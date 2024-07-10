import React, { useState } from 'react';
import httpClient from '../utils/httpClient';
import { useNavigate } from 'react-router-dom';

const UsuarioDashboard = () => {
    const [fechaInicial, setfechaInicial] = useState('2024-07-22');
    const [horaInicial, sethoraInicial] = useState('12:00');


    const handleDateChange = (event) => {
        setfechaInicial(event.target.value);
    };

    const handleTimeChange = (event) => {
        sethoraInicial(event.target.value);
    };

    const registrarIngreso = async (event) => {
        event.preventDefault();
        try {
            const fechaHora = `${fechaInicial}T${horaInicial}:00`; 
            console.log('Fecha y hora:', fechaHora);
            const body = {
                fecha: fechaHora
            };
            const response  =await httpClient.post('/asistencia/registrarIngreso', { data: body });
            console.log('Ingreso registrado')
        } catch (error) {
            const errorMsg = error.response ? error.response.data : error.message;
            setErrorMessage('Error en el registro de asistencia');
        }
    };

    const registrarEgreso = async (event) => {
        event.preventDefault();
        try {
            const fechaHora = `${fechaInicial}T${horaInicial}:00`;
            const body = {
                fecha: fechaHora
            };
            const response = await httpClient.post('/asistencia/registrarEgreso', { data: body });
            console.log('Egreso registrado');
        } catch (error) {
            const errorMsg = error.response ? error.response.data : error.message;
            setErrorMessage('Error en el registro de egreso');
        }
    };

    return (
        <div className="dashboard_container">
            <div className='dashboard_containerimput'>
                <label htmlFor="inicial">Fecha:</label>
                <input
                    type="date"
                    id="inicial"
                    name="trip-inicial"
                    value={fechaInicial}
                    min="2018-01-01"
                    max="2018-12-31"
                    onChange={handleDateChange}
                />
            </div>

            <div className='dashboard_containerimput'>
                <label htmlFor="hora">Hora:</label> 
                <input
                    type="time" 
                    id="time"
                    name="trip-time"
                    value={horaInicial}
                    onChange={handleTimeChange} 
                />
            </div>
            <div className='dashboard_containerimput'>
                <button type="button" onClick={registrarIngreso}>Registrar Ingreso</button>
                <button type="button" onClick={registrarEgreso}>Registrar Egreso</button>
            </div>


        </div>
    );
};

export default UsuarioDashboard;