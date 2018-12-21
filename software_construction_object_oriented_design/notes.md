##Software Construction: Object Oriented Design
###0 联想问题记录
1. 很多程序中都使用了异常机制，异常机制时如何提出的，用来解决哪些问题


###5. Designing Robust Classes
####5.0 Long Form Problems :CoffeeMaker Project
**What you will learn about in this project:**

- Designing your own Exception classes
- Extending existing and created Exception classes
- Translating REQUIRES clauses and class invariants into exceptions
- Refactoring specifications to include exceptions
- Throwing exceptions
- Testing exceptions
- Robust method specification, use, testing and implementation

####5.1 Module Overview
**Things You'll Learn**

- How to use Exceptions to design programs that can recover from exceptional states. 
- How to test programs that have exceptions
- How to use Assertions in the development stage to discover when your program is behaving improperly

#### 5.2 Introduction to Robust Classes

So if your program is small and there aren't many conditions
to handle, you can get away with that.
But as your program gets larger and there's more conditions
that you might have to deal with, the code can get way too complicated
to have that all interposed together.
So what programming language designers have done over time
is create constructs called exception handling mechanisms
to allow you to separate the regular execution of your code
from these exceptional conditions.
And as a result, we can write larger programs
that are easier to read and maintain.

#### 5.3  What is Robustness?  
- We discuss two ways to increase the robustness of your code: Exceptions and Assertions
- Exceptions are a way to handle exceptional scenarios that happen during execution -- they allow you to specify how to recover execution if things have started to go wrong.  Having code dedicated to handling these exceptional scenarios helps make your code more robust, because you can save it from crashing in these predicted situations. 
- Assertions are checks that are placed within your code to assess whether a class's internal state is consistent with its specification.  Assertions allow you to discover issues with your code, prior to deploying it to users.
If the exception is not caught it keeps falling down the alternate exceptional path until the program effectively crashes

####5.4 Exceptions 
##### 5.4.1 Throwing an Exception

**Technical points in this video**

- A call-stack is formed when one method calls another.  If a() called b(), we would see b() stacked on top of a().  We can then say that the return path out of b() would be back down into its calling method, a(). 

- Exceptions are not just error messages. Exception mechanisms in a programming language let us write code to recover from errors, and resume normal execution of the code. 
- Exceptions are objects that are "thrown" by a method. This is done with the keyword throw, and then the construction of a new exception object (new Exception()).  This would look like:
` throw new SomeException();`

- Throwing the exception object causes an alternate return path to be taken: once an exception is thrown, none of the subsequent code in that method is executed.  Instead, the exception object can be thought of as falling back down the return path to the calling method.   
- Normal execution through the normal return path does not resume until the exception is caught.  If the exception is not caught it keeps falling down the alternate exceptional path until the program effectively crashes.


- Exceptions can be caught by a method with the keywords try and catch.  First, we try to call the method by placing the method call within the try's block of code, and if an exception is thrown in that method, then we catch that exception and execute the code in the catch block.
```
try {
    method();
} catch (SomeException e) {
    System.out.println("Never mind let's keep going");
}
```

- A method should only catch an exception if it can actually do the work to recover from (handle) that exception.  If it is not appropriate for the current method to deal with an exception, and recover execution, then it should just pass it along, letting the exception object keep falling down the return path.  In that case, the method would not use the try/catch block.  Instead, the method would be indicated as thrown in the method signature: 

    ```
    public void theMethod() throws SomeException {
        otherMethod();
    }

    private void otherMethod() throws SomeException{
        if(someCondition){
            throw new SomeException();
        }
    }
    ```
    
##### 5.4.2 throwing a Second Exception

**Technical points in this video**


- Exceptions can be thrown from anywhere, including inside of a catch block.

    ```
    try {
        amethod();
    } catch (Exception someException) {
        throw new OtherException();
    }

    ```
- Just like exceptions thrown from elsewhere, no subsequent code in the throwing method executes, instead the exception is thrown out along that separate path, and normal operation does not resume until the exception is caught.  

##### 5.4.3 Finally
**Technical points in this video**

- A Try/Catch statement has a third part: Finally

- The Finally block of code executes either after the catch block (whether an exception was caught or not), or before the method exits if an exception is thrown within the catch block.   

    ```
    try {
        otherMethod();
    } catch (SomeException e) {
        System.out.println("Never mind! We can handle that!");
        throw new AnotherException();
    }
    finally {
        System.out.println("this will print whether SomeException was caught or not");
        System.out.println("Yes, even though AnotherException was thrown");
    }
    ```

##### 5.4.4 Exception Hierarchies
**Technical points in this video**

- Exceptions are regular classes, and as such, one exception can subclass another.  
- If an exception is declared to be caught, as in catch (SuperException supe) {..., any of the subclasses of that exception will also be caught by that same catch statement.
- Exception hierarchies are typically used to provide a standard response to an entire hierarchy of exceptions, while still leaving open the option for catching more concrete exceptions individually as needed.
- Just remember that catches execute in order, so if there was also a catch (SubException sube), you would need to place its catch before that of its super class -- otherwise the exception will get gobbled up before the SubException catch is reached

##### 5.4.5 Unchecked Exceptions
**Technical points in this video**

- Up to now we have been implementing exceptions that are noticed by the compiler -- this is why IntelliJ (or your IDE) complains when you haven't surrounded a method call with try/catch, or haven't added a potentially thrown exception to the method signature.  These are called checked exceptions, because they are checked by the compiler.
- There are also unchecked exceptions.  These are exceptions that the compiler will not complain about, and which do not have to be explicitly listed in a method signature, even if the method potentially throws that exception.  
- An example of an unchecked exception is an ArithmeticException -- the kind of exception you might get if you try to divide by zero.
- Unchecked exceptions are used for errors that could often happen, but rarely do.  For instance, you would not want to have to try/catch every time you use division in a program.  As a corollary to that, division hardly ever produces an error -- and if it does, you can spot that during testing, and perform the necessary checks to ensure it doesn't happen again.
- We can, however, catch unchecked exceptions using the try/catch mechanism, just as we would a checked exception

#### 5.5 Testing Exceptions
**Technical points in this video**
- When testing code that throws exceptions, we want to make sure exceptions are thrown in the right situations
- We devise test cases to exercise the full range of outcomes of the method -- meaning that we want to test all the situations in which we expect an exception to be thrown, and all the situations we expect the exception will not be thrown
- A simple way to test exceptions within a JUnit test is to call a method, and then fail if the exception is caught when it shouldn't be:
```
try {
 anObject.aMethod(nonExceptionalInputs);
} catch (SomeException e) {
 fail("I was not expecting SomeException!");
}
```
-  fail if the exception is not thrown when it should have been:
```
try {
 anObject.aMethod(problematicInputs);
 fail("I was not expecting to reach this line of code!");
} catch (SomeException e) {
 System.out.println("great!");
}
```
#### 5.6 Assertions
**Technical points in this video:**

- Assertions let us programmatically check what should be true at certain points in our program. 
- Assert statements are the same as those used in tests, but they are placed within the code of our class, rather than in an external test class.
- Assertions help us to discover erroneous behaviour in our code.
- By asserting what should be true at the start of a method, and then asserting what should be true at the end of the method, we can ensure that the method has accomplished its work.
- A nice benefit of assertions is that they have access to private data within the class, so checking internal state is very straightforward.
- All the extra code associated with assertions will make your code run more slowly, so we use a compiler option to turn them off when we're deploying the code for use outside of testing.



