package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.adjust.sdk.Constants;
/* loaded from: classes5.dex */
public final class Mg extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final C0770zg f664a;

    public Mg(Handler handler, C0770zg c0770zg) {
        super(handler);
        this.f664a = c0770zg;
    }

    public static void a(ResultReceiver resultReceiver, Bg bg) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putByteArray(Constants.REFERRER, bg == null ? null : bg.a());
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            Bg bg = null;
            try {
                byte[] byteArray = bundle.getByteArray(Constants.REFERRER);
                if (byteArray != null && byteArray.length != 0) {
                    bg = new Bg(byteArray);
                }
            } catch (Throwable unused) {
            }
            this.f664a.a(bg);
        }
    }
}
