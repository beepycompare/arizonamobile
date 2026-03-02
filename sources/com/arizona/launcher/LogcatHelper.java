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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
/* compiled from: LogcatHelper.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0002\u000f\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000eR\u0014\u0010\u0006\u001a\b\u0018\u00010\u0007R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/LogcatHelper;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mLogDumper", "Lcom/arizona/launcher/LogcatHelper$LogDumper;", "mPId", "", "init", "", TtmlNode.START, "clean", "", "LogDumper", "Companion", "app"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LogcatHelper {
    private static LogcatHelper INSTANCE;
    private static String PATH_LOGCAT;
    private LogDumper mLogDumper;
    private final int mPId;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ LogcatHelper(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private LogcatHelper(Context context) {
        init(context);
        this.mPId = Process.myPid();
    }

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File externalFilesDir = context.getExternalFilesDir(null);
        PATH_LOGCAT = (externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null) + "/logcat";
        String str = PATH_LOGCAT;
        Intrinsics.checkNotNull(str);
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public final void start() {
        if (this.mLogDumper == null) {
            this.mLogDumper = new LogDumper(this, String.valueOf(this.mPId));
        }
        try {
            LogDumper logDumper = this.mLogDumper;
            if (logDumper != null) {
                logDumper.start();
            }
        } catch (IllegalThreadStateException e) {
            e.printStackTrace();
        }
    }

    public final void clean(boolean z) {
        String str = PATH_LOGCAT;
        File file = new File(str, "samp.log");
        int i = z ? 512 : 64;
        if (file.exists()) {
            if (file.length() > i * 1048576) {
                file.delete();
            } else if (file.length() > (i / 2) * 1048576) {
                try {
                    File file2 = new File(str, "samp.log.tmp");
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
                        for (String str2 : SequencesKt.drop(TextStreamsKt.lineSequence(bufferedReader2), i2)) {
                            bufferedWriter2.write(str2);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LogcatHelper.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/LogcatHelper$LogDumper;", "Ljava/lang/Thread;", "mPID", "", "<init>", "(Lcom/arizona/launcher/LogcatHelper;Ljava/lang/String;)V", "dir", "logcatProc", "Ljava/lang/Process;", "mRunning", "", "command", "getCommand", "()Ljava/lang/String;", "setCommand", "(Ljava/lang/String;)V", "out", "Ljava/io/FileOutputStream;", TtmlNode.START, "", "run", "app"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class LogDumper extends Thread {
        private String command;
        private String dir;
        private Process logcatProc;
        private final String mPID;
        private boolean mRunning;
        private FileOutputStream out;
        final /* synthetic */ LogcatHelper this$0;

        public LogDumper(LogcatHelper logcatHelper, String mPID) {
            Intrinsics.checkNotNullParameter(mPID, "mPID");
            this.this$0 = logcatHelper;
            this.mPID = mPID;
            this.dir = LogcatHelper.PATH_LOGCAT;
            File file = new File(this.dir, "samp.log");
            logcatHelper.clean(true);
            try {
                this.out = new FileOutputStream(file, true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            this.command = "logcat --pid=" + this.mPID;
        }

        public final String getCommand() {
            return this.command;
        }

        public final void setCommand(String str) {
            this.command = str;
        }

        @Override // java.lang.Thread
        public void start() {
            super.start();
            this.mRunning = true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0088, code lost:
            r4.flush();
            r0 = kotlin.Unit.INSTANCE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x008e, code lost:
            r0 = kotlin.Unit.INSTANCE;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            String readLine;
            try {
                Process exec = Runtime.getRuntime().exec(this.command);
                this.logcatProc = exec;
                try {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream(), Charsets.UTF_8), 4096);
                        FileOutputStream fileOutputStream = this.out;
                        BufferedWriter bufferedWriter = fileOutputStream != null ? new BufferedWriter(new OutputStreamWriter(fileOutputStream, Charsets.UTF_8), 8192) : null;
                        while (this.mRunning && (readLine = bufferedReader.readLine()) != null && readLine != null) {
                            try {
                                if (readLine.length() != 0 && !StringsKt.contains$default((CharSequence) readLine, (CharSequence) "AudioTrack", false, 2, (Object) null) && bufferedWriter != null && StringsKt.contains$default((CharSequence) readLine, (CharSequence) this.mPID, false, 2, (Object) null)) {
                                    if (readLine.length() > 8192) {
                                        readLine = readLine.substring(0, 8192);
                                        Intrinsics.checkNotNullExpressionValue(readLine, "substring(...)");
                                    }
                                    bufferedWriter.write(readLine);
                                    bufferedWriter.newLine();
                                }
                            } finally {
                                try {
                                    bufferedReader.close();
                                } catch (IOException unused) {
                                }
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                            }
                        }
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException unused3) {
                            }
                        }
                        try {
                            Process process = this.logcatProc;
                            if (process != null) {
                                process.destroy();
                            }
                        } catch (Throwable unused4) {
                        }
                        this.logcatProc = null;
                    } catch (IOException e) {
                        e.printStackTrace();
                        try {
                            Process process2 = this.logcatProc;
                            if (process2 != null) {
                                process2.destroy();
                            }
                        } catch (Throwable unused5) {
                        }
                        this.logcatProc = null;
                        try {
                            FileOutputStream fileOutputStream2 = this.out;
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                        } catch (IOException e2) {
                            e = e2;
                            e.printStackTrace();
                            this.out = null;
                        }
                    }
                    try {
                        FileOutputStream fileOutputStream3 = this.out;
                        if (fileOutputStream3 != null) {
                            fileOutputStream3.close();
                        }
                    } catch (IOException e3) {
                        e = e3;
                        e.printStackTrace();
                        this.out = null;
                    }
                    this.out = null;
                } catch (Throwable th) {
                    try {
                        Process process3 = this.logcatProc;
                        if (process3 != null) {
                            process3.destroy();
                        }
                    } catch (Throwable unused6) {
                    }
                    this.logcatProc = null;
                    try {
                        FileOutputStream fileOutputStream4 = this.out;
                        if (fileOutputStream4 != null) {
                            fileOutputStream4.close();
                        }
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    this.out = null;
                    throw th;
                }
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
    }

    /* compiled from: LogcatHelper.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/arizona/launcher/LogcatHelper$Companion;", "", "<init>", "()V", "INSTANCE", "Lcom/arizona/launcher/LogcatHelper;", "PATH_LOGCAT", "", "getInstance", "context", "Landroid/content/Context;", "app"}, k = 1, mv = {2, 3, 0}, xi = 48)
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
