package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.rh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0554rh implements InterfaceC0511pn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0346j9 f1208a;
    public final /* synthetic */ C0629uh b;

    public C0554rh(C0629uh c0629uh, C0346j9 c0346j9) {
        this.b = c0629uh;
        this.f1208a = c0346j9;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0511pn
    public final void a(Object obj) {
        List list = (List) obj;
        C0346j9 c0346j9 = this.f1208a;
        if (lo.a((Collection) list)) {
            return;
        }
        c0346j9.d = new C0295h9[list.size()];
        for (int i = 0; i < list.size(); i++) {
            C0332il c0332il = (C0332il) list.get(i);
            C0295h9[] c0295h9Arr = c0346j9.d;
            Map map = Pf.f738a;
            C0295h9 c0295h9 = new C0295h9();
            Integer num = c0332il.f1048a;
            if (num != null) {
                c0295h9.f1026a = num.intValue();
            }
            Integer num2 = c0332il.b;
            if (num2 != null) {
                c0295h9.b = num2.intValue();
            }
            if (!TextUtils.isEmpty(c0332il.d)) {
                c0295h9.c = c0332il.d;
            }
            c0295h9.d = c0332il.c;
            c0295h9Arr[i] = c0295h9;
            this.b.g += CodedOutputByteBufferNano.computeMessageSizeNoTag(c0346j9.d[i]);
            this.b.g += CodedOutputByteBufferNano.computeTagSize(10);
        }
    }
}
