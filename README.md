# Automação de Testes - Dog API

## Visão Geral

Este projeto valida o comportamento da API cobrindo:

* Disponibilidade da API
* Estrutura das respostas
* Cenários positivos e negativos

Os endpoints que serão testados neste escopo
- GET /breeds/list/all
- GET /breed/{breed}/images
- GET /breeds/image/random

## Setup do Ambiente

Instalar:

* Java 21
* Maven 3.8+
* Git

## Git

Clonar o repositório para maquina local

> bash
git clone https://github.com/romulo-moraes/dog-api-test.git

## Verificar versões

bash > java -version

bash > mvn -version


## Cobertura de Testes

## Cenários positivos

* Listar todas as raças
* Obter imagem aleatória
* Obter imagens por raça

## Cenários negativos

* Requisição com raça inválida (validação de erro 404)


## Validações

Os testes garantem que:

* A API retorna os **status codes corretos**
* O payload segue o **formato esperado**
* Os dados retornados são **válidos e consistentes**
* A aplicação se comporta corretamente em **diferentes cenários**

## Execução dos Testes

Para executar todos os testes:

bash> mvn clean test

## Relatório de Testes

Para gerar o relatório HTML:

bash >
mvn surefire-report:report

Local do relatório:

target/site/surefire-report.html


O relatório contém:

* Testes executados (sucesso/falha)
* Tempo de execução
* Detalhes de erros

## Integração Contínua (CI) com GitHub Actions

* Executar testes automaticamente a cada push e pull request
* Gerar relatório de testes
* Disponibilizar resultados como artefatos

## Tecnologias

* Java 21
* Maven
* Rest Assured
* JUnit 5
* GitHub Actions

