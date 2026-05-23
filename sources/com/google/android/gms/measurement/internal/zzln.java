package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.zip.GZIPOutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzln implements Runnable {
    final /* synthetic */ zzlo zza;
    private final URL zzb;
    private final byte[] zzc;
    private final zzll zzd;
    private final String zze;
    private final Map zzf;

    public zzln(zzlo zzloVar, String str, URL url, byte[] bArr, Map map, zzll zzllVar) {
        Objects.requireNonNull(zzloVar);
        this.zza = zzloVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzllVar);
        this.zzb = url;
        this.zzc = bArr;
        this.zzd = zzllVar;
        this.zze = str;
        this.zzf = map;
    }

    private final void zzb(final int i, final Exception exc, final byte[] bArr, final Map map) {
        this.zza.zzu.zzaX().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlm
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzln.this.zza(i, exc, bArr, map);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:70:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0157 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.OutputStream] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        HttpURLConnection httpURLConnection;
        Map map;
        Map map2;
        Map map3;
        Map map4;
        OutputStream outputStream;
        OutputStream outputStream2;
        int responseCode;
        InputStream inputStream;
        zzlo zzloVar = this.zza;
        zzloVar.zzaY();
        int i = 0;
        try {
            URL url = this.zzb;
            int i2 = com.google.android.gms.internal.measurement.zzch.zzb;
            URLConnection openConnection = url.openConnection();
            if (!(openConnection instanceof HttpURLConnection)) {
                throw new IOException("Failed to obtain HTTP connection");
            }
            httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            zzic zzicVar = zzloVar.zzu;
            zzicVar.zzc();
            httpURLConnection.setConnectTimeout(60000);
            zzicVar.zzc();
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            ?? r5 = 1;
            httpURLConnection.setDoInput(true);
            try {
                try {
                    Map map5 = this.zzf;
                    if (map5 != null) {
                        for (Map.Entry entry : map5.entrySet()) {
                            httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                    byte[] bArr = this.zzc;
                    if (bArr != null) {
                        try {
                            zzicVar.zzaV();
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            gZIPOutputStream.write(bArr);
                            gZIPOutputStream.close();
                            byteArrayOutputStream.close();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            zzgs zzk = this.zza.zzu.zzaW().zzk();
                            int length = byteArray.length;
                            zzk.zzb("Uploading data. size", Integer.valueOf(length));
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.addRequestProperty(HttpHeaders.CONTENT_ENCODING, "gzip");
                            httpURLConnection.setFixedLengthStreamingMode(length);
                            httpURLConnection.connect();
                            OutputStream outputStream3 = httpURLConnection.getOutputStream();
                            try {
                                outputStream3.write(byteArray);
                                outputStream3.close();
                                r5 = outputStream3;
                            } catch (IOException e) {
                                e = e;
                                map4 = null;
                                outputStream2 = outputStream3;
                                if (outputStream2 != 0) {
                                }
                                if (httpURLConnection != null) {
                                }
                                zzb(i, e, null, map4);
                            } catch (Throwable th) {
                                th = th;
                                map3 = null;
                                outputStream = outputStream3;
                                if (outputStream != 0) {
                                }
                                if (httpURLConnection != null) {
                                }
                                zzb(i, null, null, map3);
                                throw th;
                            }
                        } catch (IOException e2) {
                            this.zza.zzu.zzaW().zzb().zzb("Failed to gzip post request content", e2);
                            throw e2;
                        }
                    }
                    responseCode = httpURLConnection.getResponseCode();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e = e3;
            }
            try {
                try {
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            byte[] bArr2 = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr2);
                                if (read <= 0) {
                                    break;
                                }
                                byteArrayOutputStream2.write(bArr2, 0, read);
                            }
                            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            zzb(responseCode, null, byteArray2, headerFields);
                        } catch (Throwable th3) {
                            th = th3;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream = null;
                    }
                } catch (IOException e4) {
                    i = responseCode;
                    e = e4;
                    map4 = r5;
                    outputStream2 = 0;
                    if (outputStream2 != 0) {
                        try {
                            outputStream2.close();
                        } catch (IOException e5) {
                            this.zza.zzu.zzaW().zzb().zzc("Error closing HTTP compressed POST connection output stream. appId", zzgu.zzl(this.zze), e5);
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    zzb(i, e, null, map4);
                } catch (Throwable th5) {
                    i = responseCode;
                    th = th5;
                    map3 = r5;
                    outputStream = 0;
                    if (outputStream != 0) {
                        try {
                            outputStream.close();
                        } catch (IOException e6) {
                            this.zza.zzu.zzaW().zzb().zzc("Error closing HTTP compressed POST connection output stream. appId", zzgu.zzl(this.zze), e6);
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    zzb(i, null, null, map3);
                    throw th;
                }
            } catch (IOException e7) {
                i = responseCode;
                e = e7;
                map2 = null;
                map4 = map2;
                outputStream2 = map2;
                if (outputStream2 != 0) {
                }
                if (httpURLConnection != null) {
                }
                zzb(i, e, null, map4);
            } catch (Throwable th6) {
                i = responseCode;
                th = th6;
                map = null;
                map3 = map;
                outputStream = map;
                if (outputStream != 0) {
                }
                if (httpURLConnection != null) {
                }
                zzb(i, null, null, map3);
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            httpURLConnection = null;
            map2 = null;
        } catch (Throwable th7) {
            th = th7;
            httpURLConnection = null;
            map = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(int i, Exception exc, byte[] bArr, Map map) {
        this.zzd.zza(this.zze, i, exc, bArr, map);
    }
}
