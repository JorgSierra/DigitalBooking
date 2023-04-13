import React, { useState } from "react";
import { IconButton } from "@mui/material";
import EditIcon from "@mui/icons-material/Edit";
import swal from "sweetalert";
import { useNavigate } from "react-router-dom";
import styles from '../iconDelete/IconDelete.module.css'

const IconEdit = ({ data }) => {
    const navigate = useNavigate()
  
 
  const handleEdit = () => {
    swal({
      title: "Desesa editar el producto?",
      icon: "info",
      // buttons: true,
      dangerMode:true,
    }).then(function () {
      // console.log("dentro")
      navigate(`/adminEditProduct/${data.id}`)
    });
  };
  // console.log(data)
  if (!data) {
    return
  }

  return (
    <IconButton onClick={handleEdit}>
      <EditIcon className={styles.icon}/>
    </IconButton>
  );
};

export default IconEdit;
