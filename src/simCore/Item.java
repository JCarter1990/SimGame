/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simcore;

import java.util.List;

/**
 *
 * @author JCarter
 */
class Item
{
    String name;
    String description;
    String colour;
    int weight;
    int size;
    List components;
    List slotType;
    List tags;
    
    String getName()
    {
        return this.name;
    }
    
    String getFullName()
    {
        if(this.colour == null)
            return this.name;
        else
            return this.colour + " " + this.name;
    }
    
    int getWeight()
    {
        return this.weight;
    }
    
    String getColour()
    {
        return this.colour;
    }
}