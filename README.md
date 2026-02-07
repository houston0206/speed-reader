# Speed Reader

## About

This project is a speed reader that displays one word at a time to increase reading speed.
Also includes: Semantic Mysteries lab from Monday and Empirical Complexity lab from Friday.

### Authors

*  El Houston
*  Oscar To

### Resources

*   Class lab page: https://osera.cs.grinnell.edu/ttap/data-structures-labs/speed-reader.html 
*   Java scanner class: https://www.w3schools.com/java/java_user_input.asp 
*   `DrawingPanel.java` adapted from _[Building Java Programs](https://www.buildingjavaprograms.com/) by Reges and Stepp.

## Write-up

### Semantic Mysteries

#### Problem 1.1

What is the difference in calling the following three change methods, and why is this the case?

The difference between the three change methods are what they take in as params and what they actually do in practice. 
change1 takes an int x as a param, and changes the value of x to 5. change2 takes a cell object as a param, and changes its
x field (property) to 5, while change3 takes a cell object as param, sets x field to 5, but then resets the cell by making it a 
new cell object. 

What’s the rule here? Does java pass parameters by value (i.e., copy) or by reference? Is passing an object (with an arbitrary number of fields) to a function more costly than passing a primitive?

Java passes by value. Passing an object is more costly than passing a primitive (more fields), but just passing the value doesn't work because you aren't passing the actual field. If you pass an object it still passes by value, but it passes a copy of the pointer to the object.

#### Problem 1.2

What is the this variable in a method, and where does it come from? How do these four classes differ with respect to their increment methods?

This variable in a method is a self-referencial variable that refers to the object that was accessed when the method was called. Counter1's increment takes no params, and it's incrementing an arbitrary value. Counter2's increment takes in a value as a param, and doubles the parameter, not the object value. Counter3 takes in an int value, and adds the parameter to the object value. Counter4 takes in an int value, and increments the parameter with the object value. Only Counter1 and Counter3 work as they are supposed to.

What’s the rule for variable look-up in Java? How does this differ from function calls in C?

Scope. Variable look-up in Java is dependent on the scope of the look-up function—it's dependent on what the function has 
access to (public vs private).

#### Problem 1.3

What is the distinction between a static and non-static member (i.e., field or method)? In particular, imagine using this variant of a counter. Why does this (first) code not work? How do you fix it?

If value is static, it belongs to the whole class and not a specific object, which means you can't use `this`. To fix it, make the int `value` non-static so that the increment method can be called on a new Counter object.

In general, what is the rule for mixing static and non-static things? Does this (second) code work? Why or why not?

You can't make a static reference to a non-static method or variable. The second code doesn't work because the printGreeting method is non-static, meaning it needs an object to access it and there isn't an object.


#### Problem 1.4

Does the following code snippet behave as you expect? Why? How do you fix its behavior?

It doesn't. I'd expect the equality operator to work, since both are set to 0, but since they're comparing objects, it won't work. We can fix its behaviour by comparing c1.value and c2.value instead.

With this in mind, does this code behave as you expect?

Yes. They're comparing references to string literals, which are the same. When you declare a new immutable string, it checks the string pool for an equivalent value, and makes the reference values equal. This has been shown earlier.  

How about this snippet? What’s the difference between these two snippets and why?

The second snippet doesn't work because the scanner doesn't use the string pool, so each time the scanner is used, the string is given its own reference value. Since (s3 == s4) is checking for reference equality, not value, it won't work.

#### Problem 2.1

(always: ✓, sometimes: ?, never: ✗)

*   Point A:
    + `x1 == 0`: ?
    + `x2 < 0`: ?
*   Point B:
    + `x1 == 0`: ?
    + `x2 < 0`: ✗
*   Point C:
    + `y1 < 5`: ?
    + `y2 > 0`: ✓
*   Point D:
    + `z > y1`: ?
    + `z < 0`: ✗

#### Problem 2.2

(always: ✓, sometimes: ?, never: ✗)

|         | `s.length >= 2` | `ret.length() > 0` | `ret.length() % 2 == 0`
| ------- | --------------- | ------------------ | -----------------------|
| Point A |        ?        |        ✗          |            ✓           |
| Point B |        ✓        |        X          |            ✓           |
| Point C |        ?        |        ?          |           ✓            |
| Point D |        ?        |        ✓          |          ✓             |
| Point E |        X        |         ✓         |           ✓            |

### Empirical Complexity Analysis

How accurate is the operation counting method of measuring time complexity compared to the wall-clock method for understanding how the time complexity scales with the size of the input?

Measuring time complexity seems more accurate. The operation counting method puts it on a linear scale, but the array access gets much bigger with the size of the array and the data isn't as easy to look at on a graph. The time complexity measurement uses a log scale and you can see the differences between the functions more easily. Compute1 does not return a value if the array is too big because it takes too long. Compute2 has a typical scale, and Compute3 takes around the same number of time regardless of array size.

Graphs:
![Graph for part 1](Graph1.png)
![Graph for part 2](Graph2.png)


### Usability Testing
