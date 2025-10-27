# AGM//SOFTWARE - Sistema de Turismo

Bem-vindo ao sistema de gerenciamento de pacotes turísticos **AGM//SOFTWARE - Turismo**, desenvolvido em **Java 21**, **Spring Boot 3.3.4**, **Thymeleaf** e **Bootstrap 5**.  

O sistema permite calcular pacotes nacionais e internacionais, escolher formas de pagamento, aplicar margens de lucro e taxas adicionais, e exibir resultados detalhados.

---
## 🖥️ Funcionalidades

- Cadastro e cálculo de **Pacotes Nacionais**:
  - Transporte, hospedagem, destino, quantidade de dias.
  - Margem de lucro e taxas adicionais.
  - Forma de pagamento: Cartão, Pix ou Dinheiro.
  
- Cadastro e cálculo de **Pacotes Internacionais**:
  - Inclui cotação do dólar.
  - Conversão de valores em USD para R$.
  
- **Resultado detalhado**:
  - Exibe cliente, destino, dias, forma de pagamento e valor total.
  - Confirmação de pagamento com mensagem de sucesso.

- Interface responsiva usando **Bootstrap 5**.

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.3.4**
- **Spring Data JPA**
- **Thymeleaf**
- **Bootstrap 5**
- **MySQL** (opcional para persistência)
- **Maven** (build e gerenciamento de dependências)

---
## 🚀 Como Executar o Projeto

### Pré-requisitos

- Java JDK 21
- Maven
- NetBeans 21 (opcional, mas recomendado)
- MySQL (opcional, se quiser salvar dados)
- 🌐 Navegação do Sistema

Página Inicial (index.html)

Menu de navegação para pacotes nacional e internacional.

Botões de acesso rápido para cada tipo de pacote.

Pacote Nacional (pacote-nacional.html)

Formulário para preencher transporte, hospedagem, destino, dias, cliente, margem de lucro, taxas e forma de pagamento.

Botão para calcular e finalizar pagamento.

Resultado Pacote Nacional (resultado-nacional.html)

Exibe cliente, destino, quantidade de dias, forma de pagamento e valor total.

Botões para voltar ou confirmar pagamento.

Pacote Internacional (pacote-internacional.html)

Formulário semelhante ao nacional, com campos adicionais:

Cotação do dólar

Valor total em USD e convertido em R$

Resultado Pacote Internacional (resultado-internacional.html)

Exibe cliente, destino, dias, forma de pagamento, valor em USD e valor convertido em R$.

Botões para voltar ou confirmar pagamento.

Pagamento Confirmado (pagamento-sucesso.html)

Página de confirmação com mensagem de sucesso.

Botão para voltar à página inicial.
📌 Observações

Todos os templates usam Thymeleaf, então as variáveis do backend são passadas usando ${nomeVariavel}.

A navegação entre páginas é feita via Spring MVC (@GetMapping e @PostMapping).

O sistema aplica cálculos automáticos de pacotes considerando transporte, hospedagem, dias, margem de lucro, taxas e cotação do dólar.

Responsividade garantida pelo Bootstrap 5.
📝 Licença

© 2025 AGM//SOFTWARE | Todos os direitos reservados.
