/* *****************************************************************************
 *  Name:  Naveed Bin Sattar
 *  ClarkID: C70269224    
 *  Precept:  
 *
 *  Partner Name:       
 *  Partner NetID:      
 *  Partner Precept:    
 *
 *  Hours to complete assignment (optional): 13 hours approximately
 *
 **************************************************************************** */

Programming Assignment 4: Slider Puzzle


/* *****************************************************************************
 *  Explain briefly how you represented the Board data type.
 **************************************************************************** */
The board data type for me was represented using a double-integer array (or 2D integer
array). Basically, my Board class creates a deep copy of the input, tiles[][], and works
with that. Generally, everything uses this 2D integer array. All method calls work with a 
specific value for the row and column of each value stored in the 2D array, representing the 
position of tiles. For example, the top right corner tile in 3x3 board would be board[0][2].


/* *****************************************************************************
 *  Explain briefly how you represented a search node
 *  (board + number of moves + previous search node).
 **************************************************************************** */
For the representation of a search node, my program had a separate SearchNode method that
works with a comparable. Within it are instance variables for the board object, manhattan
distance, priority and moves of the SearchNode. The search node assigns the manhattan distance
and moves values of the instance variables and then calculates the priority and assigns
the priority instance variable that value. In my function, priority is calculated in line 27
as this.moves + this.manh.

/* *****************************************************************************
 *  Explain briefly how you detected unsolvable puzzles.
 *
 *  What is the order of growth of the running time of your isSolvable()
 *  method in the worst case as function of the board size n? Recall that with
 *  order-of-growth notation, you should discard leading coefficients and
 *  lower-order terms, e.g., n log n or n^3.
 **************************************************************************** */

Description: As mentioned in the instruction page, the unsolvable puzzles can be identified
by counting the number of inversions. For an odd-sized board, if the number of inversions are odd
then the board is not solvable. For an even-sized board, the board is unsolvable if the number of inversions 
plus the row of the blank square is even. My method calculates the inversions by checking the tile at each
position in the board and then comparing it to its position to check how far the tile is from its correct 
position. It uses something similar to sorting. Inversions are counted +1 everytime the tile being processed 
is 1 place out of position.

Order of growth of running time:
N^2 (N squared)


/* *****************************************************************************
 *  For each of the following instances, give the minimum number of moves to
 *  solve the instance (as reported by your program). Also, give the amount
 *  of time your program takes with both the Hamming and Manhattan priority
 *  functions. If your program can't solve the instance in a reasonable
 *  amount of time (say, 5 minutes) or memory, indicate that instead. Note
 *  that your program may be able to solve puzzle[xx].txt even if it can't
 *  solve puzzle[yy].txt and xx > yy.
 **************************************************************************** */


                 min number          seconds
     instance     of moves     Hamming     Manhattan
   ------------  ----------   ----------   ----------
   puzzle28.txt     28		0.03		0.03	
   puzzle30.txt     30		0.05		0.048
   puzzle32.txt     32		0.85		0.84
   puzzle34.txt     34		0.24		0.19
   puzzle36.txt     36		4.05		4.12
   puzzle38.txt     38		Out of Memory Error 
   puzzle40.txt     40		0.9		0.9 
   puzzle42.txt     42		Out of Memory Error



/* *****************************************************************************
 *  If you wanted to solve random 4-by-4 or 5-by-5 puzzles, which
 *  would you prefer: a faster computer (say, 2x as fast), more memory
 *  (say 2x as much), a better priority queue (say, 2x as fast),
 *  or a better priority function (say, one on the order of improvement
 *  from Hamming to Manhattan)? Why?
 **************************************************************************** */
Considering the tests performed above, I would think that my program either cannot handle
puzzles that require high memory or is not efficient enough to handle them with the memory
provided. Hence, I would say that for my program I would prefer more memory or a better/more
memory efficient program. However, this is from the perspective of going off of testing cases 
above.

/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */
I know that the Board Timing is not as good as it is supposed to be. It fails to run
after a certain N value (right about around N = 200). Although I've tried increasing the efficiency
of my program, anything I try messes something else up.


/* *****************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 **************************************************************************** */
My most helpful resource has to be TA Nicholas. He helped me envision the project in ways
I would have never figured out on my own, and I was able to use his tips and teachings to 
both increase the performance and correctness of my code. In addition, I've also used the video
provided for 8 puzzle.


/* *****************************************************************************
 *  Describe any serious problems you encountered.                    
 **************************************************************************** */
I started my code by using a 1D array for the Board class, which was causing serious 
issues in both the correctness of the code and the timing/performance of it. In addition,
my Solver class had also not been processing input properly or outputting them correctly. However,
after using the Stack implementation several problems were fixed. In addition, I faced a lot of
trouble initially, trying to envision what the code framework should look like.


/* *****************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 **************************************************************************** */







/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **************************************************************************** */
I learned a lot from this project, especially regarding small tips and tricks in improving
the performance of a program. In addition, I also learned a lot more about the importance of figuring
out appropriate data types and frameworks for code, before actually attempitng to code something. Overall,
the project helped me learn a lot, but I cannot say that I had an easy time doing it. It definitely made me
break a few sweats.