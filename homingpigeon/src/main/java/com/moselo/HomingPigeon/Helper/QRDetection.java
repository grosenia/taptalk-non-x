package com.moselo.HomingPigeon.Helper;

import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;

public class QRDetection implements Detector.Processor<Barcode> {
    @Override
    public void release() {

    }

    @Override
    public void receiveDetections(Detector.Detections<Barcode> detections) {

    }
}
