import React from 'react';
import AdminForm from '../adminForm/AdminForm';
import AdminTitle from '../adminTittle/AdminTitle';
import styles from './BlockAdministration.module.css';

const BlockAdministration = () => {
  return (
    <div className={styles.adminBlock}>
    <AdminTitle/>
    <div className={styles.formProductContainer}>
    <h1>Crear propiedad</h1>
    <AdminForm/>
    </div>
    
    </div>
  )
}

export default BlockAdministration