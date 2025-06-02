/*
 *   ISEL-DEETC-SisInf
 *   ND 2022-2025
 *
 *
 *   Information Systems Project - Active Databases
 *
 */

/* ### DO NOT REMOVE THE QUESTION MARKERS ### */

--funcao para ver os triggers que temos
SELECT event_object_table AS tabela,
       trigger_name,
       action_timing AS quando,
       event_manipulation AS evento
FROM information_schema.triggers;
drop TRIGGER  update_rider_instead on rider;
-- region Question 1.a
CREATE OR REPLACE FUNCTION trigger_scooter_is_on_the_dock()
RETURNS TRIGGER AS $$
BEGIN
	IF not exists (
		SELECT 1 FROM dock WHERE scooter = new.scooter and state = 'occupy'
	)
	THEN
		RAISE EXCEPTION 'Nao pode ser reservada a viagem pois essa trotinete nao esta presente numa doca';
END IF;
RETURN NEW; -- retorna tuplo inserido
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER  trigger_scooter_is_on_the_dock
    BEFORE INSERT ON Travel
    FOR EACH ROW
    EXECUTE FUNCTION  trigger_scooter_is_on_the_dock()

INSERT INTO TRAVEL (dinitial, comment, evaluation, dfinal, client, scooter, stinitial, stfinal)
VALUES ('2025-05-01 10:00:00', 'Viagem de teste', 5, '2025-05-01 10:30:00', 1, 6, 1, 2);
--TODO
-- endregion
--uma trotineta e um utilizador s´o podem participar numa ´unica viagem a decorrer.
-- region Question 1.b
CREATE OR REPLACE FUNCTION trigger_scooter_and_client_is_availabe()
RETURNS TRIGGER AS $$
BEGIN
    -- verifica se client and trotinete ja existem em travel
    if exists (
		select 1 from travel where client = new.client and scooter = new.scooter
	) then
		if exists(
        --nao pode existir duas viagens em simultaneo para o mesmo cliente ou para a mesma trotineta
			SELECT 1 FROM travel WHERE dfinal IS NULL AND (client = NEW.client OR scooter = NEW.scooter )
		)
	THEN
		RAISE EXCEPTION 'Nao foi possivel reservar uma viagem pois o cliente ou uma trotinete estao ja numa viagem';
end if;
end if;
RETURN NEW; -- retorna tuplo inserido
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER  trigger_scooter_and_client_is_availabe
    BEFORE INSERT ON TRAVEL
    FOR EACH ROW
    EXECUTE FUNCTION  trigger_scooter_and_client_is_availabe()

INSERT INTO travel (dinitial, comment, evaluation, dfinal, client, scooter, stinitial, stfinal)
VALUES ('2025-01-20 10:00:00', NULL, NULL, NULL, 1, 3, 1, NULL);
--TODO
-- endregion

-- region Question 2
-- Quantas docas estão ocupadas em relação ao total de docas na estação---objetivooo nº dock state = 'ocuppy' / nº total de docas
CREATE OR REPLACE function fx_dock_occupancy(stationkid integer)
RETURNS numeric as $$
declare
totalDocks numeric;
    occupyDocks numeric;
    total numeric;
begin
	--contar numero total de docks
select count(*) into totalDocks from dock where station = stationkid;
--contar numero de docks que estao com state = occupy
select count(*) into occupyDocks from dock where station = stationkid  AND state = 'occupy';
total:=occupyDocks/totalDocks;
return total;
end;
$$ LANGUAGE plpgsql;

SELECT fx_dock_occupancy(3);

CREATE OR REPLACE PROCEDURE sp_chama_fx_dock_occupancy(
    IN stationkid INTEGER,
    OUT occupancy_ratio NUMERIC
)
LANGUAGE plpgsql
AS $$
BEGIN
    occupancy_ratio := fx_dock_occupancy(stationkid);
END;
$$;

CREATE OR REPLACE PROCEDURE pr_dock_occupancy(
    IN stationkid INTEGER,
    OUT occupancy NUMERIC
)
AS $$
BEGIN
    occupancy := fx_dock_occupancy(stationkid);
END;
$$ LANGUAGE plpgsql;

SELECT
    routine_schema,
    routine_name,
    data_type
FROM
    information_schema.routines
WHERE
    routine_type = 'PROCEDURE'
ORDER BY
    routine_schema, routine_name;
--TODO
-- endregion

-- region Question 3
CREATE OR REPLACE VIEW RIDER
AS
SELECT p.*,c.dtregister,cd.id AS cardid,cd.credit,cd.typeofcard
FROM CLIENT c INNER JOIN PERSON p ON (c.person=p.id)
              INNER JOIN CARD cd ON (cd.client = c.person);

--criar triggers INSTEAD OF pois permeite que facamos insert e neste caso updates a uma vista que tem varias tabelas
--E assim o update e insert funcionam como um insert so numa tabela.
create or replace function rider_insert_trigger()
returns trigger as $$
declare
person_id integer;
begin
insert into PERSON (name, taxnumber,email) values (NEW.name, NEW.taxnumber, NEW.email) returning id into person_id;
insert into CLIENT (person, dtregister) values (person_id, NEW.dtregister);
insert into CARD (client, credit, typeofcard) values (person_id, NEW.credit, NEW.typeofcard);
return new;
end;
$$ language plpgsql;



CREATE TRIGGER insert_rider_instead
    INSTEAD OF INSERT ON RIDER
    FOR EACH ROW
    EXECUTE FUNCTION rider_insert_trigger();

INSERT INTO RIDER (email, taxnumber, name, dtregister, credit, typeofcard)
VALUES (
           'ana.mendes@email.com', 112233445, 'Ana Mendes',
           '2025-05-01 10:00:00', 10.00, 'resident'
       );

create or replace function rider_update_trigger()
returns trigger AS $$
begin
update PERSON set
                  name = new.name,
                  taxnumber = new.taxnumber,
                  email = new.email
where id = old.id;

update CLIENT set dtregister = new.dtregister where person = old.id;

update CARD set
                credit = new.credit,
                typeofcard = new.typeofcard
where client = old.id;

return new;
end;
$$ language plpgsql;

CREATE TRIGGER update_rider_instead
    INSTEAD OF UPDATE ON RIDER
    FOR EACH ROW
    EXECUTE FUNCTION rider_update_trigger();

UPDATE RIDER
SET name = 'Ana S. Mendes',
    credit = 15.00,
    typeofcard = 'tourist'
WHERE email = 'ana.mendes@email.com';
-- endregion

-- region Question 4
CREATE OR REPLACE PROCEDURE startTrip(dockid integer, clientid  integer)
as $$
DECLARE
scooter_id integer;
station_id integer;
BEGIN
SELECT scooter, station
INTO scooter_id, station_id
FROM dock
WHERE number = dockid AND state = 'occupy';
--nova viagem
insert into travel (dinitial, comment, evaluation, dfinal, client, scooter, stinitial, stfinal)
values (NOW(), NULL, NULL, NULL, clientid, scooter_id, station_id, NULL);

update dock set
                scooter = NULL,
                state = 'free'
WHERE number = dockid;
END;
$$ language plpgsql;
--nao testei,so falta isso
CALL startTrip(1, 1);
--TODO
-- endregion