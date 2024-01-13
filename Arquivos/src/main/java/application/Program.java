package application;

import entiti.Produst;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {

        String path = "C:\\Users\\otavi\\Downloads\\hernando\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Produst> list = new ArrayList<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Produst(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();

            }
            double salary = 2000;

            System.out.println("Lista de funcionciorio com  Nome e Email e Salario: ");

            //*Lista: todos funcionarios
            List<String> todosFuncionarios = list.stream()
                    .map(p -> p.toString())
                    .sorted()
                    .collect(Collectors.toList());
            todosFuncionarios.forEach(System.out::println);

            System.out.println();
            System.out.println("Lista de Nomes:");

            //*Lista: todos nomes 
            List<String> todosNomes = list.stream()
                    .map(p -> p.getName())
                    .sorted()
                    .collect(Collectors.toList());
            todosNomes.forEach(System.out::println);

            System.out.println();
            System.out.println("Lista de Email:");

            //Lista: todos emails 
            List<String> todosEmails = list.stream()
                    .map(p -> p.getEmail())
                    .sorted()
                    .collect(Collectors.toList());
            todosEmails.forEach(System.out::println);

            System.out.println();
            System.out.println("E-mail de pessoas cujo salário é superior a " + String.format("%.2f", salary) + ":");
            System.out.println();
            
            //emails com o salario maior que 2000
            List<String> emails = list.stream()
                    .filter(p -> p.getPrice() > salary)
                    .map(p -> p.getEmail())
                    .sorted()
                    .collect(Collectors.toList());
            emails.forEach(System.out::println);

            System.out.println();
            System.out.println();

            //nomes com a letra inicial do nome 'M'
            List<String> todosFuncionariosM = list.stream()
                    .filter(p -> p.getName().charAt(0) == 'M')
                    .map(p -> p.toString())
                    .sorted()
                    .collect(Collectors.toList());
            todosFuncionariosM.forEach(System.out::println);
            
           //soma do salario cuja  a letra inicial do nome começa com a letra 'M'
            double sum = list.stream()
                    .filter(p -> p.getName().charAt(0) == 'M')
                    .map(p -> p.getPrice())
                    .reduce(0.0, (x, y) -> x + y);

            System.out.print(" Soma dos salarios com inicial M: " + String.format("%.2f", sum));

        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }

    }
}
