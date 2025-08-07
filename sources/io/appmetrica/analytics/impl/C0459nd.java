package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.nd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0459nd {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashSet f968a = new LinkedHashSet();

    public final synchronized Set a() {
        ArrayList arrayList;
        LinkedHashSet<InterfaceC0434md> linkedHashSet = this.f968a;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(linkedHashSet, 10));
        for (InterfaceC0434md interfaceC0434md : linkedHashSet) {
            arrayList2.add(interfaceC0434md.a());
        }
        arrayList = new ArrayList();
        for (Object obj : arrayList2) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final synchronized void a(InterfaceC0434md... interfaceC0434mdArr) {
        CollectionsKt.addAll(this.f968a, interfaceC0434mdArr);
    }
}
