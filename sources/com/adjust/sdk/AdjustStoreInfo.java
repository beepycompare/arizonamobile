package com.adjust.sdk;
/* loaded from: classes3.dex */
public class AdjustStoreInfo {
    private static final ILogger logger = AdjustFactory.getLogger();
    String storeAppId;
    String storeName;

    public AdjustStoreInfo(String str) {
        if (isValidStore(str)) {
            this.storeName = str;
        }
    }

    private boolean isValidStore(String str) {
        if (str == null) {
            logger.error("Missing store name", new Object[0]);
            return false;
        } else if (str.isEmpty()) {
            logger.error("Store name can't be empty", new Object[0]);
            return false;
        } else {
            return true;
        }
    }

    public void setStoreAppId(String str) {
        this.storeAppId = str;
    }
}
