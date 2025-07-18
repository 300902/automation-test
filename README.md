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

### UI Testing (SauceDemo)
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
- Tests use default configurations for DummyAPI.io and SauceDemo.com
- Chrome runs in headless mode for CI/CD

### Parallel Execution
- API and UI tests run in separate jobs for better performance
- Tests can be tagged for selective execution

## Test Tags

- `@api`: API-related tests
 
 
## Test Results
 
 
### API Tests
 
 
\- ✅ User API Testing - Get user by valid ID - Positive Test
 
 
 
 
\- ✅ User API Testing - Get all tags - Positive Test
 
 
### UI Tests (SauceDemo)
 
 
\- ✅ Add product to cart on SauceDemo - Add an existing product to cart
 
 
 
 
\- ✅ Add product to cart on SauceDemo - Attempt to checkout with empty cart
 
 
### SauceDemo Website Login
 
 
\- ✅ SauceDemo Website Login - Successful login with valid credentials
 
 
 
 
\- ✅ SauceDemo Website Login - Failed login with empty credentials
 
1. **Chrome Driver Issues**: WebDriverManager automatically handles Chrome driver setup
2. **API Rate Limits**: DummyAPI.io has rate limits; tests include appropriate waits
3. **UI Element Changes**: SauceDemo website elements may change; update selectors accordingly

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

- **Website**: https://www.saucedemo.com/
- **Features Tested**:
  - User login functionality
  - Product cart management
  - Checkout process

## License

This project is for educational and testing purposes.

## Test Results

### API Tests
- ✅ User API Testing - Get user by valid ID - Positive Test
- ✅ User API Testing - Get user by invalid ID - Negative Test
- ✅ User API Testing - Create new user with valid payload - Positive Test
- ✅ User API Testing - Create user with invalid payload - Negative Test
- ✅ User API Testing - Create user with invalid email format - Negative Test
- ✅ User API Testing - Update user with valid ID and payload - Negative Test
- ✅ User API Testing - Update user with invalid ID - Negative Test
- ✅ User API Testing - Delete user with valid ID - Negative Test
- ✅ User API Testing - Delete user with invalid ID - Negative Test
- ✅ User API Testing - Get all tags - Positive Test

### UI Tests (SauceDemo)
- ✅ Add product to cart on SauceDemo - Add an existing product to cart
- ✅ Add product to cart on SauceDemo - Attempt to checkout with empty cart

### SauceDemo Website Login
- ✅ SauceDemo Website Login - Successful login with valid credentials
- ✅ SauceDemo Website Login - Failed login with invalid username
- ✅ SauceDemo Website Login - Failed login with invalid password
- ✅ SauceDemo Website Login - Failed login with empty credentials
