package farmsimulator;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SwingConstants;

/**
 * This is the setup window where the user enters their farm name, farmer name, type of farm to play on and game length.
 * 
 * @author Ankur Patel, Benjamin Crozier
 * @version 15/05/2020
 */


public class SetUpScreen {
	
	private GameEnvironment game;

	private JFrame setUpScreenFrame;
	private JLabel enterFarmerNameMessage;
	private JTextField userFarmerName;
	private JLabel enterFarmNameMessage;
	private JTextField userFarmName;
	private JLabel selectGameLengthMessage;
	private JSlider chooseGameLength;
	private JLabel chooseAFarmLabel;
	private JTextPane farmChoiceDescriptionOne;
	private JTextPane farmChoiceDescriptionTwo;
	private JTextPane farmChoiceDescriptionThree;
	private JTextPane farmChoiceDescriptionFour;
	private JComboBox<String> farmSelection;
	private String[] farmOptions = {"Farm A", "Farm B", "Farm C", "Farm D"};
	private DefaultComboBoxModel<String> farmOptionsModel = new DefaultComboBoxModel<String>(farmOptions);
	private JButton beginGameButton;

	/*
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetUpScreen window = new SetUpScreen();
					window.setUpScreenFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetUpScreen() {
		initialize();
	}
	
	/**
	 * SetUpScreen constructor.
	 * 
	 * @param startGame 		The game environment played on.
	 */
	public SetUpScreen(GameEnvironment startGame) {
		this.game = startGame;
		initialize();
		setUpScreenFrame.setVisible(true);
	}
	
	/**
	 * Closes the window after the user has started the main game.
	 */
	public void closeSetUpScreen() {
		setUpScreenFrame.dispose();
	}
	
	/**
	 * Closes the window after the user has started the main game.
	 */
	public void finishedWindow() {
		game.closeSetUpScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setUpScreenFrame = new JFrame();
		setUpScreenFrame.setTitle("Farm Simulator Game");
		setUpScreenFrame.setBounds(100, 100, 770, 515);
		setUpScreenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUpScreenFrame.getContentPane().setLayout(null);
		
		/* Display game title */
		JLabel gameTitle = new JLabel("Farm Game!");
		gameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		gameTitle.setFont(new Font("Arial", Font.BOLD, 28));
		gameTitle.setBounds(262, 11, 192, 46);
		setUpScreenFrame.getContentPane().add(gameTitle);
		
		/* Message that asks that user to enter their chosen farmer name */
		enterFarmerNameMessage = new JLabel("Give your farmer a name:");
		enterFarmerNameMessage.setBounds(63, 70, 149, 17);
		setUpScreenFrame.getContentPane().add(enterFarmerNameMessage);
		
		/* Text Field where user inputs their farmer name */
		userFarmerName = new JTextField();
		userFarmerName.setBounds(284, 68, 192, 20);
		setUpScreenFrame.getContentPane().add(userFarmerName);
		userFarmerName.setColumns(10);
		
		/* Message that asks that user to enter their chosen farm name */
		enterFarmNameMessage = new JLabel("Give your farm a name:");
		enterFarmNameMessage.setBounds(63, 110, 149, 17);
		setUpScreenFrame.getContentPane().add(enterFarmNameMessage);
		
		/* Text Field where user inputs their farm name */
		userFarmName = new JTextField();
		userFarmName.setColumns(10);
		userFarmName.setBounds(284, 108, 192, 20);
		setUpScreenFrame.getContentPane().add(userFarmName);
		
		/* Message that asks the user to enter the number of days they want the game to last (game length) */
		selectGameLengthMessage = new JLabel("Select number of days:");
		selectGameLengthMessage.setBounds(63, 161, 149, 17);
		setUpScreenFrame.getContentPane().add(selectGameLengthMessage);
		
		/* Slider so users select the number of days the game is to last, users are only able to choose distinct values 5,6,7,8,9 
		 * or 10 days, stops the user from entering invalid data for the game length */
		chooseGameLength = new JSlider();
		chooseGameLength.setMajorTickSpacing(1);
		chooseGameLength.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				game.setGameLength(chooseGameLength.getValue());
			}
		});
		
		
		chooseGameLength.setPaintLabels(true);
		chooseGameLength.setPaintTicks(true);
		chooseGameLength.setValue(0);
		chooseGameLength.setSnapToTicks(true);
		chooseGameLength.setMaximum(10);
		chooseGameLength.setMinimum(5);
		chooseGameLength.setBounds(281, 150, 200, 55);
		setUpScreenFrame.getContentPane().add(chooseGameLength);
		
		/* Message that asks which Farm the user wants to work with, selected by picking an option in from the dropbox */
		chooseAFarmLabel = new JLabel("Choose a Farm!");
		chooseAFarmLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chooseAFarmLabel.setFont(new Font("Arial", Font.BOLD, 18));
		chooseAFarmLabel.setBounds(302, 216, 142, 24);
		setUpScreenFrame.getContentPane().add(chooseAFarmLabel);
		
		/* Description Text of First Farm, the user is able to see what attributes each farm has before making a selection */
		farmChoiceDescriptionOne = new JTextPane();
		farmChoiceDescriptionOne.setEditable(false);
		farmChoiceDescriptionOne.setBackground(Color.LIGHT_GRAY);
		farmChoiceDescriptionOne.setText("Farm A\r\n\r\nMoney Available: $1000\r\nCrop Growth Rate: 2\r\nAnimal Healthiness: 5\r\nAnimal Happiness: 3");
		farmChoiceDescriptionOne.setBounds(63, 253, 142, 116);
		setUpScreenFrame.getContentPane().add(farmChoiceDescriptionOne);
		
		/* Description Text of Second Farm, the user is able to see what attributes each farm has before making a selection */
		farmChoiceDescriptionTwo = new JTextPane();
		farmChoiceDescriptionTwo.setEditable(false);
		farmChoiceDescriptionTwo.setText("Farm B\r\n\r\nMoney Available: $600\r\nCrop Growth Rate: 1\r\nAnimal Healthiness: 5\r\nAnimal Happiness: 9");
		farmChoiceDescriptionTwo.setBackground(Color.LIGHT_GRAY);
		farmChoiceDescriptionTwo.setBounds(222, 251, 142, 116);
		setUpScreenFrame.getContentPane().add(farmChoiceDescriptionTwo);
		
		/* Description Text of Third Farm, the user is able to see what attributes each farm has before making a selection */
		farmChoiceDescriptionThree = new JTextPane();
		farmChoiceDescriptionThree.setEditable(false);
		farmChoiceDescriptionThree.setText("Farm C\r\n\r\nMoney Available: $300\r\nCrop Growth Rate: 7\r\nAnimal Healthiness: 8\r\nAnimal Happiness: 9");
		farmChoiceDescriptionThree.setBackground(Color.LIGHT_GRAY);
		farmChoiceDescriptionThree.setBounds(381, 251, 142, 116);
		setUpScreenFrame.getContentPane().add(farmChoiceDescriptionThree);
		
		/* Description Text of Fourth Farm, the user is able to see what attributes each farm has before making a selection */
		farmChoiceDescriptionFour = new JTextPane();
		farmChoiceDescriptionFour.setEditable(false);
		farmChoiceDescriptionFour.setText("Farm D\r\n\r\nMoney Available: $650\r\nCrop Growth Rate: 6\r\nAnimal Healthiness: 7\r\nAnimal Happiness: 6");
		farmChoiceDescriptionFour.setBackground(Color.LIGHT_GRAY);
		farmChoiceDescriptionFour.setBounds(540, 253, 142, 116);
		setUpScreenFrame.getContentPane().add(farmChoiceDescriptionFour);
		
		farmSelection = new JComboBox<>(farmOptionsModel);
		farmSelection.setBounds(104, 405, 121, 22);
		setUpScreenFrame.getContentPane().add(farmSelection);
		
		/* Once the user clicks the start button the main game will start, the farmer and the chosen farm will be instantiated,
		 *  if the input they have entered is not valid then an error message pops up */
		beginGameButton = new JButton("Start");
		beginGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String farmerNameChosen = userFarmerName.getText();
				String farmNameChosen = userFarmName.getText();
				if (game.userInputValid(farmerNameChosen) == false) {
					JOptionPane.showMessageDialog(setUpScreenFrame, "Your FARMER name must contain between 3 and 15 characters (inclusive) and not contain any numbers or special characters!");
				}
				else if (game.userInputValid(farmNameChosen) == false ) {
					JOptionPane.showMessageDialog(setUpScreenFrame, "Your FARM name must contain between 3 and 15 characters (inclusive) and not contain any numbers or special characters!");
				}
				else {
					game.setFarmer(farmerNameChosen);
					String farmChosen = (String)farmSelection.getSelectedItem(); //Cast from object to String
					switch(farmChosen) {
						case "Farm A":
							game.createFarm(farmNameChosen, 1000, 2, 5, 3);
							break;
						case "Farm B":
							game.createFarm(farmNameChosen, 600, 1, 5, 9);
							break;
						case "Farm C":
							game.createFarm(farmNameChosen, 300, 7, 8, 9);
							break;
						case "Farm D":
							game.createFarm(farmNameChosen, 650, 6, 7, 6);
							break;
					}
					
					game.createGeneralStore();
					Water water = new Water();
					game.addItemsOwnedByFarmer(water);
					closeSetUpScreen();
					finishedWindow();
					
				}
			}
		});
		beginGameButton.setBounds(365, 405, 89, 23);
		setUpScreenFrame.getContentPane().add(beginGameButton);
	}
	
}
