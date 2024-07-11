import React, { useState, useEffect } from 'react';
import httpClient from '../utils/httpClient';
import { useNavigate } from 'react-router-dom';

const UsuarioDashboard = () => {
    const [fechaInicial, setfechaInicial] = useState('');
    const [horaInicial, sethoraInicial] = useState('12:00');
    const [opciones, setOpciones] = useState([]);
    const [idEmpleado, setIdEmpleado] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    useEffect(() => {
        const cargarOpciones = async () => {
            try {

                const respuesta = await httpClient.get('/empleados/listar');
                setOpciones(respuesta);
            } catch (error) {
                console.error('Error al cargar las opciones', error);
                setErrorMessage('Error al cargar opciones');
            }
        };

        cargarOpciones();
    }, []);

    const handleDateChange = (event) => {
        setfechaInicial(event.target.value);
    };

    const handleTimeChange = (event) => {
        sethoraInicial(event.target.value);
    };

    const registrarIngreso = async (event) => {
        event.preventDefault();
        setErrorMessage('');
        console.log('Registrando ingreso', fechaInicial, horaInicial, idEmpleado)
        try {
            const fechaHora = `${fechaInicial}T${horaInicial}:00`;
            console.log('Fecha y hora:', fechaHora);
            const body = {
                fecha: fechaHora,
                idEmpleado: idEmpleado
            };
            const response = await httpClient.post('/asistencia/registrarIngreso', { data: body });
            if (response.success) {
                console.log(response.message);
            } else {
                setErrorMessage(response.message);
            }
        } catch (error) {
            const errorMsg = error.response ? error.response.data : error.message;
            setErrorMessage('Error en el registro de asistencia');
        }
    };

    const registrarEgreso = async (event) => {
        event.preventDefault();
        setErrorMessage('');
        try {
            const fechaHora = `${fechaInicial}T${horaInicial}:00`;
            const body = {
                fecha: fechaHora,
                idEmpleado: idEmpleado
            };
            const response = await httpClient.post('/asistencia/registrarEgreso', { data: body });
            if (response.success) {
                console.log(response.message);
                console.log(`Hora transcurrida: ${response.horaTranscurrida}`);
            } else {
                setErrorMessage(response.message);
            }
        } catch (error) {
            const errorMsg = error.response ? error.response.data : error.message;
            setErrorMessage('Error en el registro de egreso');
        }
    };

    function handleEmpleadoChange(e) {
        console.log('Empleado seleccionado:', e.target.value);
        setIdEmpleado(e.target.value);
    }

    return (


        <div className="dashboard_container">

            <div className='dashboard_containerimput'>
                <label htmlFor="opciones">Opciones:</label>
                <select id="opciones" name="opciones" value={idEmpleado}
                    onChange={handleEmpleadoChange}>

                    {opciones.map((opcion) => (
                        <option key={opcion.id_empleado} value={opcion.id_empleado}>
                            {opcion.nombre} {opcion.apellido}
                        </option>
                    ))}

                </select>
            </div>
            <div className='dashboard_containerimput'>
                <label htmlFor="inicial">Fecha:</label>
                <input
                    type="date"
                    id="inicial"
                    name="trip-inicial"
                    value={fechaInicial}
                    min="2018-01-01"
                    max={fechaInicial}
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
            <div className="error-message">{errorMessage}</div>

        </div>
    );
};

export default UsuarioDashboard;