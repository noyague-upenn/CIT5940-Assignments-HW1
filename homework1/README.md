## Please enter your personal info here:
Name:

PennKey (e.g., taliem):


# Part 1:
## Are Alicia and Lloyd both wrong, or perhaps both right? Is only one of them correct? Why?
Regarding snippet A, Alicia is right: is O(n). For a list, size is O(1) but get depends on n. In this case, we are doing get(middle) so it  should have to traverse the list to reach middle. The bigger n, more steps are required.

Regarding snippet B, it depends on the List we are looking at. If we are in the Java world, Alicia is right again: is O(1). In Java get and remove will take O(1) if you want to get the first or last element because the data structure will save the head and tail. If we are not in Java and only have the head, remove or get from the last element will take O(n).

# Part 2:
## What are the Big O and Big Ω times for snippets C and D?
Snipped C:
- Big O: n*m because in the worst case the element is the last one (or not found) and will have to loop m (columns) times each n (rows).
- Big Ω: best case scenario the target it at first position so it will change boolean variable found to true and break both loops.

Snipped D:
- Big O: it will always loop n*m, no matter if the element is found or not. The logic just prevents from saving twice. So it will loop m (columns) times each n (rows).
- Big Ω: same as Big O. It will be n*m because even if the target is found, it will continue looping.

## When measuring actual runtime, does one of the snippets run faster than the other? In what situations? Why do you think this is the case?
Using getGridOne():
- Snippet C runs faster than Snippet D.
- The reason is that this test case has the result in the first element so it is basically testing Big Ω.
- This is consistent with our previous analysis: this is because snippet C just do one loop and its done while Snippet D is iterating everything.

Using getGridOne():
- Snippet C and Snippet D takes similar amount of ms.
- The reason is that this test case has the result in the last element so it is basically testing Big O.
- This is also consistent with our previous analysis: both will perform similar because they have to iterate all the grid.

## What else do you notice about the reported runtime? Is it 100% consistent every time you run it?
I have noticed runtime is similar but it is not exactly the same on each run. Honestly I don't know why, but since computer is performing a lot of stuff under the hood I guess things mostly related to compilation and memory allocation may vary between each time we run the program. In Java, the language handles this and more stuff (like garbage collection), so we can't control exactly how is doing it and have a better runtime performance control. Conditions may be slightly different between each time we press run. 

# Part 3:
## Before you make any changes, explain whether you think a LinkedList or an ArrayList makes more sense in this instance. Which do you think will be faster? Why?


## When measuring actual runtime, is the LinkedList version Suho wrote, or your ArrayList version faster? Does this change when the list size is small versus when it is very large?


## If you ignore queue creation times, does that affect which ticket processor version is faster?


## Write a paragraph or two in the style of a technical report (think about – how would I write this professionally if I needed to explain my findings to my manager?).
Your report should answer the following questions:
* What did you learn from this experience?
* Which implementation do you suggest should be used? Are there certain situations that might call for the other approach?
* How does the theoretical time complexity compare with your findings?







# Part 4
## What are the Big O and Big Ω times for Javier's algorithm? What are the Big O and Big Ω for space use?



## Write a paragraph or two in the style of a technical report (think about – how would I write this professionally if I needed to explain my findings to my manager?). 
Your report should answer the following questions:
* Which of the two algorithms (yours versus Javier's) is more efficient in time and space (in terms of Big O)
    * What about in actual runtime?
* Which implementation do you suggest should be used? Are there certain situations that might call for the other approach?

