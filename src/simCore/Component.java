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
class Component extends Item
{
    int amount;
    
    Component(String name, String description, String colour,
    int weight, int size, List components, List slotType, List tags,
    int amount)
    {
        this.name = name;
        this.description = description;
        this.colour = colour;
        this.weight = weight;
        this.size = size;
        this.components = components;
        this.slotType = slotType;
        this.tags = tags;
        this.amount = amount;
    }
}
