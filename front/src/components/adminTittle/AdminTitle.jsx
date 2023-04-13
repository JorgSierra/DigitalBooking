import React from 'react';
import styles from './AdminTitle.module.css';
import ArrowBackIosNewIcon from "@mui/icons-material/ArrowBackIosNew";

const AdminTitle = () => {
  return (
    <div className={styles.titleContainer}>
        <p>Administración</p>
        <ArrowBackIosNewIcon className={styles.icon} fontSize="large" style={{ color: "white", cursor: "pointer" }} onClick={() => window.history.back()}/>
    </div>
  )
}

export default AdminTitle