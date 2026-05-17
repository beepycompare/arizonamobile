package com.google.android.gms.internal.play_billing;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
final class zzhz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzev zzevVar) {
        StringBuilder sb = new StringBuilder(zzevVar.zze());
        for (int i = 0; i < zzevVar.zze(); i++) {
            byte zza = zzevVar.zza(i);
            if (zza != 34) {
                if (zza != 39) {
                    if (zza == 92) {
                        sb.append("\\\\");
                    } else {
                        switch (zza) {
                            case 7:
                                sb.append("\\a");
                                continue;
                            case 8:
                                sb.append("\\b");
                                continue;
                            case 9:
                                sb.append("\\t");
                                continue;
                            case 10:
                                sb.append("\\n");
                                continue;
                            case 11:
                                sb.append("\\v");
                                continue;
                            case 12:
                                sb.append("\\f");
                                continue;
                            case 13:
                                sb.append("\\r");
                                continue;
                            default:
                                if (zza < 32 || zza > 126) {
                                    sb.append(AbstractJsonLexerKt.STRING_ESC);
                                    sb.append((char) (((zza >>> 6) & 3) + 48));
                                    sb.append((char) (((zza >>> 3) & 7) + 48));
                                    sb.append((char) ((zza & 7) + 48));
                                    break;
                                } else {
                                    sb.append((char) zza);
                                    continue;
                                }
                                break;
                        }
                    }
                } else {
                    sb.append("\\'");
                }
            } else {
                sb.append("\\\"");
            }
        }
        return sb.toString();
    }
}
