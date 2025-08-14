# 📚 Course Scheduler Application (CMPSC 221)

Java Swing desktop app to manage **semesters**, **courses**, **classes/sections**, **students**, and **enrollments** using **Apache Derby (Network Client)**. Built in **Apache NetBeans**.

---

## ✨ Start Screen
![Start Screen](screenshots/CSStartingScreen.png)

### Admin
- Create **Semesters**
- Add **Courses** and **Classes/Sections** (with capacity)
- View class rosters (scheduled vs waitlisted)
- Drop classes (updates enrollments)

### Student
- Create **Student** records
- **Register / Waitlist** for classes
- **Drop** a class
- View **My Schedule** by semester

---

## 🛠 Tech
- Java (JDK 23), Swing/AWT
- Apache NetBeans (Ant project)
- Apache Derby 10.17 — **Network Server** mode
- JDBC driver: `org.apache.derby.jdbc.ClientDriver`

**Main class:** `courseschedulermsj.MainFrame_`  
**JDBC settings used by the app:**
