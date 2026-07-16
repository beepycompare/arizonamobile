package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.qh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0538qh implements Qn {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ D9 f1167a;

    public C0538qh(D9 d9) {
        this.f1167a = d9;
    }

    @Override // io.appmetrica.analytics.impl.Qn
    public final void a(List<Nl> list) {
        if (Oo.a((Collection) list)) {
            return;
        }
        D9 d9 = this.f1167a;
        int size = list.size();
        B9[] b9Arr = new B9[size];
        for (int i = 0; i < size; i++) {
            Nl nl = list.get(i);
            Map map = AbstractC0537qg.f1166a;
            B9 b9 = new B9();
            Integer num = nl.f691a;
            if (num != null) {
                b9.f474a = num.intValue();
            }
            Integer num2 = nl.b;
            if (num2 != null) {
                b9.b = num2.intValue();
            }
            if (!StringUtils.isNullOrEmpty(nl.d)) {
                b9.c = nl.d;
            }
            b9.d = nl.c;
            b9Arr[i] = b9;
        }
        d9.d = b9Arr;
    }
}
