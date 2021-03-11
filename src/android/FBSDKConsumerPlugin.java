package com.contactpigeon.fbsdkconsumerplugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import com.contactpigeon.fbsdkconsumerplugin.CPConnectionService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import android.widget.Toast;

/**
 * This class echoes a string called from JavaScript.
 */
public class FBSDKConsumerPlugin extends CordovaPlugin {
    
    CPConnectionService gregorysConnector;
    String gregorysCPToken = "f5f49293fb634246b546ffc80d09cdc0";
    String gregorysCPGroupName = "Cp test";
    String gregorysCPName = "moirizw";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("initialize")) {
            String token = args.getString(0);
            gregorysConnector = new CPConnectionService(this.cordova.getActivity());
            cordova.getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        gregorysConnector.initWithOptions(gregorysCPToken, gregorysCPGroupName, gregorysCPName, "", "");
                        gregorysConnector.askforregistration(token); // Thread-safe.
                    }
            });
            return true;
        } else if (action.equals("doPostToken")) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        gregorysConnector.resetcurSessionFCMTokenPosted("no");
                        gregorysConnector.postFCMTokenToCP(CPMainParameters.getInstance().fcmToken);
                    }
            });
            return true;
        } else if (action.equals("pageView")) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        String utmdt = "my simple Page View";
                        String utmp = "/myandroidapp/category/subcategory/mypage/";
                        gregorysConnector.pageView(utmdt, utmp);
                    }
            });
            return true;
        } else if (action.equals("productView")) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        String pName = "το προϊον μου";
                        String pSku = "12345-abcd";
                        String utmp = "/myandroidapp/myprodpage/";
                        gregorysConnector.productView(pName, pSku, utmp);
                    }
            });
            return true;
        } else if (action.equals("add2Cart")) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        String pName = "το προϊον μου";
                        String pSku = "12345-abcd";
                        int pQty = 6;
                        double pUnitPrice = 12.36;
                        String utmp = "/myandroidapp/myprodpage/";
                        String pimg = "";
                        gregorysConnector.add2cart(pName, pSku, pQty, pUnitPrice, pimg, utmp);
                    }
            });
            return true;
        } else if (action.equals("removeFromCart")) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        String pName = "το προϊον μου";
                        String pSku = "12345-abcd";
                        int pQty = 2;
                        double pUnitPrice = 12.36;
                        String utmp = "/myandroidapp/myprodpage/";
                        String pimg = "";
                        gregorysConnector.removefromcart(pName, pSku, pQty, pUnitPrice, pimg, utmp);
                    }
            });
            return true;
        } else if (action.equals("placeOrder")) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        String utmp = "";
                        gregorysConnector.setOrderData("oid-0008", 36.36);
                        gregorysConnector.addOrderItem("81", "Four Punch Man T-Shirt", 2, 149);
                        gregorysConnector.addOrderItem("49", "Sassy, loose fit dual tone dress", 5, 190);
                        gregorysConnector.postOrder(utmp);
                    }
            });
            return true;
        } else if (action.equals("postCart")) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        gregorysConnector.postCart();
                    }
            });
            return true;
        } else if (action.equals("postContactEmail")) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        String cp_curEmail = "test@test.gr";
                        String utmp = "/myandroidapp/category/subcategory/mypage/";
                        gregorysConnector.setContactMail(cp_curEmail,utmp);
                    }
            });
            return true;
        }
        return false;
    }

//    private void coolMethod(String message, CallbackContext callbackContext) {
//        if (message != null && message.length() > 0) {
//            callbackContext.success(message);
//        } else {
//            callbackContext.error("Expected one non-empty string argument.");
//        }
//    }
}
