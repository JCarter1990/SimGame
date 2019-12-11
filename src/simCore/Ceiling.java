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
class Ceiling extends BuildingPiece
{
    Ceiling(String colour, List contents, Enterable gateway, Enterable gateBlock, Pressable control)
    {
        this.colour = colour;
        this.contents = contents;
        this.gateway = gateway;
        this.gateBlock = gateBlock;
        this.control = control;
    }
}
