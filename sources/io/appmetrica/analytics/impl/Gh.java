package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class Gh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f599a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C0279gi c;

    public Gh(C0279gi c0279gi, String str, List list) {
        this.c = c0279gi;
        this.f599a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0279gi c0279gi = this.c;
        C0279gi.a(c0279gi.f1016a, c0279gi.d, c0279gi.e).reportEvent(this.f599a, CollectionUtils.getMapFromList(this.b));
    }
}
