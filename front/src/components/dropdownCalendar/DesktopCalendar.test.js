import React from 'react';
import { render, fireEvent } from '@testing-library/react';
import DesktopCalendar from './DesktopCalendar';
import '@testing-library/jest-dom/extend-expect';

test('renders DesktopCalendar component', () => {
  const { getByTestId } = render(<DesktopCalendar />);
  const desktopCalendar = getByTestId('desktop-calendar');
  expect(desktopCalendar).toBeInTheDocument();
});

test('updates state when a date is selected', () => {
  const { getByTestId } = render(<DesktopCalendar />);
  const startDateInput = getByTestId('start-date-input');
  const endDateInput = getByTestId('end-date-input');
  const startDate = new Date('2022-01-01');
  const endDate = new Date('2022-01-10');
  fireEvent.change(startDateInput, { target: { value: startDate } });
  fireEvent.change(endDateInput, { target: { value: endDate } });
  expect(startDateInput.value).toEqual(startDate.toLocaleDateString());
  expect(endDateInput.value).toEqual(endDate.toLocaleDateString());
});
