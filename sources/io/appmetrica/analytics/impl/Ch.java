package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Ch implements InterfaceC0374jn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ B9 f375a;
    public final /* synthetic */ Fh b;

    public Ch(Fh fh, B9 b9) {
        this.b = fh;
        this.f375a = b9;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0374jn
    public final void a(Object obj) {
        List list = (List) obj;
        B9 b9 = this.f375a;
        if (fo.a((Collection) list)) {
            return;
        }
        b9.d = new C0759z9[list.size()];
        for (int i = 0; i < list.size(); i++) {
            C0273fl c0273fl = (C0273fl) list.get(i);
            C0759z9[] c0759z9Arr = b9.d;
            Map map = AbstractC0140ag.f754a;
            C0759z9 c0759z9 = new C0759z9();
            Integer num = c0273fl.f842a;
            if (num != null) {
                c0759z9.f1162a = num.intValue();
            }
            Integer num2 = c0273fl.b;
            if (num2 != null) {
                c0759z9.b = num2.intValue();
            }
            if (!TextUtils.isEmpty(c0273fl.d)) {
                c0759z9.c = c0273fl.d;
            }
            c0759z9.d = c0273fl.c;
            c0759z9Arr[i] = c0759z9;
            this.b.g += CodedOutputByteBufferNano.computeMessageSizeNoTag(b9.d[i]);
            this.b.g += CodedOutputByteBufferNano.computeTagSize(10);
        }
    }
}
