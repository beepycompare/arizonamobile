package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.rh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0555rh implements InterfaceC0512pn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0347j9 f1208a;
    public final /* synthetic */ C0630uh b;

    public C0555rh(C0630uh c0630uh, C0347j9 c0347j9) {
        this.b = c0630uh;
        this.f1208a = c0347j9;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0512pn
    public final void a(Object obj) {
        List list = (List) obj;
        C0347j9 c0347j9 = this.f1208a;
        if (lo.a((Collection) list)) {
            return;
        }
        c0347j9.d = new C0296h9[list.size()];
        for (int i = 0; i < list.size(); i++) {
            C0333il c0333il = (C0333il) list.get(i);
            C0296h9[] c0296h9Arr = c0347j9.d;
            Map map = Pf.f738a;
            C0296h9 c0296h9 = new C0296h9();
            Integer num = c0333il.f1048a;
            if (num != null) {
                c0296h9.f1026a = num.intValue();
            }
            Integer num2 = c0333il.b;
            if (num2 != null) {
                c0296h9.b = num2.intValue();
            }
            if (!TextUtils.isEmpty(c0333il.d)) {
                c0296h9.c = c0333il.d;
            }
            c0296h9.d = c0333il.c;
            c0296h9Arr[i] = c0296h9;
            this.b.g += CodedOutputByteBufferNano.computeMessageSizeNoTag(c0347j9.d[i]);
            this.b.g += CodedOutputByteBufferNano.computeTagSize(10);
        }
    }
}
