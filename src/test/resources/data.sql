-- Вставляем данные для пользователей
INSERT INTO "user" ("username", "email", "password")
VALUES ('john_doe', 'john.doe@example.com', 'password123'),
       ('jane_smith', 'jane.smith@example.com', 'password456'),
       ('mark_jones', 'mark.jones@example.com', 'password789');

-- Получаем id пользователя 'john_doe'
SET
@user_id_john_doe = (SELECT "id" FROM "user" WHERE "username" = 'john_doe');

-- Получаем id пользователя 'jane_smith'
SET
@user_id_jane_smith = (SELECT "id" FROM "user" WHERE "username" = 'jane_smith');

-- Получаем id пользователя 'mark_jones'
SET
@user_id_mark_jones = (SELECT "id" FROM "user" WHERE "username" = 'mark_jones');

-- Вставляем данные для задач
INSERT INTO "task" ("title", "description", "status", "due_date", "created_at", "user_id")
VALUES ('Complete Java project', 'Finish the backend development for the To-Do List application', 'IN_PROGRESS',
        '2025-03-25 18:00:00', '2025-03-21 08:00:00', @user_id_john_doe),
       ('Write unit tests', 'Create unit tests for the task management module', 'PENDING', '2025-03-26 10:00:00',
        '2025-03-21 08:30:00', @user_id_john_doe),
       ('Review code', 'Review the recent pull requests from team members', 'COMPLETED', '2025-03-22 12:00:00',
        '2025-03-21 09:00:00', @user_id_jane_smith),
       ('Fix UI bugs', 'Resolve the UI issues identified in the latest release', 'IN_PROGRESS', '2025-03-27 17:00:00',
        '2025-03-21 09:30:00', @user_id_mark_jones),
       ('Prepare documentation', 'Prepare technical documentation for the To-Do List app', 'PENDING',
        '2025-03-30 15:00:00', '2025-03-21 10:00:00', @user_id_mark_jones);
