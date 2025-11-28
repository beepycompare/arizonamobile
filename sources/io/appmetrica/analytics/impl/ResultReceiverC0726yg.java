package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.adjust.sdk.Constants;
/* renamed from: io.appmetrica.analytics.impl.yg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class ResultReceiverC0726yg extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0376kg f1216a;

    public ResultReceiverC0726yg(Handler handler, InterfaceC0376kg interfaceC0376kg) {
        super(handler);
        this.f1216a = interfaceC0376kg;
    }

    public static void a(ResultReceiver resultReceiver, C0576sg c0576sg) {
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putByteArray(Constants.REFERRER, c0576sg == null ? null : c0576sg.a());
            resultReceiver.send(1, bundle);
        }
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            C0576sg c0576sg = null;
            try {
                byte[] byteArray = bundle.getByteArray(Constants.REFERRER);
                if (byteArray != null && byteArray.length != 0) {
                    c0576sg = new C0576sg(byteArray);
                }
            } catch (Throwable unused) {
            }
            this.f1216a.a(c0576sg);
        }
    }
}
