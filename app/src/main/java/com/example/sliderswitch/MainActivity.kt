package com.example.sliderswitch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.sliderswitch.ui.theme.SliderSwitchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SliderSwitchTheme {
                DataLoaderApp()
            }
        }
    }
}

