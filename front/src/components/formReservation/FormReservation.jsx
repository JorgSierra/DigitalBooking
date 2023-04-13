import React from "react";
import styles from "./FormReservation.module.css";
import swal from "sweetalert";

const FormReservation = ({ values, errors, handleChange, userData }) => {
  const { nombre, apellido, email } = userData;

  return (
    <div className={styles.formContainer}>
      <div className={styles.form}>
        <section className={styles.formInfo}>
          <div className={styles.formDivisions}>
            <label htmlFor="name">Nombre</label>
            <input type="readonly" name="name" disabled placeholder={nombre} />
          </div>
          <div className={styles.formDivisions}>
            <label htmlFor="lastName">Apellido</label>
            <input
              type="readonly"
              name="lastName"
              disabled
              placeholder={apellido}
            />
          </div>
        </section>
        <section className={styles.formInfo}>
          <div className={styles.formDivisions}>
            <label htmlFor="email">Correo</label>
            <input type="readonly" name="email" disabled placeholder={email} />
          </div>
          <div className={styles.formDivisions}>
            <label htmlFor="city">Ciudad</label>
            <input
              type="text"
              name="city"
              placeholder="Entre la ciudad"
              value={values.city}
              onChange={handleChange}
              error={errors.city}
            />
            {/* {errors.city && 
            // alert(errors.city)
            <div style={{ color: "red" }}>{errors.city}</div>
            } */}
          </div>
        </section>
      </div>
    </div>
  );
};

export default FormReservation;
