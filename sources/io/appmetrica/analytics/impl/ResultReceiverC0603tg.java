package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.adjust.sdk.Constants;
/* renamed from: io.appmetrica.analytics.impl.tg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class ResultReceiverC0603tg extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0250fg f1243a;

    public ResultReceiverC0603tg(Handler handler, InterfaceC0250fg interfaceC0250fg) {
        super(handler);
        this.f1243a = interfaceC0250fg;
    }

    public static void a(ResultReceiver resultReceiver, C0454ng c0454ng) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putByteArray(Constants.REFERRER, c0454ng == null ? null : c0454ng.a());
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            C0454ng c0454ng = null;
            try {
                byte[] byteArray = bundle.getByteArray(Constants.REFERRER);
                if (byteArray != null && byteArray.length != 0) {
                    c0454ng = new C0454ng(byteArray);
                }
            } catch (Throwable unused) {
            }
            this.f1243a.a(c0454ng);
        }
    }
}
