package farmsimulator;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;

/**
 * This is the main window that is the Farm home, this where the user can perform actions on the farm.
 * 
 * @author Ankur Patel, Benjamin Crozier
 * @version 15/05/2020
 */

public class MainScreen {

	private JFrame mainScreen;
	
	private GameEnvironment game;

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.mainScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainScreen() {
		initialize();
	}
	
	/**
	 * Main screen constructor.
	 * 
	 * @param mainGame				The game environment played on.
	 */
	public MainScreen(GameEnvironment mainGame) {
		this.game = mainGame;
		initialize();
		mainScreen.setVisible(true);
	}
	
	/**
	 * Closes the window after the user has chosen another window to open.
	 */
	public void closeMainScreen() {
		mainScreen.dispose();
	}
	
	/**
	 * Closes the window after the user has chosen another window to open.
	 */
	public void finishedWindow() {
		game.closeMainScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainScreen = new JFrame();
		mainScreen.setTitle("Farm Home");
		mainScreen.setBounds(100, 100, 765, 531);
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.getContentPane().setLayout(null);
		
		
		JLabel daysLeftMessage = new JLabel("Days Left:");
		daysLeftMessage.setFont(new Font("Arial", Font.BOLD, 17));
		daysLeftMessage.setBounds(100, 103, 141, 47);
		mainScreen.getContentPane().add(daysLeftMessage);
		
		JLabel daysLeftLabel = new JLabel("");
		daysLeftLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		daysLeftLabel.setBounds(292, 119, 46, 14);
		daysLeftLabel.setText(Integer.toString(game.getGameLength() - game.getFarmer().getDayNum() + 1));
		mainScreen.getContentPane().add(daysLeftLabel);
		
		JLabel farmName = new JLabel("Farm Name:");
		farmName.setFont(new Font("Arial", Font.BOLD, 27));
		farmName.setBounds(160, 11, 212, 68);
		mainScreen.getContentPane().add(farmName);
		
		JLabel farmNameChosen = new JLabel("");
		farmNameChosen.setFont(new Font("Arial", Font.BOLD, 27));
		farmNameChosen.setBounds(352, 30, 364, 31);
		farmNameChosen.setText(game.getFarmName());
		mainScreen.getContentPane().add(farmNameChosen);
		
		JLabel cropGrowthRateMessage = new JLabel("Crop growth rate:");
		cropGrowthRateMessage.setFont(new Font("Arial", Font.BOLD, 17));
		cropGrowthRateMessage.setBounds(434, 147, 170, 47);
		mainScreen.getContentPane().add(cropGrowthRateMessage);
		
		JLabel moneyAvailableMessage = new JLabel("Money available:");
		moneyAvailableMessage.setFont(new Font("Arial", Font.BOLD, 17));
		moneyAvailableMessage.setBounds(434, 103, 170, 47);
		mainScreen.getContentPane().add(moneyAvailableMessage);
		
		JLabel actionsLeftMessage = new JLabel("Actions left in day:");
		actionsLeftMessage.setFont(new Font("Arial", Font.BOLD, 17));
		actionsLeftMessage.setBounds(100, 147, 183, 47);
		mainScreen.getContentPane().add(actionsLeftMessage);
		
		JLabel cropGrowthRate = new JLabel("0");
		cropGrowthRate.setFont(new Font("Arial", Font.PLAIN, 17));
		cropGrowthRate.setBounds(623, 163, 46, 14);
		mainScreen.getContentPane().add(cropGrowthRate);
		
		JLabel moneyAvailable = new JLabel("0");
		moneyAvailable.setFont(new Font("Arial", Font.PLAIN, 17));
		moneyAvailable.setBounds(616, 119, 95, 14);
		String formatMoneyAvailable = String.format("%.2f", game.getFarmMoneyAvailable());
		moneyAvailable.setText("$" + formatMoneyAvailable);
		mainScreen.getContentPane().add(moneyAvailable);
		
		JLabel actionsLeft = new JLabel(String.valueOf(game.getFarmerActionsLeft()));
		actionsLeft.setFont(new Font("Arial", Font.PLAIN, 17));
		actionsLeft.setBounds(292, 163, 46, 14);
		mainScreen.getContentPane().add(actionsLeft);
		
		JButton viewCrops = new JButton("View Crops");
		viewCrops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeMainScreen();
				game.launchCropWindow();
			}
		});
		viewCrops.setBounds(528, 231, 141, 23);
		mainScreen.getContentPane().add(viewCrops);
		
		JButton visitStore = new JButton("Visit Store");
		visitStore.setBounds(356, 321, 141, 23);
		visitStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeMainScreen();
				game.launchStoreWindow();
			}
		});
		mainScreen.getContentPane().add(visitStore);
		
		JButton viewAnimals = new JButton("View Animals");
		viewAnimals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeMainScreen();
				game.launchAnimalWindow();
			}
		});
		viewAnimals.setBounds(356, 231, 139, 23);
		mainScreen.getContentPane().add(viewAnimals);
		
		JButton tendFarm = new JButton("Tend Farm");
		tendFarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = game.tendFarm();
				JOptionPane.showMessageDialog(mainScreen, message);
				actionsLeft.setText(String.valueOf(game.getFarmerActionsLeft()));
			}
		});
		tendFarm.setBounds(530, 321, 139, 23);
		mainScreen.getContentPane().add(tendFarm);
		
		JButton moveToNextDay = new JButton("MOVE TO NEXT DAY");
		moveToNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = game.nextDay();
				int daysLeft = game.getGameLength() - game.getFarmer().getDayNum() + 1;
				if (daysLeft == 0) {
					game.launchFinalScreen();
					closeMainScreen();
					finishedWindow();
				}
				else {
					daysLeftLabel.setText(Integer.toString(daysLeft));
					actionsLeft.setText(String.valueOf(game.getFarmerActionsLeft()));
					JOptionPane.showMessageDialog(mainScreen, message);
					message = game.randomEvent();
					if (message != null) {
						JOptionPane.showMessageDialog(mainScreen, message);
					}
					String formatMoneyAvailable = String.format("%.2f", game.getFarmMoneyAvailable());
					moneyAvailable.setText("$" + formatMoneyAvailable);
				}
			}
		});
		moveToNextDay.setBounds(422, 424, 183, 23);
		mainScreen.getContentPane().add(moveToNextDay);
		
		JLabel mainScreenImage = new JLabel("");
		mainScreenImage.setIcon(new ImageIcon(MainScreen.class.getResource("/images/mainscreenimage.jpeg")));
		mainScreenImage.setBounds(100, 218, 238, 245);
		mainScreen.getContentPane().add(mainScreenImage);
	}
}
