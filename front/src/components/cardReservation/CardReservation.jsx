import React, { useState, useEffect, useContext } from "react";
import { Link } from "react-router-dom";
import {
  obtainASingleImageForCard,
  calculateRating,
  createStarRatingString,
  getDirectionFromCoordinates,
  textShortener,
} from "../../utils/utils";
import styles from "./CardReservation.module.css";
import LoadingSpinner from "../loadingSpinner/LoadingSpinner";
import classNames from "classnames";
import { scrollToTop } from "../../utils/utils";
import { date } from "yup";
import { DatesContext } from "../../context/Dates.context";
import LocationOnIcon from "@mui/icons-material/LocationOn";

const CardReservation = ({ dataProductDetails, values }) => {
  const [numberRating, setNumberRating] = useState("");
  const [shortAdress, setShortAdress] = useState(null);
  const [starRatingIconString, setStarRatingIconString] = useState([]);
  const [singleImg, setSingleImg] = useState("");
  const [adress, setAdress] = useState("");
  const [showMoreText, setShowMoreText] = useState(false);
  const { arrayDates } = useContext(DatesContext); //pasa el contexto de fechas
  const { valueDate, setValueDate } = useContext(DatesContext);

  const divStyle = {
    backgroundImage: `url(${singleImg})`,
  };

  const handleClickAdress = () => setShowMoreText(!showMoreText);
  // console.log(valueDate)
  useEffect(() => {
    getDirectionFromCoordinates(
      dataProductDetails.latitud,
      dataProductDetails.longitud,
      setAdress
    );
    setShowMoreText(false);
  }, []);

  useEffect(() => {
    setSingleImg(obtainASingleImageForCard(dataProductDetails.imagenes));
    setNumberRating(calculateRating(dataProductDetails.puntuaciones));
    setStarRatingIconString(createStarRatingString(numberRating));
  }, [numberRating]);

  useEffect(() => {
    textShortener(adress, setShortAdress, 80, styles.description, styles.mas);
  }, [adress]);

  if (!shortAdress) {
    return <LoadingSpinner />;
  }

  /*
    <img
        className={styles.locationImg}
        src="/src/assets/img/icons/locationIcon.svg"
        alt=""
     />
  */
  // console.log(formik, isSubmited)
  //className={styles.locationImg}
  return (
    <div className={styles.card}>
      <div className={styles.cardContent}>
        <div className={styles.leftContainer}>
          <h2 className={styles.title}>Detalle de la reserva</h2>
          <div className={styles.mainImageContainer}>
            <div className={styles.imgPlace} style={divStyle}></div>
          </div>
        </div>

        <div className={styles.rightContainer}>
          <div className={styles.titleCatStarContainer}>
            <p className={styles.category}>
              {dataProductDetails.categoria.titulo}
            </p>
            <h3 className={styles.placeName}>{dataProductDetails.nombre}</h3>
            <p className={styles.starRating}>{starRatingIconString}</p>
          </div>

          <div onClick={handleClickAdress}>
            {" "}
            {!showMoreText ? (
              <div className={styles.locationContainer}>
                <div className={styles.locationIcon}>
                  <LocationOnIcon />
                </div>
                <p className={styles.adressText}>{shortAdress}</p>
              </div>
            ) : (
              <div className={styles.locationContainer}>
                <p
                  className={classNames(styles.adressText, styles.showAllText)}
                >
                  {adress}
                </p>
              </div>
            )}
          </div>

          <div className={styles.containerCheck}>
            <hr />
            <div className={styles.containerCheckIn}>
              <p>Check in</p>
              <p aria-required>{arrayDates[0]}</p>
            </div>
            <hr />
            <div className={styles.containerCheckOut}>
              <p>Check out</p>
              <p aria-required>{arrayDates[1]}</p>
            </div>
            <hr />
          </div>
          <div className={styles.btnContainer}>
            <button 
            className={styles.btn} 
            type="submit" 
            onClick={scrollToTop}
            >
              Confirmar&nbsp;reserva
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CardReservation;
