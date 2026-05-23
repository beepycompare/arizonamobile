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
/* loaded from: classes5.dex */
public final class Gd extends AbstractC0305hh {
    public final ArrayList b;

    public Gd(C0448n5 c0448n5) {
        super(c0448n5);
        String b = c0448n5.a().b();
        b = b == null ? "empty" : b;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String.format("[ModulesEventHandler-%s]", Arrays.copyOf(new Object[]{b}, 1));
        LinkedHashMap a2 = Na.k().o().a(b);
        ArrayList arrayList = new ArrayList(a2.size());
        for (Map.Entry entry : a2.entrySet()) {
            arrayList.add(TuplesKt.to(entry.getValue(), new C0611td(c0448n5, (String) entry.getKey())));
        }
        this.b = arrayList;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0305hh
    public final boolean a(C0242f6 c0242f6) {
        if (this.f1016a.t.c()) {
            ArrayList arrayList = this.b;
            if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    C0611td c0611td = (C0611td) pair.component2();
                    if (((ModuleServiceEventHandler) pair.component1()).handle(new C0689wd(c0611td.b, c0611td.f1214a, new C0663vd(c0611td.e, c0611td.d, c0611td.c, c0242f6)), c0242f6)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
