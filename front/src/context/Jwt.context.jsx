import React, { createContext, useState, useEffect } from "react";
import { decodeToken } from "../utils/utils";

export const JwtContext = createContext();

const JwtProvider = ({ children }) => {
    
    const [jwtValue, setJwtValue] = useState(false);
    const [token, setToken] = useState("");

    useEffect(() => {
        const token = JSON.parse(localStorage.getItem("jwt"));
        if (token) {
            decodeToken(token, setJwtValue);
            setToken(token);
        } else {
            setJwtValue(false);
        }

        const handlePostMessage = (event) => {
            if (event.data.type === "jwt") {
                const token = JSON.parse(event.data.token);
                if (token) {
                    decodeToken(token, setJwtValue);
                    setToken(token);
                } else {
                    setJwtValue(false);
                }
            }
        };

        window.addEventListener("message", handlePostMessage);

        return () => window.removeEventListener("message", handlePostMessage);
    }, []);

    return (
        <JwtContext.Provider value={{ jwtValue, setJwtValue }}>
            {children}
        </JwtContext.Provider>
    );
};

export default JwtProvider;