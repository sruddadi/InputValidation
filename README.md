# InputValidation

Introduction:

The goal of this assignment is to produce a REST API that validates its input using regular expressions.

Therefore, I have created a REST API application that maintains a phonebook of names and phone numbers.  The program shall be capable of receiving and storing a list of people with their full name and telephone numbers. 

The application includes the following API endpoints:

•	GET/Phonebook/readContacts – Produce a list of number of contacts in the database.

•	POST/Phonebook/createphonebook – Add a new contact record to the database.

•	PUT/Phonebook/deleteByName – Remove contact from database with given name.

•	PUT/Phonebook/deleteByNumber – Remove contact from database with given phone number.

Description on how the application works:

I have used Spring Boot framework to create a REST API that maintains the phonebook of names and telephone numbers.

Spring Boot provides a powerful batch processing and manages REST endpoints.

In Spring Boot, everything is auto configured; no manual configurations are needed.

Spring Boot provides a flexible way to configure Java Beans and Database Transactions.

I have used SQLite database to store the data. SQLite can be easily integrated with Spring Boot to create a REST API.

All the code that has been written is in JAVA language.

There is an audit log which is generated for all the operations done in the application (Create, List and Delete) with the timestamp. This is generated at the PhoneBookService class, used File functionality of java to generate a log that is saved on the disc with an extension as log.txt

Additionally, added Junit test cases to the project to ensure the project code is working as expected 

Assumptions Made:

Assumed that the phone numbers may or may not be preceded by a + which indicates that an international dialing prefix, such as 00 or 011, must be included when dialing.  If not using the plus, the dialing prefix itself may be included.

• Assumed 5-digit extensions only for dialing from one internal phone to another. 

• Assumed North American phone numbers dialed within the countries of North America use a country code of 1, have a 3-digit area code, and a 7-digit subscriber number.  Calls to local numbers in the same area code may omit the area code if not in a metro area; therefore, a subscriber only format may be used.

• Assumed Danish telephone numbers are 8 digits long, and normally written in four groups of two separated by spaces, AA AA AA AA. In recent years it has also become common to write them in two groups of four, AAAA AAAA.  Also, allow dots instead of spaces.  Denmark's country code is 45 and may be included as well for international formats. Some notations use 2-digit area codes. Some notations with 10 digits in two groups of five separated by either a space or a dot.

• Assumed valid inputs for Name are as follows:
    o	Bruce Lee
    o	Lee, Bruce
    o	Lee, Bruce Wayne
    o	O’Malley, John F.
    o	John O’Malley-Smith
    o	Cheri

• Assumed each word in the name must start with a capital letter

• Assumed each word before space should have at most 10 letters

• Assumed each word in a name separated with space must have a capital letter in the beginning.

