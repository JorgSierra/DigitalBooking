import React from 'react';
import { render, screen } from '@testing-library/react';
import ProductDescription from './ProductDescription';
import '@testing-library/jest-dom/extend-expect';

const mockProps = {
  title: 'Product Title',
  description: 'Product Description',
  ubicacion: {
    ciudad: 'Ciudad de México',
    pais: 'México'
  },
  puntuaciones: [10,10,10],
  reviews: 10
};


describe.only('ProductDescription', () => {
  it('renders location information correctly', () => {
    render(<ProductDescription {...mockProps} />);
    
    const locationIcon = screen.getByTestId('LocationOnIcon');
    expect(locationIcon).toBeInTheDocument();

    const cityText = screen.getByText(`${mockProps.ubicacion.ciudad}, ${mockProps.ubicacion.pais}`);    
    expect(cityText).toBeInTheDocument();
    

    
  });

  it('renders loading message if props are not provided', () => {
    render(<ProductDescription />);
    
    const loadingMessage = screen.getByTestId('loading');
    expect(loadingMessage).toBeInTheDocument();
  });
});
