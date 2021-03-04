use bd_concredito;

/* --------- vista que devuelve información los prospectos -------------*/

create view vw_getListProspectos as
	select p.idProspecto, p.NombreProspecto, p.ApellidoPProspecto, p.ApellidoMProspecto, p.CalleDomProspecto, p.NumeroDomProspecto,
		p.ColoniaDomProspecto, p.CPDomProspecto, p.TelefonoProspecto, p.RFCProspecto, e.DescEstado from tb_prospectos p, c_estados e 
	where p.R_Estado = e.idEstado;

drop view vw_getListProspectos;

/* ------------------------------------------------------------------- */

/* --------- vista que devuelve información de las evaluaciones de los prospectos -------------*/

create view vw_getEvaluacion as
select 	sp.idSeguimiento , sp.Observaciones, sp.R_Prospecto , e.DescEstado 
        from c_estados e , tb_seguimientoprospectos sp
        where sp.R_Estado = e.idEstado;

drop view vw_getEvaluacion;        

