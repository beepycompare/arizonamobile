package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
import java.util.Arrays;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.fj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0257fj implements uo {

    /* renamed from: a  reason: collision with root package name */
    public final to f858a = new to();

    @Override // io.appmetrica.analytics.impl.uo
    public final so a(Revenue revenue) {
        so soVar;
        to toVar = this.f858a;
        so[] soVarArr = new so[1];
        C0383kg c0383kg = new C0383kg();
        Integer num = revenue.quantity;
        if (num != null && num.intValue() <= 0) {
            soVar = new so(c0383kg, false, "Invalid quantity value " + num);
        } else {
            soVar = new so(c0383kg, true, "");
        }
        soVarArr[0] = soVar;
        List<so> asList = Arrays.asList(soVarArr);
        toVar.getClass();
        return toVar.a(asList);
    }
}
