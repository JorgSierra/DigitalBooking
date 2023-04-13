import React from "react";
import styles from "./AdminPolitics.module.css";

const AdminPolitics = ({ data, handlePolitics }) => {
  return (
    <div
      className={styles.politicsContainer}
      // onClick={handlePolitics}
      // value={data.id}
    >
      {/* <h1>{data.tipolitica.nombre}</h1> */}
      <div key={data.id} className={styles.dataPolitics}>
        <h2 className={styles.politicsTitle}>{data.titulo}</h2>
        <p>{data.descripcion}</p>
      </div>
      <input
        type="checkbox"
        value={data.id}
        name="politics"
        className={styles.inputCharacteristics}
        onClick={handlePolitics}
      />
    </div>
  );
};

export default AdminPolitics;
