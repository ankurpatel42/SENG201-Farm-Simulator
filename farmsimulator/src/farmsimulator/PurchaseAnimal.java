package farmsimulator;

import java.awt.Color;
import java.awt.EventQueue;
//import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class PurchaseAnimal {
	
	private GameEnvironment game;

	private JFrame frmPurchaseAnimal;
	private String[] animals = {"Cow", "Pig", "Sheep"};
	DefaultComboBoxModel<String> animalsCombo = new DefaultComboBoxModel<String>(animals);
	private String animalChosen = null;
	private String message;
	private ArrayList<String> cowNamesChosen = new ArrayList<String>();
	private ArrayList<String> pigNamesChosen = new ArrayList<String>();
	private ArrayList<String> sheepNamesChosen = new ArrayList<String>();

	/**
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
	
	public PurchaseAnimal(GameEnvironment game) {
		this.game = game;
		initialize();
		frmPurchaseAnimal.setVisible(true);
	}
	
	public void closePurchaseAnimalWindow() {
		frmPurchaseAnimal.dispose();
	}
	
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
		frmPurchaseAnimal.setBounds(100, 100, 450, 263);
		frmPurchaseAnimal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPurchaseAnimal.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Make Your Purchase");
		lblTitle.setBounds(158, 6, 140, 16);
		frmPurchaseAnimal.getContentPane().add(lblTitle);
		
		JLabel lblMoney = new JLabel("Money Available:");
		lblMoney.setBounds(6, 37, 122, 16);
		frmPurchaseAnimal.getContentPane().add(lblMoney);

		JLabel lblMoneyAvailable = new JLabel("");
		lblMoneyAvailable.setBounds(130, 37, 110, 16);
		String formatMoneyAvailable = String.format("%.2f", game.getFarmMoneyAvailable());
		lblMoneyAvailable.setText("$" + formatMoneyAvailable);
		frmPurchaseAnimal.getContentPane().add(lblMoneyAvailable);
		
		JLabel lblSelect = new JLabel("Select Animal");
		lblSelect.setBounds(56, 65, 85, 16);
		frmPurchaseAnimal.getContentPane().add(lblSelect);
		
		JLabel lblCropItems = new JLabel("Animals");
		lblCropItems.setBounds(321, 65, 85, 16);
		frmPurchaseAnimal.getContentPane().add(lblCropItems);
		
		JComboBox<String> comboBoxAnimals = new JComboBox<>(animalsCombo);
		comboBoxAnimals.setBounds(24, 93, 147, 27);
		frmPurchaseAnimal.getContentPane().add(comboBoxAnimals);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setBounds(34, 135, 117, 29);
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				animalChosen = (String)comboBoxAnimals.getSelectedItem();
				switch (animalChosen) {
					case "Cow":
						String nameChosenForCow = JOptionPane.showInputDialog("Give your Cow a name!");
						if (nameChosenForCow == null) {
							JOptionPane.showMessageDialog(frmPurchaseAnimal, "That's not a valid name for your Pig!");
						}
						else if (game.checkTextInput(nameChosenForCow) == false) {
							JOptionPane.showMessageDialog(frmPurchaseAnimal, "That's not a valid name for your cow!");
						}
						else {
							if (cowNamesChosen.contains(nameChosenForCow)) {
								JOptionPane.showMessageDialog(frmPurchaseAnimal, "You already have a cow named " + nameChosenForCow);
							}
							else {
								cowNamesChosen.add(nameChosenForCow);
								message = game.createCow(nameChosenForCow);
								JOptionPane.showMessageDialog(btnPurchase, message);
							}
						}
						break;
					case "Pig":
						String nameChosenForPig = JOptionPane.showInputDialog("Give your Pig a name!");
						if (nameChosenForPig == null) {
							JOptionPane.showMessageDialog(frmPurchaseAnimal, "That's not a valid name for your Pig!");
						}
						else if (game.checkTextInput(nameChosenForPig) == false) {
							JOptionPane.showMessageDialog(frmPurchaseAnimal, "That's not a valid name for your Pig!");
						}
						else {
							if (pigNamesChosen.contains(nameChosenForPig)) {
								JOptionPane.showMessageDialog(frmPurchaseAnimal, "You already have a pig named " + nameChosenForPig);
							}
							else {
								pigNamesChosen.add(nameChosenForPig);
								message = game.createPig(nameChosenForPig);
								JOptionPane.showMessageDialog(btnPurchase, message);
							}
						}
						break;
					case "Sheep":
						String nameChosenForSheep = JOptionPane.showInputDialog("Give your Sheep a name!");
						if (nameChosenForSheep == null) {
							JOptionPane.showMessageDialog(frmPurchaseAnimal, "That's not a valid name for your Pig!");
						}
						else if (game.checkTextInput(nameChosenForSheep) == false) {
							JOptionPane.showMessageDialog(frmPurchaseAnimal, "That's not a valid name for your Sheep!");
						}
						else {
							if (sheepNamesChosen.contains(nameChosenForSheep)) {
								JOptionPane.showMessageDialog(frmPurchaseAnimal, "You already have a sheep named " + nameChosenForSheep);
							}
							else {
								sheepNamesChosen.add(nameChosenForSheep);
								message = game.createSheep(nameChosenForSheep);
								JOptionPane.showMessageDialog(btnPurchase, message);
							}
						}
						break;
				}

				
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
		btnBack.setBounds(158, 197, 117, 29);
		frmPurchaseAnimal.getContentPane().add(btnBack);
		
		JTextPane txtAnimals = new JTextPane();
		txtAnimals.setBounds(235, 81, 209, 103);
		txtAnimals.setText("Name	Price	Sell Price\r\n\r\nCow: 	$100 	$100\r\nPig: 	$100 	100\r\nSheep: 	$100 	$100");
		txtAnimals.setBackground(Color.LIGHT_GRAY);
		frmPurchaseAnimal.getContentPane().add(txtAnimals);
	}

}
