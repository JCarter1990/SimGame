/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simcore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.text.TextFlow;

/**
 *
 * @author JCarter
 */
public class SimCoord
{
    static Map<Integer, Door> doors = new HashMap<>();
    static Map<Integer, Cell> worldMap = new HashMap<>();
    static Human player;
    
    public static void worldSetup()
    {
        doors.put(0, new Door("Furry door", true, false, "imAKey"));
        doors.put(1, new Door("Purple door", true, false, "rottenMeat"));
        doors.put(2, new Door("Trapdoor", true, false, "cheekyChap"));
        
        worldMap.put(0, new Cell("Central Plaza",
            "The heart of the city.",
            0,0,0,
            new Wall("blue", new ArrayList(),doors.get(0),null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),doors.get(1),null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            new Ceiling("white", new ArrayList(), new Stairs("stairs"),
                        doors.get(2), null),
            new Floor("brown", new ArrayList(), null, null, null)));
        
        worldMap.put(1, new Cell("North Plaza",
            "Description",
            0,1,0,
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            null,null,
            new Wall("blue", new ArrayList(),doors.get(0),null,null),
            null,null,
            new Wall("blue", new ArrayList(),null,null,null),
            null,null));
        
        worldMap.put(2, new Cell("Northeast Plaza",
            "Description",
            1,1,0,
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            null,null,null,null,null,null,null));
        
        worldMap.put(3, new Cell("East Plaza",
            "Description",
            1,0,0,
            null,
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            null,null,null,null,null,null));
        
        worldMap.put(4, new Cell("Southeast Plaza",  
            "Description",
            1,-1,0,
            null,null,
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            null,null,null,null,null));
        
        worldMap.put(5, new Cell("South Plaza",
            "Description",
            0,-1,0,
            new Wall("blue", new ArrayList(),doors.get(1),null,null),
            null,null,
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            null,null,null,null));
        
        worldMap.put(6, new Cell("Southwest Plaza",
            "Description",  
            -1,-1,0,
            null,null,null,null,
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            null,null,null));
        
        worldMap.put(7, new Cell("West Plaza",
            "Description",
            -1,0,0,
            null,null,null,null,null,
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            null,null));
        
        worldMap.put(8, new Cell("Northwest Plaza",
            "Description",
            -1,1,0,
            new Wall("blue", new ArrayList(),null,null,null),
            null,null,null,null,null,
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            null,null));
        
        worldMap.put(9, new Cell("Upstairs",
            "an upstairs room.",
            0,0,1,
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            new Wall("blue", new ArrayList(),null,null,null),
            new Ceiling("white", new ArrayList(),null,null,null),
            new Floor("brown", new ArrayList(),new Stairs("stairs"),
            doors.get(2),null)));
        
        worldMap.get(0).addItem(new Container("Dufflebag", "A dufflebag.", null,
        3, 2, null, null, null, new ArrayList()));
        
        worldMap.get(0).addItem(new Container("Dufflebag", "A dufflebag.", null,
        3, 2, null, null, null, new ArrayList()));
        
        worldMap.get(0).addItem(new Container("Dufflebag", "A dufflebag.", null,
        3, 2, null, null, null, new ArrayList()));
        
        worldMap.get(0).addItem(new Container("Dufflebag", "A dufflebag.", null,
        3, 2, null, null, null, new ArrayList()));
        
        worldMap.get(0).addItem(new Container("Dufflebag", "A dufflebag.", null,
        3, 2, null, null, null, new ArrayList()));
        
        worldMap.get(0).addItem(new ItemKey("Key", "A key.", null, 0, 1,
        new ArrayList(), new ArrayList(), new ArrayList(), "imAKey"));
    }
    
    public static void playerSetup()
    {
        player = new Human("Player", "Generic desc.", 5, 5, 5, 5, 5, 5,
        worldMap.get(0), 0, 100, 7, 0, 0, 0, new BodyPart(), new BodyPart(),
        new BodyPart(), new BodyPart(), new BodyPart(), new BodyPart(),
        new BodyPart(), new BodyPart(), new BodyPart(), new BodyPart(),
        new BodyPart(), new BodyPart(), new BodyPart(), new BodyPart());
    }
    
    public static String getPlayerLocationTitle()
    {
        return player.getLocation().getTitle();
    }
    
    public static String getPlayerLocationDesc()
    {
        return player.getLocation().getDescription();
    }
    
    public static String getPlayerLocationContents()
    {
        return player.getLocation().contentsAsString();
    }
    
    public static void parser(String command, String object, String command2,
    String object2, String command3, String object3, TextFlow inputHistory)
    {
        if(command.equalsIgnoreCase("north"))
        {
            player.north(worldMap, inputHistory);
        }
        else if(command.equalsIgnoreCase("northeast"))
        {
            player.northEast(worldMap, inputHistory);
        }
        else if(command.equalsIgnoreCase("east"))
        {
            player.east(worldMap, inputHistory);
        }
        else if(command.equalsIgnoreCase("southeast"))
        {
            player.southEast(worldMap, inputHistory);
        }
        else if(command.equalsIgnoreCase("south"))
        {
            player.south(worldMap, inputHistory);
        }
        else if(command.equalsIgnoreCase("southwest"))
        {
            player.southWest(worldMap, inputHistory);
        }
        else if(command.equalsIgnoreCase("west"))
        {
            player.west(worldMap, inputHistory);
        }
        else if(command.equalsIgnoreCase("northwest"))
        {
            player.northWest(worldMap, inputHistory);
        }
        else if(command.equalsIgnoreCase("up"))
        {
            player.up(worldMap, inputHistory);
        }
        else if(command.equalsIgnoreCase("down"))
        {
            player.down(worldMap, inputHistory);
        }
        else if(command.equalsIgnoreCase("get"))
        {
            player.getItem(player.getCurrentWeight(), player.getLocation(),
            null, object, null, null, inputHistory);
        }
        else if(command.equalsIgnoreCase("open"))
        {
            if(object.equalsIgnoreCase("north"))
            {
                player.openDoor(player.getLocation().getNorth().getGateway(), inputHistory);
            }
            else if(object.equalsIgnoreCase("northeast"))
            {
                player.openDoor(player.getLocation().getNorthEast().getGateway(), inputHistory);
            }
            else if(object.equalsIgnoreCase("east"))
            {
                player.openDoor(player.getLocation().getEast().getGateway(), inputHistory);
            }
            else if(object.equalsIgnoreCase("southeast"))
            {
                player.openDoor(player.getLocation().getSouthEast().getGateway(), inputHistory);
            }
            else if(object.equalsIgnoreCase("south"))
            {
                player.openDoor(player.getLocation().getSouth().getGateway(), inputHistory);
            }
            else if(object.equalsIgnoreCase("southwest"))
            {
                player.openDoor(player.getLocation().getSouthWest().getGateway(), inputHistory);
            }
            else if(object.equalsIgnoreCase("west"))
            {
                player.openDoor(player.getLocation().getWest().getGateway(), inputHistory);
            }
            else if(object.equalsIgnoreCase("northwest"))
            {
                player.openDoor(player.getLocation().getNorthWest().getGateway(), inputHistory);
            }
            else if(object.equalsIgnoreCase("up"))
            {
                player.openDoor(player.getLocation().getUp().getGateway(), inputHistory);
            }
            else if(object.equalsIgnoreCase("down"))
            {
                player.openDoor(player.getLocation().getDown().getGateway(), inputHistory);
            }
        }
        else if(command.equalsIgnoreCase("close"))
        {
            if(object.equalsIgnoreCase("north"))
            {
                player.closeDoor(player.getLocation().getNorth().getGateway(), inputHistory);
            }
            else if(object.equalsIgnoreCase("northeast"))
            {
                player.closeDoor(player.getLocation().getNorthEast().getGateway(), inputHistory);
            }
            else if(object.equalsIgnoreCase("east"))
            {
                player.closeDoor(player.getLocation().getEast().getGateway(), inputHistory);
            }
            else if(object.equalsIgnoreCase("southeast"))
            {
                player.closeDoor(player.getLocation().getSouthEast().getGateway(), inputHistory);
            }
            else if(object.equalsIgnoreCase("south"))
            {
                player.closeDoor(player.getLocation().getSouth().getGateway(), inputHistory);
            }
            else if(object.equalsIgnoreCase("southwest"))
            {
                player.closeDoor(player.getLocation().getSouthWest().getGateway(), inputHistory);
            }
            else if(object.equalsIgnoreCase("west"))
            {
                player.closeDoor(player.getLocation().getWest().getGateway(), inputHistory);
            }
            else if(object.equalsIgnoreCase("northwest"))
            {
                player.closeDoor(player.getLocation().getNorthWest().getGateway(), inputHistory);
            }
            else if(object.equalsIgnoreCase("up"))
            {
                player.closeDoor(player.getLocation().getUp().getGateway(), inputHistory);
            }
            else if(object.equalsIgnoreCase("down"))
            {
                player.closeDoor(player.getLocation().getDown().getGateway(), inputHistory);
            }
        }
        
        else if(command.equalsIgnoreCase("unlock"))
        {
            if(command2.equalsIgnoreCase("with"))
            {
                if(object.equalsIgnoreCase("north"))
                {
                    player.unlock(player.getLocation().getNorth().getGateway(), object2, inputHistory);
                }
                else if(object.equalsIgnoreCase("northeast"))
                {
                    player.unlock(player.getLocation().getNorthEast().getGateway(), object2, inputHistory);
                }
                else if(object.equalsIgnoreCase("east"))
                {
                    player.unlock(player.getLocation().getEast().getGateway(), object2, inputHistory);
                }
                else if(object.equalsIgnoreCase("southeast"))
                {
                    player.unlock(player.getLocation().getSouthEast().getGateway(), object2, inputHistory);
                }
                else if(object.equalsIgnoreCase("south"))
                {
                    player.unlock(player.getLocation().getSouth().getGateway(), object2, inputHistory);
                }
                else if(object.equalsIgnoreCase("southwest"))
                {
                    player.unlock(player.getLocation().getSouthWest().getGateway(), object2, inputHistory);
                }
                else if(object.equalsIgnoreCase("west"))
                {
                    player.unlock(player.getLocation().getWest().getGateway(), object2, inputHistory);
                }
                else if(object.equalsIgnoreCase("northwest"))
                {
                    player.unlock(player.getLocation().getNorthWest().getGateway(), object2, inputHistory);
                }
                else if(object.equalsIgnoreCase("up"))
                {
                    player.unlock(player.getLocation().getUp().getGateBlock(), object2, inputHistory);
                }
                else if(object.equalsIgnoreCase("down"))
                {
                    player.unlock(player.getLocation().getDown().getGateBlock(), object2, inputHistory);
                }
            }
        }

        else if(command.equalsIgnoreCase("lock"))
        {
            if(command2.equalsIgnoreCase("with"))
            {
                if(object.equalsIgnoreCase("north"))
                {
                    player.lock(player.getLocation().getNorth().getGateway(), object2, inputHistory);
                }
                else if(object.equalsIgnoreCase("northeast"))
                {
                    player.lock(player.getLocation().getNorthEast().getGateway(), object2, inputHistory);
                }
                else if(object.equalsIgnoreCase("east"))
                {
                    player.lock(player.getLocation().getEast().getGateway(), object2, inputHistory);
                }
                else if(object.equalsIgnoreCase("southeast"))
                {
                    player.lock(player.getLocation().getSouthEast().getGateway(), object2, inputHistory);
                }
                else if(object.equalsIgnoreCase("south"))
                {
                    player.lock(player.getLocation().getSouth().getGateway(), object2, inputHistory);
                }
                else if(object.equalsIgnoreCase("southwest"))
                {
                    player.lock(player.getLocation().getSouthWest().getGateway(), object2, inputHistory);
                }
                else if(object.equalsIgnoreCase("west"))
                {
                    player.lock(player.getLocation().getWest().getGateway(), object2, inputHistory);
                }
                else if(object.equalsIgnoreCase("northwest"))
                {
                    player.lock(player.getLocation().getNorthWest().getGateway(), object2, inputHistory);
                }
                else if(object.equalsIgnoreCase("up"))
                {
                    player.lock(player.getLocation().getUp().getGateBlock(), object2, inputHistory);
                }
                else if(object.equalsIgnoreCase("down"))
                {
                    player.lock(player.getLocation().getDown().getGateBlock(), object2, inputHistory);
                }
            }
        }
    }
}