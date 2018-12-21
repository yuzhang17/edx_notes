##Software Construction: Data Abstraction笔记
###4: Type Hierarchies, Polymorphism and Dispatching
####overview
Many object-oriented programming languages use type hierarchies(类型层次结构) and polymorphism（多态） to simplify the expression of software.

Things you'll learn:
- What options there are for types in Java (Classes, Abstract Classes, and Interfaces), and which type can be used to create objects (just Classes!)
- Type hierarchies: get to know how subtypes can be used in place of super types for declaration, instantiation and parameter passing
- Method dispatch: how Java determines which implementation of a method to use when that method is called
- How to extract a type from a class to better structure a codebase and make it more extensible 。

####Introduction to Types, Polymorphism and Dispatch
 **how developers  implement hierarchies into their code？**
   programmers use the concept of a type hierarchy to take what's really common and put it at one type, and then separate out as subtypes pieces that have some shared commonality but are different



**how polymorphism and dispatch allow objects to behave differently in different contexts？**
 Polymorphism，If you break it down into what it means, it just means taking many different forms.
 So with polymorphism, we get the opportunity in our programs to have a variable that refers to a type that might be animal
 
 **these are the three fundamental principles of object orientation。**
- building up type hierarchies,
- understanding how types interact with one another to make a running program,
-  how object-oriented languages actually get the correct behavior to execute.

####  Types
##### 
