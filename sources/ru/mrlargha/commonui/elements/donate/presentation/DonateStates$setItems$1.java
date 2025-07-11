package ru.mrlargha.commonui.elements.donate.presentation;

import android.util.Log;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.mrlargha.commonui.elements.donate.domain.ResultState;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateBadgesModel;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateItemModel;
import ru.mrlargha.commonui.elements.donate.domain.usecases.DonateGetItemUseCase;
import ru.mrlargha.commonui.elements.donate.presentation.models.DonateItemModelUiKt;
import ru.mrlargha.commonui.elements.donate.utils.DonateUtilsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DonateStates.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.DonateStates$setItems$1", f = "DonateStates.kt", i = {}, l = {104, 105}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class DonateStates$setItems$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $categoriesId;
    final /* synthetic */ boolean $isActionCategory;
    int label;
    final /* synthetic */ DonateStates this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonateStates$setItems$1(DonateStates donateStates, boolean z, int i, Continuation<? super DonateStates$setItems$1> continuation) {
        super(2, continuation);
        this.this$0 = donateStates;
        this.$isActionCategory = z;
        this.$categoriesId = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DonateStates$setItems$1(this.this$0, this.$isActionCategory, this.$categoriesId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DonateStates$setItems$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
        if (r8.emit(ru.mrlargha.commonui.elements.donate.presentation.UiState.Loading.INSTANCE, r7) == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0058, code lost:
        if (kotlinx.coroutines.flow.FlowKt.collectLatest(r8.getItemList(), new ru.mrlargha.commonui.elements.donate.presentation.DonateStates$setItems$1.AnonymousClass1(r7.this$0, r7.$isActionCategory, r7.$categoriesId, null), r7) == r0) goto L14;
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
    @DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.presentation.DonateStates$setItems$1$1", f = "DonateStates.kt", i = {0, 1, 1, 1, 2, 2, 2}, l = {108, TsExtractor.TS_STREAM_TYPE_DTS, 140}, m = "invokeSuspend", n = {RemoteConfigConstants.ResponseFieldKey.STATE, RemoteConfigConstants.ResponseFieldKey.STATE, "sortItems", "actionSortItem", RemoteConfigConstants.ResponseFieldKey.STATE, "sortItems", "actionSortItem"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    /* renamed from: ru.mrlargha.commonui.elements.donate.presentation.DonateStates$setItems$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ResultState<? extends List<? extends DonateItemModel>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $categoriesId;
        final /* synthetic */ boolean $isActionCategory;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
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

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:
            if (r3.emit(new ru.mrlargha.commonui.elements.donate.presentation.UiState.Error(((ru.mrlargha.commonui.elements.donate.domain.ResultState.Error) r1).getMessage()), r42) == r2) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x02d8, code lost:
            if (r3.emit(new ru.mrlargha.commonui.elements.donate.presentation.UiState.Successful(r6), r42) == r2) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x0329, code lost:
            if (r3.emit(new ru.mrlargha.commonui.elements.donate.presentation.UiState.Successful(r6), r42) == r2) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x032b, code lost:
            return r2;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            MutableStateFlow mutableStateFlow;
            MutableStateFlow mutableStateFlow2;
            List list;
            DonateBadgesModel donateBadgesModel;
            int i;
            DonateBadgesModel donateBadgesModel2;
            MutableStateFlow mutableStateFlow3;
            ResultState resultState = (ResultState) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2 && i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    List list2 = (List) this.L$2;
                    List list3 = (List) this.L$1;
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
                    ResultState.Success success = (ResultState.Success) resultState;
                    Iterable iterable = (Iterable) success.getData();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Boxing.boxInt(Log.d(DonateUtilsKt.DONATE_TAG, "setItems: " + ((DonateItemModel) it.next()).getName())));
                    }
                    int i3 = this.$categoriesId;
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj2 : (Iterable) success.getData()) {
                        if (((DonateItemModel) obj2).getCategory() == i3) {
                            arrayList2.add(obj2);
                        }
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj3 : arrayList2) {
                        if (((DonateItemModel) obj3).getVisible() == 1) {
                            arrayList3.add(obj3);
                        }
                    }
                    List sortedWith = CollectionsKt.sortedWith(arrayList3, new Comparator() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateStates$setItems$1$1$invokeSuspend$$inlined$sortedBy$1
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(Integer.valueOf(((DonateItemModel) t).getPosition()), Integer.valueOf(((DonateItemModel) t2).getPosition()));
                        }
                    });
                    DonateStates donateStates = this.this$0;
                    ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith, 10));
                    Iterator it2 = sortedWith.iterator();
                    while (true) {
                        List list4 = null;
                        if (!it2.hasNext()) {
                            break;
                        }
                        DonateItemModel donateItemModel = (DonateItemModel) it2.next();
                        if (donateItemModel.getLeftUnixTime() > 0) {
                            List<DonateBadgesModel> badges = donateItemModel.getBadges();
                            if (badges != null) {
                                donateBadgesModel2 = donateStates.badgesTime;
                                list4 = CollectionsKt.plus((Collection<? extends DonateBadgesModel>) badges, DonateBadgesModel.copy$default(donateBadgesModel2, null, String.valueOf(donateItemModel.getLeftUnixTime()), null, 5, null));
                            }
                            donateItemModel = DonateItemModel.copy$default(donateItemModel, 0, 0, null, null, 0, 0, 0, 0, 0, 0, null, null, 0, null, 0, 0, 0, list4, 0, null, 0, 0, 0, null, 0, 0, 66977791, null);
                        }
                        arrayList4.add(donateItemModel);
                    }
                    ArrayList arrayList5 = arrayList4;
                    DonateStates donateStates2 = this.this$0;
                    ArrayList arrayList6 = new ArrayList();
                    for (Object obj4 : (Iterable) success.getData()) {
                        DonateItemModel donateItemModel2 = (DonateItemModel) obj4;
                        if (donateItemModel2.getDiscount() <= 0) {
                            int category = donateItemModel2.getCategory();
                            i = donateStates2.currentCategory;
                            if (category == i) {
                            }
                        }
                        arrayList6.add(obj4);
                    }
                    ArrayList arrayList7 = new ArrayList();
                    for (Object obj5 : arrayList6) {
                        if (((DonateItemModel) obj5).getVisible() == 1) {
                            arrayList7.add(obj5);
                        }
                    }
                    List<DonateItemModel> sortedWith2 = CollectionsKt.sortedWith(arrayList7, new Comparator() { // from class: ru.mrlargha.commonui.elements.donate.presentation.DonateStates$setItems$1$1$invokeSuspend$$inlined$sortedBy$2
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(Integer.valueOf(((DonateItemModel) t).getPosition()), Integer.valueOf(((DonateItemModel) t2).getPosition()));
                        }
                    });
                    DonateStates donateStates3 = this.this$0;
                    ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith2, 10));
                    for (DonateItemModel donateItemModel3 : sortedWith2) {
                        if (donateItemModel3.getLeftUnixTime() > 0) {
                            List<DonateBadgesModel> badges2 = donateItemModel3.getBadges();
                            if (badges2 != null) {
                                donateBadgesModel = donateStates3.badgesTime;
                                list = CollectionsKt.plus((Collection<? extends DonateBadgesModel>) badges2, DonateBadgesModel.copy$default(donateBadgesModel, null, String.valueOf(donateItemModel3.getLeftUnixTime()), null, 5, null));
                            } else {
                                list = null;
                            }
                            donateItemModel3 = DonateItemModel.copy$default(donateItemModel3, 0, 0, null, null, 0, 0, 0, 0, 0, 0, null, null, 0, null, 0, 0, 0, list, 0, null, 0, 0, 0, null, 0, 0, 66977791, null);
                        }
                        arrayList8.add(donateItemModel3);
                    }
                    ArrayList arrayList9 = arrayList8;
                    if (this.$isActionCategory) {
                        mutableStateFlow2 = this.this$0._itemsState;
                        ArrayList<DonateItemModel> arrayList10 = arrayList9;
                        ArrayList arrayList11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList10, 10));
                        for (DonateItemModel donateItemModel4 : arrayList10) {
                            arrayList11.add(DonateItemModelUiKt.toUi(donateItemModel4));
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(resultState);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(arrayList5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(arrayList9);
                        this.label = 2;
                    } else {
                        mutableStateFlow = this.this$0._itemsState;
                        ArrayList<DonateItemModel> arrayList12 = arrayList5;
                        ArrayList arrayList13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList12, 10));
                        for (DonateItemModel donateItemModel5 : arrayList12) {
                            arrayList13.add(DonateItemModelUiKt.toUi(donateItemModel5));
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable(resultState);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(arrayList5);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(arrayList9);
                        this.label = 3;
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }
}
