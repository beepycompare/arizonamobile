package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public final class Si implements uo {

    /* renamed from: a  reason: collision with root package name */
    public final to f686a = new to();

    @Override // io.appmetrica.analytics.impl.uo
    public final so a(Revenue revenue) {
        so soVar;
        to toVar = this.f686a;
        so[] soVarArr = new so[1];
        Xf xf = new Xf();
        Integer num = revenue.quantity;
        if (num != null && num.intValue() <= 0) {
            soVar = new so(xf, false, "Invalid quantity value " + num);
        } else {
            soVar = new so(xf, true, "");
        }
        soVarArr[0] = soVar;
        List<so> asList = Arrays.asList(soVarArr);
        toVar.getClass();
        return toVar.a(asList);
    }
}
