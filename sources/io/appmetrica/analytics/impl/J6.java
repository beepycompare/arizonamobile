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
    public final C0655va f499a;
    public final B6 b;
    public final Context c;
    public final C0630ua d;

    public J6(Context context) {
        this(context, new C0655va(), new B6(), C0630ua.a(context));
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
        C0630ua c0630ua;
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
                str = ih.e.f811a.f595a.getAsInteger("PROCESS_CFG_PROCESS_ID") + Constants.FILENAME_SEQUENCE_SEPARATOR + pf.f595a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
                b = this.d.b(str);
                b.f637a.lock();
                b.b.a();
                this.f499a.getClass();
                printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
                printWriter.write(new Eb(ih.f491a, ih.e, ih.d).k());
                io.a((Closeable) printWriter);
                b.c();
                c0630ua = this.d;
                synchronized (c0630ua) {
                    c0630ua.b.remove(str);
                }
                return;
            }
            mkdir = crashesDirectory.mkdir();
            printWriter.write(new Eb(ih.f491a, ih.e, ih.d).k());
            io.a((Closeable) printWriter);
            b.c();
            c0630ua = this.d;
            synchronized (c0630ua) {
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
        str = ih.e.f811a.f595a.getAsInteger("PROCESS_CFG_PROCESS_ID") + Constants.FILENAME_SEQUENCE_SEPARATOR + pf.f595a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
        b = this.d.b(str);
        b.f637a.lock();
        b.b.a();
        this.f499a.getClass();
        printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
    }

    public J6(Context context, C0655va c0655va, B6 b6, C0630ua c0630ua) {
        this.c = context;
        this.f499a = c0655va;
        this.b = b6;
        this.d = c0630ua;
    }
}
