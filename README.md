# Scrabble

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

Interactive graphic programming language heavily inspired by
[Scratch](https://scratch.mit.edu).
This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/),
and aims purely to be used with the purpose of teaching in the context of the course
_CC3002 Metodologías de Diseño y programación_ of the
[_Computer Sciences Department (DCC)_](https://www.dcc.uchile.cl) of the
_University of Chile_.

---

## Description
This project is a (simplified) clone of Scratch, developed by Scratch Foundation.

It consists on a block based visual programming language that allows the user to create simple
programs without any specific programming knowledge.

This Scrabble has 5 basic data types:
- Bool (ScrBool)
- String (ScrString)
- Int (ScrInt)
- Float (ScrFloat)
- cl.uchile.dcc.scrabble.AST.Operations.Binary (16-bit) (ScrBinary)

There are multiple operations for these types:
- Transformation between types, listed in the image down bellow (Sí means yes), the Scr types in
  the left can be transformed to those in the right

![img.png](img.png)

- Bitwise not (~) (for Scr cl.uchile.dcc.scrabble.AST.Operations.Binary and Bool)
- Bitwise and (∧)
- Bitwise or (∨)
- Addition (+) or concatenation (for strings)(+)
- Subtraction (-)
- Multiplication (*)
- Division (/)

Each operation can be applied between 2 objects of the same or different types, they are listed down bellow

![img_1.png](img_1.png)

Now the types
can be operated by a three of operations, there is not a graphic way to see this yet, but the bone of the structure is ready!
Some memory optimizations were implemented, so that if there are 2 ScrInt ehith the same value, only one object will be created.
---
For the second part
of the assignment, the procedure was very similar to the first part, the same logic was applied to reach every requirement, now the same operations described before are available in the Ast, the same operations and transformation are available for the scrable type nodes.

There is no interactive interface yet,
so the only way to run the program is to execute the test contained in [test](src/test)
---
##T3
This time
several new additions were made, in first place, now is possible to compare Scr types and nodes;
The ScrInt, ScrFloat and ScrBinary types  can be compared to each other, while the 
ScrBool can only be compared with another ScrBool, the same goes for ScrString. Something similar
happens with the nodes, Int, Float and Binary nodes can be compared with each other, while a Bool and String Node
can only be compared with the same type. If two incompatible Node types get compared,
they will be treated as equals for transformation purposes.
For the comparisons, when comparing two elements with the compareTo method, if the object called on is greater than
the one given as parameter, the return will be the Integer 1 or more, if the values are the same, the return will be the
integer 0, otherwise, the return will be -1 or less.
While comparing String, it's return depends on the ASCII value of the string, with Bool, true is higher than false.

Also,
now the if and while conditions are available, a short description depicting general aspects of each instruction
will be listed down below

#If: 
This method receives 3 parameters, first an Ast with the condition to be met (this Ast must converge to a BoolNode, 
otherwise it won't work), then the ast to be executed if the condition is met, and finally, the ast to be executed if the condition is not.

#While:
This method receives 2 parameters, first the condition for the continuous execution of the loop, and secondly, the code block to be executed 
while the condition is met.


#Extras:

As extras,
the do-while, for and while-Else loops were implemented, as well as a Seq class, in charge of sequentially execute an Ast,
also, comparison Nodes were added, these include greater than, greater or equal, less than, less or equal, and equal to.

#For:
It 
receives 4 arguments, the initialization variable, the condition, the increment to the variable and the code to execute, 
pretty similar to c and java's for (int i=0;i<n; i++)

#doWhile
Pretty 
similar to the while statement, the only difference is that
doWhile receives an extra parameter, Do, which will be executed
at least once, even if the condition for the while isn't true.

#While-Else
Similarly
to python's while else, receives one more parameter
than while, the else instruction, this instruction 
will be executed if the while condition stops being met,
actually, it'll be executed even if it's never met!
---
Documentation available at [javaDoc](javadoc/index.html)