import React from 'react';
import { render, screen,getByText } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import Hamburguer from './Hamburguer';
import '@testing-library/jest-dom/extend-expect';

describe('Hamburguer', () => {
  it('renders HamburguerNoLogged when not logged in', () => {
    render(
      <BrowserRouter>
        <Hamburguer handleClose={() => {}} loggedIn={false}  />
      </BrowserRouter>
    );
    expect(screen.getByTestId('hamburger-NL')).toBeInTheDocument();
    expect(screen.getByText('Login')).toBeInTheDocument();
  });

  it('renders HamburguerLoggedIn when logged in', () => {
    render(
      <BrowserRouter>
        <Hamburguer handleClose={() => {}} loggedIn={true}  />
      </BrowserRouter>
    );
    expect(screen.getByTestId('hamburger-LG')).toBeInTheDocument();
    
  });
});

