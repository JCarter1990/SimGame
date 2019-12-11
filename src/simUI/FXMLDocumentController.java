/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simui;

import simcore.SimCoord;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

/**
 *
 * @author JCarter
 */
public class FXMLDocumentController implements Initializable
{
    @FXML
    private TextField userInputField;
    @FXML
    private TextFlow roomInfoTitlePanel;
    @FXML
    private TextFlow roomInfoPanel;
    @FXML
    private TextFlow inputHistory;
    @FXML
    private ScrollPane inputHistoryScroll;
    
    private Text roomTitle;
    private Text lineBreak;
    private Text roomDescription;
    private Text roomContents;
    
    private String lastTypedString;
    
    @FXML
    private void handleExitProgram(ActionEvent event)
    {
        System.exit(0);
    }
    
    @FXML
    private void handleUserInput(ActionEvent event)
    {
        if(!userInputField.getText().trim().isEmpty())
        {
            inputHistory.getChildren().add(new Text(userInputField.getText() + "\n"));
            inputHistoryScroll.setVvalue(1);
            
            String[] cutString = userInputField.getText().split(" ");
            switch (cutString.length)
            {
                case 1:
                    SimCoord.parser(cutString[0], null, null, null, null, null, inputHistory);
                    break;
                case 2:
                    SimCoord.parser(cutString[0], cutString[1], null, null, null, null, inputHistory);
                    break;
                case 3:
                    SimCoord.parser(cutString[0], cutString[1], cutString[2], null, null, null, inputHistory);
                    break;
                case 4:
                    SimCoord.parser(cutString[0], cutString[1], cutString[2], cutString[3], null, null, inputHistory);
                    break;
                case 5:
                    SimCoord.parser(cutString[0], cutString[1], cutString[2], cutString[3], cutString[4], null, inputHistory);
                    break;
                case 6:
                    SimCoord.parser(cutString[0], cutString[1], cutString[2], cutString[3], cutString[4], cutString[5], inputHistory);
                    break;
                default:
                    break;
            }
            
            lastTypedString = userInputField.getText();
            userInputField.clear();
            this.updateDisplay();
        }
    }
    
    @FXML
    private void lastUserInput(KeyEvent keyEvent)
    {
        if (keyEvent.getCode() == KeyCode.DOWN) {
            userInputField.setText(lastTypedString);
        }
    }
    
    private void updateDisplay()
    {
        roomTitle.setText("===[" + SimCoord.getPlayerLocationTitle() + "]===" + "\n");
        roomDescription.setText(SimCoord.getPlayerLocationDesc() + "\n");
        roomContents.setText(SimCoord.getPlayerLocationContents());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        roomTitle = new Text("===[" + SimCoord.getPlayerLocationTitle() + "]===");
        roomTitle.setFont(Font.font("Courier New", 22));
        
        roomInfoTitlePanel.getChildren().add(roomTitle);
        roomInfoTitlePanel.setTextAlignment(TextAlignment.CENTER);

        roomDescription = new Text(SimCoord.getPlayerLocationDesc() + "\n");
        roomDescription.setFont(Font.font("Courier New", 18));
        
        lineBreak = new Text("\n");
        
        roomContents = new Text(SimCoord.getPlayerLocationContents());
        roomContents.setFont(Font.font("Courier New", 18));
        
        roomInfoPanel.getChildren().addAll(roomDescription, lineBreak, roomContents);
    }
}
