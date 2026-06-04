package ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.media3.extractor.ts.TsExtractor;
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
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.ws.WebSocketProtocol;
import retrofit2.Response;
import ru.mrlargha.commonui.utils.UtilsKt;
import ru.mrlargha.feature.mobile.data.remote.MobileRetrofitClient;
import ru.mrlargha.feature.mobile.data.remote.api_services.rent_accessory.MobileRentAccessoryApiService;
import ru.mrlargha.feature.mobile.databinding.MobileRentAccessoryMainBinding;
import ru.mrlargha.feature.mobile.presentation.page.rent_accessory.RentAccessoryPage;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MobileRentAccessoryMainPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryMainPage$getAds$1", f = "MobileRentAccessoryMainPage.kt", i = {1, 1, 2}, l = {127, 131, 141}, m = "invokeSuspend", n = {"ads", "it", "ads"}, nl = {WebSocketProtocol.PAYLOAD_SHORT, TsExtractor.TS_STREAM_TYPE_DTS_UHD, 149}, s = {"L$0", "L$1", "L$0"}, v = 2)
/* loaded from: classes6.dex */
public final class MobileRentAccessoryMainPage$getAds$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MobileRentAccessoryMainPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileRentAccessoryMainPage$getAds$1(MobileRentAccessoryMainPage mobileRentAccessoryMainPage, Continuation<? super MobileRentAccessoryMainPage$getAds$1> continuation) {
        super(2, continuation);
        this.this$0 = mobileRentAccessoryMainPage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MobileRentAccessoryMainPage$getAds$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MobileRentAccessoryMainPage$getAds$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0055, code lost:
        if (r8 == r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008d, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryMainPage$getAds$1$1$1(r2, null), r7) == r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ae, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryMainPage$getAds$1.AnonymousClass2(r7.this$0, null), r7) == r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b0, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MobileRetrofitClient mobileRetrofitClient;
        RentAccessoryPage rentAccessoryPage;
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
                List list = (List) this.L$1;
            } else if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Response response = (Response) this.L$0;
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            ResultKt.throwOnFailure(obj);
        }
        Response response2 = (Response) obj;
        if (response2.isSuccessful()) {
            List list2 = (List) response2.body();
            if (list2 != null) {
                MobileRentAccessoryMainPage mobileRentAccessoryMainPage = this.this$0;
                mobileRentAccessoryMainPage.currentAddsList = list2;
                this.L$0 = SpillingKt.nullOutSpilledVariable(response2);
                this.L$1 = SpillingKt.nullOutSpilledVariable(list2);
                this.label = 2;
            }
            return Unit.INSTANCE;
        }
        this.L$0 = SpillingKt.nullOutSpilledVariable(response2);
        this.label = 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MobileRentAccessoryMainPage.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryMainPage$getAds$1$2", f = "MobileRentAccessoryMainPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    /* renamed from: ru.mrlargha.feature.mobile.presentation.page.rent_accessory.pages.MobileRentAccessoryMainPage$getAds$1$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MobileRentAccessoryMainPage this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MobileRentAccessoryMainPage mobileRentAccessoryMainPage, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = mobileRentAccessoryMainPage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List list;
            RentAccessoryPage rentAccessoryPage;
            MobileRentAccessoryMainBinding mobileRentAccessoryMainBinding;
            MobileRentAccessoryMainBinding mobileRentAccessoryMainBinding2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                list = this.this$0.currentAddsList;
                if (list.isEmpty()) {
                    rentAccessoryPage = this.this$0.parentContainer;
                    rentAccessoryPage.navigatePage(RentAccessoryPage.Companion.RentAccessoryPages.NOT_DATA);
                    mobileRentAccessoryMainBinding = this.this$0.bindingPage;
                    LinearLayout mainContainer = mobileRentAccessoryMainBinding.mainContainer;
                    Intrinsics.checkNotNullExpressionValue(mainContainer, "mainContainer");
                    mainContainer.setVisibility(0);
                    mobileRentAccessoryMainBinding2 = this.this$0.bindingPage;
                    ProgressBar progressBar = mobileRentAccessoryMainBinding2.progressBar;
                    Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
                    progressBar.setVisibility(8);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
