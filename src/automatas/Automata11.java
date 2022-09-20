/*
INTEGRANTES 
Leydi Sharely Arone Incahuaman
Carmen Rosa Nuñez Soras 
Janneth Llicahua Huanaco
Melisa Arone Kacha
 */
package automatas;

import javax.swing.JOptionPane;
    public class Automata11 {
 //init state

 private static final int Q0 = 0;
 private static final int Q1 = 1;
 private static final int Q2 = 2;
 private static final int Q3 = 3;
 private int state;
 public StringBuilder buffer;

 public Automata11() {
  state = Q0;
 }

 public int getState() {
  return state;
 }

 public boolean accept(String str, boolean debug) {
  init();
  for (char c : str.toCharArray()) {
   int previousState = state;
   appendChar(c);
   System.out.println("'" + c + "' " + getStateName(previousState) + " -> " + getStateName(state));
  }
  return state == Q3;
 }

 private void init() {
  state = Q0;
  buffer = new StringBuilder();
 }

 private String getStateName(int stateToGet) {
  String stateName = "";
  switch (stateToGet) {
   case Q0:
    stateName = "Q0";
    break;
   case Q1:
    stateName = "Q1";
    break;
   case Q2:
    stateName = "Q2";
    break;
   case Q3:
    stateName = "Q3";
    break;
  }
  return stateName;
 }

 private void appendChar(char character) {
  if (character != '1' && character != '0') {
   System.err.println("Invalid character");
   return;
  }
  buffer.append(character);
  switch (state) {
   case Q0:
    if (character == '1') {
     state = Q1;
    } else {
     state = Q0;
    }
    break;
   case Q1:
    if (character == '1') {
     state = Q3;
    } else {
     state = Q2;
    }
    break;
   case Q2:
    //not matter accept any character
    state = Q2;
    break;
   case Q3:
    if (character == '1') {
     state = Q1;
    } else {
     state = Q3;
    }
    break;
   default:
    System.err.println("Error unknow state");

  }
 }

 public static void main(String args[]) {
  String string = JOptionPane.showInputDialog(null, "Enter the string with 0 and/or 1");
  Automata11 automata11 = new Automata11();
  System.out.println("The enter String '" + string + " is accept?:" + automata11.accept(string, true));

 }
}
