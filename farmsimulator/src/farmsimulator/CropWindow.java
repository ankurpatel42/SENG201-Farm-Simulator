package farmsimulator;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class CropWindow{
	
	private GameEnvironment game;

	private JFrame frmCrops;
	
	private Crop cropSelected;
	private Item itemSelected;
	private String farmName;
	DefaultListModel<Crop> cropListModel = new DefaultListModel<>();
	JList<Crop> listCrops = new JList<>(cropListModel);
	DefaultListModel<Item> itemListModel = new DefaultListModel<>();
	JList<Item> listItems = new JList<>(itemListModel);

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrops = new JFrame();
		frmCrops.setVisible(true);
		frmCrops.setTitle("Crops");
		frmCrops.setBounds(100, 100, 770, 515);
		frmCrops.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrops.getContentPane().setLayout(null);
		
		farmName = game.getFarmName();
		JLabel lblTitle = new JLabel(farmName);
		lblTitle.setBounds(150, 6, 161, 16);
		frmCrops.getContentPane().add(lblTitle);
		
		JLabel lblChooseCrop = new JLabel("Choose Crop");
		lblChooseCrop.setBounds(41, 42, 100, 16);
		frmCrops.getContentPane().add(lblChooseCrop);
		
		JLabel lblChooseItem = new JLabel("Choose Item");
		lblChooseItem.setBounds(280, 42, 103, 16);
		frmCrops.getContentPane().add(lblChooseItem);
		
		JButton btnHarvest = new JButton("Harvest Crop");
		btnHarvest.setBounds(27, 190, 117, 29);
		btnHarvest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listCrops.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(frmCrops, "Select an crop to harvest!");
				}
				else {
					Crop crop = listCrops.getSelectedValue();
					String message = game.harvestCrops(crop);
					JOptionPane.showMessageDialog(frmCrops, message);
				}
			}
		});
		frmCrops.getContentPane().add(btnHarvest);
		
		JButton btnUseItem = new JButton("Use Item");
		btnUseItem.setBounds(280, 190, 117, 29);
		btnUseItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//cropSelected = (Crop)comboBoxCrop.getSelectedItem();
				//itemSelected = (Item)comboBoxItem.getSelectedItem();
				//cropSelected.tendCrops(itemSelected);
				//Give user a message
			}
		});
		frmCrops.getContentPane().add(btnUseItem);
		
		JButton btnBack = new JButton("Back to Farm");
		btnBack.setBounds(162, 232, 117, 29);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeCropWindow();
				game.launchMainScreen();
			}
		});
		frmCrops.getContentPane().add(btnBack);
		
		cropListModel.addAll(game.getCropsOwned());
		listCrops.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCrops.setForeground(Color.WHITE);
		listCrops.setBackground(Color.GRAY);
		listCrops.setBounds(27, 68, 114, 110);
		frmCrops.getContentPane().add(listCrops);
		
		
		//animal food items owned
		for(Item item: game.getItemsOwnedByFarmer()) {
			if (item instanceof FertiliserOne || item instanceof FertiliserTwo || item instanceof FertiliserThree) {
				itemListModel.addElement(item);
			}
		}

		listItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listItems.setForeground(Color.WHITE);
		listItems.setBackground(Color.GRAY);
		listItems.setBounds(255, 68, 117, 110);
		frmCrops.getContentPane().add(listItems);
	}
}
