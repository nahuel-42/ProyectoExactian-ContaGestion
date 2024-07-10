import axios from "axios";

let headers = {
    "Content-Type": "application/json",
    Accept: `application/vnd.iman.v1+json, application/json, text/plain, */*`,
    "Access-Control-Allow-Origin": "*",
    "Cache-Control": "no-store, no-cache, must-revalidate",
    Pragma: "no-cache"
};


const filterOptions = ({ method, ...rest }) => rest;

const fetch = async (url, options = {}) => {
    try {
        const token = localStorage.getItem('jwtToken');

        const instance = axios.create({
            baseURL: `http://localhost:8080/api`
        });

        // INTERCEPTOR REQUEST
        instance.interceptors.request.use(
            config => {
                // Si existe un token, lo agrega al encabezado de Authorization
                console.log('token  ',token);
                if (token) {
                    config.headers['Authorization'] = `Bearer ${token}`;
                }
                return config;
            },
            error => {
                return Promise.reject(error);
            }
        );

        // INTERCEPTOR RESPONSE
        instance.interceptors.response.use(
            (response) => {
                console.log('Interceptor response: ', response);
                return response;
            },
            (error) => {
                //console.log('Interceptor response error: ', error);
                return Promise.reject(error);
            }
        );

        const { data } = await instance.request({
            url,
            data: options["data"],
            params: options["params"],
            method: options["method"],
            headers: { ...headers, ...options["headers"] },
            cancelToken: options["cancelFn"]
                ? new axios.CancelToken(options["cancelFn"])
                : null
        });

        return data;
    } catch (err) {
        if (axios.isCancel(err)) {
            throw new Error("request-cancelled");
        } else {
            throw err;
        }
    }
};

const get = async (url, options = {}) => {
    return await fetch(url, {
        method: "GET",
        ...filterOptions(options)
    });
};

const post = async (url, options = {}) => {
    console.log('options: ', options);
    return await fetch(url, {
        method: "POST",
        ...filterOptions(options)
    });
};

const put = async (url, options = {}) => {
    return await fetch(url, {
        method: "PUT",
        ...filterOptions(options)
    });
};

const del = async (url, options = {}) => {
    return await fetch(url, {
        method: "DELETE",
        ...filterOptions(options)
    });
};

export default {
    get,
    post,
    put,
    delete: del
};
