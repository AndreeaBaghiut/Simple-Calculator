# Simple-Calculator
This code is a Java implementation of a simple calculator application. It uses Swing components to create the user interface and handle user interactions, and implements basic arithmetic operations such as addition, subtraction, multiplication, and division.

The code defines a class called SimpleCalculator that extends the ActionListener interface. It declares several variables including a JFrame, a JTextField, and an array of JButtons to represent the numbers and arithmetic operations. The constructor of the SimpleCalculator class initializes the JFrame and sets up the user interface components, including the textfield, the function and number buttons, and the panel that contains the buttons.

The actionPerformed() method is called when the user interacts with any of the buttons. It uses a series of if statements to determine which button was pressed, and performs the appropriate action based on the button. For example, if a number button is pressed, it appends the value of the number to the text in the textfield. If the addition button is pressed, it stores the current number in the textfield as the first operand, and sets the operator to "+".

The code also defines several variables to store the first and second operands and the result of the calculation. When the user presses the equals button, the code performs the appropriate arithmetic operation based on the operator, and updates the result in the textfield. The user can clear the textfield by pressing the clear button or delete the last character by pressing the delete button.

Overall, the code is a basic implementation of a calculator application.
![image](https://user-images.githubusercontent.com/128622173/232337693-be306680-8879-4dd6-a545-1bf8898ee417.png)

