package ianListonIndividualProject.Burger211Update;

//Name: Ian Liston
//Contact info: ian.liston@bellevuecollege.edu
//Student ID: 950457388
//Date: 11/30/2020
//Description: Class GetInputGUI is a graphics user interface for implementing the front end page that houses java text field used for inputing user text for
//             desired franchise country or desired franchise name.    
//

	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.Font;
	import java.awt.Graphics;
	import java.awt.Image;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
	
	// GUI for retrieving user text input
	public class GetInputGUI extends JFrame implements ActionListener{
		boolean tripLine;
		 static final int W=800,H=600;
		   private JFrame f; 
		   private JPanel p,imageData;
		   private JLabel labelInfo,textLabel,CS211,l;
		static JButton inputButton;
		static JTextField textInput;
		String userInput;
		String textLabelHold;
		String labelInfoHold;     
		 ImagePanel image1;
		 
		 // GUI constructor 
		  GetInputGUI(String labelInfo1,String textLabel1,String image,String textFieldText){
			  labelInfoHold = labelInfo1;
			  textLabelHold = textLabel1;
				f=new JFrame();
				f.setSize(W+220, H);
				f.setBackground(Color.WHITE); // I could not get the background color to work properly.
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				p=new JPanel();
				
				// Text above user input text field
		    textLabel = new JLabel(textLabel1);
				textLabel.setBounds(250, 115, 800,50);
		    textLabel.setForeground(Color.BLACK);
				textLabel.setFont(new Font("Serif", Font.ITALIC, 25));
		      
				// Text or lower frame 
		    labelInfo=new JLabel(labelInfo1);
				labelInfo.setFont(new Font("Serif", Font.PLAIN, 13));
				labelInfo.setBounds(245,490,W,H/6);
				p.setLayout(null);
		    
				// Text field for user input
		    textInput = new JTextField(textFieldText);
		    textInput.setBounds(300, 167, 500,50);
		    textInput.setForeground(Color.RED);
				textInput.setFont(new Font("Serif", Font.ITALIC, 27));
		   
				// Button for text field
		    inputButton = new JButton("Submit");
		    inputButton.setBounds(673, 225, 125,35);
		    inputButton.setForeground(Color.RED);
			   inputButton.setFont(new Font("Serif", Font.ITALIC, 27));
			   
			    // Action listener text field button 
			   inputButton.addActionListener(this);
			   l = new JLabel("nothing entered");
			   

		    CS211 = new JLabel("CS211, Fall Quarter 2020");
		    CS211.setBounds(W-30, 1, 200,40);
		    CS211.setForeground(Color.BLACK);
				CS211.setFont(new Font("Serif", Font.ITALIC, 16));
				
		    image1 = new ImagePanel(image);
		    image1.setBounds(50,120,200,250);
			   f.add(image1);
			   p.add(labelInfo);
			   p.add(textLabel);
			   p.add(textInput);
			   p.add(inputButton);
			   p.add(CS211);
			   f.add(p); 
			   f.setVisible(true);
			}
		  class ImagePanel extends JPanel {
			    Image img;
			    public void paintComponent(Graphics g) {
			       super.paintComponent(g);
			        g.drawImage(img, 0, 0, null);
			    }
			    public ImagePanel(Image img) {
			       this.img = img;
			       Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
			       setPreferredSize(size);
			       setMinimumSize(size);
			       setMaximumSize(size);
			       setSize(size);
			       setLayout(null);
			       }
			    public ImagePanel(String img) {
			       this(new ImageIcon(img).getImage());}
			 }
		  
		  // Button action listener function
		@Override
		public void actionPerformed(ActionEvent e) {
			 userInput = e.getActionCommand(); 	
		        if (userInput.equals("Submit")) { 
		        	userInput = textInput.getText();
		            l.setText(textInput.getText()); 
		            f.setVisible(false);
		            tripLine = true;
		            textInput.setText("  ");
		            } 
		        }
		
		// I had issues with with my code in main running before GUI had finished and user text inputed, so I added this so I could use it in a do while loop in main.
		public boolean getBool() {
			return tripLine;
		}
		
		// Returns user text field input.
		public String getCountry() {
			return userInput;
		}
		}

