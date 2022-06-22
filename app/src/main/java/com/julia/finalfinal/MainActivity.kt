package com.julia.finalfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.controls.templates.ToggleTemplate
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.annotation.NonNull
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    lateinit var drawerToggle : ActionBarDrawerToggle

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout);
        val navigationView = findViewById<NavigationView>(R.id.nav_view);
        drawerToggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();


        setCurrentFragment(Pessoal())

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home-> Toast.makeText(applicationContext,"Home",Toast.LENGTH_SHORT).show()
                R.id.pessoal-> {setCurrentFragment(Pessoal())}
                R.id.formacao-> {setCurrentFragment(Formacao())}
                R.id.profissional-> {setCurrentFragment(Profissional())}
                R.id.cursos-> {setCurrentFragment(Cursos())}
                R.id.publi-> {setCurrentFragment(Publicacoes())}
            }
            true
        }




    }

    private fun setCurrentFragment(fragment:Fragment){
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.container,fragment)
    transaction.addToBackStack(null)
    transaction.commit()
        }
}