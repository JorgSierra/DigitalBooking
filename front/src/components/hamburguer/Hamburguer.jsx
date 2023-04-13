import React from "react";
import HamburguerNoLogged from "../hamburguerNoLogged/HamburguerNoLogged";
import HamburguerLoggedIn from "../hamburguerLoggerIN/HamburguerLoggedIn";

const Hamburguer = ({ handleClose, loggedIn }) => {
  return (
    <>
      {loggedIn ? (
        <HamburguerLoggedIn handleClose={handleClose} />
      ) : (
        <HamburguerNoLogged handleClose={handleClose} />
      )}
    </>
  );
};

export default Hamburguer;
