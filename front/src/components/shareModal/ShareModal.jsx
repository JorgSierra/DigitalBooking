import React from "react";
import styles from "./ShareModal.module.css";
import { ShareSocial } from "react-share-social";

const style = {
  root: {
    backgroundColor: "black",
    opacity: "0.8",
    borderRadius:' 5px',
    border: 0,
    boxShadow: "0px 4px 4px rgba(0, 0, 0, 0.25)",
    color: "white",
    padding: "0.4rem",
    maxWidth: "none",
    minWidth: "none",
    width: "100%",
  },
  copyContainer: {
    border: "1px solid black",
  },
  iconContainer: {},
};

const ShareModal = ({ id, setIsShown, modRef }) => {
  function handleClose() {
    setIsShown(false);
  }
  const url =
    "http://equipo10-digitalbooking-frontend.s3-website.us-east-2.amazonaws.com/#/productDetails/" +
    id;
  // console.log(url);

  return (
    <div className={styles.shareModalContainer} ref={modRef}>
      <section
        style={{ display: "flex", flexDirection: "column", gap: "0.5rem" }}
      >
        <h1 data-testid="share-h1">Compartir via</h1>
        <p data-testid="share-p">Click en uno de los iconos para compartir</p>
      </section>
      <section className={styles.media}>
        <ShareSocial
          url={url}
          socialTypes={["facebook", "twitter", "reddit", "linkedin", "email"]}
          onSocialButtonClicked={(data) => console.log(data)}
          style={style}
        />
      </section>
      <button
        data-testid="share-cancelButton"
        className={styles.cancelButton}
        onClick={handleClose}
      >
        Cancelar
      </button>
    </div>
  );
};

export default ShareModal;
