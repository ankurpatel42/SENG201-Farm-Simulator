package farmsimulator;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

/**
 * This is the purchase animal window where the user can purchase animals and give them a name.
 * 
 * @author Ankur Patel, Benjamin Crozier
 * @version 15/05/2020
 */


public class PurchaseAnimal {
	
	private GameEnvironment game;

	private JFrame frmPurchaseAnimal;
	private String[] animals = {"Cow", "Pig", "Sheep"};
	private DefaultComboBoxModel<String> animalsCombo = new DefaultComboBoxModel<String>(animals);
	private String animalChosen = null;
	private String message;

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseAnimal window = new PurchaseAnimal();
					window.frmPurchaseAnimal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PurchaseAnimal() {
		initialize();
	}
	
	/**
	 * PurchaseAnimal constructor.
	 * 
	 * @param game			The game environment played on.
	 */
	public PurchaseAnimal(GameEnvironment game) {
		this.game = game;
		initialize();
		frmPurchaseAnimal.setVisible(true);
	}
	
	/**
	 * Closes the window after the user has chosen to go back to the store window.
	 */
	public void closePurchaseAnimalWindow() {
		frmPurchaseAnimal.dispose();
	}
	
	/**
	 * Closes the window after the user has chosen to go back to the store window.
	 */
	public void finishedWindow() {
		game.closePurchaseAnimalWindow(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPurchaseAnimal = new JFrame();
		frmPurchaseAnimal.setTitle("Purchase Animal");
		frmPurchaseAnimal.setVisible(true);
		frmPurchaseAnimal.setBounds(100, 100, 443, 323);
		frmPurchaseAnimal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPurchaseAnimal.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Make Your Purchase");
		lblTitle.setBounds(147, 9, 181, 16);
		frmPurchaseAnimal.getContentPane().add(lblTitle);
		
		JLabel lblMoney = new JLabel("Money Available:");
		lblMoney.setBounds(35, 37, 122, 16);
		frmPurchaseAnimal.getContentPane().add(lblMoney);

		JLabel lblMoneyAvailable = new JLabel("");
		lblMoneyAvailable.setBounds(159, 37, 209, 16);
		String formatMoneyAvailable = String.format("%.2f", game.getFarmMoneyAvailable());
		lblMoneyAvailable.setText("$" + formatMoneyAvailable);
		frmPurchaseAnimal.getContentPane().add(lblMoneyAvailable);
		
		JLabel lblSelect = new JLabel("Select Animal");
		lblSelect.setBounds(62, 65, 115, 16);
		frmPurchaseAnimal.getContentPane().add(lblSelect);
		
		JLabel lblCropItems = new JLabel("Animals");
		lblCropItems.setBounds(300, 65, 85, 16);
		frmPurchaseAnimal.getContentPane().add(lblCropItems);
		
		JComboBox<String> comboBoxAnimals = new JComboBox<>(animalsCombo);
		comboBoxAnimals.setBounds(62, 93, 147, 27);
		frmPurchaseAnimal.getContentPane().add(comboBoxAnimals);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setBounds(62, 141, 147, 29);
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				animalChosen = (String)comboBoxAnimals.getSelectedItem();
				String nameSelected = JOptionPane.showInputDialog(frmPurchaseAnimal, "Give your " + animalChosen + " a name!");
				message = game.createAnimalCheck(animalChosen, nameSelected);
						
				JOptionPane.showMessageDialog(frmPurchaseAnimal, message);
				
				String formatMoneyAvailable = String.format("%.2f", game.getFarmMoneyAvailable());
				lblMoneyAvailable.setText("$" + formatMoneyAvailable);
			}
		});
		frmPurchaseAnimal.getContentPane().add(btnPurchase);
		
		JButton btnBack = new JButton("Back to Store");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closePurchaseAnimalWindow();
				game.launchStoreWindow();
			}
		});
		btnBack.setBounds(263, 223, 140, 29);
		frmPurchaseAnimal.getContentPane().add(btnBack);
		
		JTextPane txtAnimals = new JTextPane();
		txtAnimals.setEditable(false);
		txtAnimals.setBounds(263, 82, 140, 106);
		txtAnimals.setText("Type                Price\r\n\r\nCow:      \t$100\nPig:      \t$75\nSheep: \t$50");
		txtAnimals.setBackground(Color.LIGHT_GRAY);
		frmPurchaseAnimal.getContentPane().add(txtAnimals);
	}

}
