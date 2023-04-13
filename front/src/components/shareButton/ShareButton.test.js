import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import ShareButton from './ShareButton';
import '@testing-library/jest-dom';

describe('ShareButton', () => {
  const dataProductDetails = {
    nombre: 'Producto de ejemplo',
    descripcion: 'Descripción del producto de ejemplo',
    titulo: 'ejemplo',
  };
  const productDetailsPath = 'https://ejemplo.com/producto-ejemplo';

  test('renders the share button', () => {
    render(
      <ShareButton
        dataProductDetails={dataProductDetails}
        productDetailsPath={productDetailsPath}
      />
    );
    const shareButton = screen.getByTestId('share-button');
    expect(shareButton).toBeInTheDocument();
  });

  test('opens the share modal when share button is clicked', () => {
    render(
      <ShareButton
        dataProductDetails={dataProductDetails}
        productDetailsPath={productDetailsPath}
      />
    );
    const shareButton = screen.getByTestId('share-button');
    fireEvent.click(shareButton);
    const shareModalTitle = screen.getByTestId('share-h1');
    expect(shareModalTitle).toHaveTextContent('Compartir via');
  });

  test('closes the share modal when cancel button is clicked', () => {
    render(
      <ShareButton
        dataProductDetails={dataProductDetails}
        productDetailsPath={productDetailsPath}
      />
    );
    const shareButton = screen.getByTestId('share-button');
    fireEvent.click(shareButton);
    const cancelButton = screen.getByTestId('share-cancelButton');
    fireEvent.click(cancelButton);
    const shareModal = screen.queryByTestId('share-h1');
    expect(shareModal).toBeNull();
  });
});
