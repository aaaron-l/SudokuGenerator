# **SUDOKU GENERATOR DESIGN DOCUMENT**

---

## **Program Overview**

My program is meant to generate a solved Sudoku board, which can be used later to mask certain numbers to create a console-playable Sudoku game.

---

## **Data Structures**

I used a 2D array to store 9 arrays of 9 integer elements.

I went through each element of the arrays recursively to place a valid digit (1–9) in each position.

---

## **Algorithm Design**

My program first generates a random number *n* from 0–8. Then it converts it into a number from 1–9 using a for loop and the formula:

(n \+ k) % 9 \+ 1

where *k* starts at 0 and increments while *k \< 9*. This ensures that the value assigned to each element is always between 1–9, starting from the randomized position.

This number then goes through a check, which loops through the corresponding row and column of the current element in the 2D array, ignoring the element’s own position. This ensures that no duplicate values exist in the same row or column.

Next, the program checks the 3×3 box in which the element resides, ensuring that there are no duplicate values within that box.

If the number passes all checks, the program makes a recursive call to process the next element in the array. If the end of a row is reached, the column resets to 0 and the row increases by 1\.

The `generate` method includes a base case: if the row exceeds 8, it returns `true`, indicating that the board has been successfully generated.

If all 9 possible values fail the check, the method returns `false`, resets the current cell to 0, and exits the recursive call. The program then backtracks to the previous cell and tries the next possible value.

This process continues until a valid configuration is found for the entire board. This method guarantees that a board will eventually be generated, although its efficiency depends on randomness.

---

## **Methods**

In the `SudokuGenerator` class, there is a constructor that takes no parameters and calls the `generate` method with `(0, 0)`, representing the starting row and column.

The `generate` method is a recursive method that places a value in the current position, checks its validity, and proceeds to the next position if valid. This method is responsible for generating the board.

The `check` method accepts an integer along with its row and column, and checks all corresponding rows and columns for duplicate values. It returns `true` if a duplicate is found. It also calls the `checkBox` method.

The `checkBox` method checks the 3×3 box that the element belongs to, ensuring no duplicate values exist within that box.

The `toString` method formats and prints the board in the console.

In the `Main` class, the `main` method creates an instance of `SudokuGenerator` and prints the generated board.

---

## **Testing Plan**

1. I ran the program multiple times, and each time it produced a completely filled Sudoku board (no zeros).  
2. After each run, I verified that there were no duplicate numbers in any row, column, or 3×3 box.  
3. Each generated board was different, confirming that the program produces randomized Sudoku boards.  
4. I changed the starting parameters of the `generate` method, and the program still correctly filled all reachable cells, showing that the algorithm can generate a valid board from different starting points.  
   ---

   ## **Challenges and Solutions**

The first challenge I encountered was generating a random starting value while still ensuring that all numbers from 1–9 were tested. Initially, I generated a random number from 1–9. However, I later realized I could loop through all values using a shifted starting point. I generated a number from 0–8 and used modular arithmetic to cycle through all values. This ensured that all numbers were tested without exceeding the range.

The second challenge was implementing backtracking. At first, I was unsure how to structure the recursion. I realized that each placement decision is essentially binary: either valid or invalid. Based on this, I made the method return a boolean value. When a placement failed, the method returned `false`, triggering backtracking. This process continued until a valid configuration was found, eventually returning `true` through all recursive calls and completing the board.