DELETE FROM gst;
DELETE FROM slg;
DELETE FROM emp;
DELETE FROM spv;
DELETE FROM usr;
DELETE FROM cco;

INSERT INTO usr (usr_usr, usr_pwd, usr_ape, usr_nom, usr_dni) VALUES 
('juan', 'perez', 'juan', 'perez', '6.123.456'),
('mario', 'gomez', 'mario', 'gomez', '34.123.456'),
('maria', 'ramirez', 'maria', 'ramirez', '21.123.456');

INSERT INTO emp (usr_id, emp_crg, emp_cuil, emp_ncta, emp_tel, emp_mail) VALUES
(1, 'Repartidor', '30-1234567-8', '1234567', '030345699', 'juancito@gmail.com.ar'),
(2, 'Vendedor', '30-9876543-2', '9234567', '030345688', 'marito_g@gmail.com.ar');

INSERT INTO spv (usr_id, spv_ult_acc) VALUES
(3, '2013-11-12 08:08:08');

INSERT INTO cco (cco_nom) VALUES
('Centro Uno'),
('Centro Dos');

INSERT INTO slg (slg_emp_id, slg_cco_id, slg_desc, slg_imp_est, slg_est, slg_spv_id, slg_cmt_spv) VALUES
(1, 1, 'Gasto viaje a Córdoba', 2550.0, 'Rechazada', 3, 'Indicar motivo/razón del viaje.'),
(2, 2, 'Gasto publicidad en cartelería', 3000.0, 'Pendiente', null, null),
(1, 1, 'Gasto en reparación equipo de oficina maq-0132', 1200.0, 'Aprobada', 3, null);

INSERT INTO gst (gst_id, gst_slg_id, gst_fech, gst_imp, gst_nro_fact, gst_cmt_emp) VALUES 
(1, 3, '2013-11-12 08:08:09', 1200.0, '000-00001234', 'Gasto en reparación equipo de oficina maq-0132'),
(2, 2, '2013-11-13 08:09:08', 1330.0, '000-00001241', '');
