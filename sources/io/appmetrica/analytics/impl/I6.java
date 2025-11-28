package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
/* loaded from: classes5.dex */
public final class I6 extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final H6 f521a;

    public I6(Handler handler, H6 h6) {
        super(handler);
        this.f521a = h6;
    }

    public static void a(ResultReceiver resultReceiver, C0106a4 c0106a4) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            c0106a4.b(bundle);
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f521a.a(i, bundle);
    }

    public static void a(ResultReceiver resultReceiver, Nl nl, C0106a4 c0106a4) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("startup_error_key_code", nl.f612a);
            c0106a4.b(bundle);
            resultReceiver.send(2, bundle);
        }
    }
}
