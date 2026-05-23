package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Function;
import io.appmetrica.analytics.coreutils.internal.io.Base64Utils;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import kotlin.io.ByteStreamsKt;
/* renamed from: io.appmetrica.analytics.impl.fe  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0250fe implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final C0302he f979a;
    public final C0224ee b;

    public C0250fe(C0302he c0302he, C0224ee c0224ee) {
        this.f979a = c0302he;
        this.b = c0224ee;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020 A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:3:0x0001, B:5:0x0007, B:8:0x0015, B:13:0x0020, B:21:0x002c, B:10:0x001a), top: B:25:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // io.appmetrica.analytics.coreapi.internal.backport.Function
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String apply(File file) {
        byte[] bArr;
        FileInputStream fileInputStream;
        try {
            String absolutePath = file.getAbsolutePath();
            if (absolutePath != null) {
                try {
                    fileInputStream = new FileInputStream(new File(absolutePath));
                } catch (Throwable unused) {
                    fileInputStream = null;
                }
                try {
                    bArr = ByteStreamsKt.readBytes(fileInputStream);
                    Oo.a((Closeable) fileInputStream);
                } catch (Throwable unused2) {
                    Oo.a((Closeable) fileInputStream);
                    bArr = null;
                    if (bArr != null) {
                    }
                }
                if (bArr != null) {
                    if (bArr.length == 0) {
                        bArr = null;
                    }
                    if (bArr != null) {
                        return Base64Utils.compressBase64(MessageNano.toByteArray(this.b.fromModel(new C0379ke(bArr, this.f979a))));
                    }
                    return null;
                }
                return null;
            }
            bArr = null;
            if (bArr != null) {
            }
        } catch (Throwable unused3) {
            return null;
        }
    }
}
