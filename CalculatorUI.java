import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Header extends JPanel {
    JLabel result;
    Color backgroundColor = new Color (239, 234, 228);
    Font font = new Font("Helvetica Neue", Font.ITALIC, 45);

    /* used to show result */
    Header() {
        this.setPreferredSize(new Dimension(350, 100)); // Size of the header
        this.setBackground(backgroundColor);
        this.setLayout(new GridLayout(1, 1,0,0));
        
        result = new JLabel();
        result.setHorizontalAlignment(SwingConstants.RIGHT);

        result.setText("ANSWER" + " ");
        result.setFont(font);
        this.add(result); // Add the text to the header
    }
    public void setResult(String numResult) {
        result.setText(numResult);
    }

}
class Body extends JPanel {
    Color backgroundColor = new Color (156, 149, 132);
    Font buttonFont = new Font("Helvetica Neue", Font.PLAIN, 25);

    JButton ONE;
    JButton TWO;
    JButton THREE;
    JButton FOUR;
    JButton FIVE;
    JButton SIX;
    JButton SEVEN;
    JButton EIGHT;
    JButton NINE;
    JButton ZERO;

    JButton PLUS;
    JButton MINUS;
    JButton MULTIPLY;
    JButton DIVIDE;
    JButton PERCENT;

    JButton TIP;
    JButton EQUALS;
    JButton RESET;
    JButton DELETE; 
    JButton DECIMAL;


    Body() {
        this.setPreferredSize(new Dimension(150, 150));
        this.setBackground(backgroundColor);
        this.setLayout(new GridLayout(5, 5));

        /* sets button preferences */
        ONE = new JButton("1"); ONE.setFont(buttonFont);
        TWO = new JButton("2"); TWO.setFont(buttonFont);
        THREE = new JButton("3"); THREE.setFont(buttonFont);
        FOUR = new JButton("4"); FOUR.setFont(buttonFont);
        FIVE = new JButton("5"); FIVE.setFont(buttonFont);
        SIX = new JButton("6"); SIX.setFont(buttonFont);
        SEVEN = new JButton("7"); SEVEN.setFont(buttonFont);
        EIGHT = new JButton("8"); EIGHT.setFont(buttonFont);
        NINE = new JButton("9"); NINE.setFont(buttonFont);
        ZERO = new JButton("0"); ZERO.setFont(buttonFont);

        PLUS = new JButton("+"); PLUS.setFont(buttonFont);
        MINUS = new JButton("-"); MINUS.setFont(buttonFont);
        MULTIPLY = new JButton("x"); MULTIPLY.setFont(buttonFont);
        DIVIDE = new JButton("÷"); DIVIDE.setFont(buttonFont);

        PERCENT = new JButton("%"); PERCENT.setFont(buttonFont);
        TIP = new JButton("TIP"); TIP.setFont(buttonFont);

        EQUALS = new JButton("="); EQUALS.setFont(buttonFont);
        RESET = new JButton("R"); RESET.setFont(buttonFont);
        DELETE = new JButton("\u21BA"); DELETE.setFont(buttonFont);
        DECIMAL = new JButton("."); DECIMAL.setFont(buttonFont);


        /* adds to panel */
        //first row: R TIP % ÷
        this.add(RESET);
        this.add(TIP);
        this.add(PERCENT);
        this.add(DIVIDE);

        //second row: 1 2 3 x
        this.add(ONE);
        this.add(TWO);
        this.add(THREE);
        this.add(MULTIPLY);

        //third row: 4 5 6 +
        this.add(FOUR);
        this.add(FIVE);
        this.add(SIX);
        this.add(PLUS);

        //fourth row: 7 8 9 -
        this.add(SEVEN);
        this.add(EIGHT);
        this.add(NINE);
        this.add(MINUS);

        // fifth row . 0 D =
        this.add(DECIMAL);
        this.add(ZERO);
        this.add(DELETE);
        this.add(EQUALS);
        
    }

    //getter methods
    public JButton getONE() {
        return ONE;
    }
    public JButton getTWO() {
        return TWO;
    }
    public JButton getTHREE() {
        return THREE;
    }
    public JButton getFOUR() {
        return FOUR;
    }
    public JButton getFIVE() {
        return FIVE;
    }
    public JButton getSIX() {
        return SIX;
    }
    public JButton getSEVEN() {
        return SEVEN;
    }
    public JButton getEIGHT() {
        return EIGHT;
    }
    public JButton getNINE() {
        return NINE;
    }
    public JButton getZERO() {
        return ZERO;
    }
    public JButton getPLUS() {
        return PLUS;
    }
    public JButton getMINUS() {
        return MINUS;
    }
    public JButton getMULTIPLY() {
        return MULTIPLY;
    }
    public JButton getDIVIDE() {
        return DIVIDE;
    }
    public JButton getEQUALS() {
        return EQUALS;
    }
    public JButton getRESET() {
        return RESET;
    }
    public JButton getDELETE() {
        return DELETE;
    }
    public JButton getPERCENT() {
        return PERCENT;
    } 
    public JButton getTIP() {
        return TIP;
    }
    public JButton getDECIMAL() {
        return DECIMAL;
    }
}


public class CalculatorUI extends JFrame {
    private Header header;
    public Body body;
    private JButton ONE;
    private JButton TWO;
    private JButton THREE;
    private JButton FOUR;
    private JButton FIVE;
    private JButton SIX;
    private JButton SEVEN;
    private JButton EIGHT;
    private JButton NINE;
    private JButton ZERO;

    private JButton PLUS;
    private JButton MINUS;
    private JButton MULTIPLY;
    private JButton DIVIDE;

    private JButton EQUALS; 
    private JButton RESET;
    private JButton DELETE;
    private JButton TIP;
    private JButton PERCENT;
    private JButton DECIMAL;

    Boolean doneWithFirst = false;
    Boolean isFloat = false;

    StringBuilder currentNum = new StringBuilder();
    StringBuilder firstNum = new StringBuilder();
    StringBuilder secondNum = new StringBuilder();

    int intFirstNum = 0;
    int intSecondNum = 0;

    int result;

    CalculatorUI() {
        this.setSize(350,600);                              // sets size of calc frame
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close on exit
        this.setVisible(true); // Make visible

        header = new Header();
        body = new Body();

        this.add(header, BorderLayout.NORTH);
        this.add(body, BorderLayout.CENTER);

        ONE = body.getONE();
        TWO = body.getTWO();
        THREE = body.getTHREE();
        FOUR = body.getFOUR();
        FIVE = body.getFIVE();
        SIX = body.getSIX();
        SEVEN = body.getSEVEN();
        EIGHT = body.getEIGHT();
        NINE = body.getNINE();
        ZERO = body.getZERO();

        PLUS = body.getPLUS();
        MINUS = body.getMINUS();
        MULTIPLY = body.getMULTIPLY();
        DIVIDE = body.getDIVIDE();

        PERCENT = body.getPERCENT();
        TIP = body.getTIP();
        DECIMAL = body.getDECIMAL();

        EQUALS = body.getEQUALS();
        RESET = body.getRESET();
        DELETE =  body.getDELETE();

        addListeners();
    }
     public void addListeners() {
        ZERO.addMouseListener(
            new MouseAdapter() {
            @Override
                public void mousePressed(MouseEvent e) {
                    currentNum.append("0");
                    System.out.println("0");

                    String showResult = currentNum.toString();
                    header.setResult(showResult + "  ");
                }
            });
        ONE.addMouseListener(
                new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    currentNum.append("1");
                    System.out.println("1");

                    String showResult = currentNum.toString();
                    header.setResult(showResult + "  ");
                }
            });
        TWO.addMouseListener(
            new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                currentNum.append("2");
                System.out.println("2");

                String showResult = currentNum.toString();
                header.setResult(showResult + "  ");
            }
        });
        THREE.addMouseListener(
                new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    currentNum.append("3");
                    System.out.println("3");

                    String showResult = currentNum.toString();
                    header.setResult(showResult + "  ");
                }
        });
        FOUR.addMouseListener(
                new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    currentNum.append("4");
                    System.out.println("4");

                    String showResult = currentNum.toString();
                    header.setResult(showResult + "  ");
                }
        });
        FIVE.addMouseListener(
                new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    currentNum.append("5");
                    System.out.println("5");

                    String showResult = currentNum.toString();
                    header.setResult(showResult + "  ");
                }
        });
        SIX.addMouseListener(
                new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    currentNum.append("6");
                    System.out.println("6");

                    String showResult = currentNum.toString();
                    header.setResult(showResult + "  ");
                }
        });
        SEVEN.addMouseListener(
                new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    currentNum.append("7");
                    System.out.println("7");

                    String showResult = currentNum.toString();
                    header.setResult(showResult + "  ");
                }
        });
        EIGHT.addMouseListener(
                new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    currentNum.append("8");
                    System.out.println("8");

                    String showResult = currentNum.toString();
                    header.setResult(showResult + "  ");
                }
        });
        NINE.addMouseListener(
                new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    currentNum.append("9");
                    System.out.println("9");

                    String showResult = currentNum.toString();
                    header.setResult(showResult + "  ");
                }
        });
        PLUS.addMouseListener(
                new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (!doneWithFirst) {
                        doneWithFirst = true;
                        currentNum.append("+");
                        firstNum = currentNum;

                        currentNum = new StringBuilder();
                    }
                    System.out.println("+");
                }
        });
        MINUS.addMouseListener(
                new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (!doneWithFirst) {
                        doneWithFirst = true;
                        currentNum.append("-");
                        firstNum = currentNum;
                        currentNum = new StringBuilder();
                    }
                    System.out.println("-");
                }
        });
        MULTIPLY.addMouseListener(
                new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (!doneWithFirst) {
                        doneWithFirst = true;
                        currentNum.append("x");
                        firstNum = currentNum;
                        currentNum = new StringBuilder();
                    }
                    System.out.println("x");
                }
        });
        DIVIDE.addMouseListener(
                new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (!doneWithFirst) {
                        doneWithFirst = true;
                        currentNum.append("/");
                        firstNum = currentNum;
                        currentNum = new StringBuilder();
                    }
                    System.out.println("/");
                }
        });
        RESET.addMouseListener(
                new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    reset();
                    header.setResult("  ");
                }
        });
        DELETE.addMouseListener(
                new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (!doneWithFirst) {
                        currentNum.deleteCharAt(currentNum.length() - 1);
                        String cNum = currentNum.toString();
                        header.setResult(cNum + "  ");
                    }
                }
        });
        PERCENT.addMouseListener(
                new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (!doneWithFirst) {
                        String cNum = currentNum.toString();
                        int current = Integer.parseInt(cNum);
                        current = current / 100;
                        String showResult = Integer.toString(current);
                        header.setResult(showResult + "  ");
                    }
                    reset();
                }
        });
        TIP.addMouseListener(
                new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (!doneWithFirst) {
                        String cNum = currentNum.toString();
                        int current = Integer.parseInt(cNum);
                        float flCurrent = current;
                        flCurrent = (float) (flCurrent * .15);
                        String showResult = Float.toString(flCurrent);
                        header.setResult(showResult + "  ");
                    }
                    reset();
                }
        });
        DECIMAL.addMouseListener(
                new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (!doneWithFirst) {
                        currentNum.append(".");
                        header.setResult(currentNum + "  ");

                    }
                }
        });
        EQUALS.addMouseListener(
                new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    secondNum = currentNum;

                    char operator = ' ';
                    if (firstNum.length() > 0) {
                        operator = firstNum.charAt(firstNum.length() - 1);
                    }

                    if (operator == '+') {
                        firstNum.deleteCharAt(firstNum.length() - 1);
                        String first = firstNum.toString();
                        String second = secondNum.toString();
                        intFirstNum = Integer.parseInt(first);
                        intSecondNum = Integer.parseInt(second);
                        result = intFirstNum + intSecondNum;

                    } else if (operator == '-') {
                        firstNum.deleteCharAt(firstNum.length() - 1);
                        String first = firstNum.toString();
                        String second = secondNum.toString();
                        intFirstNum = Integer.parseInt(first);
                        intSecondNum = Integer.parseInt(second);
                        result = intFirstNum - intSecondNum;
                    }
                    else if (operator == 'x') {
                        firstNum.deleteCharAt(firstNum.length() - 1);
                        String first = firstNum.toString();
                        String second = secondNum.toString();
                        intFirstNum = Integer.parseInt(first);
                        intSecondNum = Integer.parseInt(second);
                        result = intFirstNum * intSecondNum;
                    }
                    else if (operator == '/') {
                        firstNum.deleteCharAt(firstNum.length() - 1);
                        String first = firstNum.toString();
                        String second = secondNum.toString();
                        intFirstNum = Integer.parseInt(first);
                        intSecondNum = Integer.parseInt(second);
                        result = intFirstNum / intSecondNum;
                    }

                    System.out.println(result);
                    String showResult = Integer.toString(result);
                    header.setResult(showResult + "  ");

                    currentNum = new StringBuilder();
                    currentNum.append(result);
                    doneWithFirst = false; 

                }
        });
     }
    /* called when user presses equals */
    public void reset() {
        doneWithFirst = false;
        currentNum = new StringBuilder();
        firstNum = new StringBuilder();
    }
    public int setStringToInt(StringBuilder num) {
        String numString = num.toString();
        int numInt = Integer.parseInt(numString);
        return numInt;
    }

    public static void main(String[] args) throws Exception {
        new CalculatorUI();
    }

}
