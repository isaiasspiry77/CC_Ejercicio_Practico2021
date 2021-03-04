use bd_concredito;

select *from c_estados;
select *from c_tipos;
select *from tb_prospectos;
select *from tb_seguimientoprospectos;

/* --------------- INSERT ESTADOS ------------------- */
insert into 
	C_Estados (ClaveEstado, DescEstado) 
values 
/* Estados de usuarios */
("AC","Activo"),("IA","Inactivo"),
/* Estado de seguimiento de prospectos */
("EN","Enviado"),("AU","Autorizado"),("RE","Rechazado");

/* ---------------------------------------------------*/


insert into tb_prospectos (NombreProspecto, ApellidoPProspecto, ApellidoMProspecto, CalleDomProspecto, NumeroDomProspecto,
ColoniaDomProspecto, CPDomProspecto, TelefonoProspecto, RFCProspecto, R_Estado) values 
("Isaias", "Espiridion", "", "Hermandad", 254, "Hidalgo", "91712", "2294745774", "sbnin", 3), 
("Eva", "Sarmiento", "Toral", "Otatital", 54, "Sotavento", "4852", "2741366819", "djdo", 3);

insert into tb_prospectos (NombreProspecto, ApellidoPProspecto, ApellidoMProspecto, CalleDomProspecto, NumeroDomProspecto,
ColoniaDomProspecto, CPDomProspecto, TelefonoProspecto, RFCProspecto, R_Estado) values 
("Eva", "Sarmiento", "Toral", "Otatital", 54, "Sotavento", "4852", "2741366819", "djdo", 3);