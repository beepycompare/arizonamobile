package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.l1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0396l1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f932a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C0496p1 c;

    public RunnableC0396l1(C0496p1 c0496p1, String str, List list) {
        this.c = c0496p1;
        this.f932a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0496p1.a(this.c).reportEvent(this.f932a, CollectionUtils.getMapFromList(this.b));
    }
}
