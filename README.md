# SelfCareTracker

A mobile app to track strength training workouts.

## 📱 What It Does

SelfCareTracker helps you track strength training workouts:

- View weekly workout plans
- See exercises for each training day
- Track sets, reps, and rest times

## 🏗 Architecture

Mobile app consisting of two modules:

**Mobile Module:**
- React Native with Expo
- TypeScript
- React Navigation
- React Native Paper (UI)
- AsyncStorage (local data)

**Backend Module:**
- Kotlin
- Ktor (HTTP server)
- JSON data storage
- REST APIs

## 📋 Prerequisites

Before you begin, ensure you have installed:

- **Node.js** (v18 or higher)
- **npm** or **yarn**
- **Java Development Kit (JDK)** 21 or higher
- **Expo Go** app on your phone (iOS or Android) for testing

## 📦 Installation

**Mobile:**
```bash
cd mobile
npm install
```

**Backend:**
```bash
cd backend
./gradlew build
```

## 🚀 Running the App

**Start backend** (in one terminal):
```bash
cd backend && ./gradlew run
```

Verify it's running:
```bash
curl http://localhost:8080/api/health
# Expected: {"status":"ok","service":"SelfCareTracker"}
```

**Start mobile app** (in another terminal):
```bash
cd mobile && npm start
```

Then:
- Scan QR code with **Expo Go** (Android) or **Camera** app (iOS)
- Or press `a` for Android emulator
- Or press `i` for iOS simulator (macOS only)

Changes are reflected immediately via hot reload.

## 📁 Project Structure

```
SelfCareTracker/
├── mobile/              # React Native app
│   ├── src/
│   │   ├── screens/    # Screen components
│   │   ├── components/ # Reusable UI components
│   │   ├── context/    # State management
│   │   ├── services/   # API & storage services
│   │   └── types/      # TypeScript definitions
│   └── App.tsx
├── backend/             # Kotlin backend
│   ├── src/
│   │   └── main/kotlin/
│   │       └── com/selfcare/
│   │           ├── models/        # Data models
│   │           ├── services/      # Business logic
│   │           └── Application.kt # Server setup
│   └── resources/
│       └── sample-training-plan.json
├── API.md               # API documentation
├── AGENTS.md            # AI collaboration guide
├── CODE_PRINCIPLES.md   # Code quality standards
└── README.md            # This file
```

## 📖 Documentation

- **API.md** - API endpoints and JSON schemas
- **AGENTS.md** - How AI agents collaborate on this project (includes detailed architecture decisions)
- **CODE_PRINCIPLES.md** - Code quality standards and best practices

## 🤝 Contributing

This is a personal project following specific development principles. See `CODE_PRINCIPLES.md` and `AGENTS.md` for guidelines.

## 📝 License

Private project - not open source.

