package com.miami.game.core.play.country.billing;

import android.content.Context;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingConfig;
import com.android.billingclient.api.BillingConfigResponseListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.GetBillingConfigParams;
import com.android.billingclient.api.PendingPurchasesParams;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.miami.game.core.play.country.api.PlayCountryResolver;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.TimeoutKt;
/* compiled from: BillingPlayCountryResolver.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u001b\b\u0007\u0012\f\b\u0001\u0010\u0002\u001a\u00020\u0003:\u0002\b\u0004\u001a\u0002\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u0004\u0018\u00010\tH\u0096@¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0082@¢\u0006\u0002\u0010\nJ\u0010\u0010\f\u001a\u0004\u0018\u00010\t*\u0004\u0018\u00010\tH\u0002R\u0015\u0010\u0002\u001a\u00020\u00038\u0002X\u0083\u0004\u0092\u0002\u0002\b\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/miami/game/core/play/country/billing/BillingPlayCountryResolver;", "Lcom/miami/game/core/play/country/api/PlayCountryResolver;", "context", "Landroid/content/Context;", "Ldagger/hilt/android/qualifiers/ApplicationContext;", "<init>", "(Landroid/content/Context;)V", "Ljavax/inject/Inject;", "getCountryIso", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestCountryIso", "toCountryIso", "Companion", "play-country-billing"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BillingPlayCountryResolver implements PlayCountryResolver {
    private static final Companion Companion = new Companion(null);
    private static final Regex ISO_COUNTRY_REGEX = new Regex("[A-Z]{2}");
    @Deprecated
    public static final long REQUEST_TIMEOUT_MS = 5000;
    @ApplicationContext
    private final Context context;

    @Inject
    public BillingPlayCountryResolver(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(2:10|11)(2:20|21))(3:22|23|(1:25))|12|13|(1:18)(2:15|16)))|28|6|7|(0)(0)|12|13|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005f, code lost:
        r7 = kotlin.Result.Companion;
        r6 = kotlin.Result.m9915constructorimpl(kotlin.ResultKt.createFailure(r6));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // com.miami.game.core.play.country.api.PlayCountryResolver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getCountryIso(Continuation<? super String> continuation) {
        BillingPlayCountryResolver$getCountryIso$1 billingPlayCountryResolver$getCountryIso$1;
        int i;
        Object m9915constructorimpl;
        if (continuation instanceof BillingPlayCountryResolver$getCountryIso$1) {
            billingPlayCountryResolver$getCountryIso$1 = (BillingPlayCountryResolver$getCountryIso$1) continuation;
            if ((billingPlayCountryResolver$getCountryIso$1.label & Integer.MIN_VALUE) != 0) {
                billingPlayCountryResolver$getCountryIso$1.label -= Integer.MIN_VALUE;
                Object obj = billingPlayCountryResolver$getCountryIso$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = billingPlayCountryResolver$getCountryIso$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Result.Companion companion = Result.Companion;
                    BillingPlayCountryResolver billingPlayCountryResolver = this;
                    billingPlayCountryResolver$getCountryIso$1.L$0 = SpillingKt.nullOutSpilledVariable(this);
                    billingPlayCountryResolver$getCountryIso$1.label = 1;
                    obj = TimeoutKt.withTimeoutOrNull(5000L, new BillingPlayCountryResolver$getCountryIso$2$1(this, null), billingPlayCountryResolver$getCountryIso$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    BillingPlayCountryResolver billingPlayCountryResolver2 = (BillingPlayCountryResolver) billingPlayCountryResolver$getCountryIso$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                m9915constructorimpl = Result.m9915constructorimpl((String) obj);
                if (Result.m9921isFailureimpl(m9915constructorimpl)) {
                    return m9915constructorimpl;
                }
                return null;
            }
        }
        billingPlayCountryResolver$getCountryIso$1 = new BillingPlayCountryResolver$getCountryIso$1(this, continuation);
        Object obj2 = billingPlayCountryResolver$getCountryIso$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = billingPlayCountryResolver$getCountryIso$1.label;
        if (i != 0) {
        }
        m9915constructorimpl = Result.m9915constructorimpl((String) obj2);
        if (Result.m9921isFailureimpl(m9915constructorimpl)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestCountryIso$lambda$0$resumeAndClose(AtomicBoolean atomicBoolean, BillingClient billingClient, CancellableContinuation<? super String> cancellableContinuation, String str) {
        if (atomicBoolean.compareAndSet(false, true)) {
            billingClient.endConnection();
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m9915constructorimpl(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toCountryIso(String str) {
        String obj;
        if (str != null && (obj = StringsKt.trim((CharSequence) str).toString()) != null) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String upperCase = obj.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            if (upperCase != null) {
                if (ISO_COUNTRY_REGEX.matches(upperCase)) {
                    return upperCase;
                }
            }
        }
        return null;
    }

    /* compiled from: BillingPlayCountryResolver.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/miami/game/core/play/country/billing/BillingPlayCountryResolver$Companion;", "", "<init>", "()V", "REQUEST_TIMEOUT_MS", "", "ISO_COUNTRY_REGEX", "Lkotlin/text/Regex;", "getISO_COUNTRY_REGEX", "()Lkotlin/text/Regex;", "play-country-billing"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Regex getISO_COUNTRY_REGEX() {
            return BillingPlayCountryResolver.ISO_COUNTRY_REGEX;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestCountryIso(Continuation<? super String> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final BillingClient build = BillingClient.newBuilder(this.context).setListener(new PurchasesUpdatedListener() { // from class: com.miami.game.core.play.country.billing.BillingPlayCountryResolver$requestCountryIso$2$billingClient$1
            @Override // com.android.billingclient.api.PurchasesUpdatedListener
            public final void onPurchasesUpdated(BillingResult billingResult, List<Purchase> list) {
                Intrinsics.checkNotNullParameter(billingResult, "<unused var>");
            }
        }).enablePendingPurchases(PendingPurchasesParams.newBuilder().enableOneTimeProducts().build()).enableAutoServiceReconnection().build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.miami.game.core.play.country.billing.BillingPlayCountryResolver$requestCountryIso$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                if (atomicBoolean.compareAndSet(false, true)) {
                    build.endConnection();
                }
            }
        });
        build.startConnection(new BillingClientStateListener() { // from class: com.miami.game.core.play.country.billing.BillingPlayCountryResolver$requestCountryIso$2$2
            @Override // com.android.billingclient.api.BillingClientStateListener
            public void onBillingSetupFinished(BillingResult billingResult) {
                Intrinsics.checkNotNullParameter(billingResult, "billingResult");
                if (billingResult.getResponseCode() != 0) {
                    BillingPlayCountryResolver.requestCountryIso$lambda$0$resumeAndClose(atomicBoolean, BillingClient.this, cancellableContinuationImpl2, null);
                    return;
                }
                GetBillingConfigParams build2 = GetBillingConfigParams.newBuilder().build();
                Intrinsics.checkNotNullExpressionValue(build2, "build(...)");
                BillingClient billingClient = BillingClient.this;
                final BillingPlayCountryResolver billingPlayCountryResolver = this;
                final AtomicBoolean atomicBoolean2 = atomicBoolean;
                final BillingClient billingClient2 = BillingClient.this;
                final CancellableContinuation<String> cancellableContinuation = cancellableContinuationImpl2;
                billingClient.getBillingConfigAsync(build2, new BillingConfigResponseListener() { // from class: com.miami.game.core.play.country.billing.BillingPlayCountryResolver$requestCountryIso$2$2$onBillingSetupFinished$1
                    @Override // com.android.billingclient.api.BillingConfigResponseListener
                    public final void onBillingConfigResponse(BillingResult result, BillingConfig billingConfig) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        if (result.getResponseCode() == 0) {
                            r0 = BillingPlayCountryResolver.this.toCountryIso(billingConfig != null ? billingConfig.getCountryCode() : null);
                        }
                        BillingPlayCountryResolver.requestCountryIso$lambda$0$resumeAndClose(atomicBoolean2, billingClient2, cancellableContinuation, r0);
                    }
                });
            }

            @Override // com.android.billingclient.api.BillingClientStateListener
            public void onBillingServiceDisconnected() {
                BillingPlayCountryResolver.requestCountryIso$lambda$0$resumeAndClose(atomicBoolean, BillingClient.this, cancellableContinuationImpl2, null);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
