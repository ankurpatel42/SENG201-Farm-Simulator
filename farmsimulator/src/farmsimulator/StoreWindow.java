package farmsimulator;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Point;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.Color;

/**
 * This is the store window where the player can see what items they own and purchase animals and items.
 * 
 * @author Ankur Patel, Benjamin Crozier
 * @version 15/05/2020
 */


public class StoreWindow {
	
	private GameEnvironment game;
	
	private JFrame frmGeneralStore;
	private JLabel lblStoreTitle;
	
	private DefaultListModel<Item> itemListModel = new DefaultListModel<Item>();
	private JList<Item> itemList = new JList<>(itemListModel);
	
	private JScrollPane itemsOwnedScroller = new JScrollPane(itemList);

	/*
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
	 * Store window constructor.
	 * 
	 * @param game 		The game environment played on.
	 */
	public StoreWindow(GameEnvironment game) {
		this.game = game;
		initialize();
		frmGeneralStore.setVisible(true);
	}
	
	/**
	 * Closes the window after the user has chosen to open a different window.
	 */
	public void closeStoreWindow() {
		frmGeneralStore.dispose();
	}
	
	/**
	 * Closes the window after the user has chosen to open a different window.
	 */
	public void finishedWindow() {
		game.closeStoreWindow(this);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeneralStore = new JFrame();
		frmGeneralStore.setVisible(true);
		frmGeneralStore.setTitle("General Store");
		frmGeneralStore.setBounds(100, 100, 415, 335);
		frmGeneralStore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGeneralStore.getContentPane().setLayout(null);
		
		lblStoreTitle = new JLabel("Welcome to the General Store!");
		lblStoreTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblStoreTitle.setFont(new Font("Arial", Font.BOLD, 15));
		lblStoreTitle.setSize(244, 16);
		lblStoreTitle.setLocation(new Point(79, 11));
		lblStoreTitle.setMaximumSize(new Dimension(90, 16));
		lblStoreTitle.setMinimumSize(new Dimension(90, 16));
		frmGeneralStore.getContentPane().add(lblStoreTitle);
		
		JLabel lblMoney = new JLabel("Money Available:");
		lblMoney.setFont(new Font("Arial", Font.BOLD, 11));
		lblMoney.setBounds(41, 51, 122, 16);
		frmGeneralStore.getContentPane().add(lblMoney);
		
		JLabel lblMoneyAvailable = new JLabel("");
		lblMoneyAvailable.setBounds(139, 51, 110, 16);
		String formatMoneyAvailable = String.format("%.2f", game.getFarmMoneyAvailable());
		lblMoneyAvailable.setText("$" + formatMoneyAvailable);
		frmGeneralStore.getContentPane().add(lblMoneyAvailable);
		
		JButton btnItem = new JButton("Purchase Item");
		btnItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeStoreWindow();
				game.launchPurchaseItemWindow();
			}
		});
		btnItem.setBounds(41, 78, 148, 29);
		frmGeneralStore.getContentPane().add(btnItem);
		
		JButton btnCrop = new JButton("Purchase Crops");
		btnCrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeStoreWindow();
				game.launchPurchaseCropWindow();
			}
		});
		btnCrop.setBounds(41, 118, 148, 29);
		frmGeneralStore.getContentPane().add(btnCrop);
		
		JButton btnAnimal = new JButton("Purchase Animals");
		btnAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeStoreWindow();
				game.launchPurchaseAnimalWindow();
			}
		});
		btnAnimal.setBounds(41, 159, 148, 29);
		frmGeneralStore.getContentPane().add(btnAnimal);
		
		JButton btnLeave = new JButton("Leave Store");
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeStoreWindow();
				finishedWindow();
				game.launchMainScreen();
			}
		});
		btnLeave.setBounds(233, 236, 121, 29);
		frmGeneralStore.getContentPane().add(btnLeave);
		
		JLabel lblItems = new JLabel("Items Owned");
		lblItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblItems.setFont(new Font("Arial", Font.BOLD, 11));
		lblItems.setBounds(246, 51, 94, 16);
		frmGeneralStore.getContentPane().add(lblItems);
		
		itemListModel.addAll(game.getItemsOwnedByFarmer());
		
		itemsOwnedScroller.setBounds(232, 78, 122, 110);
		frmGeneralStore.add(itemsOwnedScroller);
		
		itemList.setBackground(Color.LIGHT_GRAY);

	}
}
