/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simcore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author JCarter
 */
class Cell
{
    String title;
    String description;
    List<Item> roomContainer;
    int x;
    int y;
    int z;
    BuildingPiece north;
    BuildingPiece northEast;
    BuildingPiece east;
    BuildingPiece southEast;
    BuildingPiece south;
    BuildingPiece southWest;
    BuildingPiece west;
    BuildingPiece northWest;
    BuildingPiece up;
    BuildingPiece down;
    
    Cell(String title, String description,
                int x, int y, int z,
                BuildingPiece north, BuildingPiece northEast,
                BuildingPiece east, BuildingPiece southEast,
                BuildingPiece south, BuildingPiece southWest,
                BuildingPiece west, BuildingPiece northWest,
                BuildingPiece up, BuildingPiece down)
    {
        this.title = title;
        this.description = description;
        this.roomContainer = new ArrayList();
        this.x = x;
        this.y = y;
        this.z = z;
        this.north = north;
        this.northEast = northEast;
        this.east = east;
        this.southEast = southEast;
        this.south = south;
        this.southWest = southWest;
        this.west = west;
        this.northWest = northWest;
        this.up = up;
        this.down = down;
    }

    String getTitle()
    {
        return this.title;
    }
    
    String getDescription()
    {
        return this.description;
    }
    
    List<Item> getContainer()
    {
        return this.roomContainer;
    }
    
    void addItem(Item anItem)
    {
        this.roomContainer.add(anItem);
    }
    
    void removeItem(Item anItem)
    {
        this.roomContainer.remove(anItem);
    }
    
    int getX()
    {
        return this.x;
    }
    
    int getY()
    {
        return this.y;
    }
    
    int getZ()
    {
        return this.z;
    }
    
    BuildingPiece getNorth()
    {
        return this.north;
    }
    
    BuildingPiece getNorthEast()
    {
        return this.northEast;
    }
    
    BuildingPiece getEast()
    {
        return this.east;
    }
    
    BuildingPiece getSouthEast()
    {
        return this.southEast;
    }
    
    BuildingPiece getSouth()
    {
        return this.south;
    }
    
    BuildingPiece getSouthWest()
    {
        return this.southWest;
    }
    
    BuildingPiece getWest()
    {
        return this.west;
    }
    
    BuildingPiece getNorthWest()
    {
        return this.northWest;
    }
    
    BuildingPiece getUp()
    {
        return this.up;
    }
    
    BuildingPiece getDown()
    {
        return this.down;
    }
    
    String contentsAsString()
    {
        String displayString = new String();
        
        if(this.getContainer().size() == 1)
        {
            displayString =  "You see a " + this.getContainer().get(0).getName() + ".";
        }
        else if(this.getContainer().size() == 2)
        {
            displayString = String.format("You see a %s and a %s.",
            this.getContainer().get(0).getName(),
            this.getContainer().get(1).getName());
        }
        else if(this.getContainer().size() > 2)
        {
            displayString = "You see a " + this.getContainer().stream()
              .map(Item::getName)
              .limit(this.getContainer().size() - 1)
              .collect(Collectors.joining(", "));
            displayString += " and a " + this.getContainer()
            .get(this.getContainer().size() - 1).getName() + ".";
        }
        
        return displayString;
    }
}