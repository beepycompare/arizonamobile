package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.tj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0615tj extends AbstractC0462nh {
    public C0615tj(C0651v5 c0651v5) {
        super(c0651v5);
        c0651v5.b().a();
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0462nh
    public final boolean a(C0477o6 c0477o6) {
        Object remove;
        for (Map.Entry entry : c0477o6.p.entrySet()) {
            Tk tk = this.f1001a.u;
            String str = (String) entry.getKey();
            byte[] bArr = (byte[]) entry.getValue();
            if (bArr != null) {
                tk.getClass();
                if (bArr.length != 0) {
                    remove = tk.b.put(str, bArr);
                    byte[] bArr2 = (byte[]) remove;
                    Xk xk = tk.f685a;
                    Map<String, byte[]> map = tk.b;
                    IBinaryDataHelper iBinaryDataHelper = xk.d;
                    String str2 = xk.f742a;
                    Wk wk = xk.c;
                    Uk fromModel = xk.b.fromModel(map);
                    wk.getClass();
                    iBinaryDataHelper.insert(str2, MessageNano.toByteArray(fromModel));
                }
            }
            remove = tk.b.remove(str);
            byte[] bArr22 = (byte[]) remove;
            Xk xk2 = tk.f685a;
            Map<String, byte[]> map2 = tk.b;
            IBinaryDataHelper iBinaryDataHelper2 = xk2.d;
            String str22 = xk2.f742a;
            Wk wk2 = xk2.c;
            Uk fromModel2 = xk2.b.fromModel(map2);
            wk2.getClass();
            iBinaryDataHelper2.insert(str22, MessageNano.toByteArray(fromModel2));
        }
        return true;
    }
}
