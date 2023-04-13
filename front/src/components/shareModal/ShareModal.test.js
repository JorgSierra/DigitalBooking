import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import ShareModal from './ShareModal';
import '@testing-library/jest-dom';

describe('ShareModal component', () => {
  const mockProductDetails = {
    nombre: 'Producto de prueba',
    descripcion: 'Descripción del producto de prueba',
    titulo: 'Prueba',
  };

  test('renders share buttons', () => {
    render(<ShareModal dataProductDetails={mockProductDetails} productDetailsPath="/" />);
    expect(screen.getByTestId('fb-icon')).toBeInTheDocument();
    expect(screen.getByTestId('lkd-icon')).toBeInTheDocument();
    expect(screen.getByTestId('tw-icon')).toBeInTheDocument();
    expect(screen.getByTestId('wa-icon')).toBeInTheDocument();
    expect(screen.getByTestId('pt-icon')).toBeInTheDocument();
    expect(screen.getByTestId('share-cancelButton')).toBeInTheDocument();
  });

  test('renders share message', () => {
    render(<ShareModal dataProductDetails={mockProductDetails} productDetailsPath="/" />);
    expect(screen.getByTestId('share-h1')).toHaveTextContent('Compartir via');
    expect(screen.getByTestId('share-p')).toHaveTextContent('Click en uno de los iconos para compartir');
  });

  test('clicking cancel button closes modal', () => {
    const setIsShown = jest.fn();
    const modRef = jest.fn();
    render(<ShareModal dataProductDetails={mockProductDetails} productDetailsPath="/" setIsShown={setIsShown} modRef={modRef} />);
    const cancelButton = screen.getByTestId('share-cancelButton');
    fireEvent.click(cancelButton);
    expect(setIsShown).toHaveBeenCalledWith(false);
  });
});