package mns.java.PenduJAVA;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    class Hangman{
        private char word[] = new char[5];
        private char hidden[] = new char[5];
        private int hanged = 10;
        public Hangman(){
    		word[0] = 't';
    		word[1] = 'a';
    		word[2] = 't';
    		word[3] = 'o';
    		word[4] = 'o';
    		for(int i = 0; i < word.length; i++){
    			hidden[i] = '*';
    		}
    	}
        public boolean win(){
            int count = 0;
            boolean value = false;
            for(int i = 0; i < word.length; i++){
                if(hidden[i] == '*'){
                    value = true;
                    break;
                }
            }
            return value;
        }
        public boolean isInside(char letter){
            boolean value = false;
            for(int i = 0; i < word.length; i++){
                if(word[i] == letter){
                    value = true;
                    break;
                }
            }
            return value;
        }
        public boolean isHanged(){
            boolean value = false;
            if(hanged <= 0){
                value = true;
            }
            return value;
        }
        public void displayWord(){
            System.out.print("The word is: ");
            for(int i = 0; i < hidden.length; i++){
                System.out.print(hidden[i]);
            }
        }
        public void replaceChar(char letter){
            for(int i = 0; i < word.length; i++){
                if(word[i] == letter){
                    hidden[i] = letter;
                }
            }
        }
        
        
    }
    

    public static void main(String[] args) {
        launch();
    }

}