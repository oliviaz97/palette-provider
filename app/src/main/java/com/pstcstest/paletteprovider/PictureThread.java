//package com.pstcstest.paletteprovider;
//// Code in this class referenced from https://www.youtube.com/watch?v=MyL4AUBbB2w&ab_channel=FilipVujovic
//import android.graphics.Bitmap;
//import android.graphics.Canvas;
//import android.graphics.ColorMatrix;
//import android.graphics.ColorMatrixColorFilter;
//import android.graphics.Paint;
//import android.os.Handler;
//import android.widget.ImageView;
//public class PictureThread extends Thread {
//    private ImageView imageView;
//    private Bitmap bitmap;
//    private Bitmap temp_bitmap;
//    private Canvas canvas;
//    private Paint paint;
//    private ColorMatrix colorMatrix;
//    private ColorMatrixColorFilter colorMatrixColorFilter;
//    private Handler handler;
//    private boolean running = false;
//    public PictureThread(ImageView imageView, Bitmap bitmap) {
//        this.imageView = imageView;
//        this.bitmap = bitmap;
//        temp_bitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
//        canvas = new Canvas(temp_bitmap);
//        paint = new Paint();
//        handler = new Handler();
//    }
//    public void adjustBrightness(int amount) {
//        colorMatrix = new ColorMatrix(new float[]{
//                1,0,0,0,amount,
//                0,1f,0,0,amount,
//                0,0,1f,0,amount,
//                0,0,0,1f,0
//        });
//        colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
//        paint.setColorFilter(colorMatrixColorFilter);
//        running = true;
//    }
//    @Override
//    public void run() {
//        while (true) {
//            if (running) {
//                canvas.drawBitmap(bitmap,0,0,paint);
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        imageView.setImageBitmap(temp_bitmap);
//                        running = false;
//                    }
//                });
//            }
//        }
//    }
//}
//

package com.pstcstest.paletteprovider;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Handler;
import android.widget.ImageView;
public class PictureThread extends Thread {
    private ImageView imageView;
    private Bitmap bitmap;
    private Bitmap temp_bitmap;
    private Canvas canvas;
    private Paint paint;
    private ColorMatrix colorMatrix;
    private ColorMatrixColorFilter colorMatrixColorFilter;
    private Handler handler;
    private boolean running = false;
    public PictureThread(ImageView imageView, Bitmap bitmap) {
        this.imageView = imageView;
        this.bitmap = bitmap;
        temp_bitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        canvas = new Canvas(temp_bitmap);
        paint = new Paint();
        handler = new Handler();
    }
    public void adjustBrightness(int amount) {
        colorMatrix = new ColorMatrix(new float[]{
                1,0,0,0,amount,
                0,1f,0,0,amount,
                0,0,1f,0,amount,
                0,0,0,1f,0
        });
        colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);
        running = true;
    }
    @Override
    public void run() {
        while (true) {
            if (running) {
                canvas.drawBitmap(bitmap,0,0,paint);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(temp_bitmap);
                        running = false;
                    }
                });
            }
        }
    }
}