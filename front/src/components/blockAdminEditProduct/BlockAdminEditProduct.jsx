import React from 'react'
import AdminTitle from "../adminTittle/AdminTitle";
import styles from './BlockAdminEditProduct.module.css'
import AdminEditForm from '../adminEditForm/AdminEditForm';

const BlockAdminEditProduct = () => {
  return (
    <div className={styles.adminBlock}>
        <AdminTitle/>
        <div>
        <h1 className={styles.title}>Editar Producto</h1>
            <AdminEditForm/>
        </div>
    </div>
  )
}

export default BlockAdminEditProduct