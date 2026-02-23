# 🌙✨ Dream Portal — Automated UI Testing Framework

Welcome to **Dream Portal**, a scalable Selenium Automation Framework built using **Java, Selenium WebDriver, TestNG, and Maven**.  
This project follows the **Page Object Model (POM)** design pattern to maintain clean, reusable, and structured automation code.

---

## 🚀 Project Overview

Dream Portal is designed to automate UI testing of a web application with structured test execution, reusable page classes, failure handling, and reporting.

---

## ✨ Key Features

✅ 🧪 End-to-End UI Automation  
✅ 📚 Page Object Model (POM) Architecture  
✅ 🧩 TestNG Integration  
✅ 📊 HTML/TestNG Reports  
✅ 📸 Screenshot Capture on Failure  
✅ 🔀 Browser & Window Handling  
✅ ⚙️ Maven Build Management  
✅ 🧼 Clean & Maintainable Code  

---

## 📁 Project Structure

```
dream-portal/
│
├── .mvn/
├── src/
│   ├── main/
│   └── test/
│       ├── java/
│       │   ├── pages/            # Page Object Classes
│       │   ├── tests/            # Test Classes
│       │   ├── testcomponents/   # Base & Reusable Components
│       │   └── utils/            # Utilities
│       └── resources/
│
├── pom.xml
└── README.md
```

---

## 🛠️ Tech Stack

- ☕ Java  
- 🤖 Selenium WebDriver  
- 🧪 TestNG  
- 📦 Maven  
- 🧩 Page Object Model (Design Pattern)

---

## ⚡ Prerequisites

✔ JDK 11+  
✔ Maven Installed  
✔ Chrome / Firefox Browser  
✔ WebDriver Executable  
✔ IntelliJ / Eclipse IDE  

---

## 🚀 How to Run

### 1️⃣ Clone Repository

```
git clone https://github.com/madhanqa08/dream-portal.git
```

### 2️⃣ Navigate to Folder

```
cd dream-portal
```

### 3️⃣ Install Dependencies

```
mvn clean install
```

### 4️⃣ Run Tests

```
mvn test
```

---

## 🧠 Framework Design

🔹 Each page is represented as a separate class (POM).  
🔹 Test classes call reusable methods from page classes.  
🔹 Base setup handles browser initialization and teardown.  
🔹 Screenshots are captured automatically on failures.  
🔹 Reports are generated after execution.

---

## 📊 Automation Flow

1. Launch Browser  
2. Navigate to Application  
3. Perform Actions  
4. Validate Results  
5. Capture Screenshot (if failure)  
6. Generate Report  

---

## 🛡️ Best Practices

✔ Separation of Concerns  
✔ Reusable Code  
✔ Proper Naming Conventions  
✔ Scalable Framework Design  

---

## 👨‍💻 Author

**Madhan Kumar B**  
QA Automation Engineer | Selenium | Java | TestNG  

---
