# Projektarbete-WS

En komplett **REST API-tjänst** för kundhantering (**CRUD**) byggd med **Spring Boot 3, Java 17, 
Spring Data JPA, H2** och dokumenterad med **Swagger (springdoc-openapi)**.

---

## Syfte
- Visa hur man bygger ett modernt REST API med tydlig arkitektur.
- Ha **controller, service, repository, model, exception handler** i separata lager.
- Använda **validering** och **konsekvent felhantering**.
- Tillhandahålla **interaktiv dokumentation** via Swagger UI.
- Underlätta **testning och utveckling** med en in-memory databas (H2).

---

## Teknisk översikt
- **Java 17**
- **Spring Boot 3.5.5**
    - Spring Web
    - Spring Data JPA
    - Validation API
    - DevTools
- **H2 Database (in-memory)**
- **Swagger UI (springdoc-openapi-starter-webmvc-ui)**
- **Maven Wrapper (mvnw)**

---

# Teori

### Vad är REST?
REST (**Representational State Transfer**) är en arkitekturstil för webb-API:er.  
Egenskaper:
- Resurser (t.ex. **Customer**) exponeras via **URL:er**.
- HTTP-metoder används:
    - `GET` → Hämta data
    - `POST` → Skapa ny data
    - `PUT` → Uppdatera data
    - `DELETE` → Ta bort data
- Resurser returneras i JSON-format.

---

### Vad är CRUD?
CRUD är en akronym för de fyra grundläggande operationerna i databashantering:
- **Create** → Skapa ny data (`POST`)
- **Read** → Läs data (`GET`)
- **Update** → Ändra data (`PUT`)
- **Delete** → Ta bort data (`DELETE`)

I detta projekt representeras CRUD-operationerna av endpoints i `CustomerController`.

---

### MVC-arkitektur
Spring Boot bygger på **MVC (Model-View-Controller)**.
- **Model** → Data och entiteter (`Customer.java`).
- **Repository** → Dataåtkomst (`CustomerRepository`).
- **Service** → Affärslogik (`CustomerService`).
- **Controller** → API-endpoints (`CustomerController`).
- **ExceptionHandler** → Felhantering (`GlobalExceptionHandler`).

Vi använder inte **View** i detta projekt eftersom vi bygger ett **REST API**, inte en webbapp.

---

### Varför Swagger?
Swagger (OpenAPI) används för att:
- Dokumentera API:et automatiskt.
- Ge en **grafisk testmiljö** i webbläsaren.
- Göra det lättare för andra att förstå och använda API:et.

Swagger UI finns här:  
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

### Varför H2?
H2 är en **in-memory databas**. Fördelar:
- Kräver ingen installation.
- Startar snabbt → perfekt för utveckling/test.
- Nollställs vid varje omstart → enkel och fräsch miljö.

H2-konsolen finns här:  
[http://localhost:8080/h2-console](http://localhost:8080/h2-console)

---

# Kom igång

### Förutsättningar
- Java 17
- Git
- IDE (IntelliJ, Eclipse, VS Code)

### Klona & kör
```bash
git clone <repo-url>
cd projektarbete-ws

./mvnw clean install
./mvnw spring-boot:run
