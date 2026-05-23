package com.google.android.gms.internal.measurement;

import android.content.Context;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzlk {
    public static final /* synthetic */ int zza = 0;
    private static final Object zzb = new Object();
    private static final AtomicReference zzc = new AtomicReference();
    private static volatile zzlk zzd = null;
    private static volatile zzlk zze = null;
    private static final Supplier zzf = Suppliers.memoize(zzlp.zza);
    private final zzoh zzg = new zzol();
    private final Context zzh;
    private final Supplier zzi;
    private final Supplier zzj;
    private final Supplier zzk;
    private final Supplier zzl;
    private final zzrf zzm;
    private final Supplier zzn;
    private final zzqe zzo;

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
    /* loaded from: classes4.dex */
    public interface zza {
        Optional zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzlk(Context context, Supplier supplier, Supplier supplier2, final Supplier supplier3, Supplier supplier4, Supplier supplier5, byte[] bArr) {
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(supplier2);
        Preconditions.checkNotNull(supplier3);
        Preconditions.checkNotNull(supplier4);
        Preconditions.checkNotNull(supplier5);
        Supplier memoize = Suppliers.memoize(supplier);
        Supplier memoize2 = Suppliers.memoize(supplier2);
        Supplier memoize3 = Suppliers.memoize(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzlq
            @Override // com.google.common.base.Supplier
            public final /* synthetic */ Object get() {
                int i = zzlk.zza;
                return (zzqm) ((Optional) Supplier.this.get()).orNull();
            }
        });
        Supplier memoize4 = Suppliers.memoize(supplier4);
        Supplier memoize5 = Suppliers.memoize(supplier5);
        this.zzh = applicationContext;
        this.zzi = memoize;
        this.zzj = memoize2;
        this.zzk = memoize3;
        this.zzl = memoize4;
        this.zzm = new zzrf(applicationContext, memoize, memoize4, memoize2);
        this.zzn = memoize5;
        this.zzo = new zzqe(applicationContext, memoize, memoize3, memoize2);
    }

    public static void zza(Context context) {
        Context context2;
        if (zzc.get() != null) {
            return;
        }
        try {
            context2 = context.getApplicationContext();
        } catch (NullPointerException unused) {
            zzl();
            zzlz.zza(Level.WARNING, (Executor) zzf.get(), "context.getApplicationContext() yielded NullPointerException", new Object[0]);
            context2 = null;
        }
        if (context2 != null) {
            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(zzc, null, context2);
        }
    }

    public static zzlk zzb() {
        boolean z;
        zzlk zzlkVar;
        Context applicationContext;
        zzls.zza();
        zzls.zzc();
        Context context = (Context) zzc.get();
        if (context == null) {
            zzls.zzb();
            throw new IllegalStateException("Must call PhenotypeContext.setContext() first");
        }
        zzlk zzlkVar2 = zzd;
        if (zzlkVar2 != null) {
            return zzlkVar2;
        }
        final Context context2 = context.getApplicationContext();
        try {
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(zza.class, "singletonEntryPoint");
            applicationContext = context2.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        } catch (IllegalStateException unused) {
            z = false;
        }
        if (!(applicationContext instanceof zzagp)) {
            Class<?> cls = applicationContext.getClass();
            StringBuilder sb = new StringBuilder(String.valueOf(cls).length() + 72);
            sb.append("Given application context does not implement GeneratedComponentManager: ");
            sb.append(cls);
            throw new IllegalStateException("Given application context does not implement GeneratedComponentManager: ".concat(String.valueOf(cls)));
        }
        try {
            Object cast = zza.class.cast(((zzagp) applicationContext).zza());
            Intrinsics.checkNotNull(cast);
            Optional zza2 = ((zza) cast).zza();
            z = true;
            try {
                if (zza2.isPresent()) {
                    return (zzlk) zza2.get();
                }
            } catch (IllegalStateException unused2) {
            }
            synchronized (zzb) {
                if (zzd != null) {
                    zzlkVar = zzd;
                } else {
                    Optional absent = Optional.absent();
                    boolean z2 = context2 instanceof zza;
                    if (z2) {
                        absent = ((zza) context2).zza();
                    }
                    zzlkVar = (zzlk) absent.or((Supplier<? extends Object>) new Supplier() { // from class: com.google.android.gms.internal.measurement.zzll
                        @Override // com.google.common.base.Supplier
                        public final /* synthetic */ Object get() {
                            int i = zzlk.zza;
                            zzlj zzljVar = new zzlj(null);
                            zzljVar.zza(context2);
                            return zzljVar.zzb();
                        }
                    });
                    zzd = zzlkVar;
                    if (!z && !z2) {
                        zzlz.zza(Level.CONFIG, zzlkVar.zzg(), "Application doesn't implement PhenotypeApplication interface, falling back to globally set context. See go/phenotype-flag#process-stable-init for more info.", new Object[0]);
                    }
                }
            }
            return zzlkVar;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Failed to get an entry point. Did you mark your interface with @SingletonEntryPoint?", e);
        }
    }

    public static boolean zzl() {
        zzls.zzb();
        if (zzc.get() == null) {
            zzls.zzd();
        }
        return false;
    }

    public final Context zzc() {
        return this.zzh;
    }

    public final zzrf zzd() {
        return this.zzm;
    }

    public final Optional zze() {
        return (Optional) this.zzn.get();
    }

    public final zzqe zzf() {
        return this.zzo;
    }

    public final ListeningScheduledExecutorService zzg() {
        return (ListeningScheduledExecutorService) this.zzi.get();
    }

    public final zzmj zzh() {
        return (zzmj) this.zzj.get();
    }

    public final zzru zzi() {
        return (zzru) this.zzl.get();
    }

    public final zzqm zzj() {
        return (zzqm) this.zzk.get();
    }

    public final zzoh zzk() {
        return this.zzg;
    }
}
