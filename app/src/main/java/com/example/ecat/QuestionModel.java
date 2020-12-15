package com.example.ecat;

public class QuestionModel {
  String[] quizQustions={
          "Which is the square root of the 12?",
          "Which is the answer of (3+5)^2?",
          "what is the expansion of (a+b)^2?",
          "What is the formula for methan?",
          "What will be formed after reacter of Na (s) + Cl2 (g) → _____?",
          "____ states that every object will remain at rest or in uniform motion in a straight line unless compelled to change its state by the action of an external force?",
          "What is the equation of charle's law?",
          "Whihc law states that the pressure (p) of a given quantity of gas varies inversely with its volume (v) at constant temperature",
          "____ states that for any closed loop path, the sum of the length elements times the magnetic field in the direction of the length element is equal to the permeability times the electric current enclosed in the loop",
          "What is EMF stands for?"

  };

  String[][] quizOptions={
          {"122","144","12","16"},
          {"64","11","155","33.3"},
          {"a^2-2ab-b^2","a^2-2ab+b^2","a^2+2ab+b^2","a^3-2ab-b^3"},
          {"H2O","CH2","NACL","CH4"},
          {"NaCl (s)","CH4 (g)","C5H12 (g)","C3H8 (s)"},
          {"Neuton's third law","Neuton's first law","Neutons'second law","Neutons forth law"},
          {"V1/T1","V2/T2","V1/T1=V2/T2","V1/T2=T1/V2"},
          {"Neuton's Law","Charle's Law","Pascal Law","Boyle's Law"},
          {"Amper's Law","neuton's Law","Coulmbo's Law","Kirchoff's Law"},
          {"Electrical Movement Force","Electromotive Force","Electromegnatic Force","Electromegnificient Force"}
  };
  String[] correctAnswers={
    "144","64","a^2+2ab+b^2","CH4","NaCl (s)","Neuton's first law","V1/T1=V2/T2","Boyle's Law","Amper's Law","Electromotive Force"
  };
  String getQuestions(int a){
      String question=quizQustions[a];
      return question;
  }
  String getOption1(int a){
      String option1=quizOptions[a][0];
      return option1;
  }
    String getOption2(int a){
        String option2=quizOptions[a][1];
        return option2;
    }
    String getOption3(int a){
        String option3=quizOptions[a][2];
        return option3;
    }
    String getOption4(int a){
        String option4=quizOptions[a][3];
        return option4;
    }
    String getCorrectAns(int a){
      String ans=correctAnswers[a];
      return ans;
    }
}
