<!-- Use this file to provide workspace-specific custom instructions to Copilot. For more details, visit https://code.visualstudio.com/docs/copilot/copilot-customization#_use-a-githubcopilotinstructionsmd-file -->

# Automation Testing Project Instructions

This is a Java-based automation testing project that uses:

- **Cucumber BDD**: For behavior-driven development and test scenarios
- **RestAssured**: For API testing and validation
- **Selenium WebDriver**: For web UI automation
- **Maven**: For build management and dependencies
- **JUnit 5**: For test execution framework

## Code Style Guidelines

1. **Package Structure**: Follow the existing package structure under `com.automation`
2. **Step Definitions**: Keep API and UI step definitions separate
3. **Page Objects**: Use WebDriver best practices for UI automation
4. **Test Data**: Use Cucumber DataTables for parameterized tests
5. **Error Handling**: Include proper exception handling and meaningful assertions

## Testing Patterns

- Use `@Given`, `@When`, `@Then` annotations for BDD steps
- Implement proper setup and teardown with `@Before` and `@After` hooks
- Use meaningful test tags like `@api`, `@ui`, `@positive`, `@negative`
- Include both positive and negative test scenarios

## API Testing

- Base URL: https://dummyapi.io/data/v1
- Use RestAssured for HTTP requests and responses
- Validate status codes, response bodies, and headers
- Include proper authentication headers (app-id)

## UI Testing

- Target website: https://www.demoblaze.com/
- Use WebDriverManager for driver setup
- Implement explicit waits and proper element locators
- Use headless mode for CI/CD environments
- Handle alerts and modal dialogs appropriately

## CI/CD Integration

- GitHub Actions pipeline runs on push and pull requests
- Tests are executed in parallel (API and UI separately)
- Reports and artifacts are automatically generated and uploaded
- Use ubuntu-latest with Java 11 setup
