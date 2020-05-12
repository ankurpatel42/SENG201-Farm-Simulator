package farmsimulator;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JTextPane;

public class PurchaseItem {
	
	private GameEnvironment game;

	private JFrame frmPurchaseItem;
	private String[] items = {"F1", "F2", "F3", "A1", "A2", "A3"};
	DefaultComboBoxModel<String> itemsCombo = new DefaultComboBoxModel<String>(items);
	private String itemChosen = null;
	//private String famerName = GameEnvironment.getFarmer().getFarmerName();
	//private Item item; 
	private String message;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//TESTING
		//Farm farm = new Farm("Test", 1000.00, 2.5, 5, 3);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseItem window = new PurchaseItem();
					window.frmPurchaseItem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PurchaseItem() {
		initialize();
	}
	
	public PurchaseItem(GameEnvironment game) {
		this.game = game;
		initialize();
		frmPurchaseItem.setVisible(true);
	}
	
	public void closePurchaseItemWindow() {
		frmPurchaseItem.dispose();
	}
	
	public void finishedWindow() {
		game.closePurchaseItemWindow(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPurchaseItem = new JFrame();
		frmPurchaseItem.setVisible(true);
		frmPurchaseItem.setTitle("Purchase Item");
		frmPurchaseItem.setBounds(100, 100, 496, 338);
		frmPurchaseItem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPurchaseItem.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Make Your Purchase");
		lblTitle.setBounds(158, 6, 140, 16);
		frmPurchaseItem.getContentPane().add(lblTitle);
		
		JLabel lblMoney = new JLabel("Money Available:");
		lblMoney.setBounds(6, 37, 122, 16);
		frmPurchaseItem.getContentPane().add(lblMoney);
		
		JLabel lblMoneyAvailable = new JLabel("");
		lblMoneyAvailable.setBounds(130, 37, 110, 16);
		String formatMoneyAvailable = String.format("%.2f", game.getFarmMoneyAvailable());
		lblMoneyAvailable.setText("$" + formatMoneyAvailable);
		frmPurchaseItem.getContentPane().add(lblMoneyAvailable);
		
		JLabel lblSelect = new JLabel("Select Item");
		lblSelect.setBounds(56, 65, 85, 16);
		frmPurchaseItem.getContentPane().add(lblSelect);
		
		JLabel lblCropItems = new JLabel("Crop Items");
		lblCropItems.setBounds(301, 37, 85, 16);
		frmPurchaseItem.getContentPane().add(lblCropItems);
		
		JLabel lblAnimalItems = new JLabel("Animal Items");
		lblAnimalItems.setBounds(301, 160, 90, 16);
		frmPurchaseItem.getContentPane().add(lblAnimalItems);
		
		JComboBox<String> comboBoxItem = new JComboBox<>(itemsCombo);
		comboBoxItem.setBounds(24, 93, 147, 27);
		frmPurchaseItem.getContentPane().add(comboBoxItem);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setBounds(34, 127, 117, 29);
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemChosen = (String)comboBoxItem.getSelectedItem();
				switch (itemChosen) {
					case "A1":
						//make a method in Game Environment that initializes/sets items and call it here
						message = game.createAnimalFoodOne();
						break;
					case "A2":
						message = game.createAnimalFoodTwo();
						break;
					case "A3":
						message = game.createAnimalFoodThree();
						break;
					case "F1":
						message = game.createFertiliserOne();
						break;
					case "F2":
						message = game.createFertiliserTwo();
						break;
					case "F3":
						message = game.createFertiliserThree();
						break;
				}
				
				JOptionPane.showMessageDialog(btnPurchase, message);
			}
		});
		frmPurchaseItem.getContentPane().add(btnPurchase);
		
		JButton btnBack = new JButton("Back to Store");
		btnBack.setBounds(175, 281, 117, 29);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closePurchaseItemWindow();
				game.launchStoreWindow();
			}
		});
		frmPurchaseItem.getContentPane().add(btnBack);
		
		JTextPane txtCrops = new JTextPane();
		txtCrops.setBounds(206, 65, 273, 80);
		txtCrops.setText("Name	Price	Crop Growth Boost\r\n\r\nF1: 	$100 	1 day\r\nF2: 	$250 	3 days\r\nF3: 	$400 	5 days");
		txtCrops.setBackground(Color.LIGHT_GRAY);
		frmPurchaseItem.getContentPane().add(txtCrops);
		
		JTextPane txtAnimals = new JTextPane();
		txtAnimals.setText("Name	Price	Animal Health Boost\r\n\r\nA1: 	$100 	1\r\nA2: 	$300 	5\r\nA3: 	$700 	10");
		txtAnimals.setBackground(Color.LIGHT_GRAY);
		txtAnimals.setBounds(206, 188, 273, 78);
		frmPurchaseItem.getContentPane().add(txtAnimals);
	}
}
