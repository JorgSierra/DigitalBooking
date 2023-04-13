import React from "react";
import Paper from "@mui/material/Paper";
import MenuItem from "@mui/material/MenuItem";
import MenuList from "@mui/material/MenuList";
import Stack from "@mui/material/Stack";
import { Link } from "react-router-dom";
import styles from './Menu.module.css'

const Menu = ({ handleClose }) => {
  return (
    <Stack
      direction="column"
      spacing={2}
     className={styles.stack}
    >
      <Paper>
        <MenuList >
          <MenuItem>
            <Link to="/favorites" onClick={handleClose} style={{fontWeight:'bold'}}>
              Favoritos
            </Link>
          </MenuItem>
          <MenuItem>
            <Link to="/reserves/user" onClick={handleClose} style={{fontWeight:'bold'}}>
              Reservas
            </Link>
          </MenuItem>
        </MenuList>
      </Paper>
    </Stack>
  );
};

export default Menu;
