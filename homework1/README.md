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
Time:
- Big O: O(nLog(n)) - Since the array is dividing after we go through all the elements, it is taking Log2(n) steps starting from n to 1. In addition, after we take the corresponding 2 arrays, we will call Merge. That function will go through all the n elements one by one either from the combined loop or the independent ones. So for each Log2(n) it will loop n times. We drop the constants and its O(nLog(n))
- Big Ω: O(nLog(n)) - This algorithm will perform the same no matter if the array is sorted or not. It will always cut the initial ArrayList until the array is of size one, so we will have Log(n). On the other hand, it will always go through the elements to be sure they are sorted: n times.

Space:
- Big O: O(n) - This answer assumes we are in Java. An ArrayList of size n is created and the reused once and again with a smaller size because it is calling .remove() after taking each element. Then after calling merge, it is passing a reference so no more memory is needed. Then it creates a new array result so now we have 2n memory. But after the method is gone, this array disappears with Java's garbage collector. We can simplify 2n to just n
- Big Ω: O(n) - Again the algorithm will perform the same no matter if it is sorted or not.


*Clarification: if we were not in Java (and no Java's garbage collector), calling merge will need more memory because the arrays will accumulate.

## Write a paragraph or two in the style of a technical report (think about – how would I write this professionally if I needed to explain my findings to my manager?). 
Your report should answer the following questions:
* Which of the two algorithms (yours versus Javier's) is more efficient in time and space (in terms of Big O)
    * What about in actual runtime?
* Which implementation do you suggest should be used? Are there certain situations that might call for the other approach?

In summary, recursive algorithm is:
- Time - Big O: O(nLog(n)) - For every recursive step, we are creating two arrays of half of the size, so we will take Log(n) as discussed before. In addition, for every recursive step we need to create the left and right arrays, iterating them by n/2 and n/2. That is why we are getting n times for each of the Log(n) recursive calls.  
- Space - Big O: O(n) - We are creating two arrays of n/2 and n/2 and making the recursive call where getting a n/4 and n/4 arrays. We will divide the size by 2 until base case. If we sum the space needed n + n/2 + n/4 + ... we will approximate to 2n. We drop the constant and its O(n).

Comparing runtime:
- Javier: 0.8667375 ms
- MergeSort: 0.2923832 ms

Since Big O for both time and space complexity, the only reason to use recursive approach instead of iterative is because of runtime (iterative is 3 times recursive). The reason of this may be because of the use of a LinkedList that is a more complex data structure.

I found no reasons to use iterative approach.