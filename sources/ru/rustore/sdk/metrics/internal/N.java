package ru.rustore.sdk.metrics.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.metrics.internal.X;
/* loaded from: classes6.dex */
public final class N {

    /* renamed from: a  reason: collision with root package name */
    public final I f1564a;
    public final K b;
    public final L c;
    public final InterfaceC0832g d;

    public N(I persistentMetricsEventDataSource, K persistentMetricsEventDtoFactory, L persistentMetricsEventMapper, X.b logger) {
        Intrinsics.checkNotNullParameter(persistentMetricsEventDataSource, "persistentMetricsEventDataSource");
        Intrinsics.checkNotNullParameter(persistentMetricsEventDtoFactory, "persistentMetricsEventDtoFactory");
        Intrinsics.checkNotNullParameter(persistentMetricsEventMapper, "persistentMetricsEventMapper");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f1564a = persistentMetricsEventDataSource;
        this.b = persistentMetricsEventDtoFactory;
        this.c = persistentMetricsEventMapper;
        this.d = logger;
    }

    public final void a(List<D> persistentMetricsEvents) {
        Intrinsics.checkNotNullParameter(persistentMetricsEvents, "persistentMetricsEvents");
        I i = this.f1564a;
        L l = this.c;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(persistentMetricsEvents, 10));
        for (D d : persistentMetricsEvents) {
            arrayList.add(l.a(d));
        }
        i.a(arrayList);
    }
}
