package ru.rustore.sdk.metrics.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes6.dex */
public final class H extends Lambda implements Function0<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List<J> f1579a;
    public final /* synthetic */ int b = 10;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(List list) {
        super(0);
        this.f1579a = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        List<J> list = this.f1579a;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (J j : list) {
            arrayList.add(new C0832u(j.f1583a));
        }
        return "Getting first " + this.b + " from storage: " + arrayList;
    }
}
