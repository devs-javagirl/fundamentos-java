package java_para_iniciantes.cap3;

public class ContToLabel {
    public static void main(String[] args) {
        outerloop:
        for(int i=1; i < 10; i++) {
            System.out.print("\nOuter loop pass " + i +
                    ", Inner loop: ");
            for (int j = 1; j < 10; j++) {
                if (j == 5)
                    continue outerloop; // la�o externo de continue
                System.out.print(j);
            }
        }
    }
}
