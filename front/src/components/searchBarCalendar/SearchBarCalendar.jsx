import React from "react"
import styles from "./SearchBarCalendar.module.css"
// import DateRangePickerDesktop from "../dateRangePicker/DateRangePickerDesktop"
// import DateRangePickerMobile from "../dateRangePicker/DateRangePickerMobile"
import DateHome from "../dateHome/DateHome"

const SearchBarCalendar = ({ dates, onDateChange }) => {

    //const size = useWindowSize();

    //console.log(size.width)

    return (
        <section className={styles.inputCalendar} data-testid='searchBar-calendar'>
            <div className={styles.iconDiv}>
                <DateHome
                 data-testid='desktop-calendar'
                 dates={dates}
                 onDateChange={onDateChange}/>
                {/* <DateRangePickerDesktop
                    data-testid='desktop-calendar'
                    dates={dates}
                    onDateChange={onDateChange}
                /> */}
            </div>
        </section>
    )
}

export default SearchBarCalendar