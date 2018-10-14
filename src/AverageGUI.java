//package net.codejava.swing.combobox;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.BorderLayout;

import javax.swing.*;

import java.awt.event.*;
import javax.swing.text.*;
import java.awt.Component.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

/**
 * A Swing program that demonstrates how to create and use JComboBox component.
 * 
 * @author www.codejava.net
 * 
 */
public class AverageGUI extends JFrame {

	
	private JButton buttonAverage = new JButton("Average List");
	private JButton buttonRemove = new JButton("Remove");
	private JButton buttonClear = new JButton("Clear");

	public AverageGUI() {
		super("Swing JComboBox Demo");

		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		String[] dataList = new String[] { "3", "4", "5" };

		// create a combo box with items specified in the String array:
		final JComboBox<String> numberList = new JComboBox(dataList);
		//final JComboBox<String> numberList = new JComboBox<String>();

		final JTextField averageText = new JTextField(20);
	  
	  
		// add some numbers
		numberList.addItem("-1");
		numberList.addItem("3");
		numberList.addItem("-4");

		// customize some appearance:
		numberList.setForeground(Color.BLUE);
		numberList.setFont(new Font("Arial", Font.BOLD, 14));
		numberList.setMaximumRowCount(10);
		
		// make the combo box editable so we can add new item when needed
		numberList.setEditable(true);

		JComboBox.KeySelectionManager manager = new JComboBox.KeySelectionManager() {
			public int selectionForKey(char aKey, ComboBoxModel aModel) {
			  System.out.println(aKey);
			  return -1;
			}
		};
		numberList.setKeySelectionManager(manager);
	
		// add an event listener for the combo box
		numberList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				JComboBox<String> combo = (JComboBox<String>) event.getSource();
				String selectedNumber = (String) combo.getSelectedItem();

				DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) combo.getModel();

				int selectedIndex = model.getIndexOf(selectedNumber);
				if (selectedIndex < 0) {
					// if the selected book does not exist before, 
					// add it into this combo box
					model.addElement(selectedNumber);
				}

			}
		});

		
		numberList.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

		@Override
		public void keyReleased(KeyEvent event) {
			if (event.getKeyChar() == KeyEvent.VK_ENTER) {
				System.out.println("Pressed Enter!");
				
				//For reference, to answer the tittle of the page : How to get text from JComboBox?
				String value = ((JTextComponent)numberList.getEditor().getEditorComponent()).getText();

				System.out.println(value);
				
				if (((JTextComponent) ((JComboBox) ((Component) event
						.getSource()).getParent()).getEditor()
						.getEditorComponent()).getText().isEmpty())
					System.out.println("please dont make me blank");
				}
			}
		});
		
		
		// add event listener for the button Select 
		buttonAverage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String selectedNumber = (String) numberList.getSelectedItem();
				System.out.println("selected : " + selectedNumber);
				
				int numValues = 0;
				
				int count = numberList.getItemCount();
				double sum = 0;
				
				System.out.println("count : " + count);
				
				for(int index = 0; index < count; index++) {
					System.out.println(numberList.getItemAt(index));
					if(numberList.getItemAt(index) != null) {
						sum += Double.parseDouble(numberList.getItemAt(index));
						System.out.println("SUM : " + sum);
						
						numValues++;
					}
				}
				
				double average = sum / numValues;
				averageText.setText(String.valueOf(average));
				
				
			}
		});

		// add event listener for the button Remove
		buttonRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String selectedNumber = (String) numberList.getSelectedItem();
				numberList.removeItem(selectedNumber);
			}
		});

		// add event listener for the button Remove
		buttonClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				//numberList.removeAllItems();
				
				int itemCount = numberList.getItemCount();

				for(int i=0;i<itemCount;i++){
					numberList.removeItemAt(0);
				}
			}
		});
		
		// Add components to this frame
		
		// Add ComboBox to display number list
		add(numberList);
		
		// Add average button`
		add(buttonAverage);
		
		// Add remove button`
		add(buttonRemove);

		// Add clear button`
		add(buttonClear);

		add(averageText);
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {

		@Override
			public void run() {
				new AverageGUI().setVisible(true);
			}
		});
	}
}