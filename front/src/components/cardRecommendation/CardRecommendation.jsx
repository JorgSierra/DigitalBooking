import React, { useEffect, useState, useContext } from "react";
import { Link } from "react-router-dom";
import styles from "./CardRecommendation.module.css";
import {
    createStarRatingString,
    transformNumberRatingToTextEquivalent,
    calculateRating,
    obtainASingleImageForCard,
    textShortener,
    descriptionFormat,
    longWordsCheck
} from "../../utils/utils";
import { scrollToTop } from "../../utils/utils";
import FavoriteIconComponent from "../favoriteIconComponent/FavoriteIconComponent";
import LoadingSpinner from "../loadingSpinner/LoadingSpinner";
import LocationOnIcon from "@mui/icons-material/LocationOn";
import { JwtContext } from "../../context/Jwt.context";
import classNames from "classnames";

const CardRecommendation = (props) => {
    const { imagenes, caracteristicas, descripcion, latitud, longitud } = props || {};
    const [navigateToDetailsPath, setNavigateToDetailsPath] = useState(
        `/productDetails/${props.id}`
    );
    const [shortDescription, setShortDescription] = useState("");
    const [fullDescription, setFullDescription] = useState("");
    const [numberRating, setNumberRating] = useState("");
    const [starRatingIconString, setStarRatingIconString] = useState([]);
    const [wordRating, setwordRating] = useState("");
    const [singleImg, setSingleImg] = useState("");
    const [likes, setLikes] = useState([]);
    const [fav, setFav] = useState();
    const { jwtValue } = useContext(JwtContext);
    const [showMoreText, setShowMoreText] = useState(false);
    const fullDescriptionClasses = classNames(styles.description, longWordsCheck(fullDescription) ? styles.breakWord : "" , styles.showAllText)
    //const isLikedByUser = jwtValue && props.likes.some(like => like.usuario === jwtValue.id && like.id === props.id);
    //const initialFav = isLikedByUser ? true : false;

    const handleToggleFavorite = () => {
        setFav(!fav);
    };

    const handleClickAdress = () => setShowMoreText(!showMoreText);

    let propsContainerFav = {
        data: props,
        heartColor: "white",
        shadow: `drop-shadow(0px 0px 2px rgba(0, 0, 0, 0.5))`,
        handleFavs: handleToggleFavorite,
    }

    const handleClickMap = () => {
        const lat = latitud;
        const lng = longitud;
        const url = `https://www.openstreetmap.org/?mlat=${lat}&mlon=${lng}#map=17/${lat}/${lng}&layers=N`;
        window.open(url, '_blank', 'width=600,height=400,scrollbars=yes,resizable=yes');
    };

    const divStyle = {
        backgroundImage: singleImg && isNaN(singleImg) ? `url(${singleImg})` : `url()`
    };

    useEffect(() => {
        setSingleImg(obtainASingleImageForCard(imagenes));
        setNumberRating(calculateRating(props.puntuaciones));
        setStarRatingIconString(createStarRatingString(numberRating));
        setwordRating(transformNumberRatingToTextEquivalent(numberRating));
        textShortener(descripcion, setShortDescription, 70, styles.description, styles.mas, styles.breakWord);
        setFullDescription(descriptionFormat(descripcion));
    }, [numberRating]);


    if (!props) {
        return <LoadingSpinner />;
    }

    const checkIfFav = () => {
        if (likes && likes.usuario === jwtValue.id) {
            setFav(true);
            //console.log(likes)
        } else {
            setFav(false);
        }
    }

    useEffect(() => {
        if (jwtValue) {
            setLikes(props.likes.find(like => like.usuario === jwtValue.id));
        }
    }, [jwtValue, props.likes]);

    useEffect(() => {
        checkIfFav();
    }, [likes]);


    //console.log(likes)
    return (
        <article className={styles.card}>
            <div className={styles.leftHalfContainer}>
                <div className={styles.mainImageContainer}>
                    <div className={styles.imgPlace} style={divStyle}>{''}</div>
                    <div className={styles.hearthIcon}>
                        {/* <img className={styles.hearthIcon} src="/src/assets/img/icons/heartIcon.svg" alt="" /> */}
                        <FavoriteIconComponent  {...propsContainerFav} fav={fav} />
                    </div>
                </div>
            </div>
            <div className={styles.rightHalfContainer}>
                <div className={styles.upperFirst}>
                    <div className={styles.upperFirstLeft}>
                        <div className={styles.category}>{props.categoria.titulo}</div>
                        <p className={styles.starRating}>{starRatingIconString}</p>
                    </div>
                    <div className={styles.numberRating}>{numberRating}</div>
                </div>
                <div className={styles.upperSecond}>
                    <div className={styles.placeName}>{props.nombre}</div>
                    <div className={styles.wordRating}>{wordRating}</div>
                </div>
                <div className={styles.upperMediumContainer}>
                    <div className={styles.locationContainer}>
                        <LocationOnIcon className={styles.locationIcon} />
                    </div>
                    <div className={styles.distance}>A {props.distancia} km del centro</div>
                    <div className={styles.mapUrl} onClick={handleClickMap}>&nbsp;MOSTRAR EN EL MAPA</div>
                </div>
                <div className={styles.lowerMediumContainer}>
                    {caracteristicas.map((data) => {
                        return (
                            <div key={data.id}>
                                <img
                                    className={styles.iconCharacteristic}
                                    src={data.icono}
                                    alt={data.nombre}
                                />
                            </div>
                        );
                    })}
                </div>
                <div className={styles.descriptionsContainer} onClick={handleClickAdress}>
                    {" "}
                    {!showMoreText ? (
                        <div className={styles.boxDescription}>{shortDescription}</div>) :
                        <div className={styles.boxDescription}><span className={fullDescriptionClasses}>{fullDescription}</span></div>
                    }
                </div>
                <Link onClick={scrollToTop} to={navigateToDetailsPath}>
                    <div className={styles.btnContainer}>
                        <button className={styles.btn}>Ver&nbsp;más</button>
                    </div>
                </Link>
            </div>
        </article>
    );
};

//Limits the amount of icons that are shown on each card
function renderLimitedIcons(arrayObject) {
    if (arrayObject !== undefined) {
        return mapIcons(arrayObject);
    }
}

//Maps and returns each icon as an image tag that can be rendered
function mapIcons(arrayObject) {
    arrayObject.map((data) => {
        return (
            <div>
                <img
                    className={styles.locationIcon}
                    src={data.caracteristicas.icono}
                    alt={data.caracteristicas.nombre}
                />
            </div>
        );
    });
}

export default CardRecommendation;







/*useEffect(() => {
    if (jwtValue) {
        const likedByUser = props.likes.some(
            (like) => like.usuario === jwtValue.id && like.id === props.id
        );
        setLikes(likedByUser);
        setFav(likedByUser);
    }
}, [jwtValue, props.likes, props.id]);*/

// Takes a string and makes it shorter, will also add a "más..." at the end if the string becomes shorter
/*const descriptionShortener = (originalDescription, set) => {
    let maxCharText = 80;
    if (screen.width === 414) {
        maxCharText = 80;
    }
    let newShortString = "";
    let masWord = "";
    for (let i = 0; i <= maxCharText; i++) {
        if (originalDescription[i] === undefined) {
            break;
        } else {
            newShortString += originalDescription[i];
        }
    }
    //If the string is longer than maxCharText then '...' is added
    //at the end of the new shorter description
    if (originalDescription[maxCharText + 1] !== undefined) {
        newShortString += "...";
        masWord += " más...";
    }
    //Sets the new modified shorter description inside a variable as jsx
    set(
        <p>
            <span className={styles.description}>{newShortString}</span>
            <span className={styles.mas}>{masWord}</span>
        </p>
    );
};*/

/*//Goes through the array of objects that contains the images for each product
//and gets the first one
function obtainASingleImageForCard(arrayObjects) {
    let singleImage = "";
    if (arrayObjects !== undefined) {
        for (let i = 0; i < 1; i++) {
            singleImage += arrayObjects[i].urlImg;
        }
    } else {
        return "";
    }
    return singleImage;
}*/
