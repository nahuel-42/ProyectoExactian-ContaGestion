
const Historico = ({ datosHistorico }) => {
    if (!datosHistorico) {
        return <div>
                    <h2>Histórico general</h2>
                    No hay datos
                </div>;
    }
    datosHistorico = datosHistorico.slice(-5);
    datosHistorico.reverse();
    //Los ultimos 5 registros
    return (
        <div>
            <h2>Histórico general</h2>
            <ul>
                {datosHistorico.map((registro, index) => (
                    <li key={index}>
                        Hora: {new Date(registro.hora_registro).toLocaleString('es-ES', {
                            year: 'numeric',
                            month: 'long',
                            day: 'numeric',
                            hour: '2-digit',
                            minute: '2-digit',
                        })}, {registro.tipo_ingreso}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default Historico;