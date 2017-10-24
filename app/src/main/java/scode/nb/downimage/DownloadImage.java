package scode.nb.downimage;

import android.content.Context;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.DownloadListener;
import com.androidnetworking.interfaces.DownloadProgressListener;

/**
 * Created by neobyte on 24/10/17.
 */

public class DownloadImage {

    private final String TAG = DownloadImage.class.getName();
    private String url;
    private String fileName;
    private Context context;

    /**
     * Download Image with custom name
     * @param context Activity where this method called
     * @param url Image Url
     * @param filename name of the file, WITHOUT extension, it will be added from url
     */
    public DownloadImage(Context context, String url, String filename) {
        this.url = url;
        this.fileName = filename + url.substring(url.lastIndexOf("."));
        this.context = context;
    }

    /**
     * Download Image with default name
     * @param context Activity where this method called
     * @param url Image Url
     */
    public DownloadImage(Context context, String url) {
        this.url = url;
        this.context = context;
        this.fileName = url.substring(url.lastIndexOf('/') + 1).split("\\?")[0].split("#")[0];
    }

    public void startDownload() {
        AndroidNetworking.download(url, context.getCacheDir().getPath(), fileName)
                .setTag("downloadImage")
                .setPriority(Priority.MEDIUM)
                .build()
                .setDownloadProgressListener(new DownloadProgressListener() {
                    @Override
                    public void onProgress(long bytesDownloaded, long totalBytes) {
                        Log.d(TAG, "Downloaded = " + String.valueOf(bytesDownloaded)
                                + "/" + String.valueOf(totalBytes));
                    }
                })
                .startDownload(new DownloadListener() {
                    @Override
                    public void onDownloadComplete() {
                        Log.d(TAG, fileName + " has been downloaded");
                    }
                    @Override
                    public void onError(ANError error) {
                        Log.e(TAG, "Cannot download " + fileName);
                    }
                });
    }

}
