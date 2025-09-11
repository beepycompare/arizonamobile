package ru.mrlargha.commonui.elements.donate.presentation.pages;

import kotlin.Metadata;
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
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateRateType;
/* compiled from: DonateReplenishmentDialogPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.pages.DonateReplenishmentDialogPage$setupListeners$1$2$onTextChanged$2", f = "DonateReplenishmentDialogPage.kt", i = {2}, l = {94, 96, 99}, m = "invokeSuspend", n = {"bonus"}, s = {"I$0"}, v = 1)
/* loaded from: classes5.dex */
final class DonateReplenishmentDialogPage$setupListeners$1$2$onTextChanged$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $number;
    int I$0;
    int label;
    final /* synthetic */ DonateReplenishmentDialogPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateReplenishmentDialogPage$setupListeners$1$2$onTextChanged$2(DonateReplenishmentDialogPage donateReplenishmentDialogPage, long j, Continuation<? super DonateReplenishmentDialogPage$setupListeners$1$2$onTextChanged$2> continuation) {
        super(2, continuation);
        this.this$0 = donateReplenishmentDialogPage;
        this.$number = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DonateReplenishmentDialogPage$setupListeners$1$2$onTextChanged$2(this.this$0, this.$number, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DonateReplenishmentDialogPage$setupListeners$1$2$onTextChanged$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
        if (r9 == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007d, code lost:
        if (r1.emit(kotlin.TuplesKt.to(kotlin.coroutines.jvm.internal.Boxing.boxLong(r8.$number), kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)), r8) == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009e, code lost:
        if (r9.emit(kotlin.TuplesKt.to(kotlin.coroutines.jvm.internal.Boxing.boxLong(r8.$number), kotlin.coroutines.jvm.internal.Boxing.boxInt(0)), r8) == r0) goto L14;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        DonateRateType donateRateType;
        MutableStateFlow mutableStateFlow;
        DonateRateType donateRateType2;
        MutableStateFlow mutableStateFlow2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            donateRateType = this.this$0.rateType;
            if (donateRateType != DonateRateType.EXCHANGER_EXP) {
                donateRateType2 = this.this$0.rateType;
                if (donateRateType2 != DonateRateType.EXCHANGER_RUB) {
                    this.label = 2;
                    obj = BuildersKt.withContext(Dispatchers.getMain(), new DonateReplenishmentDialogPage$setupListeners$1$2$onTextChanged$2$bonus$1(this.this$0, this.$number, null), this);
                }
            }
            mutableStateFlow = this.this$0.willReceiveState;
            this.label = 1;
        } else {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    int intValue = ((Number) obj).intValue();
                    mutableStateFlow2 = this.this$0.willReceiveState;
                    this.I$0 = intValue;
                    this.label = 3;
                } else if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }
}
