# BearStore Test Automation Framework

Automation testing framework cho chức năng Register của BearStore website sử dụng Playwright, TestNG và Allure Report.

## 🛠️ Công nghệ sử dụng

- **Java 21**
- **Playwright** - Browser automation
- **TestNG** - Test framework
- **Allure** - Test reporting
- **Log4j** - Logging
- **Maven** - Build tool

## 📋 Yêu cầu hệ thống

- Java JDK 21+
- Maven 3.6+
- Git

## 🚀 Cài đặt

```bash
# Clone repository
git clone <repository-url>
cd PW_DEMO

# Install dependencies
mvn clean install
```

## ▶️ Chạy test

### Chạy tất cả test cases
```bash
mvn clean test
```

### Chạy test và xem Allure report
```bash
mvn clean test
mvn allure:serve
```

### Chạy test và tự động xóa JSON (không lưu report)
```bash
mvn clean test
# JSON sẽ tự động bị xóa sau khi test xong
```

### Chạy test bằng batch script
```bash
run-test-clean.bat
```

## 📊 Xem Allure Report

Sau khi chạy test, xem report bằng lệnh:
```bash
mvn allure:serve
```

Report sẽ tự động mở trên browser với các thông tin:
- Test results (Pass/Fail)
- Test steps chi tiết
- Screenshots và logs
- Phân loại theo Epic → Feature → Story
- Timeline và graphs

## 📁 Cấu trúc project

```
PW_DEMO/
├── src/
│   ├── main/java/org/example/bearstore/
│   │   ├── constants/          # Hằng số (BASE_URL)
│   │   ├── managers/           # DriverManager
│   │   ├── annotation/         # Custom annotations
│   │   └── allure/            # Allure utilities
│   └── test/java/org/example/bearstore/
│       ├── common/            # BaseTest
│       ├── page/              # Page Objects
│       ├── steps/             # Test Steps
│       └── testcase/ui/       # Test Cases
├── pom.xml                    # Maven configuration
└── README.md
```

## 🧪 Test Cases

### Register Function
- **TC03** - Verify register failed with existing username
- **TC06** - Verify register failed with empty email
- **TC08** - Verify register failed with password > 500 characters
- **TC10** - Verify register failed with different confirm password

## 🎯 Design Pattern

Framework sử dụng **Page Object Model (POM)** kết hợp **Step Pattern**:

1. **Page Layer** - Chứa locators và actions
2. **Step Layer** - Business logic steps
3. **Test Layer** - Test scenarios

## 📝 Logging

Test logs được ghi ra console bằng Log4j:
```
Step 1 – Navigate to Register Page
Step 2 – Fill register form with username: tien
Step 3 – Click Register button
Step 4 – Verify error message displayed
```

## 🔧 Configuration

### Tắt auto-clean Allure results

Comment plugin trong `pom.xml`:
```xml
<!-- Auto Clean Allure Results After Test -->
<!--
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-antrun-plugin</artifactId>
    ...
</plugin>
-->
```

### Thay đổi browser

Sửa trong `DriverManager.java`:
```java
browser = playwright.chromium().launch(
    new BrowserType.LaunchOptions().setHeadless(false)
);
```

## 🌐 Website test

https://bearstore-testsite.smartbear.com/

## 👤 Author

[Your Name]

## 📄 License

This project is for educational purposes.
