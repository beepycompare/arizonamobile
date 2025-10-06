package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
/* renamed from: io.appmetrica.analytics.impl.s3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0575s3 implements IBinaryDataHelper {

    /* renamed from: a  reason: collision with root package name */
    public final IBinaryDataHelper f1077a;

    public C0575s3(IBinaryDataHelper iBinaryDataHelper) {
        this.f1077a = iBinaryDataHelper;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper
    public final byte[] get(String str) {
        return this.f1077a.get(str);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper
    public final void insert(String str, byte[] bArr) {
        this.f1077a.insert(str, bArr);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper
    public final void remove(String str) {
        this.f1077a.remove(str);
    }
}
