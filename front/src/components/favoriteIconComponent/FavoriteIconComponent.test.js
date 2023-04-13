import { render, screen ,fireEvent} from "@testing-library/react";
import '@testing-library/jest-dom/extend-expect';
import FavoriteIconComponent from "./FavoriteIconComponent";
import { FavoritesContext } from "../../context/Favorites.context";
import { BrowserRouter } from "react-router-dom";

describe("FavoriteIconComponent", () => {
  test("renders FavoriteIconComponent with correct props", () => {
    const handleFavorites = jest.fn();
    const isInFavorites = jest.fn().mockReturnValue(false);
    const data = { id: 1, name: "Product 1" };
    const heartColor = "#FF0000";
    const shadow = "drop-shadow(2px 2px 2px gray)";
    render(
      <BrowserRouter>
        <FavoritesContext.Provider value={{ handleFavorites, isInFavorites }}>
          <FavoriteIconComponent data={data} heartColor={heartColor} shadow={shadow} />
        </FavoritesContext.Provider>
      </BrowserRouter>
    );
    const iconButton = screen.getByRole("button");
    expect(iconButton).toBeInTheDocument();
    fireEvent.click(iconButton);
    expect(handleFavorites).toHaveBeenCalledWith(data);
  });
});
