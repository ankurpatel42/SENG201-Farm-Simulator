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
	
	public CropWindow(GameEnvironment game) {
		this.game = game;
		initialize();
		frmCrops.setVisible(true);
	}
	
	public void closeCropWindow() {
		frmCrops.dispose();
	}
	
	public void finishedWindow() {
		game.closeCropWindow(this);
	}
	
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
		frmCrops.getContentPane().setLayout(null);
		
		farmName = game.getFarmName();
		JLabel lblTitle = new JLabel(farmName + " Farm's Crops");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 17));
		lblTitle.setBounds(89, 11, 209, 16);
		frmCrops.getContentPane().add(lblTitle);
		
		JLabel lblChooseCrop = new JLabel("Choose Crop");
		lblChooseCrop.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseCrop.setFont(new Font("Arial", Font.BOLD, 11));
		lblChooseCrop.setBounds(60, 41, 100, 16);
		frmCrops.getContentPane().add(lblChooseCrop);
		
		JLabel lblChooseItem = new JLabel("Choose Item");
		lblChooseItem.setFont(new Font("Arial", Font.BOLD, 11));
		lblChooseItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseItem.setBounds(236, 92, 84, 16);
		frmCrops.getContentPane().add(lblChooseItem);
		
		JButton btnHarvest = new JButton("Harvest Crop");
		btnHarvest.setBounds(27, 253, 117, 29);
		btnHarvest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listCrops.getSelectedValue() == null) {
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
		btnUseItem.setBounds(27, 306, 117, 29);
		btnUseItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Crop crop = listCrops.getSelectedValue();
				Item item = listItems.getSelectedValue();
				if (crop == null) {
					if (item == null) {
						JOptionPane.showMessageDialog(frmCrops, "Select a crop to Fertilise and Fertiliser to use!");
					}
					JOptionPane.showMessageDialog(frmCrops, "Select a crop to Fertilise!");
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
		btnBack.setBounds(217, 358, 117, 29);
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
	}
}
