
# 🧩 E2E REST API Automation Framework (Rest Assured + Java)

### Author: **Aayush Mishra**
🔗 [LinkedIn](https://www.linkedin.com/in/aayushmishra33/) | 🌐 [aayushmishra.tech](https://aayushmishra.tech/)

---

## 🎯 Objective
An **End-to-End REST API Automation Framework** built from scratch using **Rest Assured**, **Java**, and **TestNG**, focused on **Banking APIs**.  
This project demonstrates a complete automation setup — from basic API testing to advanced framework design, CI/CD integration, and parallel execution.

---

## 🧱 Tech Stack

| Layer | Technology |
|--------|-------------|
| Language | Java 11 |
| Framework | Rest Assured, TestNG |
| Build Tool | Maven |
| Logging | Log4j2 |
| CI/CD | GitHub Actions |
| Reporting | TestNG Reports, Surefire Reports |
| Design Pattern | Service Object Model (SOM) |

---

## ⚙️ Key Features

- ✅ Modular, scalable **Service Object Model**
- ✅ **Thread-safe parallel execution**
- ✅ **Config-driven setup** with environment support
- ✅ **Reusable BaseService** for HTTP methods
- ✅ Integrated **logging & reporting**
- ✅ Supports **CI/CD** via GitHub Actions
- ✅ **Token-based authentication handling**
- ✅ Supports **Regression, Smoke, and Parallel** suites

---

## 📂 Project Structure

```

src
├── main/java/com/api
│   ├── config
│   ├── models
│   │   ├── request
│   │   └── response
│   ├── services
│   └── utils
└── test/java/com/api
├── filters
├── listeners
└── tests

````

---

## 🧪 Example Test (Login API)

```java
@Test
public void testSuccessfulLogin() {
    LoginRequest request = new LoginRequest("testuser", "testpass");
    Response response = authService.login(request);

    assertEquals(200, response.getStatusCode());
    LoginResponse loginResponse = response.as(LoginResponse.class);
    assertNotNull(loginResponse.getToken());
}
````

This example validates the **login endpoint** and ensures that the response token is not null.

---

## 🧰 Dependencies (pom.xml)

```xml
<dependencies>
    <!-- Rest Assured -->
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.3.0</version>
    </dependency>

    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.10.2</version>
        <scope>test</scope>
    </dependency>

    <!-- Jackson for JSON serialization -->
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.18.2</version>
    </dependency>

    <!-- Log4j2 -->
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-core</artifactId>
        <version>2.20.0</version>
    </dependency>
</dependencies>
```

---

## 🧩 Framework Overview

### 🔸 Base Configuration

Centralized setup for environment variables, base URLs, and reusable request specifications.

### 🔸 Service Layer

Implements core API actions (`AuthService`, `UserService`, etc.) built on top of the reusable `BaseService`.

### 🔸 Model Layer

Defines POJOs for request and response payloads — enabling cleaner serialization/deserialization.

### 🔸 Test Layer

Contains TestNG-based test cases grouped under **auth**, **user**, etc., integrated with listeners and filters.

### 🔸 Filters & Logging

Custom filters for intercepting requests and responses using **Rest Assured Filters** and **Log4j2**.

---

## 🧵 Parallel Execution Support

The framework supports **multi-threaded execution** using `ThreadLocal` for thread safety.

Run parallel tests using:

```bash
mvn clean test -Dsuite=parallel
```

TestNG example:

```xml
<suite name="Parallel Suite" parallel="methods" thread-count="4">
    <classes>
        <class name="com.api.tests.AuthTest"/>
        <class name="com.api.tests.UserTest"/>
    </classes>
</suite>
```

---

## ⚡ CI/CD Integration (GitHub Actions)

The workflow automatically runs the API test suite on each push, PR, or scheduled run.

```yaml
name: API Test Automation

on:
  push:
    branches: [ main, master ]
  pull_request:
    branches: [ main, master ]
  schedule:
    - cron: '0 2 * * *'      # Daily at 2 AM UTC
    - cron: '0 14 * * 1,4'   # Monday & Thursday at 2 PM UTC

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout repository
        uses: actions/checkout@v3

      - name: Set up JDK
        uses: actions/setup-java@v3
        with:
          java-version: '11'
          distribution: 'temurin'
          cache: 'maven'

      - name: Run API Tests
        run: mvn clean test -Dsuite=regression
```

---

## 🧾 Execution Commands

```bash
# Run regression suite
mvn clean test -Dsuite=regression

# Run smoke suite
mvn clean test -Dsuite=smoke

# Run specific groups
mvn clean test -Dgroups=auth,user

# Enable parallel execution
mvn clean test -Dthreads=4
```

---

## 📊 Reporting & Logs

* **TestNG Reports** generated under `test-output/`
* **Surefire Reports** under `target/surefire-reports/`
* **Logs** available at `/logs/test.log`

---

## 🔄 CI/CD Results

Each pipeline run automatically:

* Executes API tests
* Uploads reports as GitHub artifacts
* Publishes TestNG results for visibility

---

## 🧠 Key Design Patterns Used

| Pattern                        | Purpose                                 |
| ------------------------------ | --------------------------------------- |
| **Service Object Model (SOM)** | Encapsulates business logic for APIs    |
| **ThreadLocal**                | Enables parallel-safe execution         |
| **Builder/Factory**            | Simplifies object creation for requests |
| **ConfigManager**              | Centralized property management         |

---

## 🚀 Future Enhancements

* Jenkins pipeline integration
* Dockerized test execution
* Dynamic environment switching
* HTML or Allure-based reporting
* API data-driven testing from JSON/Excel

---

## 🤝 Contributing

Contributions, improvements, and feedback are always welcome.
Feel free to fork the repository, raise issues, or suggest enhancements.

---

## 📧 Contact

**Aayush Mishra**
📍 India
📫 [LinkedIn](https://www.linkedin.com/in/aayushmishra33/) | 🌐 [aayushmishra.tech](https://aayushmishra.tech/)

---

> *“Quality is not an act, it’s a habit.”*
> — Aristotle




