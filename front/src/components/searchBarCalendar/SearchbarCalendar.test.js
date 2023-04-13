import React from 'react';
import { render, screen } from '@testing-library/react';
import SearchBarCalendar from './SearchBarCalendar';
import '@testing-library/jest-dom/extend-expect';



describe('SearchBarCalendar', () => {
  it('renders MobileCalendar component when window size is less than 600', () => {
   
    Object.defineProperty(window, 'innerWidth', { value: 500 });

    
    render(<SearchBarCalendar />);

   
    expect(screen.getByTestId('mobile-calendar')).toBeInTheDocument();
  });

  it('renders DesktopCalendar component when window size is greater than or equal to 600', () => {
    
    Object.defineProperty(window, 'innerWidth', { value: 600 });

   
    render(<SearchBarCalendar />);

   
    expect(screen.getByTestId('desktop-calendar')).toBeInTheDocument();
  });
});
