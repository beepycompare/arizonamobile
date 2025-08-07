package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
/* loaded from: classes4.dex */
public final class Km extends Rm {
    @Override // io.appmetrica.analytics.impl.Rm
    public final ProtobufStateStorage a(Context context, IBinaryDataHelper iBinaryDataHelper) {
        byte[] bArr;
        byte[] bArr2;
        C0742ym c0742ym = new C0742ym();
        try {
            bArr = AbstractC0614tj.a(context.getPackageName());
        } catch (Throwable unused) {
            bArr = new byte[16];
        }
        try {
            bArr2 = AbstractC0614tj.a(new StringBuilder(context.getPackageName()).reverse().toString());
        } catch (Throwable unused2) {
            bArr2 = new byte[16];
        }
        return new Zf("startup_state", iBinaryDataHelper, new T8(c0742ym, new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, bArr, bArr2)), new C0294gm());
    }

    @Override // io.appmetrica.analytics.impl.Rm
    public final IBinaryDataHelper c(Context context) {
        C0499p3 c0499p3;
        C0627u7 a2 = C0627u7.a(context);
        synchronized (a2) {
            if (a2.i == null) {
                a2.i = new C0499p3(a2.g());
            }
            c0499p3 = a2.i;
        }
        return c0499p3;
    }

    @Override // io.appmetrica.analytics.impl.Rm
    public final IBinaryDataHelper d(Context context) {
        IBinaryDataHelper g;
        C0627u7 a2 = C0627u7.a(context);
        synchronized (a2) {
            g = a2.g();
        }
        return g;
    }
}
