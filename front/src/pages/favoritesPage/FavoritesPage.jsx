import React from "react";
import BlockFavorites from "../../components/blockFavorites/BlockFavorites";
import ResponsiveTemplate from "../../components/responsiveTemplate/ResponsiveTemplate";

const FavoritesPage = () => {
    return (
            <ResponsiveTemplate>
                <BlockFavorites />
            </ResponsiveTemplate>
    );
};

export default FavoritesPage;
