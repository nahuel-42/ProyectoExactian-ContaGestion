INSERT INTO roles (descripcion, nombre) VALUES ('Administrador del sistema', 'ADMIN');
INSERT INTO roles (descripcion, nombre) VALUES ('Usuario estándar', 'USER');

INSERT INTO estado_empleados (id_estado, dentro_compania, hora_ult_egreso, hora_ult_ingreso) VALUES
(11, true, '2024-07-09 17:00:00', '2024-07-10 08:00:00'),
(12, false, '2024-07-09 17:00:00', '2024-07-09 08:30:00'),
(13, true, '2024-07-10 17:00:00', '2024-07-10 08:15:00'),
(14, true, '2024-07-10 16:30:00', '2024-07-10 08:00:00'),
(15, false, '2024-07-09 17:00:00', '2024-07-09 08:30:00');

INSERT INTO empleados (id_empleado, id_estado, apellido, email, nombre) VALUES
(11, 11, 'García', 'garcia@example.com', 'Juan'),
(12, 12, 'Martínez', 'martinez@example.com', 'Ana'),
(13, 13, 'López', 'lopez@example.com', 'Pedro'),
(14, 14, 'Rodríguez', 'rodriguez@example.com', 'María'),
(15, 15, 'Fernández', 'fernandez@example.com', 'Luis');