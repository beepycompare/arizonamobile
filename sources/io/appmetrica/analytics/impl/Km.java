package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
/* loaded from: classes4.dex */
public final class Km extends Om {
    @Override // io.appmetrica.analytics.impl.Om
    public final ProtobufStateStorage a(Context context, IBinaryDataHelper iBinaryDataHelper) {
        byte[] bArr;
        byte[] bArr2;
        A2 a2 = new A2();
        try {
            bArr = AbstractC0537qj.a(context.getPackageName());
        } catch (Throwable unused) {
            bArr = new byte[16];
        }
        try {
            bArr2 = AbstractC0537qj.a(new StringBuilder(context.getPackageName()).reverse().toString());
        } catch (Throwable unused2) {
            bArr2 = new byte[16];
        }
        return new Xf("auto_inapp_collecting_info_data", iBinaryDataHelper, new Q8(a2, new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, bArr, bArr2)), new C0694x2(new C0272g3()));
    }

    @Override // io.appmetrica.analytics.impl.Om
    public final IBinaryDataHelper c(Context context) {
        C0496p3 c0496p3;
        C0549r7 a2 = C0549r7.a(context);
        synchronized (a2) {
            if (a2.k == null) {
                a2.k = new C0496p3(a2.e());
            }
            c0496p3 = a2.k;
        }
        return c0496p3;
    }

    @Override // io.appmetrica.analytics.impl.Om
    public final IBinaryDataHelper d(Context context) {
        IBinaryDataHelper e;
        C0549r7 a2 = C0549r7.a(context);
        synchronized (a2) {
            e = a2.e();
        }
        return e;
    }
}
