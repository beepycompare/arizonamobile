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
public final class M6 {

    /* renamed from: a  reason: collision with root package name */
    public final Aa f572a;
    public final E6 b;
    public final Context c;
    public final C0756za d;

    public M6(Context context) {
        this(context, new Aa(), new E6(), C0756za.a(context));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:3|(5:(10:5|(2:7|(1:9)(1:13))|14|15|16|18|19|20|9b|25)(1:34)|18|19|20|9b)|(1:11)|14|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a6, code lost:
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Rh rh) {
        boolean mkdir;
        Vf vf;
        String str;
        X9 b;
        PrintWriter printWriter;
        C0756za c0756za;
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
                str = rh.e.f888a.f712a.getAsInteger("PROCESS_CFG_PROCESS_ID") + Constants.FILENAME_SEQUENCE_SEPARATOR + vf.f712a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
                b = this.d.b(str);
                b.f739a.lock();
                b.b.a();
                this.f572a.getClass();
                printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
                printWriter.write(new Jb(rh.f657a, rh.e, rh.d).k());
                ro.a((Closeable) printWriter);
                b.c();
                c0756za = this.d;
                synchronized (c0756za) {
                    c0756za.b.remove(str);
                }
                return;
            }
            mkdir = crashesDirectory.mkdir();
            printWriter.write(new Jb(rh.f657a, rh.e, rh.d).k());
            ro.a((Closeable) printWriter);
            b.c();
            c0756za = this.d;
            synchronized (c0756za) {
            }
        } catch (Throwable unused) {
            ro.a((Closeable) printWriter);
            b.c();
            this.d.a(str);
            return;
        }
        if (!mkdir) {
            return;
        }
        str = rh.e.f888a.f712a.getAsInteger("PROCESS_CFG_PROCESS_ID") + Constants.FILENAME_SEQUENCE_SEPARATOR + vf.f712a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
        b = this.d.b(str);
        b.f739a.lock();
        b.b.a();
        this.f572a.getClass();
        printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
    }

    public M6(Context context, Aa aa, E6 e6, C0756za c0756za) {
        this.c = context;
        this.f572a = aa;
        this.b = e6;
        this.d = c0756za;
    }
}
