package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.ld  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0414ld {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashSet f921a = new LinkedHashSet();

    public final synchronized Set a() {
        ArrayList arrayList;
        LinkedHashSet<InterfaceC0389kd> linkedHashSet = this.f921a;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(linkedHashSet, 10));
        for (InterfaceC0389kd interfaceC0389kd : linkedHashSet) {
            arrayList2.add(interfaceC0389kd.a());
        }
        arrayList = new ArrayList();
        for (Object obj : arrayList2) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final synchronized void a(InterfaceC0389kd... interfaceC0389kdArr) {
        CollectionsKt.addAll(this.f921a, interfaceC0389kdArr);
    }
}
