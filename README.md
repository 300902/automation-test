# Automation Testing Project

This project provides comprehensive automation testing for both API and Web UI using Java, Cucumber BDD, RestAssured, and Selenium WebDriver.

## Project Structure

```
automation-testing/
├── src/test/java/com/automation/
│   ├── runner/
│   │   ├── TestRunner.java          # Main test runner
│   │   ├── ApiTestRunner.java       # API tests only
│   │   └── UiTestRunner.java        # UI tests only
│   └── steps/
│       ├── api/
│       │   └── UserApiSteps.java    # API step definitions
│       └── ui/
│           ├── LoginSteps.java      # Login step definitions
│           └── CartSteps.java       # Cart step definitions
├── src/test/resources/features/
│   ├── api/
│   │   └── user.feature             # API test scenarios
│   └── ui/
│       ├── login.feature            # Login test scenarios
│       └── cart.feature             # Cart test scenarios
├── .github/workflows/
│   └── main.yml                     # GitHub Actions pipeline
└── pom.xml                          # Maven configuration
```

## Test Coverage

### API Testing (DummyAPI.io)
- **GET User by ID**: Valid and invalid ID scenarios
- **POST Create User**: Valid payload and empty payload scenarios
- **PUT Update User**: Valid and invalid ID scenarios
- **DELETE User**: Valid and invalid ID scenarios
- **GET Tags**: Basic functionality test

### UI Testing (DemoBlaze.com)
- **Login**: Valid credentials, invalid credentials, empty fields
- **Add to Cart**: Successful addition, invalid attempts
- **Checkout**: Complete information, incomplete information, invalid card

## Technologies Used

- **Java 11**: Programming language
- **Maven**: Build and dependency management
- **Cucumber**: BDD framework for test scenarios
- **RestAssured**: API testing library
- **Selenium WebDriver**: Web UI automation
- **JUnit 5**: Test framework
- **GitHub Actions**: CI/CD pipeline

## Prerequisites

- Java 11 or higher
- Maven 3.6+
- Chrome browser (for UI tests)
- Internet connection (for API and UI tests)

## Running Tests Locally

### Run All Tests
```bash
mvn clean test
```

### Run API Tests Only
```bash
mvn test -Dtest=ApiTestRunner
```

### Run UI Tests Only
```bash
mvn test -Dtest=UiTestRunner
```

### Generate Reports
```bash
mvn cucumber-reporting:generate
```

## GitHub Actions Pipeline

The pipeline automatically runs on:
- Push to `main` or `develop` branches
- Pull requests to `main` or `develop` branches

### Pipeline Jobs

1. **API Tests**: Runs all API-related tests
2. **UI Tests**: Runs all UI-related tests with Chrome browser
3. **Full Test Suite**: Combines results and generates comprehensive reports

### Artifacts Generated

- **API Test Results**: JSON, XML, and HTML reports
- **UI Test Results**: JSON, XML, HTML reports, and screenshots
- **Combined Results**: Merged test reports and logs

## Test Reports

After test execution, reports are available in:
- `target/cucumber-reports/`: HTML reports
- `target/surefire-reports/`: JUnit XML reports
- GitHub Actions artifacts (for CI/CD runs)

## Configuration

### Environment Variables
- Tests use default configurations for DummyAPI.io and DemoBlaze.com
- Chrome runs in headless mode for CI/CD

### Parallel Execution
- API and UI tests run in separate jobs for better performance
- Tests can be tagged for selective execution

## Test Tags

- `@api`: API-related tests
- `@ui`: UI-related tests
- `@positive`: Positive test scenarios
- `@negative`: Negative test scenarios

## Contributing

1. Clone the repository
2. Create a feature branch
3. Add your tests following the existing pattern
4. Run tests locally to ensure they pass
5. Create a pull request

## Troubleshooting

### Common Issues

1. **Chrome Driver Issues**: WebDriverManager automatically handles Chrome driver setup
2. **API Rate Limits**: DummyAPI.io has rate limits; tests include appropriate waits
3. **UI Element Changes**: DemoBlaze website elements may change; update selectors accordingly

### Debug Mode

For UI tests with visible browser (local development):
```java
// Remove headless option in LoginSteps.java and CartSteps.java
// options.addArguments("--headless");
```

## API Documentation

- **DummyAPI Base URL**: https://dummyapi.io/data/v1
- **Required Header**: app-id (configured in tests)
- **Endpoints Tested**:
  - GET /user/{id}
  - POST /user/create
  - PUT /user/{id}
  - DELETE /user/{id}
  - GET /tag

## UI Test Target

- **Website**: https://www.demoblaze.com/
- **Features Tested**:
  - User login functionality
  - Product cart management
  - Checkout process

## License

This project is for educational and testing purposes.
