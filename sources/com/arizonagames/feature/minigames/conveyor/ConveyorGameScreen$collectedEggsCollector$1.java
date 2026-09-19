package com.arizonagames.feature.minigames.conveyor;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConveyorGameScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizonagames.feature.minigames.conveyor.ConveyorGameScreen$collectedEggsCollector$1", f = "ConveyorGameScreen.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class ConveyorGameScreen$collectedEggsCollector$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ConveyorGameScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConveyorGameScreen$collectedEggsCollector$1(ConveyorGameScreen conveyorGameScreen, Continuation<? super ConveyorGameScreen$collectedEggsCollector$1> continuation) {
        super(2, continuation);
        this.this$0 = conveyorGameScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConveyorGameScreen$collectedEggsCollector$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConveyorGameScreen$collectedEggsCollector$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConveyorGameScreen.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* renamed from: com.arizonagames.feature.minigames.conveyor.ConveyorGameScreen$collectedEggsCollector$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class AnonymousClass1 implements FlowCollector, FunctionAdapter {
        final /* synthetic */ ConveyorGameScreen $tmp0;

        AnonymousClass1(ConveyorGameScreen conveyorGameScreen) {
            this.$tmp0 = conveyorGameScreen;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return new AdaptedFunctionReference(2, this.$tmp0, ConveyorGameScreen.class, "updateLeftItem", "updateLeftItem(II)V", 4);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final Object emit(int i, Continuation<? super Unit> continuation) {
            ConveyorGameScreen.updateLeftItem$default(this.$tmp0, i, 0, 2, null);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit(((Number) obj).intValue(), continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0.collectedEggsState;
            this.label = 1;
            if (mutableStateFlow.collect(new AnonymousClass1(this.this$0), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
