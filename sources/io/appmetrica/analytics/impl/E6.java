package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
/* loaded from: classes5.dex */
public final class E6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0679wa f527a;
    public final C0649v6 b;
    public final Context c;
    public final C0653va d;

    public E6(Context context) {
        this(context, new C0679wa(), new C0649v6(), C0653va.a(context));
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
        C0168cg c0168cg;
        String str;
        R9 b;
        PrintWriter printWriter;
        C0653va c0653va;
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
                str = ph.e.f855a.f933a.getAsInteger("PROCESS_CFG_PROCESS_ID") + "-" + c0168cg.f933a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
                b = this.d.b(str);
                b.f747a.lock();
                b.b.a();
                this.f527a.getClass();
                printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
                printWriter.write(new Lb(ph.f723a, ph.e, ph.d).l());
                Oo.a((Closeable) printWriter);
                b.c();
                c0653va = this.d;
                synchronized (c0653va) {
                    c0653va.b.remove(str);
                }
                return;
            }
            mkdir = crashesDirectory.mkdir();
            printWriter.write(new Lb(ph.f723a, ph.e, ph.d).l());
            Oo.a((Closeable) printWriter);
            b.c();
            c0653va = this.d;
            synchronized (c0653va) {
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
        str = ph.e.f855a.f933a.getAsInteger("PROCESS_CFG_PROCESS_ID") + "-" + c0168cg.f933a.getAsString("PROCESS_CFG_PROCESS_SESSION_ID");
        b = this.d.b(str);
        b.f747a.lock();
        b.b.a();
        this.f527a.getClass();
        printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File(crashesDirectory, str))));
    }

    public E6(Context context, C0679wa c0679wa, C0649v6 c0649v6, C0653va c0653va) {
        this.c = context;
        this.f527a = c0679wa;
        this.b = c0649v6;
        this.d = c0653va;
    }
}
