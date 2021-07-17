package com.example.a754e37cartelera;

import java.util.ArrayList;

public class ListaPeliculas extends ArrayList {
    public ListaPeliculas(int initialCapacity) {
        super(initialCapacity);
        add(new pelicula("unidos","dan scanlon","103 min","En un mundo habitado por criaturas mitológicas tales como elfos, centauros, hadas, cíclopes, entre otros, la magia fue un recurso utilizado por hechiceros para ayudar a los demás a mejorar su estilo de vida. ", 9,R.drawable.lll));
        add(new pelicula("parasitos","Bong Joon-ho","2h 12min","Tanto Gi Taek como su familia están sin trabajo. Cuando su hijo mayor, Gi Woo, empieza a impartir clases particulares en la adinerada casa de los Park, las dos familias, que tienen mucho en común pese a pertenecer a dos mundos totalmente distintos, entablan una relación de resultados imprevisibles.", 9,R.drawable.images));
        add(new pelicula("Bloodshot","David S. F. Wilson","1h 49min","Murray Ray Garrison es resucitado por un equipo de científicos. Mejorado con nanotecnología, se convierte en una máquina de matar biotecnológica sobrehumana.", 8,R.drawable.ola));
        add(new pelicula("contratiempo","Oriol Paulo","1h 46min","La vida del exitoso empresario Adrián Doria se vuelve una pesadilla cuando una mañana se despierta en una habitación de hotel junto al cadáver de su amante.", 7,R.drawable.olados));
        add(new pelicula("La Torre Oscura"," Stephen King","95 min","La Torre Oscura es una saga de libros escrita por el autor estadounidense Stephen King, que incorpora temas de múltiples géneros, incluyendo fantasía, fantasía científica, terror y wéstern.", 8,R.drawable.oo));


    }
}
