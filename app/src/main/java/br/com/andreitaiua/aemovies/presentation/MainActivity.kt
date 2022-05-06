package br.com.andreitaiua.aemovies.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import br.com.andreitaiua.aemovies.R
import br.com.andreitaiua.aemovies.presentation.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            showFragment(MainFragment.newInstance())
        }
    }

    fun showFragment(fragment: Fragment) {
        val backStackName = "backStackName"
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(backStackName)
            .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.fragments.size <= 1) {
            finish()
        }
    }

}
