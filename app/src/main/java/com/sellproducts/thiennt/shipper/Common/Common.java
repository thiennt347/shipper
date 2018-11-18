package com.sellproducts.thiennt.shipper.Common;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.location.Location;
import android.support.annotation.NonNull;
import android.text.format.DateFormat;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.FirebaseDatabase;
import com.sellproducts.thiennt.shipper.model.Request;
import com.sellproducts.thiennt.shipper.model.Shipper;
import com.sellproducts.thiennt.shipper.model.ShippingInfomation;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Common {
    public static final int REQUEST_CODE = 1000 ;
    public  static Shipper currentShipper;
    public  static Request currentRequest;
    public  static String currentKey;
    public  static  String TABLE_ORDER_NEED_SHIP = "OrderNeedShipper";
    public  static  String TABLE_SHIPPER_ORDER = "ShipperOrder";


    public static String convertCodeToStatus(String code){
        if (code.equals("0"))
            return "Đã Đặt";
        else if (code.equals("1"))
            return "Trên đường Đến";
        else if (code.equals("2"))
            return "Đang Lấy hàng";
        else
            return "Đã Giao Hàng";
    }
    public  static String getDate(long time)
    {
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.setTimeInMillis(time);
        StringBuilder date = new StringBuilder(DateFormat.format("dd-MM-yyyy HH:mm", calendar).toString());
        return  date.toString();
    }

    public static void createShippingOder(String key, String phone, Location mLastLocation) {

        ShippingInfomation shippingInfomation  = new ShippingInfomation();

        shippingInfomation.setOrderId(key);
        shippingInfomation.setShipperPhone(phone);
        shippingInfomation.setLat(mLastLocation.getLatitude());
        shippingInfomation.setLng(mLastLocation.getLongitude());

        FirebaseDatabase.getInstance()
                .getReference(TABLE_SHIPPER_ORDER)
                .child(key)
                .setValue(shippingInfomation)
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("ERROR",e.getMessage());
                    }
                });

    }

    public static void updateInfomatinShipping(String currentKey, Location mLastLocation) {

        Map<String, Object> updateLocation = new HashMap<>();
        updateLocation.put("lat", mLastLocation.getLatitude());
        updateLocation.put("lng", mLastLocation.getLongitude());

        FirebaseDatabase.getInstance()
                .getReference(TABLE_SHIPPER_ORDER)
                .child(currentKey)
                .updateChildren(updateLocation)
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("ERROR",e.getMessage());
                    }
                });
    }



    public static Bitmap scaleBitmap (Bitmap bitmap, int newWidth, int newHeight) {
        Bitmap scaleBitmap = Bitmap.createBitmap(newWidth, newHeight, Bitmap.Config.ARGB_8888);

        float scaleX = newWidth/(float)bitmap.getWidth();
        float scaleY = newHeight/(float)bitmap.getHeight();
        float pivotX=0, pivotY=0;

        Matrix scaleMatrix = new Matrix();
        scaleMatrix.setScale(scaleX,scaleY,pivotX,pivotY);

        Canvas canvas = new Canvas(scaleBitmap);
        canvas.setMatrix(scaleMatrix);
        canvas.drawBitmap(bitmap,0,0,new Paint(Paint.FILTER_BITMAP_FLAG));

        return scaleBitmap;
    }

}
