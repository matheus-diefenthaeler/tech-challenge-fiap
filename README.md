<h1> Tech Challenge FIAP + Alura </h1>

Este repositório contém o código do primeiro Tech Challenge da pós-graduação da FIAP + Alura. O Tech Challenge foi projetado para avaliar habilidades de programação e solução de problemas, baseado no que foi aprendido durante o primeiro módulo da pós-graduação. Ele consistiu na elaboração de três APIs, cada uma com uma função distinta, que um portal poderá consumir para apresentar aos usuários os dados de consumo de cada um de seus eletrodomésticos.

<h2> Documentação das APIs </h2>

A primeira API é a API de Gestão de Endereços. Ela tem como função gerenciar as informações referentes aos endereços cadastrados em nosso sistema, recebendo como informações a rua, número, complemento, bairro, cidade e estado. Esta API lida com a requisição de quatro endpoints, que serão listados abaixo.

+ “/address”, request method: `POST` - através deste endpoint, podemos criar e salvar novos endereços em nosso sistema. 
+ “/address/{id}”, request method: `GET` - através deste endpoint, podemos consultar algum endereço baseado em seu ID, que é atribuído no momento de registro.
+ “/address/{id}”, request method: `DELETE` - através deste endpoint, podemos deletar de nosso sistema algum endereço anteriormente registrado, baseado em seu ID.
+ “/address”, request method: `GET` - através deste endpoint, o sistema retorna uma lista que consiste de todos os endereços cadastrados.

---
Exemplo de JSON para cadastrar um endereço na API de Gestão de Endereços:
```JSON
{
    "street": "Rua das Graças",
    "state": "PERNAMBUCO",
    "number": "12",
    "complement": "Ap 202, bloco 9",
    "city": "Recife",
    "neighborhood": "Alto do Mandú"
}
```
Response da requisição acima na API de Gestão de Endereços, que retorna com o Http Status 201:

```JSON
{
    "id": 1,
    "street": "Rua das Graças",
    "number": "12",
    "complement": "Ap 202, bloco 9",
    "city": "Recife",
    "state": "PE",
    "neighborhood": "Alto do Mandú"
}
```


---
A segunda API é a API de Gestão de Pessoas. Ela tem como função gerenciar as informações referentes aos indivíduos cadastrados em nosso sistema, recebendo como informações o nome, CPF, data de nascimento, sexo e o parentesco com outro usuário do sistema. Esta API lida com a requisição de quatro endpoints, que serão listados abaixo.

+ “/person”, request method: `POST` - através deste endpoint, podemos criar e salvar novas pessoas em nosso sistema. 
+ “/person/{id}”, request method: `GET` - através deste endpoint, podemos consultar algum indivíduo baseado em seu ID, que é atribuído no momento de registro.
+ “/person/{id}”, request method: `DELETE` - através deste endpoint, podemos deletar de nosso sistema alguma pessoa anteriormente registrada, baseado em seu ID.
+ “/person”, request method: `GET` - através deste endpoint, o sistema retorna uma lista que consiste de todas as pessoas cadastradas.

---
Exemplo de JSON para cadastrar uma pessoa na API de Gestão de Pessoas:
```JSON
{
    "name": "Lucas D.",
    "cpf": "123321123321",
    "birthDate": "1991-09-19",
    "kinship": {
        "personId": 1,
        "kinship": "PAI"
    },
    "sex": "male"
}
```
Response da requisição acima na API de Gestão de Pessoas, que retorna com o Http Status 201:
```JSON
{
    "id": 4,
    "name": "Lucas D.",
    "cpf": "123321123321",
    "birthDate": "1991-09-19",
    "kinship": "Pai",
    "kinshipRelatedTo": 1,
    "sex": "male"
}
```
---
A terceira API é a API de Gestão de Eletrodomésticos. Ela tem como função gerenciar as informações referentes aos aparelhos eletrônicos dos usuários cadastrados em nosso sistema, recebendo como informações o nome do aparelho, a potência, o modelo e a unidade de medida. Esta API lida com a requisição de quatro endpoints, que serão listados abaixo.

+ “/device”, request method: `POST` - através deste endpoint, podemos criar e salvar novos aparelhos eletrônicos em nosso sistema.
+ “/device/{id}”, request method: `GET` - através deste endpoint, podemos consultar algum aparelho eletrônico baseado em seu ID, que é atribuído no momento de registro.
+ “/device/{id}”, request method: `DELETE` - através deste endpoint, podemos deletar de nosso sistema algum aparelho eletrônico anteriormente registrado, baseado em seu ID.
+ “/device”, request method: `GET` - através deste endpoint, o sistema retorna uma lista que consiste de todos os aparelhos eletrônicos cadastrados.

---
Exemplo de JSON para cadastrar um eletrodoméstico na API de Gestão de Eletrodomésticos:
```JSON
{
    "name": "Bulb",
    "power": "60",
    "model": "V1-ABC",
    "unit": "W"
}
```
Response da requisição acima na API de Gestão de Eletrodomésticos, que retorna com o Http Status 201:
```JSON
{
    "id": 1,
    "name": "Bulb",
    "power": "60",
    "model": "V1-ABC",
    "unit": "W"
}
```
---

<h2> Relatório Técnico </h2>

<h3> Tecnologias utilizadas </h3>

<table>
    <tr>
        <td>Spring Boot</td>
        <td>Java</td>
        <td>MySQL</td>
    </tr>
    <tr>
        <td>3.0.6</td>
        <td>17</td>
        <td>8.0</td>
    </tr>
</table>

<h3> Arquitetura do projeto </h3>

Em relação à arquitetura do projeto, separamos a nossa aplicação em camadas, a especificar: Controller, Service, Entity, Repository e DTOs. Os benefícios de organizar o projeto desta forma são diversos, conforme discutido ao longo do 1º módulo da pós-graduação, e aqui serão elencads algumas das vantagens.

+ Separação de responsabilidades: Ao dividir o código em camadas, cada camada possui uma responsabilidade claramente definida.
+ Reutilização de código: Com a organização em camadas, é mais fácil identificar e isolar as funcionalidades reutilizáveis em diferentes partes do sistema.
+ Manutenção facilitada: Ao dividir o código em camadas, as alterações ou correções em uma determinada funcionalidade podem ser feitas em uma camada específica, sem afetar as demais. Isso torna a manutenção do código mais fácil.
+ Escalabilidade do sistema: A organização em camadas facilita a escalabilidade do sistema. Por exemplo, se o sistema precisa lidar com um aumento significativo no número de requisições, é possível escalar a camada de Controllers separadamente da camada de Services ou Repositories. Isso permite um melhor gerenciamento de recursos.

A utilização de DTOs também é importante, visando aumentar a segurança da aplicação, o respeito à separação de responsabilidades e, ainda, a redução do tráfego de redes. Foi feita a escolha de criar manualmente as classes de Request, Response e o Mapper de cada uma das entidades do Tech Challenge, com o objetivo de ter mais controle sobre o código e não ficar suscetível a problemas de compatibilidade entre o Java e as outras possibilidades de mapear entidades e DTOs, como por exemplo o JMapper e o Mapstruct. 

Outra questão que foi debatida foi a forma de representar a relação de parentesco entre os indivíduos cadastrados na API de Gestão de Pessoas. Foi decidido utilizar um Enumerator com as diversas possibilidades de parentesco, visando facilitar a clareza, a legibilidade e a integridade do código, evitando erros de digitação ou referências inválidas. 
