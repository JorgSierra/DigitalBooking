import { render, fireEvent, screen} from "@testing-library/react";
import '@testing-library/jest-dom'
import Header from "./Header";
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import '@testing-library/jest-dom/extend-expect';

window.scrollTo = jest.fn();



describe("Header", () => {
    it("logo renders", () => {
        const { getByTestId } = render(<Router><Header /></Router>);

        const logo = getByTestId("logo-testid");

        expect(logo).toBeInTheDocument
    });
    
    
    it("renders login and signup buttons on home page", () => {
        const { getByTestId } = render(<Router><Header /></Router>);
        const loginButton = getByTestId("login-button");
        const signupButton = getByTestId("signup-button");
      
        expect(loginButton).toBeInTheDocument();
        expect(signupButton).toBeInTheDocument();
      });

      it("renders LoggedUserHeader when user is logged in", () => {
        localStorage.setItem("Logged", true);
        const { getByTestId } = render(<Router><Header /></Router>);
        const loggedUserHeader = getByTestId("logged-user");
        
        expect(loggedUserHeader).toHaveTextContent(/^Hola,\s*Braian\s+Redmond$/);
        localStorage.setItem("Logged", false);
      });
      
      describe("Header", () => {
        
      
      
    it("login button is rendered", () => {
        const { getByTestId } = render(<Router><Header /></Router>);

        const loginButton = getByTestId("login-button");

        expect(loginButton).toBeInTheDocument
    });
    it("signup button is rendered", () => {
        const { getByTestId } = render(<Router><Header /></Router>);

        const signupButton = getByTestId("signup-button");

        expect(signupButton).toBeInTheDocument
    });
    afterEach(() => {
        localStorage.setItem("Logged", false);});

});
})