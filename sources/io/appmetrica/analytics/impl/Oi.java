package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
public final class Oi implements to {

    /* renamed from: a  reason: collision with root package name */
    public final so f623a = new so();

    @Override // io.appmetrica.analytics.impl.to
    public final ro a(Revenue revenue) {
        ro roVar;
        so soVar = this.f623a;
        ro[] roVarArr = new ro[1];
        Tf tf = new Tf();
        Integer num = revenue.quantity;
        if (num != null && num.intValue() <= 0) {
            roVar = new ro(tf, false, "Invalid quantity value " + num);
        } else {
            roVar = new ro(tf, true, "");
        }
        roVarArr[0] = roVar;
        List<ro> asList = Arrays.asList(roVarArr);
        soVar.getClass();
        return soVar.a(asList);
    }
}
