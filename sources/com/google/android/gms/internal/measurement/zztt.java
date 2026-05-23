package com.google.android.gms.internal.measurement;

import android.net.Uri;
import android.util.Pair;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zztt {
    private final ConcurrentMap zza = new ConcurrentHashMap();
    private final Executor zzb;
    private final zzru zzc;
    private final AsyncFunction zzd;
    private final Map zze;
    private final zzvc zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztt(Executor executor, zzru zzruVar, zzvc zzvcVar, Map map, @Nullable zzvf zzvfVar) {
        this.zzb = (Executor) Preconditions.checkNotNull(executor);
        this.zzc = (zzru) Preconditions.checkNotNull(zzruVar);
        this.zzf = (zzvc) Preconditions.checkNotNull(zzvcVar);
        Map map2 = (Map) Preconditions.checkNotNull(map);
        this.zze = map2;
        Preconditions.checkArgument(!map2.isEmpty());
        this.zzd = zzts.zza;
    }

    public final zztp zza(zztr zztrVar) {
        zztr zztrVar2;
        ConcurrentMap concurrentMap = this.zza;
        Uri zza = zztrVar.zza();
        Pair pair = (Pair) concurrentMap.get(zza);
        if (pair == null) {
            Uri zza2 = zztrVar.zza();
            Preconditions.checkArgument(zza2.isHierarchical(), "Uri must be hierarchical: %s", zza2);
            String nullToEmpty = Strings.nullToEmpty(zza2.getLastPathSegment());
            int lastIndexOf = nullToEmpty.lastIndexOf(46);
            Preconditions.checkArgument((lastIndexOf == -1 ? "" : nullToEmpty.substring(lastIndexOf + 1)).equals("pb"), "Uri extension must be .pb: %s", zza2);
            Preconditions.checkArgument(true, "Proto schema cannot be null");
            Preconditions.checkArgument(zztrVar.zzc() != null, "Handler cannot be null");
            zzuw zzuwVar = (zzuw) this.zze.get("singleproc");
            Preconditions.checkArgument(zzuwVar != null, "No XDataStoreVariantFactory registered for ID %s", "singleproc");
            String nullToEmpty2 = Strings.nullToEmpty(zztrVar.zza().getLastPathSegment());
            int lastIndexOf2 = nullToEmpty2.lastIndexOf(46);
            if (lastIndexOf2 != -1) {
                nullToEmpty2 = nullToEmpty2.substring(0, lastIndexOf2);
            }
            String str = nullToEmpty2;
            ListenableFuture transformAsync = Futures.transformAsync(Futures.immediateFuture(zztrVar.zza()), this.zzd, MoreExecutors.directExecutor());
            Executor executor = this.zzb;
            zzru zzruVar = this.zzc;
            zzti zztiVar = zzti.ALLOWED;
            zztrVar2 = zztrVar;
            zztp zztpVar = new zztp(zzuwVar.zzb(zztrVar2, str, executor, zzruVar, zztiVar), this.zzf, transformAsync, false, zzuwVar.zza(zztiVar));
            ImmutableList zzd = zztrVar2.zzd();
            if (!zzd.isEmpty()) {
                zztpVar.zza(zzto.zza(zzd, executor));
            }
            pair = Pair.create(zztpVar, zztrVar2);
            Pair pair2 = (Pair) concurrentMap.putIfAbsent(zza, pair);
            if (pair2 != null) {
                pair = pair2;
            }
        } else {
            zztrVar2 = zztrVar;
        }
        zztp zztpVar2 = (zztp) pair.first;
        zztr zztrVar3 = (zztr) pair.second;
        if (zztrVar2.equals(zztrVar3)) {
            return zztpVar2;
        }
        String lenientFormat = Strings.lenientFormat("ProtoDataStoreConfig<%s> doesn't match previous call [uri=%s] [%s]", zztrVar2.zzb().getClass().getSimpleName(), zztrVar2.zza());
        Preconditions.checkArgument(zztrVar2.zza().equals(zztrVar3.zza()), lenientFormat, "uri");
        Preconditions.checkArgument(zztrVar2.zzb().equals(zztrVar3.zzb()), lenientFormat, "schema");
        Preconditions.checkArgument(zztrVar2.zzc().equals(zztrVar3.zzc()), lenientFormat, "handler");
        Preconditions.checkArgument(zztrVar2.zzd().equals(zztrVar3.zzd()), lenientFormat, "migrations");
        Preconditions.checkArgument(zztrVar2.zze().equals(zztrVar3.zze()), lenientFormat, "variantConfig");
        Preconditions.checkArgument(zztrVar2.zzf() == zztrVar3.zzf(), lenientFormat, "useGeneratedExtensionRegistry");
        zztrVar3.zzg();
        Preconditions.checkArgument(true, lenientFormat, (Object) "enableTracing");
        throw new IllegalArgumentException(Strings.lenientFormat(lenientFormat, "unknown"));
    }
}
