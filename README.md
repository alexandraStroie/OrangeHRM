orangeHRM/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── (main application code, if any)
│   │
│   └── test/
│       ├── java/
│       │   ├── hook/
│       │   │   └── Hook.java  (Cucumber hook for setup and teardown)
│       │   │
│       │   ├── pages/
│       │   │   ├── LoginPage.java  (Page object for the login page)
│       │   │   ├── HomePage.java   (Page object for the home/dashboard page)
│       │   │   └── etc page
│       │   │
│       │   ├── stepDefinitions/
│       │   │   └── LoginSteps.java  (Cucumber step definitions)
│       │   │
│       │   ├── runner/
│       │   │   └── TestRunner.java  (Cucumber runner class)
│       │   │
│       │   └── loadableComponents/                            
│       │   └── utils/                            
│       │       └── ConfigLoader.java  (Utility class for loading configurations)
│       │       └── WebDriverUtils.java  (Utility class for selenium waits)
│       │
│       └── resources/
│           ├── features/
│           │   └── Login.feature  (Cucumber feature files)
│           │
│           └── config.properties  (Configuration properties for the test environment)
│
├── pom.xml  (Maven POM file for project configuration)
│
├── .gitignore  (for Git version control to ignore files/folders)
│
└── README.md  (for documenting your project setup and instructions)
# OrangeHRM
