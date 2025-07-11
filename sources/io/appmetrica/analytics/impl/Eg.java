package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.adjust.sdk.Constants;
/* loaded from: classes4.dex */
public final class Eg extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0534qg f410a;

    public Eg(Handler handler, InterfaceC0534qg interfaceC0534qg) {
        super(handler);
        this.f410a = interfaceC0534qg;
    }

    public static void a(ResultReceiver resultReceiver, C0733yg c0733yg) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putByteArray(Constants.REFERRER, c0733yg == null ? null : c0733yg.a());
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            C0733yg c0733yg = null;
            try {
                byte[] byteArray = bundle.getByteArray(Constants.REFERRER);
                if (byteArray != null && byteArray.length != 0) {
                    c0733yg = new C0733yg(byteArray);
                }
            } catch (Throwable unused) {
            }
            this.f410a.a(c0733yg);
        }
    }
}
