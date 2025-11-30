package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.adjust.sdk.Constants;
/* renamed from: io.appmetrica.analytics.impl.ug  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class ResultReceiverC0626ug extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0273gg f1151a;

    public ResultReceiverC0626ug(Handler handler, InterfaceC0273gg interfaceC0273gg) {
        super(handler);
        this.f1151a = interfaceC0273gg;
    }

    public static void a(ResultReceiver resultReceiver, C0477og c0477og) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putByteArray(Constants.REFERRER, c0477og == null ? null : c0477og.a());
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            C0477og c0477og = null;
            try {
                byte[] byteArray = bundle.getByteArray(Constants.REFERRER);
                if (byteArray != null && byteArray.length != 0) {
                    c0477og = new C0477og(byteArray);
                }
            } catch (Throwable unused) {
            }
            this.f1151a.a(c0477og);
        }
    }
}
