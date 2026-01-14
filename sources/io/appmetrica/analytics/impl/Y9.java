package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
/* loaded from: classes5.dex */
public final class Y9 {

    /* renamed from: a  reason: collision with root package name */
    public final File f865a;
    public FileLock b;
    public RandomAccessFile c;
    public FileChannel d;
    public int e;

    public Y9(Context context, String str) {
        this(a(context, str));
    }

    public final synchronized void a() {
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.f865a, "rw");
        this.c = randomAccessFile;
        FileChannel channel = randomAccessFile.getChannel();
        this.d = channel;
        if (this.e == 0) {
            this.b = channel.lock();
        }
        this.e++;
    }

    public final synchronized void b() {
        this.f865a.getAbsolutePath();
        int i = this.e - 1;
        this.e = i;
        if (i == 0) {
            Ja.a(this.b);
        }
        lo.a((Closeable) this.c);
        lo.a((Closeable) this.d);
        this.c = null;
        this.b = null;
        this.d = null;
    }

    public Y9(String str) {
        this(FileUtils.getFileFromPath(str + ".lock"));
    }

    public Y9(File file) {
        this.e = 0;
        this.f865a = file;
    }

    public static File a(Context context, String str) {
        File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(context, str + ".lock");
        if (fileFromSdkStorage != null) {
            return fileFromSdkStorage;
        }
        throw new IllegalStateException("Cannot create lock file");
    }
}
