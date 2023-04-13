import React from "react";
import ArrowBackIosNewIcon from "@mui/icons-material/ArrowBackIosNew";
import styles from "../productDescription/ProductDescription.module.css";

const DescriptionBar = (props) => {
  const { nombre, categoria} = props || {};
  const { titulo } = categoria || {};

  if (!props) {
    return <div>Cargando</div>;
  }
  return (
    <section className={styles.placeName}>
      <div
        style={{ display: "flex", flexDirection: "column", lineHeight: "1.1" }}
      >
        <p className={styles.type}>{titulo}</p>
        <h1 className={styles.name}>{nombre}</h1>
      </div>
        <ArrowBackIosNewIcon fontSize="large" style={{ color: "white", cursor: "pointer" }} onClick={() => window.history.back()}/>
    </section>
  );
};

export default DescriptionBar;
