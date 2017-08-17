import java.util.ArrayList;
import java.util.List;

// Adapted from code on Recitation Slide
public class GoodWordOnBoardFinder implements IWordOnBoardFinder {

	@Override
	public List<BoardCell> cellsForWord(BoggleBoard board, String word) {
		ArrayList<BoardCell> list = new ArrayList<BoardCell>();
		for (int r=0; r<board.size(); r++) {
		 for (int c=0; c<board.size(); c++) {
		 if (findHelper(word, 0, r, c, board, list)) { return list; } }}
		list.clear();
		return list; }
				
	public boolean findHelper(String theWord, int theIndex, int row, int col, BoggleBoard theBoard, List<BoardCell> theList) {
		// if index of string is too large the  word has been found 
		
		if ((row>=theBoard.size() || (row<0) || (col>=theBoard.size()) || (col<0) )) {
			return false;
		}
		
		
		
		if(theIndex>=theWord.length()) {
			return true;
		}
		
	
		BoardCell cell=new BoardCell(row,col);
		
		if (theList.contains(cell)) {
			return false;
		}
		String face=theBoard.getFace(row, col);
		
		
		
		
		
		if(theIndex+face.length() > theWord.length()) {
			return false;
		}
		
		if (face.equals(theWord.substring(theIndex, theIndex+face.length()))) {
			
			
			
			int[] rdelta = {-1,-1,-1, 0, 0, 1, 1, 1};
			int[] cdelta = {-1, 0, 1,-1, 1,-1, 0, 1};
			
			
			theList.add(cell);
			 for(int k=0; k < rdelta.length; k++){
				 if (findHelper(theWord,theIndex+face.length(), row+rdelta[k], col+cdelta[k], theBoard,theList )) 
					 return true; 
			 }
			
			theList.remove(cell);
		}
		
		
		
		
		
		return false;
		
	}
}
				
				
				

