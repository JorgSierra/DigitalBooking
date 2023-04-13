import React, { useState, useRef, useEffect } from "react";
import styles from "./ShareButton.module.css";
import ShareIcon from "@mui/icons-material/Share";
import ShareModal from "../shareModal/ShareModal";
import IconButton from '@mui/material/IconButton';

const ShareButton = ({ dataProductDetails, productDetailsPath, id }) => {
  const [isShown, setIsShown] = useState(false);
  const modalRef = useRef();

  const handleClick = () => {
    setIsShown(!isShown);
  };

  const closeModal = (e) => {
    if (e.target.closest(".modalButton")) {
      return;
    }
    if (modalRef.current && !modalRef.current.contains(e.target)) {
      setIsShown(false);
    }
  };

  useEffect(() => {
    if (isShown) {
      document.addEventListener("mousedown", closeModal);
    } else {
        document.removeEventListener("mousedown", closeModal);
    }
    return () => document.removeEventListener("mousedown", closeModal);
  }, [isShown]);

  return (
    <div className={styles.shareButtonContainer} ref={modalRef}>
      <IconButton className="modalButton" onClick={handleClick} data-testid='share-button'>
        <ShareIcon fontSize="medium" style={{ color: "var(--darkGrey)" }} />
      </IconButton>

      {isShown ? (
        <ShareModal
          dataProductDetails={dataProductDetails}
          productDetailsPath={productDetailsPath}
          setIsShown={setIsShown}
          modRef={modalRef}
          id={id}
        />
      ) : null}
    </div>
  );
};

export default ShareButton;
