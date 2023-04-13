import React, { createContext, useState } from "react";
import {  DateObject } from "react-multi-date-picker";
export const DatesContext = createContext();

const DatesProvider = ({ children }) => {
  const [valueDate, setValueDate] = useState([new DateObject(), new DateObject()]);
  const date1=valueDate[0]?.format().split(':')[1];
  const date2=valueDate[1]?.format().split(':')[1];
  const arrayDates = [date1, date2]
  // console.log(arrayDates);

  return (
    <DatesContext.Provider 
    value={{ valueDate,  setValueDate, arrayDates }}>
        {children}
    </DatesContext.Provider>
  );
};

export default DatesProvider;
