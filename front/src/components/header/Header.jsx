import React from "react";
import { useState, useEffect, useContext } from "react";
import styles from "./Header.module.css";
import MenuSharpIcon from "@mui/icons-material/MenuSharp";
import { Link, useLocation, useNavigate } from "react-router-dom";
import Hamburguer from "../hamburguer/Hamburguer";
import LoggedUserHeader from "../loggedUserHeader/LoggedUserHeader";
import { scrollToTop } from "../../utils/utils";
import { FilterContext } from "../../context/Filter.context";
import { JwtContext } from "../../context/Jwt.context";

const Header = () => {
  const [showHamburguer, setShowHamburguer] = useState(false);
  const { filterValue, setFilterValue } = useContext(FilterContext);
 

  const currentLocation = useLocation();
  const navigate = useNavigate();

  // console.log(jwtValue)

  /*  <Link to="/signUp">
              <button data-testid="signup-button">Crear cuenta</button>
          </Link>
          <Link to="/login">
              <button data-testid="login-button">Iniciar sesión</button>
          </Link>
      */

  const loggedIn = JSON.parse(localStorage.getItem("Logged"));

  // console.log(loggedIn);

  /*useEffect(() => {
        if (loggedIn) {
            navigate("/loggedHome")
        }
    }, []);*/

  const handleOpen = () => {
    setShowHamburguer(!showHamburguer);
  };

  const handleClose = () => {
    setShowHamburguer(false);
  };

  const handleLogoClick = () => {
    setFilterValue(true);
    scrollToTop();
  };

  return (
    <header>
      <div data-testid="header" className={styles.headerContainer}>
        {loggedIn ? (
          <Link onClick={handleLogoClick} to="/loggedHome">
            <div className={styles.logo} onClick={handleClose}>
              <img
                src="https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/logoDb.png"
                alt="Logo Db"
                data-testid="logo-testid"
                style={{ width: "71px", height: "52px", borderRadius: "4px" }}
              />
              <p>Sentite como en tu hogar</p>
            </div>
          </Link>
        ) : (
          <Link onClick={scrollToTop} to="/">
            <div className={styles.logo} onClick={handleClose}>
              <img
                src="https://equipo10-digitalbooking-img.s3.us-east-2.amazonaws.com/img/logoDb.png"
                alt="Logo Db"
                data-testid="logo-testid"
                style={{ width: "71px", height: "52px", borderRadius: "4px" }}
              />
              <p>Sentite como en tu hogar</p>
            </div>
          </Link>
        )}
        <div className={styles.buttonMobile}>
          <MenuSharpIcon
            fontSize="large"
            style={{ color: "var(--darkGrey)" }}
            onClick={handleOpen}
          />
        </div>
        <div className={styles.buttonContainer}>
          {loggedIn ? (
            <LoggedUserHeader />
          ) : (
            showButtons(currentLocation.pathname, scrollToTop)
          )}
        </div>
      </div>
      {showHamburguer ? (
        <Hamburguer handleClose={handleClose} loggedIn={loggedIn} />
      ) : null}
    </header>
  );
};

//Depending on the current url path will return the appropiate button or buttons for the header
const showButtons = (location, funct) => {
  switch (location) {
    case "/signUp":
      return (
        <Link onClick={funct} to="/login">
          <button data-testid="login-button" className={styles.headerButton}>
            Iniciar sesión
          </button>
        </Link>
      );
    case "/login":
      return (
        <Link onClick={funct} to="/signUp">
          <button data-testid="signup-button" className={styles.headerButton}>
            Crear cuenta
          </button>
        </Link>
      );
    default:
      return (
        <>
          <Link onClick={funct} to="/signUp">
            <button data-testid="signup-button" className={styles.headerButton}>
              Crear cuenta
            </button>
          </Link>
          <Link onClick={funct} to="/login">
            <button data-testid="login-button" className={styles.headerButton}>
              Iniciar sesión
            </button>
          </Link>
        </>
      );
  }
};

export default Header;
