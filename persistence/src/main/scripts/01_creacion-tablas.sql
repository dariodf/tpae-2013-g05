DROP TABLE gst;
DROP SEQUENCE seq_gst;
DROP TABLE slg;
DROP SEQUENCE seq_slg;
DROP TABLE cco;
DROP SEQUENCE seq_cco;
DROP TABLE spv;
DROP TABLE emp;
DROP TABLE usr;
DROP SEQUENCE seq_usr;


CREATE SEQUENCE seq_usr START 1;
CREATE TABLE usr ( 
	usr_id integer NOT NULL DEFAULT nextval('seq_usr'),
	usr_usr varchar(16) NOT NULL,
	usr_pwd varchar(16) NOT NULL,
	usr_ape varchar(48) NOT NULL,
	usr_nom varchar(48) NOT NULL,
	usr_dni varchar(10) NOT NULL,
	CONSTRAINT usr_pk PRIMARY KEY (usr_id)
);

CREATE TABLE emp ( 
	usr_id integer NOT NULL,
	emp_crg varchar(64) NOT NULL,
	emp_cuil varchar(16) NOT NULL,
	emp_ncta varchar(30) NOT NULL,
	emp_tel varchar(20),
	emp_mail varchar(48),
	CONSTRAINT emp_pk PRIMARY KEY (usr_id),
	CONSTRAINT emp_fk_usr FOREIGN KEY (usr_id) REFERENCES usr (usr_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE spv ( 
	usr_id integer NOT NULL,
	spv_ult_acc timestamp NOT NULL,
	CONSTRAINT spv_pk PRIMARY KEY (usr_id),
	CONSTRAINT spv_fk_usr FOREIGN KEY (usr_id) REFERENCES usr (usr_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE SEQUENCE seq_cco START 1;
CREATE TABLE cco ( 
	cco_id integer NOT NULL DEFAULT nextval('seq_cco'),
	cco_nom varchar(48) NOT NULL,
	CONSTRAINT cco_pk PRIMARY KEY (cco_id)
);

CREATE SEQUENCE seq_slg START 1;
CREATE TABLE slg ( 
	slg_id integer NOT NULL DEFAULT nextval('seq_slg'),
	slg_emp_id integer NOT NULL,
	slg_cco_id integer NOT NULL,
	slg_desc varchar(256) NOT NULL,
	slg_imp_est numeric(10,2) NOT NULL,
	slg_est varchar(16) NOT NULL,
	slg_spv_id integer,
	slg_cmt_spv varchar(256),
	CONSTRAINT slg_pk PRIMARY KEY (slg_id),
	CONSTRAINT slg_fk_emp FOREIGN KEY (slg_emp_id) REFERENCES emp (usr_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT slg_fk_cco FOREIGN KEY (slg_cco_id) REFERENCES cco (cco_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT slg_fk_spv FOREIGN KEY (slg_spv_id) REFERENCES spv (usr_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE SEQUENCE seq_gst START 1;
CREATE TABLE gst ( 
	gst_id integer NOT NULL,
	gst_slg_id integer NOT NULL,
	gst_fech timestamp NOT NULL,
	gst_imp numeric(10,2) NOT NULL,
	gst_nro_fact varchar(24) NOT NULL,
	gst_cmt_emp varchar(256),
	CONSTRAINT gst_pk PRIMARY KEY (gst_id),
	CONSTRAINT gst_fk_slg FOREIGN KEY (gst_slg_id) REFERENCES slg (slg_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);
