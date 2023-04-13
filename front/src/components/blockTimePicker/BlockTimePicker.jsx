import React from "react";
import TimePickerComponent from "../timePickerComponent/TimePickerComponent";
import CheckCircleOutlineIcon from "@mui/icons-material/CheckCircleOutline";
import IconButton from '@mui/material/IconButton';
import styles from "./BlockTimePicker.module.css";

const BlockTimePicker = ({values, errors, handleChange }) => {
  return (
    <div className={styles.timeContainer}>
      <section className={styles.subtitle}>
        <IconButton style={{ padding: "0 0.5rem 0 0" }}>
          <CheckCircleOutlineIcon />
        </IconButton>
        <p>
          Tu habitación va a estar lista para el check-in entre las 10:00 AM y
          las 11:00 PM
        </p>
      </section>
      <section className={styles.timer}>
        <p>Indicá tu horario estimado de llegada </p>
        <TimePickerComponent  
        values={values}
        errors={errors}
        handleChange={handleChange}
        />
      </section>
    </div>
  );
};

export default BlockTimePicker;
