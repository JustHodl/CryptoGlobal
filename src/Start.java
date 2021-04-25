

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

public class Start {
	
	private static final double VERSION = 0.1;

	public static void main(String[] args) throws IOException  {
	
	// basic GUI
	JFrame frame = new JFrame("CryptoGlobal CORE ALPHA 0.1");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600,400);
    frame.setVisible(true);
    
    
    
  
    
    // start new blockchain
    Blockchain blk = new Blockchain();
    blk.setNewBlock();
    blk.basicMining();
    blk.setMining(0);
    
	}	

}
