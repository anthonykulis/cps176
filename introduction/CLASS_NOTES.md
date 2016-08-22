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
