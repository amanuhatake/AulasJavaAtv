import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class Main {
    public static void main(String[] args) {
        Aluno estudante = new Aluno("Manu Silva", 25);
        try {
            ArrayList<Aluno> alunos = new ArrayList<>();

            alunos.add(new Aluno("Manu Silva", 25));
            alunos.add(new Aluno("Henrique", 27));
            alunos.add(new Aluno("Alguem", 25));
            alunos.add(new Aluno("Alguem 2 ", 25));

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("alunos.dat"));

            oos.writeObject(alunos); //escrevemos
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("alunos.dat"));

            ArrayList<Aluno> lista = (ArrayList<Aluno>)ois.readObject(); //salvando

            for(Aluno a : lista){
                System.out.println(a);
            }

            ois.close();

            System.out.println("Objeto serializado com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
