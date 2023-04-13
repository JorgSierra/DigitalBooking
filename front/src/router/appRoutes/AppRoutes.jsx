import React from 'react'
import { Routes, Route, Navigate } from 'react-router-dom'
import Layout from '../layout/Layout'
import Home from "../../pages/home/Home"
import FilterCategoryPage from "../../pages/filterCategoryPage/FilterCategoryPage"
import DetailsPage from "../../pages/detailsPage/DetailsPage"
import SignUpPage from "../../pages/signUpPage/SignUpPage"
import LoginPage from "../../pages/loginPage/LoginPage"
import FavoritesPage from "../../pages/favoritesPage/FavoritesPage"
import ProtectedRoutes from '../protectedRoutes/ProtectedRoutes'
import LoggedHomePage from '../../pages/loggedHomePage/LoggedHomePage'
import ReservationPage from '../../pages/reservationPage/ReservationPage'
import VerifiedReservationPage from '../../pages/verifiedReservationPage/VerifiedReservationPage'
import FilterDateCityPage from '../../pages/filterDateCityPage/FilterDateCityPage'
import AdministrationPage from '../../pages/administration/AdministrationPage'
import VerifiedCreatedProduct from '../../pages/verifiedCreatedProductPage/VerifiedCreatedProductPage'
import VerifiedRegistrationPage from '../../pages/verifiedRegistrationPage/VerifiedRegistrationPage'
import ReservesPage from '../../pages/reservesPage/ReservesPage'
import AdminProductTable from '../../pages/adminProductsTable/AdminProductTable'
import AdminEditProduct from '../../pages/adminEditProduct/AdminEditProduct'

const AppRoutes = () => {
    //
    return (
        <Routes>
            <Route path="/" element={<Layout />}>
                <Route path="/" element={<Home />} />
                <Route path="/" element={<FilterDateCityPage />} />
                <Route path="/filterCategory/:category" element={<FilterCategoryPage />} />
                <Route path="/productDetails/:id" element={<DetailsPage />} />
                <Route path="/signUp" element={<SignUpPage />} />
                <Route path="/login" element={<LoginPage />} />              
                <Route path="/verifiedProductCreation" element={<VerifiedCreatedProduct />} />
                <Route path="/verifiedRegistration" element={<VerifiedRegistrationPage />} />
                <Route path="*" element={<Navigate to="/" />} />
                <Route element={<ProtectedRoutes />}>
                    <Route path="/loggedHome" element={<LoggedHomePage />} />
                    <Route path="/favorites" element={<FavoritesPage />} />
                    <Route path="/product/:id/reserve" element={<ReservationPage />} />
                    <Route path="/reserves/user" element={<ReservesPage />} />
                    <Route path="/verifiedReservation" element={<VerifiedReservationPage />} />
                    <Route path="/administration" element={<AdministrationPage />} />
                    <Route path="/adminTable" element={<AdminProductTable />} />
                    <Route path="/adminEditProduct/:id" element={<AdminEditProduct />} />
                </Route>
            </Route>
        </Routes>
    )
}

export default AppRoutes