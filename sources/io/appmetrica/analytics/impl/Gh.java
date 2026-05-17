package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class Gh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f603a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C0278gi c;

    public Gh(C0278gi c0278gi, String str, List list) {
        this.c = c0278gi;
        this.f603a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.c;
        C0278gi.a(c0278gi.f1020a, c0278gi.d, c0278gi.e).reportEvent(this.f603a, CollectionUtils.getMapFromList(this.b));
    }
}
