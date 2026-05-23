package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class X {

    /* renamed from: a  reason: collision with root package name */
    public final Zn f832a;
    public final List b;
    public final String c;

    public X(Zn zn, ArrayList arrayList, String str) {
        this.f832a = zn;
        this.b = arrayList == null ? Collections.emptyList() : CollectionUtils.unmodifiableListCopy(arrayList);
        this.c = str;
    }
}
