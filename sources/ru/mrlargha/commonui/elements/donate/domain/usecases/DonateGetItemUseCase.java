package ru.mrlargha.commonui.elements.donate.domain.usecases;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
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
import kotlin.jvm.functions.Function0;
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
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import ru.mrlargha.commonui.elements.donate.domain.ResultState;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateBadgesModel;
import ru.mrlargha.commonui.elements.donate.domain.models.DonateItemModel;
import ru.mrlargha.commonui.elements.donate.domain.repositories.DonateRepository;
/* compiled from: DonateGetItemUseCase.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u0018J&\u0010\u0019\u001a\u0002H\u001a\"\u0004\b\u0000\u0010\u001a*\u00020\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001cH\u0082H¢\u0006\u0002\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lru/mrlargha/commonui/elements/donate/domain/usecases/DonateGetItemUseCase;", "", "repository", "Lru/mrlargha/commonui/elements/donate/domain/repositories/DonateRepository;", "<init>", "(Lru/mrlargha/commonui/elements/donate/domain/repositories/DonateRepository;)V", "getRepository", "()Lru/mrlargha/commonui/elements/donate/domain/repositories/DonateRepository;", "_itemList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lru/mrlargha/commonui/elements/donate/domain/ResultState;", "", "Lru/mrlargha/commonui/elements/donate/domain/models/DonateItemModel;", "itemList", "Lkotlinx/coroutines/flow/StateFlow;", "getItemList", "()Lkotlinx/coroutines/flow/StateFlow;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "updateItem", "", "item", "(Lru/mrlargha/commonui/elements/donate/domain/models/DonateItemModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lockAndReturn", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Mutex;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DonateGetItemUseCase {
    private final MutableStateFlow<ResultState<List<DonateItemModel>>> _itemList;
    private final StateFlow<ResultState<List<DonateItemModel>>> itemList;
    private final Mutex mutex;
    private final DonateRepository repository;
    private final CoroutineScope scope;

    public DonateGetItemUseCase(DonateRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
        MutableStateFlow<ResultState<List<DonateItemModel>>> MutableStateFlow = StateFlowKt.MutableStateFlow(new ResultState.Success(CollectionsKt.emptyList()));
        this._itemList = MutableStateFlow;
        this.itemList = FlowKt.asStateFlow(MutableStateFlow);
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.scope = CoroutineScope;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
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
    @DebugMetadata(c = "ru.mrlargha.commonui.elements.donate.domain.usecases.DonateGetItemUseCase$1", f = "DonateGetItemUseCase.kt", i = {1}, l = {31, 32}, m = "invokeSuspend", n = {FirebaseAnalytics.Param.ITEMS}, s = {"L$0"})
    /* renamed from: ru.mrlargha.commonui.elements.donate.domain.usecases.DonateGetItemUseCase$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
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

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
            if (r6 == r0) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x004e, code lost:
            if (r5.this$0._itemList.emit(r6, r5) == r0) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0050, code lost:
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = DonateGetItemUseCase.this.getRepository().getItems(this);
            } else if (i != 1) {
                if (i == 2) {
                    ResultState resultState = (ResultState) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            ResultState resultState2 = (ResultState) obj;
            this.L$0 = SpillingKt.nullOutSpilledVariable(resultState2);
            this.label = 2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0210, code lost:
        if (r8 == null) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x02dd, code lost:
        if (r8.emit(r13, r2) == r3) goto L119;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a3 A[Catch: all -> 0x02ed, TryCatch #2 {all -> 0x02ed, blocks: (B:24:0x0097, B:26:0x00a3, B:27:0x00b5, B:29:0x00bc, B:35:0x00d5, B:37:0x00e3, B:39:0x00ec, B:41:0x00fa, B:42:0x00fe, B:44:0x010e, B:45:0x0112, B:47:0x011c, B:49:0x0125, B:51:0x012d, B:53:0x0136, B:55:0x013e, B:57:0x0147, B:59:0x014f, B:61:0x0158, B:63:0x0160, B:65:0x0169, B:67:0x0171, B:69:0x017a, B:71:0x0182, B:73:0x018b, B:75:0x0199, B:76:0x019d, B:78:0x01ad, B:79:0x01b1, B:81:0x01bb, B:83:0x01c4, B:85:0x01d2, B:86:0x01d6, B:88:0x01e0, B:90:0x01e9, B:92:0x01f1, B:94:0x01fa, B:96:0x0202, B:98:0x020a, B:99:0x020e, B:102:0x0216, B:104:0x021e, B:106:0x0227, B:108:0x0235, B:109:0x0239, B:111:0x0243, B:113:0x024c, B:115:0x0254, B:117:0x025d, B:119:0x0265, B:121:0x026e, B:123:0x027c, B:124:0x0280, B:126:0x028a, B:128:0x0293, B:127:0x028f, B:120:0x026a, B:116:0x0259, B:112:0x0248, B:105:0x0223, B:101:0x0212, B:93:0x01f6, B:89:0x01e5, B:82:0x01c0, B:72:0x0187, B:68:0x0176, B:64:0x0165, B:60:0x0154, B:56:0x0143, B:52:0x0132, B:48:0x0121, B:38:0x00e8, B:32:0x00cd), top: B:146:0x0097 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateItem(DonateItemModel donateItemModel, Continuation<? super Unit> continuation) {
        DonateGetItemUseCase$updateItem$1 donateGetItemUseCase$updateItem$1;
        int i;
        DonateItemModel donateItemModel2;
        Mutex mutex;
        DonateGetItemUseCase donateGetItemUseCase;
        int i2;
        Mutex mutex2;
        ResultState<List<DonateItemModel>> value;
        List<DonateBadgesModel> badges;
        int i3;
        Object obj;
        try {
            try {
                if (continuation instanceof DonateGetItemUseCase$updateItem$1) {
                    donateGetItemUseCase$updateItem$1 = (DonateGetItemUseCase$updateItem$1) continuation;
                    if ((donateGetItemUseCase$updateItem$1.label & Integer.MIN_VALUE) != 0) {
                        donateGetItemUseCase$updateItem$1.label -= Integer.MIN_VALUE;
                        Object obj2 = donateGetItemUseCase$updateItem$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = donateGetItemUseCase$updateItem$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj2);
                            Mutex mutex3 = this.mutex;
                            donateItemModel2 = donateItemModel;
                            donateGetItemUseCase$updateItem$1.L$0 = donateItemModel2;
                            donateGetItemUseCase$updateItem$1.L$1 = SpillingKt.nullOutSpilledVariable(this);
                            donateGetItemUseCase$updateItem$1.L$2 = mutex3;
                            donateGetItemUseCase$updateItem$1.I$0 = 0;
                            donateGetItemUseCase$updateItem$1.label = 1;
                            if (Mutex.DefaultImpls.lock$default(mutex3, null, donateGetItemUseCase$updateItem$1, 1, null) != coroutine_suspended) {
                                mutex = mutex3;
                                donateGetItemUseCase = this;
                                i2 = 0;
                            }
                            return coroutine_suspended;
                        } else if (i != 1) {
                            if (i == 2) {
                                int i4 = donateGetItemUseCase$updateItem$1.I$2;
                                int i5 = donateGetItemUseCase$updateItem$1.I$1;
                                int i6 = donateGetItemUseCase$updateItem$1.I$0;
                                DonateItemModel donateItemModel3 = (DonateItemModel) donateGetItemUseCase$updateItem$1.L$6;
                                DonateItemModel donateItemModel4 = (DonateItemModel) donateGetItemUseCase$updateItem$1.L$5;
                                List list = (List) donateGetItemUseCase$updateItem$1.L$4;
                                ResultState resultState = (ResultState) donateGetItemUseCase$updateItem$1.L$3;
                                mutex2 = (Mutex) donateGetItemUseCase$updateItem$1.L$2;
                                DonateGetItemUseCase donateGetItemUseCase2 = (DonateGetItemUseCase) donateGetItemUseCase$updateItem$1.L$1;
                                DonateItemModel donateItemModel5 = (DonateItemModel) donateGetItemUseCase$updateItem$1.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj2);
                                    Unit unit = Unit.INSTANCE;
                                    Mutex.DefaultImpls.unlock$default(mutex2, null, 1, null);
                                    return Unit.INSTANCE;
                                } catch (Throwable th) {
                                    th = th;
                                    obj = null;
                                    i3 = 1;
                                    Mutex.DefaultImpls.unlock$default(mutex2, obj, i3, obj);
                                    throw th;
                                }
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            int i7 = donateGetItemUseCase$updateItem$1.I$0;
                            mutex = (Mutex) donateGetItemUseCase$updateItem$1.L$2;
                            donateGetItemUseCase = (DonateGetItemUseCase) donateGetItemUseCase$updateItem$1.L$1;
                            ResultKt.throwOnFailure(obj2);
                            i2 = i7;
                            donateItemModel2 = (DonateItemModel) donateGetItemUseCase$updateItem$1.L$0;
                        }
                        value = this._itemList.getValue();
                        if (value instanceof ResultState.Success) {
                            List mutableList = CollectionsKt.toMutableList((Collection) ((ResultState.Success) value).getData());
                            Iterator it = mutableList.iterator();
                            int i8 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    i8 = -1;
                                    break;
                                } else if (((DonateItemModel) it.next()).getKey() == donateItemModel2.getKey()) {
                                    break;
                                } else {
                                    i8++;
                                }
                            }
                            if (i8 != -1) {
                                DonateItemModel donateItemModel6 = (DonateItemModel) mutableList.get(i8);
                                int position = donateItemModel2.getPosition() > -1 ? donateItemModel2.getPosition() : donateItemModel6.getPosition();
                                String name = donateItemModel2.getName();
                                if (name.length() == 0) {
                                    name = donateItemModel6.getName();
                                }
                                String str = name;
                                String description = donateItemModel2.getDescription();
                                if (description.length() == 0) {
                                    description = donateItemModel6.getDescription();
                                }
                                String str2 = description;
                                int price = donateItemModel2.getPrice() > -1 ? donateItemModel2.getPrice() : donateItemModel6.getPrice();
                                int priceCurrency = donateItemModel2.getPriceCurrency() > -1 ? donateItemModel2.getPriceCurrency() : donateItemModel6.getPriceCurrency();
                                int discount = donateItemModel2.getDiscount() > 0 ? donateItemModel2.getDiscount() : donateItemModel6.getDiscount();
                                int discountPrice = donateItemModel2.getDiscountPrice() > 0 ? donateItemModel2.getDiscountPrice() : donateItemModel6.getDiscountPrice();
                                int typeTemplate = donateItemModel2.getTypeTemplate() > -1 ? donateItemModel2.getTypeTemplate() : donateItemModel6.getTypeTemplate();
                                int iconButton = donateItemModel2.getIconButton() > -1 ? donateItemModel2.getIconButton() : donateItemModel6.getIconButton();
                                int isEnable = donateItemModel2.isEnable() > -1 ? donateItemModel2.isEnable() : donateItemModel6.isEnable();
                                List<String> colorListButton = donateItemModel2.getColorListButton();
                                if (colorListButton.isEmpty()) {
                                    colorListButton = donateItemModel6.getColorListButton();
                                }
                                List<String> list2 = colorListButton;
                                String titleButton = donateItemModel2.getTitleButton();
                                if (titleButton.length() == 0) {
                                    titleButton = donateItemModel6.getTitleButton();
                                }
                                String str3 = titleButton;
                                int image = donateItemModel2.getImage() > -1 ? donateItemModel2.getImage() : donateItemModel6.getImage();
                                String imageEffect = donateItemModel2.getImageEffect();
                                if (imageEffect.length() == 0) {
                                    imageEffect = donateItemModel6.getImageEffect();
                                }
                                String str4 = imageEffect;
                                int backgroundId = donateItemModel2.getBackgroundId() > -1 ? donateItemModel2.getBackgroundId() : donateItemModel6.getBackgroundId();
                                int leftUnixTime = donateItemModel2.getLeftUnixTime() > -1 ? donateItemModel2.getLeftUnixTime() : donateItemModel6.getLeftUnixTime();
                                List<DonateBadgesModel> badges2 = donateItemModel2.getBadges();
                                if (badges2 != null) {
                                    List<DonateBadgesModel> list3 = badges2;
                                    if (list3.isEmpty()) {
                                        list3 = donateItemModel6.getBadges();
                                    }
                                    badges = list3;
                                }
                                badges = donateItemModel6.getBadges();
                                List<DonateBadgesModel> list4 = badges;
                                int animation = donateItemModel2.getAnimation() > -1 ? donateItemModel2.getAnimation() : donateItemModel6.getAnimation();
                                List<String> textGradientColor = donateItemModel2.getTextGradientColor();
                                if (textGradientColor.isEmpty()) {
                                    textGradientColor = donateItemModel6.getTextGradientColor();
                                }
                                List<String> list5 = textGradientColor;
                                int totalEarnings = donateItemModel2.getTotalEarnings() > -1 ? donateItemModel2.getTotalEarnings() : donateItemModel6.getTotalEarnings();
                                int gifId = donateItemModel2.getGifId() > -1 ? donateItemModel2.getGifId() : donateItemModel6.getGifId();
                                int blockedType = donateItemModel2.getBlockedType() > -1 ? donateItemModel2.getBlockedType() : donateItemModel6.getBlockedType();
                                String blockedReason = donateItemModel2.getBlockedReason();
                                if (blockedReason.length() == 0) {
                                    blockedReason = donateItemModel6.getBlockedReason();
                                }
                                DonateItemModel copy$default = DonateItemModel.copy$default(donateItemModel6, 0, position, str, str2, price, priceCurrency, 0, typeTemplate, iconButton, isEnable, list2, str3, image, str4, discount, backgroundId, discountPrice, list4, blockedType, blockedReason, leftUnixTime, donateItemModel2.getVisible() > -1 ? donateItemModel2.getVisible() : donateItemModel6.getVisible(), animation, list5, totalEarnings, gifId, 65, null);
                                mutableList.set(i8, copy$default);
                                MutableStateFlow<ResultState<List<DonateItemModel>>> mutableStateFlow = this._itemList;
                                ResultState.Success success = new ResultState.Success(mutableList);
                                donateGetItemUseCase$updateItem$1.L$0 = SpillingKt.nullOutSpilledVariable(donateItemModel2);
                                donateGetItemUseCase$updateItem$1.L$1 = SpillingKt.nullOutSpilledVariable(donateGetItemUseCase);
                                donateGetItemUseCase$updateItem$1.L$2 = mutex;
                                donateGetItemUseCase$updateItem$1.L$3 = SpillingKt.nullOutSpilledVariable(value);
                                donateGetItemUseCase$updateItem$1.L$4 = SpillingKt.nullOutSpilledVariable(mutableList);
                                donateGetItemUseCase$updateItem$1.L$5 = SpillingKt.nullOutSpilledVariable(donateItemModel6);
                                donateGetItemUseCase$updateItem$1.L$6 = SpillingKt.nullOutSpilledVariable(copy$default);
                                donateGetItemUseCase$updateItem$1.I$0 = i2;
                                donateGetItemUseCase$updateItem$1.I$1 = 0;
                                donateGetItemUseCase$updateItem$1.I$2 = i8;
                                donateGetItemUseCase$updateItem$1.label = 2;
                            }
                        }
                        mutex2 = mutex;
                        Unit unit2 = Unit.INSTANCE;
                        Mutex.DefaultImpls.unlock$default(mutex2, null, 1, null);
                        return Unit.INSTANCE;
                    }
                }
                Unit unit22 = Unit.INSTANCE;
                Mutex.DefaultImpls.unlock$default(mutex2, null, 1, null);
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
                obj = null;
                i3 = 1;
                Mutex.DefaultImpls.unlock$default(mutex2, obj, i3, obj);
                throw th;
            }
            value = this._itemList.getValue();
            if (value instanceof ResultState.Success) {
            }
            mutex2 = mutex;
        } catch (Throwable th3) {
            th = th3;
            mutex2 = mutex;
            obj = null;
            i3 = 1;
            Mutex.DefaultImpls.unlock$default(mutex2, obj, i3, obj);
            throw th;
        }
        donateGetItemUseCase$updateItem$1 = new DonateGetItemUseCase$updateItem$1(this, continuation);
        Object obj22 = donateGetItemUseCase$updateItem$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = donateGetItemUseCase$updateItem$1.label;
        if (i != 0) {
        }
    }

    private final <T> Object lockAndReturn(Mutex mutex, Function0<? extends T> function0, Continuation<? super T> continuation) {
        Mutex.DefaultImpls.lock$default(mutex, null, continuation, 1, null);
        try {
            return function0.invoke();
        } finally {
            Mutex.DefaultImpls.unlock$default(mutex, null, 1, null);
        }
    }
}
