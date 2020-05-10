package farmsimulator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StoreWindow {
	
	private Farm farm;
	private JFrame frmGeneralStore;
	private JLabel lblStoreTitle;
	private String money;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreWindow window = new StoreWindow();
					window.frmGeneralStore.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StoreWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeneralStore = new JFrame();
		frmGeneralStore.setVisible(true);
		frmGeneralStore.setTitle("General Store");
		frmGeneralStore.setBounds(100, 100, 450, 300);
		frmGeneralStore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGeneralStore.getContentPane().setLayout(null);
		
		lblStoreTitle = new JLabel("Welcome to the General Store");
		lblStoreTitle.setSize(197, 16);
		lblStoreTitle.setLocation(new Point(130, 6));
		lblStoreTitle.setMaximumSize(new Dimension(90, 16));
		lblStoreTitle.setMinimumSize(new Dimension(90, 16));
		frmGeneralStore.getContentPane().add(lblStoreTitle);
		
		JLabel lblMoney = new JLabel("Money Available:");
		lblMoney.setBounds(6, 37, 122, 16);
		frmGeneralStore.getContentPane().add(lblMoney);
		
		JLabel lblMoneyAvailable = new JLabel(money);
		lblMoneyAvailable.setBounds(130, 37, 110, 16);
		frmGeneralStore.getContentPane().add(lblMoneyAvailable);
		
		JButton btnItem = new JButton("Purchase Item");
		btnItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGeneralStore.dispose();
				PurchaseItem p = new PurchaseItem();
			}
		});
		btnItem.setBounds(41, 78, 148, 29);
		frmGeneralStore.getContentPane().add(btnItem);
		
		JButton btnCrop = new JButton("Purchase Crops");
		btnCrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGeneralStore.dispose();
				PurchaseCrop p = new PurchaseCrop();
			}
		});
		btnCrop.setBounds(41, 118, 148, 29);
		frmGeneralStore.getContentPane().add(btnCrop);
		
		JButton btnAnimal = new JButton("Purchase Animals");
		btnAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGeneralStore.dispose();
				PurchaseAnimal p = new PurchaseAnimal();
			}
		});
		btnAnimal.setBounds(41, 159, 148, 29);
		frmGeneralStore.getContentPane().add(btnAnimal);
		
		JButton btnLeave = new JButton("Leave Store");
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGeneralStore.dispose();
				MainScreen m = new MainScreen();
			}
		});
		btnLeave.setBounds(173, 222, 117, 29);
		frmGeneralStore.getContentPane().add(btnLeave);
		
		JLabel lblItems = new JLabel("Items Owned");
		lblItems.setBounds(322, 37, 94, 16);
		frmGeneralStore.getContentPane().add(lblItems);
	}
}
