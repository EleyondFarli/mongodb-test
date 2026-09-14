# mongodb-test

A demo project management app used to explore MongoDB with Spring Boot and Angular, built for the Database Systems (DBS) course, Year IV, Semester 1.

It models a simple project-tracking domain — projects, tasks, users, comments, and attachments — persisted in MongoDB, exposed through a REST API, and consumed by an Angular front end.

## Architecture

The repo has two independent apps:

- **`mongoDB/`** — Spring Boot 3 (Java 17) REST API backed by MongoDB (via Spring Data MongoDB). Listens on port `8081`.
- **`front-end/`** — Angular 17 single-page app that talks to the API. Currently wires up a `User` CRUD screen as a working example.

```
mongodb-test/
├── mongoDB/       Spring Boot backend
└── front-end/     Angular frontend
```

## Backend (`mongoDB/`)

### Domain model

| Collection    | Fields                              |
|---------------|--------------------------------------|
| `users`       | `id`, `username`, `email`            |
| `projects`    | `id`, `name`, `description`          |
| `tasks`       | `id`, `title`, `description`         |
| `comments`    | `id`, `content`, `userId`            |
| `attachments` | `id`, `filename`, `taskId`           |

Each collection has a matching Spring Data `Repository` and a `RestController` exposing standard CRUD endpoints:

```
GET    /api/{resource}          list all
GET    /api/{resource}/{id}     get one
POST   /api/{resource}          create
PUT    /api/{resource}/{id}     update
DELETE /api/{resource}/{id}     delete
```

where `{resource}` is one of `users`, `projects`, `tasks`, `comments`, `attachments`.

`CommentController` additionally exposes `GET /api/comments/user/{userId}` to fetch a user's comments.

On startup, `DocumentsGenerator` seeds each collection with 5 sample documents (`@PostConstruct`), so the database is populated with demo data automatically the first time the app runs.

### Configuration

Connection settings live in `mongoDB/src/main/resources/application.properties`:

```properties
spring.data.mongodb.uri=<your MongoDB connection string>
server.port=8081
```

### Running the backend

```bash
cd mongoDB
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8081/api`.

## Frontend (`front-end/`)

Angular app scaffolded with the Angular CLI. `UserApiService` calls the backend at `http://localhost:8081/api`, and `UserComponent` provides a basic list/create/update/delete UI for users as a reference implementation for the other resources.

### Running the frontend

```bash
cd front-end
npm install
npm start
```

The app will be available at `http://localhost:4200` and expects the backend to be running on `http://localhost:8081`.

## Notes

- This is a learning/demo project, not production software — there's no authentication, and the seeded data is meant purely for testing CRUD flows.
- Only the `users` resource has a wired-up Angular UI; `projects`, `tasks`, `comments`, and `attachments` are backend-only so far and can be exercised via the REST API directly.
