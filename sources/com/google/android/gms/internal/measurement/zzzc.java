package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import okio.Utf8;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzzc implements zzyk {
    private static final Set zza = new HashSet(Arrays.asList(Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class));
    private final StringBuilder zzd;
    private boolean zze = false;
    private final String zzb = "[CONTEXT ";
    private final String zzc = " ]";

    public zzzc(String str, String str2, StringBuilder sb) {
        this.zzd = sb;
    }

    private static int zzc(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < ' ' || charAt == '\"' || charAt == '\\') {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzyk
    public final void zza(String str, Object obj) {
        boolean z = this.zze;
        StringBuilder sb = this.zzd;
        char c = ' ';
        if (z) {
            sb.append(' ');
        } else {
            if (sb.length() > 0) {
                if (sb.length() > 1000 || sb.indexOf("\n") != -1) {
                    c = '\n';
                }
                sb.append(c);
            }
            sb.append(this.zzb);
            this.zze = true;
        }
        StringBuilder sb2 = this.zzd;
        sb2.append(str);
        sb2.append('=');
        if (obj == null) {
            sb2.append(true);
        } else if (zza.contains(obj.getClass())) {
            sb2.append(obj);
        } else {
            sb2.append('\"');
            String obj2 = obj.toString();
            int i = 0;
            while (true) {
                int zzc = zzc(obj2, i);
                if (zzc != -1) {
                    sb2.append((CharSequence) obj2, i, zzc);
                    i = zzc + 1;
                    char charAt = obj2.charAt(zzc);
                    if (charAt == '\t') {
                        charAt = 't';
                    } else if (charAt == '\n') {
                        charAt = 'n';
                    } else if (charAt == '\r') {
                        charAt = 'r';
                    } else if (charAt != '\"' && charAt != '\\') {
                        sb2.append(Utf8.REPLACEMENT_CHARACTER);
                    }
                    sb2.append("\\");
                    sb2.append(charAt);
                } else {
                    sb2.append((CharSequence) obj2, i, obj2.length());
                    sb2.append('\"');
                    return;
                }
            }
        }
    }

    public final void zzb() {
        if (this.zze) {
            this.zzd.append(this.zzc);
        }
    }
}
