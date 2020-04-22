package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	ArrayList<Task> task = new ArrayList<Task>();

	float border;
	public void settings()
	{
		size(800, 600);
	}


	public void loadTasks()
	{
		Table table = loadTable("tasks.csv","header");

		for (TableRow row:table.rows()){

			Task t = new Task(row);
			task.add(t);
		}
	}

	public void printTasks()
	{
		for (Task t:task){
			System.out.println(t);
		}
		
	}

	public void displayTasks()
	{	
		// float border = width * 0.05f;
		// for (float x = 1; x < 32; x++){ 

		// 	if ( x % 2 == 1){
		// 		stroke(135,0,135);
		// 		float x1 = map(x,1,31,border,width);
		// 		line(x1,border,x1,height-border);
		// 		text((int) x,x1,30);
		// 	}else{
		// 		stroke(135,0,135);
		// 		float x1 = map(x,1,31,border,width);
		// 		line(x1,border,x1,height-border);
		// 		text((int) x,x1,30);
		// 	}

		// }


		


//*******should be use two loops to do for one of the loop bring in side of the 30 like the 30 days
//*******the second for loop bring the ten task but I tried many ways to do this in the whole days get dizzy;
//*******sorry for that. if i get more time I think i can do it.

	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{			
		background(0);
		displayTasks();
	}
}
