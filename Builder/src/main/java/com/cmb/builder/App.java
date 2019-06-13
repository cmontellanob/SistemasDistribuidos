/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmb.builder;

/**
 *
 * @author Carlos
 */
public class App {
public static void main(String[] args) {   
    
    var sandwichMaker = new SandwichMaker(new MySandwichBuilder());
    sandwichMaker.BuildSandwich();
    var sandwich1 = sandwichMaker.GetSandwhich();

    sandwich1.Display();

    var sandwichMaker2 = new SandwichMaker(new ClubSandwichBuilder());
    sandwichMaker2.BuildSandwich();
    var sandwich2 = sandwichMaker2.GetSandwhich();

    sandwich2.Display();
    Console.ReadKey();
    
}
}
