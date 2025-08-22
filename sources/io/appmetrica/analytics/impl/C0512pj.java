package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.pj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0512pj extends AbstractC0358jh {
    public C0512pj(C0572s5 c0572s5) {
        super(c0572s5);
        c0572s5.b().a();
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0358jh
    public final boolean a(C0399l6 c0399l6) {
        Object remove;
        for (Map.Entry entry : c0399l6.p.entrySet()) {
            Pk pk = this.f925a.u;
            String str = (String) entry.getKey();
            byte[] bArr = (byte[]) entry.getValue();
            if (bArr != null) {
                pk.getClass();
                if (bArr.length != 0) {
                    remove = pk.b.put(str, bArr);
                    byte[] bArr2 = (byte[]) remove;
                    Tk tk = pk.f609a;
                    Map<String, byte[]> map = pk.b;
                    IBinaryDataHelper iBinaryDataHelper = tk.d;
                    String str2 = tk.f665a;
                    Sk sk = tk.c;
                    Qk fromModel = tk.b.fromModel(map);
                    sk.getClass();
                    iBinaryDataHelper.insert(str2, MessageNano.toByteArray(fromModel));
                }
            }
            remove = pk.b.remove(str);
            byte[] bArr22 = (byte[]) remove;
            Tk tk2 = pk.f609a;
            Map<String, byte[]> map2 = pk.b;
            IBinaryDataHelper iBinaryDataHelper2 = tk2.d;
            String str22 = tk2.f665a;
            Sk sk2 = tk2.c;
            Qk fromModel2 = tk2.b.fromModel(map2);
            sk2.getClass();
            iBinaryDataHelper2.insert(str22, MessageNano.toByteArray(fromModel2));
        }
        return true;
    }
}
