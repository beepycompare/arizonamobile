package ru.mrlargha.commonui.elements.donate.domain.usecases;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.mrlargha.commonui.elements.donate.domain.ResultState;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateBadgesModel;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateItemModel;
import ru.mrlargha.commonui.elements.donate.domain.repositories.DonateRepository;
/* compiled from: DonateGetItemUseCase.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/donate/domain/usecases/DonateGetItemUseCase;", "", "repository", "Lru/mrlargha/commonui/elements/donate/domain/repositories/DonateRepository;", "<init>", "(Lru/mrlargha/commonui/elements/donate/domain/repositories/DonateRepository;)V", "getRepository", "()Lru/mrlargha/commonui/elements/donate/domain/repositories/DonateRepository;", "_itemList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lru/mrlargha/commonui/elements/donate/domain/ResultState;", "", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateItemModel;", "updatedItem", "", "itemList", "Lkotlinx/coroutines/flow/StateFlow;", "getItemList", "()Lkotlinx/coroutines/flow/StateFlow;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "updateItem", "", "item", "(Lru/mrlargha/commonui/elements/donate/domain/models/DonateItemModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateGetItemUseCase {
    private final MutableStateFlow<ResultState<List<DonateItemModel>>> _itemList;
    private final StateFlow<ResultState<List<DonateItemModel>>> itemList;
    private final DonateRepository repository;
    private final CoroutineScope scope;
    private final List<DonateItemModel> updatedItem;

    public DonateGetItemUseCase(DonateRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
        MutableStateFlow<ResultState<List<DonateItemModel>>> MutableStateFlow = StateFlowKt.MutableStateFlow(new ResultState.Success(CollectionsKt.emptyList()));
        this._itemList = MutableStateFlow;
        this.updatedItem = new ArrayList();
        this.itemList = FlowKt.asStateFlow(MutableStateFlow);
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.scope = CoroutineScope;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
    }

    public final DonateRepository getRepository() {
        return this.repository;
    }

    public final StateFlow<ResultState<List<DonateItemModel>>> getItemList() {
        return this.itemList;
    }

    /* compiled from: DonateGetItemUseCase.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.domain.usecases.DonateGetItemUseCase$1", f = "DonateGetItemUseCase.kt", i = {1, 2, 2, 2, 2, 2, 2}, l = {29, 30, 34}, m = "invokeSuspend", n = {FirebaseAnalytics.Param.ITEMS, FirebaseAnalytics.Param.ITEMS, "$this$forEach$iv", "element$iv", "updatedModel", "$i$f$forEach", "$i$a$-forEach-DonateGetItemUseCase$1$1"}, s = {"L$0", "L$0", "L$1", "L$4", "L$5", "I$0", "I$1"}, v = 1)
    /* renamed from: ru.mrlargha.commonui.elements.donate.domain.usecases.DonateGetItemUseCase$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0053, code lost:
            if (r11 == r0) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x006f, code lost:
            if (r10.this$0._itemList.emit(r1, r10) == r0) goto L13;
         */
        /* JADX WARN: Removed duplicated region for block: B:23:0x009a  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ResultState resultState;
            DonateGetItemUseCase donateGetItemUseCase;
            Iterator it;
            Iterable iterable;
            ResultState resultState2;
            int i;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = DonateGetItemUseCase.this.getRepository().getItems(this);
            } else if (i2 != 1) {
                if (i2 == 2) {
                    resultState = (ResultState) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (!DonateGetItemUseCase.this.updatedItem.isEmpty()) {
                        List list = DonateGetItemUseCase.this.updatedItem;
                        donateGetItemUseCase = DonateGetItemUseCase.this;
                        it = list.iterator();
                        iterable = list;
                        resultState2 = resultState;
                        i = 0;
                        while (it.hasNext()) {
                        }
                        DonateGetItemUseCase.this.updatedItem.clear();
                    }
                    return Unit.INSTANCE;
                } else if (i2 == 3) {
                    i = this.I$0;
                    DonateItemModel donateItemModel = (DonateItemModel) this.L$5;
                    it = (Iterator) this.L$3;
                    donateGetItemUseCase = (DonateGetItemUseCase) this.L$2;
                    iterable = (Iterable) this.L$1;
                    resultState2 = (ResultState) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    while (it.hasNext()) {
                        Object next = it.next();
                        DonateItemModel donateItemModel2 = (DonateItemModel) next;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(resultState2);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(iterable);
                        this.L$2 = donateGetItemUseCase;
                        this.L$3 = it;
                        this.L$4 = SpillingKt.nullOutSpilledVariable(next);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(donateItemModel2);
                        this.I$0 = i;
                        this.I$1 = 0;
                        this.label = 3;
                        if (donateGetItemUseCase.updateItem(donateItemModel2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    DonateGetItemUseCase.this.updatedItem.clear();
                    return Unit.INSTANCE;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
            }
            resultState = (ResultState) obj;
            this.L$0 = SpillingKt.nullOutSpilledVariable(resultState);
            this.label = 2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x0188, code lost:
        if (r4 == null) goto L106;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateItem(DonateItemModel donateItemModel, Continuation<? super Unit> continuation) {
        List<DonateBadgesModel> badges;
        ResultState<List<DonateItemModel>> value = this._itemList.getValue();
        if (value instanceof ResultState.Success) {
            List mutableList = CollectionsKt.toMutableList((Collection) ((ResultState.Success) value).getData());
            Iterator it = mutableList.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (((DonateItemModel) it.next()).getKey() == donateItemModel.getKey()) {
                    break;
                } else {
                    i++;
                }
            }
            if (mutableList.isEmpty()) {
                Boxing.boxBoolean(this.updatedItem.add(donateItemModel));
            } else if (i != -1) {
                DonateItemModel donateItemModel2 = (DonateItemModel) mutableList.get(i);
                int position = donateItemModel.getPosition() > -1 ? donateItemModel.getPosition() : donateItemModel2.getPosition();
                String name = donateItemModel.getName();
                if (name.length() == 0) {
                    name = donateItemModel2.getName();
                }
                String str = name;
                String description = donateItemModel.getDescription();
                if (description.length() == 0) {
                    description = donateItemModel2.getDescription();
                }
                String str2 = description;
                int price = donateItemModel.getPrice() > -1 ? donateItemModel.getPrice() : donateItemModel2.getPrice();
                int priceCurrency = donateItemModel.getPriceCurrency() > -1 ? donateItemModel.getPriceCurrency() : donateItemModel2.getPriceCurrency();
                int discount = donateItemModel.getDiscount() > 0 ? donateItemModel.getDiscount() : donateItemModel2.getDiscount();
                int discountPrice = donateItemModel.getDiscountPrice() > 0 ? donateItemModel.getDiscountPrice() : donateItemModel2.getDiscountPrice();
                int typeTemplate = donateItemModel.getTypeTemplate() > -1 ? donateItemModel.getTypeTemplate() : donateItemModel2.getTypeTemplate();
                int iconButton = donateItemModel.getIconButton() > -1 ? donateItemModel.getIconButton() : donateItemModel2.getIconButton();
                int isEnable = donateItemModel.isEnable() > -1 ? donateItemModel.isEnable() : donateItemModel2.isEnable();
                List<String> colorListButton = donateItemModel.getColorListButton();
                if (colorListButton.isEmpty()) {
                    colorListButton = donateItemModel2.getColorListButton();
                }
                List<String> list = colorListButton;
                String titleButton = donateItemModel.getTitleButton();
                if (titleButton.length() == 0) {
                    titleButton = donateItemModel2.getTitleButton();
                }
                String str3 = titleButton;
                int image = donateItemModel.getImage() > -1 ? donateItemModel.getImage() : donateItemModel2.getImage();
                String imageEffect = donateItemModel.getImageEffect();
                if (imageEffect.length() == 0) {
                    imageEffect = donateItemModel2.getImageEffect();
                }
                String str4 = imageEffect;
                int backgroundId = donateItemModel.getBackgroundId() > -1 ? donateItemModel.getBackgroundId() : donateItemModel2.getBackgroundId();
                int leftUnixTime = donateItemModel.getLeftUnixTime() > -1 ? donateItemModel.getLeftUnixTime() : donateItemModel2.getLeftUnixTime();
                List<DonateBadgesModel> badges2 = donateItemModel.getBadges();
                if (badges2 != null) {
                    List<DonateBadgesModel> list2 = badges2;
                    if (list2.isEmpty()) {
                        list2 = donateItemModel2.getBadges();
                    }
                    badges = list2;
                }
                badges = donateItemModel2.getBadges();
                List<DonateBadgesModel> list3 = badges;
                int animation = donateItemModel.getAnimation() > -1 ? donateItemModel.getAnimation() : donateItemModel2.getAnimation();
                List<String> textGradientColor = donateItemModel.getTextGradientColor();
                if (textGradientColor.isEmpty()) {
                    textGradientColor = donateItemModel2.getTextGradientColor();
                }
                List<String> list4 = textGradientColor;
                int totalEarnings = donateItemModel.getTotalEarnings() > -1 ? donateItemModel.getTotalEarnings() : donateItemModel2.getTotalEarnings();
                int gifId = donateItemModel.getGifId() > -1 ? donateItemModel.getGifId() : donateItemModel2.getGifId();
                int blockedType = donateItemModel.getBlockedType() > -1 ? donateItemModel.getBlockedType() : donateItemModel2.getBlockedType();
                String blockedReason = donateItemModel.getBlockedReason();
                if (blockedReason.length() == 0) {
                    blockedReason = donateItemModel2.getBlockedReason();
                }
                mutableList.set(i, DonateItemModel.copy$default(donateItemModel2, 0, position, str, str2, price, priceCurrency, 0, typeTemplate, iconButton, isEnable, list, str3, image, str4, discount, backgroundId, discountPrice, list3, blockedType, blockedReason, leftUnixTime, donateItemModel.getVisible() > -1 ? donateItemModel.getVisible() : donateItemModel2.getVisible(), animation, list4, totalEarnings, gifId, 0, 67108929, null));
                Object emit = this._itemList.emit(new ResultState.Success(mutableList), continuation);
                return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
