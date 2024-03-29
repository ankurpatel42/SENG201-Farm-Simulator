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
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Font;


/**
 * This is the purchase item window where the user can purchase items.
 * 
 * @author Ankur Patel, Benjamin Crozier
 * @version 15/05/2020
 */


public class PurchaseItem {
	
	private GameEnvironment game;

	private JFrame frmPurchaseItem;
	private String[] items = {"F1", "F2", "F3", "A1", "A2", "A3"};
	private DefaultComboBoxModel<String> itemsCombo = new DefaultComboBoxModel<String>(items);
	private String message;
	
	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	
	/**
	 * PurchaseItem constructor.
	 * 
	 * @param game			The game environment played on.
	 */
	public PurchaseItem(GameEnvironment game) {
		this.game = game;
		initialize();
		frmPurchaseItem.setVisible(true);
	}
	
	/**
	 * Closes the window after the user has chosen to go back to the store window.
	 */
	public void closePurchaseItemWindow() {
		frmPurchaseItem.dispose();
	}
	
	/**
	 * Closes the window after the user has chosen to go back to the store window.
	 */
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
		frmPurchaseItem.setBounds(100, 100, 540, 433);
		frmPurchaseItem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPurchaseItem.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Make Your Purchase");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 11));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(170, 10, 140, 16);
		frmPurchaseItem.getContentPane().add(lblTitle);
		
		JLabel lblMoney = new JLabel("Money Available:");
		lblMoney.setFont(new Font("Arial", Font.BOLD, 11));
		lblMoney.setBounds(29, 37, 122, 16);
		frmPurchaseItem.getContentPane().add(lblMoney);
		
		JLabel lblMoneyAvailable = new JLabel("");
		lblMoneyAvailable.setBounds(148, 36, 178, 16);
		String formatMoneyAvailable = String.format("%.2f", game.getFarmMoneyAvailable());
		lblMoneyAvailable.setText("$" + formatMoneyAvailable);
		frmPurchaseItem.getContentPane().add(lblMoneyAvailable);
		
		JLabel lblSelect = new JLabel("Select Item");
		lblSelect.setFont(new Font("Arial", Font.BOLD, 11));
		lblSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelect.setBounds(56, 65, 85, 16);
		frmPurchaseItem.getContentPane().add(lblSelect);
		
		JLabel lblCropItems = new JLabel("Crop Items");
		lblCropItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblCropItems.setFont(new Font("Arial", Font.BOLD, 11));
		lblCropItems.setBounds(306, 65, 85, 16);
		frmPurchaseItem.getContentPane().add(lblCropItems);
		
		JLabel lblAnimalItems = new JLabel("Animal Items");
		lblAnimalItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnimalItems.setFont(new Font("Arial", Font.BOLD, 11));
		lblAnimalItems.setBounds(301, 192, 90, 16);
		frmPurchaseItem.getContentPane().add(lblAnimalItems);
		
		JComboBox<String> comboBoxItem = new JComboBox<>(itemsCombo);
		comboBoxItem.setBounds(29, 95, 147, 27);
		frmPurchaseItem.getContentPane().add(comboBoxItem);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setBounds(29, 144, 147, 29);
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				message = game.createItem((String)comboBoxItem.getSelectedItem());
				JOptionPane.showMessageDialog(btnPurchase, message);
				String formatMoneyAvailable = String.format("%.2f", game.getFarmMoneyAvailable());
				lblMoneyAvailable.setText("$" + formatMoneyAvailable);
			}
		});
		frmPurchaseItem.getContentPane().add(btnPurchase);
		
		JButton btnBack = new JButton("Back to Store");
		btnBack.setBounds(356, 340, 140, 29);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closePurchaseItemWindow();
				game.launchStoreWindow();
			}
		});
		frmPurchaseItem.getContentPane().add(btnBack);
		
		JTextPane txtCrops = new JTextPane();
		txtCrops.setEditable(false);
		txtCrops.setBounds(206, 92, 290, 95);
		txtCrops.setText("Type\tPrice\tCrop Growth Boost\r\n\r\nF1: \t$50 \t1 day\r\nF2: \t$90 \t2 days\r\nF3: \t$150 \t4 days");
		txtCrops.setBackground(Color.LIGHT_GRAY);
		frmPurchaseItem.getContentPane().add(txtCrops);
		
		
		JTextPane txtAnimals = new JTextPane();
		txtAnimals.setEditable(false);
		txtAnimals.setText("Type\tPrice\tAnimal Health Boost\r\n\r\nA1: \t$50 \t10\r\nA2: \t$90 \t20\r\nA3: \t$150 \t40");
		txtAnimals.setBackground(Color.LIGHT_GRAY);
		txtAnimals.setBounds(206, 219, 290, 95);
		frmPurchaseItem.getContentPane().add(txtAnimals);
		

	}
}
