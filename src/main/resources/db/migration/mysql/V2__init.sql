CREATE TABLE GrupoIntegrante
(
  id              INT AUTO_INCREMENT
    PRIMARY KEY,
  administradorId INT NULL,
  integranteId    INT NULL,
  grupoId         INT NOT NULL,
  CONSTRAINT GrupoIntegrante_administrador_id_fk
  FOREIGN KEY (administradorId) REFERENCES administrador (id),
  CONSTRAINT GrupoIntegrante_integrante_id_fk
  FOREIGN KEY (integranteId) REFERENCES integrante (id),
  CONSTRAINT GrupoIntegrante_grupo_id_fk
  FOREIGN KEY (grupoId) REFERENCES grupo (id)
)
ENGINE = InnoDB;

CREATE INDEX GrupoIntegrante_administrador_id_fk
  ON GrupoIntegrante (administradorId);

CREATE INDEX GrupoIntegrante_integrante_id_fk
  ON GrupoIntegrante (integranteId);

CREATE INDEX GrupoIntegrante_grupo_id_fk
  ON GrupoIntegrante (grupoId);

