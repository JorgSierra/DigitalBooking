import React from "react";
import styles from "./ProductDescription.module.css";
import LocationOnIcon from "@mui/icons-material/LocationOn";
import ProductRanking from "../productRanking/ProductRanking";
import DescriptionBar from "../descriptionBar/DescriptionBar";

const ProductDescription = (props) => {
    const { ubicacion } = props || {};
    const { ciudad, pais } = ubicacion || {};

    if (!ubicacion) {
        return <div data-testid='loading'>Cargando</div>
    }
    return (
        <div className={styles.descriptionContainer}>
            <DescriptionBar {...props}/>
            <section className={styles.locationInfo}>
                <div className={styles.address}>
                    <LocationOnIcon />
                    <div className={styles.description}>
                        <p>{ciudad}, {pais}</p>
                        <p>Distancia al centro {props.distancia} km </p>
                    </div>
                </div>
                <div>
                    <ProductRanking {...props} />
                </div>
            </section>
        </div>
    );
};

export default ProductDescription;
