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
public final class Gd extends AbstractC0304hh {
    public final ArrayList b;

    public Gd(C0447n5 c0447n5) {
        super(c0447n5);
        String b = c0447n5.a().b();
        b = b == null ? "empty" : b;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String.format("[ModulesEventHandler-%s]", Arrays.copyOf(new Object[]{b}, 1));
        LinkedHashMap a2 = Na.k().o().a(b);
        ArrayList arrayList = new ArrayList(a2.size());
        for (Map.Entry entry : a2.entrySet()) {
            arrayList.add(TuplesKt.to(entry.getValue(), new C0610td(c0447n5, (String) entry.getKey())));
        }
        this.b = arrayList;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0304hh
    public final boolean a(C0241f6 c0241f6) {
        if (this.f1019a.t.c()) {
            ArrayList arrayList = this.b;
            if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    C0610td c0610td = (C0610td) pair.component2();
                    if (((ModuleServiceEventHandler) pair.component1()).handle(new C0688wd(c0610td.b, c0610td.f1217a, new C0662vd(c0610td.e, c0610td.d, c0610td.c, c0241f6)), c0241f6)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
