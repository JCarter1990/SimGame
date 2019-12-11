/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simcore;

/**
 *
 * @author JCarter
 */
class BodyPart
{
    private Item equipedItem;
    private Item heldItem;
    
    BodyPart()
    {
    }
    
    BodyPart(Item equipItem, Item holdItem)
    {
        this.equipedItem = equipItem;
        this.heldItem = holdItem;
    }
    
    void equipItem(Item anItem)
    {
        this.equipedItem = anItem;
    }
    
    void removeItem()
    {
        this.equipedItem = null;
    }
    
    Item getEquipedItem()
    {
        return this.equipedItem;
    }
    
    void holdItem(Item anItem)
    {
        this.heldItem = anItem;
    }
    
    void dropItem()
    {
        this.heldItem = null;
    }
    
    Item getHeldItem()
    {
        return this.heldItem;
    }
}
