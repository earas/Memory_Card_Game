public class Players implements Comparable<Players>{

	private String name;
	private int min;
	private int sec;
	private int point;
	private int grid;


	public Players(String name, int min, int sec, int grid) {
		this.name = name;
		this.min = min;
		this.sec = sec;
		this.grid = grid;
		this.point = (min*60 + sec) /grid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMin() {
		return min;
	}


	public void setMin(int min) {
		this.min = min;
	}


	public int getSec() {
		return sec;
	}


	public void setSec(int sec) {
		this.sec = sec;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}


	public int getGrid() {
		return grid;
	}


	public void setGrid(int grid) {
		this.grid = grid;
	}


	@Override
	public String toString() {
		return name + " (Time: " + min + ":" + sec + ", grid " + grid + "x3)";
	}


	@Override
	public int compareTo(Players player) {
		
		if (this.point < player.point) {
            
            return -1;
            
        }
        else if (this.point > player.point) {
            return 1;
            
        }
        return 0;
			
		
	}
	
	
	
	
}


