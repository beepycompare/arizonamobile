package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
/* loaded from: classes4.dex */
public final class Vm extends AbstractC0132an {
    @Override // io.appmetrica.analytics.impl.AbstractC0132an
    public final ProtobufStateStorage a(Context context, IBinaryDataHelper iBinaryDataHelper) {
        byte[] bArr;
        byte[] bArr2;
        Cf cf = new Cf();
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
        return new C0331ig("preload_info_data", iBinaryDataHelper, new Y8(cf, new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, bArr, bArr2)), new C0761zf());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0132an
    public final IBinaryDataHelper c(Context context) {
        C0574s3 c0574s3;
        C0728y7 a2 = C0728y7.a(context);
        synchronized (a2) {
            if (a2.i == null) {
                a2.i = new C0574s3(a2.g());
            }
            c0574s3 = a2.i;
        }
        return c0574s3;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0132an
    public final IBinaryDataHelper d(Context context) {
        IBinaryDataHelper g;
        C0728y7 a2 = C0728y7.a(context);
        synchronized (a2) {
            g = a2.g();
        }
        return g;
    }
}
