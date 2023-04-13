import React from 'react'
import styles from "./BlockDetailsDescription.module.css"

const BlockDetailsDescription = (props) => {

    const { titulo, descripcion } = props || {};

    if (!props) {
        return <div>Cargando</div>
    }

    return (
        <div className={styles.descriptionContainer}>
            <section>
                <h1 className={styles.title}>{titulo}</h1>
                <p className={styles.text}>{descripcion}
                </p>
            </section>
        </div>
    )
}

export default BlockDetailsDescription