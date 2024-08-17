import java.util.Arrays;
public class sudoku
{
	public static void main(String[] args) {
		int sudoku[][]={{3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        solve(sudoku);
        display(sudoku);
	}
	public static boolean solve(int b[][]){
	    int n=b.length,r=-1,c=-1;
	    boolean notempty=true;
	    for(int i=0;i<n;i++){
	        for(int j=0;j<n;j++){
	            if(b[i][j]==0){
	                r=i;
	                c=j;
	                notempty=false;
	                break;
	            }
	        }
	        if(notempty==false) break;
	    }
	    if(notempty==true) return true; //return true of no cell is notempty
	    for(int i=1;i<=9;i++){
	        if(issafe(b,r,c,i)){
	            b[r][c]=i;
	            if(solve(b)){
	                return true;    //found the answer
	            }
	            else b[r][c]=0; //backtrack
	        }
	    }
	    return false;   //return false if sudoku cant be solved
	}
	public static boolean issafe(int[][] b, int r, int c, int num){
	    for(int i=0;i<b.length;i++){
	        if(b[r][i]==num ||b[i][c]==num) return false; //check row, column for num
	    }
	    int bsize=(int)(Math.sqrt(b.length));
	    int rowstart=r-r%bsize;
	    int colstart=c-c%bsize;
	    for(int i=rowstart;i<rowstart+bsize;i++){
	        for(int j=colstart;j<colstart+bsize;j++){
	            if(b[i][j]==num) return false;
	        }
	    }
	    return true;
	}
	public static void display(int[][] b){
	    for(int[] x:b)
	    System.out.println(Arrays.toString(x));
	    System.out.println();
	}
}