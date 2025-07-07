package com.arkivanov.decompose;

import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import com.arkivanov.essenty.instancekeeper.InstanceKeeper;
import com.arkivanov.essenty.lifecycle.AndroidExtKt;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import com.arkivanov.essenty.lifecycle.LifecycleExtKt;
import com.arkivanov.essenty.lifecycle.LifecycleRegistryExtKt;
import com.arkivanov.essenty.statekeeper.SerializableContainer;
import com.arkivanov.essenty.statekeeper.StateKeeper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
/* compiled from: RetainedComponent.kt */
@Metadata(d1 = {"\u0000F\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aW\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\u00010\u000b¢\u0006\u0002\u0010\r\u001aW\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\u00010\u000b¢\u0006\u0002\u0010\u000f\u001as\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0010\b\u0001\u0010\u0010*\u00020\u0011*\u00020\u0012*\u00020\u0013*\u0002H\u00102\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\u00010\u000bH\u0000¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"retainedComponent", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/activity/ComponentActivity;", "key", "", "handleBackButton", "", "discardSavedState", "isStateSavingAllowed", "Lkotlin/Function0;", "factory", "Lkotlin/Function1;", "Lcom/arkivanov/decompose/ComponentContext;", "(Landroidx/activity/ComponentActivity;Ljava/lang/String;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "O", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/savedstate/SavedStateRegistryOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "isChangingConfigurations", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;Landroidx/activity/OnBackPressedDispatcher;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "KEY_STATE_MARKER", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RetainedComponentKt {
    private static final String KEY_STATE_MARKER = "RetainedComponent_state_marker";

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean retainedComponent$lambda$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean retainedComponent$lambda$1() {
        return true;
    }

    public static /* synthetic */ Object retainedComponent$default(ComponentActivity componentActivity, String str, boolean z, boolean z2, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "RootRetainedComponent";
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        if ((i & 8) != 0) {
            function0 = new Function0() { // from class: com.arkivanov.decompose.RetainedComponentKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean retainedComponent$lambda$0;
                    retainedComponent$lambda$0 = RetainedComponentKt.retainedComponent$lambda$0();
                    return Boolean.valueOf(retainedComponent$lambda$0);
                }
            };
        }
        boolean z3 = z2;
        return retainedComponent(componentActivity, str, z, z3, function0, function1);
    }

    public static final <T> T retainedComponent(ComponentActivity componentActivity, String key, boolean z, boolean z2, Function0<Boolean> isStateSavingAllowed, Function1<? super ComponentContext, ? extends T> factory) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(isStateSavingAllowed, "isStateSavingAllowed");
        Intrinsics.checkNotNullParameter(factory, "factory");
        return (T) retainedComponent(componentActivity, key, z ? componentActivity.getOnBackPressedDispatcher() : null, z2, isStateSavingAllowed, new RetainedComponentKt$retainedComponent$2(componentActivity), factory);
    }

    public static /* synthetic */ Object retainedComponent$default(Fragment fragment, String str, boolean z, boolean z2, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "RootRetainedComponent";
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        if ((i & 8) != 0) {
            function0 = new Function0() { // from class: com.arkivanov.decompose.RetainedComponentKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean retainedComponent$lambda$1;
                    retainedComponent$lambda$1 = RetainedComponentKt.retainedComponent$lambda$1();
                    return Boolean.valueOf(retainedComponent$lambda$1);
                }
            };
        }
        boolean z3 = z2;
        return retainedComponent(fragment, str, z, z3, function0, function1);
    }

    public static final <T> T retainedComponent(final Fragment fragment, String key, boolean z, boolean z2, Function0<Boolean> isStateSavingAllowed, Function1<? super ComponentContext, ? extends T> factory) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(isStateSavingAllowed, "isStateSavingAllowed");
        Intrinsics.checkNotNullParameter(factory, "factory");
        return (T) retainedComponent(fragment, key, z ? fragment.requireActivity().getOnBackPressedDispatcher() : null, z2, isStateSavingAllowed, new Function0() { // from class: com.arkivanov.decompose.RetainedComponentKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean retainedComponent$lambda$2;
                retainedComponent$lambda$2 = RetainedComponentKt.retainedComponent$lambda$2(Fragment.this);
                return Boolean.valueOf(retainedComponent$lambda$2);
            }
        }, factory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean retainedComponent$lambda$2(Fragment fragment) {
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            return activity.isChangingConfigurations();
        }
        return false;
    }

    public static final <T, O extends LifecycleOwner & SavedStateRegistryOwner & ViewModelStoreOwner> T retainedComponent(O o, String key, OnBackPressedDispatcher onBackPressedDispatcher, boolean z, Function0<Boolean> isStateSavingAllowed, final Function0<Boolean> isChangingConfigurations, Function1<? super ComponentContext, ? extends T> factory) {
        RetainedComponentHolder retainedComponentHolder;
        Intrinsics.checkNotNullParameter(o, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(isStateSavingAllowed, "isStateSavingAllowed");
        Intrinsics.checkNotNullParameter(isChangingConfigurations, "isChangingConfigurations");
        Intrinsics.checkNotNullParameter(factory, "factory");
        O o2 = o;
        if (o2.getSavedStateRegistry().getSavedStateProvider(key) != null) {
            throw new IllegalStateException(("Another retained component is already registered with the key: " + key).toString());
        }
        Lifecycle essentyLifecycle = AndroidExtKt.essentyLifecycle(o);
        StateKeeper stateKeeper = com.arkivanov.essenty.statekeeper.AndroidExtKt.stateKeeper(o2, key, z, isStateSavingAllowed);
        InstanceKeeper instanceKeeper$default = com.arkivanov.essenty.instancekeeper.AndroidExtKt.instanceKeeper$default(o, false, 1, null);
        boolean z2 = stateKeeper.consume(KEY_STATE_MARKER, BuiltinSerializersKt.serializer(BooleanCompanionObject.INSTANCE)) == null;
        stateKeeper.register(KEY_STATE_MARKER, BuiltinSerializersKt.serializer(BooleanCompanionObject.INSTANCE), new Function0() { // from class: com.arkivanov.decompose.RetainedComponentKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Boolean retainedComponent$lambda$4;
                retainedComponent$lambda$4 = RetainedComponentKt.retainedComponent$lambda$4();
                return retainedComponent$lambda$4;
            }
        });
        if (z2 && (retainedComponentHolder = (RetainedComponentHolder) instanceKeeper$default.remove(key)) != null) {
            LifecycleRegistryExtKt.destroy(retainedComponentHolder.getLifecycle());
            retainedComponentHolder.onDestroy();
        }
        RetainedComponentHolder retainedComponentHolder2 = instanceKeeper$default.get(key);
        if (retainedComponentHolder2 == null) {
            retainedComponentHolder2 = new RetainedComponentHolder((SerializableContainer) stateKeeper.consume(key, SerializableContainer.Companion.serializer()), factory);
            instanceKeeper$default.put(key, retainedComponentHolder2);
        }
        final RetainedComponentHolder retainedComponentHolder3 = (RetainedComponentHolder) retainedComponentHolder2;
        LifecycleExtKt.subscribe(essentyLifecycle, new Function0() { // from class: com.arkivanov.decompose.RetainedComponentKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit retainedComponent$lambda$7;
                retainedComponent$lambda$7 = RetainedComponentKt.retainedComponent$lambda$7(RetainedComponentHolder.this);
                return retainedComponent$lambda$7;
            }
        }, new Function0() { // from class: com.arkivanov.decompose.RetainedComponentKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit retainedComponent$lambda$8;
                retainedComponent$lambda$8 = RetainedComponentKt.retainedComponent$lambda$8(RetainedComponentHolder.this);
                return retainedComponent$lambda$8;
            }
        }, new Function0() { // from class: com.arkivanov.decompose.RetainedComponentKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit retainedComponent$lambda$9;
                retainedComponent$lambda$9 = RetainedComponentKt.retainedComponent$lambda$9(RetainedComponentHolder.this);
                return retainedComponent$lambda$9;
            }
        }, new Function0() { // from class: com.arkivanov.decompose.RetainedComponentKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit retainedComponent$lambda$10;
                retainedComponent$lambda$10 = RetainedComponentKt.retainedComponent$lambda$10(Function0.this, retainedComponentHolder3);
                return retainedComponent$lambda$10;
            }
        }, new Function0() { // from class: com.arkivanov.decompose.RetainedComponentKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit retainedComponent$lambda$11;
                retainedComponent$lambda$11 = RetainedComponentKt.retainedComponent$lambda$11(Function0.this, retainedComponentHolder3);
                return retainedComponent$lambda$11;
            }
        }, new Function0() { // from class: com.arkivanov.decompose.RetainedComponentKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit retainedComponent$lambda$12;
                retainedComponent$lambda$12 = RetainedComponentKt.retainedComponent$lambda$12(Function0.this, retainedComponentHolder3);
                return retainedComponent$lambda$12;
            }
        });
        stateKeeper.register(key, SerializableContainer.Companion.serializer(), new Function0() { // from class: com.arkivanov.decompose.RetainedComponentKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SerializableContainer retainedComponent$lambda$13;
                retainedComponent$lambda$13 = RetainedComponentKt.retainedComponent$lambda$13(RetainedComponentHolder.this);
                return retainedComponent$lambda$13;
            }
        });
        if (onBackPressedDispatcher != null) {
            final DelegateOnBackPressedCallback delegateOnBackPressedCallback = new DelegateOnBackPressedCallback(retainedComponentHolder3.getOnBackPressedDispatcher());
            retainedComponentHolder3.setOnBackEnabledChangedListener(new Function1() { // from class: com.arkivanov.decompose.RetainedComponentKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit retainedComponent$lambda$14;
                    retainedComponent$lambda$14 = RetainedComponentKt.retainedComponent$lambda$14(DelegateOnBackPressedCallback.this, ((Boolean) obj).booleanValue());
                    return retainedComponent$lambda$14;
                }
            });
            onBackPressedDispatcher.addCallback(o, delegateOnBackPressedCallback);
        }
        return (T) retainedComponentHolder3.getComponent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean retainedComponent$lambda$4() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit retainedComponent$lambda$7(RetainedComponentHolder retainedComponentHolder) {
        LifecycleRegistryExtKt.create(retainedComponentHolder.getLifecycle());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit retainedComponent$lambda$8(RetainedComponentHolder retainedComponentHolder) {
        LifecycleRegistryExtKt.start(retainedComponentHolder.getLifecycle());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit retainedComponent$lambda$9(RetainedComponentHolder retainedComponentHolder) {
        LifecycleRegistryExtKt.resume(retainedComponentHolder.getLifecycle());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit retainedComponent$lambda$10(Function0 function0, RetainedComponentHolder retainedComponentHolder) {
        if (!((Boolean) function0.invoke()).booleanValue()) {
            LifecycleRegistryExtKt.pause(retainedComponentHolder.getLifecycle());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit retainedComponent$lambda$11(Function0 function0, RetainedComponentHolder retainedComponentHolder) {
        if (!((Boolean) function0.invoke()).booleanValue()) {
            LifecycleRegistryExtKt.stop(retainedComponentHolder.getLifecycle());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit retainedComponent$lambda$12(Function0 function0, RetainedComponentHolder retainedComponentHolder) {
        if (!((Boolean) function0.invoke()).booleanValue()) {
            LifecycleRegistryExtKt.destroy(retainedComponentHolder.getLifecycle());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerializableContainer retainedComponent$lambda$13(RetainedComponentHolder retainedComponentHolder) {
        return retainedComponentHolder.getStateKeeper().save();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit retainedComponent$lambda$14(DelegateOnBackPressedCallback delegateOnBackPressedCallback, boolean z) {
        delegateOnBackPressedCallback.setEnabled(z);
        return Unit.INSTANCE;
    }
}
