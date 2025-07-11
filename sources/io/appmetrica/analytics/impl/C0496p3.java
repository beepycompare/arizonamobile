package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
/* renamed from: io.appmetrica.analytics.impl.p3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0496p3 implements IBinaryDataHelper {

    /* renamed from: a  reason: collision with root package name */
    public final IBinaryDataHelper f985a;

    public C0496p3(IBinaryDataHelper iBinaryDataHelper) {
        this.f985a = iBinaryDataHelper;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper
    public final byte[] get(String str) {
        return this.f985a.get(str);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper
    public final void insert(String str, byte[] bArr) {
        this.f985a.insert(str, bArr);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper
    public final void remove(String str) {
        this.f985a.remove(str);
    }
}
