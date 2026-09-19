package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
/* renamed from: io.appmetrica.analytics.impl.mn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0438mn extends AbstractC0619tn {
    @Override // io.appmetrica.analytics.impl.AbstractC0619tn
    public final IBinaryDataHelper a(Context context) {
        return Na.I.B().b(context);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0619tn
    public final IBinaryDataHelper b(Context context) {
        IBinaryDataHelper a2;
        C0126al B = Na.I.B();
        synchronized (B) {
            a2 = B.a(context);
        }
        return a2;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0619tn
    public final ProtobufStateStorage a(Context context, IBinaryDataHelper iBinaryDataHelper) {
        byte[] bArr;
        byte[] bArr2;
        C0391l2 c0391l2 = new C0391l2();
        try {
            bArr = AbstractC0400lb.a(context.getPackageName());
        } catch (Throwable unused) {
            bArr = new byte[16];
        }
        try {
            bArr2 = AbstractC0400lb.a(new StringBuilder(context.getPackageName()).reverse().toString());
        } catch (Throwable unused2) {
            bArr2 = new byte[16];
        }
        return new C0457ng("app_permissions_state", iBinaryDataHelper, new T8(c0391l2, new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, bArr, bArr2)), new C0288h2(new I2()));
    }
}
