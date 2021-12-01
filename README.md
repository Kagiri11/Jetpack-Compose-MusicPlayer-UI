# Jetpack-Compose-MusicPlayer-UI 🎵

This is a small project I am doing to interact with and explore Jetpack Compose components.

## Project Structure
### 1. Domain.
This layer is responsible for setting up the projects business rules. Also this is the layer that exposes the usecases around our software artifact.
Hence this tends to be the most abstracted layer of the project.

### 2. Data.
As the name declares, this layer is responsible for handling data that revolves our project. Following the abstraction principle, parts of this layer provide implemetations for the policies set in our domain layer.
All things to do with data transformation also happens here just to enforce the rule of crossing over boundaries.
### 3. Presentation(App in this case).
This layer plays host to artifacts responsible for information presentation to the user.

## Tech Stack
- [Koin](https://github.com/google/hilt) - A Kotlin dependency injection framework.
- [Jetpack](https://developer.android.com/jetpack) - Tools to aid in ease when it comes to android development
- [Retrofit](https://square.github.io/retrofit/) - Retrofit is a type-safe http client for android.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines.
- [Flow](https://developer.android.com/kotlin/flow)

**Screenshots**

<p align="center">
  <img src="https://user-images.githubusercontent.com/59829833/144233196-73631d0c-d0a7-405b-a2a5-c476a5b652ab.jpg" width="250"/>
  <img src="https://user-images.githubusercontent.com/59829833/144233533-e4768715-6d7c-4dc9-a3b6-ba4bb10cbc4a.jpg" width="250"/>
  <img src="https://user-images.githubusercontent.com/59829833/144233779-7d0f7e27-bad4-4c52-bc20-73f13a1b4f84.jpg" width="250"/>
</p>



