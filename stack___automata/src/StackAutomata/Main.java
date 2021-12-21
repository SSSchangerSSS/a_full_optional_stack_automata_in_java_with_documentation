
package StackAutomata;

import java.util.ArrayList;
import java.util.Scanner;





public class Main {

 
    public static void main(String[] args) {
    
    Main M = new Main();    
    M.run(args);    
        
    }
    
    
    public void run(String []args){
        
        
Automata S_auto = new Automata(); 

Scanner Input = new Scanner(System.in);
char choice;
String State;
String State2;
char char_of_string;
char char_Top_of_stack;
String harf_balaye_poshte_miravad;
String string;
boolean app_should_finish = false;
boolean string_report;
boolean start=false;
String first_state = null;
show_menu();
System.out.println();
System.out.print("please choose the option you prefer:");
System.out.println();


while(app_should_finish == false){

choice = Input.next().charAt(0);
switch(choice){
    
    case '0':
    show_menu();
    break;
    
    
    case '1':
    System.out.println();
    System.out.print("(attention : with choosing this option all state and transitions of automata will delete)");
    System.out.println();
    S_auto = new Automata();
    S_auto.states.clear();
    start = false;
    break;    
    
    case '2':
    System.out.println();    
    System.out.print("(enter the name of state example: q1 )");    
    System.out.println();    
    System.out.print("(attention : if you enter one name twice for a state second time no state will be created)");
    System.out.println();
    if (S_auto.states.isEmpty() == false)
    {
    System.out.print("state names you have created till now:");    
    System.out.println();    
    System.out.print(S_auto.states);    
    System.out.println();   
    }
    State = Input.next();
    S_auto.add_state(State);
    break; 
    
    case '3':
    System.out.println();     
    System.out.print("set starter state:");    
    System.out.println();    
    System.out.print("(choose and enter one name from your created states example: q1 )");
    System.out.println();
    if (S_auto.states.isEmpty() == false)
    {
    System.out.print("states that you have created:");    
    System.out.println();    
    System.out.print(S_auto.states);    
    System.out.println();   
    }
    State = Input.next();
    S_auto.set_starter_state(State);    
    first_state = State;
    start = true;
    break; 
    

    case '4':
    System.out.println();    
    System.out.print("(enter transition example: q1 a A q2 B )");
    System.out.println();
    System.out.print("(enter name of current state example: q1 )");
    System.out.println();
    if (S_auto.states.isEmpty() == false)
    {
    System.out.print("states that you have created:");    
    System.out.println();    
    System.out.print(S_auto.states);    
    System.out.println();   
    }
    State = Input.next();
    System.out.println();
    System.out.print("(enter current char of string: a )");
    System.out.println();
    System.out.print("(attention : current char of string should be one single character)");
    System.out.println();
    char_of_string =  Input.next().charAt(0);
    System.out.println();
    System.out.println();
    System.out.print("(enter char at top of stack example: A )");
    System.out.println();
    System.out.print("(attention : char at top of stack should be one single character.)");
    System.out.println();
    char_Top_of_stack =  Input.next().charAt(0);
    System.out.println();
    System.out.println();
    System.out.print("(enter name of next state(one of states you have created) example: q4 )");
    System.out.println();
    if (S_auto.states.isEmpty() == false)
    {
    System.out.print("states that you have created:");    
    System.out.println();    
    System.out.print(S_auto.states);    
    System.out.println();   
    }
    State2 = Input.next();
    System.out.println();
    System.out.println();
//    System.out.print("(jahat harf ha ee ke balaye poshte miravad ra vared konid manand: B   ya   BBB )");
//    System.out.println();
//    System.out.print("(tavajoh dashte bashid ke jahat tak character ast.)");
//    System.out.println();
    harf_balaye_poshte_miravad =  Input.next();
   
    S_auto.add_transition(State, char_of_string, char_Top_of_stack , State2, harf_balaye_poshte_miravad);
    break; 
    
    
    
    case '5':
    S_auto.print_transitions();
    break;
    
    
    
    case '6':
    if ( (S_auto.states.isEmpty() == true) )   
    {
    System.out.println();
    System.out.print("please first initial the automata(states,set stater state,transitions)");
    System.out.println();
    System.out.print("then you can start the stack automata");
    System.out.println();
    System.out.print("for more details on how to create automata you can choose option 7...");
    System.out.println();
    break;   
    }    
    System.out.println();
    System.out.print("(enter the string you wnat to check example: cbbab )");
    System.out.println();
    System.out.print("attention : characters should be the characters you have defined in transitions.");
    System.out.println();
    string = Input.next();
    System.out.println();
    string_report = S_auto.execute(string);
    System.out.println();
    if(string_report == true)
    System.out.println("string was accepted by automata.");
    else    
    System.out.println("string was not accepted by automata.");
    if (first_state != null)
    S_auto.set_starter_state(first_state);
    break; 
    
    
    case '7' :
    show_example_automata();
    break;
    
    case '8':
    app_should_finish = true;    
    break;

    default:
    System.out.print("the selected option is not defined!");   
    System.out.println();
    break;
}    
System.out.println();
System.out.print("please choose the option you prefer:");
System.out.print("((0 -> show menu))");
System.out.println();
}

}














public void show_menu(){
    
System.out.print("0.show menu");
System.out.println();
System.out.println();
System.out.print("1.clear all states and transitions");
System.out.println();
System.out.print("(attention : with choosing this option all state and transitions of automata will delete)");
System.out.println();
System.out.println();
System.out.print("2.add state");
System.out.println();
System.out.print("(enter name of state example: q1 )");
System.out.println();
System.out.println();
System.out.print("3.set starter state");
System.out.println();
System.out.print("(choose and enter one name from your created states example: q1 )");
System.out.println();
System.out.println();
System.out.print("4.add transition");
System.out.println();
System.out.print("(enter transition example: q1 a A q2 B )");
System.out.println();
System.out.println();
System.out.print("5.show transitions");  
System.out.println();
System.out.println();
System.out.print("6.enter string to check with automata");  
System.out.println();
System.out.print("(enter the string you wnat to check example: cbbab )");
System.out.println();
System.out.println();
System.out.print("7.example : how to create a stack automata ");
System.out.println();
System.out.println();
System.out.print("8.exit");
System.out.println();
System.out.println();
}






public void show_example_automata()
{
    System.out.print("state1 : p");
    System.out.println();
    System.out.print("state2 : q");
    System.out.println();
    System.out.print("starter state : p");
    System.out.println();
    System.out.print("transition 1: p a & p A"); 
    System.out.println();
    System.out.print("transition 2: p a A p AA"); 
    System.out.println();
    System.out.print("transition 3: p b A q &"); 
    System.out.println();
    System.out.print("transition 4: q b A q &");
    System.out.println();
    System.out.print("you can create a stack automata like example");
    System.out.println();
    System.out.print("one accepted string through example automata check : aabb");
    System.out.println();
}
    
    
    
    
}






