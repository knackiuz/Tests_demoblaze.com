# UI Test Automation - DemoBlaze.com

This project provides automated end-to-end (E2E) and functional UI tests for the [DemoBlaze](https://www.demoblaze.com/) e-commerce platform. It is built using **Java 17**, **Selenide**, and **JUnit 5**, implementing the **Page Object Model (POM)** with a **Fluent Interface** design.

## 🚀 Tech Stack

* **Java 17** (Temurin/OpenJDK)
* **Selenide 7.12.2** - A framework for concise UI tests (wrapper for Selenium WebDriver).
* **JUnit 5 (Jupiter)** - The testing engine and assertion library.
* **Maven** - Dependency management and build automation.
* **GitHub Actions** - Continuous Integration pipeline.
* **Allure Report** - Reports with charts and screenshots

---

## 📂 Project Structure

```text
├── .github/workflows/
│   └── maven.yml            # GitHub Actions CI configuration
├── src/test/java/
│   ├── base/
│   │   └── BaseTest.java    # Setup and configuration for all tests
│   ├── pages/               # Page Object Model (POM) classes
│   │   ├── HomePage.java    # Main landing page
│   │   ├── ProductPage.java # Individual product details page
│   │   ├── CartPage.java    # Shopping cart and checkout page
│   │   └── ContactModal.java # Modal component for contact form
│   └── tests/               # Test suites
│       ├── MenuTest.java    # Navigation and UI component tests
│       └── ShopTest.java    # E2E shopping scenarios
├── pom.xml                  # Maven configuration
└── README.md
