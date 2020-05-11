package farmsimulator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MainScreen {

	private JFrame mainScreen;
	private GameEnvironment mainGame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					GameEnvironment mainGame = new GameEnvironment();
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
	
	public MainScreen(GameEnvironment mainGame) {
		this.mainGame = mainGame;
		initialize();
		mainScreen.setVisible(true);
	}
	
	public void closeMainScreen() {
		mainScreen.dispose();
	}
	
	public void finishedWindow() {
		mainGame.closeMainScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainScreen = new JFrame();
		mainScreen.setTitle("Farm Home");
		mainScreen.setBounds(100, 100, 770, 515);
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.getContentPane().setLayout(null);
		
		
		JLabel daysLeftMessage = new JLabel("Days Left:");
		daysLeftMessage.setFont(new Font("Arial", Font.PLAIN, 17));
		daysLeftMessage.setBounds(115, 103, 90, 47);
		mainScreen.getContentPane().add(daysLeftMessage);
		
		JLabel gameLengthChosen = new JLabel("");
		gameLengthChosen.setFont(new Font("Arial", Font.PLAIN, 17));
		gameLengthChosen.setBounds(266, 119, 46, 14);
		gameLengthChosen.setText(Integer.toString(mainGame.getGameLength()));
		mainScreen.getContentPane().add(gameLengthChosen);
		
		JLabel farmName = new JLabel("Farm Name:");
		farmName.setFont(new Font("Arial", Font.BOLD, 23));
		farmName.setBounds(231, 11, 141, 41);
		mainScreen.getContentPane().add(farmName);
		
		JLabel farmNameChosen = new JLabel("");
		farmNameChosen.setFont(new Font("Arial", Font.BOLD, 23));
		farmNameChosen.setBounds(370, 16, 212, 31);
		farmNameChosen.setText(mainGame.getFarmName());
		mainScreen.getContentPane().add(farmNameChosen);
		
		JLabel cropGrowthRateMessage = new JLabel("Crop growth rate:");
		cropGrowthRateMessage.setFont(new Font("Arial", Font.PLAIN, 17));
		cropGrowthRateMessage.setBounds(434, 147, 148, 47);
		mainScreen.getContentPane().add(cropGrowthRateMessage);
		
		JLabel moneyAvailableMessage = new JLabel("Money available:");
		moneyAvailableMessage.setFont(new Font("Arial", Font.PLAIN, 17));
		moneyAvailableMessage.setBounds(434, 103, 148, 47);
		mainScreen.getContentPane().add(moneyAvailableMessage);
		
		JLabel actionsLeftMessage = new JLabel("Actions left in day:");
		actionsLeftMessage.setFont(new Font("Arial", Font.PLAIN, 17));
		actionsLeftMessage.setBounds(115, 147, 148, 47);
		mainScreen.getContentPane().add(actionsLeftMessage);
		
		JLabel cropGrowthRate = new JLabel("0");
		cropGrowthRate.setFont(new Font("Arial", Font.PLAIN, 17));
		cropGrowthRate.setBounds(592, 163, 46, 14);
		cropGrowthRate.setText(Double.toString(mainGame.getFarmCropGrowthRate()));
		mainScreen.getContentPane().add(cropGrowthRate);
		
		JLabel moneyAvailable = new JLabel("0");
		moneyAvailable.setFont(new Font("Arial", Font.PLAIN, 17));
		moneyAvailable.setBounds(592, 119, 95, 14);
		String formatMoneyAvailable = String.format("%.2f", mainGame.getFarmMoneyAvailable());
		moneyAvailable.setText("$" + formatMoneyAvailable);
		mainScreen.getContentPane().add(moneyAvailable);
		
		JLabel actionsLeft = new JLabel("2");
		actionsLeft.setFont(new Font("Arial", Font.PLAIN, 17));
		actionsLeft.setBounds(266, 163, 46, 14);
		mainScreen.getContentPane().add(actionsLeft);
		
		JButton viewCrops = new JButton("View Crops");
		viewCrops.setBounds(165, 242, 118, 23);
		mainScreen.getContentPane().add(viewCrops);
		
		JButton visitStore = new JButton("Visit Store");
		visitStore.setBounds(165, 321, 123, 23);
		mainScreen.getContentPane().add(visitStore);
		
		JButton viewAnimals = new JButton("View Animals");
		viewAnimals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeMainScreen();
				finishedWindow();
			}
		});
		viewAnimals.setBounds(469, 242, 118, 23);
		mainScreen.getContentPane().add(viewAnimals);
		
		JButton tendFarm = new JButton("Tend Farm");
		tendFarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainGame.getFarmerActionsLeft() != 0) {
					mainGame.tendFarm(mainGame);
					actionsLeft.setText(Integer.toString(mainGame.getFarmerActionsLeft()));
				}
				else {
					JOptionPane.showMessageDialog(mainScreen, "You cannot perform this action as you have no actions left for today.");
				}
			}
		});
		tendFarm.setBounds(469, 321, 118, 23);
		mainScreen.getContentPane().add(tendFarm);
		
		JButton moveToNextDay = new JButton("MOVE TO NEXT DAY");
		moveToNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		moveToNextDay.setBounds(265, 395, 157, 23);
		mainScreen.getContentPane().add(moveToNextDay);
	}
	
}
