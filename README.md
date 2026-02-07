# Student Marks Analyzer

## Overview

The **Student Marks Analyzer** is a Java Swing–based desktop application designed to manage and analyze student academic records through a clean, interactive graphical user interface. The application allows users to enter student details (Name and USN), record subject-wise marks, generate detailed reports, and perform search and delete operations.

This project demonstrates strong understanding of **Object-Oriented Programming (OOP)**, **event-driven GUI development**, and **Java Collections**, making it suitable for academic evaluation as well as a portfolio project on GitHub.

---

## Objectives

* To build a user-friendly Java desktop application for student marks management
* To implement subject-wise marks entry and automated analysis
* To demonstrate Java Swing layouts, event handling, and UI design
* To apply OOP principles and collection-based data management

---

## Key Features

### Core Functionalities

* Add student details using **Name** and **USN**
* Enter marks for multiple subjects:

  * Cloud Computing
  * Machine Learning
  * Advanced Java
  * Open Elective
  * DevOps
* Generate a complete student report with:

  * Subject-wise marks
  * Average marks
  * Highest and lowest marks
* Search student records by **USN**
* Delete student records using **USN**

### User Interface Features

* Modern, form-based GUI using **Java Swing**
* Grid-based layout using `GridBagLayout` for better alignment
* Scrollable output area for reports and results
* Dialog-based user interaction for search and delete actions

### Validation & Reliability

* Prevents empty input for Name and USN
* Ensures all marks are valid integers
* Graceful handling of invalid inputs using exception handling

---

## Technology Stack

| Component            | Technology                   |
| -------------------- | ---------------------------- |
| Programming Language | Java                         |
| GUI Framework        | Java Swing                   |
| Data Structures      | ArrayList, LinkedHashMap     |
| IDE                  | VS Code / IntelliJ / Eclipse |
| Platform             | Windows / Linux              |

---

## System Design

### Application Structure

* **Student Class**: Stores student name, USN, subject-wise marks, and computes statistics
* **StudentManager Class**: Manages student records (add, search, delete, report generation)
* **StudentAnalyzerUI Class**: Handles GUI layout, user interaction, and event handling

### Programming Paradigm

* Object-Oriented Programming (OOP)
* Event-driven architecture using ActionListeners

---

## How the Application Works

1. User enters Name, USN, and subject-wise marks
2. Clicking **Add Student** validates and stores data in memory
3. **Show Report** displays all student details with computed statistics
4. **Search by USN** retrieves a specific student's report
5. **Delete by USN** removes a student record from the system

All results and reports are dynamically displayed in the output area of the GUI.

---

## Installation & Execution

### Prerequisites

* Java Development Kit (JDK) 8 or higher
* Any Java-supported IDE or VS Code

### Steps to Run

```bash
# Compile the program
javac StudentAnalyzerUI.java

# Run the application
java StudentAnalyzerUI
```

> Ensure that the file name matches the public class name: `StudentAnalyzerUI.java`

---

## Learning Outcomes

* Practical experience with Java Swing GUI development
* Strong understanding of event handling and user interaction
* Hands-on use of Java Collections (`ArrayList`, `LinkedHashMap`)
* Implementation of OOP concepts such as encapsulation and modular design
* Building maintainable and user-friendly desktop applications

---

## Limitations

* Data is stored in memory and not persisted to a database
* Designed as a single-user desktop application
* No file export or import functionality




⭐ If you find this project useful, feel free to explore and share feedback.
