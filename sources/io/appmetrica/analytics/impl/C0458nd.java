package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.nd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0458nd {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashSet f969a = new LinkedHashSet();

    public final synchronized Set a() {
        ArrayList arrayList;
        LinkedHashSet<InterfaceC0433md> linkedHashSet = this.f969a;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(linkedHashSet, 10));
        for (InterfaceC0433md interfaceC0433md : linkedHashSet) {
            arrayList2.add(interfaceC0433md.a());
        }
        arrayList = new ArrayList();
        for (Object obj : arrayList2) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final synchronized void a(InterfaceC0433md... interfaceC0433mdArr) {
        CollectionsKt.addAll(this.f969a, interfaceC0433mdArr);
    }
}
