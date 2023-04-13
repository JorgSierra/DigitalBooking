import React, { useState } from 'react'
import VerifiedIcon from '@mui/icons-material/Verified';
import styles from "./BlockVerified.module.css"
import { Link } from "react-router-dom";

const BlockVerified = ({message}) => {
    const [navigateToHomePath, setNavigateToHomePath] = useState(`/`)

    //onClick={scrollToTop}
    return (
        <>
            <div className={styles.backgroundContainer}>
                <div className={styles.verifiedContainer}>
                    <VerifiedIcon className={styles.iconVerified} style={{fontSize: "80px"}}/>
                    <p className={styles.title}>¡Muchas Gracias!</p>
                    <p className={styles.text}>{message}</p>
                    <div className={styles.btnContainer}>
                        <Link to={navigateToHomePath} className={styles.btn}>
                            Ok
                        </Link>
                    </div>
                </div>
            </div>
        </>
    )
}

export default BlockVerified