package com.google.android.gms.common.internal;

import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: com.google.android.gms:play-services-basement@@18.8.0 */
@Deprecated
/* loaded from: classes4.dex */
public class LibraryVersion {
    private static final GmsLogger zza = new GmsLogger("LibraryVersion", "");
    private static final LibraryVersion zzb = new LibraryVersion();
    private final ConcurrentHashMap zzc = new ConcurrentHashMap();

    protected LibraryVersion() {
    }

    public static LibraryVersion getInstance() {
        return zzb;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b7  */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.String] */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getVersion(String str) {
        Object obj;
        InputStream inputStream;
        Preconditions.checkNotEmpty(str, "Please provide a valid libraryName");
        ConcurrentHashMap concurrentHashMap = this.zzc;
        if (concurrentHashMap.containsKey(str)) {
            return (String) concurrentHashMap.get(str);
        }
        Properties properties = new Properties();
        Object obj2 = null;
        obj2 = 0;
        obj2 = 0;
        InputStream inputStream2 = null;
        try {
            try {
                inputStream = LibraryVersion.class.getResourceAsStream(String.format("/%s.properties", str));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
            obj = null;
        }
        try {
            if (inputStream != null) {
                properties.load(inputStream);
                String property = properties.getProperty(NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, null);
                GmsLogger gmsLogger = zza;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12 + String.valueOf(property).length());
                sb.append(str);
                sb.append(" version is ");
                sb.append(property);
                gmsLogger.v("LibraryVersion", sb.toString());
                obj2 = property;
            } else {
                GmsLogger gmsLogger2 = zza;
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 43);
                sb2.append("Failed to get app version for libraryName: ");
                sb2.append(str);
                gmsLogger2.w("LibraryVersion", sb2.toString());
            }
        } catch (IOException e2) {
            e = e2;
            obj = obj2;
            inputStream2 = inputStream;
            GmsLogger gmsLogger3 = zza;
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 43);
            sb3.append("Failed to get app version for libraryName: ");
            sb3.append(str);
            gmsLogger3.e("LibraryVersion", sb3.toString(), e);
            inputStream = inputStream2;
            obj2 = obj;
            if (inputStream != null) {
            }
            if (obj2 == 0) {
            }
            this.zzc.put(str, obj2);
            return obj2;
        } catch (Throwable th2) {
            th = th2;
            obj2 = inputStream;
            if (obj2 != null) {
                IOUtils.closeQuietly(obj2);
            }
            throw th;
        }
        if (inputStream != null) {
            IOUtils.closeQuietly(inputStream);
        }
        if (obj2 == 0) {
            zza.d("LibraryVersion", ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
            obj2 = "UNKNOWN";
        }
        this.zzc.put(str, obj2);
        return obj2;
    }
}
