package farmsimulator;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class CropWindow{
	
	private GameEnvironment game;

	private JFrame frmCrops;
	
	private Crop cropSelected;
	private Item itemSelected;
	private ArrayList<Item> items; //Items Owned
	//DefaultComboBoxModel<Item> itemsCombo = new DefaultComboBoxModel<Item>(items);
	private String[] crops = {"Yet to be Done"}; //Crops Owned
	DefaultComboBoxModel<String> cropsCombo = new DefaultComboBoxModel<String>(crops);
	

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
		frmCrops.setBounds(100, 100, 450, 300);
		frmCrops.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrops.getContentPane().setLayout(null);
		
		//farm = GameEnvironment.getFarm();
		JLabel lblTitle = new JLabel("farm.getFarmName()");
		lblTitle.setBounds(150, 6, 161, 16);
		frmCrops.getContentPane().add(lblTitle);
		
		JLabel lblListTitle = new JLabel("List of Crops");
		lblListTitle.setBounds(287, 34, 95, 16);
		frmCrops.getContentPane().add(lblListTitle);
		
		JComboBox<String> comboBoxCrop = new JComboBox<>(cropsCombo);
		comboBoxCrop.setBounds(29, 70, 126, 27);
		frmCrops.getContentPane().add(comboBoxCrop);
		
		JLabel lblChooseCrop = new JLabel("Choose Crop");
		lblChooseCrop.setBounds(41, 42, 100, 16);
		frmCrops.getContentPane().add(lblChooseCrop);
		
		JLabel lblChooseItem = new JLabel("Choose Item");
		lblChooseItem.setBounds(41, 152, 103, 16);
		frmCrops.getContentPane().add(lblChooseItem);
		
		/*
		items = game.getFarm().getItemsOwned();
		//NotSure
		JComboBox<String> comboBoxItem = new JComboBox<>(items);
		//comboBoxItem.setModel(new DefaultComboBoxModel<Item>());
		comboBoxItem.setBounds(29, 180, 126, 27);
		frmCrops.getContentPane().add(comboBoxItem);
		*/
		
		JButton btnHarvest = new JButton("Harvest Crop");
		btnHarvest.setBounds(29, 109, 117, 29);
		btnHarvest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cropSelected = (Crop)comboBoxCrop.getSelectedItem();
				//cropSelected.harvestCrops();
				//Give user a message
			}
		});
		frmCrops.getContentPane().add(btnHarvest);
		
		JButton btnUseItem = new JButton("Use Item");
		btnUseItem.setBounds(29, 219, 117, 29);
		btnUseItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cropSelected = (Crop)comboBoxCrop.getSelectedItem();
				//itemSelected = (Item)comboBoxItem.getSelectedItem();
				//cropSelected.tendCrops(itemSelected);
				//Give user a message
			}
		});
		frmCrops.getContentPane().add(btnUseItem);
		
		JButton btnBack = new JButton("Back to Farm");
		btnBack.setBounds(265, 219, 117, 29);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeCropWindow();
				game.launchMainScreen();
			}
		});
		frmCrops.getContentPane().add(btnBack);
	}
}
