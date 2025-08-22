package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
/* loaded from: classes4.dex */
public final class Pm extends Wm {
    @Override // io.appmetrica.analytics.impl.Wm
    public final ProtobufStateStorage a(Context context, IBinaryDataHelper iBinaryDataHelper) {
        byte[] bArr;
        byte[] bArr2;
        Dm dm = new Dm();
        try {
            bArr = AbstractC0736yj.a(context.getPackageName());
        } catch (Throwable unused) {
            bArr = new byte[16];
        }
        try {
            bArr2 = AbstractC0736yj.a(new StringBuilder(context.getPackageName()).reverse().toString());
        } catch (Throwable unused2) {
            bArr2 = new byte[16];
        }
        return new C0228eg("startup_state", iBinaryDataHelper, new V8(dm, new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, bArr, bArr2)), new C0415lm());
    }

    @Override // io.appmetrica.analytics.impl.Wm
    public final IBinaryDataHelper c(Context context) {
        C0496p3 c0496p3;
        C0649v7 a2 = C0649v7.a(context);
        synchronized (a2) {
            if (a2.i == null) {
                a2.i = new C0496p3(a2.g());
            }
            c0496p3 = a2.i;
        }
        return c0496p3;
    }

    @Override // io.appmetrica.analytics.impl.Wm
    public final IBinaryDataHelper d(Context context) {
        IBinaryDataHelper g;
        C0649v7 a2 = C0649v7.a(context);
        synchronized (a2) {
            g = a2.g();
        }
        return g;
    }
}
