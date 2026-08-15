package com.arizona.launcher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.arizona.launcher.LogcatHelper;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: LogShareHelper.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007b\u0002\b\u0013J\u0014\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007b\u0002\b\u0013J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\r2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\rH\u0002J \u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u0018\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0005H\u0002J&\u0010#\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00170\r2\u0006\u0010%\u001a\u00020&H\u0002J\u0018\u0010'\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\rX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b+\u0012\b\b,\u0012\u0004\b\u0003\u0010\u0002¨\u0006*"}, d2 = {"Lcom/arizona/launcher/LogShareHelper;", "", "<init>", "()V", "RECENT_LOG_SHARE_LIMIT_BYTES", "", "RECENT_SHARE_DIR", "", "COPY_BUFFER_SIZE", "", "isPreparingRecentShare", "Ljava/util/concurrent/atomic/AtomicBoolean;", "fullLogPaths", "", "recentLogPaths", "shareAllLogs", "", "activity", "Landroid/app/Activity;", "Lkotlin/jvm/JvmStatic;", "shareRecentLogs", "flushCurrentLog", "createRecentLogCopies", "Ljava/io/File;", "maxTotalBytes", "resolveLogFiles", "relativePaths", "copyTail", "sourceFile", "outputFile", "maxBytes", "skipPartialFirstLine", "input", "Ljava/io/RandomAccessFile;", "sourceLength", "shareFiles", OriginalTzArchiveManifestParser.FILES_ROOT, "showEmptyMessage", "", "showError", "error", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LogShareHelper {
    public static final int $stable = 0;
    private static final int COPY_BUFFER_SIZE = 16384;
    public static final long RECENT_LOG_SHARE_LIMIT_BYTES = 2097152;
    private static final String RECENT_SHARE_DIR = "recent-log-share";
    public static final LogShareHelper INSTANCE = new LogShareHelper();
    private static final AtomicBoolean isPreparingRecentShare = new AtomicBoolean(false);
    private static final List<String> fullLogPaths = CollectionsKt.listOf((Object[]) new String[]{"logcat/samp.log", "logcat/crashes.log", "AZVoice/azvoice.log", "logcat/client.log"});
    private static final List<String> recentLogPaths = CollectionsKt.listOf((Object[]) new String[]{"logcat/crashes.log", "AZVoice/azvoice.log", "logcat/client.log", "logcat/samp.log"});

    private LogShareHelper() {
    }

    @JvmStatic
    public static final void shareAllLogs(Activity activity) {
        Object m9916constructorimpl;
        Intrinsics.checkNotNullParameter(activity, "activity");
        LogShareHelper logShareHelper = INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            logShareHelper.flushCurrentLog(activity);
            logShareHelper.shareFiles(activity, logShareHelper.resolveLogFiles(activity, fullLogPaths), false);
            m9916constructorimpl = Result.m9916constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9916constructorimpl = Result.m9916constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m9919exceptionOrNullimpl = Result.m9919exceptionOrNullimpl(m9916constructorimpl);
        if (m9919exceptionOrNullimpl != null) {
            INSTANCE.showError(activity, m9919exceptionOrNullimpl);
        }
    }

    @JvmStatic
    public static final void shareRecentLogs(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (isPreparingRecentShare.compareAndSet(false, true)) {
            ThreadsKt.thread$default(false, true, null, "RecentLogShare", 0, new Function0() { // from class: com.arizona.launcher.LogShareHelper$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LogShareHelper.shareRecentLogs$lambda$0(activity);
                }
            }, 21, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit shareRecentLogs$lambda$0(final Activity activity) {
        final Object m9916constructorimpl;
        LogShareHelper logShareHelper = INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            logShareHelper.flushCurrentLog(activity);
            m9916constructorimpl = Result.m9916constructorimpl(logShareHelper.createRecentLogCopies(activity, 2097152L));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9916constructorimpl = Result.m9916constructorimpl(ResultKt.createFailure(th));
        }
        activity.runOnUiThread(new Runnable() { // from class: com.arizona.launcher.LogShareHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LogShareHelper.shareRecentLogs$lambda$0$1(activity, m9916constructorimpl);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void shareRecentLogs$lambda$0$1(Activity activity, Object obj) {
        Object m9916constructorimpl;
        isPreparingRecentShare.set(false);
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        if (Result.m9923isSuccessimpl(obj)) {
            List<? extends File> list = (List) obj;
            LogShareHelper logShareHelper = INSTANCE;
            try {
                Result.Companion companion = Result.Companion;
                logShareHelper.shareFiles(activity, list, true);
                m9916constructorimpl = Result.m9916constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m9916constructorimpl = Result.m9916constructorimpl(ResultKt.createFailure(th));
            }
            Throwable m9919exceptionOrNullimpl = Result.m9919exceptionOrNullimpl(m9916constructorimpl);
            if (m9919exceptionOrNullimpl != null) {
                INSTANCE.showError(activity, m9919exceptionOrNullimpl);
            }
        }
        Throwable m9919exceptionOrNullimpl2 = Result.m9919exceptionOrNullimpl(obj);
        if (m9919exceptionOrNullimpl2 != null) {
            INSTANCE.showError(activity, m9919exceptionOrNullimpl2);
        }
    }

    private final void flushCurrentLog(Activity activity) {
        LogcatHelper.Companion companion = LogcatHelper.Companion;
        Context applicationContext = activity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        LogcatHelper companion2 = companion.getInstance(applicationContext);
        if (companion2 != null) {
            companion2.flush();
        }
    }

    private final List<File> createRecentLogCopies(Activity activity, long j) {
        File externalFilesDir = activity.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return CollectionsKt.emptyList();
        }
        List<File> resolveLogFiles = resolveLogFiles(activity, recentLogPaths);
        if (resolveLogFiles.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        File file = new File(externalFilesDir, RECENT_SHARE_DIR);
        if (file.isDirectory() || file.mkdirs()) {
            File[] listFiles = file.listFiles();
            int i = 0;
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
            List createListBuilder = CollectionsKt.createListBuilder();
            for (Object obj : resolveLogFiles) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                File file3 = (File) obj;
                long size = j / (resolveLogFiles.size() - i);
                if (size > 0) {
                    File file4 = new File(file, "recent_" + file3.getName());
                    INSTANCE.copyTail(file3, file4, size);
                    long length = file4.length();
                    if (length > 0) {
                        createListBuilder.add(file4);
                        j -= length;
                    } else {
                        file4.delete();
                    }
                }
                i = i2;
            }
            return CollectionsKt.build(createListBuilder);
        }
        throw new IllegalStateException("Не удалось создать папку для отправки логов".toString());
    }

    private final List<File> resolveLogFiles(Activity activity, List<String> list) {
        File externalFilesDir = activity.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return CollectionsKt.emptyList();
        }
        List<String> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (String str : list2) {
            arrayList.add(new File(externalFilesDir, str));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            File file = (File) obj;
            if (file.isFile() && file.length() > 0) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    private final void copyTail(File file, File file2, long j) {
        int read;
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            RandomAccessFile randomAccessFile2 = randomAccessFile;
            long length = randomAccessFile2.length();
            long coerceAtLeast = RangesKt.coerceAtLeast(length - j, 0L);
            randomAccessFile2.seek(coerceAtLeast);
            if (coerceAtLeast > 0) {
                INSTANCE.skipPartialFirstLine(randomAccessFile2, length);
            }
            long coerceAtMost = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(length - randomAccessFile2.getFilePointer(), 0L), j);
            FileOutputStream fileOutputStream = new FileOutputStream(file2, false);
            FileOutputStream fileOutputStream2 = fileOutputStream;
            byte[] bArr = new byte[16384];
            while (coerceAtMost > 0 && (read = randomAccessFile2.read(bArr, 0, (int) Math.min(16384L, coerceAtMost))) > 0) {
                fileOutputStream2.write(bArr, 0, read);
                coerceAtMost -= read;
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
            Unit unit2 = Unit.INSTANCE;
            CloseableKt.closeFinally(randomAccessFile, null);
        } finally {
        }
    }

    private final void skipPartialFirstLine(RandomAccessFile randomAccessFile, long j) {
        while (randomAccessFile.getFilePointer() < j && randomAccessFile.read() != 10) {
        }
    }

    private final void shareFiles(Activity activity, List<? extends File> list, boolean z) {
        if (list.isEmpty()) {
            if (z) {
                Toast.makeText(activity, "Логи для отправки не найдены", 0).show();
                return;
            }
            return;
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(list.size());
        for (File file : list) {
            arrayList.add(FileProvider.getUriForFile(activity, "com.arizona21.game.fileprovider", file));
        }
        Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        intent.setType("*/*");
        intent.addFlags(1);
        activity.startActivity(Intent.createChooser(intent, "Отправить логи"));
    }

    private final void showError(Activity activity, Throwable th) {
        Activity activity2 = activity;
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        Toast.makeText(activity2, "Не удалось подготовить логи: " + message, 1).show();
    }
}
