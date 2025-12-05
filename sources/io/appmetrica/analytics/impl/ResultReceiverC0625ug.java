package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.adjust.sdk.Constants;
/* renamed from: io.appmetrica.analytics.impl.ug  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class ResultReceiverC0625ug extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0272gg f1234a;

    public ResultReceiverC0625ug(Handler handler, InterfaceC0272gg interfaceC0272gg) {
        super(handler);
        this.f1234a = interfaceC0272gg;
    }

    public static void a(ResultReceiver resultReceiver, C0476og c0476og) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putByteArray(Constants.REFERRER, c0476og == null ? null : c0476og.a());
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            C0476og c0476og = null;
            try {
                byte[] byteArray = bundle.getByteArray(Constants.REFERRER);
                if (byteArray != null && byteArray.length != 0) {
                    c0476og = new C0476og(byteArray);
                }
            } catch (Throwable unused) {
            }
            this.f1234a.a(c0476og);
        }
    }
}
