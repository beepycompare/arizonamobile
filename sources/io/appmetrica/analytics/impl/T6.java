package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
/* loaded from: classes4.dex */
public final class T6 extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final S6 f635a;

    public T6(Handler handler, S6 s6) {
        super(handler);
        this.f635a = s6;
    }

    public static void a(ResultReceiver resultReceiver, C0480o4 c0480o4) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            c0480o4.b(bundle);
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f635a.a(i, bundle);
    }

    public static void a(ResultReceiver resultReceiver, Gl gl, C0480o4 c0480o4) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("startup_error_key_code", gl.f448a);
            c0480o4.b(bundle);
            resultReceiver.send(2, bundle);
        }
    }
}
