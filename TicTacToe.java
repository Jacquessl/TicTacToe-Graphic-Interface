import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel text_field = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player_turn;
    int g = 0;
    int z = 0;
    int kz = (int) (Math.random() * 2);
    boolean bot;

    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(245, 226, 168));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text_field.setBackground(new Color(245, 245, 245));
        text_field.setForeground(Color.black);
        text_field.setFont(new Font("Biome", Font.PLAIN, 75));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("Tic-Tac-Toe");
        text_field.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(220, 226, 160));

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Biome", Font.ITALIC, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(text_field);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
        if (g % 2 != kz && g == 0) {
            try {
                click(300, 300);
            } catch (AWTException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void checksY() {
        while (bot){
            gamePassB();
            int xi1 = 0, xi2 = 0, xi3 = 0, xi4 = 0, xi5 = 0, xi6 = 0, xi7 = 0, xi8 = 0, xi9 = 0;
        int yi1 = 0, yi2 = 0, yi3 = 0, yi4 = 0, yi5 = 0, yi6 = 0, yi7 = 0, yi8 = 0, yi9 = 0;
        int y = 0;
        int yt = 0;
        for (int i = 0; i < 9; i++) {
            switch (i) {
                case 0:
                    if (Objects.equals(buttons[i].getText(), "X")) {
                        xi1 = 1;
                        break;
                    }
                case 1:
                    if (Objects.equals(buttons[i].getText(), "X")) {
                        xi2 = 1;
                        break;
                    }
                case 2:
                    if (Objects.equals(buttons[i].getText(), "X")) {
                        xi3 = 1;
                        break;
                    }
                case 3:
                    if (Objects.equals(buttons[i].getText(), "X")) {
                        xi4 = 1;
                        break;
                    }
                case 4:
                    if (Objects.equals(buttons[i].getText(), "X")) {
                        xi5 = 1;
                        break;
                    }
                case 5:
                    if (Objects.equals(buttons[i].getText(), "X")) {
                        xi6 = 1;
                        break;
                    }
                case 6:
                    if (Objects.equals(buttons[i].getText(), "X")) {
                        xi7 = 1;
                        break;
                    }
                case 7:
                    if (Objects.equals(buttons[i].getText(), "X")) {
                        xi8 = 1;
                        break;
                    }
                case 8:
                    if (Objects.equals(buttons[i].getText(), "X")) {
                        xi9 = 1;
                        break;
                    }
            }
            switch (i) {
                case 0:
                    if (Objects.equals(buttons[i].getText(), "O")) {
                        yi1 = 1;
                        break;
                    }
                case 1:
                    if (Objects.equals(buttons[i].getText(), "O")) {
                        yi2 = 1;
                        break;
                    }
                case 2:
                    if (Objects.equals(buttons[i].getText(), "O")) {
                        yi3 = 1;
                        break;
                    }
                case 3:
                    if (Objects.equals(buttons[i].getText(), "O")) {
                        yi4 = 1;
                        break;
                    }
                case 4:
                    if (Objects.equals(buttons[i].getText(), "O")) {
                        yi5 = 1;
                        break;
                    }
                case 5:
                    if (Objects.equals(buttons[i].getText(), "O")) {
                        yi6 = 1;
                        break;
                    }
                case 6:
                    if (Objects.equals(buttons[i].getText(), "O")) {
                        yi7 = 1;
                        break;
                    }
                case 7:
                    if (Objects.equals(buttons[i].getText(), "O")) {
                        yi8 = 1;
                        break;
                    }
                case 8:
                    if (Objects.equals(buttons[i].getText(), "O")) {
                        yi9 = 1;
                        break;
                    }
            }
        }
        if (g == 0) { //if computer starting hes picking corner
            yt = (int) (Math.random() * 4);
            if (yt == 0) {
                y = 1;
            } else if (yt == 1) {
                y = 3;
            } else if (yt == 2) {
                y = 7;
            } else if (yt == 3) {
                y = 9;
            }
        } else if (g == 1) { // what filed to pick if human is starting
            if (xi5 == 1) {
                yt = (int) (Math.random() * 4);
                if (yt == 0) {
                    y = 3;
                } else if (yt == 1) {
                    y = 7;
                } else if (yt == 2) {
                    y = 9;
                } else {
                    y = 1;
                }
            } else {
                y = 5;
            }
        } else if (g == 2) { //2nd filed to pick if computer starting
            if (xi2 == 1 || xi4 == 1 || xi6 == 1 || xi8 == 1) {
                y = 5;
            } else if (xi1 == 1 || xi3 == 1 || xi7 == 1 || xi9 == 1) {
                if (yi1 == 1) {
                    if (xi3 == 1) {
                        y = 7;
                    } else if (xi7 == 1) {
                        y = 3;
                    } else if (xi5 == 1) {
                        y = 9;
                    } else {
                        yt = (int) (Math.random() * 2);
                        if (yt == 0) {
                            y = 7;
                        } else {
                            y = 3;
                        }
                    }
                } else if (yi3 == 1) {
                    if (xi1 == 1) {
                        y = 9;
                    } else if (xi9 == 1) {
                        y = 1;
                    } else if (xi5 == 1) {
                        y = 7;
                    } else {
                        yt = (int) (Math.random() * 2);
                        if (yt == 0) {
                            y = 1;
                        } else {
                            y = 1;
                        }
                    }
                } else if (yi7 == 1) {
                    if (xi1 == 1) {
                        y = 9;
                    } else if (xi9 == 1) {
                        y = 1;
                    } else if (xi5 == 1) {
                        y = 3;
                    } else {
                        yt = (int) (Math.random() * 2);
                        if (yt == 0) {
                            y = 1;
                        } else {
                            y = 9;
                        }
                    }
                } else if (yi9 == 1) {
                    if (xi7 == 1) {
                        y = 3;
                    } else if (xi3 == 1) {
                        y = 7;
                    } else if (xi5 == 1) {
                        y = 1;
                    } else {
                        yt = (int) (Math.random() * 2);
                        if (yt == 0) {
                            y = 3;
                        } else {
                            y = 7;
                        }
                    }
                }
            } else {
                if (yi1 == 1) {
                    y = 9;
                } else if (yi3 == 1) {
                    y = 7;
                } else if (yi7 == 1) {
                    y = 3;
                } else if (yi9 == 1) {
                    y = 1;
                }
            }

        } else if (yi5 == 1 && g == 4) { //3 move by computer if he picked corner and middle(when its starting)
            if (yi1 == 1) {
                if (xi9 == 0) { //checks for possible win
                    y = 9;
                } else if (xi2 == 1) {
                    y = 7;
                } else if (xi4 == 1) {
                    y = 3;
                } else if (xi9 == 1) {
                    yt = (int) (Math.random() * 2);
                    if (yt == 0) {
                        y = 3;
                    } else {
                        y = 7;
                    }
                }
            } else if (yi3 == 1) {
                if (xi7 == 0) {
                    y = 7;
                } else if (xi2 == 1) {
                    y = 9;
                } else if (xi6 == 1) {
                    y = 1;
                } else if (xi7 == 1) {
                    yt = (int) (Math.random() * 2);
                    if (yt == 0) {
                        y = 1;
                    } else {
                        y = 9;
                    }
                }
            } else if (yi7 == 1) {
                if (xi3 == 0) {
                    y = 3;
                } else if (xi4 == 1) {
                    y = 9;
                } else if (xi8 == 1) {
                    y = 1;
                } else if (xi3 == 1) {
                    if(xi2==1){
                        y = 1;
                    }
                    else if(xi1==1){
                        y = 2;
                    }
                    else {
                        yt = (int) (Math.random() * 2);
                        if (yt == 0) {
                            y = 1;
                        } else {
                            y = 9;
                        }
                    }
                }
            } else if (yi9 == 1) {
                if (xi1 == 0) {
                    y = 1;
                } else if (xi6 == 1) {
                    y = 7;
                } else if (xi8 == 1) {
                    y = 3;
                } else if (xi1 == 1) {
                    yt = (int) (Math.random() * 2);
                    if (yt == 0) {
                        y = 3;
                    } else {
                        y = 7;
                    }
                }
            }
        } else if (g == 4) {
            if (xi5 == 1) {
                if (xi2 == 1) {
                    y = 8;
                } else if (xi4 == 1) {
                    y = 6;
                } else if (xi6 == 1) {
                    y = 4;
                } else if (xi8 == 1) {
                    y = 2;
                } else if (xi1 == 1) {
                    y = 9;
                } else if (xi3 == 1) {
                    y = 7;
                } else if (xi7 == 1) {
                    y = 3;
                } else if (xi9 == 1) {
                    y = 1;
                }
            } else if (yi1 == 1) {
                if (yi3 == 1) {
                    if (xi2 == 0) {
                        y = 2;
                    } else if (xi9 == 1) {
                        y = 7;
                    } else {
                        y = 9;
                    }
                } else if (yi7 == 1) {
                    if (xi4 == 0) {
                        y = 4;
                    } else if (xi9 == 1) {
                        y = 3;
                    } else {
                        y = 9;
                    }
                } else if (yi9 == 1) {
                    if (xi7 == 1) {
                        y = 3;
                    } else {
                        y = 7;
                    }
                }
            } else if (yi9 == 1) {
                if (yi3 == 1) {
                    if (xi6 == 0) {
                        y = 6;
                    } else if (xi1 == 1) {
                        y = 7;
                    } else {
                        y = 1;
                    }
                } else if (yi7 == 1) {
                    if (xi8 == 0) {
                        y = 8;
                    } else if (xi3 == 1) {
                        y = 1;
                    } else {
                        y = 3;
                    }
                } else if (yi1 == 1) {
                    if (xi7 == 1) {
                        y = 3;
                    } else {
                        y = 7;
                    }
                }
            } else if (yi3 == 1) {
                if (yi1 == 1) {
                    if (xi2 == 0) {
                        y = 2;
                    } else if (xi7 == 1) {
                        y = 9;
                    } else {
                        y = 7;
                    }
                } else if (yi9 == 1) {
                    if (xi6 == 0) {
                        y = 6;
                    } else if (xi7 == 1) {
                        y = 1;
                    } else {
                        y = 7;
                    }
                } else if (yi7 == 1) {
                    if (xi9 == 1) {
                        y = 1;
                    } else {
                        y = 9;
                    }
                }
            } else if (yi7 == 1) {
                if (yi1 == 1) {
                    if (xi4 == 0) {
                        y = 4;
                    } else if (xi9 == 1) {
                        y = 3;
                    } else {
                        y = 9;
                    }
                } else if (yi9 == 1) {
                    if (xi8 == 0) {
                        y = 8;
                    } else if (xi3 == 1) {
                        y = 1;
                    } else {
                        y = 3;
                    }
                } else if (yi3 == 1) {
                    if (xi1 == 1) {
                        y = 9;
                    } else {
                        y = 1;
                    }
                }
            }
        } else if (g == 6 || g==8) {//4th computer move
            if (yi5 == 1) {
                if (yi1 == 1) {
                    if (yi3 == 1) {
                        if (xi2 == 0) {
                            y = 2;
                        } else if (xi7 == 0) {
                            y = 7;
                        } else if (xi9 == 0) {
                            y = 9;
                        }
                    } else if (yi7 == 1) {
                        if (xi4 == 0) {
                            y = 4;
                        } else if (xi3 == 0) {
                            y = 3;
                        } else if (xi9 == 0) {
                            y = 9;
                        }
                    }
                } else if (yi3 == 1) {
                    if (yi1 == 1) {
                        if (xi2 == 0) {
                            y = 2;
                        } else if (xi9 == 0) {
                            y = 9;
                        } else if (xi7 == 0) {
                            y = 7;
                        }
                    } else if (yi9 == 1) {
                        if (xi6 == 0) {
                            y = 6;
                        } else if (xi1 == 0) {
                            y = 1;
                        } else if (xi7 == 0) {
                            y = 7;
                        }
                    }
                } else if (yi7 == 1) {
                    if (yi9 == 1) {
                        if (xi8 == 0) {
                            y = 8;
                        } else if (xi3 == 0) {
                            y = 3;
                        } else if (xi1 == 0) {
                            y = 1;
                        }
                    } else if (yi1 == 1) {
                        if (xi4 == 0) {
                            y = 4;
                        } else if (xi3 == 0) {
                            y = 3;
                        } else if (xi9 == 0) {
                            y = 9;
                        }
                    }
                } else if (yi9 == 1) {
                    if (yi7 == 1) {
                        if (xi8 == 0) {
                            y = 8;
                        } else if (xi7 == 0) {
                            y = 7;
                        } else if (xi1 == 0) {
                            y = 1;
                        }
                    } else if (yi3 == 1) {
                        if (xi6 == 0) {
                            y = 6;
                        } else if (xi1 == 0) {
                            y = 1;
                        } else if (xi7 == 0) {
                            y = 7;
                        }
                    }
                }
            } else if (xi5 != 1) {
                if (yi1 == 1) {
                    if (xi5 == 0) {
                        y = 5;
                    } else if (yi3 == 1) {
                        if (xi2 == 0) {
                            y = 2;
                        } else if (yi9 == 1) {
                            if (xi6 == 0) {
                                y = 6;
                            }
                        }
                    } else if (yi7 == 1) {
                        if (xi4 == 0) {
                            y = 4;
                        } else if (yi9 == 1) {
                            if (xi8 == 0) {
                                y = 8;
                            }
                        }
                    }
                } else if (yi3 == 1) {
                    if (xi5 == 0) {
                        y = 5;
                    } else if (yi9 == 1) {
                        if (xi6 == 0) {
                            y = 6;
                        }
                    }
                } else if (yi7 == 1) {
                    if (xi5 == 0) {
                        y = 5;
                    } else if (yi1 == 1) {
                        if (xi4 == 0) {
                            y = 4;
                        }
                    } else if (yi9 == 1) {
                        if (xi8 == 0) {
                            y = 8;
                        }
                    }
                } else if (yi9 == 1) {
                    if (xi5 == 0) {
                        y = 5;
                    } else if (yi3 == 1) {
                        if (xi6 == 0) {
                            y = 6;
                        }
                    } else if (yi7 == 1) {
                        if (xi8 == 0) {
                            y = 8;
                        }
                    }
                } else {
                    y = (int) ((Math.random() * 9) + 1);
                }
            } else {
                if (xi9 == 1 && yi1 == 0) {
                    y = 1;
                } else if (xi7 == 1 && yi3 == 0) {
                    y = 3;
                } else if (xi3 == 1 && yi7 == 0) {
                    y = 7;
                } else if (xi1 == 1 && yi9 == 0) {
                    y = 9;
                } else if (yi1 == 1 && yi3 == 1 && xi2 == 0) {
                    y = 2;
                } else if (yi1 == 1 && yi7 == 1 && xi4 == 0) {
                    y = 4;
                } else if (yi9 == 1 && yi3 == 1 && xi6 == 0) {
                    y = 6;
                } else if (yi9 == 1 && yi7 == 1 && xi8 == 0) {
                    y = 8;
                } else {
                    y = (int) ((Math.random() * 9) + 1);

                }
            }

        }  else if (g == 3) {
            if (yi5 == 1) {
                if (xi1 == 1) {
                    if (xi2 == 1) {
                        y = 3;
                    } else if (xi3 == 1) {
                        y = 2;
                    } else if (xi4 == 1) {
                        y = 7;
                    } else if (xi7 == 1) {
                        y = 4;
                    } else {
                        y = (int) ((Math.random() * 9) + 1);
                    }
                } else if (xi9 == 1) {
                    if (xi8 == 1) {
                        y = 7;
                    } else if (xi7 == 1) {
                        y = 8;
                    } else if (xi3 == 1) {
                        y = 6;
                    } else if (xi6 == 1) {
                        y = 3;
                    } else {
                        y = (int) ((Math.random() * 9) + 1);
                    }
                } else if (xi3 == 1) {
                    if (xi6 == 1) {
                        y = 9;
                    } else if (xi2 == 1) {
                        y = 1;
                    } else {
                        y = (int) ((Math.random() * 9) + 1);
                    }
                } else if (xi7 == 1) {
                    if (xi4 == 1) {
                        y = 1;
                    } else if (xi8 == 1) {
                        y = 9;
                    } else {
                        y = (int) ((Math.random() * 9) + 1);
                    }
                } else {
                    y = (int) ((Math.random() * 9) + 1);
                }
            } else {
                if (xi1 == 1 && yi9==0) {
                    y = 9;
                } else if (xi2 == 1&& yi8==0) {
                    y = 8;
                } else if (xi3 == 1&& yi7==0) {
                    y = 7;
                } else if (xi4 == 1&& yi6==0) {
                    y = 6;
                } else if (xi6 == 1&& yi4==0) {
                    y = 4;
                } else if (xi7 == 1&& yi3==0) {
                    y = 3;
                } else if (xi8 == 1&& yi2==0) {
                    y = 2;
                } else if (xi9 == 1&& yi1==0) {
                    y = 1;
                }
                else {
                    y = (int) ((Math.random() * 9) + 1);
                }
            }
        } else if (g == 5 || g == 7) {
            if (yi5 == 1) {
                if (yi1 == 1 && xi9 == 0) {
                    y = 9;
                } else if (yi2 == 1 && xi8 == 0) {
                    y = 8;
                } else if (yi3 == 1 && xi7 == 0) {
                    y = 7;
                } else if (yi4 == 1 && xi6 == 0) {
                    y = 6;
                } else if (yi6 == 1 && xi4 == 0) {
                    y = 4;
                } else if (yi7 == 1 && xi3 == 0) {
                    y = 3;
                } else if (yi8 == 1 && xi2 == 0) {
                    y = 2;
                } else if (yi9 == 1 && xi1 == 0) {
                    y = 1;
                } else if (xi1 == 1 && xi2 == 1 && yi3 == 0) {
                    y = 3;
                } else if (xi1 == 1 && xi3 == 1 && yi2 == 0) {
                    y = 2;
                }
                else if (xi2 == 1 && xi3 == 1 && yi1 == 0){
                    y = 1;
                }else if (xi1 == 1 && xi7 == 1 && yi4 == 0) {
                    y = 4;
                } else if (xi1 == 1 && xi4 == 1 && yi7 == 0) {
                    y = 7;
                }else if (xi4 == 1 && xi7 == 1 && yi1 == 0){
                    y = 1;
                }
                else if (xi3 == 1 && xi6 == 1 && yi9 == 0) {
                    y = 9;
                } else if (xi3 == 1 && xi9 == 1 && yi6 == 0) {
                    y = 6;
                } else if (xi6 == 1 && xi9 == 1 && yi6 == 3) {
                    y = 3;
                }
                else if (xi7 == 1 && xi8 == 1 && yi9 == 0) {
                    y = 9;
                } else if (xi7 == 1 && xi9 == 1 && yi8 == 0) {
                    y = 8;
                } else {
                    y = (int) ((Math.random() * 9) + 1);
                }
            } else {
                if (yi1 == 1 && yi2 == 1 && xi3 == 0) {
                    y = 3;
                } else if (yi1 == 1 && yi3 == 1 && xi2 == 0) {
                    y = 2;
                } else if (yi7 == 1 && yi8 == 1 && xi9 == 0) {
                    y = 9;
                } else if (yi7 == 1 && yi9 == 1 && xi8 == 0) {
                    y = 8;
                } else if (xi1 == 1 && yi9 == 0) {
                    y = 9;
                } else if (xi1 == 1 && xi2 == 1 && yi3 == 0) {
                    y = 3;
                } else if (xi1 == 1 && xi3 == 1 && yi2 == 0) {
                    y = 2;
                } else if (xi1 == 1 && xi7 == 1 && yi4 == 0) {
                    y = 4;
                } else if (xi1 == 1 && xi4 == 1 && yi7 == 0) {
                    y = 7;
                } else if (xi2 == 1 && yi8 == 0) {
                    y = 8;
                } else if (xi3 == 1 && yi7 == 0) {

                    y = 7;
                } else if (xi3 == 1 && xi2 == 1 && yi1 == 0) {
                    y = 1;
                } else if (xi3 == 1 && xi6 == 1 && yi9 == 0) {
                    y = 9;
                } else if (xi3 == 1 && xi9 == 1 && yi6 == 0) {
                    y = 6;
                } else if (xi4 == 1 && yi6 == 0) {
                    y = 6;
                } else if (xi6 == 1 && yi4 == 0) {
                    y = 4;
                } else if (xi7 == 1 && yi3 == 0) {
                    y = 3;
                } else if (xi7 == 1 && xi4 == 1 && yi1 == 0) {
                    y = 1;
                } else if (xi7 == 1 && xi8 == 1 && yi9 == 0) {
                    y = 9;
                } else if (xi7 == 1 && xi9 == 1 && yi8 == 0) {
                    y = 8;
                } else if (xi8 == 1 && yi2 == 0) {
                    y = 2;
                } else if (xi9 == 1) {
                    if (yi1 == 0) {
                        y = 1;
                    } else if (xi8 == 1 && yi7 == 0) {
                        y = 7;
                    }
                }
            }
        }


        //placing and checking if its not used
        switch (y) {
            case 1:
                if (Objects.equals(buttons[0].getText(), "")) {
                    buttons[0].setText("O");
                    gamePass();
                    bot = false;
                }
                break;
            case 2:
                if (Objects.equals(buttons[1].getText(), "")) {
                    buttons[1].setText("O");
                    gamePass();
                    bot = false;
                }
                break;
            case 3:
                if (Objects.equals(buttons[2].getText(), "")) {
                    buttons[2].setText("O");
                    gamePass();
                    bot = false;

                }
                break;
            case 4:
                if (Objects.equals(buttons[3].getText(), "")) {
                    buttons[3].setText("O");
                    gamePass();
                    bot = false;

                }
                break;
            case 5:
                if (Objects.equals(buttons[4].getText(), "")) {
                    buttons[4].setText("O");
                    gamePass();
                    bot = false;

                }
                break;
            case 6:
                if (Objects.equals(buttons[5].getText(), "")) {
                    buttons[5].setText("O");
                    gamePass();
                    bot = false;

                }
                break;
            case 7:
                if (Objects.equals(buttons[6].getText(), "")) {
                    buttons[6].setText("O");
                    gamePass();
                    bot = false;

                }
                break;
            case 8:
                if (Objects.equals(buttons[7].getText(), "")) {
                    buttons[7].setText("O");
                    gamePass();
                    bot = false;

                }
                break;
            case 9:
                if (Objects.equals(buttons[8].getText(), "")) {
                    buttons[8].setText("O");
                    gamePass();
                    bot = false;
                }
                break;
        }
    }

}
    public void gamePasss(){z--;}
    public void gamePass() {
        z++;
    }
    public void gamePassB(){
        g=z;
    }

    public void actionPerformed(ActionEvent e){
        gamePassB();
            if (g % 2 == kz) {
                for (int i = 0; i < 9; i++) {
                    if (e.getSource() == buttons[i]) {
                        if (Objects.equals(buttons[i].getText(), "")) {
                            buttons[i].setText("X");
                            gamePass();
                            check();
                        }
                    }
                }
                try {
                    click(300,300);
                } catch (AWTException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else {
                    bot=true;
                    checksY();
                    check();
            }
        }

        public void check(){
            if(Objects.equals(buttons[0].getText(), "X") && Objects.equals(buttons[1].getText(), "X") && Objects.equals(buttons[2].getText(), "X")){
                xWins(0,1,2);
            }
            else if(Objects.equals(buttons[3].getText(), "X") && Objects.equals(buttons[4].getText(), "X") && Objects.equals(buttons[5].getText(), "X")){
                xWins(3,4,5);
            }
            else if(Objects.equals(buttons[6].getText(), "X") && Objects.equals(buttons[7].getText(), "X") && Objects.equals(buttons[8].getText(), "X")){
                xWins(6,7,8);
            }
            else if(Objects.equals(buttons[0].getText(), "X") && Objects.equals(buttons[3].getText(), "X") && Objects.equals(buttons[6].getText(), "X")){
                xWins(0,3,6);
            }
            else if(Objects.equals(buttons[1].getText(), "X") && Objects.equals(buttons[4].getText(), "X") && Objects.equals(buttons[7].getText(), "X")){
                xWins(1,4,7);
            }
            else if(Objects.equals(buttons[2].getText(), "X") && Objects.equals(buttons[5].getText(), "X") && Objects.equals(buttons[8].getText(), "X")){
                xWins(2,5,8);
            }
            else if(Objects.equals(buttons[0].getText(), "X") && Objects.equals(buttons[4].getText(), "X") && Objects.equals(buttons[8].getText(), "X")){
                xWins(0,4,8);
            }
            else if(Objects.equals(buttons[2].getText(), "X") && Objects.equals(buttons[4].getText(), "X") && Objects.equals(buttons[6].getText(), "X")){
                xWins(2,4,6);
            }
            else if(Objects.equals(buttons[0].getText(), "O") && Objects.equals(buttons[1].getText(), "O") && Objects.equals(buttons[2].getText(), "O")){
                yWins(0,1,2);
            }
            else if(Objects.equals(buttons[3].getText(), "O") && Objects.equals(buttons[4].getText(), "O") && Objects.equals(buttons[5].getText(), "O")){
                yWins(3,4,5);
            }
            else if(Objects.equals(buttons[6].getText(), "O") && Objects.equals(buttons[7].getText(), "O") && Objects.equals(buttons[8].getText(), "O")){
                yWins(6,7,8);
            }
            else if(Objects.equals(buttons[0].getText(), "O") && Objects.equals(buttons[3].getText(), "O") && Objects.equals(buttons[6].getText(), "O")){
                yWins(0,3,6);
            }
            else if(Objects.equals(buttons[1].getText(), "O") && Objects.equals(buttons[4].getText(), "O") && Objects.equals(buttons[7].getText(), "O")){
                yWins(1,4,7);
            }
            else if(Objects.equals(buttons[2].getText(), "O") && Objects.equals(buttons[5].getText(), "O") && Objects.equals(buttons[8].getText(), "O")){
                yWins(2,5,8);
            }
            else if(Objects.equals(buttons[0].getText(), "O") && Objects.equals(buttons[4].getText(), "O") && Objects.equals(buttons[8].getText(), "O")){
                yWins(0,4,8);
            }
            else if(Objects.equals(buttons[2].getText(), "O") && Objects.equals(buttons[4].getText(), "O") && Objects.equals(buttons[6].getText(), "O")){
                yWins(2,4,6);
            }
            else if((Objects.equals(buttons[0].getText(), "X")||(Objects.equals(buttons[0].getText(), "O")))&&(Objects.equals(buttons[1].getText(), "X")||(Objects.equals(buttons[1].getText(), "O")))&&(Objects.equals(buttons[2].getText(), "X")||(Objects.equals(buttons[2].getText(), "O")))&&(Objects.equals(buttons[3].getText(), "X")||(Objects.equals(buttons[3].getText(), "O")))&&(Objects.equals(buttons[4].getText(), "X")||(Objects.equals(buttons[4].getText(), "O")))&&(Objects.equals(buttons[5].getText(), "X")||(Objects.equals(buttons[5].getText(), "O")))&&(Objects.equals(buttons[6].getText(), "X")||(Objects.equals(buttons[6].getText(), "O")))&&(Objects.equals(buttons[7].getText(), "X")||(Objects.equals(buttons[7].getText(), "O")))&&(Objects.equals(buttons[8].getText(), "X")||(Objects.equals(buttons[8].getText(), "O")))){
                text_field.setText("Draw!");
                for(int i = 0;i<9;i++){
                    buttons[i].setEnabled(false);
                }
            }

        }
    public void xWins(int a, int b, int c){
        text_field.setText("YOU WIN!");
        buttons[a].setBackground(new Color(100,255,100));
        buttons[b].setBackground(new Color(100,255,100));
        buttons[c].setBackground(new Color(100,255,100));
        for(int i = 0;i<9;i++){
            buttons[i].setEnabled(false);
        }
    }
    public void yWins(int a, int b, int c){
        text_field.setText("YOU LOSE!");
        buttons[a].setBackground(new Color(255,100,100));
        buttons[b].setBackground(new Color(255,100,100));
        buttons[c].setBackground(new Color(255,100,100));
        for(int i = 0;i<9;i++){
            buttons[i].setEnabled(false);
        }
    }
    public static void click(int x, int y) throws AWTException{
        Robot bot = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    }

