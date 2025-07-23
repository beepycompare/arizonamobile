package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
/* loaded from: classes4.dex */
public final class Nm extends Rm {
    @Override // io.appmetrica.analytics.impl.Rm
    public final ProtobufStateStorage a(Context context, IBinaryDataHelper iBinaryDataHelper) {
        byte[] bArr;
        byte[] bArr2;
        A2 a2 = new A2();
        try {
            bArr = AbstractC0613tj.a(context.getPackageName());
        } catch (Throwable unused) {
            bArr = new byte[16];
        }
        try {
            bArr2 = AbstractC0613tj.a(new StringBuilder(context.getPackageName()).reverse().toString());
        } catch (Throwable unused2) {
            bArr2 = new byte[16];
        }
        return new Zf("auto_inapp_collecting_info_data", iBinaryDataHelper, new T8(a2, new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, bArr, bArr2)), new C0696x2(new C0274g3()));
    }

    @Override // io.appmetrica.analytics.impl.Rm
    public final IBinaryDataHelper c(Context context) {
        C0498p3 c0498p3;
        C0626u7 a2 = C0626u7.a(context);
        synchronized (a2) {
            if (a2.k == null) {
                a2.k = new C0498p3(a2.e());
            }
            c0498p3 = a2.k;
        }
        return c0498p3;
    }

    @Override // io.appmetrica.analytics.impl.Rm
    public final IBinaryDataHelper d(Context context) {
        IBinaryDataHelper e;
        C0626u7 a2 = C0626u7.a(context);
        synchronized (a2) {
            e = a2.e();
        }
        return e;
    }
}
