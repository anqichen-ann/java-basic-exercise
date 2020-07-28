import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GrammarExercise {
    public static void main(String[] args) {

        String firstWordList = "";
        String secondWordList = "";
        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        String[] firstArray = firstWordList.split(",");
        String[] secondArray = secondWordList.split(",");
        List<String> f1 = Arrays.asList(firstArray);
        List<String> f2 = Arrays.asList(secondArray);
        List<String> res11 = f1.stream().filter(str -> str.isEmpty()).collect(Collectors.toList());
        List<String> res12 = f1.stream().filter(str -> str.matches(".*[^a-zA-Z]+.*")).collect(Collectors.toList());
        List<String> res21 = f2.stream().filter(str -> str.isEmpty()).collect(Collectors.toList());
        List<String> res22 = f2.stream().filter(str -> str.matches(".*[^a-zA-Z]+.*")).collect(Collectors.toList());


        if (res11.size() + res12.size() + res21.size() + res22.size() > 0) {
            throw new RuntimeException("input not valid");
        }
        List<String> f22 = f2.stream().map(s -> s.toUpperCase()).distinct().collect(Collectors.toList());
        List<String> result = f1.stream().map(s -> s.toUpperCase()).filter(f22::contains).distinct().sorted().collect(Collectors.toList());
        List<String> result1 = result.stream().map((s) -> {
            String[] sar = s.split("");
            String newstr="";
            for(String st :sar){
                newstr = newstr + " " + st;
            }
            return newstr.trim();
        }).collect(Collectors.toList());


        return result1;
    }
}
