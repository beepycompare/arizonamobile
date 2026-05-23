package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.android.vending.expansion.zipfile.APEZProvider;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzpp extends zzjf {
    public static final /* synthetic */ int zza = 0;
    private static final String[] zzb = {"firebase_", "google_", "ga_"};
    private static final String[] zzc = {"_err"};
    private SecureRandom zzd;
    private final AtomicLong zze;
    private int zzf;
    private MeasurementManagerFutures zzg;
    private Boolean zzh;
    private Integer zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpp(zzic zzicVar) {
        super(zzicVar);
        this.zzi = null;
        this.zze = new AtomicLong(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MessageDigest zzQ() {
        MessageDigest messageDigest;
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzR(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        int i = 0;
        Preconditions.checkState(length > 0);
        long j = 0;
        for (int i2 = length - 1; i2 >= 0 && i2 >= bArr.length - 8; i2--) {
            j += (bArr[i2] & 255) << i;
            i += 8;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzS(Context context, boolean z) {
        Preconditions.checkNotNull(context);
        return zzT(context, "com.google.android.gms.measurement.AppMeasurementJobService");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzT(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    static final boolean zzaA(Bundle bundle, int i) {
        if (bundle != null && bundle.getLong("_err") == 0) {
            bundle.putLong("_err", i);
            return true;
        }
        return false;
    }

    private final Object zzaB(int i, Object obj, boolean z, boolean z2, String str) {
        Parcelable[] parcelableArr;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                if (z2 && ((obj instanceof Bundle[]) || (obj instanceof Parcelable[]))) {
                    ArrayList arrayList = new ArrayList();
                    for (Parcelable parcelable : (Parcelable[]) obj) {
                        if (parcelable instanceof Bundle) {
                            Bundle zzae = zzae((Bundle) parcelable, null);
                            if (!zzae.isEmpty()) {
                                arrayList.add(zzae);
                            }
                        }
                    }
                    return arrayList.toArray(new Bundle[arrayList.size()]);
                }
                return null;
            }
            return zzE(obj.toString(), i, z);
        }
    }

    private final int zzaC(String str) {
        if ("_ldl".equals(str)) {
            this.zzu.zzc();
            return 2048;
        } else if (APEZProvider.FILEID.equals(str)) {
            this.zzu.zzc();
            return 256;
        } else if (!"_lgclid".equals(str)) {
            this.zzu.zzc();
            return 36;
        } else {
            this.zzu.zzc();
            return 100;
        }
    }

    private static boolean zzaD(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean zzaE(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals("*") || Arrays.asList(str.split(StringUtils.COMMA)).contains(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzac(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static boolean zzai(String str) {
        return !zzc[0].equals(str);
    }

    public static ArrayList zzav(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzah zzahVar = (zzah) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzahVar.zza);
            bundle.putString("origin", zzahVar.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, zzahVar.zzd);
            bundle.putString("name", zzahVar.zzc.zzb);
            zzjh.zza(bundle, Preconditions.checkNotNull(zzahVar.zzc.zza()));
            bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, zzahVar.zze);
            String str = zzahVar.zzf;
            if (str != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str);
            }
            zzbh zzbhVar = zzahVar.zzg;
            if (zzbhVar != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, zzbhVar.zza);
                zzbf zzbfVar = zzbhVar.zzb;
                if (zzbfVar != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, zzbfVar.zzf());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, zzahVar.zzh);
            zzbh zzbhVar2 = zzahVar.zzi;
            if (zzbhVar2 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, zzbhVar2.zza);
                zzbf zzbfVar2 = zzbhVar2.zzb;
                if (zzbfVar2 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, zzbfVar2.zzf());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, zzahVar.zzc.zzc);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, zzahVar.zzj);
            zzbh zzbhVar3 = zzahVar.zzk;
            if (zzbhVar3 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, zzbhVar3.zza);
                zzbf zzbfVar3 = zzbhVar3.zzb;
                if (zzbfVar3 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, zzbfVar3.zzf());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzax(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static void zzay(zzlu zzluVar, Bundle bundle, boolean z) {
        if (bundle != null && zzluVar != null) {
            if (!bundle.containsKey("_sc") || z) {
                String str = zzluVar.zza;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = zzluVar.zzb;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", zzluVar.zzc);
                return;
            }
            z = false;
        }
        if (bundle != null && zzluVar == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzh(String str) {
        Preconditions.checkNotEmpty(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzA(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String obj2 = obj.toString();
            if (obj2.codePointCount(0, obj2.length()) > i) {
                this.zzu.zzaW().zzh().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(obj2.length()));
                return false;
            }
        }
        return true;
    }

    final void zzB(String str, String str2, String str3, Bundle bundle, List list, boolean z) {
        int zzt;
        int zzF;
        List list2 = list;
        if (bundle == null) {
            return;
        }
        zzic zzicVar = this.zzu;
        int i = true != zzicVar.zzc().zzu.zzk().zzaj(231100000, true) ? 0 : 35;
        int i2 = 0;
        boolean z2 = false;
        for (String str4 : new TreeSet(bundle.keySet())) {
            if (list2 == null || !list2.contains(str4)) {
                zzt = !z ? zzt(str4) : 0;
                if (zzt == 0) {
                    zzt = zzu(str4);
                }
            } else {
                zzt = 0;
            }
            if (zzt != 0) {
                zzL(bundle, zzt, str4, zzt == 3 ? str4 : null);
                bundle.remove(str4);
            } else {
                if (zzz(bundle.get(str4))) {
                    zzicVar.zzaW().zzh().zzd("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str4);
                    zzF = 22;
                } else {
                    zzF = zzF(str, str2, str4, bundle.get(str4), bundle, list2, z, false);
                }
                if (zzF != 0 && !"_ev".equals(str4)) {
                    zzL(bundle, zzF, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (zzh(str4) && !zzaD(str4, zzjn.zzd)) {
                    i2++;
                    if (!zzaj(231100000, true)) {
                        zzicVar.zzaW().zzd().zzc("Item array not supported on client's version of Google Play Services (Android Only)", zzicVar.zzl().zza(str2), zzicVar.zzl().zze(bundle));
                        zzaA(bundle, 23);
                        bundle.remove(str4);
                    } else if (i2 > i) {
                        if (!z2) {
                            zzgs zzd = zzicVar.zzaW().zzd();
                            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 55);
                            sb.append("Item can't contain more than ");
                            sb.append(i);
                            sb.append(" item-scoped custom params");
                            zzd.zzc(sb.toString(), zzicVar.zzl().zza(str2), zzicVar.zzl().zze(bundle));
                        }
                        zzaA(bundle, 28);
                        bundle.remove(str4);
                        list2 = list;
                        z2 = true;
                    }
                }
            }
            list2 = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzC(String str) {
        if (TextUtils.isEmpty(str)) {
            this.zzu.zzaW().zzd().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        Preconditions.checkNotNull(str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            return true;
        }
        this.zzu.zzaW().zzd().zzb("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzgu.zzl(str));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzD(String str, String str2) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            Preconditions.checkNotNull(str);
            if (!str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public final String zzE(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) > i) {
            if (z) {
                String substring = str.substring(0, str.offsetByCodePoints(0, i));
                String.valueOf(substring);
                return String.valueOf(substring).concat("...");
            }
            return null;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final int zzF(String str, String str2, String str3, Object obj, Bundle bundle, List list, boolean z, boolean z2) {
        int i;
        int zzf;
        Parcelable[] parcelableArr;
        int size;
        zzg();
        if (zzz(obj)) {
            if (!z2) {
                return 21;
            }
            if (!zzaD(str3, zzjn.zzc)) {
                return 20;
            }
            zznl zzt = this.zzu.zzt();
            zzt.zzg();
            zzt.zzb();
            if (zzt.zzK() && zzt.zzu.zzk().zzak() < 200900) {
                return 25;
            }
            zzic zzicVar = this.zzu;
            zzicVar.zzc();
            boolean z3 = obj instanceof Parcelable[];
            if (z3) {
                size = ((Parcelable[]) obj).length;
            } else if (obj instanceof ArrayList) {
                size = ((ArrayList) obj).size();
            }
            if (size > 200) {
                zzicVar.zzaW().zzh().zzd("Parameter array is too long; discarded. Value kind, name, array length", "param", str3, Integer.valueOf(size));
                zzicVar.zzc();
                if (z3) {
                    Parcelable[] parcelableArr2 = (Parcelable[]) obj;
                    if (parcelableArr2.length > 200) {
                        bundle.putParcelableArray(str3, (Parcelable[]) Arrays.copyOf(parcelableArr2, 200));
                    }
                } else if (obj instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (arrayList.size() > 200) {
                        bundle.putParcelableArrayList(str3, new ArrayList<>(arrayList.subList(0, 200)));
                    }
                }
                i = 17;
                if (!zzac(str2) || zzac(str3)) {
                    zzf = this.zzu.zzc().zzf(null, false);
                } else {
                    zzf = this.zzu.zzc().zze(null, false);
                }
                if (!zzA("param", str3, zzf, obj)) {
                    if (!z2) {
                        return 4;
                    }
                    if (obj instanceof Bundle) {
                        zzB(str, str2, str3, (Bundle) obj, list, z);
                        return i;
                    } else if (obj instanceof Parcelable[]) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                zzB(str, str2, str3, (Bundle) parcelable, list, z);
                            } else {
                                this.zzu.zzaW().zzh().zzc("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str3);
                                return 4;
                            }
                        }
                    } else if (!(obj instanceof ArrayList)) {
                        return 4;
                    } else {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size2 = arrayList2.size();
                        for (int i2 = 0; i2 < size2; i2++) {
                            Object obj2 = arrayList2.get(i2);
                            if (obj2 instanceof Bundle) {
                                zzB(str, str2, str3, (Bundle) obj2, list, z);
                            } else {
                                this.zzu.zzaW().zzh().zzc("All ArrayList elements must be of type Bundle. Value type, name", obj2 != null ? obj2.getClass() : AbstractJsonLexerKt.NULL, str3);
                                return 4;
                            }
                        }
                    }
                }
                return i;
            }
        }
        i = 0;
        if (!zzac(str2)) {
        }
        zzf = this.zzu.zzc().zzf(null, false);
        if (!zzA("param", str3, zzf, obj)) {
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object zzG(String str, Object obj) {
        int zze;
        if ("_ev".equals(str)) {
            return zzaB(this.zzu.zzc().zzf(null, false), obj, true, true, null);
        }
        if (!zzac(str)) {
            zze = this.zzu.zzc().zze(null, false);
        } else {
            zze = this.zzu.zzc().zzf(null, false);
        }
        return zzaB(zze, obj, false, true, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zzH(String str, String str2, Bundle bundle, List list, boolean z) {
        int zzt;
        List list2 = list;
        boolean zzaD = zzaD(str2, zzjm.zzg);
        if (bundle != null) {
            Bundle bundle2 = new Bundle(bundle);
            zzic zzicVar = this.zzu;
            int zzc2 = zzicVar.zzc().zzc();
            int i = 0;
            boolean z2 = false;
            for (String str3 : new TreeSet(bundle.keySet())) {
                if (list2 == null || !list2.contains(str3)) {
                    zzt = !z ? zzt(str3) : 0;
                    if (zzt == 0) {
                        zzt = zzu(str3);
                    }
                } else {
                    zzt = 0;
                }
                if (zzt != 0) {
                    zzL(bundle2, zzt, str3, zzt == 3 ? str3 : null);
                    bundle2.remove(str3);
                } else {
                    int zzF = zzF(str, str2, str3, bundle.get(str3), bundle2, list2, z, zzaD);
                    if (zzF == 17) {
                        zzL(bundle2, 17, str3, false);
                    } else if (zzF != 0 && !"_ev".equals(str3)) {
                        zzL(bundle2, zzF, zzF == 21 ? str2 : str3, bundle.get(str3));
                        bundle2.remove(str3);
                    }
                    if (zzh(str3) && (i = i + 1) > zzc2) {
                        if (!z2) {
                            StringBuilder sb = new StringBuilder(String.valueOf(zzc2).length() + 37);
                            sb.append("Event can't contain more than ");
                            sb.append(zzc2);
                            sb.append(" params");
                            zzicVar.zzaW().zzd().zzc(sb.toString(), zzicVar.zzl().zza(str2), zzicVar.zzl().zze(bundle));
                        }
                        zzaA(bundle2, 5);
                        bundle2.remove(str3);
                        z2 = true;
                    }
                }
                list2 = list;
            }
            return bundle2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzI(zzgv zzgvVar, int i) {
        Bundle bundle = zzgvVar.zze;
        int i2 = 0;
        boolean z = false;
        for (String str : new TreeSet(bundle.keySet())) {
            if (zzh(str) && (i2 = i2 + 1) > i) {
                if (!z) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 37);
                    sb.append("Event can't contain more than ");
                    sb.append(i);
                    sb.append(" params");
                    String sb2 = sb.toString();
                    zzic zzicVar = this.zzu;
                    zzicVar.zzaW().zzd().zzc(sb2, zzicVar.zzl().zza(zzgvVar.zza), zzicVar.zzl().zze(bundle));
                    zzaA(bundle, 5);
                }
                bundle.remove(str);
                z = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzJ(Parcelable[] parcelableArr, int i) {
        Preconditions.checkNotNull(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            int i2 = 0;
            boolean z = false;
            for (String str : new TreeSet(bundle.keySet())) {
                if (zzh(str) && !zzaD(str, zzjn.zzd) && (i2 = i2 + 1) > i) {
                    if (!z) {
                        zzic zzicVar = this.zzu;
                        zzgs zzd = zzicVar.zzaW().zzd();
                        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 60);
                        sb.append("Param can't contain more than ");
                        sb.append(i);
                        sb.append(" item-scoped custom parameters");
                        zzd.zzc(sb.toString(), zzicVar.zzl().zzb(str), zzicVar.zzl().zze(bundle));
                    }
                    zzaA(bundle, 28);
                    bundle.remove(str);
                    z = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzK(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                this.zzu.zzk().zzO(bundle, str, bundle2.get(str));
            }
        }
    }

    final void zzL(Bundle bundle, int i, String str, Object obj) {
        if (zzaA(bundle, i)) {
            this.zzu.zzc();
            bundle.putString("_ev", zzE(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", obj.toString().length());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzM(String str, Object obj) {
        boolean zzA;
        if ("_ldl".equals(str)) {
            zzA = zzA("user property referrer", str, zzaC(str), obj);
        } else {
            zzA = zzA("user property", str, zzaC(str), obj);
        }
        return zzA ? 0 : 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object zzN(String str, Object obj) {
        return "_ldl".equals(str) ? zzaB(zzaC(str), obj, true, false, null) : zzaB(zzaC(str), obj, false, false, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzO(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            String simpleName = obj != null ? obj.getClass().getSimpleName() : null;
            zzic zzicVar = this.zzu;
            zzicVar.zzaW().zzh().zzc("Not putting event parameter. Invalid value type. name, type", zzicVar.zzl().zzb(str), simpleName);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzP(zzpo zzpoVar, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zzaA(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i2);
        }
        zzpoVar.zza(str, "_err", bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzU() {
        zzg();
        return zzX() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MeasurementManagerFutures zzV() {
        if (this.zzg == null) {
            this.zzg = MeasurementManagerFutures.from(this.zzu.zzaZ());
        }
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzW() {
        if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
            return 0;
        }
        return SdkExtensions.getExtensionVersion(1000000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzX() {
        long j;
        zzg();
        if (zzZ(this.zzu.zzv().zzj())) {
            if (Build.VERSION.SDK_INT < 30) {
                j = 4;
            } else if (SdkExtensions.getExtensionVersion(30) < 4) {
                j = 8;
            } else {
                zzic zzicVar = this.zzu;
                int zzW = zzW();
                zzicVar.zzc();
                j = zzW < ((Integer) zzfy.zzak.zzb(null)).intValue() ? 16L : 0L;
            }
            if (!zzab("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")) {
                j |= 2;
            }
            if (j == 0 && !zzY()) {
                j = 64;
            }
            if (j == 0) {
                return 1L;
            }
            return j;
        }
        return 0L;
    }

    final boolean zzY() {
        Object e;
        Integer num;
        boolean z;
        if (this.zzh == null) {
            MeasurementManagerFutures zzV = zzV();
            if (zzV == null) {
                return false;
            }
            try {
                num = zzV.getMeasurementApiStatusAsync().get(10000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException e2) {
                e = e2;
                num = null;
            }
            if (num != null) {
                try {
                    z = true;
                } catch (InterruptedException e3) {
                    e = e3;
                    this.zzu.zzaW().zze().zzb("Measurement manager api exception", e);
                    this.zzh = false;
                    this.zzu.zzaW().zzk().zzb("Measurement manager api status result", num);
                    return this.zzh.booleanValue();
                } catch (CancellationException e4) {
                    e = e4;
                    this.zzu.zzaW().zze().zzb("Measurement manager api exception", e);
                    this.zzh = false;
                    this.zzu.zzaW().zzk().zzb("Measurement manager api status result", num);
                    return this.zzh.booleanValue();
                } catch (ExecutionException e5) {
                    e = e5;
                    this.zzu.zzaW().zze().zzb("Measurement manager api exception", e);
                    this.zzh = false;
                    this.zzu.zzaW().zzk().zzb("Measurement manager api status result", num);
                    return this.zzh.booleanValue();
                } catch (TimeoutException e6) {
                    e = e6;
                    this.zzu.zzaW().zze().zzb("Measurement manager api exception", e);
                    this.zzh = false;
                    this.zzu.zzaW().zzk().zzb("Measurement manager api status result", num);
                    return this.zzh.booleanValue();
                }
                if (num.intValue() == 1) {
                    this.zzh = Boolean.valueOf(z);
                    this.zzu.zzaW().zzk().zzb("Measurement manager api status result", num);
                }
            }
            z = false;
            this.zzh = Boolean.valueOf(z);
            this.zzu.zzaW().zzk().zzb("Measurement manager api status result", num);
        }
        return this.zzh.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzZ(String str) {
        return zzaE((String) zzfy.zzaq.zzb(null), str);
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    protected final boolean zza() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzaa(String str) {
        return zzaE((String) zzfy.zzbg.zzb(null), str) || zzaE((String) zzfy.zzbh.zzb(null), str) || zzaE((String) zzfy.zzbi.zzb(null), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzab(String str) {
        zzg();
        zzic zzicVar = this.zzu;
        if (Wrappers.packageManager(zzicVar.zzaZ()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzicVar.zzaW().zzj().zzb("Permission not granted", str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzad(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            zzic zzicVar = this.zzu;
            String zzA = zzicVar.zzc().zzA();
            zzicVar.zzaV();
            return zzA.equals(str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zzae(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                Object zzG = zzG(str2, bundle.get(str2));
                if (zzG == null) {
                    zzic zzicVar = this.zzu;
                    zzicVar.zzaW().zzh().zzb("Param value can't be null", zzicVar.zzl().zzb(str2));
                } else {
                    zzO(bundle2, str2, zzG);
                }
            }
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbh zzaf(String str, String str2, Bundle bundle, String str3, long j, long j2, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zzp(str2) != 0) {
            zzic zzicVar = this.zzu;
            zzicVar.zzaW().zzb().zzb("Invalid conditional property event name", zzicVar.zzl().zzc(str2));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str3);
        Bundle zzH = zzH(str, str2, bundle2, CollectionUtils.listOf("_o"), true);
        if (z) {
            zzH = zzae(zzH, str);
        }
        Preconditions.checkNotNull(zzH);
        return new zzbh(str2, new zzbf(zzH), str3, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzag(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e) {
            this.zzu.zzaW().zzb().zzb("Package name not found", e);
            return true;
        } catch (CertificateException e2) {
            this.zzu.zzaW().zzb().zzb("Error obtaining certificate", e2);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] zzah(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public final boolean zzaj(int i, boolean z) {
        Boolean zzJ = this.zzu.zzt().zzJ();
        if (zzak() < i / 1000) {
            return (zzJ == null || zzJ.booleanValue()) ? false : true;
        }
        return true;
    }

    @EnsuresNonNull({"this.apkVersion"})
    public final int zzak() {
        if (this.zzi == null) {
            this.zzi = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzu.zzaZ()) / 1000);
        }
        return this.zzi.intValue();
    }

    public final int zzal(int i) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(this.zzu.zzaZ(), GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public final long zzam(long j, long j2) {
        return (j + (j2 * 60000)) / 86400000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzan(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            this.zzu.zzaW().zze().zzb("Params already contained engagement", Long.valueOf(j2));
        } else {
            j2 = 0;
        }
        bundle.putLong("_et", j + j2);
    }

    public final void zzao(com.google.android.gms.internal.measurement.zzcs zzcsVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzcsVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zze().zzb("Error returning string value to wrapper", e);
        }
    }

    public final void zzap(com.google.android.gms.internal.measurement.zzcs zzcsVar, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            zzcsVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zze().zzb("Error returning long value to wrapper", e);
        }
    }

    public final void zzaq(com.google.android.gms.internal.measurement.zzcs zzcsVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            zzcsVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zze().zzb("Error returning int value to wrapper", e);
        }
    }

    public final void zzar(com.google.android.gms.internal.measurement.zzcs zzcsVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzcsVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zze().zzb("Error returning byte array to wrapper", e);
        }
    }

    public final void zzas(com.google.android.gms.internal.measurement.zzcs zzcsVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zzcsVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zze().zzb("Error returning boolean value to wrapper", e);
        }
    }

    public final void zzat(com.google.android.gms.internal.measurement.zzcs zzcsVar, Bundle bundle) {
        try {
            zzcsVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zze().zzb("Error returning bundle value to wrapper", e);
        }
    }

    public final void zzau(com.google.android.gms.internal.measurement.zzcs zzcsVar, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzcsVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaW().zze().zzb("Error returning bundle list to wrapper", e);
        }
    }

    public final URL zzaw(long j, String str, String str2, long j2, String str3) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", 161000L, Integer.valueOf(zzak())), str2, str, Long.valueOf(j2));
            if (str.equals(this.zzu.zzc().zzB())) {
                format = format.concat("&ddl_test=1");
            }
            if (!str3.isEmpty()) {
                if (str3.charAt(0) != '&') {
                    format = format.concat("&");
                }
                format = format.concat(str3);
            }
            return new URL(format);
        } catch (IllegalArgumentException | MalformedURLException e) {
            this.zzu.zzaW().zzb().zzb("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzaz() {
        byte[] bArr = new byte[16];
        zzf().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    protected final void zzbb() {
        zzg();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                this.zzu.zzaW().zze().zza("Utils falling back to Random for random id");
            }
        }
        this.zze.set(nextLong);
    }

    public final long zzd() {
        long andIncrement;
        long j;
        AtomicLong atomicLong = this.zze;
        if (atomicLong.get() == 0) {
            synchronized (atomicLong) {
                long nextLong = new Random(System.nanoTime() ^ this.zzu.zzba().currentTimeMillis()).nextLong();
                int i = this.zzf + 1;
                this.zzf = i;
                j = nextLong + i;
            }
            return j;
        }
        AtomicLong atomicLong2 = this.zze;
        synchronized (atomicLong2) {
            atomicLong2.compareAndSet(-1L, 1L);
            andIncrement = atomicLong2.getAndIncrement();
        }
        return andIncrement;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @EnsuresNonNull({"this.secureRandom"})
    public final SecureRandom zzf() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new SecureRandom();
        }
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zzi(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        if (uri != null) {
            try {
                if (uri.isHierarchical()) {
                    str = uri.getQueryParameter("utm_campaign");
                    str2 = uri.getQueryParameter("utm_source");
                    str3 = uri.getQueryParameter("utm_medium");
                    str4 = uri.getQueryParameter("gclid");
                    str5 = uri.getQueryParameter("gbraid");
                    str6 = uri.getQueryParameter("utm_id");
                    str7 = uri.getQueryParameter("dclid");
                    str8 = uri.getQueryParameter("srsltid");
                    str9 = uri.getQueryParameter("sfmc_id");
                } else {
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                    str5 = null;
                    str6 = null;
                    str7 = null;
                    str8 = null;
                    str9 = null;
                }
                if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5) && TextUtils.isEmpty(str6) && TextUtils.isEmpty(str7) && TextUtils.isEmpty(str8) && TextUtils.isEmpty(str9)) {
                    return null;
                }
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(str)) {
                    bundle.putString("campaign", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    bundle.putString("source", str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    bundle.putString("medium", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    bundle.putString("gclid", str4);
                }
                if (!TextUtils.isEmpty(str5)) {
                    bundle.putString("gbraid", str5);
                }
                String queryParameter = uri.getQueryParameter("gad_source");
                if (!TextUtils.isEmpty(queryParameter)) {
                    bundle.putString("gad_source", queryParameter);
                }
                String queryParameter2 = uri.getQueryParameter("utm_term");
                if (!TextUtils.isEmpty(queryParameter2)) {
                    bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter2);
                }
                String queryParameter3 = uri.getQueryParameter("utm_content");
                if (!TextUtils.isEmpty(queryParameter3)) {
                    bundle.putString(FirebaseAnalytics.Param.CONTENT, queryParameter3);
                }
                String queryParameter4 = uri.getQueryParameter(FirebaseAnalytics.Param.ACLID);
                if (!TextUtils.isEmpty(queryParameter4)) {
                    bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter4);
                }
                String queryParameter5 = uri.getQueryParameter(FirebaseAnalytics.Param.CP1);
                if (!TextUtils.isEmpty(queryParameter5)) {
                    bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter5);
                }
                String queryParameter6 = uri.getQueryParameter("anid");
                if (!TextUtils.isEmpty(queryParameter6)) {
                    bundle.putString("anid", queryParameter6);
                }
                if (!TextUtils.isEmpty(str6)) {
                    bundle.putString(FirebaseAnalytics.Param.CAMPAIGN_ID, str6);
                }
                if (!TextUtils.isEmpty(str7)) {
                    bundle.putString("dclid", str7);
                }
                String queryParameter7 = uri.getQueryParameter("utm_source_platform");
                if (!TextUtils.isEmpty(queryParameter7)) {
                    bundle.putString(FirebaseAnalytics.Param.SOURCE_PLATFORM, queryParameter7);
                }
                String queryParameter8 = uri.getQueryParameter("utm_creative_format");
                if (!TextUtils.isEmpty(queryParameter8)) {
                    bundle.putString(FirebaseAnalytics.Param.CREATIVE_FORMAT, queryParameter8);
                }
                String queryParameter9 = uri.getQueryParameter("utm_marketing_tactic");
                if (!TextUtils.isEmpty(queryParameter9)) {
                    bundle.putString(FirebaseAnalytics.Param.MARKETING_TACTIC, queryParameter9);
                }
                if (!TextUtils.isEmpty(str8)) {
                    bundle.putString("srsltid", str8);
                }
                if (!TextUtils.isEmpty(str9)) {
                    bundle.putString("sfmc_id", str9);
                }
                for (String str10 : uri.getQueryParameterNames()) {
                    if (str10.startsWith("gad_")) {
                        String queryParameter10 = uri.getQueryParameter(str10);
                        if (!TextUtils.isEmpty(queryParameter10)) {
                            bundle.putString(str10, queryParameter10);
                        }
                    }
                }
                zzic zzicVar = this.zzu;
                if (zzicVar.zzc().zzp(null, zzfy.zzba)) {
                    String uri2 = new Uri.Builder().scheme(uri.getScheme()).authority(uri.getAuthority()).path(uri.getPath()).build().toString();
                    int zzf = zzicVar.zzc().zzf(null, false);
                    if (uri2.length() > zzf) {
                        uri2 = zzE(uri2, zzf - 3, true);
                    }
                    if (!TextUtils.isEmpty(uri2)) {
                        bundle.putString("deep_link_url", uri2);
                    }
                }
                return bundle;
            } catch (UnsupportedOperationException e) {
                this.zzu.zzaW().zze().zzb("Install referrer url isn't a hierarchical URI", e);
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzj(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) {
            return true;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            return false;
        }
        try {
            String host = new URL(stringExtra).getHost();
            if (TextUtils.isEmpty(host)) {
                return false;
            }
            return host.matches("^(www\\.)?google(\\.com?)?(\\.[a-z]{2}t?)?$");
        } catch (MalformedURLException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzk(String str, String str2) {
        if (str2 == null) {
            this.zzu.zzaW().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.zzu.zzaW().zzd().zzb("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                this.zzu.zzaW().zzd().zzc("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    this.zzu.zzaW().zzd().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzl(String str, String str2) {
        if (str2 == null) {
            this.zzu.zzaW().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.zzu.zzaW().zzd().zzb("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                if (codePointAt != 95) {
                    this.zzu.zzaW().zzd().zzc("Name must start with a letter or _ (underscore). Type, name", str, str2);
                    return false;
                }
                codePointAt = 95;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    this.zzu.zzaW().zzd().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzm(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.zzu.zzaW().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr3 = zzb;
        for (int i = 0; i < 3; i++) {
            if (str2.startsWith(strArr3[i])) {
                this.zzu.zzaW().zzd().zzc("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !zzaD(str2, strArr)) {
            return true;
        }
        if (strArr2 == null || !zzaD(str2, strArr2)) {
            this.zzu.zzaW().zzd().zzc("Name is reserved. Type, name", str, str2);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzn(String str, int i, String str2) {
        if (str2 == null) {
            this.zzu.zzaW().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) > i) {
            this.zzu.zzaW().zzd().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzp(String str) {
        if (zzl(NotificationCompat.CATEGORY_EVENT, str)) {
            zzic zzicVar = this.zzu;
            if (zzm(NotificationCompat.CATEGORY_EVENT, zzjm.zza, zzicVar.zzc().zzp(null, zzfy.zzbf) ? zzjm.zzc : zzjm.zzb, str)) {
                zzicVar.zzc();
                return !zzn(NotificationCompat.CATEGORY_EVENT, 40, str) ? 2 : 0;
            }
            return 13;
        }
        return 2;
    }

    public final boolean zzq(String str) {
        if (this.zzu.zzc().zzp(null, zzfy.zzbf)) {
            return zzaD(str, zzjm.zze);
        }
        return zzaD(str, zzjm.zzd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzs(String str) {
        if (zzl("user property", str)) {
            if (zzm("user property", zzjo.zza, null, str)) {
                this.zzu.zzc();
                return !zzn("user property", 24, str) ? 6 : 0;
            }
            return 15;
        }
        return 6;
    }

    final int zzt(String str) {
        if (zzk("event param", str)) {
            if (zzm("event param", null, null, str)) {
                this.zzu.zzc();
                return !zzn("event param", 40, str) ? 3 : 0;
            }
            return 14;
        }
        return 3;
    }

    final int zzu(String str) {
        if (zzl("event param", str)) {
            if (zzm("event param", null, null, str)) {
                this.zzu.zzc();
                return !zzn("event param", 40, str) ? 3 : 0;
            }
            return 14;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzz(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }
}
