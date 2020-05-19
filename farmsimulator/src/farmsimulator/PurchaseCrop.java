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
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * This is the purchase crop window where the user can purchase crops.
 * 
 * @author Ankur Patel, Benjamin Crozier
 * @version 15/05/2020
 */


public class PurchaseCrop {
	
	private GameEnvironment game;

	private JFrame frmPurchaseCrop;
	private String cropChosen;
	private String[] items = {"Carrot", "Corn", "Lettuce", "Potato", "Rice", "Wheat"};
	private DefaultComboBoxModel<String> cropCombo = new DefaultComboBoxModel<String>(items);
	
	private String message;

	/*
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
	
	/**
	 * PurchaseCrop constructor.
	 * 
	 * @param game			The game environment played on.
	 */
	public PurchaseCrop(GameEnvironment game) {
		this.game = game;
		initialize();
		frmPurchaseCrop.setVisible(true);
	}
	
	/**
	 * Closes the window after the user has chosen to go back to the store window.
	 */
	public void closePurchaseCropWindow() {
		frmPurchaseCrop.dispose();
	}
	
	/**
	 * Closes the window after the user has chosen to go back to the store window.
	 */
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
		frmPurchaseCrop.setBounds(100, 100, 500, 395);
		frmPurchaseCrop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPurchaseCrop.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Make Your Purchase");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 11));
		lblTitle.setBounds(158, 6, 140, 16);
		frmPurchaseCrop.getContentPane().add(lblTitle);
		
		JLabel lblMoney = new JLabel("Money Available:");
		lblMoney.setFont(new Font("Arial", Font.BOLD, 11));
		lblMoney.setBounds(31, 37, 110, 16);
		frmPurchaseCrop.getContentPane().add(lblMoney);
		
		JLabel lblMoneyAvailable = new JLabel("");
		lblMoneyAvailable.setBounds(130, 37, 110, 16);
		String formatMoneyAvailable = String.format("%.2f", game.getFarmMoneyAvailable());
		lblMoneyAvailable.setText("$" + formatMoneyAvailable);
		frmPurchaseCrop.getContentPane().add(lblMoneyAvailable);
		
		JLabel lblSelect = new JLabel("Select Crop");
		lblSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelect.setFont(new Font("Arial", Font.BOLD, 11));
		lblSelect.setBounds(56, 65, 85, 16);
		frmPurchaseCrop.getContentPane().add(lblSelect);
		
		JLabel lblCropItems = new JLabel("Crops");
		lblCropItems.setFont(new Font("Arial", Font.BOLD, 11));
		lblCropItems.setBounds(301, 65, 85, 16);
		frmPurchaseCrop.getContentPane().add(lblCropItems);
		
		JComboBox<String> comboBoxCrop = new JComboBox<>(cropCombo);
		comboBoxCrop.setBounds(24, 93, 147, 27);
		frmPurchaseCrop.getContentPane().add(comboBoxCrop);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setBounds(24, 143, 147, 29);
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cropChosen = (String)comboBoxCrop.getSelectedItem();
				switch (cropChosen) {
					case "Carrot":
						message = game.createCarrot();
						break;
					case "Corn":
						message = game.createCorn();
						break;
					case "Lettuce":
						message = game.createLettuce();
						break;
					case "Potato":
						message = game.createPotato();
						break;
					case "Rice":
						message = game.createRice();
						break;
					case "Wheat":
						message = game.createWheat();
						break;
				}
				
				JOptionPane.showMessageDialog(btnPurchase, message);
				String formatMoneyAvailable = String.format("%.2f", game.getFarmMoneyAvailable());
				lblMoneyAvailable.setText("$" + formatMoneyAvailable);
			}
		});
		frmPurchaseCrop.getContentPane().add(btnPurchase);
		
		JButton btnBack = new JButton("Back to Store");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closePurchaseCropWindow();
				game.launchStoreWindow();
			}
		});
		btnBack.setBounds(310, 284, 117, 29);
		frmPurchaseCrop.getContentPane().add(btnBack);
		
		JTextPane txtCrops = new JTextPane();
		txtCrops.setEditable(false);
		txtCrops.setBounds(197, 92, 269, 152);
		txtCrops.setText("Name	Purchase	Grow	Sell\r\n	Price	Time	Price\r\n\r\nCarrot:	$100	3 days	$250\r\nCorn: 	$50  	3 days	$200\r\nLettuce: 	$100 	5 days	$400\r\nPotato: 	$200 	8 days	$1000\r\nRice: 	$150 	5 days	$500\r\nWheat: 	$75 	4 days	$300");
		txtCrops.setBackground(Color.LIGHT_GRAY);
		frmPurchaseCrop.getContentPane().add(txtCrops);
	}

}
