import React, { useState, useEffect } from 'react'
import Lightbox from "yet-another-react-lightbox";
import Thumbnails from "yet-another-react-lightbox/plugins/thumbnails";
import "yet-another-react-lightbox/styles.css";
import "yet-another-react-lightbox/plugins/thumbnails.css";
import styles from "./ImageGallery.module.css"

const ImageGallery = (props) => {

    const { imagenes } = props || {};
    const [open, setOpen] = useState(false);
    const [imageArray, setImageArray] = useState([])
    
    useEffect(() => {
        setImageArray(createArrayOfImages(imagenes));
    }, [imagenes]);

    
    if (!props) {
        return <div>Cargando</div>
    }

    return (
        <>
            <button className={styles.btn} type="button" onClick={() => setOpen(true)}>
                Ver más
            </button>

            <Lightbox
                open={open}
                close={() => setOpen(false)}
                slides={imageArray}
                plugins={[Thumbnails]}
                className={styles.lightbox}
                thumbnails={{
                    position: "bottom",
                    width: 120,
                    height: 80,
                    border: 1,
                    borderRadius: 4,
                    padding: 4,
                    gap: 16
                }}
            />
        </>
    );
}

/*Creates a new array of objects, each object has the property src and that 
//property contains one image url of the product*/
const createArrayOfImages = (arrayObjs) => {
    const newArrayOfObjects = []
    {arrayObjs ?
        arrayObjs.map(data => {
            newArrayOfObjects.push({src: data.urlImg})
            }) : ""
    }
    return newArrayOfObjects;
}

export default ImageGallery