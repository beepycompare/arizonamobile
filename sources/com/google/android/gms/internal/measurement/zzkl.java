package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public abstract class zzkl {
    public static final /* synthetic */ int zzc = 0;
    private static final Object zzd = new Object();
    @Nullable
    private static volatile zzkg zze = null;
    private static volatile boolean zzf = false;
    private static final AtomicInteger zzh;
    final zzkf zza;
    final String zzb;
    private Object zzg;
    private volatile int zzi = -1;
    private volatile Object zzj;
    private volatile boolean zzk;

    static {
        new AtomicReference();
        Preconditions.checkNotNull(zzkj.zza, "BuildInfo must be non-null");
        zzh = new AtomicInteger();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzkl(zzkf zzkfVar, String str, Object obj, boolean z, byte[] bArr) {
        if (zzkfVar.zza == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zza = zzkfVar;
        this.zzb = str;
        this.zzg = obj;
        this.zzk = false;
    }

    public static void zzb(final Context context) {
        if (zze != null || context == null) {
            return;
        }
        Object obj = zzd;
        synchronized (obj) {
            if (zze == null) {
                synchronized (obj) {
                    zzkg zzkgVar = zze;
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    if (zzkgVar == null || zzkgVar.zza() != context) {
                        if (zzkgVar != null) {
                            zzjq.zzd();
                            zzkn.zzb();
                            zzjx.zzc();
                        }
                        zze = new zzjn(context, Suppliers.memoize(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzkk
                            @Override // com.google.common.base.Supplier
                            public final /* synthetic */ Object get() {
                                int i = zzkl.zzc;
                                return zzjy.zza(context);
                            }
                        }));
                        zzh.incrementAndGet();
                    }
                }
            }
        }
    }

    public static void zzc() {
        zzh.incrementAndGet();
    }

    @Nullable
    abstract Object zza(Object obj);

    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058 A[Catch: all -> 0x00c9, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x001e, B:13:0x0034, B:18:0x004d, B:20:0x0058, B:22:0x0062, B:26:0x0085, B:28:0x008d, B:40:0x00b4, B:43:0x00bc, B:44:0x00bf, B:45:0x00c3, B:32:0x0096, B:34:0x009a, B:36:0x00aa, B:38:0x00b0, B:24:0x0073, B:46:0x00c7), top: B:53:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0073 A[Catch: all -> 0x00c9, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x001e, B:13:0x0034, B:18:0x004d, B:20:0x0058, B:22:0x0062, B:26:0x0085, B:28:0x008d, B:40:0x00b4, B:43:0x00bc, B:44:0x00bf, B:45:0x00c3, B:32:0x0096, B:34:0x009a, B:36:0x00aa, B:38:0x00b0, B:24:0x0073, B:46:0x00c7), top: B:53:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096 A[Catch: all -> 0x00c9, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0018, B:11:0x001e, B:13:0x0034, B:18:0x004d, B:20:0x0058, B:22:0x0062, B:26:0x0085, B:28:0x008d, B:40:0x00b4, B:43:0x00bc, B:44:0x00bf, B:45:0x00c3, B:32:0x0096, B:34:0x009a, B:36:0x00aa, B:38:0x00b0, B:24:0x0073, B:46:0x00c7), top: B:53:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzd() {
        String str;
        Uri uri;
        zzju zza;
        Object zza2;
        String zze2;
        Object zze3;
        int i = zzh.get();
        if (this.zzi < i) {
            synchronized (this) {
                if (this.zzi < i) {
                    zzkg zzkgVar = zze;
                    Optional absent = Optional.absent();
                    Object obj = null;
                    if (zzkgVar != null && zzkgVar.zzb() != null) {
                        absent = (Optional) ((Supplier) Preconditions.checkNotNull(zzkgVar.zzb())).get();
                        if (absent.isPresent()) {
                            zzkf zzkfVar = this.zza;
                            str = ((zzjs) absent.get()).zza(zzkfVar.zza, null, zzkfVar.zzc, this.zzb);
                            Preconditions.checkState(zzkgVar == null, "Must call PhenotypeFlagInitializer.maybeInit() first");
                            zzkf zzkfVar2 = this.zza;
                            uri = zzkfVar2.zza;
                            if (uri == null) {
                                zza = zzjz.zza(zzkgVar.zza(), uri) ? zzjq.zza(zzkgVar.zza().getContentResolver(), uri, zzki.zza) : null;
                            } else {
                                zza = zzkn.zza(zzkgVar.zza(), (String) Preconditions.checkNotNull(null), zzkh.zza);
                            }
                            zza2 = (zza != null || (zze3 = zza.zze(this.zzb)) == null) ? null : zza(zze3);
                            if (zza2 == null) {
                                if (!zzkfVar2.zzd && (zze2 = zzjx.zza(zzkgVar.zza()).zze(this.zzb)) != null) {
                                    obj = zza(zze2);
                                }
                                zza2 = obj == null ? this.zzg : obj;
                            }
                            if (absent.isPresent()) {
                                zza2 = str == null ? this.zzg : zza(str);
                            }
                            this.zzj = zza2;
                            this.zzi = i;
                        }
                    }
                    str = null;
                    Preconditions.checkState(zzkgVar == null, "Must call PhenotypeFlagInitializer.maybeInit() first");
                    zzkf zzkfVar22 = this.zza;
                    uri = zzkfVar22.zza;
                    if (uri == null) {
                    }
                    if (zza != null) {
                    }
                    if (zza2 == null) {
                    }
                    if (absent.isPresent()) {
                    }
                    this.zzj = zza2;
                    this.zzi = i;
                }
            }
        }
        return this.zzj;
    }
}
