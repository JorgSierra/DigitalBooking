export const REGISTER_USER = `api/usuarios`;
export const LOG_USER = `auth`;
export const GET_USER = `api/usuarios/:id`;
export const GET_PRODUCT_BY_ID_ENDPOINT = "api/productos/:id"
export const GET_EIGHT_RANDOM_PRODUCTS_ENDPOINT = "api/productos/rand";
export const GET_ALL_CATEGORIES_ENDPOINT = "api/categorias";
export const GET_ALL_PRODUCTS_ENDPOINT = "api/productos";
//Trae productos que el string que es provisto sea similar a la ciudad del producto
export const GET_PRODUCTS_BY_STRING_LIKE_CITY = `api/productos/ubicacion/ciudad/:string`;
//Trae productos que no posean una reserva entre las 2 fechas especificadas
export const GET_PRODUCT_RESERVE_AVAILABLE_BETWEEN_DATES = "api/productos/disponible";
//Trae productos que no posean una reserva entre las 2 fechas especificadas y que ademas se especifique un string de ciudad
export const GET_PRODUCT_RESERVE_AVAILABLE_BETWEEN_DATES_AND_STRING_LIKE_CITY = "api/productos/disponibleYCiudad";
//Trae todas las reservas de un producto por el id de ese producto
export const GET_ALL_PRODUCT_RESERVES = `api/reservas/producto/:id`;
export const GET_ALL_USER_RESERVES = `api/reservas/usuario/:id`;
export const GET_ALL_CHARACTERISTICS = "api/caracteristicas";
export const GET_ALL_POLITICS = "api/politicas";
export const GET_ALL_LOCATIONS = "api/ubicaciones";
export const PRODUCT_TOGGLE_LIKE = `api/likes/toggle/:id`
export const GET_PRODUCTS_LIKED_BY_USER = `api/productos/usuario/:id`
export const POST_PRODUCT_ADMIN = 'api/productos';
export const PUT_PRODUCT_ADMIN = 'api/productos/'; //editar producto
export const GET_PRODUCT_BY_ID = `api/productos/:id`; //traer producto por id
export const POST_RESERVATION = 'api/reservas';
export const POST_IMAGES = 'api/imagenes';
export const DELETE_PRODUCTS_ID = `api/productos/:id `
export const DELETE_RESERVE_ID = `api/reservas/:id`
export const ADD_CHANGE_RATING = "api/puntuaciones"
export const GET_USER_RATINGS = `api/puntuaciones/usuario/:id `

//const endpoint = replaceIdPlaceholder(GET_PRODUCT_BY_ID_ENDPOINT, id);
export function replaceIdPlaceholder(endpoint, id) {
    return endpoint.replace(':id', id);
}

//const endpoint = replaceIdPlaceholder(GET_PRODUCTS_BY_STRING_LIKE_CITY, string);
export function replaceStringPlaceholder(endpoint, string) {
    return endpoint.replace(':string', string);
}

//const endpoint = replaceIdPlaceholder(GET_PRODUCT_RESERVE_AVAILABLE_BETWEEN_DATE, fechaInicio, fechaFin);
//const endpoint = replaceIdPlaceholder(GET_PRODUCT_RESERVE_AVAILABLE_BETWEEN_DATES_AND_STRING_LIKE_CITY, fechaInicio, fechaFin, ciudad);
export function replaceDateAndCityPlaceholders(endpoint, fechaInicio, fechaFin, ciudad) {
    let formattedEndpoint = endpoint;

    if (ciudad) {
        formattedEndpoint = formattedEndpoint.replace(':ciudad', ciudad);
    } else {
        formattedEndpoint = formattedEndpoint.replace('&ciudad=:ciudad', '');
    }

    formattedEndpoint = `
$ {
    formattedEndpoint.replace(':fechaInicio', fechaInicio)
        .replace(':fechaFin', fechaFin)
}
`;

    //console.log(formattedEndpoint);
    return formattedEndpoint;
}




//import { GET_EIGHT_RANDOM_PRODUCTS_ENDPOINT } from '../../services/endpoints';
//import { GET_ALL_CATEGORIES_ENDPOINT } from '../../services/endpoints';
//import { GET_ALL_PRODUCTS_ENDPOINT } from '../../services/endpoints';
//import { GET_PRODUCT_BY_ID_ENDPOINT } from '../../services/endpoints';