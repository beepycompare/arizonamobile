package com.arizonagames.feature.arizona.bank;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BankScreen.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizonagames.feature.arizona.bank.BankScreen", f = "BankScreen.kt", i = {}, l = {745}, m = "loadGiveawayPrizesOrNull", n = {}, nl = {746}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class BankScreen$loadGiveawayPrizesOrNull$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BankScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankScreen$loadGiveawayPrizesOrNull$1(BankScreen bankScreen, Continuation<? super BankScreen$loadGiveawayPrizesOrNull$1> continuation) {
        super(continuation);
        this.this$0 = bankScreen;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object loadGiveawayPrizesOrNull;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadGiveawayPrizesOrNull = this.this$0.loadGiveawayPrizesOrNull(this);
        return loadGiveawayPrizesOrNull;
    }
}
