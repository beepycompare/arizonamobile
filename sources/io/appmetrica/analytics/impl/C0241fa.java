package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
/* renamed from: io.appmetrica.analytics.impl.fa  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0241fa {

    /* renamed from: a  reason: collision with root package name */
    public final File f874a;
    public FileLock b;
    public RandomAccessFile c;
    public FileChannel d;
    public int e;

    public C0241fa(Context context, String str) {
        this(a(context, str));
    }

    public final synchronized void a() {
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.f874a, "rw");
        this.c = randomAccessFile;
        FileChannel channel = randomAccessFile.getChannel();
        this.d = channel;
        if (this.e == 0) {
            this.b = channel.lock();
        }
        this.e++;
    }

    public final synchronized void b() {
        this.f874a.getAbsolutePath();
        int i = this.e - 1;
        this.e = i;
        if (i == 0) {
            Qa.a(this.b);
        }
        no.a((Closeable) this.c);
        no.a((Closeable) this.d);
        this.c = null;
        this.b = null;
        this.d = null;
    }

    public C0241fa(String str) {
        this(FileUtils.getFileFromPath(str + ".lock"));
    }

    public C0241fa(File file) {
        this.e = 0;
        this.f874a = file;
    }

    public static File a(Context context, String str) {
        File fileFromSdkStorage = FileUtils.getFileFromSdkStorage(context, str + ".lock");
        if (fileFromSdkStorage != null) {
            return fileFromSdkStorage;
        }
        throw new IllegalStateException("Cannot create lock file");
    }
}
