import React from "react";
import { IconButton } from "@mui/material";
import DeleteIcon from "@mui/icons-material/Delete";
import swal from "sweetalert";
import { DELETE_PRODUCTS_ID, replaceIdPlaceholder } from "../../services/endpoints";
import { deleteDataWithTokenAndNoBody } from "../../services/api";
import styles from './IconDelete.module.css'

const IconDelete = (props) => {

    const { data, database, setDatabase } = props || {}

    const handleDelete = () => {
        const path = replaceIdPlaceholder(DELETE_PRODUCTS_ID, data.id);
        swal({
            title: "Está seguro de que quiere eliminar el producto?",
            text: "Tan pronto de click en borrar no podrá recuperar el producto",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        }).then(async (result) => {
            if (result) {
                try {
                    const response = await deleteDataWithTokenAndNoBody(path)
                    if (response && response.status === 200) {
                        swal("Eliminado!", "El producto ha sido eliminada", "success");
                        setDatabase(database + 1);
                    }
                } catch (error) {
                    swal("Error", "No se pudo eliminar el producto", "error");
                }
            }
        });
    };

    return (
        <IconButton onClick={handleDelete}>
            <DeleteIcon  className={styles.icon}/>
        </IconButton>
    );
};

export default IconDelete;
