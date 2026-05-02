# 🏥 Hospital Management System (Java GUI)

A modern **Hospital Management System** built using **Java Swing** with an interactive GUI.
This application allows users to **add and manage patient records** with a clean interface and smooth navigation.

---

## 📌 Features

* 🏠 Home dashboard
* ➕ Add patient details (ID, Name, Disease)
* 📋 View patient records in table format
* 🔄 Refresh table data
* 🎨 Styled UI with colors and hover effects
* ✨ Animated title (dynamic color changing)
* 🧭 Navigation using CardLayout

---

## 🛠️ Technologies Used

* Java
* Swing (GUI Framework)
* AWT (Layouts & Events)
* Collections (`ArrayList`)

---

## 📂 Project Structure

```id="structure3"
HospitalGUIPro.java
```

---

## ▶️ How to Run

1. Open terminal / command prompt

2. Navigate to project folder

3. Compile:

```id="compile3"
javac HospitalGUIPro.java
```

4. Run:

```id="run3"
java HospitalGUIPro
```

---

## 🧠 How It Works

* Uses **CardLayout** to switch between screens (Home, Add, View)
* Stores patient data in an **ArrayList**
* Displays records using **JTable**
* Uses **DefaultTableModel** to manage table data
* Includes event handling for button clicks and user input

---

## 🖥️ Application Screens

### 🏠 Home

* Welcome screen with animated title

### ➕ Add Patient

* Enter:

  * ID
  * Name
  * Disease

### 📋 View Patients

* Displays all patient records in table
* Click **Refresh** to load latest data

---

## ⚠️ Notes

* Data is stored in memory (not saved permanently)
* ID must be a number
* Invalid input shows error message
* No database integration (yet)

---

## 🚀 Future Improvements

* 💾 Add database (MySQL / SQLite)
* 🔐 Login system (Admin/User)
* ✏️ Update & delete patient records
* 📊 Dashboard analytics
* 📸 Add patient images
* 🌐 Convert to web-based system

---

## 👩‍💻 Author

**Meenakshi Srinivasan**
Aspiring Java Developer 💻

---

## 📄 License

This project is open-source and free to use.
