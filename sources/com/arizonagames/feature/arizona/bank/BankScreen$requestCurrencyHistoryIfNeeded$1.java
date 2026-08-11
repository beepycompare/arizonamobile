package com.arizonagames.feature.arizona.bank;

import com.arizonagames.feature.arizona.bank.data.BankApiRepository;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import ru.mrlargha.commonui.utils.MapperKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BankScreen.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizonagames.feature.arizona.bank.BankScreen$requestCurrencyHistoryIfNeeded$1", f = "BankScreen.kt", i = {0, 0, 1, 1}, l = {633, 636}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$this$launch", "history"}, nl = {632, 654}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 2)
/* loaded from: classes3.dex */
public final class BankScreen$requestCurrencyHistoryIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $requestGeneration;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ BankScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankScreen$requestCurrencyHistoryIfNeeded$1(BankScreen bankScreen, int i, Continuation<? super BankScreen$requestCurrencyHistoryIfNeeded$1> continuation) {
        super(2, continuation);
        this.this$0 = bankScreen;
        this.$requestGeneration = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BankScreen$requestCurrencyHistoryIfNeeded$1 bankScreen$requestCurrencyHistoryIfNeeded$1 = new BankScreen$requestCurrencyHistoryIfNeeded$1(this.this$0, this.$requestGeneration, continuation);
        bankScreen$requestCurrencyHistoryIfNeeded$1.L$0 = obj;
        return bankScreen$requestCurrencyHistoryIfNeeded$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BankScreen$requestCurrencyHistoryIfNeeded$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x008d, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.arizonagames.feature.arizona.bank.BankScreen$requestCurrencyHistoryIfNeeded$1.AnonymousClass1(r8.$requestGeneration, r8.this$0, r9, null), r8) == r1) goto L20;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object m9915constructorimpl;
        BankApiRepository bankApiRepository;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Throwable th) {
            Result.Companion companion = Result.Companion;
            m9915constructorimpl = Result.m9915constructorimpl(ResultKt.createFailure(th));
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BankScreen bankScreen = this.this$0;
            Result.Companion companion2 = Result.Companion;
            bankApiRepository = bankScreen.bankApiRepository;
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.label = 1;
            obj = bankApiRepository.getCurrencyHistory(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            if (i == 2) {
                BankCurrencyHistoryPayload bankCurrencyHistoryPayload = (BankCurrencyHistoryPayload) this.L$1;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$1;
            ResultKt.throwOnFailure(obj);
        }
        m9915constructorimpl = Result.m9915constructorimpl((BankCurrencyHistoryPayload) obj);
        if (Result.m9921isFailureimpl(m9915constructorimpl)) {
            m9915constructorimpl = null;
        }
        BankCurrencyHistoryPayload bankCurrencyHistoryPayload2 = (BankCurrencyHistoryPayload) m9915constructorimpl;
        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
        this.L$1 = SpillingKt.nullOutSpilledVariable(bankCurrencyHistoryPayload2);
        this.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BankScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.arizonagames.feature.arizona.bank.BankScreen$requestCurrencyHistoryIfNeeded$1$1", f = "BankScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    /* renamed from: com.arizonagames.feature.arizona.bank.BankScreen$requestCurrencyHistoryIfNeeded$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BankCurrencyHistoryPayload $history;
        final /* synthetic */ int $requestGeneration;
        int label;
        final /* synthetic */ BankScreen this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, BankScreen bankScreen, BankCurrencyHistoryPayload bankCurrencyHistoryPayload, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$requestGeneration = i;
            this.this$0 = bankScreen;
            this.$history = bankCurrencyHistoryPayload;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$requestGeneration, this.this$0, this.$history, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            int i2 = this.$requestGeneration;
            i = this.this$0.openingStateGeneration;
            if (i2 == i) {
                this.this$0.isCurrencyHistoryRequestInFlight = false;
                if (this.$history != null) {
                    this.this$0.hasRequestedCurrencyHistory = true;
                    BankScreen bankScreen = this.this$0;
                    Gson gson = MapperKt.getGson();
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.add("currencyHistory", MapperKt.getGson().toJsonTree(this.$history.getCurrencies()));
                    Unit unit = Unit.INSTANCE;
                    String json = gson.toJson((JsonElement) jsonObject);
                    Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
                    bankScreen.applyPartialPayload(json);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }
}
