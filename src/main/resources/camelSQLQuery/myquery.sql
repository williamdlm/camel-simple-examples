-- myquery.sql

INSERT INTO Cliente (nome, email)
VALUES (:#${exchangeProperty.nome}, :#${exchangeProperty.email});
