USE gefico_a3;

INSERT INTO tb_Usuario (Login, Senha, ADM) VALUES ('admin', 'admin', 1);

INSERT INTO tb_Cliente (Nome, CPF, Idade, Preferencia, CEP, Logradouro, Cidade, UF, Bairro, Numero, Complemento, Telefone, Email, idUsuario) VALUES (
'Programação de Soluções Computacionais',
'12345678910',
50,
1,
'04046-300',
'Av. Jabaquara',
'São Paulo',
'SP',
'Vila da Saúde',
1870,
'',
'1127991677',
'ti@saojudas.com.br',
1);

-- SELECT * FROM tb_Usuario;
-- SELECT * FROM tb_Cliente;
-- SELECT * FROM tb_Pedidos;