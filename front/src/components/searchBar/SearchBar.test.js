import React from "react";
import SearchBar from "./SearchBar";
import { render, fireEvent, screen } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';

jest.mock("axios");

describe("SearchBar", () => {
  it("should render the search bar with all its inputs", () => {
    const { getByTestId, getByLabelText, getByText } = render(<SearchBar />);

    // Check that the search bar exists
    expect(getByTestId("search-bar")).toBeInTheDocument();

    // Check that all inputs exist
    expect(getByTestId("search-location-input")).toBeInTheDocument();
    expect(getByTestId("searchBar-calendar")).toBeInTheDocument();
    

    // Test that the search button is clickable
    const searchButton = getByText("Buscar");
    expect(searchButton).toBeInTheDocument();

    //fireEvent.click(searchButton);
    //Aca va la logica para comprobar
  });
});
