
## 2 Cadastro de Médicos

Este projeto consiste em desenvolver uma App Android de Cadastro deMédicos.
O projeto deverá ser desenvolvido com o Banco de Dados Room ou SQLite.

Nome do Banco de Dados: 
**ContatoMedico**

### Tabela Medico
- int id;(chave primária-autoincrement)
- int idEspecialidade; (chave estrangeira)
- String nome;
- String telefone;
- String Endereco
### Tabela Especilidade
- int id;;(chave primária-autoincrement)
- String descricao;

## 3 De forma geral, a aplica ̧c ̃ao deve:
- Permitir o registro de Especialidades M ́edicas;
- Permitir o registro de M ́edicos;
- Permitir operações como incluir, excluir e alterar dados nestas tabelas.
- Permitir o listar as especialidades e os m ́edicos cadastrados;

## 3.0.1 Permitir o registro de M ́edicos

A aplicação deve ser capaz de permitir ao usuário que ele adicione informações
de novos médicos. Deve-se buscar as especialidades cadastradas pela descrição
para listar em um spinner. Salvar o id da especialidade na tabela medico. Deve
permitir operações como alteração e exclusão dessas informções.

3.0.2 Permitir o registro de Especialidades

A aplica ̧c ̃ao deve ser capaz de permitir ao usu ́ario que ele adicione informa ̧c ̃oes
de novas especialidades, assim como opera ̧c ̃oes de altera ̧c ̃ao e exclus ̃ao.

3.0.3 Permitir opera ̧c ̃oes como incluir, excluir e alterar dados nestas
tabelas.

O aplicativo deve permitir inserir, alterar ou excluir dados nas duas tabelas.
Sempre que for excluir uma especialidade, ́e preciso verificar antes se n ̃ao tem
m ́edico vinculado a aquela especialidade. Se tiver, ent ̃ao n ̃ao deve permitir
excluir a especialidade.

3.0.4 Permitir o filtro para listar em um list View;

-As especialidades cadastradas
-Os m ́edicos cadastrados com a respectiva especialidade -Os m ́edicos por espe-
cialidade (permitir o filtro por especialidade)

