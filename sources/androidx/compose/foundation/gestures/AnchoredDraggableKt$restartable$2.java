package androidx.compose.foundation.gestures;

import androidx.compose.runtime.SnapshotStateKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
/*  JADX ERROR: JadxRuntimeException in pass: ClassModifier
    jadx.core.utils.exceptions.JadxRuntimeException: Not class type: I
    	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:53)
    	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticFields(ClassModifier.java:83)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:61)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:55)
    */
/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "I", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2", f = "AnchoredDraggable.kt", i = {}, l = {1545}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class AnchoredDraggableKt$restartable$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Function0<I> $inputs;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AnchoredDraggableKt$restartable$2(Function0<? extends I> function0, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AnchoredDraggableKt$restartable$2> continuation) {
        super(2, continuation);
        this.$inputs = function0;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AnchoredDraggableKt$restartable$2 anchoredDraggableKt$restartable$2 = new AnchoredDraggableKt$restartable$2(this.$inputs, this.$block, continuation);
        anchoredDraggableKt$restartable$2.L$0 = obj;
        return anchoredDraggableKt$restartable$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return invoke2(coroutineScope, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnchoredDraggableKt$restartable$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            this.label = 1;
            if (SnapshotStateKt.snapshotFlow(this.$inputs).collect(new AnonymousClass1(objectRef, (CoroutineScope) this.L$0, this.$block), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "I", "latestInputs", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ CoroutineScope $$this$coroutineScope;
        final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Ref.ObjectRef<Job> $previousDrag;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Ref.ObjectRef<Job> objectRef, CoroutineScope coroutineScope, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2) {
            this.$previousDrag = objectRef;
            this.$$this$coroutineScope = coroutineScope;
            this.$block = function2;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(I i, Continuation<? super Unit> continuation) {
            AnchoredDraggableKt$restartable$2$1$emit$1 anchoredDraggableKt$restartable$2$1$emit$1;
            int i2;
            AnonymousClass1<T> anonymousClass1;
            Object obj;
            Job launch$default;
            if (continuation instanceof AnchoredDraggableKt$restartable$2$1$emit$1) {
                anchoredDraggableKt$restartable$2$1$emit$1 = (AnchoredDraggableKt$restartable$2$1$emit$1) continuation;
                if ((anchoredDraggableKt$restartable$2$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    anchoredDraggableKt$restartable$2$1$emit$1.label -= Integer.MIN_VALUE;
                    Object obj2 = anchoredDraggableKt$restartable$2$1$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i2 = anchoredDraggableKt$restartable$2$1$emit$1.label;
                    if (i2 != 0) {
                        ResultKt.throwOnFailure(obj2);
                        Job job = this.$previousDrag.element;
                        if (job != null) {
                            job.cancel((CancellationException) new AnchoredDragFinishedSignal());
                            anchoredDraggableKt$restartable$2$1$emit$1.L$0 = this;
                            anchoredDraggableKt$restartable$2$1$emit$1.L$1 = i;
                            anchoredDraggableKt$restartable$2$1$emit$1.L$2 = job;
                            anchoredDraggableKt$restartable$2$1$emit$1.label = 1;
                            if (job.join(anchoredDraggableKt$restartable$2$1$emit$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        anonymousClass1 = this;
                        obj = i;
                    } else if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        Job job2 = (Job) anchoredDraggableKt$restartable$2$1$emit$1.L$2;
                        Object obj3 = anchoredDraggableKt$restartable$2$1$emit$1.L$1;
                        anonymousClass1 = (AnonymousClass1) anchoredDraggableKt$restartable$2$1$emit$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        obj = obj3;
                    }
                    Ref.ObjectRef<Job> objectRef = anonymousClass1.$previousDrag;
                    launch$default = BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(anonymousClass1.$block, obj, anonymousClass1.$$this$coroutineScope, null), 1, null);
                    objectRef.element = (T) launch$default;
                    return Unit.INSTANCE;
                }
            }
            anchoredDraggableKt$restartable$2$1$emit$1 = new AnchoredDraggableKt$restartable$2$1$emit$1(this, continuation);
            Object obj22 = anchoredDraggableKt$restartable$2$1$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i2 = anchoredDraggableKt$restartable$2$1$emit$1.label;
            if (i2 != 0) {
            }
            Ref.ObjectRef<Job> objectRef2 = anonymousClass1.$previousDrag;
            launch$default = BuildersKt__Builders_commonKt.launch$default(anonymousClass1.$$this$coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(anonymousClass1.$block, obj, anonymousClass1.$$this$coroutineScope, null), 1, null);
            objectRef2.element = (T) launch$default;
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AnchoredDraggable.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "I", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$2", f = "AnchoredDraggable.kt", i = {}, l = {1552}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$2  reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
            final /* synthetic */ I $latestInputs;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2, I i, CoroutineScope coroutineScope, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$block = function2;
                this.$latestInputs = i;
                this.$$this$coroutineScope = coroutineScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$block, this.$latestInputs, this.$$this$coroutineScope, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return invoke2(coroutineScope, continuation);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function2<I, Continuation<? super Unit>, Object> function2 = this.$block;
                    I i2 = this.$latestInputs;
                    this.label = 1;
                    if (function2.invoke(i2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                CoroutineScopeKt.cancel(this.$$this$coroutineScope, new AnchoredDragFinishedSignal());
                return Unit.INSTANCE;
            }
        }
    }
}
