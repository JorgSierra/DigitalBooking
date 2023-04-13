import React, { useEffect, useState, useContext } from "react";
import { useNavigate, Link } from "react-router-dom";
import styles from "./LoggedUserHeader.module.css";
import CloseSharpIcon from "@mui/icons-material/CloseSharp";
import { decodeToken } from "../../utils/utils";
import LoadingSpinner from "../loadingSpinner/LoadingSpinner";
import { JwtContext } from "../../context/Jwt.context";
import Menu from "../menu/Menu";

const LoggedUserHeader = ({ handleClose }) => {
    const navigate = useNavigate();
    const [token, setToken] = useState("");
    const [decodedToken, setDecodedToken] = useState("");
    const [initials, setInitials] = useState("");
    const [name, setName] = useState("");
    const [lastname, setLastname] = useState("");
    const [openMenu, setopenMenu] = useState(false); //menuAvatar
    const { jwtValue } = useContext(JwtContext);
    const [isShown, setIsShown] = useState(false);

    const handleLogOut = () => {
        localStorage.removeItem("jwt");
        localStorage.removeItem("Logged");
        window.postMessage({ type: "jwt", token: null }, "*");
        navigate("/");
    };

    const handleClick = () => {
        setIsShown(!isShown);
    };

    const closeModal = (e) => {
        if (e.target.closest(".MuiPaper-elevation")) {
            return;
        }
        setIsShown(!isShown);
    };

    useEffect(() => {
        const token = JSON.parse(localStorage.getItem("jwt"));
        setToken(token);
    }, []);

    useEffect(() => {
        if (token) {
            decodeToken(token, setDecodedToken);
        }
    }, [token]);

    useEffect(() => {
        if (token) {
            initialsToUpperCase();
            shortenName();
        }
    }, [decodedToken]);

    useEffect(() => {
        if (isShown) {
            document.addEventListener("mousedown", closeModal);
        } else {
            document.removeEventListener("mousedown", closeModal);
        }
        return () => document.removeEventListener("mousedown", closeModal);
    }, [isShown]);

    const role = jwtValue.role;

    if (!token) {
        return <LoadingSpinner />;
    }

    //show menu click avatar
    /*const handleMenuOpenClose = () => {
      setopenMenu(!openMenu);
    };*/



    const initialsToUpperCase = () => {
        if (decodedToken) {
            const upperInitials =
                decodedToken.name[0].toUpperCase() +
                decodedToken.lastname[0].toUpperCase();
            setInitials(upperInitials);
        }
    };

    const shortenName = () => {
        //console.log(token)
        //console.log(decodedToken.name)
        if (decodedToken.name.length > 9) {
            setName(decodedToken.name.slice(0, 9) + "...");
        } else {
            setName(decodedToken.name);
        }
        if (decodedToken.lastname.length > 9) {
            setLastname(decodedToken.lastname.slice(0, 9) + "...");
        } else {
            setLastname(decodedToken.lastname);
        }
    };

    //console.log(name)
    return (
        <div style={{ display: "flex" }}>
            <div className={styles.flex}>
                <div className={styles.buttonContainer}>

                    <section>
                        {role === "ROLE_ADMIN" ? (
                            <Link
                                to="/adminTable"
                                className={styles.adminButton}
                                onClick={handleClose}
                            >
                                ADMIN
                            </Link>
                        ) : null}
                    </section>
                </div>
                <section className={styles.userName} onClick={handleClick}>
                    <div className={styles.user}>
                        <p className={styles.initials}>{initials}</p>
                    </div>
                    <div className={styles.rightText} data-testid="logged-user">
                        <p className={styles.userTextTop}>Hola,</p>
                        <p className={styles.userTextBottom}>
                            {" "}
                            {name} {lastname}
                        </p>
                    </div>
                </section>
                <CloseSharpIcon
                    style={
                        {
                            /*
                                  index: 50,
                                  position: "absolute",
                                  top: "3%",
                                  right: 0,
                                  marginLeft: "10px"*/
                        }
                    }
                    onClick={handleLogOut}
                />
            </div>
            <div className={styles.menu}>
                {isShown ? <Menu handleClose={handleClose} /> : null}
            </div>
        </div>
    );
};

export default LoggedUserHeader;
