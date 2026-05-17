package io.appmetrica.analytics.impl;

import android.content.Context;
import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
/* renamed from: io.appmetrica.analytics.impl.n6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0444n6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0115aa f1134a;
    public final C0240f6 b;
    public final Context c;
    public final Z9 d;

    public C0444n6(Context context) {
        this(context, new C0115aa(), new C0240f6(), Z9.a(context));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:3|(5:(10:5|(2:7|(1:9)(1:13))|14|15|16|18|19|20|9b|25)(1:34)|18|19|20|9b)|(1:11)|14|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a6, code lost:
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(C0654vh c0654vh) {
        boolean mkdir;
        Bf bf;
        String str;
        C0696x9 b;
        PrintWriter printWriter;
        Z9 z9;
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
                str = c0654vh.e.f612a.f525a.getAsInteger("PROCESS_CFG_PROCESS_ID") + Constants.FILENAME_SEQUENCE_SEPARATOR + bf.f525a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
                b = this.d.b(str);
                b.f1307a.lock();
                b.b.a();
                this.f1134a.getClass();
                printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
                printWriter.write(new C0348jb(c0654vh.f1277a, c0654vh.e, c0654vh.d).k());
                lo.a((Closeable) printWriter);
                b.c();
                z9 = this.d;
                synchronized (z9) {
                    z9.b.remove(str);
                }
                return;
            }
            mkdir = crashesDirectory.mkdir();
            printWriter.write(new C0348jb(c0654vh.f1277a, c0654vh.e, c0654vh.d).k());
            lo.a((Closeable) printWriter);
            b.c();
            z9 = this.d;
            synchronized (z9) {
            }
        } catch (Throwable unused) {
            lo.a((Closeable) printWriter);
            b.c();
            this.d.a(str);
            return;
        }
        if (!mkdir) {
            return;
        }
        str = c0654vh.e.f612a.f525a.getAsInteger("PROCESS_CFG_PROCESS_ID") + Constants.FILENAME_SEQUENCE_SEPARATOR + bf.f525a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
        b = this.d.b(str);
        b.f1307a.lock();
        b.b.a();
        this.f1134a.getClass();
        printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
    }

    public C0444n6(Context context, C0115aa c0115aa, C0240f6 c0240f6, Z9 z9) {
        this.c = context;
        this.f1134a = c0115aa;
        this.b = c0240f6;
        this.d = z9;
    }
}
