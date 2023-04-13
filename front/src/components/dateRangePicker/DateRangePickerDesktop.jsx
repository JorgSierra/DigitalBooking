import React, { useState, useEffect } from "react";
import { DatePickerInput } from "@mantine/dates";
import CalendarMonthIcon from '@mui/icons-material/CalendarMonth';
import { useWindowSize } from "../../hooks/useWindowSize"
import './DateRangePickerDesktop.css'

const DateRangePickerDesktop = ({ onDateChange }) => {
    // const [value, setValue] = useState<[Date | null, Date | null]>([null, null]);
    const [columns, setColumns] = useState("")

    const size = useWindowSize();

    /*useEffect(() => {
        if (size.width > 600) {
            setColumns(2);
            forceUpdate()
        } else {
            setColumns(1);
            forceUpdate()
        }
    }, [size.widt]);*/

    return (
        <DatePickerInput
            icon={<CalendarMonthIcon size="1.1rem" stroke={1.5} />}
            type="range"
            numberOfColumns={size.width > 700 ? 2 : 1}
            aria-label="Check in - Check out"
            placeholder="Check in - Check out"
            //   value={value}
            onChange={onDateChange}
            mx="auto"
            maw={400}
            radius={'sm'}
            size={size.width > 700 ? "md" : "sm"}
            valueFormat="YYYY/MM/DD"
        // excludeDate
        // minDate={new Date(2022, 1, 1)}
        // maxDate={new Date(2022, 8, 1)}
        />
    );
};

export default DateRangePickerDesktop;
