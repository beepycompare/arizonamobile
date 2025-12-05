package io.appmetrica.analytics.impl;

import android.content.Context;
import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
/* renamed from: io.appmetrica.analytics.impl.o6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0466o6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0137ba f1125a;
    public final C0262g6 b;
    public final Context c;
    public final C0111aa d;

    public C0466o6(Context context) {
        this(context, new C0137ba(), new C0262g6(), C0111aa.a(context));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:3|(5:(10:5|(2:7|(1:9)(1:13))|14|15|16|18|19|20|9b|25)(1:34)|18|19|20|9b)|(1:11)|14|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a6, code lost:
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(C0676wh c0676wh) {
        boolean mkdir;
        Cf cf;
        String str;
        C0718y9 b;
        PrintWriter printWriter;
        C0111aa c0111aa;
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
                str = c0676wh.e.f601a.f515a.getAsInteger("PROCESS_CFG_PROCESS_ID") + Constants.FILENAME_SEQUENCE_SEPARATOR + cf.f515a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
                b = this.d.b(str);
                b.f1298a.lock();
                b.b.a();
                this.f1125a.getClass();
                printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
                printWriter.write(new C0370kb(c0676wh.f1267a, c0676wh.e, c0676wh.d).k());
                mo.a((Closeable) printWriter);
                b.c();
                c0111aa = this.d;
                synchronized (c0111aa) {
                    c0111aa.b.remove(str);
                }
                return;
            }
            mkdir = crashesDirectory.mkdir();
            printWriter.write(new C0370kb(c0676wh.f1267a, c0676wh.e, c0676wh.d).k());
            mo.a((Closeable) printWriter);
            b.c();
            c0111aa = this.d;
            synchronized (c0111aa) {
            }
        } catch (Throwable unused) {
            mo.a((Closeable) printWriter);
            b.c();
            this.d.a(str);
            return;
        }
        if (!mkdir) {
            return;
        }
        str = c0676wh.e.f601a.f515a.getAsInteger("PROCESS_CFG_PROCESS_ID") + Constants.FILENAME_SEQUENCE_SEPARATOR + cf.f515a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
        b = this.d.b(str);
        b.f1298a.lock();
        b.b.a();
        this.f1125a.getClass();
        printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
    }

    public C0466o6(Context context, C0137ba c0137ba, C0262g6 c0262g6, C0111aa c0111aa) {
        this.c = context;
        this.f1125a = c0137ba;
        this.b = c0262g6;
        this.d = c0111aa;
    }
}
