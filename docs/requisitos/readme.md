# Especificação de Requisitos de Software
Documento para específicações de requisitos do gerenciador_de_sala_mobile.
Desenvolvido por Horiel Costa e Maycon Mota para a disciplina de Programação de Dispositivos Mobile.

## Introdução

Este documento registra os requisitos detalhados da nossa entrega do trabalho para a disciplina de Programação para dispositivos mobile, na forma de requisitos textuais do produto.

## Classes de usuários

  - **Usuário Anônimo** - perfil com acesso de visualização de agendamentos e de espaços reservados;
  - **Usuário Professor** - perfil que possui os mesmos acessos do Usuário anônimo e que também pode reservar um espaço;
  - **Coordenador** - perfil com todos os acessos anteriores. Além dos já citados, tem o poder de criar, editar e excluir professores, espaços e reservas.
   
## Definição de conceitos

Nesta seção são descritos os principais conceitos relevantes para o domínio do sistema.

- **Usuário Anônimo** - usuário que não realizou o login;
- **Espaço** - Termo usado para se referir a salas, laboratórios e auditórios.
- **Disciplinas** - Termo usado para se referir a disciplinas que terão reservas repetido por determinado dia da semana, em determinado horário
- **Professores** - Termo utilizado para se referir aos professores que irão ministrar determinada disciplina e que poderão alterar as reservas efetuadas por alguma disciplina.
- **Eventos** - Termo utilizado para se referir a um evento que irá acontecer de maneira esporádica, mas que não irá se repetir.

## Requisitos de Software

Nesta seção são descritos os requisitos textuais do produto. Na Seção 4.1 são descritos os requisitos funcionais. Na Seção 4.2 são descritos os requisitos não-funcionais.

## Requisitos Funcionais

### Controle e nível de acesso:
- **[RF01]:** O sistema deve exigir que o usuário professor faça login. 
- **[RF02]:** O sistema deve exigir que o usuário coordenador façalogin.
- **[RF03]:** O usuário professor deve ser capaz de deslogar.
- **[RF04]:** O usuário moderador deve ser capaz de deslogar.
- **[RF05]:** O usuário deve ser capaz de acessar o sistema sem autenticação.

### Controle e visualização de reservas:
- **[RF06]:** O coordenador deve ser capaz de realizar a remoção de reservas do sistema, redigindo uma mensagem com o motivo da remoção para o criador da reserva.
- **[RF07]:** O moderador deve ser capaz de realizar o cadastro, a edição e a remoção de professores.
- **[RF08]:** O usuário professor deve ser capaz de cancelar uma reserva realizada ele informando o motivo da remoção.
- **[RF09]:** Somente o usuário professor que realizou a reserva e o coordenador podem removê-la.
- **[RF10]:** O usuário professor deve ser capaz de realizar reservas.
- **[RF11]:** O usuário professor deve ser capaz de editar uma reserva realizada por ele.
- **[RF12]:** O usuário deve ser capaz de ver uma reserva específica.
- **[RF13]:** O sistema deve listar para o usuário todas as reservas para uma sala solicitada dentro de um intervalo de tempo.
- **[RF14]:** O usuário professor deve ser capaz de ver todas as reservas feitas por ele.

## Requisitos Não-Funcionais

### Segurança:
- **[RNF01]**: O sistema deve diferenciar as permissões de acesso e identificação para diferentes tipos de usuários: professores e coordenadores.

### Disponibilidade:
- **[RNF02]:** O sistema deve estar disponível 24 horas por dia, 7 dias por semana.
- **[RNF03]:** O sistema no nível de permissão de usuário anônimo deve estar disponível para todos que quiserem utilizá-lo, bastandobaixá-lo em seu smartphone, desde que o aparelho tenha o sistema nas versões especificadas na seção Ambiente Operacional deste documento.
**[RNF04]:** Uma reserva só poderá ser excluída pelo coordenador caso ocorra alguma incoerência com a política de uso do sistema, com isso deve-se informar o professor do motivo da exclusão.

### Manutenabilidade
-  **[RNF05]:** O sistema deve ser construído de modo que seja possível realizar no mínimo testes funcionais.

### Usabilidade
- **[RNF06]:** O sistema deve informar ao usuário o carregamento de informações quando necessário. Essa informação pode ser dada por uma tela de carregamento ou por um ícone de carregamento.
