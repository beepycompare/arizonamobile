package com.arizonagames.feature.arizona.bank;

import com.arizonagames.feature.arizona.bank.data.BankApiRepository;
import com.arizonagames.feature.arizona.bank.data.BankHistoryApiFormatterKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BankScreen.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizonagames.feature.arizona.bank.BankScreen$requestAccountHistory$1", f = "BankScreen.kt", i = {}, l = {763}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class BankScreen$requestAccountHistory$1 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ int $accountNumber;
    int label;
    final /* synthetic */ BankScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankScreen$requestAccountHistory$1(BankScreen bankScreen, int i, Continuation<? super BankScreen$requestAccountHistory$1> continuation) {
        super(1, continuation);
        this.this$0 = bankScreen;
        this.$accountNumber = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new BankScreen$requestAccountHistory$1(this.this$0, this.$accountNumber, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super String> continuation) {
        return ((BankScreen$requestAccountHistory$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BankApiRepository bankApiRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            bankApiRepository = this.this$0.bankApiRepository;
            this.label = 1;
            obj = bankApiRepository.getAccountHistory(this.$accountNumber, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return BankHistoryApiFormatterKt.toAccountHistoryDialogBody((List) obj);
    }
}
