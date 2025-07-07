package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.l1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0402l1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f915a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C0502p1 c;

    public RunnableC0402l1(C0502p1 c0502p1, String str, List list) {
        this.c = c0502p1;
        this.f915a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0502p1.a(this.c).reportEvent(this.f915a, CollectionUtils.getMapFromList(this.b));
    }
}
