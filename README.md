# Project Title

Github User Search App.

## Description

The Github User Search App is an Android application that allows users to search and view 
information about GitHub users. Users can enter a GitHub username and the app will display 
the user's avatar, name, username, number of followers, number of following, and a list of 
their public repositories.

## Getting Started

### Dependencies

* Run application on Android Device
* This app requires a minimum SDK 24

### Installing

* To use the App, you can clone the project and run it on your Android Device or Emulator

### Executing program

* Open the GitHub User Search App
* Clone the project to Android Studio/Visual Studio Code or any tools for running the app
* Run and Install the app on your Android Device or Emulator
* The app will show the list of users
* Input the search field and click the enter button on keyboard
* The app will display the list of users that you input on the search field
* Click one of the lists and it will direct to the detail user page
* Detail user page will display user's information

```
//example search
"rghinnaa"
```

### Additional Features | Improvements | Challenges I Encountered
From the test case that was given, I used several required technology. I implemented Clean Architecture 
and MVVM for the design pattern because ViewModel layer can be reused across multiple Views that promoting 
code reuse and consistency. Also, I used Hilt Dependency Injection because it has simple and ease of use code.
I used Room database to persist the data of the user list. I implemented the unit testing for repository and 
Chukker logging in the interceptor. This challenge was so fun and gave me more knowledge. 
I rarely use unit testing but in this challenge, I have to implement it so I put my effort into finishing the unit test. 
And This is my first time implementing chukker logging and I will learn more about unit testing and chukker in further
