package extentions;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

public class WaitTimeUnit {

    public static void twoSecondWait()
    {
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }
    public static void threeSecondWait()
    {
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    public static void Five00_MilliSecondWait()
    {
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
    }

}
