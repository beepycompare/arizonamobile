package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
/* loaded from: classes5.dex */
public final class T6 extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final S6 f772a;

    public T6(Handler handler, S6 s6) {
        super(handler);
        this.f772a = s6;
    }

    public static void a(ResultReceiver resultReceiver, C0343j4 c0343j4) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            c0343j4.b(bundle);
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f772a.a(i, bundle);
    }

    public static void a(ResultReceiver resultReceiver, EnumC0413lm enumC0413lm, C0343j4 c0343j4) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("startup_error_key_code", enumC0413lm.f1084a);
            c0343j4.b(bundle);
            resultReceiver.send(2, bundle);
        }
    }
}
