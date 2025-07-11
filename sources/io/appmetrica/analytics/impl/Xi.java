package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public final class Xi implements mo {

    /* renamed from: a  reason: collision with root package name */
    public final lo f710a = new lo();

    @Override // io.appmetrica.analytics.impl.mo
    public final ko a(Revenue revenue) {
        ko koVar;
        lo loVar = this.f710a;
        ko[] koVarArr = new ko[1];
        C0210dg c0210dg = new C0210dg();
        Integer num = revenue.quantity;
        if (num != null && num.intValue() <= 0) {
            koVar = new ko(c0210dg, false, "Invalid quantity value " + num);
        } else {
            koVar = new ko(c0210dg, true, "");
        }
        koVarArr[0] = koVar;
        List<ko> asList = Arrays.asList(koVarArr);
        loVar.getClass();
        return loVar.a(asList);
    }
}
