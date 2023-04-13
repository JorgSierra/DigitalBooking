import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import styles from './AddDates.module.css'
import { scrollToTop } from '../../utils/utils';

const AddDates = (props) => {
    const { id } = props || {};
    const [navigateToReservationPath, setNavigateToReservationPath] = useState(`/product/${props.id}/reserve`)

    const notLoggedProp = {
        notLogged: true,
    }

    // logged???
    const loggedIn = JSON.parse(localStorage.getItem("Logged"));

    /*const divStyle = {
        backgroundImage: `url(${props.imagenes[0].urlImg})`,
    };*/
    /*const divStyle = {
        backgroundImage: props && props.imagenes[0] && "urlImg" in props.imagenes[0]  ? `url(${props.imagenes[0].urlImg})` : `url()`
    };*/

    /*const divStyle = {
        backgroundImage: `url(${
          props?.imagenes?.[0]?.urlImg ?? `url()`
        })`,
      };*/

    const divStyle = {
        backgroundImage: `url(${props && props.imagenes && props.imagenes[0] && props.imagenes[0].urlImg
                ? props.imagenes[0].urlImg
                : ''
            })`,
    };

    return (
        <div className={styles.addDatesContainer}>
            <div className={styles.imgContainer}>
                <div className={styles.imgPlace} style={divStyle}></div>
            </div>
            <p className={styles.text}>Agregá tus fechas de viaje para obtener precios exactos</p>
            {loggedIn ?
                <Link className={styles.btn} to={navigateToReservationPath} onClick={scrollToTop}>Iniciar Reserva</Link>
                :
                <Link className={styles.btn} to='/login' state={notLoggedProp} >Iniciar Reserva</Link>
            }
        </div>
    )
}

export default AddDates