import React from 'react';


function BotonDashboard({ onClick, texto, type }) {
  return (
    <button type= {type} className="boton_dashboard" onClick={onClick}>
        {texto}
    </button>
  );
}

export default BotonDashboard;