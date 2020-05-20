package farmsimulator;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

/**
 * This is the purchase crop window where the user can purchase crops.
 * 
 * @author Ankur Patel, Benjamin Crozier
 * @version 15/05/2020
 */


public class CropWindow{
	
	private GameEnvironment game;

	private JFrame frmCrops;
	
	private String farmName;
	private DefaultListModel<Crop> cropListModel = new DefaultListModel<>();
	private JList<Crop> listCrops = new JList<>(cropListModel);
	
	private JScrollPane cropsScroller = new JScrollPane(listCrops);
	
	private DefaultListModel<Item> itemListModel = new DefaultListModel<>();
	private JList<Item> listItems = new JList<>(itemListModel);
	
	private JScrollPane itemsScroller = new JScrollPane(listItems);

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CropWindow window = new CropWindow();
					window.frmCrops.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CropWindow() {
		initialize();
	}
	
	/**
	 * Crop window constructor.
	 * 
	 * @param game			The game environment played on.
	 */
	public CropWindow(GameEnvironment game) {
		this.game = game;
		initialize();
		frmCrops.setVisible(true);
	}
	
	/**
	 * Closes the window after the user has chosen to return to the main screen.
	 */
	public void closeCropWindow() {
		frmCrops.dispose();
	}
	
	/**
	 * Closes the window after the user has chosen to return to the main screen.
	 */
	public void finishedWindow() {
		game.closeCropWindow(this);
	}
	
	/**
	 * Adds crop items to the JList.
	 */
	public void addCropItemsToList() {
		for(Item item: game.getItemsOwnedByFarmer()) {
			if (item instanceof FertiliserOne || item instanceof FertiliserTwo || item instanceof FertiliserThree 
					|| item instanceof Water) {
				itemListModel.addElement(item);
			}
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrops = new JFrame();
		frmCrops.setVisible(true);
		frmCrops.setTitle("Crops");
		frmCrops.setBounds(100, 100, 637, 515);
		frmCrops.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		farmName = game.getFarmName();
		frmCrops.getContentPane().setLayout(null);
		JLabel lblTitle = new JLabel(farmName + " Farm's Crops");
		lblTitle.setBounds(89, 11, 243, 16);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 17));
		frmCrops.getContentPane().add(lblTitle);
		
		JLabel lblChooseCrop = new JLabel("Choose Crop");
		lblChooseCrop.setBounds(58, 39, 100, 16);
		lblChooseCrop.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseCrop.setFont(new Font("Arial", Font.BOLD, 11));
		frmCrops.getContentPane().add(lblChooseCrop);
		
		JLabel lblChooseItem = new JLabel("Choose Item");
		lblChooseItem.setBounds(236, 92, 84, 16);
		lblChooseItem.setFont(new Font("Arial", Font.BOLD, 11));
		lblChooseItem.setHorizontalAlignment(SwingConstants.CENTER);
		frmCrops.getContentPane().add(lblChooseItem);
		
		JButton btnHarvest = new JButton("Harvest Crop");
		btnHarvest.setBounds(236, 297, 141, 29);
		btnHarvest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = game.harvestCrops(listCrops.getSelectedValue());
				if (message.startsWith("Crop harvested")) {
					cropListModel.removeElement(listCrops.getSelectedValue());
				}
				JOptionPane.showMessageDialog(frmCrops, message);
			}
		});
		frmCrops.getContentPane().add(btnHarvest);
		
		JButton btnUseItem = new JButton("Fertilise Crop");
		btnUseItem.setBounds(236, 379, 141, 29);
		btnUseItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Crop crop = listCrops.getSelectedValue();
				Item item = listItems.getSelectedValue();
				String message = game.fertiliseCrop(crop, item);
				JOptionPane.showMessageDialog(frmCrops, message);
				if (message.startsWith("You fertilised") && item.getItemName() != "Water") {
					itemListModel.removeElement(item);
				}
				
				frmCrops.repaint();
			}
			
		});
		frmCrops.getContentPane().add(btnUseItem);
		
		JButton btnBack = new JButton("Back to Home");
		btnBack.setBounds(442, 430, 154, 29);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeCropWindow();
				game.launchMainScreen();
			}
		});
		frmCrops.getContentPane().add(btnBack);
		
		cropListModel.addAll(game.getCropsOwned());
		cropsScroller.setBounds(27, 68, 161, 161);
		frmCrops.getContentPane().add(cropsScroller);
		
		listCrops.setBorder(new LineBorder(new Color(0, 0, 0)));
		listCrops.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCrops.setForeground(Color.WHITE);
		listCrops.setBackground(Color.DARK_GRAY);
		
		addCropItemsToList();
		
		listItems.setBorder(new LineBorder(new Color(0, 0, 0)));
		itemsScroller.setBounds(217, 119, 117, 110);
		frmCrops.getContentPane().add(itemsScroller);
		
		listItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listItems.setForeground(Color.WHITE);
		listItems.setBackground(Color.DARK_GRAY);
		
		JLabel lblHarvestInstructions = new JLabel("Select a Crop from the list above to harvest");
		lblHarvestInstructions.setBounds(133, 269, 326, 16);
		frmCrops.getContentPane().add(lblHarvestInstructions);
		
		JLabel lblFertiliseInstructions = new JLabel("Select an crop to fertilise and an item");
		lblFertiliseInstructions.setBounds(162, 338, 297, 16);
		frmCrops.getContentPane().add(lblFertiliseInstructions);
		
		JLabel lblFertiliseInstructionsTwo = new JLabel("to fertilise with from above");
		lblFertiliseInstructionsTwo.setBounds(206, 352, 226, 16);
		frmCrops.getContentPane().add(lblFertiliseInstructionsTwo);
		
		JLabel lblCropColumnHeads = new JLabel("Field (Crop Type)	Days till harvest");
		lblCropColumnHeads.setBounds(21, 52, 193, 16);
		lblCropColumnHeads.setFont(new Font("Arial", Font.PLAIN, 11));
		frmCrops.getContentPane().add(lblCropColumnHeads);
		
		JLabel cropsIcon = new JLabel("");
		cropsIcon.setIcon(new ImageIcon(CropWindow.class.getResource("/images/crops.jpeg")));
		cropsIcon.setBounds(365, 57, 231, 177);
		frmCrops.getContentPane().add(cropsIcon);
	}
}
