package com.arizona.launcher;

import android.content.Context;
import com.arizona.launcher.util.FileServers;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UpdateAnalyticsReporter.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \"2\u00020\u0001:\u0001\"B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\nJ&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012J0\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J0\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u001c\u001a\u00020\fJ:\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b$\u0012\b\b%\u0012\u0004\b\u0003\u0010\u0000¨\u0006#"}, d2 = {"Lcom/arizona/launcher/UpdateAnalyticsReporter;", "", "eventSink", "Lcom/arizona/launcher/UpdateAnalyticsEventSink;", "firstLaunchStore", "Lcom/arizona/launcher/UpdateFirstLaunchStore;", "environment", "Lcom/arizona/launcher/UpdateAnalyticsEnvironment;", "firstLaunchLock", "<init>", "(Lcom/arizona/launcher/UpdateAnalyticsEventSink;Lcom/arizona/launcher/UpdateFirstLaunchStore;Lcom/arizona/launcher/UpdateAnalyticsEnvironment;Ljava/lang/Object;)V", "reportError", "", "error", "Lcom/arizona/launcher/UpdateAnalyticsErrorEvent;", "failureDetails", "Lcom/arizona/launcher/DownloadFailureDetails;", "serverUrl", "", "reportArchiveIndexRetry", "packageId", "retryAttempt", "", "delayMs", "", "failure", "reportArchivePackageRetry", "failureSubtype", "finishFirstLaunchSession", "reportArchiveRetry", "stage", "markFirstLaunchErrorReported", "", "errorCode", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateAnalyticsReporter {
    private final UpdateAnalyticsEnvironment environment;
    private final UpdateAnalyticsEventSink eventSink;
    private final Object firstLaunchLock;
    private final UpdateFirstLaunchStore firstLaunchStore;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public UpdateAnalyticsReporter(UpdateAnalyticsEventSink eventSink, UpdateFirstLaunchStore firstLaunchStore, UpdateAnalyticsEnvironment environment, Object firstLaunchLock) {
        Intrinsics.checkNotNullParameter(eventSink, "eventSink");
        Intrinsics.checkNotNullParameter(firstLaunchStore, "firstLaunchStore");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(firstLaunchLock, "firstLaunchLock");
        this.eventSink = eventSink;
        this.firstLaunchStore = firstLaunchStore;
        this.environment = environment;
        this.firstLaunchLock = firstLaunchLock;
    }

    public /* synthetic */ UpdateAnalyticsReporter(UpdateAnalyticsEventSink updateAnalyticsEventSink, UpdateFirstLaunchStore updateFirstLaunchStore, UpdateAnalyticsEnvironment updateAnalyticsEnvironment, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(updateAnalyticsEventSink, updateFirstLaunchStore, updateAnalyticsEnvironment, (i & 8) != 0 ? new Object() : obj);
    }

    public static /* synthetic */ void reportError$default(UpdateAnalyticsReporter updateAnalyticsReporter, UpdateAnalyticsErrorEvent updateAnalyticsErrorEvent, DownloadFailureDetails downloadFailureDetails, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            downloadFailureDetails = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        updateAnalyticsReporter.reportError(updateAnalyticsErrorEvent, downloadFailureDetails, str);
    }

    public final void reportError(UpdateAnalyticsErrorEvent error, DownloadFailureDetails downloadFailureDetails, String str) {
        String hostOf;
        Intrinsics.checkNotNullParameter(error, "error");
        LinkedHashMap linkedMapOf = MapsKt.linkedMapOf(TuplesKt.to(UpdateAnalyticsContract.LEGACY_CALL_SITE_PARAM, Integer.valueOf(error.getLegacyCallSite())), TuplesKt.to(UpdateAnalyticsContract.SOURCE_LINE_PARAM, Integer.valueOf(error.getLegacyCallSite())), TuplesKt.to("errno", Integer.valueOf(error.getErrno().getCode())), TuplesKt.to(UpdateAnalyticsContract.ERRNO_CODE_PARAM, Integer.valueOf(error.getErrno().getCode())), TuplesKt.to(UpdateAnalyticsContract.ERRNO_NAME_PARAM, error.getErrno().name()), TuplesKt.to(UpdateAnalyticsContract.ERROR_CODE_PARAM, Integer.valueOf(error.getCode())), TuplesKt.to(UpdateAnalyticsContract.ERROR_TYPE_PARAM, error.name()));
        if (downloadFailureDetails != null) {
            LinkedHashMap linkedHashMap = linkedMapOf;
            linkedHashMap.put(UpdateAnalyticsContract.ERROR_SUBTYPE_PARAM, downloadFailureDetails.subtypeFor(error.name()));
            Integer httpStatus = downloadFailureDetails.getHttpStatus();
            if (httpStatus != null) {
                linkedHashMap.put(UpdateAnalyticsContract.HTTP_STATUS_PARAM, Integer.valueOf(httpStatus.intValue()));
            }
        }
        LinkedHashMap linkedHashMap2 = linkedMapOf;
        linkedHashMap2.put(UpdateAnalyticsContract.ERROR_CONTEXT_PARAM, error.getContext());
        if (str == null) {
            str = this.environment.getDefaultServerUrl();
        }
        hostOf = UpdateAnalyticsReporterKt.hostOf(str);
        if (hostOf == null) {
            hostOf = "";
        }
        linkedHashMap2.put(UpdateAnalyticsContract.SERVER_HOST_PARAM, hostOf);
        linkedHashMap2.put(UpdateAnalyticsContract.NETWORK_INTERNET_CAPABLE_PARAM, Boolean.valueOf(this.environment.getInternetCapable()));
        linkedHashMap2.put(UpdateAnalyticsContract.NETWORK_VALIDATED_PARAM, Boolean.valueOf(this.environment.getNetworkValidated()));
        this.eventSink.logEvent(UpdateAnalyticsContract.DOWNLOAD_ERROR_EVENT, linkedHashMap2);
        if (markFirstLaunchErrorReported(error.getCode())) {
            UpdateAnalyticsEventSink updateAnalyticsEventSink = this.eventSink;
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(linkedHashMap2);
            linkedHashMap3.put(UpdateAnalyticsContract.EVENT_TAG_PARAM, "first_launch");
            linkedHashMap3.put("first_launch", true);
            linkedHashMap3.put(UpdateAnalyticsContract.FIRST_LAUNCH_DEDUPED_PARAM, true);
            Unit unit = Unit.INSTANCE;
            updateAnalyticsEventSink.logEvent(UpdateAnalyticsContract.DOWNLOAD_ERROR_FIRST_LAUNCH_EVENT, linkedHashMap3);
        }
    }

    public final void reportArchiveIndexRetry(String packageId, int i, long j, DownloadFailureDetails failure, String str) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(failure, "failure");
        reportArchiveRetry(UpdateAnalyticsContract.ARCHIVE_INDEX_RETRY_STAGE, packageId, i, j, failure.getSubtypeSuffix(), str);
    }

    public final void reportArchivePackageRetry(String packageId, int i, long j, String failureSubtype, String str) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(failureSubtype, "failureSubtype");
        reportArchiveRetry(UpdateAnalyticsContract.ARCHIVE_PACKAGE_RETRY_STAGE, packageId, i, j, failureSubtype, str);
    }

    public final void finishFirstLaunchSession() {
        synchronized (this.firstLaunchLock) {
            this.firstLaunchStore.finishErrorSession();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void reportArchiveRetry(String str, String str2, int i, long j, String str3, String str4) {
        String hostOf;
        UpdateAnalyticsEventSink updateAnalyticsEventSink = this.eventSink;
        Pair[] pairArr = new Pair[6];
        pairArr[0] = TuplesKt.to(UpdateAnalyticsContract.RETRY_STAGE_PARAM, str);
        pairArr[1] = TuplesKt.to(UpdateAnalyticsContract.ARCHIVE_PACKAGE_ID_PARAM, str2);
        pairArr[2] = TuplesKt.to(UpdateAnalyticsContract.RETRY_ATTEMPT_PARAM, Integer.valueOf(i));
        pairArr[3] = TuplesKt.to(UpdateAnalyticsContract.RETRY_DELAY_MS_PARAM, Long.valueOf(j));
        pairArr[4] = TuplesKt.to(UpdateAnalyticsContract.ERROR_SUBTYPE_PARAM, str3);
        hostOf = UpdateAnalyticsReporterKt.hostOf(str4);
        if (hostOf == null) {
            hostOf = "";
        }
        pairArr[5] = TuplesKt.to(UpdateAnalyticsContract.SERVER_HOST_PARAM, hostOf);
        updateAnalyticsEventSink.logEvent(UpdateAnalyticsContract.DOWNLOAD_RETRY_EVENT, MapsKt.linkedMapOf(pairArr));
    }

    private final boolean markFirstLaunchErrorReported(int i) {
        boolean z;
        synchronized (this.firstLaunchLock) {
            z = false;
            if (this.firstLaunchStore.isErrorSessionActive() || this.firstLaunchStore.isFirstStart()) {
                String valueOf = String.valueOf(i);
                Set<String> reportedErrorCodes = this.firstLaunchStore.reportedErrorCodes();
                if (!reportedErrorCodes.contains(valueOf)) {
                    UpdateFirstLaunchStore updateFirstLaunchStore = this.firstLaunchStore;
                    Set<String> mutableSet = CollectionsKt.toMutableSet(reportedErrorCodes);
                    mutableSet.add(valueOf);
                    updateFirstLaunchStore.saveReportedErrorCodes(mutableSet);
                    z = true;
                }
            }
        }
        return z;
    }

    /* compiled from: UpdateAnalyticsReporter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Lcom/arizona/launcher/UpdateAnalyticsReporter$Companion;", "", "<init>", "()V", "createAndroid", "Lcom/arizona/launcher/UpdateAnalyticsReporter;", "context", "Landroid/content/Context;", "currentServerUrl", "Lkotlin/Function0;", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UpdateAnalyticsReporter createAndroid$default(Companion companion, Context context, Function0 function0, int i, Object obj) {
            if ((i & 2) != 0) {
                function0 = new Function0() { // from class: com.arizona.launcher.UpdateAnalyticsReporter$Companion$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        String currentServer;
                        currentServer = FileServers.INSTANCE.getCurrentServer();
                        return currentServer;
                    }
                };
            }
            return companion.createAndroid(context, function0);
        }

        public final UpdateAnalyticsReporter createAndroid(Context context, Function0<String> currentServerUrl) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(currentServerUrl, "currentServerUrl");
            return new UpdateAnalyticsReporter(new FirebaseUpdateAnalyticsEventSink(context), new AndroidUpdateFirstLaunchStore(context), new AndroidUpdateAnalyticsEnvironment(context, currentServerUrl), null, 8, null);
        }
    }
}
