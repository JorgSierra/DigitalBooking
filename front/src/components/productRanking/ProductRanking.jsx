import React, { useState, useEffect } from 'react'
import styles from "./ProductRanking.module.css"
import { createStarRatingString, transformNumberRatingToTextEquivalent, calculateRating } from "../../utils/utils"

const ProductRanking = (props) => {

    const { puntuaciones } = props || {}
    const [numberRating, setNumberRating] = useState("");
    const [starRatingIconString, setStarRatingIconString] = useState([]);
    const [wordRating, setwordRating] = useState("");

    useEffect(() => {
        setNumberRating(calculateRating(puntuaciones));
        setStarRatingIconString(createStarRatingString(numberRating));
        setwordRating(transformNumberRatingToTextEquivalent(numberRating));
    }, [puntuaciones, numberRating]);

    if (!puntuaciones) {
        return <div data-testid='loading'>Cargando</div>
    }

    //console.log(puntuaciones)
    return (
        <div className={styles.container}>
            <div className={styles.leftContainer}>
                <p className={styles.textContainer} data-testid='wordRank'>{wordRating}</p>
                <p className={styles.starContainer}>{starRatingIconString}</p>
            </div>
            <div className={styles.numberContainer}>{numberRating}</div>
        </div>
    )
}

export default ProductRanking