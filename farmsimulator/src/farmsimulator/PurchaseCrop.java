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

public class PurchaseCrop {
	
	private GameEnvironment game;

	private JFrame frmPurchaseCrop;
	private String cropChosen;
	private String[] items = {"Carrot", "Corn", "Lettuce", "Potato", "Rice", "Wheat"};
	DefaultComboBoxModel<String> cropCombo = new DefaultComboBoxModel<String>(items);
	
	private GeneralStore store;
	private String message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseCrop window = new PurchaseCrop();
					window.frmPurchaseCrop.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PurchaseCrop() {
		initialize();
	}
	
	public PurchaseCrop(GameEnvironment game) {
		this.game = game;
		initialize();
		frmPurchaseCrop.setVisible(true);
	}
	
	public void closePurchaseCropWindow() {
		frmPurchaseCrop.dispose();
	}
	
	public void finishedWindow() {
		game.closePurchaseCropWindow(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPurchaseCrop = new JFrame();
		frmPurchaseCrop.setVisible(true);
		frmPurchaseCrop.setTitle("Purchase Crop");
		frmPurchaseCrop.setBounds(100, 100, 450, 300);
		frmPurchaseCrop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPurchaseCrop.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Make Your Purchase");
		lblTitle.setBounds(158, 6, 140, 16);
		frmPurchaseCrop.getContentPane().add(lblTitle);
		
		JLabel lblMoney = new JLabel("Money Available:");
		lblMoney.setBounds(6, 37, 122, 16);
		frmPurchaseCrop.getContentPane().add(lblMoney);
		
		JLabel lblMoneyAvailable = new JLabel("$ Farm's Money $");
		lblMoneyAvailable.setBounds(130, 37, 110, 16);
		frmPurchaseCrop.getContentPane().add(lblMoneyAvailable);
		
		JLabel lblSelect = new JLabel("Select Crop");
		lblSelect.setBounds(56, 65, 85, 16);
		frmPurchaseCrop.getContentPane().add(lblSelect);
		
		JLabel lblCropItems = new JLabel("Crops");
		lblCropItems.setBounds(321, 65, 85, 16);
		frmPurchaseCrop.getContentPane().add(lblCropItems);
		
		JComboBox<String> comboBoxCrop = new JComboBox<>(cropCombo);
		comboBoxCrop.setBounds(24, 93, 147, 27);
		frmPurchaseCrop.getContentPane().add(comboBoxCrop);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setBounds(34, 127, 117, 29);
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cropChosen = (String)comboBoxCrop.getSelectedItem();
				switch (cropChosen) {
					case "Carrot":
						//make a method in Game Environment that initializes/sets crops and call it here
						crop = new Carrot();
						break;
					case "Corn":
						crop = new Corn();
						break;
					case "Lettuce":
						crop = new Lettuce();
						break;
					case "Potato":
						crop = new Potato();
						break;
					case "Rice":
						crop = new Rice();
						break;
					case "Wheat":
						crop = new Wheat();
						break;
				}
				
				store = GameEnvironment.getStore();
				//PROBLEM, Not calling below method?
				message = store.purchaseCrop(crop);
				JOptionPane.showMessageDialog(btnPurchase, message);
			}
		});
		frmPurchaseCrop.getContentPane().add(btnPurchase);
		
		JButton btnBack = new JButton("Back to Store");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPurchaseCrop.dispose();
				StoreWindow s = new StoreWindow();
			}
		});
		btnBack.setBounds(158, 232, 117, 29);
		frmPurchaseCrop.getContentPane().add(btnBack);
		
		JTextPane txtCrops = new JTextPane();
		txtCrops.setBounds(182, 93, 245, 127);
		txtCrops.setText("Name	Price	Grow time\r\n\r\nCarrot:	$10	5 days\r\nCorn: 	$5  	5 days\r\nLettuce: 	$4 	5 days\r\nPotato: 	$4 	8 days\r\nRice: 	$2 	5 days\r\nWheat: 	$2 	3 days");
		txtCrops.setBackground(Color.LIGHT_GRAY);
		frmPurchaseCrop.getContentPane().add(txtCrops);
	}

}
