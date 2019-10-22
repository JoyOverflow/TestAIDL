package ouyj.hyena.com.logservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MessageService extends Service {

    public static final String TAG = "MessageService";
    public MessageService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        return new IMessageService.Stub() {
            @Override
            public void log2(Message msg) throws RemoteException {
                String result=String.format("%s：%s",msg.getTag(),msg.getText());
                Log.d(TAG , result);
            }
        };
    }
}
