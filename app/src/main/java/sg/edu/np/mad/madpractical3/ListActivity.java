package sg.edu.np.mad.madpractical3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import java.util.Random;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);

        ImageView imgAlert = findViewById(R.id.imageButton);

        imgAlert.setOnClickListener(v -> {
            showAlertDialog();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");

        builder.setNegativeButton("Close", (dialog, which) -> {
            dialog.dismiss();
        });

        // Add "View" button
        builder.setPositiveButton("View", (dialog, which) -> {
            int randomInteger = new Random().nextInt(1000000);

            // Launch MainActivity and pass the random integer
            Intent intent = new Intent(ListActivity.this, MainActivity.class);
            intent.putExtra("randomInteger", randomInteger);
            startActivity(intent);
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}