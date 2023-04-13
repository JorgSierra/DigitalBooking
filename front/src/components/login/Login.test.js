import React from 'react';
import { render, screen, fireEvent, act } from '@testing-library/react';
import Login from './Login';
import '@testing-library/jest-dom/extend-expect';
import { BrowserRouter as Router, Route } from 'react-router-dom';

describe('Login component', () => {
  it('should render login form', () => {
    render(<Router><Login /></Router>);
    const emailInput = screen.getByLabelText('Correo electronico');
    const passwordInput = screen.getByLabelText('Contraseña');
    const submitButton = screen.getByTestId('login-button');
    expect(emailInput).toBeInTheDocument();
    expect(passwordInput).toBeInTheDocument();
    expect(submitButton).toBeInTheDocument();
  });

  it('should show error message when invalid credentials are entered', async () => {
    render(<Router><Login /></Router>);
    const emailInput = screen.getByLabelText('Correo electronico');
    const passwordInput = screen.getByLabelText('Contraseña');
    const submitButton = screen.getByTestId('login-button');
    act(() => {
      fireEvent.change(emailInput, { target: { value: 'invalid-email' } });
    });
    act(() => {
      fireEvent.change(passwordInput, { target: { value: 'invalid-password' } });
    });
    act(() => {
      fireEvent.click(submitButton);
    });
    const errorMessage = await screen.findByTestId('password-error');
    expect(errorMessage).toBeInTheDocument();
  });

  
});
