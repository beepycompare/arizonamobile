package com.arkivanov.essenty.lifecycle;

import androidx.lifecycle.Lifecycle;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidExt.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0004\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0002¨\u0006\b"}, d2 = {"asEssentyLifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle;", "essentyLifecycle", "Landroidx/lifecycle/LifecycleOwner;", "toEssentyLifecycleState", "Lcom/arkivanov/essenty/lifecycle/Lifecycle$State;", "Landroidx/lifecycle/Lifecycle$State;", "lifecycle_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidExtKt {

    /* compiled from: AndroidExt.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.State.values().length];
            try {
                iArr[Lifecycle.State.DESTROYED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.State.INITIALIZED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.State.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.State.STARTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle.State.RESUMED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Lifecycle asEssentyLifecycle(androidx.lifecycle.Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(lifecycle, "<this>");
        return new EssentyLifecycleInterop(lifecycle);
    }

    public static final Lifecycle essentyLifecycle(androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        return asEssentyLifecycle(lifecycleOwner.getLifecycle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Lifecycle.State toEssentyLifecycleState(Lifecycle.State state) {
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            throw new NoWhenBranchMatchedException();
                        }
                        return Lifecycle.State.RESUMED;
                    }
                    return Lifecycle.State.STARTED;
                }
                return Lifecycle.State.CREATED;
            }
            return Lifecycle.State.INITIALIZED;
        }
        return Lifecycle.State.DESTROYED;
    }
}
