package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.fg  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0247fg implements InterfaceC0144bg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0350jg f878a;

    public C0247fg(C0350jg c0350jg) {
        this.f878a = c0350jg;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0144bg
    public final void a() {
        C0350jg c0350jg = this.f878a;
        ArrayList arrayList = c0350jg.g;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            C0576sg c0576sg = (C0576sg) next;
            c0350jg.c.getClass();
            String str = c0576sg != null ? c0576sg.f1114a : null;
            if (!(str == null || str.length() == 0)) {
                arrayList2.add(next);
            }
        }
        c0350jg.a(c0350jg.c.a(CollectionsKt.filterNotNull(arrayList2)));
    }
}
