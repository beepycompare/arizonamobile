package ru.mrlargha.commonui.elements.donate.presentation;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import ru.mrlargha.commonui.elements.donate.presentation.UiState;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateBoostModelUi;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DonateScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$setupCollectors$1$4", f = "DonateScreen.kt", i = {}, l = {429}, m = "invokeSuspend", n = {}, nl = {447}, s = {}, v = 2)
/* loaded from: classes6.dex */
public final class DonateScreen$setupCollectors$1$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $currentSessionGeneration;
    final /* synthetic */ DonateStates $sessionStates;
    int label;
    final /* synthetic */ DonateScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateScreen$setupCollectors$1$4(DonateStates donateStates, DonateScreen donateScreen, long j, Continuation<? super DonateScreen$setupCollectors$1$4> continuation) {
        super(2, continuation);
        this.$sessionStates = donateStates;
        this.this$0 = donateScreen;
        this.$currentSessionGeneration = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DonateScreen$setupCollectors$1$4(this.$sessionStates, this.this$0, this.$currentSessionGeneration, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DonateScreen$setupCollectors$1$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DonateScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$setupCollectors$1$4$1", f = "DonateScreen.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    /* renamed from: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen$setupCollectors$1$4$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $currentSessionGeneration;
        final /* synthetic */ DonateStates $sessionStates;
        int label;
        final /* synthetic */ DonateScreen this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DonateStates donateStates, DonateScreen donateScreen, long j, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$sessionStates = donateStates;
            this.this$0 = donateScreen;
            this.$currentSessionGeneration = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$sessionStates, this.this$0, this.$currentSessionGeneration, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<UiState<List<DonateBoostModelUi>>> boostState = this.$sessionStates.getBoostState();
                final DonateScreen donateScreen = this.this$0;
                final DonateStates donateStates = this.$sessionStates;
                final long j = this.$currentSessionGeneration;
                this.label = 1;
                if (boostState.collect(new FlowCollector() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateScreen.setupCollectors.1.4.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((UiState) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(UiState<? extends List<DonateBoostModelUi>> uiState, Continuation<? super Unit> continuation) {
                        boolean isCurrentSession;
                        isCurrentSession = DonateScreen.this.isCurrentSession(donateStates, j);
                        if (isCurrentSession) {
                            if (!(uiState instanceof UiState.Error) && !(uiState instanceof UiState.Loading)) {
                                if (!(uiState instanceof UiState.Successful)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                DonateScreen.this.dialogModel = (DonateBoostModelUi) ((List) ((UiState.Successful) uiState).getData()).get(0);
                            }
                            return Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
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

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$sessionStates, this.this$0, this.$currentSessionGeneration, null), this) == coroutine_suspended) {
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
