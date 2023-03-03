import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class AnswerCheckSat{

	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args){

		Scanner reader = new Scanner(System.in);
		String [] answersUF;
		String text = "";
		ArrayList<Character> readingAns = new ArrayList<>();
		ArrayList<Character> writingAns = new ArrayList<>();
		ArrayList<Character> mathNCAns = new ArrayList<>();
		ArrayList<Character> mathCAns = new ArrayList<>();


	        try {
		            File file = new File("AnswersSAT.txt");
		            Scanner input = new Scanner(file);

	            while (input.hasNextLine()) {
	                text += input.nextLine();

			}
	            //ans = element[x].split(" ")[1]
	            //if ans = input[x]
	            //mark asnwer as true
	            //else mark answer as false
	            input.close();
		        }
		        catch (Exception ex) {
	            ex.printStackTrace();
       }
       answersUF = text.split("#");

		for(int i = 0; i < answersUF[0].length(); i++){
			if(answersUF[0].charAt(i) == 'A' || answersUF[0].charAt(i) == 'B' || answersUF[0].charAt(i) == 'C' || answersUF[0].charAt(i) == 'D'){
				readingAns.add(answersUF[0].charAt(i));
			}
		}

		for(int i = 0; i < answersUF[1].length(); i++){
			if(answersUF[1].charAt(i) == 'A' || answersUF[1].charAt(i) == 'B' || answersUF[1].charAt(i) == 'C' || answersUF[1].charAt(i) == 'D'){
				writingAns.add(answersUF[1].charAt(i));
			}
		}

		for(int i = 0; i < answersUF[2].length(); i++){
			if(answersUF[2].charAt(i) == 'A' || answersUF[2].charAt(i) == 'B' || answersUF[2].charAt(i) == 'C' || answersUF[2].charAt(i) == 'D'){
				mathNCAns.add(answersUF[2].charAt(i));
			}
		}

		for(int i = 0; i < answersUF[3].length(); i++){
			if(answersUF[3].charAt(i) == 'A' || answersUF[3].charAt(i) == 'B' || answersUF[3].charAt(i) == 'C' || answersUF[3].charAt(i) == 'D'){
				mathCAns.add(answersUF[3].charAt(i));
			}
		}


       System.out.println("Welcome to the answer checker! For this program to work, the correct answers must be in the answersSAT.txt file.\n"
	   		+ "Separate sections with a single hash. NO HASH BEFORE THE READING STARTS\n"
		+ "Add them in without any spaces.\nEx: ABCDAB Or EX: abcdab. Run the program then add in your answers in the same style. \nPress 1 to check reading, 2 to check writing,"
		+ " 3 to check math non calculator, 4 to check math calculator");
		int x = reader.nextInt();
		//string of correct answers
		//input for answers
		//arraylist = list of size correct answer size,
		//if inputsize != answer size you missed one question
		//for x in correct answer.length, if correctanswer[x] == input[x] arrayList = True
		//abcd acbd (0,1,1,0)
		if (x == 1){
			readingCheck(readingAns);
		}
		else if (x == 2){
			writingCheck(writingAns);
		}
		else if (x == 3){
			mathNCCheck(mathNCAns);
		}
		else if (x == 4){
			mathCCheck(mathCAns);
		}

		//reader.close();

	}

	public static void mathCCheck(ArrayList<Character> mathCAns){
					System.out.println("Enter your answers for the Math calculator section (Only MCs):\n");
							ArrayList<Character> yourMathC = new ArrayList<>();
							for(int i = 0; i < 30; i++){
								System.out.print((i + 1) + ". ");
								yourMathC.add(reader.next().charAt(0));
								System.out.println();
							}

							ArrayList<Integer> mathCWrong = new ArrayList<Integer>();

							for (int i = 0; i < 30; i++){
								if(Character.toUpperCase(yourMathC.get(i)) != Character.toUpperCase(mathCAns.get(i))){
									mathCWrong.add((i+1));
								}
							}
							System.out.println("You got " + mathCWrong.size() + " wrong");
							System.out.println("Your math calculator raw score (Not including free response) is a " + (30-mathCWrong.size()));
							System.out.println("The numbers that are wrong are listed below");
					System.out.println(mathCWrong);
	}

	public static void mathNCCheck(ArrayList<Character> mathNCAns){
				System.out.println("Enter your answers for the Math non calculator section (Only MCs):\n");
						ArrayList<Character> yourMathNC = new ArrayList<>();
						for(int i = 0; i < 15; i++){
							System.out.print((i + 1) + ". ");
							yourMathNC.add(reader.next().charAt(0));
							System.out.println();
						}

						ArrayList<Integer> mathNCWrong = new ArrayList<Integer>();

						for (int i = 0; i < 15; i++){
							if(Character.toUpperCase(yourMathNC.get(i)) != Character.toUpperCase(mathNCAns.get(i))){
								mathNCWrong.add((i+1));
							}
						}
						System.out.println("You got " + mathNCWrong.size() + " wrong");
						System.out.println("Your Math NC raw score (Not including free response) is a " + (15-mathNCWrong.size()));
						System.out.println("The numbers that are wrong are listed below");
				System.out.println(mathNCWrong);
	}

	public static void writingCheck(ArrayList<Character> writingAns){
			System.out.println("Enter your answers for the writing section:\n");
					ArrayList<Character> yourWriting = new ArrayList<>();
					for(int i = 0; i < 44; i++){
						System.out.print((i + 1) + ". ");
						yourWriting.add(reader.next().charAt(0));
						System.out.println();
					}

					ArrayList<Integer> writingWrong = new ArrayList<Integer>();

					for (int i = 0; i < 44; i++){
						if(Character.toUpperCase(yourWriting.get(i)) != Character.toUpperCase(writingAns.get(i))){
							writingWrong.add((i+1));
						}
					}
					System.out.println("You got " + writingWrong.size() + " wrong");
					System.out.println("Your writing raw score is a " + (44-writingWrong.size()));
					System.out.println("The numbers that are wrong are listed below");
			System.out.println(writingWrong);
	}

	public static void readingCheck(ArrayList<Character> readingAns){
		System.out.println("Enter your answers for the reading section:\n");
				ArrayList<Character> yourReading = new ArrayList<>();
				for(int i = 0; i < 52; i++){
					System.out.print((i + 1) + ". ");
					yourReading.add(reader.next().charAt(0));
					System.out.println();
				}

				ArrayList<Integer> readingWrong = new ArrayList<Integer>();

				for (int i = 0; i < 52; i++){
					if(Character.toUpperCase(yourReading.get(i)) != Character.toUpperCase(readingAns.get(i))){
						readingWrong.add((i+1));
					}
				}
				System.out.println("You got " + readingWrong.size() + " wrong");
				System.out.println("Your reading raw score is a " + (52-readingWrong.size()));
				System.out.println("The numbers that are wrong are listed below");
		System.out.println(readingWrong);
	}

}