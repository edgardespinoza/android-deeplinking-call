package com.eespinor.deeplinkingcall

import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.eespinor.deeplinkingcall.ui.theme.DeeplinkingCallTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeeplinkingCallTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {

                    Button(onClick = {
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("app://eespinor.com/123")
                        )
                        val pendingIntent = TaskStackBuilder.create(applicationContext).run {
                            addNextIntentWithParentStack(intent)
                            getPendingIntent(
                                0,
                                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                            )
                        }
                        pendingIntent.send()
                    }) {
                        Text(text = "Trigger deeplink")
                    }
                }
            }
        }
    }
}
