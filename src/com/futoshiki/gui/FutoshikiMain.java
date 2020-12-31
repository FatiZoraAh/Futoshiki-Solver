package com.futoshiki.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class FutoshikiMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField entry;
	Grid puzzle;
	private JFrame frame;
	int size;

	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FutoshikiMain frame = new FutoshikiMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public FutoshikiMain() {
		setTitle("Futoshiki/AHSAYNI Fatima Zahrae");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		

		JPanel sizeIns = new JPanel();
		contentPane.add(sizeIns);
		sizeIns.setLayout(null);
		sizeIns.setFont(new Font("ARIAL", Font.PLAIN, 12));

		JLabel sizeQuestion = new JLabel("Choose grid size:");
		sizeQuestion.setFont(new Font("Tahoma", Font.BOLD, 16));
		sizeQuestion.setBounds(133, 127, 190, 35);
		sizeIns.add(sizeQuestion);

		entry = new JTextField();
		entry.setBounds(162, 198, 86, 20);
		sizeIns.add(entry);
		entry.setColumns(10);

		JLabel lblNewLabel = new JLabel("please press enter once you have entered the size");
		lblNewLabel.setBounds(91, 173, 305, 14);
		sizeIns.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\dell\\Downloads\\c2784b16-192e-4397-b555-08c1f88a342f_200x200.png"));
		lblNewLabel_1.setBounds(108, 0, 216, 135);
		sizeIns.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\dell\\Desktop\\couleur.jpg"));
		lblNewLabel_2.setBounds(0, 0, 424, 251);
		sizeIns.add(lblNewLabel_2);
		entry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int input = Integer.parseInt(entry.getText());
					if (input <= 0) {
						JOptionPane.showMessageDialog(frame, "Please enter a number greater than 0");
					}
					puzzle = new Grid(input);
					fill();
					 //start.dispose();
					createWindow();
				} catch (NumberFormatException ee) {
					JOptionPane.showMessageDialog(frame, "Only numbers can be entered");
				}
			}
		});
	}
	private void setup() {
        try {
            int input = Integer.parseInt(JOptionPane.showInputDialog("What size would you like the grid?\n"
                    + "(Numbers between 1 and 9 are recommended)"));
            if (input <= 0) {
                JOptionPane.showMessageDialog(frame, "Please enter a number greater than 0");
                setup();
            }
            size = input;
            puzzle = new Grid(size);
            fill();
            createWindow();
        } catch (NumberFormatException ee) {
            JOptionPane.showMessageDialog(frame, "Only numbers can be entered");
            setup();
        }
    }
	 private void fill() {
	        puzzle.fillPuzzle();
	        while (!puzzle.isLegal() || !puzzle.solvable()) {
	            puzzle.fillPuzzle();
	        }
	    }
	public void createWindow() {

		JPanel grid = new JPanel();

		JPanel cp = (JPanel) getContentPane();
		cp.removeAll();
		cp.setLayout(new BorderLayout());
		JPanel menu = new JPanel();
		menu.setLayout(new FlowLayout());
		menu.setBackground(new Color(207,163,139));
		

		menu.setBorder(new EmptyBorder(20, 20, 20, 20));
		cp.add(menu, BorderLayout.SOUTH);
		cp.setBackground(new Color(184,164,163));
		cp.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		
		JButton help = new JButton("help");
		help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "    welll just play u stupid                         ");
            }
        });
		help.setBounds(20, 237, 89, 23);
		menu.add(help);
		JButton solve = new JButton("Solve");
		solve.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
             if (puzzle.solvable()) {
                 puzzle.solution();
                 createWindow();
                 JOptionPane.showMessageDialog(null, "The puzzle has been solved");
             } else {
                 JOptionPane.showMessageDialog(null, "The puzzle can't be solved, press 'check' and change accordingly");
             }
		 }
         });
		solve.setBounds(20, 271, 89, 23);
		menu.add(solve);
		
		
		JButton check = new JButton("Check");
		check.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!puzzle.isLegal()) {
                	JOptionPane.showMessageDialog(frame, "Not complete!");
                } else if (puzzle.isFull() && puzzle.isLegal()) {
                   
                    JOptionPane.showMessageDialog(frame, "Complete!");
                } else {
                	
                }
            }});
       
		check.setBounds(20, 303, 89, 23);
		menu.add(check);
		
		JButton NewPuzzul = new JButton("New Puzzul");
		NewPuzzul.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
            	 setup();
                
            }
        }
        );
		NewPuzzul.setBounds(20, 349, 89, 23);
		menu.add(NewPuzzul);
		
		JButton Quit = new JButton("Quit");
		Quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thank you for playing");
				System.exit(0);
			}
		});
		Quit.setBounds(20, 407, 89, 23);
		menu.add(Quit);
		
		
        
		

		grid = new JPanel();
		grid.setBorder(new EmptyBorder(10, 10, 10, 10));
		grid.setBackground(new Color(184,164,163));
		

		grid.setLayout(new GridLayout((2 * (puzzle.getGridSize()) - 1), 2 * (puzzle.getGridSize()) - 1));
		for (int i = 0; i < (puzzle.getGridSize()); i++) {
			for (int j = 0; j < (puzzle.getGridSize()); j++) {
				int i1 = i;
				int j1 = j;

				JPanel jP = new JPanel();
				jP.setBackground(new Color(184,164,163));
				jP.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
				jP.setBackground(Color.white);
				
				jP.setPreferredSize(new Dimension(200 / puzzle.getGridSize(), 100 / puzzle.getGridSize()));
				if (puzzle.getSquare(i, j).getInitial() == true) {
					JLabel num = new JLabel();
					num.setFont(new Font("Arial", Font.BOLD, 200 / (puzzle.getGridSize())));
					num.setBackground(Color.white);
					num.setForeground(Color.RED);
					num.setText(puzzle.getSquare(i, j).getNumber() + "");
					jP.add(num);
				} else {
					JTextField num = new JTextField(1);
					num.setFont(new Font("Arial", Font.BOLD, 200 / (puzzle.getGridSize())));
					num.setHorizontalAlignment(JTextField.CENTER);
					num.setBorder(javax.swing.BorderFactory.createEmptyBorder());

					if (puzzle.getSquare(i, j).getNumber() != 0) {
						num.setText(puzzle.getSquare(i, j).getNumber() + "");
					}
					num.addKeyListener(new KeyAdapter() {
						@Override
						public void keyReleased(KeyEvent e) {
							try {
								if (e.getKeyCode() == KeyEvent.VK_ENTER) {
									num.setText("0");
									createWindow();
								} else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
									num.setText("0");
									createWindow();
								}
								int current = Integer.parseInt(num.getText());
								puzzle.setSquare(i1, j1, current);
								if (num.getText().equals("0")) {
									createWindow();
								}
							} catch (NumberFormatException ee) {
								JOptionPane.showMessageDialog(frame, "You can only enter numbers");
								num.setText("0");
								createWindow();
							} catch (IllegalArgumentException ee) {
								JOptionPane.showMessageDialog(frame, "You are not in the range of the grid");
								num.setText("0");
								createWindow();
							}
						}

					});
					jP.add(num);
				}
				grid.add(jP);
				if (j < (puzzle.getGridSize()) - 1) {
					JPanel jP1 = new JPanel();
					jP1.setBackground(new Color(184,164,163));

					JLabel rCon = new JLabel();
					rCon.setBackground(new Color(184,164,163));
					
					rCon.setFont(new Font("Arial", Font.BOLD, 200 / (puzzle.getGridSize())));
					rCon.setText(puzzle.getRowConstraint(i, j).constraint() + "");

					jP1.add(rCon);
					grid.add(jP1);
				}
			}
			if (i < (puzzle.getGridSize()) - 1) {
				for (int k = 0; k < (puzzle.getGridSize()); k++) {
					JPanel jP2 = new JPanel();
					jP2.setBackground(new Color(184,164,163));

					JLabel cCon = new JLabel();
					cCon.setBackground(new Color(184,164,163));
					cCon.setFont(new Font("Arial", Font.BOLD, 200 / (puzzle.getGridSize())));

					cCon.setText(puzzle.getColConstraint(i, k).constraint() + "");
					jP2.add(cCon);
					grid.add(jP2);
					if (k < (puzzle.getGridSize()) - 1) {
						JPanel empty = new JPanel();
						empty.setBackground(new Color(184,164,163));

						grid.add(empty);
					}
				}
			}
		}

		cp.add(grid, BorderLayout.CENTER);

		pack();
		setVisible(true);
		
	}
}
