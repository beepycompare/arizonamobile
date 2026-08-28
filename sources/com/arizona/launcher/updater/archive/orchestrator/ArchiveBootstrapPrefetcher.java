package com.arizona.launcher.updater.archive.orchestrator;

import android.content.Context;
import androidx.compose.runtime.ComposerKt;
import com.arizona.launcher.DownloadRetryConfig;
import com.arizona.launcher.DownloadRetryPolicy;
import com.arizona.launcher.updater.archive.download.AndroidArchiveNetworkMonitor;
import com.arizona.launcher.updater.archive.download.ArchiveDownloadRequest;
import com.arizona.launcher.updater.archive.download.ArchivePackageDownloadResult;
import com.arizona.launcher.updater.archive.download.ArchivePackageDownloader;
import com.arizona.launcher.updater.archive.download.FileArchiveDownloadResumeStore;
import com.arizona.launcher.updater.archive.io.AndroidArchiveDirectoryCreator;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchivePackageDescriptor;
import com.arizona.launcher.updater.archive.state.ArchivePackageIdentity;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;
/* compiled from: ArchiveBootstrapPrefetcher.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ$\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rÊ\u0001\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0017"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveBootstrapPrefetcher;", "", "downloadRoot", "Ljava/io/File;", "allowInsecureLoopback", "", "download", "Lkotlin/Function2;", "Lcom/arizona/launcher/updater/archive/download/ArchiveDownloadRequest;", "Lkotlin/coroutines/Continuation;", "Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadResult;", "<init>", "(Ljava/io/File;ZLkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "prefetch", "", "packages", "", "Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchivePackageDescriptor;", "serverBaseUrl", "", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveBootstrapPrefetcher {
    private final boolean allowInsecureLoopback;
    private final Function2<ArchiveDownloadRequest, Continuation<? super ArchivePackageDownloadResult>, Object> download;
    private final File downloadRoot;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public ArchiveBootstrapPrefetcher(File downloadRoot, boolean z, Function2<? super ArchiveDownloadRequest, ? super Continuation<? super ArchivePackageDownloadResult>, ? extends Object> download) {
        Intrinsics.checkNotNullParameter(downloadRoot, "downloadRoot");
        Intrinsics.checkNotNullParameter(download, "download");
        this.downloadRoot = downloadRoot;
        this.allowInsecureLoopback = z;
        this.download = download;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f3  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00d8 -> B:25:0x00dd). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object prefetch(List<OriginalTzArchivePackageDescriptor> list, String str, Continuation<? super Unit> continuation) {
        ArchiveBootstrapPrefetcher$prefetch$1 archiveBootstrapPrefetcher$prefetch$1;
        int i;
        Iterator<OriginalTzArchivePackageDescriptor> it;
        ArchiveBootstrapPrefetcher$prefetch$1 archiveBootstrapPrefetcher$prefetch$12;
        List<OriginalTzArchivePackageDescriptor> list2;
        String str2;
        if (continuation instanceof ArchiveBootstrapPrefetcher$prefetch$1) {
            archiveBootstrapPrefetcher$prefetch$1 = (ArchiveBootstrapPrefetcher$prefetch$1) continuation;
            if ((archiveBootstrapPrefetcher$prefetch$1.label & Integer.MIN_VALUE) != 0) {
                archiveBootstrapPrefetcher$prefetch$1.label -= Integer.MIN_VALUE;
                Object obj = archiveBootstrapPrefetcher$prefetch$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = archiveBootstrapPrefetcher$prefetch$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    it = list.iterator();
                    archiveBootstrapPrefetcher$prefetch$12 = archiveBootstrapPrefetcher$prefetch$1;
                    list2 = list;
                    str2 = str;
                    if (!it.hasNext()) {
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ArchivePackageIdentity archivePackageIdentity = (ArchivePackageIdentity) archiveBootstrapPrefetcher$prefetch$1.L$5;
                    String str3 = (String) archiveBootstrapPrefetcher$prefetch$1.L$4;
                    OriginalTzArchivePackageDescriptor originalTzArchivePackageDescriptor = (OriginalTzArchivePackageDescriptor) archiveBootstrapPrefetcher$prefetch$1.L$3;
                    Iterator<OriginalTzArchivePackageDescriptor> it2 = (Iterator) archiveBootstrapPrefetcher$prefetch$1.L$2;
                    List<OriginalTzArchivePackageDescriptor> list3 = (List) archiveBootstrapPrefetcher$prefetch$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    archiveBootstrapPrefetcher$prefetch$12 = archiveBootstrapPrefetcher$prefetch$1;
                    str2 = (String) archiveBootstrapPrefetcher$prefetch$1.L$1;
                    it = it2;
                    ArchivePackageDownloadResult archivePackageDownloadResult = (ArchivePackageDownloadResult) obj;
                    if (archivePackageDownloadResult instanceof ArchivePackageDownloadResult.Success) {
                        if (archivePackageDownloadResult instanceof ArchivePackageDownloadResult.Failure) {
                            return Unit.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    list2 = list3;
                    if (!it.hasNext()) {
                        OriginalTzArchivePackageDescriptor next = it.next();
                        JobKt.ensureActive(archiveBootstrapPrefetcher$prefetch$12.getContext());
                        String resolve = ArchivePackageUrlResolver.INSTANCE.resolve(str2, next.getUrl(), this.allowInsecureLoopback);
                        if (resolve == null) {
                            return Unit.INSTANCE;
                        }
                        ArchivePackageIdentity archivePackageIdentity2 = new ArchivePackageIdentity(next.getId(), next.getArchiveSize(), next.getCrc32());
                        Function2<ArchiveDownloadRequest, Continuation<? super ArchivePackageDownloadResult>, Object> function2 = this.download;
                        ArchiveDownloadRequest archiveDownloadRequest = new ArchiveDownloadRequest(next.getId(), resolve, ArchivePackagePaths.INSTANCE.archiveFile(this.downloadRoot, archivePackageIdentity2), next.getArchiveSize(), next.getCrc32());
                        archiveBootstrapPrefetcher$prefetch$12.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                        archiveBootstrapPrefetcher$prefetch$12.L$1 = str2;
                        archiveBootstrapPrefetcher$prefetch$12.L$2 = it;
                        archiveBootstrapPrefetcher$prefetch$12.L$3 = SpillingKt.nullOutSpilledVariable(next);
                        archiveBootstrapPrefetcher$prefetch$12.L$4 = SpillingKt.nullOutSpilledVariable(resolve);
                        archiveBootstrapPrefetcher$prefetch$12.L$5 = SpillingKt.nullOutSpilledVariable(archivePackageIdentity2);
                        archiveBootstrapPrefetcher$prefetch$12.label = 1;
                        Object invoke = function2.invoke(archiveDownloadRequest, archiveBootstrapPrefetcher$prefetch$12);
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        list3 = list2;
                        obj = invoke;
                        ArchivePackageDownloadResult archivePackageDownloadResult2 = (ArchivePackageDownloadResult) obj;
                        if (archivePackageDownloadResult2 instanceof ArchivePackageDownloadResult.Success) {
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                }
            }
        }
        archiveBootstrapPrefetcher$prefetch$1 = new ArchiveBootstrapPrefetcher$prefetch$1(this, continuation);
        Object obj2 = archiveBootstrapPrefetcher$prefetch$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = archiveBootstrapPrefetcher$prefetch$1.label;
        if (i != 0) {
        }
    }

    /* compiled from: ArchiveBootstrapPrefetcher.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveBootstrapPrefetcher$Companion;", "", "<init>", "()V", "forAndroid", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveBootstrapPrefetcher;", "context", "Landroid/content/Context;", "retryEnabled", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArchiveBootstrapPrefetcher forAndroid(Context context, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            return new ArchiveBootstrapPrefetcher(new File(externalCacheDir, "archive-updater/downloads"), false, new ArchiveBootstrapPrefetcher$Companion$forAndroid$1(new ArchivePackageDownloader(new DownloadRetryPolicy(new DownloadRetryConfig(z, 0, 0L, 0L, 14, null), null, 2, null), new AndroidArchiveNetworkMonitor(context), 0L, null, false, FileArchiveDownloadResumeStore.Companion.forAndroid(), null, 0L, AndroidArchiveDirectoryCreator.INSTANCE, ComposerKt.providerMapsKey, null)));
        }
    }
}
