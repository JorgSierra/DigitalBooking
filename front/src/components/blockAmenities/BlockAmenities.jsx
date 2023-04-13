import React from 'react'
import styles from "./BlockAmenities.module.css"
import CardAmenities from '../cardAmenities/CardAmenities';

const BlockAmenities = (props) => {

    const { caracteristicas } = props || {};

    if (!props) {
        return <div>Cargando</div>
    } 

    return (
        <div className={styles.blockAmenitiesContainer}>
            <section>
                <h1 className={styles.title}>¿Que ofrece este lugar?</h1>
                <hr />
            </section>
            <div className={styles.gridContainer}>
                {caracteristicas !== undefined ?
                    caracteristicas.map((data) => {
                        return (
                            <CardAmenities {...data} key={data.id} />
                        )
                    }) : ""
                }
            </div>
        </div>
    )
}

export default BlockAmenities