import React, { useState } from "react";
import { DatePickerInput } from "@mantine/dates";
import CalendarMonthIcon from '@mui/icons-material/CalendarMonth';
import './DateRangePickerDesktop.css'

const DateRangePickerMobile = () => {
  
        // const [value, setValue] = useState<[Date | null, Date | null]>([null, null]);
    
      return (
        <DatePickerInput 
          icon={<CalendarMonthIcon size="1.1rem" stroke={1.5} />}
          type="range"
          numberOfColumns={1}
          aria-label="Check in - Check out" 
          placeholder="Check in - Check out"
        //   value={value}
        //   onChange={setValue}
          mx="auto"
          maw={400}
          radius={'sm'}
          size={'sm'}
          valueFormat="YYYY/MM/DD"
        />
      );
}

export default DateRangePickerMobile