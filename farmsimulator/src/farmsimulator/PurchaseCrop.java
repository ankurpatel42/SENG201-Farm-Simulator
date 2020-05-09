package farmsimulator;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PurchaseCrop {

	private JFrame frmPurchaseCrop;

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
		
		JComboBox comboBoxItem = new JComboBox();
		comboBoxItem.setBounds(24, 93, 147, 27);
		frmPurchaseCrop.getContentPane().add(comboBoxItem);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setBounds(34, 127, 117, 29);
		frmPurchaseCrop.getContentPane().add(btnPurchase);
		
		JButton btnBack = new JButton("Back to Store");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPurchaseCrop.dispose();
				StoreWindow s = new StoreWindow();
			}
		});
		btnBack.setBounds(156, 178, 117, 29);
		frmPurchaseCrop.getContentPane().add(btnBack);
	}

}
