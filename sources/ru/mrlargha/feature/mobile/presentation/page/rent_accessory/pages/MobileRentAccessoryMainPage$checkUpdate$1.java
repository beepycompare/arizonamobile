package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import retrofit2.Response;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.feature.battlepassWinter2025.roulette.RouletteView;
import ru.mrlargha.feature.mobile.data.remote.MobileRetrofitClient;
import ru.mrlargha.feature.mobile.data.remote.api_services.rent_accessory.MobileRentAccessoryApiService;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.RentAccessoryPage;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MobileRentAccessoryMainPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryMainPage$checkUpdate$1", f = "MobileRentAccessoryMainPage.kt", i = {0}, l = {RouletteView.DEFAULT_ROULETTE_WIDTH}, m = "invokeSuspend", n = {"$this$launch"}, nl = {281}, s = {"L$0"}, v = 2)
/* loaded from: classes6.dex */
public final class MobileRentAccessoryMainPage$checkUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MobileRentAccessoryMainPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileRentAccessoryMainPage$checkUpdate$1(MobileRentAccessoryMainPage mobileRentAccessoryMainPage, Continuation<? super MobileRentAccessoryMainPage$checkUpdate$1> continuation) {
        super(2, continuation);
        this.this$0 = mobileRentAccessoryMainPage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MobileRentAccessoryMainPage$checkUpdate$1 mobileRentAccessoryMainPage$checkUpdate$1 = new MobileRentAccessoryMainPage$checkUpdate$1(this.this$0, continuation);
        mobileRentAccessoryMainPage$checkUpdate$1.L$0 = obj;
        return mobileRentAccessoryMainPage$checkUpdate$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MobileRentAccessoryMainPage$checkUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0032 -> B:14:0x0035). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (CoroutineScopeKt.isActive(coroutineScope)) {
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this.this$0, null), 3, null);
            if (CoroutineScopeKt.isActive(coroutineScope)) {
                this.L$0 = coroutineScope;
                this.label = 1;
                if (DelayKt.delay(5000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this.this$0, null), 3, null);
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    return Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MobileRentAccessoryMainPage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryMainPage$checkUpdate$1$1", f = "MobileRentAccessoryMainPage.kt", i = {1, 1, 1}, l = {283, 287}, m = "invokeSuspend", n = {"ads", "it", "$i$a$-let-MobileRentAccessoryMainPage$checkUpdate$1$1$1"}, nl = {282, 296}, s = {"L$0", "L$1", "I$0"}, v = 2)
    /* renamed from: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryMainPage$checkUpdate$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MobileRentAccessoryMainPage this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MobileRentAccessoryMainPage mobileRentAccessoryMainPage, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = mobileRentAccessoryMainPage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0051, code lost:
            if (r8 == r0) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0093, code lost:
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryMainPage$checkUpdate$1$1$1$1(r3, null), r7) == r0) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0095, code lost:
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            MobileRetrofitClient mobileRetrofitClient;
            RentAccessoryPage rentAccessoryPage;
            List list;
            List list2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mobileRetrofitClient = this.this$0.retrofitClient;
                MobileRentAccessoryApiService rentAccessoryApiService = mobileRetrofitClient.getRentAccessoryApiService();
                rentAccessoryPage = this.this$0.parentContainer;
                this.label = 1;
                obj = rentAccessoryApiService.getAds(UtilsKt.getServerId(rentAccessoryPage.getTargetActivity()).getAccountId(), this);
            } else if (i != 1) {
                if (i == 2) {
                    List list3 = (List) this.L$1;
                    Response response = (Response) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            Response response2 = (Response) obj;
            if (response2.isSuccessful() && (list = (List) response2.body()) != null) {
                MobileRentAccessoryMainPage mobileRentAccessoryMainPage = this.this$0;
                list2 = mobileRentAccessoryMainPage.currentAddsList;
                if (!Intrinsics.areEqual(list2, list)) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(response2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(list);
                    this.I$0 = 0;
                    this.label = 2;
                }
            }
            return Unit.INSTANCE;
        }
    }
}
