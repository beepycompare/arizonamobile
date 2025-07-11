package com.miami.game.core.ui.utils.extensions;

import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FlowExtensions.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.ui.utils.extensions.FlowExtensionsKt$collectInLaunchedEffectWithLifecycle$1$1", f = "FlowExtensions.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class FlowExtensionsKt$collectInLaunchedEffectWithLifecycle$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function3<CoroutineScope, T, Continuation<? super Unit>, Object>> $currentCollector$delegate;
    final /* synthetic */ Flow<T> $flow;
    final /* synthetic */ Lifecycle $lifecycle;
    final /* synthetic */ Lifecycle.State $minActiveState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowExtensionsKt$collectInLaunchedEffectWithLifecycle$1$1(Lifecycle lifecycle, Lifecycle.State state, Flow<? extends T> flow, State<? extends Function3<? super CoroutineScope, ? super T, ? super Continuation<? super Unit>, ? extends Object>> state2, Continuation<? super FlowExtensionsKt$collectInLaunchedEffectWithLifecycle$1$1> continuation) {
        super(2, continuation);
        this.$lifecycle = lifecycle;
        this.$minActiveState = state;
        this.$flow = flow;
        this.$currentCollector$delegate = state2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FlowExtensionsKt$collectInLaunchedEffectWithLifecycle$1$1(this.$lifecycle, this.$minActiveState, this.$flow, this.$currentCollector$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FlowExtensionsKt$collectInLaunchedEffectWithLifecycle$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlowExtensions.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.miami.game.core.ui.utils.extensions.FlowExtensionsKt$collectInLaunchedEffectWithLifecycle$1$1$1", f = "FlowExtensions.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.miami.game.core.ui.utils.extensions.FlowExtensionsKt$collectInLaunchedEffectWithLifecycle$1$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ State<Function3<CoroutineScope, T, Continuation<? super Unit>, Object>> $currentCollector$delegate;
        final /* synthetic */ Flow<T> $flow;
        final /* synthetic */ Lifecycle $lifecycle;
        final /* synthetic */ Lifecycle.State $minActiveState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, Flow<? extends T> flow, State<? extends Function3<? super CoroutineScope, ? super T, ? super Continuation<? super Unit>, ? extends Object>> state2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$lifecycle = lifecycle;
            this.$minActiveState = state;
            this.$flow = flow;
            this.$currentCollector$delegate = state2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$lifecycle, this.$minActiveState, this.$flow, this.$currentCollector$delegate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FlowExtensions.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.miami.game.core.ui.utils.extensions.FlowExtensionsKt$collectInLaunchedEffectWithLifecycle$1$1$1$1", f = "FlowExtensions.kt", i = {0}, l = {43}, m = "invokeSuspend", n = {"$this$repeatOnLifecycle"}, s = {"L$0"})
        /* renamed from: com.miami.game.core.ui.utils.extensions.FlowExtensionsKt$collectInLaunchedEffectWithLifecycle$1$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C00901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ State<Function3<CoroutineScope, T, Continuation<? super Unit>, Object>> $currentCollector$delegate;
            final /* synthetic */ Flow<T> $flow;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C00901(Flow<? extends T> flow, State<? extends Function3<? super CoroutineScope, ? super T, ? super Continuation<? super Unit>, ? extends Object>> state, Continuation<? super C00901> continuation) {
                super(2, continuation);
                this.$flow = flow;
                this.$currentCollector$delegate = state;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00901 c00901 = new C00901(this.$flow, this.$currentCollector$delegate, continuation);
                c00901.L$0 = obj;
                return c00901;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00901) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow<T> flow = this.$flow;
                    final State<Function3<CoroutineScope, T, Continuation<? super Unit>, Object>> state = this.$currentCollector$delegate;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.label = 1;
                    if (flow.collect(new FlowCollector() { // from class: com.miami.game.core.ui.utils.extensions.FlowExtensionsKt.collectInLaunchedEffectWithLifecycle.1.1.1.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(T t, Continuation<? super Unit> continuation) {
                            Function3 collectInLaunchedEffectWithLifecycle$lambda$1;
                            collectInLaunchedEffectWithLifecycle$lambda$1 = FlowExtensionsKt.collectInLaunchedEffectWithLifecycle$lambda$1(state);
                            Object invoke = collectInLaunchedEffectWithLifecycle$lambda$1.invoke(CoroutineScope.this, t, continuation);
                            return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(this.$lifecycle, this.$minActiveState, new C00901(this.$flow, this.$currentCollector$delegate, null), this) == coroutine_suspended) {
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

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new AnonymousClass1(this.$lifecycle, this.$minActiveState, this.$flow, this.$currentCollector$delegate, null), this) == coroutine_suspended) {
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
