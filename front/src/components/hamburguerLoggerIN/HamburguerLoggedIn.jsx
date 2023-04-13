import React, { lazy, Suspense } from "react";
import CloseSharpIcon from "@mui/icons-material/CloseSharp";
import { useNavigate, Link } from "react-router-dom";
import LoggedUserHeader from "../loggedUserHeader/LoggedUserHeader";
import styles from "./HamburguerLoggedIn.module.css"

const BsFacebook = lazy(() => import('react-icons/bs').then(module => ({ default: module.BsFacebook })));
const BsTwitter = lazy(() => import('react-icons/bs').then(module => ({ default: module.BsTwitter })));
const BsInstagram = lazy(() => import('react-icons/bs').then(module => ({ default: module.BsInstagram })));
const FaLinkedinIn = lazy(() => import('react-icons/fa').then(module => ({ default: module.FaLinkedinIn })));

const HamburguerLoggedIn = ({ handleClose }) => {
    const navigate = useNavigate();

    const handleLogOut = () => {
        localStorage.removeItem("jwt");
        localStorage.removeItem("Logged");
        window.postMessage({ type: "jwt", token: null }, "*");
        navigate("/");
        handleClose();
    }
    return (
        <div className={styles.mobileMenu} data-testid='hamburger-LG'>
            <div className={styles.menuUp}>
                <section className={styles.upper}>
                    <CloseSharpIcon onClick={handleClose} />
                    <LoggedUserHeader handleClose={handleClose} />
                </section>
            </div>
            <div className={styles.linksContainer}>
            <Link
              to="/favorites"
              onClick={handleClose}
              style={{ fontWeight: "bold" }}
            >
              Favoritos
            </Link>
            <hr />
            <Link
              to="/reserves/user"
              onClick={handleClose}
              style={{ fontWeight: "bold" }}
            >
              Reservas
            </Link>
          </div>
            <div className={styles.bottomContainer}>
                <div className={styles.endSession}>
                    <p style={{ 
                        fontSize: "12px", 
                        paddingBottom: "0.5rem", 
                        textAlign: "right",
                        paddingRight: "3vw",
                        }} onClick={handleLogOut}>
                        ¿Deseas{" "}
                        <span style={{ color: "var(--orange)" }}>
                            cerrar sesión
                        </span>{" "}
                        ?{" "}
                    </p>
                    <hr
                        style={{
                            border: "1px solid var(--darkGrey)",
                            width: "100%",
                        }}
                    />
                </div>
                <Suspense fallback={<div>Loading...</div>}>
                    <section className={styles.footer}>
                        <BsFacebook />
                        <FaLinkedinIn />
                        <BsTwitter />
                        <BsInstagram />
                    </section>
                </Suspense>
            </div>
        </div>

    );
};

export default HamburguerLoggedIn;
