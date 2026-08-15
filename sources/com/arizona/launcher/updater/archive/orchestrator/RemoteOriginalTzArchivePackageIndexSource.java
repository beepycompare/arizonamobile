package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.manifest.OriginalTzArchivePackageDescriptor;
import com.arizona.launcher.updater.archive.model.ArchiveEntryMetadata;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveByteRangeResult;
import com.arizona.launcher.updater.archive.orchestrator.OriginalTzArchivePackageIndexResult;
import com.arizona.launcher.updater.archive.range.RemoteZipDirectoryLocation;
import com.arizona.launcher.updater.archive.range.RemoteZipDirectoryLocationResult;
import com.arizona.launcher.updater.archive.range.RemoteZipEntry;
import com.arizona.launcher.updater.archive.range.RemoteZipIndex;
import com.arizona.launcher.updater.archive.range.RemoteZipIndexParseResult;
import com.arizona.launcher.updater.archive.range.RemoteZipIndexParser;
import com.arizona.launcher.updater.archive.range.StrongEtag;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/RemoteOriginalTzArchivePackageIndexSource;", "Lcom/arizona/launcher/updater/archive/orchestrator/OriginalTzArchivePackageIndexSource;", "byteRangeSource", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeSource;", "parser", "Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexParser;", "allowInsecureLoopback", "", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeSource;Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexParser;Z)V", "read", "Lcom/arizona/launcher/updater/archive/orchestrator/OriginalTzArchivePackageIndexResult;", "packageDescriptor", "Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchivePackageDescriptor;", "serverBaseUrl", "", "(Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchivePackageDescriptor;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toIndexFailure", "Lcom/arizona/launcher/updater/archive/orchestrator/OriginalTzArchivePackageIndexResult$Failure;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeResult$Failure;", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RemoteOriginalTzArchivePackageIndexSource implements OriginalTzArchivePackageIndexSource {
    @Deprecated
    public static final long ZIP_EOCD_TAIL_BYTES = 65557;
    private final boolean allowInsecureLoopback;
    private final ArchiveByteRangeSource byteRangeSource;
    private final RemoteZipIndexParser parser;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = RemoteZipIndexParser.$stable;

    public RemoteOriginalTzArchivePackageIndexSource(ArchiveByteRangeSource byteRangeSource, RemoteZipIndexParser parser, boolean z) {
        Intrinsics.checkNotNullParameter(byteRangeSource, "byteRangeSource");
        Intrinsics.checkNotNullParameter(parser, "parser");
        this.byteRangeSource = byteRangeSource;
        this.parser = parser;
        this.allowInsecureLoopback = z;
    }

    public /* synthetic */ RemoteOriginalTzArchivePackageIndexSource(ArchiveByteRangeSource archiveByteRangeSource, RemoteZipIndexParser remoteZipIndexParser, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(archiveByteRangeSource, (i & 2) != 0 ? new RemoteZipIndexParser(null, 1, null) : remoteZipIndexParser, (i & 4) != 0 ? false : z);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0283  */
    @Override // com.arizona.launcher.updater.archive.orchestrator.OriginalTzArchivePackageIndexSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object read(OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor, String str, Continuation<? super OriginalTzArchivePackageIndexResult> continuation) {
        RemoteOriginalTzArchivePackageIndexSource$read$1 remoteOriginalTzArchivePackageIndexSource$read$1;
        int i;
        String resolveArchiveUrl;
        long j;
        long j2;
        String str2;
        OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor2;
        String str3;
        OriginalTzArchivePackageIndexResult.Failure indexFailure;
        ArchiveByteRangeResult archiveByteRangeResult;
        ArchiveByteRangeResponse response;
        OriginalTzArchivePackageIndexResult.Failure indexFailure2;
        RemoteZipDirectoryLocation location;
        long j3;
        OriginalTzArchivePackageIndexResult.Failure indexFailure3;
        char c;
        StrongEtag strongEtag;
        OriginalTzArchivePackageIndexResult.Failure indexFailure4;
        byte[] copyOfRange;
        RemoteZipIndexParseResult parseCentralDirectory;
        OriginalTzArchivePackageIndexResult.Failure indexFailure5;
        OriginalTzArchivePackageIndexResult.Failure indexFailure6;
        ArchiveByteRangeResult archiveByteRangeResult2;
        OriginalTzArchivePackageIndexResult.Failure indexFailure7;
        if (continuation instanceof RemoteOriginalTzArchivePackageIndexSource$read$1) {
            remoteOriginalTzArchivePackageIndexSource$read$1 = (RemoteOriginalTzArchivePackageIndexSource$read$1) continuation;
            if ((remoteOriginalTzArchivePackageIndexSource$read$1.label & Integer.MIN_VALUE) != 0) {
                remoteOriginalTzArchivePackageIndexSource$read$1.label -= Integer.MIN_VALUE;
                Object obj = remoteOriginalTzArchivePackageIndexSource$read$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = remoteOriginalTzArchivePackageIndexSource$read$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    resolveArchiveUrl = ArchiveManifestResolverKt.resolveArchiveUrl(str, originalTzArchivePackageDescriptor.getUrl(), this.allowInsecureLoopback);
                    if (resolveArchiveUrl == null) {
                        indexFailure = ArchiveManifestResolverKt.indexFailure(ArchiveManifestResolutionErrorCode.REMOTE_INDEX_UNAVAILABLE, "unsafe or malformed archive URL");
                        return indexFailure;
                    }
                    long coerceAtLeast = RangesKt.coerceAtLeast(originalTzArchivePackageDescriptor.getArchiveSize() - ZIP_EOCD_TAIL_BYTES, 0L);
                    ArchiveByteRangeSource archiveByteRangeSource = this.byteRangeSource;
                    ArchiveByteRangeRequest archiveByteRangeRequest = new ArchiveByteRangeRequest(originalTzArchivePackageDescriptor.getId(), resolveArchiveUrl, coerceAtLeast, originalTzArchivePackageDescriptor.getArchiveSize() - 1, originalTzArchivePackageDescriptor.getArchiveSize(), null, 32, null);
                    remoteOriginalTzArchivePackageIndexSource$read$1.L$0 = originalTzArchivePackageDescriptor;
                    j = 1;
                    remoteOriginalTzArchivePackageIndexSource$read$1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    remoteOriginalTzArchivePackageIndexSource$read$1.L$2 = resolveArchiveUrl;
                    remoteOriginalTzArchivePackageIndexSource$read$1.J$0 = coerceAtLeast;
                    remoteOriginalTzArchivePackageIndexSource$read$1.label = 1;
                    obj = archiveByteRangeSource.fetch(archiveByteRangeRequest, remoteOriginalTzArchivePackageIndexSource$read$1);
                    if (obj != coroutine_suspended) {
                        j2 = coerceAtLeast;
                        str2 = resolveArchiveUrl;
                        originalTzArchivePackageDescriptor2 = originalTzArchivePackageDescriptor;
                        str3 = str;
                    }
                    return coroutine_suspended;
                } else if (i != 1) {
                    if (i == 2) {
                        long j4 = remoteOriginalTzArchivePackageIndexSource$read$1.J$1;
                        long j5 = remoteOriginalTzArchivePackageIndexSource$read$1.J$0;
                        strongEtag = (StrongEtag) remoteOriginalTzArchivePackageIndexSource$read$1.L$5;
                        location = (RemoteZipDirectoryLocation) remoteOriginalTzArchivePackageIndexSource$read$1.L$4;
                        response = (ArchiveByteRangeResponse) remoteOriginalTzArchivePackageIndexSource$read$1.L$3;
                        String str4 = (String) remoteOriginalTzArchivePackageIndexSource$read$1.L$2;
                        String str5 = (String) remoteOriginalTzArchivePackageIndexSource$read$1.L$1;
                        OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor3 = (OriginalTzArchivePackageDescriptor) remoteOriginalTzArchivePackageIndexSource$read$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        j3 = 0;
                        c = 1;
                        archiveByteRangeResult2 = (ArchiveByteRangeResult) obj;
                        if (archiveByteRangeResult2 instanceof ArchiveByteRangeResult.Success) {
                            if (archiveByteRangeResult2 instanceof ArchiveByteRangeResult.Failure) {
                                return toIndexFailure((ArchiveByteRangeResult.Failure) archiveByteRangeResult2);
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        ArchiveByteRangeResponse response2 = ((ArchiveByteRangeResult.Success) archiveByteRangeResult2).getResponse();
                        if (!Intrinsics.areEqual(response2.getStrongEtag(), strongEtag) || !Intrinsics.areEqual(response2.getEffectiveUrl(), response.getEffectiveUrl())) {
                            indexFailure7 = ArchiveManifestResolverKt.indexFailure(ArchiveManifestResolutionErrorCode.REMOTE_REPRESENTATION_CHANGED, "ZIP representation changed between Range requests");
                            return indexFailure7;
                        }
                        copyOfRange = response2.getBytes();
                        parseCentralDirectory = this.parser.parseCentralDirectory(location, copyOfRange);
                        if (parseCentralDirectory instanceof RemoteZipIndexParseResult.Success) {
                            if (!(parseCentralDirectory instanceof RemoteZipIndexParseResult.Failure)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            ArchiveManifestResolutionErrorCode archiveManifestResolutionErrorCode = ArchiveManifestResolutionErrorCode.REMOTE_INDEX_INVALID;
                            String[] strArr = new String[2];
                            RemoteZipIndexParseResult.Failure failure = (RemoteZipIndexParseResult.Failure) parseCentralDirectory;
                            strArr[0] = failure.getCode().name();
                            strArr[c] = failure.getEntryPath();
                            indexFailure5 = ArchiveManifestResolverKt.indexFailure(archiveManifestResolutionErrorCode, CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) strArr), StringUtils.PROCESS_POSTFIX_DELIMITER, null, null, 0, null, null, 62, null));
                            return indexFailure5;
                        }
                        RemoteZipIndex index = ((RemoteZipIndexParseResult.Success) parseCentralDirectory).getIndex();
                        List list = SequencesKt.toList(SequencesKt.map(SequencesKt.filterNot(CollectionsKt.asSequence(index.getEntries()), new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.RemoteOriginalTzArchivePackageIndexSource$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return Boolean.valueOf(RemoteOriginalTzArchivePackageIndexSource.read$lambda$0((RemoteZipEntry) obj2));
                            }
                        }), new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.RemoteOriginalTzArchivePackageIndexSource$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return RemoteOriginalTzArchivePackageIndexSource.read$lambda$1((RemoteZipEntry) obj2);
                            }
                        }));
                        if (list.isEmpty() || index.getTotalUncompressedBytes() <= j3) {
                            indexFailure6 = ArchiveManifestResolverKt.indexFailure(ArchiveManifestResolutionErrorCode.REMOTE_INDEX_INVALID, "ZIP contains no installable files");
                            return indexFailure6;
                        }
                        return new OriginalTzArchivePackageIndexResult.Success(new OriginalTzArchivePackageIndex(list, index.getTotalUncompressedBytes()));
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    long j6 = remoteOriginalTzArchivePackageIndexSource$read$1.J$0;
                    str3 = (String) remoteOriginalTzArchivePackageIndexSource$read$1.L$1;
                    originalTzArchivePackageDescriptor2 = (OriginalTzArchivePackageDescriptor) remoteOriginalTzArchivePackageIndexSource$read$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    str2 = (String) remoteOriginalTzArchivePackageIndexSource$read$1.L$2;
                    j = 1;
                    j2 = j6;
                }
                archiveByteRangeResult = (ArchiveByteRangeResult) obj;
                if (archiveByteRangeResult instanceof ArchiveByteRangeResult.Success) {
                    if (archiveByteRangeResult instanceof ArchiveByteRangeResult.Failure) {
                        return toIndexFailure((ArchiveByteRangeResult.Failure) archiveByteRangeResult);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                response = ((ArchiveByteRangeResult.Success) archiveByteRangeResult).getResponse();
                RemoteZipDirectoryLocationResult parseEocdTail = this.parser.parseEocdTail(originalTzArchivePackageDescriptor2.getArchiveSize(), j2, response.getBytes());
                long j7 = j2;
                if (!(parseEocdTail instanceof RemoteZipDirectoryLocationResult.Success)) {
                    if (parseEocdTail instanceof RemoteZipDirectoryLocationResult.Failure) {
                        indexFailure2 = ArchiveManifestResolverKt.indexFailure(ArchiveManifestResolutionErrorCode.REMOTE_INDEX_INVALID, ((RemoteZipDirectoryLocationResult.Failure) parseEocdTail).getCode().name());
                        return indexFailure2;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                location = ((RemoteZipDirectoryLocationResult.Success) parseEocdTail).getLocation();
                j3 = 0;
                try {
                    c = 1;
                    long addExact = Math.addExact(location.getCentralDirectoryOffset(), location.getCentralDirectorySize());
                    if (location.getCentralDirectoryOffset() >= j7 && addExact <= originalTzArchivePackageDescriptor2.getArchiveSize()) {
                        copyOfRange = ArraysKt.copyOfRange(response.getBytes(), (int) (location.getCentralDirectoryOffset() - j7), (int) (addExact - j7));
                        parseCentralDirectory = this.parser.parseCentralDirectory(location, copyOfRange);
                        if (parseCentralDirectory instanceof RemoteZipIndexParseResult.Success) {
                        }
                    } else {
                        StrongEtag strongEtag2 = response.getStrongEtag();
                        if (strongEtag2 == null) {
                            indexFailure4 = ArchiveManifestResolverKt.indexFailure(ArchiveManifestResolutionErrorCode.REMOTE_REPRESENTATION_CHANGED, "two-range ZIP index requires a strong ETag");
                            return indexFailure4;
                        }
                        ArchiveByteRangeSource archiveByteRangeSource2 = this.byteRangeSource;
                        ArchiveByteRangeRequest archiveByteRangeRequest2 = new ArchiveByteRangeRequest(originalTzArchivePackageDescriptor2.getId(), str2, location.getCentralDirectoryOffset(), addExact - j, originalTzArchivePackageDescriptor2.getArchiveSize(), strongEtag2);
                        remoteOriginalTzArchivePackageIndexSource$read$1.L$0 = SpillingKt.nullOutSpilledVariable(originalTzArchivePackageDescriptor2);
                        remoteOriginalTzArchivePackageIndexSource$read$1.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                        remoteOriginalTzArchivePackageIndexSource$read$1.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                        remoteOriginalTzArchivePackageIndexSource$read$1.L$3 = response;
                        remoteOriginalTzArchivePackageIndexSource$read$1.L$4 = location;
                        remoteOriginalTzArchivePackageIndexSource$read$1.L$5 = strongEtag2;
                        remoteOriginalTzArchivePackageIndexSource$read$1.J$0 = j7;
                        remoteOriginalTzArchivePackageIndexSource$read$1.J$1 = addExact;
                        remoteOriginalTzArchivePackageIndexSource$read$1.label = 2;
                        obj = archiveByteRangeSource2.fetch(archiveByteRangeRequest2, remoteOriginalTzArchivePackageIndexSource$read$1);
                        if (obj != coroutine_suspended) {
                            strongEtag = strongEtag2;
                            archiveByteRangeResult2 = (ArchiveByteRangeResult) obj;
                            if (archiveByteRangeResult2 instanceof ArchiveByteRangeResult.Success) {
                            }
                        }
                        return coroutine_suspended;
                    }
                } catch (ArithmeticException unused) {
                    indexFailure3 = ArchiveManifestResolverKt.indexFailure(ArchiveManifestResolutionErrorCode.REMOTE_INDEX_INVALID, "central directory bounds overflow");
                    return indexFailure3;
                }
            }
        }
        remoteOriginalTzArchivePackageIndexSource$read$1 = new RemoteOriginalTzArchivePackageIndexSource$read$1(this, continuation);
        Object obj2 = remoteOriginalTzArchivePackageIndexSource$read$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = remoteOriginalTzArchivePackageIndexSource$read$1.label;
        if (i != 0) {
        }
        archiveByteRangeResult = (ArchiveByteRangeResult) obj2;
        if (archiveByteRangeResult instanceof ArchiveByteRangeResult.Success) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean read$lambda$0(RemoteZipEntry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.isDirectory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ArchiveEntryMetadata read$lambda$1(RemoteZipEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        return new ArchiveEntryMetadata(entry.getPath(), entry.getSize(), entry.getCrc32());
    }

    private final OriginalTzArchivePackageIndexResult.Failure toIndexFailure(ArchiveByteRangeResult.Failure failure) {
        ArchiveManifestResolutionErrorCode archiveManifestResolutionErrorCode;
        OriginalTzArchivePackageIndexResult.Failure indexFailure;
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
        indexFailure = ArchiveManifestResolverKt.indexFailure(archiveManifestResolutionErrorCode, CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) strArr), StringUtils.PROCESS_POSTFIX_DELIMITER, null, null, 0, null, null, 62, null));
        return indexFailure;
    }

    /* compiled from: ArchiveManifestResolver.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/RemoteOriginalTzArchivePackageIndexSource$Companion;", "", "<init>", "()V", "ZIP_EOCD_TAIL_BYTES", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
