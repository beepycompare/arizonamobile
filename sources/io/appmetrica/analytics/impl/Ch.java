package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Ch implements InterfaceC0366jn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ B9 f376a;
    public final /* synthetic */ Fh b;

    public Ch(Fh fh, B9 b9) {
        this.b = fh;
        this.f376a = b9;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0366jn
    public final void a(Object obj) {
        List list = (List) obj;
        B9 b9 = this.f376a;
        if (fo.a((Collection) list)) {
            return;
        }
        b9.d = new C0751z9[list.size()];
        for (int i = 0; i < list.size(); i++) {
            C0265fl c0265fl = (C0265fl) list.get(i);
            C0751z9[] c0751z9Arr = b9.d;
            Map map = AbstractC0132ag.f755a;
            C0751z9 c0751z9 = new C0751z9();
            Integer num = c0265fl.f843a;
            if (num != null) {
                c0751z9.f1163a = num.intValue();
            }
            Integer num2 = c0265fl.b;
            if (num2 != null) {
                c0751z9.b = num2.intValue();
            }
            if (!TextUtils.isEmpty(c0265fl.d)) {
                c0751z9.c = c0265fl.d;
            }
            c0751z9.d = c0265fl.c;
            c0751z9Arr[i] = c0751z9;
            this.b.g += CodedOutputByteBufferNano.computeMessageSizeNoTag(b9.d[i]);
            this.b.g += CodedOutputByteBufferNano.computeTagSize(10);
        }
    }
}
