package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class U {

    /* renamed from: a  reason: collision with root package name */
    public final C0617tn f660a;
    public final List b;
    public final String c;

    public U(C0617tn c0617tn, ArrayList arrayList, String str) {
        this.f660a = c0617tn;
        this.b = arrayList == null ? Collections.emptyList() : CollectionUtils.unmodifiableListCopy(arrayList);
        this.c = str;
    }
}
