# 🏨 Hotel Hunter

Sistema de gestão hoteleira em linha de comando, escrito em **Kotlin**. Todos os dados ficam em memória (sem banco de dados) e são perdidos ao encerrar o programa.

## Funcionalidades

| Módulo | Descrição |
|---|---|
| **Reservas de Quartos** | Reserva de 1 a 20 quartos (Standard, Executivo e Luxo), com taxa de serviço de 10% e mapa de ocupação. |
| **Cadastro de Hóspedes** | Cadastrar, pesquisar (nome exato e prefixo), listar em ordem alfabética, atualizar e remover (limite de 15). |
| **Eventos** | Escolha de auditório, verificação de agenda, cálculo de garçons e buffet, e relatório de custos. |
| **Ar-Condicionado** | Comparação de orçamentos de várias empresas, com desconto por quantidade e deslocamento. |
| **Abastecimento** | Compara álcool x gasolina em dois postos (Wayne Oil e Stark Petrol) para um tanque de 42 L. |
| **Relatórios** | Reservas, taxa de ocupação, hóspedes, eventos e receitas. |

## Requisitos

- **JDK 17 ou superior**
- **Kotlin** (compilador `kotlinc`) ou **IntelliJ IDEA**

## Como executar

### Opção 1: IntelliJ IDEA (mais fácil)

1. Clone o repositório:
   ```bash
   git clone <URL-DO-SEU-REPOSITORIO>
   ```
2. Abra a pasta no IntelliJ IDEA (`File > Open`).
3. Se o projeto não tiver sido criado com Gradle, crie um projeto Kotlin/JVM e copie os arquivos `.kt` para `src/main/kotlin/`.
4. Abra `Main.kt` e clique no ícone ▶ ao lado de `fun main()`.

### Opção 2: Linha de comando (kotlinc)

Na pasta onde estão os arquivos `.kt`:

```bash
# Compilar
kotlinc *.kt -include-runtime -d HotelHunter.jar

# Executar
java -jar HotelHunter.jar
```

> Instalação do Kotlin: <https://kotlinlang.org/docs/command-line.html>
> (ou via SDKMAN: `sdk install kotlin`)

## Como usar

1. Informe o **nome de usuário**.
2. Digite a **senha**: `2678` (máximo de 3 tentativas; após isso o sistema é bloqueado).
3. Escolha uma opção no menu principal (1 a 7). Ao terminar um módulo, você volta ao menu.

### Exemplo

```
Bem vindo ao Hotel Hunter
Nome do usuario: Carla
Senha: 2678
Bem-vindo ao Hotel Hunter, Carla
É um imenso Prazer ter você aqui!
===============HOTEL HUNTER===============
1 - Reserva de Quartos
2 - Cadastro de Hóspedes
3 - Eventos
4 - Ar-Condicionado
5 - Abastecimento
6 - Relatorios
7 - sair
```

### Dicas de entrada

- **Eventos:** digite o dia da semana em minúsculas e sem acento (ex.: `segunda`, `sabado`).
- **Valores monetários:** use ponto ou vírgula nos preços de combustível (ex.: `4,20` ou `4.20`); nos demais módulos, prefira ponto (ex.: `120.50`).
- **Confirmações:** responda `S` ou `N`.

## Regras de negócio

**Reservas**
- Diária > 0 e quantidade de diárias entre 1 e 30.
- Fatores por tipo: Standard `1.00`, Executivo `1.35`, Luxo `1.65`.
- `subtotal = diária × diárias × fator`; `taxa = 10%`; `total = subtotal + taxa`.

**Eventos**
- Auditório Laranja: 150 lugares + até 70 cadeiras extras. Colorado: 350 lugares.
- Funcionamento: seg–sex das 7h às 23h; sáb e dom das 7h às 15h.
- Garçons: `ceil(convidados / 12) + floor(duração / 2)`, a R$ 10,50/hora.
- Buffet: 0,2 L de café (R$ 0,80/L), 0,5 L de água (R$ 0,40/L) e 7 salgados (R$ 34,00 o cento) por convidado.

**Ar-Condicionado**
- Desconto aplicado se `quantidade >= mínimo`.
- `total = bruto - desconto + deslocamento`.

**Abastecimento**
- Etanol compensa se `preço_etanol <= preço_gasolina × 0,70`.

## Estrutura do projeto

```
.
├── Main.kt            # Login e controle de tentativas
├── Menu.kt            # Menu principal e estado em memória
├── Reservas.kt        # Subprograma de reservas de quartos
├── Hospedes.kt        # Cadastro de hóspedes
├── Eventos.kt         # Subprograma de eventos
├── Ar-Condicionado.kt # Comparativo de orçamentos
├── Abastecimento.kt   # Análise de combustível
├── Relatorios.kt      # Relatórios operacionais
└── Utils.kt           # Funções utilitárias (saída e erro)
```

Todos os arquivos pertencem ao pacote `HotelHunter`.

## Tecnologias

- Kotlin (JVM)

## Autor

Feito por **<seu nome>**: <https:[(https://github.com/eu-LucasTeodoro)>

## Licença

Defina a licença do projeto (ex.: MIT).
