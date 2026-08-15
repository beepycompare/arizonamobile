package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
/* renamed from: io.appmetrica.analytics.impl.nn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0465nn extends AbstractC0620tn {
    @Override // io.appmetrica.analytics.impl.AbstractC0620tn
    public final IBinaryDataHelper a(Context context) {
        return Na.I.B().b(context);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0620tn
    public final IBinaryDataHelper b(Context context) {
        IBinaryDataHelper a2;
        C0127al B = Na.I.B();
        synchronized (B) {
            a2 = B.a(context);
        }
        return a2;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0620tn
    public final ProtobufStateStorage a(Context context, IBinaryDataHelper iBinaryDataHelper) {
        byte[] bArr;
        byte[] bArr2;
        If r1 = new If();
        try {
            bArr = AbstractC0401lb.a(context.getPackageName());
        } catch (Throwable unused) {
            bArr = new byte[16];
        }
        try {
            bArr2 = AbstractC0401lb.a(new StringBuilder(context.getPackageName()).reverse().toString());
        } catch (Throwable unused2) {
            bArr2 = new byte[16];
        }
        return new C0458ng("preload_info_data", iBinaryDataHelper, new T8(r1, new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, bArr, bArr2)), new Ff());
    }
}
