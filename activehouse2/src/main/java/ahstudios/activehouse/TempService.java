package ahstudios.activehouse;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

public class TempService extends Service {
    public TempService() {
    }

    private static Timer timer = new Timer();
    private Context ctx;
    int HouseID;

    public IBinder onBind(Intent arg0)
    {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        HouseID = intent.getIntExtra("HouseID", 0);
        return START_STICKY;
    }

    public void onCreate()
    {
        super.onCreate();
        ctx = this;
        startService();
    }

    private void startService()
    {
        timer.scheduleAtFixedRate(new mainTask(), 0, 60000);
    }

    private class mainTask extends TimerTask
    {
        public void run()
        {
            Log.e(this.getClass().getSimpleName(), "service is called");
			new ahstudios.activehouse.TempService.getTemp().execute();   
            
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        
    }

    private class GetTemp extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

        }
    }

}