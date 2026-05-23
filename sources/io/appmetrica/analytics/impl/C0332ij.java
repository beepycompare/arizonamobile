package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
import java.util.Arrays;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ij  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0332ij implements Vo {

    /* renamed from: a  reason: collision with root package name */
    public final Uo f1035a = new Uo();

    @Override // io.appmetrica.analytics.impl.Vo
    public final To a(Revenue revenue) {
        To to;
        Uo uo = this.f1035a;
        To[] toArr = new To[1];
        C0614tg c0614tg = new C0614tg();
        Integer num = revenue.quantity;
        if (num != null && num.intValue() <= 0) {
            to = new To(c0614tg, false, "Invalid quantity value " + num);
        } else {
            to = new To(c0614tg, true, "");
        }
        toArr[0] = to;
        List<To> asList = Arrays.asList(toArr);
        uo.getClass();
        return uo.a(asList);
    }
}
