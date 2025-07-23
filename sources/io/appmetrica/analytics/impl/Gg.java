package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.adjust.sdk.Constants;
/* loaded from: classes4.dex */
public final class Gg extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0585sg f455a;

    public Gg(Handler handler, InterfaceC0585sg interfaceC0585sg) {
        super(handler);
        this.f455a = interfaceC0585sg;
    }

    public static void a(ResultReceiver resultReceiver, Ag ag) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putByteArray(Constants.REFERRER, ag == null ? null : ag.a());
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            Ag ag = null;
            try {
                byte[] byteArray = bundle.getByteArray(Constants.REFERRER);
                if (byteArray != null && byteArray.length != 0) {
                    ag = new Ag(byteArray);
                }
            } catch (Throwable unused) {
            }
            this.f455a.a(ag);
        }
    }
}
