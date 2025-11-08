# AI Agent Collaboration Guide

This document defines how AI agents (like Cursor, Claude, etc.) should collaborate on this project.

**Structure:** General rules (apply to all projects) come first. Project-specific content is at the bottom—update that section when starting a new project.

---

## 🎯 Core Philosophy

**"Clean code, iterative progress, git as history"**

We build incrementally, commit frequently, and rely on version control instead of keeping unused code around. Every change should move us forward, not sideways.

---

## 📋 Code Principles

### Follow CODE_PRINCIPLES.md

All code decisions should align with `CODE_PRINCIPLES.md`. Key principles include:

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
4. **Test** - **MUST verify it works before moving to next step**
5. **Commit** - Save the working state to git
6. **Repeat**

**Critical Rule:** Never proceed to the next iteration without testing the current one. Each iteration must be verified as working before building on top of it.

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
- ✅ Code changes must be tested and verified working before committing
- ❌ Never commit untested code "to test it later"
- ❌ Never commit broken code "to fix it in the next commit"

If tests fail, fix the code first, then commit.

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
- **CODE_PRINCIPLES.md** - Contributors: code quality standards
- **AGENTS.md** - AI: project context, architecture, collaboration rules
- **.cursorrules** - Cursor AI: enforced behavior rules

**Before keeping any section, ask:**
- Does this add enough value to justify maintaining it?
- Does it duplicate data that already lives in the system?
- Is this still current/relevant, or should it be in git history?

**Rule:** "If a document tries to serve multiple purposes, split it into focused documents."

### Update Before Completing Iteration

- README.md - Current features, setup instructions
- AGENTS.md - Update project-specific section as scope evolves
- CODE_PRINCIPLES.md - Add learnings from the iteration
- Setup guides - Keep accurate

### Documentation Must Match Reality

If the code changes, documentation must change too:
- Names must match code
- Structures must match code
- Expected outputs must match actual outputs

**Why:** Prevents confusion and frustration when following guides.

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

## Development Roadmap

### Phase 1: Bootstrap ✅
- [x] Project structure
- [x] Mobile app hello world
- [x] Backend hello world
- [x] Documentation

### Phase 2: Strength Training (Next)
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

## Related Documents

- `CODE_PRINCIPLES.md` - Core development principles
- `README.md` - Setup and running instructions
- `.prompts/01-OUT-architecture_plan.md` - Detailed architecture decisions

---

**Remember:** Good collaboration is about clarity, incremental progress, and leaving the codebase better than you found it. 🚀

