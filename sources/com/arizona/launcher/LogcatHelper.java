package com.arizona.launcher;

import android.content.Context;
import android.os.Process;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
/* compiled from: LogcatHelper.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0007\u0018\u0000 &2\u00020\u0001:\u0003$%&B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\u000fH\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\fH\u0002J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010#\u001a\u00020\fH\u0002R\u0014\u0010\u0006\u001a\b\u0018\u00010\u0007R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/arizona/launcher/LogcatHelper;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mLogDumper", "Lcom/arizona/launcher/LogcatHelper$LogDumper;", "mPId", "", "recentLogLines", "Ljava/util/ArrayDeque;", "", "recentLogLinesLock", "init", "", TtmlNode.START, "clean", "", "cleanCrashLog", "cleanFile", "fileName", "maxSizeMb", "installCrashHandler", "recordRecentLine", "line", "getRecentLinesSnapshot", "", "writeCrashReport", "thread", "Ljava/lang/Thread;", "throwable", "", "buildCrashReport", "appendReport", "report", "LogDumper", "CrashFileUncaughtExceptionHandler", "Companion", "app"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LogcatHelper {
    private static final int CRASH_BUFFER_LINES = 100;
    private static final String CRASH_LOG_FILE_NAME = "crashes.log";
    private static final String CRASH_SECTION_DIVIDER = "==================== APP CRASH ====================";
    private static LogcatHelper INSTANCE = null;
    private static final String MAIN_LOG_FILE_NAME = "samp.log";
    private static String PATH_LOGCAT;
    private LogDumper mLogDumper;
    private final int mPId;
    private final ArrayDeque<String> recentLogLines;
    private final Object recentLogLinesLock;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ LogcatHelper(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private LogcatHelper(Context context) {
        this.recentLogLines = new ArrayDeque<>(100);
        this.recentLogLinesLock = new Object();
        init(context);
        this.mPId = Process.myPid();
    }

    public final void init(Context context) {
        String absolutePath;
        Intrinsics.checkNotNullParameter(context, "context");
        String str = null;
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null && (absolutePath = externalFilesDir.getAbsolutePath()) != null) {
            str = absolutePath + "/logcat";
        }
        PATH_LOGCAT = str;
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x001f, code lost:
        if ((r0 != null ? r0.getState() : null) == java.lang.Thread.State.TERMINATED) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void start() {
        installCrashHandler();
        LogDumper logDumper = this.mLogDumper;
        if (logDumper == null || !logDumper.isAlive()) {
            LogDumper logDumper2 = this.mLogDumper;
            if (logDumper2 != null) {
            }
            this.mLogDumper = new LogDumper(this, String.valueOf(this.mPId));
            try {
                LogDumper logDumper3 = this.mLogDumper;
                if (logDumper3 != null) {
                    logDumper3.start();
                }
            } catch (IllegalThreadStateException e) {
                e.printStackTrace();
            }
        }
    }

    public final void clean(boolean z) {
        cleanFile(MAIN_LOG_FILE_NAME, z ? 512 : 64);
    }

    private final void cleanCrashLog() {
        cleanFile(CRASH_LOG_FILE_NAME, 16);
    }

    private final void cleanFile(String str, int i) {
        String str2 = PATH_LOGCAT;
        if (str2 == null) {
            return;
        }
        File file = new File(str2, str);
        File file2 = new File(str2, str + ".tmp");
        if (file.exists()) {
            if (file.length() > i * 1048576) {
                file.delete();
            } else if (file.length() > (i / 2) * 1048576) {
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), Charsets.UTF_8);
                    BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                    int count = SequencesKt.count(TextStreamsKt.lineSequence(bufferedReader));
                    CloseableKt.closeFinally(bufferedReader, null);
                    int i2 = count / 2;
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file2), Charsets.UTF_8);
                    BufferedWriter bufferedWriter = outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
                    BufferedWriter bufferedWriter2 = bufferedWriter;
                    InputStreamReader inputStreamReader2 = new InputStreamReader(new FileInputStream(file), Charsets.UTF_8);
                    BufferedReader bufferedReader2 = inputStreamReader2 instanceof BufferedReader ? (BufferedReader) inputStreamReader2 : new BufferedReader(inputStreamReader2, 8192);
                    try {
                        for (String str3 : SequencesKt.drop(TextStreamsKt.lineSequence(bufferedReader2), i2)) {
                            bufferedWriter2.write(str3);
                            bufferedWriter2.newLine();
                        }
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(bufferedReader2, null);
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(bufferedWriter, null);
                        if (file.delete()) {
                            if (file2.renameTo(file)) {
                                return;
                            }
                            System.out.println((Object) "The temporary file could not be renamed.");
                            return;
                        }
                        System.out.println((Object) "The temporary file could not be removed.");
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(bufferedReader2, th);
                            throw th2;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private final void installCrashHandler() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof CrashFileUncaughtExceptionHandler) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new CrashFileUncaughtExceptionHandler(defaultUncaughtExceptionHandler));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordRecentLine(String str) {
        synchronized (this.recentLogLinesLock) {
            if (this.recentLogLines.size() == 100) {
                this.recentLogLines.removeFirst();
            }
            this.recentLogLines.addLast(str);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final List<String> getRecentLinesSnapshot() {
        List<String> list;
        synchronized (this.recentLogLinesLock) {
            list = CollectionsKt.toList(this.recentLogLines);
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeCrashReport(Thread thread, Throwable th) {
        cleanCrashLog();
        LogDumper logDumper = this.mLogDumper;
        if (logDumper != null) {
            logDumper.flush();
        }
        String buildCrashReport = buildCrashReport(thread, th);
        appendReport(MAIN_LOG_FILE_NAME, buildCrashReport);
        appendReport(CRASH_LOG_FILE_NAME, buildCrashReport);
    }

    private final String buildCrashReport(Thread thread, Throwable th) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US).format(new Date());
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            th.printStackTrace(printWriter);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(printWriter, null);
            List<String> recentLinesSnapshot = getRecentLinesSnapshot();
            StringBuilder sb = new StringBuilder("\n==================== APP CRASH ====================\n");
            sb.append("CRASH TIME: " + format).append('\n');
            sb.append("THREAD: " + thread.getName()).append('\n');
            sb.append("TYPE: " + th.getClass().getName()).append('\n');
            String message = th.getMessage();
            if (message == null) {
                message = "no message";
            }
            sb.append("MESSAGE: " + message).append("\n\nSTACKTRACE:\n");
            String stringWriter2 = stringWriter.toString();
            Intrinsics.checkNotNullExpressionValue(stringWriter2, "toString(...)");
            sb.append(StringsKt.trimEnd((CharSequence) stringWriter2).toString()).append("\n\nLAST 100 LOG LINES BEFORE CRASH:\n");
            if (recentLinesSnapshot.isEmpty()) {
                sb.append("No buffered log lines\n");
            } else {
                for (String str : recentLinesSnapshot) {
                    sb.append(str).append('\n');
                }
            }
            sb.append("==================== APP CRASH ====================\n");
            return sb.toString();
        } finally {
        }
    }

    private final void appendReport(String str, String str2) {
        String str3 = PATH_LOGCAT;
        if (str3 == null) {
            return;
        }
        File file = new File(str3, str);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file, true), Charsets.UTF_8);
            BufferedWriter bufferedWriter = outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
            bufferedWriter.write(str2);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedWriter, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LogcatHelper.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0014\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/LogcatHelper$LogDumper;", "Ljava/lang/Thread;", "mPID", "", "<init>", "(Lcom/arizona/launcher/LogcatHelper;Ljava/lang/String;)V", "logcatProc", "Ljava/lang/Process;", "mRunning", "", "command", "out", "Ljava/io/FileOutputStream;", "writer", "Ljava/io/BufferedWriter;", "writerLock", "", TtmlNode.START, "", "flush", "run", "app"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class LogDumper extends Thread {
        private final String command;
        private Process logcatProc;
        private final String mPID;
        private boolean mRunning;
        private FileOutputStream out;
        final /* synthetic */ LogcatHelper this$0;
        private BufferedWriter writer;
        private final Object writerLock;

        public LogDumper(LogcatHelper logcatHelper, String mPID) {
            Intrinsics.checkNotNullParameter(mPID, "mPID");
            this.this$0 = logcatHelper;
            this.mPID = mPID;
            this.command = "logcat --pid=" + mPID;
            this.writerLock = new Object();
            logcatHelper.clean(true);
            String str = LogcatHelper.PATH_LOGCAT;
            if (str != null) {
                try {
                    this.out = new FileOutputStream(new File(str, LogcatHelper.MAIN_LOG_FILE_NAME), true);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // java.lang.Thread
        public void start() {
            super.start();
            this.mRunning = true;
        }

        public final void flush() {
            synchronized (this.writerLock) {
                try {
                    BufferedWriter bufferedWriter = this.writer;
                    if (bufferedWriter != null) {
                        bufferedWriter.flush();
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (IOException unused) {
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String readLine;
            try {
                Process exec = Runtime.getRuntime().exec(this.command);
                this.logcatProc = exec;
                try {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream(), Charsets.UTF_8), 4096);
                        FileOutputStream fileOutputStream = this.out;
                        this.writer = fileOutputStream != null ? new BufferedWriter(new OutputStreamWriter(fileOutputStream, Charsets.UTF_8), 8192) : null;
                        while (this.mRunning && (readLine = bufferedReader.readLine()) != null && readLine != null) {
                            try {
                                if (readLine.length() != 0 && !StringsKt.contains$default((CharSequence) readLine, (CharSequence) "AudioTrack", false, 2, (Object) null) && this.writer != null && StringsKt.contains$default((CharSequence) readLine, (CharSequence) this.mPID, false, 2, (Object) null)) {
                                    if (readLine.length() > 8192) {
                                        readLine = readLine.substring(0, 8192);
                                        Intrinsics.checkNotNullExpressionValue(readLine, "substring(...)");
                                    }
                                    synchronized (this.writerLock) {
                                        BufferedWriter bufferedWriter = this.writer;
                                        if (bufferedWriter != null) {
                                            bufferedWriter.write(readLine);
                                        }
                                        BufferedWriter bufferedWriter2 = this.writer;
                                        if (bufferedWriter2 != null) {
                                            bufferedWriter2.newLine();
                                            Unit unit = Unit.INSTANCE;
                                        }
                                    }
                                    this.this$0.recordRecentLine(readLine);
                                }
                            } catch (Throwable th) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException unused) {
                                }
                                synchronized (this.writerLock) {
                                    try {
                                        BufferedWriter bufferedWriter3 = this.writer;
                                        if (bufferedWriter3 != null) {
                                            bufferedWriter3.close();
                                        }
                                    } catch (IOException unused2) {
                                    }
                                    this.writer = null;
                                    Unit unit2 = Unit.INSTANCE;
                                    throw th;
                                }
                            }
                        }
                        flush();
                        try {
                            bufferedReader.close();
                        } catch (IOException unused3) {
                        }
                        synchronized (this.writerLock) {
                            try {
                                BufferedWriter bufferedWriter4 = this.writer;
                                if (bufferedWriter4 != null) {
                                    bufferedWriter4.close();
                                }
                            } catch (IOException unused4) {
                            }
                            this.writer = null;
                            Unit unit3 = Unit.INSTANCE;
                        }
                        try {
                            Process process = this.logcatProc;
                            if (process != null) {
                                process.destroy();
                            }
                        } catch (Throwable unused5) {
                        }
                        this.logcatProc = null;
                        try {
                            FileOutputStream fileOutputStream2 = this.out;
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                        } catch (IOException e) {
                            e = e;
                            e.printStackTrace();
                            this.out = null;
                        }
                    } catch (Throwable th2) {
                        try {
                            Process process2 = this.logcatProc;
                            if (process2 != null) {
                                process2.destroy();
                            }
                        } catch (Throwable unused6) {
                        }
                        this.logcatProc = null;
                        try {
                            FileOutputStream fileOutputStream3 = this.out;
                            if (fileOutputStream3 != null) {
                                fileOutputStream3.close();
                            }
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        this.out = null;
                        throw th2;
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                    try {
                        Process process3 = this.logcatProc;
                        if (process3 != null) {
                            process3.destroy();
                        }
                    } catch (Throwable unused7) {
                    }
                    this.logcatProc = null;
                    try {
                        FileOutputStream fileOutputStream4 = this.out;
                        if (fileOutputStream4 != null) {
                            fileOutputStream4.close();
                        }
                    } catch (IOException e4) {
                        e = e4;
                        e.printStackTrace();
                        this.out = null;
                    }
                }
                this.out = null;
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LogcatHelper.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/arizona/launcher/LogcatHelper$CrashFileUncaughtExceptionHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "delegate", "<init>", "(Lcom/arizona/launcher/LogcatHelper;Ljava/lang/Thread$UncaughtExceptionHandler;)V", "uncaughtException", "", "thread", "Ljava/lang/Thread;", "throwable", "", "app"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class CrashFileUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        private final Thread.UncaughtExceptionHandler delegate;

        public CrashFileUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.delegate = uncaughtExceptionHandler;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable throwable) {
            Intrinsics.checkNotNullParameter(thread, "thread");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            try {
                LogcatHelper.this.writeCrashReport(thread, throwable);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.delegate;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, throwable);
                return;
            }
            throwable.printStackTrace();
            Process.killProcess(Process.myPid());
            System.exit(10);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
    }

    /* compiled from: LogcatHelper.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/arizona/launcher/LogcatHelper$Companion;", "", "<init>", "()V", "MAIN_LOG_FILE_NAME", "", "CRASH_LOG_FILE_NAME", "CRASH_BUFFER_LINES", "", "CRASH_SECTION_DIVIDER", "INSTANCE", "Lcom/arizona/launcher/LogcatHelper;", "PATH_LOGCAT", "getInstance", "context", "Landroid/content/Context;", "app"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LogcatHelper getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (LogcatHelper.INSTANCE == null) {
                LogcatHelper.INSTANCE = new LogcatHelper(context, null);
            }
            return LogcatHelper.INSTANCE;
        }
    }
}
