package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Formattable;
import java.util.Formatter;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzzh {
    static final Locale zza = Locale.ROOT;

    public static String zza(Object obj) {
        if (obj == null) {
            return AbstractJsonLexerKt.NULL;
        }
        try {
            if (!obj.getClass().isArray()) {
                String obj2 = obj.toString();
                return obj2 != null ? obj2 : zzf(obj, "toString() returned null");
            } else if (obj instanceof int[]) {
                return Arrays.toString((int[]) obj);
            } else {
                if (obj instanceof long[]) {
                    return Arrays.toString((long[]) obj);
                }
                if (obj instanceof byte[]) {
                    return Arrays.toString((byte[]) obj);
                }
                if (obj instanceof char[]) {
                    return Arrays.toString((char[]) obj);
                }
                if (obj instanceof short[]) {
                    return Arrays.toString((short[]) obj);
                }
                if (obj instanceof float[]) {
                    return Arrays.toString((float[]) obj);
                }
                if (obj instanceof double[]) {
                    return Arrays.toString((double[]) obj);
                }
                if (obj instanceof boolean[]) {
                    return Arrays.toString((boolean[]) obj);
                }
                return Arrays.toString((Object[]) obj);
            }
        } catch (RuntimeException e) {
            return zze(obj, e);
        }
    }

    public static void zzb(Formattable formattable, StringBuilder sb, zzza zzzaVar) {
        int zzj = zzzaVar.zzj();
        int i = zzj & 162;
        if (i != 0) {
            i = ((zzj & 32) != 0 ? 1 : 0) | ((zzj & 128) != 0 ? 2 : 0) | ((zzj & 2) != 0 ? 4 : 0);
        }
        int length = sb.length();
        Formatter formatter = new Formatter(sb, zza);
        try {
            formattable.formatTo(formatter, i, zzzaVar.zzf(), zzzaVar.zzg());
        } catch (RuntimeException e) {
            sb.setLength(length);
            try {
                formatter.out().append(zze(formattable, e));
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzc(StringBuilder sb, Number number, zzza zzzaVar) {
        boolean zzk = zzzaVar.zzk();
        long longValue = number.longValue();
        if (number instanceof Long) {
            zzd(sb, longValue, zzk);
        } else if (number instanceof Integer) {
            zzd(sb, longValue & 4294967295L, zzk);
        } else if (number instanceof Byte) {
            zzd(sb, longValue & 255, zzk);
        } else if (number instanceof Short) {
            zzd(sb, longValue & WebSocketProtocol.PAYLOAD_SHORT_MAX, zzk);
        } else if (number instanceof BigInteger) {
            String bigInteger = ((BigInteger) number).toString(16);
            if (zzk) {
                bigInteger = bigInteger.toUpperCase(zza);
            }
            sb.append(bigInteger);
        } else {
            String valueOf = String.valueOf(number.getClass());
            String.valueOf(valueOf);
            throw new IllegalStateException("unsupported number type: ".concat(String.valueOf(valueOf)));
        }
    }

    private static void zzd(StringBuilder sb, long j, boolean z) {
        if (j == 0) {
            sb.append("0");
            return;
        }
        String str = true != z ? "0123456789abcdef" : "0123456789ABCDEF";
        for (int numberOfLeadingZeros = (63 - Long.numberOfLeadingZeros(j)) & (-4); numberOfLeadingZeros >= 0; numberOfLeadingZeros -= 4) {
            sb.append(str.charAt((int) ((j >>> numberOfLeadingZeros) & 15)));
        }
    }

    private static String zze(Object obj, RuntimeException runtimeException) {
        String simpleName;
        try {
            simpleName = runtimeException.toString();
        } catch (RuntimeException e) {
            simpleName = e.getClass().getSimpleName();
        }
        return zzf(obj, simpleName);
    }

    private static String zzf(Object obj, String str) {
        String name = obj.getClass().getName();
        int identityHashCode = System.identityHashCode(obj);
        int length = String.valueOf(name).length();
        StringBuilder sb = new StringBuilder(length + 2 + String.valueOf(identityHashCode).length() + 2 + String.valueOf(str).length() + 1);
        sb.append("{");
        sb.append(name);
        sb.append("@");
        sb.append(identityHashCode);
        sb.append(": ");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
