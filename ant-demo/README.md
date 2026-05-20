# Ant Demo — Seminário "Explorando Ferramentas de Build"

Projeto de demonstração prática do **Apache Ant** desenvolvido para o seminário da disciplina de Gerência de Configuração e Evolução de Software (GCES).

O projeto é uma aplicação Java simples com dois módulos (`Calculator` e `StringUtils`), testes unitários JUnit e um `build.xml` que demonstra todos os recursos principais do Ant.

---

## Pré-requisitos

| Ferramenta   | Versão mínima | Download                          |
|--------------|---------------|-----------------------------------|
| Java JDK     | 11+           | https://adoptium.net              |
| Apache Ant   | 1.10+         | https://ant.apache.org/bindownload.cgi |

Verifique a instalação:
```bash
java -version
ant -version
```

---

## Estrutura do Projeto

```
ant-demo/
├── build.xml                      ← Script de build (coração do Ant)
├── lib/
│   ├── junit-4.13.2.jar           ← Dependência de teste
│   └── hamcrest-core-1.3.jar      ← Dependência de teste
├── src/
│   └── com/demo/
│       ├── Calculator.java        ← Operações aritméticas
│       ├── StringUtils.java       ← Utilitários de string
│       └── Main.java              ← Ponto de entrada da aplicação
├── test/
│   └── com/demo/
│       ├── CalculatorTest.java    ← 5 testes unitários
│       └── StringUtilsTest.java   ← 3 testes unitários
└── dist/                          ← Artefatos gerados pelo build
    ├── ant-demo.jar               ← JAR executável
    ├── docs/index.html            ← Documentação Javadoc
    └── reports/html/index.html    ← Relatório HTML dos testes
```

---

## Comandos Disponíveis

| Comando        | Descrição                                               |
|----------------|---------------------------------------------------------|
| `ant all`      | **Build completo:** clean → compile → jar → javadoc (padrão) |
| `ant compile`  | Compila os fontes Java em `build/classes/`              |
| `ant jar`      | Gera o JAR executável em `dist/ant-demo.jar`            |
| `ant test`     | Compila e executa os 8 testes JUnit (gera XML)          |
| `ant report`   | Gera relatório HTML dos testes em `dist/reports/html/`  |
| `ant javadoc`  | Gera documentação da API em `dist/docs/`                |
| `ant inspect`  | Exibe o manifesto e as classes empacotadas no JAR       |
| `ant run`      | Executa a aplicação (`dist/ant-demo.jar`)               |
| `ant clean`    | Remove todos os artefatos gerados (`build/` e `dist/`)  |

Para listar todos os targets com descrição:
```bash
ant -projecthelp
```

---

## Como Rodar

### 1. Build completo (primeira execução)
```bash
ant all
```
Gera o JAR em `dist/ant-demo.jar` e a documentação em `dist/docs/`.

### 2. Executar a aplicação
```bash
ant run
```
Ou diretamente pelo Java, sem precisar do Ant:
```bash
java -jar dist/ant-demo.jar
```

### 3. Rodar os testes + relatório HTML
```bash
ant report
```
Abre o relatório em `dist/reports/html/index.html` no navegador.

### 4. Gerar somente a documentação
```bash
ant javadoc
```
Abre a documentação em `dist/docs/index.html` no navegador.

### 5. Examinar o artefato gerado
```bash
ant inspect
```
Exibe o manifesto do JAR (Main-Class, Built-By, Version) e lista todas as classes empacotadas.

### 6. Limpar e reconstruir do zero
```bash
ant clean
ant all
```
O Ant remove `build/` e `dist/`, depois reconstrói tudo. Isso demonstra a **recompilação mínima**: se você rodar `ant compile` duas vezes sem alterar os fontes, o Ant detecta que os `.class` já estão atualizados e não recompila.

---

## Artefatos Gerados

Após `ant all` + `ant report`, os seguintes artefatos são criados em `dist/`:

| Artefato                         | Descrição                                     |
|----------------------------------|-----------------------------------------------|
| `dist/ant-demo.jar`              | JAR executável (Main-Class: `com.demo.Main`)  |
| `dist/docs/index.html`           | Documentação Javadoc navegável                |
| `dist/reports/html/index.html`   | Relatório HTML com resultado dos testes       |

---

## Características do Ant Demonstradas

| Característica da Atividade      | Como é demonstrada neste projeto              |
|----------------------------------|-----------------------------------------------|
| **Geração do script de build**   | `build.xml` com propriedades e targets encadeados via `depends` |
| **Recompilação mínima**          | `<javac>` usa timestamps — só recompila arquivos alterados |
| **Criação do sistema executável**| `<jar>` empacota os `.class` com manifesto (`Main-Class`) |
| **Gerenciamento de dependências**| Pasta `lib/` referenciada via `<path>` e `<fileset>` |
| **Automação de testes**          | `ant test` executa os testes JUnit automaticamente |
| **Emissão de relatórios**        | `ant report` gera HTML via `<junitreport>` com XSLT |
| **Geração de documentação**      | `ant javadoc` gera site HTML via task `<javadoc>` |
| **Extensibilidade**              | Tasks opcionais: `<junit>`, `<junitreport>`, `<javadoc>` |
| **Suporte a multiplataformas**   | Ant roda em qualquer OS com JVM (Windows, Linux, macOS) |

---

## Gerenciamento de Dependências

As dependências externas ficam na pasta `lib/` e são declaradas no `build.xml` como um `<path>`:

```xml
<path id="compile.classpath">
  <fileset dir="${lib.dir}" includes="*.jar"/>
</path>
```

Para adicionar uma nova dependência, basta copiar o `.jar` para `lib/` — o Ant a incluirá automaticamente no classpath.

> **Nota:** O Ant não baixa dependências automaticamente como Maven/Gradle. Para projetos maiores, é comum integrar o **Apache Ivy** ao Ant para gerenciamento automático de dependências via repositórios Maven Central.
