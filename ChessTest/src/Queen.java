
public class Queen extends Piece {

	int row,column;
	
	boolean isValidMove(Position newPosition){
		
		if(!super.isValidMove(newPosition)) {
			return false;
		}
			
		
		if(newPosition.column == this.column || newPosition.row == this.row){
	         return true;
	      }
	      else if(Math.abs(newPosition.column - this.column) == Math.abs(newPosition.row - this.row)){
	    	  return true;
	      }
	      else
	      {
	    	  return false;
	      }
		
		
	}
}
