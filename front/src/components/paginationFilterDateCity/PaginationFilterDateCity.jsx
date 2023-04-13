import React, { useEffect, useState } from 'react'
import { useLocation } from 'react-router-dom';
import { getData, postData } from '../../services/api';
import styles from "./PaginationFilterDateCity.module.css"
import LoadingSpinner from '../loadingSpinner/LoadingSpinner';
import BlockPagination from '../blockPagination.jsx/BlockPagination';
import {
    GET_PRODUCT_RESERVE_AVAILABLE_BETWEEN_DATES,
    GET_PRODUCT_RESERVE_AVAILABLE_BETWEEN_DATES_AND_STRING_LIKE_CITY,
    GET_PRODUCTS_BY_STRING_LIKE_CITY,
    replaceStringPlaceholder,
} from '../../services/endpoints';


const PaginationFilterDateCity = ({ searchInputs, setSearchInputs }) => {

    const location = useLocation();
    const [data, setData] = useState(null);
    const [itemsPerPage, setItemsPerPage] = useState(8);
    const [currentPage, setCurrentPage] = useState(1);
    const maxPageButtons = 5;
    const [path, setPath] = useState("");
    const [body, setBody] = useState();

    const getBody = () => {
        let body = {};
        if (Object.values(searchInputs).every(val => val === "")) {
            return {}
        } else if (searchInputs[0] && searchInputs[0].start && searchInputs[0].end && searchInputs[0].city) {
            const start = searchInputs[0].start;
            const end = searchInputs[0].end;
            const city = searchInputs[0].city;
            body = {
                "fechaInicio": `${start}`,
                "fechaFin": `${end}`,
                "ciudad": `${city}`,
            }
        } else if (searchInputs[0] && searchInputs[0].start && searchInputs[0].end) {
            const start = searchInputs[0].start;
            const end = searchInputs[0].end;
            body = {
                "fechaInicio": `${start}`,
                "fechaFin": `${end}`,
            }
        } else if (searchInputs[0] && searchInputs[0].city) {
            return
        }
        return body;
    }

    const callApiSearch = async () => {
        if (Object.values(searchInputs).every((val) => val === '')) {
            setData(''); // set data to empty string when all inputs are empty
            return;
        } else if (
            searchInputs[0] &&
            'end' in searchInputs[0] &&
            'start' in searchInputs[0] &&
            'city' in searchInputs[0]
        ) {
            try {
                const response = await searchByDatesAndCity();
                if (response && response.status === 200) {
                    setData(response.data)
                }
            } catch (error) {
                if (error.message === 'Not found') {
                    console.log("No se encontraron productos.");
                }
            }
        } else if (
            searchInputs[0] &&
            'end' in searchInputs[0] &&
            'start' in searchInputs[0]
        ) {
            try {
                const response = await searchByDates();
                if (response && response.status === 200) {
                    setData(response.data)
                }
            } catch (error) {
                if (error.message === 'Not found') {
                    console.log("No se encontraron productos.");
                } else {
                    console.log('Error:', error);
                }
            }
        } else if (searchInputs[0] && 'city' in searchInputs[0]) {
            console.log(searchInputs[0])
            try {
                const response = await searchByCity();
                if (response && response.status === 200) {
                    setData(response.data)
                }
            } catch (error) {
                if (error.message === 'Not found') {
                    console.log("No se encontraron productos.");
                } else {
                    console.log('Error:', error);
                }
            }
        } else {
            return;
        }
    };

    const searchByDatesAndCity = async () => {
        const path = GET_PRODUCT_RESERVE_AVAILABLE_BETWEEN_DATES_AND_STRING_LIKE_CITY;
        //setPath(getPath())
        try {
            const response = await postData(path, getBody())
            if (response && response.status === 200) {
                return response
            }
        } catch (error) {
            if (error.message === 'Not found') {
                console.log("No se encontraron productos.");
                setData("")
                console.clear()
                return null;
            }
        }
    }

    const searchByDates = async () => {
        //setPath(getPath())
        const path = GET_PRODUCT_RESERVE_AVAILABLE_BETWEEN_DATES;
        try {
            const response = await postData(path, getBody())
            if (response && response.status === 200) {
                return response
            }
        } catch (error) {
            if (error.message === 'Not found') {
                console.log("No se encontraron productos.");
                setData("")
                console.clear()
                return null;
            }
        }
    }

    const searchByCity = async () => {
        const city = searchInputs[0].city;
        console.log(searchInputs[0].city)
        const path = replaceStringPlaceholder(GET_PRODUCTS_BY_STRING_LIKE_CITY, city);
        console.log(path)
        try {
            const response = await getData(path)
            if (response && response.status === 200) {
                console.log(response)
                return response
            }
        } catch (error) {
            if (error.message === 'Not found') {
                console.log("No se encontraron productos.");
                setData("")
                console.clear()
                return null;
            }
        }
    }
    

    useEffect(() => {
        callApiSearch();
    }, [searchInputs]);

    if (!data) {
        return <div className={styles.notFound}>No se encontraron lugares que cumplan con esas caracteristicas</div>
    }

    const totalPages = Math.ceil(data.length / itemsPerPage);

    const handleClick = (page) => {
        setCurrentPage(page);
    };

    const handleGoLeft = () => {
        setCurrentPage((prevPage) => prevPage - 1);
    };

    const handleGoRight = () => {
        setCurrentPage((prevPage) => prevPage + 1);
    };

    const renderPageButtons = () => {
        const pages = [];
        let startPage, endPage;

        if (totalPages <= maxPageButtons) {
            startPage = 1;
            endPage = totalPages;
        } else {
            const maxPagesBeforeCurrentPage = Math.floor(maxPageButtons / 2);
            const maxPagesAfterCurrentPage = Math.ceil(maxPageButtons / 2) - 1;

            if (currentPage <= maxPagesBeforeCurrentPage) {
                startPage = 1;
                endPage = maxPageButtons;
            } else if (
                currentPage + maxPagesAfterCurrentPage >=
                totalPages
            ) {
                startPage = totalPages - maxPageButtons + 1;
                endPage = totalPages;
            } else {
                startPage = currentPage - maxPagesBeforeCurrentPage;
                endPage = currentPage + maxPagesAfterCurrentPage;
            }
        }

        for (let i = startPage; i <= endPage; i++) {
            pages.push(
                <button
                    key={i}
                    onClick={() => handleClick(i)}
                    className={i === currentPage ? `${styles.active}` : ""}
                >
                    {i}
                </button>
            );
        }

        return pages;
    };

    const renderData = (dataProducts) => {
        const startIndex = (currentPage - 1) * itemsPerPage;
        const endIndex = startIndex + itemsPerPage;
        return (
            <BlockPagination start={startIndex} end={endIndex} data={dataProducts} />
        );
    };

    return (
        <>
            <div className={styles.backgroundContainer}>
                <div className="pagination">
                    <div className="data">{renderData(data)}</div>
                    <div className={styles.pageButtons}>
                        <button onClick={handleGoLeft} disabled={currentPage === 1}>
                            {"<"}
                        </button>
                        {renderPageButtons()}
                        <button onClick={handleGoRight} disabled={currentPage === totalPages}>
                            {">"}
                        </button>
                    </div>
                </div>
            </div>
        </>
    );
}

export default PaginationFilterDateCity


/*const getPath = () => {
    let path = "";
    if (Object.values(searchInputs).every(val => val === "")) {
        return
    }
    else if (searchInputs[0] && searchInputs[0].start && searchInputs[0].end && searchInputs[0].city) {
        path = GET_PRODUCT_RESERVE_AVAILABLE_BETWEEN_DATES_AND_STRING_LIKE_CITY;
    } else if (searchInputs[0] && searchInputs[0].start && searchInputs[0].end) {
        path = GET_PRODUCT_RESERVE_AVAILABLE_BETWEEN_DATES;
    } else if (searchInputs[0] && searchInputs[0].city) {
        const city = searchInputs[0].city;
        path = replaceStringPlaceholder(GET_PRODUCTS_BY_STRING_LIKE_CITY, city);
    }
    return path;
}*/