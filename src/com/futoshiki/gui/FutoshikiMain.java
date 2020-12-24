package com.futoshiki.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class FutoshikiMain extends JFrame {

	private JPanel contentPane;
	private JTextField entry;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public FutoshikiMain() {
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
		sizeQuestion.setBounds(141, 75, 190, 35);
		sizeIns.add(sizeQuestion);
		
		entry = new JTextField();
		entry.setBounds(162, 132, 86, 20);
		sizeIns.add(entry);
		entry.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("please press enter once you have entered the size");
		lblNewLabel.setBounds(95, 109, 305, 14);
		sizeIns.add(lblNewLabel);
		entry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int input = Integer.parseInt(entry.getText());
                    if (input <= 0) {
                        JOptionPane.showMessageDialog(null, "Please enter a number greater than 0");
                    }
                    //puzzle = new FutoshikiGrid(input);
                    //fill();
                    //start.dispose();
                    //createWindow();
                } catch (NumberFormatException ee) {
                    JOptionPane.showMessageDialog(null, "Only numbers can be entered");
                }
            }
        });
	}
}
