package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ci  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0179ci implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f826a;
    public final /* synthetic */ List b;
    public final /* synthetic */ Ci c;

    public RunnableC0179ci(Ci ci, String str, List list) {
        this.c = ci;
        this.f826a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.c;
        Ci.a(ci.f392a, ci.d, ci.e).reportEvent(this.f826a, CollectionUtils.getMapFromList(this.b));
    }
}
