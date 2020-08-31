package br.com.gok.android.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.gok.android.R
import br.com.gok.android.di.MainModule
import br.com.gok.android.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    private val modules = listOf(MainModule.instance)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.argb(0, 0, 0, 0)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}