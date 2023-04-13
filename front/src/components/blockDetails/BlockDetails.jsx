import React, { useState, useEffect, useContext } from "react";
import { useParams } from "react-router-dom";
import { getData } from "../../services/api";
import { useWindowSize } from "../../hooks/useWindowSize";
import ProductDescription from "../../components/productDescription/ProductDescription";
import AvailableDates from "../../components/availableDates/AvailableDates";
import UsagePolitics from "../../components/usagePolitics/UsagePolitics";
import ShareButton from "../../components/shareButton/ShareButton";
import BlockImages from "../../components/blockImages/BlockImages";
import ImageCarousel from "../../components/imageCarousel/ImageCarousel";
import BlockMap from "../../components/blockMap/BlockMap";
import BlockDetailsDescription from "../../components/blockDetailsDescription/BlockDetailsDescription";
import BlockAmenities from "../../components/blockAmenities/BlockAmenities";
import FavoriteIconComponent from "../../components/favoriteIconComponent/FavoriteIconComponent";
import styles from "./BlockDetails.module.css";
import {
    GET_PRODUCT_BY_ID_ENDPOINT,
    replaceIdPlaceholder,
    GET_ALL_PRODUCT_RESERVES,
} from "../../services/endpoints";
import ResponsiveTemplate from "../../components/responsiveTemplate/ResponsiveTemplate";
import LoadingSpinner from "../../components/loadingSpinner/LoadingSpinner";
import { JwtContext } from "../../context/Jwt.context";


const BlockDetails = () => {
    const { id } = useParams();
    const [dataProductDetails, setDataProductDetails] = useState(null);
    const [datas, setDatas] = useState([]);
    const { jwtValue } = useContext(JwtContext);
    const endpoint = replaceIdPlaceholder(GET_PRODUCT_BY_ID_ENDPOINT, id);
    const urls = replaceIdPlaceholder(GET_ALL_PRODUCT_RESERVES, id);
    const [like, setLike] = useState(null);
    const [fav, setFav] = useState(null);
    const size = useWindowSize(null);

    const handleToggleFavorite = () => {
        setFav(!fav);
    };
    

    useEffect(() => {
        getData(endpoint, setDataProductDetails);
        getData(urls, setDatas);
    }, []);

    useEffect(() => {
        if (jwtValue && dataProductDetails) {
            setLike(dataProductDetails.likes.find(like => like.usuario === jwtValue.id))
        }
    }, [jwtValue, dataProductDetails]);

    const checkIfFav = () => {
        if (like && like.usuario === jwtValue.id) {
            setFav(true);
            /*console.log(like)
            console.log(jwtValue)*/
        } else {
            setFav(false);
        }
    }

    useEffect(() => {
        checkIfFav();
    }, [like]);


    let propsContainerFav = {
        data: dataProductDetails,
        heartColor: "black",
        shadow: "none",
        jwt: jwtValue,
        handleFavs: handleToggleFavorite
    };

    if (!dataProductDetails) {
        return <LoadingSpinner />;
    }

    //console.log(id)

    return (
        <ResponsiveTemplate>
            <ProductDescription {...dataProductDetails} />
            <section className={styles.buttonsBar}>
                <div className={styles.shareContainer}>
                    <ShareButton
                        dataProductDetails={dataProductDetails}
                        productDetailsPath={endpoint}
                        id={id}
                    />
                    <FavoriteIconComponent {...propsContainerFav} fav={fav} />
                </div>
            </section>
            {size.width < 900 ? (
                <ImageCarousel {...dataProductDetails} />
            ) : (
                <BlockImages {...dataProductDetails} />
            )}
            <BlockDetailsDescription {...dataProductDetails} />
            <BlockAmenities {...dataProductDetails} />
            <AvailableDates dataProductDetails={dataProductDetails} datas={datas} />
            <BlockMap {...dataProductDetails} />
            <UsagePolitics {...dataProductDetails} />
        </ResponsiveTemplate>
    );
};

export default BlockDetails;
