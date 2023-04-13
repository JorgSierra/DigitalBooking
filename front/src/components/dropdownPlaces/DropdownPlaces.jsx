import React, { useState, useEffect } from "react";
import { getData } from "../../services/api";
import LocationOnSharpIcon from "@mui/icons-material/LocationOnSharp";
import styles from "./DropdownPlaces.module.css";
import { GET_ALL_LOCATIONS } from "../../services/endpoints";

const DropdownPlaces = ({ setDropdownValue }) => {

    const [location, setLocation] = useState(null);
    const placesToShow = 5;

    // call to api
    useEffect(() => {
        getData(GET_ALL_LOCATIONS, setLocation)
    }, []);

    const handleClick = (e) => {
        const value = e.target.innerText;
        setDropdownValue(value);
    };

    if (!location) {
        return <div>Cargando</div>
    }
    
    return (
        <div className={styles.placesCard} data-testid="dropdown-places">
            {location.slice(0, placesToShow).map((place) => (
                <div className={styles.place} key={place.id} onClick={handleClick}>
                    <div className={styles.side}>
                        <LocationOnSharpIcon style={{ color: "#31363F" }} />
                        <div className={styles.location}>
                            <p>
                                {place.ciudad}
                                <span >-{place.pais}</span>
                            </p>
                        </div>
                    </div>
                    <hr />
                </div>
            ))}
        </div>
    );
};

export default DropdownPlaces;
