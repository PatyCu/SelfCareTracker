# AI Agent Collaboration Guide

This document defines how AI agents (like Cursor, Claude, etc.) should collaborate on this project.

**Structure:** General rules (apply to all projects) come first. Project-specific content is at the bottom—update that section when starting a new project.

---

## 🎯 Core Philosophy

**"Clean code, iterative progress, git as history"**

We build incrementally, commit frequently, and rely on version control instead of keeping unused code around. Every change should move us forward, not sideways.

---

## 📋 Code Principles

### Follow CONTRIBUTING.md

All code decisions should align with `CONTRIBUTING.md`. Key principles include:

1. **Clean Code** - Minimal, no cruft, descriptive names
2. **Precise Language** - Say what you mean (retrieve not "fetch", calculate not "get")
3. **Iterative Development** - One feature at a time, test thoroughly
4. **Self-Documenting Code** - Code explains itself without comments
5. **Data Over Logic** - Store complete data explicitly, don't derive through code
6. **User Experience** - Clear errors, helpful messages

### Naming Conventions

- **Be descriptive**: `SpecificComponentMenu` not `Menu`
- **Be specific**: `calculateFullAnalysis` not `analyze`
- **Be consistent**: Follow project conventions (see project-specific section)
- **Avoid abbreviations** unless universally understood

### No "Reference" Code

❌ **Never do this:**
```
Module.js           # Current code
Module_OLD.js       # Kept "for reference"
Module_backup.js    # "Just in case"
```

✅ **Do this instead:**
```
Module.js           # Current code
# Everything else in git history
```

**Why:** Git exists precisely for this. Keeping old code creates confusion about what's actually in use.

---

## 🔄 Development Workflow

### Iterative Approach

1. **Propose the plan** - For complex changes, share the approach and wait for approval
2. **Plan the step** - Break complex features into small, testable increments
3. **Implement** - Make the smallest change that adds value
4. **Test** - **User manually tests each iteration to verify it works**
5. **Commit** - Save the working state to git (after user verification)
6. **Repeat**

**Critical Rule:** Never proceed to the next iteration without user testing the current one. Each iteration must be manually verified as working before building on top of it.

**Workflow:**
- AI implements the change
- User manually tests and verifies it works
- Once verified, commit as a stable point
- User can then merge/push upstream knowing it's tested and stable

### Before User Testing - AI Self-Verification

Before handing off for user testing, verify:
- ✅ **Code compiles** - Run build/compile
- ✅ **Data consistency** - Models match data files (JSON, schemas, etc.)
- ✅ **Type alignment** - String fields have quoted values, numbers are numeric, etc.
- ✅ **Mental trace** - Think through the actual runtime execution path
- ✅ **Error-prone areas** - Serialization, API contracts, file I/O

**Why:** User testing should verify functionality, not debug AI mistakes.

### When Making Complex Changes

**IMPORTANT: For complex or multi-step changes, share the plan first and wait for user feedback/approval before implementing.**

Once approved:
- Break into 5-7 discrete steps
- User tests each step before proceeding to next
- Commit automatically at iteration end (after docs and cleanup)

---

## 🔧 Git Practices

### When to Commit

**Always commit at the end of each iteration:**
- ✅ **After** completing an iteration
- ✅ **After** documentation is updated
- ✅ **After** code is cleaned (unused/legacy code removed)
- ✅ **Before** starting a new iteration

**Intermediate commits** during an iteration should only happen when the user explicitly requests them (e.g., "let's commit this checkpoint").

### What to Commit

**Critical Rule: Only commit tested and working code.**

- ✅ Documentation-only changes can be committed without testing
- ✅ Code changes must be **manually tested by user** and verified working before committing
- ❌ Never commit untested code "to test it later"
- ❌ Never commit broken code "to fix it in the next commit"

**Workflow:** AI implements → User tests → User verifies → Then commit. Commits represent stable, tested points that can be merged upstream.

### Commit Messages

**Format:**
```
type: Brief description (50 chars max)
```

**Rules:**
- **One line only** - No body, no detailed explanations
- **Imperative mood** - "Add feature" not "Added feature"
- **No period** at the end
- **Types:** `feat`, `fix`, `refactor`, `docs`, `test`, `chore`
- **Review staged files** - Check what's being committed matches the message

**Examples:**
- `feat: Add weekly plan management screen`
- `fix: Resolve training day date calculation bug`
- `docs: Update setup instructions for backend`

---

## 📖 Documentation Principles

### Information Architecture

**Each document has one clear focus and audience:**
- **README.md** - Developers: overview, structure, technologies, how to contribute
- **SETUP.md** - Users: step-by-step setup instructions
- **CONTRIBUTING.md** - Contributors: code quality standards and contribution guidelines
- **AGENTS.md** - AI: project context, architecture, collaboration rules
- **.cursorrules** - Cursor AI: enforced behavior rules

**AGENTS.md vs .cursorrules - When to use which:**

**.cursorrules** = "What to do NOW" (actionable, enforced)
- Brief directives that must be followed immediately
- Actionable rules without lengthy explanation
- Examples: "Never commit untested code", "Update prompt files with [x] as tasks complete"
- Think: enforcement layer

**AGENTS.md** = "How we work together" (context, rationale)
- Explains WHY and HOW with examples and context
- Broader collaboration guidelines
- Detailed explanations with trade-offs
- Think: understanding layer

**Rule:** If it's something that should be done automatically every time → .cursorrules. If it needs explanation and context → AGENTS.md. Often rules appear in both: brief in .cursorrules, detailed in AGENTS.md.

**Before keeping any section, ask:**
- Does this add enough value to justify maintaining it?
- Does it duplicate data that already lives in the system?
- Is this still current/relevant, or should it be in git history?

**Rule:** "If a document tries to serve multiple purposes, split it into focused documents."

### Update Before Completing Iteration

- README.md - Current features, setup instructions
- AGENTS.md - Update project-specific section as scope evolves
- CONTRIBUTING.md - Add learnings from the iteration
- Setup guides - Keep accurate

### Documentation Must Match Reality

If the code changes, documentation must change too:
- Names must match code
- Structures must match code
- Expected outputs must match actual outputs

**Why:** Prevents confusion and frustration when following guides.

### README.md Specific Guidelines

**Snapshot Principle:** README always reflects current state, never future plans or roadmap

**Rules:**
- ❌ **Never reference roadmap** - No "Current Status", "Building X next", "Future: Y"
- ❌ **Never mention temporal phases** - No "current phase", "for now", "planned"
- ✅ **Describe what exists** - If feature isn't built, don't mention it
- ✅ **Update when things change** - When new features ship, add them then

**Structure:**
- **What It Does** - Only current functionality
- **Architecture** - Technologies used (mobile + backend)
- **Prerequisites** - What to install
- **Installation** - One-time setup steps
- **Running the App** - How to start services daily
- **Project Structure** - Current folder layout
- **Documentation** - Links to other docs

**Content Principles:**
- Keep sections focused (no redundancy between Installation/Running)
- Be concise and technical
- Group related content (tech stack + architecture together)
- Show folder structure with current files

**Example:**
- ❌ Bad: "A mobile app to track strength training, nutrition, and health (nutrition coming soon)"
- ✅ Good: "A mobile app to track strength training workouts"

---

## 💬 Communication Style

### Be Precise

❌ **Vague:** "Fetch data"
✅ **Precise:** "Retrieve user profile from database"

❌ **Vague:** "Process the thing"
✅ **Precise:** "Calculate average response time from logs"

### Long Responses - Use .prompts/ Files

For elaborate responses that are difficult to review in the IDE:

**Naming Convention:**
- Input prompts: `XX-IN-description.md`
- Output responses: `XX-OUT-description.md`
- Use matching numbers to show relationship

**Example:**
```
.prompts/
├── 01-IN-project_context.md
├── 01-OUT-architecture_plan.md
├── 02-IN-feature_request.md
└── 02-OUT-implementation_plan.md
```

**When to use:**
- Architecture plans
- Complex technical proposals
- Detailed specifications
- Multi-step implementation plans

**Task Tracking:**
- When a prompt file contains multiple tasks, mark them with `[ ]` / `[x]` checkboxes
- Update the prompt file as tasks are completed
- Helps track progress throughout the session

**Why:** Easier to review, reference later, and keep context across sessions

### Explain Trade-offs

When making architecture decisions, explain:
- What you chose
- Why you chose it
- What alternatives existed
- What was sacrificed

### Ask When Unclear

If user intent is ambiguous:
- Ask clarifying questions
- Propose specific options
- Wait for confirmation before proceeding

Don't guess or assume - **clarity over speed**.

### Learning Moments - Update Ways of Working

When we encounter situations that reveal gaps in our process:
- **Prompt to update WoW** - "Should we add this to our ways of working?"
- **Examples:** Bugs that could have been caught earlier, repeated mistakes, unclear processes
- **Goal:** Continuously improve collaboration through documented learnings

---

## ✅ Success Criteria

You're collaborating well if:

- ✅ Code is always in working state after commits
- ✅ Documentation matches reality
- ✅ No unused "backup" or "reference" code exists
- ✅ Each iteration builds on the previous
- ✅ Features are tested before moving to next
- ✅ Commit history tells a clear story
- ✅ Future contributors can understand decisions

---

## 🚫 Anti-Patterns to Avoid

### Code Smells
- Files > 500 lines
- Functions > 50 lines
- Unused functions "just in case"
- Code commented out instead of deleted
- Vague variable names (data, result, temp)

### Process Smells
- Combining multiple features in one commit
- Moving to next feature before testing current
- Skipping documentation updates
- Keeping old code "for reference"
- Guessing user intent instead of asking

---

# 📦 PROJECT-SPECIFIC SECTION

> **Update this section when starting a new project**

## What This Project Does

SelfCareTracker is a mobile app to track self-care habits across three main areas:
1. **Strength Training:** Weekly workout plans with exercises, sets, and reps
2. **Nutrition:** Weekly meal plans with calorie/macro tracking
3. **Health:** Weight/body fat measurements, medications, supplements, daily symptoms

**Current Status:** Bootstrap complete. Focus on Strength Training module as first milestone.

## Technology Stack

### Mobile
- **Primary Language:** TypeScript
- **Framework:** React Native with Expo
- **State Management:** React Context + hooks
- **Navigation:** React Navigation v6
- **Storage:** AsyncStorage (local-first)
- **UI Library:** React Native Paper

### Backend
- **Primary Language:** Kotlin
- **Framework:** Ktor (lightweight HTTP server)
- **Database:** PostgreSQL (future)
- **API Style:** REST

## Naming Convention

- **Style:** camelCase for TypeScript/JavaScript, PascalCase for components
- **Example:** `calculateWeeklyPlan`, `TrainingDayScreen`, `exerciseService`

## Project-Specific Rules

- **Monorepo structure:** Mobile and backend in same repository
- **Local-first approach:** Mobile app works offline, backend adds sync capability
- **Module-based development:** Build one module at a time (Strength → Nutrition → Health)
- **Simple is better:** Avoid over-engineering, start minimal and iterate

## Architecture Decisions

### Data Storage Strategy

**Current Implementation:**
- **Backend:** JSON file (`backend/src/main/resources/sample-training-plan.json`)
- **Mobile:** AsyncStorage for local-first functionality
- **Future:** PostgreSQL database with sync capability

**Why JSON file first:**
- ✅ Faster to implement and iterate
- ✅ No database setup required yet
- ✅ Easy to inspect and modify during development
- ✅ Satisfies "simple is better" principle
- ❌ Trade-off: Not scalable, will migrate to PostgreSQL later

### API Design Decisions

**REST over GraphQL:**
- ✅ Simpler for this app's complexity
- ✅ Well-understood, easier to debug
- ✅ Standard HTTP tools work out of the box
- ❌ Trade-off: Less flexible for complex queries (acceptable for now)

**Endpoint structure: `/api/v1/...`**
- ✅ Versioned from the start (easy to evolve API)
- ✅ Clear separation from health check endpoint
- ✅ RESTful resource naming

### Data Model Decisions

**`reps` as String type:**
- **Problem:** Some exercises use numeric reps (8, 10, 12), others use "to failure"
- **Solution:** String type to handle both cases
- **Why not union type?** Kotlin serialization complexity; string is simpler and sufficient
- **Validation:** Client-side responsibility to display appropriately

**Highlighted exercises:**
- **Stored twice:** Array of names (`highlightedExercises`) + boolean flag on each exercise (`isHighlighted`)
- **Why redundant?** Allows quick filtering without iterating all exercises in UI
- **Trade-off:** Slight data duplication for better UX performance

**`dayOfWeek` as number (0-6):**
- Follows JavaScript convention (0=Sunday)
- Consistent with mobile Date API
- Simple numeric comparison for sorting/filtering

### Service Layer Pattern

**Why `TrainingPlanService` exists:**
- ✅ Separates data retrieval from routing logic
- ✅ Makes testing easier (can mock service)
- ✅ Single responsibility: service handles data, routes handle HTTP
- ✅ Easier to swap JSON → database later without changing routes

**Why not repository pattern?**
- Too heavy for current complexity
- Can refactor later when adding database

### Error Handling Strategy

**Current:** Basic Ktor error responses
**Future considerations:**
- Structured error responses with codes
- Validation error details
- Client-friendly error messages

Will evolve as needs emerge (iterative approach).

## Development Roadmap

### Phase 1: Bootstrap ✅
- [x] Project structure
- [x] Mobile app hello world
- [x] Backend hello world
- [x] Documentation

### Phase 2: Strength Training (In Progress)
- [x] Backend data models (TrainingPlan, TrainingDay, Exercise)
- [x] Training plan API endpoint (`GET /api/v1/training-plan`)
- [x] JSON data storage with sample training plan
- [ ] Mobile app displays weekly training plan (ST01)
- [ ] Mobile app displays training day details (ST02)
- [ ] Exercise logging functionality (ST03)
- [ ] Edit existing training plans (ST04)
- [ ] Create new training plans (ST05)
- [ ] Training plan history (ST06)

### Phase 3: Nutrition Module
- [ ] Meal planning
- [ ] Calorie tracking
- [ ] Macro calculations

### Phase 4: Health Module
- [ ] Measurements tracking
- [ ] Medications/supplements
- [ ] Symptom logging

## Related Documents

- `CONTRIBUTING.md` - Code quality standards and contribution guidelines
- `README.md` - Setup and running instructions
- `API.md` - API endpoints and JSON schemas

---

**Remember:** Good collaboration is about clarity, incremental progress, and leaving the codebase better than you found it. 🚀

