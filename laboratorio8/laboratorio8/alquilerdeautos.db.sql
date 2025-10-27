-- ==========================================================
-- BASE DE DATOS: alquilerdeautos.db
-- ==========================================================

PRAGMA foreign_keys = ON;

-- ==========================================================
-- 1. TABLA: Tipo_Vehiculo
-- ==========================================================
CREATE TABLE IF NOT EXISTS Tipo_Vehiculo (
    id_tipo INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL
);

-- ==========================================================
-- 2. TABLA: Tarifas
-- ==========================================================
CREATE TABLE IF NOT EXISTS Tarifas (
    id_tarifa INTEGER PRIMARY KEY AUTOINCREMENT,
    id_tipo INTEGER NOT NULL,
    costo_por_dia REAL NOT NULL,
    FOREIGN KEY (id_tipo) REFERENCES Tipo_Vehiculo(id_tipo)
);

-- ==========================================================
-- 3. TABLA: Sucursales
-- ==========================================================
CREATE TABLE IF NOT EXISTS Sucursales (
    id_sucursal INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    direccion TEXT NOT NULL
);

-- ==========================================================
-- 4. TABLA: Vehiculos
-- ==========================================================
CREATE TABLE IF NOT EXISTS Vehiculos (
    id_vehiculo INTEGER PRIMARY KEY AUTOINCREMENT,
    placa TEXT NOT NULL UNIQUE,
    marca TEXT NOT NULL,
    modelo TEXT NOT NULL,
    ano INTEGER NOT NULL,
    id_tipo INTEGER NOT NULL,
    id_sucursal INTEGER NOT NULL,
    disponible INTEGER NOT NULL DEFAULT 1,
    FOREIGN KEY (id_tipo) REFERENCES Tipo_Vehiculo(id_tipo),
    FOREIGN KEY (id_sucursal) REFERENCES Sucursales(id_sucursal)
);

-- ==========================================================
-- 5. TABLA: Documentos_Vehiculo
-- ==========================================================
CREATE TABLE IF NOT EXISTS Documentos_Vehiculo (
    id_documento INTEGER PRIMARY KEY AUTOINCREMENT,
    id_vehiculo INTEGER NOT NULL,
    tipo_documento TEXT NOT NULL,
    fecha_emision TEXT NOT NULL,
    fecha_vencimiento TEXT NOT NULL,
    FOREIGN KEY (id_vehiculo) REFERENCES Vehiculos(id_vehiculo)
        ON DELETE CASCADE
);

-- ==========================================================
-- 6. TABLA: Clientes
-- ==========================================================
CREATE TABLE IF NOT EXISTS Clientes (
    cliente_id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    apellido TEXT NOT NULL,
    dni TEXT UNIQUE NOT NULL,
    telefono TEXT,
    correo TEXT
);

-- ==========================================================
-- 7. TABLA: Empleados
-- ==========================================================
CREATE TABLE IF NOT EXISTS Empleados (
    empleado_id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    apellido TEXT NOT NULL,
    cargo TEXT NOT NULL,
    salario REAL NOT NULL,
    id_sucursal INTEGER NOT NULL,
    FOREIGN KEY (id_sucursal) REFERENCES Sucursales(id_sucursal)
);

-- ==========================================================
-- 8. TABLA: Alquileres
-- ==========================================================
CREATE TABLE IF NOT EXISTS Alquileres (
    id_alquiler INTEGER PRIMARY KEY AUTOINCREMENT,
    cliente_id INTEGER NOT NULL,
    id_vehiculo INTEGER NOT NULL,
    empleado_id INTEGER NOT NULL,
    fecha_inicio TEXT NOT NULL,
    fecha_fin TEXT NOT NULL,
    total REAL NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES Clientes(cliente_id),
    FOREIGN KEY (id_vehiculo) REFERENCES Vehiculos(id_vehiculo),
    FOREIGN KEY (empleado_id) REFERENCES Empleados(empleado_id)
);

-- ==========================================================
-- 9. TABLA: Pagos
-- ==========================================================
CREATE TABLE IF NOT EXISTS Pagos (
    id_pago INTEGER PRIMARY KEY AUTOINCREMENT,
    id_alquiler INTEGER NOT NULL,
    fecha_pago TEXT NOT NULL,
    monto REAL NOT NULL,
    metodo_pago TEXT NOT NULL,
    FOREIGN KEY (id_alquiler) REFERENCES Alquileres(id_alquiler)
);

-- ==========================================================
-- INSERTS DE DATOS DE PRUEBA
-- ==========================================================

-- Tipo de vehículos
INSERT INTO Tipo_Vehiculo (nombre) VALUES
('Sedán'),
('SUV'),
('Camioneta'),
('Motocicleta'),
('Furgoneta'),
('Convertible'),
('Deportivo'),
('Pickup'),
('Minivan'),
('Eléctrico');

-- Tarifas
INSERT INTO Tarifas (id_tipo, costo_por_dia) VALUES
(1, 50.00),
(2, 70.00),
(3, 80.00),
(4, 30.00),
(5, 90.00),
(6, 100.00),
(7, 150.00),
(8, 120.00),
(9, 110.00),
(10, 60.00);

-- Sucursales
INSERT INTO Sucursales (nombre, direccion) VALUES
('Sucursal Central', 'Av. Principal 123'),
('Sucursal Norte', 'Calle Norte 45'),
('Sucursal Sur', 'Av. Sur 67'),
('Sucursal Este', 'Jr. Los Pinos 89'),
('Sucursal Oeste', 'Av. Las Flores 321'),
('Sucursal Playa', 'Malecón 12'),
('Sucursal Centro', 'Plaza Mayor 5'),
('Sucursal Aeropuerto', 'Av. Aviación 202'),
('Sucursal Campo', 'Carretera 56'),
('Sucursal Montaña', 'Ruta 88');

-- Vehículos
INSERT INTO Vehiculos (placa, marca, modelo, ano, id_tipo, id_sucursal) VALUES
('ABC-123', 'Toyota', 'Corolla', 2020, 1, 1),
('DEF-456', 'Hyundai', 'Tucson', 2019, 2, 2),
('GHI-789', 'Chevrolet', 'D-Max', 2021, 3, 3),
('JKL-012', 'Honda', 'CBR500', 2022, 4, 4),
('MNO-345', 'Mercedes', 'Sprinter', 2018, 5, 5),
('PQR-678', 'Mazda', 'MX-5', 2020, 6, 6),
('STU-901', 'Ferrari', 'F8', 2022, 7, 7),
('VWX-234', 'Ford', 'Ranger', 2019, 8, 8),
('YZA-567', 'Kia', 'Carnival', 2021, 9, 9),
('BCD-890', 'Tesla', 'Model 3', 2023, 10, 10);

-- Documentos de Vehículo
INSERT INTO Documentos_Vehiculo (id_vehiculo, tipo_documento, fecha_emision, fecha_vencimiento) VALUES
(1, 'SOAT', '2024-01-01', '2025-01-01'),
(2, 'Revisión Técnica', '2024-02-15', '2025-02-15'),
(3, 'Seguro Vehicular', '2024-03-20', '2025-03-20'),
(4, 'Permiso Circulación', '2024-04-10', '2025-04-10'),
(5, 'SOAT', '2024-05-05', '2025-05-05'),
(6, 'Revisión Técnica', '2024-06-06', '2025-06-06'),
(7, 'Seguro Vehicular', '2024-07-07', '2025-07-07'),
(8, 'Permiso Circulación', '2024-08-08', '2025-08-08'),
(9, 'SOAT', '2024-09-09', '2025-09-09'),
(10, 'Revisión Técnica', '2024-10-10', '2025-10-10');

-- Clientes
INSERT INTO Clientes (nombre, apellido, dni, telefono, correo) VALUES
('Carlos', 'Ramírez', '12345678', '987654321', 'carlos@gmail.com'),
('María', 'Pérez', '87654321', '912345678', 'maria@gmail.com'),
('Luis', 'Torres', '45678912', '998877665', 'luis@gmail.com'),
('Ana', 'Gómez', '78912345', '955443322', 'ana@gmail.com'),
('Pedro', 'Díaz', '32165498', '933221100', 'pedro@gmail.com'),
('Lucía', 'Fernández', '65498732', '977665544', 'lucia@gmail.com'),
('Jorge', 'Cruz', '15975384', '966554433', 'jorge@gmail.com'),
('Sofía', 'Herrera', '95175362', '988776655', 'sofia@gmail.com'),
('Andrés', 'Lopez', '35795146', '922334455', 'andres@gmail.com'),
('Valeria', 'Suárez', '75315948', '911223344', 'valeria@gmail.com');

-- Empleados
INSERT INTO Empleados (nombre, apellido, cargo, salario, id_sucursal) VALUES
('Mario', 'Gonzales', 'Gerente', 3500.00, 1),
('Elena', 'Castro', 'Asesor', 2000.00, 2),
('Ricardo', 'Mendoza', 'Mecánico', 1800.00, 3),
('Laura', 'López', 'Administradora', 2500.00, 4),
('Pablo', 'Salas', 'Chofer', 1600.00, 5),
('Carla', 'Torres', 'Atención al Cliente', 1700.00, 6),
('Oscar', 'Huamán', 'Supervisor', 2800.00, 7),
('Patricia', 'Reyes', 'Recepcionista', 1500.00, 8),
('Fernando', 'Díaz', 'Asesor', 2000.00, 9),
('Gabriela', 'Chavez', 'Encargada', 2300.00, 10);

-- Alquileres
INSERT INTO Alquileres (cliente_id, id_vehiculo, empleado_id, fecha_inicio, fecha_fin, total) VALUES
(1, 1, 1, '2024-07-01', '2024-07-05', 250.00),
(2, 2, 2, '2024-07-03', '2024-07-06', 210.00),
(3, 3, 3, '2024-07-02', '2024-07-07', 400.00),
(4, 4, 4, '2024-07-04', '2024-07-08', 120.00),
(5, 5, 5, '2024-07-05', '2024-07-10', 450.00),
(6, 6, 6, '2024-07-06', '2024-07-11', 500.00),
(7, 7, 7, '2024-07-07', '2024-07-09', 300.00),
(8, 8, 8, '2024-07-08', '2024-07-12', 600.00),
(9, 9, 9, '2024-07-09', '2024-07-13', 550.00),
(10, 10, 10, '2024-07-10', '2024-07-15', 900.00);

-- Pagos
INSERT INTO Pagos (id_alquiler, fecha_pago, monto, metodo_pago) VALUES
(1, '2024-07-05', 250.00, 'Efectivo'),
(2, '2024-07-06', 210.00, 'Tarjeta'),
(3, '2024-07-07', 400.00, 'Transferencia'),
(4, '2024-07-08', 120.00, 'Efectivo'),
(5, '2024-07-10', 450.00, 'Tarjeta'),
(6, '2024-07-11', 500.00, 'Transferencia'),
(7, '2024-07-09', 300.00, 'Efectivo'),
(8, '2024-07-12', 600.00, 'Tarjeta'),
(9, '2024-07-13', 550.00, 'Transferencia'),
(10, '2024-07-15', 900.00, 'Efectivo');
