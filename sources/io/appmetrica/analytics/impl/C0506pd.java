package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.pd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0506pd {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashSet f1011a = new LinkedHashSet();

    public final synchronized Set a() {
        ArrayList arrayList;
        LinkedHashSet<InterfaceC0481od> linkedHashSet = this.f1011a;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(linkedHashSet, 10));
        for (InterfaceC0481od interfaceC0481od : linkedHashSet) {
            arrayList2.add(interfaceC0481od.a());
        }
        arrayList = new ArrayList();
        for (Object obj : arrayList2) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final synchronized void a(InterfaceC0481od... interfaceC0481odArr) {
        CollectionsKt.addAll(this.f1011a, interfaceC0481odArr);
    }
}
