package com.arizona.launcher.updater.archive.orchestrator;

import android.content.Context;
import com.arizona.launcher.DownloadRetryConfig;
import com.arizona.launcher.DownloadRetryPolicy;
import com.arizona.launcher.updater.archive.download.AndroidArchiveNetworkMonitor;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestDescriptor;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchivePackageDescriptor;
import com.arizona.launcher.updater.archive.model.ArchiveEntryMetadata;
import com.arizona.launcher.updater.archive.model.ArchiveGpu;
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
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.TimeoutKt;
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 &2\u00020\u0001:\u0001&B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0086@¢\u0006\u0002\u0010\u0012J(\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0082@¢\u0006\u0002\u0010\u0016J(\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0082@¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u001c\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u0014\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0011H\u0002J\u0014\u0010#\u001a\u0004\u0018\u00010 *\b\u0012\u0004\u0012\u00020%0$H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b(\u0012\b\b)\u0012\u0004\b\u0003\u0010\u0000¨\u0006'"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolver;", "", "packageIndexSource", "Lcom/arizona/launcher/updater/archive/orchestrator/OriginalTzArchivePackageIndexSource;", "indexFetchConcurrency", "", "indexReadTimeoutMs", "", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/OriginalTzArchivePackageIndexSource;IJ)V", "resolve", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolutionResult;", "candidate", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidate;", "serverBaseUrl", "", "loadedState", "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestCandidate;Ljava/lang/String;Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveOriginalTz", "descriptor", "Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchiveManifestDescriptor;", "(Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchiveManifestDescriptor;Ljava/lang/String;Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveOriginalTzIndexes", "readRemoteIndex", "Lcom/arizona/launcher/updater/archive/orchestrator/OriginalTzArchivePackageIndexResult;", "packageDescriptor", "Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchivePackageDescriptor;", "(Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchivePackageDescriptor;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolvedPackage", "Lcom/arizona/launcher/updater/archive/model/ArchivePackage;", FirebaseAnalytics.Param.INDEX, "Lcom/arizona/launcher/updater/archive/orchestrator/OriginalTzArchivePackageIndex;", "reusableIndex", RemoteConfigConstants.ResponseFieldKey.STATE, "toPackageIndexOrNull", "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveManifestResolver {
    public static final int INDEX_FETCH_CONCURRENCY = 6;
    public static final long INDEX_HTTP_CALL_TIMEOUT_SECONDS = 30;
    public static final long INDEX_READ_TIMEOUT_MS = 60000;
    private final int indexFetchConcurrency;
    private final long indexReadTimeoutMs;
    private final OriginalTzArchivePackageIndexSource packageIndexSource;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ArchiveManifestResolver() {
        this(null, 0, 0L, 7, null);
    }

    public ArchiveManifestResolver(OriginalTzArchivePackageIndexSource packageIndexSource, int i, long j) {
        Intrinsics.checkNotNullParameter(packageIndexSource, "packageIndexSource");
        this.packageIndexSource = packageIndexSource;
        this.indexFetchConcurrency = i;
        this.indexReadTimeoutMs = j;
    }

    public /* synthetic */ ArchiveManifestResolver(AnonymousClass1 anonymousClass1, int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new OriginalTzArchivePackageIndexSource() { // from class: com.arizona.launcher.updater.archive.orchestrator.ArchiveManifestResolver.1
            @Override // com.arizona.launcher.updater.archive.orchestrator.OriginalTzArchivePackageIndexSource
            public final Object read(OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor, String str, Continuation<? super OriginalTzArchivePackageIndexResult> continuation) {
                return new OriginalTzArchivePackageIndexResult.Failure(ArchiveManifestResolutionErrorCode.REMOTE_INDEX_UNAVAILABLE, "original-TZ package index source is not configured");
            }
        } : anonymousClass1, (i2 & 2) != 0 ? 6 : i, (i2 & 4) != 0 ? 60000L : j);
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
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f A[Catch: all -> 0x0042, TryCatch #1 {all -> 0x0042, blocks: (B:12:0x003e, B:23:0x0075, B:26:0x007f, B:28:0x0083, B:31:0x00bb, B:32:0x00c0), top: B:39:0x003e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveOriginalTz(OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor, String str, ArchiveUpdaterState archiveUpdaterState, Continuation<? super ArchiveManifestResolutionResult> continuation) {
        ArchiveManifestResolver$resolveOriginalTz$1 archiveManifestResolver$resolveOriginalTz$1;
        int i;
        OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor2;
        String str2;
        Throwable th;
        long j;
        long elapsedMs;
        ArchiveManifestResolutionResult archiveManifestResolutionResult;
        String name;
        long elapsedMs2;
        if (continuation instanceof ArchiveManifestResolver$resolveOriginalTz$1) {
            archiveManifestResolver$resolveOriginalTz$1 = (ArchiveManifestResolver$resolveOriginalTz$1) continuation;
            if ((archiveManifestResolver$resolveOriginalTz$1.label & Integer.MIN_VALUE) != 0) {
                archiveManifestResolver$resolveOriginalTz$1.label -= Integer.MIN_VALUE;
                Object obj = archiveManifestResolver$resolveOriginalTz$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = archiveManifestResolver$resolveOriginalTz$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    long nanoTime = System.nanoTime();
                    try {
                        archiveManifestResolver$resolveOriginalTz$1.L$0 = originalTzArchiveManifestDescriptor;
                        archiveManifestResolver$resolveOriginalTz$1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                        archiveManifestResolver$resolveOriginalTz$1.L$2 = SpillingKt.nullOutSpilledVariable(archiveUpdaterState);
                        archiveManifestResolver$resolveOriginalTz$1.L$3 = "cancelled";
                        archiveManifestResolver$resolveOriginalTz$1.J$0 = nanoTime;
                        archiveManifestResolver$resolveOriginalTz$1.label = 1;
                        Object resolveOriginalTzIndexes = resolveOriginalTzIndexes(originalTzArchiveManifestDescriptor, str, archiveUpdaterState, archiveManifestResolver$resolveOriginalTz$1);
                        if (resolveOriginalTzIndexes == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        originalTzArchiveManifestDescriptor2 = originalTzArchiveManifestDescriptor;
                        obj = resolveOriginalTzIndexes;
                        j = nanoTime;
                    } catch (Throwable th2) {
                        originalTzArchiveManifestDescriptor2 = originalTzArchiveManifestDescriptor;
                        str2 = "cancelled";
                        th = th2;
                        j = nanoTime;
                        int size = originalTzArchiveManifestDescriptor2.getPackages().size();
                        elapsedMs = ArchiveManifestResolverKt.elapsedMs(j);
                        ArchiveManifestResolverKt.logResolver("original TZ resolve done packages=" + size + " elapsedMs=" + elapsedMs + " result=" + str2);
                        throw th;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    j = archiveManifestResolver$resolveOriginalTz$1.J$0;
                    str2 = (String) archiveManifestResolver$resolveOriginalTz$1.L$3;
                    ArchiveUpdaterState archiveUpdaterState2 = (ArchiveUpdaterState) archiveManifestResolver$resolveOriginalTz$1.L$2;
                    String str3 = (String) archiveManifestResolver$resolveOriginalTz$1.L$1;
                    originalTzArchiveManifestDescriptor2 = (OriginalTzArchiveManifestDescriptor) archiveManifestResolver$resolveOriginalTz$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        int size2 = originalTzArchiveManifestDescriptor2.getPackages().size();
                        elapsedMs = ArchiveManifestResolverKt.elapsedMs(j);
                        ArchiveManifestResolverKt.logResolver("original TZ resolve done packages=" + size2 + " elapsedMs=" + elapsedMs + " result=" + str2);
                        throw th;
                    }
                }
                archiveManifestResolutionResult = (ArchiveManifestResolutionResult) obj;
                if (!(archiveManifestResolutionResult instanceof ArchiveManifestResolutionResult.Success)) {
                    name = FirebaseAnalytics.Param.SUCCESS;
                } else if (!(archiveManifestResolutionResult instanceof ArchiveManifestResolutionResult.Failure)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    name = ((ArchiveManifestResolutionResult.Failure) archiveManifestResolutionResult).getCode().name();
                }
                int size3 = originalTzArchiveManifestDescriptor2.getPackages().size();
                elapsedMs2 = ArchiveManifestResolverKt.elapsedMs(j);
                ArchiveManifestResolverKt.logResolver("original TZ resolve done packages=" + size3 + " elapsedMs=" + elapsedMs2 + " result=" + name);
                return archiveManifestResolutionResult;
            }
        }
        archiveManifestResolver$resolveOriginalTz$1 = new ArchiveManifestResolver$resolveOriginalTz$1(this, continuation);
        Object obj2 = archiveManifestResolver$resolveOriginalTz$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = archiveManifestResolver$resolveOriginalTz$1.label;
        if (i != 0) {
        }
        archiveManifestResolutionResult = (ArchiveManifestResolutionResult) obj2;
        if (!(archiveManifestResolutionResult instanceof ArchiveManifestResolutionResult.Success)) {
        }
        int size32 = originalTzArchiveManifestDescriptor2.getPackages().size();
        elapsedMs2 = ArchiveManifestResolverKt.elapsedMs(j);
        ArchiveManifestResolverKt.logResolver("original TZ resolve done packages=" + size32 + " elapsedMs=" + elapsedMs2 + " result=" + name);
        return archiveManifestResolutionResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014c A[Catch: IllegalArgumentException -> 0x0172, TryCatch #0 {IllegalArgumentException -> 0x0172, blocks: (B:48:0x0139, B:50:0x014c, B:52:0x0150, B:53:0x0156, B:54:0x0161, B:55:0x0162), top: B:60:0x0139 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveOriginalTzIndexes(OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor, String str, ArchiveUpdaterState archiveUpdaterState, Continuation<? super ArchiveManifestResolutionResult> continuation) {
        ArchiveManifestResolver$resolveOriginalTzIndexes$1 archiveManifestResolver$resolveOriginalTzIndexes$1;
        int i;
        ArchivePackage[] archivePackageArr;
        ArchiveManifestResolver archiveManifestResolver;
        Object coroutineScope;
        try {
            try {
                if (continuation instanceof ArchiveManifestResolver$resolveOriginalTzIndexes$1) {
                    archiveManifestResolver$resolveOriginalTzIndexes$1 = (ArchiveManifestResolver$resolveOriginalTzIndexes$1) continuation;
                    if ((archiveManifestResolver$resolveOriginalTzIndexes$1.label & Integer.MIN_VALUE) != 0) {
                        archiveManifestResolver$resolveOriginalTzIndexes$1.label -= Integer.MIN_VALUE;
                        Object obj = archiveManifestResolver$resolveOriginalTzIndexes$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = archiveManifestResolver$resolveOriginalTzIndexes$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            archivePackageArr = new ArchivePackage[originalTzArchiveManifestDescriptor.getPackages().size()];
                            ArrayList arrayList = new ArrayList(originalTzArchiveManifestDescriptor.getPackages().size());
                            int i2 = 0;
                            for (OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor : originalTzArchiveManifestDescriptor.getPackages()) {
                                int i3 = i2 + 1;
                                OriginalTzArchivePackageIndex reusableIndex = reusableIndex(originalTzArchivePackageDescriptor, archiveUpdaterState);
                                if (reusableIndex != null) {
                                    try {
                                        archivePackageArr[i2] = resolvedPackage(originalTzArchivePackageDescriptor, reusableIndex);
                                    } catch (IllegalArgumentException e) {
                                        return new ArchiveManifestResolutionResult.Failure(ArchiveManifestResolutionErrorCode.PACKAGE_METADATA_INVALID, originalTzArchivePackageDescriptor.getId(), e.getMessage());
                                    }
                                } else {
                                    arrayList.add(Boxing.boxInt(i2));
                                }
                                i2 = i3;
                            }
                            if (!arrayList.isEmpty()) {
                                archiveManifestResolver = this;
                                archiveManifestResolver$resolveOriginalTzIndexes$1.L$0 = originalTzArchiveManifestDescriptor;
                                archiveManifestResolver$resolveOriginalTzIndexes$1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                                archiveManifestResolver$resolveOriginalTzIndexes$1.L$2 = SpillingKt.nullOutSpilledVariable(archiveUpdaterState);
                                archiveManifestResolver$resolveOriginalTzIndexes$1.L$3 = archivePackageArr;
                                archiveManifestResolver$resolveOriginalTzIndexes$1.L$4 = SpillingKt.nullOutSpilledVariable(arrayList);
                                archiveManifestResolver$resolveOriginalTzIndexes$1.label = 1;
                                coroutineScope = CoroutineScopeKt.coroutineScope(new ArchiveManifestResolver$resolveOriginalTzIndexes$remoteIndexes$1(archiveManifestResolver, arrayList, originalTzArchiveManifestDescriptor, str, null), archiveManifestResolver$resolveOriginalTzIndexes$1);
                                if (coroutineScope == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                originalTzArchiveManifestDescriptor = originalTzArchiveManifestDescriptor;
                            } else {
                                String manifestVersion = originalTzArchiveManifestDescriptor.getManifestVersion();
                                ArchiveGpu selectedGpu = originalTzArchiveManifestDescriptor.getSelectedGpu();
                                ArrayList arrayList2 = new ArrayList(archivePackageArr.length);
                                for (ArchivePackage archivePackage : archivePackageArr) {
                                    if (archivePackage == null) {
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                    arrayList2.add(archivePackage);
                                }
                                return new ArchiveManifestResolutionResult.Success(new ArchiveManifest(2, manifestVersion, selectedGpu, arrayList2));
                            }
                        } else if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            ArrayList arrayList3 = (ArrayList) archiveManifestResolver$resolveOriginalTzIndexes$1.L$4;
                            ArchivePackage[] archivePackageArr2 = (ArchivePackage[]) archiveManifestResolver$resolveOriginalTzIndexes$1.L$3;
                            ArchiveUpdaterState archiveUpdaterState2 = (ArchiveUpdaterState) archiveManifestResolver$resolveOriginalTzIndexes$1.L$2;
                            String str2 = (String) archiveManifestResolver$resolveOriginalTzIndexes$1.L$1;
                            OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor2 = (OriginalTzArchiveManifestDescriptor) archiveManifestResolver$resolveOriginalTzIndexes$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            archiveManifestResolver = this;
                            coroutineScope = obj;
                            archivePackageArr = archivePackageArr2;
                            originalTzArchiveManifestDescriptor = originalTzArchiveManifestDescriptor2;
                        }
                        for (Pair pair : (List) coroutineScope) {
                            int intValue = ((Number) pair.component1()).intValue();
                            OriginalTzArchivePackageIndex originalTzArchivePackageIndex = (OriginalTzArchivePackageIndex) pair.component2();
                            OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor2 = originalTzArchiveManifestDescriptor.getPackages().get(intValue);
                            try {
                                archivePackageArr[intValue] = archiveManifestResolver.resolvedPackage(originalTzArchivePackageDescriptor2, originalTzArchivePackageIndex);
                            } catch (IllegalArgumentException e2) {
                                return new ArchiveManifestResolutionResult.Failure(ArchiveManifestResolutionErrorCode.PACKAGE_METADATA_INVALID, originalTzArchivePackageDescriptor2.getId(), e2.getMessage());
                            }
                        }
                        String manifestVersion2 = originalTzArchiveManifestDescriptor.getManifestVersion();
                        ArchiveGpu selectedGpu2 = originalTzArchiveManifestDescriptor.getSelectedGpu();
                        ArrayList arrayList22 = new ArrayList(archivePackageArr.length);
                        while (r3 < r14) {
                        }
                        return new ArchiveManifestResolutionResult.Success(new ArchiveManifest(2, manifestVersion2, selectedGpu2, arrayList22));
                    }
                }
                String manifestVersion22 = originalTzArchiveManifestDescriptor.getManifestVersion();
                ArchiveGpu selectedGpu22 = originalTzArchiveManifestDescriptor.getSelectedGpu();
                ArrayList arrayList222 = new ArrayList(archivePackageArr.length);
                while (r3 < r14) {
                }
                return new ArchiveManifestResolutionResult.Success(new ArchiveManifest(2, manifestVersion22, selectedGpu22, arrayList222));
            } catch (IllegalArgumentException e3) {
                return new ArchiveManifestResolutionResult.Failure(ArchiveManifestResolutionErrorCode.PACKAGE_METADATA_INVALID, null, e3.getMessage(), 2, null);
            }
            if (i != 0) {
            }
            while (r11.hasNext()) {
            }
        } catch (OriginalTzRemoteIndexException e4) {
            return new ArchiveManifestResolutionResult.Failure(e4.getCode(), e4.getPackageId(), e4.getDetail());
        }
        archiveManifestResolver$resolveOriginalTzIndexes$1 = new ArchiveManifestResolver$resolveOriginalTzIndexes$1(this, continuation);
        Object obj2 = archiveManifestResolver$resolveOriginalTzIndexes$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = archiveManifestResolver$resolveOriginalTzIndexes$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009f A[Catch: CancellationException -> 0x003f, TryCatch #0 {CancellationException -> 0x003f, blocks: (B:12:0x003b, B:23:0x009b, B:25:0x009f, B:26:0x00aa, B:32:0x00c1, B:29:0x00b2, B:31:0x00b6, B:34:0x00f4, B:35:0x00f9), top: B:40:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b2 A[Catch: CancellationException -> 0x003f, TryCatch #0 {CancellationException -> 0x003f, blocks: (B:12:0x003b, B:23:0x009b, B:25:0x009f, B:26:0x00aa, B:32:0x00c1, B:29:0x00b2, B:31:0x00b6, B:34:0x00f4, B:35:0x00f9), top: B:40:0x003b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readRemoteIndex(OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor, String str, Continuation<? super OriginalTzArchivePackageIndexResult> continuation) {
        ArchiveManifestResolver$readRemoteIndex$1 archiveManifestResolver$readRemoteIndex$1;
        int i;
        String indexHost;
        OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor2;
        String str2;
        CancellationException e;
        long j;
        long elapsedMs;
        OriginalTzArchivePackageIndexResult.Failure failure;
        String name;
        long elapsedMs2;
        if (continuation instanceof ArchiveManifestResolver$readRemoteIndex$1) {
            archiveManifestResolver$readRemoteIndex$1 = (ArchiveManifestResolver$readRemoteIndex$1) continuation;
            if ((archiveManifestResolver$readRemoteIndex$1.label & Integer.MIN_VALUE) != 0) {
                archiveManifestResolver$readRemoteIndex$1.label -= Integer.MIN_VALUE;
                Object obj = archiveManifestResolver$readRemoteIndex$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = archiveManifestResolver$readRemoteIndex$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    long nanoTime = System.nanoTime();
                    indexHost = ArchiveManifestResolverKt.indexHost(str, originalTzArchivePackageDescriptor.getUrl());
                    ArchiveManifestResolverKt.logResolver("remote index start package=" + originalTzArchivePackageDescriptor.getId() + " host=" + indexHost);
                    try {
                        archiveManifestResolver$readRemoteIndex$1.L$0 = originalTzArchivePackageDescriptor;
                        archiveManifestResolver$readRemoteIndex$1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                        archiveManifestResolver$readRemoteIndex$1.L$2 = indexHost;
                        archiveManifestResolver$readRemoteIndex$1.J$0 = nanoTime;
                        archiveManifestResolver$readRemoteIndex$1.label = 1;
                        Object withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(this.indexReadTimeoutMs, new ArchiveManifestResolver$readRemoteIndex$result$1(this, originalTzArchivePackageDescriptor, str, null), archiveManifestResolver$readRemoteIndex$1);
                        if (withTimeoutOrNull == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        originalTzArchivePackageDescriptor2 = originalTzArchivePackageDescriptor;
                        str2 = indexHost;
                        obj = withTimeoutOrNull;
                        j = nanoTime;
                    } catch (CancellationException e2) {
                        originalTzArchivePackageDescriptor2 = originalTzArchivePackageDescriptor;
                        str2 = indexHost;
                        e = e2;
                        j = nanoTime;
                        String id = originalTzArchivePackageDescriptor2.getId();
                        elapsedMs = ArchiveManifestResolverKt.elapsedMs(j);
                        ArchiveManifestResolverKt.logResolver("remote index cancelled package=" + id + " host=" + str2 + " elapsedMs=" + elapsedMs);
                        throw e;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    j = archiveManifestResolver$readRemoteIndex$1.J$0;
                    str2 = (String) archiveManifestResolver$readRemoteIndex$1.L$2;
                    String str3 = (String) archiveManifestResolver$readRemoteIndex$1.L$1;
                    originalTzArchivePackageDescriptor2 = (OriginalTzArchivePackageDescriptor) archiveManifestResolver$readRemoteIndex$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (CancellationException e3) {
                        e = e3;
                        String id2 = originalTzArchivePackageDescriptor2.getId();
                        elapsedMs = ArchiveManifestResolverKt.elapsedMs(j);
                        ArchiveManifestResolverKt.logResolver("remote index cancelled package=" + id2 + " host=" + str2 + " elapsedMs=" + elapsedMs);
                        throw e;
                    }
                }
                failure = (OriginalTzArchivePackageIndexResult) obj;
                if (failure == null) {
                    failure = new OriginalTzArchivePackageIndexResult.Failure(ArchiveManifestResolutionErrorCode.REMOTE_INDEX_UNAVAILABLE, "index read timed out");
                }
                if (!(failure instanceof OriginalTzArchivePackageIndexResult.Success)) {
                    name = FirebaseAnalytics.Param.SUCCESS;
                } else if (!(failure instanceof OriginalTzArchivePackageIndexResult.Failure)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    name = ((OriginalTzArchivePackageIndexResult.Failure) failure).getCode().name();
                }
                String id3 = originalTzArchivePackageDescriptor2.getId();
                elapsedMs2 = ArchiveManifestResolverKt.elapsedMs(j);
                ArchiveManifestResolverKt.logResolver("remote index done package=" + id3 + " host=" + str2 + " elapsedMs=" + elapsedMs2 + " result=" + name);
                return failure;
            }
        }
        archiveManifestResolver$readRemoteIndex$1 = new ArchiveManifestResolver$readRemoteIndex$1(this, continuation);
        Object obj2 = archiveManifestResolver$readRemoteIndex$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = archiveManifestResolver$readRemoteIndex$1.label;
        if (i != 0) {
        }
        failure = (OriginalTzArchivePackageIndexResult) obj2;
        if (failure == null) {
        }
        if (!(failure instanceof OriginalTzArchivePackageIndexResult.Success)) {
        }
        String id32 = originalTzArchivePackageDescriptor2.getId();
        elapsedMs2 = ArchiveManifestResolverKt.elapsedMs(j);
        ArchiveManifestResolverKt.logResolver("remote index done package=" + id32 + " host=" + str2 + " elapsedMs=" + elapsedMs2 + " result=" + name);
        return failure;
    }

    private final ArchivePackage resolvedPackage(OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor, OriginalTzArchivePackageIndex originalTzArchivePackageIndex) {
        return new ArchivePackage(originalTzArchivePackageDescriptor.getId(), ArchivePackageType.ARCHIVE, originalTzArchivePackageDescriptor.getUrl(), originalTzArchivePackageDescriptor.getArchiveSize(), originalTzArchivePackageIndex.getInstalledSize(), originalTzArchivePackageDescriptor.getCrc32(), originalTzArchivePackageIndex.getEntries(), false, originalTzArchivePackageDescriptor.getCentralDirectorySha256(), originalTzArchivePackageIndex.getCentralDirectorySha256(), originalTzArchivePackageIndex.getResolvedZipIndexMetadata(), 128, null);
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
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolver$Companion;", "", "<init>", "()V", "INDEX_FETCH_CONCURRENCY", "", "INDEX_READ_TIMEOUT_MS", "", "INDEX_HTTP_CALL_TIMEOUT_SECONDS", "create", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolver;", "context", "Landroid/content/Context;", "retryEnabled", "", "retryListener", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRangeRetryListener;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
            return new ArchiveManifestResolver(new RemoteOriginalTzArchivePackageIndexSource(new OkHttpArchiveByteRangeSource(new DownloadRetryPolicy(new DownloadRetryConfig(z, 0, 0L, 0L, 14, null), null, 2, null), new AndroidArchiveNetworkMonitor(context), retryListener, null, false, 30L, 24, null), null, false, 2, null), 0, 0L, 6, null);
        }
    }
}
