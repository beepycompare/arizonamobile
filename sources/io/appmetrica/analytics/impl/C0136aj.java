package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
import java.util.Arrays;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.aj  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0136aj implements po {

    /* renamed from: a  reason: collision with root package name */
    public final oo f771a = new oo();

    @Override // io.appmetrica.analytics.impl.po
    public final no a(Revenue revenue) {
        no noVar;
        oo ooVar = this.f771a;
        no[] noVarArr = new no[1];
        C0262fg c0262fg = new C0262fg();
        Integer num = revenue.quantity;
        if (num != null && num.intValue() <= 0) {
            noVar = new no(c0262fg, false, "Invalid quantity value " + num);
        } else {
            noVar = new no(c0262fg, true, "");
        }
        noVarArr[0] = noVar;
        List<no> asList = Arrays.asList(noVarArr);
        ooVar.getClass();
        return ooVar.a(asList);
    }
}
