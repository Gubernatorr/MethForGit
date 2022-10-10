package org.example;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

//        List<String> sent = Arrays.asList("Collections and streams, while bearing some superficial similarities, have different goals.",
//                "We create a stream of Widget objects via Collection.stream(), filter it to produce a stream containing only the red widgets.", "By contrast, streams do " +
//                        "not provide a means to directly access or manipulate their elements, and are instead concerned with declaratively " +
//                        "describing their source and the computational operations which will be performed in aggregate on that source.");
        List<String> sent = Arrays.asList("This is a good song, I will listen to it often.", "Oh wow this song has some insane vibes.",
                "Incredible unbelievable mind blowing");
//        System.out.println(sent.size());
//        List<List<Character>> ls = Controller.findChars(sent);
//        System.out.println(ls);

        Controller.findCharsByStream(sent);
    }
}
class Controller{

    public static List<List<Character>> findChars(List<String> stringList) {

        List<List<Character>> listOfCharLists = new ArrayList<>();

        for(String str : stringList){
            List<Character> chars = new ArrayList<>();
            for (int i = 0; i < str.length(); i++){
                if(!chars.contains(str.charAt(i))){
                    chars.add(str.charAt(i));
                }
            }
            listOfCharLists.add(chars);
        }

        return listOfCharLists;
    }

    public static List<List<Character>> findCharsByStream(List<String> stringList){
        List<List<Character>> llc = new ArrayList<>();

//        stringList.stream().forEach(str -> Stream.of(str).flatMap(c -> c.chars().mapToObj(ch -> (char) ch).forEach(chr -> {
//            List<Character> lc = new ArrayList<>();
//            if(!lc.contains(chr)){
//                lc.add(chr);
//            }
//        })));
        for(String txt : stringList){
            List<Character> lc = new ArrayList<>();
            Stream.of(txt).flatMap(c -> c.chars().mapToObj(ch -> (char) ch).filter(chr -> !lc.contains(chr)).toList());
        }

        return llc;
    }
}

//        stringList.stream().forEach(str -> Stream.of(str).flatMap(c -> c.chars().mapToObj(ch -> (char) ch)));
//    public static List<List<Character>> findCharsByStream(List<String> stringList){
//
//        List<Character> textInChar = );
//        textInChar = text.chars().mapToObj(e->(char)e).collect(Collectors.toList());
//        Map<Character, Integer> countChar = stringList.stream().collect(HashMap::new, (m , c) -> {
//            if(m.containsKey(c)){
//                m.put(c, m.get(c) + 1);
//            }else{
//                m.put(c, 1);
//            }
//        }, HashMap::putAll);
//        countChar.forEach( (k, v) -> System.out.println(k + " -> " + v));
//
//        return null;
//    }
