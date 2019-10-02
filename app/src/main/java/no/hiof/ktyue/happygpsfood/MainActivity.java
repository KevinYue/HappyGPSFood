package no.hiof.ktyue.happygpsfood;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  {

    private NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupBottomNavigationMenu();

    }

    private void setupBottomNavigationMenu() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        navController = Navigation.findNavController(this, R.id.navHostFragment);

        NavigationUI.setupActionBarWithNavController(this, navController);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home_destination:
                        navController.navigate(R.id.homeFragment);
                        break;
                    case R.id.nearby_destination:
                        navController.navigate(R.id.nearbyRestaurantFragment);
                        break;
                    case R.id.add_destination:
                        navController.navigate(R.id.add_destination);
                        break;
                    case R.id.favorites_destination:
                        navController.navigate(R.id.favoritesFragment);
                        break;
                    case R.id.search_destination:
                        navController.navigate(R.id.searchFragment);
                        break;
                }
                return false;
            }
        });
    }
}
