package ouyj.hyena.com.demondk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //加载本地库（ouyang.so文件，可省略后缀名）
    static {
        System.loadLibrary("ouyang");
    }
    //声明原生库内的方法
    public native String test1();
    public native String test2();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //调用C++函数返回字串
        TextView tv = findViewById(R.id.txt_sample);
        tv.setText(test1());
    }



}
