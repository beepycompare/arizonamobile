package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Jh implements InterfaceC0565rn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ G9 f516a;
    public final /* synthetic */ Mh b;

    public Jh(Mh mh, G9 g9) {
        this.b = mh;
        this.f516a = g9;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0565rn
    public final void a(Object obj) {
        List list = (List) obj;
        G9 g9 = this.f516a;
        if (no.a((Collection) list)) {
            return;
        }
        g9.d = new E9[list.size()];
        for (int i = 0; i < list.size(); i++) {
            C0464nl c0464nl = (C0464nl) list.get(i);
            E9[] e9Arr = g9.d;
            Map map = AbstractC0306hg.f889a;
            E9 e9 = new E9();
            Integer num = c0464nl.f987a;
            if (num != null) {
                e9.f411a = num.intValue();
            }
            Integer num2 = c0464nl.b;
            if (num2 != null) {
                e9.b = num2.intValue();
            }
            if (!TextUtils.isEmpty(c0464nl.d)) {
                e9.c = c0464nl.d;
            }
            e9.d = c0464nl.c;
            e9Arr[i] = e9;
            this.b.g += CodedOutputByteBufferNano.computeMessageSizeNoTag(g9.d[i]);
            this.b.g += CodedOutputByteBufferNano.computeTagSize(10);
        }
    }
}
