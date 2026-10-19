package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.android.billingclient.api.BillingResult;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes3.dex */
final class zzdy extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null || !intent.hasExtra("RESPONSE_CODE")) {
            com.google.android.gms.internal.play_billing.zzc.zzo("ProxyBillingBroadcastReceiver", "Null intent or intent missing response code!");
            return;
        }
        BillingResult.Builder newBuilder = BillingResult.newBuilder();
        newBuilder.setResponseCode(intent.getIntExtra("RESPONSE_CODE", 0));
        newBuilder.setDebugMessage(com.google.android.gms.internal.play_billing.zzbm.zzc(intent.getStringExtra("DEBUG_MESSAGE")));
        newBuilder.build();
    }
}
