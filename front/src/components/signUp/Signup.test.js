import React from 'react';
import { render, fireEvent, act, getByText } from '@testing-library/react';
import SignUp from './SignUp';
import '@testing-library/jest-dom/extend-expect';
import { BrowserRouter as Router } from 'react-router-dom';


describe('SignUp', () => {
  it('should render correctly', () => {
    const { getByTestId } = render(<Router>
      <SignUp />
      </Router>);
    expect(getByTestId('name')).toBeInTheDocument();
    expect(getByTestId('lastname')).toBeInTheDocument();
    expect(getByTestId('email')).toBeInTheDocument();
    expect(getByTestId('password')).toBeInTheDocument();
    expect(getByTestId('password2')).toBeInTheDocument();
  });

  it('should show error message if required fields are not filled in', async () => {
    const { getByTestId, getByText } = render(<Router>
      <SignUp />
      </Router>);
    const submitButton = getByTestId('submit-button');
    await act(async () => {
      fireEvent.click(submitButton);
    });

    expect(getByText('Debe ingresar un nombre')).toBeInTheDocument();
    expect(getByText('Debe ingresar un apellido')).toBeInTheDocument();
    expect(getByText('Debe ingresar un correo electrónico')).toBeInTheDocument();
    
    expect(getByText('Debe confirmar la contraseña')).toBeInTheDocument();
  });

  it('should show error message if username or lastname contain numbers', async () => {
    const { getByTestId, getByText } = render(<Router>
      <SignUp />
      </Router>);
    const usernameInput = getByTestId('name');
    const lastnameInput = getByTestId('lastname');
    const submitButton = getByTestId('submit-button');
    await act(async () => {
      fireEvent.change(usernameInput, { target: { value: 'braian12' } });
      fireEvent.change(lastnameInput, { target: { value: 'Redmond12' } });
      fireEvent.click(submitButton);
    });

    expect(getByText('El nombre o apellido no pueden contener números')).toBeInTheDocument();
  });

  it('should show error message if passwords do not match', async () => {
    const { getByTestId, getByText } = render(<Router>
      <SignUp />
      </Router>);
    const passwordInput = getByTestId('password');
    const password2Input = getByTestId('password2');
    const submitButton = getByTestId('submit-button');
    await act(async () => {
      fireEvent.change(passwordInput, { target: { value: 'password1' } });
      fireEvent.change(password2Input, { target: { value: 'password2' } });
      fireEvent.click(submitButton);
    });

    expect(getByText('Las contraseñas no coinciden')).toBeInTheDocument();
  });

  it('should show error message if password is too short', async () => {
    const { getByTestId, getByText } = render(<Router>
      <SignUp />
      </Router>);
    const passwordInput = getByTestId('password');
    const password2Input = getByTestId('password2');
    const submitButton = getByTestId('submit-button');
    await act(async () => {
      fireEvent.change(passwordInput, { target: { value: 'passw' } });
      fireEvent.change(password2Input, { target: { value: 'passw' } });
      fireEvent.click(submitButton);
    });

    expect(getByText('La contraseña debe tener al menos 6 caracteres')).toBeInTheDocument();
  });

 
});
