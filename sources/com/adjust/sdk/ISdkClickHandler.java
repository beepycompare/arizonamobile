package com.adjust.sdk;

import com.adjust.sdk.network.IActivityPackageSender;
/* loaded from: classes3.dex */
public interface ISdkClickHandler {
    void init(IActivityHandler iActivityHandler, boolean z, IActivityPackageSender iActivityPackageSender);

    void pauseSending();

    void resumeSending();

    void sendPreinstallPayload(String str, String str2);

    void sendReftagReferrers();

    void sendSdkClick(ActivityPackage activityPackage);

    void teardown();
}
