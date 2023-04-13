import React from 'react'
import Pagination from '../pagination/Pagination'
import BlockCategory from '../blockCategory/BlockCategory'
import SearchBar from '../searchBar/SearchBar'

const BlockLoggedHome = () => {
    return (
        <>
            <SearchBar/>
            <BlockCategory />
            <Pagination />
        </>
    )
}

export default BlockLoggedHome