package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ai  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0118ai implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f894a;
    public final /* synthetic */ List b;
    public final /* synthetic */ Ai c;

    public RunnableC0118ai(Ai ai, String str, List list) {
        this.c = ai;
        this.f894a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.c;
        Ai.a(ai.f466a, ai.d, ai.e).reportEvent(this.f894a, CollectionUtils.getMapFromList(this.b));
    }
}
