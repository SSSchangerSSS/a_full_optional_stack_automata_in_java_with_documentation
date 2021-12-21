/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackAutomata;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author asus
 */
public class Automata {

 public Automata(){  
 }   
    
 Stack automata_ = new Stack();    
 String current_state;
 char char_of_string;
 char char_at_top_of_stack;
 ArrayList<String> states = new ArrayList<>();
 ArrayList<Transition> transitions = new ArrayList<>();    
 
 
 public boolean add_state(String state){
 if (this.states.contains(state))
 return false;
 else{
 this.states.add(state);
 return true;    
 }  
 }

 public void print_state(){
 System.out.println();
 System.out.print(this.states);
 System.out.println();
 }
 
 
 public void add_transition(String current_state , char char_of_string , char char_at_Top_stack , String next_state , String chars_stack_push)
 {
 Transition t;
 t = new Transition(current_state, char_of_string, char_at_Top_stack, next_state, chars_stack_push);
 this.transitions.add(t);
 } 

 public void print_transitions(){
 if (this.transitions.isEmpty() == false) {
 System.out.println();
 for (int i = 0 ; i < this.transitions.size() ; i++){
 System.out.print(this.transitions.get(i).current_state + " " + this.transitions.get(i).char_of_string + " " + this.transitions.get(i).char_at_Top_stack + " " + this.transitions.get(i).next_state + " " + this.transitions.get(i).chars_stack_push);
 System.out.println();
 }
 }
 else
 return;    
 }
 
 
class Transition{
String current_state; 
char char_of_string; 
char char_at_Top_stack; 
String next_state;
String chars_stack_push;   
public Transition(String current_state , char char_of_string , char char_at_Top_stack , String next_state , String chars_stack_push){
this.current_state = current_state;
this.char_of_string = char_of_string;
this.char_at_Top_stack = char_at_Top_stack;
this.next_state = next_state;
this.chars_stack_push = chars_stack_push;
}
    }

public void set_starter_state(String halat){
this.current_state = halat;
}

public boolean execute(String string){
int i = 0;
boolean not_accepted = false;
boolean state_found = false;
Transition t;

if (this.states.isEmpty() || this.transitions.isEmpty())
return false;

while(i < string.length() && not_accepted == false)
{
this.char_of_string = string.charAt(i);
if (this.automata_.isEmpty() == true)
{
for(int j = 0 ; j < this.transitions.size() ; j++){
t = transitions.get(j);
if ( t.current_state.equals(this.current_state) && t.char_of_string == this.char_of_string && t.char_at_Top_stack == '&')
{
state_found = true;     
System.out.print(t.current_state + " " + t.char_of_string + " " + t.char_at_Top_stack + " " + t.next_state + " " + t.chars_stack_push);
this.current_state = t.next_state;
if (!(t.chars_stack_push.charAt(0) == '&'))
{
for(int h = 0 ; h < t.chars_stack_push.length() ; h++)
this.automata_.push(t.chars_stack_push.charAt(h));
}
break;
}  
}
}    
else
{    
this.char_at_top_of_stack =(char) this.automata_.pop();
for(int j = 0 ; j < this.transitions.size() ; j++){
t = transitions.get(j);
if ( t.current_state.equals(this.current_state) && t.char_of_string == this.char_of_string && t.char_at_Top_stack == this.char_at_top_of_stack)
{
state_found = true;        
System.out.print(t.current_state + " " + t.char_of_string + " " + t.char_at_Top_stack + " " + t.next_state + " " + t.chars_stack_push);
this.current_state = t.next_state;
if (!(t.chars_stack_push.charAt(0) == '&'))
{
for(int h = 0 ; h < t.chars_stack_push.length() ; h++)
this.automata_.push(t.chars_stack_push.charAt(h));
}    
break;
}   
}
}

if (state_found == false)
not_accepted = true;    
else
state_found = false;    


i = i + 1;

System.out.print("     "+this.automata_);
System.out.println();
//test : System.out.print(this.poshte + this.halat_feli + i + "   " + adame_paziresh);
}

if (not_accepted == false && i == string.length())
return true;
else
return false;
        

}
 
 
}
