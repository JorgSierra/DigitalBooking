import React from 'react';
import { render, screen ,cleanup} from '@testing-library/react';
import CardAmenities from './CardAmenities';
import '@testing-library/jest-dom/extend-expect';

describe('CardAmenities', () => {
   
  const caracteristicas = {
    icono: 'icono.png',
    nombre: 'Piscina'
  };
  
  it('renders the icon and name', () => {
    render(<CardAmenities {...caracteristicas} />);
    const iconElement = screen.getByTestId('amenitie-img');
    const nameElement = screen.getByText('Piscina');
    expect(iconElement).toBeInTheDocument();
    expect(nameElement).toBeInTheDocument();
  });

  it('renders a loading message if no props are passed', () => {
    render(<CardAmenities />);
    const loadingElement = screen.getByTestId('loading');
    expect(loadingElement).toBeInTheDocument();
  });
});
