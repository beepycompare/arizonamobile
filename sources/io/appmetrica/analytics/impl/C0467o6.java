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
public final class C0467o6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0138ba f1042a;
    public final C0263g6 b;
    public final Context c;
    public final C0112aa d;

    public C0467o6(Context context) {
        this(context, new C0138ba(), new C0263g6(), C0112aa.a(context));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:3|(5:(10:5|(2:7|(1:9)(1:13))|14|15|16|18|19|20|9b|25)(1:34)|18|19|20|9b)|(1:11)|14|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a6, code lost:
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(C0677wh c0677wh) {
        boolean mkdir;
        Cf cf;
        String str;
        C0719y9 b;
        PrintWriter printWriter;
        C0112aa c0112aa;
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
                str = c0677wh.e.f518a.f432a.getAsInteger("PROCESS_CFG_PROCESS_ID") + Constants.FILENAME_SEQUENCE_SEPARATOR + cf.f432a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
                b = this.d.b(str);
                b.f1215a.lock();
                b.b.a();
                this.f1042a.getClass();
                printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
                printWriter.write(new C0371kb(c0677wh.f1184a, c0677wh.e, c0677wh.d).k());
                mo.a((Closeable) printWriter);
                b.c();
                c0112aa = this.d;
                synchronized (c0112aa) {
                    c0112aa.b.remove(str);
                }
                return;
            }
            mkdir = crashesDirectory.mkdir();
            printWriter.write(new C0371kb(c0677wh.f1184a, c0677wh.e, c0677wh.d).k());
            mo.a((Closeable) printWriter);
            b.c();
            c0112aa = this.d;
            synchronized (c0112aa) {
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
        str = c0677wh.e.f518a.f432a.getAsInteger("PROCESS_CFG_PROCESS_ID") + Constants.FILENAME_SEQUENCE_SEPARATOR + cf.f432a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
        b = this.d.b(str);
        b.f1215a.lock();
        b.b.a();
        this.f1042a.getClass();
        printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
    }

    public C0467o6(Context context, C0138ba c0138ba, C0263g6 c0263g6, C0112aa c0112aa) {
        this.c = context;
        this.f1042a = c0138ba;
        this.b = c0263g6;
        this.d = c0112aa;
    }
}
