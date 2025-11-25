# Desafio Técnico: Booking.com - Sistema de Reservas 🏨

## 📝 Contexto
Simulação de um backend simplificado para o Booking.com. O desafio principal é gerenciar a disponibilidade de inventário (quartos) em um ambiente concorrente, onde múltiplos usuários podem tentar reservar o último quarto disponível simultaneamente.

## 🚀 Requisitos Funcionais
1.  **Listar Quartos:** Buscar quartos disponíveis por hotel.
2.  **Reservar (Book):** Transformar um quarto disponível em reservado atomicamente.
3.  **Segurança de Concorrência:** Impedir "Overbooking" (duas pessoas reservarem o mesmo quarto).

## 🧠 Conceitos-Chave & Arquitetura
* **Pessimistic Locking (JPA):** Utilização de travamento de linha no banco de dados (`SELECT ... FOR UPDATE`) para garantir que, enquanto um usuário finaliza a reserva, ninguém mais possa modificar aquele registro.
* **Transações ACID:** Garantia de que a operação de reserva é atômica (ou acontece tudo, ou não acontece nada).
* **State Pattern (Simplificado):** O quarto transita de estados: `AVAILABLE` -> `BOOKED`.

## 🛠️ Tecnologias
* Java 17 / Spring Boot 3
* H2 Database (SQL em memória)
* Spring Data JPA (Hibernate)

## 🔌 Endpoints

### `POST /rooms/book`
Tenta realizar a reserva de um quarto específico.

**Corpo da Requisição:**
```json
{
  "roomId": 1,
  "guestName": "João da Silva",
  "checkInDate": "2023-12-25",
  "checkOutDate": "2023-12-30"
}
