import React from 'react';
import Login from './pages/Login'; 
import UsuarioDashboard from './pages/UsuarioDashboard';
import './App.css'; 
import NotFound from './pages/NotFound';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

class App extends React.Component {
  render() {
    return (
      <>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/login" element={<Login />} />
            <Route path="/UsuarioDashboard" element={<UsuarioDashboard />} />
            <Route path="*" element={<NotFound />} />
          </Routes>
        </BrowserRouter>
      </>
    );
  }
}

export default App;