package com.arkivanov.decompose.router.stack;

import com.arkivanov.decompose.router.children.ChildNavState;
import com.arkivanov.decompose.router.children.NavState;
import com.arkivanov.decompose.router.children.SimpleChildNavState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChildStackFactory.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/arkivanov/decompose/router/stack/StackNavState;", "C", "", "Lcom/arkivanov/decompose/router/children/NavState;", "configurations", "", "<init>", "(Ljava/util/List;)V", "getConfigurations", "()Ljava/util/List;", "children", "Lcom/arkivanov/decompose/router/children/SimpleChildNavState;", "getChildren", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StackNavState<C> implements NavState<C> {
    private final List<SimpleChildNavState<C>> children;
    private final List<C> configurations;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StackNavState copy$default(StackNavState stackNavState, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = stackNavState.configurations;
        }
        return stackNavState.copy(list);
    }

    public final List<C> component1() {
        return this.configurations;
    }

    public final StackNavState<C> copy(List<? extends C> configurations) {
        Intrinsics.checkNotNullParameter(configurations, "configurations");
        return new StackNavState<>(configurations);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StackNavState) && Intrinsics.areEqual(this.configurations, ((StackNavState) obj).configurations);
    }

    public int hashCode() {
        return this.configurations.hashCode();
    }

    public String toString() {
        return "StackNavState(configurations=" + this.configurations + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StackNavState(List<? extends C> configurations) {
        Intrinsics.checkNotNullParameter(configurations, "configurations");
        this.configurations = configurations;
        if (configurations.isEmpty()) {
            throw new IllegalArgumentException("Configuration stack must not be empty".toString());
        }
        List<? extends C> list = configurations;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new SimpleChildNavState(obj, i == CollectionsKt.getLastIndex(this.configurations) ? ChildNavState.Status.RESUMED : ChildNavState.Status.CREATED));
            i = i2;
        }
        this.children = arrayList;
    }

    public final List<C> getConfigurations() {
        return this.configurations;
    }

    @Override // com.arkivanov.decompose.router.children.NavState
    public List<SimpleChildNavState<C>> getChildren() {
        return this.children;
    }
}
