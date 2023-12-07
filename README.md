### Architecture used in MoviesApp
The app is divided into 2 main parts, :core: and :feature: modules

### Core modules:
It contains all frameworks that should be used regardless of the feature, for example: `:core:netwroking` and `:core:localization`.

#### MoviesApp core modules:
##### `:core:design-system`
- Central place that contains all system assets, colors, themes and styles
- Should contain View token to be used across the app

##### `:core:localization`
- Central place to handle localization across the app

##### `:core:networking`
- Central place for all network calls, easy to modify headers, requests and responses

### Feature modules:
Each feature in the application should have it's own module consisting of any of the 3 main layers, **domain**, **data** and **presentation**
Dependencies are made on abstraction for better decoupling and testing purposes.

##### Domain layer
- Contains pure business logic, doesn't depend on any Android framework dependencies
- UseCases reside in this layer
- Could take repositories or another useCases as arguments for it's useCases
- Having there domain entities without depending other layers

##### Data layer
- Contains the implementation for the repositories
- Having their own mappers to communicate with the domain layer
- Repositories can have access on multiple data sources

##### Presentation layer
- Uses MVVM as user events communication pattern
- Has access to useCases
- Having their own mappers to draw UI logic

#### MoviesApp feature modules:
##### `:feature:movies`
- Consists of the main app screen displaying movies list

#### Testing:
- Used `Mockk` as mocking library
- Used `Robolectric ` for testing android views

#### DI:
- Used `DaggerHilt` as dependency injcetion framework
- Depending on `javax:inject` or `com.google.dagger:hilt-core` annotations whenever possible, to keep it pure kotlin module

### Improvement areas:
- Dependencies should be centralized to reduce duplicated build config logic
- View styles should be centralized under `:core:design-system`
- Extracting `Dispatchers` to be constructor injected for easier testing
- More unit tests and UI tests
- Network layer enhancements

