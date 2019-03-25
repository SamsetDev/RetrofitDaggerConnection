package sample.sam.com.daggerretrofitconnection.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import dagger.android.AndroidInjection;
import sample.sam.com.daggerretrofitconnection.R;
import sample.sam.com.daggerretrofitconnection.utils.Constant;
import sample.sam.com.daggerretrofitconnection.utils.HelloData;

import android.os.Bundle;
import android.util.Log;

import java.util.Date;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private MutableLiveData<Date> liveData;

    @Inject
    Constant constant;

    @Inject
    HelloData helloData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TAG"," Comming msg-1  "+ constant.showmsg());
        Log.e("TAG"," Comming msg-2  "+ helloData.sayHello());

    }
}
