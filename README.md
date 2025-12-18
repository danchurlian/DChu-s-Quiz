# DChu's Quiz
By Daniel Chu (2024)  

This was a project that I did during my junior year of high school before I took the AP Computer Science A Exam.   
It encompasses a wide range of fundamental programming principles with relation to the Java language, primarily:
- Object Oriented Programming (OOP)
- Basic Inheritance
- Polymorphism

## Key notes
- The primary uses of Object Oriented Programming and the inheritance that comes with it are found in the different ```Problem``` classes.  

- Note the ```Problem``` class is never fully instantiated directly in the game itself; it is essentially an ```abstract``` class that I wasn't aware about back then. This came naturally to me.  

- In the same way, the ```MemoryProb``` class is also ```abstract``` because it is used the same way as the ```Problem``` class.

- The program also incorporates some ANSI codes to the terminal, such as to flush the terminal (clear the "screen"). It also has a sleeping time component, which is essential for child classes of ```MemoryProb``` to be displayed to the user. 

## Installation and running the program
The project can be run by cloning the repository and compiling the Java code. After cloning, compile the Java code using:  
```
javac Driver.java
```  

And then run the Java code by running  
```
java Driver
```

Note to turn off sticky scrolling for the terminal and to expand the terminal vertically for the best experience.

## Contact
Email: chudaniel400@gmail.com  
Use this email to give me feedback on this project. Anything is appreciated!