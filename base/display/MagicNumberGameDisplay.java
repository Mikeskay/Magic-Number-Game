package magicnumbergame.base.display;

import magicnumbergame.base.engine.*;

import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;  
import java.awt.GridBagLayout;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.util.concurrent.TimeUnit;


public class MagicNumberGameDisplay extends JFrame implements ActionListener{

    protected JPanel mainPanel = new JPanel(new GridLayout(2,1));
    protected JPanel topPanel;
    protected JPanel midPanel;
    

    protected JLabel gameLabel;

    protected JTextField textField;

    protected JButton enterButton;
    protected JButton resetButton;
    protected JButton replayButton = new JButton("Replay");
    
    protected int counter = 1;
    

    protected Object buttonPressed;

    protected int magicNumber = ManagingNumbers.generateRandomNumber();
    protected int guess;
    protected boolean comparison;
    

    public MagicNumberGameDisplay(){
        setTitle("Magic Number Guess");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        setBounds(100,100, 600, 150);
        getContentPane().add(mainPanel);

        mainPanel.add(topPanel());
        mainPanel.add(midPanel());

        enterButton.addActionListener(this);
        resetButton.addActionListener(this);
        replayButton.addActionListener(this);

        setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e){
       
        buttonPressed = e.getSource();
       

        if (buttonPressed == resetButton){
            counter = 1;
            magicNumber = ManagingNumbers.generateRandomNumber();

            gameLabel.removeAll();
            gameLabel.setText("I am now thinking of a new number between 1 - 100 ;) You have 7 guesses");
            topPanel.validate();
            topPanel.repaint();

        }

       /* if (buttonPressed == replayButton)  {
            counter = 1;
            magicNumber = ManagingNumbers.generateRandomNumber();
         

            mainPanel.removeAll();
            mainPanel.add(topPanel());
            mainPanel.add(midPanel());
            gameLabel.removeAll();
            gameLabel.setText("I'm thinking of a new number between 1 - 100 now ;) You have 7 guesses");
            
            mainPanel.validate();
            mainPanel.repaint();  

        }*/
    
        if (buttonPressed == enterButton){

           try {
                guess = Integer.parseInt(textField.getText());
                boolean inRange = (guess >= 0 && guess <= 100);
                boolean comparison = ManagingNumbers.compareNumber(guess, magicNumber);

                if(!inRange){
                    gameLabel.removeAll();
                    gameLabel.setText("KMT enter a valid number between 0-100, you still have " + ((7 - counter) + 1)  + " goes");
                    topPanel.validate();
                    topPanel.repaint();
                    counter--;
                    

                }

               else if (inRange && comparison && counter == 1){      
                    gameLabel.setText(":) wow :0 you must have cheated! you got it right on your first go" ) ;
                    System.out.println(magicNumber) ;
        
                }
                else if (inRange && guess > magicNumber && counter < 7){
        
                    gameLabel.removeAll();
                    gameLabel.setText(" :( Incorrect guess, you went too high. you have " + (7 - counter) + " tries remaining ");
                    System.out.println(magicNumber) ;
                    guess = Integer.parseInt(textField.getText());
                    topPanel.validate();
                    topPanel.repaint();
                    
                }
               else if (inRange && guess < magicNumber && counter < 7){
                    gameLabel.removeAll();
                    gameLabel.setText(" :( Incorrect guess, you went too LOW. you have " + (7 - counter) + " tries remaining ");
                    guess = Integer.parseInt(textField.getText());
                    System.out.println(magicNumber) ;
                    topPanel.validate();
                    topPanel.repaint();
                    
                 }
                
                else if (inRange && counter > 6 && !comparison){

                  /*  mainPanel.removeAll();
                    mainPanel.add(topPanel());
                    mainPanel.add(replayPanel());*/
                    gameLabel.removeAll();
                    gameLabel.setText(" You lose!! My number was " + magicNumber + " it took you: " + counter + " times");
                    mainPanel.validate();
                    mainPanel.repaint();  
                   

                }

                else if ( inRange && comparison && counter <=  7) {

                    gameLabel.removeAll();
                    gameLabel.setText(":) finally got there! it took you: " + counter + " times");
                    System.out.println(magicNumber) ;
                    topPanel.validate();
                    topPanel.repaint();
                    
                }  

                counter++;                      
                    
                    
                } catch (Exception error) {
                    gameLabel.removeAll();
                    gameLabel.setText("KMT enter a valid number between 0-100, you still have " + ((7 - counter) + 1)  + " goes");
                    topPanel.validate();
                    topPanel.repaint();
                    
                }
            }

    }

    public JPanel topPanel(){
        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setSize(400, 100);
        topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));


        gameLabel = new JLabel("I'm thinking of a number between 1 - 100. You have 7 guesses");
        gameLabel.setForeground( (new Color(65, 66, 64)));
        gameLabel.setFont(new Font("Open Sans", Font.BOLD, 13));
    
        topPanel.add(gameLabel);
        topPanel.setBackground(new Color(52, 235, 235));

        return topPanel;
    }

    public JPanel midPanel(){
        midPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        midPanel.setSize(400, 100);
        midPanel.setBorder(new EmptyBorder(10, 10, 10, 10));


        textField = new JTextField(7);
        enterButton = new JButton("Enter");
        resetButton = new JButton("Reset");
        
  
        midPanel.add(textField);
        midPanel.add(enterButton);
        midPanel.add(resetButton);
    

        return midPanel;
    }

    public JPanel replayPanel(){
        midPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        midPanel.setSize(400, 100);
        midPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        textField = new JTextField(7);
  
        midPanel.add(textField);
        midPanel.add(replayButton);

        return midPanel;
    }
 


}
