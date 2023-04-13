import React, {useState} from "react";
import { Link } from "react-router-dom";
import AdminTitle from "../adminTittle/AdminTitle";
import AdminProductTable from "../adminProductTable/AdminProductTable";
import AddIcon from "@mui/icons-material/Add";
import styles from "./BlockAdminProductTable.module.css";

const BlockAdminProductTable = () => {
  const [sentData, setsentData] = useState(0)
  return (
    <div className={styles.adminBlock}>
      <AdminTitle />
      <Link to="/administration" className={styles.link}>
        Agregar Producto <AddIcon />
      </Link>
      <div className={styles.productsTable}>
        <AdminProductTable sentData={sentData} setsentData={setsentData}/>
      </div>
    </div>
  );
};

export default BlockAdminProductTable;
