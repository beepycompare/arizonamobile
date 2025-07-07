package com.arkivanov.decompose.router.children;

import androidx.core.app.NotificationCompat;
import com.arkivanov.decompose.router.children.ChildNavState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SimpleChildNavState.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000e\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0004\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/arkivanov/decompose/router/children/SimpleChildNavState;", "C", "", "Lcom/arkivanov/decompose/router/children/ChildNavState;", "configuration", NotificationCompat.CATEGORY_STATUS, "Lcom/arkivanov/decompose/router/children/ChildNavState$Status;", "<init>", "(Ljava/lang/Object;Lcom/arkivanov/decompose/router/children/ChildNavState$Status;)V", "getConfiguration", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStatus", "()Lcom/arkivanov/decompose/router/children/ChildNavState$Status;", "component1", "component2", "copy", "(Ljava/lang/Object;Lcom/arkivanov/decompose/router/children/ChildNavState$Status;)Lcom/arkivanov/decompose/router/children/SimpleChildNavState;", "equals", "", "other", "hashCode", "", "toString", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SimpleChildNavState<C> implements ChildNavState<C> {
    private final C configuration;
    private final ChildNavState.Status status;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SimpleChildNavState copy$default(SimpleChildNavState simpleChildNavState, Object obj, ChildNavState.Status status, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = simpleChildNavState.configuration;
        }
        if ((i & 2) != 0) {
            status = simpleChildNavState.status;
        }
        return simpleChildNavState.copy(obj, status);
    }

    public final C component1() {
        return this.configuration;
    }

    public final ChildNavState.Status component2() {
        return this.status;
    }

    public final SimpleChildNavState<C> copy(C configuration, ChildNavState.Status status) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(status, "status");
        return new SimpleChildNavState<>(configuration, status);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleChildNavState) {
            SimpleChildNavState simpleChildNavState = (SimpleChildNavState) obj;
            return Intrinsics.areEqual(this.configuration, simpleChildNavState.configuration) && this.status == simpleChildNavState.status;
        }
        return false;
    }

    public int hashCode() {
        return (this.configuration.hashCode() * 31) + this.status.hashCode();
    }

    public String toString() {
        return "SimpleChildNavState(configuration=" + this.configuration + ", status=" + this.status + ')';
    }

    public SimpleChildNavState(C configuration, ChildNavState.Status status) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(status, "status");
        this.configuration = configuration;
        this.status = status;
    }

    @Override // com.arkivanov.decompose.router.children.ChildNavState
    public C getConfiguration() {
        return this.configuration;
    }

    @Override // com.arkivanov.decompose.router.children.ChildNavState
    public ChildNavState.Status getStatus() {
        return this.status;
    }
}
