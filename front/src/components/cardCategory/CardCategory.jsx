import React, { useState, useContext } from 'react'
import { Link } from 'react-router-dom';
import { scrollToTop } from '../../utils/utils';
import styles from './CardCategory.module.css'
import { FilterContext } from '../../context/Filter.context';

const CardCategoria = (props) => {

    const [filteredCategoryPath, setFilteredCategoryPath] = useState(`/filterCategory/${props.titulo}`)
    const { filterValue, setFilterValue } = useContext(FilterContext);

    if (!props) {
        return <div>Cargando</div>
    }

    const { categoryNumber } = props;
    
    const handleCategoryClick = () => {
        setFilterValue(true);
        scrollToTop()
    }
    
    return (
        <Link className={styles.card} onClick={handleCategoryClick} to={filteredCategoryPath}>
            <div className={styles.imageContainer}>
                <img className={styles.placeImage} src={props.urlImagen} alt={props.descripcion} />
            </div>
            <div className={styles.lowerTextContainer}>
                <p className={styles.category}>{props.titulo}</p>
                <p className={styles.placeAmount}>{categoryNumber[props.titulo]} {props.titulo}</p>
            </div>
        </Link>
    );
}

export default CardCategoria
