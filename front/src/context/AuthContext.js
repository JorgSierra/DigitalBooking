import React, { createContext } from "react"

export const AuthContext = createContext();

const AuthContextProvider = ({ children }) => {

    const [recommendationsData, setRecommendationsData] = useState([]);
    const [categoriesData, setCategoriesData] = useState([]);

    const data = {
        recommendationsData,
        setRecommendationsData
    }

    return (
        <AuthContext.Provider value={data}>
            {children}
        </ AuthContext.Provider>
    )
}

export default AuthContextProvider