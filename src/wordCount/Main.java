package wordCount;

import org.w3c.dom.Text;

import java.util.*;
import java.util.stream.Collectors;

public class Main
{
    private static HashMap.Entry<String, Integer> findLargest(HashMap<String, Integer> map)
    {
        HashMap.Entry<String, Integer> maxEntry = null;

        for (HashMap.Entry<String, Integer> entry : map.entrySet())
        {
            if ((maxEntry == null) || (maxEntry.getValue() < entry.getValue()))
            {
                maxEntry = entry;
            }
        }

        return maxEntry;
    }



    public static void main(String[] args)
    {
	    String unText = new TheText().getTheText();

//        remove punctuation marks which include . ? ! , ; : { } ( ) '
//        this could be handled by a regular expression or replace each punctuation mark

        unText = unText.replaceAll("[[\\.\\?\\!\\,\\;\\:\\{\\}\\(\\)\\']]", "");

//        unText = unText.replace(".", "");
//        unText = unText.replace("?", "");
//        unText = unText.replace("!", "");
//        unText = unText.replace(",", "");
//        unText = unText.replace(";", "");
//        unText = unText.replace(":", "");
//        unText = unText.replace("{", "");
//        unText = unText.replace("}", "");
//        unText = unText.replace("(", "");
//        unText = unText.replace(")", "");
//        unText = unText.replace("'", "");
//        unText = unText.replace("-", "");
//
        String[] words = unText.split(" +");
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (String aWord:words)
        {
            if (!map.containsKey(aWord))
            {
                map.put(aWord, 1);
            }
            else
            {
                map.put(aWord, map.get(aWord) + 1);
            }
        }

//        for (int i = 1; i <= 50; i++)
//        {
//            HashMap.Entry<String, Integer> maxEntry = findLargest(map);
//            System.out.println(i + " most common word: <" + maxEntry.getKey() + "> and occurs: " + maxEntry.getValue());
//            map.remove(maxEntry.getKey());
//        }

        ArrayList<HashMap.Entry<String, Integer>> sortedMap = new ArrayList<HashMap.Entry<String, Integer>>();
        sortedMap.addAll(map.entrySet());

        Collections.sort(sortedMap, new Comparator<Map.Entry<String, Integer> >()
        {
            public int compare (HashMap.Entry<String, Integer> o1, HashMap.Entry<String, Integer> o2)
            {
                return o2.getValue() - o1.getValue();
            }
        });

        // alphaSortedMap is for Stretch Goal
        ArrayList<HashMap.Entry<String, Integer>> alphaSortedMap = new ArrayList<HashMap.Entry<String, Integer>>();
        System.out.println("\nTop 50 words\n");
        for (int i = 0; i < 50 ; i++)
        {
            System.out.println("Common Word <" + sortedMap.get(i).getKey() + "> occurs " + sortedMap.get(i).getValue() + " times");
            alphaSortedMap.add(sortedMap.get(i));
        }

        // the rest is for Stretch Goal

        System.out.println("\nTop 50 words Alphabetically\n");

        Collections.sort(alphaSortedMap, new Comparator<Map.Entry<String, Integer> >()
        {
            public int compare (HashMap.Entry<String, Integer> o1, HashMap.Entry<String, Integer> o2)
            {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for (int i = 0; i < 50 ; i++)
        {
            System.out.println("Common Word <" + alphaSortedMap.get(i).getKey() + "> occurs " + alphaSortedMap.get(i).getValue() + " times");
        }
    }
}
