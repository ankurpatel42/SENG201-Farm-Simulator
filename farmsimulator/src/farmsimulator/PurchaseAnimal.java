package farmsimulator;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PurchaseAnimal {

	private JFrame frmPuchaseAnimal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseAnimal window = new PurchaseAnimal();
					window.frmPuchaseAnimal.setVisible(true);
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
		frmPuchaseAnimal = new JFrame();
		frmPuchaseAnimal.setTitle("Puchase Animal");
		frmPuchaseAnimal.setBounds(100, 100, 450, 300);
		frmPuchaseAnimal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPuchaseAnimal.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Make Your Purchase");
		lblTitle.setBounds(158, 6, 140, 16);
		frmPuchaseAnimal.getContentPane().add(lblTitle);
		
		JLabel lblMoney = new JLabel("Money Available:");
		lblMoney.setBounds(6, 37, 122, 16);
		frmPuchaseAnimal.getContentPane().add(lblMoney);
		
		JLabel lblMoneyAvailable = new JLabel("$ Farm's Money $");
		lblMoneyAvailable.setBounds(130, 37, 110, 16);
		frmPuchaseAnimal.getContentPane().add(lblMoneyAvailable);
		
		JLabel lblSelect = new JLabel("Select Animal");
		lblSelect.setBounds(56, 65, 85, 16);
		frmPuchaseAnimal.getContentPane().add(lblSelect);
		
		JLabel lblCropItems = new JLabel("Animals");
		lblCropItems.setBounds(321, 65, 85, 16);
		frmPuchaseAnimal.getContentPane().add(lblCropItems);
		
		JComboBox comboBoxItem = new JComboBox();
		comboBoxItem.setBounds(24, 93, 147, 27);
		frmPuchaseAnimal.getContentPane().add(comboBoxItem);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setBounds(34, 135, 117, 29);
		frmPuchaseAnimal.getContentPane().add(btnPurchase);
		
		JButton btnBack = new JButton("Back to Store");
		btnBack.setBounds(158, 187, 117, 29);
		frmPuchaseAnimal.getContentPane().add(btnBack);
	}

}
