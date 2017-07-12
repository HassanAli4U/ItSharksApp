package com.iloveallah.itsharks.contentProvider;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.iloveallah.itsharks.R;


public class Database extends SQLiteOpenHelper {
    public static final String Database_name = "itsharks";
    public static final String TABLE_NAME = "Courses";
    public static final String COURSE_NAME = "cours_name";
    public static final String COURSE_IMAGE = "course_image";
    public static final String COURSE_PRICE = "price";
    public static final String COURSE_WEEKS = "weeks";
    public static final String COURSE_SESSIONS = "sessions";
    public static final String COURSE_HOURS = "hours";
    public static final String COURSE_CONTENT = "content";
    public static final String INSTRUCTOR_NAME = "instructor_name";
    public static final String INSTRUCTOR_IMAGE = "instructor_image";
    static final int version = 1;
    public static final String ID = "id";

    public Database(Context context) {
        super(context, Database_name, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COURSE_NAME + " TEXT UNIQUE NOT NULL, " +
                COURSE_IMAGE + " INTEGER NOT NULL, " +
                COURSE_PRICE + " INTEGER NOT NULL, " +
                COURSE_WEEKS + " INTEGER NOT NULL, " +
                COURSE_SESSIONS + " INTEGER NOT NULL, " +
                COURSE_HOURS + " INTEGER NOT NULL, " +
                COURSE_CONTENT + " TEXT NOT NULL, " +
                INSTRUCTOR_NAME + " TEXT NOT NULL, " +
                INSTRUCTOR_IMAGE + " INTEGER NOT NULL " +
                ");";
        sqLiteDatabase.execSQL(CREATE_TABLE);
        //all inserted data need to be inserted only one time  when the app is installed
        //if there is any data will be inserted or deleted ,it will be in a new version
        ContentValues values = new ContentValues();
        values.put(COURSE_NAME, "Android");
        values.put(COURSE_IMAGE, R.drawable.android);
        values.put(COURSE_PRICE, 1400);
        values.put(COURSE_WEEKS, 8);
        values.put(COURSE_SESSIONS, 3);
        values.put(COURSE_HOURS, 92);
        values.put(COURSE_CONTENT, "JAVA\n" +
                "•Java What's Java ?\n" +
                "•Java history.\n" +
                "•Java Bytecode.\n" +
                "•Java virtual machine.\n" +
                "•JRE(Java runtime environment ).\n" +
                "•JDK (Java Development kit ).\n" +
                "•SDK(Software Development Kit ).\n" +
                "•API(Application Programming Interfaces ).\n" +
                "•Variables Data Types.\n" +
                "•Strings.\n" +
                "•Input-output.\n" +
                "•Comments.\n" +
                "•Math Operations.\n" +
                "•Conditional statement (if- switch).\n" +
                "•Looping.\n" +
                "•Exceptions.\n" +
                "•Streams (input stream- output stream).\n" +
                "•Casting.\n" +
                "\n" +
                "OOP\n" +
                "•Class.\n" +
                "•Object Member.\n" +
                "•Variable Member.\n" +
                "•method.\n" +
                "•Constructor.\n" +
                "•Access Control Modifiers.\n" +
                "•Inheritance.\n" +
                "•Polymorphism.\n" +
                "•Interfaces.\n" +
                "•Abstraction.\n" + "Introduction to Android\n" +
                "•What’s Android.\n" +
                "•Why Android.\n" +
                "•Android Market.\n" +
                "•Android Versions.\n" +
                "\n" +
                " Android Architecture\n" +
                "•Android Stack.\n" +
                "•Android Features.\n" +
                "•Android Architecture layer.\n" +
                "\n" +
                " Tools\n" +
                "•SDK (software development kit ).\n" +
                "•JDK (javaimage development kit ).\n" +
                "•IDE (integrated development environment.\n" +
                "\n" +
                " Android Studio\n" +
                "•Setup Android Studio.\n" +
                "•Android Manifest.\n" +
                "•Important Folders.\n" +
                "•Important Buttons.\n" +
                "•LogCat.\n" +
                "•Emulator  and genymotion.\n" +
                "\n" +
                "Android Components\n" +
                "•Activities.\n" +
                "•Services.\n" +
                "•Broadcast Receivers.\n" +
                "•Content Providers.\n" +
                "\n" +
                " Building Application UI\n" +
                "•Material design concept.\n" +
                "•Layouts.\n" +
                "•Layout types.\n" +
                "•View class.\n" +
                "•Attributes.\n" +
                "\n" +
                " Activities\n" +
                "•Life Cycle.\n" +
                "•Call Back.\n" +
                "•Methods Interacting with UI.\n" +
                "•Resources.\n" +
                "\n" +
                " Intents\n" +
                "•Explicit Intents.\n" +
                "•Implicit Intent.\n" +
                "•Intent Filter.\n" +
                "\n" +
                "listView\n" +
                "•Adapter.\n" +
                "•Listview.\n" +
                "•CustomListView.\n" +
                "\n" +
                "Networking\n" +
                "•Threads.\n" +
                "•AsyncTask.\n" +
                "•Volley library.\n" +
                "•JSON Parsing.\n" +
                "\n" +
                "Data Storing\n" +
                "•Shared preferences.\n" +
                "•Internal storage.\n" +
                "•External storage.\n" +
                "•SQLite.\n" +
                "\n" +
                "Services\n" +
                "•Overview of services in Android.\n" +
                "•Implementing a Service.\n" +
                "•a Service lifecycle.\n" +
                "\n" +
                "Fragments\n" +
                "•Static.\n" +
                "•Dynamic.\n" +
                "•Android Fragments Tabs.\n" +
                "\n" +
                "Camera\n" +
                "•Working with camera.\n" +
                "\n" +
                "Multimedia in Android\n" +
                "•Simple Media Player APP.\n" +
                "•Simple video playback.\n" +
                "\n" +
                "Menus\n" +
                "•Context Menu.\n" +
                "•Popup Menu.\n" +
                "•Option Menus.\n" +
                "\n" +
                "Notifications\n" +
                "•Notification properties.\n" +
                "•Attach Actions to notification.\n" +
                "•Pending Intent.\n" +
                "\n" +
                "Maps and Locations\n" +
                "•Working with Google Maps.\n" +
                "•Finding current location and listening for changes in location.\n" +
                "•Working with GPS.\n");
        values.put(INSTRUCTOR_NAME, "Reham Mokhtar");
        values.put(INSTRUCTOR_IMAGE, R.drawable.reham);
        sqLiteDatabase.insert(Database.TABLE_NAME, null, values);


        ContentValues values2 = new ContentValues();
        values2.put(COURSE_NAME, "C#");
        values2.put(COURSE_IMAGE, R.drawable.cs);
        values2.put(COURSE_PRICE, 800);
        values2.put(COURSE_WEEKS, 4);
        values2.put(COURSE_SESSIONS, 3);
        values2.put(COURSE_HOURS, 48);
        values2.put(COURSE_CONTENT, "Introduction and Principles \n" +
                "\n" +
                "Introduction\n" +
                "Reading and writing to a console\n" +
                "Built-in data types\n" +
                "String data type\n" +
                "Control Structure \n" +
                "\n" +
                "Operators\n" +
                "Nullable Types\n" +
                "Datatype conversions\n" +
                "Comments\n" +
                "If statement\n" +
                "Switch statement\n" +
                "While loop\n" +
                "Do while loop\n" +
                "For & foreach loop\n" +
                " Functions, Arrays\n" +
                "\n" +
                "arrays(one & two dimension).\n" +
                "Methods.\n" +
                "Method parameters.\n" +
                "passing array to function.\n" +
                " Classes \n" +
                "\n" +
                "Class - Introduction\n" +
                "Static & Instance members\n" +
                "Method hiding \n" +
                "Structs\n" +
                "Classes Vs Structs\n" +
                " OOP\n" +
                "\n" +
                "Encapsulations\n" +
                "Polymorphism\n" +
                "Method overriding Vs hiding\n" +
                "Method overloading. \n" +
                "Inheritance.\n" +
                "Diamond Problem\n" +
                "Multiple inheritance \n" +
                "Classes Properties \n" +
                "\n" +
                "Interfaces\n" +
                "Explicit interface implementation\n" +
                "Abstract Classes\n" +
                "Abstract Classes Vs Interfaces\n" +
                " Delegates, Exception Handling \n" +
                "\n" +
                "Delegates\n" +
                "Multicast Delegates\n" +
                "Exception Handling\n" +
                "Inner Exceptions\n" +
                "Custom Exceptions\n" +
                "Exception Handling Abuse\n" +
                "Preventing Exception Handling Abuse\n" +
                "Enums, Modifiers, Reflection\n" +
                "\n" +
                "Enums\n" +
                "Enums Concepts\n" +
                "Types vs Type Members\n" +
                "Access Modifiers - Private, Public and Protected\n" +
                "Access Modifiers - Internal and Protected Internal\n" +
                "Access Modifiers for types ,Attributes\n" +
                "Reflection\n" +
                "Late binding using reflection\n" +
                " Generics\n" +
                "\n" +
                "Generic Collections\n" +
                "Difference between Convert.ToString() and ToString() method\n" +
                "Difference between string and stringbuilder\n" +
                "Dictionary, list, Lambada\n" +
                "\n" +
                "dictionary\n" +
                "List collection class \n" +
                "When to use a dictionary over list\n" +
                "Anonymous methods\n" +
                "Lambda expression\n" +
                " ADO\n" +
                "\n" +
                "What is ADO.NET\n" +
                "SQLConnection object in ADO.NET\n" +
                "Storing and retrieving connection\n" +
                "SqlCommand in ado.net\n" +
                "Calling a stored procedure with output parameters\n" +
                "SqlDataReader object in ADO.NET\n" +
                "SqlDataReader object's NextResult() method\n" +
                "SqlDataAdapter in ADO.NET\n" +
                " Project \n" +
                "\n" +
                "Project In windows Form \n" +
                "Group of 2-3 persons select an idea.\n" +
                "The lecturer discusses the code with you.");
        values2.put(INSTRUCTOR_NAME, "Khaled Abdelhalim");
        values2.put(INSTRUCTOR_IMAGE, R.drawable.khaled);
        sqLiteDatabase.insert(Database.TABLE_NAME, null, values2);


        /////////////


        ContentValues values1 = new ContentValues();
        values1.put(COURSE_NAME, "Java");
        values1.put(COURSE_IMAGE, R.drawable.javaimage);
        values1.put(COURSE_PRICE, 1500);
        values1.put(COURSE_WEEKS, 9);
        values1.put(COURSE_SESSIONS, 3);
        values1.put(COURSE_HOURS, 104);
        values1.put(COURSE_CONTENT, "Introduction and Overview \n" +
                "1.introduction to stand-alone application\n" +
                "2.overview about JDK,JVM,JRE\n" +
                "3.How to compile code into bytecode\n" +
                "4.overview about IDE\n" +
                "5.overview about libraries\n" +
                "6.Declaring and initializing variables\n" +
                "7.Datatypes\n" +
                "8.How to print in Console\n" +
                "9.How to scan values from user\n" +
                "\n" +
                " Control Structure \n" +
                "1.If, if-else statements\n" +
                "2.While loop\n" +
                "3.Do while loop\n" +
                "4.For & foreach loop\n" +
                "5.Switch statement\n" +
                "6.Introduction to  Dialogs and message boxes.\n" +
                "\n" +
                " Arrays \n" +
                "1.Arrays\n" +
                "2.String\n" +
                "\n" +
                "OOP \n" +
                "1.Overview about traditional programming,\n" +
                "2.Access Modifiers,\n" +
                "3.Introduction to classes and methods,\n" +
                "4.Introduction to object oriented programming\n" +
                "5.Encapsulation\n" +
                "6.Inheritance\n" +
                "7.Polymorphism\n" +
                "8.Abstraction\n" +
                "9.Interfaces\n" +
                "\n" +
                "GUI \n" +
                "1.Introduction to Graphics User Interface,\n" +
                "2.How to use components(Swing UI)\n" +
                "\n" +
                " SQL \n" +
                "1.Introduction to SQL,\n" +
                "2.Submitting SQL statements,\n" +
                "3.Retrieving and processing results.\n" +
                "\n" +
                "JDBC \n" +
                "1.Introduction to JDBC,\n" +
                "2.Choosing Database drivers,\n" +
                "3. Connecting to a Database.\n" +
                "\n" +
                "Application Using JDBC \n" +
                "1.Implementing application using JDBC\n" +
                "\n" +
                "Storing and Retrieving Data with File I/O\n" +
                "1.Reading and writing files.\n" +
                "2.Creating, deleting and renaming files.\n" +
                "3.Obtaining directory and file information.\n" +
                "\n" +
                "Exception Handling and threads\n" +
                "1.Handling exceptions with try and catch.\n" +
                "2.Threads.\n" +
                "\n" +
                "\n" +
                "Project \n" +
                "1.Project In windows Form \n" +
                "2.Group of 2-3 persons select an idea.\n" +
                "3.The lecturer discusses the code with you.\n" + "Introduction\n" +
                "1.Introduction to web programming.\n" +
                "2.Introduction to HTML\n" +
                "\n" +
                " Servlets and Application Server\n" +
                "1.Introduction to Application Server\n" +
                "2.Servlet life cycle methods\n" +
                "3.Accessing servlet environment variables\n" +
                "\n" +
                "Creating web-based forms for user input \n" +
                "1.Adding text fields and drop-down lists\n" +
                "2.Retrieving form data in the servlet\n" +
                "\n" +
                " Creating Java Server Pages(JSP) \n" +
                "1.Using JSP scriptlets, expressions and declarations\n" +
                "2.Communicating with client using built-in JSPserver objects\n" +
                "3.Implicit variables\n" +
                "\n" +
                " State Management with JSP\n" +
                "1.Accessing cookies and sessions.\n" +
                "2.Storing common application data\n" +
                "\n" +
                "Calling JSP from servlets\n" +
                "1.Forwarding Java objects to JSP\n" +
                "2.Using JavaBeans to transfer data\n" +
                "\n" +
                "Accessing Databases with Servelets\n" +
                "1.Connecting to the Database.\n" +
                "2.Submitting SQL statements\n" +
                "3.Retrieving and processing data\n" +
                "4.Constructing an HTML table\n" +
                "\n" +
                "Managing application state with sessions\n" +
                "1.Creating a unique session for each user\n" +
                "2.Storing and retrieving Java objects within sessions\n" +
                "3.Controlling a session's life span\n" +
                "4.Creating application and session event listeners\n" +
                "\n" +
                " Sample Application Using Servelet, JSP, JDBC\n" +
                "\n" +
                "Developing custom tags\n" +
                "1.Creating custom tags with JSP 2 tag files\n" +
                "2.Customizing tag behavior with attributes\n" +
                "\n" +
                "Developing JavaServer Faces (JSF) Applications \n" +
                "1.JSF Framework overview\n" +
                "2.Identifying the JSF core components\n" +
                "3.Managing application flow using JSF navigation model\n" +
                "\n" +
                "Building JSF Components\n" +
                "1.Developing back beans\n" +
                "2.Creating views with JSF custom tags\n" +
                "\n" +
                "Project\n" +
                "1.Group of 2-3 persons select an idea.\n" +
                "2.The lecturer discusses the code with you.\n");
        values1.put(INSTRUCTOR_NAME, "Eslam Yousef");
        values1.put(INSTRUCTOR_IMAGE, R.drawable.eslam);
        sqLiteDatabase.insert(Database.TABLE_NAME, null, values1);
        /////////
        ContentValues values3 = new ContentValues();
        values3.put(COURSE_NAME, "php");
        values3.put(COURSE_IMAGE, R.drawable.php);
        values3.put(COURSE_PRICE, 1400);
        values3.put(COURSE_WEEKS, 9);
        values3.put(COURSE_SESSIONS, 3);
        values3.put(COURSE_HOURS, 98);
        values3.put(COURSE_CONTENT, "Web Design Course [\uF017 48 Hours] \uF062\n" +
                "\n" +
                "1.Intro to web fundamentals 1.Intro for Hyper Text Markup Language\n" +
                "2.Understanding the web page structure\n" +
                "3.How pages are executed and compiled?\n" +
                "4.What the component of web pages\n" +
                "\n" +
                "2.HTML4 1.Study the Tags of HTML4\n" +
                "2.How to make good design page using HTML4\n" +
                "\n" +
                "3.HTML5 1.Study removed tags in HTML4\n" +
                "2.Study new tags in HTML5\n" +
                "3.Building full structured web page using HTML4 and HTML5\n" +
                "\n" +
                "4.CSS2 1.Study the difference between CSS [Cascading Style Sheets] and HTML\n" +
                "2.The structure of CSS code\n" +
                "3.How to link between HTML and CSS\n" +
                "4.Study the selectors and what are their priorities\n" +
                "5.Study the formatting and values of each priorities\n" +
                "\n" +
                "5.CSS3 1.Study removed properties in CSS2\n" +
                "2.Study new properties in CSS3\n" +
                "3.Building full well designed web pages using HTML4, HTML5, CSS2 and CSS3\n" +
                "\n" +
                "6.PSD to HTML 1.Understand the basics of Photoshop\n" +
                "2.How you can get a free PSD template\n" +
                "3.Study the principles, you should follow to convert PSD image to HTML code\n" +
                "4.Workshop with converting a PSD to website\n" +
                "\n" +
                "7.JavaScript 1.Study the principles of programming 1.Variables\n" +
                "2.Loops\n" +
                "3.Conditional statements\n" +
                "\n" +
                "2.Understand DOM\n" +
                "3.How to design and animate page using JavaScript\n" +
                "4.How to build a plugin from scratch\n" +
                "\n" +
                "8.JQuery 1.What and why is JQuery?\n" +
                "2.The slogan of JQuery\n" +
                "3.How to use JQuery\n" +
                "4.What is the CDN?\n" +
                "5.Study the main functions of JQuery library to animate your page\n" +
                "6.How to build a plugin\n" +
                "7.How to use ready plugins, how to get it and how to edit or customize it?\n" +
                "\n" +
                "9.Bootstrap 1.Understand the concepts of responsive design\n" +
                "2.Why should use bootstrap?\n" +
                "3.How to build first web page using bootstrap?\n" +
                "4.Understanding the grid system\n" +
                "5.Study the classes of bootstrap and how to use its documentation?\n" +
                "\n" +
                "10.Project 1.Building a web site that fits all screen devices\n" +
                "2.Using all learnt technologies\n" +
                "\n" +
                "11.Workshop 1.full day in IT Sharks, Implemting real projects as like as in a company\n" +
                "\n" + "\n" +
                "Php-Mysql Course [\uF017 50 Hours] \uF062\n" +
                "\n" +
                "1.Introduction\n" +
                "1.Introduction to World Wide Web.\n" +
                "2.Understanding the difference between web design and web development\n" +
                "3.Understanding the rules of dynamic website\n" +
                "4.History Understanding client/server roles Apache, PHP, MySQL, Wamp Installation, PHP Basic syntax.\n" +
                "2.PHP Fundamentals\n" +
                "1.PHP data Types.\n" +
                "2.PHP Variables.\n" +
                "3.echo / print.\n" +
                "4.PHP Operators.\n" +
                "5.Control statements\n" +
                "6.Conditional statements. 1.If-else\n" +
                "2.switch\n" +
                "\n" +
                "7. Loops. 1.While\n" +
                "2.For\n" +
                "\n" +
                "1.PHP Arrays\n" +
                "1.PHP Enumerated Arrays.\n" +
                "2.PHP Associative Arrays.\n" +
                "3.Array Iteration.\n" +
                "4.PHP Multi-Dimensional Arrays.\n" +
                "5.Array Functions.\n" +
                "6.Foreach loop\n" +
                "7.Array functions\n" +
                "4.PHP Functions \n" +
                "1.Understand the difference between user-defined and built-in functions\n" +
                "2.PHP Functions. Syntax, Arguments, Variables, References.\n" +
                "3.Return Values, Variable Scope.\n" +
                "1.How to divide your code\n" +
                "1.PHP include().\n" +
                "2.PHP require().\n" +
                "6.PHP Forms\n" +
                "1.PHP Form handling.\n" +
                "2.PHP GET, PHP POST, PHP Form Validation.\n" +
                "3.PHP Form Sanitization.\n" +
                "4.File uploading.\n" +
                "5.XSS filtering\n" +
                "6.How to filter your data\n" +
                "7.PHP Strings Handling \n" +
                "1.Strings and Patterns.\n" +
                "2.Matching, Extracting.\n" +
                "3.Searching Replacing.\n" +
                "4.Formatting, PCRE.\n" +
                "8.MySQL\n" +
                "1.Intro to the history of Database\n" +
                "2.Difference between DBMS, DB and SQL\n" +
                "3.DDL \"Data Definition Language\" 1.How to design Database\n" +
                "2.Understanding ERD \"Entity Relationship Diagram\"\n" +
                "3.Understanding the relations between tables\n" +
                "4.How to create, alter and drop the tables\n" +
                "\n" +
                "1.DML \"Data Manipulation Language\" 1.Study insert statement\n" +
                "2.Study update statement\n" +
                "3.Study delete statement\n" +
                "4.Study select statement 1.Select types\n" +
                "2.How to search in Database\n" +
                "3.Condition operators\n" +
                "4.Sorting data\n" +
                "5.Aggregation functions\n" +
                "6.Joins\n" +
                "\n" +
                "\n" +
                "1.How to connect PHP with MYSQL 1.Understand the lifecycle of connection\n" +
                "2.Difference between MYSQL, MYSQLI and PDO\n" +
                "3.Implement CRUD functions for tables\n" +
                "\n" +
                "2.OOP [Object Oriented Concepts]\n" +
                "1.Understanding the theory of OOP\n" +
                "2.Understanding Encapsulation\n" +
                "3.Inheritance\n" +
                "4.Polymorphism\n" +
                "5.Abstraction\n" +
                "11.PHP Cookies & PHP Sessions\n" +
                "1.PHP Cookie handling.\n" +
                "2.PHP Session Handling.\n" +
                "3.PHP Login Session.\n" +
                "4.Managing user ACL,PHP Cookie handling.\n" +
                "5.PHP Session Handling.\n" +
                "6.PHP Login Session.\n" +
                "7.Managing user ACL.\n" +
                "12.PHP AJAX and JSON\n" +
                "1.Submit form using AJAX and JSON\n" +
                "1.How to distribute you code natively to pure MVC\n" +
                "2.Frameworks and CMS\n" +
                "1.Intro to wordpress CMS\n" +
                "2.Intro to Codeigniter or Yii2 or Laravel framework\n" +
                "15.Project 1.Implementing full CMS web site\n" +
                "\n" +
                "16.Hosting 1.how to book a domain?\n" +
                "2.how to purchase a hosting?\n" +
                "3.how to publish your web site\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n");
        values3.put(INSTRUCTOR_NAME, "Ahmed Shaaban Elgendy");
        values3.put(INSTRUCTOR_IMAGE, R.drawable.ahmed);
        sqLiteDatabase.insert(Database.TABLE_NAME, null, values3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP" + TABLE_NAME + " ;");
        onCreate(db);
    }

    public static void deleteDatabase(Context context) {
        context.deleteDatabase(Database_name);
    }

}
