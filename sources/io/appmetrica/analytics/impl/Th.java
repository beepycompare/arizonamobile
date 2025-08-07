package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* loaded from: classes4.dex */
public final class Th implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f655a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C0613ti c;

    public Th(C0613ti c0613ti, String str, List list) {
        this.c = c0613ti;
        this.f655a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0613ti c0613ti = this.c;
        C0613ti.a(c0613ti.f1068a, c0613ti.d, c0613ti.e).reportEvent(this.f655a, CollectionUtils.getMapFromList(this.b));
    }
}
