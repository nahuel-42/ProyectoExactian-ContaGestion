import React, { useState, useEffect } from 'react';
import httpClient from '../utils/httpClient';
import Historico from '../components/Historico';
import BotonDashboard from '../components/BotonDashboard';
import { useNavigate } from 'react-router-dom';
import { formatoTiempo } from '../utils/utils';
const UsuarioDashboard = () => {
    const [fechaInicial, setfechaInicial] = useState('');
    const [horaInicial, sethoraInicial] = useState('12:00');
    const [opciones, setOpciones] = useState([]);
    const [idEmpleado, setIdEmpleado] = useState('default');
    const [errorMessage, setErrorMessage] = useState('');
    const [datosHistoricos, setDatosHistoricos] = useState([]);
    const [horaTranscurrida, setHoraTranscurrida] = useState('');
    const [mostrarHoraTranscurrida, setMostrarHoraTranscurrida] = useState(false);
    const navigate = useNavigate();


    const cargarHistorico = async () => {
        try {

            const respuesta = await httpClient.get('/historico/listar');
            setDatosHistoricos(respuesta);
        } catch (error) {
            console.error('Error al cargar el historico', error);
            setErrorMessage('Error al cargar historico');
        }
    };

    useEffect(() => {
        const cargarOpciones = async () => {
            try {
                const respuesta = await httpClient.get('/empleados/listar');
                setOpciones(respuesta);
            } catch (error) {
                if (error.response.status === 403) {
                    navigate('/login');
                } else {
                    errorMsg = error.response.data || 'Error en el servidor';
                }
            }
        };

        inicializarDatos();
        cargarHistorico();
        cargarOpciones();
    }, []);


    const inicializarDatos = () => {
        const ahora = new Date();
        const fechaFormateada = `${ahora.getFullYear()}-${("0" + (ahora.getMonth() + 1)).slice(-2)}-${("0" + ahora.getDate()).slice(-2)}`;
        setfechaInicial(fechaFormateada);
        sethoraInicial(`${("0" + ahora.getHours()).slice(-2)}:${("0" + ahora.getMinutes()).slice(-2)}`);
    };


    const handleDateChange = (event) => {
        setfechaInicial(event.target.value);
    };

    const handleTimeChange = (event) => {
        sethoraInicial(event.target.value);
    };

    function handleEmpleadoChange(e) {
        console.log('Empleado seleccionado:', e.target.value);
        setIdEmpleado(e.target.value);
        limpiarMensajeError();
        setMostrarHoraTranscurrida(false);
    }

    const esValidoEmpleado = () => {
        console.log('Empleado seleccionado:', idEmpleado);
        if (idEmpleado == 'default') {
            setErrorMessage('Debe seleccionar un empleado');
            console.log('Debe seleccionar un empleado');
            return false;
        }
        return true;
    }

    const limpiarMensajeError = () => {
        
        setErrorMessage('');
    };

    const registrarIngreso = async (event) => {
        event.preventDefault();
        setErrorMessage('');
        setMostrarHoraTranscurrida(false);
        if (esValidoEmpleado()) {
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
                    cargarHistorico();
                    setErrorMessage(response.message);
                } else {
                    setErrorMessage(response.message);
                }
            } catch (error) {
                if (error.response.status === 403) {
                    navigate('/login');
                } else {
                    errorMsg = error.response.data || 'Error en el servidor';
                }
            }
        }
    };

    const registrarEgreso = async (event) => {
        event.preventDefault();
        limpiarMensajeError();
        if (esValidoEmpleado()) {
            try {
                const fechaHora = `${fechaInicial}T${horaInicial}:00`;
                const body = {
                    fecha: fechaHora,
                    idEmpleado: idEmpleado
                };
                const response = await httpClient.post('/asistencia/registrarEgreso', { data: body });
                if (response.success) {
                    console.log(response.message);
                    cargarHistorico();
                    setHoraTranscurrida(response.horaTranscurrida);
                    setMostrarHoraTranscurrida(true);
                    setErrorMessage(response.message);

                } else {
                    setErrorMessage(response.message);
                }
            } catch (error) {
                if (error.response.status === 403) {
                    navigate('/login');
                } else {
                    errorMsg = error.response.data || 'Error en el servidor';
                }
            }
        }
    };

    return (

        <div className="dashboard_container">

            <div className="titulo_principal">
                <h1 id= "titulo_UsuarioDashboard">Registrar ingresos y egresos</h1>
            </div>
            <div className='dashboard_containerimput'>
                <label htmlFor="opciones">Opciones:</label>
                <select className='select_empleados' id="opciones" name="opciones" value={idEmpleado}
                    onChange={handleEmpleadoChange}>
                    <option value="">Seleccione el empleado</option>

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
                <BotonDashboard onClick={registrarIngreso} texto="Registrar Ingreso" />
                <BotonDashboard onClick={registrarEgreso} texto="Registrar Egreso" />
            </div>
            {mostrarHoraTranscurrida && (<div className='dashboard_containerimput borde_negro'>
                <p>Hora transcurrida del empleado seleccionado: </p>
                <div >
                    <p className='horas_transcurridas'>{formatoTiempo(horaTranscurrida)}</p>
                </div>
            </div>
            )}
            <div className="dashboard_containerimput error-message">{errorMessage}</div>
            <Historico  datosHistorico={datosHistoricos} />
        </div>
    );
};

export default UsuarioDashboard;