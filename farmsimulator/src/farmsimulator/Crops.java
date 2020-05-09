package farmsimulator;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Crops {

	private JFrame frmCrops;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crops window = new Crops();
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
	public Crops() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrops = new JFrame();
		frmCrops.setTitle("Crops");
		frmCrops.setBounds(100, 100, 450, 300);
		frmCrops.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrops.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("FarmName's Crops");
		lblTitle.setBounds(150, 6, 161, 16);
		frmCrops.getContentPane().add(lblTitle);
		
		JLabel lblListTitle = new JLabel("List of Crops");
		lblListTitle.setBounds(287, 34, 95, 16);
		frmCrops.getContentPane().add(lblListTitle);
		
		JComboBox comboBoxCrop = new JComboBox();
		comboBoxCrop.setBounds(29, 70, 126, 27);
		frmCrops.getContentPane().add(comboBoxCrop);
		
		JLabel lblChooseCrop = new JLabel("Choose Crop");
		lblChooseCrop.setBounds(41, 42, 100, 16);
		frmCrops.getContentPane().add(lblChooseCrop);
		
		JLabel lblChooseItem = new JLabel("Choose Item");
		lblChooseItem.setBounds(41, 152, 103, 16);
		frmCrops.getContentPane().add(lblChooseItem);
		
		JComboBox comboBoxItem = new JComboBox();
		comboBoxItem.setBounds(29, 180, 126, 27);
		frmCrops.getContentPane().add(comboBoxItem);
		
		JButton btnHarvest = new JButton("Harvest Crop");
		btnHarvest.setBounds(29, 109, 117, 29);
		frmCrops.getContentPane().add(btnHarvest);
		
		JButton btnUseItem = new JButton("Use Item");
		btnUseItem.setBounds(29, 219, 117, 29);
		frmCrops.getContentPane().add(btnUseItem);
		
		JButton btnBack = new JButton("Back to Farm");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCrops.dispose();
				//FarmGUI f = new FarmGui();
			}
		});
		btnBack.setBounds(265, 219, 117, 29);
		frmCrops.getContentPane().add(btnBack);
	}

}
