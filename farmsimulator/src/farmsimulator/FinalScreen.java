package farmsimulator;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This is the final screen which displays the users statistics after the game has ended.
 * 
 * @author Ankur Patel, Benjamin Crozier
 * @version 15/05/2020
 */


public class FinalScreen {

	private JFrame finalScreenFrame;
	private GameEnvironment game;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalScreen window = new FinalScreen();
					window.finalScreenFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FinalScreen() {
		initialize();
	}
	
	/**
	 * Final screen constructor.
	 * 
	 * @param game			The game environment played on.
	 */
	public FinalScreen(GameEnvironment game) {
		this.game = game;
		initialize();
		finalScreenFrame.setVisible(true);
	}
	
	/**
	 * Closes the window after the user has chosen to play the game again.
	 */
	public void closeFinalScreen() {
		finalScreenFrame.dispose();
	}
	
	/**
	 * Closes the window after the user has chosen to play the game again.
	 */
	public void finishedWindow() {
		game.closeFinalScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		finalScreenFrame = new JFrame();
		finalScreenFrame.setBounds(100, 100, 599, 407);
		finalScreenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		finalScreenFrame.getContentPane().setLayout(null);
		
		JLabel lblfarmName = new JLabel("Farm Name :");
		lblfarmName.setBounds(37, 39, 171, 72);
		lblfarmName.setFont(new Font("Arial", Font.BOLD, 18));
		finalScreenFrame.getContentPane().add(lblfarmName);
		
		JLabel lbluserFarmName = new JLabel("New label");
		lbluserFarmName.setBounds(173, 54, 287, 44);
		lbluserFarmName.setFont(new Font("Arial", Font.BOLD, 18));
		lbluserFarmName.setText(game.getFarmName());
		finalScreenFrame.getContentPane().add(lbluserFarmName);
		
		JLabel lblgameOverMessage = new JLabel("YOUR FARM JOURNEY IS OVER!");
		lblgameOverMessage.setBounds(97, 11, 420, 44);
		lblgameOverMessage.setFont(new Font("Arial", Font.BOLD, 24));
		finalScreenFrame.getContentPane().add(lblgameOverMessage);
		
		JLabel lblgameDurationMessage = new JLabel("Days your journey lasted :");
		lblgameDurationMessage.setBounds(37, 81, 275, 72);
		lblgameDurationMessage.setFont(new Font("Arial", Font.BOLD, 18));
		finalScreenFrame.getContentPane().add(lblgameDurationMessage);
		
		JLabel lblnumberOfCropsMessage = new JLabel("Number of Crops : ");
		lblnumberOfCropsMessage.setBounds(37, 135, 228, 72);
		lblnumberOfCropsMessage.setFont(new Font("Arial", Font.BOLD, 18));
		finalScreenFrame.getContentPane().add(lblnumberOfCropsMessage);
		
		JLabel lblnumberOfAnimalsMessage = new JLabel("Number of Animals : ");
		lblnumberOfAnimalsMessage.setBounds(37, 179, 228, 72);
		lblnumberOfAnimalsMessage.setFont(new Font("Arial", Font.BOLD, 18));
		finalScreenFrame.getContentPane().add(lblnumberOfAnimalsMessage);
		
		JLabel animalStatusMessage = new JLabel("Overall Animal Status :");
		animalStatusMessage.setBounds(37, 231, 228, 72);
		animalStatusMessage.setFont(new Font("Arial", Font.BOLD, 18));
		finalScreenFrame.getContentPane().add(animalStatusMessage);
		
		JLabel lbldaysLasted = new JLabel("New label");
		lbldaysLasted.setBounds(297, 106, 91, 24);
		lbldaysLasted.setFont(new Font("Arial", Font.BOLD, 14));
		lbldaysLasted.setText(Integer.toString(game.getGameLength()));
		finalScreenFrame.getContentPane().add(lbldaysLasted);
		
		JLabel lblnumberOfCrops = new JLabel("New label");
		lblnumberOfCrops.setBounds(297, 160, 91, 24);
		lblnumberOfCrops.setFont(new Font("Arial", Font.BOLD, 14));
		lblnumberOfCrops.setText(Integer.toString(game.getCropsOwned().size()));
		finalScreenFrame.getContentPane().add(lblnumberOfCrops);
		
		JLabel lblNumberOfAnimals = new JLabel("New label");
		lblNumberOfAnimals.setBounds(297, 204, 91, 24);
		lblNumberOfAnimals.setFont(new Font("Arial", Font.BOLD, 14));
		lblNumberOfAnimals.setText(Integer.toString(game.getAnimalsOnFarm().size()));
		finalScreenFrame.getContentPane().add(lblNumberOfAnimals);
		
		JLabel lblAnimalStatus = new JLabel("New label");
		lblAnimalStatus.setBounds(297, 256, 91, 24);
		lblAnimalStatus.setFont(new Font("Arial", Font.BOLD, 14));
		lblAnimalStatus.setText(Double.toString(game.getFinalAnimalStatus()));
		finalScreenFrame.getContentPane().add(lblAnimalStatus);
		
		JLabel labelMoneyEarned = new JLabel("Money earned :");
		labelMoneyEarned.setBounds(37, 285, 228, 72);
		labelMoneyEarned.setFont(new Font("Arial", Font.BOLD, 18));
		finalScreenFrame.getContentPane().add(labelMoneyEarned);
		
		JLabel moneyEarned = new JLabel("$ 0.00");
		moneyEarned.setBounds(297, 310, 91, 24);
		moneyEarned.setFont(new Font("Arial", Font.BOLD, 14));
		String finalMoney = String.format("%.2f", game.getFarmMoneyAvailable());
		moneyEarned.setText("$ " + finalMoney);
		finalScreenFrame.getContentPane().add(moneyEarned);
		
		JButton reStartGame = new JButton("Click to play again");
		reStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeFinalScreen();
				finishedWindow();
				game.launchSetUpScreen();
			}
		});
		reStartGame.setBounds(409, 334, 137, 23);
		finalScreenFrame.getContentPane().add(reStartGame);
	}
}
