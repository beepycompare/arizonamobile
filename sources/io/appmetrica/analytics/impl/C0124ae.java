package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Function;
import io.appmetrica.analytics.coreutils.internal.io.Base64Utils;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import kotlin.io.ByteStreamsKt;
/* renamed from: io.appmetrica.analytics.impl.ae  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0124ae implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final C0176ce f793a;
    public final Zd b;

    public C0124ae(C0176ce c0176ce, Zd zd) {
        this.f793a = c0176ce;
        this.b = zd;
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
                    ro.a((Closeable) fileInputStream);
                } catch (Throwable unused2) {
                    ro.a((Closeable) fileInputStream);
                    bArr = null;
                    if (bArr != null) {
                    }
                }
                if (bArr != null) {
                    if (bArr.length == 0) {
                        bArr = null;
                    }
                    if (bArr != null) {
                        return Base64Utils.compressBase64(MessageNano.toByteArray(this.b.fromModel(new C0253fe(bArr, this.f793a))));
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
