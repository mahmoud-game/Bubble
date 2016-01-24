package com.bubble.game.android.systems;

import com.artemis.Entity;
import com.artemis.World;
import com.artemis.managers.GroupManager;
import com.bubble.game.android.components.*;
 
public class FabriqueEntite {

public static Entity creerBalle(World w, float xDep, float yDep, float incXDep, float incYDep, float size){
    Entity balle = w.createEntity();
    
    //nous ajoutons ici les composants de notre balle    
    //va falloir que la balle apparaisse autre part que là
    //où y'a une autre balle/bombe
    balle.edit().add(new Position(xDep, yDep));
    balle.edit().add(new Velocity(incXDep, incYDep));
 
    //ici 0 correspond au type "normal"
    balle.edit().add(new Type(0));

    //notre balle sera un cercle de diamètre 10 pixel
    //Au hasard, choix entre 5 tailles à définir
    balle.edit().add(new Size(size));
    
    //on enregistre notre balle dans le groupe des balle    
    w.getSystem(GroupManager.class).add(balle, "BULLES");    
    
    return balle;
    
 }

public static Entity creerBombe(World w, int xDep, int yDep, float incXDep, float incYDep, float size){
    Entity bombe = w.createEntity();
    
    //nous ajoutons ici les composants de notre balle    
    bombe.edit().add(new Position(xDep, yDep));
    bombe.edit().add(new Velocity(incXDep, incYDep));
 
    //ici 0 correspond au type "bombe"
    bombe.edit().add(new Type(1));
 
    //notre balle sera un cercle de diamètre 10 pixel
    bombe.edit().add(new Size(size));
    
    //on enregistre notre balle dans le groupe des balle
    w.getSystem(GroupManager.class).add(bombe, "BOMBES");
    
    return bombe;
    
 }
 
}
