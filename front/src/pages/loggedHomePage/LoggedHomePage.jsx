import React, { useState, useEffect, useContext } from 'react'
import PaginationFilterDateCity from '../../components/paginationFilterDateCity/PaginationFilterDateCity'
import SearchBar from '../../components/searchBar/SearchBar'
import BlockCategory from "../../components/blockCategory/BlockCategory"
import ResponsiveTemplate from '../../components/responsiveTemplate/ResponsiveTemplate'
import Pagination from '../../components/pagination/Pagination'
import { FilterContext } from '../../context/Filter.context'

const LoggedHomePage = () => {

    const [searchInputs, setSearchInputs] = useState({ start: '', end: '', city: '', searchVisible: true });
    const { filterValue, setFilterValue } = useContext(FilterContext);
    const jwt = JSON.parse(localStorage.getItem("jwt"));

    useEffect(() => {
        setFilterValue(searchInputs.searchVisible);
    }, [searchInputs]);


    return (
        <>
            <ResponsiveTemplate>
                <SearchBar setSearchInputs={setSearchInputs} searchInputs={searchInputs} />
                <BlockCategory />
                {filterValue ? (<Pagination />) : (<PaginationFilterDateCity searchInputs={searchInputs} setSearchInputs={setSearchInputs} />)}
            </ResponsiveTemplate>
        </>
    )
}

export default LoggedHomePage