package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
/* renamed from: io.appmetrica.analytics.impl.a7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ResultReceiverC0116a7 extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final Z6 f788a;

    public ResultReceiverC0116a7(Handler handler, Z6 z6) {
        super(handler);
        this.f788a = z6;
    }

    public static void a(ResultReceiver resultReceiver, C0550r4 c0550r4) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            c0550r4.b(bundle);
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f788a.a(i, bundle);
    }

    public static void a(ResultReceiver resultReceiver, Sl sl, C0550r4 c0550r4) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("startup_error_key_code", sl.f675a);
            c0550r4.b(bundle);
            resultReceiver.send(2, bundle);
        }
    }
}
