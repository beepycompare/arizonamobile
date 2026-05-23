package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.BiFunction;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
/* renamed from: io.appmetrica.analytics.impl.go  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0286go {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0260fo f1002a;
    public final BiFunction b;
    public final InterfaceC0201dg c;

    public C0286go() {
        this(new Cdo(), new Ia(), C0576s4.l().n());
    }

    public final ArrayList a(Thread thread, Thread thread2) {
        Map map;
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new C0234eo());
        try {
            map = this.f1002a.c();
        } catch (SecurityException unused) {
            map = null;
        }
        if (map != null) {
            treeMap.putAll(map);
        }
        if (thread2 != null) {
            treeMap.remove(thread2);
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            Thread thread3 = (Thread) entry.getKey();
            if (thread3 != thread && thread3 != thread2) {
                arrayList.add((Zn) this.b.apply(thread3, (StackTraceElement[]) entry.getValue()));
            }
        }
        return arrayList;
    }

    public C0286go(InterfaceC0260fo interfaceC0260fo, Ia ia, J6 j6) {
        this.f1002a = interfaceC0260fo;
        this.b = ia;
        this.c = j6;
    }
}
