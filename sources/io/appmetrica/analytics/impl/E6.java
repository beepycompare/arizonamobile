package io.appmetrica.analytics.impl;

import android.content.Context;
import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
/* loaded from: classes5.dex */
public final class E6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0686wa f524a;
    public final C0656v6 b;
    public final Context c;
    public final C0660va d;

    public E6(Context context) {
        this(context, new C0686wa(), new C0656v6(), C0660va.a(context));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:3|(5:(10:5|(2:7|(1:9)(1:13))|14|15|16|18|19|20|9b|25)(1:34)|18|19|20|9b)|(1:11)|14|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a6, code lost:
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Ph ph) {
        boolean mkdir;
        C0175cg c0175cg;
        String str;
        R9 b;
        PrintWriter printWriter;
        C0660va c0660va;
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
                str = ph.e.f852a.f930a.getAsInteger("PROCESS_CFG_PROCESS_ID") + Constants.FILENAME_SEQUENCE_SEPARATOR + c0175cg.f930a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
                b = this.d.b(str);
                b.f744a.lock();
                b.b.a();
                this.f524a.getClass();
                printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
                printWriter.write(new Lb(ph.f720a, ph.e, ph.d).l());
                Oo.a((Closeable) printWriter);
                b.c();
                c0660va = this.d;
                synchronized (c0660va) {
                    c0660va.b.remove(str);
                }
                return;
            }
            mkdir = crashesDirectory.mkdir();
            printWriter.write(new Lb(ph.f720a, ph.e, ph.d).l());
            Oo.a((Closeable) printWriter);
            b.c();
            c0660va = this.d;
            synchronized (c0660va) {
            }
        } catch (Throwable unused) {
            Oo.a((Closeable) printWriter);
            b.c();
            this.d.a(str);
            return;
        }
        if (!mkdir) {
            return;
        }
        str = ph.e.f852a.f930a.getAsInteger("PROCESS_CFG_PROCESS_ID") + Constants.FILENAME_SEQUENCE_SEPARATOR + c0175cg.f930a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
        b = this.d.b(str);
        b.f744a.lock();
        b.b.a();
        this.f524a.getClass();
        printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
    }

    public E6(Context context, C0686wa c0686wa, C0656v6 c0656v6, C0660va c0660va) {
        this.c = context;
        this.f524a = c0686wa;
        this.b = c0656v6;
        this.d = c0660va;
    }
}
