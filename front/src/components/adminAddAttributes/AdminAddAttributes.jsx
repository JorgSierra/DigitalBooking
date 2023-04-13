import React from "react";
import styles from "./AdminAdd.module.css";

const AdminAdd = ({ data, handleAttribute }) => {
  // console.log(data)
  const dataId = parseInt(data.id);
  return (
    <div className={styles.addContainer}>
      <div className={styles.characteristics}>
        <section className={styles.attributeSection}>
          <p>{data.nombre}</p>
          <img
            className={styles.iconCharacteristic}
            src={data.icono}
            alt={data.nombre}
          />
        </section>
        <input
          type="checkbox"
          value={data.id}
          name='attributes'
          className={styles.inputCharacteristics}
          onClick={handleAttribute}
        />
      </div>
    </div>
  );
};

export default AdminAdd;
