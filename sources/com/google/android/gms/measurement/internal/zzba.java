package com.google.android.gms.measurement.internal;

import com.google.android.vending.expansion.downloader.Constants;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzba extends zzje {
    private long zza;
    private String zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzba(zzib zzibVar) {
        super(zzibVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzje
    protected final boolean zza() {
        Calendar calendar = Calendar.getInstance();
        this.zza = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String lowerCase = locale.getLanguage().toLowerCase(Locale.ENGLISH);
        String lowerCase2 = locale.getCountry().toLowerCase(Locale.ENGLISH);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length());
        sb.append(lowerCase);
        sb.append(Constants.FILENAME_SEQUENCE_SEPARATOR);
        sb.append(lowerCase2);
        this.zzb = sb.toString();
        return false;
    }

    public final long zzb() {
        zzw();
        return this.zza;
    }

    public final String zzc() {
        zzw();
        return this.zzb;
    }
}
