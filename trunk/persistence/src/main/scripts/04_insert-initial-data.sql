DELETE FROM gst;
DELETE FROM slg;
DELETE FROM emp;
DELETE FROM spv;
DELETE FROM usr;
DELETE FROM cco;

INSERT INTO usr (usr_usr, usr_pwd, usr_ape, usr_nom, usr_dni) VALUES 
('Juan', '1234', 'Perez', 'Juan', '6.123.456'),
('Mario', '1234', 'Gomez', 'Mario', '34.123.456'),
('Maria', '1234', 'Ramirez', 'Maria', '21.123.456');

INSERT INTO emp (usr_id, emp_crg, emp_cuil, emp_ncta, emp_tel, emp_mail) VALUES
(1, 'Repartidor', '30-1234567-8', '1234567', '030345699', 'juanperez@gmail.com'),
(2, 'Vendedor', '30-9876543-2', '9234567', '030345688', 'mariogomez@gmail.com');

INSERT INTO spv (usr_id, spv_ult_acc) VALUES
(3, '2013-11-12 08:08:18');

INSERT INTO cco (cco_nom) VALUES
('Compras'),
('Marketing'),
('Ventas');