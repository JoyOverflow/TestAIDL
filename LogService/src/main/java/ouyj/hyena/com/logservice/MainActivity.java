package ouyj.hyena.com.logservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBinderButton;
    private Button mAddButton;

    //服务端通过AIDL生成的Java接口
    private IMessageService mIBookManager;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            //得到服务端onBind()时返回的binder对象
            IBinder b=binder;
            //得到服务端IMessageService（aidl文件）接口的实例
            mIBookManager = IMessageService.Stub.asInterface(b);
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            mIBookManager = null;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBinderButton = findViewById(R.id.btn_bind);
        mAddButton = findViewById(R.id.btn_add);
        mBinderButton.setOnClickListener(this);
        mAddButton.setOnClickListener(this);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mIBookManager!=null){
            unbindService(mServiceConnection);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_bind:{

                //Intent intent = new Intent("ouyj.hyena.com.logservice.MessageService");
                Intent intent = new Intent(this,MessageService.class);
                this.bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
                Toast.makeText(getApplicationContext(),"服务已绑定！！", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_add:{

                if(mIBookManager!=null){
                    try {
                        mIBookManager.log2(new Message("104259","ouyj"));
                        Toast.makeText(
                                getApplicationContext(),
                                "log2",
                                Toast.LENGTH_SHORT
                        ).show();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }

                break;
            }
        }
    }

}
