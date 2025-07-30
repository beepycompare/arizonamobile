package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
/* loaded from: classes4.dex */
public final class W6 extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final V6 f697a;

    public W6(Handler handler, V6 v6) {
        super(handler);
        this.f697a = v6;
    }

    public static void a(ResultReceiver resultReceiver, C0474o4 c0474o4) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            c0474o4.b(bundle);
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.f697a.a(i, bundle);
    }

    public static void a(ResultReceiver resultReceiver, Jl jl, C0474o4 c0474o4) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("startup_error_key_code", jl.f511a);
            c0474o4.b(bundle);
            resultReceiver.send(2, bundle);
        }
    }
}
