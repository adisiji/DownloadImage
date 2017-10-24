package scode.nb.downimage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
         * Example Download image from demo URL
         */
        String demoUrl = "http://119.235.208.234:5000/uploads/2877bf0b-a90e-44b5-9d5b-dbd5b1458c7e.png";

        // Download with default name
        DownloadImage downloadImage = new DownloadImage(this, demoUrl);
        downloadImage.startDownload();

        // Download with custom name
        DownloadImage downloadImage1 = new DownloadImage(this, demoUrl, "tesaja");
        downloadImage1.startDownload();
    }
}
