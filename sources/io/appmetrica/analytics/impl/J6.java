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
    public final C0654va f500a;
    public final B6 b;
    public final Context c;
    public final C0629ua d;

    public J6(Context context) {
        this(context, new C0654va(), new B6(), C0629ua.a(context));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:3|(5:(10:5|(2:7|(1:9)(1:13))|14|15|16|18|19|20|9b|25)(1:34)|18|19|20|9b)|(1:11)|14|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a6, code lost:
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Ih ih) {
        boolean mkdir;
        Pf pf;
        String str;
        S9 b;
        PrintWriter printWriter;
        C0629ua c0629ua;
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
                str = ih.e.f812a.f596a.getAsInteger("PROCESS_CFG_PROCESS_ID") + Constants.FILENAME_SEQUENCE_SEPARATOR + pf.f596a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
                b = this.d.b(str);
                b.f638a.lock();
                b.b.a();
                this.f500a.getClass();
                printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
                printWriter.write(new Eb(ih.f492a, ih.e, ih.d).k());
                io.a((Closeable) printWriter);
                b.c();
                c0629ua = this.d;
                synchronized (c0629ua) {
                    c0629ua.b.remove(str);
                }
                return;
            }
            mkdir = crashesDirectory.mkdir();
            printWriter.write(new Eb(ih.f492a, ih.e, ih.d).k());
            io.a((Closeable) printWriter);
            b.c();
            c0629ua = this.d;
            synchronized (c0629ua) {
            }
        } catch (Throwable unused) {
            io.a((Closeable) printWriter);
            b.c();
            this.d.a(str);
            return;
        }
        if (!mkdir) {
            return;
        }
        str = ih.e.f812a.f596a.getAsInteger("PROCESS_CFG_PROCESS_ID") + Constants.FILENAME_SEQUENCE_SEPARATOR + pf.f596a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
        b = this.d.b(str);
        b.f638a.lock();
        b.b.a();
        this.f500a.getClass();
        printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
    }

    public J6(Context context, C0654va c0654va, B6 b6, C0629ua c0629ua) {
        this.c = context;
        this.f500a = c0654va;
        this.b = b6;
        this.d = c0629ua;
    }
}
