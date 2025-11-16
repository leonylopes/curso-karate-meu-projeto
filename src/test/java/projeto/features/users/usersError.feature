# language: en
#  encoding UTF-8

@smoke
Feature: Criar e lista usuario api petStore com erro

  Background:
    * def headers = read('classpath:projeto/domain/headers.yaml')
    * def test_data = read('classpath:projeto/data/test_data/criarUserError.yaml')
    * def sleep = function(pause){ java.lang.Thread.sleep(pause*1000) }

  @criar_usuario_com_erro
  Scenario Outline: Criar usuario com erro e status code <status_code>
    * def id = <id>
    * def userName = Java.type('projeto.support.UserUtils').username()
    * def firstName = Java.type('projeto.support.UserUtils').firstName()
    * def lastName = Java.type('projeto.support.UserUtils').lastName()
    * def email = Java.type('projeto.support.UserUtils').email()
    * def password = Java.type('projeto.support.UserUtils').password()
    * def phone = Java.type('projeto.support.UserUtils').phone()
    * def body = read('classpath:projeto/data/request/criarUserError.json')
    Given url petStoreUrl
    And path '/user'
    And headers headers.header_post
    And request body
    * print body
    When method post
    Then status <status_code>
    * print response

    Examples:

      | status_code | id                          |
      | 500         | test_data.id.idAlfanumerico |