package com.arkivanov.decompose;

import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.arkivanov.essenty.backhandler.AndroidBackHandlerKt;
import com.arkivanov.essenty.backhandler.BackHandler;
import com.arkivanov.essenty.lifecycle.AndroidExtKt;
import com.arkivanov.essenty.statekeeper.StateKeeper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
/* compiled from: DefaultComponentContextBuilder.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a2\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u001a?\u0010\n\u001a\u00020\u0001\"\u0014\b\u0000\u0010\u000b*\u00020\f*\u00020\r*\u00020\u000e*\u00020\u000f*\u0002H\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0010\u0014\u001a.\u0010\n\u001a\u00020\u0001*\u00020\u00152\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013\u001aC\u0010\n\u001a\u00020\u0001\"\u0010\b\u0000\u0010\u000b*\u00020\f*\u00020\u000e*\u00020\u000f*\u0002H\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013H\u0002¢\u0006\u0002\u0010\u0018\"\u000e\u0010\u0019\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"DefaultComponentContext", "Lcom/arkivanov/decompose/DefaultComponentContext;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "defaultComponentContext", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/savedstate/SavedStateRegistryOwner;", "Landroidx/activity/OnBackPressedDispatcherOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/LifecycleOwner;", "discardSavedState", "", "isStateSavingAllowed", "Lkotlin/Function0;", "(Landroidx/savedstate/SavedStateRegistryOwner;ZLkotlin/jvm/functions/Function0;)Lcom/arkivanov/decompose/DefaultComponentContext;", "Landroidx/fragment/app/Fragment;", "backHandler", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "(Landroidx/savedstate/SavedStateRegistryOwner;Lcom/arkivanov/essenty/backhandler/BackHandler;ZLkotlin/jvm/functions/Function0;)Lcom/arkivanov/decompose/DefaultComponentContext;", "KEY_STATE_MARKER", "", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultComponentContextBuilderKt {
    private static final String KEY_STATE_MARKER = "DefaultComponentContext_state_marker";

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean defaultComponentContext$lambda$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean defaultComponentContext$lambda$1() {
        return true;
    }

    public static /* synthetic */ DefaultComponentContext DefaultComponentContext$default(Lifecycle lifecycle, SavedStateRegistry savedStateRegistry, ViewModelStore viewModelStore, OnBackPressedDispatcher onBackPressedDispatcher, int i, Object obj) {
        if ((i & 2) != 0) {
            savedStateRegistry = null;
        }
        if ((i & 4) != 0) {
            viewModelStore = null;
        }
        if ((i & 8) != 0) {
            onBackPressedDispatcher = null;
        }
        return DefaultComponentContext(lifecycle, savedStateRegistry, viewModelStore, onBackPressedDispatcher);
    }

    public static final DefaultComponentContext DefaultComponentContext(Lifecycle lifecycle, SavedStateRegistry savedStateRegistry, ViewModelStore viewModelStore, OnBackPressedDispatcher onBackPressedDispatcher) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        return new DefaultComponentContext(AndroidExtKt.asEssentyLifecycle(lifecycle), savedStateRegistry != null ? com.arkivanov.essenty.statekeeper.AndroidExtKt.StateKeeper$default(savedStateRegistry, false, null, 6, null) : null, viewModelStore != null ? com.arkivanov.essenty.instancekeeper.AndroidExtKt.InstanceKeeper$default(viewModelStore, false, 2, null) : null, onBackPressedDispatcher != null ? AndroidBackHandlerKt.BackHandler(onBackPressedDispatcher) : null);
    }

    public static /* synthetic */ DefaultComponentContext defaultComponentContext$default(SavedStateRegistryOwner savedStateRegistryOwner, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: com.arkivanov.decompose.DefaultComponentContextBuilderKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean defaultComponentContext$lambda$0;
                    defaultComponentContext$lambda$0 = DefaultComponentContextBuilderKt.defaultComponentContext$lambda$0();
                    return Boolean.valueOf(defaultComponentContext$lambda$0);
                }
            };
        }
        return defaultComponentContext(savedStateRegistryOwner, z, function0);
    }

    public static final <T extends SavedStateRegistryOwner & OnBackPressedDispatcherOwner & ViewModelStoreOwner & LifecycleOwner> DefaultComponentContext defaultComponentContext(T t, boolean z, Function0<Boolean> isStateSavingAllowed) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(isStateSavingAllowed, "isStateSavingAllowed");
        return defaultComponentContext(t, AndroidBackHandlerKt.BackHandler(t.getOnBackPressedDispatcher()), z, isStateSavingAllowed);
    }

    public static /* synthetic */ DefaultComponentContext defaultComponentContext$default(Fragment fragment, OnBackPressedDispatcher onBackPressedDispatcher, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function0 = new Function0() { // from class: com.arkivanov.decompose.DefaultComponentContextBuilderKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean defaultComponentContext$lambda$1;
                    defaultComponentContext$lambda$1 = DefaultComponentContextBuilderKt.defaultComponentContext$lambda$1();
                    return Boolean.valueOf(defaultComponentContext$lambda$1);
                }
            };
        }
        return defaultComponentContext(fragment, onBackPressedDispatcher, z, function0);
    }

    public static final DefaultComponentContext defaultComponentContext(Fragment fragment, OnBackPressedDispatcher onBackPressedDispatcher, boolean z, Function0<Boolean> isStateSavingAllowed) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(isStateSavingAllowed, "isStateSavingAllowed");
        return defaultComponentContext(fragment, onBackPressedDispatcher != null ? AndroidBackHandlerKt.BackHandler(onBackPressedDispatcher, fragment) : null, z, isStateSavingAllowed);
    }

    private static final <T extends SavedStateRegistryOwner & ViewModelStoreOwner & LifecycleOwner> DefaultComponentContext defaultComponentContext(T t, BackHandler backHandler, boolean z, Function0<Boolean> function0) {
        StateKeeper stateKeeper = com.arkivanov.essenty.statekeeper.AndroidExtKt.stateKeeper(t, z, function0);
        String str = (String) stateKeeper.consume(KEY_STATE_MARKER, BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE));
        stateKeeper.register(KEY_STATE_MARKER, BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE), new Function0() { // from class: com.arkivanov.decompose.DefaultComponentContextBuilderKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String defaultComponentContext$lambda$3;
                defaultComponentContext$lambda$3 = DefaultComponentContextBuilderKt.defaultComponentContext$lambda$3();
                return defaultComponentContext$lambda$3;
            }
        });
        return new DefaultComponentContext(AndroidExtKt.asEssentyLifecycle(t.getLifecycle()), stateKeeper, com.arkivanov.essenty.instancekeeper.AndroidExtKt.instanceKeeper(t, str == null), backHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String defaultComponentContext$lambda$3() {
        return "marker";
    }
}
