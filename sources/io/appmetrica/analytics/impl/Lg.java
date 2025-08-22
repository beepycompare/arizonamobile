package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.adjust.sdk.Constants;
/* loaded from: classes4.dex */
public final class Lg extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0708xg f545a;

    public Lg(Handler handler, InterfaceC0708xg interfaceC0708xg) {
        super(handler);
        this.f545a = interfaceC0708xg;
    }

    public static void a(ResultReceiver resultReceiver, Fg fg) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putByteArray(Constants.REFERRER, fg == null ? null : fg.a());
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            Fg fg = null;
            try {
                byte[] byteArray = bundle.getByteArray(Constants.REFERRER);
                if (byteArray != null && byteArray.length != 0) {
                    fg = new Fg(byteArray);
                }
            } catch (Throwable unused) {
            }
            this.f545a.a(fg);
        }
    }
}
