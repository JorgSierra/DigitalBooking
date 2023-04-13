import React from 'react';
import { render, screen,fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import { BrowserRouter } from 'react-router-dom';
import CardCategoria from './CardCategory';

describe('CardCategoria', () => {
  const props = {
    titulo: 'test',
    urlImagen: 'test.png',
    descripcion: 'test description'
  }

  test('renders category title and image', () => {
    render(
      <BrowserRouter>
        <CardCategoria {...props} />
      </BrowserRouter>
    );
    expect(screen.getByText(props.titulo)).toBeInTheDocument();
    expect(screen.getByAltText(props.descripcion)).toBeInTheDocument();
  });

  test('clicking on the card scrolls to top of page', () => {
    window.scrollTo = jest.fn(); // mock window.scrollTo function
    render(
      <BrowserRouter>
        <CardCategoria {...props} />
      </BrowserRouter>
    );
    const cardLink = screen.getByRole('link');
    fireEvent.click(cardLink);
    expect(window.scrollTo).toHaveBeenCalledWith(0, 0);
  });

  test('link points to the correct filtered category path', () => {
    render(
      <BrowserRouter>
        <CardCategoria {...props} />
      </BrowserRouter>
    );
    const cardLink = screen.getByRole('link');
    expect(cardLink.getAttribute('href')).toBe(`/filterCategory/${props.titulo}`);
  });
});
