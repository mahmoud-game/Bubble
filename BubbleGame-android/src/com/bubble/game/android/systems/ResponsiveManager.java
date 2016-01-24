package com.bubble.game.android.systems;

public class ResponsiveManager {

    // Fonction qui maintien le rapport entre les positions Y
    // vis-à-vis de la taille de l'écran
    public static float xUnite(float x, float largeur_ecran)
    {
          return x*largeur_ecran/480f;
    }
   
    // Fonction qui maintien le rapport entre les positions Y
    // vis-à-vis de la taille de l'écran
    public static float yUnite(float y, float hauteur_ecran)
    {
          return y*hauteur_ecran/320;
    }
}
