package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	ArrayList<Task> task = new ArrayList<Task>();

	int days;
	float left;
	float margin;
	//float pixels;
	float rect;
	
	public void settings()
	{
		size(800, 600);

		days = 30;
		left =  width / 6;
		margin = width / 20;
		//pixels = 20;
		rect = 30;
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
		
		textAlign(LEFT);
		fill(200);
		//float text1 = 0.6f;
		float text1 = 0.8f;

		


		for(int i = 1; i <= days; i++) {
			if (i % 2 == 0) {

				stroke(90);

			} else {

				stroke(150);

			}

			float x = map(i, 1, days, left, width - margin);
			line(x, margin, x, height - margin); 
			text(i, x, margin * text1);

		}

		int r = 5;
		for(int z = 0; z < task.size(); z++) {
		
			fill(200);
			float y = map(z, 0, task.size(), 2 * margin, height - margin);
			text(task.get(z).getTask(), margin, y);
			float color = map(z, 0, task.size(), 0, 255);
			
			fill(color, 255, 255);

			float rectStart = map(task.get(z).getStart(), 1, days, left, width - margin);
			float rectEnd = map(task.get(z).getEnd(), 1, days, left, width - margin);
			float rectWidth = rectEnd - rectStart;
			rect(rectStart, y - (rect / 2), rectWidth, rect, r); 
	}
}



	// public void mousePressed()
	// {
	// 	println("Mouse pressed");	
	// }

	// public void mouseDragged()
	// {
	// 	println("Mouse dragged");
	// }

	
	
	public void setup() 
	{
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{			
		background(0);
		displayTasks();
		colorMode(HSB);
	}
}
