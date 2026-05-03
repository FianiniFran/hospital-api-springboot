# Hospital API REST

REST API for medical appointment management built with Spring Boot.

## Technologies
- Java 21
- Spring Boot 4.0.6
- Spring Data JPA
- MySQL
- Lombok
- Spring Security

## Requirements
- Java 21
- MySQL
- Maven

## Setup

1. Clone the repository
2. Create the database:
```sql
source sql/schemaHospital.sql
```
3. Copy `application.properties.example` to `application.properties`
4. Fill in your credentials

## Run
```bash
mvn spring-boot:run
```

## Main Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | /api/v1/patient | List patients |
| POST | /api/v1/patient | Add patient |
| PUT | /api/v1/patient | Modify patient |
| DELETE | /api/v1/patient | Soft-Delete patient |
| GET | /api/v1/doctor | List doctors |
| POST | /api/v1/doctor | Add doctor |
| PUT | /api/v1/doctor | Modify doctor |
| DELETE | /api/v1/doctor | Soft-Delete doctor |
| GET | /api/v1/speciality | List specialities |
| GET | /api/v1/timetable | List timetables |
| GET | /api/v1/timetablexdoctor | List timetables per doctor |
| POST | /api/v1/timetablexdoctor | Add timetable to a doctor |
| GET | /api/v1/turn | List appointments |
| POST | /api/v1/turn | Book appointment |
| PUT | /api/v1/turn | Modify appointment |

## Data Model
- Patient
- Doctor
- Speciality
- Timetable
- TimetableXDoctor
- Turn

## Author
Franco Fianini
https://github.com/FianiniFran