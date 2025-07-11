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
import ru.mrlargha.commonui.elements.donate.data.repositories.DonateRepositoryImpl;
import ru.mrlargha.commonui.elements.donate.domain.ResultState;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateBoostModel;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateBoostModelUiKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DonateStates.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.DonateStates$setBoosts$1", f = "DonateStates.kt", i = {1, 2}, l = {150, 152, 156}, m = "invokeSuspend", n = {RemoteConfigConstants.ResponseFieldKey.STATE, RemoteConfigConstants.ResponseFieldKey.STATE}, s = {"L$0", "L$0"})
/* loaded from: classes5.dex */
public final class DonateStates$setBoosts$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DonateStates this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateStates$setBoosts$1(DonateStates donateStates, Continuation<? super DonateStates$setBoosts$1> continuation) {
        super(2, continuation);
        this.this$0 = donateStates;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DonateStates$setBoosts$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DonateStates$setBoosts$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (r7 == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
        if (r1.emit(new ru.mrlargha.commonui.elements.donate.presentation.UiState.Error(((ru.mrlargha.commonui.elements.donate.domain.ResultState.Error) r7).getMessage()), r6) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00bc, code lost:
        if (r1.emit(new ru.mrlargha.commonui.elements.donate.presentation.UiState.Successful(r4), r6) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00be, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        DonateRepositoryImpl donateRepositoryImpl;
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            donateRepositoryImpl = this.this$0.repository;
            this.label = 1;
            obj = donateRepositoryImpl.getBoost(this);
        } else if (i != 1) {
            if (i == 2 || i == 3) {
                ResultState resultState = (ResultState) this.L$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        ResultState resultState2 = (ResultState) obj;
        if (resultState2 instanceof ResultState.Error) {
            mutableStateFlow2 = this.this$0._boostState;
            this.L$0 = SpillingKt.nullOutSpilledVariable(resultState2);
            this.label = 2;
        } else if (resultState2 instanceof ResultState.Success) {
            mutableStateFlow = this.this$0._boostState;
            Object data = ((ResultState.Success) resultState2).getData();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.collections.List<ru.mrlargha.commonui.elements.donate.domain.models.DonateBoostModel>");
            List<DonateBoostModel> list = (List) data;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (DonateBoostModel donateBoostModel : list) {
                arrayList.add(DonateBoostModelUiKt.toUi(donateBoostModel));
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(resultState2);
            this.label = 3;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
