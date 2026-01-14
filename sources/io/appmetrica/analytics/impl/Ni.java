package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
public final class Ni implements so {

    /* renamed from: a  reason: collision with root package name */
    public final ro f712a = new ro();

    @Override // io.appmetrica.analytics.impl.so
    public final qo a(Revenue revenue) {
        qo qoVar;
        ro roVar = this.f712a;
        qo[] qoVarArr = new qo[1];
        Sf sf = new Sf();
        Integer num = revenue.quantity;
        if (num != null && num.intValue() <= 0) {
            qoVar = new qo(sf, false, "Invalid quantity value " + num);
        } else {
            qoVar = new qo(sf, true, "");
        }
        qoVarArr[0] = qoVar;
        List<qo> asList = Arrays.asList(qoVarArr);
        roVar.getClass();
        return roVar.a(asList);
    }
}
