package com.arkivanov.decompose.router.slot;

import com.arkivanov.decompose.router.children.ChildNavState;
import com.arkivanov.decompose.router.children.NavState;
import com.arkivanov.decompose.router.children.SimpleChildNavState;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChildSlotFactory.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000f\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\bJ \u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR \u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/arkivanov/decompose/router/slot/SlotNavState;", "C", "", "Lcom/arkivanov/decompose/router/children/NavState;", "configuration", "<init>", "(Ljava/lang/Object;)V", "getConfiguration", "()Ljava/lang/Object;", "Ljava/lang/Object;", "children", "", "Lcom/arkivanov/decompose/router/children/SimpleChildNavState;", "getChildren", "()Ljava/util/List;", "component1", "copy", "(Ljava/lang/Object;)Lcom/arkivanov/decompose/router/slot/SlotNavState;", "equals", "", "other", "hashCode", "", "toString", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SlotNavState<C> implements NavState<C> {
    private final List<SimpleChildNavState<C>> children;
    private final C configuration;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SlotNavState copy$default(SlotNavState slotNavState, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = slotNavState.configuration;
        }
        return slotNavState.copy(obj);
    }

    public final C component1() {
        return this.configuration;
    }

    public final SlotNavState<C> copy(C c) {
        return new SlotNavState<>(c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SlotNavState) && Intrinsics.areEqual(this.configuration, ((SlotNavState) obj).configuration);
    }

    public int hashCode() {
        C c = this.configuration;
        if (c == null) {
            return 0;
        }
        return c.hashCode();
    }

    public String toString() {
        return "SlotNavState(configuration=" + this.configuration + ')';
    }

    public SlotNavState(C c) {
        List<SimpleChildNavState<C>> listOf;
        this.configuration = c;
        if (c == null) {
            listOf = CollectionsKt.emptyList();
        } else {
            listOf = CollectionsKt.listOf(new SimpleChildNavState(c, ChildNavState.Status.RESUMED));
        }
        this.children = listOf;
    }

    public final C getConfiguration() {
        return this.configuration;
    }

    @Override // com.arkivanov.decompose.router.children.NavState
    public List<SimpleChildNavState<C>> getChildren() {
        return this.children;
    }
}
