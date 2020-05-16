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
	DefaultListModel<Crop> cropListModel = new DefaultListModel<>();
	JList<Crop> listCrops = new JList<>(cropListModel);
	
	private JScrollPane cropsScroller = new JScrollPane(listCrops);
	
	DefaultListModel<Item> itemListModel = new DefaultListModel<>();
	JList<Item> listItems = new JList<>(itemListModel);
	
	private JScrollPane itemsScroller = new JScrollPane(listItems);

	/**
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
	 * @param mainGame				The game environment played on.
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
		frmCrops.setBounds(100, 100, 399, 462);
		frmCrops.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		farmName = game.getFarmName();
		frmCrops.getContentPane().setLayout(null);
		JLabel lblTitle = new JLabel(farmName + " Farm's Crops");
		lblTitle.setBounds(89, 11, 209, 16);
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
		btnHarvest.setBounds(139, 280, 117, 29);
		btnHarvest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getCropsOwned().size() == 0) {
					JOptionPane.showMessageDialog(frmCrops, "There are no crops on your farm yet, visit the General Store to buy them!");
				}
				else if (listCrops.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(frmCrops, "Select an crop to harvest!");
				}
				else {
					Crop crop = listCrops.getSelectedValue();
					String message = game.harvestCrops(crop);
					if (message.startsWith("Crop harvested")) {
						cropListModel.removeElement(crop);
					}
					JOptionPane.showMessageDialog(frmCrops, message);
				}
			}
		});
		frmCrops.getContentPane().add(btnHarvest);
		
		JButton btnUseItem = new JButton("Fertilise Crop");
		btnUseItem.setBounds(139, 358, 117, 29);
		btnUseItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Crop crop = listCrops.getSelectedValue();
				Item item = listItems.getSelectedValue();
				if (game.getCropsOwned().size() == 0) {
					JOptionPane.showMessageDialog(frmCrops, "There are no crops on your farm yet, visit the General Store to buy them!");
				}
				else if (crop == null) {
						JOptionPane.showMessageDialog(frmCrops, "Select a crop to Fertilise and Fertiliser to use!");
				}
				else {
					if (item == null) {
						JOptionPane.showMessageDialog(frmCrops, "Select a Fertiliser to use!");
					}
					else {
						String message = game.fertiliseCrop(crop, item);
						if (message.startsWith("You fertilised") & item.getItemName() != "Water") {
							itemListModel.removeElement(item);
						}
						JOptionPane.showMessageDialog(frmCrops, message);
					}
				}
			}
		});
		frmCrops.getContentPane().add(btnUseItem);
		
		JButton btnBack = new JButton("Back to Home");
		btnBack.setBounds(254, 390, 117, 29);
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
		
		//Crop items owned
		addCropItemsToList();
		
		listItems.setBorder(new LineBorder(new Color(0, 0, 0)));
		itemsScroller.setBounds(217, 119, 117, 110);
		frmCrops.getContentPane().add(itemsScroller);
		
		listItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listItems.setForeground(Color.WHITE);
		listItems.setBackground(Color.DARK_GRAY);
		
		JLabel lblHarvestInstructions = new JLabel("Select a Crop from the list above to harvest");
		lblHarvestInstructions.setBounds(49, 252, 280, 16);
		frmCrops.getContentPane().add(lblHarvestInstructions);
		
		JLabel lblFertiliseInstructions = new JLabel("Select an crop to fertilise and an item");
		lblFertiliseInstructions.setBounds(66, 313, 243, 16);
		frmCrops.getContentPane().add(lblFertiliseInstructions);
		
		JLabel lblFertiliseInstructionsTwo = new JLabel("to fertilise with from above");
		lblFertiliseInstructionsTwo.setBounds(106, 330, 185, 16);
		frmCrops.getContentPane().add(lblFertiliseInstructionsTwo);
		
		JLabel lblCropColumnHeads = new JLabel("Field (Crop Type)	Days till harvest");
		lblCropColumnHeads.setBounds(21, 52, 193, 16);
		lblCropColumnHeads.setFont(new Font("Arial", Font.PLAIN, 11));
		frmCrops.getContentPane().add(lblCropColumnHeads);
	}
}
