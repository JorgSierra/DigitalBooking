import React, { useState, useContext } from "react";
import DatePicker, { DateObject } from "react-multi-date-picker";
import { useWindowSize } from "../../hooks/useWindowSize";
import dayjs from "dayjs";
import isBetween from "dayjs/plugin/isBetween";
import "./DateHome.css";
import { DatesContext } from "../../context/Dates.context";


dayjs.extend(isBetween);

const DateHome = ({ onDateChange }) => {
  const { valueDate, setValueDate } = useContext(DatesContext);  

  // function handleSubmit() {
  //   if (values instanceof DateObject) values = values.toDate();
  //   submitDate(values);
  // }

  /*

        <button 
        type="button"
        className="btnSubmit"
        onClick={setValueDate([])}
        >
          Borrar
        </button>

  */
  const size = useWindowSize();
  return (
    <div id='dateHome'>
      <DatePicker
        mapDays={({ date }) => {
          if (dayjs(date).isBefore(dayjs(), "day")) {
            return {
              disabled: true,
              style: { color: "#ccc" },
              onClick: () => alert("Esta fecha no esta disponible"),
            };
          } //para fechas antes del dia de hoy
        }}
        // render={<InputIcon/>}
        style={{
          width: "100%",
          boxSizing: "border-box",
        }}
        containerStyle={{
          width: "100%",
          borderRadius:'5px'        }}
        className="custom-datePicker"
        inputClass="custom-input"
        placeholder="Check in - Check out"
        format="YYYY/MM/DD"
        values={valueDate}
        onChange={onDateChange}
        numberOfMonths={size.width > 700 ? 2 : 1}
        range={true}
        rangeHover={true}
        buttons={true}
        arrow={false}

      >
      </DatePicker>
    </div >
  );
};

export default DateHome;
