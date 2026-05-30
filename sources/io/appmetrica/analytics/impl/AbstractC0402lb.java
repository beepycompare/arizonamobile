package io.appmetrica.analytics.impl;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* renamed from: io.appmetrica.analytics.impl.lb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0402lb {
    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(File file) {
        byte[] bArr;
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        FileChannel channel;
        if (file != null && file.exists()) {
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    channel = randomAccessFile.getChannel();
                    fileLock = channel.lock(0L, Long.MAX_VALUE, true);
                } catch (IOException | SecurityException unused) {
                    fileLock = null;
                } catch (Throwable th) {
                    th = th;
                    fileLock = null;
                }
            } catch (IOException | SecurityException unused2) {
                randomAccessFile = null;
                fileLock = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
                fileLock = null;
            }
            try {
                ByteBuffer allocate = ByteBuffer.allocate((int) file.length());
                channel.read(allocate);
                allocate.flip();
                bArr = allocate.array();
            } catch (IOException | SecurityException unused3) {
                bArr = null;
                if (bArr == null) {
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    C0541qk c0541qk = Oj.f706a;
                    c0541qk.getClass();
                    c0541qk.a(new Pj("error_during_file_reading", th));
                    file.getAbsolutePath();
                    a(fileLock);
                    Oo.a((Closeable) randomAccessFile);
                    bArr = null;
                    if (bArr == null) {
                    }
                } finally {
                    file.getAbsolutePath();
                    a(fileLock);
                    Oo.a((Closeable) randomAccessFile);
                }
            }
            if (bArr == null) {
                return new String(bArr, StandardCharsets.UTF_8);
            }
            return null;
        }
        bArr = null;
        if (bArr == null) {
        }
    }

    public static void a(FileLock fileLock) {
        if (fileLock == null || !fileLock.isValid()) {
            return;
        }
        try {
            fileLock.release();
        } catch (IOException unused) {
        }
    }

    public static void a(String str, FileOutputStream fileOutputStream) {
        FileLock fileLock = null;
        try {
            FileChannel channel = fileOutputStream.getChannel();
            fileLock = channel.lock();
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            ByteBuffer allocate = ByteBuffer.allocate(bytes.length);
            allocate.put(bytes);
            allocate.flip();
            channel.write(allocate);
            channel.force(true);
        } catch (IOException unused) {
        } finally {
            a(fileLock);
            Oo.a((Closeable) fileOutputStream);
        }
    }

    public static byte[] a(String str) {
        try {
            return MessageDigest.getInstance("MD5").digest(str.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException unused) {
            return new byte[0];
        }
    }
}
