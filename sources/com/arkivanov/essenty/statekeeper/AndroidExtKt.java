package com.arkivanov.essenty.statekeeper;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidExt.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u001a0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u001a$\u0010\u000b\u001a\u00020\u0003*\u00020\f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u001a,\u0010\u000b\u001a\u00020\u0003*\u00020\f2\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"KEY_STATE", "", "StateKeeper", "Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "discardSavedState", "", "isSavingAllowed", "Lkotlin/Function0;", "key", "stateKeeper", "Landroidx/savedstate/SavedStateRegistryOwner;", "state-keeper_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidExtKt {
    private static final String KEY_STATE = "STATE_KEEPER_STATE";

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean StateKeeper$lambda$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean StateKeeper$lambda$1() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean stateKeeper$lambda$5() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean stateKeeper$lambda$6() {
        return true;
    }

    public static /* synthetic */ StateKeeper StateKeeper$default(SavedStateRegistry savedStateRegistry, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function0 = new Function0() { // from class: com.arkivanov.essenty.statekeeper.AndroidExtKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean StateKeeper$lambda$0;
                    StateKeeper$lambda$0 = AndroidExtKt.StateKeeper$lambda$0();
                    return Boolean.valueOf(StateKeeper$lambda$0);
                }
            };
        }
        return StateKeeper(savedStateRegistry, z, function0);
    }

    public static final StateKeeper StateKeeper(SavedStateRegistry savedStateRegistry, boolean z, Function0<Boolean> isSavingAllowed) {
        Intrinsics.checkNotNullParameter(savedStateRegistry, "savedStateRegistry");
        Intrinsics.checkNotNullParameter(isSavingAllowed, "isSavingAllowed");
        return StateKeeper(savedStateRegistry, KEY_STATE, z, isSavingAllowed);
    }

    public static /* synthetic */ StateKeeper StateKeeper$default(SavedStateRegistry savedStateRegistry, String str, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            function0 = new Function0() { // from class: com.arkivanov.essenty.statekeeper.AndroidExtKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean StateKeeper$lambda$1;
                    StateKeeper$lambda$1 = AndroidExtKt.StateKeeper$lambda$1();
                    return Boolean.valueOf(StateKeeper$lambda$1);
                }
            };
        }
        return StateKeeper(savedStateRegistry, str, z, function0);
    }

    public static final StateKeeper StateKeeper(SavedStateRegistry savedStateRegistry, String key, boolean z, final Function0<Boolean> isSavingAllowed) {
        SerializableContainer serializableContainer;
        Intrinsics.checkNotNullParameter(savedStateRegistry, "savedStateRegistry");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(isSavingAllowed, "isSavingAllowed");
        Bundle consumeRestoredStateForKey = savedStateRegistry.consumeRestoredStateForKey(key);
        SerializableContainer serializableContainer2 = null;
        if (consumeRestoredStateForKey != null && (serializableContainer = BundleExtKt.getSerializableContainer(consumeRestoredStateForKey, KEY_STATE)) != null && !z) {
            serializableContainer2 = serializableContainer;
        }
        final StateKeeperDispatcher StateKeeperDispatcher = StateKeeperDispatcherKt.StateKeeperDispatcher(serializableContainer2);
        savedStateRegistry.registerSavedStateProvider(key, new SavedStateRegistry.SavedStateProvider() { // from class: com.arkivanov.essenty.statekeeper.AndroidExtKt$$ExternalSyntheticLambda1
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle saveState() {
                Bundle StateKeeper$lambda$4;
                StateKeeper$lambda$4 = AndroidExtKt.StateKeeper$lambda$4(Function0.this, StateKeeperDispatcher);
                return StateKeeper$lambda$4;
            }
        });
        return StateKeeperDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle StateKeeper$lambda$4(Function0 function0, StateKeeperDispatcher stateKeeperDispatcher) {
        Bundle bundle = new Bundle();
        if (((Boolean) function0.invoke()).booleanValue()) {
            BundleExtKt.putSerializableContainer(bundle, KEY_STATE, stateKeeperDispatcher.save());
        }
        return bundle;
    }

    public static /* synthetic */ StateKeeper stateKeeper$default(SavedStateRegistryOwner savedStateRegistryOwner, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: com.arkivanov.essenty.statekeeper.AndroidExtKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean stateKeeper$lambda$5;
                    stateKeeper$lambda$5 = AndroidExtKt.stateKeeper$lambda$5();
                    return Boolean.valueOf(stateKeeper$lambda$5);
                }
            };
        }
        return stateKeeper(savedStateRegistryOwner, z, function0);
    }

    public static final StateKeeper stateKeeper(SavedStateRegistryOwner savedStateRegistryOwner, boolean z, Function0<Boolean> isSavingAllowed) {
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "<this>");
        Intrinsics.checkNotNullParameter(isSavingAllowed, "isSavingAllowed");
        return stateKeeper(savedStateRegistryOwner, KEY_STATE, z, isSavingAllowed);
    }

    public static /* synthetic */ StateKeeper stateKeeper$default(SavedStateRegistryOwner savedStateRegistryOwner, String str, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function0 = new Function0() { // from class: com.arkivanov.essenty.statekeeper.AndroidExtKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean stateKeeper$lambda$6;
                    stateKeeper$lambda$6 = AndroidExtKt.stateKeeper$lambda$6();
                    return Boolean.valueOf(stateKeeper$lambda$6);
                }
            };
        }
        return stateKeeper(savedStateRegistryOwner, str, z, function0);
    }

    public static final StateKeeper stateKeeper(SavedStateRegistryOwner savedStateRegistryOwner, String key, boolean z, Function0<Boolean> isSavingAllowed) {
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(isSavingAllowed, "isSavingAllowed");
        return StateKeeper(savedStateRegistryOwner.getSavedStateRegistry(), key, z, isSavingAllowed);
    }
}
