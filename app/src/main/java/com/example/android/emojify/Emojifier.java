package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by su on 2018/8/21.
 */

public class Emojifier {
    private static final String TAG = "Emojifier";
    public static void detectFaces(Context context, Bitmap bitmap){
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        //build the frame
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        //detect the faces
        SparseArray<Face> faces = detector.detect(frame);

        //log the number of faces
        Log.e(TAG, "detectFaces: number of faces = "+faces.size() );

        if(faces.size() == 0){
            Toast.makeText(context, R.string.no_face, Toast.LENGTH_SHORT).show();
        }

        //release the detector
        detector.release();

    }

}
