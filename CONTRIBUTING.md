# Contribution Guidelines

Core code quality principles for this project.

## Summary

✅ Write clean, minimal code  
✅ Use precise, unambiguous language  
✅ Handle security properly  
✅ Optimize for performance  
✅ Write self-documenting code  
✅ Design cohesive data structures  
✅ Focus on user experience  

These principles ensure the code remains maintainable, understandable, and professional.

---

## 1. 🧹 Clean Code
- Remove functions from previous iterations once they're no longer needed
- Only keep utilities that are actively used
- No commented-out code or "just in case" functions
- Functions and variables should describe what they do
- Use consistent naming conventions (camelCase for JavaScript)

---

## 2. 📝 Precise Language
- Use specific terms: "retrieve metadata" not "fetch files"
- "Query" = ask Sourcegraph API for information
- "Search" = look for patterns using regex
- Distinguish between metadata (file info) and content (file code)
- Be explicit about where data is stored and processed

---

## 3. 🔐 Security
- Never log or display tokens in UI
- Store tokens securely in Script Properties
- Remove unused tokens (following clean code principle)
- Process data in memory, never write sensitive data to cells

---

## 4. ⚡ Performance
- Batch API requests when possible
- Cache results when appropriate
- Show progress indicators for long operations
- Provide clear success/error messages
- Log to Apps Script Logger for debugging

---

## 5. 📖 Self-Documenting Code
- Code should explain itself without requiring comments
- Use descriptive names that explain what things are and do
- Keep related data together in cohesive structures
- Make values explicit instead of deriving them through logic
- Choose clarity over cleverness - obvious code beats clever code
- **Rule**: "Code is read 10x more often than it's written. Optimize for the reader, not the writer."

---

## 6. 📦 Data Structure Design
- **Prefer Data Over Logic**: Store complete data explicitly rather than deriving it through code
- If data is constant for a context, include it in the data structure even if "hardcoded"
- Keep related data together (better cohesion)
- Simpler functions with fewer parameters
- **Rule**: Don't make things configurable just because you *can* - make them configurable only if they *need* to vary

---

## 7. 🎨 User Experience
- Use descriptive menu items and navigation elements

---


