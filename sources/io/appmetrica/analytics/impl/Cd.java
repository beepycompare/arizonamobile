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
/* loaded from: classes4.dex */
public final class Cd extends AbstractC0463nh {
    public final ArrayList b;

    public Cd(C0652v5 c0652v5) {
        super(c0652v5);
        String b = c0652v5.b().b();
        b = b == null ? "empty" : b;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String.format("[ModulesEventHandler-%s]", Arrays.copyOf(new Object[]{b}, 1));
        LinkedHashMap a2 = Na.j().n().a(b);
        ArrayList arrayList = new ArrayList(a2.size());
        for (Map.Entry entry : a2.entrySet()) {
            arrayList.add(TuplesKt.to(entry.getValue(), new C0610td(c0652v5, (String) entry.getKey())));
        }
        this.b = arrayList;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0463nh
    public final boolean a(C0478o6 c0478o6) {
        if (this.f1006a.t.c()) {
            ArrayList arrayList = this.b;
            if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    C0610td c0610td = (C0610td) pair.component2();
                    if (((ModuleServiceEventHandler) pair.component1()).handle(new C0685wd(c0610td.b, c0610td.f1095a, new C0660vd(c0610td.d, c0610td.c, c0478o6)), c0478o6)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
