package data;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    Clase para un par, pensada para representar una arista en un nuestro
    grafo, con first siendo
 */
public class Pair<U, V>
{
    private U first;
    private V second;

    public Pair(U first, V second)
    {
        this.first = first;
        this.second = second;
    }

    // Getters :V
    public U getFirst()
    {
        return this.first;
    }

    public V getSecond()
    {
        return this.second;
    }

    @Override
    public String toString()
    {
        return "(" + first + ", " + second + ")";
    }
}