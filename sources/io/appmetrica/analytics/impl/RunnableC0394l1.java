package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.l1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0394l1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f916a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C0494p1 c;

    public RunnableC0394l1(C0494p1 c0494p1, String str, List list) {
        this.c = c0494p1;
        this.f916a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0494p1.a(this.c).reportEvent(this.f916a, CollectionUtils.getMapFromList(this.b));
    }
}
