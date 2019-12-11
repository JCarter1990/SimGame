/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simcore;

import java.util.List;
import java.util.Map;

/**
 *
 * @author JCarter
 */
class Pressable extends ItemKey
{
    Pressable(String name, String description, String colour,
    int weight, int size, List components, List slotType, List tags,
    String ID)
    {
        super(name, description, colour, weight, size, components, slotType,
              tags, ID);
    }
    
    void onPress(Map<Integer, Door> doors)
    {
        for(Door correctDoor : doors.values())
        {
            if(this.id.equals(correctDoor.getID()))
            {
                if(correctDoor.getIsLocked() == true)
                {
                    //print("you hear a door unlock somewhere.")
                    correctDoor.toggleLock(false);
                }
                else
                {
                    if(correctDoor.getIsOpen() == true)
                    {
                        //print("you should close the door first.")
                    }
                    else
                    {
                        //print("you hear a door lock somewhere.")
                        correctDoor.toggleLock(true);
                    }
                }
            }
        }
    }
}