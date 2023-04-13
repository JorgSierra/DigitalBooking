import { useState } from "react";
import styles from "./AvailableDates.module.css";
import AddDates from "../addDates/AddDates";
import { useWindowSize } from "../../hooks/useWindowSize";
// import DatePickerDesktop from "../DEPRECATEDLASTdatePicker/DatePickerDesktop";
// import DatePickerMobile from "../DEPRECATEDLASTdatePicker/DatePickerMobile";
import DateCalendar from "../dateCalendar/DateCalendar";

const AvailableDates = ({dataProductDetails, datas}) => {
    // ------calendar----------------------------------
    const [isMobile, setIsMobile] = useState(false);
    const size = useWindowSize();

    return (
        <div className={styles.availableContainer}>
            <div className={styles.calendarContainer}>
                <h1>Fechas disponibles</h1>
                <div className={styles.componentsBox}>
                    <div className={styles.datePicker}>                        
                       <DateCalendar datas={datas}/> 
                    </div>
                    <AddDates className={styles.datePicker} {...dataProductDetails} />
                </div>
            </div>
        </div>
    );
};

export default AvailableDates;
