package com.arkivanov.decompose.router.stack;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.GettingList;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ChildStack.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0001\u0010\u0003 \u0001*\u00020\u00022\u00020\u0002B7\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0007¢\u0006\u0004\b\b\u0010\tB!\b\u0017\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\u0006\u0010\u000b\u001a\u00028\u0001\u0012\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\rB\u0019\b\u0016\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\u0006\u0010\u000b\u001a\u00028\u0001¢\u0006\u0004\b\b\u0010\u000eJ\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005HÆ\u0003J\u001b\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0007HÆ\u0003JG\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/arkivanov/decompose/router/stack/ChildStack;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "Lcom/arkivanov/decompose/Child$Created;", "backStack", "", "<init>", "(Lcom/arkivanov/decompose/Child$Created;Ljava/util/List;)V", "configuration", "instance", "key", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getActive", "()Lcom/arkivanov/decompose/Child$Created;", "getBackStack", "()Ljava/util/List;", FirebaseAnalytics.Param.ITEMS, "getItems", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChildStack<C, T> {
    private final Child.Created<C, T> active;
    private final List<Child.Created<C, T>> backStack;
    private final List<Child.Created<C, T>> items;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChildStack copy$default(ChildStack childStack, Child.Created created, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            created = childStack.active;
        }
        if ((i & 2) != 0) {
            list = childStack.backStack;
        }
        return childStack.copy(created, list);
    }

    public final Child.Created<C, T> component1() {
        return this.active;
    }

    public final List<Child.Created<C, T>> component2() {
        return this.backStack;
    }

    public final ChildStack<C, T> copy(Child.Created<? extends C, ? extends T> active, List<? extends Child.Created<? extends C, ? extends T>> backStack) {
        Intrinsics.checkNotNullParameter(active, "active");
        Intrinsics.checkNotNullParameter(backStack, "backStack");
        return new ChildStack<>((Child.Created) active, (List) backStack);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChildStack) {
            ChildStack childStack = (ChildStack) obj;
            return Intrinsics.areEqual(this.active, childStack.active) && Intrinsics.areEqual(this.backStack, childStack.backStack);
        }
        return false;
    }

    public int hashCode() {
        return (this.active.hashCode() * 31) + this.backStack.hashCode();
    }

    public String toString() {
        return "ChildStack(active=" + this.active + ", backStack=" + this.backStack + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChildStack(Child.Created<? extends C, ? extends T> active, List<? extends Child.Created<? extends C, ? extends T>> backStack) {
        Intrinsics.checkNotNullParameter(active, "active");
        Intrinsics.checkNotNullParameter(backStack, "backStack");
        this.active = active;
        this.backStack = backStack;
        this.items = new GettingList(backStack.size() + 1, new Function1() { // from class: com.arkivanov.decompose.router.stack.ChildStack$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Child.Created items$lambda$0;
                items$lambda$0 = ChildStack.items$lambda$0(ChildStack.this, ((Integer) obj).intValue());
                return items$lambda$0;
            }
        });
    }

    public final Child.Created<C, T> getActive() {
        return this.active;
    }

    public /* synthetic */ ChildStack(Child.Created created, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(created, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Child.Created<C, T>> getBackStack() {
        return this.backStack;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChildStack(C configuration, T instance, Object key) {
        this(new Child.Created(configuration, instance, key), null, 2, null);
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(key, "key");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChildStack(C configuration, T instance) {
        this(configuration, instance, configuration);
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    public final List<Child.Created<C, T>> getItems() {
        return this.items;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Child.Created items$lambda$0(ChildStack childStack, int i) {
        Child.Created created = (Child.Created) CollectionsKt.getOrNull(childStack.backStack, i);
        return created == null ? childStack.active : created;
    }
}
