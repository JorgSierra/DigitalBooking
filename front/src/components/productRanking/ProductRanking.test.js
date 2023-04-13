import React from 'react';
import { render, screen } from '@testing-library/react';
import ProductRanking from './ProductRanking';
import '@testing-library/jest-dom/extend-expect';

describe('ProductRanking', () => {
  it('renders loading message if props are not provided', () => {
    render(<ProductRanking />);
    const loadingMessage = screen.getByTestId('loading');
    expect(loadingMessage).toBeInTheDocument();
  });

 
});
