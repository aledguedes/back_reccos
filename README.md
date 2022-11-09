# back_reccos
# Atalhos para insersão no banco de dados (01/11)
INSERT INTO LIGA VALUES(1,'2022-09-09', '2022-01-01', 'Canindé', 'Liga 1', 'Mata-mata');

INSERT INTO LIGA VALUES(1,'2022-09-09', '2022-01-01', 'Canindé', 'Liga 1', true, 'Mata-mata');

INSERT INTO ARBITRO VALUES(1, 'Bananão', 'Juiz 01', 1, 1);

INSERT INTO TIME VALUES
(1, 'SPFC', 'Castelo', '14300000', 'São Paulo', null, '1935-09-07', 'https://image.shutterstock.com/image-photo/paulo-brazil-06072020-panoramic-view-260nw-1751134427.jpg', 'Rua São Paulo', 'São Paulo Futebol Clube', 1, 'Santo Paulo', true, '+55 00 12345-6789', 'SP', 'https://seeklogo.com/vector-logo/122586/sao-paulo-futebol-clube', 1),
(2, 'CRF', 'Aterro do Flamengo', '14300000', 'Rio de Janeiro', null, '1899-03-03', 'https://imgsapp2.correiobraziliense.com.br/app/noticia_127983242361/2013/04/16/360770/20130416164425897226o.jpg', 'Rua Rio de Janeiro', 'Clube de Regatas Flamengo', 1000, 'Santo Mengo', 0, '+55 00 98765-4321', 'RJ', 'https://logodetimes.com/wp-content/uploads/flamengo.png', 1);

INSERT INTO ATLETA VALUES
(1, 'Kokhym', 'Alexandre Guedes', 'Atacante', 0, 1),
(2, 'João', 'João Victor', 'Atacante', 1, 1),
(3, 'Thorzinho', 'Heitor Prado', 'Lateral', 1, 2);
