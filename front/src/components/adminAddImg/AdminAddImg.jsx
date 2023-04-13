import React, { useState } from "react";
import styles from "./AdminAddImg.module.css";
import AddIcon from "@mui/icons-material/Add";

const AdminAddImg = ({ image, setImage}) => {
  const [dataInputTitulo, setdataInputTitulo] = useState("");
  const [dataInputUrl, setdataInputUrl] = useState("");

  return (
    <div className={styles.addContainer}>
      <section className={styles.formInfo}>
        <div className={styles.formDivisionsTitle} style={{ width: "33%" }}>
          <input
            type="text"
            name="titulo"
            value={image.titulo}
            placeholder="Titulo imagen"
            onChange={(e) => {
              setdataInputTitulo(e.target.value);
              // setdataInputTitulo("");
            }}
          />
        </div>
        <div className={styles.formDivisions} style={{ width: "65%" }}>
          <input
            type="text"
            name="urlImg"
            value={image.urlImg}
            placeholder="Insertar https : //"
            onChange={(e) => {
              setdataInputUrl(e.target.value);
              // setdataInputUrl("");
            }}
          />
        </div>
        <button
          type="button"
          className={styles.Btn}
          onClick={() => {
            setImage((prevState) => [
              ...prevState,
              {
                titulo: dataInputTitulo,
                urlImg: dataInputUrl,
              },
            ]);
          }}
        >
          <AddIcon
            style={{
              backgroundColor: "var(--orange)",
              height: "2.5rem",
              width: "2.5rem",
              borderRadius: "4px",
              color: "white",
            }}
            //
          />
        </button>
      </section>
    </div>
  );
};

export default AdminAddImg;
