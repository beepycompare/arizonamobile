package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
import java.util.Arrays;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.jj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0360jj implements yo {

    /* renamed from: a  reason: collision with root package name */
    public final xo f937a = new xo();

    @Override // io.appmetrica.analytics.impl.yo
    public final wo a(Revenue revenue) {
        wo woVar;
        xo xoVar = this.f937a;
        wo[] woVarArr = new wo[1];
        C0487og c0487og = new C0487og();
        Integer num = revenue.quantity;
        if (num != null && num.intValue() <= 0) {
            woVar = new wo(c0487og, false, "Invalid quantity value " + num);
        } else {
            woVar = new wo(c0487og, true, "");
        }
        woVarArr[0] = woVar;
        List<wo> asList = Arrays.asList(woVarArr);
        xoVar.getClass();
        return xoVar.a(asList);
    }
}
