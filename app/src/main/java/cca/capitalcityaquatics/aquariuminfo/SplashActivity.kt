package cca.capitalcityaquatics.aquariuminfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.TextView
import cca.capitalcityaquatics.aquariuminfo.R

class SplashActivity : AppCompatActivity() {

    private lateinit var timerTV: TextView

    companion object{
        private const val TAG = "SPLASH_TAG"

        private  const val COUNTER_TIMER: Long = 5
    }

    private var secondsRemaining: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        timerTV = findViewById(R.id.timerTV)

        createTimer(COUNTER_TIMER)
    }

    private fun createTimer(seconds: Long){
        val countdownTimer: CountDownTimer = object : CountDownTimer(seconds * 1000, 1000){

            override fun onTick(millisUntilFinished: Long) {
                Log.d(TAG, "onTick: $millisUntilFinished")
                secondsRemaining = millisUntilFinished / 1000 + 1
                timerTV.text = "Loading in $secondsRemaining"
            }

            override fun onFinish() {
                Log.d(TAG, "onFinish: ")
                secondsRemaining = 0
                timerTV.text = "Loaded..."
                
                var application = application
                if (application !is MyApplication){
                    Log.d(TAG, "onFinish: Failed to cast application to MyApplication")
                    startMainActivity()
                    return
                }

                application.showAdIfAvailable(
                    this@SplashActivity,
                    object: MyApplication.OnShowAdCompletedListener{
                        override fun onShowAdComplete() {
                            Log.d(TAG, "onShowAdComplete: ")
                            startMainActivity()
                        }
                    }
                )
            }
        }

        countdownTimer.start()

    }
    private  fun  startMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onBackPressed(){
        moveTaskToBack(true)
    }
}