package com.miami.game.core.play.country.billing;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BillingPlayCountryResolver.kt */
@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.play.country.billing.BillingPlayCountryResolver", f = "BillingPlayCountryResolver.kt", i = {0}, l = {24}, m = "getCountryIso", n = {"$this$getCountryIso_u24lambda_u240"}, nl = {26}, s = {"L$0"}, v = 2)
/* loaded from: classes5.dex */
public final class BillingPlayCountryResolver$getCountryIso$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BillingPlayCountryResolver this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillingPlayCountryResolver$getCountryIso$1(BillingPlayCountryResolver billingPlayCountryResolver, Continuation<? super BillingPlayCountryResolver$getCountryIso$1> continuation) {
        super(continuation);
        this.this$0 = billingPlayCountryResolver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getCountryIso(this);
    }
}
