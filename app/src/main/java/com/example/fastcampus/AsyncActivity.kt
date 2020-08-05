package com.example.fastcampus

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_async.*

class AsyncActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)


        var task: BackgroundAsyncTest?=null
        start.setOnClickListener{
            task= BackgroundAsyncTest(progressbar ,ment)
            task?.execute()
        }
        stop.setOnClickListener{
            task?.cancel(true)
        }
    }
}

class BackgroundAsyncTest(
    val progressbar: ProgressBar, val progressText: TextView
) : AsyncTask<Int, Int, Int>() {
    // params: -> doInBackground에서 사용할 타입
    // progress -> onProgressUpdate 에서 사용할 타입
    // result -> onPostExecute 에서 사용할 타입
    // vararg=> 여러개 사용가능하다는 뜻

    var percent: Int = 0
    override fun onPreExecute() {
        percent = 0
        progressbar.setProgress(percent)
    }

    override fun doInBackground(vararg params: Int?): Int {

        while (isCancelled() == false) {
            //완료가 되기전에 취소가 됐는지 안됐는지를 알려준다.
            percent++

            if (percent > 100) {
                break
            } else {
                publishProgress(percent)
            }
            try {
                Thread.sleep(100)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return percent

    }

    override fun onProgressUpdate(vararg values: Int?) {
        progressbar.setProgress(values[0] ?: 0)
        progressText.setText("퍼센트: " + values[0])
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Int?) {
        progressText.setText("작업이 완료되었습니다")
    }

    override fun onCancelled() {
        progressbar.setProgress(0)
        progressText.setText("작업이 취소되었습니다")
    }
}