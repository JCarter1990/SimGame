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
class ItemKey extends Item
{
    String id;
    
    ItemKey(String name, String description, String colour,
    int weight, int size, List components, List slotType, List tags,
    String id)
    {
        this.name = name;
        this.description = description;
        this.colour = colour;
        this.weight = weight;
        this.size = size;
        this.components = components;
        this.slotType = slotType;
        this.tags = tags;
        this.id = id;
    }
    
    String getID()
    {
        return this.id;
    }
}
