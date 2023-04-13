import React, { useState, useEffect } from "react";
import styles from "./AdminEditForm.module.css";
import { editDataWithToken, getData } from "../../services/api";
import {
  GET_ALL_CATEGORIES_ENDPOINT,
  PUT_PRODUCT_ADMIN,
  GET_PRODUCT_BY_ID,
  GET_ALL_LOCATIONS,
  GET_ALL_CHARACTERISTICS,
  GET_ALL_POLITICS,
} from "../../services/endpoints";
import { replaceIdPlaceholder } from "../../services/endpoints";
import LoadingSpinner from "../loadingSpinner/LoadingSpinner";
import AdminAdd from "../adminAddAttributes/AdminAddAttributes";
import AdminPolitics from "../adminPolitics/AdminPolitics";
import { useParams } from "react-router-dom";
import { useFormik } from "formik";
import * as Yup from "yup";
import swal from "sweetalert";
import { useNavigate } from "react-router-dom";
import {scrollToTop} from '../../utils/utils'

const AdminEditForm = ({setsentData, sentData}) => {
  const [dataLocations, setdataLocations] = useState(null);
  const [dataCategory, setdataCategory] = useState(null);
  const [dataCharacteristics, setdataCharacteristics] = useState(null); //caracteristicas
  const [dataPolitics, setdataPolitics] = useState(null); //politicas
  const [politics, setPolitics] = useState([]); //productPolitics
  const [dataProductWithId, setdataProductWithId] = useState(null);
  const [attributes, setAttributes] = useState([]); //attributes
  const [errorForm, setErrorForm] = useState("");

  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    getData(GET_ALL_LOCATIONS, setdataLocations);
    getData(GET_ALL_CATEGORIES_ENDPOINT, setdataCategory);
    getData(GET_ALL_CHARACTERISTICS, setdataCharacteristics);
    getData(GET_ALL_POLITICS, setdataPolitics);
    getData(replaceIdPlaceholder(GET_PRODUCT_BY_ID, id), setdataProductWithId);
  }, []);

  //------------------attributes-----------------------------
  const handleAttribute = (e) => {
    setAttributes([...attributes, e.target.value]);
    const filteredAttributes = attributes.filter(
      (attribute) => attribute !== e.target.value
    );
  };

  //------------------politics--------------------------------
  const handlePolitics = (e) => {
    setPolitics([...politics, e.target.value]);

    const filteredPolitics = politics.filter(
      (politic) => politic !== e.target.value
    );
  };
  //----------form validation-------

  let initialValues = {
    name: "",
    title: "",
    description: "",
    price: "",
    latitud: "",
    longitud: "",
    distance: "",
    address: "",
    category: "",
    city: "",
  };

  //----send -> PUT----------------
  const attribute = attributes.map((element) => parseInt(element));
  const policies = politics.map((element) => parseInt(element));

  const productCreation = async (data) => {
    let locationId;
    // console.log(data);
    if (data.city) {
      const foundLocation = dataLocations.find((obj) => obj.city === data.city);
      if (foundLocation) {
        locationId = foundLocation.id;
        console.log(locationId);
      }
    }

    let dataPut = {
      id: id,
      nombre: data.name,
      titulo: data.title,
      descripcion: data.description,
      precio: data.price,
      latitud: data.latitud,
      longitud: data.longitud,
      distancia: data.distance,
      direccion: data.address,
      caracteristicas: attribute,
      categoria: data.category,
      politicas: policies,
      ubicacion: data.city,
    };
    // console.log(data);

    //POST
    try {
      console.log(dataPut);
      const response = await editDataWithToken(PUT_PRODUCT_ADMIN, dataPut);
      // console.log(response)
      if (response && response.status === 204) {
        // setsentData(sentData + 1);
        // setSubmitting(false);
        console.log("exito");
        navigate('/adminTable');        
        swal({
          title: "Producto actualizado con exito",
          icon: "success",
          // buttons: true,
          dangerMode: true,
        });
      } else {
        // console.log(response);
        swal(
          "Error!",
          "Lamentablemente no se ha podido editar el producto. Por favor, intente más tarde",
          "warning"
        );
      }
      // setSubmitting(false);
    } catch (error) {
      if (error.message === "Bad Request") {
        setErrorForm("Error en request recibido.");
      } else if (error.message === "Request conflict") {
        swal(
          "Error!",
          "El usuario que intentó registrar tiene un correo ya registrado."
        );
      } else {
        swal(
          "Error!",
          "Lamentablemente no ha podido editarse el producto. Por favor, intente más tarde",
          "warning"
        );
      }
      // setSubmitting(false);
    }
    console.log("submiting the form!");
  };
  //----formik---------------------------
  const { handleChange, handleSubmit, values, errors } = useFormik({
    initialValues: initialValues,

    onSubmit: productCreation,

    validationSchema: Yup.object().shape({
      name: Yup.string()
        .required("Required")
        .min(3, "name must be 3 characters at minimum"),
      category: Yup.string().required("Required"),
      address: Yup.string()
        .required("Required")
        .min(3, "address must be 3 characters at minimum"),
      city: Yup.number().required("Required"),
      description: Yup.string()
        .required("Required")
        .min(10, "description must be 10 characters at minimum"),
      title: Yup.string()
        .required("Required")
        .min(3, "title must be 3 characters at minimum"),
      price: Yup.number()
        .required("Required")
        .min(3, "price must be 3 numbers at minimum"),
      latitud: Yup.number()
        .required("Required")
        .min(2, "latitud must be 2 numbers at minimum"),
      longitud: Yup.number()
        .required("Required")
        .min(2, "longitud must be 2 numbers at minimum"),
      distance: Yup.number()
        .required("Required")
        .min(1, "distance must be 1 numbers at minimum"),
    }),
    validateOnChange: false,
  });
  //-----------------------------spiner-------------------------
  if (
    !dataLocations ||
    !dataCategory ||
    !dataCharacteristics ||
    !dataPolitics ||
    !dataProductWithId
  ) {
    return <LoadingSpinner />;
  }

  //   console.log(dataProductWithId);
  return (
    <form className={styles.AdminForm} onSubmit={handleSubmit}>
      <div>
        <div className={styles.idInput}>
          <label htmlFor="id">Id</label>
          <input
            type="text"
            name="id"
            placeholder="Id"
            onChange={handleChange}
            value={id}
            readOnly={true}
            disabled
          />
        </div>
        <section className={styles.formInfo}>
          <div className={styles.formDivisions}>
            <label htmlFor="name">Nombre de la propiedad</label>
            <input
              type="text"
              name="name"
              placeholder={dataProductWithId.nombre}
              onChange={handleChange}
              value={values.name}
              error={errors.name}
            />
            {errors.name && <div style={{ color: "red" }}>{errors.name}</div>}
          </div>
          <div className={styles.formDivisions}>
            <label htmlFor="category">Categoria</label>
            <select
              name="category"
              id={styles.arrowDiv}
              value={values.category}
              onChange={handleChange}
              error={errors.category}
            >
              <option value="" disabled hidden>
                Categoria
              </option>
              {dataCategory.map((data) => {
                return (
                  <option key={data.id} value={data.id}>
                    {data.titulo}
                  </option>
                );
              })}
            </select>
            {errors.category && (
              <div style={{ color: "red" }}>{errors.category}</div>
            )}
          </div>
        </section>

        <section className={styles.formInfo}>
          <div className={styles.formDivisions}>
            <label htmlFor="title">Titulo de la propiedad</label>
            <input
              type="text"
              name="title"
              placeholder={dataProductWithId.titulo}
              onChange={handleChange}
              value={values.title}
              error={errors.title}
            />
            {errors.title && <div style={{ color: "red" }}>{errors.title}</div>}
          </div>
          <div className={styles.formDivisions}>
            <label htmlFor="city">Ciudad</label>
            <select
              name="city"
              placeholder="Ciudad"
              id={styles.arrowDiv}
              onChange={handleChange}
              value={values.city}
              error={errors.city}
            >
              <option value="" disabled hidden>
                Ciudad
              </option>
              {dataLocations.map((data) => {
                return (
                  <option key={data.id} value={data.id}>
                    {data.ciudad}
                  </option>
                );
              })}
            </select>
            {errors.city && <div style={{ color: "red" }}>{errors.city}</div>}
          </div>
        </section>

        <section className={styles.formInfo}>
          <div className={styles.formDivisions}>
            <label htmlFor="address">Direccion</label>
            <input
              type="text"
              name="address"
              placeholder={dataProductWithId.direccion}
              value={values.address}
              onChange={handleChange}
              error={errors.address}
            />
            {errors.address && (
              <div style={{ color: "red" }}>{errors.address}</div>
            )}
          </div>
          <div className={styles.formDivisions}>
            <label htmlFor="price">Precio</label>
            <input
              type="number"
              name="price"
              placeholder={dataProductWithId.precio}
              value={values.price}
              onChange={handleChange}
              error={errors.price}
            />
            {errors.price && <div style={{ color: "red" }}>{errors.price}</div>}
          </div>
        </section>

        <section className={styles.formInfo}>
          <div
            style={{
              display: "flex",
              flexDirection: "row",
              width: "50%",
              gap: "1rem",
            }}
          >
            <div className={styles.formDivisions}>
              <label htmlFor="latitud">Latitud</label>
              <input
                type="number"
                name="latitud"
                placeholder={dataProductWithId.latitud}
                value={values.latitud}
                onChange={handleChange}
                error={errors.latitud}
              />
              {errors.latitud && (
                <div style={{ color: "red" }}>{errors.latitud}</div>
              )}
            </div>
            <div className={styles.formDivisions}>
              <label htmlFor="longitud">Longitud</label>
              <input
                type="number"
                name="longitud"
                placeholder={dataProductWithId.longitud}
                value={values.longitud}
                onChange={handleChange}
                error={errors.longitud}
              />
              {errors.longitud && (
                <div style={{ color: "red" }}>{errors.longitud}</div>
              )}
            </div>
          </div>
          <div className={styles.formDivisions}>
            <label htmlFor="distance">Distancia al Centro</label>
            <input
              type="number"
              name="distance"
              placeholder={dataProductWithId.distancia}
              value={values.distance}
              onChange={handleChange}
              error={errors.distance}
            />
            {errors.distance && (
              <div style={{ color: "red" }}>{errors.distance}</div>
            )}
          </div>
        </section>

        <div className={styles.textareaContainer}>
          <label htmlFor="city">Descripción</label>
          <textarea
            name="description"
            className={styles.descriptionArea}
            placeholder={dataProductWithId.descripcion}
            value={values.description}
            onChange={handleChange}
            error={errors.description}
          />
          {errors.description && (
            <div style={{ color: "red" }}>{errors.description}</div>
          )}
        </div>
        <>
          <h2>Agregar atributos</h2>
          <div className={styles.isAdding}>
            {dataCharacteristics.map((data) => {
              return (
                <AdminAdd
                  data={data}
                  key={data.id}
                  handleAttribute={handleAttribute}
                />
              );
            })}
          </div>
        </>
        <h3>Políticas del producto</h3>
        <div className={styles.politicsContainer}>
          {dataPolitics.map((data) => {
            return (
              <AdminPolitics
                data={data}
                key={data.id}
                handlePolitics={handlePolitics}
              />
            );
          })}
        </div>
      </div>
      <div className={styles.btnContainer}>
        <button type="submit" className={styles.btn} onClick={scrollToTop}>
          Guardar
        </button>
      </div>
    </form>
  );
};

export default AdminEditForm;
