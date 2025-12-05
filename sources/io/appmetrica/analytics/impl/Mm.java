package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
/* loaded from: classes5.dex */
public final class Mm extends Sm {
    @Override // io.appmetrica.analytics.impl.Sm
    public final IBinaryDataHelper a(Context context) {
        return C0470oa.I.B().b(context);
    }

    @Override // io.appmetrica.analytics.impl.Sm
    public final IBinaryDataHelper b(Context context) {
        IBinaryDataHelper a2;
        C0754zk B = C0470oa.I.B();
        synchronized (B) {
            a2 = B.a(context);
        }
        return a2;
    }

    @Override // io.appmetrica.analytics.impl.Sm
    public final ProtobufStateStorage a(Context context, IBinaryDataHelper iBinaryDataHelper) {
        byte[] bArr;
        byte[] bArr2;
        C0348jf c0348jf = new C0348jf();
        try {
            bArr = AbstractC0301hj.a(context.getPackageName());
        } catch (Throwable unused) {
            bArr = new byte[16];
        }
        try {
            bArr2 = AbstractC0301hj.a(new StringBuilder(context.getPackageName()).reverse().toString());
        } catch (Throwable unused2) {
            bArr2 = new byte[16];
        }
        return new Nf("preload_info_data", iBinaryDataHelper, new B8(c0348jf, new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, bArr, bArr2)), new C0271gf());
    }
}
