package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.sh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0576sh implements InterfaceC0533qn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0368k9 f1203a;
    public final /* synthetic */ C0651vh b;

    public C0576sh(C0651vh c0651vh, C0368k9 c0368k9) {
        this.b = c0651vh;
        this.f1203a = c0368k9;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0533qn
    public final void a(Object obj) {
        List list = (List) obj;
        C0368k9 c0368k9 = this.f1203a;
        if (mo.a((Collection) list)) {
            return;
        }
        c0368k9.d = new C0317i9[list.size()];
        for (int i = 0; i < list.size(); i++) {
            C0354jl c0354jl = (C0354jl) list.get(i);
            C0317i9[] c0317i9Arr = c0368k9.d;
            Map map = Qf.f733a;
            C0317i9 c0317i9 = new C0317i9();
            Integer num = c0354jl.f1043a;
            if (num != null) {
                c0317i9.f1021a = num.intValue();
            }
            Integer num2 = c0354jl.b;
            if (num2 != null) {
                c0317i9.b = num2.intValue();
            }
            if (!TextUtils.isEmpty(c0354jl.d)) {
                c0317i9.c = c0354jl.d;
            }
            c0317i9.d = c0354jl.c;
            c0317i9Arr[i] = c0317i9;
            this.b.g += CodedOutputByteBufferNano.computeMessageSizeNoTag(c0368k9.d[i]);
            this.b.g += CodedOutputByteBufferNano.computeTagSize(10);
        }
    }
}
