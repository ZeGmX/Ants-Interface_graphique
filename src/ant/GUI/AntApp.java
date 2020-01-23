package ant.GUI;


import ant.Simulator;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class AntApp extends Application {

	private static String[] filenames = {"", "", ""};
	public boolean pause = false;
    private static boolean firstPlay;
    private final static int SIZE = 1000;
    private AntAnimation mainAnimation;
    public static Text redScore;
    public static Text blackScore;
    	
	private void setButtonNameFromFile(Button button, String filename) {
		int indexLastSlash = 0;
		char[] fileNameChar = filename.toCharArray();
		for (int i = 0 ; i < fileNameChar.length ; i++) {
			if (fileNameChar[i] == '/') {
				indexLastSlash = i;
			}
		}
		char[] name = new char[fileNameChar.length - indexLastSlash - 1];
		for (int i = indexLastSlash + 1 ; i < fileNameChar.length; i++) {
			name[i - indexLastSlash - 1] = fileNameChar[i];
		}
		button.setText(new String(name));
    }
	
	
    @Override
    public void start(Stage stage) throws Exception {
    	Pane root = new FlowPane();
		Scene scene = new Scene(root);
      	stage.setScene(scene);
      	Canvas canvas = new Canvas( SIZE, SIZE );
        root.getChildren().add(canvas);
        
        Button buttonClose = new Button("Close");
        buttonClose.setFocusTraversable(false);
        buttonClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	stage.close();
            }
        });
        
        Button reset = new Button("Reset");
        reset.setFocusTraversable(false);
        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	if(!firstPlay) {
	            	mainAnimation.stop();
	            	mainAnimation = new AntAnimation(filenames, canvas, stage);
	            	mainAnimation.start();
            	}
            }
        });
        
        Button buttonPlay = new Button("Play");
        buttonPlay.setFocusTraversable(false);
        buttonPlay.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	if (filenames[0] == "" || filenames[1] == "" || filenames[2] == "") {
            		System.out.println("Please select files\n");
            	} else {
            		if (firstPlay) {

            			firstPlay = false;
            			
            			mainAnimation = new AntAnimation(filenames, canvas, stage);
            		}
            		mainAnimation.start();

            	}
            }
        });
        
        Button buttonPause = new Button("Pause");
        buttonPause.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	mainAnimation.stop();
            }
        });
        buttonPause.setFocusTraversable(false);
        
        Button buttonEnd = new Button("End");
        buttonEnd.setFocusTraversable(false);
        buttonEnd.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	mainAnimation.stop();
            	Simulator.oneGameFrom(Simulator.currNbTurn + 1);
            	mainAnimation.end();
            	
            }
        });
        
        redScore = new Text();
        redScore.setText("Red Score : 0  ");
        root.getChildren().add(redScore);
        
        blackScore = new Text();
        blackScore.setText("Black Score : 0  ");
        root.getChildren().add(blackScore);
        
        FileChooser red_prog = new FileChooser();
        red_prog.getExtensionFilters().addAll(
        	     new FileChooser.ExtensionFilter("Brain", "*.brain")
        	);
        red_prog.setTitle("Programme des fourmis rouges");
        
        FileChooser black_prog = new FileChooser();
        black_prog.getExtensionFilters().addAll(
       	     new FileChooser.ExtensionFilter("Brain", "*.brain")
       	);
        black_prog.setTitle("Programme des fourmis noir");
        
        FileChooser map = new FileChooser();
        map.getExtensionFilters().addAll(
       	     new FileChooser.ExtensionFilter("World", "*.world")
       	);
        map.setTitle("Fichier de la map");
        
        Button buttonRedBrain = new Button("Select Red Ant Brain");
        buttonRedBrain.setFocusTraversable(false);
        buttonRedBrain.setStyle("-fx-background-color: #ff1a1a");
        if (filenames[1] != "") {
        	buttonRedBrain.setStyle("-fx-background-color: #b4cc04");
        	setButtonNameFromFile(buttonRedBrain, filenames[1]);
        }
        buttonRedBrain.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	File redBrain = red_prog.showOpenDialog(stage);
            	filenames[1] = redBrain.getAbsolutePath();
            	buttonRedBrain.setStyle("-fx-background-color: #b4cc04");
            	setButtonNameFromFile(buttonRedBrain, filenames[1]);
            }
        });
        Button buttonBlackBrain = new Button("Select Black Ant Brain");
        buttonBlackBrain.setFocusTraversable(false);
        buttonBlackBrain.setStyle("-fx-background-color: #ff1a1a");
        if (filenames[2] != "") {
        	buttonBlackBrain.setStyle("-fx-background-color: #b4cc04");
        	setButtonNameFromFile(buttonBlackBrain, filenames[2]);
        }
        buttonBlackBrain.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	try {
            		File blackBrain = black_prog.showOpenDialog(stage);
            		filenames[2] = blackBrain.getAbsolutePath();
            		buttonBlackBrain.setStyle("-fx-background-color: #b4cc04");
            		setButtonNameFromFile(buttonBlackBrain, filenames[2]);            		
            	} catch(Throwable exc) {
            		System.out.println("Failure while selecting file: " + exc.getMessage());
            	}
            }
        });
        
        Button buttonWorldFile = new Button("Select World File");
        buttonWorldFile.setFocusTraversable(false);
        buttonWorldFile.setStyle("-fx-background-color: #ff1a1a");
        if (filenames[0] != "") {
        	buttonWorldFile.setStyle("-fx-background-color: #b4cc04");
        	setButtonNameFromFile(buttonWorldFile, filenames[0]);
        }
        buttonWorldFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
            	File fileWorld = map.showOpenDialog(stage);
            	filenames[0] = fileWorld.getAbsolutePath();
            	buttonWorldFile.setStyle("-fx-background-color: #b4cc04");
            	setButtonNameFromFile(buttonWorldFile, filenames[0]);
            }
        });
        
        root.getChildren().addAll(buttonClose,reset, buttonPlay, buttonPause, buttonEnd, 
        		buttonRedBrain, buttonBlackBrain, buttonWorldFile);
          
        
        stage.show();
    }
   
    

    public static void main(String[] args) {
    	firstPlay = true;
    	for (int k = 0 ; k < args.length ; k++) {
    		filenames[k] = new String(args[k]);
    	}
        launch(args);
    }
}