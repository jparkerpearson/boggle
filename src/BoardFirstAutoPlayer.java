import java.util.ArrayList;
import java.util.List;



public class BoardFirstAutoPlayer extends AbstractAutoPlayer {
  
	public int length;
	public BoggleBoard gameBoard;
    public ILexicon lexicon;
    @Override
    public void findAllValidWords(BoggleBoard board, ILexicon lex, int minLength) {
	    // TODO: you write this code
    	// clear
    	clear();
lexicon=lex;
    	ArrayList<BoardCell> locs=new ArrayList<BoardCell>();
    	 gameBoard=board;
    	int size=board.size();
    	 StringBuilder builtString = new StringBuilder("");
    	for (int i=0; i<size;i++) {
    		
    		
    		for(int j=0; j<size; j++) {
    		 wordHelper(i,j,builtString,locs);	
    		}
    	
    } 
    length=minLength;	
    }
    
    	private void wordHelper(int i, int j, StringBuilder builtString, ArrayList<BoardCell> locs) {
    		// Helper method to help backtrack 		
		if ((i>=gameBoard.size() || (i<0) || (j>=gameBoard.size()) || (j<0) )) {
			return;
		}
		BoardCell currentBoard=new BoardCell(i,j);
		
		
		// if the BoardCell is already contained in locs then no need to go further
		if(locs.contains(currentBoard)) {
			return;
		}
		String boardFace=gameBoard.getFace(i,j);
	locs.add(currentBoard);
	
	
	
	builtString.append(boardFace);
	LexStatus indicator = lexicon.wordStatus(builtString);
	// if not a word
		if(indicator==LexStatus.NOT_WORD){
			locs.remove(currentBoard);
			builtString.delete(builtString.length()-boardFace.length(), builtString.length());
			
			return;
		}
		if (indicator==LexStatus.WORD) {
			
			
			if(builtString.length()>=length)
				this.add(builtString.toString());
		}
		
		

			int[] rdelta = {-1,-1,-1, 0, 0, 1, 1, 1};
			int[] cdelta = {-1, 0, 1,-1, 1,-1, 0, 1};
			
			
			
			 for(int k=0; k < rdelta.length; k++){
				 wordHelper(i+rdelta[k], j+cdelta[k], builtString,locs ) ;
					
			 }
			
			 locs.remove(currentBoard);
			builtString.delete(builtString.length()-boardFace.length(), builtString.length());
			
			return;
		}
		
		
		
		
	
		
	}
