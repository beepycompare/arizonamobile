package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
/* renamed from: io.appmetrica.analytics.impl.ua  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0634ua {

    /* renamed from: a  reason: collision with root package name */
    public final File f1231a;
    public FileLock b;
    public RandomAccessFile c;
    public FileChannel d;
    public int e;

    public C0634ua(Context context, String str) {
        this(a(context, str));
    }

    public final synchronized void a() {
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.f1231a, "rw");
        this.c = randomAccessFile;
        FileChannel channel = randomAccessFile.getChannel();
        this.d = channel;
        if (this.e == 0) {
            this.b = channel.lock();
        }
        this.e++;
    }

    public final synchronized void b() {
        this.f1231a.getAbsolutePath();
        int i = this.e - 1;
        this.e = i;
        if (i == 0) {
            AbstractC0402lb.a(this.b);
        }
        Oo.a((Closeable) this.c);
        Oo.a((Closeable) this.d);
        this.c = null;
        this.b = null;
        this.d = null;
    }

    public C0634ua(String str) {
        this(FileUtils.getFileFromPath(str + ".lock"));
    }

    public C0634ua(File file) {
        this.e = 0;
        this.f1231a = file;
    }

    public static File a(Context context, String str) {
        File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(context, str + ".lock");
        if (fileFromSdkStorage != null) {
            return fileFromSdkStorage;
        }
        throw new IllegalStateException("Cannot create lock file");
    }
}
