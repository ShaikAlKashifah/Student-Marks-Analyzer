# Student-Marks-Analyzer
A Java Swing–based desktop application for managing and analyzing student marks, featuring record creation, search functionality, and real-time statistical analysis. Built using object-oriented principles with an interactive, event-driven GUI.

# Student Marks Analyzer

## Overview

The **Student Marks Analyzer** is a Java-based desktop application developed using **Java Swing** to efficiently manage and analyze student academic records. The application provides an interactive graphical user interface (GUI) that allows users to add student details, search records, and compute statistical insights such as average, highest, and lowest marks.

This project demonstrates the practical application of **Object-Oriented Programming (OOP)** concepts, **event-driven programming**, and **Java Collections**, making it suitable for academic evaluation and portfolio presentation on GitHub.

---

## Objectives

* To design a user-friendly desktop application for managing student records
* To implement real-time analysis of student marks
* To demonstrate Java Swing GUI development and event handling
* To apply OOP principles in a real-world use case

---

## Features

### Core Functionalities

* Add student details including name, roll number, and marks
* Display all stored student records
* Search students by name or roll number
* Calculate and display:

  * Average marks
  * Highest marks
  * Lowest marks

### User Interface Features

* Interactive form-based GUI using Java Swing
* Scrollable output area for better readability
* Dialog-based error handling and validation messages

### Validation & Reliability

* Prevents empty input for name and roll number
* Ensures marks are entered as valid integers
* Graceful handling of invalid input using exception handling

---

## Technology Stack

| Component            | Technology                   |
| -------------------- | ---------------------------- |
| Programming Language | Java                         |
| GUI Framework        | Java Swing                   |
| Data Structure       | ArrayList                    |
| IDE                  | VS Code / IntelliJ / Eclipse |
| Platform             | Windows / Linux              |

---

## System Design

### Application Structure

* **Student Class**: Represents the student data model (name, roll number, marks)
* **Main Frame**: Handles UI layout, event listeners, and application logic
* **Collection Layer**: Uses `ArrayList` to store and manage student records dynamically

### Programming Paradigm

* Object-Oriented Programming (OOP)
* Event-driven architecture using ActionListeners

---

## How the Application Works

1. User enters student details in the input fields
2. On clicking "Add Student", data is validated and stored in memory
3. "Show All" displays all student records
4. "Search" retrieves student details by name or roll number
5. "Show Stats" computes average, maximum, and minimum marks

All outputs are displayed dynamically within the GUI window.

---

## Installation & Execution

### Prerequisites

* Java Development Kit (JDK) 8 or higher
* Any Java-supported IDE or VS Code

### Steps to Run

# Compile the program
javac StudentMarksAnalyzer.java

# Run the application
java StudentMarksAnalyzer


> Ensure that the file name matches the public class name: `StudentMarksAnalyzer.java`

---

## Learning Outcomes

* Hands-on experience with Java Swing GUI development
* Understanding of event handling and user interaction
* Practical implementation of OOP concepts such as classes, objects, and encapsulation
* Use of Java Collections for dynamic data management
* Writing clean, maintainable, and user-friendly desktop applications

---

## Limitations

* Data is stored in memory and not persisted to a database
* Single-user desktop application
* No file export or import functionality

---

## Future Enhancements

* Integrate database support (MySQL / SQLite)
* Add grade calculation and report generation
* Implement file export (PDF / CSV)
* Enhance UI using JavaFX
* Add authentication for role-based access

---

## Project Type

Academic Mini Project / Java GUI Application


⭐ If you find this project useful, feel free to explore and share feedback.
