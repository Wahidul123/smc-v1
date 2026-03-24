# Sameeha Medical Centre - Spring Boot Version

A modern healthcare management system built with Spring Boot, Java, and Thymeleaf.

## Project Structure
src/ ├── main/ │ ├── java/ │ │ └── com/sameeha/ │ │ ├── MedicalCentreApplication.java │ │ ├── controller/ # Web Controllers │ │ ├── service/ # Business Logic │ │ ├── repository/ # Data Access │ │ └── entity/ # JPA Entities │ └── resources/ │ ├── templates/ # Thymeleaf Templates │ ├── static/ │ │ ├── css/ │ │ └── js/ │ └── application.properties


## Features

- **Doctors Management** - View and manage doctor profiles
- **Medical Services** - Browse available medical services
- **Appointment Booking** - Book appointments with doctors
- **Contact Form** - Send inquiries and messages
- **FAQ Section** - Frequently asked questions
- **Responsive Design** - Works on all devices
- **Database Integration** - H2 (dev) / MySQL (prod)

## Technologies Used

- Java 17
- Spring Boot 3.2.0
- Spring Data JPA / Hibernate
- Thymeleaf
- MySQL / H2 Database
- Maven
- Bootstrap CSS

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+

### Installation

1. Clone the repository:
```bash
git clone https://github.com/Wahidul123/smc-v1.git
cd smc-v1
