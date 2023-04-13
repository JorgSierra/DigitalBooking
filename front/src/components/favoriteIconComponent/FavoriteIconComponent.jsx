import { useContext, useEffect } from "react";
import IconButton from '@mui/material/IconButton';
import FavoriteSharpIcon from "@mui/icons-material/FavoriteSharp";
import { FavoritesContext } from "../../context/Favorites.context";
import { PRODUCT_TOGGLE_LIKE } from "../../services/endpoints";
import { JwtContext } from "../../context/Jwt.context";
import swal from "sweetalert";
import { useNavigate } from "react-router-dom";

const FavoriteIconComponent = ({ data, heartColor, shadow, fav, handleFavs }) => {
    const { favorites, handlePost, changing, setChanging } = useContext(FavoritesContext);
    const { jwtValue } = useContext(JwtContext);
    const navigate = useNavigate();

    /*useEffect(() => {

    }, [fav, jwtValue]);*/
    //console.log(fav)
    
    const handleClick = () => {
        if (jwtValue) {
            handleFavs()
            handlePost(PRODUCT_TOGGLE_LIKE, data.id)
            setChanging(!changing)
        } else {
            swal("Debes estar logeado para añadir un producto a favoritos")
            navigate("/login");
        }
    }

    return (
        <>
            <IconButton
                value={favorites}
                onClick={handleClick}
            >
                {fav && jwtValue ? <FavoriteSharpIcon color="error" /> : <FavoriteSharpIcon style={{ color: heartColor, filter: shadow }} />}
            </IconButton>
        </>
    );
};

export default FavoriteIconComponent;
