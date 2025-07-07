package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
/* loaded from: classes4.dex */
public final class Jm extends Om {
    @Override // io.appmetrica.analytics.impl.Om
    public final ProtobufStateStorage a(Context context, IBinaryDataHelper iBinaryDataHelper) {
        byte[] bArr;
        byte[] bArr2;
        C0640uf c0640uf = new C0640uf();
        try {
            bArr = AbstractC0545qj.a(context.getPackageName());
        } catch (Throwable unused) {
            bArr = new byte[16];
        }
        try {
            bArr2 = AbstractC0545qj.a(new StringBuilder(context.getPackageName()).reverse().toString());
        } catch (Throwable unused2) {
            bArr2 = new byte[16];
        }
        return new Xf("preload_info_data", iBinaryDataHelper, new Q8(c0640uf, new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, bArr, bArr2)), new C0565rf());
    }

    @Override // io.appmetrica.analytics.impl.Om
    public final IBinaryDataHelper c(Context context) {
        C0504p3 c0504p3;
        C0557r7 a2 = C0557r7.a(context);
        synchronized (a2) {
            if (a2.i == null) {
                a2.i = new C0504p3(a2.g());
            }
            c0504p3 = a2.i;
        }
        return c0504p3;
    }

    @Override // io.appmetrica.analytics.impl.Om
    public final IBinaryDataHelper d(Context context) {
        IBinaryDataHelper g;
        C0557r7 a2 = C0557r7.a(context);
        synchronized (a2) {
            g = a2.g();
        }
        return g;
    }
}
