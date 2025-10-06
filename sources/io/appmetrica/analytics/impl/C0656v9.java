package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.v9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0656v9 extends AbstractC0681w9 {

    /* renamed from: a  reason: collision with root package name */
    public final List f1123a;

    public C0656v9(List<Object> list) {
        this.f1123a = CollectionUtils.unmodifiableListCopy(list);
    }

    public final List<Object> a() {
        return this.f1123a;
    }
}
