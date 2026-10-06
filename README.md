\# 🧠 MindTrack



A full-stack mental wellness web application built with \*\*Java 24, Spring Boot, and MongoDB\*\* that helps users track their moods, maintain personal journals, and access wellness-focused features through a simple web interface.



\---



\## 📌 About the Project



\*\*MindTrack\*\* is a Spring Boot-based web application developed to provide users with a centralized platform for maintaining their mental wellness records.



The application allows users to:



\- Create an account and log in

\- Record and manage daily moods

\- Create and manage personal journal entries

\- View their wellness information through a dashboard

\- Access a guided breathing/relaxation page

\- Store application data using MongoDB



The project follows a structured backend architecture using \*\*Controllers, Models, and Repositories\*\*.



\---



\## ✨ Features



\### 🔐 Authentication

\- User registration

\- User login

\- User data management



\### 😊 Mood Tracking

\- Record moods

\- Store mood data in MongoDB

\- Retrieve mood information



\### 📔 Journal

\- Create journal entries

\- Store journal entries

\- Retrieve journal data

\- Manage personal journal records



\### 📊 Dashboard

\- Centralized user dashboard

\- Access mood and journal related information



\### 🧘 Breathing

\- Dedicated breathing/relaxation page

\- Simple wellness-focused interface



\---



\## 🛠️ Tech Stack



\### Backend

\- \*\*Java 24\*\*

\- \*\*Spring Boot\*\*

\- \*\*Spring MVC\*\*

\- \*\*Spring Data MongoDB\*\*

\- \*\*REST APIs\*\*

\- \*\*Maven\*\*



\### Frontend

\- \*\*HTML\*\*

\- \*\*CSS\*\*

\- \*\*JavaScript\*\*

\- \*\*Thymeleaf\*\*



\### Database

\- \*\*MongoDB\*\*



\### Development Tools

\- \*\*IntelliJ IDEA\*\*

\- \*\*Git\*\*

\- \*\*GitHub\*\*

\- \*\*Maven Wrapper\*\*



\---



\## 🏗️ Project Architecture



```text

MindTrack

│

├── src

│   │

│   ├── main

│   │   │

│   │   ├── java

│   │   │   └── com

│   │   │       └── MindTrack

│   │   │           │

│   │   │           ├── controller

│   │   │           │   ├── AuthController.java

│   │   │           │   ├── JournalController.java

│   │   │           │   ├── MoodController.java

│   │   │           │   └── PageController.java

│   │   │           │

│   │   │           ├── model

│   │   │           │   ├── Journal.java

│   │   │           │   ├── Mood.java

│   │   │           │   └── User.java

│   │   │           │

│   │   │           ├── repository

│   │   │           │   ├── JournalRepository.java

│   │   │           │   ├── MoodRepository.java

│   │   │           │   └── UserRepository.java

│   │   │           │

│   │   │           └── MindTrackApplication.java

│   │   │

│   │   └── resources

│   │       │

│   │       ├── templates

│   │       │   ├── breathing.html

│   │       │   ├── dashboard.html

│   │       │   ├── Journal.html

│   │       │   ├── login.html

│   │       │   └── signup.html

│   │       │

│   │       └── application.properties

│   │

│   └── test

│

├── .mvn

├── .gitignore

├── .gitattributes

├── HELP.md

├── mvnw

├── mvnw.cmd

├── pom.xml

└── README.md

