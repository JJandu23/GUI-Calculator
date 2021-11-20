package com.company.view;

import com.company.controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Calculator extends JFrame implements ActionListener, MouseListener {

    private static String[] ARITHMETIC_OPERATORS = new String[]{"+", "-", "/", "*"};
    private static String[] SCIENTIFIC_OPERATORS = new String[]{"+", "-", "/", "*", "sqrt", "pow", "factorial", "mod", "gcd", "lcm"};

    // Variables
    JMenuBar menuBar;
    JMenu decimalMenu;
    JMenu homeMenu;
    JMenu aboutMenu;
    JMenu binaryMenu;
    JMenu hexadecimalMenu;
    JMenu bigNumberMenu;
    JMenu helpMenu;
    JPanel mainPanel;
    JTextField txtA;
    JTextField txtB;
    JLabel txtAns;
    JComboBox<String> comBo;
    JButton btnCalculate;
    JButton btnClear;

    //Data
    private JMenu selectedMenu;

    /**
     * Default constructor
     */
    public Calculator() {
        prepareMenubar(); // calls the function which prepares the menubar
        mainPanel = getHomePanel();
        add(mainPanel); // adds panel to main JFrame
        // sets title, size and close property of main window
        setTitle("Java Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);

        // Initialize variables
        txtA = new JTextField();
        txtB = new JTextField();
        txtAns = new JLabel();
        btnCalculate = new JButton("Calculate");
        btnCalculate.addActionListener(this);

        btnClear = new JButton("Clear");
        btnClear.addActionListener(this);
    }

    /**
     * Returns a home panel with starter message
     * @return JPanel
     */
    private JPanel getHomePanel() {
        JPanel jPanel = new JPanel(new GridLayout(3, 3)); // new panel is created
        jPanel.add(new JLabel("Choose an option from the top menu to start")); // adds start label
        return jPanel;
    }

    /**
     * Starts the calculator GUI
     */
    public void start() {
        setVisible(true);
    }

    /**
     * Get header title for give menu option
     * @param menu JMenu
     * @return String
     */
    public String getTitleFromMenu(JMenu menu) {
        if(menu == decimalMenu) {
            return "Decimal Calculator";
        }
        else if(menu == binaryMenu) {
            return "Binary Calculator";
        }
        else if(menu == hexadecimalMenu) {
            return "Hexadecimal Calculator";
        }
        else if(menu == bigNumberMenu) {
            return "BigNumber Calculator";
        }
        return null;
    }

    /**
     * This method is implemented from ActionListener interface
     * It will perform the actions based on the source
     *
     * @param e Input event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();
        if(object == btnClear) {
            clear();
        }
        else if(object == btnCalculate && selectedMenu != null) {
            try {
                if(selectedMenu == decimalMenu) {
                    calculateArithmetic(new DecimalController());
                }
                else if(selectedMenu == binaryMenu) {
                    calculateArithmetic(new BinaryController());
                }
                else if(selectedMenu == hexadecimalMenu) {
                    calculateArithmetic(new HexadecimalController());
                }
                else if(selectedMenu == bigNumberMenu) {
                    calculateScientific(new BigNumberController());
                }
            } catch (Exception ex) {
                txtAns.setForeground(Color.RED);
                txtAns.setText("Error: " + ex.getLocalizedMessage());
            }
        }
    }

    /**
     * Clears all input fields
     */
    private void clear() {
        txtA.setText(null);
        txtB.setText(null);
        txtAns.setText(null);
        if(comBo != null  && comBo.getItemCount() > 0) {
            comBo.setSelectedIndex(0);
        }
    }

    /**
     * This method prepares the menubar and adds it to the main frame
     */
    private void prepareMenubar() {
        menuBar = new JMenuBar();

        homeMenu = new JMenu("Home");
        homeMenu.addMouseListener(this);
        menuBar.add(homeMenu);

        decimalMenu = new JMenu("Decimal");
        decimalMenu.addMouseListener(this);
        menuBar.add(decimalMenu);

        binaryMenu = new JMenu("Binary");
        binaryMenu.addMouseListener(this);
        menuBar.add(binaryMenu);

        hexadecimalMenu = new JMenu("Hex");
        hexadecimalMenu.addMouseListener(this);
        menuBar.add(hexadecimalMenu);

        bigNumberMenu = new JMenu("BIG Num");
        bigNumberMenu.addMouseListener(this);
        menuBar.add(bigNumberMenu);

        helpMenu = new JMenu("Help");
        helpMenu.addMouseListener(this);
        menuBar.add(helpMenu);

        aboutMenu = new JMenu("About");
        aboutMenu.addMouseListener(this);
        menuBar.add(aboutMenu);

        setJMenuBar(menuBar);
    }

    /**
     * This method adds the minimal calculator to the main frame
     */
    private void addCalculator(String[] operators) {
        removePanel(); // removes the old panel and create new one
        // Add labels, button and text fields to the panel

        mainPanel.add(new JLabel("Operation A: "));
        mainPanel.add(txtA);
        mainPanel.add(new JLabel());
        mainPanel.add(new JLabel());
        mainPanel.add(new JLabel("Operator: "));

        comBo = new JComboBox<>();
        for(String item: operators) {
            comBo.addItem(item);
        }
        mainPanel.add(comBo);

        mainPanel.add(new JLabel());
        mainPanel.add(new JLabel());
        mainPanel.add(new JLabel("Operation B: "));
        mainPanel.add(txtB);
        mainPanel.add(new JLabel());
        mainPanel.add(new JLabel());
        mainPanel.add(new JLabel("Result: "));
        mainPanel.add(txtAns);
        mainPanel.add(new JLabel());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnCalculate);
        buttonPanel.add(btnClear);

        mainPanel.add(buttonPanel);
        addPanel(); // adds the panel to the main frame
    }

    /**
     * This method removes the panel from the main frame
     */
    private void showAbout() {
        String text = "My name is Jashanpreet.|This is my Multi-Calculator Program. |Hope you like it!";
        createDialog(text);
    }

    /**
     * Shows the help string in new dialog/frame
     */
    private void showHelp() {
        String text = " Help|You can perform +, -, *, / operations on integers|" +
                "|1) Enter an integer in text field operation A" +
                "|2) Select an operator from box below it" +
                "|3) Enter second integer in text field operation B" +
                "|4) Press the calculate button to perform the selected operation." +
                "|5) The result will be displayed in the text field below it." +
                "|6) You can clear all the fields by pressing the clear button." +
                "|7) You can also perform decimal operations by selecting decimal menu." +
                "|8) You can also perform binary operations by selecting binary menu." +
                "|9) You can also perform hexadecimal operations by selecting hexadecimal menu." +
                "|10) You can also perform big number operations by selecting big number menu." +
                "|operator A: 5, operator: + operator B: 4 = 9" +
                "|operator A: 5, operator: / operator B: 0 = Error" +
                "|operator A: 01010, operator: + operator B: 01010 = 010100" +
                "|operator A: B, operator: - operator B: C = -1" +
                "|operator 12: B, operator: pow(^) operator B: 2 = 144" +
                "|operator (binary to decimal) A: 12, operator: + operator B: 12 = 1000" +
                "|operator (hex to decimal) A: C, operator: + operator B: 22 = 2E" + "|";
        createDialog(text);
    }

    /**
     * Create a dialog with give input text
     * @param text String
     */
    private void createDialog(String text) {
        String[] arr = text.split("\\|");

        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(300, 300);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(arr.length + 2, 1, 5, 5));

        for (String s : arr) {
            panel.add(new JLabel(s));
        }

        jFrame.add(panel);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    /**
     * Set successful result
     * @param output String
     */
    private void setAnswer(String output) {
        txtAns.setText(output);
        txtAns.setForeground(Color.BLACK);
    }

    /**
     * Calculates the result based on the selected operation between operator A and operator B
     * @param controllerInterface Any class that conforms to ArithmeticControllerInterface interface
     * @param <T> Any Java class
     * @throws Exception
     */
    private <T> void calculateArithmetic(ArithmeticControllerInterface<T> controllerInterface) throws Exception {
        T t1 = controllerInterface.convert(txtA.getText());
        T t2 = controllerInterface.convert(txtB.getText());
        String op = String.valueOf(comBo.getSelectedItem());
        switch (op) {
            case "+" -> setAnswer(controllerInterface.add(t1, t2).toString());
            case "-" -> setAnswer(controllerInterface.subtract(t1, t2).toString());
            case "*" -> setAnswer(controllerInterface.multiply(t1, t2).toString());
            case "/" -> setAnswer(controllerInterface.divide(t1, t2).toString());
        }
    }

    /**
     * Calculates the result based on the selected operation between operator A and operator B
     * @param controllerInterface Any class that conforms to ScientificControllerInterface interface
     * @param <T> Any Java class
     * @throws Exception
     */
    private <T> void calculateScientific(ScientificControllerInterface<T> controllerInterface) throws Exception {
        T t1 = controllerInterface.convert(txtA.getText());
        String op = String.valueOf(comBo.getSelectedItem());
        switch (op) {
            case "pow" -> {
                int integer = Integer.parseInt(txtB.getText());
                setAnswer(controllerInterface.power(t1, integer).toString());
            }
            case "sqrt" -> setAnswer(controllerInterface.sqrt(t1).toString());
            case "factorial" -> setAnswer(controllerInterface.factorial(t1).toString());
            case "mod" -> {
                T t2 = controllerInterface.convert(txtB.getText());
                setAnswer(controllerInterface.mod(t1, t2).toString());
            }
            case "gcd" -> {
                T t2 = controllerInterface.convert(txtB.getText());
                setAnswer(controllerInterface.gcd(t1, t2).toString());
            }
            case "lcm" -> {
                T t2 = controllerInterface.convert(txtB.getText());
                setAnswer(controllerInterface.lcm(t1, t2).toString());
            }
            default -> calculateArithmetic(controllerInterface);
        }
    }

    /**
     * Removes the old panel and creates new panel
     */
    private void removePanel() {
        remove(mainPanel);
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(8, 4));
    }

    /**
     * Adds the panel to the main frame
     */
    private void addPanel() {
        add(mainPanel);
        repaint();
        revalidate();
    }

    /**
     * Callback when mouse is clicked
     * @param e Mouseevent
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Object object = e.getSource();
        if(object instanceof JMenu) {
            selectedMenu = (JMenu) object;
            if(selectedMenu == homeMenu) {
                setTitle("Java Calculator");
                removePanel(); // removes old panel and creates new one
                mainPanel = getHomePanel();
                addPanel(); // adds panel to the main frame
            }
            else if(selectedMenu == aboutMenu) {
                setTitle("Java Calculator");
                showAbout();
            }
            else if(selectedMenu == helpMenu) {
                setTitle("Java Calculator");
                showHelp();
            }
            else if(selectedMenu == bigNumberMenu) {
                clear();
                setTitle(getTitleFromMenu(selectedMenu));
                addCalculator(SCIENTIFIC_OPERATORS);
            }
            else {
                clear();
                setTitle(getTitleFromMenu(selectedMenu));
                addCalculator(ARITHMETIC_OPERATORS);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
