#  Real-Time Chat Application (Spring Boot + WebSocket)

This is a real-time chat application built with **Spring Boot**, **WebSocket**, and a complete **DevOps CI/CD pipeline** using tools like Jenkins, Docker, Ansible, SonarQube, Graphite, and Grafana.

---

## 🛠️ Tech Stack

### 📦 Backend
- Java 17
- Spring Boot 3.5+
- WebSocket
- JWT Authentication
- H2 Database
- JPA & Lombok

### 📊 DevOps Tools
| Tool        | Purpose |
|-------------|---------|
| **Git + GitHub** | Version control and source code hosting |
| **Maven** | Build automation and dependency management |
| **JUnit** | Unit testing |
| **Jenkins** | CI/CD pipeline |
| **Docker** | Containerization of app and tools |
| **Ansible** | Deployment and provisioning |
| **SonarQube** | Code quality and static analysis |
| **Graphite** | Metric collection |
| **Grafana** | Monitoring and visualization |

---

## ⚙️ Features

- 🔐 JWT-based login and registration
- 💬 Real-time messaging via STOMP/WebSocket
- 📊 Code quality checks via SonarQube
- 🔁 Automated CI/CD with Jenkins
- 📦 Docker-based microservice setup
- 🖥️ Server provisioning with Ansible
- 📈 Live monitoring with Graphite + Grafana

---

## 🚀 CI/CD Pipeline Workflow

1. **Clone Code** – From GitHub repo.
2. **Build & Test** – Using Maven and JUnit.
3. **Static Code Analysis** – With SonarQube.
4. **Dockerize App** – Docker build & run.
5. **Ansible Deployment** – Pull latest code and redeploy.
6. **Monitoring** – App metrics shown on Grafana dashboards.

---

## 🐳 Running Locally with Docker

```bash
# Build the Docker image
docker build -t realtime-chat-app .

# Run the container on port 8081
docker run -d -p 8081:8080 --name chat-app realtime-chat-app
```


---

## 📦 Jenkins Pipeline (Jenkinsfile)

The Jenkins pipeline includes:
- Clone → Build → Test → SonarQube Analysis → Docker Build → Ansible Deployment → Monitoring


---

## 📊 Monitoring

- **Graphite**: Exposed metrics
- **Grafana**: Accessible at [http://localhost:3000](http://localhost:3000) with pre-configured dashboard panels

## 👤 Author

**Srinath Kamalakumar**

## 📝 License

Licensed under [MIT](https://opensource.org/licenses/MIT).
