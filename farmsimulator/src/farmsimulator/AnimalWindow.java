package farmsimulator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class AnimalWindow {

	private GameEnvironment game;
	
	private JFrame animalsFrame;
	
	private DefaultListModel<Animal> animalListModel = new DefaultListModel<Animal>();
	private JList<Animal> animalList = new JList<>(animalListModel);
	
	private JScrollPane animalScroller = new JScrollPane(animalList);
	
	private DefaultListModel<Item> animalFoodListModel = new DefaultListModel<Item>();
	private JList<Item> animalFoodList = new JList<>(animalFoodListModel);
	
	private JScrollPane animalFoodScroller = new JScrollPane(animalFoodList);
	
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
	
	public void finishedWindow() {
		game.closeAnimalWindow(this);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		animalsFrame = new JFrame();
		animalsFrame.setTitle("Animals");
		animalsFrame.setBounds(100, 100, 612, 413);
		animalsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		animalsFrame.getContentPane().setLayout(null);
		
		
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
					String message = game.feedAnimal(animalList.getSelectedValue(), animalFoodList.getSelectedValue());
					if (message.startsWith("You have fed")) {
						animalFoodListModel.removeElement(animalFoodList.getSelectedValue());
					}
					JOptionPane.showMessageDialog(animalsFrame, message);
					animalsFrame.repaint();
				}
			}
		});
		feedAnimalButton.setBounds(70, 202, 162, 23);
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
					String message = game.playWithAnimal(animalList.getSelectedValue());
					JOptionPane.showMessageDialog(animalsFrame, message);
					animalsFrame.repaint();
				}
			}
		});
		playWithAnimalButton.setBounds(70, 243, 162, 23);
		animalsFrame.getContentPane().add(playWithAnimalButton);
		
		JButton backToFarmButton = new JButton("Back to Home");
		backToFarmButton.setBounds(312, 326, 144, 23);
		backToFarmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeAnimalWindow();
				finishedWindow();
				game.launchMainScreen();
			}
		});
		animalsFrame.getContentPane().add(backToFarmButton);
		
		JLabel userFarmNameLabel = new JLabel("");
		userFarmNameLabel.setFont(new Font("Arial", Font.BOLD, 17));
		userFarmNameLabel.setBounds(70, 11, 267, 32);
		userFarmNameLabel.setText(game.getFarmName() + "'s Animals");
		animalsFrame.getContentPane().add(userFarmNameLabel);
		
		
		animalListModel.addAll(game.getAnimalsOnFarm());
		
		animalScroller.setBounds(281, 83, 267, 194);
		animalsFrame.getContentPane().add(animalScroller);
		
		animalList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		animalList.setForeground(Color.WHITE);
		animalList.setBackground(Color.DARK_GRAY);
		
		//animal food items owned
		for(Item item: game.getItemsOwnedByFarmer()) {
			if (item instanceof AnimalFoodOne || item instanceof AnimalFoodTwo || item instanceof AnimalFoodThree) {
				animalFoodListModel.addElement(item);
			}
		}
		animalFoodList.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		animalFoodScroller.setBounds(70, 82, 162, 109);
		animalsFrame.add(animalFoodScroller);
		
		animalFoodList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		animalFoodList.setForeground(Color.WHITE);
		animalFoodList.setBackground(Color.DARK_GRAY);
		
		JLabel animalFoodItemsLabel = new JLabel("Animal Food Items available");
		animalFoodItemsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		animalFoodItemsLabel.setFont(new Font("Arial", Font.BOLD, 11));
		animalFoodItemsLabel.setBounds(70, 54, 162, 32);
		animalsFrame.getContentPane().add(animalFoodItemsLabel);
		
		JLabel lblAnimalDescription = new JLabel("Name        :        Healthiness        :        Happiness");
		lblAnimalDescription.setFont(new Font("Arial", Font.BOLD, 11));
		lblAnimalDescription.setBounds(281, 63, 267, 14);
		animalsFrame.getContentPane().add(lblAnimalDescription);
	}
}
