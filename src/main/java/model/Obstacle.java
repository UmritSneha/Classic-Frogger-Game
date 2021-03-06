package model;

import javafx.scene.image.Image;

/**
 * Derived from Actor class. <p>
 * The different obstacles include race car, normal car, short white truck, long blue truck and tractor.
 * Uses switch statement to set the images of the obstacles
 * @author Amended from previous Obstacle class
 *
 */
public class Obstacle extends Actor {
	
	/**
	 * 
	 * @param x Set the x position of the obstacle
	 * @param y Set the y position of the obstacle
	 * @param obstacleName String that helps us identify the obstacle thus making it easier to use in level class
	 * @param speed Allows us to set the speed of each obstacle
	 */
	public Obstacle(int x, int y, String obstacleName,double speed) {
		super(x, y);		

		switch (obstacleName) {		
		case "race car":
			actorSpeed = speed;
			setImage(new Image("file:src/main/resources/Obstacles/racecarleft.png",63,63,false,true));
			break;
		
		case "normal car":
			actorSpeed = speed;
			setImage(new Image("file:src/main/resources/Obstacles/car1Left.png",45,35,false,true));			
			break;
	
		case "short white truck":

			actorSpeed = speed;
			setImage(new Image("file:src/main/resources/Obstacles/whitetruckright.png",100,60,false,true));
			break;
		
		case "long blue truck":
			actorSpeed = speed;
			setImage(new Image("file:src/main/resources/Obstacles/truck2Right.png",190,39,false,true));
			break;
			
		case "tractor":
			actorSpeed = speed;
			setImage(new Image("file:src/main/resources/Obstacles/tractorright.png",70,60,false,true));
			break;

		}
	}

	/**
	 * Override method from Actor class to implement move method and set the position of the obstacles during animation
	 */
    @Override
    public void act() {
        move(actorSpeed, 0);
        if (getX() > 600 && actorSpeed > 0)
            setX(-200);
        if (getX() < -50 && actorSpeed < 0)
            setX(600);
    }
	

}
