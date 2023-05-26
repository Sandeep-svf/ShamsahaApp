package com.shamsaha.util;

import android.content.Context;
import android.provider.Settings;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DeviceUtils {
    public static String getUniqueDeviceId(Context context) {
        // Get the Android ID
        String androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);

        // Get the device manufacturer and model
        String manufacturer = android.os.Build.MANUFACTURER;
        String model = android.os.Build.MODEL;

        // Concatenate the identifiers
        String combinedId = androidId + manufacturer + model;

        // Generate a SHA-1 hash of the combined identifiers
        String uniqueId = generateSHA1(combinedId);

        return uniqueId;
    }

    private static String generateSHA1(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            byte[] byteData = digest.digest(input.getBytes("UTF-8"));

            // Convert the byte array to a hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (byte b : byteData) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
