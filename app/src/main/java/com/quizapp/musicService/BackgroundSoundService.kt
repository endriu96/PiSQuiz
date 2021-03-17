package com.quizapp.musicService

import android.app.Service
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast
import com.quizapp.R
import java.util.*


class BackgroundSoundService : Service() {
    var mediaPlayer: MediaPlayer? = null


    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    fun onCompletion(mediaPlayer: MediaPlayer) {
        var count = 0
        mediaPlayer.setOnCompletionListener {

            mediaPlayer.stop()
        }

    }

    override fun onCreate() {
        super.onCreate()



        mediaPlayer = MediaPlayer.create(this, R.raw.twoj_bol_lepszy_niz_moj)


    }


    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        mediaPlayer!!.start()
        Toast.makeText(applicationContext, "Playing  Music in the Background", Toast.LENGTH_SHORT)
                .show()
        return startId
    }

    override fun onStart(intent: Intent, startId: Int) {


    }

    override fun onDestroy() {
        mediaPlayer!!.stop()
        mediaPlayer!!.release()
    }


    override fun onLowMemory() {
        mediaPlayer!!.stop()
    }


}
