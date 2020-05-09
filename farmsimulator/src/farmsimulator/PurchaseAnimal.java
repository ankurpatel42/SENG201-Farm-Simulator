package farmsimulator;

import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PurchaseAnimal {

	private JFrame frmPurchaseAnimal;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPurchaseAnimal = new JFrame();
		frmPurchaseAnimal.setTitle("Purchase Animal");
		frmPurchaseAnimal.setVisible(true);
		frmPurchaseAnimal.setBounds(100, 100, 450, 300);
		frmPurchaseAnimal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPurchaseAnimal.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Make Your Purchase");
		lblTitle.setBounds(158, 6, 140, 16);
		frmPurchaseAnimal.getContentPane().add(lblTitle);
		
		JLabel lblMoney = new JLabel("Money Available:");
		lblMoney.setBounds(6, 37, 122, 16);
		frmPurchaseAnimal.getContentPane().add(lblMoney);
		
		JLabel lblMoneyAvailable = new JLabel("$ Farm's Money $");
		lblMoneyAvailable.setBounds(130, 37, 110, 16);
		frmPurchaseAnimal.getContentPane().add(lblMoneyAvailable);
		
		JLabel lblSelect = new JLabel("Select Animal");
		lblSelect.setBounds(56, 65, 85, 16);
		frmPurchaseAnimal.getContentPane().add(lblSelect);
		
		JLabel lblCropItems = new JLabel("Animals");
		lblCropItems.setBounds(321, 65, 85, 16);
		frmPurchaseAnimal.getContentPane().add(lblCropItems);
		
		JComboBox comboBoxItem = new JComboBox();
		comboBoxItem.setBounds(24, 93, 147, 27);
		frmPurchaseAnimal.getContentPane().add(comboBoxItem);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setBounds(34, 135, 117, 29);
		frmPurchaseAnimal.getContentPane().add(btnPurchase);
		
		JButton btnBack = new JButton("Back to Store");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPurchaseAnimal.dispose();
				StoreWindow s = new StoreWindow();
			}
		});
		btnBack.setBounds(158, 187, 117, 29);
		frmPurchaseAnimal.getContentPane().add(btnBack);
	}

}
