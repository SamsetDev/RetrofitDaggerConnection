package sample.sam.com.daggerretrofitconnection.view.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import dagger.android.AndroidInjection
import sample.sam.com.daggerretrofitconnection.R
import sample.sam.com.daggerretrofitconnection.utils.Constant
import sample.sam.com.daggerretrofitconnection.utils.HelloData

import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

import java.util.Date

import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var constant: Constant

    @Inject
    lateinit var helloData: HelloData


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)


    }

    override fun onResume() {
        super.onResume()
       showApplicationScopeMsg()
        showActivityScopeMsg()

    }

    private fun showApplicationScopeMsg(){
        tvmsg1.text=constant?.showmsg()
    }

    private fun showActivityScopeMsg(){
        tvmsg2.text=helloData?.sayHello()
    }
}
