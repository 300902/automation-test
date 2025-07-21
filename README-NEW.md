# Automation Testing Framework

Automated testing framework yang menggunakan Java, Gradle, Selenium, REST Assured, dan Cucumber untuk testing Web UI dan API.

## 🛠️ Tools & Libraries

### Build Tool
- **Gradle 8.4** - Build automation tool

### Programming Language
- **Java 11** - Programming language

### Testing Frameworks
- **Cucumber 7.14.0** - BDD framework dengan Gherkin syntax
- **JUnit 5** - Testing framework untuk Java

### Web UI Testing
- **Selenium WebDriver 4.15.0** - Web browser automation
- **WebDriverManager 5.6.2** - Automatic driver management
- **Page Object Model** - Design pattern untuk maintainable UI tests

### API Testing
- **REST Assured 5.3.2** - Java library untuk API testing dan validation

### Reporting
- **Cucumber Reports** - HTML dan JSON reports untuk test results

### CI/CD
- **GitHub Actions** - Automated testing pipeline

## 🎯 Test Targets

### Web UI Testing
- **Target Website**: https://www.demoblaze.com/
- **Test Scenarios**: Login, Cart Management, Product Selection

### API Testing
- **Target APIs**: https://dummyapi.io/
  - User endpoints (Get, Create, Update, Delete)
  - Tag endpoints (Get List of Tags)

## 📁 Project Structure

```
src/
├── test/
│   ├── java/
│   │   └── com/automation/
│   │       ├── runner/
│   │       │   ├── ApiTestRunner.java      # Runner untuk @api tests
│   │       │   ├── WebTestRunner.java      # Runner untuk @web tests
│   │       │   └── TestRunner.java         # Runner untuk semua tests
│   │       ├── steps/
│   │       │   ├── api/                    # Step definitions untuk API tests
│   │       │   └── web/                    # Step definitions untuk Web tests
│   │       └── pages/                      # Page Object Model classes
│   └── resources/
│       └── features/
│           ├── api/                        # Feature files untuk API tests
│           └── web/                        # Feature files untuk Web tests
```

## 🚀 Cara Menjalankan Tests

### Prerequisites
- Java 11 atau lebih tinggi
- Chrome browser untuk Web UI tests

### Install Dependencies
```bash
./gradlew build
```

### Menjalankan Tests

#### 1. Menjalankan API Tests saja
```bash
./gradlew apiTest
```

#### 2. Menjalankan Web Tests saja
```bash
./gradlew webTest
```

#### 3. Menjalankan Semua Tests
```bash
./gradlew allTests
```

### Test Reports
Setelah test execution, reports tersedia di:
- **HTML Reports**: `build/reports/cucumber/`
- **JSON Reports**: `build/reports/cucumber/`
- **JUnit XML**: `build/test-results/`

## 🏷️ Test Tags

- `@api` - API test scenarios
- `@web` - Web UI test scenarios
- `@positive` - Positive test cases
- `@negative` - Negative test cases

## 🔄 GitHub Actions CI/CD

### Automatic Triggers
- **Push** ke branch `main` atau `develop`
- **Pull Request** ke branch `main` atau `develop`

### Manual Trigger
Workflow dapat dijalankan manual dengan pilihan:
- `all` - Menjalankan semua tests (API + Web)
- `api` - Menjalankan API tests saja
- `web` - Menjalankan Web tests saja

### Pipeline Jobs
1. **api-tests** - Menjalankan API tests dengan tag `@api`
2. **web-tests** - Menjalankan Web UI tests dengan tag `@web`
3. **full-test-suite** - Kombinasi hasil dari API dan Web tests

### Artifacts
- Test reports (HTML, JSON, XML)
- Screenshots (untuk Web tests)
- Test results summary

## 📊 Test Implementation

### Page Object Model
Web UI tests menggunakan Page Object Model untuk:
- **Maintainability** - Mudah maintenance ketika UI berubah
- **Reusability** - Page objects dapat digunakan di multiple tests
- **Readability** - Test code lebih clean dan readable

### API Response Validation
API tests melakukan validasi:
- **Status Codes** - HTTP response codes
- **Response Body** - JSON response content dan structure
- **Headers** - HTTP response headers
- **Schema Validation** - JSON schema compliance

### Element Locators
Web UI tests menggunakan robust locators:
- **ID selectors** - Primary choice untuk stability
- **CSS selectors** - Untuk styling-based elements
- **XPath** - Untuk complex element relationships
- **Data attributes** - Untuk test-specific identifiers

## 🏃‍♂️ Getting Started

1. **Clone repository**
   ```bash
   git clone https://github.com/300902/automation-test.git
   cd automation-test
   ```

2. **Jalankan tests**
   ```bash
   ./gradlew apiTest        # API tests only
   ./gradlew webTest        # Web tests only
   ./gradlew allTests       # All tests
   ```

3. **Lihat reports**
   - Buka `build/reports/cucumber/*/cucumber-*-report.html` di browser

## 🤝 Contributing

1. Fork repository
2. Create feature branch (`git checkout -b feature/amazing-feature`)
3. Commit changes (`git commit -m 'Add amazing feature'`)
4. Push to branch (`git push origin feature/amazing-feature`)
5. Open Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
