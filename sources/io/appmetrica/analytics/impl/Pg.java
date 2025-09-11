package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.adjust.sdk.Constants;
/* loaded from: classes4.dex */
public final class Pg extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final Bg f626a;

    public Pg(Handler handler, Bg bg) {
        super(handler);
        this.f626a = bg;
    }

    public static void a(ResultReceiver resultReceiver, Jg jg) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putByteArray(Constants.REFERRER, jg == null ? null : jg.a());
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            Jg jg = null;
            try {
                byte[] byteArray = bundle.getByteArray(Constants.REFERRER);
                if (byteArray != null && byteArray.length != 0) {
                    jg = new Jg(byteArray);
                }
            } catch (Throwable unused) {
            }
            this.f626a.a(jg);
        }
    }
}
