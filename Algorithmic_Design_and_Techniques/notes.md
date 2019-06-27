# Algorithmic Design and Techniques
## 1.Programming Challenges
### 1.1 Welcome
#### 1.1.1 welcome
#### 1.1.2 Programming challenges

##2. Algorithmic Warmup
### 2.1 Why Study Algorithms?
#### 2.1.1 Lecture: Why Study Algorithms?

##### Simple Programming Problems

- Has linear scan.
- Cannot do much better.
- The obvious program works.

##### Algorithms Problems

- Not clear how to do
- Simple ideas too slow
- Room for optimization

##### Artificial Intelligence Problems

- Hard to even clearly state.

##### What We’ll Cover

Focus on algorithms problems.:

- Clearly formulated.

- Hard to do efficiently


#### 2.1.2 Lecture: Coming Up

Cover two algorithm problems:

- Fibonacci Numbers

- Greatest Common Divisors

Examples of why algorithms are important.



Both of these problems have a pretty straightforward algorithm.

These very straightforward algorithms are far, far too slow.



### 2.2 Fibonacci Numbers

Learning Objectives:

- Understand the definition of the Fibonacci numbers.
- Show that the naive algorithm for computing them is slow.
- Efficiently compute large Fibonacci numbers

#### 2.2.1 Problem Overview

- Understand the definition of the Fibonacci numbers.
- Show that Fibonacci numbers become very large.

#### 2.2.2 Naive Algorithm

- Produce a simple algorithm to compute Fibonacci numbers.
- Show that this algorithm is very slow

#### 2.2.3 Efficient Algorithm

- Compute Fibonacci numbers efficiently.

#### 2.2.4 Summary

- Introduced Fibonacci numbers.
- Naive algorithm takes ridiculously long time on small examples.
- Improved algorithm incredibly fast.

***The right algorithm makes all the difference***

### 2.3 Greatest Common Divisor  

#### 2.3.1 Lecture: Problem Overview and Naive Algorithm

### 2.4 Big-O Notation

#### 2.4.1 Lecture: Computing Runtimes

**Problem**

- Figuring out accurate runtime is a h uge mess
- In practice, you might not even know some of these details

**want to** 

- Figuring out accurate runtime is a huge mess
- In practice, you might not even know some of these details

#### 2.4.2 Lecture: Asymptotic Notation

**Learning Objectives**

- Understand the basic idea behind asymptotic runtimes.
- Describe some of the advantages to using asymptotic runtimes.

#### 2.4.3 Lecture: Big-O Notation

**Learning Objectives**

- Understand the meaning of Big-O notation.
- Describe some of the advantages and disadvantages of using Big-O notation.

This has several advantages

1. Clarifies Growth Rate
2. Cleans up Notation
3. Can Ignore Complicated Details

Warning:

- Using Big-O loses important information about constant multiples.
- Big-O is only asymptotic.

#### 2.4.4 Lecture: Using Big-O

##### Learning Objectives

- Manipulate expressions involving Big-O and other asymptotic notation.
- Compute algorithm runtimes in terms of Big-O.

### 2.5 Course Overview

What can we teach you?

- Practice designing algorithms.
- Common tools used in algorithm design.

Levels of Design

- Naive Algorithm: Definition to algorithm. Slow.
- Algorithm by way of standard Tools: Standard techniques.
- Optimized Algorithm: Improve existing algorithm.
- Magic Algorithm: Unique insight.

## 3. Greedy Algorithms

### 3.1 Introduction  

#### 3.1.1 Largest Number

What’s Coming

- Solve salary maximization problem
- Come up with a greedy algorithm yourself
- Solve optimal queue arrangement problem
- Generalize solutions using the concepts of greedy choice, subproblem and safe choice

**Greedy Strategy**

1. Make some greedy choice
2. Reduce to a smaller problem
3. Iterate

**Safe Choice**

A greedy choice is called safe choice if there is an optimal solution consistent with this first choice.

![](Screen Shot 2019-06-24 at 17.20.58.png)

### 3.2 Celebration Party  

### 3.3 Maximizing Loot  

##### 3.2.3 review

Main Ingredients：

- Safe choice
- Prove safety
- Solve subproblem
- Estimate running time