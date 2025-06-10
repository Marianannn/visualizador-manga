# Documentação

## Sobre

Projeto feito com a intenção de passar pelo desafio da DIO, a Digital Innovation One, a qual é uma plataforma brasileira de educação online e open education com foco em tecnologia.

## Proposta

Simular um visualizador de mangas para um usuário.

## Diagrama de classe do projeto

```mermaid
classDiagram
    class Usuario {
        -Integer id
        -String nome
        -String email
        -List~Manga~ mangas
    }

    class Manga {
        -String nome
        -String foto
        -String descricao
        -int qtdCapitulos
        -List~Capitulo~ capitulos
    }

    class Capitulo {
        -int numeroCapitulo
        -int qtdPaginas
        -List~Pagina~ paginas
    }

    class Pagina {
        -String img
    }

    Usuario "*" o-- "*" Manga : possui
    Manga "1" *-- "*" Capitulo : compõe
    Capitulo "1" *-- "*" Pagina : compõe
```
