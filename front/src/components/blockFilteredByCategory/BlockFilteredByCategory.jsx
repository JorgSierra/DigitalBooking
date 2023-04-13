import React, { useState, useEffect } from 'react'
import { useParams } from 'react-router-dom'
import { getData } from '../../services/api'
import { GET_ALL_PRODUCTS_ENDPOINT } from '../../services/endpoints'
import CardRecomendado from '../cardRecommendation/CardRecommendation'
import styles from './BlockFilteredByCategory.module.css'

const BlockFilteredByCategory = () => {

    const { category } = useParams()
    const [dataCategory, setDataCategory] = useState(null);
    const [filteredCategory, setFilteredCategory] = useState([]);

    useEffect(() => {
        getData(GET_ALL_PRODUCTS_ENDPOINT, setDataCategory)
    }, []);

    useEffect(() => {
        setFilteredCategory(filterCategories(dataCategory, category))
    }, [category, dataCategory]);

    if (!dataCategory) {
        return <div>Cargando</div>
    }

    return (
        <div className={styles.backgroundContainer}>
            <section className={styles.recomendacionContainer}
            >
                <h2 className={styles.title}>{category}</h2>
                <div className={styles.gridContainer}>
                    {
                        filteredCategory.map((data) => {
                            return <CardRecomendado {...data} key={data.id} />
                        })
                    }
                </div>
            </section>
        </div>
    )
}

//Takes the entire product's array of objects and for each one checks if their category 
//is the same as the category of the path the user is currently located
//then returns a new array with only products of that category
const filterCategories = (arrayObject, category) => {
    const filteredArray = []
    if (arrayObject) {
        arrayObject.map(data => {
            data.categoria.titulo === category ? filteredArray.push(data) : ""
        })
    }
    return filteredArray;
}

export default BlockFilteredByCategory

