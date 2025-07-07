package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public final class Xi implements mo {

    /* renamed from: a  reason: collision with root package name */
    public final lo f709a = new lo();

    @Override // io.appmetrica.analytics.impl.mo
    public final ko a(Revenue revenue) {
        ko koVar;
        lo loVar = this.f709a;
        ko[] koVarArr = new ko[1];
        C0218dg c0218dg = new C0218dg();
        Integer num = revenue.quantity;
        if (num != null && num.intValue() <= 0) {
            koVar = new ko(c0218dg, false, "Invalid quantity value " + num);
        } else {
            koVar = new ko(c0218dg, true, "");
        }
        koVarArr[0] = koVar;
        List<ko> asList = Arrays.asList(koVarArr);
        loVar.getClass();
        return loVar.a(asList);
    }
}
