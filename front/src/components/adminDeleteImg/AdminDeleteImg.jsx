import React from "react";
import styles from '../adminAddImg/AdminAddImg.module.css';
import ClearIcon from "@mui/icons-material/Clear";

const AdminDeleteImg = ({ deleteImg, img }) => {
  return (
    <div  className={styles.addContainer}>
      <section className={styles.formInfo}>
        <div className={styles.formDivisions} style={{ width: "100%", display:'flex', flexDirection:'row', gap:'1.2rem'}}>
          <input type="text" name="image" disabled value={img.titulo} style={{width:'33.5%'}}/>
          <input type="text" name="image" disabled value={img.urlImg} style={{width:'66%'}}/>
        </div>
        <button type="button" className={styles.Btn} 
        onClick={()=>deleteImg(img)}
        >
          <ClearIcon
            style={{
              backgroundColor: "var(--darkGrey)",
              height: "2.5rem",
              width: "2.5rem",
              borderRadius: "4px",
              color: "white",
            }}
          />
        </button>
      </section>
    </div>
  );
};

export default AdminDeleteImg;
