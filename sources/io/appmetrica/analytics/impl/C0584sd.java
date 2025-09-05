package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.sd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0584sd {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashSet f1077a = new LinkedHashSet();

    public final synchronized Set a() {
        ArrayList arrayList;
        LinkedHashSet<InterfaceC0559rd> linkedHashSet = this.f1077a;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(linkedHashSet, 10));
        for (InterfaceC0559rd interfaceC0559rd : linkedHashSet) {
            arrayList2.add(interfaceC0559rd.a());
        }
        arrayList = new ArrayList();
        for (Object obj : arrayList2) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final synchronized void a(InterfaceC0559rd... interfaceC0559rdArr) {
        CollectionsKt.addAll(this.f1077a, interfaceC0559rdArr);
    }
}
