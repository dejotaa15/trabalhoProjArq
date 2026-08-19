# Desafio sobre Padrões de Projeto

O objetivo é resolver a maior quantidade de problemas usando padrões de projeto. Em todas as questões, modifique o código fornecido aplicando o padrão solicitado e apresente no `App.java` um exemplo que demonstre o funcionamento da solução.

## Q1: Classe validadora de campos string usando Strategy
Aplicar o padrão Strategy a fim de permitir acrescentar outros validadores.

## Q2: Sistema de log simples usando Singleton
Aplicar o padrão Singleton de modo que exista uma única instância do mecanismo de log, acessível de diferentes pontos do programa.

## Q3: Sistema de log com níveis usando Decorator
Esta questão parte da solução obtida na **Q2**.

Aplicar o padrão Decorator para permitir acrescentar diferentes informações no log.

Sugestões:
- envolver a mensagem de log entre colchetes: `[mensagem]`;
- colocar a mensagem de log em letras maiúsculas;
- acrescentar o string `NIVEL 1` na frente da mensagem de log;
- acrescentar o string `NIVEL 2` na frente da mensagem de log.

## Q4: Sistema de notificação usando Observer
Aplicar o padrão Observer, fazendo com que `FonteDeDados` notifique automaticamente os visualizadores quando um novo valor for acrescentado. A solução deve tornar simples o acréscimo de novos visualizadores, bem como sua ativação e desativação.

## Q5: Sistema de registro de vendas usando Composite
Aplicar o padrão Composite de maneira que uma venda possa conter tanto produtos individuais quanto kits compostos por outros produtos. Um kit pode, por sua vez, conter produtos ou outros kits.

## Q6: Dado capaz de armazenar o histórico dos valores sorteados
Aplicar o padrão Decorator sobre um dado simples para criar uma versão capaz de manter o histórico de todos os valores obtidos nas jogadas.

## Q7: Criação de notificações usando Factory Method
O sistema permite enviar diferentes tipos de notificações. Atualmente, o código cliente decide diretamente qual classe concreta deve ser instanciada.

Aplicar o padrão **Factory Method** de maneira que a criação dos objetos de notificação fique desacoplada do código que os utiliza. Acrescentar pelo menos um novo tipo de notificação para demonstrar a extensibilidade da solução.

## Q8: Integração de serviços de pagamento usando Adapter
O sistema possui uma interface `ProcessadorDePagamento` utilizada para realizar pagamentos. O serviço de cartão disponibilizado possui uma interface diferente e, por isso, não pode ser utilizado diretamente como um `ProcessadorDePagamento`.

Aplicar o padrão **Adapter** para permitir que o serviço de cartão seja utilizado através da interface `ProcessadorDePagamento`, sem modificar a classe `ServicoCartao`. O `App.java` deve demonstrar o uso das duas formas de pagamento através da mesma interface.
