-- DROP TABLES
drop table share_price;
drop table investment;
drop table portfolio;
drop table exchange_traded_fund;


-- DROP SEQUENCES
drop sequence asc_share_price_id;
drop sequence asc_portfolio_id;
drop sequence asc_investment_id;
drop sequence asc_etf_id;


-- CREATE SEQUENCES
CREATE SEQUENCE asc_etf_id
START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE asc_share_price_id
START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE asc_portfolio_id
START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE asc_investment_id
START WITH 1 INCREMENT BY 1;


-- CREATE TABLE EXCHANGE_TRADED_FUND
CREATE TABLE exchange_traded_fund
(
	id INT default nextval('asc_etf_id'),
	short_name VARCHAR(48) unique NOT NULL PRIMARY KEY,
	long_name VARCHAR(48) unique NOT NULL,
	fund_open_date DATE NOT null,
	fund_close_date DATE not null
);


-- CREATE TABLE SHARE_PRICE
create table share_price
(
	id INT default nextval('asc_share_price_id') NOT NULL primary key,
	etf_fk VARCHAR(48) not null,
	share_date DATE not NULL,
	price_open DECIMAL(19,4) not NULL,
	price_high DECIMAL(19,4) not NULL,
	price_low DECIMAL(19,4) not NULL,
	price_close DECIMAL(19,4) not NULL,
	FOREIGN KEY (etf_fk) REFERENCES exchange_traded_fund(short_name),
	UNIQUE (etf_fk, share_date)
);


-- CREATE TABLE PORTFOLIO
create table portfolio
(
    id INT default nextval('asc_portfolio_id') NOT NULL PRIMARY key,
    portfolio_name VARCHAR(48) UNIQUE not null ,
    start_date DATE not null,
    end_date DATE not null
);


--  CREATE TABLE INVESTMENT
create table investment
(
    id INT default nextval('asc_investment_id') NOT NULL PRIMARY KEY,
    portfolio_fk INT not null,
	etf_fk VARCHAR(48) unique not null,
    share_amount Integer not null,
	FOREIGN KEY (portfolio_fk) REFERENCES portfolio(id),
	FOREIGN KEY (etf_fk) REFERENCES exchange_traded_fund(short_name)
);