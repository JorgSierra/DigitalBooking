import React, { useState, useContext } from "react";
import { useNavigate } from "react-router-dom";
import styles from "./SearchBar.module.css";
import SearchBarCalendar from "../searchBarCalendar/SearchBarCalendar";
import SearchBarLocationInput from "../searchBarLocationInput/SearchBarLocationInput";
import { DatesContext } from "../../context/Dates.context";

const SearchBar = ({ setSearchInputs }) => {

    const [locationInputValue, setLocationInputValue] = useState('');
    const [rangeDates, setDates] = useState({ startDate: null, endDate: null });
    const navigate = useNavigate();
    const loggedIn = JSON.parse(localStorage.getItem("Logged"));
    const { valueDate,  setValueDate } = useContext(DatesContext);
    
    const handleDateChange = (dates) => {
        setValueDate (dates)
        //console.log(dates)
        if (dates.length > 1) {
            setDates({ 
                startDate: `${dates[0].year}-${(dates[0].monthIndex + 1).toString().padStart(2, '0')}-${dates[0].day.toString().padStart(2, '0')}`,
                endDate: `${dates[1].year}-${(dates[1].monthIndex + 1).toString().padStart(2, '0')}-${dates[1].day.toString().padStart(2, '0')}` });      
        }
    };

    const handleLocationInputChange = (value) => {
        setLocationInputValue(value);
    };


    const handleSubmit = (event) => {
        event.preventDefault();
        const inputs = getInputs();

        if (!loggedIn) {
            return navigate("/login", {state: { searchNotLogged: true }})
        }
        
        if (inputs) {
            //console.log(inputs)
            setSearchInputs(inputs);
        }
    };


    const getInputs = () => {
        let inputs = [];

        if (rangeDates.startDate && rangeDates.endDate && Boolean(locationInputValue)) {
            //const startDateString = dates.startDate.toISOString().slice(0, 10);
            //const endDateString = dates.endDate.toISOString().slice(0, 10);
            inputs = [{
                start: rangeDates.startDate, 
                end: rangeDates.endDate, 
                city: locationInputValue,
                searchVisible: false
            }]

        } else if (rangeDates.startDate && rangeDates.endDate) {
            
            /*const startDateString = dates.startDate.toISOString().slice(0, 10);
            const endDateString = dates.endDate.toISOString().slice(0, 10);*/
            inputs = [{
                start: rangeDates.startDate, 
                end: rangeDates.endDate, 
                searchVisible: false
            }]

        } else if (Boolean(locationInputValue)) {
            inputs = [{
                city: locationInputValue,
                searchVisible: false
            }]
        } else {
            return inputs = [{
                searchVisible: true
            }]
        }
        //console.log(inputs)
        return inputs;
    };

    return (
        <form
            className={styles.searchBar}
            data-testid="search-bar"
            onSubmit={handleSubmit}
        >
            <h1>Busca ofertas en hoteles, casas y mucho más</h1>
            <div className={styles.inputs}>
                <SearchBarLocationInput
                    data-testid="search-location-input"
                    onChange={handleLocationInputChange}
                />
                <SearchBarCalendar
                    data-testid="searchBar-calendar"
                    dates={rangeDates}
                    onDateChange={handleDateChange}
                />
                <div>
                    <button
                        className={styles.formButton}
                        type="submit"
                    >
                        Buscar
                    </button>
                </div>
            </div>
        </form>
    );
};

export default SearchBar;






  /*const getUrl = () => {
        let url = "";

        if (dates.startDate && dates.endDate && Boolean(locationInputValue)) {
            const startDateString = dates.startDate.toISOString().slice(0, 10);
            const endDateString = dates.endDate.toISOString().slice(0, 10);
            url = replaceDateAndCityPlaceholders(
                GET_PRODUCT_RESERVE_AVAILABLE_BETWEEN_DATES_AND_STRING_LIKE_CITY,
                startDateString,
                endDateString,
                locationInputValue
            );
        } else if (dates.startDate && dates.endDate) {
            const startDateString = dates.startDate.toISOString().slice(0, 10);
            const endDateString = dates.endDate.toISOString().slice(0, 10);
            url = replaceDateAndCityPlaceholders(
                GET_PRODUCT_RESERVE_AVAILABLE_BETWEEN_DATES,
                startDateString,
                endDateString
            );
        } else if (Boolean(locationInputValue)) {
            url = replaceStringPlaceholder(
                GET_PRODUCTS_BY_STRING_LIKE_CITY,
                locationInputValue
            );
        }

        return url;
    };*/


    /*const handleSubmit = (event) => {
        event.preventDefault();
      
        if (dates.startDate && dates.endDate && Boolean(locationInputValue)) {
          const startDateString = dates.startDate.toISOString().slice(0, 10);
          const endDateString = dates.endDate.toISOString().slice(0, 10);
          const url = replaceDateAndCityPlaceholders(GET_PRODUCT_RESERVE_AVAILABLE_BETWEEN_DATES_AND_STRING_LIKE_CITY, startDateString, endDateString, locationInputValue);
          return getData(url, setData).then(() => {
            navigate("/", { state: { places: { data } } });
          });
        } else if (dates.startDate && dates.endDate) {
          const startDateString = dates.startDate.toISOString().slice(0, 10);
          const endDateString = dates.endDate.toISOString().slice(0, 10);
          const url = replaceDateAndCityPlaceholders(GET_PRODUCT_RESERVE_AVAILABLE_BETWEEN_DATES, startDateString, endDateString);
          return getData(url, setData).then(() => {
            navigate("/", { state: { places: { data } } });
          });
        } else if (Boolean(locationInputValue)) {
          const url = replaceStringPlaceholder(GET_PRODUCTS_BY_STRING_LIKE_CITY, locationInputValue)
          return getData(url, setData).then(() => {
            navigate("/", { state: { places: { data } } });
          });
        } else {
          return "No valid inputs"
        }
      };*/

    /*const handleSubmit = (event) => {
        event.preventDefault();
        if (dates.startDate && dates.endDate && Boolean(locationInputValue)) {
            const startDateString = dates.startDate.toISOString().slice(0, 10);
            const endDateString = dates.endDate.toISOString().slice(0, 10);
            const url = replaceDateAndCityPlaceholders(GET_PRODUCT_RESERVE_AVAILABLE_BETWEEN_DATES_AND_STRING_LIKE_CITY, startDateString, endDateString, locationInputValue);
            getData(url, setData)
            console.log("estoy en 1");
        } else if (dates.startDate && dates.endDate) {
            const startDateString = dates.startDate.toISOString().slice(0, 10);
            const endDateString = dates.endDate.toISOString().slice(0, 10);
            const url = replaceDateAndCityPlaceholders(GET_PRODUCT_RESERVE_AVAILABLE_BETWEEN_DATES, startDateString, endDateString);
            getData(url, setData)
            console.log("estoy en 2");
        } else if (Boolean(locationInputValue)) {
            console.log("estoy en 3");
            const url = replaceStringPlaceholder(GET_PRODUCTS_BY_STRING_LIKE_CITY, locationInputValue)
            getData(url, setData)
        } else {
            return "No valid inputs"
        }
        navigate("/", { state: { places: { data } } });
    };*/


    //console.log(locationInputValue)
    //console.log(data)


