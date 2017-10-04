package ahstudios.activehouse;

import android.app.Service;
import android.content.Context;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Oliver on 2017-10-04.
 */

public class TempService extends Service
{
    public TempService() {}


        private static Timer timer = new Timer();
        private Context ctx;
        int HouseID;





    public void onCreate()
    {
        super.onCreate();
        ctx = this;
        startService();
    }

    private void startService()
    {
        timer.scheduleAtFixedRate(new ahstudios.activehouse.TempService.mainTask(), 0, 60000);
    }

    private class mainTask extends TimerTask
    {
        public void run()
        {
            Log.e(this.getClass().getSimpleName(), "service is called");
            new ahstudios.activehouse.TempService.GetTemp().execute();         /////////////////Get the Temp Value in place of GetGas [maybe GetTemp]
            //toastHandler.sendEmptyMessage(0);
        }
    }

}
