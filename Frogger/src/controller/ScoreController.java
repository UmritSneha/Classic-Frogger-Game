package controller;

import java.text.ParseException;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.ScoreModel;
import view.ScoreView;
/**
 * New class that uses ScoreModel to implement read method.<p>
 * Creates an instance of scoreview to update the display as the score changes
 * Implements to update score and return score both as String or integer
 * @author hcysu1
 *
 */

public class ScoreController {

	/**
	 * Indicate file path of CSV file
	 */
	private static final String SCORES_PATH = "res/ScoreBoard.csv";
	private static IntegerProperty score = new SimpleIntegerProperty(0);
	
	/**
	 * Creates an instance of ScoreView
	 * Updates score and return updated score for display
	 * @return ScoreView
	 */
	public static ScoreView getScoreView() {
		score = new SimpleIntegerProperty(0);
		return new ScoreView();
	}
	
	/**
	 * 
	 * @return The path of the CSV file where the scores are stored
	 */
	public static String getScoresPath() {
		return SCORES_PATH;
	}
	
	/**
	 * 
	 * @return The maximum score as a String
	 */
	public static String getMaxScore() {
		return String.valueOf(ScoreModel.getMaxScore());
	}
	
	/**
	 * 
	 * @return The integer value of the score
	 */
	public static int getScore() {
		return score.get();
	}
	
	/**
	 * 
	 * @return The score as a String
	 */
	public static String getScoreString() {
		return String.valueOf(score.get());
	}
	
	/**
	 * asString() creates a StringBinding that holds the value of score turned into a String.
	 * If the value of score changes, the value of StringBinding will be updated automatically.
	 * @return score as StringBinding
	 */
	public static StringBinding getBinding() {
		return score.asString();
		
	}
	
	/**
	 * Used to increment score and set the new score based on the actions of the frog.
	 * @param points
	 */
	public static void changeScore(double points) {
		int newScore = score.get();
		if (points < 0) {
			newScore += points;
		} else {
			newScore += points * (1 + TimeController.getProgressbarValue());
		}
		score.set(newScore);
	}
	
	/**
	 * Read the scores from the CSV file 
	 * Uses try/catch
	 * @return 
	 */
	public static String getHighScores() {
		try {		
			return ScoreModel.read(SCORES_PATH);			
		} catch (ParseException e) {
            return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
}
