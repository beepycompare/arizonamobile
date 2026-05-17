package ru.rustore.sdk.appupdate;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public final b0 f1532a;
    public final c0 b;
    public final d0 c;

    public a0(b0 sdkNameDataSource, c0 sdkTypeDataSource, d0 sdkVersionDataSource) {
        Intrinsics.checkNotNullParameter(sdkNameDataSource, "sdkNameDataSource");
        Intrinsics.checkNotNullParameter(sdkTypeDataSource, "sdkTypeDataSource");
        Intrinsics.checkNotNullParameter(sdkVersionDataSource, "sdkVersionDataSource");
        this.f1532a = sdkNameDataSource;
        this.b = sdkTypeDataSource;
        this.c = sdkVersionDataSource;
    }
}
