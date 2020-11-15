-- DROP TABLES
drop table share_price;
drop table exchange_traded_fund;
drop table portfolio;


-- DROP SEQUENCES
drop sequence asc_company_id;
drop sequence asc_share_price_pk;
drop sequence asc_porfolio_id;


-- CREATE SEQUENCES
CREATE SEQUENCE asc_company_id
START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE asc_share_price_pk
START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE asc_porfolio_id
START WITH 1 INCREMENT BY 1;


-- CREATE TABLE EXCHANGE_TRADED_FUND
CREATE TABLE exchange_traded_fund
(
	id uuid NOT NULL default gen_random_uuid(),
	company_id INT default nextval('asc_company_id'),
	company_symbol VARCHAR(48) unique NOT NULL PRIMARY KEY,
	company_name VARCHAR(48) unique NOT NULL,
	trading_start_date DATE NOT null,
	trading_end_date DATE not null
);


-- CREATE TABLE SHARE_PRICE
create table share_price
(
	id INT default nextval('asc_share_price_pk') primary key,
	company_symbol VARCHAR(48) not null,
	share_date DATE not NULL,
	price_open DECIMAL(19,4) not NULL,
	price_high DECIMAL(19,4) not NULL,
	price_low DECIMAL(19,4) not NULL,
	price_close DECIMAL(19,4) not NULL,
	FOREIGN KEY (company_symbol) REFERENCES exchange_traded_fund(company_symbol),
	UNIQUE (company_symbol, share_date)
);


-- CREATE TABLE PORTFOLIO
create table portfolio
(
    id INT default nextval('asc_porfolio_id'),
    company_symbol VARCHAR(48) not null ,
    start_date DATE not null,
    end_date DATE not null,
    share_amount Integer not null,
    FOREIGN KEY (company_symbol) REFERENCES exchange_traded_fund(company_symbol)
);