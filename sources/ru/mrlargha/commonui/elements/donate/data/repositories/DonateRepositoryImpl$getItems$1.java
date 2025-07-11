package ru.mrlargha.commonui.elements.donate.data.repositories;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DonateRepositoryImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.data.repositories.DonateRepositoryImpl", f = "DonateRepositoryImpl.kt", i = {}, l = {31}, m = "getItems", n = {}, s = {})
/* loaded from: classes5.dex */
public final class DonateRepositoryImpl$getItems$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DonateRepositoryImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateRepositoryImpl$getItems$1(DonateRepositoryImpl donateRepositoryImpl, Continuation<? super DonateRepositoryImpl$getItems$1> continuation) {
        super(continuation);
        this.this$0 = donateRepositoryImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getItems(this);
    }
}
