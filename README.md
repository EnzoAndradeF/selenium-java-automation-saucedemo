# 🧪 Automação de Testes – SauceDemo

Projeto de **automação de testes funcionais** da aplicação **SauceDemo**, desenvolvido com foco em **boas práticas de QA**, organização de código e execução automatizada via **CI**.

Os testes são executados automaticamente via **GitHub Actions** a cada push ou pull request.

---


## 🛠️ Tecnologias Utilizadas

* **Java 17**
* **Selenium WebDriver**
* **JUnit 5**
* **Maven**
* **WebDriverManager**
* **GitHub Actions** (CI)
* **Allure Reports** (execução local)

---

## 📁 Estrutura do Projeto

```
src
├── main
│   └── java
│       └── pages        # Page Objects
│       └── base         # Configurações base (Driver, Setup)
└── test
    └── java
        └── test         # Classes de teste
              
```

> O projeto segue o padrão **Page Object Model (POM)**.

---

## ✅ Cenários Automatizados

* Login com usuário válido
* Login com usuário inválido
* Adição de produto ao carrinho
* Fluxo completo de compra
* Logout do sistema

---

## ▶️ Executando os Testes Localmente

### Pré-requisitos

* Java 17+ instalado
* Maven configurado
* Navegador Microsoft Edge

### Passos

```bash
# Clonar o repositório
git clone <URL_DO_REPOSITORIO>

# Acessar a pasta do projeto
cd nome-do-projeto

# Executar os testes
mvn clean test
```

## 📊 Relatórios de Teste (Local)

### Gerar relatório

```bash
mvn allure:serve
```

O comando irá:

* Gerar o relatório
* Abrir automaticamente no navegador

O relatório apresenta:

* Status dos testes (pass/fail)
* Tempo de execução
* Detalhes de cada cenário

---

## 🔄 Integração Contínua (CI)

* Push
* Pull Request

O workflow:

* Faz checkout do código
* Configura o ambiente Java
* Executa os testes via Maven

---

## 📌 Observações

* O relatório Allure é utilizado apenas localmente
* O foco do projeto é **qualidade de código, clareza e boas práticas**, não volume excessivo de testes

---






