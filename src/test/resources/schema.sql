CREATE TABLE IF NOT EXISTS task (
    id BIGINT  NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    status BOOLEAN NOT NULL,
    PRIMARY KEY (id)
    )
    ENGINE = InnoDB
    AUTO_INCREMENT = 1002;

CREATE INDEX ix_task_status ON task (status);

CREATE TABLE IF NOT EXISTS user(
    id BIGINT NOT NULL AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
    );

CREATE UNIQUE INDEX ix_user_email ON user (email);