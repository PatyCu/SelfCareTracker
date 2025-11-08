# SelfCareTracker

A mobile app to track self-care habits including strength training, nutrition, and health metrics.

## 📱 What It Does

SelfCareTracker helps you maintain healthy habits across three areas:

1. **Strength Training** - Track weekly workout plans, exercises, sets, and reps
2. **Nutrition** - Manage meal plans with calorie and macro tracking
3. **Health** - Monitor weight, body fat, medications, supplements, and daily symptoms

**Current Status:** Bootstrap complete. Building Strength Training module first.

## 🛠 Technology Stack

### Mobile
- React Native with Expo
- TypeScript
- React Navigation
- React Native Paper (UI)
- AsyncStorage (local data)

### Backend
- Kotlin
- Ktor (HTTP server)
- PostgreSQL (planned)

## 📋 Prerequisites

Before you begin, ensure you have installed:

- **Node.js** (v18 or higher)
- **npm** or **yarn**
- **Java Development Kit (JDK)** 21 or higher
- **Expo Go** app on your phone (iOS or Android) for testing

## 🚀 Getting Started

### Mobile App Setup

1. Navigate to the mobile directory:
```bash
cd mobile
```

2. Install dependencies:
```bash
npm install
```

3. Start the development server:
```bash
npm start
```

4. Run on your device:
   - Scan the QR code with **Expo Go** (Android) or **Camera** app (iOS)
   - Or press `a` for Android emulator
   - Or press `i` for iOS simulator (macOS only)

### Backend Setup

1. Navigate to the backend directory:
```bash
cd backend
```

2. Build the project:
```bash
./gradlew build
```

3. Run the server:
```bash
./gradlew run
```

4. Verify it's running:
```bash
curl http://localhost:8080/api/health
```

Expected response:
```json
{
  "status": "ok",
  "service": "SelfCareTracker"
}
```

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
│   └── src/
│       └── main/kotlin/
│           └── com/selfcare/
│               └── Application.kt
├── AGENTS.md            # AI collaboration guide
├── CODE_PRINCIPLES.md   # Code quality standards
└── README.md           # This file
```

## 🔧 Development Workflow

1. **Start the backend:**
```bash
cd backend && ./gradlew run
```

2. **Start the mobile app** (in a new terminal):
```bash
cd mobile && npm start
```

3. **Make changes** and see them reflected immediately via hot reload

## 📖 Documentation

- **AGENTS.md** - How AI agents collaborate on this project
- **CODE_PRINCIPLES.md** - Code quality standards and best practices
- **.prompts/01-OUT-architecture_plan.md** - Detailed architecture decisions

## 🗺 Roadmap

### Phase 1: Bootstrap ✅
- [x] Project structure
- [x] Mobile app hello world
- [x] Backend hello world
- [x] Documentation

### Phase 2: Strength Training (In Progress)
- [ ] Data models
- [ ] Weekly plan management
- [ ] Training day view
- [ ] Exercise logging

### Phase 3: Backend Integration
- [ ] API endpoints
- [ ] Data sync
- [ ] Offline support

### Phase 4: Nutrition Module
- [ ] Meal planning
- [ ] Calorie tracking
- [ ] Macro calculations

### Phase 5: Health Module
- [ ] Measurements tracking
- [ ] Medications/supplements
- [ ] Symptom logging

## 🤝 Contributing

This is a personal project following specific development principles. See `CODE_PRINCIPLES.md` and `AGENTS.md` for guidelines.

## 📝 License

Private project - not open source.

