package ru.mrlargha.commonui.elements.donate.presentation.pages;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
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
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateBoostModelUi;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DonateReplenishmentDialogPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.pages.DonateReplenishmentDialogPage$setupControllers$1", f = "DonateReplenishmentDialogPage.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class DonateReplenishmentDialogPage$setupControllers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DonateBoostModelUi $model;
    int label;
    final /* synthetic */ DonateReplenishmentDialogPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateReplenishmentDialogPage$setupControllers$1(DonateReplenishmentDialogPage donateReplenishmentDialogPage, DonateBoostModelUi donateBoostModelUi, Continuation<? super DonateReplenishmentDialogPage$setupControllers$1> continuation) {
        super(2, continuation);
        this.this$0 = donateReplenishmentDialogPage;
        this.$model = donateBoostModelUi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DonateReplenishmentDialogPage$setupControllers$1(this.this$0, this.$model, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DonateReplenishmentDialogPage$setupControllers$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0.willReceiveState;
            final DonateBoostModelUi donateBoostModelUi = this.$model;
            final DonateReplenishmentDialogPage donateReplenishmentDialogPage = this.this$0;
            this.label = 1;
            if (mutableStateFlow.collect(new FlowCollector() { // from class: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateReplenishmentDialogPage$setupControllers$1.1

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: DonateReplenishmentDialogPage.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.pages.DonateReplenishmentDialogPage$setupControllers$1$1$1", f = "DonateReplenishmentDialogPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: ru.mrlargha.commonui.elements.donate.presentation.pages.DonateReplenishmentDialogPage$setupControllers$1$1$1  reason: invalid class name and collision with other inner class name */
                /* loaded from: classes5.dex */
                public static final class C01031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Pair<Long, Integer> $it;
                    final /* synthetic */ DonateBoostModelUi $model;
                    int label;
                    final /* synthetic */ DonateReplenishmentDialogPage this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C01031(Pair<Long, Integer> pair, DonateBoostModelUi donateBoostModelUi, DonateReplenishmentDialogPage donateReplenishmentDialogPage, Continuation<? super C01031> continuation) {
                        super(2, continuation);
                        this.$it = pair;
                        this.$model = donateBoostModelUi;
                        this.this$0 = donateReplenishmentDialogPage;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C01031(this.$it, this.$model, this.this$0, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C01031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        boolean z;
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        long longValue = (this.$it.getFirst().longValue() * this.$model.getRate().getTo()) / this.$model.getRate().getFrom();
                        int doubleValue = (int) (longValue * (this.$it.getSecond().doubleValue() / 100.0d));
                        long j = doubleValue + longValue;
                        z = this.this$0.isReverse;
                        if (!z) {
                            this.this$0.getBinding().tvReceive.setText(DonateUtilsKt.formatWithSpaces(longValue));
                            this.this$0.getAmount = longValue;
                        } else {
                            this.this$0.getBinding().tvReceive.setText(DonateUtilsKt.formatWithSpaces(j));
                            this.this$0.getAmount = j;
                        }
                        this.this$0.getBinding().tvBonus.setText(String.valueOf(doubleValue));
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((Pair) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(Pair<Long, Integer> pair, Continuation<? super Unit> continuation) {
                    Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new C01031(pair, DonateBoostModelUi.this, donateReplenishmentDialogPage, null), continuation);
                    return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
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
