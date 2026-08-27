package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.manifest.OriginalTzArchivePackageDescriptor;
import com.arizona.launcher.updater.archive.model.ArchiveEntryMetadata;
import com.arizona.launcher.updater.archive.model.ArchiveResolvedZipFileMetadata;
import com.arizona.launcher.updater.archive.model.ArchiveResolvedZipIndexMetadata;
import com.arizona.launcher.updater.archive.orchestrator.OriginalTzArchivePackageIndexResult;
import com.arizona.launcher.updater.archive.orchestrator.RemoteZipIndexFetchResult;
import com.arizona.launcher.updater.archive.range.RemoteZipEntry;
import com.arizona.launcher.updater.archive.range.RemoteZipIndexParser;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0013"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/RemoteOriginalTzArchivePackageIndexSource;", "Lcom/arizona/launcher/updater/archive/orchestrator/OriginalTzArchivePackageIndexSource;", "byteRangeSource", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeSource;", "parser", "Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexParser;", "allowInsecureLoopback", "", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeSource;Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexParser;Z)V", "fetcher", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipIndexFetcher;", "read", "Lcom/arizona/launcher/updater/archive/orchestrator/OriginalTzArchivePackageIndexResult;", "packageDescriptor", "Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchivePackageDescriptor;", "serverBaseUrl", "", "(Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchivePackageDescriptor;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RemoteOriginalTzArchivePackageIndexSource implements OriginalTzArchivePackageIndexSource {
    public static final int $stable = RemoteZipIndexFetcher.$stable;
    private final boolean allowInsecureLoopback;
    private final ArchiveByteRangeSource byteRangeSource;
    private final RemoteZipIndexFetcher fetcher;

    public RemoteOriginalTzArchivePackageIndexSource(ArchiveByteRangeSource byteRangeSource, RemoteZipIndexParser parser, boolean z) {
        Intrinsics.checkNotNullParameter(byteRangeSource, "byteRangeSource");
        Intrinsics.checkNotNullParameter(parser, "parser");
        this.byteRangeSource = byteRangeSource;
        this.allowInsecureLoopback = z;
        this.fetcher = new RemoteZipIndexFetcher(byteRangeSource, parser);
    }

    public /* synthetic */ RemoteOriginalTzArchivePackageIndexSource(ArchiveByteRangeSource archiveByteRangeSource, RemoteZipIndexParser remoteZipIndexParser, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(archiveByteRangeSource, (i & 2) != 0 ? new RemoteZipIndexParser(null, 1, null) : remoteZipIndexParser, (i & 4) != 0 ? false : z);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0178  */
    @Override // com.arizona.launcher.updater.archive.orchestrator.OriginalTzArchivePackageIndexSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object read(OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor, String str, Continuation<? super OriginalTzArchivePackageIndexResult> continuation) {
        RemoteOriginalTzArchivePackageIndexSource$read$1 remoteOriginalTzArchivePackageIndexSource$read$1;
        int i;
        String resolveArchiveUrl;
        OriginalTzArchivePackageIndexResult.Failure indexFailure;
        RemoteZipIndexFetchResult remoteZipIndexFetchResult;
        OriginalTzArchivePackageIndexResult.Failure indexFailure2;
        if (continuation instanceof RemoteOriginalTzArchivePackageIndexSource$read$1) {
            remoteOriginalTzArchivePackageIndexSource$read$1 = (RemoteOriginalTzArchivePackageIndexSource$read$1) continuation;
            if ((remoteOriginalTzArchivePackageIndexSource$read$1.label & Integer.MIN_VALUE) != 0) {
                remoteOriginalTzArchivePackageIndexSource$read$1.label -= Integer.MIN_VALUE;
                RemoteOriginalTzArchivePackageIndexSource$read$1 remoteOriginalTzArchivePackageIndexSource$read$12 = remoteOriginalTzArchivePackageIndexSource$read$1;
                Object obj = remoteOriginalTzArchivePackageIndexSource$read$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = remoteOriginalTzArchivePackageIndexSource$read$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    resolveArchiveUrl = ArchiveManifestResolverKt.resolveArchiveUrl(str, originalTzArchivePackageDescriptor.getUrl(), this.allowInsecureLoopback);
                    if (resolveArchiveUrl == null) {
                        indexFailure = ArchiveManifestResolverKt.indexFailure(ArchiveManifestResolutionErrorCode.REMOTE_INDEX_UNAVAILABLE, "unsafe or malformed archive URL");
                        return indexFailure;
                    }
                    RemoteZipIndexFetcher remoteZipIndexFetcher = this.fetcher;
                    String id = originalTzArchivePackageDescriptor.getId();
                    long archiveSize = originalTzArchivePackageDescriptor.getArchiveSize();
                    remoteOriginalTzArchivePackageIndexSource$read$12.L$0 = SpillingKt.nullOutSpilledVariable(originalTzArchivePackageDescriptor);
                    remoteOriginalTzArchivePackageIndexSource$read$12.L$1 = SpillingKt.nullOutSpilledVariable(str);
                    remoteOriginalTzArchivePackageIndexSource$read$12.L$2 = SpillingKt.nullOutSpilledVariable(resolveArchiveUrl);
                    remoteOriginalTzArchivePackageIndexSource$read$12.label = 1;
                    obj = remoteZipIndexFetcher.fetch(id, resolveArchiveUrl, archiveSize, remoteOriginalTzArchivePackageIndexSource$read$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    String str2 = (String) remoteOriginalTzArchivePackageIndexSource$read$12.L$2;
                    String str3 = (String) remoteOriginalTzArchivePackageIndexSource$read$12.L$1;
                    OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor2 = (OriginalTzArchivePackageDescriptor) remoteOriginalTzArchivePackageIndexSource$read$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                remoteZipIndexFetchResult = (RemoteZipIndexFetchResult) obj;
                if (!(remoteZipIndexFetchResult instanceof RemoteZipIndexFetchResult.Success)) {
                    RemoteZipIndexFetchResult.Success success = (RemoteZipIndexFetchResult.Success) remoteZipIndexFetchResult;
                    List<RemoteZipEntry> entries = success.getSession().getIndex().getEntries();
                    List list = SequencesKt.toList(SequencesKt.map(SequencesKt.filterNot(CollectionsKt.asSequence(entries), new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.RemoteOriginalTzArchivePackageIndexSource$$ExternalSyntheticLambda0
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
                    if (list.isEmpty() || success.getSession().getIndex().getTotalUncompressedBytes() <= 0) {
                        indexFailure2 = ArchiveManifestResolverKt.indexFailure(ArchiveManifestResolutionErrorCode.REMOTE_INDEX_INVALID, "ZIP contains no installable files");
                        return indexFailure2;
                    }
                    long totalUncompressedBytes = success.getSession().getIndex().getTotalUncompressedBytes();
                    String hex = success.getSession().getIndex().getCentralDirectorySha256().getHex();
                    ArchiveResolvedZipIndexMetadata archiveResolvedZipIndexMetadata = null;
                    if (success.getSession().getObservedFence() != null) {
                        try {
                            long fetchedBytes = ((RemoteZipIndexFetchResult.Success) remoteZipIndexFetchResult).getSession().getFetchedBytes();
                            long centralDirectoryOffset = ((RemoteZipIndexFetchResult.Success) remoteZipIndexFetchResult).getSession().getIndex().getCentralDirectoryOffset();
                            List<RemoteZipEntry> list2 = entries;
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                            for (RemoteZipEntry remoteZipEntry : list2) {
                                arrayList.add(Boxing.boxLong(remoteZipEntry.getLocalHeaderOffset()));
                            }
                            archiveResolvedZipIndexMetadata = new ArchiveResolvedZipIndexMetadata(fetchedBytes, centralDirectoryOffset, arrayList, SequencesKt.toList(SequencesKt.map(SequencesKt.filterNot(CollectionsKt.asSequence(entries), new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.RemoteOriginalTzArchivePackageIndexSource$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    boolean read$lambda$2$1;
                                    read$lambda$2$1 = RemoteOriginalTzArchivePackageIndexSource.read$lambda$2$1((RemoteZipEntry) obj2);
                                    return Boolean.valueOf(read$lambda$2$1);
                                }
                            }), new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.RemoteOriginalTzArchivePackageIndexSource$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    ArchiveResolvedZipFileMetadata read$lambda$2$2;
                                    read$lambda$2$2 = RemoteOriginalTzArchivePackageIndexSource.read$lambda$2$2((RemoteZipEntry) obj2);
                                    return read$lambda$2$2;
                                }
                            })));
                        } catch (CancellationException e) {
                            throw e;
                        } catch (Exception unused) {
                        }
                    }
                    return new OriginalTzArchivePackageIndexResult.Success(new OriginalTzArchivePackageIndex(list, totalUncompressedBytes, hex, archiveResolvedZipIndexMetadata));
                } else if (!(remoteZipIndexFetchResult instanceof RemoteZipIndexFetchResult.Failure)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    RemoteZipIndexFetchResult.Failure failure = (RemoteZipIndexFetchResult.Failure) remoteZipIndexFetchResult;
                    return new OriginalTzArchivePackageIndexResult.Failure(failure.getCode(), failure.getDetail());
                }
            }
        }
        remoteOriginalTzArchivePackageIndexSource$read$1 = new RemoteOriginalTzArchivePackageIndexSource$read$1(this, continuation);
        RemoteOriginalTzArchivePackageIndexSource$read$1 remoteOriginalTzArchivePackageIndexSource$read$122 = remoteOriginalTzArchivePackageIndexSource$read$1;
        Object obj2 = remoteOriginalTzArchivePackageIndexSource$read$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = remoteOriginalTzArchivePackageIndexSource$read$122.label;
        if (i != 0) {
        }
        remoteZipIndexFetchResult = (RemoteZipIndexFetchResult) obj2;
        if (!(remoteZipIndexFetchResult instanceof RemoteZipIndexFetchResult.Success)) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean read$lambda$2$1(RemoteZipEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        return entry.isDirectory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArchiveResolvedZipFileMetadata read$lambda$2$2(RemoteZipEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        return new ArchiveResolvedZipFileMetadata(entry.getPath(), entry.getSize(), entry.getCrc32(), entry.getCompressedSize(), entry.getLocalHeaderOffset());
    }
}
