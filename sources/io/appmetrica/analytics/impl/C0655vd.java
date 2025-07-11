package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.service.event.ModuleServiceEventHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.StringCompanionObject;
/* renamed from: io.appmetrica.analytics.impl.vd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0655vd extends AbstractC0185ch {
    public final ArrayList b;

    public C0655vd(C0572s5 c0572s5) {
        super(c0572s5);
        String b = c0572s5.b().b();
        b = b == null ? "empty" : b;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String.format("[ModulesEventHandler-%s]", Arrays.copyOf(new Object[]{b}, 1));
        LinkedHashMap a2 = Ga.j().n().a(b);
        ArrayList arrayList = new ArrayList(a2.size());
        for (Map.Entry entry : a2.entrySet()) {
            arrayList.add(TuplesKt.to(entry.getValue(), new C0431md(c0572s5, (String) entry.getKey())));
        }
        this.b = arrayList;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0185ch
    public final boolean a(C0325i6 c0325i6) {
        ArrayList arrayList = this.b;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            C0431md c0431md = (C0431md) pair.component2();
            if (((ModuleServiceEventHandler) pair.component1()).handle(new C0506pd(c0431md.b, c0431md.f938a, new C0481od(c0431md.c, c0325i6)), c0325i6)) {
                return true;
            }
        }
        return false;
    }
}
