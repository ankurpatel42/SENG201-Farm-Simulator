package farmsimulator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.ListSelectionModel;

public class AnimalWindow {

	private GameEnvironment game;
	
	private JFrame animalsFrame;
	private JComboBox<String> animalSelection;
	private String[] animalOptions = {"Cow", "Pig", "Sheep"};
	DefaultComboBoxModel<String> animalOptionsModel = new DefaultComboBoxModel<String>(animalOptions);
	
	DefaultListModel<Animal> animalListModel = new DefaultListModel<Animal>();
	JList<Animal> animalList = new JList<>(animalListModel);
	
	DefaultListModel<Item> animalFoodListModel = new DefaultListModel<Item>();
	JList<Item> animalFoodList = new JList<>(animalFoodListModel);
	
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
	
	public void closeAnimalWindow() {
		animalsFrame.dispose();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		animalsFrame = new JFrame();
		animalsFrame.setTitle("Animals");
		animalsFrame.setBounds(100, 100, 770, 515);
		animalsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		animalsFrame.getContentPane().setLayout(null);
		
		animalSelection = new JComboBox<>(animalOptionsModel);
		animalSelection.setBounds(70, 96, 144, 22);
		animalsFrame.getContentPane().add(animalSelection);
		
		
		JButton feedAnimalButton = new JButton("Feed Animal");
		feedAnimalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getAnimalsOnFarm().size() == 0) {
					JOptionPane.showMessageDialog(animalsFrame, "There are no Animals on your farm to feed yet, visit the General Store to "
							+ "purchase Animals!");
				}
				else if (animalList.getSelectedValue() == null || animalFoodList.getSelectedValue() == null) {
						JOptionPane.showMessageDialog(animalsFrame, "You must select an Animal and a food item to feed your Animal! "
								+ "Animals and food items are available for purchase at the General Store!");
				}
				else {
					game.feedAnimal(animalList.getSelectedValue(), animalFoodList.getSelectedValue());
					JOptionPane.showMessageDialog(animalsFrame, "You have fed " + animalList.getSelectedValue().getAnimalName() + " " 
							+ animalFoodList.getSelectedValue().getItemName());
					animalsFrame.repaint();
				}
			}
		});
		feedAnimalButton.setBounds(70, 328, 144, 23);
		animalsFrame.getContentPane().add(feedAnimalButton);
		
		JButton playWithAnimalButton = new JButton("Play with Animal");
		playWithAnimalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getAnimalsOnFarm().size() == 0) {
					JOptionPane.showMessageDialog(animalsFrame, "There are no Animals on your farm to play with yet, isit the General Store to purchase Animals!");
				}
				else if (animalList.getSelectedValue() == null) {
					JOptionPane.showMessageDialog(animalsFrame, "Select an animal to play with!");
				}
				else {
					game.playWithAnima(animalList.getSelectedValue());
					JOptionPane.showMessageDialog(animalsFrame, "You played with" + animalList.getSelectedValue().getAnimalName());
					animalsFrame.repaint();
				}
			}
		});
		playWithAnimalButton.setBounds(70, 374, 144, 23);
		animalsFrame.getContentPane().add(playWithAnimalButton);
		
		JButton backToFarmButton = new JButton("Back to Farm");
		backToFarmButton.setBounds(549, 420, 144, 23);
		backToFarmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeAnimalWindow();
				game.launchMainScreen();
			}
		});
		animalsFrame.getContentPane().add(backToFarmButton);
		
		JLabel userFarmNameLabel = new JLabel("");
		userFarmNameLabel.setBounds(205, 11, 132, 32);
		userFarmNameLabel.setText(game.getFarmName());
		animalsFrame.getContentPane().add(userFarmNameLabel);
		
		JLabel animalsLabel = new JLabel("Animals on Farm (pick one to feed or play with!)");
		animalsLabel.setBounds(400, 11, 278, 32);
		animalsFrame.getContentPane().add(animalsLabel);
		
		
		animalListModel.addAll(game.getAnimalsOnFarm());
		
		animalList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		animalList.setForeground(Color.WHITE);
		animalList.setBackground(Color.GRAY);
		animalList.setBounds(372, 72, 321, 316);
		animalsFrame.getContentPane().add(animalList);
		
		JLabel feedAllAnimalsLabel = new JLabel("Feed and play with all Animals of a type!");
		feedAllAnimalsLabel.setBounds(70, 54, 217, 32);
		animalsFrame.getContentPane().add(feedAllAnimalsLabel);
		
		JLabel farmNameLabel = new JLabel("Farm:");
		farmNameLabel.setBounds(152, 11, 62, 32);
		animalsFrame.getContentPane().add(farmNameLabel);
		
		//animal food items owned
		for(Item item: game.getItemsOwnedByFarmer()) {
			if (item instanceof AnimalFoodOne || item instanceof AnimalFoodTwo || item instanceof AnimalFoodThree) {
				animalFoodListModel.addElement(item);
			}
		}
		
		animalFoodList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		animalFoodList.setForeground(Color.WHITE);
		animalFoodList.setBackground(Color.GRAY);
		animalFoodList.setBounds(70, 177, 162, 109);
		animalsFrame.getContentPane().add(animalFoodList);
		
		JLabel animalFoodItemsLabel = new JLabel("Animal Food Items available");
		animalFoodItemsLabel.setBounds(70, 134, 162, 32);
		animalsFrame.getContentPane().add(animalFoodItemsLabel);
		
		JLabel animalDescriptionLabel = new JLabel("Animal name : Animal healthiness : Animal happiness");
		animalDescriptionLabel.setBounds(400, 40, 293, 32);
		animalsFrame.getContentPane().add(animalDescriptionLabel);
	}
}
