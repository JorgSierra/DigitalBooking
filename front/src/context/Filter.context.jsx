import React, { createContext, useState } from "react";

export const FilterContext = createContext();

const FilterProvider = ({ children }) => {
  const [filterValue, setFilterValue] = useState(true);
  // console.log(arrayDates);

  return (
    <FilterContext.Provider 
    value={{ filterValue,  setFilterValue }}>
        {children}
    </FilterContext.Provider>
  );
};

export default FilterProvider;
