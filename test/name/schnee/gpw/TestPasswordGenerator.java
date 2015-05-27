package name.schnee.gpw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import junit.framework.TestCase;

/**
 * User: bschneem
 * Date: Feb 4, 2005
 * Time: 2:43:08 PM
 */
public class TestPasswordGenerator extends TestCase
{
    private static final int NPW = 300000;

    public TestPasswordGenerator(String s)
    {
        super(s);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public void testGenerate()
    {
        String seed = Long.toString(System.currentTimeMillis());

        List words = PasswordGenerator.generate(NPW, 8, seed.getBytes());

        Set wordSet = new HashSet(words);

        System.out.println("Unique Entries:    " + wordSet.size());
        System.out.println("Requested Entries: " + NPW);

//        Stopwatch timer = new Stopwatch();
//        for (int k = 0; k < 5; k++)
//        {
//            timer.start();
//            String[] s2 = sortOnInsert(wordSet);
//            timer.stop();
//            System.out.println(s2.length + " items inserted into SortedSet took " + timer.getElapsedFormatted());
//
//            timer.reset();
//            timer.start();
//            String[] sorted = sortAtEnd(wordSet);
//            timer.stop();
//            System.out.println(sorted.length + " items inserted then sorted took " + timer.getElapsedFormatted());
//
//        }

    }

    private String[] sortAtEnd(Set wordSet)
    {
        List sortAtEnd = new ArrayList();
        for (Iterator iterator = wordSet.iterator(); iterator.hasNext();)
        {
            String s = (String) iterator.next();
            sortAtEnd.add(s);
        }
        String[] sorted = (String[]) sortAtEnd.toArray(new String[0]);
        Arrays.sort(sorted);
        return sorted;
    }

    private String[] sortOnInsert(Set wordSet)
    {
        SortedSet sortOnInsert = new TreeSet();
        for (Iterator iterator = wordSet.iterator(); iterator.hasNext();)
        {
            String s = (String) iterator.next();
            sortOnInsert.add(s);
        }
        String[] s2 = (String[]) sortOnInsert.toArray(new String[0]);
        return s2;
    }
}
