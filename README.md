# 🕵️ RedDork: Bug Bounty Dorks Recon Tool


A powerful, desktop-based recon tool for bug bounty hunters, built with Java Swing.  
It leverages categorized Google Dorks and Github to identify potentially sensitive, exposed, or misconfigured assets across a given domain.

![image](https://github.com/user-attachments/assets/9b329db3-bce4-401b-820e-319312d0d3b7)


---

## ✨ Features

- ⚡ **Fast, responsive GUI** (Java Swing with a dark/red hacker-style theme)
- 🔍 **Domain-based Dorking Input**
- 📁 **Categorized Recon Tabs**, including:
  - Sensitive Files
  - API & Endpoints
  - JS Link Extractor
  - Exposures
  - Credentials & Tokens
  - Error Messages & Directory Listings
  - WordPress Recon
  - Login & Registration Panels
  - Other Common Misconfigurations
- 🖼️ **Custom tab icons**
- 🔗 Automatically generates Google search URLs based on dork + domain
- ❤️ Designed by a bug bounty hunter, for bug bounty hunters

---

## 📦 Requirements

- Java 8 or higher  
- Compatible with Windows / Linux / macOS

---

## 🧪 How to Run

### 🔻 Option 1: Run the Standalone `.exe` (Recommended for Windows)

1. **Download the Latest Release:**
   - Go to the [Releases](https://github.com/OsKaaaR/RedDork-Advanced-Bug-Hunter-Dorks-Tool/releases) section.
   - Download the executable:  
     **`RedDork.exe`**

2. **Run the Application:**
   - Double-click `RedDork.exe` to launch the app.
   - ⚠️ Make sure **Java is installed** on your system (Java 17 or higher).  
     You can check by opening Command Prompt and typing:
     ```bash
     java -version
     ```
   - If Java is not installed, download it from one of the following:
     - [Adoptium (OpenJDK)](https://adoptium.net)
     - [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html)

---

### 🛠 Option 2: Run from Source (For Developers)


# Clone the repository
```bash
git clone https://github.com/YourUsername/RedDork.git
cd RedDork
```

# Compile and run (requires Java 17+)
```bash
javac -d out src/**/*.java
java -cp out DorkingToolGUI
```

## 🙌 Credits
Developed with ❤️ by OsKaaR
Special thanks to infosec community.
