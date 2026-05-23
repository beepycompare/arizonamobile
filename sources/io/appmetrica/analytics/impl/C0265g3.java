package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
/* renamed from: io.appmetrica.analytics.impl.g3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0265g3 implements IBinaryDataHelper {

    /* renamed from: a  reason: collision with root package name */
    public final IBinaryDataHelper f990a;

    public C0265g3(IBinaryDataHelper iBinaryDataHelper) {
        this.f990a = iBinaryDataHelper;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper
    public final byte[] get(String str) {
        return this.f990a.get(str);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper
    public final void insert(String str, byte[] bArr) {
        this.f990a.insert(str, bArr);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper
    public final void remove(String str) {
        this.f990a.remove(str);
    }
}
