import os

# Nombre de las entidades
ENTITIES = ["Answer", "Option", "Question", "Student", "Test"]

# Nombre de la carpeta de repositorios
REPOSITORY_FOLDER = "repository"

# Obtén la ubicación actual del script
SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))

# Ruta completa de la carpeta de repositorios
REPOSITORY_PATH = os.path.join(SCRIPT_DIR, "src/main/java/com/me/testgenerator", REPOSITORY_FOLDER)

PACKAGE = f"com.me.testgenerator"

# Comprueba si la carpeta de repositorios ya existe, si no, créala
if not os.path.exists(REPOSITORY_PATH):
    os.makedirs(REPOSITORY_PATH)

# Itera sobre las entidades y crea los repositorios
for ENTITY in ENTITIES:
    REPOSITORY_NAME = f"{ENTITY}Repository.java"
    repository_content = f"""package {PACKAGE}.{REPOSITORY_FOLDER};

import {PACKAGE}.domain.{ENTITY};
import org.springframework.data.jpa.repository.JpaRepository;

public interface {ENTITY}Repository extends JpaRepository<{ENTITY}, Long> {{
    // Puedes agregar metodos de consulta personalizados si es necesario
}}
"""
    repository_file_path = os.path.join(REPOSITORY_PATH, REPOSITORY_NAME)
    
    with open(repository_file_path, "w") as repository_file:
        repository_file.write(repository_content)
    
    print(f"Archivo {REPOSITORY_NAME} creado y contenido generado.")

print(f"Repositorios creados en la carpeta {REPOSITORY_PATH}")
