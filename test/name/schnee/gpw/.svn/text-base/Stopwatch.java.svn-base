package name.schnee.gpw;

/**
 * User: bschneem
 * Date: Feb 4, 2005
 * Time: 2:53:49 PM
 */
/*

/**
 * Abstracts a stopwatch.
 * @author <a href="mailto:bschneem@inovant.com">Brent Schneeman</a>
 **/

public class Stopwatch
{
    /**
     * A class to help benchmark code
     * It simulates a real stop watch
     */

    private long startTime = -1;
    private long stopTime = -1;

    private static long millisPerSecond = 1000;
    private static long millisPerMinute = millisPerSecond * 60;
    private static long millisPerHour = millisPerMinute * 60;

    private boolean running = false;

    /**
     * Starts the timer
     * @return a Stopwatch object
     */
    public Stopwatch start()
    {
        startTime = System.currentTimeMillis();
        running = true;
        return this;
    }

    /**
     * Constructs a new Stopwatch object, starts it and returns it
     *
     * @return a running Stopwatch object
     */
    public static Stopwatch go()
    {
        return new Stopwatch().start();
    }

    /**
     * Stops the timer
     * @return this Stopwatch object
     */
    public Stopwatch stop()
    {
        stopTime = System.currentTimeMillis();
        running = false;
        return this;
    }

    /**
     * returns elapsed time in milliseconds
     * if the watch has never been started then
     * return zero
     * @return the elapsed time in milliseconds since the watch has started
     */
    public long getElapsedTime()
    {
        if (startTime == -1)
        {
            return 0;
        }
        if (running)
        {
            return System.currentTimeMillis() - startTime;
        }
        else
        {
            return stopTime - startTime;
        }
    }

    /**
     * Returns the elapsed time
     * in the form "HH hours MM Minutes SS.ss seconds"
     * @return a String representation of the elapsed time
     */
    public String getElapsedFormatted()
    {
        long elapsed = getElapsedTime();

        return getElapsedFormatted(elapsed);

    }

    /**
     * Formats the parameters into "HH hours MM Minutes SS.ss seconds"
     * @param elapsed
     * @return a formatted String
     */
    public static String getElapsedFormatted(long elapsed)
    {
        StringBuffer sb = new StringBuffer();

        double hours = (double)elapsed / millisPerHour;
        if (hours > 1)
        {
            final int i = (int) hours;
            sb.append(i);
            if (i == 1)
            {
                sb.append(" hour ");
            }
            else
            {
                sb.append(" hours ");
            }

            elapsed = elapsed % millisPerHour;
        }

        double minutes = (double)elapsed / millisPerMinute;
        if (minutes > 1)
        {
            final int i = (int) minutes;
            sb.append(i);
            if (i == 1)
            {
                sb.append(" minute ");
            }
            else
            {
                sb.append(" minutes ");
            }

            elapsed = elapsed % millisPerMinute;
        }

        double seconds = (double)elapsed / millisPerSecond;
        sb.append(seconds);

        if (seconds == 1.0)
        {
            sb.append(" second");
        }
        else
        {
            sb.append(" seconds");
        }


        return sb.toString();
    }

    /**
     * Resets the stop watch
     * @return a reset Stopwatch
     */
    public Stopwatch reset()
    {
        startTime = -1;
        stopTime = -1;
        running = false;
        return this;
    }

    /**
     * Restarts the stopwatch;
     * @return a restarted Stopwatch
     */
    public Stopwatch restart()
    {
        this.reset();
        this.start();
        return this;
    }

}


