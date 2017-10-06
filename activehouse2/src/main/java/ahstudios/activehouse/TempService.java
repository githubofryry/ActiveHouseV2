package ahstudios.activehouse;

import android.app.Service;
import android.content.Context;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class TempService extends Service
{
    public TempService() {}


        private static Timer timer = new Timer();
        private Context ctx;
        int HouseID;
        
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
        timer.scheduleAtFixedRate(new ahstudios.activehouse.TempService.mainTask(), 0, 60000);
    }

    private class mainTask extends TimerTask
    {
        public void run()
        {
            Log.e(this.getClass().getSimpleName(), "service is called");
            new ahstudios.activehouse.TempService.getTemp().execute();         /////////////////Get the Temp Value in place of GetGas [maybe GetTemp]
            //toastHandler.sendEmptyMessage(0);
        }
    }
    
    public void onDestroy()
    {
        super.onDestroy();
        //Toast.makeText(this, "Service Stopped ...", Toast.LENGTH_SHORT).show();
    }
    
    private class GetTemp extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Toast.makeText(HomeActivity.this,"Json Data is downloading",Toast.LENGTH_LONG).show();

}
