package com.pignasoft.dotasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.pignasoft.dotasks.ui.theme.DoTasksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoTasksTheme {
                MainScreen()
            }
        }
    }
}
