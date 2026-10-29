# Calculator REST API

Projet du laboratoire SEG3502 : un service Web REST Spring Boot écrit en Kotlin qui fournit quatre opérations arithmétiques et une documentation OpenAPI.

## Prérequis

- Java 17 ou une version compatible
- Une connexion Internet lors de la première compilation, afin que Gradle télécharge les dépendances

## Démarrer l’application

Depuis le dossier `calculator-api`, exécutez :

```powershell
.\gradlew.bat bootRun
```

Le serveur démarre à l’adresse `http://localhost:8080`. Laissez le terminal ouvert pendant les requêtes. Pour arrêter le serveur, appuyez sur `Ctrl+C`.

## Points de terminaison

| Méthode | URL | Exemple de réponse |
|---|---|---:|
| Addition | `GET /calculator/add/{number1}/{number2}` | `/calculator/add/5/3` → `8.0` |
| Soustraction | `GET /calculator/subtract/{number1}/{number2}` | `/calculator/subtract/10/4` → `6.0` |
| Multiplication | `GET /calculator/multiply/{number1}/{number2}` | `/calculator/multiply/2/6` → `12.0` |
| Division | `GET /calculator/divide/{number1}/{number2}` | `/calculator/divide/9/3` → `3.0` |

Les nombres décimaux et négatifs sont acceptés. Une division par zéro retourne le statut HTTP `400 Bad Request`.

Vous pouvez ouvrir ces URLs dans un navigateur ou les appeler avec `curl`, par exemple :

```powershell
curl.exe http://localhost:8080/calculator/add/5/3
```

## Documentation OpenAPI

Après avoir démarré le serveur :

- Swagger UI : <http://localhost:8080/swagger-ui/index.html>
- Spécification OpenAPI JSON : <http://localhost:8080/v3/api-docs>

## Tests

Exécutez les tests automatisés avec :

```powershell
.\gradlew.bat test
```

Les tests couvrent les quatre opérations ainsi que le cas de division par zéro.
