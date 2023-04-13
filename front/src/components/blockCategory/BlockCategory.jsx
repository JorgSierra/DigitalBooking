import React, { useState, useEffect } from 'react'
import { getData } from '../../services/api'
import { GET_ALL_CATEGORIES_ENDPOINT, GET_ALL_PRODUCTS_ENDPOINT } from '../../services/endpoints'
import styles from './BlockCategory.module.css'
import CardCategoria from '../cardCategory/CardCategory'
import LoadingSpinner from '../loadingSpinner/LoadingSpinner'

const BlockCategory = () => {

    const [dataCategories, setDataCategories] = useState(null);
    const [dataProducts, setDataProducts] = useState(null);
    const [categoriesToShow, setCategoriesToShow] = useState(4);
    const [categoryNumber, setCategoryNumber] = useState([]);

    useEffect(() => {
        getData(GET_ALL_CATEGORIES_ENDPOINT, setDataCategories)
        getData(GET_ALL_PRODUCTS_ENDPOINT, setDataProducts)
    }, []);

    useEffect(() => {
        if (dataProducts) {
            const productsByCategory = dataProducts.reduce((accumulator, currentValue) => {
                const category = currentValue.categoria.titulo;
                if (accumulator[category]) {
                    accumulator[category]++;
                } else {
                    accumulator[category] = 1;
                }
                return accumulator;
            }, {});
            setCategoryNumber(productsByCategory);
        }
    }, [dataProducts]);

    if (!dataCategories && !dataProducts) {
        return <LoadingSpinner />
    }

    return (
        <section className={styles.categoriaContainer}>
            <h2 className={styles.title}>Buscar por tipo de alojamiento</h2>
            <div className={styles.flexContainer}>
                {
                    dataCategories.slice(0, categoriesToShow).map((data) => {
                        return <CardCategoria {...data} categoryNumber={categoryNumber} key={data.id} />
                    })
                }
            </div>
        </section>
    )
}

export default BlockCategory