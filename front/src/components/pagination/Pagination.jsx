import React, { useEffect, useState } from 'react'
import { GET_ALL_PRODUCTS_ENDPOINT } from '../../services/endpoints';
import { getData } from '../../services/api';
import styles from "./Pagination.module.css"
import LoadingSpinner from '../loadingSpinner/LoadingSpinner';
import BlockPagination from '../blockPagination.jsx/BlockPagination';

const Pagination = () => {

    const [data, setData] = useState(null);
    const [itemsPerPage, setItemsPerPage] = useState(8);
    const [currentPage, setCurrentPage] = useState(1);
    const maxPageButtons = 5;

    useEffect(() => {
        getData(GET_ALL_PRODUCTS_ENDPOINT, setData)
    }, [currentPage]);

    if (!data) {
        return <LoadingSpinner />
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

export default Pagination