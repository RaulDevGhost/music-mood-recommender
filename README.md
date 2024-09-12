# 🎵 Mood-Based Music Recommender 🎭

## 📖 About
The Mood-Based Music Recommender is a Spring Boot application that suggests music based on your current mood. Simply input how you're feeling, and let our AI-powered system recommend the perfect song to match your emotions!

## 🌟 Features
- 🧠 Intelligent mood analysis
- 🎶 Personalized music recommendations
- 🚀 Fast and efficient Spring Boot backend
- 🔄 RESTful API for easy integration

## 🛠️ Technology Stack
- Java 20
- Spring Boot 3.2.3
- Maven

## 🏗️ Project Structure
```
com.example.mood_music_recommender
├── controller
│   └── MoodController.java
├── model
│   └── Mood.java
├── service
│   └── MusicRecommendationService.java
└── MoodMusicRecommenderApplication.java
```

## 🚀 Getting Started
1. Clone the repository
2. Navigate to the project directory
3. Run `mvn spring-boot:run`
4. The application will start on `http://localhost:8081`

## 🔥 How to Use
Send a POST request to `/mood` with a JSON body:
```json
{
  "description": "happy"
}
```
You'll receive a song recommendation based on your mood!

## 🤝 Contributing
We welcome contributions! Please feel free to submit a Pull Request.

## 📜 License
This project is licensed under the MIT License.

## 👏 Acknowledgements
- Spring Boot team for the amazing framework
- All contributors and users of this project

---
Made with ❤️ by Raul Rincones