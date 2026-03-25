# The Java Manager for Library.

# App
* Add new books
* Edit existing books
* Delete books
* View overdue loans
* Save data to a JSON file

# How To run
* Press run in VS code or IntelliJ IDEA
* for now, press javafx:run in maven

# Soon

- Mint theme

## Project Structure
```
├── kirjasto.json
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   ├── java
│   │   │   └── fi
│   │   │       └── jyu
│   │   │           └── ohj2
│   │   │               └── iliadanilo
│   │   │                   └── kirjasto
│   │   │                       └── project
│   │   │                           ├── controller
│   │   │                           │   ├── HistoriaController.java
│   │   │                           │   ├── KirjaListaController.java
│   │   │                           │   ├── LainausController.java
│   │   │                           │   ├── LisaaKirjaController.java
│   │   │                           │   └── MuokkaKirjaController.java
│   │   │                           ├── Main.java
│   │   │                           ├── model
│   │   │                           │   ├── Kirja.java
│   │   │                           │   └── Lainaus.java
│   │   │                           └── service
│   │   │                               ├── KirjastoService.java
│   │   │                               └── TallennusService.java
│   │   └── resources
│   │       └── fi
│   │           └── jyu
│   │               └── ohj2
│   │                   └── iliadanilo
│   │                       └── kirjasto
│   │                           └── project
│   │                               ├── historia.fxml
│   │                               ├── kirjalista.fxml
│   │                               ├── lainaus.fxml
│   │                               ├── lisaakirja.fxml
│   │                               └── muokkaakirja.fxml
│   └── test
│       └── java
│           └── fi
│               └── jyu
│                   └── ohj2
│                       └── iliadanilo
│                           └── kirjasto
│                               └── project
│                                   └── model
│                                       └── KirjaTest.java
├── structure
├── target
│   ├── classes
│   │   └── fi
│   │       └── jyu
│   │           └── ohj2
│   │               └── iliadanilo
│   │                   └── kirjasto
│   │                       └── project
│   │                           ├── controller
│   │                           │   ├── HistoriaController.class
│   │                           │   ├── KirjaListaController$1.class
│   │                           │   ├── KirjaListaController.class
│   │                           │   ├── LainausController.class
│   │                           │   ├── LisaaKirjaController.class
│   │                           │   └── MuokkaKirjaController.class
│   │                           ├── historia.fxml
│   │                           ├── kirjalista.fxml
│   │                           ├── lainaus.fxml
│   │                           ├── lisaakirja.fxml
│   │                           ├── Main.class
│   │                           ├── model
│   │                           │   ├── Kirja.class
│   │                           │   └── Lainaus.class
│   │                           ├── muokkaakirja.fxml
│   │                           └── service
│   │                               ├── KirjastoService.class
│   │                               └── TallennusService.class
│   ├── generated-sources
│   │   └── annotations
│   ├── generated-test-sources
│   │   └── test-annotations
│   ├── maven-status
│   │   └── maven-compiler-plugin
│   │       └── compile
│   │           └── default-compile
│   │               ├── createdFiles.lst
│   │               └── inputFiles.lst
│   └── test-classes
│       └── fi
│           └── jyu
│               └── ohj2
│                   └── iliadanilo
│                       └── kirjasto
│                           └── project
│                               └── model
│                                   └── KirjaTest.class
└── ui kirjasto.drawio
```
##
