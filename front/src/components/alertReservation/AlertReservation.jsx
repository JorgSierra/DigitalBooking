import React from "react";
import ErrorIcon from "@mui/icons-material/Error";
import { IconButton } from "@mui/material";
import styles from './AlertReservation.module.css'

const AlertReservation = () => {
  return (
    <div className={styles.alertContainer}>
      <IconButton>
        <ErrorIcon color="error"/>
      </IconButton>
      <p>Lamentablemente la reserva no ha podido realizarse. Por favor, intente más tarde.</p>
    </div>
  );
};

export default AlertReservation;