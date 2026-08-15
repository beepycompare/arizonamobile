package com.arizona.launcher.updater.http;

import com.arizona.launcher.updater.http.UpdateMetadataHttpResult;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
/* compiled from: UpdateMetadataFetcher.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u000eR\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0010"}, d2 = {"Lcom/arizona/launcher/updater/http/UpdateMetadataFetcher;", "Lcom/arizona/launcher/updater/http/UpdateMetadataRequest;", "firstAttempt", "retryAttempt", "<init>", "(Lcom/arizona/launcher/updater/http/UpdateMetadataRequest;Lcom/arizona/launcher/updater/http/UpdateMetadataRequest;)V", "get", "Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldRetry", "", "result", "shouldRetry$app", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateMetadataFetcher implements UpdateMetadataRequest {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final long FIRST_TIMEOUT_SECONDS = 10;
    private static final long RETRY_TIMEOUT_SECONDS = 20;
    private final UpdateMetadataRequest firstAttempt;
    private final UpdateMetadataRequest retryAttempt;

    public UpdateMetadataFetcher(UpdateMetadataRequest firstAttempt, UpdateMetadataRequest retryAttempt) {
        Intrinsics.checkNotNullParameter(firstAttempt, "firstAttempt");
        Intrinsics.checkNotNullParameter(retryAttempt, "retryAttempt");
        this.firstAttempt = firstAttempt;
        this.retryAttempt = retryAttempt;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
        if (r7 == r1) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075 A[RETURN] */
    @Override // com.arizona.launcher.updater.http.UpdateMetadataRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object get(String str, Continuation<? super UpdateMetadataHttpResult> continuation) {
        UpdateMetadataFetcher$get$1 updateMetadataFetcher$get$1;
        int i;
        UpdateMetadataHttpResult updateMetadataHttpResult;
        if (continuation instanceof UpdateMetadataFetcher$get$1) {
            updateMetadataFetcher$get$1 = (UpdateMetadataFetcher$get$1) continuation;
            if ((updateMetadataFetcher$get$1.label & Integer.MIN_VALUE) != 0) {
                updateMetadataFetcher$get$1.label -= Integer.MIN_VALUE;
                Object obj = updateMetadataFetcher$get$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = updateMetadataFetcher$get$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    UpdateMetadataRequest updateMetadataRequest = this.firstAttempt;
                    updateMetadataFetcher$get$1.L$0 = str;
                    updateMetadataFetcher$get$1.label = 1;
                    obj = updateMetadataRequest.get(str, updateMetadataFetcher$get$1);
                } else if (i != 1) {
                    if (i == 2) {
                        UpdateMetadataHttpResult updateMetadataHttpResult2 = (UpdateMetadataHttpResult) updateMetadataFetcher$get$1.L$1;
                        String str2 = (String) updateMetadataFetcher$get$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    str = (String) updateMetadataFetcher$get$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                updateMetadataHttpResult = (UpdateMetadataHttpResult) obj;
                if (shouldRetry$app(updateMetadataHttpResult)) {
                    return updateMetadataHttpResult;
                }
                UpdateMetadataRequest updateMetadataRequest2 = this.retryAttempt;
                updateMetadataFetcher$get$1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                updateMetadataFetcher$get$1.L$1 = SpillingKt.nullOutSpilledVariable(updateMetadataHttpResult);
                updateMetadataFetcher$get$1.label = 2;
                Object obj2 = updateMetadataRequest2.get(str, updateMetadataFetcher$get$1);
                return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
            }
        }
        updateMetadataFetcher$get$1 = new UpdateMetadataFetcher$get$1(this, continuation);
        Object obj3 = updateMetadataFetcher$get$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = updateMetadataFetcher$get$1.label;
        if (i != 0) {
        }
        updateMetadataHttpResult = (UpdateMetadataHttpResult) obj3;
        if (shouldRetry$app(updateMetadataHttpResult)) {
        }
    }

    public final boolean shouldRetry$app(UpdateMetadataHttpResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result instanceof UpdateMetadataHttpResult.Timeout) {
            return true;
        }
        if (result instanceof UpdateMetadataHttpResult.HttpError) {
            UpdateMetadataHttpResult.HttpError httpError = (UpdateMetadataHttpResult.HttpError) result;
            return httpError.getStatusCode() == 401 || httpError.getStatusCode() == 403;
        } else if (result instanceof UpdateMetadataHttpResult.NetworkError) {
            return ((UpdateMetadataHttpResult.NetworkError) result).getResponseStarted();
        } else {
            if ((result instanceof UpdateMetadataHttpResult.Success) || (result instanceof UpdateMetadataHttpResult.BodyTooLarge) || (result instanceof UpdateMetadataHttpResult.InvalidRequest)) {
                return false;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* compiled from: UpdateMetadataFetcher.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u000b\u001a\u00020\n*\u00020\n2\u0006\u0010\f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/arizona/launcher/updater/http/UpdateMetadataFetcher$Companion;", "", "<init>", "()V", "FIRST_TIMEOUT_SECONDS", "", "RETRY_TIMEOUT_SECONDS", "create", "Lcom/arizona/launcher/updater/http/UpdateMetadataFetcher;", "baseClient", "Lokhttp3/OkHttpClient;", "forMetadataTimeout", "timeoutSeconds", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UpdateMetadataFetcher create(OkHttpClient baseClient) {
            Intrinsics.checkNotNullParameter(baseClient, "baseClient");
            return new UpdateMetadataFetcher(new UpdateMetadataHttpClient(forMetadataTimeout(baseClient, 10L), 0L, 2, null), new UpdateMetadataHttpClient(forMetadataTimeout(baseClient, 20L), 0L, 2, null));
        }

        private final OkHttpClient forMetadataTimeout(OkHttpClient okHttpClient, long j) {
            return okHttpClient.newBuilder().retryOnConnectionFailure(false).followSslRedirects(false).connectTimeout(j, TimeUnit.SECONDS).readTimeout(j, TimeUnit.SECONDS).writeTimeout(j, TimeUnit.SECONDS).build();
        }
    }
}
