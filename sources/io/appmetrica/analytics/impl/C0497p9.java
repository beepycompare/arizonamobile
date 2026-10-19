package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.p9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0497p9 extends AbstractC0523q9 {

    /* renamed from: a  reason: collision with root package name */
    public final List f1150a;

    public C0497p9(List<Object> list) {
        this.f1150a = CollectionUtils.unmodifiableListCopy(list);
    }

    public final List<Object> a() {
        return this.f1150a;
    }
}
