##Simple Language Interpreter

A simple interpreter for a custom programming language with basic arithmetic, variable assignment, conditional statements, and print functionality.

##Table of Contents

Introduction
Features
Installation
Usage
BNF Grammar
Examples
Contributing
License
Introduction

This project is an implementation of an interpreter for a simple programming language. The interpreter can handle basic arithmetic operations, variable assignments, conditional statements (if-else), and print statements.

#Features

Arithmetic operations: +, -, *, /, >, <
Variable declarations and assignments
Conditional statements (if-else)
Print statements
Installation

To run the interpreter, you need to have Java installed on your system. Follow these steps to set up the project:

Clone the repository:

bash

git clone https://github.com/yourusername/simple-language-interpreter.git
cd simple-language-interpreter
Compile the Java files:

bash

javac -d bin src/*.java
Run the interpreter:

bash

java -cp bin Interpreter
#Usage

Create a new file with your program code, for example, program.txt.

Run the interpreter and pass your program file as an argument:

java -cp bin Interpreter program.txt
#BNF Grammar

#The language follows the BNF grammar below:

<program> ::= <statement> | <statement> <program>
<statement> ::= <assignment> ";" 
              | <expression> ";" 
              | <if-statement>
              | <print-statement> ";"
<assignment> ::= "var" <identifier> "=" <expression>
<if-statement> ::= "if" "(" <expression> ")" "{" <statement-list> "}" <else-clause>?
<else-clause> ::= "else" "{" <statement-list> "}"
<statement-list> ::= <statement> | <statement> <statement-list>
<print-statement> ::= "print" <identifier>
<expression> ::= <term> 
               | <term> "+" <expression> 
               | <term> "-" <expression>
               | <term> ">" <expression>
               | <term> "<" <expression>
<term> ::= <factor> 
         | <factor> "*" <term> 
         | <factor> "/" <term>
<factor> ::= <number> 
           | <identifier> 
           | "(" <expression> ")"
<identifier> ::= <letter> | <letter> <identifier>
<number> ::= <digit> | <digit> <number>
<letter> ::= "a" | "b" | "c" | ... | "x" | "y" | "z" 
           | "A" | "B" | "C" | ... | "X" | "Y" | "Z"
<digit> ::= "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9"

#Examples

Example Program
var x = 10;
print x;
if (x > 5) {
    print x;
} else {
    var y = 5;
    print y;
}
Running the Example
Save the above program to a file named example.txt.
Run the interpreter:

java -cp bin Interpreter example.txt
#Contributing

Contributions are welcome! Please open an issue or submit a pull request for any changes you would like to make.
