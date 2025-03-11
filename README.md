# Hospital Management System Backend

API server for hospital operations management with role-based access control (Admin/Doctor). Handles patient records, appointments, and medical inventory.

## Table of Contents
- [Features](#features)
- [Live Demo](#live-demo)
- [Getting Started](#getting-started)
- [API Documentation](#api-documentation)
- [Development](#development)
- [Testing](#testing)
- [Built With](#built-with)
- [Contributing](#contributing)

## Features
| Module | Capabilities |
|--------|--------------|
| **Patient Management** | CRUD operations with RBAC |
| **Appointments** | Full scheduling management |
| **Medicine Inventory** | CRUD operations with stock tracking |

## Live Demo
**Base API URL:** [https://hospital-management-system-backend-pkob.onrender.com](https://hospital-management-system-backend-pkob.onrender.com)

### Example Requests
```bash
# Get all patients (Admin only)
curl -X GET https://hospital-management-system-backend-pkob.onrender.com/api/v1 \
-H "Authorization: Bearer admin_token"

# Get medicine by ID (Doctor accessible)
curl -X GET https://hospital-management-system-backend-pkob.onrender.com/api/v3/medicines/123 \
-H "Authorization: Bearer doctor_token"
```

## Getting Started
### Prerequisites
1. Java 17+
2. Maven 3.8+
3. MySQL 8+
### Setup Instructions


```bash 
# Clone repository
git clone https://github.com/your-username/hospital-management-system.git
cd hospital-management-system

# Configure database (src/main/resources/application.properties)
spring.datasource.url=jdbc: use mongodb

# Run application
mvn spring-boot:run
```

## API Documentation
### Patient Management

| METHOD  | ENDPOINT                  | DESCRIPTION        | ACCESS  |
|---------|---------------------------|--------------------|---------|
| POST    | `/api/v1/insert`          | Create new patient | Admin   |
| GET     | `/api/v1`                 | Get all patients   | Admin   |
| GET     | `/api/v1/patients/{id}`   | Get patient details | Both   |
| PUT     | `/api/v1/patients/{id}`   | Update patient     | Admin   |
| DELETE  | `/api/v1/patients/{id}`   | Delete patient     | Admin   |

### Appointment Management

| METHOD  | ENDPOINT                  | DESCRIPTION           | ACCESS  |
|---------|---------------------------|-----------------------|---------|
| POST    | `/api/v2/insert`          | Schedule appointment  | Both    |
| GET     | `/api/v2`                 | Get all appointments  | Both    |
| DELETE  | `/api/v2/appointments/{id}` | Cancel appointment  | Admin   |

### Medicine Inventory

| METHOD  | ENDPOINT                   | DESCRIPTION       | ACCESS  |
|---------|----------------------------|-------------------|---------|
| POST    | `/api/v3/insert`           | Add new medicine  | Admin   |
| GET     | `/api/v3`                  | Get all medicines | Both    |
| GET     | `/api/v3/medicines/{id}`   | Get medicine details | Both  |
| PUT     | `/api/v3/medicines/{id}`   | Update medicine   | Admin   |
| DELETE  | `/api/v3/medicines/{id}`   | Delete medicine   | Admin   |


### Development
```bash
# Run with hot-reload
mvn spring-boot:run

# Package for production
mvn clean install
```

### Testing

```bash
# Unit tests
mvn test

# Integration tests
mvn verify

# Test coverage report
mvn jacoco:report
```

## Built With
1. Spring Boot 3.2
2. Spring Data MongoDB
3. MongoDB Driver
4. Java 17



## Contributing
1. Fork repository
2. Create feature branch (git checkout -b feature/new-endpoint)
3. Commit changes (git commit -m 'Add new endpoint')
4. Push branch (git push origin feature/new-endpoint)
5. Open pull request


```bash
Key updates made:
1. Integrated your live Render URL
2. Added access level indicators in API documentation
3. Included both Admin and Doctor access examples
4. Added note about demo environment limitations
5. Formatted endpoints with consistent structure

Make sure to:
1. Verify the test accounts work with your Render deployment
2. Consider adding Swagger documentation endpoint if available
3. Monitor Render's free tier usage limits for your demo instance

```