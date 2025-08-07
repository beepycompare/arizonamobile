package ru.mrlargha.commonui.elements.donate.presentation;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import ru.mrlargha.commonui.elements.donate.domain.ResultState;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateItemModel;
import ru.mrlargha.commonui.elements.donate.domain.usecases.DonateGetItemUseCase;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DonateStates.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.DonateStates$setItemsArizona$1", f = "DonateStates.kt", i = {}, l = {104, 105}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class DonateStates$setItemsArizona$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $categoriesId;
    final /* synthetic */ boolean $isActionCategory;
    int label;
    final /* synthetic */ DonateStates this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateStates$setItemsArizona$1(DonateStates donateStates, boolean z, int i, Continuation<? super DonateStates$setItemsArizona$1> continuation) {
        super(2, continuation);
        this.this$0 = donateStates;
        this.$isActionCategory = z;
        this.$categoriesId = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DonateStates$setItemsArizona$1(this.this$0, this.$isActionCategory, this.$categoriesId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DonateStates$setItemsArizona$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
        if (r7.emit(ru.mrlargha.commonui.elements.donate.presentation.UiState.Loading.INSTANCE, r6) == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0055, code lost:
        if (r7.collect(new ru.mrlargha.commonui.elements.donate.presentation.DonateStates$setItemsArizona$1.AnonymousClass1<>(), r6) == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        DonateGetItemUseCase donateGetItemUseCase;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._itemsState;
            this.label = 1;
        } else if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw new KotlinNothingValueException();
        } else {
            ResultKt.throwOnFailure(obj);
        }
        donateGetItemUseCase = this.this$0.getItemsUseCase;
        StateFlow<ResultState<List<DonateItemModel>>> itemList = donateGetItemUseCase.getItemList();
        final DonateStates donateStates = this.this$0;
        final boolean z = this.$isActionCategory;
        final int i2 = this.$categoriesId;
        this.label = 2;
    }
}
