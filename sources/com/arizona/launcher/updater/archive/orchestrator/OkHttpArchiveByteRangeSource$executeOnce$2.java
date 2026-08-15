package com.arizona.launcher.updater.archive.orchestrator;

import com.adjust.sdk.Constants;
import com.arizona.launcher.updater.archive.download.ArchiveRemoteNetworkPolicy;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveByteRangeResult;
import com.arizona.launcher.updater.archive.orchestrator.OkHttpArchiveByteRangeSource;
import com.arizona.launcher.updater.archive.range.StrongEtag;
import java.net.URI;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.updater.archive.orchestrator.OkHttpArchiveByteRangeSource$executeOnce$2", f = "ArchiveManifestResolver.kt", i = {0, 0, 0, 0, 0}, l = {444}, m = "invokeSuspend", n = {"$this$withContext", "currentUrl", "terminalResult", "httpRequest", "redirectsFollowed"}, nl = {456}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 2)
/* loaded from: classes3.dex */
public final class OkHttpArchiveByteRangeSource$executeOnce$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArchiveByteRangeResult>, Object> {
    final /* synthetic */ int $expectedBodyBytes;
    final /* synthetic */ ArchiveByteRangeRequest $request;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ OkHttpArchiveByteRangeSource this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpArchiveByteRangeSource$executeOnce$2(ArchiveByteRangeRequest archiveByteRangeRequest, OkHttpArchiveByteRangeSource okHttpArchiveByteRangeSource, int i, Continuation<? super OkHttpArchiveByteRangeSource$executeOnce$2> continuation) {
        super(2, continuation);
        this.$request = archiveByteRangeRequest;
        this.this$0 = okHttpArchiveByteRangeSource;
        this.$expectedBodyBytes = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OkHttpArchiveByteRangeSource$executeOnce$2 okHttpArchiveByteRangeSource$executeOnce$2 = new OkHttpArchiveByteRangeSource$executeOnce$2(this.$request, this.this$0, this.$expectedBodyBytes, continuation);
        okHttpArchiveByteRangeSource$executeOnce$2.L$0 = obj;
        return okHttpArchiveByteRangeSource$executeOnce$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArchiveByteRangeResult> continuation) {
        return ((OkHttpArchiveByteRangeSource$executeOnce$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01f5 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00e8 -> B:21:0x00ee). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String url;
        int i;
        ArchiveByteRangeResult archiveByteRangeResult;
        boolean z;
        OkHttpClient okHttpClient;
        Object obj2;
        Object m9916constructorimpl;
        boolean z2;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            url = this.$request.getUrl();
            i = 0;
            archiveByteRangeResult = null;
            if (archiveByteRangeResult == null) {
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            int i3 = this.I$0;
            Request request = (Request) this.L$3;
            ArchiveByteRangeResult archiveByteRangeResult2 = (ArchiveByteRangeResult) this.L$2;
            ResultKt.throwOnFailure(obj);
            int i4 = i3;
            String str = (String) this.L$1;
            ArchiveByteRangeResult archiveByteRangeResult3 = archiveByteRangeResult2;
            Object executeCancellable = obj;
            OkHttpArchiveByteRangeSource.ArchiveHttpHop archiveHttpHop = (OkHttpArchiveByteRangeSource.ArchiveHttpHop) executeCancellable;
            if (!(archiveHttpHop instanceof OkHttpArchiveByteRangeSource.ArchiveHttpHop.Terminal)) {
                if (!(archiveHttpHop instanceof OkHttpArchiveByteRangeSource.ArchiveHttpHop.Redirect)) {
                    throw new NoWhenBranchMatchedException();
                }
                String location = ((OkHttpArchiveByteRangeSource.ArchiveHttpHop.Redirect) archiveHttpHop).getLocation();
                if (location == null || StringsKt.isBlank(location)) {
                    return new ArchiveByteRangeResult.Failure(ArchiveByteRangeErrorCode.REDIRECT_LOCATION_MISSING, null, null, 6, null);
                }
                if (i4 >= 5) {
                    return new ArchiveByteRangeResult.Failure(ArchiveByteRangeErrorCode.REDIRECT_LIMIT_EXCEEDED, null, null, 6, null);
                }
                try {
                } catch (Throwable th) {
                    Result.Companion companion = Result.Companion;
                    obj2 = Result.m9916constructorimpl(ResultKt.createFailure(th));
                }
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m9916constructorimpl(new URI(((OkHttpArchiveByteRangeSource.ArchiveHttpHop.Redirect) archiveHttpHop).getFromUrl()).resolve(((OkHttpArchiveByteRangeSource.ArchiveHttpHop.Redirect) archiveHttpHop).getLocation()).toString());
                boolean m9922isFailureimpl = Result.m9922isFailureimpl(obj2);
                Object obj3 = obj2;
                if (m9922isFailureimpl) {
                    obj3 = null;
                }
                String str2 = (String) obj3;
                if (str2 == null) {
                    return new ArchiveByteRangeResult.Failure(ArchiveByteRangeErrorCode.REDIRECT_URL_UNSAFE, null, null, 6, null);
                }
                try {
                } catch (Throwable th2) {
                    Result.Companion companion3 = Result.Companion;
                    m9916constructorimpl = Result.m9916constructorimpl(ResultKt.createFailure(th2));
                }
                Result.Companion companion4 = Result.Companion;
                m9916constructorimpl = Result.m9916constructorimpl(Boxing.boxBoolean(StringsKt.equals(new URI(((OkHttpArchiveByteRangeSource.ArchiveHttpHop.Redirect) archiveHttpHop).getFromUrl()).getScheme(), Constants.SCHEME, true) && !StringsKt.equals(new URI(str2).getScheme(), Constants.SCHEME, true)));
                Boolean boxBoolean = Boxing.boxBoolean(true);
                boolean m9922isFailureimpl2 = Result.m9922isFailureimpl(m9916constructorimpl);
                Boolean bool = m9916constructorimpl;
                if (m9922isFailureimpl2) {
                    bool = boxBoolean;
                }
                if (!((Boolean) bool).booleanValue()) {
                    ArchiveRemoteNetworkPolicy archiveRemoteNetworkPolicy = ArchiveRemoteNetworkPolicy.INSTANCE;
                    z2 = this.this$0.allowInsecureLoopback;
                    if (archiveRemoteNetworkPolicy.isAllowedUrl(str2, z2)) {
                        i = i4 + 1;
                        archiveByteRangeResult = archiveByteRangeResult3;
                        url = str2;
                    }
                }
                return new ArchiveByteRangeResult.Failure(ArchiveByteRangeErrorCode.REDIRECT_URL_UNSAFE, null, null, 6, null);
            }
            url = str;
            i = i4;
            archiveByteRangeResult = ((OkHttpArchiveByteRangeSource.ArchiveHttpHop.Terminal) archiveHttpHop).getResult();
            if (archiveByteRangeResult == null) {
                CoroutineScopeKt.ensureActive(coroutineScope);
                ArchiveRemoteNetworkPolicy archiveRemoteNetworkPolicy2 = ArchiveRemoteNetworkPolicy.INSTANCE;
                z = this.this$0.allowInsecureLoopback;
                if (!archiveRemoteNetworkPolicy2.isAllowedUrl(url, z)) {
                    return new ArchiveByteRangeResult.Failure(ArchiveByteRangeErrorCode.EFFECTIVE_URL_UNSAFE, null, "unsafe or malformed request URL", 2, null);
                }
                Request.Builder header = new Request.Builder().url(url).header("Range", "bytes=" + this.$request.getStartInclusive() + com.google.android.vending.expansion.downloader.Constants.FILENAME_SEQUENCE_SEPARATOR + this.$request.getEndInclusive()).header("Accept-Encoding", "identity");
                StrongEtag ifRange = this.$request.getIfRange();
                if (ifRange != null) {
                    header.header("If-Range", ifRange.getHeaderValue());
                }
                Request build = header.get().build();
                OkHttpArchiveByteRangeSource okHttpArchiveByteRangeSource = this.this$0;
                okHttpClient = okHttpArchiveByteRangeSource.client;
                Call newCall = okHttpClient.newCall(build);
                final OkHttpArchiveByteRangeSource okHttpArchiveByteRangeSource2 = this.this$0;
                final ArchiveByteRangeRequest archiveByteRangeRequest = this.$request;
                final int i5 = this.$expectedBodyBytes;
                this.L$0 = coroutineScope;
                this.L$1 = url;
                this.L$2 = archiveByteRangeResult;
                this.L$3 = SpillingKt.nullOutSpilledVariable(build);
                this.I$0 = i;
                this.label = 1;
                executeCancellable = okHttpArchiveByteRangeSource.executeCancellable(newCall, new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.OkHttpArchiveByteRangeSource$executeOnce$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        return OkHttpArchiveByteRangeSource$executeOnce$2.invokeSuspend$lambda$1(OkHttpArchiveByteRangeSource.this, archiveByteRangeRequest, i5, (Response) obj4);
                    }
                }, this);
                if (executeCancellable == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ArchiveByteRangeResult archiveByteRangeResult4 = archiveByteRangeResult;
                i4 = i;
                str = url;
                archiveByteRangeResult3 = archiveByteRangeResult4;
                OkHttpArchiveByteRangeSource.ArchiveHttpHop archiveHttpHop2 = (OkHttpArchiveByteRangeSource.ArchiveHttpHop) executeCancellable;
                if (!(archiveHttpHop2 instanceof OkHttpArchiveByteRangeSource.ArchiveHttpHop.Terminal)) {
                }
                if (archiveByteRangeResult == null) {
                    return archiveByteRangeResult;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final OkHttpArchiveByteRangeSource.ArchiveHttpHop invokeSuspend$lambda$1(OkHttpArchiveByteRangeSource okHttpArchiveByteRangeSource, ArchiveByteRangeRequest archiveByteRangeRequest, int i, Response response) {
        OkHttpArchiveByteRangeSource.Companion companion;
        ArchiveByteRangeResult validatePartialResponse;
        companion = OkHttpArchiveByteRangeSource.Companion;
        if (!companion.getREDIRECT_HTTP_STATUSES().contains(Integer.valueOf(response.code()))) {
            validatePartialResponse = okHttpArchiveByteRangeSource.validatePartialResponse(response, archiveByteRangeRequest, i);
            return new OkHttpArchiveByteRangeSource.ArchiveHttpHop.Terminal(validatePartialResponse);
        }
        return new OkHttpArchiveByteRangeSource.ArchiveHttpHop.Redirect(response.request().url().toString(), Response.header$default(response, "Location", null, 2, null));
    }
}
