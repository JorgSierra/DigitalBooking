import React, { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import BlockCategory from "../../components/blockCategory/BlockCategory"
import BlockRecommendation from "../../components/blockRecommendation/BlockRecommendation"
import SearchBar from '../../components/searchBar/SearchBar'
import ResponsiveTemplate from '../../components/responsiveTemplate/ResponsiveTemplate'

const Home = () => {

    //const location = useLocation();
    //const loggedIn = JSON.parse(localStorage.getItem("Logged"));
    const navigate = useNavigate();
    const jwt = JSON.parse(localStorage.getItem("jwt"))
  
    const [searchInputs, setSearchInputs] = useState({start: '', end: '', city: '', searchVisible: true});
    const [showFilter, setShowFilter] = useState(true);

    useEffect(() => {
        if(jwt) {
            return navigate("/loggedHome")
        }
        setShowFilter(searchInputs.searchVisible);
      }, [searchInputs]);

    return (
        <ResponsiveTemplate>
            <SearchBar setSearchInputs={setSearchInputs}/>
            <BlockCategory />
            <BlockRecommendation />
        </ResponsiveTemplate>
    )
}

export default Home
