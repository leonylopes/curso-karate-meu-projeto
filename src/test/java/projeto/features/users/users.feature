# language: en
#  encoding UTF-8

@smoke
Feature: Criar e lista usuario api petStore

  Background:
    * def headers = read('classpath:projeto/domain/headers.yaml')
    * def sleep = function(pause){ java.lang.Thread.sleep(pause*1000) }

  @criar_usuario
  Scenario: Criar usuario
    * def id = Java.type('projeto.support.UserUtils').randomNumericId(4)
    * def userName = Java.type('projeto.support.UserUtils').username()
    * def firstName = Java.type('projeto.support.UserUtils').firstName()
    * def lastName = Java.type('projeto.support.UserUtils').lastName()
    * def email = Java.type('projeto.support.UserUtils').email()
    * def password = Java.type('projeto.support.UserUtils').password()
    * def phone = Java.type('projeto.support.UserUtils').phone()
    * def body = read('classpath:projeto/data/request/criarUser.json')
    Given url petStoreUrl
    And path '/user'
    And headers headers.header_post
    And request body
    * print body
    When method post
    Then status 200
    * print response
    * sleep(2)


    ## Buscando usuario cadastrado
    Given url petStoreUrl
    And path '/user/' + userName
    And headers headers.header_get
    * retry until responseStatus == 200
    When method get
    Then status 200
    * print response
    * sleep(2)

    ## Deletando usuario cadastrado
    Given url petStoreUrl
    And path '/user/' + userName
    * retry until responseStatus == 200
    When method delete
    Then status 200
    * print response
    * sleep(2)

    ## Buscando usuario deletado
    Given url petStoreUrl
    And path '/user/' + userName
    And headers headers.header_get
    When method get
    Then status 404
    And match response.message == "User not found"
    * print response
