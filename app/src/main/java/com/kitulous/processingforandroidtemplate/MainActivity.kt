package com.kitulous.processingforandroidtemplate

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import processing.android.CompatUtils
import processing.android.PFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val frame = FrameLayout(this)
        frame.id = CompatUtils.getUniqueViewId()
        setContentView(
            frame, ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )

        val fragment = PFragment(App)
        fragment.setView(frame, this)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        App.onRequestPermissionsResult(
            requestCode, permissions, grantResults
        )
    }

    public override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        App.onNewIntent(intent)
    }
}