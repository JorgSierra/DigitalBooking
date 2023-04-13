import React, { useState } from "react";
const format = "HH:mm";
import "./TimePickerComponent.css";

const TimePickerComponent = ({ values, errors, handleChange }) => {

  return (
    <>
      <input
        placeholder="Seleccionar hora de llegada"
        type="time"
        name="time"
        value={values.time}
        onChange={handleChange}
        style={{ padding: "0.7rem 1.7rem" }}
      />
      {/* {errors.time && (
        <div style={{ color: "red" }}>
          {errors.time}
        </div>
      )} */}
    </>
  );
};

export default TimePickerComponent;
