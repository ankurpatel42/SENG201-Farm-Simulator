package farmsimulator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnimalWindow {

	private GameEnvironment game;
	
	private JFrame animalsFrame;
	private JComboBox<String> animalSelection;
	private String[] animalOptions = {"Cow", "Pig", "Sheep"};
	private JComboBox<String> animalFoodSelection;
	private String[] animalFoodSelectionOptions = {"Animal Food 1", "Animal Food 2", "Animal Food 3"};
	DefaultComboBoxModel<String> animalOptionsModel = new DefaultComboBoxModel<String>(animalOptions);
	DefaultComboBoxModel<String> animalFoodSelectionOptionsModel = new DefaultComboBoxModel<String>(animalFoodSelectionOptions);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalWindow window = new AnimalWindow();
					window.animalsFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AnimalWindow() {
		initialize();
	}
	
	public AnimalWindow(GameEnvironment mainGame) {
		game = mainGame;
		initialize();
		animalsFrame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		animalsFrame = new JFrame();
		animalsFrame.setTitle("Animals");
		animalsFrame.setBounds(100, 100, 654, 413);
		animalsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		animalsFrame.getContentPane().setLayout(null);
		
		animalSelection = new JComboBox<>(animalOptionsModel);
		animalSelection.setBounds(70, 60, 144, 22);
		animalsFrame.getContentPane().add(animalSelection);
		
		
		animalFoodSelection = new JComboBox<>(animalFoodSelectionOptionsModel);
		animalFoodSelection.setBounds(70, 124, 144, 22);
		animalsFrame.getContentPane().add(animalFoodSelection);
		
		
		JButton feedAnimalButton = new JButton("Feed Animal");
		feedAnimalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getAnimalsOnFarm().size() == 0) {
					JOptionPane.showMessageDialog(animalsFrame, "There are no Animals on your farm to feed yet");
				}
			}
		});
		feedAnimalButton.setBounds(70, 190, 144, 23);
		animalsFrame.getContentPane().add(feedAnimalButton);
		
		JButton playWithAnimalButton = new JButton("Play with Animal");
		playWithAnimalButton.setBounds(70, 252, 144, 23);
		animalsFrame.getContentPane().add(playWithAnimalButton);
		
		JButton backToFarmButton = new JButton("Back to Farm");
		backToFarmButton.setBounds(390, 303, 144, 23);
		animalsFrame.getContentPane().add(backToFarmButton);
		
		JLabel userFarmNameLabel = new JLabel("New label");
		userFarmNameLabel.setBounds(205, 11, 132, 32);
		animalsFrame.getContentPane().add(userFarmNameLabel);
		
		JLabel animalsLabel = new JLabel("Animals");
		animalsLabel.setBounds(402, 11, 132, 32);
		animalsFrame.getContentPane().add(animalsLabel);
	}
}
