# Hostel Management System (Android App)

A complete **Hostel Management System** for students and admins built in Android using **Java**, **Firebase**, **RecyclerView**, and **REST APIs**. The app supports theme management, CRUD operations for rooms, student applications, and portfolio integration via WebView.

---

## Features

1. Role-based authentication for **Admin** and **Student**.
2. Student registration and login.
3. Admin dashboard with **room management** (add, update, delete).
4. Student dashboard to **view available rooms**.
5. Theme switching: Light / Dark.
6. Persistent theme preference using **SharedPreferences**.
7. Display of student applications admin can accept or reject for real-time updates.
8. **WebView integration** for portfolio display.
9. Menu options: Theme change, logout, and add rooms via api.
10. Input validation, RecyclerView adapters, and efficient data binding.

---

## Technology Stack

- **Android Studio** (Java, XML)
- **Firebase Realtime Database** (Room & Application storage)
- **RecyclerView & Custom Adapters**
- **WebView** (Portfolio integration)
- **SharedPreferences** (Theme persistence)
- **HttpURLConnection / Retrofit** (API integration)
- Material Components for UI (TextInputLayout, Buttons, etc.)

---

## Application Flow

1. **Student**:
   - Login → View available rooms → View portfolio via WebView.
2. **Admin**:
   - Login → Manage rooms → Add / Update / Delete rooms
         - → View applications.

---

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/hostel-management-system.git
2-Open in Android Studio.
3-Configure Firebase for your app (add google-services.json to app/ folder).
4-Build and run the app on an emulator or device.
5-Default themes and menu options are already implemented. Switch themes via options menu.

---

##Screenshots

---


## Future Enhancements

1-Add notifications for room availability.
2-Full REST API integration for dynamic content fetching.
3-User profile management.

---

##Author
**Author:** Ahmad – [Portfolio](https://ahmadev.site)

