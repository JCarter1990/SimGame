/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simcore;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import simcore.BodyPart;
import simcore.BodyPart;
import simcore.Cell;
import simcore.Cell;
import simcore.Container;
import simcore.Container;
import simcore.Enterable;
import simcore.Enterable;
import simcore.Item;
import simcore.Item;
import simcore.ItemKey;
import simcore.ItemKey;

/**
 *
 * @author JCarter
 */
class Human extends Entity
{
    BodyPart head;
    BodyPart upperBody;
    BodyPart leftShoulder;
    BodyPart leftArm;
    BodyPart leftHand;
    BodyPart rightShoulder;
    BodyPart rightArm;
    BodyPart rightHand;
    BodyPart back;
    BodyPart lowerBody;
    BodyPart leftLeg;
    BodyPart leftFoot;
    BodyPart rightLeg;
    BodyPart rightFoot;
    
    Human(String name, String description, int strength, int endurance,
    int agility, int dexterity, int intelligence, int willpower, Cell location,
    int currentWeight, int maxWeight, int size, int x, int y, int z,
    BodyPart head, BodyPart upperBody, BodyPart leftShoulder, BodyPart leftArm,
    BodyPart leftHand, BodyPart rightShoulder, BodyPart rightArm,
    BodyPart rightHand, BodyPart back, BodyPart lowerBody, BodyPart leftLeg,
    BodyPart leftFoot, BodyPart rightLeg, BodyPart rightFoot)
    {
        super(name, description, strength, endurance, agility, dexterity,
        intelligence, willpower, location, currentWeight, maxWeight, size,
        x, y, z);
        this.head = head;
        this.upperBody = upperBody;
        this.leftShoulder = leftShoulder;
        this.leftArm = leftArm;
        this.leftHand = leftHand;
        this.rightShoulder = rightShoulder;
        this.rightArm = rightArm;
        this.rightHand = rightHand;
        this.back = back;
        this.lowerBody = lowerBody;
        this.leftLeg = leftLeg;
        this.leftFoot = leftFoot;
        this.rightLeg = rightLeg;
        this.rightFoot = rightFoot;
    }
    
    List<BodyPart> getSlots()
    {
        List slotList = new ArrayList();
        
        slotList.add(this.head);
        slotList.add(this.upperBody);
        slotList.add(this.leftShoulder);
        slotList.add(this.leftArm);
        slotList.add(this.leftHand);
        slotList.add(this.rightShoulder);
        slotList.add(this.rightArm);
        slotList.add(this.rightHand);
        slotList.add(this.back);
        slotList.add(this.lowerBody);
        slotList.add(this.leftLeg);
        slotList.add(this.leftFoot);
        slotList.add(this.rightLeg);
        slotList.add(this.rightFoot);
        
        return slotList;
    }
    
    List<BodyPart> getHands()
    {
        List handList = new ArrayList();
        
        handList.add(this.rightHand);
        handList.add(this.leftHand);
        
        return handList;
    }
    
    void getItem(int playerWeight, Cell location, String itemColour,
    String item, String containerColour, String container,
    TextFlow inputHistory)
    {
        //Get item from room.
        if(itemColour == null & containerColour == null & container == null)
        {
            boolean hasFound = false;
            
            for(Item anItem : location.getContainer())
            {
                if(item.equalsIgnoreCase(anItem.getName()))
                {
                    this.checkHands(playerWeight, location, anItem,
                                    inputHistory);
                    hasFound = true;
                    break;
                }
            }
            if(hasFound == false)
            {
                //print("Item doesnt exist.")
            }
        }
        //Get coloured item from room.
        else if(containerColour == null & container == null)
        {
            boolean hasFound = false;
            
            for(Item anItem : location.getContainer())
            {
                if(itemColour.equalsIgnoreCase(anItem.getColour()))
                {
                    if(item.equalsIgnoreCase(anItem.getName()))
                    {
                        this.checkHands(playerWeight, location, anItem,
                                        inputHistory);
                        hasFound = true;
                        break;
                    }
                }
            }
            if(hasFound == false)
            {
                //print("Item doesnt exist.")
            }
        }
        //Get item from container.
        else if(itemColour == null & containerColour == null)
        {
            boolean hasFound = false;
            
            for(Item anItem : location.getContainer())
            {
                Container foundItem = (Container)anItem;
                
                if(container.equalsIgnoreCase(foundItem.getName()))
                {
                    for(Item containedItem : foundItem.getContents())
                    {
                        if(item.equalsIgnoreCase(containedItem.getName()))
                        {
                            this.checkHands(playerWeight, foundItem,
                                            containedItem, inputHistory);
                            hasFound = true;
                            break;
                        }
                    }
                }
            }
            if(hasFound == false)
            {
                //print("Item doesnt exist.")
            }
        }
        //Get item from coloured container.
        else if(itemColour == null)
        {
            boolean hasFound = false;
                        
            for(Item anItem : location.getContainer())
            {
                Container foundItem = (Container)anItem;
                
                if(containerColour.equalsIgnoreCase(anItem.getColour()))
                {
                    if(container.equalsIgnoreCase(anItem.getName()))
                    {
                        for(Item containedItem : foundItem.getContents())
                        {
                            if(item.equalsIgnoreCase(containedItem.getName()))
                            {
                                this.checkHands(playerWeight, foundItem,
                                                containedItem, inputHistory);
                                hasFound = true;
                                break;
                            }
                        }
                    }
                }
            }
            if(hasFound == false)
            {
                //print("Item doesnt exist.")
            }
        }
        //Get coloured item from container.
        else if(containerColour == null)
        {
            boolean hasFound = false;
                        
            for(Item anItem : location.getContainer())
            {
                Container foundItem = (Container)anItem;
                
                if(container.equalsIgnoreCase(anItem.getName()))
                {
                    for(Item containedItem : foundItem.getContents())
                    {
                        if(itemColour.equalsIgnoreCase
                                     (containedItem.getColour()))
                        {
                            if(item.equalsIgnoreCase(containedItem.getName()))
                            {
                                this.checkHands(playerWeight, foundItem,
                                                containedItem, inputHistory);
                                hasFound = true;
                                break;
                            }
                        }
                    }
                }
            }
            if(hasFound == false)
            {
                //print("Item doesnt exist.")
            }
        }
        //Get coloured item from coloured container.
        else
        {
            boolean hasFound = false;
                        
            for(Item anItem : location.getContainer())
            {
                Container foundItem = (Container)anItem;
                
                if(containerColour.equalsIgnoreCase(anItem.getColour()))
                {
                    if(container.equalsIgnoreCase(anItem.getName()))
                    {
                        for(Item containedItem : foundItem.getContents())
                        {
                            if(itemColour.equalsIgnoreCase
                                         (containedItem.getColour()))
                            {
                                if(item.equalsIgnoreCase
                                       (containedItem.getName()))
                                {
                                    this.checkHands(playerWeight, foundItem,
                                                   containedItem, inputHistory);
                                    hasFound = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if(hasFound == false)
            {
                //print("Item doesnt exist.")
            }
        }
    }
    
    void getItemHeld(int playerWeight, List<BodyPart> location,
    String itemColour, String item,String containerColour, String container,
    TextFlow inputHistory)
    {
        //Get item from held container
        if(itemColour == null & containerColour == null)
        {
            boolean hasFound = false;
            
            for(BodyPart aBodyPart : location)
            {
                Container heldContainer = (Container) aBodyPart.getHeldItem();
                
                if(container.equalsIgnoreCase(heldContainer.getName()))
                {
                    for(Item anItem : heldContainer.getContents())
                    {
                        if(item.equalsIgnoreCase(anItem.getName()))
                        {
                            this.checkHands(playerWeight, heldContainer, anItem,
                                            inputHistory);
                            hasFound = true;
                            break;
                        }
                    }
                }
            }
            if(hasFound == false)
            {
                //print("Item doesnt exist.")
            }
        }
        //Get colour item from held container
        else if(containerColour == null)
        {
            boolean hasFound = false;
            
            for(BodyPart aBodyPart : location)
            {
                Container heldContainer = (Container) aBodyPart.getHeldItem();
                
                if(container.equalsIgnoreCase(heldContainer.getName()))
                {
                    for(Item anItem : heldContainer.getContents())
                    {
                        if(itemColour.equalsIgnoreCase(anItem.getColour()))
                        {
                            if(item.equalsIgnoreCase(anItem.getName()))
                            {
                                this.checkHands(playerWeight, heldContainer,
                                                anItem, inputHistory);
                                hasFound = true;
                                break;
                            }
                        }
                    }
                }
            }
            if(hasFound == false)
            {
                //print("Item doesnt exist.")
            }
        }

        //Get item from held colour container
        else if(itemColour == null)
        {
            boolean hasFound = false;
            
            for(BodyPart aBodyPart : location)
            {
                Container heldContainer = (Container) aBodyPart.getHeldItem();
                
                if(containerColour.equalsIgnoreCase(heldContainer.getColour()))
                {
                    if(container.equalsIgnoreCase(heldContainer.getName()))
                    {
                        for(Item anItem : heldContainer.getContents())
                        {
                            if(item.equalsIgnoreCase(anItem.getName()))
                            {
                                this.checkHands(playerWeight, heldContainer,
                                                anItem, inputHistory);
                                hasFound = true;
                                break;
                            }
                        }
                    }
                }
            }
            if(hasFound == false)
            {
                //print("Item doesnt exist.")
            }
        }
        //Get colour item from held colour container
        else
        {
            boolean hasFound = false;
            
            for(BodyPart aBodyPart : location)
            {
                Container heldContainer = (Container) aBodyPart.getHeldItem();
                
                if(containerColour.equalsIgnoreCase(heldContainer.getColour()))
                {
                    if(container.equalsIgnoreCase(heldContainer.getName()))
                    {
                        for(Item anItem : heldContainer.getContents())
                        {
                            if(itemColour.equalsIgnoreCase(anItem.getColour()))
                            {
                                if(item.equalsIgnoreCase(anItem.getName()))
                                {
                                    this.checkHands(playerWeight, heldContainer,
                                                    anItem, inputHistory);
                                    hasFound = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if(hasFound == false)
            {
                //print("Item doesnt exist.")
            }
        }
    }
    
    //Drop item
    void dropItem(Cell location, String itemColour, String item,
                  TextFlow inputHistory)
    {
        if(itemColour == null)
        {
            for(BodyPart aPart : this.getHands())
            {
                if(item.equalsIgnoreCase(aPart.getHeldItem().getName()))
                {
                    location.addItem(aPart.getHeldItem());
                    aPart.dropItem();
                }
            }
        }
        else
        {
            for(BodyPart aPart : this.getHands())
            {
                if(itemColour.equalsIgnoreCase(aPart.getHeldItem().getColour()))
                {
                    if(item.equalsIgnoreCase(aPart.getHeldItem().getName()))
                    {
                        location.addItem(aPart.getHeldItem());
                        aPart.dropItem();
                    }
                }
            }
        }
    }
    
    void putItem(Cell location, String itemColour, String item,
    String containerColour, String container, TextFlow inputHistory)
    {
        //Put item in container(room)
        if(itemColour == null & containerColour == null)
        {
            for(BodyPart aPart : this.getHands())
            {
                if(item.equalsIgnoreCase(aPart.getHeldItem().getName()))
                {
                    for(Item anItem : location.getContainer())
                    {
                        if(container.equalsIgnoreCase(anItem.getName()))
                        {
                            Container aContainer = (Container) anItem;
                            
                            aContainer.addItem(aPart.getHeldItem());
                            aPart.dropItem();
                        }
                    }
                }
            }
        }
        //Put item in colour container(room)
        else if(itemColour == null)
        {
            for(BodyPart aPart : this.getHands())
            {
                if(item.equalsIgnoreCase(aPart.getHeldItem().getName()))
                {
                    for(Item anItem : location.getContainer())
                    {
                        if(containerColour.equalsIgnoreCase(anItem.getColour()))
                        {
                            if(container.equalsIgnoreCase(anItem.getName()))
                            {
                                Container aContainer = (Container) anItem;

                                aContainer.addItem(aPart.getHeldItem());
                                aPart.dropItem();
                            }
                        }
                    }
                }
            }
        }
        //Put colour item in container(room)
        else if(containerColour == null)
        {
            for(BodyPart aPart : this.getHands())
            {
                if(itemColour.equalsIgnoreCase(aPart.getHeldItem().getColour()))
                {
                    if(item.equalsIgnoreCase(aPart.getHeldItem().getName()))
                    {
                        for(Item anItem : location.getContainer())
                        {
                            if(container.equalsIgnoreCase(anItem.getName()))
                            {
                                Container aContainer = (Container) anItem;

                                aContainer.addItem(aPart.getHeldItem());
                                aPart.dropItem();
                            }
                        }
                    }
                }
            }
        }
        //Put colour item in colour container(room)
        else
        {
            for(BodyPart aPart : this.getHands())
            {
                if(itemColour.equalsIgnoreCase(aPart.getHeldItem().getColour()))
                {
                    if(item.equalsIgnoreCase(aPart.getHeldItem().getName()))
                    {
                        for(Item anItem : location.getContainer())
                        {
                            if(containerColour.equalsIgnoreCase
                                              (anItem.getColour()))
                            {
                                if(container.equalsIgnoreCase(anItem.getName()))
                                {
                                    Container aContainer = (Container) anItem;

                                    aContainer.addItem(aPart.getHeldItem());
                                    aPart.dropItem();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    void putItemHeld(String itemColour, String item,
    String containerColour, String container, TextFlow inputHistory)
    {
        //Put item in container(player)
        if(itemColour == null & containerColour == null)
        {
            for(BodyPart aPart : this.getHands())
            {
                if(item.equalsIgnoreCase(aPart.getHeldItem().getName()))
                {
                    for(BodyPart containerPart : this.getHands())
                    {
                        if(container.equalsIgnoreCase
                                    (containerPart.getHeldItem().getName()))
                        {
                            Container aContainer = 
                            (Container) containerPart.getHeldItem();
                            
                            aContainer.addItem(aPart.getHeldItem());
                            aPart.dropItem();
                        }
                    }
                }
            }
        }
        //Put item in colour container(player)
        else if(itemColour == null)
        {
            for(BodyPart aPart : this.getHands())
            {
                if(item.equalsIgnoreCase(aPart.getHeldItem().getName()))
                {
                    for(BodyPart containerPart : this.getHands())
                    {
                        if(containerColour.equalsIgnoreCase
                                      (containerPart.getHeldItem().getColour()))
                        {
                            if(container.equalsIgnoreCase
                                        (containerPart.getHeldItem().getName()))
                            {
                                Container aContainer = 
                                (Container) containerPart.getHeldItem();

                                aContainer.addItem(aPart.getHeldItem());
                                aPart.dropItem();
                            }
                        }
                    }
                }
            }
        }
        //Put colour item in container(player)
        else if(containerColour == null)
        {
            for(BodyPart aPart : this.getHands())
            {
                if(itemColour.equalsIgnoreCase(aPart.getHeldItem().getColour()))
                {
                    if(item.equalsIgnoreCase(aPart.getHeldItem().getName()))
                    {
                        for(BodyPart containerPart : this.getHands())
                        {
                            if(container.equalsIgnoreCase
                                        (containerPart.getHeldItem().getName()))
                            {
                                Container aContainer = 
                                (Container) containerPart.getHeldItem();

                                aContainer.addItem(aPart.getHeldItem());
                                aPart.dropItem();
                            }
                        }
                    }
                }
            }
        }
        //Put colour item in colour container(player)
        else
        {
            for(BodyPart aPart : this.getHands())
            {
                if(itemColour.equalsIgnoreCase(aPart.getHeldItem().getColour()))
                {
                    if(item.equalsIgnoreCase(aPart.getHeldItem().getName()))
                    {
                        for(BodyPart containerPart : this.getHands())
                        {
                            if(containerColour.equalsIgnoreCase
                                      (containerPart.getHeldItem().getColour()))
                            {
                                if(container.equalsIgnoreCase
                                        (containerPart.getHeldItem().getName()))
                                {
                                    Container aContainer = 
                                    (Container) containerPart.getHeldItem();

                                    aContainer.addItem(aPart.getHeldItem());
                                    aPart.dropItem();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    void checkHands(int playerWeight, Cell location, Item foundItem,
                    TextFlow inputHistory)
    {
        if(rightHand.getHeldItem() == null)
        {
            rightHand.holdItem(foundItem);
            location.removeItem(foundItem);
            playerWeight += foundItem.getWeight();
            inputHistory.getChildren()
            .add(new Text("You picked up the " + foundItem.getName() 
            + " with your right hand." + "\n"));
        }
        else
        {
            if(leftHand.getHeldItem() == null)
            {
                leftHand.holdItem(foundItem);
                location.removeItem(foundItem);
                playerWeight += foundItem.getWeight();
                inputHistory.getChildren()
                .add(new Text("You picked up the " + foundItem.getName() 
                + " with your left hand." + "\n"));
            }
            else
            {
                inputHistory.getChildren()
                .add(new Text("Both hands are holding something." + "\n"));
            }
        }
    }

    void checkHands(int playerWeight, Container aContainer, Item foundItem,
                    TextFlow inputHistory)
    {
        if(rightHand.getHeldItem() == null)
        {
            rightHand.holdItem(foundItem);
            aContainer.removeItem(foundItem);
            playerWeight += foundItem.getWeight();
            inputHistory.getChildren()
            .add(new Text("You picked up the " + foundItem.getName() 
            + " with your right hand." + "\n"));
        }
        else
        {
            if(leftHand.getHeldItem() == null)
            {
                leftHand.holdItem(foundItem);
                aContainer.removeItem(foundItem);
                playerWeight += foundItem.getWeight();
                inputHistory.getChildren()
                .add(new Text("You picked up the " + foundItem.getName() 
                + " with your left hand." + "\n"));
            }
            else
            {
                inputHistory.getChildren()
                .add(new Text("Both hands are holding something." + "\n"));
            }
        }
    }
    
    void openDoor(Enterable door, TextFlow inputHistory)
    {
        if(door == null)
        {
            inputHistory.getChildren().add(
                                    new Text("There is no door there." + "\n"));
        }
        else
        {
            if(door.getIsLocked() == true)
                inputHistory.getChildren().add(
                                        new Text("The door is locked." + "\n"));
            else
            {
                if(door.getIsOpen() == true)
                    inputHistory.getChildren().add(
                                  new Text("the door is already open." + "\n"));
                else
                {
                    inputHistory.getChildren().add(
                                         new Text("you open the door." + "\n"));
                    door.toggleOpen(true);
                }
            }
        }
    }
    
    void closeDoor(Enterable door, TextFlow inputHistory)
    {
        if(door == null)
        {
            inputHistory.getChildren().add(
                                    new Text("There is no door there." + "\n"));
        }
        else
        {
            if(door.getIsLocked() == true)
            {
                inputHistory.getChildren().add(
                          new Text("you should unlock the door first." + "\n"));
            }
            else
            {
                if(door.getIsOpen() == false)
                {
                    inputHistory.getChildren().add(
                                new Text("the door is already closed." + "\n"));
                }
                else
                {
                    inputHistory.getChildren().add(
                                        new Text("you close the door." + "\n"));
                    door.toggleOpen(false);
                }
            }
        }
    }
    
    void lock(Enterable door, String keyName, TextFlow inputHistory)
    {
        if(door == null)
        {
            inputHistory.getChildren().add(new Text("There is no door there." + "\n"));
        }
        else
        {
            if(door.getIsLocked() == true)
            {
                inputHistory.getChildren().add(new Text("the door is already locked." + "\n"));
            }
            else if(door.getIsOpen() == true)
            {
                inputHistory.getChildren().add(new Text("you should close the door first." + "\n"));
            }
            else
            {
                System.out.println("test");
                if(this.rightHand.getHeldItem() instanceof ItemKey)
                {
                    System.out.println("test2");
                    ItemKey keyItem = (ItemKey) this.rightHand.getHeldItem();
                    
                    if(keyName.equalsIgnoreCase(keyItem.getName()))
                    {
                        if(keyItem.getID().equals(door.getID()))
                        {
                            inputHistory.getChildren().add(new Text("door locked." + "\n"));
                            door.toggleLock(true);
                        }
                        else if(!keyItem.getID().equals(door.getID()))
                        {
                            inputHistory.getChildren().add(new Text("that isnt the right key." + "\n"));
                        }
                    }
                }
                else if(this.leftHand.getHeldItem() instanceof ItemKey)
                {
                    System.out.println("test3");
                    ItemKey keyItem = (ItemKey) this.leftHand.getHeldItem();
                    
                    if(keyName.equalsIgnoreCase(keyItem.getName()))
                    {
                        if(keyItem.getID().equals(door.getID()))
                        {
                            inputHistory.getChildren().add(new Text("door locked." + "\n"));
                            door.toggleLock(true);
                        }
                        else if(!keyItem.getID().equals(door.getID()))
                        {
                            inputHistory.getChildren().add(new Text("that isnt the right key." + "\n"));
                        }
                    }
                }
            }
        }
    }

    void unlock(Enterable door, String keyName, TextFlow inputHistory)
    {
        
        if(door == null)
        {
            inputHistory.getChildren().add(new Text("There is no door there." + "\n"));
        }
        else
        {
            if(door.getIsLocked() == false)
            {
                inputHistory.getChildren().add(new Text("the door is already unlocked." + "\n"));
            }
            else
            {
                if(this.rightHand.getHeldItem() instanceof ItemKey)
                {
                    ItemKey keyItem = (ItemKey) this.rightHand.getHeldItem();
                    
                    if(keyName.equalsIgnoreCase(keyItem.getName()))
                    {
                        if(keyItem.getID().equals(door.getID()))
                        {
                            inputHistory.getChildren().add(new Text("door unlocked." + "\n"));
                            door.toggleLock(false);
                        }
                        else if(!keyItem.getID().equals(door.getID()))
                        {
                            inputHistory.getChildren().add(new Text("that isnt the right key." + "\n"));
                        }
                    }
                }
                else if(this.leftHand.getHeldItem() instanceof ItemKey)
                {
                    ItemKey keyItem = (ItemKey) this.leftHand.getHeldItem();
                    
                    if(keyName.equalsIgnoreCase(keyItem.getName()))
                    {
                        if(keyItem.getID().equals(door.getID()))
                        {
                            inputHistory.getChildren().add(new Text("door unlocked." + "\n"));
                            door.toggleLock(false);
                        }
                        else if(!keyItem.getID().equals(door.getID()))
                        {
                            inputHistory.getChildren().add(new Text("that isnt the right key." + "\n"));
                        }
                    }
                }
            }
        }
    }
}