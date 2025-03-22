CREATE TABLE user(
    id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
CREATE UNIQUE INDEX ix_user_email ON user (email);

CREATE TABLE IF NOT EXISTS task (
    id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    status VARCHAR(50) NOT NULL,
    due_date DATETIME NOT NULL,
    created_at DATETIME NOT NULL,
    user_id BIGINT NOT NULL,
    PRIMARY KEY (`id`)
    )
    ENGINE = InnoDB
    AUTO_INCREMENT = 1002;

ALTER TABLE `task`
    ADD CONSTRAINT fk_task_user FOREIGN KEY (user_id) REFERENCES user(id);

CREATE INDEX ix_task_status ON task (status);
CREATE INDEX ix_task_due_date ON task (due_date);
CREATE INDEX ix_task_user_id ON task (user_id);
