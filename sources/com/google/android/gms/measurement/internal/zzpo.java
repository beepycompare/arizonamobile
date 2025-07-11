package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
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
import androidx.compose.material3.internal.CalendarModelKt;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.Renderer;
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
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzpo extends zzje {
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
    public zzpo(zzib zzibVar) {
        super(zzibVar);
        this.zzi = null;
        this.zze = new AtomicLong(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MessageDigest zzO() {
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
    public static long zzP(byte[] bArr) {
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
    public static boolean zzQ(Context context, boolean z) {
        Preconditions.checkNotNull(context);
        return zzR(context, "com.google.android.gms.measurement.AppMeasurementJobService");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzR(Context context, String str) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzZ(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    private static boolean zzaA(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean zzaf(String str) {
        return !zzc[0].equals(str);
    }

    public static ArrayList zzas(List list) {
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
            zzjg.zza(bundle, Preconditions.checkNotNull(zzahVar.zzc.zza()));
            bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, zzahVar.zze);
            String str = zzahVar.zzf;
            if (str != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str);
            }
            zzbg zzbgVar = zzahVar.zzg;
            if (zzbgVar != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, zzbgVar.zza);
                zzbe zzbeVar = zzbgVar.zzb;
                if (zzbeVar != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, zzbeVar.zzf());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, zzahVar.zzh);
            zzbg zzbgVar2 = zzahVar.zzi;
            if (zzbgVar2 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, zzbgVar2.zza);
                zzbe zzbeVar2 = zzbgVar2.zzb;
                if (zzbeVar2 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, zzbeVar2.zzf());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, zzahVar.zzc.zzc);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, zzahVar.zzj);
            zzbg zzbgVar3 = zzahVar.zzk;
            if (zzbgVar3 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, zzbgVar3.zza);
                zzbe zzbeVar3 = zzbgVar3.zzb;
                if (zzbeVar3 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, zzbeVar3.zzf());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzau(Context context) {
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

    public static void zzav(zzlt zzltVar, Bundle bundle, boolean z) {
        if (bundle != null && zzltVar != null) {
            if (!bundle.containsKey("_sc") || z) {
                String str = zzltVar.zza;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = zzltVar.zzb;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", zzltVar.zzc);
                return;
            }
            z = false;
        }
        if (bundle != null && zzltVar == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    static final boolean zzax(Bundle bundle, int i) {
        if (bundle != null && bundle.getLong("_err") == 0) {
            bundle.putLong("_err", i);
            return true;
        }
        return false;
    }

    private final Object zzay(int i, Object obj, boolean z, boolean z2, String str) {
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
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return zzC(obj.toString(), i, z);
            }
            if (z2 && ((obj instanceof Bundle[]) || (obj instanceof Parcelable[]))) {
                ArrayList arrayList = new ArrayList();
                for (Parcelable parcelable : (Parcelable[]) obj) {
                    if (parcelable instanceof Bundle) {
                        Bundle zzab = zzab((Bundle) parcelable, null);
                        if (!zzab.isEmpty()) {
                            arrayList.add(zzab);
                        }
                    }
                }
                return arrayList.toArray(new Bundle[arrayList.size()]);
            }
            return null;
        }
    }

    private final int zzaz(String str) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzh(String str) {
        Preconditions.checkNotEmpty(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzA(String str) {
        if (TextUtils.isEmpty(str)) {
            this.zzu.zzaV().zzd().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        Preconditions.checkNotNull(str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            return true;
        }
        this.zzu.zzaV().zzd().zzb("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzgt.zzl(str));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzB(String str, String str2) {
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

    public final String zzC(String str, int i, boolean z) {
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
    final int zzD(String str, String str2, String str3, Object obj, Bundle bundle, List list, boolean z, boolean z2) {
        int i;
        int zzf;
        Parcelable[] parcelableArr;
        int size;
        zzg();
        if (zzt(obj)) {
            if (!z2) {
                return 21;
            }
            if (!zzaA(str3, zzjm.zzc)) {
                return 20;
            }
            zznk zzt = this.zzu.zzt();
            zzt.zzg();
            zzt.zzb();
            if (zzt.zzK() && zzt.zzu.zzk().zzah() < 200900) {
                return 25;
            }
            zzib zzibVar = this.zzu;
            zzibVar.zzc();
            boolean z3 = obj instanceof Parcelable[];
            if (z3) {
                size = ((Parcelable[]) obj).length;
            } else if (obj instanceof ArrayList) {
                size = ((ArrayList) obj).size();
            }
            if (size > 200) {
                zzibVar.zzaV().zzh().zzd("Parameter array is too long; discarded. Value kind, name, array length", "param", str3, Integer.valueOf(size));
                zzibVar.zzc();
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
                if (!zzZ(str2) || zzZ(str3)) {
                    zzf = this.zzu.zzc().zzf(null, false);
                } else {
                    zzf = this.zzu.zzc().zze(null, false);
                }
                if (!zzu("param", str3, zzf, obj)) {
                    if (!z2) {
                        return 4;
                    }
                    if (obj instanceof Bundle) {
                        zzz(str, str2, str3, (Bundle) obj, list, z);
                        return i;
                    } else if (obj instanceof Parcelable[]) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                zzz(str, str2, str3, (Bundle) parcelable, list, z);
                            } else {
                                this.zzu.zzaV().zzh().zzc("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str3);
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
                                zzz(str, str2, str3, (Bundle) obj2, list, z);
                            } else {
                                this.zzu.zzaV().zzh().zzc("All ArrayList elements must be of type Bundle. Value type, name", obj2 != null ? obj2.getClass() : AbstractJsonLexerKt.NULL, str3);
                                return 4;
                            }
                        }
                    }
                }
                return i;
            }
        }
        i = 0;
        if (!zzZ(str2)) {
        }
        zzf = this.zzu.zzc().zzf(null, false);
        if (!zzu("param", str3, zzf, obj)) {
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object zzE(String str, Object obj) {
        int zze;
        if ("_ev".equals(str)) {
            return zzay(this.zzu.zzc().zzf(null, false), obj, true, true, null);
        }
        if (!zzZ(str)) {
            zze = this.zzu.zzc().zze(null, false);
        } else {
            zze = this.zzu.zzc().zzf(null, false);
        }
        return zzay(zze, obj, false, true, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zzF(String str, String str2, Bundle bundle, List list, boolean z) {
        int zzq;
        List list2 = list;
        boolean zzaA = zzaA(str2, zzjl.zzd);
        if (bundle != null) {
            Bundle bundle2 = new Bundle(bundle);
            zzib zzibVar = this.zzu;
            int zzc2 = zzibVar.zzc().zzc();
            int i = 0;
            boolean z2 = false;
            for (String str3 : new TreeSet(bundle.keySet())) {
                if (list2 == null || !list2.contains(str3)) {
                    zzq = !z ? zzq(str3) : 0;
                    if (zzq == 0) {
                        zzq = zzs(str3);
                    }
                } else {
                    zzq = 0;
                }
                if (zzq != 0) {
                    zzJ(bundle2, zzq, str3, zzq == 3 ? str3 : null);
                    bundle2.remove(str3);
                } else {
                    int zzD = zzD(str, str2, str3, bundle.get(str3), bundle2, list2, z, zzaA);
                    if (zzD == 17) {
                        zzJ(bundle2, 17, str3, false);
                    } else if (zzD != 0 && !"_ev".equals(str3)) {
                        zzJ(bundle2, zzD, zzD == 21 ? str2 : str3, bundle.get(str3));
                        bundle2.remove(str3);
                    }
                    if (zzh(str3) && (i = i + 1) > zzc2) {
                        if (!zzibVar.zzc().zzp(null, zzfx.zzbf) || !z2) {
                            StringBuilder sb = new StringBuilder(String.valueOf(zzc2).length() + 37);
                            sb.append("Event can't contain more than ");
                            sb.append(zzc2);
                            sb.append(" params");
                            zzibVar.zzaV().zzd().zzc(sb.toString(), zzibVar.zzl().zza(str2), zzibVar.zzl().zze(bundle));
                        }
                        zzax(bundle2, 5);
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
    public final void zzG(zzgu zzguVar, int i) {
        Bundle bundle = zzguVar.zzd;
        int i2 = 0;
        boolean z = false;
        for (String str : new TreeSet(bundle.keySet())) {
            if (zzh(str) && (i2 = i2 + 1) > i) {
                zzib zzibVar = this.zzu;
                if (!zzibVar.zzc().zzp(null, zzfx.zzbf) || !z) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 37);
                    sb.append("Event can't contain more than ");
                    sb.append(i);
                    sb.append(" params");
                    zzibVar.zzaV().zzd().zzc(sb.toString(), zzibVar.zzl().zza(zzguVar.zza), zzibVar.zzl().zze(bundle));
                    zzax(bundle, 5);
                }
                bundle.remove(str);
                z = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzH(Parcelable[] parcelableArr, int i) {
        Preconditions.checkNotNull(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            int i2 = 0;
            boolean z = false;
            for (String str : new TreeSet(bundle.keySet())) {
                if (zzh(str) && !zzaA(str, zzjm.zzd) && (i2 = i2 + 1) > i) {
                    zzib zzibVar = this.zzu;
                    if (!zzibVar.zzc().zzp(null, zzfx.zzbf) || !z) {
                        zzgr zzd = zzibVar.zzaV().zzd();
                        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 60);
                        sb.append("Param can't contain more than ");
                        sb.append(i);
                        sb.append(" item-scoped custom parameters");
                        zzd.zzc(sb.toString(), zzibVar.zzl().zzb(str), zzibVar.zzl().zze(bundle));
                    }
                    zzax(bundle, 28);
                    bundle.remove(str);
                    z = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzI(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                this.zzu.zzk().zzM(bundle, str, bundle2.get(str));
            }
        }
    }

    final void zzJ(Bundle bundle, int i, String str, Object obj) {
        if (zzax(bundle, i)) {
            this.zzu.zzc();
            bundle.putString("_ev", zzC(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", obj.toString().length());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzK(String str, Object obj) {
        boolean zzu;
        if ("_ldl".equals(str)) {
            zzu = zzu("user property referrer", str, zzaz(str), obj);
        } else {
            zzu = zzu("user property", str, zzaz(str), obj);
        }
        return zzu ? 0 : 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object zzL(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return zzay(zzaz(str), obj, true, false, null);
        }
        return zzay(zzaz(str), obj, false, false, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzM(Bundle bundle, String str, Object obj) {
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
            zzib zzibVar = this.zzu;
            zzibVar.zzaV().zzh().zzc("Not putting event parameter. Invalid value type. name, type", zzibVar.zzl().zzb(str), simpleName);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzN(zzpn zzpnVar, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zzax(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i2);
        }
        zzpnVar.zza(str, "_err", bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzS() {
        zzg();
        return zzV() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MeasurementManagerFutures zzT() {
        if (this.zzg == null) {
            this.zzg = MeasurementManagerFutures.from(this.zzu.zzaY());
        }
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzU() {
        if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
            return 0;
        }
        return SdkExtensions.getExtensionVersion(1000000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzV() {
        long j;
        zzg();
        if (zzX(this.zzu.zzv().zzj())) {
            if (Build.VERSION.SDK_INT < 30) {
                j = 4;
            } else if (SdkExtensions.getExtensionVersion(30) < 4) {
                j = 8;
            } else {
                zzib zzibVar = this.zzu;
                int zzU = zzU();
                zzibVar.zzc();
                j = zzU < ((Integer) zzfx.zzal.zzb(null)).intValue() ? 16L : 0L;
            }
            if (!zzY("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")) {
                j |= 2;
            }
            if (j == 0 && !zzW()) {
                j = 64;
            }
            if (j == 0) {
                return 1L;
            }
            return j;
        }
        return 0L;
    }

    final boolean zzW() {
        Object e;
        Integer num;
        boolean z;
        if (this.zzh == null) {
            MeasurementManagerFutures zzT = zzT();
            if (zzT == null) {
                return false;
            }
            try {
                num = zzT.getMeasurementApiStatusAsync().get(Renderer.DEFAULT_DURATION_TO_PROGRESS_US, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException e2) {
                e = e2;
                num = null;
            }
            if (num != null) {
                try {
                    z = true;
                } catch (InterruptedException e3) {
                    e = e3;
                    this.zzu.zzaV().zze().zzb("Measurement manager api exception", e);
                    this.zzh = false;
                    this.zzu.zzaV().zzk().zzb("Measurement manager api status result", num);
                    return this.zzh.booleanValue();
                } catch (CancellationException e4) {
                    e = e4;
                    this.zzu.zzaV().zze().zzb("Measurement manager api exception", e);
                    this.zzh = false;
                    this.zzu.zzaV().zzk().zzb("Measurement manager api status result", num);
                    return this.zzh.booleanValue();
                } catch (ExecutionException e5) {
                    e = e5;
                    this.zzu.zzaV().zze().zzb("Measurement manager api exception", e);
                    this.zzh = false;
                    this.zzu.zzaV().zzk().zzb("Measurement manager api status result", num);
                    return this.zzh.booleanValue();
                } catch (TimeoutException e6) {
                    e = e6;
                    this.zzu.zzaV().zze().zzb("Measurement manager api exception", e);
                    this.zzh = false;
                    this.zzu.zzaV().zzk().zzb("Measurement manager api status result", num);
                    return this.zzh.booleanValue();
                }
                if (num.intValue() == 1) {
                    this.zzh = Boolean.valueOf(z);
                    this.zzu.zzaV().zzk().zzb("Measurement manager api status result", num);
                }
            }
            z = false;
            this.zzh = Boolean.valueOf(z);
            this.zzu.zzaV().zzk().zzb("Measurement manager api status result", num);
        }
        return this.zzh.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzX(String str) {
        String str2 = (String) zzfx.zzar.zzb(null);
        return str2.equals("*") || Arrays.asList(str2.split(StringUtils.COMMA)).contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzY(String str) {
        zzg();
        zzib zzibVar = this.zzu;
        if (Wrappers.packageManager(zzibVar.zzaY()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzibVar.zzaV().zzj().zzb("Permission not granted", str);
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzje
    protected final boolean zza() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzaa(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            zzib zzibVar = this.zzu;
            String zzA = zzibVar.zzc().zzA();
            zzibVar.zzaU();
            return zzA.equals(str);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zzab(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                Object zzE = zzE(str2, bundle.get(str2));
                if (zzE == null) {
                    zzib zzibVar = this.zzu;
                    zzibVar.zzaV().zzh().zzb("Param value can't be null", zzibVar.zzl().zzb(str2));
                } else {
                    zzM(bundle2, str2, zzE);
                }
            }
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbg zzac(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zzn(str2) != 0) {
            zzib zzibVar = this.zzu;
            zzibVar.zzaV().zzb().zzb("Invalid conditional property event name", zzibVar.zzl().zzc(str2));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str3);
        Bundle zzF = zzF(str, str2, bundle2, CollectionUtils.listOf("_o"), true);
        if (z) {
            zzF = zzab(zzF, str);
        }
        Preconditions.checkNotNull(zzF);
        return new zzbg(str2, new zzbe(zzF), str3, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzad(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e) {
            this.zzu.zzaV().zzb().zzb("Package name not found", e);
            return true;
        } catch (CertificateException e2) {
            this.zzu.zzaV().zzb().zzb("Error obtaining certificate", e2);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] zzae(Parcelable parcelable) {
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

    public final boolean zzag(int i, boolean z) {
        Boolean zzJ = this.zzu.zzt().zzJ();
        if (zzah() < i / 1000) {
            return (zzJ == null || zzJ.booleanValue()) ? false : true;
        }
        return true;
    }

    @EnsuresNonNull({"this.apkVersion"})
    public final int zzah() {
        if (this.zzi == null) {
            this.zzi = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzu.zzaY()) / 1000);
        }
        return this.zzi.intValue();
    }

    public final int zzai(int i) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(this.zzu.zzaY(), GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public final long zzaj(long j, long j2) {
        return (j + (j2 * 60000)) / CalendarModelKt.MillisecondsIn24Hours;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzak(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            this.zzu.zzaV().zze().zzb("Params already contained engagement", Long.valueOf(j2));
        } else {
            j2 = 0;
        }
        bundle.putLong("_et", j + j2);
    }

    public final void zzal(com.google.android.gms.internal.measurement.zzcu zzcuVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaV().zze().zzb("Error returning string value to wrapper", e);
        }
    }

    public final void zzam(com.google.android.gms.internal.measurement.zzcu zzcuVar, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaV().zze().zzb("Error returning long value to wrapper", e);
        }
    }

    public final void zzan(com.google.android.gms.internal.measurement.zzcu zzcuVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaV().zze().zzb("Error returning int value to wrapper", e);
        }
    }

    public final void zzao(com.google.android.gms.internal.measurement.zzcu zzcuVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaV().zze().zzb("Error returning byte array to wrapper", e);
        }
    }

    public final void zzap(com.google.android.gms.internal.measurement.zzcu zzcuVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaV().zze().zzb("Error returning boolean value to wrapper", e);
        }
    }

    public final void zzaq(com.google.android.gms.internal.measurement.zzcu zzcuVar, Bundle bundle) {
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaV().zze().zzb("Error returning bundle value to wrapper", e);
        }
    }

    public final void zzar(com.google.android.gms.internal.measurement.zzcu zzcuVar, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaV().zze().zzb("Error returning bundle list to wrapper", e);
        }
    }

    public final URL zzat(long j, String str, String str2, long j2, String str3) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", 130000L, Integer.valueOf(zzah())), str2, str, Long.valueOf(j2));
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
            this.zzu.zzaV().zzb().zzb("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzaw() {
        byte[] bArr = new byte[16];
        zzf().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    @Override // com.google.android.gms.measurement.internal.zzje
    protected final void zzba() {
        zzg();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                this.zzu.zzaV().zze().zza("Utils falling back to Random for random id");
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
                long nextLong = new Random(System.nanoTime() ^ this.zzu.zzaZ().currentTimeMillis()).nextLong();
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
        String str10;
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
                if (TextUtils.isEmpty(str)) {
                    str10 = "sfmc_id";
                } else {
                    str10 = "sfmc_id";
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
                    bundle.putString(str10, str9);
                }
                for (String str11 : uri.getQueryParameterNames()) {
                    if (str11.startsWith("gad_")) {
                        String queryParameter10 = uri.getQueryParameter(str11);
                        if (!TextUtils.isEmpty(queryParameter10)) {
                            bundle.putString(str11, queryParameter10);
                        }
                    }
                }
                return bundle;
            } catch (UnsupportedOperationException e) {
                this.zzu.zzaV().zze().zzb("Install referrer url isn't a hierarchical URI", e);
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzj(String str, String str2) {
        if (str2 == null) {
            this.zzu.zzaV().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.zzu.zzaV().zzd().zzb("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                this.zzu.zzaV().zzd().zzc("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    this.zzu.zzaV().zzd().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzk(String str, String str2) {
        if (str2 == null) {
            this.zzu.zzaV().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.zzu.zzaV().zzd().zzb("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                if (codePointAt != 95) {
                    this.zzu.zzaV().zzd().zzc("Name must start with a letter or _ (underscore). Type, name", str, str2);
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
                    this.zzu.zzaV().zzd().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzl(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.zzu.zzaV().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr3 = zzb;
        for (int i = 0; i < 3; i++) {
            if (str2.startsWith(strArr3[i])) {
                this.zzu.zzaV().zzd().zzc("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !zzaA(str2, strArr)) {
            return true;
        }
        if (strArr2 == null || !zzaA(str2, strArr2)) {
            this.zzu.zzaV().zzd().zzc("Name is reserved. Type, name", str, str2);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzm(String str, int i, String str2) {
        if (str2 == null) {
            this.zzu.zzaV().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) > i) {
            this.zzu.zzaV().zzd().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzn(String str) {
        if (zzk(NotificationCompat.CATEGORY_EVENT, str)) {
            if (zzl(NotificationCompat.CATEGORY_EVENT, zzjl.zza, zzjl.zzb, str)) {
                this.zzu.zzc();
                return !zzm(NotificationCompat.CATEGORY_EVENT, 40, str) ? 2 : 0;
            }
            return 13;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzp(String str) {
        if (zzk("user property", str)) {
            if (zzl("user property", zzjn.zza, null, str)) {
                this.zzu.zzc();
                return !zzm("user property", 24, str) ? 6 : 0;
            }
            return 15;
        }
        return 6;
    }

    final int zzq(String str) {
        if (zzj("event param", str)) {
            if (zzl("event param", null, null, str)) {
                this.zzu.zzc();
                return !zzm("event param", 40, str) ? 3 : 0;
            }
            return 14;
        }
        return 3;
    }

    final int zzs(String str) {
        if (zzk("event param", str)) {
            if (zzl("event param", null, null, str)) {
                this.zzu.zzc();
                return !zzm("event param", 40, str) ? 3 : 0;
            }
            return 14;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzt(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzu(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String obj2 = obj.toString();
            if (obj2.codePointCount(0, obj2.length()) > i) {
                this.zzu.zzaV().zzh().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(obj2.length()));
                return false;
            }
        }
        return true;
    }

    final void zzz(String str, String str2, String str3, Bundle bundle, List list, boolean z) {
        int zzq;
        String str4;
        int zzD;
        List list2 = list;
        if (bundle == null) {
            return;
        }
        zzib zzibVar = this.zzu;
        int i = true != zzibVar.zzc().zzu.zzk().zzag(231100000, true) ? 0 : 35;
        int i2 = 0;
        boolean z2 = false;
        for (String str5 : new TreeSet(bundle.keySet())) {
            if (list2 == null || !list2.contains(str5)) {
                zzq = !z ? zzq(str5) : 0;
                if (zzq == 0) {
                    zzq = zzs(str5);
                }
            } else {
                zzq = 0;
            }
            if (zzq != 0) {
                zzJ(bundle, zzq, str5, zzq == 3 ? str5 : null);
                bundle.remove(str5);
            } else {
                if (zzt(bundle.get(str5))) {
                    zzibVar.zzaV().zzh().zzd("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str5);
                    zzD = 22;
                    str4 = null;
                } else {
                    str4 = null;
                    zzD = zzD(str, str2, str5, bundle.get(str5), bundle, list2, z, false);
                }
                if (zzD == 0 || "_ev".equals(str5)) {
                    if (zzh(str5) && !zzaA(str5, zzjm.zzd)) {
                        i2++;
                        if (!zzag(231100000, true)) {
                            zzibVar.zzaV().zzd().zzc("Item array not supported on client's version of Google Play Services (Android Only)", zzibVar.zzl().zza(str2), zzibVar.zzl().zze(bundle));
                            zzax(bundle, 23);
                            bundle.remove(str5);
                        } else if (i2 > i) {
                            if (!zzibVar.zzc().zzp(str4, zzfx.zzbf) || !z2) {
                                zzgr zzd = zzibVar.zzaV().zzd();
                                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 55);
                                sb.append("Item can't contain more than ");
                                sb.append(i);
                                sb.append(" item-scoped custom params");
                                zzd.zzc(sb.toString(), zzibVar.zzl().zza(str2), zzibVar.zzl().zze(bundle));
                            }
                            zzax(bundle, 28);
                            bundle.remove(str5);
                            list2 = list;
                            z2 = true;
                        }
                    }
                } else {
                    zzJ(bundle, zzD, str5, bundle.get(str5));
                    bundle.remove(str5);
                }
            }
            list2 = list;
        }
    }
}
