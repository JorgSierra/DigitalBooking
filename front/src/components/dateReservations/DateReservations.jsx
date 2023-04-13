import React, { useContext } from "react";
import { Calendar } from "react-multi-date-picker";
import "./DateReservations.css";
import dayjs from "dayjs";
import isBetween from "dayjs/plugin/isBetween";
import { DatesContext } from "../../context/Dates.context";
import { useWindowSize } from "../../hooks/useWindowSize";

dayjs.extend(isBetween);

const DateReservations = ({ datas }) => {
  const { valueDate, setValueDate } = useContext(DatesContext);

  const reservedDates = [];
  datas.map((data) => {
    return reservedDates.push({ start: data.fechaInicio, end: data.fechaFin });
  });

  const size = useWindowSize();
  return (
    <>
      <Calendar
        mapDays={({ date }) => {
          if (dayjs(date).isBefore(dayjs(), "day")) {
            return {
              disabled: true,
              style: { color: "#ccc" },
              onClick: () => alert("Esta fecha no esta disponible"),
            };
          } //para fechas antes del dia de hoy

          for (let i = 0; i < reservedDates.length; i++) {
            const { start, end } = reservedDates[i];
            if (
              dayjs(date).isSame(start, "day") ||
              dayjs(date).isSame(end, "day") ||
              dayjs(date).isBetween(start, end, null, "[]")
            ) {
              return {
                disabled: true,
                style: { color: "#ccc" },
                onClick: () => alert("Esta fecha no esta disponible!"),
              };
            }
          }
        }}
        className="custom-calendar"
        value={valueDate}
        onChange={(e) => setValueDate(e)}
        numberOfMonths={size.width > 700 ? 2 : 1}
        format="Date:YYYY/MM/DD"
        range={true}
        rangeHover
      />
    </>
  );
};

export default DateReservations;
