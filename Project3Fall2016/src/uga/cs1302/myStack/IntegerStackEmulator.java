package uga.cs1302.myStack;
/**
 * @author Stone Daniel
 * Purpose: This is the IntegerStackEmulator, which creates a GUI that serves as a display of the stack being created.
 * The variables are all set to private in order to have good encapsulation. DefaultTableModel's isCellEditable method is
 * also overriden in order to prevent the editing of cells in the JTable.
 * Date: 11/2/2016
 */


import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.table.*;

import java.awt.event.*;


public class IntegerStackEmulator implements ActionListener {

	private JFrame frame;
	private JPanel stackPanel,rightPanel,buttonPanel,textPanel;
	private JButton[] buttonArray = new JButton[10];
	private JButton zeroButton,pushButton,popButton,sizeButton,clearButton;
	private JTextField outputField;
	private JTable stackTable;
	private JScrollPane scroll;
	private DefaultTableModel model = new DefaultTableModel()
			{
			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
			};
	Stack<Integer> stack1 = new Stack<Integer>();
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntegerStackEmulator window = new IntegerStackEmulator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public IntegerStackEmulator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setFrame(new JFrame("Stack Emulation"));
		getFrame().setVisible(true);
		Font buttonFont = new Font("Times New Roman",Font.BOLD,48);
		getFrame().getContentPane().setLayout(new GridLayout(1, 2));
		getFrame().setResizable(false);
		textPanel = new JPanel();
		rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(2,1));
		buttonPanel = new JPanel();
		stackPanel = new JPanel();
		stackPanel.setLayout(new GridLayout());
		outputField = new JTextField();
		outputField.setPreferredSize(new Dimension(500,500));
		outputField.setFont(buttonFont);
		outputField.setHorizontalAlignment(JTextField.RIGHT);
		textPanel.add(outputField);
		rightPanel.add(textPanel);
		rightPanel.add(buttonPanel);
		
		
		
		
		getFrame().setBounds(100, 100, 1000, 1000);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonPanel.setLayout(null);
		stackTable = new JTable(model);
		stackTable.setRowHeight(100);
		stackTable.setFont(new Font("Times New Roman", Font.BOLD,30));
		model.setColumnIdentifiers(new String[] {"Stack"});
		model.setRowCount(50);
		stackPanel.add(stackTable);
		scroll = new JScrollPane(stackPanel);
		
		//stackTable.setPreferredSize(new Dimension(460,(10000)));//1000 should be stacklength * 15
		getFrame().getContentPane().add(scroll);
		
		for(int i = 0;i<10;i++)
			{	
			buttonArray[i] =  new JButton("" + (i + 1));
			buttonArray[i].setFont(buttonFont);
			buttonArray[i].addActionListener(this);
			buttonArray[i].setBounds((i*166), 0, 166, 100);
			buttonPanel.add(buttonArray[i]);	
			}	
		for(int i = 0;i<3;i++)
		{
			buttonArray[i+3] =  new JButton("" + (i + 4));
			buttonArray[i+3].setFont(buttonFont);
			buttonArray[i+3].addActionListener(this);
			buttonArray[i+3].setBounds((i*166), 100, 166, 100);
			buttonPanel.add(buttonArray[i+3]);
		}
		for(int i = 0;i<3;i++)
		{
			buttonArray[i+6] =  new JButton("" + (i + 7));
			buttonArray[i+6].setFont(buttonFont);
			buttonArray[i+6].addActionListener(this);
			buttonArray[i+6].setBounds((i*166), 200, 166, 100);
			buttonPanel.add(buttonArray[i+6]);
		}
		zeroButton = new JButton("0");
		zeroButton.setBounds(166, 300, 166, 100);
		zeroButton.setFont(buttonFont);
		zeroButton.addActionListener(this);
		popButton = new JButton("Pop");
		popButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					stack1.pop();	
					for(int i = 0;i<stack1.size();i++)
					{
						model.setValueAt(model.getValueAt(i+1, 0), i, 0);
					}
					model.setValueAt("" ,stack1.size(), 0);
					outputField.setText("");
					
				}
				catch(EmptyStackException e)
				{
					outputField.setText("Stack is empty.");
				}
				
				
			}
		});
		popButton.setFont(new Font("Times New Roman", Font.BOLD, 32));
		popButton.setBounds(0,300,166,100);
		pushButton = new JButton("Push");
		pushButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(stack1.maxSize() == 0)
					outputField.setText("Size needs to be >0.");
				else
				{
				try
				{
					stack1.push(Integer.parseInt(outputField.getText()));
					for(int i = stack1.size()-1;i>0;i--)
					{
						model.setValueAt(model.getValueAt(i-1, 0), i, 0);
					}
					model.setValueAt(Integer.parseInt(outputField.getText()), 0, 0);
					//model.setValueAt(, stack1.top, 0);
					//model.setValueAt(Integer.parseInt(outputField.getText()), stack1.size() -1, 0);
					outputField.setText("");
				}
				catch(FullStackException f1)
				{
					outputField.setText("Stack is full.");
				}
				catch(NumberFormatException n1)
				{
					outputField.setText("Please enter a number."
							+ "");
				}
				}
			}
		});
		pushButton.setFont(new Font("Times New Roman", Font.BOLD, 32));
		pushButton.setBounds(332,300,166,100);
		sizeButton = new JButton("Set Size");
		sizeButton.setBounds(0,400,249,80);
		sizeButton.setFont(new Font("Times New Roman", Font.BOLD, 32));
		sizeButton.addActionListener(this);
		clearButton = new JButton("C");
		clearButton.setBounds(249, 400, 249, 80);
		clearButton.setFont(new Font("Times New Roman", Font.BOLD, 32));
		clearButton.addActionListener(this);
		buttonPanel.add(popButton);
		buttonPanel.add(zeroButton);
		buttonPanel.add(clearButton);
		buttonPanel.add(pushButton);
		buttonPanel.add(sizeButton);
		getFrame().getContentPane().add(rightPanel);
		
		
		
		
	}

	@Override
	/**
	 * This is actionPerformed, which will determine the source of the event, then act accordingly.
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		try
		{
		if(e.getSource() == buttonArray[0])
			outputField.setText(outputField.getText() + "1");
		else if(e.getSource() == buttonArray[1])
			outputField.setText(outputField.getText() + "2");
		else if(e.getSource() == buttonArray[2])
			outputField.setText(outputField.getText() + "3");
		else if(e.getSource() == buttonArray[3])
			outputField.setText(outputField.getText() + "4");
		else if(e.getSource() == buttonArray[4])
			outputField.setText(outputField.getText() + "5");
		else if(e.getSource() == buttonArray[5])
			outputField.setText(outputField.getText() + "6");
		else if(e.getSource() == buttonArray[6])
			outputField.setText(outputField.getText() + "7");
		else if(e.getSource() == buttonArray[7])
			outputField.setText(outputField.getText() + "8");
		else if(e.getSource() == buttonArray[8])
			outputField.setText(outputField.getText() + "9");
		else if(e.getSource() == zeroButton)
			outputField.setText(outputField.getText() + "0");
		else if(e.getSource() == clearButton)
			outputField.setText("");
		else if(e.getSource() == sizeButton)
		{
			stack1 = new Stack<>(Integer.parseInt(outputField.getText())); 
			model.setRowCount(Integer.parseInt(outputField.getText()));
			for(int i = 1;i<stack1.maxSize();i++)
			{
				model.setValueAt("", i-1, 0);
			}
			
			//stack1.setSize(Integer.parseInt(outputField.getText()));
			outputField.setText("");
		}
			
		}
		catch(NumberFormatException e1)
		{
			outputField.setText("Please choose a valid number.");
		}
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
