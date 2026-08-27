package com.arizona.launcher.updater.archive.orchestrator;

import android.content.Context;
import com.arizona.launcher.DownloadRetryConfig;
import com.arizona.launcher.DownloadRetryPolicy;
import com.arizona.launcher.updater.archive.download.AndroidArchiveNetworkMonitor;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestDescriptor;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchivePackageDescriptor;
import com.arizona.launcher.updater.archive.model.ArchiveEntryMetadata;
import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import com.arizona.launcher.updater.archive.model.ArchivePackage;
import com.arizona.launcher.updater.archive.model.ArchivePackageType;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveManifestCandidate;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveManifestResolutionResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveRangeRetryListener;
import com.arizona.launcher.updater.archive.orchestrator.OriginalTzArchivePackageIndexResult;
import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import com.arizona.launcher.updater.archive.state.ArchivePackageJournalEntry;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u000eJ(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0082@¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\rH\u0002J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001b"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolver;", "", "packageIndexSource", "Lcom/arizona/launcher/updater/archive/orchestrator/OriginalTzArchivePackageIndexSource;", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/OriginalTzArchivePackageIndexSource;)V", "resolve", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolutionResult;", "candidate", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidate;", "serverBaseUrl", "", "loadedState", "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidate;Ljava/lang/String;Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveOriginalTz", "descriptor", "Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchiveManifestDescriptor;", "(Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchiveManifestDescriptor;Ljava/lang/String;Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reusableIndex", "Lcom/arizona/launcher/updater/archive/orchestrator/OriginalTzArchivePackageIndex;", "Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchivePackageDescriptor;", RemoteConfigConstants.ResponseFieldKey.STATE, "toPackageIndexOrNull", "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveManifestResolver {
    private final OriginalTzArchivePackageIndexSource packageIndexSource;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ArchiveManifestResolver() {
        this(null, 1, null);
    }

    public ArchiveManifestResolver(OriginalTzArchivePackageIndexSource packageIndexSource) {
        Intrinsics.checkNotNullParameter(packageIndexSource, "packageIndexSource");
        this.packageIndexSource = packageIndexSource;
    }

    public /* synthetic */ ArchiveManifestResolver(AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new OriginalTzArchivePackageIndexSource() { // from class: com.arizona.launcher.updater.archive.orchestrator.ArchiveManifestResolver.1
            @Override // com.arizona.launcher.updater.archive.orchestrator.OriginalTzArchivePackageIndexSource
            public final Object read(OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor, String str, Continuation<? super OriginalTzArchivePackageIndexResult> continuation) {
                return new OriginalTzArchivePackageIndexResult.Failure(ArchiveManifestResolutionErrorCode.REMOTE_INDEX_UNAVAILABLE, "original-TZ package index source is not configured");
            }
        } : anonymousClass1);
    }

    public final Object resolve(ArchiveManifestCandidate archiveManifestCandidate, String str, ArchiveUpdaterState archiveUpdaterState, Continuation<? super ArchiveManifestResolutionResult> continuation) {
        if (archiveManifestCandidate instanceof ArchiveManifestCandidate.Resolved) {
            return new ArchiveManifestResolutionResult.Success(((ArchiveManifestCandidate.Resolved) archiveManifestCandidate).getManifest());
        }
        if (!(archiveManifestCandidate instanceof ArchiveManifestCandidate.OriginalTz)) {
            throw new NoWhenBranchMatchedException();
        }
        return resolveOriginalTz(((ArchiveManifestCandidate.OriginalTz) archiveManifestCandidate).getDescriptor(), str, archiveUpdaterState, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0134 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0084 -> B:43:0x00cc). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00a4 -> B:24:0x00b2). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveOriginalTz(OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor, String str, ArchiveUpdaterState archiveUpdaterState, Continuation<? super ArchiveManifestResolutionResult> continuation) {
        ArchiveManifestResolver$resolveOriginalTz$1 archiveManifestResolver$resolveOriginalTz$1;
        int i;
        ArrayList arrayList;
        ArchiveManifestResolver$resolveOriginalTz$1 archiveManifestResolver$resolveOriginalTz$12;
        Iterator<OriginalTzArchivePackageDescriptor> it;
        OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor2;
        String str2;
        ArchiveUpdaterState archiveUpdaterState2;
        if (continuation instanceof ArchiveManifestResolver$resolveOriginalTz$1) {
            archiveManifestResolver$resolveOriginalTz$1 = (ArchiveManifestResolver$resolveOriginalTz$1) continuation;
            if ((archiveManifestResolver$resolveOriginalTz$1.label & Integer.MIN_VALUE) != 0) {
                archiveManifestResolver$resolveOriginalTz$1.label -= Integer.MIN_VALUE;
                Object obj = archiveManifestResolver$resolveOriginalTz$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = archiveManifestResolver$resolveOriginalTz$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    arrayList = new ArrayList(originalTzArchiveManifestDescriptor.getPackages().size());
                    archiveManifestResolver$resolveOriginalTz$12 = archiveManifestResolver$resolveOriginalTz$1;
                    it = originalTzArchiveManifestDescriptor.getPackages().iterator();
                    originalTzArchiveManifestDescriptor2 = originalTzArchiveManifestDescriptor;
                    str2 = str;
                    archiveUpdaterState2 = archiveUpdaterState;
                    if (it.hasNext()) {
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    OriginalTzArchivePackageIndex originalTzArchivePackageIndex = (OriginalTzArchivePackageIndex) archiveManifestResolver$resolveOriginalTz$1.L$6;
                    OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor = (OriginalTzArchivePackageDescriptor) archiveManifestResolver$resolveOriginalTz$1.L$5;
                    Iterator<OriginalTzArchivePackageDescriptor> it2 = (Iterator) archiveManifestResolver$resolveOriginalTz$1.L$4;
                    ArrayList arrayList2 = (ArrayList) archiveManifestResolver$resolveOriginalTz$1.L$3;
                    ArchiveUpdaterState archiveUpdaterState3 = (ArchiveUpdaterState) archiveManifestResolver$resolveOriginalTz$1.L$2;
                    String str3 = (String) archiveManifestResolver$resolveOriginalTz$1.L$1;
                    OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor3 = (OriginalTzArchiveManifestDescriptor) archiveManifestResolver$resolveOriginalTz$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    OriginalTzArchivePackageIndexResult originalTzArchivePackageIndexResult = (OriginalTzArchivePackageIndexResult) obj;
                    if (!(originalTzArchivePackageIndexResult instanceof OriginalTzArchivePackageIndexResult.Success)) {
                        OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor4 = originalTzArchiveManifestDescriptor3;
                        OriginalTzArchivePackageIndex reusableIndex = ((OriginalTzArchivePackageIndexResult.Success) originalTzArchivePackageIndexResult).getIndex();
                        originalTzArchiveManifestDescriptor2 = originalTzArchiveManifestDescriptor4;
                        Iterator<OriginalTzArchivePackageDescriptor> it3 = it2;
                        archiveManifestResolver$resolveOriginalTz$12 = archiveManifestResolver$resolveOriginalTz$1;
                        str2 = str3;
                        OriginalTzArchivePackageDescriptor next = originalTzArchivePackageDescriptor;
                        archiveUpdaterState2 = archiveUpdaterState3;
                        arrayList = arrayList2;
                        it = it3;
                        try {
                            arrayList.add(new ArchivePackage(next.getId(), ArchivePackageType.ARCHIVE, next.getUrl(), next.getArchiveSize(), reusableIndex.getInstalledSize(), next.getCrc32(), reusableIndex.getEntries(), false, next.getCentralDirectorySha256(), reusableIndex.getCentralDirectorySha256(), reusableIndex.getResolvedZipIndexMetadata(), 128, null));
                            if (it.hasNext()) {
                                next = it.next();
                                reusableIndex = reusableIndex(next, archiveUpdaterState2);
                                if (reusableIndex == null) {
                                    OriginalTzArchivePackageIndexSource originalTzArchivePackageIndexSource = this.packageIndexSource;
                                    archiveManifestResolver$resolveOriginalTz$12.L$0 = originalTzArchiveManifestDescriptor2;
                                    archiveManifestResolver$resolveOriginalTz$12.L$1 = str2;
                                    archiveManifestResolver$resolveOriginalTz$12.L$2 = archiveUpdaterState2;
                                    archiveManifestResolver$resolveOriginalTz$12.L$3 = arrayList;
                                    archiveManifestResolver$resolveOriginalTz$12.L$4 = it;
                                    archiveManifestResolver$resolveOriginalTz$12.L$5 = next;
                                    archiveManifestResolver$resolveOriginalTz$12.L$6 = SpillingKt.nullOutSpilledVariable(reusableIndex);
                                    archiveManifestResolver$resolveOriginalTz$12.label = 1;
                                    Object read = originalTzArchivePackageIndexSource.read(next, str2, archiveManifestResolver$resolveOriginalTz$12);
                                    if (read == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    originalTzArchiveManifestDescriptor3 = originalTzArchiveManifestDescriptor2;
                                    obj = read;
                                    str3 = str2;
                                    archiveManifestResolver$resolveOriginalTz$1 = archiveManifestResolver$resolveOriginalTz$12;
                                    it2 = it;
                                    arrayList2 = arrayList;
                                    archiveUpdaterState3 = archiveUpdaterState2;
                                    originalTzArchivePackageDescriptor = next;
                                    OriginalTzArchivePackageIndexResult originalTzArchivePackageIndexResult2 = (OriginalTzArchivePackageIndexResult) obj;
                                    if (!(originalTzArchivePackageIndexResult2 instanceof OriginalTzArchivePackageIndexResult.Success)) {
                                        if (!(originalTzArchivePackageIndexResult2 instanceof OriginalTzArchivePackageIndexResult.Failure)) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        OriginalTzArchivePackageIndexResult.Failure failure = (OriginalTzArchivePackageIndexResult.Failure) originalTzArchivePackageIndexResult2;
                                        return new ArchiveManifestResolutionResult.Failure(failure.getCode(), originalTzArchivePackageDescriptor.getId(), failure.getDetail());
                                    }
                                }
                                arrayList.add(new ArchivePackage(next.getId(), ArchivePackageType.ARCHIVE, next.getUrl(), next.getArchiveSize(), reusableIndex.getInstalledSize(), next.getCrc32(), reusableIndex.getEntries(), false, next.getCentralDirectorySha256(), reusableIndex.getCentralDirectorySha256(), reusableIndex.getResolvedZipIndexMetadata(), 128, null));
                                if (it.hasNext()) {
                                }
                            } else {
                                try {
                                    return new ArchiveManifestResolutionResult.Success(new ArchiveManifest(2, originalTzArchiveManifestDescriptor2.getManifestVersion(), originalTzArchiveManifestDescriptor2.getSelectedGpu(), arrayList));
                                } catch (IllegalArgumentException e) {
                                    return new ArchiveManifestResolutionResult.Failure(ArchiveManifestResolutionErrorCode.PACKAGE_METADATA_INVALID, null, e.getMessage(), 2, null);
                                }
                            }
                        } catch (IllegalArgumentException e2) {
                            return new ArchiveManifestResolutionResult.Failure(ArchiveManifestResolutionErrorCode.PACKAGE_METADATA_INVALID, next.getId(), e2.getMessage());
                        }
                    }
                }
            }
        }
        archiveManifestResolver$resolveOriginalTz$1 = new ArchiveManifestResolver$resolveOriginalTz$1(this, continuation);
        Object obj2 = archiveManifestResolver$resolveOriginalTz$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = archiveManifestResolver$resolveOriginalTz$1.label;
        if (i != 0) {
        }
    }

    private final OriginalTzArchivePackageIndex reusableIndex(OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor, ArchiveUpdaterState archiveUpdaterState) {
        ArchivePackageJournalEntry packageById;
        if (archiveUpdaterState == null || (packageById = archiveUpdaterState.packageById(originalTzArchivePackageDescriptor.getId())) == null || packageById.getArchiveSize() != originalTzArchivePackageDescriptor.getArchiveSize() || packageById.getArchiveCrc32() != originalTzArchivePackageDescriptor.getCrc32() || !packageById.isReady() || packageById.getFiles().isEmpty()) {
            return null;
        }
        return toPackageIndexOrNull(packageById.getFiles());
    }

    private final OriginalTzArchivePackageIndex toPackageIndexOrNull(List<ArchivePackageFileRecord> list) {
        try {
            List<ArchivePackageFileRecord> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            long j = 0;
            for (ArchivePackageFileRecord archivePackageFileRecord : list2) {
                j = Math.addExact(j, archivePackageFileRecord.getSize());
                arrayList.add(new ArchiveEntryMetadata("files/" + archivePackageFileRecord.getRelativePath(), archivePackageFileRecord.getSize(), archivePackageFileRecord.getCrc32()));
            }
            ArrayList arrayList2 = arrayList;
            if (j > 0 && !arrayList2.isEmpty()) {
                return new OriginalTzArchivePackageIndex(arrayList2, j, null, null, 12, null);
            }
        } catch (ArithmeticException | IllegalArgumentException unused) {
        }
        return null;
    }

    /* compiled from: ArchiveManifestResolver.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolver$Companion;", "", "<init>", "()V", "create", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolver;", "context", "Landroid/content/Context;", "retryEnabled", "", "retryListener", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRangeRetryListener;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ArchiveManifestResolver create$default(Companion companion, Context context, boolean z, ArchiveRangeRetryListener archiveRangeRetryListener, int i, Object obj) {
            if ((i & 4) != 0) {
                archiveRangeRetryListener = ArchiveRangeRetryListener.None.INSTANCE;
            }
            return companion.create(context, z, archiveRangeRetryListener);
        }

        public final ArchiveManifestResolver create(Context context, boolean z, ArchiveRangeRetryListener retryListener) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(retryListener, "retryListener");
            return new ArchiveManifestResolver(new RemoteOriginalTzArchivePackageIndexSource(new OkHttpArchiveByteRangeSource(new DownloadRetryPolicy(new DownloadRetryConfig(z, 0, 0L, 0L, 14, null), null, 2, null), new AndroidArchiveNetworkMonitor(context), retryListener, null, false, 24, null), null, false, 2, null));
        }
    }
}
