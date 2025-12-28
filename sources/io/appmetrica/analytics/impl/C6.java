package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
/* loaded from: classes5.dex */
public final class C6 extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final B6 f522a;

    public C6(Handler handler, B6 b6) {
        super(handler);
        this.f522a = b6;
    }

    public static void a(ResultReceiver resultReceiver, T3 t3) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            t3.b(bundle);
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f522a.a(i, bundle);
    }

    public static void a(ResultReceiver resultReceiver, Kl kl, T3 t3) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("startup_error_key_code", kl.f657a);
            t3.b(bundle);
            resultReceiver.send(2, bundle);
        }
    }
}
