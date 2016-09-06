import org.apache.commons.lang3.RandomUtils;

public class GenTerrain {
	double[][]grid;
	int size=8;
	int iters = size/2;
	int n=1;
	int d = size/2;
	double var = 2.0;
	double range = 3.0;
	public GenTerrain(double[][] grid){
		this.grid = grid;
		generate();
	}
	public void generate(){
		grid[0][0] = 2; grid[size][0] = 2;		
		grid[0][size]=2; grid[size][size] = 2;
		for(int i=0;i<iters;i++){
			square();
			diamond();
		}
	}
	public double[][]getGrid(){
		return grid;
	}
	void square(){
		for(int i=0;i<=size;i++){
			for(int j=0;j<=size;j++){
				try{
					if(grid[i+d][j+d]!=0&&grid[i-d][j+d]!=0&&grid[i+d][j-d]!=0&&grid[i-d][j+d]!=0){
						double t = RandomUtils.nextDouble(0, range);
						grid[i][j]=(((grid[i+d][j+d]+grid[i-d][j+d]+grid[i+d][j-d]+grid[i-d][j+d])/4)+(t>range/2?(t-range):t));
					}
				}catch(ArrayIndexOutOfBoundsException e){}
			}
		}
		
	}
	void diamond(){
		//
		for(int i=0;i<=size;i++){
			for(int j=0;j<=size;j++){
				try{
					if(grid[i+d][j]!=0&&grid[i-d][j]!=0&&grid[i][j+d]!=0&&grid[i][j-d]!=0){
						double t = RandomUtils.nextDouble(0, range);
						grid[i][j]=((grid[i+d][j]+grid[i-d][j]+grid[i][j-d]+grid[i][j+d])/4)+(t>range/2?(t-range):t);
					}
				}catch(ArrayIndexOutOfBoundsException e){}
				
				try{
					if(grid[i+d][j]!=0&&grid[i-d][j]!=0&&grid[i][j+d]!=0){
						double t = RandomUtils.nextDouble(0, range);
						grid[i][j]=((grid[i+d][j]+grid[i-d][j]+grid[i][j+d])/3)+(t>range/2?(t-range):t);
						grid[i][0]=((grid[i+d][j]+grid[i-d][j]+grid[i][j+d])/3)+(t>range/2?(t-range):t);
					}
				}catch(ArrayIndexOutOfBoundsException e){}
				
				try{
					if(grid[i+d][j]!=0&&grid[i-d][j]!=0&&grid[i][j-d]!=0){
						double t = RandomUtils.nextDouble(0, range);
						grid[i][j]=((grid[i+d][j]+grid[i-d][j]+grid[i][j-d])/3)+(t>range/2?(t-range):t);
						//grid[i][1024]=((grid[i+d][j]+grid[i-d][j]+grid[i][j-d])/3)+(t>range/2?(t-range):t);
					}
				}catch(ArrayIndexOutOfBoundsException e){}
				
				try{
					if(grid[i+d][j]!=0&&grid[i][j+d]!=0&&grid[i][j-d]!=0){
						double t = RandomUtils.nextDouble(0, range);
						grid[i][j]=((grid[i+d][j]+grid[i][j-d]+grid[i][j+d])/3)+(t>range/2?(t-range):t);
						grid[1024][j]=((grid[i+d][j]+grid[i][j-d]+grid[i][j+d])/3)+(t>range/2?(t-range):t);
					}
				}catch(ArrayIndexOutOfBoundsException e){}
				
				try{
					if(grid[i-d][j]!=0&&grid[i][j+d]!=0&&grid[i][j-d]!=0){
						double t = RandomUtils.nextDouble(0, range);
						grid[i][j]=((grid[i-d][j]+grid[i][j-d]+grid[i][j+d])/3)+(t>range/2?(t-range):t);
						grid[0][j]=((grid[i-d][j]+grid[i][j-d]+grid[i][j+d])/3)+(t>range/2?(t-range):t);
					}
				}catch(ArrayIndexOutOfBoundsException e){}				
			}
		}
		d-=1;
		range/=2.0;
	}
}
