package io.appmetrica.analytics.impl;

import android.content.Context;
import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
/* loaded from: classes4.dex */
public final class J6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0702xa f510a;
    public final B6 b;
    public final Context c;
    public final C0677wa d;

    public J6(Context context) {
        this(context, new C0702xa(), new B6(), C0677wa.a(context));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:3|(5:(10:5|(2:7|(1:9)(1:13))|14|15|16|18|19|20|9b|25)(1:34)|18|19|20|9b)|(1:11)|14|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a6, code lost:
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Nh nh) {
        boolean mkdir;
        Rf rf;
        String str;
        U9 b;
        PrintWriter printWriter;
        C0677wa c0677wa;
        File crashesDirectory = FileUtils.getCrashesDirectory(this.c);
        this.b.getClass();
        if (crashesDirectory == null) {
            return;
        }
        try {
            if (crashesDirectory.exists()) {
                if (!crashesDirectory.isDirectory()) {
                    if (!crashesDirectory.delete()) {
                        return;
                    }
                    mkdir = crashesDirectory.mkdir();
                }
                str = nh.e.f823a.f635a.getAsInteger("PROCESS_CFG_PROCESS_ID") + Constants.FILENAME_SEQUENCE_SEPARATOR + rf.f635a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
                b = this.d.b(str);
                b.f675a.lock();
                b.b.a();
                this.f510a.getClass();
                printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
                printWriter.write(new Gb(nh.f580a, nh.e, nh.d).k());
                no.a((Closeable) printWriter);
                b.c();
                c0677wa = this.d;
                synchronized (c0677wa) {
                    c0677wa.b.remove(str);
                }
                return;
            }
            mkdir = crashesDirectory.mkdir();
            printWriter.write(new Gb(nh.f580a, nh.e, nh.d).k());
            no.a((Closeable) printWriter);
            b.c();
            c0677wa = this.d;
            synchronized (c0677wa) {
            }
        } catch (Throwable unused) {
            no.a((Closeable) printWriter);
            b.c();
            this.d.a(str);
            return;
        }
        if (!mkdir) {
            return;
        }
        str = nh.e.f823a.f635a.getAsInteger("PROCESS_CFG_PROCESS_ID") + Constants.FILENAME_SEQUENCE_SEPARATOR + rf.f635a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
        b = this.d.b(str);
        b.f675a.lock();
        b.b.a();
        this.f510a.getClass();
        printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
    }

    public J6(Context context, C0702xa c0702xa, B6 b6, C0677wa c0677wa) {
        this.c = context;
        this.f510a = c0702xa;
        this.b = b6;
        this.d = c0677wa;
    }
}
