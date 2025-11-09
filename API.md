# API Documentation

## Endpoints

### Health Check

```
GET /api/health
```

**Response:**
```json
{
  "status": "ok",
  "service": "SelfCareTracker"
}
```

---

### Training Plan

```
GET /api/v1/training-plan
```

Returns the active weekly training plan with all training days and exercises.

**Response Schema:**

```json
{
  "id": "string",
  "name": "string",
  "daysPerWeek": number,
  "startDate": "string (YYYY-MM-DD)",
  "isActive": boolean,
  "trainingDays": [
    {
      "id": "string",
      "dayOfWeek": number (0-6, Sunday=0),
      "workoutType": "string (upperbody|lowerbody|fullbody|push|pull)",
      "location": "string (home|gym)",
      "highlightedExercises": ["string"],
      "exercises": [
        {
          "id": "string",
          "name": "string",
          "sets": number,
          "reps": "string (numeric value or 'to failure')",
          "restSeconds": number,
          "isHighlighted": boolean
        }
      ]
    }
  ]
}
```

**Example Response:**

```json
{
  "id": "plan-001",
  "name": "4-Day Upper/Lower Split",
  "daysPerWeek": 4,
  "startDate": "2025-11-10",
  "isActive": true,
  "trainingDays": [
    {
      "id": "day-001",
      "dayOfWeek": 1,
      "workoutType": "upperbody",
      "location": "gym",
      "highlightedExercises": ["Bench Press"],
      "exercises": [
        {
          "id": "ex-001",
          "name": "Bench Press",
          "sets": 4,
          "reps": "8",
          "restSeconds": 120,
          "isHighlighted": true
        },
        {
          "id": "ex-002",
          "name": "Barbell Row",
          "sets": 4,
          "reps": "8",
          "restSeconds": 120,
          "isHighlighted": false
        }
      ]
    }
  ]
}
```

**Notes:**
- `reps` is a string to support both numeric values ("8") and text values ("to failure")
- `dayOfWeek` follows JavaScript convention: 0=Sunday, 1=Monday, etc.
- `highlightedExercises` contains names of 1-2 key exercises for the day
- `isHighlighted` marks exercises that should be visually emphasized in the UI

