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
public final class G6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0610ta f439a;
    public final C0731y6 b;
    public final Context c;
    public final C0585sa d;

    public G6(Context context) {
        this(context, new C0610ta(), new C0731y6(), C0585sa.a(context));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:3|(5:(10:5|(2:7|(1:9)(1:13))|14|15|16|18|19|20|9b|25)(1:34)|18|19|20|9b)|(1:11)|14|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a6, code lost:
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Gh gh) {
        boolean mkdir;
        Nf nf;
        String str;
        P9 b;
        PrintWriter printWriter;
        C0585sa c0585sa;
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
                str = gh.e.f796a.f553a.getAsInteger("PROCESS_CFG_PROCESS_ID") + Constants.FILENAME_SEQUENCE_SEPARATOR + nf.f553a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
                b = this.d.b(str);
                b.f578a.lock();
                b.b.a();
                this.f439a.getClass();
                printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
                printWriter.write(new Cb(gh.f445a, gh.e, gh.d).k());
                fo.a((Closeable) printWriter);
                b.c();
                c0585sa = this.d;
                synchronized (c0585sa) {
                    c0585sa.b.remove(str);
                }
                return;
            }
            mkdir = crashesDirectory.mkdir();
            printWriter.write(new Cb(gh.f445a, gh.e, gh.d).k());
            fo.a((Closeable) printWriter);
            b.c();
            c0585sa = this.d;
            synchronized (c0585sa) {
            }
        } catch (Throwable unused) {
            fo.a((Closeable) printWriter);
            b.c();
            this.d.a(str);
            return;
        }
        if (!mkdir) {
            return;
        }
        str = gh.e.f796a.f553a.getAsInteger("PROCESS_CFG_PROCESS_ID") + Constants.FILENAME_SEQUENCE_SEPARATOR + nf.f553a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
        b = this.d.b(str);
        b.f578a.lock();
        b.b.a();
        this.f439a.getClass();
        printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
    }

    public G6(Context context, C0610ta c0610ta, C0731y6 c0731y6, C0585sa c0585sa) {
        this.c = context;
        this.f439a = c0610ta;
        this.b = c0731y6;
        this.d = c0585sa;
    }
}
