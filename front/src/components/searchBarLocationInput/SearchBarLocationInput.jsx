import React, { useState, useEffect } from 'react'
import DropdownPlaces from "../dropdownPlaces/DropdownPlaces";
import LocationOnIcon from "@mui/icons-material/LocationOn";
import styles from "./SearchBarLocationInput.module.css"

const SearchBarLocationInput = ({ onChange }) => {

    //-----------------Open/Close logic--------------------------------------------

    const [isShown, setIsShown] = useState(false);
    const [dropdownData, setDropdownData] = useState("");
    const [inputValue, setInputValue] = useState("");

    const handleClick = () => {
        setIsShown(!isShown);
    };

    const closeModal = (e) => {
        if (e.target.closest(".inputLocation")) {
            return;
        }
        setIsShown(!isShown);
    };

    useEffect(() => {
        if (isShown) {
            document.addEventListener("mousedown", closeModal);
        } else {
            document.removeEventListener("mousedown", closeModal);
        }
        return () => document.removeEventListener("mousedown", closeModal);
    }, [isShown]);


    //-----------------Places--------------------------------------------

    const [dropdownValue, setDropdownValue] = useState("");

    useEffect(() => {
        const storedValue = localStorage.getItem("value");
        if (storedValue) {
            setDropdownValue(JSON.parse(storedValue));
        }
    }, []);

    useEffect(() => {
        localStorage.setItem("value", JSON.stringify(dropdownValue));
    }, [dropdownValue]);

    const handleDropdownChange = (value) => {
        const [city, country] = value.split(/\s*-\s*/);
        setInputValue(city);
        setDropdownValue(city);
        onChange(city);
    };

    const handleInputChange = (event) => {
        const inputValue = event.target.value;
        const [city, country] = inputValue.split(/\s*-\s*/);
        setInputValue(city);
        onChange(city);
    };

    //onChange={(event) => onChange(event.target.value)}
    return (
        <section className='inputLocation' onClick={handleClick}>
            <div className={styles.iconDiv}>
                <LocationOnIcon
                    fontSize="medium"
                    style={{
                        color: "7F7F7F",
                        paddingLeft: "0.5rem",
                    }}
                />
                <input
                    type="text"

                    placeholder="¿A dónde vamos?"
                    data-testid="search-location-input"
                    value={inputValue}
                    onChange={handleInputChange}

                />
            </div>
            {isShown && (
                <DropdownPlaces
                    data-testid="dropdown-places"
                    setDropdownValue={handleDropdownChange}
                />
            )}
        </section>
    )
}

export default SearchBarLocationInput