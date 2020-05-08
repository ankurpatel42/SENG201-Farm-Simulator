package farmsimulator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PurchaseItem {

	private JFrame frmPurchaseItem;

	/**
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
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPurchaseItem = new JFrame();
		frmPurchaseItem.setTitle("Purchase Item");
		frmPurchaseItem.setBounds(100, 100, 450, 300);
		frmPurchaseItem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPurchaseItem.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Make Your Purchase");
		lblTitle.setBounds(158, 6, 140, 16);
		frmPurchaseItem.getContentPane().add(lblTitle);
		
		JLabel lblMoney = new JLabel("Money Available:");
		lblMoney.setBounds(6, 37, 122, 16);
		frmPurchaseItem.getContentPane().add(lblMoney);
		
		JLabel lblMoneyAvailable = new JLabel("$ Farm's Money $");
		lblMoneyAvailable.setBounds(130, 37, 110, 16);
		frmPurchaseItem.getContentPane().add(lblMoneyAvailable);
		
		JLabel lblSelect = new JLabel("Select Item");
		lblSelect.setBounds(56, 65, 85, 16);
		frmPurchaseItem.getContentPane().add(lblSelect);
		
		JLabel lblCropItems = new JLabel("Crop Items");
		lblCropItems.setBounds(301, 37, 85, 16);
		frmPurchaseItem.getContentPane().add(lblCropItems);
		
		JLabel lblAnimalItems = new JLabel("Animal Items");
		lblAnimalItems.setBounds(301, 132, 90, 16);
		frmPurchaseItem.getContentPane().add(lblAnimalItems);
		
		JComboBox comboBoxItem = new JComboBox();
		comboBoxItem.setBounds(24, 93, 147, 27);
		frmPurchaseItem.getContentPane().add(comboBoxItem);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setBounds(34, 127, 117, 29);
		frmPurchaseItem.getContentPane().add(btnPurchase);
		
		JButton btnBack = new JButton("Back to Store");
		btnBack.setBounds(158, 229, 117, 29);
		frmPurchaseItem.getContentPane().add(btnBack);
	}
}
