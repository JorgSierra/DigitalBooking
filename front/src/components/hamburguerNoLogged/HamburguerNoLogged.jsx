import React, { lazy, Suspense } from "react";
import CloseSharpIcon from "@mui/icons-material/CloseSharp";
import { Link } from "react-router-dom";
import styles from "./HamburgerNoLogged.module.css"

const BsFacebook = lazy(() => import('react-icons/bs').then(module => ({ default: module.BsFacebook })));
const BsTwitter = lazy(() => import('react-icons/bs').then(module => ({ default: module.BsTwitter })));
const BsInstagram = lazy(() => import('react-icons/bs').then(module => ({ default: module.BsInstagram })));
const FaLinkedinIn = lazy(() => import('react-icons/fa').then(module => ({ default: module.FaLinkedinIn })));

const HamburguerNoLogged = ({ handleClose }) => {
    return (
        <div className={styles.mobileMenu} data-testid='hamburguer-NL'>
            <div className={styles.menuUp}>
                <section className={styles.upper}>
                    <CloseSharpIcon onClick={handleClose} />

                    <h1 data-testid='hamburguer-h1'>MENÚ</h1>
                </section>

                <section className={styles.middle}>
                    <Link to="/signUp" onClick={handleClose}>
                        <p>Crear cuenta</p>
                    </Link>
                    <hr />
                    <Link to="/login" onClick={handleClose}>
                        <p>Iniciar sesión</p>
                    </Link>
                </section>
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
    );
};

export default HamburguerNoLogged;
