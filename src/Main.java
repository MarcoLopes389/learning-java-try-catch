import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        try (var bufferedReader = new BufferedReader(new FileReader("/home/marco/Área de Trabalho/projetos/learning-try-catch/src/index.csv"))) {
            var items = new ArrayList<HashMap<String, String>>();
            var chaves = new ArrayList<String>();
            final int[] index = {0};
            bufferedReader.lines().forEach( (item) -> {
                var splitted = item.split(",");
                if (index[0] == 0) {
                    for (var chave : splitted) {
                        chaves.add(chave);
                    }
                } else {
                    var hashMap = new HashMap<String, String>();
                    for (var i = 0; i < chaves.size(); i++) {
                        hashMap.put(chaves.get(i), splitted[i]);
                    }
                    items.add(hashMap);
                }
                index[0]++;
            });
            System.out.println(items);
        } catch (IOException e) {
            System.out.println("erro");
        }
    }
}