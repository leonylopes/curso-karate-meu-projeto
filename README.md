---

# 🥋 Curso Karate - Meu Projeto

Este repositório contém um projeto de automação de testes de API utilizando o [Karate Framework](https://github.com/intuit/karate). Ele foi desenvolvido como parte de um curso prático para demonstrar como criar testes eficientes, legíveis e integrados com Java e Maven.

---

## 🚀 Pré-requisitos

Antes de rodar o projeto localmente, certifique-se de ter instalado:

- **Java JDK 11 ou superior**
- **Maven 3.6+**
- **Git** (para clonar o repositório)
- **IDE** (recomendado: IntelliJ IDEA ou VS Code)

---

## 📦 Instalação

1. Clone o repositório:

   ```bash
   git clone https://github.com/leonylopes/curso-karate-meu-projeto.git
   cd curso-karate-meu-projeto
   ```

2. Compile o projeto:

   ```bash
   mvn clean install
   ```

3. Execute os testes:

   ```bash
   mvn test
   ```

---

## 🧪 Estrutura dos testes

O projeto está organizado em módulos para facilitar a manutenção e evolução dos testes:

```
src/
└── test/
    ├── java/
    │   └── projeto/
    │       ├── domain/       # Modelos de dados
    │       ├── support/      # Utilitários Java (gerador de dados, etc.)
    │       ├── features/     # Arquivos .feature com os testes Karate
    │       └── RunTest.java  # Runner para execução dos testes
    └── resources/
        └── logback-test.xml  # Configuração de logs
```

---

## 🧰 Tecnologias utilizadas

- [Karate DSL](https://github.com/intuit/karate)
- [JUnit 5](https://junit.org/junit5/)
- [Maven](https://maven.apache.org/)
- [Java](https://www.oracle.com/java/)

---

## ⚙️ Configuração de ambiente

Você pode definir o ambiente de execução usando a propriedade `karate.env`. Exemplo:

```bash
mvn test -Dkarate.env=dev
```

O arquivo `karate-config.js` será carregado automaticamente e pode conter configurações específicas por ambiente (URLs, headers, etc).

---

## 📊 Relatórios

Após a execução, os relatórios são gerados automaticamente em:

```
target/karate-reports/
```

Você pode abrir o `karate-summary.html` para visualizar os resultados dos testes.

---

## 🙌 Contribuições

Este projeto é parte de um curso e está aberto para aprendizado. Sinta-se à vontade para abrir issues, sugerir melhorias ou usar como base para seus próprios testes.

---
