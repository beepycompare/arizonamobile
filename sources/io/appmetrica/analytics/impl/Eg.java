package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.adjust.sdk.Constants;
/* loaded from: classes4.dex */
public final class Eg extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0542qg f409a;

    public Eg(Handler handler, InterfaceC0542qg interfaceC0542qg) {
        super(handler);
        this.f409a = interfaceC0542qg;
    }

    public static void a(ResultReceiver resultReceiver, C0741yg c0741yg) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putByteArray(Constants.REFERRER, c0741yg == null ? null : c0741yg.a());
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            C0741yg c0741yg = null;
            try {
                byte[] byteArray = bundle.getByteArray(Constants.REFERRER);
                if (byteArray != null && byteArray.length != 0) {
                    c0741yg = new C0741yg(byteArray);
                }
            } catch (Throwable unused) {
            }
            this.f409a.a(c0741yg);
        }
    }
}
