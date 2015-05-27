package name.schnee.gpw;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import name.schnee.gpw.data.GpwData;

//Optorych4n Optorych4n
/**
 * User: bschneem
 * Date: Jan 26, 2005
 * Time: 5:22:17 PM
 */
public class PasswordGenerator
{
    private static GpwData data = null;
    private final static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    static
    {
        data = new GpwData();
    }

    public static List<String> generate(int npw, int pwl, byte[] seed)
    {
        List<String> passwords = new ArrayList<String>(npw);

        StringBuffer password;
        Random ran = new SecureRandom(seed); // new random source seeded by clock

        // Pick a random starting point.
        for (int pwnum = 0; pwnum < npw; pwnum++)
        {
            password = makeWord(pwl, ran);

            passwords.add(password.toString());
        } // for pwnum
        return passwords;
    }

    public static StringBuffer makeWord(int pwl, Random ran)
    {
        StringBuffer password;
        double pik;
        long ranno;
        long sum;
        int c1;
        int c2;
        int c3;
        int nchar;
        password = new StringBuffer(pwl);
        pik = ran.nextDouble(); // random number [0,1]
        ranno = (long) (pik * data.getSigma()); // weight by sum of frequencies
        sum = 0;
        for (c1 = 0; c1 < 26; c1++)
        {
            for (c2 = 0; c2 < 26; c2++)
            {
                for (c3 = 0; c3 < 26; c3++)
                {
                    sum += data.get(c1, c2, c3);
                    if (sum > ranno)
                    {
                        password.append(alphabet.charAt(c1));
                        password.append(alphabet.charAt(c2));
                        password.append(alphabet.charAt(c3));
                        c1 = 26; // Found start. Break all 3 loops.
                        c2 = 26;
                        c3 = 26;
                    } // if sum
                } // for c3
            } // for c2
        } // for c1

        // Now do a random walk.
        nchar = 3;
        while (nchar < pwl)
        {
            c1 = alphabet.indexOf(password.charAt(nchar - 2));
            c2 = alphabet.indexOf(password.charAt(nchar - 1));
            sum = 0;
            for (c3 = 0; c3 < 26; c3++)
            {
                sum += data.get(c1, c2, c3);
            }
            if (sum == 0)
            {
                break;	// exit while loop
            }
            pik = ran.nextDouble();
            ranno = (long) (pik * sum);
            sum = 0;
            for (c3 = 0; c3 < 26; c3++)
            {
                sum += data.get(c1, c2, c3);
                if (sum > ranno)
                {
                    password.append(alphabet.charAt(c3));
                    c3 = 26; // break for loop
                } // if sum
            } // for c3
            nchar++;
        } // while nchar
        return password;
    }

    public static void main(String args[])
    {
        String seed = Long.toString(System.currentTimeMillis());
        for (String string : args) {
        	seed += string;
		}
        
        List<String> pwds = PasswordGenerator.generate(10, 10, seed.getBytes());
        for (String password : pwds) {
			System.out.println(password);
		}

    } // main()
}
