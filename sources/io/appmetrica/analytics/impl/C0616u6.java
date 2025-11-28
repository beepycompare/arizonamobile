package io.appmetrica.analytics.impl;

import android.content.Context;
import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
/* renamed from: io.appmetrica.analytics.impl.u6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0616u6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0293ha f1145a;
    public final C0417m6 b;
    public final Context c;
    public final C0267ga d;

    public C0616u6(Context context) {
        this(context, new C0293ha(), new C0417m6(), C0267ga.a(context));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:3|(5:(10:5|(2:7|(1:9)(1:13))|14|15|16|18|19|20|9b|25)(1:34)|18|19|20|9b)|(1:11)|14|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a6, code lost:
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Ah ah) {
        boolean mkdir;
        Gf gf;
        String str;
        E9 b;
        PrintWriter printWriter;
        C0267ga c0267ga;
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
                str = ah.e.f629a.f492a.getAsInteger("PROCESS_CFG_PROCESS_ID") + Constants.FILENAME_SEQUENCE_SEPARATOR + gf.f492a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
                b = this.d.b(str);
                b.f456a.lock();
                b.b.a();
                this.f1145a.getClass();
                printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
                printWriter.write(new C0522qb(ah.f397a, ah.e, ah.d).k());
                no.a((Closeable) printWriter);
                b.c();
                c0267ga = this.d;
                synchronized (c0267ga) {
                    c0267ga.b.remove(str);
                }
                return;
            }
            mkdir = crashesDirectory.mkdir();
            printWriter.write(new C0522qb(ah.f397a, ah.e, ah.d).k());
            no.a((Closeable) printWriter);
            b.c();
            c0267ga = this.d;
            synchronized (c0267ga) {
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
        str = ah.e.f629a.f492a.getAsInteger("PROCESS_CFG_PROCESS_ID") + Constants.FILENAME_SEQUENCE_SEPARATOR + gf.f492a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
        b = this.d.b(str);
        b.f456a.lock();
        b.b.a();
        this.f1145a.getClass();
        printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
    }

    public C0616u6(Context context, C0293ha c0293ha, C0417m6 c0417m6, C0267ga c0267ga) {
        this.c = context;
        this.f1145a = c0293ha;
        this.b = c0417m6;
        this.d = c0267ga;
    }
}
