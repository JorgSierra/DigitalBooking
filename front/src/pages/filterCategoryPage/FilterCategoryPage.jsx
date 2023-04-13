import React, { useState, useEffect, useContext } from 'react'
import BlockCategory from "../../components/blockCategory/BlockCategory"
import SearchBar from '../../components/searchBar/SearchBar'
import BlockFilteredByCategory from '../../components/blockFilteredByCategory/BlockFilteredByCategory'
import ResponsiveTemplate from '../../components/responsiveTemplate/ResponsiveTemplate'
import PaginationFilterDateCity from '../../components/paginationFilterDateCity/PaginationFilterDateCity'
import { FilterContext } from '../../context/Filter.context'

const FilterCategoryPage = () => {

    const [searchInputs, setSearchInputs] = useState({start: '', end: '', city: '', searchVisible: true});
    const { filterValue, setFilterValue } = useContext(FilterContext);  

    useEffect(() => {
        setFilterValue(searchInputs.searchVisible);
      }, [searchInputs]);

    return (

        <ResponsiveTemplate>
            <SearchBar setSearchInputs={setSearchInputs} searchInputs={searchInputs} />
            <BlockCategory />
            {filterValue ? (<BlockFilteredByCategory />) : (<PaginationFilterDateCity searchInputs={searchInputs} setSearchInputs={setSearchInputs} />)}
        </ResponsiveTemplate>
    )
}

export default FilterCategoryPage


/*

        <ResponsiveTemplate>
            <SearchBar />
            <BlockCategory />
            <BlockFilteredByCategory />
        </ResponsiveTemplate>

*/
