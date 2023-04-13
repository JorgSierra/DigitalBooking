import React, { useState, useEffect } from "react";
import { getData, postDataWithToken } from "../../services/api";
import AdminAdd from "../adminAddAttributes/AdminAddAttributes";
import AdminAddImg from "../adminAddImg/AdminAddImg";
import AdminDeleteImg from "../adminDeleteImg/AdminDeleteImg";
import AdminPolitics from "../adminPolitics/AdminPolitics";
import AdminProduct from "../adminProduct/AdminProduct";
import styles from "./AdminForm.module.css";
import {
  GET_ALL_CHARACTERISTICS,
  GET_ALL_POLITICS,
  GET_ALL_LOCATIONS,
  POST_PRODUCT_ADMIN,
  POST_IMAGES,
  GET_ALL_CATEGORIES_ENDPOINT
} from "../../services/endpoints";
import LoadingSpinner from "../loadingSpinner/LoadingSpinner";
import { useFormik } from "formik";
import * as Yup from "yup";
import { useNavigate } from "react-router-dom";
import swal from "sweetalert";

const AdminForm = () => {
  const [isAddingImg, setisAddingImg] = useState(false);
  const [dataCharacteristics, setdataCharacteristics] = useState(null); //caracteristicas
  const [dataPolitics, setdataPolitics] = useState(null); //politicas
  const [attributes, setAttributes] = useState([]); //attributes
  const [politics, setPolitics] = useState([]); //productPolitics
  const [image, setImage] = useState([]);
  const [errorForm, setErrorForm] = useState("");
  const [dataLocations, setdataLocations] = useState(null);
  const [dataCategories, setDataCategories] = useState(null);

  const navigate = useNavigate();

  //----------------images----------------------------
   const deleteImg = (img) => {
    let newArray = image.filter((e) => e !== img);
    setImage(newArray);
  };

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

  useEffect(() => {
    getData(GET_ALL_CHARACTERISTICS, setdataCharacteristics),
      getData(GET_ALL_POLITICS, setdataPolitics);
      getData(GET_ALL_LOCATIONS, setdataLocations);
      getData(GET_ALL_CATEGORIES_ENDPOINT, setDataCategories)
  }, []);

  // form Validation
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

  const createImages = async (id) => {
    for (const img of image) {
      let dataImages = {
        "titulo": img.titulo,
        "urlImg": img.urlImg,
        "producto": id,
      };
      try {
        const response = await postDataWithToken(
          POST_IMAGES,
          dataImages
        );
        if (response && response.status === 201) {
          // setSubmitting(false);
          console.log("exito img");
        } else {
          console.log(response);
          swal(
            "Error!",
            "Lamentablemente no ha podido crearse un a imagen. Por favor, intente más tarde"
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
            "Lamentablemente no ha podido registrar img. Por favor, intente más tarde"
        );
          // setErrorForm(
          //   "Lamentablemente no ha podido registrar img. Por favor, intente más tarde"
          // );
        }
      }
    }
  };
  const attribute = attributes.map((element) => parseInt(element));
  const policies = politics.map((element) => parseInt(element));

  const productCreation = async (data) => {
    let locationId;
    console.log(data)
    if (data.city) {
      const foundLocation = dataLocations.find((obj) => obj.city === data.city);
      if (foundLocation) {
        locationId = foundLocation.id;
        console.log(locationId);
      }
    }

    let dataPost = {
      "nombre": data.name,
      "titulo": data.title,
      "descripcion": data.description,
      "precio": data.price,
      "latitud": data.latitud,
      "longitud": data.longitud,
      "distancia": data.distance,
      "direccion": data.address,
      "caracteristicas": attribute,
      "categoria": data.category,
      "politicas": policies,
      "ubicacion": data.city,
    };
    console.log(data.category)
   

    //POST
    try {
      console.log(dataPost);
      const response = await postDataWithToken(POST_PRODUCT_ADMIN, dataPost);

      if (response && response.status === 201) {
        // setSubmitting(false);

        console.log("exito");
        createImages(response.data.id);
        navigate("/verifiedProductCreation");
      } else {
        console.log(response);
        setErrorForm(
          "Lamentablemente no ha podido crearse un producto. Por favor, intente más tarde"
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
          "Lamentablemente no ha podido crearse un nuevo producto. Por favor, intente más tarde",
          "warning"
      );
      }
      // setSubmitting(false);
    }
    console.log(data, "submiting the form!");
  };

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
      // .min(3, "city must be 3 characters at minimum"),
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
        // .max(3,"latitud must be 3 numbers at max")
        .min(2, "latitud must be 2 numbers at minimum"),
      longitud: Yup.number()
        .required("Required")
        // .max(3,"longitud must be 3 numbers at max")
        .min(2, "longitud must be 2 numbers at minimum"),
      distance: Yup.number()
        .required("Required")
        // .max(3,"distance must be 3 numbers at max")
        .min(1, "distance must be 1 numbers at minimum"),
    }),
    validateOnChange: false,
  });

  //-----------spinner----------------------------------------
  if (!dataCharacteristics || !dataPolitics) {
    return <LoadingSpinner />;
  }

  return (
    <form className={styles.AdminForm} onSubmit={handleSubmit}>
      <>
        <AdminProduct
          values={values}
          errors={errors}
          handleChange={handleChange}
        />
      </>
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
      <>
        <h4>Cargar imágenes</h4>
        <AdminAddImg
          image={image}
          setImage={setImage}
        />       
        {image
          ? image.map((img, index) => {
              return (
                <div key={index}>
                  <AdminDeleteImg img={img} deleteImg={deleteImg} />
                </div>
              );
            })
          : null}
      </>
      <div className={styles.btnContainer}>
        <button className={styles.btn} type="submit">
          Crear
        </button>
      </div>
    </form>
  );
};

export default AdminForm;
