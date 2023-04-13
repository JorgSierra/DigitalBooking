import { useState } from "react";
import { Formik, Form, Field } from "formik";
import style from "./SignUp.module.css";
import { Link, useNavigate } from "react-router-dom";
import IconButton from '@mui/material/IconButton';
import VisibilityIcon from '@mui/icons-material/Visibility';
import VisibilityOffIcon from '@mui/icons-material/VisibilityOff';
import { REGISTER_USER } from "../../services/endpoints";
import { postData } from "../../services/api";

const SignUp = () => {
    const [showPassword, setShowPassword] = useState(false);
    const [errorForm, setErrorForm] = useState("");
    const navigate = useNavigate();

    const initialValues = {
        username: "",
        password: "",
        password2: "",
        lastname: "",
        email: "",
    };

    const validate = (values) => {
        const errors = {};

        if (!values.username) {
            errors.username = "Debe ingresar un nombre";
        }

        if (!values.lastname) {
            errors.lastname = "Debe ingresar un apellido";
        }

        if (!values.email) {
            errors.email = "Debe ingresar un correo electrónico";
        }

        if (!values.password) {
            errors.password = "Debe ingresar una contraseña";
        }

        if (!values.password2) {
            errors.password2 = "Debe confirmar la contraseña";
        } else if (values.password !== values.password2) {
            errors.password2 = "Las contraseñas no coinciden";
        }

        if (/\d/.test(values.username) || /\d/.test(values.lastname)) {
            errors.username = "El nombre o apellido no pueden contener números";
        }

        if (values.password.length < 6) {
            errors.password = "La contraseña debe tener al menos 6 caracteres";
        }

        return errors;
    };

    const handleSubmit = async (values, { setSubmitting }) => {
        const body = {
            "nombre": `${values.username}`,
            "apellido": `${values.lastname}`,
            "email": `${values.email}`,
            "password": `${values.password}`,
            "ciudad": "Sin definir",
            "rol": 2
        }

        try {
            const response = await postData(REGISTER_USER, body)

            if (response && response.status === 201) {
                /*localStorage.setItem("jwt", JSON.stringify(response.data.jwt));
                localStorage.setItem("Logged", JSON.stringify("true"));*/
                setSubmitting(false);
                navigate("/verifiedRegistration");
                //console.log("exito");
            } else {
                //console.log(response);
                setErrorForm("Lamentablemente no ha podido registrarse. Por favor, intente más tarde");
            }
            setSubmitting(false);
        } catch (error) {
            if (error.message === "Bad Request") {
                setErrorForm("Error en request recibido.");
            } else if (error.message === "Request conflict") {
                setErrorForm("El usuario que intentó registrar tiene un correo ya registrado.");
            } else {
                setErrorForm("Lamentablemente no ha podido registrarse. Por favor, intente más tarde");
            }
            setSubmitting(false);
        }
    };

    return (
        <div className={style.container} data-testid="signup-component">
            <div className={style.form}>
                <h1
                    style={{
                        color: "var(--orange)",
                        fontSize: "1.5rem",
                        fontWeight: "bold",
                    }}
                >
                    Crear Cuenta
                </h1>
                <Formik
                    initialValues={initialValues}
                    validate={validate}
                    onSubmit={handleSubmit}
                >
                    {(formik) => (
                        <Form>
                            <div className={style.LastnameContainer}>
                                <section className={style.sectionName}>
                                    <div className={style.inputName}>
                                        <label htmlFor="name">Nombre</label>
                                        <Field
                                            type="text"
                                            className="input"
                                            name="username"
                                            id="name"
                                            required
                                            data-testid="name"
                                        />
                                    </div>
                                    <div>
                                        {formik.errors.username && formik.touched.username && (
                                            <p className={style.error}>{formik.errors.username}</p>
                                        )}
                                    </div>
                                </section>
                                <section className={style.sectionName}>
                                    <div className={style.inputName}>
                                        <label htmlFor="lastname">Apellido</label>
                                        <Field
                                            type="text"
                                            name="lastname"
                                            id="lastname"
                                            required
                                            data-testid="lastname"
                                        />
                                    </div>
                                    <div>
                                        {formik.errors.lastname && formik.touched.lastname && (
                                            <p className={style.error}>{formik.errors.lastname}</p>
                                        )}
                                    </div>
                                </section>
                            </div>
                            <section>
                                <div className={style.input}>
                                    <label htmlFor="email">Email</label>
                                    <Field
                                        type="email"
                                        name="email"
                                        id="email"
                                        required
                                        data-testid="email"
                                    />
                                </div>
                                <div>
                                    {formik.errors.email && formik.touched.email && (
                                        <p className={style.error}>{formik.errors.email}</p>
                                    )}
                                </div>
                            </section>

                            <section>
                                <div style={{ border: "0%" }}>
                                    <label
                                        htmlFor="password"
                                        style={{ fontWeight: " bold", fontSize: "0.75rem" }}
                                    >
                                        Contraseña
                                    </label>
                                    <div
                                        style={{
                                            backgroundColor: "white",
                                            height: "2.5rem",
                                            border: " 0",
                                            borderRadius: "4px",
                                            boxShadow: "0px 1px 5px rgba(0, 0, 0, 0.15)",
                                            textIndent: "8px",
                                            margin: "0.5rem 0",
                                        }}
                                    >
                                        <Field id="password" name="password">
                                            {({ field }) => (
                                                <div
                                                    style={{
                                                        display: "flex",
                                                        flexDirection: "row",
                                                        justifyContent: "space-between",
                                                    }}
                                                >
                                                    <input
                                                        {...field}
                                                        type={showPassword ? "text" : "password"}
                                                        aria-label="Contraseña"
                                                        style={{ boxShadow: "none", width: "100%" }}
                                                        data-testid='password'
                                                    />
                                                    <IconButton
                                                        onClick={() => setShowPassword(!showPassword)}
                                                        data-testid="password-visibility-button"
                                                        style={{
                                                            width: "2.5rem",
                                                            height: "2.5rem",
                                                            boxShadow: "none",
                                                            margin: "0 1rem",
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
                                    </div>
                                    <p className={style.error} data-testid="password-error"></p>
                                </div>
                                <div>
                                    {formik.errors.password && formik.touched.password && (
                                            <p className={style.error}>{formik.errors.password}</p>
                                        )}
                                </div>
                            </section>
                            <section>
                                <div className={style.input}>
                                    <label htmlFor="password2">Confirme su contraseña</label>
                                    <Field
                                        type="password"
                                        name="password2"
                                        id="password2"
                                        required
                                        data-testid="password2"
                                    />
                                </div>
                                <div>
                                    {errorForm ?
                                        (<p className={style.errorSubmit}>{errorForm}</p>) :
                                        (formik.errors.password2 && formik.touched.password2 && (
                                            <p className={style.error}>{formik.errors.password2}</p>
                                        ))
                                    }
                                </div>
                            </section>

                            <div
                                style={{
                                    display: "flex",
                                    flexDirection: "row",
                                    justifyContent: "center",
                                    paddingTop: "2rem",
                                    width: "100%",
                                    height: "2.5rem",
                                }}
                            >
                                <button
                                    type="submit"
                                    className={style.submitButton}
                                    data-testid="submit-button"
                                    disabled={!formik.isValid || formik.isSubmitting}
                                >
                                    {formik.isSubmitting ? "Cargando..." : "Crear cuenta"}
                                </button>
                            </div>
                        </Form>
                    )}
                </Formik>
                <p style={{ padding: "2.3rem 0" }} className={style.newAccount}>
                    <span style={{ fontWeight: "bold", width: "468px" }}>
                        ¿Ya tienes cuenta?&nbsp;
                    </span>
                    <Link to="/login">
                        Inicia sesión
                    </Link>
                </p>
            </div>
        </div>
    );
};

export default SignUp;
