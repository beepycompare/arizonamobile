package com.wardrumstudios.utils;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.billing.IabHelper;
import com.google.android.billing.IabResult;
import com.google.android.billing.Inventory;
import com.google.android.billing.Purchase;
import com.google.android.billing.SkuDetails;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class WarBilling extends WarBase {
    private static final int OS_Cached = 4;
    private static final int OS_Cancelled = 2;
    private static final int OS_Error = 5;
    private static final int OS_Purchased = 0;
    private static final int OS_Refunded = 3;
    private static final int OS_Restored = 1;
    private static final int REQUEST_CODE = 10002;
    private static final String TAG = "OSWrapper";
    private static final boolean billLogging = false;
    private IabHelper mHelper;
    private ArrayList<SkuEntry> skus;
    private String mBillingKey = "UNUSED";
    private int mPurchasingIndex = -1;
    IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new IabHelper.QueryInventoryFinishedListener() { // from class: com.wardrumstudios.utils.WarBilling.2
        @Override // com.google.android.billing.IabHelper.QueryInventoryFinishedListener
        public void onQueryInventoryFinished(IabResult iabResult, Inventory inventory) {
            WarBilling.this.OutputLog("Query inventory finished.");
            if (iabResult.isFailure()) {
                WarBilling.this.complain("Failed to query inventory: " + iabResult);
                if (!iabResult.toString().contains("prices")) {
                    WarBilling.this.changeConnection(false);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < WarBilling.this.skus.size(); i++) {
                    WarBilling.this.OutputLog("Checking sku without price " + ((SkuEntry) WarBilling.this.skus.get(i)).id);
                    arrayList.add(((SkuEntry) WarBilling.this.skus.get(i)).id);
                }
                WarBilling.this.mHelper.queryInventoryAsync(false, arrayList, this);
                return;
            }
            WarBilling.this.OutputLog("Query successful. Inventory: " + inventory);
            boolean z = false;
            for (int i2 = 0; i2 < WarBilling.this.skus.size(); i2++) {
                boolean hasPurchase = inventory.hasPurchase(((SkuEntry) WarBilling.this.skus.get(i2)).id);
                SkuDetails skuDetails = inventory.getSkuDetails(((SkuEntry) WarBilling.this.skus.get(i2)).id);
                if (skuDetails != null) {
                    WarBilling.this.OutputLog("SKU '" + ((SkuEntry) WarBilling.this.skus.get(i2)).id + "' : '" + skuDetails.getType() + "' '" + skuDetails.getPrice() + "' '" + skuDetails.getTitle() + "' " + hasPurchase);
                    ((SkuEntry) WarBilling.this.skus.get(i2)).priceFormat = skuDetails.getPrice();
                    ((SkuEntry) WarBilling.this.skus.get(i2)).cachedDetails = skuDetails;
                    z = true;
                } else {
                    WarBilling.this.OutputLog("SKU '" + ((SkuEntry) WarBilling.this.skus.get(i2)).id + "' : no details : " + hasPurchase);
                    ((SkuEntry) WarBilling.this.skus.get(i2)).priceFormat = "";
                }
                if (hasPurchase) {
                    ((SkuEntry) WarBilling.this.skus.get(i2)).purchased = true;
                    WarBilling warBilling = WarBilling.this;
                    warBilling.notifyChange(((SkuEntry) warBilling.skus.get(i2)).id, 4);
                }
            }
            WarBilling warBilling2 = WarBilling.this;
            if (z) {
                warBilling2.changeConnection(true);
            } else {
                warBilling2.changeConnection(false);
            }
        }
    };
    IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() { // from class: com.wardrumstudios.utils.WarBilling.3
        @Override // com.google.android.billing.IabHelper.OnIabPurchaseFinishedListener
        public void onIabPurchaseFinished(IabResult iabResult, Purchase purchase) {
            WarBilling.this.OutputLog("Purchase finished: " + iabResult + ", purchase: " + purchase);
            int i = WarBilling.this.mPurchasingIndex;
            if (purchase != null && ((i = WarBilling.this.GetSKU(purchase.getSku())) < 0 || i >= WarBilling.this.skus.size())) {
                Log.d(WarBilling.TAG, "Error skuIndex " + i + " out of range");
                return;
            }
            int response = iabResult.getResponse();
            if (response != -1006) {
                if (response != -1005) {
                    if (response == 0) {
                        WarBilling.this.OutputLog("Purchase successful.");
                        if (i != -1) {
                            ((SkuEntry) WarBilling.this.skus.get(i)).purchased = true;
                            WarBilling warBilling = WarBilling.this;
                            warBilling.notifyChange(((SkuEntry) warBilling.skus.get(i)).id, 0);
                            WarBilling warBilling2 = WarBilling.this;
                            warBilling2.purchaseEvent(((SkuEntry) warBilling2.skus.get(i)).cachedDetails, purchase);
                            return;
                        }
                        return;
                    } else if (response != 1) {
                        switch (response) {
                            case 3:
                                WarBilling.this.OutputLog("Billing not available.");
                                if (i != -1) {
                                    WarBilling warBilling3 = WarBilling.this;
                                    warBilling3.notifyChange(((SkuEntry) warBilling3.skus.get(i)).id, 5);
                                    return;
                                }
                                return;
                            case 4:
                                WarBilling.this.OutputLog("Item not available.");
                                if (i != -1) {
                                    WarBilling warBilling4 = WarBilling.this;
                                    warBilling4.notifyChange(((SkuEntry) warBilling4.skus.get(i)).id, 5);
                                    return;
                                }
                                return;
                            case 5:
                                break;
                            case 6:
                                WarBilling.this.OutputLog("IAP Error.");
                                if (i != -1) {
                                    WarBilling warBilling5 = WarBilling.this;
                                    warBilling5.notifyChange(((SkuEntry) warBilling5.skus.get(i)).id, 5);
                                    return;
                                }
                                return;
                            case 7:
                                WarBilling.this.OutputLog("Already owned.");
                                if (i != -1) {
                                    ((SkuEntry) WarBilling.this.skus.get(i)).purchased = true;
                                    WarBilling warBilling6 = WarBilling.this;
                                    warBilling6.notifyChange(((SkuEntry) warBilling6.skus.get(i)).id, 2);
                                    return;
                                }
                                return;
                            case 8:
                                WarBilling.this.OutputLog("Not wtf.");
                                if (i != -1) {
                                    ((SkuEntry) WarBilling.this.skus.get(i)).purchased = false;
                                    WarBilling warBilling7 = WarBilling.this;
                                    warBilling7.notifyChange(((SkuEntry) warBilling7.skus.get(i)).id, 2);
                                    return;
                                }
                                return;
                            default:
                                WarBilling.this.OutputLog("Unknown response");
                                if (i != -1) {
                                    try {
                                        ((SkuEntry) WarBilling.this.skus.get(i)).purchased = false;
                                        WarBilling.this.notifyChange(purchase.getSku(), 5);
                                        return;
                                    } catch (Exception unused) {
                                        WarBilling.this.OutputLog("Unknown response Error " + iabResult.getResponse());
                                        return;
                                    }
                                }
                                return;
                        }
                    }
                }
                WarBilling.this.OutputLog("Purchase cancelled.");
                if (i != -1) {
                    ((SkuEntry) WarBilling.this.skus.get(i)).purchased = false;
                    WarBilling warBilling8 = WarBilling.this;
                    warBilling8.notifyChange(((SkuEntry) warBilling8.skus.get(i)).id, 2);
                    return;
                }
                return;
            }
            WarBilling.this.OutputLog("Dev error.");
            if (i != -1) {
                WarBilling warBilling9 = WarBilling.this;
                warBilling9.notifyChange(((SkuEntry) warBilling9.skus.get(i)).id, 5);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class SkuEntry {
        SkuDetails cachedDetails;
        String id;
        String priceFormat;
        boolean purchased;

        private SkuEntry() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int GetSKU(String str) {
        for (int i = 0; i < this.skus.size(); i++) {
            if (this.skus.get(i).id.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OutputLog(String str) {
    }

    public void AddSKU(String str) {
        SkuEntry skuEntry = new SkuEntry();
        skuEntry.id = str;
        skuEntry.purchased = false;
        this.skus.add(skuEntry);
    }

    public boolean InitBilling() {
        String billingKey = getBillingKey();
        changeConnection(false);
        if (billingKey.contains("UNUSED")) {
            OutputLog("No key provided by app.");
            complain("No key provided by app.********************************************");
            changeConnection(false);
            return false;
        }
        OutputLog("Creating IAB helper");
        IabHelper iabHelper = new IabHelper(this, billingKey);
        this.mHelper = iabHelper;
        iabHelper.enableDebugLogging(false, TAG);
        OutputLog("Starting setup.");
        this.mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() { // from class: com.wardrumstudios.utils.WarBilling.1
            @Override // com.google.android.billing.IabHelper.OnIabSetupFinishedListener
            public void onIabSetupFinished(IabResult iabResult) {
                WarBilling.this.OutputLog("Setup finished.");
                if (!iabResult.isSuccess()) {
                    WarBilling.this.complain("Problem setting up in-app billing: " + iabResult);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < WarBilling.this.skus.size(); i++) {
                    WarBilling.this.OutputLog("Checking sku " + ((SkuEntry) WarBilling.this.skus.get(i)).id);
                    arrayList.add(((SkuEntry) WarBilling.this.skus.get(i)).id);
                }
                WarBilling.this.OutputLog("Setup successful. Querying inventory.");
                try {
                    WarBilling.this.mHelper.queryInventoryAsync(true, arrayList, WarBilling.this.mGotInventoryListener);
                } catch (IllegalStateException e) {
                    WarBilling.this.OutputLog("inventory error " + e.getMessage());
                }
            }
        });
        return true;
    }

    public String LocalizedPrice(String str) {
        int GetSKU = GetSKU(str);
        return GetSKU != -1 ? this.skus.get(GetSKU).priceFormat : "";
    }

    public boolean RequestPurchase(String str) {
        int GetSKU = GetSKU(str);
        this.mPurchasingIndex = GetSKU;
        if (GetSKU == -1 || this.skus.get(GetSKU).purchased) {
            OutputLog("Not requesting purchase " + str + " " + GetSKU);
            return false;
        }
        OutputLog("Requesting purchase " + str + " " + GetSKU + " " + this.skus.get(GetSKU).purchased);
        this.delayInputForStore = true;
        this.mHelper.launchPurchaseFlow(this, str, REQUEST_CODE, this.mPurchaseFinishedListener);
        return true;
    }

    public void SetBillingKey(String str) {
        this.mBillingKey = str;
    }

    void alert(String str) {
        Log.d(TAG, str);
    }

    public native void changeConnection(boolean z);

    void complain(String str) {
        Log.e(TAG, "Billing Error: " + str);
        alert("Error: " + str);
    }

    protected String getBillingKey() {
        return this.mBillingKey;
    }

    public native void notifyChange(String str, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.wardrumstudios.utils.WarBase, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        OutputLog("onActivityResult(" + i + StringUtils.COMMA + i2 + StringUtils.COMMA + intent);
        IabHelper iabHelper = this.mHelper;
        if (iabHelper == null || !iabHelper.handleActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        } else {
            OutputLog("onActivityResult handled by IABUtil.");
        }
    }

    @Override // com.wardrumstudios.utils.WarBase, com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.skus = new ArrayList<>();
    }

    @Override // com.wardrumstudios.utils.WarBase, com.nvidia.devtech.NvEventQueueActivity, android.app.Activity
    public void onDestroy() {
        IabHelper iabHelper = this.mHelper;
        if (iabHelper != null) {
            iabHelper.dispose();
            this.mHelper = null;
        }
        super.onDestroy();
    }

    protected void purchaseEvent(SkuDetails skuDetails, Purchase purchase) {
    }
}
