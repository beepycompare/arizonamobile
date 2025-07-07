package com.arkivanov.decompose;

import androidx.activity.OnBackPressedDispatcher;
import androidx.core.util.Consumer;
import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.essenty.backhandler.AndroidBackHandlerKt;
import com.arkivanov.essenty.instancekeeper.InstanceKeeper;
import com.arkivanov.essenty.instancekeeper.InstanceKeeperDispatcher;
import com.arkivanov.essenty.instancekeeper.InstanceKeeperDispatcherKt;
import com.arkivanov.essenty.lifecycle.LifecycleRegistry;
import com.arkivanov.essenty.lifecycle.LifecycleRegistryKt;
import com.arkivanov.essenty.statekeeper.SerializableContainer;
import com.arkivanov.essenty.statekeeper.StateKeeperDispatcher;
import com.arkivanov.essenty.statekeeper.StateKeeperDispatcherKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RetainedComponent.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010#\u001a\u00020\u0016H\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/arkivanov/decompose/RetainedComponentHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper$Instance;", "savedState", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "factory", "Lkotlin/Function1;", "Lcom/arkivanov/decompose/ComponentContext;", "<init>", "(Lcom/arkivanov/essenty/statekeeper/SerializableContainer;Lkotlin/jvm/functions/Function1;)V", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/LifecycleRegistry;", "getLifecycle", "()Lcom/arkivanov/essenty/lifecycle/LifecycleRegistry;", "stateKeeper", "Lcom/arkivanov/essenty/statekeeper/StateKeeperDispatcher;", "getStateKeeper", "()Lcom/arkivanov/essenty/statekeeper/StateKeeperDispatcher;", "instanceKeeper", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeperDispatcher;", "onBackEnabledChangedListener", "", "", "getOnBackEnabledChangedListener", "()Lkotlin/jvm/functions/Function1;", "setOnBackEnabledChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "getOnBackPressedDispatcher", "()Landroidx/activity/OnBackPressedDispatcher;", "component", "getComponent", "()Ljava/lang/Object;", "Ljava/lang/Object;", "onDestroy", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RetainedComponentHolder<T> implements InstanceKeeper.Instance {
    private final T component;
    private final InstanceKeeperDispatcher instanceKeeper;
    private final LifecycleRegistry lifecycle;
    private Function1<? super Boolean, Unit> onBackEnabledChangedListener;
    private final OnBackPressedDispatcher onBackPressedDispatcher;
    private final StateKeeperDispatcher stateKeeper;

    public RetainedComponentHolder(SerializableContainer serializableContainer, Function1<? super ComponentContext, ? extends T> factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        LifecycleRegistry LifecycleRegistry = LifecycleRegistryKt.LifecycleRegistry();
        this.lifecycle = LifecycleRegistry;
        StateKeeperDispatcher StateKeeperDispatcher = StateKeeperDispatcherKt.StateKeeperDispatcher(serializableContainer);
        this.stateKeeper = StateKeeperDispatcher;
        InstanceKeeperDispatcher InstanceKeeperDispatcher = InstanceKeeperDispatcherKt.InstanceKeeperDispatcher();
        this.instanceKeeper = InstanceKeeperDispatcher;
        OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher(null, new Consumer() { // from class: com.arkivanov.decompose.RetainedComponentHolder$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                RetainedComponentHolder.onBackPressedDispatcher$lambda$0(RetainedComponentHolder.this, (Boolean) obj);
            }
        });
        this.onBackPressedDispatcher = onBackPressedDispatcher;
        this.component = factory.invoke(new DefaultComponentContext(LifecycleRegistry, StateKeeperDispatcher, InstanceKeeperDispatcher, AndroidBackHandlerKt.BackHandler(onBackPressedDispatcher)));
    }

    public final LifecycleRegistry getLifecycle() {
        return this.lifecycle;
    }

    public final StateKeeperDispatcher getStateKeeper() {
        return this.stateKeeper;
    }

    public final Function1<Boolean, Unit> getOnBackEnabledChangedListener() {
        return this.onBackEnabledChangedListener;
    }

    public final void setOnBackEnabledChangedListener(Function1<? super Boolean, Unit> function1) {
        this.onBackEnabledChangedListener = function1;
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackPressedDispatcher$lambda$0(RetainedComponentHolder retainedComponentHolder, Boolean bool) {
        Function1<? super Boolean, Unit> function1 = retainedComponentHolder.onBackEnabledChangedListener;
        if (function1 != null) {
            Intrinsics.checkNotNull(bool);
            function1.invoke(bool);
        }
    }

    public final T getComponent() {
        return this.component;
    }

    @Override // com.arkivanov.essenty.instancekeeper.InstanceKeeper.Instance
    public void onDestroy() {
        this.instanceKeeper.destroy();
    }
}
