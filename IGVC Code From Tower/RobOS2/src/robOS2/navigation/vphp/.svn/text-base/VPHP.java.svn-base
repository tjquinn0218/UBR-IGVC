package robOS2.navigation.vphp;

import java.lang.Math;
import java.util.ArrayList;


public class VPHP implements robOS2.navigation.IPathPlanner{
	
	//variables
	double robotRadius;
	double vCurrent;
	double vMax; //max robot velocity
	double[] _obstDistances;  //we will get these magically from the LIDAR
	double dThresh = 2*robotRadius;  //"safe" distance -- might want to change this
	double dSafe;
	double safetyK;
	double rMin;
	double planningCycle;
	
	public VPHP(double[] obstDistances){
		_obstDistances = obstDistances;
		dSafe = safetyK*(vCurrent/vMax*rMin + vCurrent*planningCycle);
	}
	//Part A
	public double furthestDistance(double heading){
		double dFurthest; //furthest distance robot can go in a direction
		int arrayIndex = (int)(heading*2);  //Index of array that corresponds with given heading
		double separator = _obstDistances[nextObjectIndex(arrayIndex)]*Math.sin(nextObjectIndex(arrayIndex) - heading);
		
		if(separator > robotRadius || (separator <= robotRadius && _obstDistances[nextObjectIndex(arrayIndex)]*Math.cos(nextObjectIndex(arrayIndex) - heading) > _obstDistances[nextObjectIndex(arrayIndex)])){
			dFurthest = _obstDistances[arrayIndex]-robotRadius;
		}else{
			dFurthest = _obstDistances[(int)(nextObjectIndex(arrayIndex)*Math.cos(nextObjectIndex(arrayIndex) - heading))]-robotRadius;
		}
		
		return dFurthest;
	}
	
	public int nextObjectIndex(int currentIndex){
		int nextIndex = currentIndex;
		double x = 0; //variable for while loop (what is stored at a particular index)
		while(x == 0){    ////////////YO. I THINK THIS IS WRONG.////////////////////////////////
			nextIndex += 1;
			x = _obstDistances[nextIndex];
		}
				
		return nextIndex;
	}
	
	//Part B
	ArrayList<ArrayList<Integer>> _blocks;
	
	public void makeBlocks(){
		ArrayList<Integer> block = new ArrayList<Integer>();
		for(int i = -1; i<_obstDistances.length; i++){
			int obstPt1 = nextObjectIndex(i);
			int obstPt2 = nextObjectIndex(obstPt1);
			
			if(block.isEmpty()){
				block.add(obstPt1);
			}
			
			double distToObst1 = _obstDistances[obstPt1];
			double distToObst2 = _obstDistances[obstPt2];
			double distBtwnObst = Math.sqrt(Math.pow(distToObst1,2)+Math.pow(distToObst2,2)- 2*distToObst1*distToObst2*Math.cos(obstPt2-obstPt1));
			
			if(distBtwnObst < dThresh){
				block.add(obstPt2);
				
			}else{
				_blocks.add(block);
				block = new ArrayList<Integer>();
				
			}
			
		}
	}
	
	//Part C
	public int isNOTConcave(ArrayList<Integer> block){
		int index = _blocks.indexOf(block);
		double dist0 = _obstDistances[block.get(0)];
		double distLast = _obstDistances[block.get(block.size()-1)];
		double distPrev = _obstDistances[_blocks.get(index-1).get(_blocks.get(index-1).size()-1)];
		double distNext = _obstDistances[_blocks.get(index+1).get(0)];
		
		if(dist0 < distPrev && distLast < distNext){
			return 0;
		}
		
		return 1;
	}
	
	public int symbolFcn(int i){
		for(ArrayList<Integer> b: _blocks){
			if(b.contains(i)){
				return isNOTConcave(b);
			}
		}
		return 1;
	}
	
	//Part D
	public int threshFcn(int i){
		if(_obstDistances[i] >= dSafe){
			return 1;
		}
		return 0;
	}
	
	//Part E
	public double cost(int i){
		double s = 1;  //OBVIOUSLY NOT CORRECT

		return symbolFcn(i)*threshFcn(i)*_obstDistances[i]/s;
	}
	
	public double heading(){
		double heading = 0;
		for(double i: _obstDistances){
			if(i > heading){
				heading = i;
			}
		}
		
		return heading;
	}
	@Override
	public double getForwardVelocity() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double getRotationalVelocity() {
		// TODO Auto-generated method stub
		return 0;
	}

}
