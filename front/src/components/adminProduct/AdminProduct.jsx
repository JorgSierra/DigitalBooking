import React, { useState, useEffect } from "react";
import styles from "./AdminProduct.module.css";
import { getData } from "../../services/api";
import {
  GET_ALL_LOCATIONS,
  GET_ALL_CATEGORIES_ENDPOINT,
} from "../../services/endpoints";
import LoadingSpinner from "../loadingSpinner/LoadingSpinner";

const AdminProduct = ({ values, errors, handleChange }) => {
  const [dataLocations, setdataLocations] = useState(null);
  const [dataCategory, setdataCategory] = useState(null);

  useEffect(() => {
    getData(GET_ALL_LOCATIONS, setdataLocations);
    getData(GET_ALL_CATEGORIES_ENDPOINT, setdataCategory);
  }, []);

  if (!dataLocations || !dataCategory) {
    return <LoadingSpinner />;
  }
  //validation
  const handleError = () => {
    seterrorCity(true);
  };
  return (
    <>
      <section className={styles.formInfo}>
        <div className={styles.formDivisions}>
          <label htmlFor="name">Nombre de la propiedad</label>
          <input
            type="text"
            name="name"
            placeholder="Nombre de la propiedad"
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
            placeholder="Titulo de la propiedad"
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
            onChange={handleChange}
            value={values.city}
            id={styles.arrowDiv}
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
            value={values.address}
            onChange={handleChange}
            placeholder="Direccion"
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
            value={values.price}
            onChange={handleChange}
            placeholder="$"
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
              value={values.latitud}
              onChange={handleChange}
              placeholder="10.15"
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
              value={values.longitud}
              onChange={handleChange}
              placeholder="45.55"
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
            value={values.distance}
            onChange={handleChange}
            placeholder="5 km"
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
          value={values.description}
          onChange={handleChange}
          className={styles.descriptionArea}
          placeholder="Descripción"
          error={errors.description}
        />
        {errors.description && (
          <div style={{ color: "red" }}>{errors.description}</div>
        )}
      </div>
    </>
  );
};

export default AdminProduct;
