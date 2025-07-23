package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Eh implements InterfaceC0443mn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ E9 f419a;
    public final /* synthetic */ Hh b;

    public Eh(Hh hh, E9 e9) {
        this.b = hh;
        this.f419a = e9;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0443mn
    public final void a(Object obj) {
        List list = (List) obj;
        E9 e9 = this.f419a;
        if (io.a((Collection) list)) {
            return;
        }
        e9.d = new C9[list.size()];
        for (int i = 0; i < list.size(); i++) {
            C0341il c0341il = (C0341il) list.get(i);
            C9[] c9Arr = e9.d;
            Map map = AbstractC0184cg.f798a;
            C9 c9 = new C9();
            Integer num = c0341il.f904a;
            if (num != null) {
                c9.f375a = num.intValue();
            }
            Integer num2 = c0341il.b;
            if (num2 != null) {
                c9.b = num2.intValue();
            }
            if (!TextUtils.isEmpty(c0341il.d)) {
                c9.c = c0341il.d;
            }
            c9.d = c0341il.c;
            c9Arr[i] = c9;
            this.b.g += CodedOutputByteBufferNano.computeMessageSizeNoTag(e9.d[i]);
            this.b.g += CodedOutputByteBufferNano.computeTagSize(10);
        }
    }
}
