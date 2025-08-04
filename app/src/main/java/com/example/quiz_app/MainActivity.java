package com.example.quiz_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.collection.BuildConfig;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);
        drawerLayout = findViewById(R.id.drawer);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Set navigation item listener
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                // Handle navigation view item clicks here
                int id = menuItem.getItemId();

                if (id == R.id.logout) {

                    logout();
                }else if (id == R.id.share) {

                    shareApp();
                }
                return true;
            }
        });
    }

    // Logout method
    private void logout() {
        // Add your logout logic here
        // For example, clear user session and navigate to login screen
        // Replace LoginActivity.class with your login activity
        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);
        finish(); // close current activity
        Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show();
    }
    private void shareApp() {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Check out this awesome app!";
        String shareSubject = "Quiz App";
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share using"));
    }

    // Handle back button press when navigation drawer is open
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(navigationView)) {
            drawerLayout.closeDrawer(navigationView);
        } else {
            super.onBackPressed();
        }
    }

    // Handle menu item selection
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.logout) {
            logout();
            return true;
        } else if (id == R.id.share) {
            shareApp();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void C(View view) {

        Intent intent = new Intent(MainActivity.this,questionActivity.class);
        startActivity(intent);
    }

    public void Cplus(View view) {
        Intent intent = new Intent(MainActivity.this,questionActivity2.class);
        startActivity(intent);

    }

    public void Python(View view) {
        Intent intent = new Intent(MainActivity.this,questionActivity3.class);
        startActivity(intent);
    }

    public void HTML(View view) {
        Intent intent = new Intent(MainActivity.this,questionActivity4.class);
        startActivity(intent);
    }

    public void Kotlin(View view) {
        Intent intent = new Intent(MainActivity.this,questionActivity5.class);
        startActivity(intent);
    }

    public void Csharp(View view) {
        Intent intent = new Intent(MainActivity.this,questionActivity6.class);
        startActivity(intent);
    }


}