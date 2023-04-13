import React from "react";
import styles from "./FavoritesButton.module.css";
import { Link} from "react-router-dom";

const FavoritesButon = ({handleClose}) => {
  return (
    <>
      <Link to="/favorites" onClick={handleClose} className={styles.toFavButton}>
       Favoritos
      </Link>
    </>
  );
};

export default FavoritesButon;
