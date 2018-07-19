CREATE TABLE administrador
(
  id       INT AUTO_INCREMENT
    PRIMARY KEY,
  email    VARCHAR(255) NOT NULL,
  nome     VARCHAR(255) NOT NULL,
  telefone VARCHAR(30)  NOT NULL,
  CONSTRAINT administrador_email_uindex
  UNIQUE (email)
)
  ENGINE = InnoDB;

CREATE TABLE integrante
(
  id       INT AUTO_INCREMENT
    PRIMARY KEY,
  nome     VARCHAR(255) NOT NULL,
  email    VARCHAR(255) NOT NULL,
  telefone VARCHAR(30)  NULL
)
  ENGINE = InnoDB;

CREATE TABLE grupo
(
  id          INT AUTO_INCREMENT PRIMARY KEY,
  nome        VARCHAR(255) NOT NULL,
  dataCriacao DATETIME     NOT NULL
)
  ENGINE = InnoDB;

