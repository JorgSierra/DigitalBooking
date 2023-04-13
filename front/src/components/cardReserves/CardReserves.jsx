import React, { useState, useEffect, useContext } from 'react'
import styles from "./CardReserves.module.css"
import { obtainASingleImageForCard } from '../../utils/utils';
import { Link } from 'react-router-dom';
import LoadingSpinner from '../loadingSpinner/LoadingSpinner';
import StarsRating from 'react-star-rate';
import DeleteForeverIcon from '@mui/icons-material/DeleteForever';
import { deleteDataWithTokenAndNoBody, postDataWithToken } from '../../services/api';
import { DELETE_RESERVE_ID, ADD_CHANGE_RATING, replaceIdPlaceholder } from '../../services/endpoints';
import { JwtContext } from '../../context/Jwt.context';
import swal from 'sweetalert';

const CardReserves = (props) => {

    const { product, rating, database, setDataBase, ratingVersion, setRatingVersion } = props || {};
    const { imagenes, nombre, id } = product || {};
    const [value, setValue] = useState(0);
    const [rateEnabled, setRateEnabled] = useState(true);
    const currentDate = new Date();
    const { jwtValue } = useContext(JwtContext);
    const [singleImg, setSingleImg] = useState([])

    useEffect(() => {
        setSingleImg(obtainASingleImageForCard(imagenes));
        if (props) {
            const myDate = new Date(props.fechaFin);
            myDate.getTime() < currentDate.getTime() ? setRateEnabled(false) : setRateEnabled(true);
        }
    }, [props]);

    const handleDeleteReserve = () => {

        const path = replaceIdPlaceholder(DELETE_RESERVE_ID, props.id);
        swal({
            title: 'Estas seguro de querer borrar esta reserva?',
            text: "Una vez hecho no podra revertirse!",
            icon: 'warning',
            buttons: true,
            dangerMode: true,
        })
            .then(async (result) => {
                if (result) {
                    try {
                        const response = await deleteDataWithTokenAndNoBody(path)
                        if (response && response.status === 200) {
                            swal("Eliminada!", "Su reserva ha sido eliminada", "success");
                            setDataBase(database + 1);
                        }
                    } catch (error) {
                        swal("Error", "No se pudo eliminar su reserva", "error");
                    }
                }
            });
    };

    const handleRating = async (value) => {
        const path = ADD_CHANGE_RATING;
        if (!rateEnabled) {
            
            setValue(value)

            const body =
            {
                "valor": value,
                "producto": product.id,
                "usuario": jwtValue.id
            }

            try {
                const response = await postDataWithToken(path, body)
                if (response && response.status === 201) {
                    setRatingVersion(ratingVersion + 1);
                    //console.log(response)
                    //console.log("exito");
                    swal("Su puntuación se ha modificado con éxito")
                }
            } catch (error) {
                swal("Lamentablemente, su puntuación no ha podido ser modificada")
                //console.log("Fallo")
            }
        } else {
            swal("Podrás puntuar este producto una vez que las fechas de la reserva hayan concluido")
        }
    }

    if (!props || !product) {
        return <LoadingSpinner />
    }

    return (
        <div className={styles.flex}>
            <div className={styles.card}>
                <div className={styles.imageContainer}>
                    <img className={styles.placeImage} src={singleImg} alt="" />
                    <DeleteForeverIcon className={styles.trashIcon} style={{ fontSize: 40 }} onClick={handleDeleteReserve} />
                </div>
                <div className={styles.lowerTextContainer}>
                    <div style={{ lineHeight: "2.8rem" }}>
                        <StarsRating
                            value={rating && rating.valor ? rating.valor : value}
                            allowHalf={false}
                            allowClear={false}
                            onChange={value => {
                                handleRating(value);
                            }}
                        />
                    </div>
                    <div className={styles.title}>{nombre}</div>
                    <div><span className={styles.attribute}>Hora Inicio:</span> {props.horaInicio}</div>
                    <div><span className={styles.attribute}>Fecha Inicio:</span> {props.fechaInicio}</div>
                    <div className={styles.dateEnd}><span className={styles.attribute}>Fecha Fin:</span> {props.fechaFin}</div>
                    <Link to={`/productDetails/${id}`}>Ir al producto</Link>
                </div>
            </div>
        </div>
    )
}

export default CardReserves