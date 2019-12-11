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
class BuildingPiece
{
    String colour;
    List contents;
    Enterable gateway;
    Enterable gateBlock;
    Pressable control;
    
    void setColour(String newColour)
    {
        this.colour = newColour;
    }
    
    String getColour()
    {
        return this.colour;
    }

    void addContents(Item anItem)
    {
        this.contents.add(anItem);
    }

    void removeContents(Item anItem)
    {
        this.contents.remove(anItem);
    }

    List getContents()
    {
        return this.contents;
    }
    
    Enterable getGateway()
    {
        return this.gateway;
    }
    
    Enterable getGateBlock()
    {
        return this.gateBlock;
    }
}
