import React from "react";
import styles from "./UsagePolitics.module.css";

const UsagePolitics = (props) => {

    const { politicas } = props || {};
    const normPolitic = 1;
    const healthAndSafetyPolitic = 2
    const cancelPolitic = 3

    const renderPolitics = (politicId) => {
        return politicas.map(item => {
            if (item.tipolitica.id === politicId) {
                return <li key={item.id}>{item.descripcion}</li>
            }
        })
    }

    //Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.
    return (
        <div className={styles.politicsComponent}>
            <section>
                <h1>Qué tenés que saber</h1>
                <hr />
            </section>
            <section className={styles.rules}>
                <div className={styles.div1}>
                    <p className={styles.titulo}>Normas&nbsp;de&nbsp;la&nbsp;casa</p>
                    <ul className={styles.listado}>
                        {politicas ? renderPolitics(normPolitic) : ""}
                    </ul>
                </div>
                <div className={styles.div2}>
                    <p className={styles.titulo}>Salud&nbsp;y&nbsp;seguridad</p>
                    <ul className={styles.listado}>
                        {politicas ? renderPolitics(healthAndSafetyPolitic) : ""}
                    </ul>
                </div >
                <div className={styles.div3}>
                    <p className={styles.titulo}>Política&nbsp;de&nbsp;cancelación</p>
                    <ul className={styles.listado}>
                        {politicas ? renderPolitics(cancelPolitic) : ""}
                    </ul>
                </div>
            </section>
        </div>
    );
};

export default UsagePolitics;
