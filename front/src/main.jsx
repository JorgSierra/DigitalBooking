
import React from "react";
import ReactDOM from "react-dom/client";
import { HashRouter } from "react-router-dom";
import App from "./App";
import DatesProvider from "./context/Dates.context";
import FilterProvider from "./context/Filter.context";
import FavoritesProvider from "./context/Favorites.context";
import JwtProvider from "./context/Jwt.context";
import "./index.css";

ReactDOM.createRoot(document.getElementById("root")).render(
    <React.StrictMode>
        <JwtProvider>
            <DatesProvider>
                <FavoritesProvider>
                    <FilterProvider>
                        <HashRouter>
                            <App />
                        </HashRouter>
                    </FilterProvider>
                </FavoritesProvider>
            </DatesProvider>
        </JwtProvider>
    </React.StrictMode>
);
