import React, { useState, useEffect, useContext } from "react";
import { useParams, useNavigate } from "react-router-dom";
import {
    getData,
    getDataWithToken,
    postDataWithToken,
} from "../../services/api";
import {
    GET_PRODUCT_BY_ID_ENDPOINT,
    GET_USER,
    replaceIdPlaceholder,
    GET_ALL_PRODUCT_RESERVES,
    POST_RESERVATION,
} from "../../services/endpoints";
import { useWindowSize } from "../../hooks/useWindowSize";
import styles from "./BlockReservation.module.css";
import DescriptionBar from "../descriptionBar/DescriptionBar";
import FormReservation from "../formReservation/FormReservation";
import BlockTimePicker from "../blockTimePicker/BlockTimePicker";
import UsagePolitics from "../usagePolitics/UsagePolitics";
import CardReservation from "../cardReservation/CardReservation";
import LoadingSpinner from "../loadingSpinner/LoadingSpinner";
import { useFormik } from "formik";
import * as Yup from "yup";
import DateReservations from '../dateReservations/DateReservations'
import { decodeToken } from "../../utils/utils";
import FormCovid from "../formCovidReservations/FormCovid";
import { DatesContext } from "../../context/Dates.context";
import swal from "sweetalert";

const BlockReservation = () => {
    const { id } = useParams();
    const [isMobile, setIsMobile] = useState(false);
    const [dataProductDetails, setDataProductDetails] = useState(null);
    const [datas, setDatas] = useState([]);
    const [date, setDate] = useState(new Date()); //calendar
    const [isSubmited, setisSubmited] = useState(false);
    const [token, setToken] = useState("");
    const [decodedToken, setDecodedToken] = useState("");
    const endpoint = replaceIdPlaceholder(GET_PRODUCT_BY_ID_ENDPOINT, id);
    const urls = replaceIdPlaceholder(GET_ALL_PRODUCT_RESERVES, id);
    const [userData, setUserData] = useState({});
    const [userPath, setUserPath] = useState();
    const [hasCovidVaccine, setHasCovidVaccine] = useState(false);
    const { arrayDates } = useContext(DatesContext);
    const [errorForm, setErrorForm] = useState("");
    const [errorDate, setErrorDate] = useState(false);
    const [errorSingleDate, setErrorSingleDate] = useState(false);
    const [loadingForm, setLoadingForm] = useState(false);

    const navigate = useNavigate();

    useEffect(() => {
        getData(endpoint, setDataProductDetails);
        getData(urls, setDatas);
        getData(endpoint, setDataProductDetails);
        const token = JSON.parse(localStorage.getItem("jwt"));
        setToken(token);
        return () => {
            setErrorDate(false);
        };
    }, []);

    useEffect(() => {
        if (token) {
            decodeToken(token, setDecodedToken);
        }
    }, [token]);

    useEffect(() => {
        if (decodedToken) {
            setUserPath(replaceIdPlaceholder(GET_USER, decodedToken.id));
        }
    }, [decodedToken]);

    useEffect(() => {
        if (userPath) {
            getDataWithToken(userPath, setUserData);
        }
    }, [userPath]);

    useEffect(() => { }, [isSubmited]);

    //------------------form Validation-----------------------------
    let initialValues = {
        city: "",
        time: "",
        comments: "",
    };

    const putCityUser = async () => {
        let dataUsuario = {
            id: decodedToken.id,
            nombre: decodedToken.name,
            apellido: decodedToken.lastname,
            email: decodedToken.sub,
            password: decodedToken, //faltaaaa
            ciudad: values.city,
            rol: decodedToken.token,
        };

        //POST
        // try {
        //   const response = await postDataWithToken(POST_RESERVATION, dataUsuario);

        //   if (response && response.status === 201) {
        //     // setSubmitting(false);
        //     navigate("/verifiedReservation");
        //     console.log("Reserva agregada con éxito.");
        //   } else {
        //     console.log(response);
        //     setErrorForm(
        //       "Lamentablemente no ha podido crearse una Reserva. Por favor, intente más tarde" // <AlertReservation />
        //     );
        //   }
        //   // setSubmitting(false);
        // } catch (error) {
        //   if (error.message === "Bad Request") {
        //     setErrorForm("Error en request recibido.");
        //   } else if (error.message === "Request conflict") {
        //     setErrorForm(
        //       "El usuario que intentó registrar tiene un correo ya registrado."
        //     );
        //   } else {
        //     setErrorForm(
        //       "Lamentablemente no ha podido crearse una Reserva. Por favor, intente más tarde"
        //     );
        //   }
        //   // setSubmitting(false);
        // }
    };

    const createReservation = async (data) => {
        if (!arrayDates[0] || !arrayDates[1]) {
            setErrorSingleDate(true);
            return;
        }

        // const timeFormat = data.time.replace(":", "-");
        const startDateFormat = arrayDates[0].replace(/\//g, "-");
        const endDateFormat = arrayDates[1].replace(/\//g, "-");
        const dateRangeStart = new Date(startDateFormat);
        const dateRangeEnd = new Date(endDateFormat);

        for (let i = 0; i < datas.length; i++) {
            const fechaInicio = new Date(datas[i].fechaInicio);
            const fechaFin = new Date(datas[i].fechaFin);

            // loop through each date between fechaInicio and fechaFin
            for (let d = fechaInicio; d <= fechaFin; d.setDate(d.getDate() + 1)) {
                const currentDate = new Date(d);
                if (currentDate >= dateRangeStart && currentDate <= dateRangeEnd) {
                    setErrorDate(true);
                    return;
                }
            }
        }

        let dataPost = {
            horaInicio: `${data.time}`,
            fechaInicio: `${startDateFormat}`,
            fechaFin: `${endDateFormat}`,
            datosVendedor: `${data.comments}`,
            vacunaCovid: !!hasCovidVaccine,
            producto: parseInt(dataProductDetails.id), //id
            usuario: parseInt(decodedToken.id), //id
        };

        //POST
        try {
            setErrorDate(false);
            setErrorSingleDate(false);
            setLoadingForm(true)
            const response = await postDataWithToken(POST_RESERVATION, dataPost);

            if (response && response.status === 201) {
                // setSubmitting(false);
                console.log("Reserva agregada con éxito.");
                navigate("/verifiedReservation");
            } else {
                setLoadingForm(false);
                setErrorForm(
                    "Lamentablemente no ha podido crearse una Reserva. Por favor, intente más tarde" //
                );
            }
            // setSubmitting(false);
        } catch (error) {
            if (error.message === "Bad Request") {
                setLoadingForm(false);
                setErrorForm("Error en request recibido.");
            } else if (error.message === "Request conflict") {
                setLoadingForm(false);
                swal(
                    "Error!",
                    "El usuario que intentó registrar tiene un correo ya registrado."
                );
            } else {
                setLoadingForm(false);
                swal(
                    "Error!",
                    "Lamentablemente no ha podido crearse una Reserva. Por favor, intente más tarde",
                    "warning"
                );
            }
            // setSubmitting(false);
        }
        setLoadingForm(false);
        console.log(dataPost, "submiting the form!");
    };

    const { handleChange, handleSubmit, values, errors } = useFormik({
        initialValues: initialValues,

        onSubmit: createReservation,

        validationSchema: Yup.object().shape({
            city: Yup.string()
                .min(3, "City must be 3 characters at minimum")
                .required("city is required"),
            time: Yup.string()
                .min(3, "time must be 3 characters at minimum")
                .required("time is required"),
            comments: Yup.string()
                .required("comments is required")
                .min(10, "comments must be 10 characters at minimum"),
        }),
        validateOnChange: false,
    });

    // calendar
    const size = useWindowSize();

    if (!dataProductDetails) {
        return <LoadingSpinner />;
    }

    if (loadingForm) {
        return <LoadingSpinner />;
    }

    return (
        <form onSubmit={handleSubmit} className={styles.reservationForm}>
            <div className={styles.backgroundContainer}>
                <div className={styles.containerReservation}>
                    <DescriptionBar {...dataProductDetails} />
                    <div
                        style={{
                            margin: "1rem 3vw",
                            backgroundColor: "#eeb5b5",
                            textAlign: "center",
                        }}
                    >
                        {errors.city && (
                            <div style={{ color: "red", padding: "0.5rem" }}>
                                Introduzca su ciudad
                            </div>
                        )}
                        {errors.time && (
                            <div style={{ color: "red", padding: "0.5rem" }}>
                                Introduzca un horario de inicio
                            </div>
                        )}
                        {errors.comments && (
                            <div style={{ color: "red", padding: "0.5rem" }}>
                                Introduzca un comentario para el vendedor
                            </div>
                        )}
                        {errorDate && (
                            <div style={{ color: "red", padding: "0.5rem" }}>
                                El rango de fechas que selecciono posee fechas no disponibles
                            </div>
                        )}
                        {errorSingleDate && (
                            <div style={{ color: "red", padding: "0.5rem" }}>
                                Por favor seleccione dos fechas.
                            </div>
                        )}
                    </div>
                    <h1 className={styles.userData}>Completá tus datos</h1>
                    <section className={styles.bodyContainer}>
                        <div className={styles.formContainer}>
                            <FormReservation
                                values={values}
                                errors={errors}
                                handleChange={handleChange}
                                userData={userData}
                            />
                        </div>
                        <div className={styles.dateContainer}>
                            <h2 className={styles.reserveDateTitle}>
                                Seleccioná tu fecha de reserva
                            </h2>
                            <DateReservations datas={datas} />
                        </div>
                        <div className={styles.timeContainer}>
                            <h2>Tu horario de llegada</h2>
                            <BlockTimePicker
                                values={values}
                                errors={errors}
                                handleChange={handleChange}
                            />
                        </div>
                        <div className={styles.cardContainer}>
                            <CardReservation
                                dataProductDetails={dataProductDetails}
                                values={values}
                            />
                        </div>
                        <div className={styles.covid}>
                            <FormCovid
                                values={values}
                                errors={errors}
                                handleChange={handleChange}
                                hasCovidVaccine={hasCovidVaccine}
                                setHasCovidVaccine={setHasCovidVaccine}
                            />
                        </div>
                    </section>
                </div>
            </div>
            <UsagePolitics {...dataProductDetails} />
        </form>
    );
};

export default BlockReservation;
