package ru.mrlargha.commonui.elements.donate.presentation;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.mrlargha.commonui.elements.donate.domain.ResultState;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateCategoryModel;
import ru.mrlargha.commonui.elements.donate.domain.usecases.DonateGetCategoriesUseCase;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateCategoryModelUiKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DonateStates.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.DonateStates$setCategories$1", f = "DonateStates.kt", i = {1, 2, 2}, l = {82, 84, 92}, m = "invokeSuspend", n = {RemoteConfigConstants.ResponseFieldKey.STATE, RemoteConfigConstants.ResponseFieldKey.STATE, "categories"}, nl = {83, 87, 82}, s = {"L$0", "L$0", "L$1"}, v = 2)
/* loaded from: classes6.dex */
public final class DonateStates$setCategories$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DonateStates this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateStates$setCategories$1(DonateStates donateStates, Continuation<? super DonateStates$setCategories$1> continuation) {
        super(2, continuation);
        this.this$0 = donateStates;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DonateStates$setCategories$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DonateStates$setCategories$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        if (r7 == r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0068, code lost:
        if (r1.emit(new ru.mrlargha.commonui.elements.donate.presentation.UiState.Error(((ru.mrlargha.commonui.elements.donate.domain.ResultState.Error) r7).getMessage()), r6) == r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00cc, code lost:
        if (r3.emit(new ru.mrlargha.commonui.elements.donate.presentation.UiState.Successful(r1), r6) == r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ce, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        DonateGetCategoriesUseCase donateGetCategoriesUseCase;
        List applyCategoryUpdates;
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            donateGetCategoriesUseCase = this.this$0.getCategoriesUseCase;
            this.label = 1;
            obj = donateGetCategoriesUseCase.invoke(this);
        } else if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                List list = (List) this.L$1;
            }
            ResultState resultState = (ResultState) this.L$0;
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            ResultKt.throwOnFailure(obj);
        }
        ResultState resultState2 = (ResultState) obj;
        if (resultState2 instanceof ResultState.Error) {
            mutableStateFlow2 = this.this$0._categoriesState;
            this.L$0 = SpillingKt.nullOutSpilledVariable(resultState2);
            this.label = 2;
        } else if (!(resultState2 instanceof ResultState.Success)) {
            throw new NoWhenBranchMatchedException();
        } else {
            Object data = ((ResultState.Success) resultState2).getData();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.collections.List<ru.mrlargha.commonui.elements.donate.domain.models.DonateCategoryModel>");
            List<DonateCategoryModel> list2 = (List) data;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (DonateCategoryModel donateCategoryModel : list2) {
                arrayList.add(DonateCategoryModelUiKt.toUi(donateCategoryModel));
            }
            applyCategoryUpdates = this.this$0.applyCategoryUpdates(arrayList);
            mutableStateFlow = this.this$0._categoriesState;
            this.L$0 = SpillingKt.nullOutSpilledVariable(resultState2);
            this.L$1 = SpillingKt.nullOutSpilledVariable(applyCategoryUpdates);
            this.label = 3;
        }
    }
}
