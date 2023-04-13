import { useState, createContext, useEffect } from "react";
import { postDataWithTokenAndNoBody } from "../services/api";
import { PRODUCT_TOGGLE_LIKE, replaceIdPlaceholder } from "../services/endpoints";

export const FavoritesContext = createContext();

const FavoritesProvider = ({ children }) => {
  const [favorites, setFavorites] = useState([]);
  const [changing, setChanging] = useState(false);

  const handlePost = async (endpoint, productId) => {
    const productWithId = replaceIdPlaceholder(endpoint, productId)
    //console.log(productWithId)
    try {
      const response = await postDataWithTokenAndNoBody(productWithId);
      //console.log(response)
      if (response && response.status === 200) {
        //console.log("Like creado con exito");
      } else if (response && response.status) {
        //console.log("Like eliminado con exito");
      }
      else if (response) {
        //console.log(response)
      }
    } catch (error) {
      if (error.message === "User not authorized") {
        //console.log("Usuario no autorizado");
      } else {
        //console.log(error);
      }
    }
  };

  return (
    <FavoritesContext.Provider
      value={{ favorites, setFavorites, handlePost, changing, setChanging}}
    >
      {children}
    </FavoritesContext.Provider>
  );
};

export default FavoritesProvider;



  /*const handleFavorites = (hotel) => {
    // console.log(hotel);
    const exist = favorites.some((element) => element.id === hotel.id);
    if (exist) {
      const newFavs = favorites.filter((element) => element.id !== hotel.id);
      setFavorites(newFavs);
    } else {
      setFavorites([...favorites, hotel]);
    }
  };

  const isInFavorites = (id) => {
    return favorites.some((element) => element.id === id);
  };*/
