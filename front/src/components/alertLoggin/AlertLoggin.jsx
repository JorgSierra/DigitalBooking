import React from "react";
import ErrorIcon from "@mui/icons-material/Error";
import { IconButton } from "@mui/material";
import styles from '../alertLoggin/AlertLoggin.module.css'

const AlertLoggin = (props) => {
  return (
    <div className={styles.alertContainer}>
      <IconButton>
        <ErrorIcon color="error"/>
      </IconButton>
      <p>{props.text}</p>
    </div>
  );
};

export default AlertLoggin;
