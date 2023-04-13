import React, { useState, useContext, useEffect } from 'react'
import { JwtContext } from "../../context/Jwt.context";
import { GET_ALL_USER_RESERVES, GET_ALL_PRODUCTS_ENDPOINT, GET_USER_RATINGS, replaceIdPlaceholder } from '../../services/endpoints';
import { getDataWithToken, getData } from '../../services/api';
import LoadingSpinner from '../loadingSpinner/LoadingSpinner';
import styles from "./BlockReserves.module.css"
import CardReserves from '../cardReserves/CardReserves';

const BlockReserves = () => {
    const { jwtValue } = useContext(JwtContext);
    const [pathReserves, setPathReserves] = useState("");
    const [pathRatings, setPathRatings] = useState("");
    const [dataReserves, setDataReserves] = useState([]);
    const [dataRatings, setDataRatings] = useState([]);
    const [dataProduct, setDataProduct] = useState([]);
    const [databaseVersion, setDatabaseVersion] = useState(0);
    const [ratingVersion, setRatingVersion] = useState(0);
    const [empty, setEmpty] = useState(null);

    useEffect(() => {
        if (jwtValue) {
            setPathReserves(replaceIdPlaceholder(GET_ALL_USER_RESERVES, jwtValue.id));
            setPathRatings(replaceIdPlaceholder(GET_USER_RATINGS, jwtValue.id));
        }
    }, [jwtValue]);

    useEffect(() => {
        if (jwtValue && pathReserves) {
            getReserves()
        }
    }, [pathReserves, databaseVersion]);

    useEffect(() => {
        if (dataReserves.length > 0) {
            setEmpty(false);
            getProducts();
            getRating();
        } else {
            setEmpty(true);
        }
    }, [dataReserves, databaseVersion, ratingVersion]);

    const getReserves = async () => {
        try {
            const response = await getDataWithToken(pathReserves, setDataReserves)
            if (response && response.status === 200) {
                console.log("exito")
            }
        } catch (error) {
            if (error.message === 'User not authorized') {
                setEmpty(true)
                console.clear()

            } else if (error.message === 'Not found') {
                setEmpty(true)
                console.clear()
            }
        }
    };

    const getRating = async () => {
        try {
            const response = await getDataWithToken(pathRatings, setDataRatings)
            if (response && response.status === 200) {
                console.log(response)
                console.log("exito")
            }
        } catch (error) {
            if (error.message === 'User not authorized') {
                //console.log(error.message)
                console.clear()
            } else if (error.message === 'Not found') {
                //console.log("No se encontraron productos.")
                console.clear()
            }
        }
    };

    const getProducts = async () => {
        try {
            const response = await getData(GET_ALL_PRODUCTS_ENDPOINT)
            if (response && response.status === 200) {
                const products = response.data;
                const filteredProducts = products.filter((product) => {
                    return dataReserves.some((reserve) => {
                        return reserve.producto === product.id;
                    });
                });
                setDataProduct(filteredProducts);
                //console.log(filteredProducts);
            }
        } catch (error) {
            if (error.message === 'Not found') {
                //console.log("No se encontraron productos.");
                console.clear()
            }
        }
    }

    if (!dataReserves || !dataProduct) {
        return <LoadingSpinner />
    }

    return (
        <div className={styles.backgroundContainer}>
            <section className={styles.recomendacionContainer}>
                <h2 className={styles.title}>Tus reservas</h2>
                <div className={styles.gridContainer}>
                    {
                        !empty ?
                        dataReserves.map((data) => {
                            const product = dataProduct.find((p) => p.id === data.producto);
                            const rating = dataRatings.find((r) => r.producto === data.producto);
                            return <CardReserves 
                                {...data} 
                                product={product} 
                                rating={rating} 
                                key={data.id} 
                                database={databaseVersion} 
                                setDataBase={setDatabaseVersion}
                                ratingVersion={ratingVersion}
                                setRatingVersion={setRatingVersion}
                                />
                        })
                        : ""
                    }
                </div>
            </section>
        </div>
    )
}

export default BlockReserves