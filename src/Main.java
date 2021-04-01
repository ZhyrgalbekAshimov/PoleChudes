import java.util.*;

public class Main {

    public static void main(String[] args)  {

        Scanner scan = new Scanner(System.in);

        Set<Question> questions = new HashSet<>();
        questions.add(new Question("Столица Кыргызстана?", "БИШКЕК"));
        questions.add(new Question("Столица Казахстана?", "АСТАНА"));
        questions.add(new Question("Фамилия первого президента США?", "ВАШИНГТОН"));
        questions.add(new Question("Фамилия первого президента России?", "ЕЛЬЦИН"));
        questions.add(new Question("Самое высокая гора в мире?", "ЭВЕРЕСТ"));
        questions.add(new Question("Самая большая планета в Солнечной системе?", "ЮПИТЕР"));

        ArrayList<Question> questionArrayList = new ArrayList<>(questions);
        Collections.shuffle(questionArrayList);

        System.out.println(questionArrayList.get(0).getQuestion());

        for (int i = 0; i < questionArrayList.get(0).getAnswer().length(); i++) {

            System.out.print("* ");

        }

        System.out.println();

        int answerLength = (int) Math.round((double) (questionArrayList.get(0).getAnswer().length() + 1) / 4);
        System.out.println("\nВам разрешается отгадать " + answerLength + " букв(ы):");

        ArrayList<Character> charAnswer = new ArrayList<>();

        for (int i = 1; i <= answerLength; i++) {

            System.out.print(i + ") Введите букву: ");

            String enteredChar = scan.next();

            if(enteredChar.length() != 1){
                System.out.println("Вы ввели несколько букв. Введите только 1 букву!");
                i--;
                continue;
            }

            char ch = enteredChar.toLowerCase().charAt(0);
            boolean isFewChars = false;
            for (Character aChar : charAnswer) {

                if (aChar == ch) {
                    System.out.println("Вы уже вводили такую букву. Введите другую букву!");
                    i--;
                    isFewChars = true;
                    break;
                }
            }

            if(!isFewChars){
                charAnswer.add(ch);
            }
        }

        System.out.println("\nРезультат: ");

        String answer = questionArrayList.get(0).getAnswer().toLowerCase();
        for (int i = 0; i < answer.length(); i++) {

            boolean isCharsMatching = false;
            for (Character aChar : charAnswer) {
                if (answer.charAt(i) == aChar) {
                    System.out.print(questionArrayList.get(0).getAnswer().charAt(i) + " ");
                    isCharsMatching = true;
                }
            }
            
            if(!isCharsMatching){
                System.out.print("* ");
            }
        }
    }
}