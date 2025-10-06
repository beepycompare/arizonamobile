package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
/* loaded from: classes4.dex */
public final class Tm extends AbstractC0133an {
    @Override // io.appmetrica.analytics.impl.AbstractC0133an
    public final ProtobufStateStorage a(Context context, IBinaryDataHelper iBinaryDataHelper) {
        byte[] bArr;
        byte[] bArr2;
        Hm hm = new Hm();
        try {
            bArr = Cj.a(context.getPackageName());
        } catch (Throwable unused) {
            bArr = new byte[16];
        }
        try {
            bArr2 = Cj.a(new StringBuilder(context.getPackageName()).reverse().toString());
        } catch (Throwable unused2) {
            bArr2 = new byte[16];
        }
        return new C0332ig("startup_state", iBinaryDataHelper, new Y8(hm, new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, bArr, bArr2)), new C0520pm());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0133an
    public final IBinaryDataHelper c(Context context) {
        C0575s3 c0575s3;
        C0729y7 a2 = C0729y7.a(context);
        synchronized (a2) {
            if (a2.i == null) {
                a2.i = new C0575s3(a2.g());
            }
            c0575s3 = a2.i;
        }
        return c0575s3;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0133an
    public final IBinaryDataHelper d(Context context) {
        IBinaryDataHelper g;
        C0729y7 a2 = C0729y7.a(context);
        synchronized (a2) {
            g = a2.g();
        }
        return g;
    }
}
