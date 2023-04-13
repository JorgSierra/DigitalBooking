import React, { useState, useEffect } from "react";
import { Link, useNavigate, useLocation } from "react-router-dom";
import { Formik, Form, Field } from "formik";
import style from "./Login.module.css";
import IconButton from "@mui/material/IconButton";
import VisibilityIcon from "@mui/icons-material/Visibility";
import VisibilityOffIcon from "@mui/icons-material/VisibilityOff";
import AlertLoggin from "../alertLoggin/AlertLoggin";
import { LOG_USER } from "../../services/endpoints";
import { postData } from "../../services/api";

function Login() {
    const location = useLocation();
    const navigate = useNavigate();
    const [showPassword, setShowPassword] = useState(false);
    const [passwordError, setPasswordError] = useState(false);
    const [reservaErrorIsVisible, setReservaErrorIsVisible] = useState(false);
    const reservaErrorMessage =
        "Para realizar una reserva necesitas estar logueado";
    const [searchBarErrorIsVisible, setSearchBarErrorIsVisible] = useState(false);
    const searchBarErrorMessage =
        "Para realizar una busqueda necesitas estar logueado";

    const handleSubmit = async (values, { setSubmitting }) => {
        const body = {
            username: `${values.email}`,
            password: `${values.password}`,
        };

        try {
            const response = await postData(LOG_USER, body);

            if (response && response.status === 200) {
                localStorage.setItem("jwt", JSON.stringify(response.data.jwt));
                localStorage.setItem("Logged", JSON.stringify("true"));
                window.postMessage({ type: "jwt", token: JSON.stringify(response.data.jwt) }, "*");
                setSubmitting(false);
                navigate("/loggedHome");
            } else {
                //console.log(response);
                setPasswordError(
                    "Lamentablemente no ha podido iniciar sesión. Por favor, intente más tarde"
                );
            }

            setSubmitting(false);
        } catch (error) {
            if (error.message === 'User not authorized') {
                setPasswordError("El usuario no está registrado, su contraseña no corresponde o aún no habilito su cuenta (verifique su correo)");
            } else {
                setPasswordError("Lamentablemente no ha podido iniciar sesión. Por favor, intente más tarde");
            }
            setSubmitting(false);
        }
    };

    function loginPage() {
        if (location.state && location.state.notLogged) {
            setReservaErrorIsVisible(true);
        } else if (location.state && location.state.searchNotLogged) {
            setSearchBarErrorIsVisible(true);
        }
    }

    useEffect(() => {
        loginPage();
    }, []);

    return (
        <div className={style.background}>
            <div className={style.loginContainer} data-testid="login-container">
                {reservaErrorIsVisible ? (
                    <AlertLoggin text={reservaErrorMessage} />
                ) : (
                    ""
                )}
                {searchBarErrorIsVisible ? (
                    <AlertLoggin text={searchBarErrorMessage} />
                ) : (
                    ""
                )}

                <h2 className={style.loginTitle}>Iniciar Sesión</h2>
                <Formik
                    initialValues={{ email: "", password: "" }}
                    onSubmit={handleSubmit}
                >
                    {({ isSubmitting }) => (
                        <Form>
                            <div className={style.divisions}>
                                <label htmlFor="email">Correo electrónico</label>
                                <Field
                                    type="email"
                                    id="email"
                                    name="email"
                                    aria-label="Correo electronico"
                                    style={{ boxShadow: "0px 1px 5px rgba(0, 0, 0, 0.15)" }}
                                />
                            </div>
                            <div className={style.divisions} style={{ position: "relative" }}>
                                <label htmlFor="password">Contraseña</label>
                                <Field id="password" name="password">
                                    {({ field }) => (
                                        <div className={style.password}>
                                            <input
                                                {...field}
                                                type={showPassword ? "text" : "password"}
                                                aria-label="Contraseña"
                                                style={{ width: "100%" }}
                                            />
                                            <IconButton
                                                onClick={() => setShowPassword(!showPassword)}
                                                data-testid="password-visibility-button"
                                                style={{
                                                    width: "2.5rem",
                                                    height: "2.5rem",
                                                    boxShadow: "none",
                                                }}
                                            >
                                                {showPassword ? (
                                                    <VisibilityIcon
                                                        data-testid="showPasswordButton"
                                                        aria-label="Mostrar contraseña"
                                                    />
                                                ) : (
                                                    <VisibilityOffIcon />
                                                )}
                                            </IconButton>
                                        </div>
                                    )}
                                </Field>
                                <p className={style.error} data-testid="password-error">
                                    {passwordError}
                                </p>
                            </div>
                            <div className={style.containerButton}>
                                <button
                                    type="submit"
                                    className={style.submitButton}
                                    disabled={isSubmitting}
                                    data-testid="login-button"
                                >
                                    Ingresar
                                </button>
                                <p>
                                    <span>¿Aún no tenés cuenta?</span>{" "}
                                    <Link to="/signUp" className={style.newAccount}> Registrate</Link>
                                </p>
                            </div>
                        </Form>
                    )}
                </Formik>
            </div>
        </div>
    );
}

export default Login;
