package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Nh implements InterfaceC0670vn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ J9 f597a;
    public final /* synthetic */ Qh b;

    public Nh(Qh qh, J9 j9) {
        this.b = qh;
        this.f597a = j9;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0670vn
    public final void a(Object obj) {
        List list = (List) obj;
        J9 j9 = this.f597a;
        if (ro.a((Collection) list)) {
            return;
        }
        j9.d = new H9[list.size()];
        for (int i = 0; i < list.size(); i++) {
            C0568rl c0568rl = (C0568rl) list.get(i);
            H9[] h9Arr = j9.d;
            Map map = AbstractC0410lg.f974a;
            H9 h9 = new H9();
            Integer num = c0568rl.f1071a;
            if (num != null) {
                h9.f476a = num.intValue();
            }
            Integer num2 = c0568rl.b;
            if (num2 != null) {
                h9.b = num2.intValue();
            }
            if (!TextUtils.isEmpty(c0568rl.d)) {
                h9.c = c0568rl.d;
            }
            h9.d = c0568rl.c;
            h9Arr[i] = h9;
            this.b.g += CodedOutputByteBufferNano.computeMessageSizeNoTag(j9.d[i]);
            this.b.g += CodedOutputByteBufferNano.computeTagSize(10);
        }
    }
}
