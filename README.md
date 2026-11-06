# Caixinha da Família — v0.1

Sistema de controle de caixinha com um membro, feito em Java (console).

## 📋 Funcionalidades
- Registrar contribuições
- Registrar empréstimos
- Consultar saldo
- Listar histórico de movimentações

## 🚀 Como rodar
1. Clone o repositório
2. Abra no IntelliJ IDEA (ou Eclipse/STS)
3. Execute a classe `Main.java`

## 🧠 O que foi utilizado nesta versão
- **Array + contador:** histórico com capacidade fixa.
- **Composição:** `Caixinha` tem `Membro` e `Movimentacao[]`.
- **Defesa em profundidade:** validações no `Main`, na `Caixinha` e no `Membro`.
- **Guard clauses e `boolean`:** uso de retorno `true/false` para indicar sucesso/falha.

## 📌 Próximas versões
- [ ] v0.2 — Substituir array por `ArrayList`
- [ ] v0.3 — `enum` para tipo + composição de parcelas
- [ ] v0.4 — Datas nas movimentações
- [ ] v1.0 — Persistência em banco de dados

## 🚧 Status
Projeto em evolução.