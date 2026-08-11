package com.arizonagames.feature.arizona.bank.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BankApiRepository.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizonagames.feature.arizona.bank.data.BankApiRepository", f = "BankApiRepository.kt", i = {}, l = {25}, m = "getCurrencyHistory", n = {}, nl = {-1}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class BankApiRepository$getCurrencyHistory$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BankApiRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankApiRepository$getCurrencyHistory$1(BankApiRepository bankApiRepository, Continuation<? super BankApiRepository$getCurrencyHistory$1> continuation) {
        super(continuation);
        this.this$0 = bankApiRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getCurrencyHistory(this);
    }
}
