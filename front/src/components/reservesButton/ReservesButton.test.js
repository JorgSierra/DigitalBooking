import React from 'react';
import { BrowserRouter } from 'react-router-dom';
import { fireEvent, render, screen } from '@testing-library/react';
import FavoritesButon from './ReservesButton';
import '@testing-library/jest-dom/extend-expect';

describe('FavoritesButton', () => {
  it('renders FavoritesButton with proper text', () => {
    render(
      <BrowserRouter>
        <FavoritesButon handleClose={() => {}} />
      </BrowserRouter>
    );
    const button = screen.getByRole('button', { name: /Favoritos/i });
    expect(button).toBeInTheDocument();
  });

  it('clicking on button calls handleClose', () => {
    const handleClose = jest.fn();
    render(
      <BrowserRouter>
        <FavoritesButon handleClose={handleClose} />
      </BrowserRouter>
    );
    const button = screen.getByRole('button', { name: /Favoritos/i });
    fireEvent.click(button);
    expect(handleClose).toHaveBeenCalled();
  });
});
