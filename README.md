# 🔐 Analisador de Senhas com Histórico de Brechas

Aplicativo Android nativo desenvolvido em **Java** com o objetivo de ajudar usuários a criar senhas mais seguras e identificar riscos de vazamento.

O aplicativo analisa a força da senha e verifica se ela já foi exposta em brechas conhecidas, sempre respeitando boas práticas de segurança.

---

## 🎯 Objetivo
Auxiliar o usuário a reduzir riscos de invasões, reutilização de senhas e vazamentos de dados.

---

## 🛠 Tecnologias Utilizadas
- Java (Android Nativo)
- Retrofit (consumo de APIs simuladas)
- Gson (serialização de dados)
- RecyclerView (exibição do histórico)
- SharedPreferences (persistência)
- SHA-256 (hashing de senhas)

---

## 🔐 Segurança
Nenhuma senha é salva ou enviada em texto puro.  
Todas são protegidas usando **hashing SHA-256**.

---

## 📱 Funcionalidades
- Análise de força da senha
- Verificação de brechas de segurança
- Histórico de análises
- Interface simples e intuitiva

---

## 🚀 Trabalhos Futuros
- Uso de SQLite para histórico avançado
- Alertas de segurança com Broadcast Receiver
- Integração com múltiplos serviços de brechas

---

📌 Projeto desenvolvido para fins acadêmicos.
