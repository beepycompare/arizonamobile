package com.arizona.launcher.updater.archive.orchestrator;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import coil3.disk.DiskLruCache;
import com.arizona.launcher.UpdateServiceContract;
import com.arizona.launcher.updater.archive.install.WholeFileCrc32Verifier;
import com.arizona.launcher.updater.archive.install.WholeFileVerificationResult;
import com.arizona.launcher.updater.archive.io.ArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.io.ArchiveLivePathSafety;
import com.arizona.launcher.updater.archive.io.ArchiveStorageFailureClassifier;
import com.arizona.launcher.updater.archive.io.JvmArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.model.ArchiveEntryMetadata;
import com.arizona.launcher.updater.archive.model.ArchivePackage;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveSelectiveInstallResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveSelectiveProbeResult;
import com.arizona.launcher.updater.archive.orchestrator.RemoteZipEntryPreparationResult;
import com.arizona.launcher.updater.archive.orchestrator.RemoteZipEntryReadResult;
import com.arizona.launcher.updater.archive.orchestrator.RemoteZipIndexFetchResult;
import com.arizona.launcher.updater.archive.range.ArchiveDeltaEligibility;
import com.arizona.launcher.updater.archive.range.ArchiveEntryChangePlan;
import com.arizona.launcher.updater.archive.range.ArchiveObservedRepresentationFence;
import com.arizona.launcher.updater.archive.range.ArchiveRepresentationFencePolicy;
import com.arizona.launcher.updater.archive.range.ArchiveSelectiveEntryDiff;
import com.arizona.launcher.updater.archive.range.ArchiveSelectiveUpdatePolicy;
import com.arizona.launcher.updater.archive.range.RemoteZipEntry;
import com.arizona.launcher.updater.archive.range.StrongEtag;
import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import com.arizona.launcher.updater.archive.state.ArchivePackageJournalEntry;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.zip.CRC32;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
/* compiled from: ArchiveSelectivePackageInstaller.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 22\u00020\u0001:\u00012Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00128\u0010\f\u001a4\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r¢\u0006\u0004\b\u0013\u0010\u0014J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u001cJ:\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00032\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#H\u0086@¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u001a\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010)\u001a\u00020*2\u0006\u0010!\u001a\u00020\u0003H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010\u00032\u0006\u0010)\u001a\u00020*H\u0002J\u0018\u0010-\u001a\u00020(2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0003H\u0002J\u0018\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020$H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\f\u001a4\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b4\u0012\b\b5\u0012\u0004\b\u0003\u0010\u0000¨\u00063"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectivePackageInstaller;", "", "gameRoot", "Ljava/io/File;", "indexFetcher", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipIndexFetcher;", "entryReader", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryRangeReader;", "pathSafety", "Lcom/arizona/launcher/updater/archive/io/ArchiveLivePathSafety;", "directoryCreator", "Lcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;", "resolvePackageUrl", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "baseUrl", "packageUrl", "<init>", "(Ljava/io/File;Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipIndexFetcher;Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryRangeReader;Lcom/arizona/launcher/updater/archive/io/ArchiveLivePathSafety;Lcom/arizona/launcher/updater/archive/io/ArchiveDirectoryCreator;Lkotlin/jvm/functions/Function2;)V", "probe", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveProbeResult;", "archivePackage", "Lcom/arizona/launcher/updater/archive/model/ArchivePackage;", DiskLruCache.JOURNAL_FILE, "Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;", "serverBaseUrl", "(Lcom/arizona/launcher/updater/archive/model/ArchivePackage;Lcom/arizona/launcher/updater/archive/state/ArchivePackageJournalEntry;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "install", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveInstallResult;", "session", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveInstallSession;", "stagingRoot", "onNetworkProgress", "Lkotlin/Function1;", "", "", "(Lcom/arizona/launcher/updater/archive/model/ArchivePackage;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveInstallSession;Ljava/io/File;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "liveFileMatches", "", "record", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;", "copyLiveFile", "validatedLiveSource", "containedTarget", TypedValues.AttributesType.S_TARGET, "addFetched", UpdateServiceContract.BundleKey.CURRENT, "extra", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveSelectivePackageInstaller {
    @Deprecated
    public static final int BUFFER_SIZE = 65536;
    private final ArchiveDirectoryCreator directoryCreator;
    private final RemoteZipEntryRangeReader entryReader;
    private final File gameRoot;
    private final RemoteZipIndexFetcher indexFetcher;
    private final ArchiveLivePathSafety pathSafety;
    private final Function2<String, String, String> resolvePackageUrl;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: ArchiveSelectivePackageInstaller.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RemoteZipEntryReadErrorCode.values().length];
            try {
                iArr[RemoteZipEntryReadErrorCode.NO_SPACE_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RemoteZipEntryReadErrorCode.REPRESENTATION_CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArchiveSelectivePackageInstaller(File gameRoot, RemoteZipIndexFetcher indexFetcher, RemoteZipEntryRangeReader entryReader, ArchiveLivePathSafety pathSafety, ArchiveDirectoryCreator directoryCreator, Function2<? super String, ? super String, String> resolvePackageUrl) {
        Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
        Intrinsics.checkNotNullParameter(indexFetcher, "indexFetcher");
        Intrinsics.checkNotNullParameter(entryReader, "entryReader");
        Intrinsics.checkNotNullParameter(pathSafety, "pathSafety");
        Intrinsics.checkNotNullParameter(directoryCreator, "directoryCreator");
        Intrinsics.checkNotNullParameter(resolvePackageUrl, "resolvePackageUrl");
        this.gameRoot = gameRoot;
        this.indexFetcher = indexFetcher;
        this.entryReader = entryReader;
        this.pathSafety = pathSafety;
        this.directoryCreator = directoryCreator;
        this.resolvePackageUrl = resolvePackageUrl;
    }

    public /* synthetic */ ArchiveSelectivePackageInstaller(File file, RemoteZipIndexFetcher remoteZipIndexFetcher, RemoteZipEntryRangeReader remoteZipEntryRangeReader, ArchiveLivePathSafety archiveLivePathSafety, JvmArchiveDirectoryCreator jvmArchiveDirectoryCreator, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, remoteZipIndexFetcher, remoteZipEntryRangeReader, archiveLivePathSafety, (i & 16) != 0 ? JvmArchiveDirectoryCreator.INSTANCE : jvmArchiveDirectoryCreator, function2);
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x050a  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02ad A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0371  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:104:0x042d -> B:13:0x00b7). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object probe(ArchivePackage archivePackage, ArchivePackageJournalEntry archivePackageJournalEntry, String str, Continuation<? super ArchiveSelectiveProbeResult> continuation) {
        ArchiveSelectivePackageInstaller$probe$1 archiveSelectivePackageInstaller$probe$1;
        int i;
        char c;
        String str2;
        ArchivePackage archivePackage2;
        ArchivePackageJournalEntry archivePackageJournalEntry2;
        List<ArchivePackageFileRecord> list;
        Object obj;
        String str3;
        ArchiveEntryChangePlan archiveEntryChangePlan;
        RemoteZipIndexFetchResult remoteZipIndexFetchResult;
        RemoteZipIndexSession remoteZipIndexSession;
        ArchiveEntryChangePlan archiveEntryChangePlan2;
        ArchiveObservedRepresentationFence archiveObservedRepresentationFence;
        ArchivePackageJournalEntry archivePackageJournalEntry3;
        ArrayList arrayList;
        long j;
        List list2;
        ArchivePackage archivePackage3;
        ArchiveSelectivePackageInstaller$probe$1 archiveSelectivePackageInstaller$probe$12;
        Iterator it;
        CharSequence charSequence;
        LinkedHashMap linkedHashMap;
        RemoteZipEntryRangeSession remoteZipEntryRangeSession;
        ArrayList arrayList2;
        String str4;
        RemoteZipIndexSession remoteZipIndexSession2;
        List<ArchivePackageFileRecord> list3;
        ArchiveDeltaEligibility archiveDeltaEligibility;
        ArrayList arrayList3;
        long j2;
        ArrayList arrayList4;
        RemoteZipEntry remoteZipEntry;
        Object obj2;
        ArchiveSelectivePackageInstaller archiveSelectivePackageInstaller = this;
        if (continuation instanceof ArchiveSelectivePackageInstaller$probe$1) {
            archiveSelectivePackageInstaller$probe$1 = (ArchiveSelectivePackageInstaller$probe$1) continuation;
            if ((archiveSelectivePackageInstaller$probe$1.label & Integer.MIN_VALUE) != 0) {
                archiveSelectivePackageInstaller$probe$1.label -= Integer.MIN_VALUE;
                ArchiveSelectivePackageInstaller$probe$1 archiveSelectivePackageInstaller$probe$13 = archiveSelectivePackageInstaller$probe$1;
                Object obj3 = archiveSelectivePackageInstaller$probe$13.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = archiveSelectivePackageInstaller$probe$13.label;
                String str5 = "selective byte estimate overflow";
                if (i != 0) {
                    c = 0;
                    ResultKt.throwOnFailure(obj3);
                    List<ArchivePackageFileRecord> desiredFiles = archivePackageJournalEntry.getDesiredFiles();
                    if (desiredFiles.isEmpty()) {
                        return new ArchiveSelectiveProbeResult.Fallback("desired files missing");
                    }
                    ArchiveEntryChangePlan plan = ArchiveSelectiveEntryDiff.INSTANCE.plan(archivePackageJournalEntry.getPreviousFiles(), desiredFiles);
                    if (plan.getReusable().isEmpty() || plan.getToFetch().isEmpty()) {
                        return new ArchiveSelectiveProbeResult.Fallback("selective work is empty or complete");
                    }
                    str2 = str;
                    String invoke = archiveSelectivePackageInstaller.resolvePackageUrl.invoke(str2, archivePackage.getUrl());
                    if (invoke == null) {
                        return new ArchiveSelectiveProbeResult.Fallback("package URL is invalid");
                    }
                    RemoteZipIndexFetcher remoteZipIndexFetcher = archiveSelectivePackageInstaller.indexFetcher;
                    String id = archivePackage.getId();
                    long archiveSize = archivePackage.getArchiveSize();
                    archivePackage2 = archivePackage;
                    archiveSelectivePackageInstaller$probe$13.L$0 = archivePackage2;
                    archiveSelectivePackageInstaller$probe$13.L$1 = SpillingKt.nullOutSpilledVariable(archivePackageJournalEntry);
                    archiveSelectivePackageInstaller$probe$13.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                    archiveSelectivePackageInstaller$probe$13.L$3 = desiredFiles;
                    archiveSelectivePackageInstaller$probe$13.L$4 = plan;
                    archiveSelectivePackageInstaller$probe$13.L$5 = invoke;
                    archiveSelectivePackageInstaller$probe$13.label = 1;
                    Object fetch = remoteZipIndexFetcher.fetch(id, invoke, archiveSize, archiveSelectivePackageInstaller$probe$13);
                    if (fetch != coroutine_suspended) {
                        archivePackageJournalEntry2 = archivePackageJournalEntry;
                        list = desiredFiles;
                        obj = fetch;
                        str3 = invoke;
                        archiveEntryChangePlan = plan;
                    }
                    return coroutine_suspended;
                } else if (i == 1) {
                    c = 0;
                    archiveEntryChangePlan = (ArchiveEntryChangePlan) archiveSelectivePackageInstaller$probe$13.L$4;
                    list = (List) archiveSelectivePackageInstaller$probe$13.L$3;
                    archivePackageJournalEntry2 = (ArchivePackageJournalEntry) archiveSelectivePackageInstaller$probe$13.L$1;
                    ResultKt.throwOnFailure(obj3);
                    str3 = (String) archiveSelectivePackageInstaller$probe$13.L$5;
                    str2 = (String) archiveSelectivePackageInstaller$probe$13.L$2;
                    archivePackage2 = (ArchivePackage) archiveSelectivePackageInstaller$probe$13.L$0;
                    obj = obj3;
                } else if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    long j3 = archiveSelectivePackageInstaller$probe$13.J$2;
                    long j4 = archiveSelectivePackageInstaller$probe$13.J$1;
                    long j5 = archiveSelectivePackageInstaller$probe$13.J$0;
                    RemoteZipEntry remoteZipEntry2 = (RemoteZipEntry) archiveSelectivePackageInstaller$probe$13.L$17;
                    c = 0;
                    ArrayList arrayList5 = (ArrayList) archiveSelectivePackageInstaller$probe$13.L$10;
                    LinkedHashMap linkedHashMap2 = (LinkedHashMap) archiveSelectivePackageInstaller$probe$13.L$9;
                    archiveDeltaEligibility = (ArchiveDeltaEligibility) archiveSelectivePackageInstaller$probe$13.L$8;
                    ArchiveObservedRepresentationFence archiveObservedRepresentationFence2 = (ArchiveObservedRepresentationFence) archiveSelectivePackageInstaller$probe$13.L$7;
                    RemoteZipIndexSession remoteZipIndexSession3 = (RemoteZipIndexSession) archiveSelectivePackageInstaller$probe$13.L$6;
                    String str6 = (String) archiveSelectivePackageInstaller$probe$13.L$5;
                    ArchiveEntryChangePlan archiveEntryChangePlan3 = (ArchiveEntryChangePlan) archiveSelectivePackageInstaller$probe$13.L$4;
                    List<ArchivePackageFileRecord> list4 = (List) archiveSelectivePackageInstaller$probe$13.L$3;
                    String str7 = (String) archiveSelectivePackageInstaller$probe$13.L$2;
                    ArchivePackageJournalEntry archivePackageJournalEntry4 = (ArchivePackageJournalEntry) archiveSelectivePackageInstaller$probe$13.L$1;
                    ResultKt.throwOnFailure(obj3);
                    linkedHashMap = linkedHashMap2;
                    ArchivePackage archivePackage4 = (ArchivePackage) archiveSelectivePackageInstaller$probe$13.L$0;
                    String str8 = "selective byte estimate overflow";
                    arrayList = (ArrayList) archiveSelectivePackageInstaller$probe$13.L$11;
                    Object prepare = obj3;
                    archiveObservedRepresentationFence = archiveObservedRepresentationFence2;
                    archivePackageJournalEntry3 = archivePackageJournalEntry4;
                    ArchivePackageFileRecord archivePackageFileRecord = (ArchivePackageFileRecord) archiveSelectivePackageInstaller$probe$13.L$16;
                    archiveSelectivePackageInstaller$probe$12 = archiveSelectivePackageInstaller$probe$13;
                    charSequence = StringUtils.PROCESS_POSTFIX_DELIMITER;
                    list2 = (List) archiveSelectivePackageInstaller$probe$13.L$13;
                    remoteZipEntryRangeSession = (RemoteZipEntryRangeSession) archiveSelectivePackageInstaller$probe$13.L$12;
                    arrayList2 = (ArrayList) archiveSelectivePackageInstaller$probe$13.L$14;
                    str2 = str7;
                    ArrayList arrayList6 = arrayList5;
                    it = (Iterator) archiveSelectivePackageInstaller$probe$13.L$15;
                    ArchiveDeltaEligibility archiveDeltaEligibility2 = archiveDeltaEligibility;
                    RemoteZipEntryPreparationResult remoteZipEntryPreparationResult = (RemoteZipEntryPreparationResult) prepare;
                    if (!(remoteZipEntryPreparationResult instanceof RemoteZipEntryPreparationResult.Success)) {
                        RemoteZipEntryPreparationResult.Success success = (RemoteZipEntryPreparationResult.Success) remoteZipEntryPreparationResult;
                        try {
                            long addExact = Math.addExact(j5, success.getFetchedBytes());
                            j = Math.addExact(j4, success.getPrepared().getPayloadLength());
                            arrayList2.add(new ArchiveSelectiveEntryTransfer(archivePackageFileRecord, success.getPrepared()));
                            arrayList3 = arrayList6;
                            j2 = addExact;
                            archiveDeltaEligibility = archiveDeltaEligibility2;
                            remoteZipIndexSession2 = remoteZipIndexSession3;
                            str4 = str6;
                            archiveEntryChangePlan2 = archiveEntryChangePlan3;
                            list3 = list4;
                            str5 = str8;
                            archivePackage3 = archivePackage4;
                            archiveSelectivePackageInstaller = this;
                            if (it.hasNext()) {
                                ArchivePackage archivePackage5 = archivePackage3;
                                String str9 = str5;
                                try {
                                    long addExact2 = Math.addExact(j2, j);
                                    if (addExact2 >= archivePackage5.getArchiveSize()) {
                                        return new ArchiveSelectiveProbeResult.Fallback("selective transfer is not smaller than the ZIP");
                                    }
                                    return new ArchiveSelectiveProbeResult.Ready(new ArchiveSelectiveInstallSession(str4, remoteZipIndexSession2, arrayList3, arrayList2, j2, addExact2));
                                } catch (ArithmeticException unused) {
                                    return new ArchiveSelectiveProbeResult.Fallback(str9);
                                }
                            }
                            String str10 = str2;
                            Object next = it.next();
                            str8 = str5;
                            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                            Pair pair = (Pair) next;
                            archivePackageFileRecord = (ArchivePackageFileRecord) pair.component1();
                            RemoteZipEntry remoteZipEntry3 = (RemoteZipEntry) pair.component2();
                            Iterator it2 = list2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    obj2 = null;
                                    break;
                                }
                                obj2 = it2.next();
                                if (((Number) obj2).longValue() > remoteZipEntry3.getLocalHeaderOffset()) {
                                    break;
                                }
                            }
                            Long l = (Long) obj2;
                            long longValue = l != null ? l.longValue() : remoteZipIndexSession2.getIndex().getCentralDirectoryOffset();
                            RemoteZipEntryRangeReader remoteZipEntryRangeReader = archiveSelectivePackageInstaller.entryReader;
                            archiveSelectivePackageInstaller$probe$12.L$0 = archivePackage3;
                            archiveSelectivePackageInstaller$probe$12.L$1 = SpillingKt.nullOutSpilledVariable(archivePackageJournalEntry3);
                            archiveSelectivePackageInstaller$probe$12.L$2 = SpillingKt.nullOutSpilledVariable(str10);
                            archiveSelectivePackageInstaller$probe$12.L$3 = SpillingKt.nullOutSpilledVariable(list3);
                            archiveSelectivePackageInstaller$probe$12.L$4 = SpillingKt.nullOutSpilledVariable(archiveEntryChangePlan2);
                            archiveSelectivePackageInstaller$probe$12.L$5 = str4;
                            archiveSelectivePackageInstaller$probe$12.L$6 = remoteZipIndexSession2;
                            archiveSelectivePackageInstaller$probe$12.L$7 = SpillingKt.nullOutSpilledVariable(archiveObservedRepresentationFence);
                            archiveSelectivePackageInstaller$probe$12.L$8 = SpillingKt.nullOutSpilledVariable(archiveDeltaEligibility);
                            archiveSelectivePackageInstaller$probe$12.L$9 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                            archiveSelectivePackageInstaller$probe$12.L$10 = arrayList3;
                            archiveSelectivePackageInstaller$probe$12.L$11 = SpillingKt.nullOutSpilledVariable(arrayList);
                            archiveSelectivePackageInstaller$probe$12.L$12 = remoteZipEntryRangeSession;
                            archiveSelectivePackageInstaller$probe$12.L$13 = list2;
                            archiveSelectivePackageInstaller$probe$12.L$14 = arrayList2;
                            archiveSelectivePackageInstaller$probe$12.L$15 = it;
                            archiveSelectivePackageInstaller$probe$12.L$16 = archivePackageFileRecord;
                            archiveSelectivePackageInstaller$probe$12.L$17 = SpillingKt.nullOutSpilledVariable(remoteZipEntry3);
                            archiveSelectivePackageInstaller$probe$12.J$0 = j2;
                            archiveSelectivePackageInstaller$probe$12.J$1 = j;
                            archivePackage4 = archivePackage3;
                            archiveSelectivePackageInstaller$probe$12.J$2 = longValue;
                            archiveSelectivePackageInstaller$probe$12.label = 2;
                            RemoteZipEntryRangeSession remoteZipEntryRangeSession2 = remoteZipEntryRangeSession;
                            ArchiveSelectivePackageInstaller$probe$1 archiveSelectivePackageInstaller$probe$14 = archiveSelectivePackageInstaller$probe$12;
                            prepare = remoteZipEntryRangeReader.prepare(remoteZipEntryRangeSession2, remoteZipEntry3, longValue, archiveSelectivePackageInstaller$probe$14);
                            if (prepare != coroutine_suspended) {
                                arrayList6 = arrayList3;
                                j5 = j2;
                                archiveEntryChangePlan3 = archiveEntryChangePlan2;
                                str6 = str4;
                                remoteZipIndexSession3 = remoteZipIndexSession2;
                                j4 = j;
                                remoteZipEntryRangeSession = remoteZipEntryRangeSession2;
                                archiveSelectivePackageInstaller$probe$12 = archiveSelectivePackageInstaller$probe$14;
                                str2 = str10;
                                list4 = list3;
                                ArchiveDeltaEligibility archiveDeltaEligibility22 = archiveDeltaEligibility;
                                RemoteZipEntryPreparationResult remoteZipEntryPreparationResult2 = (RemoteZipEntryPreparationResult) prepare;
                                if (!(remoteZipEntryPreparationResult2 instanceof RemoteZipEntryPreparationResult.Success)) {
                                    if (!(remoteZipEntryPreparationResult2 instanceof RemoteZipEntryPreparationResult.Failure)) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    String[] strArr = new String[2];
                                    RemoteZipEntryPreparationResult.Failure failure = (RemoteZipEntryPreparationResult.Failure) remoteZipEntryPreparationResult2;
                                    strArr[c] = failure.getCode().name();
                                    strArr[1] = failure.getDetail();
                                    return new ArchiveSelectiveProbeResult.Fallback(CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) strArr), charSequence, null, null, 0, null, null, 62, null));
                                }
                            }
                            return coroutine_suspended;
                        } catch (ArithmeticException unused2) {
                            return new ArchiveSelectiveProbeResult.Fallback(str8);
                        }
                    }
                }
                remoteZipIndexFetchResult = (RemoteZipIndexFetchResult) obj;
                if (remoteZipIndexFetchResult instanceof RemoteZipIndexFetchResult.Success) {
                    if (!(remoteZipIndexFetchResult instanceof RemoteZipIndexFetchResult.Failure)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    String[] strArr2 = new String[2];
                    RemoteZipIndexFetchResult.Failure failure2 = (RemoteZipIndexFetchResult.Failure) remoteZipIndexFetchResult;
                    strArr2[c] = failure2.getCode().name();
                    strArr2[1] = failure2.getDetail();
                    return new ArchiveSelectiveProbeResult.Fallback(CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) strArr2), StringUtils.PROCESS_POSTFIX_DELIMITER, null, null, 0, null, null, 62, null));
                }
                RemoteZipIndexSession session = ((RemoteZipIndexFetchResult.Success) remoteZipIndexFetchResult).getSession();
                ArchiveObservedRepresentationFence observedFence = session.getObservedFence();
                if (observedFence == null) {
                    return new ArchiveSelectiveProbeResult.Fallback("missing observed strong ETag");
                }
                ArchiveDeltaEligibility evaluate = ArchiveRepresentationFencePolicy.INSTANCE.evaluate(ArchiveSelectiveUpdatePolicy.INSTANCE.publishedBinding(archivePackage2), ArchiveSelectiveUpdatePolicy.INSTANCE.resolvedBinding(archivePackage2), observedFence, session.getIndex().getCentralDirectorySha256());
                if (!(evaluate instanceof ArchiveDeltaEligibility.Eligible)) {
                    Intrinsics.checkNotNull(evaluate, "null cannot be cast to non-null type com.arizona.launcher.updater.archive.range.ArchiveDeltaEligibility.Ineligible");
                    return new ArchiveSelectiveProbeResult.Fallback(((ArchiveDeltaEligibility.Ineligible) evaluate).getReason().name());
                } else if (!ArchiveSelectiveUpdatePolicy.INSTANCE.remoteRegularEntriesMatchExpected(session.getIndex(), archivePackage2, list)) {
                    return new ArchiveSelectiveProbeResult.Fallback("central directory does not match expected entry proofs");
                } else {
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                    Iterator<RemoteZipEntry> it3 = session.getIndex().getEntries().iterator();
                    while (true) {
                        remoteZipIndexSession = session;
                        archiveEntryChangePlan2 = archiveEntryChangePlan;
                        if (!it3.hasNext()) {
                            break;
                        }
                        RemoteZipEntry next2 = it3.next();
                        if (next2.isDirectory()) {
                            session = remoteZipIndexSession;
                            archiveEntryChangePlan = archiveEntryChangePlan2;
                        } else {
                            ArchiveObservedRepresentationFence archiveObservedRepresentationFence3 = observedFence;
                            String target = next2.getTarget();
                            ArchivePackageJournalEntry archivePackageJournalEntry5 = archivePackageJournalEntry2;
                            Locale ROOT = Locale.ROOT;
                            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                            String lowerCase = target.toLowerCase(ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            linkedHashMap3.put(lowerCase, next2);
                            session = remoteZipIndexSession;
                            archiveEntryChangePlan = archiveEntryChangePlan2;
                            list = list;
                            observedFence = archiveObservedRepresentationFence3;
                            archivePackageJournalEntry2 = archivePackageJournalEntry5;
                        }
                    }
                    List<ArchivePackageFileRecord> list5 = list;
                    archiveObservedRepresentationFence = observedFence;
                    archivePackageJournalEntry3 = archivePackageJournalEntry2;
                    ArrayList arrayList7 = new ArrayList();
                    ArrayList arrayList8 = new ArrayList();
                    for (ArchivePackageFileRecord archivePackageFileRecord2 : list5) {
                        List<ArchivePackageFileRecord> reusable = archiveEntryChangePlan2.getReusable();
                        ArrayList arrayList9 = arrayList7;
                        if (!(reusable instanceof Collection) || !reusable.isEmpty()) {
                            Iterator it4 = reusable.iterator();
                            while (it4.hasNext()) {
                                Iterator it5 = it4;
                                arrayList4 = arrayList8;
                                if (StringsKt.equals(((ArchivePackageFileRecord) it4.next()).getRelativePath(), archivePackageFileRecord2.getRelativePath(), true)) {
                                    if (archiveSelectivePackageInstaller.liveFileMatches(archivePackageFileRecord2)) {
                                        arrayList9.add(archivePackageFileRecord2);
                                        arrayList7 = arrayList9;
                                        arrayList8 = arrayList4;
                                    }
                                    String relativePath = archivePackageFileRecord2.getRelativePath();
                                    Locale ROOT2 = Locale.ROOT;
                                    Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
                                    String lowerCase2 = relativePath.toLowerCase(ROOT2);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                    remoteZipEntry = (RemoteZipEntry) linkedHashMap3.get(lowerCase2);
                                    if (remoteZipEntry != null) {
                                        return new ArchiveSelectiveProbeResult.Fallback("changed entry missing from ZIP index");
                                    }
                                    arrayList4.add(TuplesKt.to(archivePackageFileRecord2, remoteZipEntry));
                                    arrayList7 = arrayList9;
                                    arrayList8 = arrayList4;
                                } else {
                                    it4 = it5;
                                    arrayList8 = arrayList4;
                                }
                            }
                        }
                        arrayList4 = arrayList8;
                        String relativePath2 = archivePackageFileRecord2.getRelativePath();
                        Locale ROOT22 = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(ROOT22, "ROOT");
                        String lowerCase22 = relativePath2.toLowerCase(ROOT22);
                        Intrinsics.checkNotNullExpressionValue(lowerCase22, "toLowerCase(...)");
                        remoteZipEntry = (RemoteZipEntry) linkedHashMap3.get(lowerCase22);
                        if (remoteZipEntry != null) {
                        }
                    }
                    ArrayList arrayList10 = arrayList7;
                    arrayList = arrayList8;
                    if (arrayList10.isEmpty() || arrayList.isEmpty()) {
                        return new ArchiveSelectiveProbeResult.Fallback("no reusable live files after validation");
                    }
                    RemoteZipEntryRangeSession remoteZipEntryRangeSession3 = new RemoteZipEntryRangeSession(archivePackage2.getId(), str3, remoteZipIndexSession.getEffectiveUrl(), archiveObservedRepresentationFence.getStrongEtag(), archivePackage2.getArchiveSize(), remoteZipIndexSession.getIndex().getCentralDirectoryOffset());
                    List<RemoteZipEntry> entries = remoteZipIndexSession.getIndex().getEntries();
                    ArrayList arrayList11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries, 10));
                    for (RemoteZipEntry remoteZipEntry4 : entries) {
                        arrayList11.add(Boxing.boxLong(remoteZipEntry4.getLocalHeaderOffset()));
                    }
                    List sorted = CollectionsKt.sorted(CollectionsKt.distinct(arrayList11));
                    ArrayList arrayList12 = new ArrayList(arrayList.size());
                    long fetchedBytes = remoteZipIndexSession.getFetchedBytes();
                    Iterator it6 = arrayList.iterator();
                    Intrinsics.checkNotNullExpressionValue(it6, "iterator(...)");
                    j = 0;
                    list2 = sorted;
                    archivePackage3 = archivePackage2;
                    archiveSelectivePackageInstaller$probe$12 = archiveSelectivePackageInstaller$probe$13;
                    it = it6;
                    charSequence = StringUtils.PROCESS_POSTFIX_DELIMITER;
                    linkedHashMap = linkedHashMap3;
                    remoteZipEntryRangeSession = remoteZipEntryRangeSession3;
                    arrayList2 = arrayList12;
                    str4 = str3;
                    remoteZipIndexSession2 = remoteZipIndexSession;
                    list3 = list5;
                    archiveDeltaEligibility = evaluate;
                    arrayList3 = arrayList10;
                    j2 = fetchedBytes;
                    if (it.hasNext()) {
                    }
                }
            }
        }
        archiveSelectivePackageInstaller$probe$1 = new ArchiveSelectivePackageInstaller$probe$1(archiveSelectivePackageInstaller, continuation);
        ArchiveSelectivePackageInstaller$probe$1 archiveSelectivePackageInstaller$probe$132 = archiveSelectivePackageInstaller$probe$1;
        Object obj32 = archiveSelectivePackageInstaller$probe$132.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = archiveSelectivePackageInstaller$probe$132.label;
        String str52 = "selective byte estimate overflow";
        if (i != 0) {
        }
        remoteZipIndexFetchResult = (RemoteZipIndexFetchResult) obj;
        if (remoteZipIndexFetchResult instanceof RemoteZipIndexFetchResult.Success) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0162 A[Catch: SecurityException -> 0x02e7, IOException -> 0x02eb, TryCatch #4 {IOException -> 0x02eb, SecurityException -> 0x02e7, blocks: (B:46:0x01f8, B:48:0x0200, B:50:0x022e, B:53:0x0242, B:36:0x015c, B:38:0x0162, B:40:0x0181, B:42:0x01a2, B:54:0x026a, B:56:0x0278, B:58:0x027c, B:61:0x02a2, B:64:0x02aa, B:62:0x02a5, B:63:0x02a8, B:66:0x02e1, B:67:0x02e6), top: B:127:0x01f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0200 A[Catch: SecurityException -> 0x02e7, IOException -> 0x02eb, TryCatch #4 {IOException -> 0x02eb, SecurityException -> 0x02e7, blocks: (B:46:0x01f8, B:48:0x0200, B:50:0x022e, B:53:0x0242, B:36:0x015c, B:38:0x0162, B:40:0x0181, B:42:0x01a2, B:54:0x026a, B:56:0x0278, B:58:0x027c, B:61:0x02a2, B:64:0x02aa, B:62:0x02a5, B:63:0x02a8, B:66:0x02e1, B:67:0x02e6), top: B:127:0x01f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0278 A[Catch: SecurityException -> 0x02e7, IOException -> 0x02eb, TryCatch #4 {IOException -> 0x02eb, SecurityException -> 0x02e7, blocks: (B:46:0x01f8, B:48:0x0200, B:50:0x022e, B:53:0x0242, B:36:0x015c, B:38:0x0162, B:40:0x0181, B:42:0x01a2, B:54:0x026a, B:56:0x0278, B:58:0x027c, B:61:0x02a2, B:64:0x02aa, B:62:0x02a5, B:63:0x02a8, B:66:0x02e1, B:67:0x02e6), top: B:127:0x01f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02ef  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x01f4 -> B:127:0x01f8). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object install(ArchivePackage archivePackage, ArchiveSelectiveInstallSession archiveSelectiveInstallSession, File file, Function1<? super Long, Unit> function1, Continuation<? super ArchiveSelectiveInstallResult> continuation) {
        ArchiveSelectivePackageInstaller$install$1 archiveSelectivePackageInstaller$install$1;
        int i;
        ArchiveUpdaterErrorCode archiveUpdaterErrorCode;
        StrongEtag strongEtag;
        File file2;
        final Function1<? super Long, Unit> function12;
        final long j;
        final Ref.LongRef longRef;
        StrongEtag strongEtag2;
        RemoteZipEntryRangeSession remoteZipEntryRangeSession;
        ArchiveSelectivePackageInstaller$install$1 archiveSelectivePackageInstaller$install$12;
        Iterator<ArchiveSelectiveEntryTransfer> it;
        LinkedHashMap linkedHashMap;
        ArchiveSelectiveInstallSession archiveSelectiveInstallSession2;
        ArchivePackage archivePackage2;
        ArchiveUpdaterErrorCode archiveUpdaterErrorCode2;
        try {
            if (continuation instanceof ArchiveSelectivePackageInstaller$install$1) {
                archiveSelectivePackageInstaller$install$1 = (ArchiveSelectivePackageInstaller$install$1) continuation;
                if ((archiveSelectivePackageInstaller$install$1.label & Integer.MIN_VALUE) != 0) {
                    archiveSelectivePackageInstaller$install$1.label -= Integer.MIN_VALUE;
                    Object obj = archiveSelectivePackageInstaller$install$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = archiveSelectivePackageInstaller$install$1.label;
                    String str = "toLowerCase(...)";
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        ArchiveObservedRepresentationFence observedFence = archiveSelectiveInstallSession.getIndexSession().getObservedFence();
                        if (observedFence == null || (strongEtag = observedFence.getStrongEtag()) == null) {
                            return new ArchiveSelectiveInstallResult.Failure(ArchiveUpdaterErrorCode.DOWNLOAD_FAILED, "missing observed strong ETag", 0L, 4, null);
                        }
                        RemoteZipEntryRangeSession remoteZipEntryRangeSession2 = new RemoteZipEntryRangeSession(archivePackage.getId(), archiveSelectiveInstallSession.getRequestUrl(), archiveSelectiveInstallSession.getIndexSession().getEffectiveUrl(), strongEtag, archivePackage.getArchiveSize(), archiveSelectiveInstallSession.getIndexSession().getIndex().getCentralDirectoryOffset());
                        Ref.LongRef longRef2 = new Ref.LongRef();
                        longRef2.element = archiveSelectiveInstallSession.getPreflightNetworkBytes();
                        long estimatedNetworkBytes = archiveSelectiveInstallSession.getEstimatedNetworkBytes();
                        RemoteZipEntryRangeSession remoteZipEntryRangeSession3 = remoteZipEntryRangeSession2;
                        install$reportProgress(function1, estimatedNetworkBytes, longRef2.element);
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        for (ArchivePackageFileRecord archivePackageFileRecord : archiveSelectiveInstallSession.getReusable()) {
                            ArchivePackageFileRecord copyLiveFile = copyLiveFile(archivePackageFileRecord, file);
                            if (copyLiveFile == null) {
                                return new ArchiveSelectiveInstallResult.Failure(ArchiveUpdaterErrorCode.EXTRACTION_FAILED, "UNCHANGED_LIVE_FILE_INVALID:" + archivePackageFileRecord.getRelativePath(), longRef2.element);
                            }
                            String relativePath = archivePackageFileRecord.getRelativePath();
                            ArchiveSelectivePackageInstaller$install$1 archiveSelectivePackageInstaller$install$13 = archiveSelectivePackageInstaller$install$1;
                            Locale ROOT = Locale.ROOT;
                            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                            String lowerCase = relativePath.toLowerCase(ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            linkedHashMap2.put(lowerCase, copyLiveFile);
                            remoteZipEntryRangeSession3 = remoteZipEntryRangeSession3;
                            archiveSelectivePackageInstaller$install$1 = archiveSelectivePackageInstaller$install$13;
                        }
                        file2 = file;
                        ArchiveSelectivePackageInstaller$install$1 archiveSelectivePackageInstaller$install$14 = archiveSelectivePackageInstaller$install$1;
                        function12 = function1;
                        j = estimatedNetworkBytes;
                        longRef = longRef2;
                        strongEtag2 = strongEtag;
                        remoteZipEntryRangeSession = remoteZipEntryRangeSession3;
                        archiveSelectivePackageInstaller$install$12 = archiveSelectivePackageInstaller$install$14;
                        it = archiveSelectiveInstallSession.getToFetch().iterator();
                        linkedHashMap = linkedHashMap2;
                        archiveSelectiveInstallSession2 = archiveSelectiveInstallSession;
                        archivePackage2 = archivePackage;
                        if (!it.hasNext()) {
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        long j2 = archiveSelectivePackageInstaller$install$1.J$0;
                        File file3 = (File) archiveSelectivePackageInstaller$install$1.L$11;
                        ArchivePackageFileRecord archivePackageFileRecord2 = (ArchivePackageFileRecord) archiveSelectivePackageInstaller$install$1.L$10;
                        ArchiveSelectiveEntryTransfer archiveSelectiveEntryTransfer = (ArchiveSelectiveEntryTransfer) archiveSelectivePackageInstaller$install$1.L$9;
                        Iterator<ArchiveSelectiveEntryTransfer> it2 = (Iterator) archiveSelectivePackageInstaller$install$1.L$8;
                        LinkedHashMap linkedHashMap3 = (LinkedHashMap) archiveSelectivePackageInstaller$install$1.L$7;
                        Ref.LongRef longRef3 = (Ref.LongRef) archiveSelectivePackageInstaller$install$1.L$6;
                        RemoteZipEntryRangeSession remoteZipEntryRangeSession4 = (RemoteZipEntryRangeSession) archiveSelectivePackageInstaller$install$1.L$5;
                        StrongEtag strongEtag3 = (StrongEtag) archiveSelectivePackageInstaller$install$1.L$4;
                        Function1<? super Long, Unit> function13 = (Function1) archiveSelectivePackageInstaller$install$1.L$3;
                        File file4 = (File) archiveSelectivePackageInstaller$install$1.L$2;
                        ArchiveSelectiveInstallSession archiveSelectiveInstallSession3 = (ArchiveSelectiveInstallSession) archiveSelectivePackageInstaller$install$1.L$1;
                        ArchivePackage archivePackage3 = (ArchivePackage) archiveSelectivePackageInstaller$install$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        String str2 = "toLowerCase(...)";
                        strongEtag2 = strongEtag3;
                        ArchivePackageFileRecord archivePackageFileRecord3 = archivePackageFileRecord2;
                        linkedHashMap = linkedHashMap3;
                        ArchiveSelectivePackageInstaller$install$1 archiveSelectivePackageInstaller$install$15 = archiveSelectivePackageInstaller$install$1;
                        j = j2;
                        longRef = longRef3;
                        function12 = function13;
                        it = it2;
                        remoteZipEntryRangeSession = remoteZipEntryRangeSession4;
                        archiveSelectiveInstallSession2 = archiveSelectiveInstallSession3;
                        file2 = file4;
                        archivePackage2 = archivePackage3;
                        Object obj2 = obj;
                        try {
                            RemoteZipEntryReadResult remoteZipEntryReadResult = (RemoteZipEntryReadResult) obj2;
                            Object obj3 = coroutine_suspended;
                            if (!(remoteZipEntryReadResult instanceof RemoteZipEntryReadResult.Success)) {
                                ArchivePackage archivePackage4 = archivePackage2;
                                ArchiveSelectiveInstallSession archiveSelectiveInstallSession4 = archiveSelectiveInstallSession2;
                                ArchiveSelectivePackageInstaller$install$1 archiveSelectivePackageInstaller$install$16 = archiveSelectivePackageInstaller$install$15;
                                longRef.element = addFetched(longRef.element, ((RemoteZipEntryReadResult.Success) remoteZipEntryReadResult).getFetchedBytes());
                                install$reportProgress(function12, j, longRef.element);
                                if (((RemoteZipEntryReadResult.Success) remoteZipEntryReadResult).getFile().getSize() == archivePackageFileRecord3.getSize() && ((RemoteZipEntryReadResult.Success) remoteZipEntryReadResult).getFile().getCrc32() == archivePackageFileRecord3.getCrc32()) {
                                    String relativePath2 = archivePackageFileRecord3.getRelativePath();
                                    Locale ROOT2 = Locale.ROOT;
                                    Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
                                    String lowerCase2 = relativePath2.toLowerCase(ROOT2);
                                    str = str2;
                                    Intrinsics.checkNotNullExpressionValue(lowerCase2, str);
                                    linkedHashMap.put(lowerCase2, ((RemoteZipEntryReadResult.Success) remoteZipEntryReadResult).getFile());
                                    archiveSelectivePackageInstaller$install$12 = archiveSelectivePackageInstaller$install$16;
                                    coroutine_suspended = obj3;
                                    archivePackage2 = archivePackage4;
                                    archiveSelectiveInstallSession2 = archiveSelectiveInstallSession4;
                                    if (!it.hasNext()) {
                                        ArchiveSelectiveEntryTransfer next = it.next();
                                        ArchivePackageFileRecord desired = next.getDesired();
                                        str2 = str;
                                        File file5 = new File(file2, desired.getRelativePath());
                                        if (!containedTarget(file2, file5)) {
                                            return new ArchiveSelectiveInstallResult.Failure(ArchiveUpdaterErrorCode.EXTRACTION_FAILED, "PATH_UNSAFE:" + desired.getRelativePath(), longRef.element);
                                        }
                                        RemoteZipEntryRangeReader remoteZipEntryRangeReader = this.entryReader;
                                        RemoteZipPreparedEntry prepared = next.getPrepared();
                                        archivePackageFileRecord3 = desired;
                                        Function1<? super Long, Unit> function14 = new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.ArchiveSelectivePackageInstaller$$ExternalSyntheticLambda0
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj4) {
                                                return ArchiveSelectivePackageInstaller.install$lambda$0(ArchiveSelectivePackageInstaller.this, longRef, function12, j, ((Long) obj4).longValue());
                                            }
                                        };
                                        archiveSelectivePackageInstaller$install$12.L$0 = archivePackage2;
                                        archiveSelectivePackageInstaller$install$12.L$1 = archiveSelectiveInstallSession2;
                                        archiveSelectivePackageInstaller$install$12.L$2 = file2;
                                        archiveSelectivePackageInstaller$install$12.L$3 = function12;
                                        archiveSelectivePackageInstaller$install$12.L$4 = SpillingKt.nullOutSpilledVariable(strongEtag2);
                                        archiveSelectivePackageInstaller$install$12.L$5 = remoteZipEntryRangeSession;
                                        archiveSelectivePackageInstaller$install$12.L$6 = longRef;
                                        archiveSelectivePackageInstaller$install$12.L$7 = linkedHashMap;
                                        archiveSelectivePackageInstaller$install$12.L$8 = it;
                                        archiveSelectivePackageInstaller$install$12.L$9 = SpillingKt.nullOutSpilledVariable(next);
                                        archiveSelectivePackageInstaller$install$12.L$10 = archivePackageFileRecord3;
                                        archiveSelectivePackageInstaller$install$12.L$11 = SpillingKt.nullOutSpilledVariable(file5);
                                        archiveSelectivePackageInstaller$install$12.J$0 = j;
                                        archiveSelectivePackageInstaller$install$12.label = 1;
                                        ArchiveSelectivePackageInstaller$install$1 archiveSelectivePackageInstaller$install$17 = archiveSelectivePackageInstaller$install$12;
                                        LinkedHashMap linkedHashMap4 = linkedHashMap;
                                        Object readPreparedToFile = remoteZipEntryRangeReader.readPreparedToFile(remoteZipEntryRangeSession, prepared, file5, function14, archiveSelectivePackageInstaller$install$17);
                                        if (readPreparedToFile == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        linkedHashMap = linkedHashMap4;
                                        obj2 = readPreparedToFile;
                                        archiveSelectivePackageInstaller$install$15 = archiveSelectivePackageInstaller$install$17;
                                        RemoteZipEntryReadResult remoteZipEntryReadResult2 = (RemoteZipEntryReadResult) obj2;
                                        Object obj32 = coroutine_suspended;
                                        if (!(remoteZipEntryReadResult2 instanceof RemoteZipEntryReadResult.Success)) {
                                            if (!(remoteZipEntryReadResult2 instanceof RemoteZipEntryReadResult.Failure)) {
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            longRef.element = addFetched(longRef.element, ((RemoteZipEntryReadResult.Failure) remoteZipEntryReadResult2).getFetchedBytes());
                                            int i2 = WhenMappings.$EnumSwitchMapping$0[((RemoteZipEntryReadResult.Failure) remoteZipEntryReadResult2).getCode().ordinal()];
                                            if (i2 == 1) {
                                                archiveUpdaterErrorCode2 = ArchiveUpdaterErrorCode.INSUFFICIENT_STORAGE;
                                            } else if (i2 == 2) {
                                                archiveUpdaterErrorCode2 = ArchiveUpdaterErrorCode.DOWNLOAD_FAILED;
                                            } else {
                                                archiveUpdaterErrorCode2 = ArchiveUpdaterErrorCode.EXTRACTION_FAILED;
                                            }
                                            return new ArchiveSelectiveInstallResult.Failure(archiveUpdaterErrorCode2, CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{((RemoteZipEntryReadResult.Failure) remoteZipEntryReadResult2).getCode().name(), ((RemoteZipEntryReadResult.Failure) remoteZipEntryReadResult2).getDetail()}), StringUtils.PROCESS_POSTFIX_DELIMITER, null, null, 0, null, null, 62, null), longRef.element);
                                        }
                                    } else {
                                        LinkedHashMap linkedHashMap5 = linkedHashMap;
                                        List<ArchivePackageFileRecord> reusable = archiveSelectiveInstallSession2.getReusable();
                                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(reusable, 10));
                                        for (ArchivePackageFileRecord archivePackageFileRecord4 : reusable) {
                                            String relativePath3 = archivePackageFileRecord4.getRelativePath();
                                            Locale ROOT3 = Locale.ROOT;
                                            Intrinsics.checkNotNullExpressionValue(ROOT3, "ROOT");
                                            String lowerCase3 = relativePath3.toLowerCase(ROOT3);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase3, str);
                                            ArchivePackageFileRecord archivePackageFileRecord5 = (ArchivePackageFileRecord) linkedHashMap5.get(lowerCase3);
                                            if (archivePackageFileRecord5 == null) {
                                                return new ArchiveSelectiveInstallResult.Failure(ArchiveUpdaterErrorCode.STATE_FILES_MISSING, archivePackageFileRecord4.getRelativePath(), longRef.element);
                                            }
                                            arrayList.add(archivePackageFileRecord5);
                                        }
                                        ArrayList arrayList2 = arrayList;
                                        List<ArchiveSelectiveEntryTransfer> toFetch = archiveSelectiveInstallSession2.getToFetch();
                                        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(toFetch, 10));
                                        for (ArchiveSelectiveEntryTransfer archiveSelectiveEntryTransfer2 : toFetch) {
                                            ArchivePackageFileRecord desired2 = archiveSelectiveEntryTransfer2.getDesired();
                                            String relativePath4 = desired2.getRelativePath();
                                            Locale ROOT4 = Locale.ROOT;
                                            Intrinsics.checkNotNullExpressionValue(ROOT4, "ROOT");
                                            String lowerCase4 = relativePath4.toLowerCase(ROOT4);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase4, str);
                                            ArchivePackageFileRecord archivePackageFileRecord6 = (ArchivePackageFileRecord) linkedHashMap5.get(lowerCase4);
                                            if (archivePackageFileRecord6 == null) {
                                                return new ArchiveSelectiveInstallResult.Failure(ArchiveUpdaterErrorCode.STATE_FILES_MISSING, desired2.getRelativePath(), longRef.element);
                                            }
                                            arrayList3.add(archivePackageFileRecord6);
                                        }
                                        List plus = CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList3);
                                        List<ArchiveEntryMetadata> entries = archivePackage2.getEntries();
                                        if (entries == null) {
                                            entries = CollectionsKt.emptyList();
                                        }
                                        List<ArchiveEntryMetadata> list = entries;
                                        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                                        for (ArchiveEntryMetadata archiveEntryMetadata : list) {
                                            String targetRelativePath = archiveEntryMetadata.getTargetRelativePath();
                                            Locale ROOT5 = Locale.ROOT;
                                            Intrinsics.checkNotNullExpressionValue(ROOT5, "ROOT");
                                            String lowerCase5 = targetRelativePath.toLowerCase(ROOT5);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase5, str);
                                            arrayList4.add(lowerCase5);
                                        }
                                        Set set = CollectionsKt.toSet(arrayList4);
                                        List<ArchivePackageFileRecord> list2 = plus;
                                        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                                        for (ArchivePackageFileRecord archivePackageFileRecord7 : list2) {
                                            String relativePath5 = archivePackageFileRecord7.getRelativePath();
                                            Locale ROOT6 = Locale.ROOT;
                                            Intrinsics.checkNotNullExpressionValue(ROOT6, "ROOT");
                                            String lowerCase6 = relativePath5.toLowerCase(ROOT6);
                                            Intrinsics.checkNotNullExpressionValue(lowerCase6, str);
                                            arrayList5.add(lowerCase6);
                                        }
                                        if (!Intrinsics.areEqual(CollectionsKt.toSet(arrayList5), set)) {
                                            return new ArchiveSelectiveInstallResult.Failure(ArchiveUpdaterErrorCode.ENTRY_MANIFEST_MISMATCH, null, longRef.element, 2, null);
                                        }
                                        long j3 = 0;
                                        for (ArchivePackageFileRecord archivePackageFileRecord8 : list2) {
                                            j3 += archivePackageFileRecord8.getSize();
                                        }
                                        if (j3 != archivePackage2.getInstalledSize()) {
                                            return new ArchiveSelectiveInstallResult.Failure(ArchiveUpdaterErrorCode.INSTALLED_SIZE_MISMATCH, "expected=" + archivePackage2.getInstalledSize() + ", actual=" + j3, longRef.element);
                                        }
                                        if (longRef.element != archiveSelectiveInstallSession2.getEstimatedNetworkBytes()) {
                                            return new ArchiveSelectiveInstallResult.Failure(ArchiveUpdaterErrorCode.DOWNLOAD_FAILED, "selective byte accounting mismatch", longRef.element);
                                        }
                                        install$reportProgress(function12, j, archiveSelectiveInstallSession2.getEstimatedNetworkBytes());
                                        return new ArchiveSelectiveInstallResult.Success(plus, archiveSelectiveInstallSession2.getEstimatedNetworkBytes());
                                    }
                                }
                                return new ArchiveSelectiveInstallResult.Failure(ArchiveUpdaterErrorCode.ENTRY_MANIFEST_MISMATCH, archivePackageFileRecord3.getRelativePath(), longRef.element);
                            }
                        } catch (IOException e) {
                            e = e;
                            Ref.LongRef longRef4 = longRef;
                            if (ArchiveStorageFailureClassifier.INSTANCE.isNoSpace(e)) {
                                archiveUpdaterErrorCode = ArchiveUpdaterErrorCode.INSUFFICIENT_STORAGE;
                            } else {
                                archiveUpdaterErrorCode = ArchiveUpdaterErrorCode.EXTRACTION_FAILED;
                            }
                            return new ArchiveSelectiveInstallResult.Failure(archiveUpdaterErrorCode, e.getMessage(), longRef4.element);
                        } catch (SecurityException e2) {
                            e = e2;
                            Ref.LongRef longRef5 = longRef;
                            return new ArchiveSelectiveInstallResult.Failure(ArchiveUpdaterErrorCode.EXTRACTION_FAILED, e.getMessage(), longRef5.element);
                        }
                    }
                }
            }
            if (i != 0) {
            }
        } catch (IOException e3) {
            e = e3;
        } catch (SecurityException e4) {
            e = e4;
        }
        archiveSelectivePackageInstaller$install$1 = new ArchiveSelectivePackageInstaller$install$1(this, continuation);
        Object obj4 = archiveSelectivePackageInstaller$install$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = archiveSelectivePackageInstaller$install$1.label;
        String str3 = "toLowerCase(...)";
    }

    private static final void install$reportProgress(Function1<? super Long, Unit> function1, long j, long j2) {
        function1.invoke(Long.valueOf(RangesKt.coerceAtMost(j2, j)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$0(ArchiveSelectivePackageInstaller archiveSelectivePackageInstaller, Ref.LongRef longRef, Function1 function1, long j, long j2) {
        install$reportProgress(function1, j, archiveSelectivePackageInstaller.addFetched(longRef.element, j2));
        return Unit.INSTANCE;
    }

    private final boolean liveFileMatches(ArchivePackageFileRecord archivePackageFileRecord) {
        File validatedLiveSource = validatedLiveSource(archivePackageFileRecord);
        if (validatedLiveSource == null) {
            return false;
        }
        return WholeFileCrc32Verifier.INSTANCE.verify(validatedLiveSource, archivePackageFileRecord.getSize(), archivePackageFileRecord.getCrc32()) instanceof WholeFileVerificationResult.Success;
    }

    private final ArchivePackageFileRecord copyLiveFile(ArchivePackageFileRecord archivePackageFileRecord, File file) {
        File parentFile;
        File validatedLiveSource;
        File validatedLiveSource2;
        File file2 = new File(file, archivePackageFileRecord.getRelativePath());
        if (!containedTarget(file, file2) || (parentFile = file2.getParentFile()) == null) {
            return null;
        }
        if ((!parentFile.isDirectory() && !this.directoryCreator.createDirectories(parentFile)) || (validatedLiveSource = validatedLiveSource(archivePackageFileRecord)) == null || (validatedLiveSource2 = validatedLiveSource(archivePackageFileRecord)) == null || !Intrinsics.areEqual(validatedLiveSource, validatedLiveSource2)) {
            return null;
        }
        CRC32 crc32 = new CRC32();
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        try {
            FileInputStream fileInputStream = new FileInputStream(validatedLiveSource2);
            try {
                FileInputStream fileInputStream2 = fileInputStream;
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                FileOutputStream fileOutputStream2 = fileOutputStream;
                byte[] bArr = new byte[65536];
                long j = 0;
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read < 0) {
                        break;
                    } else if (read != 0) {
                        fileOutputStream2.write(bArr, 0, read);
                        crc32.update(bArr, 0, read);
                        messageDigest.update(bArr, 0, read);
                        j += read;
                    }
                }
                fileOutputStream2.flush();
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, null);
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(fileInputStream, null);
                if (j != archivePackageFileRecord.getSize() || crc32.getValue() != archivePackageFileRecord.getCrc32()) {
                    file2.delete();
                    return null;
                }
                String relativePath = archivePackageFileRecord.getRelativePath();
                long value = crc32.getValue();
                byte[] digest = messageDigest.digest();
                Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
                return new ArchivePackageFileRecord(relativePath, j, value, ArraysKt.joinToString$default(digest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.arizona.launcher.updater.archive.orchestrator.ArchiveSelectivePackageInstaller$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ArchiveSelectivePackageInstaller.copyLiveFile$lambda$1(((Byte) obj).byteValue());
                    }
                }, 30, (Object) null));
            } finally {
            }
        } catch (IOException unused) {
            file2.delete();
            return null;
        } catch (SecurityException unused2) {
            file2.delete();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence copyLiveFile$lambda$1(byte b) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(b & 255)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    private final File validatedLiveSource(ArchivePackageFileRecord archivePackageFileRecord) {
        try {
            File file = new File(this.gameRoot, archivePackageFileRecord.getRelativePath());
            File canonicalFile = this.gameRoot.getCanonicalFile();
            if (!this.pathSafety.isSymbolicLink(file)) {
                ArchiveLivePathSafety archiveLivePathSafety = this.pathSafety;
                Intrinsics.checkNotNull(canonicalFile);
                if (!archiveLivePathSafety.hasSymbolicLinkComponent(canonicalFile, file)) {
                    File canonicalFile2 = file.getCanonicalFile();
                    ArchiveLivePathSafety archiveLivePathSafety2 = this.pathSafety;
                    Intrinsics.checkNotNull(canonicalFile2);
                    if (archiveLivePathSafety2.isStrictChild(canonicalFile2, canonicalFile) && !this.pathSafety.isSymbolicLink(file)) {
                        if (!this.pathSafety.hasUnsafeCanonicalAlias(canonicalFile, file, canonicalFile2)) {
                            return canonicalFile2;
                        }
                    }
                }
            }
        } catch (IOException | SecurityException unused) {
        }
        return null;
    }

    private final boolean containedTarget(File file, File file2) {
        File normalizedAbsoluteFile;
        File normalizedAbsoluteFile2 = this.pathSafety.normalizedAbsoluteFile(file);
        if (normalizedAbsoluteFile2 == null || (normalizedAbsoluteFile = this.pathSafety.normalizedAbsoluteFile(file2)) == null) {
            return false;
        }
        return this.pathSafety.isStrictChild(normalizedAbsoluteFile, normalizedAbsoluteFile2);
    }

    private final long addFetched(long j, long j2) {
        try {
            return Math.addExact(j, j2);
        } catch (ArithmeticException unused) {
            return Long.MAX_VALUE;
        }
    }

    /* compiled from: ArchiveSelectivePackageInstaller.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectivePackageInstaller$Companion;", "", "<init>", "()V", "BUFFER_SIZE", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
