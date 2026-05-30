package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ai  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0125ai implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f889a;
    public final /* synthetic */ List b;
    public final /* synthetic */ Ai c;

    public RunnableC0125ai(Ai ai, String str, List list) {
        this.c = ai;
        this.f889a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.c;
        Ai.a(ai.f461a, ai.d, ai.e).reportEvent(this.f889a, CollectionUtils.getMapFromList(this.b));
    }
}
