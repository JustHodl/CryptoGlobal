
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;





public class Blockchain {
	
	private int GENESIS = 0; // FALSE
	private int DIFFICULTY = 0;
	byte[] Originhash;
	String s = "1GENESIS"; 
	
	// defaut genesis blk 'magic word' to sha-256
	
	// Default Constructor
	
	Blockchain()  {
		
        
 
        
        
        
		
	}
	

	
	// put a new block on CG blockchain 
	public int setNewBlock() {
		if (GENESIS == 0) {
			// START AT GENESIS BLOCK
			
			
			MessageDigest digest;
			try {
				digest = MessageDigest.getInstance("SHA-256");
				Originhash = digest.digest(s.getBytes(Charset.forName("UTF-8")));
				
				
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Path chemin = Paths.get("block1.hex");
	        
			 
	        
	        OutputStream output = null;
	        try {
	            // Un objet BufferedOutputStream est affecté à la référence OutputStream.
	            output = new BufferedOutputStream(Files.newOutputStream(chemin));
	            // Ecrire dans le fichier
	            output.write(Originhash);
	 
	            // vider le tampon
	            output.flush();
	 
	            // fermer le fichier
	            output.close();
	 
	        } catch (Exception e) {
	            System.out.println("Message " + e); }
	        
	       
			
		}
		
		else {
			// IF GENESIS BLOCK ALREADY MINED
			
			// APPEND NEW BLOCK
			
			Path chemin = Paths.get("block2.hex");
	        
			 
	        
	        OutputStream output = null;
	        try {
	            // Un objet BufferedOutputStream est affecté à la référence OutputStream.
	            output = new BufferedOutputStream(Files.newOutputStream(chemin));
	            // Ecrire dans le fichier
	            output.write(Originhash);
	 
	            // vider le tampon
	            output.flush();
	 
	            // fermer le fichier
	            output.close();
	 
	        } catch (Exception e) {
	            System.out.println("Message " + e); }
			
			
			
			
		}
		
		
		return 0;
	}
	
	int basicMining() {
		// TRUE HASHING
		while (Originhash[0] != '0') {
			
			// Basic mining work !
			
			MessageDigest digest;
			
			
			try {
				digest = MessageDigest.getInstance("SHA-256");
				Originhash = digest.digest(s.getBytes(Charset.forName("UTF-8")));
				s = s+1;
				System.out.println(s);
				System.out.println(Originhash);
				
				Path chemin = Paths.get("block1HASH.hex");
		        
				 
		        
		        OutputStream output = null;
		        try {
		            // Un objet BufferedOutputStream est affecté à la référence OutputStream.
		            output = new BufferedOutputStream(Files.newOutputStream(chemin));
		            // Ecrire dans le fichier
		            output.write(Originhash);
		 
		            // vider le tampon
		            output.flush();
		 
		            // fermer le fichier
		            output.close();
		 
		        } catch (Exception e) {
		            System.out.println("Message " + e); }
				
				
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		// END GENESIS MINING
		
		GENESIS = 1; // TRUE
		
		
		
		
		DIFFICULTY++; // Increase difficulty after first block mined
		
		return 0;
	}
	
	int setMining(int methodDIFFICULTY) throws IOException {
		
		// PROOF OF WORK
		
		int standardBlockDifficulty;
		standardBlockDifficulty = DIFFICULTY;
		System.out.println(standardBlockDifficulty);
		
		MessageDigest digest;
		
		
			Path cheminBlock = Paths.get("block1HASH.hex");
	        
			Scanner myReader = new Scanner(cheminBlock);
			  while (myReader.hasNextLine()) {
			    String hashFirstBlock = myReader.nextLine();
			    System.out.println(hashFirstBlock);
			    
			    byte[] hashFirstBlockTab = (s.getBytes(Charset.forName("UTF-8")));
			    
			    // Loop second block mining
			    
			    // Block hash salt
			    char random_char;
			    int random_int = (int)Math.floor(Math.random()*(9-0+1)+0);
			    if (random_int > 5 ) {
			    	random_char = '0';
			    }
			   
			    
			    else {
			    	random_char = '1';
			    }
			    
			    System.out.println(random_char);
			    
			    //////////////////////////////////
			    
			    
			    while (hashFirstBlockTab[0] != '0') {
			    	
			    	try {
						digest = MessageDigest.getInstance("SHA-256");
						hashFirstBlockTab = digest.digest(hashFirstBlock.getBytes(Charset.forName("UTF-8")));
						
						System.out.println(hashFirstBlock);
						System.out.println(hashFirstBlockTab);
						System.out.println(random_int);
						
						Path chemin = Paths.get("block2HASH.hex");
						
						
						// Increase difficulty by adding a zero at position 4 (hex)
						
						if (hashFirstBlockTab[1] != random_char) {
							while (hashFirstBlockTab[1] != random_char) {
								digest = MessageDigest.getInstance("SHA-256");
								hashFirstBlockTab = digest.digest(hashFirstBlock.getBytes(Charset.forName("UTF-8")));
								
								hashFirstBlock = hashFirstBlock+1;
								
							}
							
								
						}
						
						
						
						
						
						
				        
						 
				        
				        OutputStream output = null;
				        try {
				            // Un objet BufferedOutputStream est affecté à la référence OutputStream.
				            output = new BufferedOutputStream(Files.newOutputStream(chemin));
				            // Ecrire dans le fichier
				            output.write(hashFirstBlockTab);
				 
				            // vider le tampon
				            output.flush();
				 
				            // fermer le fichier
				            output.close();
				 
				        } catch (Exception e) {
				            System.out.println("Message " + e); }
						
						
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	
			    }
			    
			    
			    
			  }
			  myReader.close();
		
		
		return 0;
		
	}
	
	int setNewTransaction() {
		return 0;
	}
	
	
	

}
