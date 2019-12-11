/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simcore;

import javafx.scene.text.TextFlow;

/**
 *
 * @author JCarter
 */
class Enterable
{
    String name;
    boolean isOpen;
    boolean isLocked;
    String id;
    
    String getName()
    {
        return this.name;
    }
    
    String getID()
    {
        return this.id;
    }
    
    boolean getIsLocked()
    {
        return this.isLocked;
    }

    boolean getIsOpen()
    {
        return this.isOpen;
    }

    void toggleOpen(boolean toggle)
    {
        this.isOpen = toggle;
    }

    void toggleLock(boolean toggle)
    {
        this.isLocked = toggle;
    }

    boolean getState(TextFlow inputHistory)
    {
        return false;
    }
}
