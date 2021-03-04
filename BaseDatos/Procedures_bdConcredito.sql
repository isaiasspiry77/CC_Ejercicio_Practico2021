use bd_concredito;

/* --------- Procedimiento almacenado para devolver información de un prospecto en especifico -------------*/
DELIMITER $$
	CREATE PROCEDURE getInfoProspecto(in idP int)
	BEGIN 
         select * from vw_getListProspectos p where p.idProspecto = idP; 
    END$$
DELIMITER $$

CALL getInfoProspecto(1);
DROP PROCEDURE getInfoProspecto;

/* ------------------------------------------------------------------------------------------------------ */

/* --------- Procedimiento almacenado para devolver información de un prospecto en especifico -------------*/

DELIMITER $$
	CREATE PROCEDURE addInfoProspecto(in NombreP varchar(40), in ApellidoPP varchar(50), in ApellidoMP varchar(50), in CalleDomP varchar(60), in NumeroDomP int,
in ColoniaDomP varchar(60), in CPDomP varchar(5), in TelefonoP varchar(10),in RFCP varchar(13))
	BEGIN 
         insert into tb_prospectos (NombreProspecto, ApellidoPProspecto, ApellidoMProspecto, CalleDomProspecto, NumeroDomProspecto,
			ColoniaDomProspecto, CPDomProspecto, TelefonoProspecto, RFCProspecto, R_Estado) values 
		(NombreP, ApellidoPP, ApellidoMP, CalleDomP, NumeroDomP, ColoniaDomP, CPDomP, TelefonoP, RFCP, 3);
    END$$
DELIMITER $$

CALL addInfoProspecto("Eduardo", "Soriano", "Lopez", "Hermandad", 254, "Hidalgo", "91712", "2294567893", "idsb12");
DROP PROCEDURE addInfoProspecto;

/* ------------------------------------------------------------------------------------------------------ */


/* --------- Procedimiento almacenado para devolver información de la evaluacion de un prospecto en especifico -------------*/
DELIMITER $$
	CREATE PROCEDURE getInfoEvaluacion(in idP int)
	BEGIN 
         select * from vw_getEvaluacion ev where ev.R_Prospecto = idP; 
    END$$
DELIMITER $$

CALL getInfoEvaluacion(1);
DROP PROCEDURE getInfoEvaluacion;

/* ------------------------------------------------------------------------------------------------------ */

/* --------- Procedimiento almacenado para insertar la observacion de la evaluacion de un prospecto -------------*/

DELIMITER $$
	CREATE PROCEDURE addObsvEvaluacionP(in IdEv int, in ObsrvEv varchar(300), in EstEv int)
	BEGIN 
         update tb_seguimientoprospectos set Observaciones = ObsrvEv, R_Estado = EstEv where idSeguimiento = IdEv;
    END$$
DELIMITER $$

CALL addObsvEvaluacionP(1,"ejemplo",4);
DROP PROCEDURE addObsvEvaluacionP;

/* ------------------------------------------------------------------------------------------------------ */