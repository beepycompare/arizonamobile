package ru.rustore.sdk.metrics.internal;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class S {

    /* renamed from: a  reason: collision with root package name */
    public final b0 f1429a;
    public final C b;
    public final O c;
    public final e0 d;

    public S(b0 userIdDataSource, C packageNameDataSource, O remoteMetricsEventDataSource, e0 versionNameDataSource) {
        Intrinsics.checkNotNullParameter(userIdDataSource, "userIdDataSource");
        Intrinsics.checkNotNullParameter(packageNameDataSource, "packageNameDataSource");
        Intrinsics.checkNotNullParameter(remoteMetricsEventDataSource, "remoteMetricsEventDataSource");
        Intrinsics.checkNotNullParameter(versionNameDataSource, "versionNameDataSource");
        this.f1429a = userIdDataSource;
        this.b = packageNameDataSource;
        this.c = remoteMetricsEventDataSource;
        this.d = versionNameDataSource;
    }
}
