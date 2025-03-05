package org.example;

import org.example.models.Pokemon;
import org.example.services.PokemonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    private static PokemonService service = new PokemonService();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        List<Pokemon> pokemon = new ArrayList<>();

        do {
            System.out.println("Welcome Pokemon Trainer!");
            System.out.println("1. Get first 20");
            System.out.println("2. Get second 20");
            System.out.println("3. Get next 20");
            System.out.println("4. Quit");
            System.out.println("Enter choice: ");
            int choice = Integer.parseInt(input.nextLine() );

            if(choice ==4){
                break;
            }
            switch (choice) {
                case 1:
                    pokemon = service.getMorePokemon(0);
                    System.out.println(pokemon);
                    break;
                case 2:
                    pokemon = service.getMorePokemon(20);
                    System.out.println(pokemon);
                    break;
                case 3 :
                    pokemon = service.getMorePokemon(40);
                    System.out.println(pokemon);
                    break;
            }
        } while (true);

    }
}