# 📌 Personal Profile REST API

This project is a **backend REST API** for a **single-profile personal portfolio website**.
It provides structured and reusable endpoints to serve profile information such as education, skills, projects, experience, and contact messages.

The system is designed for **one portfolio owner only** and does **not include authentication or multi-user management**, keeping the architecture simple and suitable for academic purposes.

---

## 🚀 Features

* Single personal profile
* Education, skills, projects, experience, and certifications management
* Contact form message handling
* Clean RESTful API design
* Layered architecture (Controller, Service, Repository)
* Uses DTOs for request and response handling
* Custom API response format
* Easy integration with frontend applications

---

## 🏗️ Project Structure

```text
personalprofile
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.personalprofile
│   │   │
│   │   │   ├── controllers
│   │   │   │   ├── ProfileController.java
│   │   │   │   ├── EducationController.java
│   │   │   │   ├── SkillController.java
│   │   │   │   ├── ProjectController.java
│   │   │   │   ├── ExperienceController.java
│   │   │   │   └── ContactController.java
│   │   │
│   │   │   ├── services
│   │   │   │   ├── ProfileService.java
│   │   │   │   ├── EducationService.java
│   │   │   │   ├── SkillService.java
│   │   │   │   ├── ProjectService.java
│   │   │   │   ├── ExperienceService.java
│   │   │   │   └── ContactService.java
│   │   │
│   │   │   ├── repositories
│   │   │   │   ├── ProfileRepository.java
│   │   │   │   ├── EducationRepository.java
│   │   │   │   ├── SkillRepository.java
│   │   │   │   ├── ProjectRepository.java
│   │   │   │   ├── ExperienceRepository.java
│   │   │   │   ├── CertificationRepository.java
│   │   │   │   ├── SocialLinkRepository.java
│   │   │   │   └── ContactMessageRepository.java
│   │   │
│   │   │   ├── models
│   │   │   │   ├── Profile.java
│   │   │   │   ├── Education.java
│   │   │   │   ├── Skill.java
│   │   │   │   ├── Project.java
│   │   │   │   ├── ProjectTechnology.java
│   │   │   │   ├── Experience.java
│   │   │   │   ├── Certification.java
│   │   │   │   ├── SocialLink.java
│   │   │   │   └── ContactMessage.java
│   │   │
│   │   │   ├── dto
│   │   │   │   ├── request
│   │   │   │   │   └── ContactMessageRequest.java
│   │   │   │   └── response
│   │   │   │       ├── ApiResponse.java
│   │   │   │       ├── ProfileResponse.java
│   │   │   │       ├── EducationResponse.java
│   │   │   │       ├── SkillResponse.java
│   │   │   │       ├── ProjectResponse.java
│   │   │   │       ├── ExperienceResponse.java
│   │   │   │       ├── CertificationResponse.java
│   │   │   │       └── SocialLinkResponse.java
│   │   │
│   │   │   └── PersonalprofileApplication.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│
├── pom.xml
└── README.md
```

---

## 🔁 Application Flow

1. The frontend sends an HTTP request to the controller.
2. The controller delegates the request to the service layer.
3. The service layer handles business logic and data transformation.
4. The repository retrieves data from the database.
5. The response is returned using a standardized API response format.

---

## 🌐 API Endpoints

| Method | Endpoint          | Description                      |
| ------ | ----------------- | -------------------------------- |
| GET    | `/api/profile`    | Get personal profile information |
| GET    | `/api/education`  | Get education history            |
| GET    | `/api/skills`     | Get skills list                  |
| GET    | `/api/projects`   | Get projects                     |
| GET    | `/api/experience` | Get experience records           |
| POST   | `/api/contact`    | Send contact message             |

---

## 📦 API Response Format

All responses follow a standard format:

```json
{
  "success": true,
  "message": "Success",
  "data": {}
}
```

---

## 🧠 Design Decisions

* The system is intentionally designed as a **single-profile application**.
* All data belongs to one portfolio owner.
* No authentication or user management is included.
* Service interfaces are omitted to keep the codebase simple and readable.

---

## ▶️ How to Run the Project

1. Clone the repository
2. Configure database settings in `application.properties`
3. Run the application using your IDE or:

   ```bash
   mvn spring-boot:run
   ```
4. Access APIs via `http://localhost:8080/api`

---

## 📄 License

This project is developed for **academic and learning purposes**.

---
