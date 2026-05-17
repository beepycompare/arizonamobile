package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class V {

    /* renamed from: a  reason: collision with root package name */
    public final C0685wn f822a;
    public final List b;
    public final String c;

    public V(C0685wn c0685wn, ArrayList arrayList, String str) {
        this.f822a = c0685wn;
        this.b = arrayList == null ? Collections.emptyList() : CollectionUtils.unmodifiableListCopy(arrayList);
        this.c = str;
    }
}
