import React from 'react';

function BotonDashboard({ onClick, texto  }) {
  return (
    <button type="button" className="boton_dashboard" onClick={onClick}>
        {texto}
    </button>
  );
}

export default BotonDashboard;