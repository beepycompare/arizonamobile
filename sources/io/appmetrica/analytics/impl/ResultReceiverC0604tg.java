package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.adjust.sdk.Constants;
/* renamed from: io.appmetrica.analytics.impl.tg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class ResultReceiverC0604tg extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0251fg f1239a;

    public ResultReceiverC0604tg(Handler handler, InterfaceC0251fg interfaceC0251fg) {
        super(handler);
        this.f1239a = interfaceC0251fg;
    }

    public static void a(ResultReceiver resultReceiver, C0455ng c0455ng) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putByteArray(Constants.REFERRER, c0455ng == null ? null : c0455ng.a());
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            C0455ng c0455ng = null;
            try {
                byte[] byteArray = bundle.getByteArray(Constants.REFERRER);
                if (byteArray != null && byteArray.length != 0) {
                    c0455ng = new C0455ng(byteArray);
                }
            } catch (Throwable unused) {
            }
            this.f1239a.a(c0455ng);
        }
    }
}
