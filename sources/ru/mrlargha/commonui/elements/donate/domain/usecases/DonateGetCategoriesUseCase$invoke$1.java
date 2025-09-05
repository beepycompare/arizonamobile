package ru.mrlargha.commonui.elements.donate.domain.usecases;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DonateGetCategoriesUseCase.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.domain.usecases.DonateGetCategoriesUseCase", f = "DonateGetCategoriesUseCase.kt", i = {}, l = {10}, m = "invoke", n = {}, s = {})
/* loaded from: classes5.dex */
public final class DonateGetCategoriesUseCase$invoke$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DonateGetCategoriesUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateGetCategoriesUseCase$invoke$1(DonateGetCategoriesUseCase donateGetCategoriesUseCase, Continuation<? super DonateGetCategoriesUseCase$invoke$1> continuation) {
        super(continuation);
        this.this$0 = donateGetCategoriesUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(this);
    }
}
