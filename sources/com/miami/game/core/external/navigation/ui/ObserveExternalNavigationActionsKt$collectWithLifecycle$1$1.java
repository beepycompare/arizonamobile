package com.miami.game.core.external.navigation.ui;

import androidx.compose.runtime.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ObserveExternalNavigationActions.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.external.navigation.ui.ObserveExternalNavigationActionsKt$collectWithLifecycle$1$1", f = "ObserveExternalNavigationActions.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class ObserveExternalNavigationActionsKt$collectWithLifecycle$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function1<T, Unit>> $currentOnEvent$delegate;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ Flow<T> $this_collectWithLifecycle;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ObserveExternalNavigationActionsKt$collectWithLifecycle$1$1(LifecycleOwner lifecycleOwner, Flow<? extends T> flow, State<? extends Function1<? super T, Unit>> state, Continuation<? super ObserveExternalNavigationActionsKt$collectWithLifecycle$1$1> continuation) {
        super(2, continuation);
        this.$lifecycleOwner = lifecycleOwner;
        this.$this_collectWithLifecycle = flow;
        this.$currentOnEvent$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ObserveExternalNavigationActionsKt$collectWithLifecycle$1$1(this.$lifecycleOwner, this.$this_collectWithLifecycle, this.$currentOnEvent$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ObserveExternalNavigationActionsKt$collectWithLifecycle$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObserveExternalNavigationActions.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.miami.game.core.external.navigation.ui.ObserveExternalNavigationActionsKt$collectWithLifecycle$1$1$1", f = "ObserveExternalNavigationActions.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.miami.game.core.external.navigation.ui.ObserveExternalNavigationActionsKt$collectWithLifecycle$1$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ State<Function1<T, Unit>> $currentOnEvent$delegate;
        final /* synthetic */ Flow<T> $this_collectWithLifecycle;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Flow<? extends T> flow, State<? extends Function1<? super T, Unit>> state, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_collectWithLifecycle = flow;
            this.$currentOnEvent$delegate = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_collectWithLifecycle, this.$currentOnEvent$delegate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObserveExternalNavigationActions.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.miami.game.core.external.navigation.ui.ObserveExternalNavigationActionsKt$collectWithLifecycle$1$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final /* synthetic */ class C00891 implements FlowCollector, FunctionAdapter {
            final /* synthetic */ Function1<T, Unit> $tmp0;

            /* JADX WARN: Multi-variable type inference failed */
            C00891(Function1<? super T, Unit> function1) {
                this.$tmp0 = function1;
            }

            public final boolean equals(Object obj) {
                if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                    return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
                }
                return false;
            }

            @Override // kotlin.jvm.internal.FunctionAdapter
            public final Function<?> getFunctionDelegate() {
                return new FunctionReferenceImpl(2, this.$tmp0, Intrinsics.Kotlin.class, "suspendConversion0", "invokeSuspend$suspendConversion0(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
            }

            public final int hashCode() {
                return getFunctionDelegate().hashCode();
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(T t, Continuation<? super Unit> continuation) {
                Object invokeSuspend$suspendConversion0 = AnonymousClass1.invokeSuspend$suspendConversion0(this.$tmp0, t, continuation);
                return invokeSuspend$suspendConversion0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invokeSuspend$suspendConversion0 : Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Function1 collectWithLifecycle$lambda$4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<T> flow = this.$this_collectWithLifecycle;
                collectWithLifecycle$lambda$4 = ObserveExternalNavigationActionsKt.collectWithLifecycle$lambda$4(this.$currentOnEvent$delegate);
                this.label = 1;
                if (flow.collect(new C00891(collectWithLifecycle$lambda$4), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ Object invokeSuspend$suspendConversion0(Function1 function1, Object obj, Continuation continuation) {
            function1.invoke(obj);
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(this.$lifecycleOwner, Lifecycle.State.STARTED, new AnonymousClass1(this.$this_collectWithLifecycle, this.$currentOnEvent$delegate, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
