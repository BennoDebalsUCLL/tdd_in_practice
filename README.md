# TDD in practice: exercise session

Starter code for the exercise session on test-driven development.
The full instructions are in the student handout.

## What is in here

| Package | Exercise | State |
|---|---|---|
| `bookstore.shipping` | 1: shipping cost, test first | Empty. Your first test decides what goes here. |
| `bookstore.invoicing` | 2 and 3: TDD meets legacy code | A small legacy invoice service. It works. Do not trust it. |

## Build and test

Requires JDK 17 or later and Maven 3.6 or later (IntelliJ ships with both).

```
mvn test
```

Run the legacy code once to see what it does today:

```
mvn compile exec:java
```

or run `Main` from the IDE.

## How we work today

Pairs, ping-pong style. Commit on every green, with a message that names the behaviour or the refactoring.
Never refactor on red.
