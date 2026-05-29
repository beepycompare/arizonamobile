package ru.mrlargha.commonui.elements.donate.domain.usecases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import ru.mrlargha.commonui.elements.donate.domain.ResultState;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateBadgesModel;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateItemModel;
import ru.mrlargha.commonui.elements.donate.domain.repositories.DonateRepository;
/* compiled from: DonateGetItemUseCase.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lru/mrlargha/commonui/elements/donate/domain/usecases/DonateGetItemUseCase;", "", "repository", "Lru/mrlargha/commonui/elements/donate/domain/repositories/DonateRepository;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lru/mrlargha/commonui/elements/donate/domain/repositories/DonateRepository;Lkotlinx/coroutines/CoroutineScope;)V", "getRepository", "()Lru/mrlargha/commonui/elements/donate/domain/repositories/DonateRepository;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "_itemList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lru/mrlargha/commonui/elements/donate/domain/ResultState;", "", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateItemModel;", "updatedItem", "", "updateMutex", "Lkotlinx/coroutines/sync/Mutex;", "itemList", "Lkotlinx/coroutines/flow/StateFlow;", "getItemList", "()Lkotlinx/coroutines/flow/StateFlow;", "updateItem", "", "item", "(Lru/mrlargha/commonui/elements/donate/domain/models/DonateItemModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateItemLocked", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonateGetItemUseCase {
    private final MutableStateFlow<ResultState<List<DonateItemModel>>> _itemList;
    private final StateFlow<ResultState<List<DonateItemModel>>> itemList;
    private final DonateRepository repository;
    private final CoroutineScope scope;
    private final Mutex updateMutex;
    private final List<DonateItemModel> updatedItem;

    public DonateGetItemUseCase(DonateRepository repository, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.repository = repository;
        this.scope = scope;
        MutableStateFlow<ResultState<List<DonateItemModel>>> MutableStateFlow = StateFlowKt.MutableStateFlow(new ResultState.Success(CollectionsKt.emptyList()));
        this._itemList = MutableStateFlow;
        this.updatedItem = new ArrayList();
        this.updateMutex = MutexKt.Mutex$default(false, 1, null);
        this.itemList = FlowKt.asStateFlow(MutableStateFlow);
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass1(null), 3, null);
    }

    public final DonateRepository getRepository() {
        return this.repository;
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final StateFlow<ResultState<List<DonateItemModel>>> getItemList() {
        return this.itemList;
    }

    /* compiled from: DonateGetItemUseCase.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.domain.usecases.DonateGetItemUseCase$1", f = "DonateGetItemUseCase.kt", i = {1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {35, 108, 37, 43}, m = "invokeSuspend", n = {"items", "$this$withLock_u24default$iv", "$i$f$withLock", "items", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DonateGetItemUseCase$1$1", "items", "$this$withLock_u24default$iv", "pendingUpdates", "$this$forEach$iv", "element$iv", "updatedModel", "$i$f$withLock", "$i$a$-withLock$default-DonateGetItemUseCase$1$1", "$i$f$forEach", "$i$a$-forEach-DonateGetItemUseCase$1$1$1"}, nl = {36, 109, 39, 44}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$3", "L$4", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3"}, v = 2)
    /* renamed from: ru.mrlargha.commonui.elements.donate.domain.usecases.DonateGetItemUseCase$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
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

        /* JADX WARN: Code restructure failed: missing block: B:21:0x008c, code lost:
            if (r2 == r1) goto L16;
         */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00cd  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00cf  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00dd A[Catch: all -> 0x005d, TryCatch #0 {all -> 0x005d, blocks: (B:9:0x003a, B:34:0x00fe, B:36:0x0104, B:39:0x0141, B:14:0x0058, B:31:0x00d1, B:33:0x00dd, B:27:0x00b3), top: B:44:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0104 A[Catch: all -> 0x005d, TryCatch #0 {all -> 0x005d, blocks: (B:9:0x003a, B:34:0x00fe, B:36:0x0104, B:39:0x0141, B:14:0x0058, B:31:0x00d1, B:33:0x00dd, B:27:0x00b3), top: B:44:0x000e }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object items;
            Mutex mutex;
            DonateGetItemUseCase donateGetItemUseCase;
            ResultState resultState;
            int i;
            MutableStateFlow mutableStateFlow;
            int i2;
            int i3;
            List list;
            Iterable iterable;
            ResultState resultState2;
            Iterator it;
            DonateGetItemUseCase donateGetItemUseCase2;
            int i4;
            int i5;
            int i6;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i7 = this.label;
            try {
                if (i7 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    items = DonateGetItemUseCase.this.getRepository().getItems(this);
                } else if (i7 != 1) {
                    if (i7 == 2) {
                        i = this.I$0;
                        donateGetItemUseCase = (DonateGetItemUseCase) this.L$2;
                        ResultKt.throwOnFailure(obj);
                        mutex = (Mutex) this.L$1;
                        resultState = (ResultState) this.L$0;
                        mutableStateFlow = donateGetItemUseCase._itemList;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(resultState);
                        this.L$1 = mutex;
                        this.L$2 = donateGetItemUseCase;
                        this.I$0 = i;
                        this.I$1 = 0;
                        this.label = 3;
                        if (mutableStateFlow.emit(resultState, this) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i2 = i;
                        i3 = 0;
                        if (!donateGetItemUseCase.updatedItem.isEmpty()) {
                        }
                        Unit unit = Unit.INSTANCE;
                        mutex.unlock(null);
                        return Unit.INSTANCE;
                    } else if (i7 == 3) {
                        i3 = this.I$1;
                        i2 = this.I$0;
                        donateGetItemUseCase = (DonateGetItemUseCase) this.L$2;
                        mutex = (Mutex) this.L$1;
                        resultState = (ResultState) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (!donateGetItemUseCase.updatedItem.isEmpty()) {
                            List list2 = CollectionsKt.toList(donateGetItemUseCase.updatedItem);
                            donateGetItemUseCase.updatedItem.clear();
                            List list3 = list2;
                            Iterator it2 = list3.iterator();
                            list = list2;
                            iterable = list3;
                            resultState2 = resultState;
                            it = it2;
                            donateGetItemUseCase2 = donateGetItemUseCase;
                            i4 = i2;
                            i5 = i3;
                            i6 = 0;
                            while (it.hasNext()) {
                            }
                        }
                        Unit unit2 = Unit.INSTANCE;
                        mutex.unlock(null);
                        return Unit.INSTANCE;
                    } else if (i7 == 4) {
                        i6 = this.I$2;
                        i5 = this.I$1;
                        i4 = this.I$0;
                        DonateItemModel donateItemModel = (DonateItemModel) this.L$7;
                        it = (Iterator) this.L$5;
                        iterable = (Iterable) this.L$4;
                        list = (List) this.L$3;
                        donateGetItemUseCase2 = (DonateGetItemUseCase) this.L$2;
                        mutex = (Mutex) this.L$1;
                        resultState2 = (ResultState) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        while (it.hasNext()) {
                            Object next = it.next();
                            DonateItemModel donateItemModel2 = (DonateItemModel) next;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(resultState2);
                            this.L$1 = mutex;
                            this.L$2 = donateGetItemUseCase2;
                            this.L$3 = SpillingKt.nullOutSpilledVariable(list);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(iterable);
                            this.L$5 = it;
                            this.L$6 = SpillingKt.nullOutSpilledVariable(next);
                            this.L$7 = SpillingKt.nullOutSpilledVariable(donateItemModel2);
                            this.I$0 = i4;
                            this.I$1 = i5;
                            this.I$2 = i6;
                            this.I$3 = 0;
                            this.label = 4;
                            if (donateGetItemUseCase2.updateItemLocked(donateItemModel2, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        Unit unit22 = Unit.INSTANCE;
                        mutex.unlock(null);
                        return Unit.INSTANCE;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    items = obj;
                }
                ResultState resultState3 = (ResultState) items;
                Mutex mutex2 = DonateGetItemUseCase.this.updateMutex;
                DonateGetItemUseCase donateGetItemUseCase3 = DonateGetItemUseCase.this;
                this.L$0 = resultState3;
                this.L$1 = mutex2;
                this.L$2 = donateGetItemUseCase3;
                this.I$0 = 0;
                this.label = 2;
                if (mutex2.lock(null, this) != coroutine_suspended) {
                    mutex = mutex2;
                    donateGetItemUseCase = donateGetItemUseCase3;
                    resultState = resultState3;
                    i = 0;
                    mutableStateFlow = donateGetItemUseCase._itemList;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(resultState);
                    this.L$1 = mutex;
                    this.L$2 = donateGetItemUseCase;
                    this.I$0 = i;
                    this.I$1 = 0;
                    this.label = 3;
                    if (mutableStateFlow.emit(resultState, this) != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateItem(DonateItemModel donateItemModel, Continuation<? super Unit> continuation) {
        DonateGetItemUseCase$updateItem$1 donateGetItemUseCase$updateItem$1;
        Object coroutine_suspended;
        int i;
        Mutex mutex;
        int i2;
        Mutex mutex2;
        try {
            if (continuation instanceof DonateGetItemUseCase$updateItem$1) {
                donateGetItemUseCase$updateItem$1 = (DonateGetItemUseCase$updateItem$1) continuation;
                if ((donateGetItemUseCase$updateItem$1.label & Integer.MIN_VALUE) != 0) {
                    donateGetItemUseCase$updateItem$1.label -= Integer.MIN_VALUE;
                    Object obj = donateGetItemUseCase$updateItem$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = donateGetItemUseCase$updateItem$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.updateMutex;
                        donateGetItemUseCase$updateItem$1.L$0 = donateItemModel;
                        donateGetItemUseCase$updateItem$1.L$1 = mutex;
                        donateGetItemUseCase$updateItem$1.I$0 = 0;
                        donateGetItemUseCase$updateItem$1.label = 1;
                        if (mutex.lock(null, donateGetItemUseCase$updateItem$1) != coroutine_suspended) {
                            i2 = 0;
                        }
                        return coroutine_suspended;
                    } else if (i != 1) {
                        if (i == 2) {
                            int i3 = donateGetItemUseCase$updateItem$1.I$1;
                            int i4 = donateGetItemUseCase$updateItem$1.I$0;
                            mutex2 = (Mutex) donateGetItemUseCase$updateItem$1.L$1;
                            DonateItemModel donateItemModel2 = (DonateItemModel) donateGetItemUseCase$updateItem$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                Unit unit = Unit.INSTANCE;
                                mutex2.unlock(null);
                                return Unit.INSTANCE;
                            } catch (Throwable th) {
                                th = th;
                                mutex2.unlock(null);
                                throw th;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        int i5 = donateGetItemUseCase$updateItem$1.I$0;
                        ResultKt.throwOnFailure(obj);
                        mutex = (Mutex) donateGetItemUseCase$updateItem$1.L$1;
                        i2 = i5;
                        donateItemModel = (DonateItemModel) donateGetItemUseCase$updateItem$1.L$0;
                    }
                    donateGetItemUseCase$updateItem$1.L$0 = SpillingKt.nullOutSpilledVariable(donateItemModel);
                    donateGetItemUseCase$updateItem$1.L$1 = mutex;
                    donateGetItemUseCase$updateItem$1.I$0 = i2;
                    donateGetItemUseCase$updateItem$1.I$1 = 0;
                    donateGetItemUseCase$updateItem$1.label = 2;
                    if (updateItemLocked(donateItemModel, donateGetItemUseCase$updateItem$1) != coroutine_suspended) {
                        mutex2 = mutex;
                        Unit unit2 = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                }
            }
            donateGetItemUseCase$updateItem$1.L$0 = SpillingKt.nullOutSpilledVariable(donateItemModel);
            donateGetItemUseCase$updateItem$1.L$1 = mutex;
            donateGetItemUseCase$updateItem$1.I$0 = i2;
            donateGetItemUseCase$updateItem$1.I$1 = 0;
            donateGetItemUseCase$updateItem$1.label = 2;
            if (updateItemLocked(donateItemModel, donateGetItemUseCase$updateItem$1) != coroutine_suspended) {
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            th = th2;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
        donateGetItemUseCase$updateItem$1 = new DonateGetItemUseCase$updateItem$1(this, continuation);
        Object obj2 = donateGetItemUseCase$updateItem$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = donateGetItemUseCase$updateItem$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateItemLocked(DonateItemModel donateItemModel, Continuation<? super Unit> continuation) {
        ResultState<List<DonateItemModel>> value = this._itemList.getValue();
        if (value instanceof ResultState.Success) {
            ResultState.Success success = (ResultState.Success) value;
            if (((List) success.getData()).isEmpty()) {
                this.updatedItem.add(donateItemModel);
                return Unit.INSTANCE;
            }
            Iterable<DonateItemModel> iterable = (Iterable) success.getData();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (DonateItemModel donateItemModel2 : iterable) {
                if (donateItemModel2.getKey() == donateItemModel.getKey()) {
                    int position = donateItemModel.getPosition() > -1 ? donateItemModel.getPosition() : donateItemModel2.getPosition();
                    String name = donateItemModel.getName();
                    if (name == null) {
                        name = donateItemModel2.getName();
                    }
                    String str = name;
                    String description = donateItemModel.getDescription();
                    if (description == null) {
                        description = donateItemModel2.getDescription();
                    }
                    String str2 = description;
                    int price = donateItemModel.getPrice() > -1 ? donateItemModel.getPrice() : donateItemModel2.getPrice();
                    int priceCurrency = donateItemModel.getPriceCurrency() > -1 ? donateItemModel.getPriceCurrency() : donateItemModel2.getPriceCurrency();
                    int category = donateItemModel.getCategory() > -1 ? donateItemModel.getCategory() : donateItemModel2.getCategory();
                    int discount = donateItemModel.getDiscount() > -1 ? donateItemModel.getDiscount() : donateItemModel2.getDiscount();
                    int discountPrice = donateItemModel.getDiscountPrice() > -1 ? donateItemModel.getDiscountPrice() : donateItemModel2.getDiscountPrice();
                    int typeTemplate = donateItemModel.getTypeTemplate() > -1 ? donateItemModel.getTypeTemplate() : donateItemModel2.getTypeTemplate();
                    int iconButton = donateItemModel.getIconButton() > -1 ? donateItemModel.getIconButton() : donateItemModel2.getIconButton();
                    int isEnable = donateItemModel.isEnable() > -1 ? donateItemModel.isEnable() : donateItemModel2.isEnable();
                    List<String> colorListButton = donateItemModel.getColorListButton();
                    if (colorListButton == null) {
                        colorListButton = donateItemModel2.getColorListButton();
                    }
                    List<String> list = colorListButton;
                    String titleButton = donateItemModel.getTitleButton();
                    if (titleButton == null) {
                        titleButton = donateItemModel2.getTitleButton();
                    }
                    String str3 = titleButton;
                    int image = donateItemModel.getImage() > -1 ? donateItemModel.getImage() : donateItemModel2.getImage();
                    String imageEffect = donateItemModel.getImageEffect();
                    if (imageEffect == null) {
                        imageEffect = donateItemModel2.getImageEffect();
                    }
                    String str4 = imageEffect;
                    int backgroundId = donateItemModel.getBackgroundId() > -1 ? donateItemModel.getBackgroundId() : donateItemModel2.getBackgroundId();
                    int leftUnixTime = donateItemModel.getLeftUnixTime() > -1 ? donateItemModel.getLeftUnixTime() : donateItemModel2.getLeftUnixTime();
                    List<DonateBadgesModel> badges = donateItemModel.getBadges();
                    if (badges == null) {
                        badges = donateItemModel2.getBadges();
                    }
                    List<DonateBadgesModel> list2 = badges;
                    int animation = donateItemModel.getAnimation() > -1 ? donateItemModel.getAnimation() : donateItemModel2.getAnimation();
                    List<String> textGradientColor = donateItemModel.getTextGradientColor();
                    if (textGradientColor == null) {
                        textGradientColor = donateItemModel2.getTextGradientColor();
                    }
                    List<String> list3 = textGradientColor;
                    long totalEarnings = donateItemModel.getTotalEarnings() > -1 ? donateItemModel.getTotalEarnings() : donateItemModel2.getTotalEarnings();
                    int gifId = donateItemModel.getGifId() > -1 ? donateItemModel.getGifId() : donateItemModel2.getGifId();
                    int blockedType = donateItemModel.getBlockedType() > -1 ? donateItemModel.getBlockedType() : donateItemModel2.getBlockedType();
                    String blockedReason = donateItemModel.getBlockedReason();
                    if (blockedReason == null) {
                        blockedReason = donateItemModel2.getBlockedReason();
                    }
                    donateItemModel2 = DonateItemModel.copy$default(donateItemModel2, 0, position, str, str2, price, priceCurrency, category, typeTemplate, iconButton, isEnable, list, str3, image, str4, discount, backgroundId, discountPrice, list2, blockedType, blockedReason, leftUnixTime, donateItemModel.getVisible() > -1 ? donateItemModel.getVisible() : donateItemModel2.getVisible(), animation, list3, totalEarnings, gifId, donateItemModel.getLimited() > -1 ? donateItemModel.getLimited() : donateItemModel2.getLimited(), 1, null);
                }
                arrayList.add(donateItemModel2);
            }
            Object emit = this._itemList.emit(new ResultState.Success(arrayList), continuation);
            return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
