# Albums
An Android application to display data from a remote API.
<p align="center">
  <img src="https://github.com/jibjoub/Albums/assets/46657670/bd73466f-0090-4adc-9ec2-592b874c477e" width="25%">
  <img src="https://github.com/jibjoub/Albums/assets/46657670/569d93c8-6688-4da9-a240-e9d9c8b080d6" width="25%">
</p>


## Tech Stack
- Kotlin
  - Coroutines
  - Flow
- Retrofit for consuming the API
- Hilt for Dependency Injection
- Jetpack Compose for UI building
- Architecture
  - CLEAN architecture
  - MVVM (View - ViewModel - Model)
  - Repository pattern
- Junit for unit tests

## Current state of the project
The app is fetching all the 100 first albums from the API and displays them in a list.

## Set up the project
- Use Android Studio Hedgehog or above
- Download Java SDK 21 or above
- Set your environment variable JAVA_HOME to the location of the JDK on your machine, more detail of the process here: https://docs.oracle.com/cd/E19182-01/821-0917/inst_jdk_javahome_t/index.html 
- Clone the repository in Android Studio

## Future improvements
- Persistence of already fetched data by using a framework like Room
- Improve UI
- Application Icon
