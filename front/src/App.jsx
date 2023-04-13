import "./App.css";
import { useEffect } from "react"
import { Router, RouterProvider, useLocation } from "react-router-dom";
import { Routes, Route, Navigate } from "react-router-dom";
import AppRoutes from "./router/appRoutes/AppRoutes";
import { RouteSharp } from "@mui/icons-material";

function App() {

    return (
        <div className="app">
            <AppRoutes />
        </div>
    );
}

export default App;


/*const location = useLocation();
useEffect(() => {
    window.scrollTo(0, 0);
}, [location]);*/
