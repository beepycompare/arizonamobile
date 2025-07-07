package com.arkivanov.decompose.lifecycle;

import com.arkivanov.essenty.lifecycle.Lifecycle;
import com.arkivanov.essenty.lifecycle.LifecycleRegistry;
import com.arkivanov.essenty.lifecycle.LifecycleRegistryExtKt;
import com.arkivanov.essenty.lifecycle.LifecycleRegistryKt;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
/* compiled from: MergedLifecycle.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002J\u0011\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/arkivanov/decompose/lifecycle/MergedLifecycle;", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "registry", "Lcom/arkivanov/essenty/lifecycle/LifecycleRegistry;", "lifecycle1", "lifecycle2", "<init>", "(Lcom/arkivanov/essenty/lifecycle/LifecycleRegistry;Lcom/arkivanov/essenty/lifecycle/Lifecycle;Lcom/arkivanov/essenty/lifecycle/Lifecycle;)V", "(Lcom/arkivanov/essenty/lifecycle/Lifecycle;Lcom/arkivanov/essenty/lifecycle/Lifecycle;)V", "moveTo", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arkivanov/essenty/lifecycle/Lifecycle$State;", "moveToDestroyed", "moveToCreated", "moveToStarted", "moveToResumed", "subscribe", "callbacks", "Lcom/arkivanov/essenty/lifecycle/Lifecycle$Callbacks;", "unsubscribe", "getState", "()Lcom/arkivanov/essenty/lifecycle/Lifecycle$State;", "CallbacksImpl", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MergedLifecycle implements Lifecycle {
    private final LifecycleRegistry registry;

    /* compiled from: MergedLifecycle.kt */
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

    @Override // com.arkivanov.essenty.lifecycle.Lifecycle
    public Lifecycle.State getState() {
        return this.registry.getState();
    }

    @Override // com.arkivanov.essenty.lifecycle.Lifecycle
    public void subscribe(Lifecycle.Callbacks callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        this.registry.subscribe(callbacks);
    }

    @Override // com.arkivanov.essenty.lifecycle.Lifecycle
    public void unsubscribe(Lifecycle.Callbacks callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        this.registry.unsubscribe(callbacks);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private MergedLifecycle(LifecycleRegistry lifecycleRegistry, final Lifecycle lifecycle, final Lifecycle lifecycle2) {
        this.registry = lifecycleRegistry;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = lifecycle.getState() == Lifecycle.State.DESTROYED ? Lifecycle.State.DESTROYED : Lifecycle.State.INITIALIZED;
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = lifecycle2.getState() == Lifecycle.State.DESTROYED ? Lifecycle.State.DESTROYED : Lifecycle.State.INITIALIZED;
        moveTo((Lifecycle.State) ComparisonsKt.minOf((Comparable) objectRef.element, (Comparable) objectRef2.element));
        if (objectRef.element == Lifecycle.State.DESTROYED || objectRef2.element == Lifecycle.State.DESTROYED) {
            return;
        }
        final CallbacksImpl callbacksImpl = new CallbacksImpl(new Function1() { // from class: com.arkivanov.decompose.lifecycle.MergedLifecycle$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = MergedLifecycle._init_$lambda$0(Ref.ObjectRef.this, this, objectRef2, (Lifecycle.State) obj);
                return _init_$lambda$0;
            }
        });
        final CallbacksImpl callbacksImpl2 = new CallbacksImpl(new Function1() { // from class: com.arkivanov.decompose.lifecycle.MergedLifecycle$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _init_$lambda$1;
                _init_$lambda$1 = MergedLifecycle._init_$lambda$1(Ref.ObjectRef.this, this, objectRef, (Lifecycle.State) obj);
                return _init_$lambda$1;
            }
        });
        CallbacksImpl callbacksImpl3 = callbacksImpl;
        lifecycle.subscribe(callbacksImpl3);
        CallbacksImpl callbacksImpl4 = callbacksImpl2;
        lifecycle2.subscribe(callbacksImpl4);
        LifecycleRegistry lifecycleRegistry2 = lifecycleRegistry;
        if (lifecycleRegistry2.getState() == Lifecycle.State.DESTROYED) {
            lifecycle.unsubscribe(callbacksImpl3);
            lifecycle2.unsubscribe(callbacksImpl4);
            return;
        }
        lifecycleRegistry2.subscribe(new Lifecycle.Callbacks() { // from class: com.arkivanov.decompose.lifecycle.MergedLifecycle$special$$inlined$doOnDestroy$1
            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public void onCreate() {
                Lifecycle.Callbacks.DefaultImpls.onCreate(this);
            }

            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public void onPause() {
                Lifecycle.Callbacks.DefaultImpls.onPause(this);
            }

            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public void onResume() {
                Lifecycle.Callbacks.DefaultImpls.onResume(this);
            }

            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public void onStart() {
                Lifecycle.Callbacks.DefaultImpls.onStart(this);
            }

            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public void onStop() {
                Lifecycle.Callbacks.DefaultImpls.onStop(this);
            }

            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public void onDestroy() {
                Lifecycle.this.unsubscribe(callbacksImpl);
                lifecycle2.unsubscribe(callbacksImpl2);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MergedLifecycle(Lifecycle lifecycle1, Lifecycle lifecycle2) {
        this(LifecycleRegistryKt.LifecycleRegistry(), lifecycle1, lifecycle2);
        Intrinsics.checkNotNullParameter(lifecycle1, "lifecycle1");
        Intrinsics.checkNotNullParameter(lifecycle2, "lifecycle2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit _init_$lambda$0(Ref.ObjectRef objectRef, MergedLifecycle mergedLifecycle, Ref.ObjectRef objectRef2, Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        objectRef.element = state;
        mergedLifecycle.moveTo((Lifecycle.State) ComparisonsKt.minOf(state, (Comparable) objectRef2.element));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit _init_$lambda$1(Ref.ObjectRef objectRef, MergedLifecycle mergedLifecycle, Ref.ObjectRef objectRef2, Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        objectRef.element = state;
        mergedLifecycle.moveTo((Lifecycle.State) ComparisonsKt.minOf(state, (Comparable) objectRef2.element));
        return Unit.INSTANCE;
    }

    private final void moveTo(Lifecycle.State state) {
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1) {
            moveToDestroyed();
        } else if (i != 2) {
            if (i == 3) {
                moveToCreated();
            } else if (i == 4) {
                moveToStarted();
            } else if (i != 5) {
                throw new NoWhenBranchMatchedException();
            } else {
                moveToResumed();
            }
        }
    }

    private final void moveToDestroyed() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.registry.getState().ordinal()];
        if (i != 1) {
            if (i == 2) {
                LifecycleRegistryExtKt.create(this.registry);
                LifecycleRegistryExtKt.destroy(this.registry);
            } else if (i != 3 && i != 4 && i != 5) {
                throw new NoWhenBranchMatchedException();
            } else {
                LifecycleRegistryExtKt.destroy(this.registry);
            }
        }
    }

    private final void moveToCreated() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.registry.getState().ordinal()];
        if (i != 1) {
            if (i == 2) {
                LifecycleRegistryExtKt.create(this.registry);
            } else if (i != 3) {
                if (i != 4 && i != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                LifecycleRegistryExtKt.stop(this.registry);
            }
        }
    }

    private final void moveToStarted() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.registry.getState().ordinal()];
        if (i != 1) {
            if (i == 2 || i == 3) {
                LifecycleRegistryExtKt.start(this.registry);
            } else if (i != 4) {
                if (i != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                LifecycleRegistryExtKt.pause(this.registry);
            }
        }
    }

    private final void moveToResumed() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.registry.getState().ordinal()];
        if (i != 1) {
            if (i == 2 || i == 3 || i == 4) {
                LifecycleRegistryExtKt.resume(this.registry);
            } else if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MergedLifecycle.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/arkivanov/decompose/lifecycle/MergedLifecycle$CallbacksImpl;", "Lcom/arkivanov/essenty/lifecycle/Lifecycle$Callbacks;", "onStateChanged", "Lkotlin/Function1;", "Lcom/arkivanov/essenty/lifecycle/Lifecycle$State;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "onCreate", "onStart", "onResume", "onPause", "onStop", "onDestroy", "decompose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class CallbacksImpl implements Lifecycle.Callbacks {
        private final Function1<Lifecycle.State, Unit> onStateChanged;

        /* JADX WARN: Multi-variable type inference failed */
        public CallbacksImpl(Function1<? super Lifecycle.State, Unit> onStateChanged) {
            Intrinsics.checkNotNullParameter(onStateChanged, "onStateChanged");
            this.onStateChanged = onStateChanged;
        }

        @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
        public void onCreate() {
            this.onStateChanged.invoke(Lifecycle.State.CREATED);
        }

        @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
        public void onStart() {
            this.onStateChanged.invoke(Lifecycle.State.STARTED);
        }

        @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
        public void onResume() {
            this.onStateChanged.invoke(Lifecycle.State.RESUMED);
        }

        @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
        public void onPause() {
            this.onStateChanged.invoke(Lifecycle.State.STARTED);
        }

        @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
        public void onStop() {
            this.onStateChanged.invoke(Lifecycle.State.CREATED);
        }

        @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
        public void onDestroy() {
            this.onStateChanged.invoke(Lifecycle.State.DESTROYED);
        }
    }
}
