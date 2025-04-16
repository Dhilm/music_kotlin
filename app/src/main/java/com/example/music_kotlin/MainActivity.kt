package com.example.musicapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private val musicUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playButton = findViewById<Button>(R.id.playButton)
        val stopButton = findViewById<Button>(R.id.stopButton)

        playButton.setOnClickListener {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer().apply {
                    setDataSource(musicUrl)
                    prepareAsync()
                    setOnPreparedListener { start() }
                }
            } else {
                mediaPlayer?.start()
            }
        }

        stopButton.setOnClickListener {
            mediaPlayer?.pause()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
