import React, { useState, useEffect } from 'react';
import calendarioLogo from '../assets/images/calendario_logo.png';
import httpClient from '../utils/httpClient';
import { useNavigate } from 'react-router-dom';

import BotonDashboard from '../components/BotonDashboard';

function Login() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();
    const [usuario, setUsuario] = useState('usuario1');
    const [contraseña, setContraseña] = useState('contraseñaSegura123');

    const [mostrarUsuario, setMostrarUsuario] = useState(() => {
        const valorAlmacenado = localStorage.getItem('mostrarUsuario');
        return valorAlmacenado ? JSON.parse(valorAlmacenado) : false;
    });

    useEffect(() => {
        localStorage.setItem('mostrarUsuario', mostrarUsuario);
    }, [mostrarUsuario]);

    var token;
    const handleUsernameChange = (event) => {
        setUsername(event.target.value);
    };

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        localStorage.removeItem('jwtToken');
        try {
            const body = {
                nombre_de_usuario: username,
                contrasenia: password,
            };
            const response = await httpClient.post('/auth/login', { data: body });

            token = response.token;
            localStorage.setItem('jwtToken', token);
            navigate('/UsuarioDashboard');
        } catch (error) {
            const errorMsg = error.response ? error.response.data : error.message;
            console.error('Error en el login:', errorMsg);
            setErrorMessage('Error en el login');
        }
    };

    const registrarse = async (event) => { //Registro con fines practicos al probar el sistema
        event.preventDefault();
        localStorage.removeItem('jwtToken');
        try {
            const body = {
                nombre_usuario: usuario,
                contrasenia: contraseña,
                nombre: "Pedro",
                apellido: "Sanchez",
                email: "juan.perez@example.com"

            }
            const response = await httpClient.post('/auth/register', { data: body });
            setMostrarUsuario(true);

        } catch (error) {
            const errorMsg = error.response ? error.response.data : error.message;
            console.error('Error en el registro:', errorMsg);
        }


    }
    return (
        <>
            <img src={calendarioLogo} alt="Login" className="imagen_login" />
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="username">Usuario</label>
                    <input
                        type="text"
                        id="username"
                        value={username}
                        onChange={handleUsernameChange}
                    />
                </div>
                <div>
                    <label htmlFor="password">Contraseña</label>
                    <input
                        type="password"
                        id="password"
                        value={password}
                        onChange={handlePasswordChange}
                    />
                </div>

                <BotonDashboard texto="Iniciar sesión" type="submit" />
                <BotonDashboard texto="Registrarse" type="submit" onClick={registrarse} />
            </form>
            {mostrarUsuario && (<div>
                <p>Info con fines practicos para acceso al usuario</p>
                <p>Usuario: {usuario}</p>
                <p>Contraseña: {contraseña}</p>
            </div>
            )}
        </>
    );
}

export default Login;