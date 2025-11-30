package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.sh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0577sh implements InterfaceC0534qn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0369k9 f1120a;
    public final /* synthetic */ C0652vh b;

    public C0577sh(C0652vh c0652vh, C0369k9 c0369k9) {
        this.b = c0652vh;
        this.f1120a = c0369k9;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0534qn
    public final void a(Object obj) {
        List list = (List) obj;
        C0369k9 c0369k9 = this.f1120a;
        if (mo.a((Collection) list)) {
            return;
        }
        c0369k9.d = new C0318i9[list.size()];
        for (int i = 0; i < list.size(); i++) {
            C0355jl c0355jl = (C0355jl) list.get(i);
            C0318i9[] c0318i9Arr = c0369k9.d;
            Map map = Qf.f650a;
            C0318i9 c0318i9 = new C0318i9();
            Integer num = c0355jl.f960a;
            if (num != null) {
                c0318i9.f938a = num.intValue();
            }
            Integer num2 = c0355jl.b;
            if (num2 != null) {
                c0318i9.b = num2.intValue();
            }
            if (!TextUtils.isEmpty(c0355jl.d)) {
                c0318i9.c = c0355jl.d;
            }
            c0318i9.d = c0355jl.c;
            c0318i9Arr[i] = c0318i9;
            this.b.g += CodedOutputByteBufferNano.computeMessageSizeNoTag(c0369k9.d[i]);
            this.b.g += CodedOutputByteBufferNano.computeTagSize(10);
        }
    }
}
