package io.appmetrica.analytics.coreutils.internal.io;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¨\u0006\t"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/io/InputStreamUtils;", "", "", "limit", "Lkotlin/Function0;", "Ljava/io/InputStream;", "inputStreamProvider", "", "readSafelyApprox", "core-utils_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class InputStreamUtils {
    public static final InputStreamUtils INSTANCE = new InputStreamUtils();

    private InputStreamUtils() {
    }

    public final byte[] readSafelyApprox(int i, Function0<? extends InputStream> function0) {
        try {
            InputStream invoke = function0.invoke();
            if (invoke != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[8192];
                int i2 = 0;
                while (true) {
                    int read = invoke.read(bArr);
                    if (-1 == read || i2 > i) {
                        break;
                    } else if (read > 0) {
                        byteArrayOutputStream.write(bArr, 0, read);
                        i2 += read;
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                CloseableKt.closeFinally(byteArrayOutputStream, null);
                CloseableKt.closeFinally(invoke, null);
                return byteArray;
            }
        } catch (Throwable unused) {
        }
        return new byte[0];
    }
}
