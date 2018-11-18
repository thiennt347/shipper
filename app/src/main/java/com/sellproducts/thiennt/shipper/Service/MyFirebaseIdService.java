package com.sellproducts.thiennt.shipper.Service;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.sellproducts.thiennt.shipper.Common.Common;
import com.sellproducts.thiennt.shipper.model.Token;

public class MyFirebaseIdService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String tokenfresh = FirebaseInstanceId.getInstance().getToken();
        /////////////////
        uptoken(tokenfresh);

    }

    private void uptoken(String tokenfresh) {
        if(Common.currentShipper != null) {

            FirebaseDatabase db = FirebaseDatabase.getInstance();
            DatabaseReference tokens = db.getReference("Tokens");
            Token token = new Token(tokenfresh, true); //fasle, vi token gui tu clien app
            tokens.child(Common.currentShipper.getPhone()).setValue(token);
        }
    }
}

