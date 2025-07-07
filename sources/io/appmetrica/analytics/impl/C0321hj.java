package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.hj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0321hj extends AbstractC0193ch {
    public C0321hj(C0580s5 c0580s5) {
        super(c0580s5);
        c0580s5.b().a();
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0193ch
    public final boolean a(C0333i6 c0333i6) {
        Object remove;
        for (Map.Entry entry : c0333i6.p.entrySet()) {
            Hk hk = this.f785a.u;
            String str = (String) entry.getKey();
            byte[] bArr = (byte[]) entry.getValue();
            if (bArr != null) {
                hk.getClass();
                if (bArr.length != 0) {
                    remove = hk.b.put(str, bArr);
                    byte[] bArr2 = (byte[]) remove;
                    Lk lk = hk.f464a;
                    Map<String, byte[]> map = hk.b;
                    IBinaryDataHelper iBinaryDataHelper = lk.d;
                    String str2 = lk.f521a;
                    Kk kk = lk.c;
                    Ik fromModel = lk.b.fromModel(map);
                    kk.getClass();
                    iBinaryDataHelper.insert(str2, MessageNano.toByteArray(fromModel));
                }
            }
            remove = hk.b.remove(str);
            byte[] bArr22 = (byte[]) remove;
            Lk lk2 = hk.f464a;
            Map<String, byte[]> map2 = hk.b;
            IBinaryDataHelper iBinaryDataHelper2 = lk2.d;
            String str22 = lk2.f521a;
            Kk kk2 = lk2.c;
            Ik fromModel2 = lk2.b.fromModel(map2);
            kk2.getClass();
            iBinaryDataHelper2.insert(str22, MessageNano.toByteArray(fromModel2));
        }
        return true;
    }
}
