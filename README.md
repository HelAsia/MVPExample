# MVPExample
### This is a simple project showing the use of the MVP pattern.

**Model-View-Presenter** is one of the most-used design patterns in mobile applications. It streamlines the process of creating transparent application code by dividing responsibility into three separate layers. MVP pattern separate the application logic layer from the presentation layer. By using such a division, our code becomes readable, easier to debug or test.

**Three layers of the MVP pattern:**
- **Model** - deals with business logic, storage, processing and delivery of relevant data to the presenter. The model can be, for example, a class using an API or a database manager.
- **View** - deals with displaying data that gets from the presenter and intercepts user interactions and sends information about such events to the presenter. The view can be e.g. Activity, Fragment or other View prepared by us.
- **Presenter** - deals with the mediation between View and Model. It contains all logic. Retrieves data from the Model to properly display them in the View, reacts to information about user interaction coming from the View.

Simple application screen:
![main](main_screen.jpg = 200x)
