import React from 'react';
import "react-responsive-carousel/lib/styles/carousel.min.css";
import { Carousel } from 'react-responsive-carousel';
import styles from "./ImageCarousel.module.css"
import "./ImageCarouselOverride.css"

const ImageCarousel = (props) => {

    const { imagenes } = props || {};

    if (!props) {
        return <div>Cargando</div>
    }

    return (
        <Carousel
            autoPlay={true}
            infiniteLoop={true}
            showThumbs={false}
            showIndicators={false}
            emulateTouch={true}
            statusFormatter={(current, total) => {
                return "".concat(current, " / ").concat(total);
            }}
        >
            {imagenes ?
                imagenes.map(data => {
                    return (
                        <div className={styles.imageContainer} key={data.id}>
                            <img className={styles.image} src={data.urlImg} alt="" />
                        </div>)
                    }) : ""
            }
        </Carousel>
    );
}

export default ImageCarousel