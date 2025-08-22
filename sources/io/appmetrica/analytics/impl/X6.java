package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
/* loaded from: classes4.dex */
public final class X6 extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final W6 f721a;

    public X6(Handler handler, W6 w6) {
        super(handler);
        this.f721a = w6;
    }

    public static void a(ResultReceiver resultReceiver, C0472o4 c0472o4) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            c0472o4.b(bundle);
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f721a.a(i, bundle);
    }

    public static void a(ResultReceiver resultReceiver, Ol ol, C0472o4 c0472o4) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("startup_error_key_code", ol.f593a);
            c0472o4.b(bundle);
            resultReceiver.send(2, bundle);
        }
    }
}
