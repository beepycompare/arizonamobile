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
/* renamed from: io.appmetrica.analytics.impl.hd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0295hd extends Sg {
    public final ArrayList b;

    public C0295hd(Y4 y4) {
        super(y4);
        String b = y4.b().b();
        b = b == null ? "empty" : b;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String.format("[ModulesEventHandler-%s]", Arrays.copyOf(new Object[]{b}, 1));
        LinkedHashMap a2 = C0470oa.k().o().a(b);
        ArrayList arrayList = new ArrayList(a2.size());
        for (Map.Entry entry : a2.entrySet()) {
            arrayList.add(TuplesKt.to(entry.getValue(), new Uc(y4, (String) entry.getKey())));
        }
        this.b = arrayList;
    }

    @Override // io.appmetrica.analytics.impl.Sg
    public final boolean a(Q5 q5) {
        if (this.f762a.t.c()) {
            ArrayList arrayList = this.b;
            if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    Uc uc = (Uc) pair.component2();
                    if (((ModuleServiceEventHandler) pair.component1()).handle(new Xc(uc.b, uc.f792a, new Wc(uc.d, uc.c, q5)), q5)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
