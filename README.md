# PokemonApp

## Architecture

* I was using MVVM pattern

## API Used
https://pokeapi.co/

## Libraries Used

* **[Retrofit]implementation 'com.squareup.retrofit2:retrofit:2.9.0'**
* **[Retrofit converter for JSON]implementation 'com.squareup.retrofit2:converter-gson:2.9.0'**
* **[RecyclerView]implementation 'androidx.recyclerview:recyclerview:1.2.1'**
* **[Glide for displaying images from API]implementation 'com.github.bumptech.glide:glide:4.12.0'**


## Implementation
* This app follows Clean Architecture Principles paired with MVVM architecture.
* Project is divided in three parts  *activity and adapter*, *model* and *rest*.
* The *activity and adapter* display ui of app and showing results.
* *Model* module contains the basic blueprint and business logic of the application.
* While *Rest* contains all the code that handles data.


## TO-DO Improvements

### Pagination
* Pagination is used for better user experience and resource management. It has broken down a list of content into equal smaller pieces, loaded one at a time.

##Gaps:
* Lack of complete data on main JSON object for each Pokemon
* Withdraw the complete list of data from JSON although the user may not be able to access the details of the pokemon

