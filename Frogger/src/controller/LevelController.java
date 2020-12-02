package controller;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Actor;
import model.Level;
import view.LevelView;

/**
 * 
 * @author hcysu1
 *
 */
public class LevelController {
	
	private static final int MAX_LEVEL = 5;
	private static final SimpleIntegerProperty LEVEL_VALUE = new SimpleIntegerProperty();
	
	public static String getMaxLevel() {
		return Integer.toString(MAX_LEVEL);
	}
	
	
	public static StringBinding getLevelValue() {
		return LEVEL_VALUE.asString();
	}
	
	
    public static LevelView getLevelView() {
        return new LevelView();
    }
	
    /**
     * 
     * @return the elements of array LEVEL1
     */
	public static Actor[] getStartingLevel() {
		LEVEL_VALUE.setValue(1);
		return getCurrentLevel();
	}
	
	public static Actor[] getCurrentLevel() {
		return Level.getGameLevel(LEVEL_VALUE.get());
		
	}
	
	/**
	 * Used for testing
	 * @return the integer value of the level being played
	 */
	public static int getLevel() {
		return LEVEL_VALUE.getValue().intValue();
	}
	
	public static Actor[] getNextLevel() {
		
		LEVEL_VALUE.setValue(LEVEL_VALUE.get() + 1);
		
		//When all levels have been completed and the game is won
		if (LEVEL_VALUE.get() > MAX_LEVEL) {		
			AudioController.playWinAudio();
			MenuController.gameWon();
		}
		return getCurrentLevel();
	}
	
	
	public static Actor[] getSpecificLevel(int level) {
		LEVEL_VALUE.setValue(level);
		return getCurrentLevel();
	}
	
}