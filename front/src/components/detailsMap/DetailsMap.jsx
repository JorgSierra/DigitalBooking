import React, { useEffect, useState } from 'react'
import { getDirectionFromCoordinates } from '../../utils/utils';
import { MapContainer, TileLayer, useMap, Marker, Popup } from 'react-leaflet'
import 'leaflet/dist/leaflet.css';
import styles from "./DetailsMap.module.css"
import L from 'leaflet';
import RoomIcon from '@mui/icons-material/Room';

const DetailsMap = (props) => {

    const customIcon = L.icon({
        iconUrl: `https://www.pngall.com/wp-content/uploads/2017/05/Map-Marker-PNG-HD.png`,
        iconSize: [40, 40],
        iconAnchor: [17, 41],
        popupAnchor: [1, -34],
      });

    const { latitud, longitud } = props || {};
    const [position, setPosition] = useState([51.505, -0.09]);
    const [address, setAddress] = useState("");
    const decimalRegex = /^-?\d+(\.\d+)?$/;

    useEffect(() => {
        setPosition(CheckValidCoordinates(latitud, longitud, decimalRegex));
    }, [latitud, longitud]);



    if (!props) {
        return <div>Cargando</div>
    }

    return (
        <div className={styles.mapContainer}>
            {(latitud && longitud) ?
                <MapContainer className={styles.map} style={{ width: "100%", height: "100%" }} center={position} zoom={13} scrollWheelZoom={false}>
                    <TileLayer
                        attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
                        url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
                    />
                    <ChangeMapView coords={position} />
                    <Marker position={position} icon={customIcon}  eventHandlers={{
                        click: (event) => getDirectionFromCoordinates(latitud, longitud, setAddress, event)
                    }}>
                        <Popup >
                            {address}
                        </Popup>
                    </Marker>
                </MapContainer> : ""}
        </div>
    )
}

//Checks if the data type of each coordinate is a number
const checkIfNumber = (cord1, cord2) => {
    if (cord1 && cord2) {
        if (typeof cord1 === 'number' && typeof cord2 === 'number') {
            return true;
        }
    }
    return false;
}

//Checks with a regular expression if both coordinates are in decimal format
const checkIfDecimal = (cord1, cord2, decimalRegex) => {
    if (cord1 && cord2) {
        if (decimalRegex.test(cord1.toString()) && decimalRegex.test(cord2.toString())) {
            return true;
        }
    }
    return false;
}

//Calls two functions to verify if both coordinates are of type number and in decimal 
//format, if not it will return a default coordinate
const CheckValidCoordinates = (lat, long, decimalRegex) => {
    if (checkIfNumber(lat, long) && checkIfDecimal(lat, long, decimalRegex)) {
        return [lat, long]
    } else {
        return [51.505, -0.09];
    }
}

//Function that updates the map, since MapContainer is immutable after its creation,
// you need to have a component inside that will change and re render so the entire map is updated
function ChangeMapView({ coords }) {
    const map = useMap();
    map.setView(coords, map.getZoom());
    return null;
}

export default DetailsMap