package com.shamsaha.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImageUtils {

    public static Bitmap resizeImage(String imagePath, int newWidth, int newHeight) {
        // Load the original image using BitmapFactory
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imagePath, options);

        // Calculate the sample size based on the desired width and height
        int sampleSize = calculateSampleSize(options, newWidth, newHeight);

        // Set the sample size and decode the image
        options.inJustDecodeBounds = false;
        options.inSampleSize = sampleSize;
        Bitmap scaledBitmap = BitmapFactory.decodeFile(imagePath, options);

        // Resize the bitmap to the desired width and height
        return Bitmap.createScaledBitmap(scaledBitmap, newWidth, newHeight, false);
    }

    private static int calculateSampleSize(BitmapFactory.Options options, int newWidth, int newHeight) {
        int originalWidth = options.outWidth;
        int originalHeight = options.outHeight;
        int sampleSize = 1;

        if (originalHeight > newHeight || originalWidth > newWidth) {
            int halfHeight = originalHeight / 2;
            int halfWidth = originalWidth / 2;

            // Calculate the largest sample size that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / sampleSize) >= newHeight && (halfWidth / sampleSize) >= newWidth) {
                sampleSize *= 2;
            }
        }

        return sampleSize;
    }
}
