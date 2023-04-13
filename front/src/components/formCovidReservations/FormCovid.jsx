import React from "react";
import styles from './FormCovid.module.css'

const FormCovid = ({values, errors, handleChange, hasCovidVaccine, setHasCovidVaccine}) => {
  return (
    <div  className={styles.formContainer}>
      <div className={styles.textareaContainer}>
        <label htmlFor="comments">Comentarios</label>
        <textarea
          className={styles.descriptionArea}
          name="comments"
          placeholder="Comentarios para el vendedor"
          onChange={handleChange}
          value={values.comments}
          error={errors.comments}
        />
        {/* {errors.comments && (
          <div style={{ color: "red" }}>{errors.comments}</div>
        )} */}
      </div>
      <div  className={styles.covidContainer}>
      <label htmlFor="covid">¿Estás vacunado contra el covid?</label>
      <input
        type="checkbox"
        value={hasCovidVaccine}
        name="covid"
        placeholder="covid"
        id="covid"
        onChange={()=>setHasCovidVaccine( !hasCovidVaccine)}
      />
      </div>
    </div>
  );
};

export default FormCovid;
