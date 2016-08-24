# Introduction to Computers and Java
Class notes for Chapter 1

## 1.1 Introduction
* Before diving into code, we need to understand the fundamentals of how hardware and software work together.  

## 1.2 Why Program?
### Computers can perform many various operations because they are programmed.
* As an counter example, an Integrated Circuit (IC) can only perform one job and are the "fastest" logic controllers
* As another counter example, a FPGA can perform many tasks, including those found in many ICs, may perform faster than CPUs and slower than ICs. Their benefit is that their intended logic can be developed faster than ICs (and slower than CPU based software). This provides a middle ground between an IC and a CPU based system.
* As a final counter example, a Micro-Controller (uC) is excellent as performing a define set of tasks, is very nimble for development, but is not typically as specific as a FPGA and is a lot less flexible as a CPU.
* CPU based systems are "general" and because of the extra underlying layers to make them general, tend to perform slower than their FPGA and IC counter parts. This allows massive flexibility, hence why we have ubiquitous computing on CPU based systems and not ICs, FPGAs, or even uCs.
* The CPU via an *instruction set* allows it to be programmed.
  * Writing programs with a CPU instruction set is time consuming at a minimum.
  * Over time we have developed layers of abstraction to access the instruction set.
  * There are considered to be 4 generations of languages. This class will cover a 3rd generation language (Java)

## 1.3 Computer Systems: Hardware and Software
* All computer systems use the Von Neuman architecture. This allows for similar hardware interfacing and software development.

### Hardware

* The physical components the computer is made of.
* 5 Major Classifications of Components -
  1. The Central Processing Unit (CPU)
  2. Main Memory
  3. Secondary Memory / Storage
  4. Input Devices
  5. Output Devices

#### The CPU

* The "heart" of the computer
* Workflow of CPU is basically to fetch an instruction, follow the instruction, and produce some resulting data.
* Internally can be categorized into 2 major subdivisions
  1. Control Unit
  2. Arithmetic and Logic Unit (ALU)
* Works in cycles (per core)
  1. Fetch - gets the next sequenced instruction from main memory
  2. Decode - turns that instruction into a usable format for signal outputs on CPU pins
  3. Execute - routes that signal (via turning on and off pins) to a given device (secondary memory, ALU, video card, etc)

#### Main Memory
* Commonly called Random Access Memory (RAM)
* RAM holds the sequence of instructions for the CPU
* RAM is separated into a logical format called *Words*
  * A word on a 32bit system is typically 4 Bytes and 8 Bytes for a 64bit system
  * Each Byte is 8 Bits
  * Each Bit is either 1 or 0 (binary)
  * Question - Explain binary. Also, besides bit and byte, there are two other popular number formats. Hint: Binary is a base 2 number and decimal is base 10. The two I am looking for are base 8 and base 16, but have common names.
* RAM is *ordered*. This means we can access it logically from start to finish by supplying it an address.
  * For instance - if we are RAM that has 32bit words (8 Bytes), each address accessible with be in steps of 8 Bytes, e.g. 0x0000, 0x0008, ..., 0xFFFF
* RAM is typically volatile. This means when it loses power it loses the instruction set loaded into it.

#### Secondary Storage
* Consider secondary storage to be your long term storage.
* SSD, HDD, Flash, even the *cloud* can be secondary storage.

#### Input Devices
* A computer is useless to us unless it can take input from the outside world.
* For general computing, the obvious keyboard and mouse are input devices.
* Question - what are some other input devices you can think of?

#### Output Devices
* Again, the obvious monitor, speakers, printer are output devices.
* Question - what are some other output devices?

### Software
* Programs that run the computer
* Two categories of software
  1. Operating Systems
  2. Applications

#### Operating Systems
* Generally speaking, the OS is used to allow applications to interface with the physical hardware
* Also provides rules for executing programs (the scheduler), allocating memory, allocating processing cores, etc.

## 1.4 Programming languages
* First thing to always remember, a programming language is simply a tool. Just like a screwdriver is great for screwing in a screw, is terrible for hammering a nail. Choose the correct tool for the job.

### What is a program?
* A set of instructions designed to solve a problem.
* Sequenced steps or order is driven by data events
  * Sequenced steps are instructions that mean something similar to "step 1, then step 2, ..., step N, exit or loop to step 1".
  * Data driven events are events that cause the known data set to "update", causing a defined set of instructions to take place. For instance, if you imagine a GUI, we wait for the user to interact with an input. Once this input is initiated, we may fire off a sequenced set of steps, but once finished we will wait for the next input event.

* In a programming we use mostly human readable languages that are then translated into machine code. This can occur from compilation to machine code, compilation to byte code for a virtual machine, or interpreted code that is never compiled.
  * C/C++ is an example of human readable code compiled to machine code
  * Java is an example of human readable code compiled to byte code which runs in a Java Virtual Machine (JVM)
  * Python is an example of human readable code that is not compiled but rather interpreted. We typically call this "scripting". The interpreter translates human readable code into machine code on the fly, and because of so, scripting languages tend to be the slowest to execute but provide that fastest development time. Python is famous as a "prototyping language" although it is used in production frequently and successfully.

#### Java - Applications and Applets
* The java application runs in the Java Virtual Machine (JVM). As already noted, when Java source is compiled it is compiled into Java byte code. This byte code is then run in the JVM. Because of this, it makes Java *portable*. This means a single compiled Java application can be run on all forms of operating systems as long as a JVM exists on that operating system.
* The Java Applet is designed to run in browsers as *Agents*. Just like a secret agent is dispatched to do your bidding, the Applet is dispatched from the server to do its bidding on the client machine.
  * Java Applets are ***DEPRECATED***. They are deprecated by force. All modern browsers are dropping the plugin architecture and Oracle (who owns Java), has stated that will no longer include it in Java after the Java 9 release.
  * Deprecation means we are not to use the deprecated item any more. This includes methods, libraries, etc. You will encounter this word often.
  * Because of the deprecation, I will only cover this topic if we have time and only do it for the novelty. But from here on out, you are not responsible for knowing anything about Applets.

## 1.5 What is a program made of?
* Certain elements are common throughout all programming languages

### Language Elements
* Keywords - words provided by the language that provide special meaning and can only be used in that context. Example `class` is a keyword and can only be used when defining a class `public class Example`
* Operators - Operators are symbols or words that perform operations on one or more operands. Example `1 + 2`, where `+` adds 1 and 2
* Punctuation - Not all, but most programming languages have some form of punctuation. Like keywords, this punctuation can only be used in appropriate locations. Example the `;` - `int ageOfDog = 3;`
* Programmer-Define Names - AKA *Indentifiers*, these are words created by the user to identify hard to understand machine concepts, like a memory address. For instance `ageOfDog = 1` may have a machine address of `0x01f43ffa1` and hold a value of `00000001`. Obviously, trying to remember what `0x01f43ffa1` refers to at a later date is nearly impossible.
  * From Google: *"Identifiers are the names of variables, methods, classes, packages and interfaces. Unlike literals they are not the things themselves, just ways of referring to them"*
* Syntax - Just like the English language requires a noun and a verb, programming languages have constructs that define them and how they should appear. This means that items such as `keywords`, `identifiers`, `punctuation`, and `operators` are required to appear in certain orders and that grammatically create a legal program.

#### Example Language Elements
* Please visit the [sample program](../examples/introduction/Payroll.java) for a highly verbose example of language elements
* A list of Java keywords can be found on page 10, table 1-3 in your text book. They are testable items!

#### The Compiler and the Java Virtual Machine
* We already saw an example of the compiler `javac` and the Java Virtual Machine (JVM) `java`.
* The software engineers written code is called `source code`. It is typically shorted to `source` or `code`. In scripting languages it is common to call the source code `scripts`.
* When we run `javac` on our source code, eg `javac MyProgram.java`, we invoke the compiler to translate the source code into Java `byte code`. This will create a file named `MyProgram.class` if it compiles with no errors.
  * Java byte code is specific to the JVM and cannot be used outside the JVM, hence these are not `executable files` and cannot be double clicked or called directly from the command line. They ***must*** be called from the JVM.
* Once we have a compiled source, we can then run our application by invoking the JVM and passing our Java byte code signified by `.class` to the JVM - `java MyProgram` - without the trailing `.class`

#### Java Portability
* One of the best benefits of Java is I can write one program and distribute it to all computers in the world irregardless of their operating system ***as long as they have a JVM***.
* For a counter example, in the language `c`, we compile the source code into machine code for a specific operating system. This means a `c` application compiled for Linux cannot run on Windows.

#### Java Software Editions
* The Java software you use to write applications is called the *Java Developement Kit* or *JDK*. There are 3 standard editions of the JDK.
 1. *Java SE* - This is the standard edition and it provides all the essential software tools to make Java application.
 2. *Java EE* - This is the enterprise edition. It includes all the Java SE components and includes addition tools and libraries for high scale, high performance enterprise applications.
 3. *Java ME* - This is the micro edition and is in a light weight and optimized version for mobile and embedded applications.

#### Integrated Development Environments (IDE)
* To facilitate large scale applications IDEs were developed. They provide numerous tools to help in complex building of applications, debugging of applications, and tend to provide support for user defined plugins.
* Loosely speaking, text editors can be IDEs assuming they provide the plugin support. I currently use [Atom](http://atom.io) which is very lightweight editor but has open ended plugin support. If I choose, I could continue to provide it plugins until it mimics the heaviest IDEs (eg Netbeans) or keep it as lightweight as a simple text editor with no language support.

## 1.6 The Programming Process
* We shall stop here for today
