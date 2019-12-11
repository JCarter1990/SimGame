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
class Container extends Item
{
    List contents;
    
    Container(String name, String description, String colour,
    int weight, int size, List components, List slotType, List tags,
    List contents)
    {
        this.name = name;
        this.description = description;
        this.colour = colour;
        this.weight = weight;
        this.size = size;
        this.components = components;
        this.slotType = slotType;
        this.tags = tags;
        this.contents = contents;
    }
    
    List<Item> getContents()
    {
        return this.contents;
    }
    
    void addItem(Item anItem)
    {
        this.contents.add(anItem);
    }
    
    void removeItem(Item anItem)
    {
        this.contents.remove(anItem);
    }
}
