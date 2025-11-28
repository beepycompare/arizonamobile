package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.wh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0677wh implements InterfaceC0558rn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0520q9 f1188a;
    public final /* synthetic */ C0752zh b;

    public C0677wh(C0752zh c0752zh, C0520q9 c0520q9) {
        this.b = c0752zh;
        this.f1188a = c0520q9;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0558rn
    public final void a(Object obj) {
        List list = (List) obj;
        C0520q9 c0520q9 = this.f1188a;
        if (no.a((Collection) list)) {
            return;
        }
        c0520q9.d = new C0470o9[list.size()];
        for (int i = 0; i < list.size(); i++) {
            C0432ml c0432ml = (C0432ml) list.get(i);
            C0470o9[] c0470o9Arr = c0520q9.d;
            Map map = Uf.f719a;
            C0470o9 c0470o9 = new C0470o9();
            Integer num = c0432ml.f1013a;
            if (num != null) {
                c0470o9.f1038a = num.intValue();
            }
            Integer num2 = c0432ml.b;
            if (num2 != null) {
                c0470o9.b = num2.intValue();
            }
            if (!TextUtils.isEmpty(c0432ml.d)) {
                c0470o9.c = c0432ml.d;
            }
            c0470o9.d = c0432ml.c;
            c0470o9Arr[i] = c0470o9;
            this.b.g += CodedOutputByteBufferNano.computeMessageSizeNoTag(c0520q9.d[i]);
            this.b.g += CodedOutputByteBufferNano.computeTagSize(10);
        }
    }
}
