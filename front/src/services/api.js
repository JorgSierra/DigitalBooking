import axios from "axios";
import { isTokenExpired, tokenLogOut } from "../utils/utils";


//'http://3.145.94.168/api'
//"http://localhost:8090/api"
//Creates a new instance of axios with customized URL to connect the api and a timeout
const apiWithoutToken = axios.create({
    baseURL: "http://3.145.94.168/",
    timeout: 10000,
    headers: {
        'Content-Type': 'application/json'
    }
});

//Fetch function using the customized instance of axios
// Requires 2 arguments, the end point to the api for example: "/Productos"
// the setData will store the data received from the backend into a state, has to be created on each component that uses getData
export async function getData(path, setData = null) {
    try {
        const res = await apiWithoutToken.get(path);
        if (!res.data) {
            throw new Error("Data is null or undefined");
        }
        if (setData) {
            setData(res.data);
        }
        return res;
    } catch (error) {
        if (error.response) {
            /*console.log(error.response.data);
            console.log(error.response.status);
            console.log(error.response.headers);*/
            if (error.response.status === 403) {
                throw new Error("User not authorized");
            } else if (error.response.status === 404) {
                throw new Error("Not found");
            } else if (error.response.status === 500) {
                const token = JSON.parse(localStorage.getItem("jwt"));
                if (isTokenExpired(token)) {
                    tokenLogOut();
                    throw new Error("Token expired");
                } else {
                    throw new Error("Internal server error");
                }
            }
        } else if (error.request) {
            //console.log(error.request);
        } else {
            //console.log('Error', error.message);
        }
        //console.log(error.config);
    }
}

export async function getDataWithToken(path, setData) {
    try {
        const jwtToken = localStorage.getItem('jwt');
        const parsed = JSON.parse(jwtToken) // get JWT token from local storage
        if (jwtToken) {
            const apiWithToken = axios.create({
                baseURL: "http://3.145.94.168/",
                timeout: 10000,
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": `Bearer ${parsed}` // add token to headers
                }
            });
            const res = await apiWithToken.get(path);
            if (!res.data) {
                throw new Error('Data is null or undefined');
            }
            setData(res.data);
            return res.data;
        }
    } catch (error) {
        if (error.response) {
            /*console.log(error.response.data);
            console.log(error.response.status);
            console.log(error.response.headers);*/
            if (error.response.status === 403) {
                throw new Error('User not authorized');
            } else if (error.response.state === 400) {
                throw new Error('Error in reseived request')
            } else if (error.response.status === 404) {
                throw new Error('Not found');
            } else if (error.response.status === 500) {
                const token = JSON.parse(localStorage.getItem("jwt"));
                if (isTokenExpired(token)) {
                    tokenLogOut();
                    throw new Error("Token expired");
                } else {
                    throw new Error("Internal server error");
                }
            } else if (error.request) {
                //console.log(error.request);
            } else {
                //console.log('Error', error.message);
            }
            //console.log(error.config);
        }
    }
}


export async function postData(path, body) {
    try {
        const response = await apiWithoutToken.post(path, body);

        if (!response.data) {
            throw new Error('Data is null or undefined');
        }

        return response;
    } catch (error) {
        if (error.response) {
            // The request was made and the server responded with an error status code
            /*console.log(error.response.data);
            console.log(error.response.status);
            console.log(error.response.headers);*/

            if (error.response.status === 403) {
                throw new Error('User not authorized');
            } else if (error.response.status === 400) {
                throw new Error('Bad Request');
            } else if (error.response.status === 409) {
                throw new Error('Request conflict');
            } else if (error.response.status === 404) {
                throw new Error('Not found');
            } else if (error.response.status === 500) {
                const token = JSON.parse(localStorage.getItem("jwt"));
                if (isTokenExpired(token)) {
                    tokenLogOut();
                    throw new Error("Token expired");
                } else {
                    throw new Error("Internal server error");
                }
            } else if (error.request) {
                // The request was made but no response was received
                //console.log(error.request);
            } else {
                // Something happened in setting up the request that triggered an Error
                //console.log('Error', error.message);
            }

            //console.log(error.config);
            return null;
        }
    }
}


export async function postDataWithToken(path, body) {
    try {
        const jwtToken = localStorage.getItem('jwt');
        const parsed = JSON.parse(jwtToken);
        const apiWithToken = axios.create({
            baseURL: "http://3.145.94.168/",
            timeout: 10000,
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${parsed}`
            }
        });
        const response = await apiWithToken.post(path, body);

        if (!response.data) {
            throw new Error('Data is null or undefined');
        }

        return response;
    } catch (error) {
        if (error.response) {
            // The request was made and the server responded with an error status code
            if (error.response.status === 403) {
                throw new Error('User not authorized');
            } else if (error.response.status === 400) {
                throw new Error('Bad Request');
            } else if (error.response.status === 409) {
                throw new Error('Request conflict');
            } else if (error.response.status === 404) {
                throw new Error('Not found');
            } else if (error.response.status === 500) {
                const token = JSON.parse(localStorage.getItem("jwt"));
                if (isTokenExpired(token)) {
                    tokenLogOut();
                    throw new Error("Token expired");
                } else {
                    throw new Error("Internal server error");
                }
            } else if (error.request) {
                // The request was made but no response was received
                //console.log(error.request);
            } else {
                // Something happened in setting up the request that triggered an Error
                //console.log('Error', error.message);
            }

            //console.log(error.config);
            return null;
        }
    }
}

export async function postDataWithTokenAndNoBody(path) {
    try {
        const jwtToken = localStorage.getItem('jwt');
        const parsed = JSON.parse(jwtToken);
        const apiWithToken = axios.create({
            baseURL: "http://3.145.94.168/",
            timeout: 10000,
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${parsed}`
            }
        });
        const response = await apiWithToken.post(path);

        if (!response.data) {
            throw new Error('Data is null or undefined');
        }

        return response;
    } catch (error) {
        if (error.response) {
            // The request was made and the server responded with an error status code
            if (error.response.status === 403) {
                throw new Error('User not authorized');
            } else if (error.response.status === 400) {
                throw new Error('Bad Request');
            } else if (error.response.status === 409) {
                throw new Error('Request conflict');
            } else if (error.response.status === 404) {
                throw new Error('Not found');
            } else if (error.response.status === 500) {
                const token = JSON.parse(localStorage.getItem("jwt"));
                if (isTokenExpired(token)) {
                    tokenLogOut();
                    throw new Error("Token expired");
                } else {
                    throw new Error("Internal server error");
                }
            } else if (error.request) {
                // The request was made but no response was received
                //console.log(error.request);
            } else {
                // Something happened in setting up the request that triggered an Error
                //console.log('Error', error.message);
            }

            //console.log(error.config);
            return null;
        }
    }
}

//               
export async function deleteDataWithTokenAndNoBody(path) {

    try {
        const jwtToken = localStorage.getItem('jwt');
        const parsed = JSON.parse(jwtToken);
        const apiWithTokenDelete = axios.create({
            baseURL: "http://3.145.94.168/",
            timeout: 10000,
            headers: {
                "Authorization": `Bearer ${parsed}`,
            }
        });
        const response = await apiWithTokenDelete.delete(path);

        if (!response.data) {
            throw new Error('Data is null or undefined');
        }

        return response;
    } catch (error) {
        if (error.response) {
            // The request was made and the server responded with an error status code
            if (error.response.status === 403) {
                throw new Error('User not authorized');
            } else if (error.response.status === 400) {
                throw new Error('Bad Request');
            } else if (error.response.status === 409) {
                throw new Error('Request conflict');
            } else if (error.response.status === 404) {
                throw new Error('Not found');
            } else if (error.response.status === 500) {
                const token = JSON.parse(localStorage.getItem("jwt"));
                if (isTokenExpired(token)) {
                    tokenLogOut();
                    throw new Error("Token expired");
                } else {
                    throw new Error("Internal server error");
                }
            } else if (error.request) {
                // The request was made but no response was received
                //console.log(error.request);
            } else {
                // Something happened in setting up the request that triggered an Error
                //console.log('Error', error.message);
            }
            //console.log(error.config);
            return null;
        }
    }
}


export async function editDataWithToken(path, body) {
    try {
        const jwtToken = localStorage.getItem('jwt');
        const parsed = JSON.parse(jwtToken);
        const apiWithToken = axios.create({
            baseURL: "http://3.145.94.168/",
            timeout: 10000,
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${parsed}`
            }
        });
        const response = await apiWithToken.put(path, body);

        if (!response) {
            throw new Error('Data is null or undefined');
        }

        return response;
    } catch (error) {
        if (error.response) {
            // The request was made and the server responded with an error status code
            if (error.response.status === 403) {
                throw new Error('User not authorized');
            } else if (error.response.status === 400) {
                throw new Error('Bad Request');
            } else if (error.response.status === 409) {
                throw new Error('Request conflict');
            } else if (error.response.status === 404) {
                throw new Error('Not found');
            } else if (error.response.status === 500) {
                const token = JSON.parse(localStorage.getItem("jwt"));
                if (isTokenExpired(token)) {
                    tokenLogOut();
                    throw new Error("Token expired");
                } else {
                    throw new Error("Internal server error");
                }
            } else if (error.request) {
                // The request was made but no response was received
                //console.log(error.request);
            } else {
                // Something happened in setting up the request that triggered an Error
                //console.log('Error', error.message);
            }

            //console.log(error.config);
            return null;
        }
    }
}