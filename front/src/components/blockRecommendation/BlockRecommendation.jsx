import React, { useState, useEffect } from 'react'
import { getData } from '../../services/api'
import { GET_EIGHT_RANDOM_PRODUCTS_ENDPOINT } from '../../services/endpoints'
import styles from './BlockRecommendation.module.css'
import CardRecommendation from '../cardRecommendation/CardRecommendation'
import LoadingSpinner from '../loadingSpinner/LoadingSpinner'

const BlockRecomendados = () => {

    const [dataRecommendations, setDataRecommendations] = useState(null);
    
    useEffect(() => {
        getData(GET_EIGHT_RANDOM_PRODUCTS_ENDPOINT, setDataRecommendations)
    }, []);

    if (!dataRecommendations) {
        return <LoadingSpinner/>
    }
    //<div>Cargando</div>
    return (
        <div className={styles.backgroundContainer}>
            <section className={styles.recomendacionContainer}>
                <h2 className={styles.title}>Recomendaciones</h2>
                <div className={styles.gridContainer}>
                    {
                        dataRecommendations.map((data) => {
                            return <CardRecommendation {...data} key={data.id} />
                        })
                    }
                </div>
            </section>
        </div>
    )
}

export default BlockRecomendados