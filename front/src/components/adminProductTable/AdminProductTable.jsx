import React, { useEffect, useState } from "react";
import { styled } from "@mui/material/styles";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell, { tableCellClasses } from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { getData } from "../../services/api";
import { GET_ALL_PRODUCTS_ENDPOINT } from "../../services/endpoints";
import LoadingSpinner from "../loadingSpinner/LoadingSpinner";
import TablePagination from "@mui/material/TablePagination";
import IconEdit from "../iconEdit/IconEdit";
import IconDelete from "../iconDelete/IconDelete";

const StyledTableCell = styled(TableCell)(({ theme }) => ({
  [`&.${tableCellClasses.head}`]: {
    backgroundColor: theme.palette.common.black,
    color: theme.palette.common.white,
  },
  [`&.${tableCellClasses.body}`]: {
    fontSize: 14,
  },
}));

const StyledTableRow = styled(TableRow)(({ theme }) => ({
  "&:nth-of-type(odd)": {
    backgroundColor: theme.palette.action.hover,
  },
  // hide last border
  "&:last-child td, &:last-child th": {
    border: 0,
  },
}));

const AdminProductTable = () => {
  const [dataProducts, setdataProducts] = useState(null);
  const [page, setPage] = useState(0);
  const [rowsPerPage, setRowsPerPage] = useState(10);
  const [databaseChanges, setDatabaseChanges] = useState(0);

  const handleChangePage = (event, newPage) => {
    setPage(newPage);
  };

  const handleChangeRowsPerPage = (event) => {
    setRowsPerPage(+event.target.value);
    setPage(0);
  };

  useEffect(() => {
    getData(GET_ALL_PRODUCTS_ENDPOINT, setdataProducts);
  }, [databaseChanges]);
 
  //-----------spinner----------------------------------------
  if (!dataProducts) {
    return <LoadingSpinner />;
  }

  return (
    <Paper sx={{ width: "100%" }} >
      <TableContainer style={{ borderBottom: "1px solid var(--lightGrey)" }}>
        <Table sx={{ minWidth: 650 }} size="medium">
          <TableHead>
            <TableRow>
              <StyledTableCell
                align="left"
                style={{ fontSize: "1rem", fontWeight: "bold", width: "2rem" }}
              >
                Id
              </StyledTableCell>
              <StyledTableCell
                align="left"
                style={{ fontSize: "1rem", fontWeight: "bold" }}
              >
                Nombre
              </StyledTableCell>
              <StyledTableCell
                align="left"
                style={{ fontSize: "1rem", fontWeight: "bold" }}
              >
                Titulo
              </StyledTableCell>
              <StyledTableCell
                align="left"
                style={{ fontSize: "1rem", fontWeight: "bold" }}
              >
                Categoria
              </StyledTableCell>
              <StyledTableCell
                align="left"
                style={{ fontSize: "1rem", fontWeight: "bold"}}
              >
                Editar
              </StyledTableCell>
              <StyledTableCell
                align="left"
                style={{ fontSize: "1rem", fontWeight: "bold"}}
              >
                Eliminar
              </StyledTableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {dataProducts
              .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
              .map((data) => (
                <TableRow
                  key={data.id}
                  sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
                >
                  <TableCell
                    align="left"
                    style={{ fontSize: "1rem", fontWeight: "bold" }}
                    onClick={()=>console.log(data.id)}
                  >
                    {data.id}
                  </TableCell>
                  <TableCell align="left"  style={{ fontSize: "1rem", fontWeight: "600" }}>{data.nombre}</TableCell>
                  <TableCell align="left" style={{ fontSize: "1rem", fontWeight: "600" }}>{data.titulo}</TableCell>
                  <TableCell align="left" style={{ fontSize: "1rem", fontWeight: "600" }}>{data.categoria.titulo}</TableCell>
                  <TableCell align="left" >
                    <IconEdit data={data}/>
                  </TableCell>
                  <TableCell align="left">
                    <IconDelete data={data} database={databaseChanges} setDatabase={setDatabaseChanges} />
                  </TableCell>
                </TableRow>
              ))}
          </TableBody>
        </Table>
      </TableContainer>
      <TablePagination
      // style={{ fontSize: "1rem", fontWeight: "600" }}
        rowsPerPageOptions={[10, 25, 100]}
        component="div"
        count={dataProducts.length}
        rowsPerPage={rowsPerPage}
        page={page}
        onPageChange={handleChangePage}
        onRowsPerPageChange={handleChangeRowsPerPage}
      />
    </Paper>
  );
};

export default AdminProductTable;
