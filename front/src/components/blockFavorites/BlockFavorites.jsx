import React, { useContext, useEffect, useState } from 'react'
import styles from '../../components/blockRecommendation/BlockRecommendation.module.css'
import { FavoritesContext } from "../../context/Favorites.context";
import CardRecommendation from '../../components/cardRecommendation/CardRecommendation'
import LoadingSpinner from '../loadingSpinner/LoadingSpinner'
import { getDataWithToken } from '../../services/api';
import { GET_PRODUCTS_LIKED_BY_USER, replaceIdPlaceholder } from '../../services/endpoints';
import { JwtContext } from "../../context/Jwt.context";

const BlockFavorites = () => {

    const [userLikes, setUserLikes] = useState([]);
    const [endpoint, setEndpoint] = useState("")
    const { jwtValue } = useContext(JwtContext);
    const { changing, setChanging } = useContext(FavoritesContext);
    const [empty, setEmpty] = useState(null);

    useEffect(() => {
        if (jwtValue) {
            setEndpoint(replaceIdPlaceholder(GET_PRODUCTS_LIKED_BY_USER, jwtValue.id))
        }
    }, [jwtValue,]);

    useEffect(() => {
        if (endpoint) {
            callFunctionGetLikes()
            //console.log(userLikes)
        }
    }, [endpoint, changing]);

    useEffect(() => {
        callFunctionGetLikes()
        //getDataWithToken(endpoint, setUserLikes)
    }, [changing, userLikes.length]);

    useEffect(() => {
        if (empty && userLikes.length !== 0) {
            setEmpty(false);
        }
    }, [userLikes]);

    const callFunctionGetLikes = async () => {
        try {
            const response = await getDataWithToken(endpoint, setUserLikes)
            if (response && response.status === 200) {
                //console.log("exito")
            } 
        } catch (error) {
            if (error.message === 'User not authorized') {
                //console.log(error.message)
                setEmpty(true)
            } else if (error.message === 'Not found') {
                setEmpty(true)
                console.clear()
                //console.log(error.message)
            }
        }
    };

    if (!userLikes) {
        return <LoadingSpinner />;
    }

    return (
        <div className={styles.backgroundContainer}
            style={{ flexGrow: '1' }}
        >
            <div >
                <section className={styles.recomendacionContainer}>
                    <h1 className={styles.title}>Mis favoritos</h1>
                    <div className={styles.gridContainer}>
                        {!empty ? userLikes.map((data) => {
                            return <CardRecommendation {...data} key={data.id} />
                        }): ""}
                    </div>
                </section>
            </div>
        </div>
    )
}

export default BlockFavorites


    //const { changing, setChanging } = useContext(FavoritesContext);