/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simcore;

import java.util.Map;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import simcore.Ceiling;
import simcore.Ceiling;
import simcore.Cell;
import simcore.Cell;
import simcore.Door;
import simcore.Door;
import simcore.Floor;
import simcore.Floor;
import simcore.Stairs;
import simcore.Stairs;
import simcore.Wall;
import simcore.Wall;
import simcore.Window;
import simcore.Window;

/**
 *
 * @author JCarter
 */
class Entity
{
    String name;
    String description;
    int strength;
    int endurance;
    int agility;
    int dexterity;
    int intelligence;
    int willpower;
    Cell location;
    int currentWeight;
    int maxWeight;
    int size;
    int x;
    int y;
    int z;
    
    Entity(String name, String description, int strength, int endurance,
    int agility, int dexterity, int intelligence, int willpower, Cell location,
    int currentWeight, int maxWeight, int size, int x, int y, int z)
    {
        this.name = name;
        this.description = description;
        this.strength = strength;
        this.endurance = endurance;
        this.agility = agility;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.willpower = willpower;
        this.location = location;
        this.currentWeight = currentWeight;
        this.maxWeight = maxWeight;
        this.size = size;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    String getName()
    {
        return this.name;
    }
    
    String getDescription()
    {
        return this.description;
    }
    
    int getStrength()
    {
        return this.strength;
    }
    
    int getEndurance()
    {
        return this.endurance;
    }
    
    int getAgility()
    {
        return this.agility;
    }
    
    int getDexterity()
    {
        return this.dexterity;
    }
    
    int getIntelligence()
    {
        return this.intelligence;
    }
    
    int getWillpower()
    {
        return this.willpower;
    }
    
    Cell getLocation()
    {
        return this.location;
    }
    
    void setLocation(Cell newLoc)
    {
        this.location = newLoc;
        this.setX(newLoc.getX());
        this.setY(newLoc.getY());
        this.setZ(newLoc.getZ());
        
    }
    
    int getCurrentWeight()
    {
        return this.currentWeight;
    }
    
    int getMaxWeight()
    {
        return this.maxWeight;
    }
    
    int getSize()
    {
        return this.size;
    }
    
    int getX()
    {
        return this.x;
    }
    
    void setX(int newX)
    {
        this.x = newX;
    }

    int getY()
    {
        return this.y;
    }
    
    void setY(int newY)
    {
        this.y = newY;
    }
    
    int getZ()
    {
        return this.z;
    }
    
    void setZ(int newZ)
    {
        this.z = newZ;
    }

    void locCheck(Map<Integer, Cell> worldMap, int x, int y, int z)
    {
        x = this.getX() + x;
        y = this.getY() + y;
        z = this.getZ() + z;
        
        for(Cell room : worldMap.values())
        {
            if(x == room.getX() && y == room.getY() && z == room.getZ())
            {
                this.setLocation(room);
            }
        }
    }

    void north(Map<Integer, Cell> worldMap, TextFlow inputHistory)
    {
        if(this.getLocation().getNorth() == null)
        {
            this.locCheck(worldMap, 0, 1, 0);
        }
        else if(this.getLocation().getNorth() instanceof Wall)
        {
            if(this.getLocation().getNorth().getGateway() == null)
            {
                inputHistory.getChildren().add(new Text("You can't walk through walls." + "\n"));
            }
            else if(this.getLocation().getNorth().getGateway() instanceof Door || this.getLocation().getNorth().getGateway() instanceof Window)
            {
                if(this.getLocation().getNorth().getGateway().getState(inputHistory) == true)
                {
                    this.locCheck(worldMap, 0, 1, 0);
                }
            }
        }
    }
    
    void northEast(Map<Integer, Cell> worldMap, TextFlow inputHistory)
    {
        if(this.getLocation().getNorthEast() == null)
        {
            this.locCheck(worldMap, 1, 1, 0);
        }
        else if(this.getLocation().getNorthEast() instanceof Wall)
        {
            if(this.getLocation().getNorthEast().getGateway() == null)
            {
                inputHistory.getChildren().add(new Text("You can't walk through walls." + "\n"));
            }
            else if(this.getLocation().getNorthEast().getGateway() instanceof Door || this.getLocation().getNorthEast().getGateway() instanceof Window)
            {
                if(this.getLocation().getNorthEast().getGateway().getState(inputHistory) == true)
                {
                    this.locCheck(worldMap, 1, 1, 0);
                }
            }
        }
    }
    
    void east(Map<Integer, Cell> worldMap, TextFlow inputHistory)
    {
        if(this.getLocation().getEast() == null)
        {
            this.locCheck(worldMap, 1, 0, 0);
        }
        else if(this.getLocation().getEast() instanceof Wall)
        {
            if(this.getLocation().getEast().getGateway() == null)
            {
                inputHistory.getChildren().add(new Text("You can't walk through walls." + "\n"));
            }
            else if(this.getLocation().getEast().getGateway() instanceof Door || this.getLocation().getEast().getGateway() instanceof Window)
            {
                if(this.getLocation().getEast().getGateway().getState(inputHistory) == true)
                {
                    this.locCheck(worldMap, 1, 0, 0);
                }
            }
        }
    }
    
    void southEast(Map<Integer, Cell> worldMap, TextFlow inputHistory)
    {
        if(this.getLocation().getSouthEast() == null)
        {
            this.locCheck(worldMap, 1, -1, 0);
        }
        else if(this.getLocation().getSouthEast() instanceof Wall)
        {
            if(this.getLocation().getSouthEast().getGateway() == null)
            {
                inputHistory.getChildren().add(new Text("You can't walk through walls." + "\n"));
            }
            else if(this.getLocation().getSouthEast().getGateway() instanceof Door || this.getLocation().getSouthEast().getGateway() instanceof Window)
            {
                if(this.getLocation().getSouthEast().getGateway().getState(inputHistory) == true)
                {
                    this.locCheck(worldMap, 1, -1, 0);
                }
            }
        }
    }
    
    void south(Map<Integer, Cell> worldMap, TextFlow inputHistory)
    {
        if(this.getLocation().getSouth() == null)
        {
            this.locCheck(worldMap, 0, -1, 0);
        }
        else if(this.getLocation().getSouth() instanceof Wall)
        {
            if(this.getLocation().getSouth().getGateway() == null)
            {
                inputHistory.getChildren().add(new Text("You can't walk through walls." + "\n"));
            }
            else if(this.getLocation().getSouth().getGateway() instanceof Door || this.getLocation().getSouth().getGateway() instanceof Window)
            {
                if(this.getLocation().getSouth().getGateway().getState(inputHistory) == true)
                {
                    this.locCheck(worldMap, 0, -1, 0);
                }
            }
        }
    }
    
    void southWest(Map<Integer, Cell> worldMap, TextFlow inputHistory)
    {
        if(this.getLocation().getSouthWest() == null)
        {
            this.locCheck(worldMap, -1, -1, 0);
        }
        else if(this.getLocation().getSouthWest() instanceof Wall)
        {
            if(this.getLocation().getSouthWest().getGateway() == null)
            {
                inputHistory.getChildren().add(new Text("You can't walk through walls." + "\n"));
            }
            else if(this.getLocation().getSouthWest().getGateway() instanceof Door || this.getLocation().getSouthWest().getGateway() instanceof Window)
            {
                if(this.getLocation().getSouthWest().getGateway().getState(inputHistory) == true)
                {
                    this.locCheck(worldMap, -1, -1, 0);
                }
            }
        }
    }
    
    void west(Map<Integer, Cell> worldMap, TextFlow inputHistory)
    {
        if(this.getLocation().getWest() == null)
        {
            this.locCheck(worldMap, -1, 0, 0);
        }
        else if(this.getLocation().getWest() instanceof Wall)
        {
            if(this.getLocation().getWest().getGateway() == null)
            {
                inputHistory.getChildren().add(new Text("You can't walk through walls." + "\n"));
            }
            else if(this.getLocation().getWest().getGateway() instanceof Door || this.getLocation().getWest().getGateway() instanceof Window)
            {
                if(this.getLocation().getWest().getGateway().getState(inputHistory) == true)
                {
                    this.locCheck(worldMap, -1, 0, 0);
                }
            }
        }
    }
    
    void northWest(Map<Integer, Cell> worldMap, TextFlow inputHistory)
    {
        if(this.getLocation().getNorthWest() == null)
        {
            this.locCheck(worldMap, -1, 1, 0);
        }
        else if(this.getLocation().getNorthWest() instanceof Wall)
        {
            if(this.getLocation().getNorthWest().getGateway() == null)
            {
                inputHistory.getChildren().add(new Text("You can't walk through walls." + "\n"));
            }
            else if(this.getLocation().getNorthWest().getGateway() instanceof Door || this.getLocation().getNorthWest().getGateway() instanceof Window)
            {
                if(this.getLocation().getNorthWest().getGateway().getState(inputHistory) == true)
                {
                    this.locCheck(worldMap, -1, 1, 0);
                }
            }
        }
    }
    
    void up(Map<Integer, Cell> worldMap, TextFlow inputHistory)
    {
        if(this.getLocation().getUp() == null)
        {
            inputHistory.getChildren().add(new Text("are you trying to climb the air?" + "\n"));
        }
        else if(this.getLocation().getUp() instanceof Ceiling)
        {
            if(this.getLocation().getUp().getGateway() == null)
            {
                inputHistory.getChildren().add(new Text("theres no way up its just a ceiling." + "\n"));
            }
            else if(this.getLocation().getUp().getGateway() instanceof Stairs)
            {
                if(this.getLocation().getUp().getGateBlock() == null)
                {
                    this.locCheck(worldMap, 0, 0, 1);
                }
                else if(this.getLocation().getUp().getGateBlock() instanceof Door)
                {
                    if(this.getLocation().getUp().getGateBlock().getState(inputHistory) == true)
                    {
                        this.locCheck(worldMap, 0, 0, 1);
                    }
                }
            }
        }
    }
    
    void down(Map<Integer, Cell> worldMap, TextFlow inputHistory)
    {
        if(this.getLocation().getDown() == null)
        {
            inputHistory.getChildren().add(new Text("you can't move down, you are falling." + "\n"));
        }
        else if(this.getLocation().getDown() instanceof Floor)
        {
            if(this.getLocation().getDown().getGateway() == null)
            {
                inputHistory.getChildren().add(new Text("do you intend on digging?" + "\n"));
            }
            else if(this.getLocation().getDown().getGateway() instanceof Stairs)
            {
                if(this.getLocation().getDown().getGateBlock() == null)
                {
                    this.locCheck(worldMap, 0, 0, -1);
                }
                else if(this.getLocation().getDown().getGateBlock() instanceof Door)
                {
                    if(this.getLocation().getDown().getGateBlock().getState(inputHistory) == true)
                    {
                        this.locCheck(worldMap, 0, 0, -1);
                    }
                }
            }
        }
    }
}