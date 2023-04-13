import React, { useState, useEffect } from 'react'
import PaginationFilterDateCity from '../../components/paginationFilterDateCity/PaginationFilterDateCity'
import SearchBar from '../../components/searchBar/SearchBar'
import BlockCategory from "../../components/blockCategory/BlockCategory"
import ResponsiveTemplate from '../../components/responsiveTemplate/ResponsiveTemplate'
import Pagination from '../../components/pagination/Pagination'

const FilterDateCityPage = () => {

    const [searchInputs, setSearchInputs] = useState({start: '', end: '', city: '', searchVisible: true});
    const [showFilter, setShowFilter] = useState(true);

    useEffect(() => {
        setShowFilter(searchInputs.searchVisible);
      }, [searchInputs]);

    /*const handleSearchSubmit = (inputs) => {
      setSearchInputs(inputs);
    };*/
  
    console.log(searchInputs)
    //console.log(searchInputs)
    return (
        <>
            <ResponsiveTemplate>
                <SearchBar  setSearchInputs={setSearchInputs} searchInputs={searchInputs}  />
                <BlockCategory />
                {showFilter ? (<Pagination/>) : (<PaginationFilterDateCity searchInputs={searchInputs} setSearchInputs={setSearchInputs}  />)}
            </ResponsiveTemplate>
        </>
    )
}

export default FilterDateCityPage