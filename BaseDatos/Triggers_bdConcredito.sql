use bd_concredito;



/*Trigger despues de insertar un prospecto se agrega el seguimiento del mismo en donde lo evaluara posteriormente el promotor*/
DELIMITER $$
    Create trigger TG_AI_InsertSegumientoPros
	after insert 
    on tb_prospectos
    for each row
    begin
		insert into tb_seguimientoprospectos(R_Prospecto,R_Estado) values (new.idProspecto,3);
	end;
    $$
DELIMITER ;

drop TRIGGER TG_AI_InsertSegumientoPros;
/* ------------------------------------------------------------------------------------------------------ */

/* Trigger para actualizar el estado del prospecto despues de que se actulice el estado de la evaluacion */

DELIMITER $$
    Create trigger TG_AU_EditEstatusProspecto
	after update 
    on tb_seguimientoprospectos
    for each row
    begin
		if new.R_Estado=4 then
			update tb_prospectos set R_Estado=4 where idProspecto = new.R_Prospecto;
		elseif new.R_Estado=5 then
			update tb_prospectos set R_Estado=5 where idProspecto = new.R_Prospecto;
		end if;
	end;
    $$
DELIMITER ;

drop TRIGGER TG_AU_EditEstatusProspecto;

/* ------------------------------------------------------------------------------------------------------ */
