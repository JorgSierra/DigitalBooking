import React, { Children } from 'react'
import styles from "./ResponsiveTemplate.module.css"

const ResponsiveTemplate = (props) => {
    return (
        <div className={styles.responsiveTemplateContainer}>
            {props.children}
        </div>
    )
}

export default ResponsiveTemplate