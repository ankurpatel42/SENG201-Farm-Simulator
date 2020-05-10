package farmsimulator;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class PurchaseAnimal {

	private JFrame frmPurchaseAnimal;
	private String[] animals = {"Cow", "Pig", "Sheep"};
	DefaultComboBoxModel<String> animalsCombo = new DefaultComboBoxModel<String>(animals);
	private String animalChosen = null;
	private Animal animal;
	private GeneralStore store;
	private String message;
	private String money;
	private Farm farm;

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
		farm = GameEnvironment.getFarm();
		initialize();
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
		
		money = farm.moneyToString();
		JLabel lblMoneyAvailable = new JLabel(money);
		lblMoneyAvailable.setBounds(130, 37, 110, 16);
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
						animal = new Cow();
						break;
					case "Pig":
						animal = new Pig();
						break;
					case "Sheep":
						animal = new Sheep();
						break;
				}
				
				store = GameEnvironment.getStore();
				//PROBLEM, Not calling below method?
				message = store.purchaseAnimal(animal);
				JOptionPane.showMessageDialog(btnPurchase, message);
			}
		});
		frmPurchaseAnimal.getContentPane().add(btnPurchase);
		
		JButton btnBack = new JButton("Back to Store");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPurchaseAnimal.dispose();
				StoreWindow s = new StoreWindow();
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
