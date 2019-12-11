/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simcore;

import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 *
 * @author JCarter
 */
class Door extends Enterable
{
    Door(String name, boolean openState, boolean lockState, String id)
    {
        this.name = name;
        this.isOpen = openState;
        this.isLocked = lockState;
        this.id = id;
    }
    
    @Override
    boolean getState(TextFlow inputHistory)
    {
        boolean state = false;
        
        if(this.isOpen == false && this.isLocked == true)
        {
            inputHistory.getChildren().add(
                                        new Text("The door is locked." + "\n"));
            state = false;
        }
        else if(this.isOpen == true && this.isLocked == false)
        {
            state = true;
        }
        else if(this.isOpen == false && this.isLocked == false)
        {
            inputHistory.getChildren().add(
                        new Text("You open the door and walk through." + "\n"));
            this.isOpen = true;
            state = true;
        }
        
        return state;
    }
}