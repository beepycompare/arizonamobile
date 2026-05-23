package com.google.android.gms.internal.measurement;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzru {
    private final Map zza;
    private final Map zzb;
    private final List zzc;

    public zzru(List list) {
        List<zztc> emptyList = Collections.emptyList();
        List emptyList2 = Collections.emptyList();
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzsx zzsxVar = (zzsx) it.next();
            if (TextUtils.isEmpty(zzsxVar.zzc())) {
                Log.w("MobStore.FileStorage", "Cannot register backend, name empty");
            } else {
                zzsx zzsxVar2 = (zzsx) this.zza.put(zzsxVar.zzc(), zzsxVar);
                if (zzsxVar2 != null) {
                    String canonicalName = zzsxVar2.getClass().getCanonicalName();
                    String canonicalName2 = zzsxVar.getClass().getCanonicalName();
                    StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 30 + String.valueOf(canonicalName2).length());
                    sb.append("Cannot override Backend ");
                    sb.append(canonicalName);
                    sb.append(" with ");
                    sb.append(canonicalName2);
                    throw new IllegalArgumentException(sb.toString());
                }
            }
        }
        for (zztc zztcVar : emptyList) {
            if (TextUtils.isEmpty(zztcVar.zza())) {
                Log.w("MobStore.FileStorage", "Cannot register transform, name empty");
            } else {
                zztc zztcVar2 = (zztc) this.zzb.put(zztcVar.zza(), zztcVar);
                if (zztcVar2 != null) {
                    String canonicalName3 = zztcVar2.getClass().getCanonicalName();
                    String canonicalName4 = zztcVar.getClass().getCanonicalName();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(canonicalName3).length() + 35 + String.valueOf(canonicalName4).length());
                    sb2.append("Cannot to override Transform ");
                    sb2.append(canonicalName3);
                    sb2.append(" with ");
                    sb2.append(canonicalName4);
                    throw new IllegalArgumentException(sb2.toString());
                }
            }
        }
        this.zzc.addAll(emptyList2);
    }

    private final zzrs zze(Uri uri) throws IOException {
        ImmutableList of;
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList.Builder builder2 = ImmutableList.builder();
        String encodedFragment = uri.getEncodedFragment();
        if (!TextUtils.isEmpty(encodedFragment) && encodedFragment.startsWith("transform=")) {
            of = ImmutableList.copyOf(Splitter.on("+").omitEmptyStrings().split(encodedFragment.substring(10)));
        } else {
            of = ImmutableList.of();
        }
        int size = of.size();
        for (int i = 0; i < size; i++) {
            builder2.add((ImmutableList.Builder) zzsp.zza((String) of.get(i)));
        }
        ImmutableList build = builder2.build();
        int size2 = build.size();
        for (int i2 = 0; i2 < size2; i2++) {
            String str = (String) build.get(i2);
            zztc zztcVar = (zztc) this.zzb.get(str);
            if (zztcVar != null) {
                builder.add((ImmutableList.Builder) zztcVar);
            } else {
                String valueOf = String.valueOf(uri);
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(valueOf).length());
                sb.append("Requested transform isn't registered: ");
                sb.append(str);
                sb.append(": ");
                sb.append(valueOf);
                throw new zzsk(sb.toString());
            }
        }
        ImmutableList reverse = builder.build().reverse();
        zzrr zzrrVar = new zzrr(null);
        String scheme = uri.getScheme();
        zzsx zzsxVar = (zzsx) this.zza.get(scheme);
        if (zzsxVar != null) {
            zzrrVar.zza(zzsxVar);
            zzrrVar.zzc(this.zzc);
            zzrrVar.zzb(reverse);
            zzrrVar.zze(uri);
            if (!reverse.isEmpty()) {
                ArrayList arrayList = new ArrayList(uri.getPathSegments());
                if (!arrayList.isEmpty() && !uri.getPath().endsWith("/")) {
                    String str2 = (String) arrayList.get(arrayList.size() - 1);
                    ListIterator<E> listIterator = reverse.listIterator(reverse.size());
                    while (listIterator.hasPrevious()) {
                        zztc zztcVar2 = (zztc) listIterator.previous();
                    }
                    arrayList.set(arrayList.size() - 1, str2);
                    uri = uri.buildUpon().path(TextUtils.join("/", arrayList)).encodedFragment(null).build();
                }
            }
            zzrrVar.zzd(uri);
            return new zzrs(zzrrVar);
        }
        throw new zzsk(String.format("Requested backend isn't registered: %s", scheme));
    }

    public final Object zza(Uri uri, zzrt zzrtVar) throws IOException {
        return zzrtVar.zza(zze(uri));
    }

    public final void zzb(Uri uri) throws IOException {
        zzrs zze = zze(uri);
        zze.zza().zzk(zze.zzb());
    }

    public final boolean zzc(Uri uri) throws IOException {
        zzrs zze = zze(uri);
        return zze.zza().zze(zze.zzb());
    }

    public final void zzd(Uri uri, Uri uri2) throws IOException {
        zzrs zze = zze(uri);
        zzrs zze2 = zze(uri2);
        if (zze.zza() != zze2.zza()) {
            throw new zzsk("Cannot rename file across backends");
        }
        zze.zza().zzl(zze.zzb(), zze2.zzb());
    }
}
