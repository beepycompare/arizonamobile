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
public final class C0663vd extends AbstractC0193ch {
    public final ArrayList b;

    public C0663vd(C0580s5 c0580s5) {
        super(c0580s5);
        String b = c0580s5.b().b();
        b = b == null ? "empty" : b;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String.format("[ModulesEventHandler-%s]", Arrays.copyOf(new Object[]{b}, 1));
        LinkedHashMap a2 = Ga.j().n().a(b);
        ArrayList arrayList = new ArrayList(a2.size());
        for (Map.Entry entry : a2.entrySet()) {
            arrayList.add(TuplesKt.to(entry.getValue(), new C0439md(c0580s5, (String) entry.getKey())));
        }
        this.b = arrayList;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0193ch
    public final boolean a(C0333i6 c0333i6) {
        ArrayList arrayList = this.b;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            C0439md c0439md = (C0439md) pair.component2();
            if (((ModuleServiceEventHandler) pair.component1()).handle(new C0514pd(c0439md.b, c0439md.f937a, new C0489od(c0439md.c, c0333i6)), c0333i6)) {
                return true;
            }
        }
        return false;
    }
}
