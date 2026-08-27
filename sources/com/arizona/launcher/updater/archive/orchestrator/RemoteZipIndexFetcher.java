package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.orchestrator.ArchiveByteRangeResult;
import com.arizona.launcher.updater.archive.orchestrator.RemoteZipIndexFetchResult;
import com.arizona.launcher.updater.archive.range.ArchiveObservedRepresentationFence;
import com.arizona.launcher.updater.archive.range.RemoteZipDirectoryLocation;
import com.arizona.launcher.updater.archive.range.RemoteZipDirectoryLocationResult;
import com.arizona.launcher.updater.archive.range.RemoteZipIndex;
import com.arizona.launcher.updater.archive.range.RemoteZipIndexParseResult;
import com.arizona.launcher.updater.archive.range.RemoteZipIndexParser;
import com.arizona.launcher.updater.archive.range.StrongEtag;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: RemoteZipIndexFetcher.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fJ\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0014"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipIndexFetcher;", "", "byteRangeSource", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeSource;", "parser", "Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexParser;", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeSource;Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexParser;)V", RemoteConfigComponent.FETCH_FILE_NAME, "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipIndexFetchResult;", "packageId", "", "archiveUrl", "archiveSize", "", "(Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toIndexFailure", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipIndexFetchResult$Failure;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeResult$Failure;", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RemoteZipIndexFetcher {
    @Deprecated
    public static final long ZIP_EOCD_TAIL_BYTES = 65557;
    private final ArchiveByteRangeSource byteRangeSource;
    private final RemoteZipIndexParser parser;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = RemoteZipIndexParser.$stable;

    public RemoteZipIndexFetcher(ArchiveByteRangeSource byteRangeSource, RemoteZipIndexParser parser) {
        Intrinsics.checkNotNullParameter(byteRangeSource, "byteRangeSource");
        Intrinsics.checkNotNullParameter(parser, "parser");
        this.byteRangeSource = byteRangeSource;
        this.parser = parser;
    }

    public /* synthetic */ RemoteZipIndexFetcher(ArchiveByteRangeSource archiveByteRangeSource, RemoteZipIndexParser remoteZipIndexParser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(archiveByteRangeSource, (i & 2) != 0 ? new RemoteZipIndexParser(null, 1, null) : remoteZipIndexParser);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0257  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetch(String str, String str2, long j, Continuation<? super RemoteZipIndexFetchResult> continuation) {
        RemoteZipIndexFetcher$fetch$1 remoteZipIndexFetcher$fetch$1;
        int i;
        long j2;
        char c;
        long j3;
        String str3;
        String str4;
        long j4;
        ArchiveByteRangeResult archiveByteRangeResult;
        ArchiveByteRangeResponse response;
        RemoteZipIndexFetcher remoteZipIndexFetcher;
        RemoteZipDirectoryLocation location;
        long length;
        char c2;
        int i2;
        RemoteZipDirectoryLocation remoteZipDirectoryLocation;
        long j5;
        StrongEtag strongEtag;
        byte[] copyOfRange;
        RemoteZipIndexParseResult parseCentralDirectory;
        ArchiveByteRangeResult archiveByteRangeResult2;
        long j6;
        if (continuation instanceof RemoteZipIndexFetcher$fetch$1) {
            remoteZipIndexFetcher$fetch$1 = (RemoteZipIndexFetcher$fetch$1) continuation;
            if ((remoteZipIndexFetcher$fetch$1.label & Integer.MIN_VALUE) != 0) {
                remoteZipIndexFetcher$fetch$1.label -= Integer.MIN_VALUE;
                RemoteZipIndexFetcher$fetch$1 remoteZipIndexFetcher$fetch$12 = remoteZipIndexFetcher$fetch$1;
                Object obj = remoteZipIndexFetcher$fetch$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = remoteZipIndexFetcher$fetch$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    long coerceAtLeast = RangesKt.coerceAtLeast(j - ZIP_EOCD_TAIL_BYTES, 0L);
                    ArchiveByteRangeSource archiveByteRangeSource = this.byteRangeSource;
                    j2 = coerceAtLeast;
                    c = 1;
                    j3 = 1;
                    ArchiveByteRangeRequest archiveByteRangeRequest = new ArchiveByteRangeRequest(str, str2, j2, j - 1, j, null, 32, null);
                    remoteZipIndexFetcher$fetch$12.L$0 = str;
                    remoteZipIndexFetcher$fetch$12.L$1 = str2;
                    remoteZipIndexFetcher$fetch$12.J$0 = j;
                    remoteZipIndexFetcher$fetch$12.J$1 = j2;
                    remoteZipIndexFetcher$fetch$12.label = 1;
                    obj = archiveByteRangeSource.fetch(archiveByteRangeRequest, remoteZipIndexFetcher$fetch$12);
                    if (obj != coroutine_suspended) {
                        str3 = str;
                        str4 = str2;
                        j4 = j;
                    }
                    return coroutine_suspended;
                } else if (i != 1) {
                    if (i == 2) {
                        j5 = remoteZipIndexFetcher$fetch$12.J$3;
                        long j7 = remoteZipIndexFetcher$fetch$12.J$2;
                        long j8 = remoteZipIndexFetcher$fetch$12.J$1;
                        long j9 = remoteZipIndexFetcher$fetch$12.J$0;
                        strongEtag = (StrongEtag) remoteZipIndexFetcher$fetch$12.L$4;
                        RemoteZipDirectoryLocation remoteZipDirectoryLocation2 = (RemoteZipDirectoryLocation) remoteZipIndexFetcher$fetch$12.L$3;
                        response = (ArchiveByteRangeResponse) remoteZipIndexFetcher$fetch$12.L$2;
                        String str5 = (String) remoteZipIndexFetcher$fetch$12.L$1;
                        String str6 = (String) remoteZipIndexFetcher$fetch$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        remoteZipIndexFetcher = this;
                        i2 = 2;
                        remoteZipDirectoryLocation = remoteZipDirectoryLocation2;
                        c2 = 1;
                        archiveByteRangeResult2 = (ArchiveByteRangeResult) obj;
                        if (archiveByteRangeResult2 instanceof ArchiveByteRangeResult.Success) {
                            if (archiveByteRangeResult2 instanceof ArchiveByteRangeResult.Failure) {
                                return remoteZipIndexFetcher.toIndexFailure((ArchiveByteRangeResult.Failure) archiveByteRangeResult2);
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        ArchiveByteRangeResponse response2 = ((ArchiveByteRangeResult.Success) archiveByteRangeResult2).getResponse();
                        if (!Intrinsics.areEqual(response2.getStrongEtag(), strongEtag) || !Intrinsics.areEqual(response2.getEffectiveUrl(), response.getEffectiveUrl())) {
                            return new RemoteZipIndexFetchResult.Failure(ArchiveManifestResolutionErrorCode.REMOTE_REPRESENTATION_CHANGED, "ZIP representation changed between Range requests");
                        }
                        try {
                            j6 = Math.addExact(j5, response2.getBytes().length);
                        } catch (ArithmeticException unused) {
                            j6 = Long.MAX_VALUE;
                        }
                        length = j6;
                        copyOfRange = response2.getBytes();
                        location = remoteZipDirectoryLocation;
                        parseCentralDirectory = remoteZipIndexFetcher.parser.parseCentralDirectory(location, copyOfRange);
                        if (parseCentralDirectory instanceof RemoteZipIndexParseResult.Success) {
                            if (!(parseCentralDirectory instanceof RemoteZipIndexParseResult.Failure)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            ArchiveManifestResolutionErrorCode archiveManifestResolutionErrorCode = ArchiveManifestResolutionErrorCode.REMOTE_INDEX_INVALID;
                            String[] strArr = new String[i2];
                            RemoteZipIndexParseResult.Failure failure = (RemoteZipIndexParseResult.Failure) parseCentralDirectory;
                            strArr[0] = failure.getCode().name();
                            strArr[c2] = failure.getEntryPath();
                            return new RemoteZipIndexFetchResult.Failure(archiveManifestResolutionErrorCode, CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) strArr), StringUtils.PROCESS_POSTFIX_DELIMITER, null, null, 0, null, null, 62, null));
                        }
                        RemoteZipIndex index = ((RemoteZipIndexParseResult.Success) parseCentralDirectory).getIndex();
                        StrongEtag strongEtag2 = response.getStrongEtag();
                        return new RemoteZipIndexFetchResult.Success(new RemoteZipIndexSession(index, strongEtag2 != null ? new ArchiveObservedRepresentationFence(strongEtag2) : null, response.getEffectiveUrl(), length));
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    long j10 = remoteZipIndexFetcher$fetch$12.J$1;
                    long j11 = remoteZipIndexFetcher$fetch$12.J$0;
                    ResultKt.throwOnFailure(obj);
                    str4 = (String) remoteZipIndexFetcher$fetch$12.L$1;
                    c = 1;
                    j2 = j10;
                    j4 = j11;
                    str3 = (String) remoteZipIndexFetcher$fetch$12.L$0;
                    j3 = 1;
                }
                archiveByteRangeResult = (ArchiveByteRangeResult) obj;
                if (archiveByteRangeResult instanceof ArchiveByteRangeResult.Success) {
                    if (archiveByteRangeResult instanceof ArchiveByteRangeResult.Failure) {
                        return toIndexFailure((ArchiveByteRangeResult.Failure) archiveByteRangeResult);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                response = ((ArchiveByteRangeResult.Success) archiveByteRangeResult).getResponse();
                remoteZipIndexFetcher = this;
                RemoteZipDirectoryLocationResult parseEocdTail = remoteZipIndexFetcher.parser.parseEocdTail(j4, j2, response.getBytes());
                if (!(parseEocdTail instanceof RemoteZipDirectoryLocationResult.Success)) {
                    if (!(parseEocdTail instanceof RemoteZipDirectoryLocationResult.Failure)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return new RemoteZipIndexFetchResult.Failure(ArchiveManifestResolutionErrorCode.REMOTE_INDEX_INVALID, ((RemoteZipDirectoryLocationResult.Failure) parseEocdTail).getCode().name());
                }
                location = ((RemoteZipDirectoryLocationResult.Success) parseEocdTail).getLocation();
                try {
                    long addExact = Math.addExact(location.getCentralDirectoryOffset(), location.getCentralDirectorySize());
                    length = response.getBytes().length;
                    if (location.getCentralDirectoryOffset() >= j2 && addExact <= j4) {
                        copyOfRange = ArraysKt.copyOfRange(response.getBytes(), (int) (location.getCentralDirectoryOffset() - j2), (int) (addExact - j2));
                        c2 = c;
                        i2 = 2;
                        parseCentralDirectory = remoteZipIndexFetcher.parser.parseCentralDirectory(location, copyOfRange);
                        if (parseCentralDirectory instanceof RemoteZipIndexParseResult.Success) {
                        }
                    } else {
                        StrongEtag strongEtag3 = response.getStrongEtag();
                        if (strongEtag3 == null) {
                            return new RemoteZipIndexFetchResult.Failure(ArchiveManifestResolutionErrorCode.REMOTE_REPRESENTATION_CHANGED, "two-range ZIP index requires a strong ETag");
                        }
                        ArchiveByteRangeSource archiveByteRangeSource2 = remoteZipIndexFetcher.byteRangeSource;
                        ArchiveByteRangeRequest archiveByteRangeRequest2 = new ArchiveByteRangeRequest(str3, str4, location.getCentralDirectoryOffset(), addExact - j3, j4, strongEtag3);
                        remoteZipIndexFetcher$fetch$12.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                        remoteZipIndexFetcher$fetch$12.L$1 = SpillingKt.nullOutSpilledVariable(str4);
                        remoteZipIndexFetcher$fetch$12.L$2 = response;
                        remoteZipIndexFetcher$fetch$12.L$3 = location;
                        remoteZipIndexFetcher$fetch$12.L$4 = strongEtag3;
                        c2 = c;
                        remoteZipIndexFetcher$fetch$12.J$0 = j4;
                        remoteZipIndexFetcher$fetch$12.J$1 = j2;
                        remoteZipIndexFetcher$fetch$12.J$2 = addExact;
                        remoteZipIndexFetcher$fetch$12.J$3 = length;
                        i2 = 2;
                        remoteZipIndexFetcher$fetch$12.label = 2;
                        obj = archiveByteRangeSource2.fetch(archiveByteRangeRequest2, remoteZipIndexFetcher$fetch$12);
                        if (obj != coroutine_suspended) {
                            remoteZipDirectoryLocation = location;
                            j5 = length;
                            strongEtag = strongEtag3;
                            archiveByteRangeResult2 = (ArchiveByteRangeResult) obj;
                            if (archiveByteRangeResult2 instanceof ArchiveByteRangeResult.Success) {
                            }
                        }
                        return coroutine_suspended;
                    }
                } catch (ArithmeticException unused2) {
                    return new RemoteZipIndexFetchResult.Failure(ArchiveManifestResolutionErrorCode.REMOTE_INDEX_INVALID, "central directory bounds overflow");
                }
            }
        }
        remoteZipIndexFetcher$fetch$1 = new RemoteZipIndexFetcher$fetch$1(this, continuation);
        RemoteZipIndexFetcher$fetch$1 remoteZipIndexFetcher$fetch$122 = remoteZipIndexFetcher$fetch$1;
        Object obj2 = remoteZipIndexFetcher$fetch$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = remoteZipIndexFetcher$fetch$122.label;
        if (i != 0) {
        }
        archiveByteRangeResult = (ArchiveByteRangeResult) obj2;
        if (archiveByteRangeResult instanceof ArchiveByteRangeResult.Success) {
        }
    }

    private final RemoteZipIndexFetchResult.Failure toIndexFailure(ArchiveByteRangeResult.Failure failure) {
        ArchiveManifestResolutionErrorCode archiveManifestResolutionErrorCode;
        if (failure.getCode() == ArchiveByteRangeErrorCode.HTTP_STATUS && CollectionsKt.contains(SetsKt.setOf((Object[]) new Integer[]{200, 412, 416}), failure.getHttpStatus())) {
            archiveManifestResolutionErrorCode = ArchiveManifestResolutionErrorCode.REMOTE_REPRESENTATION_CHANGED;
        } else {
            archiveManifestResolutionErrorCode = ArchiveManifestResolutionErrorCode.REMOTE_INDEX_UNAVAILABLE;
        }
        String[] strArr = new String[3];
        strArr[0] = failure.getCode().name();
        Integer httpStatus = failure.getHttpStatus();
        strArr[1] = httpStatus != null ? String.valueOf(httpStatus.intValue()) : null;
        strArr[2] = failure.getDetail();
        return new RemoteZipIndexFetchResult.Failure(archiveManifestResolutionErrorCode, CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) strArr), StringUtils.PROCESS_POSTFIX_DELIMITER, null, null, 0, null, null, 62, null));
    }

    /* compiled from: RemoteZipIndexFetcher.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipIndexFetcher$Companion;", "", "<init>", "()V", "ZIP_EOCD_TAIL_BYTES", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
