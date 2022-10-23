
# Lista de Médicos

Este projeto consiste em desenvolver uma App Android para listar médicos cadastrados na plataforma <br>
O projeto deverá ser desenvolvido com o Banco de Dados Room ou SQLite.

# Screenshots
<img src="https://github.com/FelipeGaleao/ConsultaMedica/blob/main/screenshots/screenshots.png?raw=true" height="450px">

# Modelagem do banco de dados 
### ConsultaMedico
Banco de dados implementado utilizando [Room](https://developer.android.com/jetpack/androidx/releases/room?hl=pt-br)
### Tabela Medico
  - int id;(chave primária-autoincrement)
  - int idEspecialidade; (chave estrangeira)
  - String nome;
  - String telefone;
  - String Endereco

### Tabela Especilidade
  - int id;;(chave primária-autoincrement)
  - String descricao;

## Requisitos

### 3 De forma geral, a aplicação deve:
- Permitir o registro de Especialidades Médicas;
- Permitir o registro de Médicos;
- Permitir operações como incluir, excluir e alterar dados nestas tabelas.
- Permitir o listar as especialidades e os médicos cadastrados;

  #### 3.0.1 Permitir o registro de Médicos

  A aplicação deve ser capaz de permitir ao usuário que ele adicione informações
  de novos médicos. Deve-se buscar as especialidades cadastradas pela descrição
  para listar em um spinner. Salvar o id da especialidade na tabela medico. Deve
  permitir operações como alteração e exclusão dessas informações.

  #### 3.0.2 Permitir o registro de Especialidades

  A aplicação deve ser capaz de permitir ao usuário que ele adicione informações
  de novas especialidades, assim como operações de alteração e exclusão.

  #### 3.0.3 Permitir operações como incluir, excluir e alterar dados nestas tabelas.

  O aplicativo deve permitir inserir, alterar ou excluir dados nas duas tabelas.
  Sempre que for excluir uma especialidade, é preciso verificar antes se não tem
  médico vinculado a aquela especialidade. Se tiver, ent ̃ao n ̃ao deve permitir
  excluir a especialidade.

  #### 3.0.4 Permitir o filtro para listar em um list View;

  - As especialidades cadastradas
  - Os médicos cadastrados com a respectiva especialidade 
  - Os médicos por especialidade (permitir o filtro por especialidade)


