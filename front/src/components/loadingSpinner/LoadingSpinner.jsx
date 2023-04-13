import React from 'react'
import styles from "./LoadingSpinner.module.css"

const LoadingSpinner = () => {

    //className={styles.ldsSpinner}
    return (
        <>
            <div className={styles.spinnerContainer}>
                <div className={styles.ldsSpinner}><div></div><div></div><div></div><div></div></div>
            </div>
        </>
    )
}

export default LoadingSpinner