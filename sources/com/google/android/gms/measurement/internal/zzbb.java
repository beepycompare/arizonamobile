package com.google.android.gms.measurement.internal;

import com.google.android.vending.expansion.downloader.Constants;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzbb extends zzjr {
    private long zza;
    private String zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbb(zzio zzioVar) {
        super(zzioVar);
    }

    public final long zza() {
        zzv();
        return this.zza;
    }

    public final String zzb() {
        zzv();
        return this.zzb;
    }

    @Override // com.google.android.gms.measurement.internal.zzjr
    protected final boolean zzc() {
        Calendar calendar = Calendar.getInstance();
        this.zza = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String lowerCase = locale.getLanguage().toLowerCase(Locale.ENGLISH);
        String lowerCase2 = locale.getCountry().toLowerCase(Locale.ENGLISH);
        this.zzb = lowerCase + Constants.FILENAME_SEQUENCE_SEPARATOR + lowerCase2;
        return false;
    }
}
