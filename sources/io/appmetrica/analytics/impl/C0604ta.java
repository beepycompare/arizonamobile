package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
/* renamed from: io.appmetrica.analytics.impl.ta  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0604ta {

    /* renamed from: a  reason: collision with root package name */
    public final File f1064a;
    public FileLock b;
    public RandomAccessFile c;
    public FileChannel d;
    public int e;

    public C0604ta(Context context, String str) {
        this(a(context, str));
    }

    public final synchronized void a() {
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.f1064a, "rw");
        this.c = randomAccessFile;
        FileChannel channel = randomAccessFile.getChannel();
        this.d = channel;
        if (this.e == 0) {
            this.b = channel.lock();
        }
        this.e++;
    }

    public final synchronized void b() {
        this.f1064a.getAbsolutePath();
        int i = this.e - 1;
        this.e = i;
        if (i == 0) {
            AbstractC0230eb.a(this.b);
        }
        io.a((Closeable) this.c);
        io.a((Closeable) this.d);
        this.c = null;
        this.b = null;
        this.d = null;
    }

    public C0604ta(String str) {
        this(FileUtils.getFileFromPath(str + ".lock"));
    }

    public C0604ta(File file) {
        this.e = 0;
        this.f1064a = file;
    }

    public static File a(Context context, String str) {
        File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(context, str + ".lock");
        if (fileFromSdkStorage != null) {
            return fileFromSdkStorage;
        }
        throw new IllegalStateException("Cannot create lock file");
    }
}
