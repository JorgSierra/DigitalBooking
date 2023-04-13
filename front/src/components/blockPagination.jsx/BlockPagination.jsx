import React, { useState, useEffect } from 'react'
import styles from './BlockPagination.module.css'
import CardRecommendation from '../cardRecommendation/CardRecommendation'
import LoadingSpinner from '../loadingSpinner/LoadingSpinner'

const BlockPagination = (props) => {

    //console.log(props)
    /*const [dataRecommendations, setDataRecommendations] = useState(null);
    
    useEffect(() => {
        getData(GET_EIGHT_RANDOM_PRODUCTS_ENDPOINT, setDataRecommendations)
    }, []);*/

    if (!props.data) {
        return <LoadingSpinner/>
    }
    //<div>Cargando</div>
    return (
        <div className={styles.backgroundContainer}>
            <section className={styles.recomendacionContainer}>
                <h2 className={styles.title}>Lugares</h2>
                <div className={styles.gridContainer}>
                    {
                        props.data.slice(props.start, props.end).map((data) => {
                            return <CardRecommendation {...data} key={data.id} />
                        })
                    }
                </div>
            </section>
        </div>
    )
}

export default BlockPagination