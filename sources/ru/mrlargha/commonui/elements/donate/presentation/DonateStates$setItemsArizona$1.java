package ru.mrlargha.commonui.elements.donate.presentation;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.BuildConfig;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.mrlargha.commonui.elements.donate.domain.ResultState;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateItemModel;
import ru.mrlargha.commonui.elements.donate.domain.usecases.DonateGetItemUseCase;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemModelUiKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DonateStates.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.DonateStates$setItemsArizona$1", f = "DonateStates.kt", i = {}, l = {102, 103}, m = "invokeSuspend", n = {}, s = {})
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
        if (r8.emit(ru.mrlargha.commonui.elements.donate.presentation.UiState.Loading.INSTANCE, r7) == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0058, code lost:
        if (kotlinx.coroutines.flow.FlowKt.collectLatest(r8.getItemList(), new ru.mrlargha.commonui.elements.donate.presentation.DonateStates$setItemsArizona$1.AnonymousClass1(r7.this$0, r7.$isActionCategory, r7.$categoriesId, null), r7) == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005a, code lost:
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
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        donateGetItemUseCase = this.this$0.getItemsUseCase;
        this.label = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DonateStates.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\n"}, d2 = {"<anonymous>", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Lru/mrlargha/commonui/elements/donate/domain/ResultState;", "", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateItemModel;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.DonateStates$setItemsArizona$1$1", f = "DonateStates.kt", i = {0, 1, 1, 2, 2}, l = {106, 112, BuildConfig.API_LEVEL}, m = "invokeSuspend", n = {RemoteConfigConstants.ResponseFieldKey.STATE, RemoteConfigConstants.ResponseFieldKey.STATE, "actionSortItem", RemoteConfigConstants.ResponseFieldKey.STATE, "sortItems"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"})
    /* renamed from: ru.mrlargha.commonui.elements.donate.presentation.DonateStates$setItemsArizona$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ResultState<? extends List<? extends DonateItemModel>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $categoriesId;
        final /* synthetic */ boolean $isActionCategory;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ DonateStates this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DonateStates donateStates, boolean z, int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = donateStates;
            this.$isActionCategory = z;
            this.$categoriesId = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$isActionCategory, this.$categoriesId, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(ResultState<? extends List<? extends DonateItemModel>> resultState, Continuation<? super Unit> continuation) {
            return invoke2((ResultState<? extends List<DonateItemModel>>) resultState, continuation);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object invoke2(ResultState<? extends List<DonateItemModel>> resultState, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(resultState, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:
            if (r8.emit(new ru.mrlargha.commonui.elements.donate.presentation.UiState.Error(((ru.mrlargha.commonui.elements.donate.domain.ResultState.Error) r0).getMessage()), r7) == r1) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00b4, code lost:
            if (r3.emit(new ru.mrlargha.commonui.elements.donate.presentation.UiState.Successful(r6), r7) == r1) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0110, code lost:
            if (r4.emit(new ru.mrlargha.commonui.elements.donate.presentation.UiState.Successful(r6), r7) == r1) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0112, code lost:
            return r1;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            List filterItemOrdinary;
            MutableStateFlow mutableStateFlow;
            List filterItemByAction;
            MutableStateFlow mutableStateFlow2;
            MutableStateFlow mutableStateFlow3;
            ResultState resultState = (ResultState) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2 && i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    List list = (List) this.L$1;
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                if (resultState instanceof ResultState.Error) {
                    mutableStateFlow3 = this.this$0._itemsState;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(resultState);
                    this.label = 1;
                } else if (!(resultState instanceof ResultState.Success)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    if (this.$isActionCategory) {
                        filterItemByAction = this.this$0.filterItemByAction((List) ((ResultState.Success) resultState).getData());
                        mutableStateFlow2 = this.this$0._itemsState;
                        List<DonateItemModel> list2 = filterItemByAction;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                        for (DonateItemModel donateItemModel : list2) {
                            arrayList.add(DonateItemModelUiKt.toUi(donateItemModel));
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(resultState);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(filterItemByAction);
                        this.label = 2;
                    } else {
                        filterItemOrdinary = this.this$0.filterItemOrdinary(this.$categoriesId, (List) ((ResultState.Success) resultState).getData());
                        mutableStateFlow = this.this$0._itemsState;
                        List<DonateItemModel> list3 = filterItemOrdinary;
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                        for (DonateItemModel donateItemModel2 : list3) {
                            arrayList2.add(DonateItemModelUiKt.toUi(donateItemModel2));
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(resultState);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(filterItemOrdinary);
                        this.label = 3;
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }
}
