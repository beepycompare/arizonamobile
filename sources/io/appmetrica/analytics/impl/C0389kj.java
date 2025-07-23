package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.kj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0389kj extends AbstractC0236eh {
    public C0389kj(C0574s5 c0574s5) {
        super(c0574s5);
        c0574s5.b().a();
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0236eh
    public final boolean a(C0401l6 c0401l6) {
        Object remove;
        for (Map.Entry entry : c0401l6.p.entrySet()) {
            Kk kk = this.f831a.u;
            String str = (String) entry.getKey();
            byte[] bArr = (byte[]) entry.getValue();
            if (bArr != null) {
                kk.getClass();
                if (bArr.length != 0) {
                    remove = kk.b.put(str, bArr);
                    byte[] bArr2 = (byte[]) remove;
                    Ok ok = kk.f525a;
                    Map<String, byte[]> map = kk.b;
                    IBinaryDataHelper iBinaryDataHelper = ok.d;
                    String str2 = ok.f582a;
                    Nk nk = ok.c;
                    Lk fromModel = ok.b.fromModel(map);
                    nk.getClass();
                    iBinaryDataHelper.insert(str2, MessageNano.toByteArray(fromModel));
                }
            }
            remove = kk.b.remove(str);
            byte[] bArr22 = (byte[]) remove;
            Ok ok2 = kk.f525a;
            Map<String, byte[]> map2 = kk.b;
            IBinaryDataHelper iBinaryDataHelper2 = ok2.d;
            String str22 = ok2.f582a;
            Nk nk2 = ok2.c;
            Lk fromModel2 = ok2.b.fromModel(map2);
            nk2.getClass();
            iBinaryDataHelper2.insert(str22, MessageNano.toByteArray(fromModel2));
        }
        return true;
    }
}
