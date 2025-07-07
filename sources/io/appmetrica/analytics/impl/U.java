package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class U {

    /* renamed from: a  reason: collision with root package name */
    public final C0549qn f648a;
    public final List b;
    public final String c;

    public U(C0549qn c0549qn, ArrayList arrayList, String str) {
        this.f648a = c0549qn;
        this.b = arrayList == null ? Collections.emptyList() : CollectionUtils.unmodifiableListCopy(arrayList);
        this.c = str;
    }
}
