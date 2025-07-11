package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.hj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0313hj extends AbstractC0185ch {
    public C0313hj(C0572s5 c0572s5) {
        super(c0572s5);
        c0572s5.b().a();
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0185ch
    public final boolean a(C0325i6 c0325i6) {
        Object remove;
        for (Map.Entry entry : c0325i6.p.entrySet()) {
            Hk hk = this.f786a.u;
            String str = (String) entry.getKey();
            byte[] bArr = (byte[]) entry.getValue();
            if (bArr != null) {
                hk.getClass();
                if (bArr.length != 0) {
                    remove = hk.b.put(str, bArr);
                    byte[] bArr2 = (byte[]) remove;
                    Lk lk = hk.f465a;
                    Map<String, byte[]> map = hk.b;
                    IBinaryDataHelper iBinaryDataHelper = lk.d;
                    String str2 = lk.f522a;
                    Kk kk = lk.c;
                    Ik fromModel = lk.b.fromModel(map);
                    kk.getClass();
                    iBinaryDataHelper.insert(str2, MessageNano.toByteArray(fromModel));
                }
            }
            remove = hk.b.remove(str);
            byte[] bArr22 = (byte[]) remove;
            Lk lk2 = hk.f465a;
            Map<String, byte[]> map2 = hk.b;
            IBinaryDataHelper iBinaryDataHelper2 = lk2.d;
            String str22 = lk2.f522a;
            Kk kk2 = lk2.c;
            Ik fromModel2 = lk2.b.fromModel(map2);
            kk2.getClass();
            iBinaryDataHelper2.insert(str22, MessageNano.toByteArray(fromModel2));
        }
        return true;
    }
}
