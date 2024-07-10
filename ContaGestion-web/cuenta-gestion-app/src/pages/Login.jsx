import React, { useState } from 'react';
import calendarioLogo from '../assets/images/calendario_logo.png';
import httpClient from '../utils/httpClient';
import { useNavigate } from 'react-router-dom';

function Login() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    const navigate = useNavigate();

    const handleUsernameChange = (event) => {
        setUsername(event.target.value);
    };

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const body = {
                nombre_de_usuario: username,
                contrasenia: password,
            };
            const response = await httpClient.post('/auth/login', { data: body });
            console.log('Respuesta del servidor:', response.data);
            navigate('/UsuarioDashboard'); 
        } catch (error) {
            const errorMsg = error.response ? error.response.data : error.message;
            console.error('Error en el login:', errorMsg);
            setErrorMessage('Error en el login');
        }
    };

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
                <button type="submit">Iniciar sesión</button>
            </form>
        </>
    );
}

export default Login;