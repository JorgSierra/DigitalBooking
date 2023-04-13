import classNames from 'classnames';
import React, { useState, useEffect } from 'react'
import styles from "./BlockImages.module.css"
import ImageGallery from '../imageGallery/ImageGallery';

const BlockImages = (props) => {

    const { imagenes } = props || {};
    const [fiveImagesOrLessArray, setFiveImagesOrLessArray] = useState([]);

    useEffect(() => {
        setFiveImagesOrLessArray(obtainUpToFiveImagesFromProduct(imagenes));
    }, [imagenes]);

    if (!props) {
        return <div>Cargando</div>
    }

    return (
        <div className={styles.blockContainer}>
            <div className={styles.gridContainer}>


                { //Ternary operator that checks if the contents of the array is undefined or has something.
                    //If undefined, it will return a div with a string saying that no image was found
                    //If not undefined, it will map the contents of the array
                    fiveImagesOrLessArray ? (
                        fiveImagesOrLessArray.map((data, index) => {
                            const urlImg = data?.urlImg;
                            if (!urlImg) {
                                return null;
                            }
                            const firstImageClasses = classNames(
                                styles.imageGridCol2,
                                styles.imageGridRow2
                            );
                            return (
                                <img
                                    className={index === 0 ? firstImageClasses : ""}
                                    src={urlImg}
                                    key={data.id}
                                />
                            );
                        })
                    ) : (
                        <div className={styles.notFound}>
                            No se encontraron imagenes para este producto
                        </div>
                    )}
                <ImageGallery {...props} />
            </div>
        </div>
    )
}

//Takes the product's array of objects and creates a new array with up to 5 product objects
const obtainUpToFiveImagesFromProduct = (arrayObjs) => {
    const newArrayOfObjects = []
    if (!arrayObjs) {
        return newArrayOfObjects;
    }
    for (let i = 0; i < 5; i++) {
        newArrayOfObjects.push(arrayObjs[i]);
    }
    return newArrayOfObjects;
}

export default BlockImages