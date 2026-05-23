package com.google.android.gms.measurement.internal;

import android.app.BroadcastOptions;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.collection.ArrayMap;
import androidx.collection.SieveCacheKt;
import androidx.compose.runtime.ComposerKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.android.vending.expansion.zipfile.APEZProvider;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzaeh;
import com.google.android.gms.internal.measurement.zzahh;
import com.google.android.gms.internal.measurement.zzahk;
import com.google.android.gms.internal.measurement.zzaif;
import com.google.android.gms.internal.measurement.zzair;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import kotlin.time.DurationKt;
import kotlinx.datetime.internal.DateCalculationsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzpg implements zzjg {
    private static volatile zzpg zzb;
    private List zzA;
    private long zzB;
    private final Map zzC;
    private final Map zzD;
    private final Map zzE;
    private zzlu zzG;
    private String zzH;
    private zzaz zzI;
    private long zzJ;
    long zza;
    private final zzht zzc;
    private final zzgz zzd;
    private zzaw zze;
    private zzhb zzf;
    private zzok zzg;
    private zzad zzh;
    private final zzpk zzi;
    private zzlp zzj;
    private zznn zzk;
    private final zzou zzl;
    private zzhk zzm;
    private final zzic zzn;
    private boolean zzp;
    private List zzq;
    private int zzs;
    private int zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private FileLock zzx;
    private FileChannel zzy;
    private List zzz;
    private final AtomicBoolean zzo = new AtomicBoolean(false);
    private final Deque zzr = new LinkedList();
    private final Map zzF = new HashMap();
    private final zzpo zzK = new zzpb(this);

    zzpg(zzph zzphVar, zzic zzicVar) {
        Preconditions.checkNotNull(zzphVar);
        this.zzn = zzic.zzy(zzphVar.zza, null, null, null);
        this.zzB = -1L;
        this.zzl = new zzou(this);
        zzpk zzpkVar = new zzpk(this);
        zzpkVar.zzaz();
        this.zzi = zzpkVar;
        zzgz zzgzVar = new zzgz(this);
        zzgzVar.zzaz();
        this.zzd = zzgzVar;
        zzht zzhtVar = new zzht(this);
        zzhtVar.zzaz();
        this.zzc = zzhtVar;
        this.zzC = new HashMap();
        this.zzD = new HashMap();
        this.zzE = new HashMap();
        zzaX().zzj(new zzov(this, zzphVar));
    }

    public static zzpg zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzpg.class) {
                if (zzb == null) {
                    zzb = new zzpg((zzph) Preconditions.checkNotNull(new zzph(context)), null);
                }
            }
        }
        return zzb;
    }

    static final void zzaB(com.google.android.gms.internal.measurement.zzhr zzhrVar, int i, String str) {
        List zza = zzhrVar.zza();
        for (int i2 = 0; i2 < zza.size(); i2++) {
            if ("_err".equals(((com.google.android.gms.internal.measurement.zzhw) zza.get(i2)).zzb())) {
                return;
            }
        }
        com.google.android.gms.internal.measurement.zzhv zzn = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzn.zzb("_err");
        zzn.zzf(Long.valueOf(i).longValue());
        com.google.android.gms.internal.measurement.zzhv zzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzn2.zzb("_ev");
        zzn2.zzd(str);
        zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzn.zzbd());
        zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzn2.zzbd());
    }

    static final void zzaC(com.google.android.gms.internal.measurement.zzhr zzhrVar, String str) {
        List zza = zzhrVar.zza();
        for (int i = 0; i < zza.size(); i++) {
            if (str.equals(((com.google.android.gms.internal.measurement.zzhw) zza.get(i)).zzb())) {
                zzhrVar.zzj(i);
                return;
            }
        }
    }

    private final int zzaD(String str, zzan zzanVar) {
        zzjk zzjkVar;
        zzji zzB;
        zzht zzhtVar = this.zzc;
        if (zzhtVar.zzy(str) == null) {
            zzanVar.zzc(zzjk.AD_PERSONALIZATION, zzam.FAILSAFE);
            return 1;
        }
        zzh zzu = zzj().zzu(str);
        if (zzu != null && zze.zzc(zzu.zzaH()).zza() == zzji.POLICY && (zzB = zzhtVar.zzB(str, (zzjkVar = zzjk.AD_PERSONALIZATION))) != zzji.UNINITIALIZED) {
            zzanVar.zzc(zzjkVar, zzam.REMOTE_ENFORCED_DEFAULT);
            return zzB == zzji.GRANTED ? 0 : 1;
        }
        zzjk zzjkVar2 = zzjk.AD_PERSONALIZATION;
        zzanVar.zzc(zzjkVar2, zzam.REMOTE_DEFAULT);
        return zzhtVar.zzw(str, zzjkVar2) ? 0 : 1;
    }

    private final Map zzaE(com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        HashMap hashMap = new HashMap();
        zzp();
        for (Map.Entry entry : zzpk.zzL(zzhsVar, "gad_").entrySet()) {
            hashMap.put((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
        return hashMap;
    }

    private final zzaz zzaF() {
        if (this.zzI == null) {
            this.zzI = new zzoy(this, this.zzn);
        }
        return this.zzI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzaG */
    public final void zzaw() {
        zzaX().zzg();
        if (this.zzr.isEmpty() || zzaF().zzc()) {
            return;
        }
        long max = Math.max(0L, ((Integer) zzfy.zzaA.zzb(null)).intValue() - (zzba().elapsedRealtime() - this.zzJ));
        zzaW().zzk().zzb("Scheduling notify next app runnable, delay in ms", Long.valueOf(max));
        zzaF().zzb(max);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02cf A[Catch: all -> 0x0e3a, TRY_ENTER, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0336 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0364 A[Catch: all -> 0x0e3a, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03c5 A[Catch: all -> 0x0e3a, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x042f A[Catch: all -> 0x0e3a, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x045f A[Catch: all -> 0x0e3a, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0477 A[Catch: all -> 0x0e3a, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0490 A[Catch: all -> 0x0e3a, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x049d A[Catch: all -> 0x0e3a, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x04eb A[Catch: all -> 0x0e3a, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x05a2 A[Catch: all -> 0x0e3a, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x05be A[Catch: all -> 0x0e3a, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x05cc A[Catch: all -> 0x0e3a, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x06da  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x0a5e A[Catch: all -> 0x0e22, TryCatch #0 {all -> 0x0e22, blocks: (B:306:0x0962, B:307:0x0975, B:309:0x097b, B:399:0x0c38, B:333:0x0a0d, B:340:0x0a3e, B:342:0x0a5e, B:343:0x0a66, B:345:0x0a6c, B:347:0x0a7c, B:354:0x0aa4, B:355:0x0ac7, B:357:0x0ad3, B:359:0x0ae7, B:361:0x0b28, B:365:0x0b3e, B:367:0x0b45, B:369:0x0b54, B:371:0x0b58, B:373:0x0b5c, B:375:0x0b60, B:376:0x0b6c, B:377:0x0b71, B:379:0x0b77, B:381:0x0b93, B:382:0x0b98, B:398:0x0c35, B:383:0x0bb0, B:385:0x0bb6, B:389:0x0bd7, B:391:0x0bff, B:392:0x0c0a, B:393:0x0c1d, B:395:0x0c25, B:386:0x0bc0, B:352:0x0a90, B:400:0x0c41, B:402:0x0c4c, B:403:0x0c52, B:404:0x0c5a, B:406:0x0c60, B:408:0x0c75, B:410:0x0c85, B:430:0x0d06, B:411:0x0c9d, B:413:0x0ca3, B:415:0x0cad, B:417:0x0cb4, B:423:0x0cc4, B:425:0x0ccb, B:427:0x0cf7, B:429:0x0cfe, B:428:0x0cfb, B:424:0x0cc8, B:416:0x0cb1), top: B:484:0x0962 }] */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0aa4 A[Catch: all -> 0x0e22, TryCatch #0 {all -> 0x0e22, blocks: (B:306:0x0962, B:307:0x0975, B:309:0x097b, B:399:0x0c38, B:333:0x0a0d, B:340:0x0a3e, B:342:0x0a5e, B:343:0x0a66, B:345:0x0a6c, B:347:0x0a7c, B:354:0x0aa4, B:355:0x0ac7, B:357:0x0ad3, B:359:0x0ae7, B:361:0x0b28, B:365:0x0b3e, B:367:0x0b45, B:369:0x0b54, B:371:0x0b58, B:373:0x0b5c, B:375:0x0b60, B:376:0x0b6c, B:377:0x0b71, B:379:0x0b77, B:381:0x0b93, B:382:0x0b98, B:398:0x0c35, B:383:0x0bb0, B:385:0x0bb6, B:389:0x0bd7, B:391:0x0bff, B:392:0x0c0a, B:393:0x0c1d, B:395:0x0c25, B:386:0x0bc0, B:352:0x0a90, B:400:0x0c41, B:402:0x0c4c, B:403:0x0c52, B:404:0x0c5a, B:406:0x0c60, B:408:0x0c75, B:410:0x0c85, B:430:0x0d06, B:411:0x0c9d, B:413:0x0ca3, B:415:0x0cad, B:417:0x0cb4, B:423:0x0cc4, B:425:0x0ccb, B:427:0x0cf7, B:429:0x0cfe, B:428:0x0cfb, B:424:0x0cc8, B:416:0x0cb1), top: B:484:0x0962 }] */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0ac7 A[Catch: all -> 0x0e22, TryCatch #0 {all -> 0x0e22, blocks: (B:306:0x0962, B:307:0x0975, B:309:0x097b, B:399:0x0c38, B:333:0x0a0d, B:340:0x0a3e, B:342:0x0a5e, B:343:0x0a66, B:345:0x0a6c, B:347:0x0a7c, B:354:0x0aa4, B:355:0x0ac7, B:357:0x0ad3, B:359:0x0ae7, B:361:0x0b28, B:365:0x0b3e, B:367:0x0b45, B:369:0x0b54, B:371:0x0b58, B:373:0x0b5c, B:375:0x0b60, B:376:0x0b6c, B:377:0x0b71, B:379:0x0b77, B:381:0x0b93, B:382:0x0b98, B:398:0x0c35, B:383:0x0bb0, B:385:0x0bb6, B:389:0x0bd7, B:391:0x0bff, B:392:0x0c0a, B:393:0x0c1d, B:395:0x0c25, B:386:0x0bc0, B:352:0x0a90, B:400:0x0c41, B:402:0x0c4c, B:403:0x0c52, B:404:0x0c5a, B:406:0x0c60, B:408:0x0c75, B:410:0x0c85, B:430:0x0d06, B:411:0x0c9d, B:413:0x0ca3, B:415:0x0cad, B:417:0x0cb4, B:423:0x0cc4, B:425:0x0ccb, B:427:0x0cf7, B:429:0x0cfe, B:428:0x0cfb, B:424:0x0cc8, B:416:0x0cb1), top: B:484:0x0962 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0187 A[Catch: all -> 0x0e3a, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f8 A[Catch: all -> 0x0e3a, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x022f A[Catch: all -> 0x0e3a, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x024d A[Catch: all -> 0x0e3a, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0262 A[Catch: all -> 0x0e3a, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x029f A[Catch: all -> 0x0e3a, TRY_LEAVE, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean zzaH(String str, long j) {
        zzpg zzpgVar;
        boolean z;
        int i;
        long parseLong;
        int zzn;
        long j2;
        zzpc zzpcVar;
        SecureRandom secureRandom;
        int i2;
        long zzam;
        int i3;
        boolean z2;
        zzh zzu;
        com.google.android.gms.internal.measurement.zzic zzicVar;
        int i4;
        String str2;
        zzal zzd;
        zzfx zzfxVar;
        boolean zzk;
        int i5;
        boolean z3;
        boolean z4;
        String str3;
        String str4;
        int i6;
        boolean z5;
        com.google.android.gms.internal.measurement.zzhv zzhvVar;
        String str5;
        String str6;
        int i7;
        int i8;
        int i9;
        String str7;
        int i10;
        int i11;
        int i12;
        int i13;
        long zzE;
        String str8;
        zzpg zzpgVar2 = this;
        zzpg zzpgVar3 = "_ai";
        String str9 = FirebaseAnalytics.Event.PURCHASE;
        String str10 = "items";
        zzpgVar2.zzj().zzb();
        try {
            zzpc zzpcVar2 = new zzpc(zzpgVar2, null);
            zzpgVar2.zzj().zzav(str, j, zzpgVar2.zzB, zzpcVar2);
            List list = zzpcVar2.zzc;
            try {
                if (list != null && !list.isEmpty()) {
                    com.google.android.gms.internal.measurement.zzic zzicVar2 = (com.google.android.gms.internal.measurement.zzic) zzpcVar2.zza.zzco();
                    zzicVar2.zzi();
                    com.google.android.gms.internal.measurement.zzhr zzhrVar = null;
                    com.google.android.gms.internal.measurement.zzhr zzhrVar2 = null;
                    int i14 = -1;
                    int i15 = 0;
                    int i16 = 0;
                    boolean z6 = false;
                    int i17 = -1;
                    boolean z7 = false;
                    String str11 = "_ai";
                    while (true) {
                        i = i16;
                        boolean z8 = z6;
                        com.google.android.gms.internal.measurement.zzhr zzhrVar3 = zzhrVar;
                        int i18 = i17;
                        if (i15 >= zzpcVar2.zzc.size()) {
                            break;
                        }
                        com.google.android.gms.internal.measurement.zzhr zzhrVar4 = (com.google.android.gms.internal.measurement.zzhr) ((com.google.android.gms.internal.measurement.zzhs) zzpcVar2.zzc.get(i15)).zzco();
                        com.google.android.gms.internal.measurement.zzhr zzhrVar5 = zzhrVar2;
                        if (zzpgVar2.zzh().zzj(zzpcVar2.zza.zzA(), zzhrVar4.zzk())) {
                            zzpgVar2.zzaW().zze().zzc("Dropping blocked raw event. appId", zzgu.zzl(zzpcVar2.zza.zzA()), zzpgVar2.zzn.zzl().zza(zzhrVar4.zzk()));
                            if (!zzpgVar2.zzh().zzo(zzpcVar2.zza.zzA()) && !zzpgVar2.zzh().zzp(zzpcVar2.zza.zzA()) && !"_err".equals(zzhrVar4.zzk())) {
                                zzpgVar2.zzt().zzP(zzpgVar2.zzK, zzpcVar2.zza.zzA(), 11, "_ev", zzhrVar4.zzk(), 0);
                            }
                            int i19 = i15;
                            str7 = str10;
                            i10 = i19;
                            str3 = str11;
                            str4 = str9;
                            zzhrVar = zzhrVar3;
                            i17 = i18;
                            zzhrVar2 = zzhrVar5;
                            i11 = i;
                        } else {
                            String zzk2 = zzhrVar4.zzk();
                            int i20 = i15;
                            String str12 = str10;
                            if (zzk2.equals(str9) || zzk2.equals("_iap") || zzk2.equals("ecommerce_purchase")) {
                                zzicVar = zzicVar2;
                                i4 = i14;
                                str2 = "_et";
                            } else {
                                str2 = "_et";
                                zzicVar = zzicVar2;
                                i4 = i14;
                                if (zzpgVar2.zzd().zzp(null, zzfy.zzbf) && zzk2.equals(FirebaseAnalytics.Event.IN_APP_PURCHASE)) {
                                }
                                if (zzhrVar4.zzk().equals(zzjm.zza(str11))) {
                                    zzhrVar4.zzl(str11);
                                    zzpgVar2.zzaW().zzk().zza("Renaming ad_impression to _ai");
                                    if (Log.isLoggable(zzpgVar2.zzaW().zzn(), 5)) {
                                        for (int i21 = 0; i21 < zzhrVar4.zzb(); i21++) {
                                            if (FirebaseAnalytics.Param.AD_PLATFORM.equals(zzhrVar4.zzc(i21).zzb()) && !zzhrVar4.zzc(i21).zzd().isEmpty() && "admob".equalsIgnoreCase(zzhrVar4.zzc(i21).zzd())) {
                                                zzpgVar2.zzaW().zzh().zza("AdMob ad impression logged from app. Potentially duplicative.");
                                            }
                                        }
                                    }
                                }
                                zzd = zzpgVar2.zzd();
                                zzfxVar = zzfy.zzbf;
                                if (zzd.zzp(null, zzfxVar) && zzhrVar4.zzk().equals(FirebaseAnalytics.Event.IN_APP_PURCHASE)) {
                                    zzhrVar4.zzl("_iap");
                                    zzpgVar2.zzaW().zzk().zza("Renaming in_app_purchase to _iap");
                                }
                                zzk = zzpgVar2.zzh().zzk(zzpcVar2.zza.zzA(), zzhrVar4.zzk());
                                if (zzpgVar2.zzd().zzp(null, zzfxVar) && "_iap".equals(zzhrVar4.zzk())) {
                                    zzk = zzpgVar2.zzV(zzhrVar4);
                                    String zzA4 = zzpcVar2.zza.zzA();
                                    if ("_iap".equals(zzhrVar4.zzk())) {
                                        zzpgVar2.zzaK(zzhrVar4, "value", zzA4);
                                        zzpgVar2.zzaK(zzhrVar4, FirebaseAnalytics.Param.PRICE, zzA4);
                                    }
                                    if (!"_iap".equals(zzhrVar4.zzk())) {
                                        ArrayList arrayList = new ArrayList(zzhrVar4.zza());
                                        int i22 = 0;
                                        while (true) {
                                            if (i22 < arrayList.size()) {
                                                if (FirebaseAnalytics.Param.QUANTITY.equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i22)).zzb())) {
                                                    break;
                                                }
                                                i22++;
                                            } else {
                                                com.google.android.gms.internal.measurement.zzhv zzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                                zzn2.zzb(FirebaseAnalytics.Param.QUANTITY);
                                                zzn2.zzf(1L);
                                                zzhrVar4.zzf((com.google.android.gms.internal.measurement.zzhw) zzn2.zzbd());
                                                break;
                                            }
                                        }
                                    }
                                }
                                if (!zzk) {
                                    zzpgVar2.zzp();
                                    String zzk3 = zzhrVar4.zzk();
                                    Preconditions.checkNotEmpty(zzk3);
                                    if (zzk3.hashCode() != 95027 || !zzk3.equals("_ui")) {
                                        str3 = str11;
                                        str4 = str9;
                                        zzk = false;
                                        if (zzk) {
                                            zzpgVar2.zzV(zzhrVar4);
                                        }
                                        if (!"_e".equals(zzhrVar4.zzk())) {
                                            zzpgVar2.zzp();
                                            if (zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar4.zzbd(), "_fr") == null) {
                                                if (zzhrVar5 != null && Math.abs(zzhrVar5.zzn() - zzhrVar4.zzn()) <= 1000) {
                                                    com.google.android.gms.internal.measurement.zzhr zzhrVar6 = (com.google.android.gms.internal.measurement.zzhr) zzhrVar5.zzaS();
                                                    if (zzpgVar2.zzaJ(zzhrVar4, zzhrVar6)) {
                                                        zzicVar2 = zzicVar;
                                                        i7 = i4;
                                                        zzicVar2.zzf(i7, zzhrVar6);
                                                        i17 = i18;
                                                        zzhrVar = null;
                                                        zzhrVar2 = null;
                                                    }
                                                }
                                                zzicVar2 = zzicVar;
                                                i7 = i4;
                                                i17 = i;
                                                zzhrVar = zzhrVar4;
                                                zzhrVar2 = zzhrVar5;
                                            } else {
                                                zzicVar2 = zzicVar;
                                                i7 = i4;
                                                i8 = i18;
                                                i17 = i8;
                                                zzhrVar = zzhrVar3;
                                                zzhrVar2 = zzhrVar5;
                                            }
                                        } else {
                                            zzicVar2 = zzicVar;
                                            i7 = i4;
                                            if (!"_vs".equals(zzhrVar4.zzk())) {
                                                i8 = i18;
                                                if (("_f".equals(zzhrVar4.zzk()) || "_v".equals(zzhrVar4.zzk())) && ("_f".equals(zzhrVar4.zzk()) || "_v".equals(zzhrVar4.zzk()))) {
                                                    int i23 = 0;
                                                    while (true) {
                                                        if (i23 >= zzhrVar4.zzb()) {
                                                            break;
                                                        }
                                                        com.google.android.gms.internal.measurement.zzhw zzc = zzhrVar4.zzc(i23);
                                                        if ("_elt".equals(zzc.zzb())) {
                                                            zzhrVar4.zzr(zzc.zzf());
                                                            zzhrVar4.zzj(i23);
                                                            break;
                                                        }
                                                        i23++;
                                                    }
                                                }
                                                i17 = i8;
                                                zzhrVar = zzhrVar3;
                                                zzhrVar2 = zzhrVar5;
                                            } else {
                                                zzpgVar2.zzp();
                                                if (zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar4.zzbd(), str2) == null) {
                                                    if (zzhrVar3 != null && Math.abs(zzhrVar3.zzn() - zzhrVar4.zzn()) <= 1000) {
                                                        com.google.android.gms.internal.measurement.zzhr zzhrVar7 = (com.google.android.gms.internal.measurement.zzhr) zzhrVar3.zzaS();
                                                        if (zzpgVar2.zzaJ(zzhrVar7, zzhrVar4)) {
                                                            zzicVar2.zzf(i18, zzhrVar7);
                                                            i17 = i18;
                                                            zzhrVar = null;
                                                            zzhrVar2 = null;
                                                        }
                                                    }
                                                    i7 = i;
                                                    i17 = i18;
                                                    zzhrVar2 = zzhrVar4;
                                                    zzhrVar = zzhrVar3;
                                                }
                                                i8 = i18;
                                                i17 = i8;
                                                zzhrVar = zzhrVar3;
                                                zzhrVar2 = zzhrVar5;
                                            }
                                        }
                                        if (zzpgVar2.zzd().zzp(null, zzfy.zzbe) && zzhrVar4.zzu() && !zzhrVar4.zzs()) {
                                            zzE = zzpgVar2.zzp().zzE(zzhrVar4.zzv());
                                            if (zzE != 0) {
                                                zzhrVar4.zzt(zzE);
                                            }
                                            zzhrVar4.zzw(0L);
                                        }
                                        if (zzhrVar4.zzb() == 0) {
                                            zzpgVar2.zzp();
                                            Bundle zzH = zzpk.zzH(zzhrVar4.zza());
                                            int i24 = 0;
                                            while (i24 < zzhrVar4.zzb()) {
                                                com.google.android.gms.internal.measurement.zzhw zzc2 = zzhrVar4.zzc(i24);
                                                String str13 = str12;
                                                if (zzc2.zzb().equals(str13) && !zzc2.zzl().isEmpty()) {
                                                    String zzA2 = zzpcVar2.zza.zzA();
                                                    List zzl = zzc2.zzl();
                                                    Bundle[] bundleArr = new Bundle[zzl.size()];
                                                    i12 = i24;
                                                    i13 = i7;
                                                    int i25 = 0;
                                                    while (i25 < zzl.size()) {
                                                        com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) zzl.get(i25);
                                                        zzpgVar2.zzp();
                                                        int i26 = i25;
                                                        Bundle zzH2 = zzpk.zzH(zzhwVar.zzl());
                                                        for (Iterator it = zzhwVar.zzl().iterator(); it.hasNext(); it = it) {
                                                            zzpgVar2.zzU(zzhrVar4.zzk(), (com.google.android.gms.internal.measurement.zzhv) ((com.google.android.gms.internal.measurement.zzhw) it.next()).zzco(), zzH2, zzA2);
                                                            zzl = zzl;
                                                        }
                                                        bundleArr[i26] = zzH2;
                                                        i25 = i26 + 1;
                                                        zzl = zzl;
                                                    }
                                                    zzH.putParcelableArray(str13, bundleArr);
                                                } else {
                                                    i12 = i24;
                                                    i13 = i7;
                                                    if (!zzc2.zzb().equals(str13)) {
                                                        zzpgVar2.zzU(zzhrVar4.zzk(), (com.google.android.gms.internal.measurement.zzhv) zzc2.zzco(), zzH, zzpcVar2.zza.zzA());
                                                    }
                                                }
                                                i24 = i12 + 1;
                                                str12 = str13;
                                                i7 = i13;
                                            }
                                            i9 = i7;
                                            str7 = str12;
                                            zzhrVar4.zzi();
                                            zzpk zzp = zzpgVar2.zzp();
                                            ArrayList<com.google.android.gms.internal.measurement.zzhw> arrayList2 = new ArrayList();
                                            for (String str14 : zzH.keySet()) {
                                                com.google.android.gms.internal.measurement.zzhv zzn3 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                                zzn3.zzb(str14);
                                                Object obj = zzH.get(str14);
                                                if (obj != null) {
                                                    zzp.zzd(zzn3, obj);
                                                    arrayList2.add((com.google.android.gms.internal.measurement.zzhw) zzn3.zzbd());
                                                }
                                            }
                                            for (com.google.android.gms.internal.measurement.zzhw zzhwVar2 : arrayList2) {
                                                zzhrVar4.zzf(zzhwVar2);
                                            }
                                        } else {
                                            i9 = i7;
                                            str7 = str12;
                                        }
                                        i10 = i20;
                                        zzpcVar2.zzc.set(i10, (com.google.android.gms.internal.measurement.zzhs) zzhrVar4.zzbd());
                                        zzicVar2.zzg(zzhrVar4);
                                        i11 = i + 1;
                                        i14 = i9;
                                    }
                                }
                                i5 = 0;
                                z3 = false;
                                z4 = false;
                                String str1522 = str11;
                                while (i5 < zzhrVar4.zzb()) {
                                    if ("_c".equals(zzhrVar4.zzc(i5).zzb())) {
                                        com.google.android.gms.internal.measurement.zzhv zzhvVar2 = (com.google.android.gms.internal.measurement.zzhv) zzhrVar4.zzc(i5).zzco();
                                        str5 = str1522;
                                        str6 = str9;
                                        zzhvVar2.zzf(1L);
                                        zzhrVar4.zzd(i5, (com.google.android.gms.internal.measurement.zzhw) zzhvVar2.zzbd());
                                        z3 = true;
                                    } else {
                                        str5 = str1522;
                                        str6 = str9;
                                        if ("_r".equals(zzhrVar4.zzc(i5).zzb())) {
                                            com.google.android.gms.internal.measurement.zzhv zzhvVar3 = (com.google.android.gms.internal.measurement.zzhv) zzhrVar4.zzc(i5).zzco();
                                            zzhvVar3.zzf(1L);
                                            zzhrVar4.zzd(i5, (com.google.android.gms.internal.measurement.zzhw) zzhvVar3.zzbd());
                                            z3 = z3;
                                            z4 = true;
                                        }
                                    }
                                    i5++;
                                    str1522 = str5;
                                    str9 = str6;
                                }
                                str3 = str1522;
                                str4 = str9;
                                if (!z3 && zzk) {
                                    zzpgVar2.zzaW().zzk().zzb("Marking event as conversion", zzpgVar2.zzn.zzl().zza(zzhrVar4.zzk()));
                                    com.google.android.gms.internal.measurement.zzhv zzn42 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                    zzn42.zzb("_c");
                                    zzn42.zzf(1L);
                                    zzhrVar4.zzg(zzn42);
                                }
                                if (!z4) {
                                    zzpgVar2.zzaW().zzk().zzb("Marking event as real-time", zzpgVar2.zzn.zzl().zza(zzhrVar4.zzk()));
                                    com.google.android.gms.internal.measurement.zzhv zzn5 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                    zzn5.zzb("_r");
                                    zzn5.zzf(1L);
                                    zzhrVar4.zzg(zzn5);
                                }
                                if (zzpgVar2.zzj().zzw(zzpgVar2.zzC(), zzpcVar2.zza.zzA(), false, false, false, false, true, false, false).zze > zzpgVar2.zzd().zzm(zzpcVar2.zza.zzA(), zzfy.zzo)) {
                                    zzaC(zzhrVar4, "_r");
                                } else {
                                    z7 = true;
                                }
                                if (zzpp.zzh(zzhrVar4.zzk()) && zzk && zzpgVar2.zzj().zzw(zzpgVar2.zzC(), zzpcVar2.zza.zzA(), false, false, true, false, false, false, false).zzc > zzpgVar2.zzd().zzm(zzpcVar2.zza.zzA(), zzfy.zzn)) {
                                    zzpgVar2.zzaW().zze().zzb("Too many conversions. Not logging as conversion. appId", zzgu.zzl(zzpcVar2.zza.zzA()));
                                    z5 = false;
                                    zzhvVar = null;
                                    int i272 = -1;
                                    for (i6 = 0; i6 < zzhrVar4.zzb(); i6++) {
                                        com.google.android.gms.internal.measurement.zzhw zzc3 = zzhrVar4.zzc(i6);
                                        if ("_c".equals(zzc3.zzb())) {
                                            zzhvVar = (com.google.android.gms.internal.measurement.zzhv) zzc3.zzco();
                                            i272 = i6;
                                        } else if ("_err".equals(zzc3.zzb())) {
                                            z5 = true;
                                        }
                                    }
                                    if (z5) {
                                        if (zzhvVar != null) {
                                            zzhrVar4.zzj(i272);
                                        } else {
                                            zzhvVar = null;
                                        }
                                    }
                                    if (zzhvVar == null) {
                                        com.google.android.gms.internal.measurement.zzhv zzhvVar4 = (com.google.android.gms.internal.measurement.zzhv) zzhvVar.zzaS();
                                        zzhvVar4.zzb("_err");
                                        zzhvVar4.zzf(10L);
                                        zzhrVar4.zzd(i272, (com.google.android.gms.internal.measurement.zzhw) zzhvVar4.zzbd());
                                    } else {
                                        zzpgVar2.zzaW().zzb().zzb("Did not find conversion parameter. appId", zzgu.zzl(zzpcVar2.zza.zzA()));
                                    }
                                }
                                if (zzk) {
                                }
                                if (!"_e".equals(zzhrVar4.zzk())) {
                                }
                                if (zzpgVar2.zzd().zzp(null, zzfy.zzbe)) {
                                    zzE = zzpgVar2.zzp().zzE(zzhrVar4.zzv());
                                    if (zzE != 0) {
                                    }
                                    zzhrVar4.zzw(0L);
                                }
                                if (zzhrVar4.zzb() == 0) {
                                }
                                i10 = i20;
                                zzpcVar2.zzc.set(i10, (com.google.android.gms.internal.measurement.zzhs) zzhrVar4.zzbd());
                                zzicVar2.zzg(zzhrVar4);
                                i11 = i + 1;
                                i14 = i9;
                            }
                            com.google.android.gms.internal.measurement.zzhv zzn6 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzn6.zzb("_ct");
                            if (!z8) {
                                String zzA3 = zzpcVar2.zza.zzA();
                                if (zzpgVar2.zzaQ(zzA3, str9) && zzpgVar2.zzaQ(zzA3, "_iap") && zzpgVar2.zzaQ(zzA3, "ecommerce_purchase")) {
                                    str8 = "new";
                                    zzn6.zzd(str8);
                                    zzhrVar4.zzf((com.google.android.gms.internal.measurement.zzhw) zzn6.zzbd());
                                    z8 = true;
                                    if (zzhrVar4.zzk().equals(zzjm.zza(str11))) {
                                    }
                                    zzd = zzpgVar2.zzd();
                                    zzfxVar = zzfy.zzbf;
                                    if (zzd.zzp(null, zzfxVar)) {
                                        zzhrVar4.zzl("_iap");
                                        zzpgVar2.zzaW().zzk().zza("Renaming in_app_purchase to _iap");
                                    }
                                    zzk = zzpgVar2.zzh().zzk(zzpcVar2.zza.zzA(), zzhrVar4.zzk());
                                    if (zzpgVar2.zzd().zzp(null, zzfxVar)) {
                                        zzk = zzpgVar2.zzV(zzhrVar4);
                                        String zzA42 = zzpcVar2.zza.zzA();
                                        if ("_iap".equals(zzhrVar4.zzk())) {
                                        }
                                        if (!"_iap".equals(zzhrVar4.zzk())) {
                                        }
                                    }
                                    if (!zzk) {
                                    }
                                    i5 = 0;
                                    z3 = false;
                                    z4 = false;
                                    String str15222 = str11;
                                    while (i5 < zzhrVar4.zzb()) {
                                    }
                                    str3 = str15222;
                                    str4 = str9;
                                    if (!z3) {
                                        zzpgVar2.zzaW().zzk().zzb("Marking event as conversion", zzpgVar2.zzn.zzl().zza(zzhrVar4.zzk()));
                                        com.google.android.gms.internal.measurement.zzhv zzn422 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                        zzn422.zzb("_c");
                                        zzn422.zzf(1L);
                                        zzhrVar4.zzg(zzn422);
                                    }
                                    if (!z4) {
                                    }
                                    if (zzpgVar2.zzj().zzw(zzpgVar2.zzC(), zzpcVar2.zza.zzA(), false, false, false, false, true, false, false).zze > zzpgVar2.zzd().zzm(zzpcVar2.zza.zzA(), zzfy.zzo)) {
                                    }
                                    if (zzpp.zzh(zzhrVar4.zzk())) {
                                        zzpgVar2.zzaW().zze().zzb("Too many conversions. Not logging as conversion. appId", zzgu.zzl(zzpcVar2.zza.zzA()));
                                        z5 = false;
                                        zzhvVar = null;
                                        int i2722 = -1;
                                        while (i6 < zzhrVar4.zzb()) {
                                        }
                                        if (z5) {
                                        }
                                        if (zzhvVar == null) {
                                        }
                                    }
                                    if (zzk) {
                                    }
                                    if (!"_e".equals(zzhrVar4.zzk())) {
                                    }
                                    if (zzpgVar2.zzd().zzp(null, zzfy.zzbe)) {
                                    }
                                    if (zzhrVar4.zzb() == 0) {
                                    }
                                    i10 = i20;
                                    zzpcVar2.zzc.set(i10, (com.google.android.gms.internal.measurement.zzhs) zzhrVar4.zzbd());
                                    zzicVar2.zzg(zzhrVar4);
                                    i11 = i + 1;
                                    i14 = i9;
                                }
                            }
                            str8 = "returning";
                            zzn6.zzd(str8);
                            zzhrVar4.zzf((com.google.android.gms.internal.measurement.zzhw) zzn6.zzbd());
                            z8 = true;
                            if (zzhrVar4.zzk().equals(zzjm.zza(str11))) {
                            }
                            zzd = zzpgVar2.zzd();
                            zzfxVar = zzfy.zzbf;
                            if (zzd.zzp(null, zzfxVar)) {
                            }
                            zzk = zzpgVar2.zzh().zzk(zzpcVar2.zza.zzA(), zzhrVar4.zzk());
                            if (zzpgVar2.zzd().zzp(null, zzfxVar)) {
                            }
                            if (!zzk) {
                            }
                            i5 = 0;
                            z3 = false;
                            z4 = false;
                            String str152222 = str11;
                            while (i5 < zzhrVar4.zzb()) {
                            }
                            str3 = str152222;
                            str4 = str9;
                            if (!z3) {
                            }
                            if (!z4) {
                            }
                            if (zzpgVar2.zzj().zzw(zzpgVar2.zzC(), zzpcVar2.zza.zzA(), false, false, false, false, true, false, false).zze > zzpgVar2.zzd().zzm(zzpcVar2.zza.zzA(), zzfy.zzo)) {
                            }
                            if (zzpp.zzh(zzhrVar4.zzk())) {
                            }
                            if (zzk) {
                            }
                            if (!"_e".equals(zzhrVar4.zzk())) {
                            }
                            if (zzpgVar2.zzd().zzp(null, zzfy.zzbe)) {
                            }
                            if (zzhrVar4.zzb() == 0) {
                            }
                            i10 = i20;
                            zzpcVar2.zzc.set(i10, (com.google.android.gms.internal.measurement.zzhs) zzhrVar4.zzbd());
                            zzicVar2.zzg(zzhrVar4);
                            i11 = i + 1;
                            i14 = i9;
                        }
                        z6 = z8;
                        int i28 = i10 + 1;
                        String str16 = str3;
                        i16 = i11;
                        str11 = str16;
                        str10 = str7;
                        i15 = i28;
                        str9 = str4;
                    }
                    int i29 = i;
                    int i30 = 0;
                    long j3 = 0;
                    while (i30 < i29) {
                        com.google.android.gms.internal.measurement.zzhs zzd2 = zzicVar2.zzd(i30);
                        if ("_e".equals(zzd2.zzd())) {
                            zzpgVar2.zzp();
                            if (zzpk.zzI(zzd2, "_fr") != null) {
                                zzicVar2.zzj(i30);
                                i29--;
                                i30--;
                                i30++;
                            }
                        }
                        zzpgVar2.zzp();
                        com.google.android.gms.internal.measurement.zzhw zzI = zzpk.zzI(zzd2, "_et");
                        if (zzI != null) {
                            Long valueOf = zzI.zze() ? Long.valueOf(zzI.zzf()) : null;
                            if (valueOf != null && valueOf.longValue() > 0) {
                                j3 += valueOf.longValue();
                            }
                        }
                        i30++;
                    }
                    zzpgVar2.zzaI(zzicVar2, j3, false);
                    Iterator it2 = zzicVar2.zzb().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if ("_s".equals(((com.google.android.gms.internal.measurement.zzhs) it2.next()).zzd())) {
                                zzpgVar2.zzj().zzk(zzicVar2.zzK(), "_se");
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (zzpk.zzx(zzicVar2, "_sid") >= 0) {
                        zzpgVar2.zzaI(zzicVar2, j3, true);
                    } else {
                        int zzx = zzpk.zzx(zzicVar2, "_se");
                        if (zzx >= 0) {
                            zzicVar2.zzr(zzx);
                            zzpgVar2.zzaW().zzb().zzb("Session engagement user property is in the bundle without session ID. appId", zzgu.zzl(zzpcVar2.zza.zzA()));
                        }
                    }
                    String zzA5 = zzpcVar2.zza.zzA();
                    zzpgVar2.zzaX().zzg();
                    zzpgVar2.zzu();
                    zzh zzu2 = zzpgVar2.zzj().zzu(zzA5);
                    if (zzu2 == null) {
                        zzpgVar2.zzaW().zzb().zzb("Cannot fix consent fields without appInfo. appId", zzgu.zzl(zzA5));
                    } else {
                        zzpgVar2.zzI(zzu2, zzicVar2);
                    }
                    String zzA6 = zzpcVar2.zza.zzA();
                    zzpgVar2.zzaX().zzg();
                    zzpgVar2.zzu();
                    zzh zzu3 = zzpgVar2.zzj().zzu(zzA6);
                    if (zzu3 == null) {
                        zzpgVar2.zzaW().zze().zzb("Cannot populate ad_campaign_info without appInfo. appId", zzgu.zzl(zzA6));
                    } else {
                        zzpgVar2.zzJ(zzu3, zzicVar2);
                    }
                    zzicVar2.zzv(Long.MAX_VALUE);
                    zzicVar2.zzx(Long.MIN_VALUE);
                    for (int i31 = 0; i31 < zzicVar2.zzc(); i31++) {
                        com.google.android.gms.internal.measurement.zzhs zzd3 = zzicVar2.zzd(i31);
                        if (zzd3.zzf() < zzicVar2.zzu()) {
                            zzicVar2.zzv(zzd3.zzf());
                        }
                        if (zzd3.zzf() > zzicVar2.zzw()) {
                            zzicVar2.zzx(zzd3.zzf());
                        }
                    }
                    zzicVar2.zzak();
                    zzjl zzjlVar = zzjl.zza;
                    zzjl zzs = zzpgVar2.zzB(zzpcVar2.zza.zzA()).zzs(zzjl.zzf(zzpcVar2.zza.zzaf(), 100));
                    zzjl zzaf = zzpgVar2.zzj().zzaf(zzpcVar2.zza.zzA());
                    zzpgVar2.zzj().zzae(zzpcVar2.zza.zzA(), zzs);
                    zzjk zzjkVar = zzjk.ANALYTICS_STORAGE;
                    if (zzs.zzo(zzjkVar) || !zzaf.zzo(zzjkVar)) {
                        if (zzs.zzo(zzjkVar) && !zzaf.zzo(zzjkVar)) {
                            zzpgVar2.zzj().zzj(zzpcVar2.zza.zzA());
                        }
                    } else {
                        zzpgVar2.zzj().zzi(zzpcVar2.zza.zzA());
                    }
                    zzjk zzjkVar2 = zzjk.AD_STORAGE;
                    if (!zzs.zzo(zzjkVar2)) {
                        zzicVar2.zzR();
                        zzicVar2.zzU();
                        zzicVar2.zzan();
                    }
                    if (!zzs.zzo(zzjkVar)) {
                        zzicVar2.zzX();
                        zzicVar2.zzav();
                    }
                    zzaif.zza();
                    if (zzpgVar2.zzd().zzp(zzpcVar2.zza.zzA(), zzfy.zzaO) && zzpgVar2.zzt().zzZ(zzpcVar2.zza.zzA()) && zzpgVar2.zzB(zzpcVar2.zza.zzA()).zzo(zzjkVar2) && zzpcVar2.zza.zzak()) {
                        zzpgVar2.zzT(zzicVar2, zzpcVar2);
                    }
                    zzicVar2.zzag();
                    zzicVar2.zzaf(zzpgVar2.zzm().zzb(zzicVar2.zzK(), zzicVar2.zzb(), zzicVar2.zzk(), Long.valueOf(zzicVar2.zzu()), Long.valueOf(zzicVar2.zzw()), !zzs.zzo(zzjkVar)));
                    if (zzpgVar2.zzd().zzD(zzpcVar2.zza.zzA())) {
                        try {
                            HashMap hashMap = new HashMap();
                            ArrayList arrayList3 = new ArrayList();
                            SecureRandom zzf = zzpgVar2.zzt().zzf();
                            int i32 = 0;
                            while (i32 < zzicVar2.zzc()) {
                                com.google.android.gms.internal.measurement.zzhr zzhrVar8 = (com.google.android.gms.internal.measurement.zzhr) zzicVar2.zzd(i32).zzco();
                                if (zzhrVar8.zzk().equals("_ep")) {
                                    zzpgVar2.zzp();
                                    String str17 = (String) zzpk.zzM((com.google.android.gms.internal.measurement.zzhs) zzhrVar8.zzbd(), "_en");
                                    zzbd zzbdVar = (zzbd) hashMap.get(str17);
                                    if (zzbdVar == null && (zzbdVar = zzpgVar2.zzj().zzf(zzpcVar2.zza.zzA(), (String) Preconditions.checkNotNull(str17))) != null) {
                                        hashMap.put(str17, zzbdVar);
                                    }
                                    if (zzbdVar != null && zzbdVar.zzi == null) {
                                        Long l = zzbdVar.zzj;
                                        if (l != null && l.longValue() > 1) {
                                            zzpgVar2.zzp();
                                            zzpk.zzF(zzhrVar8, "_sr", l);
                                        }
                                        Boolean bool = zzbdVar.zzk;
                                        if (bool != null && bool.booleanValue()) {
                                            zzpgVar2.zzp();
                                            zzpk.zzF(zzhrVar8, "_efs", 1L);
                                        }
                                        arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar8.zzbd());
                                    }
                                    zzicVar2.zzf(i32, zzhrVar8);
                                    secureRandom = zzf;
                                    i3 = i32;
                                    zzpcVar = zzpcVar2;
                                } else {
                                    zzht zzh = zzpgVar2.zzh();
                                    String zzA7 = zzpcVar2.zza.zzA();
                                    String zza = zzh.zza(zzA7, "measurement.account.time_zone_offset_minutes");
                                    if (!TextUtils.isEmpty(zza)) {
                                        try {
                                            parseLong = Long.parseLong(zza);
                                        } catch (NumberFormatException e) {
                                            zzh.zzu.zzaW().zze().zzc("Unable to parse timezone offset. appId", zzgu.zzl(zzA7), e);
                                        }
                                        long zzam22 = zzpgVar2.zzt().zzam(zzhrVar8.zzn(), parseLong);
                                        com.google.android.gms.internal.measurement.zzhs zzhsVar2 = (com.google.android.gms.internal.measurement.zzhs) zzhrVar8.zzbd();
                                        Long l22 = 1L;
                                        if (!TextUtils.isEmpty("_dbg")) {
                                            Iterator it3 = zzhsVar2.zza().iterator();
                                            while (true) {
                                                if (!it3.hasNext()) {
                                                    break;
                                                }
                                                com.google.android.gms.internal.measurement.zzhw zzhwVar3 = (com.google.android.gms.internal.measurement.zzhw) it3.next();
                                                if ("_dbg".equals(zzhwVar3.zzb())) {
                                                    if (l22.equals(Long.valueOf(zzhwVar3.zzf()))) {
                                                        zzn = 1;
                                                    }
                                                }
                                            }
                                        }
                                        zzn = zzh().zzn(zzpcVar2.zza.zzA(), zzhrVar8.zzk());
                                        if (zzn > 0) {
                                            zzaW().zze().zzc("Sample rate must be positive. event, rate", zzhrVar8.zzk(), Integer.valueOf(zzn));
                                            arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar8.zzbd());
                                            zzicVar2.zzf(i32, zzhrVar8);
                                        } else {
                                            zzbd zzbdVar2 = (zzbd) hashMap.get(zzhrVar8.zzk());
                                            if (zzbdVar2 == null && (zzbdVar2 = zzj().zzf(zzpcVar2.zza.zzA(), zzhrVar8.zzk())) == null) {
                                                j2 = parseLong;
                                                zzaW().zze().zzc("Event being bundled has no eventAggregate. appId, eventName", zzpcVar2.zza.zzA(), zzhrVar8.zzk());
                                                zzbdVar2 = new zzbd(zzpcVar2.zza.zzA(), zzhrVar8.zzk(), 1L, 1L, 1L, zzhrVar8.zzn(), 0L, null, null, null, null);
                                            } else {
                                                j2 = parseLong;
                                            }
                                            zzp();
                                            Long l3 = (Long) zzpk.zzM((com.google.android.gms.internal.measurement.zzhs) zzhrVar8.zzbd(), "_eid");
                                            Boolean valueOf2 = Boolean.valueOf(l3 != null);
                                            if (zzn == 1) {
                                                arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar8.zzbd());
                                                if (valueOf2.booleanValue() && (zzbdVar2.zzi != null || zzbdVar2.zzj != null || zzbdVar2.zzk != null)) {
                                                    hashMap.put(zzhrVar8.zzk(), zzbdVar2.zzc(null, null, null));
                                                }
                                                zzicVar2.zzf(i32, zzhrVar8);
                                            } else {
                                                if (zzf.nextInt(zzn) == 0) {
                                                    zzp();
                                                    Long valueOf3 = Long.valueOf(zzn);
                                                    zzpk.zzF(zzhrVar8, "_sr", valueOf3);
                                                    arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar8.zzbd());
                                                    if (valueOf2.booleanValue()) {
                                                        zzbdVar2 = zzbdVar2.zzc(null, valueOf3, null);
                                                    }
                                                    hashMap.put(zzhrVar8.zzk(), zzbdVar2.zzb(zzhrVar8.zzn(), zzam22));
                                                    secureRandom = zzf;
                                                    i3 = i32;
                                                    zzpcVar = zzpcVar2;
                                                } else {
                                                    Long l4 = zzbdVar2.zzh;
                                                    if (l4 != null) {
                                                        zzam = l4.longValue();
                                                        secureRandom = zzf;
                                                        i2 = i32;
                                                        zzpcVar = zzpcVar2;
                                                    } else {
                                                        zzpcVar = zzpcVar2;
                                                        secureRandom = zzf;
                                                        i2 = i32;
                                                        zzam = zzt().zzam(zzhrVar8.zzp(), j2);
                                                    }
                                                    if (zzam != zzam22) {
                                                        zzp();
                                                        zzpk.zzF(zzhrVar8, "_efs", 1L);
                                                        zzp();
                                                        Long valueOf4 = Long.valueOf(zzn);
                                                        zzpk.zzF(zzhrVar8, "_sr", valueOf4);
                                                        arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar8.zzbd());
                                                        if (valueOf2.booleanValue()) {
                                                            zzbdVar2 = zzbdVar2.zzc(null, valueOf4, true);
                                                        }
                                                        hashMap.put(zzhrVar8.zzk(), zzbdVar2.zzb(zzhrVar8.zzn(), zzam22));
                                                        i3 = i2;
                                                    } else {
                                                        if (valueOf2.booleanValue()) {
                                                            hashMap.put(zzhrVar8.zzk(), zzbdVar2.zzc(l3, null, null));
                                                        }
                                                        i3 = i2;
                                                    }
                                                }
                                                zzicVar2.zzf(i3, zzhrVar8);
                                            }
                                        }
                                        secureRandom = zzf;
                                        i3 = i32;
                                        zzpcVar = zzpcVar2;
                                    }
                                    parseLong = 0;
                                    long zzam222 = zzpgVar2.zzt().zzam(zzhrVar8.zzn(), parseLong);
                                    com.google.android.gms.internal.measurement.zzhs zzhsVar22 = (com.google.android.gms.internal.measurement.zzhs) zzhrVar8.zzbd();
                                    Long l222 = 1L;
                                    if (!TextUtils.isEmpty("_dbg")) {
                                    }
                                    zzn = zzh().zzn(zzpcVar2.zza.zzA(), zzhrVar8.zzk());
                                    if (zzn > 0) {
                                    }
                                    secureRandom = zzf;
                                    i3 = i32;
                                    zzpcVar = zzpcVar2;
                                }
                                i32 = i3 + 1;
                                zzpgVar2 = this;
                                zzf = secureRandom;
                                zzpcVar2 = zzpcVar;
                            }
                            zzpc zzpcVar3 = zzpcVar2;
                            if (arrayList3.size() < zzicVar2.zzc()) {
                                zzicVar2.zzi();
                                zzicVar2.zzh(arrayList3);
                            }
                            for (Map.Entry entry : hashMap.entrySet()) {
                                zzj().zzh((zzbd) entry.getValue());
                            }
                            zzpcVar2 = zzpcVar3;
                        } catch (Throwable th) {
                            th = th;
                            zzpgVar3 = this;
                            zzpgVar3.zzj().zzd();
                            throw th;
                        }
                    }
                    String zzA8 = zzpcVar2.zza.zzA();
                    zzh zzu4 = zzj().zzu(zzA8);
                    if (zzu4 == null) {
                        zzaW().zzb().zzb("Bundling raw events w/o app info. appId", zzgu.zzl(zzpcVar2.zza.zzA()));
                    } else if (zzicVar2.zzc() > 0) {
                        long zzp2 = zzu4.zzp();
                        if (zzp2 != 0) {
                            zzicVar2.zzA(zzp2);
                        } else {
                            zzicVar2.zzB();
                        }
                        long zzn7 = zzu4.zzn();
                        if (zzn7 != 0) {
                            zzp2 = zzn7;
                        }
                        if (zzp2 != 0) {
                            zzicVar2.zzy(zzp2);
                        } else {
                            zzicVar2.zzz();
                        }
                        zzu4.zzM(zzicVar2.zzc());
                        zzicVar2.zzaJ((int) zzu4.zzaF());
                        zzicVar2.zzZ((int) zzu4.zzG());
                        zzu4.zzo(zzicVar2.zzu());
                        zzu4.zzq(zzicVar2.zzw());
                        String zzaa = zzu4.zzaa();
                        if (zzaa != null) {
                            zzicVar2.zzaa(zzaa);
                        } else {
                            zzicVar2.zzab();
                        }
                        zzj().zzv(zzu4, false, false);
                    }
                    if (zzicVar2.zzc() > 0) {
                        zzpgVar = this;
                        zzpgVar.zzn.zzaV();
                        if (zzpgVar.zzd().zzp(zzpcVar2.zza.zzA(), zzfy.zzbj)) {
                            String zzK = zzicVar2.zzK();
                            if (!TextUtils.isEmpty(zzK) && (zzu = zzpgVar.zzj().zzu(zzK)) != null) {
                                long currentTimeMillis = zzpgVar.zzba().currentTimeMillis();
                                if (currentTimeMillis - zzu.zzaN() >= zzpgVar.zzd().zzl(zzK, zzfy.zzaB)) {
                                    List zzac = zzpgVar.zzj().zzac("");
                                    if (!zzac.isEmpty()) {
                                        zzicVar2.zzaR(zzac);
                                    }
                                    List zzac2 = zzpgVar.zzj().zzac(zzK);
                                    if (!zzac2.isEmpty()) {
                                        zzicVar2.zzaR(zzac2);
                                    }
                                    zzu.zzaM(currentTimeMillis);
                                    zzpgVar.zzj().zzv(zzu, false, false);
                                }
                            }
                        }
                        com.google.android.gms.internal.measurement.zzgl zzb2 = zzpgVar.zzh().zzb(zzpcVar2.zza.zzA());
                        if (zzb2 != null && zzb2.zza()) {
                            zzicVar2.zzal(zzb2.zzb());
                            zzpgVar.zzj().zzz((com.google.android.gms.internal.measurement.zzid) zzicVar2.zzbd(), z7);
                        }
                        if (zzpcVar2.zza.zzP().isEmpty()) {
                            zzicVar2.zzal(-1L);
                        } else {
                            zzpgVar.zzaW().zze().zzb("Did not find measurement config or missing version info. appId", zzgu.zzl(zzpcVar2.zza.zzA()));
                        }
                        zzpgVar.zzj().zzz((com.google.android.gms.internal.measurement.zzid) zzicVar2.zzbd(), z7);
                    } else {
                        zzpgVar = this;
                    }
                    zzpgVar.zzj().zzS(zzpcVar2.zzb);
                    zzaw zzj = zzpgVar.zzj();
                    SQLiteDatabase zze = zzj.zze();
                    try {
                        String[] strArr = new String[2];
                        strArr[0] = zzA8;
                        z2 = true;
                        try {
                            strArr[1] = zzA8;
                            zze.execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", strArr);
                        } catch (SQLiteException e2) {
                            e = e2;
                            zzj.zzu.zzaW().zzb().zzc("Failed to remove unused event metadata. appId", zzgu.zzl(zzA8), e);
                            zzpgVar.zzj().zzc();
                            z = z2;
                            zzpgVar.zzj().zzd();
                            return z;
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                        z2 = true;
                    }
                    zzpgVar.zzj().zzc();
                    z = z2;
                    zzpgVar.zzj().zzd();
                    return z;
                }
                zzpgVar = zzpgVar2;
                zzpgVar.zzj().zzc();
                z = false;
                zzpgVar.zzj().zzd();
                return z;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            zzpgVar3 = zzpgVar2;
            zzpgVar3.zzj().zzd();
            throw th;
        }
    }

    private final void zzaI(com.google.android.gms.internal.measurement.zzic zzicVar, long j, boolean z) {
        String str;
        zzpn zzpnVar;
        Object obj;
        if (true != z) {
            str = "_lte";
        } else {
            str = "_se";
        }
        String str2 = str;
        zzpn zzm = zzj().zzm(zzicVar.zzK(), str2);
        if (zzm == null || (obj = zzm.zze) == null) {
            zzpnVar = new zzpn(zzicVar.zzK(), "auto", str2, zzba().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzpnVar = new zzpn(zzicVar.zzK(), "auto", str2, zzba().currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + j));
        }
        com.google.android.gms.internal.measurement.zzit zzm2 = com.google.android.gms.internal.measurement.zziu.zzm();
        zzm2.zzb(str2);
        zzm2.zza(zzba().currentTimeMillis());
        Object obj2 = zzpnVar.zze;
        zzm2.zze(((Long) obj2).longValue());
        com.google.android.gms.internal.measurement.zziu zziuVar = (com.google.android.gms.internal.measurement.zziu) zzm2.zzbd();
        int zzx = zzpk.zzx(zzicVar, str2);
        if (zzx < 0) {
            zzicVar.zzo(zziuVar);
        } else {
            zzicVar.zzn(zzx, zziuVar);
        }
        if (j > 0) {
            zzj().zzl(zzpnVar);
            zzaW().zzk().zzc("Updated engagement user property. scope, value", true != z ? "lifetime" : "session-scoped", obj2);
        }
    }

    private final boolean zzaJ(com.google.android.gms.internal.measurement.zzhr zzhrVar, com.google.android.gms.internal.measurement.zzhr zzhrVar2) {
        Preconditions.checkArgument("_e".equals(zzhrVar.zzk()));
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzI = zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbd(), "_sc");
        String zzd = zzI == null ? null : zzI.zzd();
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzI2 = zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar2.zzbd(), "_pc");
        String zzd2 = zzI2 != null ? zzI2.zzd() : null;
        if (zzd2 == null || !zzd2.equals(zzd)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzhrVar.zzk()));
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzI3 = zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbd(), "_et");
        if (zzI3 == null || !zzI3.zze() || zzI3.zzf() <= 0) {
            return true;
        }
        long zzf = zzI3.zzf();
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzI4 = zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar2.zzbd(), "_et");
        if (zzI4 != null && zzI4.zzf() > 0) {
            zzf += zzI4.zzf();
        }
        zzp();
        zzpk.zzF(zzhrVar2, "_et", Long.valueOf(zzf));
        zzp();
        zzpk.zzF(zzhrVar, "_fr", 1L);
        return true;
    }

    private final void zzaK(com.google.android.gms.internal.measurement.zzhr zzhrVar, String str, String str2) {
        ArrayList arrayList = new ArrayList(zzhrVar.zza());
        int i = 0;
        while (true) {
            if (i >= arrayList.size()) {
                i = -1;
                break;
            } else if (str.equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i)).zzb())) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        double zzk = zzhrVar.zzc(i).zzk() * 1000000.0d;
        if (zzk == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            zzk = zzhrVar.zzc(i).zzf() * 1000000.0d;
        }
        if (zzk <= 9.223372036854776E18d && zzk >= -9.223372036854776E18d) {
            zzhrVar.zzj(i);
            com.google.android.gms.internal.measurement.zzhv zzn = com.google.android.gms.internal.measurement.zzhw.zzn();
            zzn.zzb(str);
            zzn.zzf(Math.round(zzk));
            zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzn.zzbd());
            return;
        }
        zzaW().zze().zzc("Data lost. Purchase " + str + " is too big. appId", zzgu.zzl(str2), Double.valueOf(zzk));
    }

    private final boolean zzaL() {
        zzaX().zzg();
        zzu();
        return zzj().zzP() || !TextUtils.isEmpty(zzj().zzF());
    }

    private final void zzaM() {
        long max;
        long j;
        zzaX().zzg();
        zzu();
        if (this.zza > 0) {
            long abs = DurationKt.MILLIS_IN_HOUR - Math.abs(zzba().elapsedRealtime() - this.zza);
            if (abs > 0) {
                zzaW().zzk().zzb("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                zzk().zzb();
                zzl().zzf();
                return;
            }
            this.zza = 0L;
        }
        if (this.zzn.zzH() && zzaL()) {
            long currentTimeMillis = zzba().currentTimeMillis();
            zzd();
            long max2 = Math.max(0L, ((Long) zzfy.zzO.zzb(null)).longValue());
            boolean z = true;
            if (!zzj().zzR() && !zzj().zzG()) {
                z = false;
            }
            if (z) {
                String zzA = zzd().zzA();
                if (!TextUtils.isEmpty(zzA) && !".none.".equals(zzA)) {
                    zzd();
                    max = Math.max(0L, ((Long) zzfy.zzJ.zzb(null)).longValue());
                } else {
                    zzd();
                    max = Math.max(0L, ((Long) zzfy.zzI.zzb(null)).longValue());
                }
            } else {
                zzd();
                max = Math.max(0L, ((Long) zzfy.zzH.zzb(null)).longValue());
            }
            long zza = this.zzk.zzd.zza();
            long zza2 = this.zzk.zze.zza();
            long j2 = 0;
            boolean z2 = z;
            long max3 = Math.max(zzj().zzM(), zzj().zzO());
            if (max3 == 0) {
                j = 0;
            } else {
                long abs2 = currentTimeMillis - Math.abs(max3 - currentTimeMillis);
                long abs3 = currentTimeMillis - Math.abs(zza - currentTimeMillis);
                long abs4 = currentTimeMillis - Math.abs(zza2 - currentTimeMillis);
                j = max2 + abs2;
                long max4 = Math.max(abs3, abs4);
                if (z2 && max4 > 0) {
                    j = Math.min(abs2, max4) + max;
                }
                if (!zzp().zzs(max4, max)) {
                    j = max4 + max;
                }
                if (abs4 != 0 && abs4 >= abs2) {
                    int i = 0;
                    while (true) {
                        zzd();
                        if (i >= Math.min(20, Math.max(0, ((Integer) zzfy.zzQ.zzb(null)).intValue()))) {
                            j = 0;
                            break;
                        }
                        zzd();
                        j += Math.max(j2, ((Long) zzfy.zzP.zzb(null)).longValue()) * (1 << i);
                        if (j > abs4) {
                            break;
                        }
                        i++;
                        j2 = 0;
                    }
                }
                j2 = 0;
            }
            if (j == j2) {
                zzaW().zzk().zza("Next upload time is 0");
                zzk().zzb();
                zzl().zzf();
                return;
            } else if (zzi().zzb()) {
                long zza3 = this.zzk.zzc.zza();
                zzd();
                long max5 = Math.max(0L, ((Long) zzfy.zzF.zzb(null)).longValue());
                if (!zzp().zzs(zza3, max5)) {
                    j = Math.max(j, zza3 + max5);
                }
                zzk().zzb();
                long currentTimeMillis2 = j - zzba().currentTimeMillis();
                if (currentTimeMillis2 <= 0) {
                    zzd();
                    currentTimeMillis2 = Math.max(0L, ((Long) zzfy.zzK.zzb(null)).longValue());
                    this.zzk.zzd.zzb(zzba().currentTimeMillis());
                }
                zzaW().zzk().zzb("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
                zzl().zzd(currentTimeMillis2);
                return;
            } else {
                zzaW().zzk().zza("No network");
                zzk().zza();
                zzl().zzf();
                return;
            }
        }
        zzaW().zzk().zza("Nothing to upload or uploading impossible");
        zzk().zzb();
        zzl().zzf();
    }

    private final void zzaN() {
        zzaX().zzg();
        if (!this.zzu && !this.zzv && !this.zzw) {
            zzaW().zzk().zza("Stopping uploading service(s)");
            List<Runnable> list = this.zzq;
            if (list == null) {
                return;
            }
            for (Runnable runnable : list) {
                runnable.run();
            }
            ((List) Preconditions.checkNotNull(this.zzq)).clear();
            return;
        }
        zzaW().zzk().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv), Boolean.valueOf(this.zzw));
    }

    private final Boolean zzaO(zzh zzhVar) {
        try {
            int i = (zzhVar.zzt() > SieveCacheKt.NodeMetaAndPreviousMask ? 1 : (zzhVar.zzt() == SieveCacheKt.NodeMetaAndPreviousMask ? 0 : -1));
            zzic zzicVar = this.zzn;
            if (i == 0) {
                String str = Wrappers.packageManager(zzicVar.zzaZ()).getPackageInfo(zzhVar.zzc(), 0).versionName;
                String zzr = zzhVar.zzr();
                if (zzr != null && zzr.equals(str)) {
                    return true;
                }
            } else {
                if (zzhVar.zzt() == Wrappers.packageManager(zzicVar.zzaZ()).getPackageInfo(zzhVar.zzc(), 0).versionCode) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final zzr zzaP(String str) {
        zzh zzu = zzj().zzu(str);
        if (zzu == null || TextUtils.isEmpty(zzu.zzr())) {
            zzaW().zzj().zzb("No app data available; dropping", str);
            return null;
        }
        Boolean zzaO = zzaO(zzu);
        if (zzaO != null && !zzaO.booleanValue()) {
            zzaW().zzb().zzb("App version does not match; dropping. appId", zzgu.zzl(str));
            return null;
        }
        return new zzr(str, zzu.zzf(), zzu.zzr(), zzu.zzt(), zzu.zzv(), zzu.zzx(), zzu.zzz(), (String) null, zzu.zzD(), false, zzu.zzl(), 0L, 0, zzu.zzac(), false, zzu.zzae(), zzu.zzB(), zzu.zzag(), zzB(str).zzl(), "", (String) null, zzu.zzai(), zzu.zzak(), zzB(str).zzb(), zzx(str).zze(), zzu.zzao(), zzu.zzaw(), zzu.zzay(), zzu.zzaH(), 0L, zzu.zzaL(), 0L);
    }

    private final boolean zzaQ(String str, String str2) {
        zzbd zzf = zzj().zzf(str, str2);
        return zzf == null || zzf.zzc < 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzaR(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT < 34) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
        }
    }

    private static final boolean zzaS(zzr zzrVar) {
        return !TextUtils.isEmpty(zzrVar.zzb);
    }

    private static final zzos zzaT(zzos zzosVar) {
        if (zzosVar != null) {
            if (zzosVar.zzax()) {
                return zzosVar;
            }
            String valueOf = String.valueOf(zzosVar.getClass());
            String.valueOf(valueOf);
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(valueOf)));
        }
        throw new IllegalStateException("Upload Component not created");
    }

    private static final Boolean zzaU(zzr zzrVar) {
        Boolean bool = zzrVar.zzp;
        String str = zzrVar.zzC;
        if (!TextUtils.isEmpty(str)) {
            zzji zza = zze.zzc(str).zza();
            zzji zzjiVar = zzji.UNINITIALIZED;
            int ordinal = zza.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                return null;
            }
            if (ordinal == 2) {
                return true;
            }
            if (ordinal == 3) {
                return false;
            }
        }
        return bool;
    }

    final void zzA(String str, zzjl zzjlVar) {
        zzaX().zzg();
        zzu();
        this.zzC.put(str, zzjlVar);
        zzj().zzaa(str, zzjlVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzjl zzB(String str) {
        zzjl zzjlVar = zzjl.zza;
        zzaX().zzg();
        zzu();
        zzjl zzjlVar2 = (zzjl) this.zzC.get(str);
        if (zzjlVar2 == null) {
            zzjlVar2 = zzj().zzY(str);
            if (zzjlVar2 == null) {
                zzjlVar2 = zzjl.zza;
            }
            zzA(str, zzjlVar2);
        }
        return zzjlVar2;
    }

    final long zzC() {
        long currentTimeMillis = zzba().currentTimeMillis();
        zznn zznnVar = this.zzk;
        zznnVar.zzay();
        zznnVar.zzg();
        zzhe zzheVar = zznnVar.zzf;
        long zza = zzheVar.zza();
        if (zza == 0) {
            zza = zznnVar.zzu.zzk().zzf().nextInt(DateCalculationsKt.MILLIS_PER_DAY) + 1;
            zzheVar.zzb(zza);
        }
        return ((((currentTimeMillis + zza) / 1000) / 60) / 60) / 24;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzD(zzbh zzbhVar, String str) {
        zzh zzu = zzj().zzu(str);
        if (zzu == null || TextUtils.isEmpty(zzu.zzr())) {
            zzaW().zzj().zzb("No app data available; dropping event", str);
            return;
        }
        Boolean zzaO = zzaO(zzu);
        if (zzaO == null) {
            if (!"_ui".equals(zzbhVar.zza)) {
                zzaW().zze().zzb("Could not find package. appId", zzgu.zzl(str));
            }
        } else if (!zzaO.booleanValue()) {
            zzaW().zzb().zzb("App version does not match; dropping event. appId", zzgu.zzl(str));
            return;
        }
        zzE(zzbhVar, new zzr(str, zzu.zzf(), zzu.zzr(), zzu.zzt(), zzu.zzv(), zzu.zzx(), zzu.zzz(), (String) null, zzu.zzD(), false, zzu.zzl(), 0L, 0, zzu.zzac(), false, zzu.zzae(), zzu.zzB(), zzu.zzag(), zzB(str).zzl(), "", (String) null, zzu.zzai(), zzu.zzak(), zzB(str).zzb(), zzx(str).zze(), zzu.zzao(), zzu.zzaw(), zzu.zzay(), zzu.zzaH(), 0L, zzu.zzaL(), 0L));
    }

    final void zzE(zzbh zzbhVar, zzr zzrVar) {
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzgv zza = zzgv.zza(zzbhVar);
        zzt().zzK(zza.zze, zzj().zzV(str));
        zzt().zzI(zza, zzd().zzd(str));
        zzbh zzb2 = zza.zzb();
        if (!zzd().zzp(null, zzfy.zzaZ) && Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzb2.zza)) {
            zzbf zzbfVar = zzb2.zzb;
            if ("referrer API v2".equals(zzbfVar.zzd("_cis"))) {
                String zzd = zzbfVar.zzd("gclid");
                if (!TextUtils.isEmpty(zzd)) {
                    zzad(new zzpl("_lgclid", zzb2.zzd, zzd, "auto"), zzrVar);
                }
            }
        }
        zzF(zzb2, zzrVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzF(zzbh zzbhVar, zzr zzrVar) {
        char c;
        List zzt;
        List zzt2;
        List<zzah> zzt3;
        String str;
        Preconditions.checkNotNull(zzrVar);
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        zzaX().zzg();
        zzu();
        long j = zzbhVar.zzd;
        long j2 = zzbhVar.zze;
        zzgv zza = zzgv.zza(zzbhVar);
        zzaX().zzg();
        zzpp.zzay((this.zzG == null || (str = this.zzH) == null || !str.equals(str2)) ? null : null, zza.zze, false);
        zzbh zzb2 = zza.zzb();
        zzp();
        if (zzpk.zzG(zzb2, zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            List list = zzrVar.zzr;
            if (list != null) {
                String str3 = zzb2.zza;
                if (list.contains(str3)) {
                    Bundle zzf = zzb2.zzb.zzf();
                    c = 0;
                    zzf.putLong("ga_safelisted", 1L);
                    zzb2 = new zzbh(str3, new zzbf(zzf), zzb2.zzc, zzb2.zzd, zzb2.zze);
                } else {
                    zzaW().zzj().zzd("Dropping non-safelisted event. appId, event name, origin", str2, str3, zzb2.zzc);
                    return;
                }
            } else {
                c = 0;
            }
            zzj().zzb();
            try {
                String str4 = zzb2.zza;
                if ("_s".equals(str4) && !zzj().zzQ(str2, "_s") && zzb2.zzb.zzb("_sid").longValue() != 0) {
                    if (!zzj().zzQ(str2, "_f") && !zzj().zzQ(str2, "_v")) {
                        zzj().zzX(str2, Long.valueOf(zzba().currentTimeMillis() - 15000), "_sid", zzG(str2, zzb2));
                    }
                    zzj().zzX(str2, null, "_sid", zzG(str2, zzb2));
                }
                zzaw zzj = zzj();
                Preconditions.checkNotEmpty(str2);
                zzj.zzg();
                zzj.zzay();
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                boolean z = true;
                if (i < 0) {
                    zzj.zzu.zzaW().zze().zzc("Invalid time querying timed out conditional properties", zzgu.zzl(str2), Long.valueOf(j));
                    zzt = Collections.emptyList();
                } else {
                    String[] strArr = new String[2];
                    strArr[c] = str2;
                    strArr[1] = String.valueOf(j);
                    zzt = zzj.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", strArr);
                }
                Iterator it = zzt.iterator();
                while (it.hasNext()) {
                    zzah zzahVar = (zzah) it.next();
                    if (zzahVar != null) {
                        boolean z2 = z;
                        Iterator it2 = it;
                        zzaW().zzk().zzd("User property timed out", zzahVar.zza, this.zzn.zzl().zzc(zzahVar.zzc.zzb), zzahVar.zzc.zza());
                        zzbh zzbhVar2 = zzahVar.zzg;
                        if (zzbhVar2 != null) {
                            zzH(new zzbh(zzbhVar2, j, j2), zzrVar);
                        }
                        zzj().zzr(str2, zzahVar.zzc.zzb);
                        z = z2;
                        it = it2;
                    }
                }
                boolean z3 = z;
                zzaw zzj2 = zzj();
                Preconditions.checkNotEmpty(str2);
                zzj2.zzg();
                zzj2.zzay();
                if (i < 0) {
                    zzj2.zzu.zzaW().zze().zzc("Invalid time querying expired conditional properties", zzgu.zzl(str2), Long.valueOf(j));
                    zzt2 = Collections.emptyList();
                } else {
                    String[] strArr2 = new String[2];
                    strArr2[c] = str2;
                    strArr2[z3 ? 1 : 0] = String.valueOf(j);
                    zzt2 = zzj2.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", strArr2);
                }
                ArrayList<zzbh> arrayList = new ArrayList(zzt2.size());
                Iterator it3 = zzt2.iterator();
                while (it3.hasNext()) {
                    zzah zzahVar2 = (zzah) it3.next();
                    if (zzahVar2 != null) {
                        Iterator it4 = it3;
                        int i2 = i;
                        zzaW().zzk().zzd("User property expired", zzahVar2.zza, this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                        zzj().zzk(str2, zzahVar2.zzc.zzb);
                        zzbh zzbhVar3 = zzahVar2.zzk;
                        if (zzbhVar3 != null) {
                            arrayList.add(zzbhVar3);
                        }
                        zzj().zzr(str2, zzahVar2.zzc.zzb);
                        it3 = it4;
                        i = i2;
                    }
                }
                int i3 = i;
                for (zzbh zzbhVar4 : arrayList) {
                    zzH(new zzbh(zzbhVar4, j, j2), zzrVar);
                    j2 = j2;
                }
                long j3 = j2;
                zzaw zzj3 = zzj();
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str4);
                zzj3.zzg();
                zzj3.zzay();
                if (i3 < 0) {
                    zzic zzicVar = zzj3.zzu;
                    zzicVar.zzaW().zze().zzd("Invalid time querying triggered conditional properties", zzgu.zzl(str2), zzicVar.zzl().zza(str4), Long.valueOf(j));
                    zzt3 = Collections.emptyList();
                } else {
                    String[] strArr3 = new String[3];
                    strArr3[c] = str2;
                    strArr3[z3 ? 1 : 0] = str4;
                    strArr3[2] = String.valueOf(j);
                    zzt3 = zzj3.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", strArr3);
                }
                ArrayList<zzbh> arrayList2 = new ArrayList(zzt3.size());
                for (zzah zzahVar3 : zzt3) {
                    if (zzahVar3 != null) {
                        zzpl zzplVar = zzahVar3.zzc;
                        long j4 = j;
                        zzpn zzpnVar = new zzpn((String) Preconditions.checkNotNull(zzahVar3.zza), zzahVar3.zzb, zzplVar.zzb, j4, Preconditions.checkNotNull(zzplVar.zza()));
                        j = j4;
                        if (zzj().zzl(zzpnVar)) {
                            zzaW().zzk().zzd("User property triggered", zzahVar3.zza, this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                        } else {
                            zzaW().zzb().zzd("Too many active user properties, ignoring", zzgu.zzl(zzahVar3.zza), this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                        }
                        zzbh zzbhVar5 = zzahVar3.zzi;
                        if (zzbhVar5 != null) {
                            arrayList2.add(zzbhVar5);
                        }
                        zzahVar3.zzc = new zzpl(zzpnVar);
                        boolean z4 = z3 ? 1 : 0;
                        zzahVar3.zze = z4;
                        zzj().zzp(zzahVar3);
                        z3 = z4;
                    }
                }
                zzH(zzb2, zzrVar);
                for (zzbh zzbhVar6 : arrayList2) {
                    long j5 = j3;
                    zzH(new zzbh(zzbhVar6, j, j5), zzrVar);
                    j3 = j5;
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    final Bundle zzG(String str, zzbh zzbhVar) {
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", zzbhVar.zzb.zzb("_sid").longValue());
        zzpn zzm = zzj().zzm(str, "_sno");
        if (zzm != null) {
            Object obj = zzm.zze;
            if (obj instanceof Long) {
                bundle.putLong("_sno", ((Long) obj).longValue());
            }
        }
        return bundle;
    }

    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:686)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:544)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:175)
        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:171)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:365)
        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:313)
        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:302)
        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:302)
        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */
    /* JADX WARN: Can't wrap try/catch for region: R(19:322|(10:327|328|329|(1:331)|57|(0)(0)|60|(0)(0)|66|67)|332|333|334|335|336|337|338|339|328|329|(0)|57|(0)(0)|60|(0)(0)|66|67) */
    /* JADX WARN: Can't wrap try/catch for region: R(50:(2:69|(3:71|(1:73)|74))|75|(2:77|(3:79|(1:81)|82))|83|84|(1:86)|87|(2:91|(1:93))|94|(6:95|96|97|98|99|100)|101|(1:103)|104|(2:106|(2:112|113)(1:111))(1:287)|114|(1:116)|117|(1:119)|120|(1:122)|123|(1:125)|126|(1:128)|129|(1:131)|132|(6:136|(1:140)|141|(1:143)(1:176)|144|(1:146)(15:147|(1:149)(1:175)|150|(1:152)(1:174)|153|(1:155)(1:173)|156|(1:158)(1:172)|159|(1:161)(1:171)|162|(1:164)(1:170)|165|(1:167)(1:169)|168))|177|(1:179)|180|(1:182)|183|(1:187)|188|(12:(2:192|(28:195|(1:197)|198|(28:206|(1:208)(1:284)|209|(1:211)|212|213|(2:215|(1:217))|218|(3:220|(1:222)|223)(1:283)|224|(1:228)|229|(1:231)|232|(4:235|(2:245|246)(2:239|(2:241|242)(1:244))|243|233)|247|248|249|250|251|(2:252|(2:254|(1:256))(3:271|272|(1:276)))|258|259|260|(1:262)(2:267|268)|263|264|265)|285|213|(0)|218|(0)(0)|224|(2:226|228)|229|(0)|232|(1:233)|247|248|249|250|251|(3:252|(0)(0)|255)|258|259|260|(0)(0)|263|264|265))|249|250|251|(3:252|(0)(0)|255)|258|259|260|(0)(0)|263|264|265)|286|285|213|(0)|218|(0)(0)|224|(0)|229|(0)|232|(1:233)|247|248) */
    /* JADX WARN: Can't wrap try/catch for region: R(53:289|290|101|(0)|104|(0)(0)|114|(0)|117|(0)|120|(0)|123|(0)|126|(0)|129|(0)|132|(7:134|136|(2:138|140)|141|(0)(0)|144|(0)(0))|177|(0)|180|(0)|183|(2:185|187)|188|(3:190|192|(28:195|(0)|198|(31:200|202|204|206|(0)(0)|209|(0)|212|213|(0)|218|(0)(0)|224|(0)|229|(0)|232|(1:233)|247|248|249|250|251|(3:252|(0)(0)|255)|258|259|260|(0)(0)|263|264|265)|285|213|(0)|218|(0)(0)|224|(0)|229|(0)|232|(1:233)|247|248|249|250|251|(3:252|(0)(0)|255)|258|259|260|(0)(0)|263|264|265))|286|285|213|(0)|218|(0)(0)|224|(0)|229|(0)|232|(1:233)|247|248|249|250|251|(3:252|(0)(0)|255)|258|259|260|(0)(0)|263|264|265) */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x09c5, code lost:
        r14 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x0a85, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x0a86, code lost:
        r2.zzu.zzaW().zzb().zzc("Error storing raw event. appId", com.google.android.gms.measurement.internal.zzgu.zzl(r8.zza), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x0ab5, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x0ab6, code lost:
        zzaW().zzb().zzc("Data loss. Failed to insert raw event metadata. appId", com.google.android.gms.measurement.internal.zzgu.zzl(r9.zzK()), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0296, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0298, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0299, code lost:
        r47 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x029b, code lost:
        r13.zzu.zzaW().zzb().zzc("Error pruning currencies. appId", com.google.android.gms.measurement.internal.zzgu.zzl(r10), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x037a A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x04e1 A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0521 A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x059a A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x05df A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x05ea A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x05f5 A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0600 A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x060c A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x061d A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x067f  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0681  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0689  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x068b A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0700 A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0719 A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x077c A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x07c1 A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:255:0x07d9  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x07e5 A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x083b A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0852 A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x08ac  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x08b5 A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:281:0x08d6 A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x08f2 A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x09b8 A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0a6c A[Catch: SQLiteException -> 0x0a85, all -> 0x0afc, TRY_LEAVE, TryCatch #4 {SQLiteException -> 0x0a85, blocks: (B:309:0x0a5b, B:311:0x0a6c), top: B:336:0x0a5b, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0a80  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x09c7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x019c A[Catch: all -> 0x0afc, TRY_ENTER, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f7 A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0207 A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02d3 A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0317 A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzH(com.google.android.gms.measurement.internal.zzbh r47, com.google.android.gms.measurement.internal.zzr r48) {
        /*
            Method dump skipped, instructions count: 2821
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzH(com.google.android.gms.measurement.internal.zzbh, com.google.android.gms.measurement.internal.zzr):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzI(zzh zzhVar, com.google.android.gms.internal.measurement.zzic zzicVar) {
        com.google.android.gms.internal.measurement.zziu zziuVar;
        zzaX().zzg();
        zzu();
        zzan zzd = zzan.zzd(zzicVar.zzaA());
        String zzc = zzhVar.zzc();
        zzaX().zzg();
        zzu();
        zzjl zzB = zzB(zzc);
        zzji zzjiVar = zzji.UNINITIALIZED;
        int ordinal = zzB.zzp().ordinal();
        if (ordinal == 1) {
            zzd.zzc(zzjk.AD_STORAGE, zzam.REMOTE_ENFORCED_DEFAULT);
        } else if (ordinal == 2 || ordinal == 3) {
            zzd.zzb(zzjk.AD_STORAGE, zzB.zzb());
        } else {
            zzd.zzc(zzjk.AD_STORAGE, zzam.FAILSAFE);
        }
        int ordinal2 = zzB.zzq().ordinal();
        if (ordinal2 == 1) {
            zzd.zzc(zzjk.ANALYTICS_STORAGE, zzam.REMOTE_ENFORCED_DEFAULT);
        } else if (ordinal2 == 2 || ordinal2 == 3) {
            zzd.zzb(zzjk.ANALYTICS_STORAGE, zzB.zzb());
        } else {
            zzd.zzc(zzjk.ANALYTICS_STORAGE, zzam.FAILSAFE);
        }
        String zzc2 = zzhVar.zzc();
        zzaX().zzg();
        zzu();
        zzba zzz = zzz(zzc2, zzx(zzc2), zzB(zzc2), zzd);
        zzicVar.zzaD(((Boolean) Preconditions.checkNotNull(zzz.zzj())).booleanValue());
        if (!TextUtils.isEmpty(zzz.zzk())) {
            zzicVar.zzaF(zzz.zzk());
        }
        zzaX().zzg();
        zzu();
        Iterator it = zzicVar.zzk().iterator();
        while (true) {
            if (!it.hasNext()) {
                zziuVar = null;
                break;
            }
            zziuVar = (com.google.android.gms.internal.measurement.zziu) it.next();
            if ("_npa".equals(zziuVar.zzc())) {
                break;
            }
        }
        if (zziuVar != null) {
            zzjk zzjkVar = zzjk.AD_PERSONALIZATION;
            if (zzd.zza(zzjkVar) == zzam.UNSET) {
                zzpn zzm = zzj().zzm(zzhVar.zzc(), "_npa");
                if (zzm != null) {
                    String str = zzm.zzb;
                    if ("tcf".equals(str)) {
                        zzd.zzc(zzjkVar, zzam.TCF);
                    } else if ("app".equals(str)) {
                        zzd.zzc(zzjkVar, zzam.API);
                    } else {
                        zzd.zzc(zzjkVar, zzam.MANIFEST);
                    }
                } else {
                    Boolean zzae = zzhVar.zzae();
                    if (zzae == null || ((zzae.booleanValue() && zziuVar.zzh() != 1) || (!zzae.booleanValue() && zziuVar.zzh() != 0))) {
                        zzd.zzc(zzjkVar, zzam.API);
                    } else {
                        zzd.zzc(zzjkVar, zzam.MANIFEST);
                    }
                }
            }
        } else {
            int zzaD = zzaD(zzhVar.zzc(), zzd);
            com.google.android.gms.internal.measurement.zzit zzm2 = com.google.android.gms.internal.measurement.zziu.zzm();
            zzm2.zzb("_npa");
            zzm2.zza(zzba().currentTimeMillis());
            zzm2.zze(zzaD);
            zzicVar.zzo((com.google.android.gms.internal.measurement.zziu) zzm2.zzbd());
            zzaW().zzk().zzc("Setting user property", "non_personalized_ads(_npa)", Integer.valueOf(zzaD));
        }
        zzicVar.zzaB(zzd.toString());
        boolean zzz2 = this.zzc.zzz(zzhVar.zzc());
        List zzb2 = zzicVar.zzb();
        int i = 0;
        for (int i2 = 0; i2 < zzb2.size(); i2++) {
            if ("_tcf".equals(((com.google.android.gms.internal.measurement.zzhs) zzb2.get(i2)).zzd())) {
                com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) ((com.google.android.gms.internal.measurement.zzhs) zzb2.get(i2)).zzco();
                List zza = zzhrVar.zza();
                int i3 = 0;
                while (true) {
                    if (i3 >= zza.size()) {
                        break;
                    } else if ("_tcfd".equals(((com.google.android.gms.internal.measurement.zzhw) zza.get(i3)).zzb())) {
                        String zzd2 = ((com.google.android.gms.internal.measurement.zzhw) zza.get(i3)).zzd();
                        if (zzz2 && zzd2.length() > 4) {
                            char[] charArray = zzd2.toCharArray();
                            int i4 = 1;
                            while (true) {
                                if (i4 >= 64) {
                                    break;
                                } else if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i4)) {
                                    i = i4;
                                    break;
                                } else {
                                    i4++;
                                }
                            }
                            charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i | 1);
                            zzd2 = String.valueOf(charArray);
                        }
                        com.google.android.gms.internal.measurement.zzhv zzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                        zzn.zzb("_tcfd");
                        zzn.zzd(zzd2);
                        zzhrVar.zze(i3, zzn);
                    } else {
                        i3++;
                    }
                }
                zzicVar.zzf(i2, zzhrVar);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzJ(zzh zzhVar, com.google.android.gms.internal.measurement.zzic zzicVar) {
        zzaX().zzg();
        zzu();
        com.google.android.gms.internal.measurement.zzgx zzt = com.google.android.gms.internal.measurement.zzha.zzt();
        byte[] zzaJ = zzhVar.zzaJ();
        if (zzaJ != null) {
            try {
                zzt = (com.google.android.gms.internal.measurement.zzgx) zzpk.zzw(zzt, zzaJ);
            } catch (zzaeh unused) {
                zzaW().zze().zzb("Failed to parse locally stored ad campaign info. appId", zzgu.zzl(zzhVar.zzc()));
            }
        }
        for (com.google.android.gms.internal.measurement.zzhs zzhsVar : zzicVar.zzb()) {
            if (zzhsVar.zzd().equals(Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN)) {
                String str = (String) zzpk.zzN(zzhsVar, "gclid", "");
                String str2 = (String) zzpk.zzN(zzhsVar, "gbraid", "");
                String str3 = (String) zzpk.zzN(zzhsVar, "gad_source", "");
                String str4 = (String) zzpk.zzN(zzhsVar, "deep_link_url", "");
                String[] split = ((String) zzfy.zzbb.zzb(null)).split(StringUtils.COMMA);
                zzp();
                if (!zzpk.zzK(zzhsVar, split).isEmpty()) {
                    long longValue = ((Long) zzpk.zzN(zzhsVar, "click_timestamp", 0L)).longValue();
                    if (longValue <= 0) {
                        longValue = zzhsVar.zzf();
                    }
                    if ("referrer API v2".equals(zzpk.zzM(zzhsVar, "_cis"))) {
                        if (longValue > zzt.zzo()) {
                            if (str.isEmpty()) {
                                zzt.zzj();
                            } else {
                                zzt.zzi(str);
                            }
                            if (str2.isEmpty()) {
                                zzt.zzl();
                            } else {
                                zzt.zzk(str2);
                            }
                            if (str3.isEmpty()) {
                                zzt.zzn();
                            } else {
                                zzt.zzm(str3);
                            }
                            zzt.zzp(longValue);
                            zzt.zzs();
                            zzt.zzt(zzaE(zzhsVar));
                        }
                    } else if (longValue > zzt.zzg()) {
                        if (str.isEmpty()) {
                            zzt.zzb();
                        } else {
                            zzt.zza(str);
                        }
                        if (str2.isEmpty()) {
                            zzt.zzd();
                        } else {
                            zzt.zzc(str2);
                        }
                        if (str3.isEmpty()) {
                            zzt.zzf();
                        } else {
                            zzt.zze(str3);
                        }
                        if (zzd().zzp(null, zzfy.zzba)) {
                            if (str4.isEmpty()) {
                                zzt.zzv();
                            } else {
                                zzt.zzu(str4);
                            }
                        }
                        zzt.zzh(longValue);
                        zzt.zzq();
                        zzt.zzr(zzaE(zzhsVar));
                    }
                }
            }
        }
        if (!((com.google.android.gms.internal.measurement.zzha) zzt.zzbd()).equals(com.google.android.gms.internal.measurement.zzha.zzu())) {
            zzicVar.zzaM((com.google.android.gms.internal.measurement.zzha) zzt.zzbd());
        }
        zzhVar.zzaI(((com.google.android.gms.internal.measurement.zzha) zzt.zzbd()).zzcd());
        if (zzhVar.zza()) {
            zzj().zzv(zzhVar, false, false);
        }
        if (zzd().zzp(null, zzfy.zzba)) {
            for (int i = 0; i < zzicVar.zzc(); i++) {
                com.google.android.gms.internal.measurement.zzhs zzd = zzicVar.zzd(i);
                if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzd.zzd())) {
                    com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzd.zzco();
                    List zza = zzhrVar.zza();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= zza.size()) {
                            break;
                        } else if ("deep_link_url".equals(((com.google.android.gms.internal.measurement.zzhw) zza.get(i2)).zzb())) {
                            zzhrVar.zzj(i2);
                            zzicVar.zzf(i, zzhrVar);
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
        }
        if (zzd().zzp(null, zzfy.zzaZ)) {
            zzj().zzk(zzhVar.zzc(), "_lgclid");
        }
    }

    final String zzK(zzjl zzjlVar) {
        if (zzjlVar.zzo(zzjk.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            zzt().zzf().nextBytes(bArr);
            return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        }
        return null;
    }

    final void zzL(List list) {
        Preconditions.checkArgument(!list.isEmpty());
        if (this.zzz != null) {
            zzaW().zzb().zza("Set uploading progress before finishing the previous upload");
        } else {
            this.zzz = new ArrayList(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0106, code lost:
        if (r8 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0108, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0110, code lost:
        if (r8 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0125, code lost:
        if (r8 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0128, code lost:
        r12.zzB = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0171, code lost:
        if (r0 != 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0173, code lost:
        r0.close();
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x017b, code lost:
        if (r0 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0195, code lost:
        if (r0 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0198, code lost:
        r0 = android.text.TextUtils.isEmpty(r8);
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x019c, code lost:
        if (r0 != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x019e, code lost:
        r0 = zzj().zzu(r8);
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01a6, code lost:
        if (r0 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01a8, code lost:
        zzX(r0);
        r0 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.String] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x0195 -> B:56:0x0173). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x0195 -> B:70:0x0198). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzM() {
        zzaw zzj;
        long zzF;
        SQLiteException e;
        zzaw zzawVar;
        zzaX().zzg();
        zzu();
        Cursor cursor = 1;
        this.zzw = true;
        try {
            zzic zzicVar = this.zzn;
            zzicVar.zzaV();
            Boolean zzJ = zzicVar.zzt().zzJ();
            if (zzJ == null) {
                zzaW().zze().zza("Upload data called on the client side before use of service was decided");
            } else if (zzJ.booleanValue()) {
                zzaW().zzb().zza("Upload called in the client side when service should be used");
            } else if (this.zza <= 0) {
                zzaX().zzg();
                if (this.zzz != null) {
                    zzaW().zzk().zza("Uploading requested multiple times");
                } else if (!zzi().zzb()) {
                    zzaW().zzk().zza("Network not connected, ignoring upload request");
                    zzaM();
                } else {
                    long currentTimeMillis = zzba().currentTimeMillis();
                    Cursor cursor2 = null;
                    Cursor cursor3 = null;
                    r8 = null;
                    r8 = null;
                    r8 = null;
                    String str = null;
                    int zzm = zzd().zzm(null, zzfy.zzah);
                    zzd();
                    long zzF2 = currentTimeMillis - zzal.zzF();
                    for (int i = 0; i < zzm && zzaH(null, zzF2); i++) {
                    }
                    zzaif.zza();
                    zzaX().zzg();
                    zzaw();
                    long zza = this.zzk.zzd.zza();
                    if (zza != 0) {
                        zzaW().zzj().zzb("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - zza)));
                    }
                    String zzF3 = zzj().zzF();
                    long j = -1;
                    if (TextUtils.isEmpty(zzF3)) {
                        try {
                            this.zzB = -1L;
                            zzj = zzj();
                            zzd();
                            zzF = currentTimeMillis - zzal.zzF();
                            zzj.zzg();
                            zzj.zzay();
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                        }
                        try {
                            cursor = zzj.zze().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(zzF)});
                            try {
                                if (!cursor.moveToFirst()) {
                                    zzj.zzu.zzaW().zzk().zza("No expired configs for apps with pending events");
                                    zzawVar = zzj;
                                    zzj = zzj;
                                } else {
                                    str = cursor.getString(0);
                                    zzawVar = zzj;
                                    zzj = zzj;
                                }
                            } catch (SQLiteException e2) {
                                e = e2;
                                ?? r4 = "Error selecting expired configs";
                                zzj.zzu.zzaW().zzb().zzb("Error selecting expired configs", e);
                                zzawVar = r4;
                                zzj = r4;
                            }
                        } catch (SQLiteException e3) {
                            e = e3;
                            cursor = null;
                            ?? r42 = "Error selecting expired configs";
                            zzj.zzu.zzaW().zzb().zzb("Error selecting expired configs", e);
                            zzawVar = r42;
                            zzj = r42;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            throw th;
                        }
                    } else {
                        if (this.zzB == -1) {
                            zzaw zzj2 = zzj();
                            try {
                                cursor3 = zzj2.zze().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                                if (cursor3.moveToFirst()) {
                                    j = cursor3.getLong(0);
                                }
                            } catch (SQLiteException e4) {
                                zzj2.zzu.zzaW().zzb().zzb("Error querying raw events", e4);
                            }
                        }
                        zzN(zzF3, currentTimeMillis);
                    }
                }
            } else {
                zzaM();
            }
        } finally {
            this.zzw = false;
            zzaN();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:155:0x0445, code lost:
        if (r17 != null) goto L308;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0447, code lost:
        r17.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0474, code lost:
        if (r17 == null) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01df, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0206, code lost:
        if (r10 != null) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x09b5  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0a04  */
    /* JADX WARN: Removed duplicated region for block: B:452:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:453:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0214  */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v58 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzN(String str, long j) {
        long j2;
        Cursor cursor;
        Cursor cursor2;
        List emptyList;
        List<Pair> list;
        boolean z;
        Object obj;
        String str2;
        zzot zzotVar;
        boolean z2;
        List list2;
        boolean z3;
        int i;
        String str3;
        Cursor cursor3;
        List list3;
        Cursor cursor4;
        List list4;
        int i2;
        int i3;
        SQLiteDatabase zze;
        long currentTimeMillis;
        Cursor query;
        byte[] blob;
        zzpk zzp;
        long j3;
        long j4;
        int zzm = zzd().zzm(str, zzfy.zzg);
        int i4 = 0;
        int max = Math.max(0, zzd().zzm(str, zzfy.zzh));
        zzaw zzj = zzj();
        zzj.zzg();
        zzj.zzay();
        int i5 = 1;
        Preconditions.checkArgument(zzm > 0);
        ?? r10 = max > 0 ? 1 : 0;
        Preconditions.checkArgument(r10);
        Preconditions.checkNotEmpty(str);
        try {
            try {
                try {
                    j2 = -1;
                    try {
                        cursor2 = zzj.zze().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(zzm));
                        try {
                        } catch (SQLiteException e) {
                            e = e;
                            zzj.zzu.zzaW().zzb().zzc("Error querying bundles. appId", zzgu.zzl(str), e);
                            emptyList = Collections.emptyList();
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        cursor2 = null;
                        zzj.zzu.zzaW().zzb().zzc("Error querying bundles. appId", zzgu.zzl(str), e);
                        emptyList = Collections.emptyList();
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = r10;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            j2 = -1;
        }
        if (!cursor2.moveToFirst()) {
            emptyList = Collections.emptyList();
            if (cursor2 != null) {
                cursor2.close();
            }
            list = emptyList;
            if (!list.isEmpty()) {
                return;
            }
            zzahh.zza();
            zzal zzd = zzd();
            zzfx zzfxVar = zzfy.zzbc;
            if (zzd.zzp(null, zzfxVar)) {
                zzahh.zza();
                if (zzd().zzp(null, zzfxVar)) {
                    if (!zzB(str).zzo(zzjk.ANALYTICS_STORAGE) && zzh().zzC(str)) {
                        List asList = Arrays.asList(((String) zzfy.zzbd.zzb(null)).split(StringUtils.COMMA));
                        for (Pair pair : list) {
                            try {
                                zzj().zzH(((Long) pair.second).longValue());
                                for (com.google.android.gms.internal.measurement.zzhs zzhsVar : ((com.google.android.gms.internal.measurement.zzid) pair.first).zzc()) {
                                    if (asList.contains(zzhsVar.zzd())) {
                                        if (zzhsVar.zzd().equals("_f") || zzhsVar.zzd().equals("_v")) {
                                            com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzhsVar.zzco();
                                            zzp();
                                            zzpk.zzF(zzhrVar, "_dac", 1L);
                                            zzhsVar = (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbd();
                                        }
                                        zzaw zzj2 = zzj();
                                        zzj2.zzg();
                                        zzj2.zzay();
                                        Preconditions.checkNotNull(zzhsVar);
                                        Preconditions.checkNotEmpty(str);
                                        zzic zzicVar = zzj2.zzu;
                                        zzicVar.zzaW().zzk().zzb("Caching events in NO_DATA mode", zzhsVar);
                                        ContentValues contentValues = new ContentValues();
                                        contentValues.put("app_id", str);
                                        contentValues.put("name", zzhsVar.zzd());
                                        contentValues.put("data", zzhsVar.zzcd());
                                        contentValues.put("timestamp_millis", Long.valueOf(zzhsVar.zzf()));
                                        try {
                                            if (zzj2.zze().insert("no_data_mode_events", null, contentValues) == j2) {
                                                zzicVar.zzaW().zzb().zzb("Failed to insert NO_DATA mode event (got -1). appId", zzgu.zzl(str));
                                            }
                                        } catch (SQLiteException e4) {
                                            zzj2.zzu.zzaW().zzb().zzc("Error storing NO_DATA mode event. appId", zzgu.zzl(str), e4);
                                        }
                                    }
                                }
                            } catch (SQLiteException unused) {
                                zzaW().zzh().zzb("Failed handling NO_DATA mode bundles. appId", str);
                            }
                        }
                        list = Collections.emptyList();
                    } else {
                        ArrayList arrayList = new ArrayList(list.size());
                        zzaw zzj3 = zzj();
                        Preconditions.checkNotEmpty(str);
                        zzj3.zzg();
                        zzj3.zzay();
                        List arrayList2 = new ArrayList();
                        try {
                            try {
                                zze = zzj3.zze();
                                currentTimeMillis = zzj3.zzu.zzba().currentTimeMillis();
                                query = zze.query("no_data_mode_events", new String[]{"data"}, "app_id=? AND timestamp_millis <= CAST(? AS INTEGER)", new String[]{str, String.valueOf(currentTimeMillis)}, null, null, "rowid", null);
                                list3 = list;
                            } catch (SQLiteException e5) {
                                e = e5;
                                list3 = list;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            cursor3 = null;
                            if (cursor3 != null) {
                            }
                            throw th;
                        }
                        try {
                            if (query.moveToFirst()) {
                                while (true) {
                                    try {
                                        arrayList2.add((com.google.android.gms.internal.measurement.zzhs) ((com.google.android.gms.internal.measurement.zzhr) zzpk.zzw(com.google.android.gms.internal.measurement.zzhs.zzp(), query.getBlob(0))).zzbd());
                                        cursor4 = query;
                                    } catch (zzaeh e6) {
                                        cursor4 = query;
                                        try {
                                            try {
                                                zzj3.zzu.zzaW().zzh().zzc("Failed to parse stored NO_DATA mode event, appId", zzgu.zzl(str), e6);
                                            } catch (SQLiteException e7) {
                                                e = e7;
                                                zzj3.zzu.zzaW().zzb().zzc("Error flushing NO_DATA mode events. appId", zzgu.zzl(str), e);
                                                arrayList2 = Collections.emptyList();
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            cursor3 = cursor4;
                                            if (cursor3 != null) {
                                                cursor3.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    if (!cursor4.moveToNext()) {
                                        break;
                                    }
                                    query = cursor4;
                                }
                                cursor4.close();
                                try {
                                    int delete = zze.delete("no_data_mode_events", "app_id=? AND timestamp_millis <= CAST(? AS INTEGER)", new String[]{str, String.valueOf(currentTimeMillis)});
                                    zzgs zzk = zzj3.zzu.zzaW().zzk();
                                    StringBuilder sb = new StringBuilder(String.valueOf(delete).length() + 34);
                                    sb.append("Pruned ");
                                    sb.append(delete);
                                    sb.append(" NO_DATA mode events. appId");
                                    zzk.zzb(sb.toString(), str);
                                } catch (SQLiteException e8) {
                                    e = e8;
                                    cursor4 = null;
                                    zzj3.zzu.zzaW().zzb().zzc("Error flushing NO_DATA mode events. appId", zzgu.zzl(str), e);
                                    arrayList2 = Collections.emptyList();
                                }
                            } else {
                                cursor4 = query;
                            }
                        } catch (SQLiteException e9) {
                            e = e9;
                            cursor4 = query;
                            zzj3.zzu.zzaW().zzb().zzc("Error flushing NO_DATA mode events. appId", zzgu.zzl(str), e);
                            arrayList2 = Collections.emptyList();
                        } catch (Throwable th5) {
                            th = th5;
                            cursor4 = query;
                            cursor3 = cursor4;
                            if (cursor3 != null) {
                            }
                            throw th;
                        }
                        Iterator it = list3.iterator();
                        boolean z4 = true;
                        while (it.hasNext()) {
                            Pair pair2 = (Pair) it.next();
                            com.google.android.gms.internal.measurement.zzic zzicVar2 = (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzid) pair2.first).zzco();
                            if (z4 && !arrayList2.isEmpty()) {
                                List zzb2 = zzicVar2.zzb();
                                zzicVar2.zzi();
                                zzicVar2.zzh(arrayList2);
                                zzicVar2.zzh(zzb2);
                                z4 = false;
                            }
                            com.google.android.gms.internal.measurement.zzhh zzb3 = com.google.android.gms.internal.measurement.zzho.zzb();
                            com.google.android.gms.internal.measurement.zzgf zzy = zzh().zzy(str);
                            ArrayList arrayList3 = new ArrayList();
                            if (zzy != null) {
                                for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzy.zza()) {
                                    com.google.android.gms.internal.measurement.zzhk zza = com.google.android.gms.internal.measurement.zzhl.zza();
                                    int zzb4 = zzfuVar.zzb();
                                    zzji zzjiVar = zzji.UNINITIALIZED;
                                    Iterator it2 = it;
                                    int i6 = zzb4 - 1;
                                    boolean z5 = z4;
                                    if (i6 == 1) {
                                        list4 = arrayList2;
                                        i2 = 3;
                                        i3 = 2;
                                    } else if (i6 != 2) {
                                        list4 = arrayList2;
                                        i2 = 3;
                                        i3 = i6 != 3 ? i6 != 4 ? 1 : 5 : 4;
                                    } else {
                                        list4 = arrayList2;
                                        i2 = 3;
                                        i3 = 3;
                                    }
                                    zza.zza(i3);
                                    int zzd2 = zzfuVar.zzd() - 1;
                                    zza.zzb(zzd2 != 1 ? zzd2 != 2 ? 1 : i2 : 2);
                                    arrayList3.add((com.google.android.gms.internal.measurement.zzhl) zza.zzbd());
                                    z4 = z5;
                                    it = it2;
                                    arrayList2 = list4;
                                }
                            }
                            Iterator it3 = it;
                            boolean z6 = z4;
                            List list5 = arrayList2;
                            zzb3.zza(arrayList3);
                            zzicVar2.zzaP(zzb3);
                            arrayList.add(Pair.create((com.google.android.gms.internal.measurement.zzid) zzicVar2.zzbd(), (Long) pair2.second));
                            z4 = z6;
                            it = it3;
                            arrayList2 = list5;
                        }
                        list = arrayList;
                    }
                }
                if (list.isEmpty()) {
                    return;
                }
            }
            zzjl zzB = zzB(str);
            zzjk zzjkVar = zzjk.AD_STORAGE;
            if (zzB.zzo(zzjkVar)) {
                Iterator it4 = list.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        str3 = null;
                        break;
                    }
                    com.google.android.gms.internal.measurement.zzid zzidVar = (com.google.android.gms.internal.measurement.zzid) ((Pair) it4.next()).first;
                    if (!zzidVar.zzG().isEmpty()) {
                        str3 = zzidVar.zzG();
                        break;
                    }
                }
                if (str3 != null) {
                    int i7 = 0;
                    while (true) {
                        if (i7 >= list.size()) {
                            break;
                        }
                        com.google.android.gms.internal.measurement.zzid zzidVar2 = (com.google.android.gms.internal.measurement.zzid) ((Pair) list.get(i7)).first;
                        if (!zzidVar2.zzG().isEmpty() && !zzidVar2.zzG().equals(str3)) {
                            list = list.subList(0, i7);
                            break;
                        }
                        i7++;
                    }
                }
            }
            com.google.android.gms.internal.measurement.zzhz zzi = com.google.android.gms.internal.measurement.zzib.zzi();
            int size = list.size();
            List arrayList4 = new ArrayList(list.size());
            boolean z7 = zzd().zzC(str) && zzB(str).zzo(zzjkVar);
            boolean zzo = zzB(str).zzo(zzjkVar);
            boolean zzo2 = zzB(str).zzo(zzjk.ANALYTICS_STORAGE);
            zzair.zza();
            boolean zzp2 = zzd().zzp(str, zzfy.zzaM);
            zzou zzouVar = this.zzl;
            zzot zza2 = zzouVar.zza(str);
            int i8 = 0;
            while (i8 < size) {
                boolean z8 = zzo;
                com.google.android.gms.internal.measurement.zzic zzicVar3 = (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzid) ((Pair) list.get(i8)).first).zzco();
                int i9 = size;
                arrayList4.add((Long) ((Pair) list.get(i8)).second);
                zzd().zzi();
                boolean z9 = z7;
                boolean z10 = zzo2;
                zzicVar3.zzO(161000L);
                zzicVar3.zzs(j);
                this.zzn.zzaV();
                zzicVar3.zzae(false);
                if (!z9) {
                    zzicVar3.zzan();
                }
                if (!z8) {
                    zzicVar3.zzR();
                    zzicVar3.zzU();
                }
                if (!z10) {
                    zzicVar3.zzX();
                }
                zzS(str, zzicVar3);
                if (!zzp2) {
                    zzicVar3.zzav();
                }
                if (!z10) {
                    zzicVar3.zzag();
                }
                String zzP = zzicVar3.zzP();
                if (TextUtils.isEmpty(zzP) || zzP.equals("00000000-0000-0000-0000-000000000000")) {
                    ArrayList arrayList5 = new ArrayList(zzicVar3.zzb());
                    Iterator it5 = arrayList5.iterator();
                    z2 = z9;
                    Long l = null;
                    Long l2 = null;
                    boolean z11 = false;
                    boolean z12 = false;
                    while (it5.hasNext()) {
                        List list6 = list;
                        com.google.android.gms.internal.measurement.zzhs zzhsVar2 = (com.google.android.gms.internal.measurement.zzhs) it5.next();
                        boolean z13 = zzp2;
                        int i10 = i8;
                        if ("_fx".equals(zzhsVar2.zzd())) {
                            it5.remove();
                            zzp2 = z13;
                            list = list6;
                            i8 = i10;
                            z11 = true;
                        } else if ("_f".equals(zzhsVar2.zzd())) {
                            zzp();
                            com.google.android.gms.internal.measurement.zzhw zzI = zzpk.zzI(zzhsVar2, "_pfo");
                            if (zzI != null) {
                                l = Long.valueOf(zzI.zzf());
                            }
                            zzp();
                            com.google.android.gms.internal.measurement.zzhw zzI2 = zzpk.zzI(zzhsVar2, "_uwa");
                            if (zzI2 != null) {
                                l2 = Long.valueOf(zzI2.zzf());
                            }
                            zzp2 = z13;
                            list = list6;
                            i8 = i10;
                        } else {
                            zzp2 = z13;
                            list = list6;
                            i8 = i10;
                        }
                        z12 = true;
                    }
                    list2 = list;
                    z3 = zzp2;
                    i = i8;
                    if (z11) {
                        zzicVar3.zzi();
                        zzicVar3.zzh(arrayList5);
                    }
                    if (z12) {
                        zzR(zzicVar3.zzK(), true, l, l2);
                    }
                } else {
                    z2 = z9;
                    list2 = list;
                    z3 = zzp2;
                    i = i8;
                }
                if (zzicVar3.zzc() != 0) {
                    if (zzd().zzp(str, zzfy.zzaC)) {
                        zzicVar3.zzas(zzp().zzt(((com.google.android.gms.internal.measurement.zzid) zzicVar3.zzbd()).zzcd()));
                    }
                    com.google.android.gms.internal.measurement.zzis zzd3 = zza2.zzd();
                    if (zzd3 != null) {
                        zzicVar3.zzaN(zzd3);
                    }
                    zzi.zze(zzicVar3);
                }
                i8 = i + 1;
                zzo2 = z10;
                zzo = z8;
                size = i9;
                z7 = z2;
                zzp2 = z3;
                list = list2;
            }
            if (zzi.zzb() == 0) {
                zzL(arrayList4);
                zzW(false, ComposerKt.providerMapsKey, null, null, str, Collections.emptyList(), null);
                return;
            }
            com.google.android.gms.internal.measurement.zzib zzibVar = (com.google.android.gms.internal.measurement.zzib) zzi.zzbd();
            List arrayList6 = new ArrayList();
            boolean z14 = zza2.zzc() == zzls.SGTM_CLIENT;
            if (zza2.zzc() == zzls.SGTM) {
                z = z14;
            } else if (!z14) {
                obj = null;
                if (zzi().zzb()) {
                    return;
                }
                if (Log.isLoggable(zzaW().zzn(), 2)) {
                    obj = zzp().zzi(zzibVar);
                }
                zzp();
                byte[] zzcd = zzibVar.zzcd();
                zzL(arrayList4);
                this.zzk.zze.zzb(j);
                zzaW().zzk().zzd("Uploading data. app, uncompressed size, data", str, Integer.valueOf(zzcd.length), obj);
                this.zzv = true;
                zzi().zzc(str, zza2, zzibVar, new zzow(this, str, arrayList6));
                return;
            } else {
                z = true;
            }
            Iterator it6 = ((com.google.android.gms.internal.measurement.zzib) zzi.zzbd()).zza().iterator();
            while (true) {
                if (it6.hasNext()) {
                    if (((com.google.android.gms.internal.measurement.zzid) it6.next()).zzY()) {
                        str2 = UUID.randomUUID().toString();
                        break;
                    }
                } else {
                    str2 = null;
                    break;
                }
            }
            com.google.android.gms.internal.measurement.zzib zzibVar2 = (com.google.android.gms.internal.measurement.zzib) zzi.zzbd();
            zzaX().zzg();
            zzu();
            com.google.android.gms.internal.measurement.zzhz zzj4 = com.google.android.gms.internal.measurement.zzib.zzj(zzibVar2);
            if (!TextUtils.isEmpty(str2)) {
                zzj4.zzi(str2);
            }
            String zzc = zzh().zzc(str);
            if (!TextUtils.isEmpty(zzc)) {
                zzj4.zzj(zzc);
            }
            ArrayList arrayList7 = new ArrayList();
            for (com.google.android.gms.internal.measurement.zzid zzidVar3 : zzibVar2.zza()) {
                com.google.android.gms.internal.measurement.zzic zzaF = com.google.android.gms.internal.measurement.zzid.zzaF(zzidVar3);
                zzaF.zzan();
                arrayList7.add((com.google.android.gms.internal.measurement.zzid) zzaF.zzbd());
            }
            zzj4.zzg();
            zzj4.zzf(arrayList7);
            zzaW().zzk().zzb("[sgtm] Processed MeasurementBatch for sGTM with sgtmJoinId: ", TextUtils.isEmpty(str2) ? AbstractJsonLexerKt.NULL : zzj4.zzh());
            com.google.android.gms.internal.measurement.zzib zzibVar3 = (com.google.android.gms.internal.measurement.zzib) zzj4.zzbd();
            if (TextUtils.isEmpty(str2)) {
                obj = null;
            } else {
                zzaX().zzg();
                zzu();
                com.google.android.gms.internal.measurement.zzhz zzi2 = com.google.android.gms.internal.measurement.zzib.zzi();
                zzaW().zzk().zzb("[sgtm] Processing Google Signal, sgtmJoinId:", str2);
                zzi2.zzi(str2);
                for (com.google.android.gms.internal.measurement.zzid zzidVar4 : ((com.google.android.gms.internal.measurement.zzib) zzi.zzbd()).zza()) {
                    com.google.android.gms.internal.measurement.zzic zzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                    zzaE.zzam(zzidVar4.zzZ());
                    zzaE.zzaJ(zzidVar4.zzav());
                    zzi2.zze(zzaE);
                }
                com.google.android.gms.internal.measurement.zzib zzibVar4 = (com.google.android.gms.internal.measurement.zzib) zzi2.zzbd();
                String zzc2 = zzouVar.zzg.zzh().zzc(str);
                if (!TextUtils.isEmpty(zzc2)) {
                    Uri parse = Uri.parse((String) zzfy.zzr.zzb(null));
                    Uri.Builder buildUpon = parse.buildUpon();
                    String authority = parse.getAuthority();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(zzc2).length() + 1 + String.valueOf(authority).length());
                    sb2.append(zzc2);
                    sb2.append(".");
                    sb2.append(authority);
                    buildUpon.authority(sb2.toString());
                    obj = null;
                    zzotVar = new zzot(buildUpon.build().toString(), Collections.emptyMap(), z ? zzls.GOOGLE_SIGNAL_PENDING : zzls.GOOGLE_SIGNAL, null);
                } else {
                    obj = null;
                    zzotVar = new zzot((String) zzfy.zzr.zzb(null), Collections.emptyMap(), z ? zzls.GOOGLE_SIGNAL_PENDING : zzls.GOOGLE_SIGNAL, null);
                }
                arrayList6.add(Pair.create(zzibVar4, zzotVar));
            }
            if (!z) {
                zzibVar = zzibVar3;
                if (zzi().zzb()) {
                }
            } else {
                com.google.android.gms.internal.measurement.zzhz zzhzVar = (com.google.android.gms.internal.measurement.zzhz) zzibVar3.zzco();
                for (int i11 = 0; i11 < zzibVar3.zzb(); i11++) {
                    com.google.android.gms.internal.measurement.zzic zzicVar4 = (com.google.android.gms.internal.measurement.zzic) zzibVar3.zzc(i11).zzco();
                    zzicVar4.zzt();
                    zzicVar4.zzaO(j);
                    zzhzVar.zzd(i11, zzicVar4);
                }
                arrayList6.add(Pair.create((com.google.android.gms.internal.measurement.zzib) zzhzVar.zzbd(), zza2));
                zzL(arrayList4);
                zzW(false, ComposerKt.providerMapsKey, null, null, str, arrayList6, null);
                if (zzO(str, zza2.zza())) {
                    zzaW().zzk().zzb("[sgtm] Sending sgtm batches available notification to app", str);
                    Intent intent = new Intent();
                    intent.setAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                    intent.setPackage(str);
                    zzaR(this.zzn.zzaZ(), intent);
                }
            }
        } else {
            list = new ArrayList();
            int i12 = 0;
            while (true) {
                long j5 = cursor2.getLong(i4);
                try {
                    blob = cursor2.getBlob(i5);
                    zzp = zzj.zzg.zzp();
                } catch (IOException e10) {
                    zzj.zzu.zzaW().zzb().zzc("Failed to unzip queued bundle. appId", zzgu.zzl(str), e10);
                }
                try {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(blob);
                    GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = gZIPInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
                        byteArrayOutputStream.write(bArr, 0, read);
                        byteArrayInputStream = byteArrayInputStream2;
                    }
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (!list.isEmpty() && byteArray.length + i12 > max) {
                        break;
                    }
                    try {
                        com.google.android.gms.internal.measurement.zzic zzicVar5 = (com.google.android.gms.internal.measurement.zzic) zzpk.zzw(com.google.android.gms.internal.measurement.zzid.zzaE(), byteArray);
                        if (!list.isEmpty()) {
                            com.google.android.gms.internal.measurement.zzid zzidVar5 = (com.google.android.gms.internal.measurement.zzid) ((Pair) list.get(0)).first;
                            com.google.android.gms.internal.measurement.zzid zzidVar6 = (com.google.android.gms.internal.measurement.zzid) zzicVar5.zzbd();
                            if (!zzidVar5.zzaf().equals(zzidVar6.zzaf()) || !zzidVar5.zzam().equals(zzidVar6.zzam()) || zzidVar5.zzao() != zzidVar6.zzao() || !zzidVar5.zzaq().equals(zzidVar6.zzaq())) {
                                break;
                            }
                            Iterator it7 = zzidVar5.zzf().iterator();
                            while (true) {
                                if (!it7.hasNext()) {
                                    j3 = -1;
                                    break;
                                }
                                com.google.android.gms.internal.measurement.zziu zziuVar = (com.google.android.gms.internal.measurement.zziu) it7.next();
                                Iterator it8 = it7;
                                if ("_npa".equals(zziuVar.zzc())) {
                                    j3 = zziuVar.zzh();
                                    break;
                                }
                                it7 = it8;
                            }
                            Iterator it9 = zzidVar6.zzf().iterator();
                            while (true) {
                                if (!it9.hasNext()) {
                                    j4 = -1;
                                    break;
                                }
                                com.google.android.gms.internal.measurement.zziu zziuVar2 = (com.google.android.gms.internal.measurement.zziu) it9.next();
                                if ("_npa".equals(zziuVar2.zzc())) {
                                    j4 = zziuVar2.zzh();
                                    break;
                                }
                            }
                            if (j3 != j4) {
                                break;
                            }
                        }
                        if (!cursor2.isNull(2)) {
                            zzicVar5.zzao(cursor2.getInt(2));
                        }
                        i12 += byteArray.length;
                        list.add(Pair.create((com.google.android.gms.internal.measurement.zzid) zzicVar5.zzbd(), Long.valueOf(j5)));
                    } catch (IOException e11) {
                        zzj.zzu.zzaW().zzb().zzc("Failed to merge queued bundle. appId", zzgu.zzl(str), e11);
                    }
                    if (!cursor2.moveToNext() || i12 > max) {
                        break;
                    }
                    i4 = 0;
                    i5 = 1;
                } catch (IOException e12) {
                    zzp.zzu.zzaW().zzb().zzb("Failed to ungzip content", e12);
                    throw e12;
                    break;
                }
            }
            if (!list.isEmpty()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzO(String str, String str2) {
        zzh zzu = zzj().zzu(str);
        if (zzu != null && zzt().zzad(str, zzu.zzay())) {
            this.zzF.remove(str2);
            return true;
        }
        zzpe zzpeVar = (zzpe) this.zzF.get(str2);
        if (zzpeVar == null) {
            return true;
        }
        return zzpeVar.zzb();
    }

    final void zzP(String str) {
        com.google.android.gms.internal.measurement.zzib zzd;
        zzaX().zzg();
        zzu();
        this.zzw = true;
        try {
            zzic zzicVar = this.zzn;
            zzicVar.zzaV();
            Boolean zzJ = zzicVar.zzt().zzJ();
            if (zzJ == null) {
                zzaW().zze().zza("Upload data called on the client side before use of service was decided");
            } else if (zzJ.booleanValue()) {
                zzaW().zzb().zza("Upload called in the client side when service should be used");
            } else if (this.zza > 0) {
                zzaM();
            } else if (!zzi().zzb()) {
                zzaW().zzk().zza("Network not connected, ignoring upload request");
                zzaM();
            } else if (!zzj().zzD(str)) {
                zzaW().zzk().zzb("[sgtm] Upload queue has no batches for appId", str);
            } else {
                zzaw zzj = zzj();
                Preconditions.checkNotEmpty(str);
                zzj.zzg();
                zzj.zzay();
                List zzC = zzj.zzC(str, zzoo.zza(zzls.GOOGLE_SIGNAL), 1);
                zzpj zzpjVar = zzC.isEmpty() ? null : (zzpj) zzC.get(0);
                if (zzpjVar != null && (zzd = zzpjVar.zzd()) != null) {
                    zzaW().zzk().zzd("[sgtm] Uploading data from upload queue. appId, type, url", str, zzpjVar.zzf(), zzpjVar.zze());
                    byte[] zzcd = zzd.zzcd();
                    if (Log.isLoggable(zzaW().zzn(), 2)) {
                        zzaW().zzk().zzd("[sgtm] Uploading data from upload queue. appId, uncompressed size, data", str, Integer.valueOf(zzcd.length), zzp().zzi(zzd));
                    }
                    zzot zza = zzpjVar.zza();
                    this.zzv = true;
                    zzi().zzc(str, zza, zzd, new zzox(this, str, zzpjVar));
                }
            }
        } finally {
            this.zzw = false;
            zzaN();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzQ(String str, int i, Throwable th, byte[] bArr, zzpj zzpjVar) {
        zzaX().zzg();
        zzu();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzv = false;
                zzaN();
                throw th2;
            }
        }
        if (i != 200) {
            if (i == 204) {
                i = 204;
            }
            String str2 = new String(bArr, StandardCharsets.UTF_8);
            String substring = str2.substring(0, Math.min(32, str2.length()));
            zzgs zzh = zzaW().zzh();
            Integer valueOf = Integer.valueOf(i);
            if (th == null) {
                th = substring;
            }
            zzh.zzd("Network upload failed. Will retry later. appId, status, error", str, valueOf, th);
            zzj().zzK(Long.valueOf(zzpjVar.zzc()));
            zzaM();
            this.zzv = false;
            zzaN();
        }
        if (th == null) {
            zzj().zzE(Long.valueOf(zzpjVar.zzc()));
            zzaW().zzk().zzc("Successfully uploaded batch from upload queue. appId, status", str, Integer.valueOf(i));
            if (zzi().zzb() && zzj().zzD(str)) {
                zzP(str);
            } else {
                zzaM();
            }
            this.zzv = false;
            zzaN();
        }
        String str22 = new String(bArr, StandardCharsets.UTF_8);
        String substring2 = str22.substring(0, Math.min(32, str22.length()));
        zzgs zzh2 = zzaW().zzh();
        Integer valueOf2 = Integer.valueOf(i);
        if (th == null) {
        }
        zzh2.zzd("Network upload failed. Will retry later. appId, status, error", str, valueOf2, th);
        zzj().zzK(Long.valueOf(zzpjVar.zzc()));
        zzaM();
        this.zzv = false;
        zzaN();
    }

    final void zzR(String str, boolean z, Long l, Long l2) {
        zzh zzu = zzj().zzu(str);
        if (zzu != null) {
            zzu.zzar(z);
            zzu.zzat(l);
            zzu.zzav(l2);
            if (zzu.zza()) {
                zzj().zzv(zzu, false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzS(String str, com.google.android.gms.internal.measurement.zzic zzicVar) {
        int zzx;
        int indexOf;
        Set zzl = zzh().zzl(str);
        if (zzl != null) {
            zzicVar.zzaw(zzl);
        }
        if (zzh().zzq(str)) {
            zzicVar.zzG();
        }
        if (zzh().zzr(str)) {
            String zzD = zzicVar.zzD();
            if (!TextUtils.isEmpty(zzD) && (indexOf = zzD.indexOf(".")) != -1) {
                zzicVar.zzE(zzD.substring(0, indexOf));
            }
        }
        if (zzh().zzs(str) && (zzx = zzpk.zzx(zzicVar, APEZProvider.FILEID)) != -1) {
            zzicVar.zzr(zzx);
        }
        if (zzh().zzt(str)) {
            zzicVar.zzan();
        }
        if (zzh().zzu(str)) {
            zzicVar.zzX();
            if (zzB(str).zzo(zzjk.ANALYTICS_STORAGE)) {
                Map map = this.zzE;
                zzpd zzpdVar = (zzpd) map.get(str);
                if (zzpdVar == null || zzpdVar.zzb + zzd().zzl(str, zzfy.zzaj) < zzba().elapsedRealtime()) {
                    zzpdVar = new zzpd(this, (byte[]) null);
                    map.put(str, zzpdVar);
                }
                zzicVar.zzax(zzpdVar.zza);
            }
        }
        if (zzh().zzv(str)) {
            zzicVar.zzav();
        }
    }

    final void zzT(com.google.android.gms.internal.measurement.zzic zzicVar, zzpc zzpcVar) {
        for (int i = 0; i < zzicVar.zzc(); i++) {
            com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzicVar.zzd(i).zzco();
            Iterator it = zzhrVar.zza().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if ("_c".equals(((com.google.android.gms.internal.measurement.zzhw) it.next()).zzb())) {
                    if (zzpcVar.zza.zzar() >= zzd().zzm(zzpcVar.zza.zzA(), zzfy.zzak)) {
                        int zzm = zzd().zzm(zzpcVar.zza.zzA(), zzfy.zzax);
                        String str = null;
                        if (zzm > 0) {
                            if (zzj().zzw(zzC(), zzpcVar.zza.zzA(), false, false, false, false, false, false, true).zzg > zzm) {
                                com.google.android.gms.internal.measurement.zzhv zzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzn.zzb("_tnr");
                                zzn.zzf(1L);
                                zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzn.zzbd());
                            } else {
                                if (zzd().zzp(zzpcVar.zza.zzA(), zzfy.zzaQ)) {
                                    str = zzt().zzaz();
                                    com.google.android.gms.internal.measurement.zzhv zzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                    zzn2.zzb("_tu");
                                    zzn2.zzd(str);
                                    zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzn2.zzbd());
                                }
                                com.google.android.gms.internal.measurement.zzhv zzn3 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzn3.zzb("_tr");
                                zzn3.zzf(1L);
                                zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzn3.zzbd());
                                zzoh zzf = zzp().zzf(zzpcVar.zza.zzA(), zzicVar, zzhrVar, str);
                                if (zzf != null) {
                                    zzaW().zzk().zzc("Generated trigger URI. appId, uri", zzpcVar.zza.zzA(), zzf.zza);
                                    zzj().zzZ(zzpcVar.zza.zzA(), zzf);
                                    Deque deque = this.zzr;
                                    if (!deque.contains(zzpcVar.zza.zzA())) {
                                        deque.add(zzpcVar.zza.zzA());
                                    }
                                }
                            }
                        } else {
                            if (zzd().zzp(zzpcVar.zza.zzA(), zzfy.zzaQ)) {
                                str = zzt().zzaz();
                                com.google.android.gms.internal.measurement.zzhv zzn4 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzn4.zzb("_tu");
                                zzn4.zzd(str);
                                zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzn4.zzbd());
                            }
                            com.google.android.gms.internal.measurement.zzhv zzn5 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzn5.zzb("_tr");
                            zzn5.zzf(1L);
                            zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzn5.zzbd());
                            zzoh zzf2 = zzp().zzf(zzpcVar.zza.zzA(), zzicVar, zzhrVar, str);
                            if (zzf2 != null) {
                                zzaW().zzk().zzc("Generated trigger URI. appId, uri", zzpcVar.zza.zzA(), zzf2.zza);
                                zzj().zzZ(zzpcVar.zza.zzA(), zzf2);
                                Deque deque2 = this.zzr;
                                if (!deque2.contains(zzpcVar.zza.zzA())) {
                                    deque2.add(zzpcVar.zza.zzA());
                                }
                            }
                        }
                    }
                    zzicVar.zze(i, (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbd());
                }
            }
        }
    }

    final void zzU(String str, com.google.android.gms.internal.measurement.zzhv zzhvVar, Bundle bundle, String str2) {
        List listOf;
        int zzf;
        if (zzd().zzp(str2, zzfy.zzba)) {
            listOf = CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si", "deep_link_url"});
        } else {
            listOf = CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"});
        }
        if (!zzpp.zzac(zzhvVar.zza()) && !zzpp.zzac(str)) {
            zzf = zzd().zze(str2, true);
        } else {
            zzf = zzd().zzf(str2, true);
        }
        long j = zzf;
        long codePointCount = zzhvVar.zzc().codePointCount(0, zzhvVar.zzc().length());
        zzpp zzt = zzt();
        String zza = zzhvVar.zza();
        zzd();
        String zzE = zzt.zzE(zza, 40, true);
        if (codePointCount <= j || listOf.contains(zzhvVar.zza())) {
            return;
        }
        if ("_ev".equals(zzhvVar.zza())) {
            bundle.putString("_ev", zzt().zzE(zzhvVar.zzc(), zzd().zzf(str2, true), true));
            return;
        }
        zzaW().zzh().zzc("Param value is too long; discarded. Name, value length", zzE, Long.valueOf(codePointCount));
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", 4L);
            if (bundle.getString("_ev") == null) {
                bundle.putString("_ev", zzE);
                bundle.putLong("_el", codePointCount);
            }
        }
        bundle.remove(zzhvVar.zza());
    }

    final boolean zzV(com.google.android.gms.internal.measurement.zzhr zzhrVar) {
        ArrayList arrayList = new ArrayList(zzhrVar.zza());
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if ("value".equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i3)).zzb())) {
                i = i3;
            } else if (FirebaseAnalytics.Param.CURRENCY.equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i3)).zzb())) {
                i2 = i3;
            }
        }
        if (i == -1) {
            if (zzd().zzp(null, zzfy.zzbf) && "_iap".equals(zzhrVar.zzk())) {
                zzaC(zzhrVar, "_c");
                zzaB(zzhrVar, 18, "value");
                return false;
            }
            return true;
        } else if (!((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i)).zze() && !((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i)).zzj()) {
            zzaW().zzh().zza("Value must be specified with a numeric type.");
            zzhrVar.zzj(i);
            zzaC(zzhrVar, "_c");
            zzaB(zzhrVar, 18, "value");
            return false;
        } else {
            if (i2 != -1) {
                String zzd = ((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i2)).zzd();
                if (zzd.length() == 3) {
                    int i4 = 0;
                    while (i4 < zzd.length()) {
                        int codePointAt = zzd.codePointAt(i4);
                        if (Character.isLetter(codePointAt)) {
                            i4 += Character.charCount(codePointAt);
                        }
                    }
                    return true;
                }
            }
            zzaW().zzh().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
            zzhrVar.zzj(i);
            zzaC(zzhrVar, "_c");
            zzaB(zzhrVar, 19, FirebaseAnalytics.Param.CURRENCY);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
        if (r21 != null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzW(boolean z, int i, Throwable th, byte[] bArr, String str, List list, Map map) {
        byte[] bArr2;
        int i2 = i;
        zzaX().zzg();
        zzu();
        if (bArr == null) {
            try {
                bArr2 = new byte[0];
            } finally {
                this.zzv = false;
                zzaN();
            }
        } else {
            bArr2 = bArr;
        }
        if (zzd().zzp(null, zzfy.zzbe)) {
            zzp().zzD(map);
        }
        List<Long> list2 = (List) Preconditions.checkNotNull(this.zzz);
        this.zzz = null;
        try {
            if (z) {
                if (i2 != 200) {
                    if (i2 == 204) {
                        i2 = 204;
                    }
                    String str2 = new String(bArr2, StandardCharsets.UTF_8);
                    zzaW().zzh().zzd("Network upload failed. Will retry later. code, error", Integer.valueOf(i2), th, str2.substring(0, Math.min(32, str2.length())));
                    this.zzk.zze.zzb(zzba().currentTimeMillis());
                    if (i2 == 503 || i2 == 429) {
                        this.zzk.zzc.zzb(zzba().currentTimeMillis());
                    }
                    zzj().zzJ(list2);
                    zzaM();
                    return;
                }
            }
            HashMap hashMap = new HashMap();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                com.google.android.gms.internal.measurement.zzib zzibVar = (com.google.android.gms.internal.measurement.zzib) pair.first;
                zzot zzotVar = (zzot) pair.second;
                if (zzotVar.zzc() != zzls.SGTM_CLIENT) {
                    long zzA = zzj().zzA(str, zzibVar, zzotVar.zza(), zzotVar.zzb(), zzotVar.zzc(), null);
                    if (zzotVar.zzc() == zzls.GOOGLE_SIGNAL_PENDING && zzA != -1 && !zzibVar.zze().isEmpty()) {
                        hashMap.put(zzibVar.zze(), Long.valueOf(zzA));
                    }
                }
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Pair pair2 = (Pair) it2.next();
                com.google.android.gms.internal.measurement.zzib zzibVar2 = (com.google.android.gms.internal.measurement.zzib) pair2.first;
                zzot zzotVar2 = (zzot) pair2.second;
                if (zzotVar2.zzc() == zzls.SGTM_CLIENT) {
                    zzj().zzA(str, zzibVar2, zzotVar2.zza(), zzotVar2.zzb(), zzotVar2.zzc(), (Long) hashMap.get(zzibVar2.zze()));
                }
            }
            List zzC = zzj().zzC(str, zzoo.zza(zzls.SGTM_CLIENT), 1);
            if (!zzC.isEmpty()) {
                long zzg = ((zzpj) zzC.get(0)).zzg();
                if (zzba().currentTimeMillis() > ((Long) zzfy.zzE.zzb(null)).longValue() + zzg) {
                    zzaW().zze().zzc("[sgtm] client batches are queued too long. appId, creationTime", str, Long.valueOf(zzg));
                }
            }
            for (Long l : list2) {
                try {
                    zzj().zzH(l.longValue());
                } catch (SQLiteException e) {
                    List list3 = this.zzA;
                    if (list3 == null || !list3.contains(l)) {
                        throw e;
                    }
                }
            }
            zzj().zzc();
            zzj().zzd();
            this.zzA = null;
            if (zzi().zzb() && zzj().zzD(str)) {
                zzP(str);
            } else if (zzi().zzb() && zzaL()) {
                zzM();
            } else {
                this.zzB = -1L;
                zzaM();
            }
            this.zza = 0L;
            return;
        } catch (Throwable th2) {
            zzj().zzd();
            throw th2;
        }
        zzgs zzk = zzaW().zzk();
        Integer valueOf = Integer.valueOf(i2);
        zzk.zzc("Network upload successful with code, uploadAttempted", valueOf, Boolean.valueOf(z));
        if (z) {
            try {
                this.zzk.zzd.zzb(zzba().currentTimeMillis());
            } catch (SQLiteException e2) {
                zzaW().zzb().zzb("Database error while trying to delete uploaded bundles", e2);
                this.zza = zzba().elapsedRealtime();
                zzaW().zzk().zzb("Disable upload, time", Long.valueOf(this.zza));
            }
        }
        this.zzk.zze.zzb(0L);
        zzaM();
        if (z) {
            zzaW().zzk().zzc("Successful upload. Got network response. code, size", valueOf, Integer.valueOf(bArr2.length));
        } else {
            zzaW().zzk().zza("Purged empty bundles");
        }
        zzj().zzb();
    }

    final void zzX(zzh zzhVar) {
        zzaX().zzg();
        if (TextUtils.isEmpty(zzhVar.zzf())) {
            zzY((String) Preconditions.checkNotNull(zzhVar.zzc()), ComposerKt.providerMapsKey, null, null, null);
            return;
        }
        String str = (String) Preconditions.checkNotNull(zzhVar.zzc());
        zzaW().zzk().zzb("Fetching remote configuration", str);
        com.google.android.gms.internal.measurement.zzgl zzb2 = zzh().zzb(str);
        String zzd = zzh().zzd(str);
        ArrayMap arrayMap = null;
        if (zzb2 != null) {
            if (!TextUtils.isEmpty(zzd)) {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put(HttpHeaders.IF_MODIFIED_SINCE, zzd);
                arrayMap = arrayMap2;
            }
            String zze = zzh().zze(str);
            if (!TextUtils.isEmpty(zze)) {
                if (arrayMap == null) {
                    arrayMap = new ArrayMap();
                }
                arrayMap.put(HttpHeaders.IF_NONE_MATCH, zze);
            }
        }
        this.zzu = true;
        zzi().zzd(zzhVar, arrayMap, new zzgw() { // from class: com.google.android.gms.measurement.internal.zzpf
            @Override // com.google.android.gms.measurement.internal.zzgw
            public final /* synthetic */ void zza(String str2, int i, Throwable th, byte[] bArr, Map map) {
                zzpg.this.zzY(str2, i, th, bArr, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005b A[Catch: all -> 0x0178, TryCatch #2 {all -> 0x0181, blocks: (B:4:0x0010, B:5:0x0012, B:7:0x0031, B:8:0x0038, B:54:0x016b, B:9:0x003f, B:19:0x005b, B:53:0x0164, B:24:0x0075, B:29:0x00c5, B:28:0x00b6, B:30:0x00ca, B:34:0x00e1, B:38:0x00fa, B:40:0x010e, B:42:0x012d, B:44:0x0137, B:46:0x013d, B:47:0x0141, B:49:0x014b, B:51:0x0159, B:52:0x0161, B:41:0x011c, B:35:0x00e9, B:37:0x00f3), top: B:63:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010e A[Catch: all -> 0x0178, TryCatch #2 {all -> 0x0181, blocks: (B:4:0x0010, B:5:0x0012, B:7:0x0031, B:8:0x0038, B:54:0x016b, B:9:0x003f, B:19:0x005b, B:53:0x0164, B:24:0x0075, B:29:0x00c5, B:28:0x00b6, B:30:0x00ca, B:34:0x00e1, B:38:0x00fa, B:40:0x010e, B:42:0x012d, B:44:0x0137, B:46:0x013d, B:47:0x0141, B:49:0x014b, B:51:0x0159, B:52:0x0161, B:41:0x011c, B:35:0x00e9, B:37:0x00f3), top: B:63:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011c A[Catch: all -> 0x0178, TryCatch #2 {all -> 0x0181, blocks: (B:4:0x0010, B:5:0x0012, B:7:0x0031, B:8:0x0038, B:54:0x016b, B:9:0x003f, B:19:0x005b, B:53:0x0164, B:24:0x0075, B:29:0x00c5, B:28:0x00b6, B:30:0x00ca, B:34:0x00e1, B:38:0x00fa, B:40:0x010e, B:42:0x012d, B:44:0x0137, B:46:0x013d, B:47:0x0141, B:49:0x014b, B:51:0x0159, B:52:0x0161, B:41:0x011c, B:35:0x00e9, B:37:0x00f3), top: B:63:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzY(String str, int i, Throwable th, byte[] bArr, Map map) {
        boolean z;
        zzaX().zzg();
        zzu();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.zzu = false;
                zzaN();
            }
        }
        zzgs zzk = zzaW().zzk();
        Integer valueOf = Integer.valueOf(bArr.length);
        zzk.zzb("onConfigFetched. Response size", valueOf);
        if (zzd().zzp(null, zzfy.zzbe)) {
            zzp().zzD(map);
        }
        zzj().zzb();
        zzh zzu = zzj().zzu(str);
        if (i != 200 && i != 204) {
            if (i == 304) {
                i = 304;
            }
            z = false;
            if (zzu == null) {
                zzaW().zze().zzb("App does not exist in onConfigFetched. appId", zzgu.zzl(str));
            } else {
                if (!z && i != 404) {
                    zzu.zzK(zzba().currentTimeMillis());
                    zzj().zzv(zzu, false, false);
                    zzaW().zzk().zzc("Fetching config failed. code, error", Integer.valueOf(i), th);
                    zzh().zzf(str);
                    this.zzk.zze.zzb(zzba().currentTimeMillis());
                    if (i == 503 || i == 429) {
                        this.zzk.zzc.zzb(zzba().currentTimeMillis());
                    }
                    zzaM();
                }
                zzp();
                String zzJ = zzpk.zzJ(map, HttpHeaders.LAST_MODIFIED);
                zzp();
                String zzJ2 = zzpk.zzJ(map, HttpHeaders.ETAG);
                if (i != 404 && i != 304) {
                    zzh().zzi(str, bArr, zzJ, zzJ2);
                    zzu.zzI(zzba().currentTimeMillis());
                    zzj().zzv(zzu, false, false);
                    if (i != 404) {
                        zzaW().zzh().zzb("Config not found. Using empty config. appId", str);
                    } else {
                        zzaW().zzk().zzc("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), valueOf);
                    }
                    if (!zzi().zzb() && zzaL()) {
                        zzM();
                    } else if (!zzi().zzb() && zzj().zzD(zzu.zzc())) {
                        zzP(zzu.zzc());
                    } else {
                        zzaM();
                    }
                }
                if (zzh().zzb(str) == null) {
                    zzh().zzi(str, null, null, null);
                }
                zzu.zzI(zzba().currentTimeMillis());
                zzj().zzv(zzu, false, false);
                if (i != 404) {
                }
                if (!zzi().zzb()) {
                }
                if (!zzi().zzb()) {
                }
                zzaM();
            }
            zzj().zzc();
            zzj().zzd();
        }
        if (th == null) {
            z = true;
            if (zzu == null) {
            }
            zzj().zzc();
            zzj().zzd();
        }
        z = false;
        if (zzu == null) {
        }
        zzj().zzc();
        zzj().zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzZ(Runnable runnable) {
        zzaX().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaA(long j) {
        this.zzJ = j;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzae zzaV() {
        return this.zzn.zzaV();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzgu zzaW() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzaW();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzhz zzaX() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzaX();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final Context zzaZ() {
        return this.zzn.zzaZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaa() {
        zzaX().zzg();
        zzu();
        if (this.zzp) {
            return;
        }
        this.zzp = true;
        if (zzab()) {
            FileChannel fileChannel = this.zzy;
            zzaX().zzg();
            int i = 0;
            if (fileChannel == null || !fileChannel.isOpen()) {
                zzaW().zzb().zza("Bad channel to read from");
            } else {
                ByteBuffer allocate = ByteBuffer.allocate(4);
                try {
                    fileChannel.position(0L);
                    int read = fileChannel.read(allocate);
                    if (read == 4) {
                        allocate.flip();
                        i = allocate.getInt();
                    } else if (read != -1) {
                        zzaW().zze().zzb("Unexpected data length. Bytes read", Integer.valueOf(read));
                    }
                } catch (IOException e) {
                    zzaW().zzb().zzb("Failed to read from channel", e);
                }
            }
            int zzm = this.zzn.zzv().zzm();
            zzaX().zzg();
            if (i > zzm) {
                zzaW().zzb().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzm));
            } else if (i < zzm) {
                FileChannel fileChannel2 = this.zzy;
                zzaX().zzg();
                if (fileChannel2 == null || !fileChannel2.isOpen()) {
                    zzaW().zzb().zza("Bad channel to read from");
                } else {
                    ByteBuffer allocate2 = ByteBuffer.allocate(4);
                    allocate2.putInt(zzm);
                    allocate2.flip();
                    try {
                        fileChannel2.truncate(0L);
                        fileChannel2.write(allocate2);
                        fileChannel2.force(true);
                        if (fileChannel2.size() != 4) {
                            zzaW().zzb().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                        }
                        zzaW().zzk().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzm));
                        return;
                    } catch (IOException e2) {
                        zzaW().zzb().zzb("Failed to write to channel", e2);
                    }
                }
                zzaW().zzb().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzm));
            }
        }
    }

    final boolean zzab() {
        zzaX().zzg();
        FileLock fileLock = this.zzx;
        if (fileLock != null && fileLock.isValid()) {
            zzaW().zzk().zza("Storage concurrent access okay");
            return true;
        }
        this.zze.zzu.zzc();
        File filesDir = this.zzn.zzaZ().getFilesDir();
        com.google.android.gms.internal.measurement.zzby.zza();
        int i = com.google.android.gms.internal.measurement.zzcd.zza;
        try {
            FileChannel channel = new RandomAccessFile(new File(new File(filesDir, "google_app_measurement.db").getPath()), "rw").getChannel();
            this.zzy = channel;
            FileLock tryLock = channel.tryLock();
            this.zzx = tryLock;
            if (tryLock != null) {
                zzaW().zzk().zza("Storage concurrent access okay");
                return true;
            }
            zzaW().zzb().zza("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            zzaW().zzb().zzb("Failed to acquire storage lock", e);
            return false;
        } catch (IOException e2) {
            zzaW().zzb().zzb("Failed to access storage lock file", e2);
            return false;
        } catch (OverlappingFileLockException e3) {
            zzaW().zze().zzb("Storage lock already acquired", e3);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzac(zzr zzrVar) {
        if (this.zzz != null) {
            ArrayList arrayList = new ArrayList();
            this.zzA = arrayList;
            arrayList.addAll(this.zzz);
        }
        zzaw zzj = zzj();
        String str = (String) Preconditions.checkNotNull(zzrVar.zza);
        Preconditions.checkNotEmpty(str);
        zzj.zzg();
        zzj.zzay();
        try {
            SQLiteDatabase zze = zzj.zze();
            String[] strArr = {str};
            int delete = zze.delete("apps", "app_id=?", strArr) + zze.delete("events", "app_id=?", strArr) + zze.delete("events_snapshot", "app_id=?", strArr) + zze.delete("user_attributes", "app_id=?", strArr) + zze.delete("conditional_properties", "app_id=?", strArr) + zze.delete("raw_events", "app_id=?", strArr) + zze.delete("raw_events_metadata", "app_id=?", strArr) + zze.delete("queue", "app_id=?", strArr) + zze.delete("audience_filter_values", "app_id=?", strArr) + zze.delete("main_event_params", "app_id=?", strArr) + zze.delete("default_event_params", "app_id=?", strArr) + zze.delete("trigger_uris", "app_id=?", strArr) + zze.delete("upload_queue", "app_id=?", strArr);
            zzahh.zza();
            zzic zzicVar = zzj.zzu;
            if (zzicVar.zzc().zzp(null, zzfy.zzbc)) {
                delete += zze.delete("no_data_mode_events", "app_id=?", strArr);
            }
            int delete2 = delete + zze.delete("diagnostic_signals", "app_id=?", strArr);
            if (delete2 > 0) {
                zzicVar.zzaW().zzk().zzc("Reset analytics data. app, records", str, Integer.valueOf(delete2));
            }
        } catch (SQLiteException e) {
            zzj.zzu.zzaW().zzb().zzc("Error resetting analytics data. appId, error", zzgu.zzl(str), e);
        }
        if (zzrVar.zzh) {
            zzai(zzrVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzad(zzpl zzplVar, zzr zzrVar) {
        zzpn zzm;
        long j;
        zzaX().zzg();
        zzu();
        if (zzaS(zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            zzpp zzt = zzt();
            String str = zzplVar.zzb;
            int zzs = zzt.zzs(str);
            if (zzs != 0) {
                zzpp zzt2 = zzt();
                zzd();
                zzt().zzP(this.zzK, zzrVar.zza, zzs, "_ev", zzt2.zzE(str, 24, true), str != null ? str.length() : 0);
                return;
            }
            int zzM = zzt().zzM(str, zzplVar.zza());
            if (zzM != 0) {
                zzpp zzt3 = zzt();
                zzd();
                String zzE = zzt3.zzE(str, 24, true);
                Object zza = zzplVar.zza();
                if (zza != null && ((zza instanceof String) || (zza instanceof CharSequence))) {
                    r13 = zza.toString().length();
                }
                zzt().zzP(this.zzK, zzrVar.zza, zzM, "_ev", zzE, r13);
                return;
            }
            Object zzN = zzt().zzN(str, zzplVar.zza());
            if (zzN != null) {
                if ("_sid".equals(str)) {
                    long j2 = zzplVar.zzc;
                    String str2 = zzplVar.zzf;
                    String str3 = (String) Preconditions.checkNotNull(zzrVar.zza);
                    zzpn zzm2 = zzj().zzm(str3, "_sno");
                    if (zzm2 != null) {
                        Object obj = zzm2.zze;
                        if (obj instanceof Long) {
                            j = ((Long) obj).longValue();
                            zzad(new zzpl("_sno", j2, Long.valueOf(j + 1), str2), zzrVar);
                        }
                    }
                    if (zzm2 != null) {
                        zzaW().zze().zzb("Retrieved last session number from database does not contain a valid (long) value", zzm2.zze);
                    }
                    zzbd zzf = zzj().zzf(str3, "_s");
                    if (zzf != null) {
                        zzgs zzk = zzaW().zzk();
                        long j3 = zzf.zzc;
                        zzk.zzb("Backfill the session number. Last used session number", Long.valueOf(j3));
                        j = j3;
                    } else {
                        j = 0;
                    }
                    zzad(new zzpl("_sno", j2, Long.valueOf(j + 1), str2), zzrVar);
                }
                String str4 = zzrVar.zza;
                zzpn zzpnVar = new zzpn((String) Preconditions.checkNotNull(str4), (String) Preconditions.checkNotNull(zzplVar.zzf), str, zzplVar.zzc, zzN);
                zzgs zzk2 = zzaW().zzk();
                zzic zzicVar = this.zzn;
                String str5 = zzpnVar.zzc;
                zzk2.zzc("Setting user property", zzicVar.zzl().zzc(str5), zzN);
                zzj().zzb();
                try {
                    if (APEZProvider.FILEID.equals(str5) && (zzm = zzj().zzm(str4, APEZProvider.FILEID)) != null && !zzpnVar.zze.equals(zzm.zze)) {
                        zzj().zzk(str4, "_lair");
                    }
                    zzap(zzrVar);
                    boolean zzl = zzj().zzl(zzpnVar);
                    if ("_sid".equals(str)) {
                        long zzu = zzp().zzu(zzrVar.zzu);
                        zzh zzu2 = zzj().zzu(str4);
                        if (zzu2 != null) {
                            zzu2.zzan(zzu);
                            if (zzu2.zza()) {
                                zzj().zzv(zzu2, false, false);
                            }
                        }
                    }
                    zzj().zzc();
                    if (!zzl) {
                        zzaW().zzb().zzc("Too many unique user properties are set. Ignoring user property", zzicVar.zzl().zzc(str5), zzpnVar.zze);
                        zzt().zzP(this.zzK, str4, 9, null, null, 0);
                    }
                } finally {
                    zzj().zzd();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzae(String str, zzr zzrVar) {
        zzaX().zzg();
        zzu();
        if (zzaS(zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            Boolean zzaU = zzaU(zzrVar);
            if ("_npa".equals(str) && zzaU != null) {
                zzaW().zzj().zza("Falling back to manifest metadata value for ad personalization");
                zzad(new zzpl("_npa", zzba().currentTimeMillis(), Long.valueOf(true != zzaU.booleanValue() ? 0L : 1L), "auto"), zzrVar);
                return;
            }
            zzgs zzj = zzaW().zzj();
            zzic zzicVar = this.zzn;
            zzj.zzb("Removing user property", zzicVar.zzl().zzc(str));
            zzj().zzb();
            try {
                zzap(zzrVar);
                if (APEZProvider.FILEID.equals(str)) {
                    zzj().zzk((String) Preconditions.checkNotNull(zzrVar.zza), "_lair");
                }
                zzj().zzk((String) Preconditions.checkNotNull(zzrVar.zza), str);
                zzj().zzc();
                zzaW().zzj().zzb("User property removed", zzicVar.zzl().zzc(str));
            } finally {
                zzj().zzd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaf() {
        this.zzs++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzag() {
        this.zzt++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzic zzah() {
        return this.zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00eb, code lost:
        if (true == r14.booleanValue()) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ed, code lost:
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f0, code lost:
        r14 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f1, code lost:
        r18 = new com.google.android.gms.measurement.internal.zzpl("_npa", r20, java.lang.Long.valueOf(r14), "auto");
        r14 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00fe, code lost:
        if (r13 == null) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0108, code lost:
        if (r13.zze.equals(r18.zzd) != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x010a, code lost:
        zzad(r18, r35);
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02d6 A[Catch: all -> 0x0467, TRY_LEAVE, TryCatch #2 {all -> 0x0467, blocks: (B:31:0x00c1, B:33:0x00d3, B:50:0x0115, B:52:0x0122, B:54:0x012b, B:56:0x0130, B:59:0x0149, B:62:0x015e, B:64:0x0183, B:67:0x018b, B:69:0x019a, B:97:0x027f, B:99:0x02ab, B:100:0x02ae, B:102:0x02d6, B:142:0x03ae, B:143:0x03b1, B:151:0x0458, B:104:0x02eb, B:109:0x030e, B:111:0x0316, B:113:0x0320, B:117:0x0333, B:121:0x034a, B:125:0x0356, B:128:0x036a, B:131:0x037b, B:133:0x038f, B:135:0x0397, B:137:0x039f, B:139:0x03a5, B:119:0x0340, B:107:0x02fa, B:70:0x01ab, B:72:0x01d6, B:73:0x01e5, B:75:0x01ec, B:77:0x01f2, B:79:0x01fc, B:81:0x0206, B:83:0x020c, B:85:0x0212, B:86:0x0217, B:90:0x0235, B:93:0x023a, B:94:0x024e, B:95:0x025e, B:96:0x026e, B:144:0x03d7, B:146:0x040e, B:147:0x0411, B:148:0x0434, B:150:0x043a, B:57:0x013c, B:53:0x0128, B:38:0x00e3, B:42:0x00f1, B:44:0x0100, B:46:0x010a, B:49:0x0112), top: B:161:0x00c1, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03ae A[Catch: all -> 0x0467, TryCatch #2 {all -> 0x0467, blocks: (B:31:0x00c1, B:33:0x00d3, B:50:0x0115, B:52:0x0122, B:54:0x012b, B:56:0x0130, B:59:0x0149, B:62:0x015e, B:64:0x0183, B:67:0x018b, B:69:0x019a, B:97:0x027f, B:99:0x02ab, B:100:0x02ae, B:102:0x02d6, B:142:0x03ae, B:143:0x03b1, B:151:0x0458, B:104:0x02eb, B:109:0x030e, B:111:0x0316, B:113:0x0320, B:117:0x0333, B:121:0x034a, B:125:0x0356, B:128:0x036a, B:131:0x037b, B:133:0x038f, B:135:0x0397, B:137:0x039f, B:139:0x03a5, B:119:0x0340, B:107:0x02fa, B:70:0x01ab, B:72:0x01d6, B:73:0x01e5, B:75:0x01ec, B:77:0x01f2, B:79:0x01fc, B:81:0x0206, B:83:0x020c, B:85:0x0212, B:86:0x0217, B:90:0x0235, B:93:0x023a, B:94:0x024e, B:95:0x025e, B:96:0x026e, B:144:0x03d7, B:146:0x040e, B:147:0x0411, B:148:0x0434, B:150:0x043a, B:57:0x013c, B:53:0x0128, B:38:0x00e3, B:42:0x00f1, B:44:0x0100, B:46:0x010a, B:49:0x0112), top: B:161:0x00c1, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0434 A[Catch: all -> 0x0467, TryCatch #2 {all -> 0x0467, blocks: (B:31:0x00c1, B:33:0x00d3, B:50:0x0115, B:52:0x0122, B:54:0x012b, B:56:0x0130, B:59:0x0149, B:62:0x015e, B:64:0x0183, B:67:0x018b, B:69:0x019a, B:97:0x027f, B:99:0x02ab, B:100:0x02ae, B:102:0x02d6, B:142:0x03ae, B:143:0x03b1, B:151:0x0458, B:104:0x02eb, B:109:0x030e, B:111:0x0316, B:113:0x0320, B:117:0x0333, B:121:0x034a, B:125:0x0356, B:128:0x036a, B:131:0x037b, B:133:0x038f, B:135:0x0397, B:137:0x039f, B:139:0x03a5, B:119:0x0340, B:107:0x02fa, B:70:0x01ab, B:72:0x01d6, B:73:0x01e5, B:75:0x01ec, B:77:0x01f2, B:79:0x01fc, B:81:0x0206, B:83:0x020c, B:85:0x0212, B:86:0x0217, B:90:0x0235, B:93:0x023a, B:94:0x024e, B:95:0x025e, B:96:0x026e, B:144:0x03d7, B:146:0x040e, B:147:0x0411, B:148:0x0434, B:150:0x043a, B:57:0x013c, B:53:0x0128, B:38:0x00e3, B:42:0x00f1, B:44:0x0100, B:46:0x010a, B:49:0x0112), top: B:161:0x00c1, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0122 A[Catch: all -> 0x0467, TryCatch #2 {all -> 0x0467, blocks: (B:31:0x00c1, B:33:0x00d3, B:50:0x0115, B:52:0x0122, B:54:0x012b, B:56:0x0130, B:59:0x0149, B:62:0x015e, B:64:0x0183, B:67:0x018b, B:69:0x019a, B:97:0x027f, B:99:0x02ab, B:100:0x02ae, B:102:0x02d6, B:142:0x03ae, B:143:0x03b1, B:151:0x0458, B:104:0x02eb, B:109:0x030e, B:111:0x0316, B:113:0x0320, B:117:0x0333, B:121:0x034a, B:125:0x0356, B:128:0x036a, B:131:0x037b, B:133:0x038f, B:135:0x0397, B:137:0x039f, B:139:0x03a5, B:119:0x0340, B:107:0x02fa, B:70:0x01ab, B:72:0x01d6, B:73:0x01e5, B:75:0x01ec, B:77:0x01f2, B:79:0x01fc, B:81:0x0206, B:83:0x020c, B:85:0x0212, B:86:0x0217, B:90:0x0235, B:93:0x023a, B:94:0x024e, B:95:0x025e, B:96:0x026e, B:144:0x03d7, B:146:0x040e, B:147:0x0411, B:148:0x0434, B:150:0x043a, B:57:0x013c, B:53:0x0128, B:38:0x00e3, B:42:0x00f1, B:44:0x0100, B:46:0x010a, B:49:0x0112), top: B:161:0x00c1, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0128 A[Catch: all -> 0x0467, TryCatch #2 {all -> 0x0467, blocks: (B:31:0x00c1, B:33:0x00d3, B:50:0x0115, B:52:0x0122, B:54:0x012b, B:56:0x0130, B:59:0x0149, B:62:0x015e, B:64:0x0183, B:67:0x018b, B:69:0x019a, B:97:0x027f, B:99:0x02ab, B:100:0x02ae, B:102:0x02d6, B:142:0x03ae, B:143:0x03b1, B:151:0x0458, B:104:0x02eb, B:109:0x030e, B:111:0x0316, B:113:0x0320, B:117:0x0333, B:121:0x034a, B:125:0x0356, B:128:0x036a, B:131:0x037b, B:133:0x038f, B:135:0x0397, B:137:0x039f, B:139:0x03a5, B:119:0x0340, B:107:0x02fa, B:70:0x01ab, B:72:0x01d6, B:73:0x01e5, B:75:0x01ec, B:77:0x01f2, B:79:0x01fc, B:81:0x0206, B:83:0x020c, B:85:0x0212, B:86:0x0217, B:90:0x0235, B:93:0x023a, B:94:0x024e, B:95:0x025e, B:96:0x026e, B:144:0x03d7, B:146:0x040e, B:147:0x0411, B:148:0x0434, B:150:0x043a, B:57:0x013c, B:53:0x0128, B:38:0x00e3, B:42:0x00f1, B:44:0x0100, B:46:0x010a, B:49:0x0112), top: B:161:0x00c1, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0130 A[Catch: all -> 0x0467, TryCatch #2 {all -> 0x0467, blocks: (B:31:0x00c1, B:33:0x00d3, B:50:0x0115, B:52:0x0122, B:54:0x012b, B:56:0x0130, B:59:0x0149, B:62:0x015e, B:64:0x0183, B:67:0x018b, B:69:0x019a, B:97:0x027f, B:99:0x02ab, B:100:0x02ae, B:102:0x02d6, B:142:0x03ae, B:143:0x03b1, B:151:0x0458, B:104:0x02eb, B:109:0x030e, B:111:0x0316, B:113:0x0320, B:117:0x0333, B:121:0x034a, B:125:0x0356, B:128:0x036a, B:131:0x037b, B:133:0x038f, B:135:0x0397, B:137:0x039f, B:139:0x03a5, B:119:0x0340, B:107:0x02fa, B:70:0x01ab, B:72:0x01d6, B:73:0x01e5, B:75:0x01ec, B:77:0x01f2, B:79:0x01fc, B:81:0x0206, B:83:0x020c, B:85:0x0212, B:86:0x0217, B:90:0x0235, B:93:0x023a, B:94:0x024e, B:95:0x025e, B:96:0x026e, B:144:0x03d7, B:146:0x040e, B:147:0x0411, B:148:0x0434, B:150:0x043a, B:57:0x013c, B:53:0x0128, B:38:0x00e3, B:42:0x00f1, B:44:0x0100, B:46:0x010a, B:49:0x0112), top: B:161:0x00c1, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013c A[Catch: all -> 0x0467, TryCatch #2 {all -> 0x0467, blocks: (B:31:0x00c1, B:33:0x00d3, B:50:0x0115, B:52:0x0122, B:54:0x012b, B:56:0x0130, B:59:0x0149, B:62:0x015e, B:64:0x0183, B:67:0x018b, B:69:0x019a, B:97:0x027f, B:99:0x02ab, B:100:0x02ae, B:102:0x02d6, B:142:0x03ae, B:143:0x03b1, B:151:0x0458, B:104:0x02eb, B:109:0x030e, B:111:0x0316, B:113:0x0320, B:117:0x0333, B:121:0x034a, B:125:0x0356, B:128:0x036a, B:131:0x037b, B:133:0x038f, B:135:0x0397, B:137:0x039f, B:139:0x03a5, B:119:0x0340, B:107:0x02fa, B:70:0x01ab, B:72:0x01d6, B:73:0x01e5, B:75:0x01ec, B:77:0x01f2, B:79:0x01fc, B:81:0x0206, B:83:0x020c, B:85:0x0212, B:86:0x0217, B:90:0x0235, B:93:0x023a, B:94:0x024e, B:95:0x025e, B:96:0x026e, B:144:0x03d7, B:146:0x040e, B:147:0x0411, B:148:0x0434, B:150:0x043a, B:57:0x013c, B:53:0x0128, B:38:0x00e3, B:42:0x00f1, B:44:0x0100, B:46:0x010a, B:49:0x0112), top: B:161:0x00c1, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0149 A[Catch: all -> 0x0467, TRY_LEAVE, TryCatch #2 {all -> 0x0467, blocks: (B:31:0x00c1, B:33:0x00d3, B:50:0x0115, B:52:0x0122, B:54:0x012b, B:56:0x0130, B:59:0x0149, B:62:0x015e, B:64:0x0183, B:67:0x018b, B:69:0x019a, B:97:0x027f, B:99:0x02ab, B:100:0x02ae, B:102:0x02d6, B:142:0x03ae, B:143:0x03b1, B:151:0x0458, B:104:0x02eb, B:109:0x030e, B:111:0x0316, B:113:0x0320, B:117:0x0333, B:121:0x034a, B:125:0x0356, B:128:0x036a, B:131:0x037b, B:133:0x038f, B:135:0x0397, B:137:0x039f, B:139:0x03a5, B:119:0x0340, B:107:0x02fa, B:70:0x01ab, B:72:0x01d6, B:73:0x01e5, B:75:0x01ec, B:77:0x01f2, B:79:0x01fc, B:81:0x0206, B:83:0x020c, B:85:0x0212, B:86:0x0217, B:90:0x0235, B:93:0x023a, B:94:0x024e, B:95:0x025e, B:96:0x026e, B:144:0x03d7, B:146:0x040e, B:147:0x0411, B:148:0x0434, B:150:0x043a, B:57:0x013c, B:53:0x0128, B:38:0x00e3, B:42:0x00f1, B:44:0x0100, B:46:0x010a, B:49:0x0112), top: B:161:0x00c1, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02ab A[Catch: all -> 0x0467, TryCatch #2 {all -> 0x0467, blocks: (B:31:0x00c1, B:33:0x00d3, B:50:0x0115, B:52:0x0122, B:54:0x012b, B:56:0x0130, B:59:0x0149, B:62:0x015e, B:64:0x0183, B:67:0x018b, B:69:0x019a, B:97:0x027f, B:99:0x02ab, B:100:0x02ae, B:102:0x02d6, B:142:0x03ae, B:143:0x03b1, B:151:0x0458, B:104:0x02eb, B:109:0x030e, B:111:0x0316, B:113:0x0320, B:117:0x0333, B:121:0x034a, B:125:0x0356, B:128:0x036a, B:131:0x037b, B:133:0x038f, B:135:0x0397, B:137:0x039f, B:139:0x03a5, B:119:0x0340, B:107:0x02fa, B:70:0x01ab, B:72:0x01d6, B:73:0x01e5, B:75:0x01ec, B:77:0x01f2, B:79:0x01fc, B:81:0x0206, B:83:0x020c, B:85:0x0212, B:86:0x0217, B:90:0x0235, B:93:0x023a, B:94:0x024e, B:95:0x025e, B:96:0x026e, B:144:0x03d7, B:146:0x040e, B:147:0x0411, B:148:0x0434, B:150:0x043a, B:57:0x013c, B:53:0x0128, B:38:0x00e3, B:42:0x00f1, B:44:0x0100, B:46:0x010a, B:49:0x0112), top: B:161:0x00c1, inners: #0, #1, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzai(zzr zzrVar) {
        long j;
        zzbd zzf;
        boolean z;
        String str;
        long zzN;
        zzic zzicVar;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        ApplicationInfo applicationInfo2;
        long j2;
        boolean z2;
        zzaX().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        if (zzaS(zzrVar)) {
            zzh zzu = zzj().zzu(str2);
            if (zzu != null && TextUtils.isEmpty(zzu.zzf()) && !TextUtils.isEmpty(zzrVar.zzb)) {
                zzu.zzI(0L);
                zzj().zzv(zzu, false, false);
                zzh().zzh(str2);
            }
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            long j3 = zzrVar.zzl;
            zzal zzd = zzd();
            zzfx zzfxVar = zzfy.zzbe;
            long j4 = zzd.zzp(null, zzfxVar) ? zzrVar.zzF : 0L;
            if (j3 == 0) {
                j3 = zzba().currentTimeMillis();
                j4 = zzd().zzp(null, zzfxVar) ? zzba().elapsedRealtime() : 0L;
            }
            long j5 = j4;
            long j6 = j3;
            int i = zzrVar.zzm;
            if (i != 0 && i != 1) {
                zzaW().zze().zzc("Incorrect app type, assuming installed app. appId, appType", zzgu.zzl(str2), Integer.valueOf(i));
                i = 0;
            }
            zzj().zzb();
            try {
                zzpn zzm = zzj().zzm(str2, "_npa");
                Boolean zzaU = zzaU(zzrVar);
                int i2 = i;
                if (zzm != null && !"auto".equals(zzm.zzb)) {
                    j = j6;
                    if (!zzd().zzp(null, zzfy.zzaW)) {
                        zzao(zzrVar, zzrVar.zzD);
                    } else {
                        zzao(zzrVar, j);
                    }
                    zzap(zzrVar);
                    if (i2 == 0) {
                        zzf = zzj().zzf(str2, "_v");
                        z = true;
                    } else {
                        zzf = zzj().zzf(str2, "_f");
                        z = false;
                    }
                    if (zzf != null) {
                        long j7 = ((j / DurationKt.MILLIS_IN_HOUR) + 1) * DurationKt.MILLIS_IN_HOUR;
                        if (z) {
                            long j8 = j;
                            zzad(new zzpl("_fvt", j8, Long.valueOf(j7), "auto"), zzrVar);
                            zzaX().zzg();
                            zzu();
                            Bundle bundle = new Bundle();
                            bundle.putLong("_c", 1L);
                            bundle.putLong("_r", 1L);
                            bundle.putLong("_et", 1L);
                            if (zzrVar.zzo) {
                                bundle.putLong("_dac", 1L);
                            }
                            bundle.putLong("_elt", zzba().currentTimeMillis());
                            zzE(new zzbh("_v", new zzbf(bundle), "auto", j8, j5), zzrVar);
                        } else {
                            Long valueOf = Long.valueOf(j7);
                            long j9 = j;
                            zzad(new zzpl("_fot", j9, valueOf, "auto"), zzrVar);
                            zzaX().zzg();
                            zzhk zzhkVar = (zzhk) Preconditions.checkNotNull(this.zzm);
                            if (str2 != null && !str2.isEmpty()) {
                                zzic zzicVar2 = zzhkVar.zza;
                                zzicVar2.zzaX().zzg();
                                if (!zzhkVar.zza()) {
                                    zzicVar2.zzaW().zzi().zza("Install Referrer Reporter is not available");
                                    str = "_elt";
                                } else {
                                    zzhj zzhjVar = new zzhj(zzhkVar, str2);
                                    zzicVar2.zzaX().zzg();
                                    Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                                    str = "_elt";
                                    intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                                    PackageManager packageManager = zzicVar2.zzaZ().getPackageManager();
                                    if (packageManager == null) {
                                        zzicVar2.zzaW().zzf().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                                    } else {
                                        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
                                        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                                            ResolveInfo resolveInfo = queryIntentServices.get(0);
                                            if (resolveInfo.serviceInfo != null) {
                                                String str3 = resolveInfo.serviceInfo.packageName;
                                                if (resolveInfo.serviceInfo.name != null && "com.android.vending".equals(str3) && zzhkVar.zza()) {
                                                    try {
                                                        zzicVar2.zzaW().zzk().zzb("Install Referrer Service is", ConnectionTracker.getInstance().bindService(zzicVar2.zzaZ(), new Intent(intent), zzhjVar, 1) ? "available" : "not available");
                                                    } catch (RuntimeException e) {
                                                        zzhkVar.zza.zzaW().zzb().zzb("Exception occurred while binding to Install Referrer Service", e.getMessage());
                                                    }
                                                } else {
                                                    zzhkVar.zza.zzaW().zze().zza("Play Store version 8.3.73 or higher required for Install Referrer");
                                                }
                                            }
                                        } else {
                                            zzhkVar.zza.zzaW().zzi().zza("Play Service for fetching Install Referrer is unavailable on device");
                                        }
                                    }
                                }
                                zzaX().zzg();
                                zzu();
                                Bundle bundle2 = new Bundle();
                                bundle2.putLong("_c", 1L);
                                bundle2.putLong("_r", 1L);
                                bundle2.putLong("_uwa", 0L);
                                bundle2.putLong("_pfo", 0L);
                                bundle2.putLong("_sys", 0L);
                                bundle2.putLong("_sysu", 0L);
                                bundle2.putLong("_et", 1L);
                                if (zzrVar.zzo) {
                                    bundle2.putLong("_dac", 1L);
                                }
                                String str4 = (String) Preconditions.checkNotNull(zzrVar.zza);
                                zzaw zzj = zzj();
                                Preconditions.checkNotEmpty(str4);
                                zzj.zzg();
                                zzj.zzay();
                                zzN = zzj.zzN(str4, "first_open_count");
                                zzicVar = this.zzn;
                                if (zzicVar.zzaZ().getPackageManager() == null) {
                                    try {
                                        packageInfo = Wrappers.packageManager(zzicVar.zzaZ()).getPackageInfo(str4, 0);
                                    } catch (PackageManager.NameNotFoundException e2) {
                                        zzaW().zzb().zzc("Package info is null, first open report might be inaccurate. appId", zzgu.zzl(str4), e2);
                                        packageInfo = null;
                                    }
                                    if (packageInfo == null || packageInfo.firstInstallTime == 0) {
                                        applicationInfo = null;
                                        zzN = zzN;
                                    } else {
                                        if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                            applicationInfo = null;
                                            if (!zzd().zzp(null, zzfy.zzaI)) {
                                                bundle2.putLong("_uwa", 1L);
                                            } else if (zzN == 0) {
                                                bundle2.putLong("_uwa", 1L);
                                                z2 = false;
                                                zzN = 0;
                                            }
                                            zzN = zzN;
                                            z2 = false;
                                        } else {
                                            applicationInfo = null;
                                            zzN = zzN;
                                            z2 = true;
                                        }
                                        zzad(new zzpl("_fi", j9, Long.valueOf(true != z2 ? 0L : 1L), "auto"), zzrVar);
                                    }
                                    try {
                                        applicationInfo2 = Wrappers.packageManager(this.zzn.zzaZ()).getApplicationInfo(str4, 0);
                                    } catch (PackageManager.NameNotFoundException e3) {
                                        zzaW().zzb().zzc("Application info is null, first open report might be inaccurate. appId", zzgu.zzl(str4), e3);
                                        applicationInfo2 = applicationInfo;
                                    }
                                    if (applicationInfo2 != null) {
                                        if ((applicationInfo2.flags & 1) != 0) {
                                            j2 = 1;
                                            bundle2.putLong("_sys", 1L);
                                        } else {
                                            j2 = 1;
                                        }
                                        if ((applicationInfo2.flags & 128) != 0) {
                                            bundle2.putLong("_sysu", j2);
                                        }
                                    }
                                } else {
                                    zzaW().zzb().zzb("PackageManager is null, first open report might be inaccurate. appId", zzgu.zzl(str4));
                                }
                                if (zzN >= 0) {
                                    bundle2.putLong("_pfo", zzN);
                                }
                                bundle2.putLong(str, zzba().currentTimeMillis());
                                zzE(new zzbh("_f", new zzbf(bundle2), "auto", j9, j5), zzrVar);
                            }
                            str = "_elt";
                            zzhkVar.zza.zzaW().zzf().zza("Install Referrer Reporter was called with invalid app package name");
                            zzaX().zzg();
                            zzu();
                            Bundle bundle22 = new Bundle();
                            bundle22.putLong("_c", 1L);
                            bundle22.putLong("_r", 1L);
                            bundle22.putLong("_uwa", 0L);
                            bundle22.putLong("_pfo", 0L);
                            bundle22.putLong("_sys", 0L);
                            bundle22.putLong("_sysu", 0L);
                            bundle22.putLong("_et", 1L);
                            if (zzrVar.zzo) {
                            }
                            String str42 = (String) Preconditions.checkNotNull(zzrVar.zza);
                            zzaw zzj2 = zzj();
                            Preconditions.checkNotEmpty(str42);
                            zzj2.zzg();
                            zzj2.zzay();
                            zzN = zzj2.zzN(str42, "first_open_count");
                            zzicVar = this.zzn;
                            if (zzicVar.zzaZ().getPackageManager() == null) {
                            }
                            if (zzN >= 0) {
                            }
                            bundle22.putLong(str, zzba().currentTimeMillis());
                            zzE(new zzbh("_f", new zzbf(bundle22), "auto", j9, j5), zzrVar);
                        }
                    } else {
                        long j10 = j;
                        if (zzrVar.zzi) {
                            zzE(new zzbh("_cd", new zzbf(new Bundle()), "auto", j10, 0L), zzrVar);
                        }
                    }
                    zzj().zzc();
                }
                j = j6;
                if (zzm != null) {
                    zzae("_npa", zzrVar);
                }
                if (!zzd().zzp(null, zzfy.zzaW)) {
                }
                zzap(zzrVar);
                if (i2 == 0) {
                }
                if (zzf != null) {
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaj(zzr zzrVar) {
        zzaX().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        int i = 0;
        if (zzd().zzp(null, zzfy.zzay)) {
            long currentTimeMillis = zzba().currentTimeMillis();
            int zzm = zzd().zzm(null, zzfy.zzah);
            zzd();
            long zzF = currentTimeMillis - zzal.zzF();
            while (i < zzm && zzaH(null, zzF)) {
                i++;
            }
        } else {
            zzd();
            long zzH = zzal.zzH();
            while (i < zzH && zzaH(str, 0L)) {
                i++;
            }
        }
        if (zzd().zzp(null, zzfy.zzaz)) {
            zzaX().zzg();
            zzaw();
        }
        if (this.zzl.zzc(str, com.google.android.gms.internal.measurement.zzin.zzb(zzrVar.zzE))) {
            zzaW().zzk().zzb("[sgtm] Going background, trigger client side upload. appId", str);
            zzN(str, zzba().currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzak(zzah zzahVar) {
        zzr zzaP = zzaP((String) Preconditions.checkNotNull(zzahVar.zza));
        if (zzaP != null) {
            zzal(zzahVar, zzaP);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzal(zzah zzahVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzahVar);
        Preconditions.checkNotEmpty(zzahVar.zza);
        Preconditions.checkNotNull(zzahVar.zzb);
        Preconditions.checkNotNull(zzahVar.zzc);
        Preconditions.checkNotEmpty(zzahVar.zzc.zzb);
        zzaX().zzg();
        zzu();
        if (zzaS(zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            zzah zzahVar2 = new zzah(zzahVar);
            boolean z = false;
            zzahVar2.zze = false;
            zzj().zzb();
            try {
                zzah zzq = zzj().zzq((String) Preconditions.checkNotNull(zzahVar2.zza), zzahVar2.zzc.zzb);
                if (zzq != null && !zzq.zzb.equals(zzahVar2.zzb)) {
                    zzaW().zze().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzb, zzq.zzb);
                }
                if (zzq == null || !zzq.zze) {
                    if (TextUtils.isEmpty(zzahVar2.zzf)) {
                        zzpl zzplVar = zzahVar2.zzc;
                        zzahVar2.zzc = new zzpl(zzplVar.zzb, zzahVar2.zzd, zzplVar.zza(), zzahVar2.zzc.zzf);
                        zzahVar2.zze = true;
                        z = true;
                    }
                } else {
                    zzahVar2.zzb = zzq.zzb;
                    zzahVar2.zzd = zzq.zzd;
                    zzahVar2.zzh = zzq.zzh;
                    zzahVar2.zzf = zzq.zzf;
                    zzahVar2.zzi = zzq.zzi;
                    zzahVar2.zze = true;
                    zzpl zzplVar2 = zzahVar2.zzc;
                    zzahVar2.zzc = new zzpl(zzplVar2.zzb, zzq.zzc.zzc, zzplVar2.zza(), zzq.zzc.zzf);
                }
                if (zzahVar2.zze) {
                    zzpl zzplVar3 = zzahVar2.zzc;
                    zzpn zzpnVar = new zzpn((String) Preconditions.checkNotNull(zzahVar2.zza), zzahVar2.zzb, zzplVar3.zzb, zzplVar3.zzc, Preconditions.checkNotNull(zzplVar3.zza()));
                    if (zzj().zzl(zzpnVar)) {
                        zzaW().zzj().zzd("User property updated immediately", zzahVar2.zza, this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                    } else {
                        zzaW().zzb().zzd("(2)Too many active user properties, ignoring", zzgu.zzl(zzahVar2.zza), this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                    }
                    if (z && zzahVar2.zzi != null) {
                        zzH(new zzbh(zzahVar2.zzi, zzahVar2.zzd, 0L), zzrVar);
                    }
                }
                if (zzj().zzp(zzahVar2)) {
                    zzaW().zzj().zzd("Conditional property added", zzahVar2.zza, this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                } else {
                    zzaW().zzb().zzd("Too many conditional properties, ignoring", zzgu.zzl(zzahVar2.zza), this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzam(zzah zzahVar) {
        zzr zzaP = zzaP((String) Preconditions.checkNotNull(zzahVar.zza));
        if (zzaP != null) {
            zzan(zzahVar, zzaP);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzan(zzah zzahVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzahVar);
        Preconditions.checkNotEmpty(zzahVar.zza);
        Preconditions.checkNotNull(zzahVar.zzc);
        Preconditions.checkNotEmpty(zzahVar.zzc.zzb);
        zzaX().zzg();
        zzu();
        if (zzaS(zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            zzj().zzb();
            try {
                zzap(zzrVar);
                String str = (String) Preconditions.checkNotNull(zzahVar.zza);
                zzah zzq = zzj().zzq(str, zzahVar.zzc.zzb);
                if (zzq != null) {
                    zzaW().zzj().zzc("Removing conditional user property", zzahVar.zza, this.zzn.zzl().zzc(zzahVar.zzc.zzb));
                    zzj().zzr(str, zzahVar.zzc.zzb);
                    if (zzq.zze) {
                        zzj().zzk(str, zzahVar.zzc.zzb);
                    }
                    zzbh zzbhVar = zzahVar.zzk;
                    if (zzbhVar != null) {
                        zzbf zzbfVar = zzbhVar.zzb;
                        zzH((zzbh) Preconditions.checkNotNull(zzt().zzaf(str, ((zzbh) Preconditions.checkNotNull(zzbhVar)).zza, zzbfVar != null ? zzbfVar.zzf() : null, zzq.zzb, zzbhVar.zzd, zzbhVar.zze, true, true)), zzrVar);
                    }
                } else {
                    zzaW().zze().zzc("Conditional user property doesn't exist", zzgu.zzl(zzahVar.zza), this.zzn.zzl().zzc(zzahVar.zzc.zzb));
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    final void zzao(zzr zzrVar, long j) {
        zzh zzu = zzj().zzu((String) Preconditions.checkNotNull(zzrVar.zza));
        boolean z = true;
        if (zzu != null && zzt().zzD(zzrVar.zzb, zzu.zzf())) {
            zzaW().zze().zzb("New GMP App Id passed in. Removing cached database data. appId", zzgu.zzl(zzu.zzc()));
            zzaw zzj = zzj();
            String zzc = zzu.zzc();
            zzj.zzay();
            zzj.zzg();
            Preconditions.checkNotEmpty(zzc);
            try {
                SQLiteDatabase zze = zzj.zze();
                String[] strArr = {zzc};
                int delete = zze.delete("events", "app_id=?", strArr) + zze.delete("user_attributes", "app_id=?", strArr) + zze.delete("conditional_properties", "app_id=?", strArr) + zze.delete("apps", "app_id=?", strArr) + zze.delete("raw_events", "app_id=?", strArr) + zze.delete("raw_events_metadata", "app_id=?", strArr) + zze.delete("event_filters", "app_id=?", strArr) + zze.delete("property_filters", "app_id=?", strArr) + zze.delete("audience_filter_values", "app_id=?", strArr) + zze.delete("consent_settings", "app_id=?", strArr) + zze.delete("default_event_params", "app_id=?", strArr) + zze.delete("trigger_uris", "app_id=?", strArr) + zze.delete("diagnostic_signals", "app_id=?", strArr);
                zzahh.zza();
                zzic zzicVar = zzj.zzu;
                if (zzicVar.zzc().zzp(null, zzfy.zzbc)) {
                    delete += zze.delete("no_data_mode_events", "app_id=?", strArr);
                }
                if (delete > 0) {
                    zzicVar.zzaW().zzk().zzc("Deleted application data. app, records", zzc, Integer.valueOf(delete));
                }
            } catch (SQLiteException e) {
                zzj.zzu.zzaW().zzb().zzc("Error deleting application data. appId, error", zzgu.zzl(zzc), e);
            }
            zzu = null;
        }
        if (zzu != null) {
            boolean z2 = (zzu.zzt() == SieveCacheKt.NodeMetaAndPreviousMask || zzu.zzt() == zzrVar.zzj) ? false : true;
            String zzr = zzu.zzr();
            if (zzu.zzt() != SieveCacheKt.NodeMetaAndPreviousMask || zzr == null || zzr.equals(zzrVar.zzc)) {
                z = false;
            }
            if (z2 || z) {
                Bundle bundle = new Bundle();
                bundle.putString("_pv", zzr);
                zzbh zzbhVar = new zzbh("_au", new zzbf(bundle), "auto", j, 0L);
                if (zzd().zzp(null, zzfy.zzaX)) {
                    zzE(zzbhVar, zzrVar);
                } else {
                    zzF(zzbhVar, zzrVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzh zzap(zzr zzrVar) {
        boolean z;
        String str;
        long j;
        String str2;
        String str3;
        String str4;
        zzaX().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str5 = zzrVar.zza;
        Preconditions.checkNotEmpty(str5);
        String str6 = zzrVar.zzt;
        if (!str6.isEmpty()) {
            this.zzE.put(str5, new zzpd(this, str6, null));
        }
        zzh zzu = zzj().zzu(str5);
        zzjl zzs = zzB(str5).zzs(zzjl.zzf(zzrVar.zzs, 100));
        String zzf = this.zzk.zzf(zzrVar, zzs);
        boolean z2 = true;
        if (zzu == null) {
            zzh zzhVar = new zzh(this.zzn, str5);
            if (zzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                zzhVar.zze(zzK(zzs));
            }
            if (zzs.zzo(zzjk.AD_STORAGE)) {
                zzhVar.zzk(zzf);
            }
            zzu = zzhVar;
        } else if (zzs.zzo(zzjk.AD_STORAGE) && zzf != null && !zzf.equals(zzu.zzj())) {
            boolean isEmpty = TextUtils.isEmpty(zzu.zzj());
            zzu.zzk(zzf);
            if (zzrVar.zzn && !"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzc(zzrVar, zzs).first) && !isEmpty) {
                if (zzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                    zzu.zze(zzK(zzs));
                    z = false;
                } else {
                    z = true;
                }
                if (zzj().zzm(str5, APEZProvider.FILEID) != null && zzj().zzm(str5, "_lair") == null) {
                    zzj().zzl(new zzpn(str5, "auto", "_lair", zzba().currentTimeMillis(), 1L));
                }
                zzu.zzg(zzrVar.zzb);
                str = zzrVar.zzk;
                if (!TextUtils.isEmpty(str)) {
                    zzu.zzm(str);
                }
                j = zzrVar.zze;
                if (j != 0) {
                    zzu.zzy(j);
                }
                str2 = zzrVar.zzc;
                if (!TextUtils.isEmpty(str2)) {
                    zzu.zzs(str2);
                }
                zzu.zzu(zzrVar.zzj);
                str3 = zzrVar.zzd;
                if (str3 != null) {
                    zzu.zzw(str3);
                }
                zzu.zzA(zzrVar.zzf);
                zzu.zzE(zzrVar.zzh);
                str4 = zzrVar.zzg;
                if (!TextUtils.isEmpty(str4)) {
                    zzu.zzab(str4);
                }
                zzu.zzad(zzrVar.zzn);
                zzu.zzaf(zzrVar.zzp);
                zzu.zzC(zzrVar.zzq);
                zzu.zzi(zzrVar.zzu);
                zzahk.zza();
                if (!zzd().zzp(null, zzfy.zzaL)) {
                    zzu.zzah(zzrVar.zzr);
                } else {
                    zzahk.zza();
                    if (zzd().zzp(null, zzfy.zzaK)) {
                        zzu.zzah(null);
                    }
                }
                zzu.zzaj(zzrVar.zzv);
                zzu.zzaz(zzrVar.zzB);
                zzaif.zza();
                if (zzd().zzp(null, zzfy.zzaO)) {
                    zzu.zzap(zzrVar.zzz);
                }
                zzu.zzal(zzrVar.zzw);
                zzu.zzaG(zzrVar.zzC);
                zzu.zzaK(zzrVar.zzE);
                if (!zzu.zza()) {
                    z2 = z;
                } else if (!z) {
                    return zzu;
                }
                zzj().zzv(zzu, z2, false);
                return zzu;
            } else if (TextUtils.isEmpty(zzu.zzd()) && zzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                zzu.zze(zzK(zzs));
            }
        } else if (TextUtils.isEmpty(zzu.zzd()) && zzs.zzo(zzjk.ANALYTICS_STORAGE)) {
            zzu.zze(zzK(zzs));
        }
        z = false;
        zzu.zzg(zzrVar.zzb);
        str = zzrVar.zzk;
        if (!TextUtils.isEmpty(str)) {
        }
        j = zzrVar.zze;
        if (j != 0) {
        }
        str2 = zzrVar.zzc;
        if (!TextUtils.isEmpty(str2)) {
        }
        zzu.zzu(zzrVar.zzj);
        str3 = zzrVar.zzd;
        if (str3 != null) {
        }
        zzu.zzA(zzrVar.zzf);
        zzu.zzE(zzrVar.zzh);
        str4 = zzrVar.zzg;
        if (!TextUtils.isEmpty(str4)) {
        }
        zzu.zzad(zzrVar.zzn);
        zzu.zzaf(zzrVar.zzp);
        zzu.zzC(zzrVar.zzq);
        zzu.zzi(zzrVar.zzu);
        zzahk.zza();
        if (!zzd().zzp(null, zzfy.zzaL)) {
        }
        zzu.zzaj(zzrVar.zzv);
        zzu.zzaz(zzrVar.zzB);
        zzaif.zza();
        if (zzd().zzp(null, zzfy.zzaO)) {
        }
        zzu.zzal(zzrVar.zzw);
        zzu.zzaG(zzrVar.zzC);
        zzu.zzaK(zzrVar.zzE);
        if (!zzu.zza()) {
        }
        zzj().zzv(zzu, z2, false);
        return zzu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzaq(zzr zzrVar) {
        try {
            return (String) zzaX().zzh(new zzoz(this, zzrVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzaW().zzb().zzc("Failed to get app instance id. appId", zzgu.zzl(zzrVar.zza), e);
            return null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:28:0x00a8
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    final java.util.List zzar(com.google.android.gms.measurement.internal.zzr r21, android.os.Bundle r22) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzar(com.google.android.gms.measurement.internal.zzr, android.os.Bundle):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzas(String str, zzaf zzafVar) {
        zzaX().zzg();
        zzu();
        zzaw zzj = zzj();
        long j = zzafVar.zza;
        zzpj zzB = zzj.zzB(j);
        if (zzB == null) {
            zzaW().zze().zzc("[sgtm] Queued batch doesn't exist. appId, rowId", str, Long.valueOf(j));
            return;
        }
        String zze = zzB.zze();
        if (zzafVar.zzb == zzlr.SUCCESS.zza()) {
            Map map = this.zzF;
            if (map.containsKey(zze)) {
                map.remove(zze);
            }
            zzaw zzj2 = zzj();
            Long valueOf = Long.valueOf(j);
            zzj2.zzE(valueOf);
            zzaW().zzk().zzc("[sgtm] queued batch deleted after successful client upload. appId, rowId", str, valueOf);
            long j2 = zzafVar.zzc;
            if (j2 > 0) {
                zzaw zzj3 = zzj();
                zzj3.zzg();
                zzj3.zzay();
                Long valueOf2 = Long.valueOf(j2);
                Preconditions.checkNotNull(valueOf2);
                ContentValues contentValues = new ContentValues();
                contentValues.put("upload_type", Integer.valueOf(zzls.GOOGLE_SIGNAL.zza()));
                zzic zzicVar = zzj3.zzu;
                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzicVar.zzba().currentTimeMillis()));
                try {
                    if (zzj3.zze().update("upload_queue", contentValues, "rowid=? AND app_id=? AND upload_type=?", new String[]{String.valueOf(j2), str, String.valueOf(zzls.GOOGLE_SIGNAL_PENDING.zza())}) != 1) {
                        zzicVar.zzaW().zze().zzc("Google Signal pending batch not updated. appId, rowId", str, valueOf2);
                    }
                    zzaW().zzk().zzc("[sgtm] queued Google Signal batch updated. appId, signalRowId", str, Long.valueOf(zzafVar.zzc));
                    zzP(str);
                    return;
                } catch (SQLiteException e) {
                    zzj3.zzu.zzaW().zzb().zzd("Failed to update google Signal pending batch. appid, rowId", str, Long.valueOf(j2), e);
                    throw e;
                }
            }
            return;
        }
        if (zzafVar.zzb == zzlr.BACKOFF.zza()) {
            Map map2 = this.zzF;
            zzpe zzpeVar = (zzpe) map2.get(zze);
            if (zzpeVar == null) {
                zzpeVar = new zzpe(this);
                map2.put(zze, zzpeVar);
            } else {
                zzpeVar.zza();
            }
            zzaW().zzk().zzd("[sgtm] Putting sGTM server in backoff mode. appId, destination, nextRetryInSeconds", str, zze, Long.valueOf((zzpeVar.zzc() - zzba().currentTimeMillis()) / 1000));
        }
        zzaw zzj4 = zzj();
        Long valueOf3 = Long.valueOf(zzafVar.zza);
        zzj4.zzK(valueOf3);
        zzaW().zzk().zzc("[sgtm] increased batch retry count after failed client upload. appId, rowId", str, valueOf3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzat(boolean z) {
        zzaM();
    }

    public final void zzau(String str, zzlu zzluVar) {
        zzaX().zzg();
        String str2 = this.zzH;
        if (str2 == null || str2.equals(str) || zzluVar != null) {
            this.zzH = str;
            this.zzG = zzluVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzav(zzph zzphVar) {
        zzaX().zzg();
        this.zzm = new zzhk(this);
        zzaw zzawVar = new zzaw(this);
        zzawVar.zzaz();
        this.zze = zzawVar;
        zzd().zza((zzak) Preconditions.checkNotNull(this.zzc));
        zznn zznnVar = new zznn(this);
        zznnVar.zzaz();
        this.zzk = zznnVar;
        zzad zzadVar = new zzad(this);
        zzadVar.zzaz();
        this.zzh = zzadVar;
        zzlp zzlpVar = new zzlp(this);
        zzlpVar.zzaz();
        this.zzj = zzlpVar;
        zzok zzokVar = new zzok(this);
        zzokVar.zzaz();
        this.zzg = zzokVar;
        this.zzf = new zzhb(this);
        if (this.zzs != this.zzt) {
            zzaW().zzb().zzc("Not all upload components initialized", Integer.valueOf(this.zzs), Integer.valueOf(this.zzt));
        }
        this.zzo.set(true);
        zzaW().zzk().zza("UploadController is now fully initialized");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzic zzay() {
        return this.zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Deque zzaz() {
        return this.zzr;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final Clock zzba() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzba();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzc() {
        zzaX().zzg();
        zzj().zzI();
        zzaw zzj = zzj();
        zzj.zzg();
        zzj.zzay();
        if (zzj.zzai()) {
            zzfx zzfxVar = zzfy.zzau;
            if (((Long) zzfxVar.zzb(null)).longValue() != 0) {
                SQLiteDatabase zze = zzj.zze();
                zzic zzicVar = zzj.zzu;
                int delete = zze.delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(zzicVar.zzba().currentTimeMillis()), String.valueOf(zzfxVar.zzb(null))});
                if (delete > 0) {
                    zzicVar.zzaW().zzk().zzb("Deleted stale trigger uris. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
        if (this.zzk.zzd.zza() == 0) {
            this.zzk.zzd.zzb(zzba().currentTimeMillis());
        }
        zzaM();
    }

    public final zzal zzd() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzc();
    }

    public final zzou zzf() {
        return this.zzl;
    }

    public final zzht zzh() {
        zzht zzhtVar = this.zzc;
        zzaT(zzhtVar);
        return zzhtVar;
    }

    public final zzgz zzi() {
        zzgz zzgzVar = this.zzd;
        zzaT(zzgzVar);
        return zzgzVar;
    }

    public final zzaw zzj() {
        zzaw zzawVar = this.zze;
        zzaT(zzawVar);
        return zzawVar;
    }

    public final zzhb zzk() {
        zzhb zzhbVar = this.zzf;
        if (zzhbVar != null) {
            return zzhbVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzok zzl() {
        zzok zzokVar = this.zzg;
        zzaT(zzokVar);
        return zzokVar;
    }

    public final zzad zzm() {
        zzad zzadVar = this.zzh;
        zzaT(zzadVar);
        return zzadVar;
    }

    public final zzlp zzn() {
        zzlp zzlpVar = this.zzj;
        zzaT(zzlpVar);
        return zzlpVar;
    }

    public final zzpk zzp() {
        zzpk zzpkVar = this.zzi;
        zzaT(zzpkVar);
        return zzpkVar;
    }

    public final zznn zzq() {
        return this.zzk;
    }

    public final zzgn zzs() {
        return this.zzn.zzl();
    }

    public final zzpp zzt() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzk();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzu() {
        if (!this.zzo.get()) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzv(zzr zzrVar) {
        zzaX().zzg();
        zzu();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzjl zzf = zzjl.zzf(zzrVar.zzs, zzrVar.zzx);
        zzB(str);
        zzaW().zzk().zzc("Setting storage consent for package", str, zzf);
        zzA(str, zzf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzw(zzr zzrVar) {
        zzaX().zzg();
        zzu();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzba zzg = zzba.zzg(zzrVar.zzy);
        zzaW().zzk().zzc("Setting DMA consent for package", str, zzg);
        zzaX().zzg();
        zzu();
        zzji zzc = zzba.zzh(zzy(str), 100).zzc();
        this.zzD.put(str, zzg);
        zzj().zzad(str, zzg);
        zzji zzc2 = zzba.zzh(zzy(str), 100).zzc();
        zzaX().zzg();
        zzu();
        zzji zzjiVar = zzji.DENIED;
        boolean z = true;
        boolean z2 = zzc == zzjiVar && zzc2 == zzji.GRANTED;
        if (zzc != zzji.GRANTED || zzc2 != zzjiVar) {
            z = false;
        }
        if (z2 || z) {
            zzaW().zzk().zzb("Generated _dcu event for", str);
            Bundle bundle = new Bundle();
            if (zzj().zzw(zzC(), str, false, false, false, false, false, false, false).zzf < zzd().zzm(str, zzfy.zzal)) {
                bundle.putLong("_r", 1L);
                zzaW().zzk().zzc("_dcu realtime event count", str, Long.valueOf(zzj().zzw(zzC(), str, false, false, false, false, false, true, false).zzf));
            }
            this.zzK.zza(str, "_dcu", bundle);
        }
    }

    final zzba zzx(String str) {
        zzaX().zzg();
        zzu();
        Map map = this.zzD;
        zzba zzbaVar = (zzba) map.get(str);
        if (zzbaVar == null) {
            zzba zzab = zzj().zzab(str);
            map.put(str, zzab);
            return zzab;
        }
        return zzbaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zzy(String str) {
        boolean z;
        String str2;
        zzaX().zzg();
        zzu();
        if (zzh().zzy(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        zzjl zzB = zzB(str);
        bundle.putAll(zzB.zzn());
        bundle.putAll(zzz(str, zzx(str), zzB, new zzan()).zzf());
        zzpn zzm = zzj().zzm(str, "_npa");
        if (zzm != null) {
            z = zzm.zze.equals(1L);
        } else {
            z = zzaD(str, new zzan());
        }
        if (1 != z) {
            str2 = "granted";
        } else {
            str2 = "denied";
        }
        bundle.putString("ad_personalization", str2);
        return bundle;
    }

    final zzba zzz(String str, zzba zzbaVar, zzjl zzjlVar, zzan zzanVar) {
        zzji zzjiVar;
        int i = 90;
        boolean z = false;
        if (zzh().zzy(str) == null) {
            if (zzbaVar.zzc() == zzji.DENIED) {
                i = zzbaVar.zzb();
                zzanVar.zzb(zzjk.AD_USER_DATA, i);
            } else {
                zzanVar.zzc(zzjk.AD_USER_DATA, zzam.FAILSAFE);
            }
            return new zzba((Boolean) false, i, (Boolean) true, com.google.android.vending.expansion.downloader.Constants.FILENAME_SEQUENCE_SEPARATOR);
        }
        zzji zzc = zzbaVar.zzc();
        zzji zzjiVar2 = zzji.GRANTED;
        if (zzc == zzjiVar2 || zzc == (zzjiVar = zzji.DENIED)) {
            i = zzbaVar.zzb();
            zzanVar.zzb(zzjk.AD_USER_DATA, i);
        } else {
            if (zzc == zzji.POLICY) {
                zzht zzhtVar = this.zzc;
                zzjk zzjkVar = zzjk.AD_USER_DATA;
                zzji zzB = zzhtVar.zzB(str, zzjkVar);
                if (zzB != zzji.UNINITIALIZED) {
                    zzanVar.zzc(zzjkVar, zzam.REMOTE_ENFORCED_DEFAULT);
                    zzc = zzB;
                }
            }
            zzht zzhtVar2 = this.zzc;
            zzjk zzjkVar2 = zzjk.AD_USER_DATA;
            zzjk zzx = zzhtVar2.zzx(str, zzjkVar2);
            zzji zzp = zzjlVar.zzp();
            if (zzp == zzjiVar2 || zzp == zzjiVar) {
                z = true;
            }
            if (zzx == zzjk.AD_STORAGE && z) {
                zzanVar.zzc(zzjkVar2, zzam.REMOTE_DELEGATION);
                zzc = zzp;
            } else {
                zzanVar.zzc(zzjkVar2, zzam.REMOTE_DEFAULT);
                zzc = true != zzhtVar2.zzw(str, zzjkVar2) ? zzjiVar : zzjiVar2;
            }
        }
        boolean zzz = this.zzc.zzz(str);
        SortedSet zzA = zzh().zzA(str);
        if (zzc == zzji.DENIED || zzA.isEmpty()) {
            return new zzba((Boolean) false, i, Boolean.valueOf(zzz), com.google.android.vending.expansion.downloader.Constants.FILENAME_SEQUENCE_SEPARATOR);
        }
        return new zzba((Boolean) true, i, Boolean.valueOf(zzz), zzz ? TextUtils.join("", zzA) : "");
    }
}
