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

My answer is independent of the given code. At the end I will circle back.

First, what should a ticketing system do? Users should be able to crete a ticket (add), solve a ticket (remove) and search for a ticket. Following those three features, we can analyze each data structure.

1. Add tickets (at index 0 or at the end, no need to add to any position):
- LinkedList: O(1) if at index 0 or at the end
- ArrayList: O(1) if at the end and O(n) if at index 0

2. Remove tickets:
- LinkedList: O(n) at any position, but O(1) at index 0 or at the end
- ArrayList: O(n), but O(1) at the end 

3. Get tickets from anyone - from any position:
- LinkedList: O(n)
- ArrayList: O(1)

If we want to track the order of the tickets, something like first in - first out, we should use a LinkedList. This is because we can either add the new items at the end and remove from the beginning or do it otherwise and both ways will be O(1). On the other hand, an ArrayList only has O(1) for the end so we will miss the get or the add, depending on how we define the order.

If our system doesn't care about the order of the incoming tickets, and they will be solved on any order, then the get feature will gain relevance. Not only to get a ticket, maybe to check the status. In this case, an ArrayList will be better because the get feature will matter and it is O(1) for ArrayLists.

If we stick to the given Java code, we are adding the element at the end O(1) and removing the first one O(1). And we have no get feature. Both are O(1) for get but LinkedList is O(1) for add and ArrayList is O(n) to add so LinkedList is better.

## When measuring actual runtime, is the LinkedList version Suho wrote, or your ArrayList version faster? Does this change when the list size is small versus when it is very large?
For n=50 they are similar, being LinkedList slightly better (at the third decimal in my tests). For n=20000 ArrayList was about 20% faster so the difference was significant.

*What I did was do a For Loop with 10 iterations and the average for each case.
- ArrayList n=50: 0.8871207
- ArrayList n=20000: 53.9779083
- LinkedList n=50: 0.8843706
- LinkedList n=20000: 44.1949

## If you ignore queue creation times, does that affect which ticket processor version is faster?
The algorithm is adding elements with the .add() method that in Java adds it to the end. Doesn't affect our last comments because for both the ArrayList and the LinkedList add is O(1) because they are adding at the end. 

## Write a paragraph or two in the style of a technical report (think about – how would I write this professionally if I needed to explain my findings to my manager?).
Your report should answer the following questions:
* What did you learn from this experience?
* Which implementation do you suggest should be used? Are there certain situations that might call for the other approach?
* How does the theoretical time complexity compare with your findings?

I learned with a practical and very concrete measures which data structure may be better given a specific implementation: in this case the usage of add and delete with no get. It is a First In - First Out or "queue" implementation.

If the tickets can be solved as they come, then an ArrayList like a First In -First Out will perform better like a "queue". Second scenario is like the last question where tickets are solved on a Last In First out basis. That is more like an stack and it will be the same to have an ArrayList or a LinkedList. Third scenario is more complex. If user that solves tickets can decide which one to solve first or we need to check the tickets multiple times (maybe different support levels or the user) the get feature will get more relevance. In that case maybe an ArrayList will be better because get is O(1) compared to O(n) in the case of an ArrayList.

Theoretical time complexity is consistent with the test results. It is also consistent that bigger N shows a more evident difference. What was new for me was the variability of results. You can see difference between implementations but you also see some standard deviation for the same implementation.

# Part 4
## What are the Big O and Big Ω times for Javier's algorithm? What are the Big O and Big Ω for space use?



## Write a paragraph or two in the style of a technical report (think about – how would I write this professionally if I needed to explain my findings to my manager?). 
Your report should answer the following questions:
* Which of the two algorithms (yours versus Javier's) is more efficient in time and space (in terms of Big O)
    * What about in actual runtime?
* Which implementation do you suggest should be used? Are there certain situations that might call for the other approach?

