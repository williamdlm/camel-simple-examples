# Camel Simple Examples

## Descrição

Este projeto é uma demonstração de um aplicativo Spring Boot que utiliza Apache Camel para ilustrar exemplos simples de rotas e componentes Camel. O objetivo é mostrar como usar componentes como File, Direct, Netty-Http, Timer, CXF, SQL e demonstrar alguns padrões de integração (EIPs) como choice, throttle e process.

## Pré-requisitos

- Java 17
- Maven

## Estrutura do Projeto

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.2.7-SNAPSHOT</version>
        <relativePath/>
    </parent>
    <groupId>com.github.williamdlm</groupId>
    <artifactId>camel-simple-examples</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>camel-simple-examples</name>
    <description>Demo project for Spring Boot</description>
    <properties>
        <java.version>17</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.apache.camel.springboot</groupId>
            <artifactId>camel-spring-boot-starter</artifactId>
            <version>4.6.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.camel.springboot</groupId>
            <artifactId>camel-cxf-soap-starter</artifactId>
            <version>4.6.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.camel</groupId>
            <artifactId>camel-netty-http</artifactId>
            <version>4.6.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.cxf</groupId>
            <artifactId>cxf-spring-boot-starter-jaxws</artifactId>
            <version>4.0.4</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```

## Componentes Utilizados

- **File**: Permite interagir com arquivos no sistema de arquivos.
- **Direct**: Permite a comunicação direta entre rotas Camel.
- **Netty-Http**: Permite criar servidores HTTP utilizando Netty.
- **Timer**: Gera eventos baseados em um cronômetro.
- **CXF**: Suporte para serviços SOAP e RESTful.
- **SQL**: Permite interagir com bancos de dados através de consultas SQL.

## Exemplos de Padrões de Integração (EIPs)

- **Choice**: Permite criar rotas condicionais.
- **Throttle**: Permite limitar a taxa de mensagens processadas.
- **Process**: Permite processar mensagens com lógica personalizada.

## Como Executar

1. Clone o repositório:

   ```bash
   git clone https://github.com/williamdlm/camel-simple-examples.git
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd camel-simple-examples
   ```

3. Compile e execute o projeto usando Maven:

   ```bash
   mvn spring-boot:run
   ```

## Exemplos de Rotas

### Rota com Componente File

```java
from("file:input?noop=true")
    .to("file:output");
```

### Rota com Componente Direct

```java
from("direct:start")
    .to("log:received-message");
```

### Rota com Componente Netty-Http

```java
from("netty-http:http://0.0.0.0:8080/hello")
    .transform().constant("Hello from Camel!");
```

### Rota com Componente Timer

```java
from("timer:foo?period=1000")
    .log("Timer triggered");
```

### Rota com Componente CXF

```java
from("cxf:bean:soapEndpoint")
    .to("log:received-soap-message");
```

### Rota com Componente SQL

```java
from("sql:select * from my_table")
    .to("log:sql-result");
```

### Rota com EIP Choice

```java
from("direct:start")
    .choice()
        .when(header("foo").isEqualTo("bar"))
            .to("log:foo-is-bar")
        .otherwise()
            .to("log:foo-is-not-bar");
```

### Rota com EIP Throttle

```java
from("direct:start")
    .throttle(10)
    .to("log:throttled-message");
```

### Rota com EIP Process

```java
from("direct:start")
    .process(exchange -> {
        String originalBody = exchange.getIn().getBody(String.class);
        exchange.getIn().setBody(originalBody.toUpperCase());
    })
    .to("log:processed-message");
```

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

Este README fornece uma visão geral do projeto, explicando sua finalidade, estrutura, componentes utilizados, exemplos de rotas e como executar o projeto. Sinta-se à vontade para ajustar qualquer parte conforme necessário para se adequar melhor ao seu projeto.
