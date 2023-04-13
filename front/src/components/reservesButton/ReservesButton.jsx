import React from "react";
import styles from "./ReservesButton.module.css";
import { Link} from "react-router-dom";

const ReservesButton = ({handleClose}) => {
  return (
    <>
      <Link to="/reserves/user" className={styles.toFavButton} onClick={handleClose}>
     Reservas
      </Link>
    </>
  );
};

export default ReservesButton;
