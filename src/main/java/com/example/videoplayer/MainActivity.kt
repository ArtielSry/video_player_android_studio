package com.example.videoplayer

import android.net.IpConfiguration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import com.example.videoplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: IpConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Llamando al componente por su ID
        val videoView = findViewById<VideoView>(binding.testView.id)

        // Creating Mediacontroller - sirve para los controles del video: pausa, play..
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        //Specify the location of media file - donde está el archivo
         val uri: Uri = Uri.parse(
             "android.resource://" + packageName + "/" + R.raw.test
        )

        //Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController) // ponle botones
        videoView.setVideoURI(uri) // ponle el video de esta uri
        videoView.requestFocus() // para que comience a reproducirse nada mas empezar
        videoView.start() // empieza a reproducir
    }
}