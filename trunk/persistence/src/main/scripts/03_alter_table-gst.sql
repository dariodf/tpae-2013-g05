ALTER TABLE gst ADD gst_cmt_emp character varying(256);
ALTER TABLE gst ADD gst_fech_real timestamp;
ALTER TABLE gst RENAME gst_fech to gst_fech_alta timestamp;