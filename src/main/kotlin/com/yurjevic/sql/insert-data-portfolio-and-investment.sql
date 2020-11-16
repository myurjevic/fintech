
-- DATA PORTFOLIO
INSERT INTO portfolio
	(portfolio_name , start_date , end_date)
VALUES
	('Mi Primer Portafolio', '2010-01-01', '2015-01-01'),
	('Rico MacPato','2010-01-01', '2015-01-01');


-- DATA INVESTMENT
INSERT INTO investment
	(portfolio_fk , etf_fk , share_amount)
VALUES
	(1 , 'USO' , 100);
