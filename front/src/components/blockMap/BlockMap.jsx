import React from 'react'
import DetailsMap from '../detailsMap/DetailsMap'
import styles from "./BlockMap.module.css"

const BlockMap = (props) => {

    const { ubicacion } = props || {};
    const { ciudad, pais } = ubicacion || {};

    if (!props) {
        return <div>Cargando</div>
    }

    return (
        <div className={styles.blockMapContainer}>
            <section id="mapSection">
                <h1 className={styles.title}>¿Donde vas a estar?</h1>
                <hr />
                <p className={styles.location}>{ciudad}, {pais}</p>
            </section>
            <DetailsMap {...props} />
        </div>
    )
}

export default BlockMap