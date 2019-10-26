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
    public void onCreate() {
        Log.d(TAG , "onCreate");
        super.onCreate();
    }


    /**
     * 客户绑定服务端时触发
     * @param intent
     * @return
     */
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG , "onBind");
        //实现接口内的抽象类
        return new IMessageService.Stub() {
            @Override
            public void log2(Message msg) throws RemoteException {
                String result=String.format("%s：%s",msg.getTag(),msg.getText());
                Log.d(TAG , result);
            }
        };
    }


    @Override
    public void onRebind(Intent intent) {
        Log.d(TAG , "onRebind");
        super.onRebind(intent);
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG , "onUnbind");
        return super.onUnbind(intent);
    }
    @Override
    public void onDestroy() {
        Log.d(TAG , "onDestroy");
        super.onDestroy();
    }
}
