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
import com.google.android.gms.internal.measurement.zzpr;
import com.google.android.gms.internal.measurement.zzqp;
import com.google.android.gms.internal.measurement.zzrb;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
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
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import kotlinx.datetime.internal.DateCalculationsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: com.google.android.gms:play-services-measurement@@23.0.0 */
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
    private zzay zzI;
    private long zzJ;
    long zza;
    private final zzht zzc;
    private final zzgz zzd;
    private zzav zze;
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
        this.zzn = zzic.zzy(zzphVar.zza, null, null);
        this.zzB = -1L;
        this.zzl = new zzou(this);
        zzpk zzpkVar = new zzpk(this);
        zzpkVar.zzax();
        this.zzi = zzpkVar;
        zzgz zzgzVar = new zzgz(this);
        zzgzVar.zzax();
        this.zzd = zzgzVar;
        zzht zzhtVar = new zzht(this);
        zzhtVar.zzax();
        this.zzc = zzhtVar;
        this.zzC = new HashMap();
        this.zzD = new HashMap();
        this.zzE = new HashMap();
        zzaW().zzj(new zzov(this, zzphVar));
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

    static final void zzaA(com.google.android.gms.internal.measurement.zzhr zzhrVar, int i, String str) {
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
        zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzn.zzbc());
        zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzn2.zzbc());
    }

    static final void zzaB(com.google.android.gms.internal.measurement.zzhr zzhrVar, String str) {
        List zza = zzhrVar.zza();
        for (int i = 0; i < zza.size(); i++) {
            if (str.equals(((com.google.android.gms.internal.measurement.zzhw) zza.get(i)).zzb())) {
                zzhrVar.zzj(i);
                return;
            }
        }
    }

    private final int zzaC(String str, zzan zzanVar) {
        zzjk zzjkVar;
        zzji zzA;
        zzht zzhtVar = this.zzc;
        if (zzhtVar.zzx(str) == null) {
            zzanVar.zzc(zzjk.AD_PERSONALIZATION, zzam.FAILSAFE);
            return 1;
        }
        zzh zzu = zzj().zzu(str);
        if (zzu == null || zze.zzc(zzu.zzaH()).zza() != zzji.POLICY || (zzA = zzhtVar.zzA(str, (zzjkVar = zzjk.AD_PERSONALIZATION))) == zzji.UNINITIALIZED) {
            zzjk zzjkVar2 = zzjk.AD_PERSONALIZATION;
            zzanVar.zzc(zzjkVar2, zzam.REMOTE_DEFAULT);
            return zzhtVar.zzv(str, zzjkVar2) ? 0 : 1;
        }
        zzanVar.zzc(zzjkVar, zzam.REMOTE_ENFORCED_DEFAULT);
        return zzA == zzji.GRANTED ? 0 : 1;
    }

    private final Map zzaD(com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        HashMap hashMap = new HashMap();
        zzp();
        for (Map.Entry entry : zzpk.zzH(zzhsVar, "gad_").entrySet()) {
            hashMap.put((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
        return hashMap;
    }

    private final zzay zzaE() {
        if (this.zzI == null) {
            this.zzI = new zzoy(this, this.zzn);
        }
        return this.zzI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzaF */
    public final void zzav() {
        zzaW().zzg();
        if (this.zzr.isEmpty() || zzaE().zzc()) {
            return;
        }
        long max = Math.max(0L, ((Integer) zzfy.zzaB.zzb(null)).intValue() - (zzaZ().elapsedRealtime() - this.zzJ));
        zzaV().zzk().zzb("Scheduling notify next app runnable, delay in ms", Long.valueOf(max));
        zzaE().zzb(max);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x037e A[Catch: all -> 0x0e15, TryCatch #1 {all -> 0x0e15, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005a, B:15:0x0082, B:17:0x00b7, B:20:0x00c8, B:22:0x00d2, B:228:0x06e0, B:25:0x0100, B:28:0x0112, B:30:0x0118, B:45:0x015a, B:47:0x0168, B:50:0x0188, B:52:0x018e, B:54:0x019e, B:56:0x01ac, B:58:0x01bc, B:59:0x01c9, B:60:0x01cc, B:63:0x01e2, B:74:0x0210, B:77:0x021a, B:79:0x0228, B:85:0x0278, B:80:0x0245, B:82:0x0255, B:89:0x0285, B:91:0x02b1, B:92:0x02db, B:94:0x0314, B:96:0x031a, B:119:0x03e7, B:120:0x03f3, B:123:0x0401, B:129:0x0424, B:126:0x0413, B:152:0x04ab, B:154:0x04b5, B:157:0x04c6, B:159:0x04d9, B:161:0x04e5, B:194:0x05a5, B:196:0x05ab, B:197:0x05b7, B:199:0x05bd, B:201:0x05cd, B:203:0x05d7, B:204:0x05ea, B:206:0x05f0, B:207:0x060b, B:209:0x0611, B:210:0x062f, B:211:0x063c, B:215:0x0667, B:212:0x0644, B:214:0x0654, B:216:0x0672, B:217:0x068c, B:219:0x0692, B:221:0x06a5, B:222:0x06b2, B:223:0x06b6, B:225:0x06bc, B:227:0x06cc, B:165:0x04f8, B:167:0x0504, B:170:0x0515, B:172:0x0528, B:174:0x0534, B:176:0x0542, B:178:0x0551, B:180:0x055b, B:182:0x0567, B:184:0x0571, B:187:0x057e, B:189:0x0584, B:191:0x0594, B:192:0x059f, B:133:0x0430, B:135:0x043c, B:137:0x0448, B:149:0x048d, B:141:0x0465, B:144:0x0477, B:146:0x047d, B:148:0x0487, B:99:0x0326, B:101:0x035d, B:102:0x0378, B:104:0x037e, B:106:0x038e, B:110:0x03a4, B:107:0x0398, B:113:0x03ab, B:116:0x03b3, B:117:0x03cc, B:34:0x0122, B:36:0x012f, B:38:0x013b, B:40:0x0141, B:44:0x014c, B:231:0x06f6, B:233:0x0704, B:235:0x070d, B:246:0x073d, B:236:0x0715, B:238:0x071e, B:240:0x0724, B:243:0x0730, B:245:0x0738, B:247:0x0740, B:248:0x074c, B:251:0x0754, B:253:0x0766, B:254:0x0771, B:256:0x0779, B:260:0x079f, B:262:0x07b9, B:264:0x07ce, B:266:0x07e8, B:268:0x07fd, B:269:0x080b, B:271:0x0811, B:273:0x0821, B:274:0x0828, B:276:0x0834, B:277:0x083b, B:278:0x083e, B:280:0x0880, B:282:0x0886, B:288:0x08ad, B:290:0x08b5, B:291:0x08be, B:293:0x08c4, B:294:0x08ca, B:296:0x08df, B:298:0x08ef, B:300:0x08ff, B:302:0x0907, B:303:0x090a, B:311:0x097e, B:313:0x0997, B:315:0x09ad, B:317:0x09b2, B:319:0x09b6, B:321:0x09ba, B:323:0x09c4, B:324:0x09ca, B:326:0x09ce, B:328:0x09d4, B:329:0x09e2, B:330:0x09eb, B:335:0x0a0e, B:338:0x0a14, B:283:0x0894, B:285:0x089a, B:287:0x08a0, B:267:0x07fa, B:263:0x07cb, B:257:0x077f, B:259:0x0785), top: B:478:0x0011, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03b3 A[Catch: all -> 0x0e15, TryCatch #1 {all -> 0x0e15, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005a, B:15:0x0082, B:17:0x00b7, B:20:0x00c8, B:22:0x00d2, B:228:0x06e0, B:25:0x0100, B:28:0x0112, B:30:0x0118, B:45:0x015a, B:47:0x0168, B:50:0x0188, B:52:0x018e, B:54:0x019e, B:56:0x01ac, B:58:0x01bc, B:59:0x01c9, B:60:0x01cc, B:63:0x01e2, B:74:0x0210, B:77:0x021a, B:79:0x0228, B:85:0x0278, B:80:0x0245, B:82:0x0255, B:89:0x0285, B:91:0x02b1, B:92:0x02db, B:94:0x0314, B:96:0x031a, B:119:0x03e7, B:120:0x03f3, B:123:0x0401, B:129:0x0424, B:126:0x0413, B:152:0x04ab, B:154:0x04b5, B:157:0x04c6, B:159:0x04d9, B:161:0x04e5, B:194:0x05a5, B:196:0x05ab, B:197:0x05b7, B:199:0x05bd, B:201:0x05cd, B:203:0x05d7, B:204:0x05ea, B:206:0x05f0, B:207:0x060b, B:209:0x0611, B:210:0x062f, B:211:0x063c, B:215:0x0667, B:212:0x0644, B:214:0x0654, B:216:0x0672, B:217:0x068c, B:219:0x0692, B:221:0x06a5, B:222:0x06b2, B:223:0x06b6, B:225:0x06bc, B:227:0x06cc, B:165:0x04f8, B:167:0x0504, B:170:0x0515, B:172:0x0528, B:174:0x0534, B:176:0x0542, B:178:0x0551, B:180:0x055b, B:182:0x0567, B:184:0x0571, B:187:0x057e, B:189:0x0584, B:191:0x0594, B:192:0x059f, B:133:0x0430, B:135:0x043c, B:137:0x0448, B:149:0x048d, B:141:0x0465, B:144:0x0477, B:146:0x047d, B:148:0x0487, B:99:0x0326, B:101:0x035d, B:102:0x0378, B:104:0x037e, B:106:0x038e, B:110:0x03a4, B:107:0x0398, B:113:0x03ab, B:116:0x03b3, B:117:0x03cc, B:34:0x0122, B:36:0x012f, B:38:0x013b, B:40:0x0141, B:44:0x014c, B:231:0x06f6, B:233:0x0704, B:235:0x070d, B:246:0x073d, B:236:0x0715, B:238:0x071e, B:240:0x0724, B:243:0x0730, B:245:0x0738, B:247:0x0740, B:248:0x074c, B:251:0x0754, B:253:0x0766, B:254:0x0771, B:256:0x0779, B:260:0x079f, B:262:0x07b9, B:264:0x07ce, B:266:0x07e8, B:268:0x07fd, B:269:0x080b, B:271:0x0811, B:273:0x0821, B:274:0x0828, B:276:0x0834, B:277:0x083b, B:278:0x083e, B:280:0x0880, B:282:0x0886, B:288:0x08ad, B:290:0x08b5, B:291:0x08be, B:293:0x08c4, B:294:0x08ca, B:296:0x08df, B:298:0x08ef, B:300:0x08ff, B:302:0x0907, B:303:0x090a, B:311:0x097e, B:313:0x0997, B:315:0x09ad, B:317:0x09b2, B:319:0x09b6, B:321:0x09ba, B:323:0x09c4, B:324:0x09ca, B:326:0x09ce, B:328:0x09d4, B:329:0x09e2, B:330:0x09eb, B:335:0x0a0e, B:338:0x0a14, B:283:0x0894, B:285:0x089a, B:287:0x08a0, B:267:0x07fa, B:263:0x07cb, B:257:0x077f, B:259:0x0785), top: B:478:0x0011, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03cc A[Catch: all -> 0x0e15, TryCatch #1 {all -> 0x0e15, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005a, B:15:0x0082, B:17:0x00b7, B:20:0x00c8, B:22:0x00d2, B:228:0x06e0, B:25:0x0100, B:28:0x0112, B:30:0x0118, B:45:0x015a, B:47:0x0168, B:50:0x0188, B:52:0x018e, B:54:0x019e, B:56:0x01ac, B:58:0x01bc, B:59:0x01c9, B:60:0x01cc, B:63:0x01e2, B:74:0x0210, B:77:0x021a, B:79:0x0228, B:85:0x0278, B:80:0x0245, B:82:0x0255, B:89:0x0285, B:91:0x02b1, B:92:0x02db, B:94:0x0314, B:96:0x031a, B:119:0x03e7, B:120:0x03f3, B:123:0x0401, B:129:0x0424, B:126:0x0413, B:152:0x04ab, B:154:0x04b5, B:157:0x04c6, B:159:0x04d9, B:161:0x04e5, B:194:0x05a5, B:196:0x05ab, B:197:0x05b7, B:199:0x05bd, B:201:0x05cd, B:203:0x05d7, B:204:0x05ea, B:206:0x05f0, B:207:0x060b, B:209:0x0611, B:210:0x062f, B:211:0x063c, B:215:0x0667, B:212:0x0644, B:214:0x0654, B:216:0x0672, B:217:0x068c, B:219:0x0692, B:221:0x06a5, B:222:0x06b2, B:223:0x06b6, B:225:0x06bc, B:227:0x06cc, B:165:0x04f8, B:167:0x0504, B:170:0x0515, B:172:0x0528, B:174:0x0534, B:176:0x0542, B:178:0x0551, B:180:0x055b, B:182:0x0567, B:184:0x0571, B:187:0x057e, B:189:0x0584, B:191:0x0594, B:192:0x059f, B:133:0x0430, B:135:0x043c, B:137:0x0448, B:149:0x048d, B:141:0x0465, B:144:0x0477, B:146:0x047d, B:148:0x0487, B:99:0x0326, B:101:0x035d, B:102:0x0378, B:104:0x037e, B:106:0x038e, B:110:0x03a4, B:107:0x0398, B:113:0x03ab, B:116:0x03b3, B:117:0x03cc, B:34:0x0122, B:36:0x012f, B:38:0x013b, B:40:0x0141, B:44:0x014c, B:231:0x06f6, B:233:0x0704, B:235:0x070d, B:246:0x073d, B:236:0x0715, B:238:0x071e, B:240:0x0724, B:243:0x0730, B:245:0x0738, B:247:0x0740, B:248:0x074c, B:251:0x0754, B:253:0x0766, B:254:0x0771, B:256:0x0779, B:260:0x079f, B:262:0x07b9, B:264:0x07ce, B:266:0x07e8, B:268:0x07fd, B:269:0x080b, B:271:0x0811, B:273:0x0821, B:274:0x0828, B:276:0x0834, B:277:0x083b, B:278:0x083e, B:280:0x0880, B:282:0x0886, B:288:0x08ad, B:290:0x08b5, B:291:0x08be, B:293:0x08c4, B:294:0x08ca, B:296:0x08df, B:298:0x08ef, B:300:0x08ff, B:302:0x0907, B:303:0x090a, B:311:0x097e, B:313:0x0997, B:315:0x09ad, B:317:0x09b2, B:319:0x09b6, B:321:0x09ba, B:323:0x09c4, B:324:0x09ca, B:326:0x09ce, B:328:0x09d4, B:329:0x09e2, B:330:0x09eb, B:335:0x0a0e, B:338:0x0a14, B:283:0x0894, B:285:0x089a, B:287:0x08a0, B:267:0x07fa, B:263:0x07cb, B:257:0x077f, B:259:0x0785), top: B:478:0x0011, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03e7 A[Catch: all -> 0x0e15, TryCatch #1 {all -> 0x0e15, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005a, B:15:0x0082, B:17:0x00b7, B:20:0x00c8, B:22:0x00d2, B:228:0x06e0, B:25:0x0100, B:28:0x0112, B:30:0x0118, B:45:0x015a, B:47:0x0168, B:50:0x0188, B:52:0x018e, B:54:0x019e, B:56:0x01ac, B:58:0x01bc, B:59:0x01c9, B:60:0x01cc, B:63:0x01e2, B:74:0x0210, B:77:0x021a, B:79:0x0228, B:85:0x0278, B:80:0x0245, B:82:0x0255, B:89:0x0285, B:91:0x02b1, B:92:0x02db, B:94:0x0314, B:96:0x031a, B:119:0x03e7, B:120:0x03f3, B:123:0x0401, B:129:0x0424, B:126:0x0413, B:152:0x04ab, B:154:0x04b5, B:157:0x04c6, B:159:0x04d9, B:161:0x04e5, B:194:0x05a5, B:196:0x05ab, B:197:0x05b7, B:199:0x05bd, B:201:0x05cd, B:203:0x05d7, B:204:0x05ea, B:206:0x05f0, B:207:0x060b, B:209:0x0611, B:210:0x062f, B:211:0x063c, B:215:0x0667, B:212:0x0644, B:214:0x0654, B:216:0x0672, B:217:0x068c, B:219:0x0692, B:221:0x06a5, B:222:0x06b2, B:223:0x06b6, B:225:0x06bc, B:227:0x06cc, B:165:0x04f8, B:167:0x0504, B:170:0x0515, B:172:0x0528, B:174:0x0534, B:176:0x0542, B:178:0x0551, B:180:0x055b, B:182:0x0567, B:184:0x0571, B:187:0x057e, B:189:0x0584, B:191:0x0594, B:192:0x059f, B:133:0x0430, B:135:0x043c, B:137:0x0448, B:149:0x048d, B:141:0x0465, B:144:0x0477, B:146:0x047d, B:148:0x0487, B:99:0x0326, B:101:0x035d, B:102:0x0378, B:104:0x037e, B:106:0x038e, B:110:0x03a4, B:107:0x0398, B:113:0x03ab, B:116:0x03b3, B:117:0x03cc, B:34:0x0122, B:36:0x012f, B:38:0x013b, B:40:0x0141, B:44:0x014c, B:231:0x06f6, B:233:0x0704, B:235:0x070d, B:246:0x073d, B:236:0x0715, B:238:0x071e, B:240:0x0724, B:243:0x0730, B:245:0x0738, B:247:0x0740, B:248:0x074c, B:251:0x0754, B:253:0x0766, B:254:0x0771, B:256:0x0779, B:260:0x079f, B:262:0x07b9, B:264:0x07ce, B:266:0x07e8, B:268:0x07fd, B:269:0x080b, B:271:0x0811, B:273:0x0821, B:274:0x0828, B:276:0x0834, B:277:0x083b, B:278:0x083e, B:280:0x0880, B:282:0x0886, B:288:0x08ad, B:290:0x08b5, B:291:0x08be, B:293:0x08c4, B:294:0x08ca, B:296:0x08df, B:298:0x08ef, B:300:0x08ff, B:302:0x0907, B:303:0x090a, B:311:0x097e, B:313:0x0997, B:315:0x09ad, B:317:0x09b2, B:319:0x09b6, B:321:0x09ba, B:323:0x09c4, B:324:0x09ca, B:326:0x09ce, B:328:0x09d4, B:329:0x09e2, B:330:0x09eb, B:335:0x0a0e, B:338:0x0a14, B:283:0x0894, B:285:0x089a, B:287:0x08a0, B:267:0x07fa, B:263:0x07cb, B:257:0x077f, B:259:0x0785), top: B:478:0x0011, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x04b5 A[Catch: all -> 0x0e15, TryCatch #1 {all -> 0x0e15, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005a, B:15:0x0082, B:17:0x00b7, B:20:0x00c8, B:22:0x00d2, B:228:0x06e0, B:25:0x0100, B:28:0x0112, B:30:0x0118, B:45:0x015a, B:47:0x0168, B:50:0x0188, B:52:0x018e, B:54:0x019e, B:56:0x01ac, B:58:0x01bc, B:59:0x01c9, B:60:0x01cc, B:63:0x01e2, B:74:0x0210, B:77:0x021a, B:79:0x0228, B:85:0x0278, B:80:0x0245, B:82:0x0255, B:89:0x0285, B:91:0x02b1, B:92:0x02db, B:94:0x0314, B:96:0x031a, B:119:0x03e7, B:120:0x03f3, B:123:0x0401, B:129:0x0424, B:126:0x0413, B:152:0x04ab, B:154:0x04b5, B:157:0x04c6, B:159:0x04d9, B:161:0x04e5, B:194:0x05a5, B:196:0x05ab, B:197:0x05b7, B:199:0x05bd, B:201:0x05cd, B:203:0x05d7, B:204:0x05ea, B:206:0x05f0, B:207:0x060b, B:209:0x0611, B:210:0x062f, B:211:0x063c, B:215:0x0667, B:212:0x0644, B:214:0x0654, B:216:0x0672, B:217:0x068c, B:219:0x0692, B:221:0x06a5, B:222:0x06b2, B:223:0x06b6, B:225:0x06bc, B:227:0x06cc, B:165:0x04f8, B:167:0x0504, B:170:0x0515, B:172:0x0528, B:174:0x0534, B:176:0x0542, B:178:0x0551, B:180:0x055b, B:182:0x0567, B:184:0x0571, B:187:0x057e, B:189:0x0584, B:191:0x0594, B:192:0x059f, B:133:0x0430, B:135:0x043c, B:137:0x0448, B:149:0x048d, B:141:0x0465, B:144:0x0477, B:146:0x047d, B:148:0x0487, B:99:0x0326, B:101:0x035d, B:102:0x0378, B:104:0x037e, B:106:0x038e, B:110:0x03a4, B:107:0x0398, B:113:0x03ab, B:116:0x03b3, B:117:0x03cc, B:34:0x0122, B:36:0x012f, B:38:0x013b, B:40:0x0141, B:44:0x014c, B:231:0x06f6, B:233:0x0704, B:235:0x070d, B:246:0x073d, B:236:0x0715, B:238:0x071e, B:240:0x0724, B:243:0x0730, B:245:0x0738, B:247:0x0740, B:248:0x074c, B:251:0x0754, B:253:0x0766, B:254:0x0771, B:256:0x0779, B:260:0x079f, B:262:0x07b9, B:264:0x07ce, B:266:0x07e8, B:268:0x07fd, B:269:0x080b, B:271:0x0811, B:273:0x0821, B:274:0x0828, B:276:0x0834, B:277:0x083b, B:278:0x083e, B:280:0x0880, B:282:0x0886, B:288:0x08ad, B:290:0x08b5, B:291:0x08be, B:293:0x08c4, B:294:0x08ca, B:296:0x08df, B:298:0x08ef, B:300:0x08ff, B:302:0x0907, B:303:0x090a, B:311:0x097e, B:313:0x0997, B:315:0x09ad, B:317:0x09b2, B:319:0x09b6, B:321:0x09ba, B:323:0x09c4, B:324:0x09ca, B:326:0x09ce, B:328:0x09d4, B:329:0x09e2, B:330:0x09eb, B:335:0x0a0e, B:338:0x0a14, B:283:0x0894, B:285:0x089a, B:287:0x08a0, B:267:0x07fa, B:263:0x07cb, B:257:0x077f, B:259:0x0785), top: B:478:0x0011, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x04f8 A[Catch: all -> 0x0e15, TryCatch #1 {all -> 0x0e15, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005a, B:15:0x0082, B:17:0x00b7, B:20:0x00c8, B:22:0x00d2, B:228:0x06e0, B:25:0x0100, B:28:0x0112, B:30:0x0118, B:45:0x015a, B:47:0x0168, B:50:0x0188, B:52:0x018e, B:54:0x019e, B:56:0x01ac, B:58:0x01bc, B:59:0x01c9, B:60:0x01cc, B:63:0x01e2, B:74:0x0210, B:77:0x021a, B:79:0x0228, B:85:0x0278, B:80:0x0245, B:82:0x0255, B:89:0x0285, B:91:0x02b1, B:92:0x02db, B:94:0x0314, B:96:0x031a, B:119:0x03e7, B:120:0x03f3, B:123:0x0401, B:129:0x0424, B:126:0x0413, B:152:0x04ab, B:154:0x04b5, B:157:0x04c6, B:159:0x04d9, B:161:0x04e5, B:194:0x05a5, B:196:0x05ab, B:197:0x05b7, B:199:0x05bd, B:201:0x05cd, B:203:0x05d7, B:204:0x05ea, B:206:0x05f0, B:207:0x060b, B:209:0x0611, B:210:0x062f, B:211:0x063c, B:215:0x0667, B:212:0x0644, B:214:0x0654, B:216:0x0672, B:217:0x068c, B:219:0x0692, B:221:0x06a5, B:222:0x06b2, B:223:0x06b6, B:225:0x06bc, B:227:0x06cc, B:165:0x04f8, B:167:0x0504, B:170:0x0515, B:172:0x0528, B:174:0x0534, B:176:0x0542, B:178:0x0551, B:180:0x055b, B:182:0x0567, B:184:0x0571, B:187:0x057e, B:189:0x0584, B:191:0x0594, B:192:0x059f, B:133:0x0430, B:135:0x043c, B:137:0x0448, B:149:0x048d, B:141:0x0465, B:144:0x0477, B:146:0x047d, B:148:0x0487, B:99:0x0326, B:101:0x035d, B:102:0x0378, B:104:0x037e, B:106:0x038e, B:110:0x03a4, B:107:0x0398, B:113:0x03ab, B:116:0x03b3, B:117:0x03cc, B:34:0x0122, B:36:0x012f, B:38:0x013b, B:40:0x0141, B:44:0x014c, B:231:0x06f6, B:233:0x0704, B:235:0x070d, B:246:0x073d, B:236:0x0715, B:238:0x071e, B:240:0x0724, B:243:0x0730, B:245:0x0738, B:247:0x0740, B:248:0x074c, B:251:0x0754, B:253:0x0766, B:254:0x0771, B:256:0x0779, B:260:0x079f, B:262:0x07b9, B:264:0x07ce, B:266:0x07e8, B:268:0x07fd, B:269:0x080b, B:271:0x0811, B:273:0x0821, B:274:0x0828, B:276:0x0834, B:277:0x083b, B:278:0x083e, B:280:0x0880, B:282:0x0886, B:288:0x08ad, B:290:0x08b5, B:291:0x08be, B:293:0x08c4, B:294:0x08ca, B:296:0x08df, B:298:0x08ef, B:300:0x08ff, B:302:0x0907, B:303:0x090a, B:311:0x097e, B:313:0x0997, B:315:0x09ad, B:317:0x09b2, B:319:0x09b6, B:321:0x09ba, B:323:0x09c4, B:324:0x09ca, B:326:0x09ce, B:328:0x09d4, B:329:0x09e2, B:330:0x09eb, B:335:0x0a0e, B:338:0x0a14, B:283:0x0894, B:285:0x089a, B:287:0x08a0, B:267:0x07fa, B:263:0x07cb, B:257:0x077f, B:259:0x0785), top: B:478:0x0011, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x05ab A[Catch: all -> 0x0e15, TryCatch #1 {all -> 0x0e15, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005a, B:15:0x0082, B:17:0x00b7, B:20:0x00c8, B:22:0x00d2, B:228:0x06e0, B:25:0x0100, B:28:0x0112, B:30:0x0118, B:45:0x015a, B:47:0x0168, B:50:0x0188, B:52:0x018e, B:54:0x019e, B:56:0x01ac, B:58:0x01bc, B:59:0x01c9, B:60:0x01cc, B:63:0x01e2, B:74:0x0210, B:77:0x021a, B:79:0x0228, B:85:0x0278, B:80:0x0245, B:82:0x0255, B:89:0x0285, B:91:0x02b1, B:92:0x02db, B:94:0x0314, B:96:0x031a, B:119:0x03e7, B:120:0x03f3, B:123:0x0401, B:129:0x0424, B:126:0x0413, B:152:0x04ab, B:154:0x04b5, B:157:0x04c6, B:159:0x04d9, B:161:0x04e5, B:194:0x05a5, B:196:0x05ab, B:197:0x05b7, B:199:0x05bd, B:201:0x05cd, B:203:0x05d7, B:204:0x05ea, B:206:0x05f0, B:207:0x060b, B:209:0x0611, B:210:0x062f, B:211:0x063c, B:215:0x0667, B:212:0x0644, B:214:0x0654, B:216:0x0672, B:217:0x068c, B:219:0x0692, B:221:0x06a5, B:222:0x06b2, B:223:0x06b6, B:225:0x06bc, B:227:0x06cc, B:165:0x04f8, B:167:0x0504, B:170:0x0515, B:172:0x0528, B:174:0x0534, B:176:0x0542, B:178:0x0551, B:180:0x055b, B:182:0x0567, B:184:0x0571, B:187:0x057e, B:189:0x0584, B:191:0x0594, B:192:0x059f, B:133:0x0430, B:135:0x043c, B:137:0x0448, B:149:0x048d, B:141:0x0465, B:144:0x0477, B:146:0x047d, B:148:0x0487, B:99:0x0326, B:101:0x035d, B:102:0x0378, B:104:0x037e, B:106:0x038e, B:110:0x03a4, B:107:0x0398, B:113:0x03ab, B:116:0x03b3, B:117:0x03cc, B:34:0x0122, B:36:0x012f, B:38:0x013b, B:40:0x0141, B:44:0x014c, B:231:0x06f6, B:233:0x0704, B:235:0x070d, B:246:0x073d, B:236:0x0715, B:238:0x071e, B:240:0x0724, B:243:0x0730, B:245:0x0738, B:247:0x0740, B:248:0x074c, B:251:0x0754, B:253:0x0766, B:254:0x0771, B:256:0x0779, B:260:0x079f, B:262:0x07b9, B:264:0x07ce, B:266:0x07e8, B:268:0x07fd, B:269:0x080b, B:271:0x0811, B:273:0x0821, B:274:0x0828, B:276:0x0834, B:277:0x083b, B:278:0x083e, B:280:0x0880, B:282:0x0886, B:288:0x08ad, B:290:0x08b5, B:291:0x08be, B:293:0x08c4, B:294:0x08ca, B:296:0x08df, B:298:0x08ef, B:300:0x08ff, B:302:0x0907, B:303:0x090a, B:311:0x097e, B:313:0x0997, B:315:0x09ad, B:317:0x09b2, B:319:0x09b6, B:321:0x09ba, B:323:0x09c4, B:324:0x09ca, B:326:0x09ce, B:328:0x09d4, B:329:0x09e2, B:330:0x09eb, B:335:0x0a0e, B:338:0x0a14, B:283:0x0894, B:285:0x089a, B:287:0x08a0, B:267:0x07fa, B:263:0x07cb, B:257:0x077f, B:259:0x0785), top: B:478:0x0011, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x06c6  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x0a4a A[Catch: all -> 0x0dfd, TryCatch #4 {all -> 0x0dfd, blocks: (B:305:0x094c, B:306:0x095f, B:308:0x0965, B:398:0x0c1f, B:333:0x09f8, B:340:0x0a28, B:342:0x0a4a, B:343:0x0a52, B:345:0x0a58, B:347:0x0a68, B:354:0x0a90, B:355:0x0ab3, B:357:0x0abf, B:359:0x0ad3, B:361:0x0b14, B:365:0x0b2a, B:367:0x0b31, B:369:0x0b40, B:371:0x0b44, B:373:0x0b48, B:375:0x0b4c, B:376:0x0b58, B:377:0x0b5d, B:379:0x0b63, B:381:0x0b7d, B:382:0x0b82, B:397:0x0c1c, B:383:0x0b99, B:385:0x0b9d, B:389:0x0bc3, B:391:0x0beb, B:392:0x0bf6, B:393:0x0c06, B:395:0x0c0e, B:386:0x0baa, B:352:0x0a7c, B:399:0x0c2b, B:401:0x0c39, B:402:0x0c3f, B:403:0x0c47, B:405:0x0c4d, B:408:0x0c66, B:410:0x0c76, B:430:0x0cf3, B:411:0x0c8e, B:413:0x0c94, B:415:0x0c9c, B:417:0x0ca3, B:423:0x0cb1, B:425:0x0cb8, B:427:0x0ce4, B:429:0x0ceb, B:428:0x0ce8, B:424:0x0cb5, B:416:0x0ca0), top: B:484:0x094c }] */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0a90 A[Catch: all -> 0x0dfd, TryCatch #4 {all -> 0x0dfd, blocks: (B:305:0x094c, B:306:0x095f, B:308:0x0965, B:398:0x0c1f, B:333:0x09f8, B:340:0x0a28, B:342:0x0a4a, B:343:0x0a52, B:345:0x0a58, B:347:0x0a68, B:354:0x0a90, B:355:0x0ab3, B:357:0x0abf, B:359:0x0ad3, B:361:0x0b14, B:365:0x0b2a, B:367:0x0b31, B:369:0x0b40, B:371:0x0b44, B:373:0x0b48, B:375:0x0b4c, B:376:0x0b58, B:377:0x0b5d, B:379:0x0b63, B:381:0x0b7d, B:382:0x0b82, B:397:0x0c1c, B:383:0x0b99, B:385:0x0b9d, B:389:0x0bc3, B:391:0x0beb, B:392:0x0bf6, B:393:0x0c06, B:395:0x0c0e, B:386:0x0baa, B:352:0x0a7c, B:399:0x0c2b, B:401:0x0c39, B:402:0x0c3f, B:403:0x0c47, B:405:0x0c4d, B:408:0x0c66, B:410:0x0c76, B:430:0x0cf3, B:411:0x0c8e, B:413:0x0c94, B:415:0x0c9c, B:417:0x0ca3, B:423:0x0cb1, B:425:0x0cb8, B:427:0x0ce4, B:429:0x0ceb, B:428:0x0ce8, B:424:0x0cb5, B:416:0x0ca0), top: B:484:0x094c }] */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0ab3 A[Catch: all -> 0x0dfd, TryCatch #4 {all -> 0x0dfd, blocks: (B:305:0x094c, B:306:0x095f, B:308:0x0965, B:398:0x0c1f, B:333:0x09f8, B:340:0x0a28, B:342:0x0a4a, B:343:0x0a52, B:345:0x0a58, B:347:0x0a68, B:354:0x0a90, B:355:0x0ab3, B:357:0x0abf, B:359:0x0ad3, B:361:0x0b14, B:365:0x0b2a, B:367:0x0b31, B:369:0x0b40, B:371:0x0b44, B:373:0x0b48, B:375:0x0b4c, B:376:0x0b58, B:377:0x0b5d, B:379:0x0b63, B:381:0x0b7d, B:382:0x0b82, B:397:0x0c1c, B:383:0x0b99, B:385:0x0b9d, B:389:0x0bc3, B:391:0x0beb, B:392:0x0bf6, B:393:0x0c06, B:395:0x0c0e, B:386:0x0baa, B:352:0x0a7c, B:399:0x0c2b, B:401:0x0c39, B:402:0x0c3f, B:403:0x0c47, B:405:0x0c4d, B:408:0x0c66, B:410:0x0c76, B:430:0x0cf3, B:411:0x0c8e, B:413:0x0c94, B:415:0x0c9c, B:417:0x0ca3, B:423:0x0cb1, B:425:0x0cb8, B:427:0x0ce4, B:429:0x0ceb, B:428:0x0ce8, B:424:0x0cb5, B:416:0x0ca0), top: B:484:0x094c }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0168 A[Catch: all -> 0x0e15, TryCatch #1 {all -> 0x0e15, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005a, B:15:0x0082, B:17:0x00b7, B:20:0x00c8, B:22:0x00d2, B:228:0x06e0, B:25:0x0100, B:28:0x0112, B:30:0x0118, B:45:0x015a, B:47:0x0168, B:50:0x0188, B:52:0x018e, B:54:0x019e, B:56:0x01ac, B:58:0x01bc, B:59:0x01c9, B:60:0x01cc, B:63:0x01e2, B:74:0x0210, B:77:0x021a, B:79:0x0228, B:85:0x0278, B:80:0x0245, B:82:0x0255, B:89:0x0285, B:91:0x02b1, B:92:0x02db, B:94:0x0314, B:96:0x031a, B:119:0x03e7, B:120:0x03f3, B:123:0x0401, B:129:0x0424, B:126:0x0413, B:152:0x04ab, B:154:0x04b5, B:157:0x04c6, B:159:0x04d9, B:161:0x04e5, B:194:0x05a5, B:196:0x05ab, B:197:0x05b7, B:199:0x05bd, B:201:0x05cd, B:203:0x05d7, B:204:0x05ea, B:206:0x05f0, B:207:0x060b, B:209:0x0611, B:210:0x062f, B:211:0x063c, B:215:0x0667, B:212:0x0644, B:214:0x0654, B:216:0x0672, B:217:0x068c, B:219:0x0692, B:221:0x06a5, B:222:0x06b2, B:223:0x06b6, B:225:0x06bc, B:227:0x06cc, B:165:0x04f8, B:167:0x0504, B:170:0x0515, B:172:0x0528, B:174:0x0534, B:176:0x0542, B:178:0x0551, B:180:0x055b, B:182:0x0567, B:184:0x0571, B:187:0x057e, B:189:0x0584, B:191:0x0594, B:192:0x059f, B:133:0x0430, B:135:0x043c, B:137:0x0448, B:149:0x048d, B:141:0x0465, B:144:0x0477, B:146:0x047d, B:148:0x0487, B:99:0x0326, B:101:0x035d, B:102:0x0378, B:104:0x037e, B:106:0x038e, B:110:0x03a4, B:107:0x0398, B:113:0x03ab, B:116:0x03b3, B:117:0x03cc, B:34:0x0122, B:36:0x012f, B:38:0x013b, B:40:0x0141, B:44:0x014c, B:231:0x06f6, B:233:0x0704, B:235:0x070d, B:246:0x073d, B:236:0x0715, B:238:0x071e, B:240:0x0724, B:243:0x0730, B:245:0x0738, B:247:0x0740, B:248:0x074c, B:251:0x0754, B:253:0x0766, B:254:0x0771, B:256:0x0779, B:260:0x079f, B:262:0x07b9, B:264:0x07ce, B:266:0x07e8, B:268:0x07fd, B:269:0x080b, B:271:0x0811, B:273:0x0821, B:274:0x0828, B:276:0x0834, B:277:0x083b, B:278:0x083e, B:280:0x0880, B:282:0x0886, B:288:0x08ad, B:290:0x08b5, B:291:0x08be, B:293:0x08c4, B:294:0x08ca, B:296:0x08df, B:298:0x08ef, B:300:0x08ff, B:302:0x0907, B:303:0x090a, B:311:0x097e, B:313:0x0997, B:315:0x09ad, B:317:0x09b2, B:319:0x09b6, B:321:0x09ba, B:323:0x09c4, B:324:0x09ca, B:326:0x09ce, B:328:0x09d4, B:329:0x09e2, B:330:0x09eb, B:335:0x0a0e, B:338:0x0a14, B:283:0x0894, B:285:0x089a, B:287:0x08a0, B:267:0x07fa, B:263:0x07cb, B:257:0x077f, B:259:0x0785), top: B:478:0x0011, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:494:0x027d A[EDGE_INSN: B:494:0x027d->B:86:0x027d ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01e2 A[Catch: all -> 0x0e15, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0e15, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005a, B:15:0x0082, B:17:0x00b7, B:20:0x00c8, B:22:0x00d2, B:228:0x06e0, B:25:0x0100, B:28:0x0112, B:30:0x0118, B:45:0x015a, B:47:0x0168, B:50:0x0188, B:52:0x018e, B:54:0x019e, B:56:0x01ac, B:58:0x01bc, B:59:0x01c9, B:60:0x01cc, B:63:0x01e2, B:74:0x0210, B:77:0x021a, B:79:0x0228, B:85:0x0278, B:80:0x0245, B:82:0x0255, B:89:0x0285, B:91:0x02b1, B:92:0x02db, B:94:0x0314, B:96:0x031a, B:119:0x03e7, B:120:0x03f3, B:123:0x0401, B:129:0x0424, B:126:0x0413, B:152:0x04ab, B:154:0x04b5, B:157:0x04c6, B:159:0x04d9, B:161:0x04e5, B:194:0x05a5, B:196:0x05ab, B:197:0x05b7, B:199:0x05bd, B:201:0x05cd, B:203:0x05d7, B:204:0x05ea, B:206:0x05f0, B:207:0x060b, B:209:0x0611, B:210:0x062f, B:211:0x063c, B:215:0x0667, B:212:0x0644, B:214:0x0654, B:216:0x0672, B:217:0x068c, B:219:0x0692, B:221:0x06a5, B:222:0x06b2, B:223:0x06b6, B:225:0x06bc, B:227:0x06cc, B:165:0x04f8, B:167:0x0504, B:170:0x0515, B:172:0x0528, B:174:0x0534, B:176:0x0542, B:178:0x0551, B:180:0x055b, B:182:0x0567, B:184:0x0571, B:187:0x057e, B:189:0x0584, B:191:0x0594, B:192:0x059f, B:133:0x0430, B:135:0x043c, B:137:0x0448, B:149:0x048d, B:141:0x0465, B:144:0x0477, B:146:0x047d, B:148:0x0487, B:99:0x0326, B:101:0x035d, B:102:0x0378, B:104:0x037e, B:106:0x038e, B:110:0x03a4, B:107:0x0398, B:113:0x03ab, B:116:0x03b3, B:117:0x03cc, B:34:0x0122, B:36:0x012f, B:38:0x013b, B:40:0x0141, B:44:0x014c, B:231:0x06f6, B:233:0x0704, B:235:0x070d, B:246:0x073d, B:236:0x0715, B:238:0x071e, B:240:0x0724, B:243:0x0730, B:245:0x0738, B:247:0x0740, B:248:0x074c, B:251:0x0754, B:253:0x0766, B:254:0x0771, B:256:0x0779, B:260:0x079f, B:262:0x07b9, B:264:0x07ce, B:266:0x07e8, B:268:0x07fd, B:269:0x080b, B:271:0x0811, B:273:0x0821, B:274:0x0828, B:276:0x0834, B:277:0x083b, B:278:0x083e, B:280:0x0880, B:282:0x0886, B:288:0x08ad, B:290:0x08b5, B:291:0x08be, B:293:0x08c4, B:294:0x08ca, B:296:0x08df, B:298:0x08ef, B:300:0x08ff, B:302:0x0907, B:303:0x090a, B:311:0x097e, B:313:0x0997, B:315:0x09ad, B:317:0x09b2, B:319:0x09b6, B:321:0x09ba, B:323:0x09c4, B:324:0x09ca, B:326:0x09ce, B:328:0x09d4, B:329:0x09e2, B:330:0x09eb, B:335:0x0a0e, B:338:0x0a14, B:283:0x0894, B:285:0x089a, B:287:0x08a0, B:267:0x07fa, B:263:0x07cb, B:257:0x077f, B:259:0x0785), top: B:478:0x0011, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x021a A[Catch: all -> 0x0e15, TRY_ENTER, TryCatch #1 {all -> 0x0e15, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005a, B:15:0x0082, B:17:0x00b7, B:20:0x00c8, B:22:0x00d2, B:228:0x06e0, B:25:0x0100, B:28:0x0112, B:30:0x0118, B:45:0x015a, B:47:0x0168, B:50:0x0188, B:52:0x018e, B:54:0x019e, B:56:0x01ac, B:58:0x01bc, B:59:0x01c9, B:60:0x01cc, B:63:0x01e2, B:74:0x0210, B:77:0x021a, B:79:0x0228, B:85:0x0278, B:80:0x0245, B:82:0x0255, B:89:0x0285, B:91:0x02b1, B:92:0x02db, B:94:0x0314, B:96:0x031a, B:119:0x03e7, B:120:0x03f3, B:123:0x0401, B:129:0x0424, B:126:0x0413, B:152:0x04ab, B:154:0x04b5, B:157:0x04c6, B:159:0x04d9, B:161:0x04e5, B:194:0x05a5, B:196:0x05ab, B:197:0x05b7, B:199:0x05bd, B:201:0x05cd, B:203:0x05d7, B:204:0x05ea, B:206:0x05f0, B:207:0x060b, B:209:0x0611, B:210:0x062f, B:211:0x063c, B:215:0x0667, B:212:0x0644, B:214:0x0654, B:216:0x0672, B:217:0x068c, B:219:0x0692, B:221:0x06a5, B:222:0x06b2, B:223:0x06b6, B:225:0x06bc, B:227:0x06cc, B:165:0x04f8, B:167:0x0504, B:170:0x0515, B:172:0x0528, B:174:0x0534, B:176:0x0542, B:178:0x0551, B:180:0x055b, B:182:0x0567, B:184:0x0571, B:187:0x057e, B:189:0x0584, B:191:0x0594, B:192:0x059f, B:133:0x0430, B:135:0x043c, B:137:0x0448, B:149:0x048d, B:141:0x0465, B:144:0x0477, B:146:0x047d, B:148:0x0487, B:99:0x0326, B:101:0x035d, B:102:0x0378, B:104:0x037e, B:106:0x038e, B:110:0x03a4, B:107:0x0398, B:113:0x03ab, B:116:0x03b3, B:117:0x03cc, B:34:0x0122, B:36:0x012f, B:38:0x013b, B:40:0x0141, B:44:0x014c, B:231:0x06f6, B:233:0x0704, B:235:0x070d, B:246:0x073d, B:236:0x0715, B:238:0x071e, B:240:0x0724, B:243:0x0730, B:245:0x0738, B:247:0x0740, B:248:0x074c, B:251:0x0754, B:253:0x0766, B:254:0x0771, B:256:0x0779, B:260:0x079f, B:262:0x07b9, B:264:0x07ce, B:266:0x07e8, B:268:0x07fd, B:269:0x080b, B:271:0x0811, B:273:0x0821, B:274:0x0828, B:276:0x0834, B:277:0x083b, B:278:0x083e, B:280:0x0880, B:282:0x0886, B:288:0x08ad, B:290:0x08b5, B:291:0x08be, B:293:0x08c4, B:294:0x08ca, B:296:0x08df, B:298:0x08ef, B:300:0x08ff, B:302:0x0907, B:303:0x090a, B:311:0x097e, B:313:0x0997, B:315:0x09ad, B:317:0x09b2, B:319:0x09b6, B:321:0x09ba, B:323:0x09c4, B:324:0x09ca, B:326:0x09ce, B:328:0x09d4, B:329:0x09e2, B:330:0x09eb, B:335:0x0a0e, B:338:0x0a14, B:283:0x0894, B:285:0x089a, B:287:0x08a0, B:267:0x07fa, B:263:0x07cb, B:257:0x077f, B:259:0x0785), top: B:478:0x0011, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0283 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02b1 A[Catch: all -> 0x0e15, TryCatch #1 {all -> 0x0e15, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005a, B:15:0x0082, B:17:0x00b7, B:20:0x00c8, B:22:0x00d2, B:228:0x06e0, B:25:0x0100, B:28:0x0112, B:30:0x0118, B:45:0x015a, B:47:0x0168, B:50:0x0188, B:52:0x018e, B:54:0x019e, B:56:0x01ac, B:58:0x01bc, B:59:0x01c9, B:60:0x01cc, B:63:0x01e2, B:74:0x0210, B:77:0x021a, B:79:0x0228, B:85:0x0278, B:80:0x0245, B:82:0x0255, B:89:0x0285, B:91:0x02b1, B:92:0x02db, B:94:0x0314, B:96:0x031a, B:119:0x03e7, B:120:0x03f3, B:123:0x0401, B:129:0x0424, B:126:0x0413, B:152:0x04ab, B:154:0x04b5, B:157:0x04c6, B:159:0x04d9, B:161:0x04e5, B:194:0x05a5, B:196:0x05ab, B:197:0x05b7, B:199:0x05bd, B:201:0x05cd, B:203:0x05d7, B:204:0x05ea, B:206:0x05f0, B:207:0x060b, B:209:0x0611, B:210:0x062f, B:211:0x063c, B:215:0x0667, B:212:0x0644, B:214:0x0654, B:216:0x0672, B:217:0x068c, B:219:0x0692, B:221:0x06a5, B:222:0x06b2, B:223:0x06b6, B:225:0x06bc, B:227:0x06cc, B:165:0x04f8, B:167:0x0504, B:170:0x0515, B:172:0x0528, B:174:0x0534, B:176:0x0542, B:178:0x0551, B:180:0x055b, B:182:0x0567, B:184:0x0571, B:187:0x057e, B:189:0x0584, B:191:0x0594, B:192:0x059f, B:133:0x0430, B:135:0x043c, B:137:0x0448, B:149:0x048d, B:141:0x0465, B:144:0x0477, B:146:0x047d, B:148:0x0487, B:99:0x0326, B:101:0x035d, B:102:0x0378, B:104:0x037e, B:106:0x038e, B:110:0x03a4, B:107:0x0398, B:113:0x03ab, B:116:0x03b3, B:117:0x03cc, B:34:0x0122, B:36:0x012f, B:38:0x013b, B:40:0x0141, B:44:0x014c, B:231:0x06f6, B:233:0x0704, B:235:0x070d, B:246:0x073d, B:236:0x0715, B:238:0x071e, B:240:0x0724, B:243:0x0730, B:245:0x0738, B:247:0x0740, B:248:0x074c, B:251:0x0754, B:253:0x0766, B:254:0x0771, B:256:0x0779, B:260:0x079f, B:262:0x07b9, B:264:0x07ce, B:266:0x07e8, B:268:0x07fd, B:269:0x080b, B:271:0x0811, B:273:0x0821, B:274:0x0828, B:276:0x0834, B:277:0x083b, B:278:0x083e, B:280:0x0880, B:282:0x0886, B:288:0x08ad, B:290:0x08b5, B:291:0x08be, B:293:0x08c4, B:294:0x08ca, B:296:0x08df, B:298:0x08ef, B:300:0x08ff, B:302:0x0907, B:303:0x090a, B:311:0x097e, B:313:0x0997, B:315:0x09ad, B:317:0x09b2, B:319:0x09b6, B:321:0x09ba, B:323:0x09c4, B:324:0x09ca, B:326:0x09ce, B:328:0x09d4, B:329:0x09e2, B:330:0x09eb, B:335:0x0a0e, B:338:0x0a14, B:283:0x0894, B:285:0x089a, B:287:0x08a0, B:267:0x07fa, B:263:0x07cb, B:257:0x077f, B:259:0x0785), top: B:478:0x0011, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0314 A[Catch: all -> 0x0e15, TryCatch #1 {all -> 0x0e15, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005a, B:15:0x0082, B:17:0x00b7, B:20:0x00c8, B:22:0x00d2, B:228:0x06e0, B:25:0x0100, B:28:0x0112, B:30:0x0118, B:45:0x015a, B:47:0x0168, B:50:0x0188, B:52:0x018e, B:54:0x019e, B:56:0x01ac, B:58:0x01bc, B:59:0x01c9, B:60:0x01cc, B:63:0x01e2, B:74:0x0210, B:77:0x021a, B:79:0x0228, B:85:0x0278, B:80:0x0245, B:82:0x0255, B:89:0x0285, B:91:0x02b1, B:92:0x02db, B:94:0x0314, B:96:0x031a, B:119:0x03e7, B:120:0x03f3, B:123:0x0401, B:129:0x0424, B:126:0x0413, B:152:0x04ab, B:154:0x04b5, B:157:0x04c6, B:159:0x04d9, B:161:0x04e5, B:194:0x05a5, B:196:0x05ab, B:197:0x05b7, B:199:0x05bd, B:201:0x05cd, B:203:0x05d7, B:204:0x05ea, B:206:0x05f0, B:207:0x060b, B:209:0x0611, B:210:0x062f, B:211:0x063c, B:215:0x0667, B:212:0x0644, B:214:0x0654, B:216:0x0672, B:217:0x068c, B:219:0x0692, B:221:0x06a5, B:222:0x06b2, B:223:0x06b6, B:225:0x06bc, B:227:0x06cc, B:165:0x04f8, B:167:0x0504, B:170:0x0515, B:172:0x0528, B:174:0x0534, B:176:0x0542, B:178:0x0551, B:180:0x055b, B:182:0x0567, B:184:0x0571, B:187:0x057e, B:189:0x0584, B:191:0x0594, B:192:0x059f, B:133:0x0430, B:135:0x043c, B:137:0x0448, B:149:0x048d, B:141:0x0465, B:144:0x0477, B:146:0x047d, B:148:0x0487, B:99:0x0326, B:101:0x035d, B:102:0x0378, B:104:0x037e, B:106:0x038e, B:110:0x03a4, B:107:0x0398, B:113:0x03ab, B:116:0x03b3, B:117:0x03cc, B:34:0x0122, B:36:0x012f, B:38:0x013b, B:40:0x0141, B:44:0x014c, B:231:0x06f6, B:233:0x0704, B:235:0x070d, B:246:0x073d, B:236:0x0715, B:238:0x071e, B:240:0x0724, B:243:0x0730, B:245:0x0738, B:247:0x0740, B:248:0x074c, B:251:0x0754, B:253:0x0766, B:254:0x0771, B:256:0x0779, B:260:0x079f, B:262:0x07b9, B:264:0x07ce, B:266:0x07e8, B:268:0x07fd, B:269:0x080b, B:271:0x0811, B:273:0x0821, B:274:0x0828, B:276:0x0834, B:277:0x083b, B:278:0x083e, B:280:0x0880, B:282:0x0886, B:288:0x08ad, B:290:0x08b5, B:291:0x08be, B:293:0x08c4, B:294:0x08ca, B:296:0x08df, B:298:0x08ef, B:300:0x08ff, B:302:0x0907, B:303:0x090a, B:311:0x097e, B:313:0x0997, B:315:0x09ad, B:317:0x09b2, B:319:0x09b6, B:321:0x09ba, B:323:0x09c4, B:324:0x09ca, B:326:0x09ce, B:328:0x09d4, B:329:0x09e2, B:330:0x09eb, B:335:0x0a0e, B:338:0x0a14, B:283:0x0894, B:285:0x089a, B:287:0x08a0, B:267:0x07fa, B:263:0x07cb, B:257:0x077f, B:259:0x0785), top: B:478:0x0011, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0324 A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean zzaG(String str, long j) {
        zzpg zzpgVar;
        boolean z;
        int i;
        boolean z2;
        long j2;
        long parseLong;
        long j3;
        int zzm;
        long j4;
        zzpc zzpcVar;
        Boolean bool;
        com.google.android.gms.internal.measurement.zzic zzicVar;
        SecureRandom secureRandom;
        long zzaj;
        boolean z3;
        int i2;
        String str2;
        boolean zzk;
        String str3;
        boolean z4;
        String str4;
        zzpc zzpcVar2;
        int i3;
        int i4;
        String str5;
        int i5;
        int i6;
        int i7;
        int i8;
        zzpc zzpcVar3;
        int i9;
        boolean z5;
        boolean z6;
        int i10;
        boolean z7;
        com.google.android.gms.internal.measurement.zzhv zzhvVar;
        boolean z8;
        zzpg zzpgVar2 = this;
        zzpg zzpgVar3 = "_ai";
        String str6 = FirebaseAnalytics.Event.PURCHASE;
        String str7 = "items";
        zzpgVar2.zzj().zzb();
        try {
            zzpc zzpcVar4 = new zzpc(zzpgVar2, null);
            zzpgVar2.zzj().zzat(str, j, zzpgVar2.zzB, zzpcVar4);
            List list = zzpcVar4.zzc;
            try {
                if (list != null && !list.isEmpty()) {
                    com.google.android.gms.internal.measurement.zzic zzicVar2 = (com.google.android.gms.internal.measurement.zzic) zzpcVar4.zza.zzcl();
                    zzicVar2.zzi();
                    com.google.android.gms.internal.measurement.zzhr zzhrVar = null;
                    com.google.android.gms.internal.measurement.zzhr zzhrVar2 = null;
                    int i11 = -1;
                    int i12 = 0;
                    int i13 = 0;
                    boolean z9 = false;
                    boolean z10 = false;
                    int i14 = -1;
                    String str8 = "_ai";
                    while (true) {
                        i = i13;
                        boolean z11 = z9;
                        z2 = z10;
                        com.google.android.gms.internal.measurement.zzhr zzhrVar3 = zzhrVar;
                        if (i12 >= zzpcVar4.zzc.size()) {
                            break;
                        }
                        com.google.android.gms.internal.measurement.zzhr zzhrVar4 = (com.google.android.gms.internal.measurement.zzhr) ((com.google.android.gms.internal.measurement.zzhs) zzpcVar4.zzc.get(i12)).zzcl();
                        int i15 = i12;
                        if (zzpgVar2.zzh().zzj(zzpcVar4.zza.zzA(), zzhrVar4.zzk())) {
                            zzpgVar2.zzaV().zze().zzc("Dropping blocked raw event. appId", zzgu.zzl(zzpcVar4.zza.zzA()), zzpgVar2.zzn.zzl().zza(zzhrVar4.zzk()));
                            if (!zzpgVar2.zzh().zzn(zzpcVar4.zza.zzA()) && !zzpgVar2.zzh().zzo(zzpcVar4.zza.zzA()) && !"_err".equals(zzhrVar4.zzk())) {
                                zzpgVar2.zzt().zzN(zzpgVar2.zzK, zzpcVar4.zza.zzA(), 11, "_ev", zzhrVar4.zzk(), 0);
                            }
                            str3 = str8;
                            str4 = str6;
                            str5 = str7;
                            i4 = i11;
                            zzhrVar = zzhrVar3;
                            i5 = i15;
                            i6 = i;
                        } else {
                            String zzk2 = zzhrVar4.zzk();
                            String str9 = str7;
                            if (!zzk2.equals(str6) && !zzk2.equals("_iap") && !zzk2.equals("ecommerce_purchase")) {
                                i2 = i14;
                                if (zzhrVar4.zzk().equals(zzjm.zza(str8))) {
                                    zzhrVar4.zzl(str8);
                                    zzpgVar2.zzaV().zzk().zza("Renaming ad_impression to _ai");
                                    if (Log.isLoggable(zzpgVar2.zzaV().zzn(), 5)) {
                                        for (int i16 = 0; i16 < zzhrVar4.zzb(); i16++) {
                                            if (FirebaseAnalytics.Param.AD_PLATFORM.equals(zzhrVar4.zzc(i16).zzb()) && !zzhrVar4.zzc(i16).zzd().isEmpty() && "admob".equalsIgnoreCase(zzhrVar4.zzc(i16).zzd())) {
                                                zzpgVar2.zzaV().zzh().zza("AdMob ad impression logged from app. Potentially duplicative.");
                                            }
                                        }
                                    }
                                }
                                zzk = zzpgVar2.zzh().zzk(zzpcVar4.zza.zzA(), zzhrVar4.zzk());
                                if (zzk) {
                                    str3 = str8;
                                } else {
                                    zzpgVar2.zzp();
                                    String zzk3 = zzhrVar4.zzk();
                                    Preconditions.checkNotEmpty(zzk3);
                                    str3 = str8;
                                    if (zzk3.hashCode() != 95027 || !zzk3.equals("_ui")) {
                                        str4 = str6;
                                        z4 = false;
                                        boolean z12222 = z2;
                                        if (z4) {
                                            zzpcVar2 = zzpcVar4;
                                            z2 = z12222;
                                        } else {
                                            ArrayList arrayList = new ArrayList(zzhrVar4.zza());
                                            int i17 = 0;
                                            int i18 = -1;
                                            int i19 = -1;
                                            while (true) {
                                                z2 = z12222;
                                                zzpcVar2 = zzpcVar4;
                                                if (i17 >= arrayList.size()) {
                                                    break;
                                                }
                                                if ("value".equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i17)).zzb())) {
                                                    i18 = i17;
                                                } else if (FirebaseAnalytics.Param.CURRENCY.equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i17)).zzb())) {
                                                    i19 = i17;
                                                }
                                                i17++;
                                                z12222 = z2;
                                                zzpcVar4 = zzpcVar2;
                                            }
                                            if (i18 != -1) {
                                                if (((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i18)).zze() || ((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i18)).zzi()) {
                                                    if (i19 != -1) {
                                                        String zzd = ((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i19)).zzd();
                                                        if (zzd.length() == 3) {
                                                            int i20 = 0;
                                                            while (i20 < zzd.length()) {
                                                                int codePointAt = zzd.codePointAt(i20);
                                                                if (Character.isLetter(codePointAt)) {
                                                                    i20 += Character.charCount(codePointAt);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    zzpgVar2.zzaV().zzh().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                                    zzhrVar4.zzj(i18);
                                                    zzaB(zzhrVar4, "_c");
                                                    zzaA(zzhrVar4, 19, FirebaseAnalytics.Param.CURRENCY);
                                                    break;
                                                }
                                                zzpgVar2.zzaV().zzh().zza("Value must be specified with a numeric type.");
                                                zzhrVar4.zzj(i18);
                                                zzaB(zzhrVar4, "_c");
                                                zzaA(zzhrVar4, 18, "value");
                                            }
                                            if ("_e".equals(zzhrVar4.zzk())) {
                                                zzpgVar2.zzp();
                                                if (zzpk.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar4.zzbc(), "_fr") == null) {
                                                    if (zzhrVar2 != null && Math.abs(zzhrVar2.zzn() - zzhrVar4.zzn()) <= 1000) {
                                                        com.google.android.gms.internal.measurement.zzhr zzhrVar5 = (com.google.android.gms.internal.measurement.zzhr) zzhrVar2.zzaR();
                                                        if (zzpgVar2.zzaI(zzhrVar4, zzhrVar5)) {
                                                            zzicVar2.zzf(i11, zzhrVar5);
                                                            i14 = i2;
                                                            zzhrVar = null;
                                                            zzhrVar2 = null;
                                                            if (zzhrVar4.zzb() != 0) {
                                                                zzpgVar2.zzp();
                                                                Bundle zzE = zzpk.zzE(zzhrVar4.zza());
                                                                int i21 = 0;
                                                                while (i21 < zzhrVar4.zzb()) {
                                                                    com.google.android.gms.internal.measurement.zzhw zzc = zzhrVar4.zzc(i21);
                                                                    String str10 = str9;
                                                                    if (!zzc.zzb().equals(str10) || zzc.zzk().isEmpty()) {
                                                                        i7 = i21;
                                                                        i8 = i11;
                                                                        zzpcVar3 = zzpcVar2;
                                                                        if (!zzc.zzb().equals(str10)) {
                                                                            zzpgVar2.zzU(zzhrVar4.zzk(), (com.google.android.gms.internal.measurement.zzhv) zzc.zzcl(), zzE, zzpcVar3.zza.zzA());
                                                                        }
                                                                    } else {
                                                                        zzpcVar3 = zzpcVar2;
                                                                        String zzA = zzpcVar3.zza.zzA();
                                                                        List zzk4 = zzc.zzk();
                                                                        Bundle[] bundleArr = new Bundle[zzk4.size()];
                                                                        int i22 = 0;
                                                                        while (i22 < zzk4.size()) {
                                                                            com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) zzk4.get(i22);
                                                                            zzpgVar2.zzp();
                                                                            Bundle zzE2 = zzpk.zzE(zzhwVar.zzk());
                                                                            for (com.google.android.gms.internal.measurement.zzhw zzhwVar2 : zzhwVar.zzk()) {
                                                                                zzpgVar2.zzU(zzhrVar4.zzk(), (com.google.android.gms.internal.measurement.zzhv) zzhwVar2.zzcl(), zzE2, zzA);
                                                                                i21 = i21;
                                                                                i11 = i11;
                                                                            }
                                                                            bundleArr[i22] = zzE2;
                                                                            i22++;
                                                                            i21 = i21;
                                                                            i11 = i11;
                                                                        }
                                                                        i7 = i21;
                                                                        i8 = i11;
                                                                        zzE.putParcelableArray(str10, bundleArr);
                                                                    }
                                                                    i21 = i7 + 1;
                                                                    str9 = str10;
                                                                    zzpcVar2 = zzpcVar3;
                                                                    i11 = i8;
                                                                }
                                                                i4 = i11;
                                                                str5 = str9;
                                                                zzpcVar4 = zzpcVar2;
                                                                zzhrVar4.zzi();
                                                                zzpk zzp = zzpgVar2.zzp();
                                                                ArrayList<com.google.android.gms.internal.measurement.zzhw> arrayList2 = new ArrayList();
                                                                for (String str11 : zzE.keySet()) {
                                                                    com.google.android.gms.internal.measurement.zzhv zzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                                                                    zzn.zzb(str11);
                                                                    Object obj = zzE.get(str11);
                                                                    if (obj != null) {
                                                                        zzp.zzd(zzn, obj);
                                                                        arrayList2.add((com.google.android.gms.internal.measurement.zzhw) zzn.zzbc());
                                                                    }
                                                                }
                                                                for (com.google.android.gms.internal.measurement.zzhw zzhwVar3 : arrayList2) {
                                                                    zzhrVar4.zzf(zzhwVar3);
                                                                }
                                                            } else {
                                                                i4 = i11;
                                                                str5 = str9;
                                                                zzpcVar4 = zzpcVar2;
                                                            }
                                                            i5 = i15;
                                                            zzpcVar4.zzc.set(i5, (com.google.android.gms.internal.measurement.zzhs) zzhrVar4.zzbc());
                                                            zzicVar2.zzg(zzhrVar4);
                                                            i6 = i + 1;
                                                        }
                                                    }
                                                    i14 = i;
                                                    zzhrVar = zzhrVar4;
                                                    if (zzhrVar4.zzb() != 0) {
                                                    }
                                                    i5 = i15;
                                                    zzpcVar4.zzc.set(i5, (com.google.android.gms.internal.measurement.zzhs) zzhrVar4.zzbc());
                                                    zzicVar2.zzg(zzhrVar4);
                                                    i6 = i + 1;
                                                }
                                                i3 = i2;
                                                i14 = i3;
                                                zzhrVar = zzhrVar3;
                                                if (zzhrVar4.zzb() != 0) {
                                                }
                                                i5 = i15;
                                                zzpcVar4.zzc.set(i5, (com.google.android.gms.internal.measurement.zzhs) zzhrVar4.zzbc());
                                                zzicVar2.zzg(zzhrVar4);
                                                i6 = i + 1;
                                            } else {
                                                if ("_vs".equals(zzhrVar4.zzk())) {
                                                    zzpgVar2.zzp();
                                                    if (zzpk.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar4.zzbc(), "_et") == null) {
                                                        if (zzhrVar3 != null && Math.abs(zzhrVar3.zzn() - zzhrVar4.zzn()) <= 1000) {
                                                            com.google.android.gms.internal.measurement.zzhr zzhrVar6 = (com.google.android.gms.internal.measurement.zzhr) zzhrVar3.zzaR();
                                                            if (zzpgVar2.zzaI(zzhrVar6, zzhrVar4)) {
                                                                int i23 = i2;
                                                                zzicVar2.zzf(i23, zzhrVar6);
                                                                i14 = i23;
                                                                zzhrVar = null;
                                                                zzhrVar2 = null;
                                                                if (zzhrVar4.zzb() != 0) {
                                                                }
                                                                i5 = i15;
                                                                zzpcVar4.zzc.set(i5, (com.google.android.gms.internal.measurement.zzhs) zzhrVar4.zzbc());
                                                                zzicVar2.zzg(zzhrVar4);
                                                                i6 = i + 1;
                                                            }
                                                        }
                                                        i3 = i2;
                                                        i11 = i;
                                                        zzhrVar2 = zzhrVar4;
                                                    }
                                                    i3 = i2;
                                                } else {
                                                    i3 = i2;
                                                    if (zzpgVar2.zzd().zzp(null, zzfy.zzbj) && (("_f".equals(zzhrVar4.zzk()) || "_v".equals(zzhrVar4.zzk())) && ("_f".equals(zzhrVar4.zzk()) || "_v".equals(zzhrVar4.zzk())))) {
                                                        int i24 = 0;
                                                        while (true) {
                                                            if (i24 >= zzhrVar4.zzb()) {
                                                                break;
                                                            }
                                                            com.google.android.gms.internal.measurement.zzhw zzc2 = zzhrVar4.zzc(i24);
                                                            if ("_elt".equals(zzc2.zzb())) {
                                                                zzhrVar4.zzr(zzc2.zzf());
                                                                zzhrVar4.zzj(i24);
                                                                break;
                                                            }
                                                            i24++;
                                                        }
                                                    }
                                                }
                                                i14 = i3;
                                                zzhrVar = zzhrVar3;
                                                if (zzhrVar4.zzb() != 0) {
                                                }
                                                i5 = i15;
                                                zzpcVar4.zzc.set(i5, (com.google.android.gms.internal.measurement.zzhs) zzhrVar4.zzbc());
                                                zzicVar2.zzg(zzhrVar4);
                                                i6 = i + 1;
                                            }
                                        }
                                        if ("_e".equals(zzhrVar4.zzk())) {
                                        }
                                    }
                                }
                                str4 = str6;
                                i9 = 0;
                                z5 = false;
                                boolean z1322 = false;
                                while (true) {
                                    z4 = zzk;
                                    if (i9 >= zzhrVar4.zzb()) {
                                        break;
                                    }
                                    if ("_c".equals(zzhrVar4.zzc(i9).zzb())) {
                                        com.google.android.gms.internal.measurement.zzhv zzhvVar2 = (com.google.android.gms.internal.measurement.zzhv) zzhrVar4.zzc(i9).zzcl();
                                        z8 = z1322;
                                        zzhvVar2.zzf(1L);
                                        zzhrVar4.zzd(i9, (com.google.android.gms.internal.measurement.zzhw) zzhvVar2.zzbc());
                                        z5 = true;
                                    } else {
                                        z8 = z1322;
                                        if ("_r".equals(zzhrVar4.zzc(i9).zzb())) {
                                            com.google.android.gms.internal.measurement.zzhv zzhvVar3 = (com.google.android.gms.internal.measurement.zzhv) zzhrVar4.zzc(i9).zzcl();
                                            zzhvVar3.zzf(1L);
                                            zzhrVar4.zzd(i9, (com.google.android.gms.internal.measurement.zzhw) zzhvVar3.zzbc());
                                            z1322 = true;
                                            z5 = z5;
                                            i9++;
                                            zzk = z4;
                                        }
                                    }
                                    z1322 = z8;
                                    i9++;
                                    zzk = z4;
                                }
                                z6 = z1322;
                                if (!z5 && z4) {
                                    zzpgVar2.zzaV().zzk().zzb("Marking event as conversion", zzpgVar2.zzn.zzl().zza(zzhrVar4.zzk()));
                                    com.google.android.gms.internal.measurement.zzhv zzn22 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                    zzn22.zzb("_c");
                                    zzn22.zzf(1L);
                                    zzhrVar4.zzg(zzn22);
                                }
                                if (!z6) {
                                    zzpgVar2.zzaV().zzk().zzb("Marking event as real-time", zzpgVar2.zzn.zzl().zza(zzhrVar4.zzk()));
                                    com.google.android.gms.internal.measurement.zzhv zzn3 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                    zzn3.zzb("_r");
                                    zzn3.zzf(1L);
                                    zzhrVar4.zzg(zzn3);
                                }
                                if (zzpgVar2.zzj().zzw(zzpgVar2.zzC(), zzpcVar4.zza.zzA(), false, false, false, false, true, false, false).zze > zzpgVar2.zzd().zzm(zzpcVar4.zza.zzA(), zzfy.zzo)) {
                                    zzaB(zzhrVar4, "_r");
                                } else {
                                    z2 = true;
                                }
                                if (zzpp.zzh(zzhrVar4.zzk()) && z4 && zzpgVar2.zzj().zzw(zzpgVar2.zzC(), zzpcVar4.zza.zzA(), false, false, true, false, false, false, false).zzc > zzpgVar2.zzd().zzm(zzpcVar4.zza.zzA(), zzfy.zzn)) {
                                    zzpgVar2.zzaV().zze().zzb("Too many conversions. Not logging as conversion. appId", zzgu.zzl(zzpcVar4.zza.zzA()));
                                    i10 = 0;
                                    z7 = false;
                                    int i252 = -1;
                                    zzhvVar = null;
                                    while (i10 < zzhrVar4.zzb()) {
                                        com.google.android.gms.internal.measurement.zzhw zzc3 = zzhrVar4.zzc(i10);
                                        int i26 = i10;
                                        if ("_c".equals(zzc3.zzb())) {
                                            zzhvVar = (com.google.android.gms.internal.measurement.zzhv) zzc3.zzcl();
                                            i252 = i26;
                                        } else if ("_err".equals(zzc3.zzb())) {
                                            z7 = true;
                                        }
                                        i10 = i26 + 1;
                                    }
                                    if (z7) {
                                        if (zzhvVar != null) {
                                            zzhrVar4.zzj(i252);
                                        } else {
                                            zzhvVar = null;
                                        }
                                    }
                                    if (zzhvVar == null) {
                                        com.google.android.gms.internal.measurement.zzhv zzhvVar4 = (com.google.android.gms.internal.measurement.zzhv) zzhvVar.zzaR();
                                        zzhvVar4.zzb("_err");
                                        zzhvVar4.zzf(10L);
                                        zzhrVar4.zzd(i252, (com.google.android.gms.internal.measurement.zzhw) zzhvVar4.zzbc());
                                    } else {
                                        zzpgVar2.zzaV().zzb().zzb("Did not find conversion parameter. appId", zzgu.zzl(zzpcVar4.zza.zzA()));
                                    }
                                }
                                boolean z122222 = z2;
                                if (z4) {
                                }
                                if ("_e".equals(zzhrVar4.zzk())) {
                                }
                            }
                            com.google.android.gms.internal.measurement.zzhv zzn4 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            i2 = i14;
                            zzn4.zzb("_ct");
                            if (!z11) {
                                String zzA2 = zzpcVar4.zza.zzA();
                                if (zzpgVar2.zzaP(zzA2, str6) && zzpgVar2.zzaP(zzA2, "_iap") && zzpgVar2.zzaP(zzA2, "ecommerce_purchase")) {
                                    str2 = "new";
                                    zzn4.zzd(str2);
                                    zzhrVar4.zzf((com.google.android.gms.internal.measurement.zzhw) zzn4.zzbc());
                                    z11 = true;
                                    if (zzhrVar4.zzk().equals(zzjm.zza(str8))) {
                                    }
                                    zzk = zzpgVar2.zzh().zzk(zzpcVar4.zza.zzA(), zzhrVar4.zzk());
                                    if (zzk) {
                                    }
                                    str4 = str6;
                                    i9 = 0;
                                    z5 = false;
                                    boolean z13222 = false;
                                    while (true) {
                                        z4 = zzk;
                                        if (i9 >= zzhrVar4.zzb()) {
                                        }
                                        i9++;
                                        zzk = z4;
                                    }
                                    z6 = z13222;
                                    if (!z5) {
                                        zzpgVar2.zzaV().zzk().zzb("Marking event as conversion", zzpgVar2.zzn.zzl().zza(zzhrVar4.zzk()));
                                        com.google.android.gms.internal.measurement.zzhv zzn222 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                        zzn222.zzb("_c");
                                        zzn222.zzf(1L);
                                        zzhrVar4.zzg(zzn222);
                                    }
                                    if (!z6) {
                                    }
                                    if (zzpgVar2.zzj().zzw(zzpgVar2.zzC(), zzpcVar4.zza.zzA(), false, false, false, false, true, false, false).zze > zzpgVar2.zzd().zzm(zzpcVar4.zza.zzA(), zzfy.zzo)) {
                                    }
                                    if (zzpp.zzh(zzhrVar4.zzk())) {
                                        zzpgVar2.zzaV().zze().zzb("Too many conversions. Not logging as conversion. appId", zzgu.zzl(zzpcVar4.zza.zzA()));
                                        i10 = 0;
                                        z7 = false;
                                        int i2522 = -1;
                                        zzhvVar = null;
                                        while (i10 < zzhrVar4.zzb()) {
                                        }
                                        if (z7) {
                                        }
                                        if (zzhvVar == null) {
                                        }
                                    }
                                    boolean z1222222 = z2;
                                    if (z4) {
                                    }
                                    if ("_e".equals(zzhrVar4.zzk())) {
                                    }
                                }
                            }
                            str2 = "returning";
                            zzn4.zzd(str2);
                            zzhrVar4.zzf((com.google.android.gms.internal.measurement.zzhw) zzn4.zzbc());
                            z11 = true;
                            if (zzhrVar4.zzk().equals(zzjm.zza(str8))) {
                            }
                            zzk = zzpgVar2.zzh().zzk(zzpcVar4.zza.zzA(), zzhrVar4.zzk());
                            if (zzk) {
                            }
                            str4 = str6;
                            i9 = 0;
                            z5 = false;
                            boolean z132222 = false;
                            while (true) {
                                z4 = zzk;
                                if (i9 >= zzhrVar4.zzb()) {
                                }
                                i9++;
                                zzk = z4;
                            }
                            z6 = z132222;
                            if (!z5) {
                            }
                            if (!z6) {
                            }
                            if (zzpgVar2.zzj().zzw(zzpgVar2.zzC(), zzpcVar4.zza.zzA(), false, false, false, false, true, false, false).zze > zzpgVar2.zzd().zzm(zzpcVar4.zza.zzA(), zzfy.zzo)) {
                            }
                            if (zzpp.zzh(zzhrVar4.zzk())) {
                            }
                            boolean z12222222 = z2;
                            if (z4) {
                            }
                            if ("_e".equals(zzhrVar4.zzk())) {
                            }
                        }
                        z9 = z11;
                        z10 = z2;
                        i12 = i5 + 1;
                        str7 = str5;
                        i11 = i4;
                        str6 = str4;
                        i13 = i6;
                        str8 = str3;
                    }
                    long j5 = 0;
                    int i27 = i;
                    long j6 = 0;
                    int i28 = 0;
                    while (i28 < i27) {
                        com.google.android.gms.internal.measurement.zzhs zzd2 = zzicVar2.zzd(i28);
                        if ("_e".equals(zzd2.zzd())) {
                            zzpgVar2.zzp();
                            if (zzpk.zzF(zzd2, "_fr") != null) {
                                zzicVar2.zzj(i28);
                                i27--;
                                i28--;
                                i28++;
                            }
                        }
                        zzpgVar2.zzp();
                        com.google.android.gms.internal.measurement.zzhw zzF = zzpk.zzF(zzd2, "_et");
                        if (zzF != null) {
                            Long valueOf = zzF.zze() ? Long.valueOf(zzF.zzf()) : null;
                            if (valueOf != null && valueOf.longValue() > 0) {
                                j6 += valueOf.longValue();
                            }
                        }
                        i28++;
                    }
                    zzpgVar2.zzaH(zzicVar2, j6, false);
                    Iterator it = zzicVar2.zzb().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if ("_s".equals(((com.google.android.gms.internal.measurement.zzhs) it.next()).zzd())) {
                                zzpgVar2.zzj().zzk(zzicVar2.zzK(), "_se");
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (zzpk.zzx(zzicVar2, "_sid") >= 0) {
                        zzpgVar2.zzaH(zzicVar2, j6, true);
                    } else {
                        int zzx = zzpk.zzx(zzicVar2, "_se");
                        if (zzx >= 0) {
                            zzicVar2.zzr(zzx);
                            zzpgVar2.zzaV().zzb().zzb("Session engagement user property is in the bundle without session ID. appId", zzgu.zzl(zzpcVar4.zza.zzA()));
                        }
                    }
                    String zzA3 = zzpcVar4.zza.zzA();
                    zzpgVar2.zzaW().zzg();
                    zzpgVar2.zzu();
                    zzh zzu = zzpgVar2.zzj().zzu(zzA3);
                    if (zzu == null) {
                        zzpgVar2.zzaV().zzb().zzb("Cannot fix consent fields without appInfo. appId", zzgu.zzl(zzA3));
                    } else {
                        zzpgVar2.zzI(zzu, zzicVar2);
                    }
                    String zzA4 = zzpcVar4.zza.zzA();
                    zzpgVar2.zzaW().zzg();
                    zzpgVar2.zzu();
                    zzh zzu2 = zzpgVar2.zzj().zzu(zzA4);
                    if (zzu2 == null) {
                        zzpgVar2.zzaV().zze().zzb("Cannot populate ad_campaign_info without appInfo. appId", zzgu.zzl(zzA4));
                    } else {
                        zzpgVar2.zzJ(zzu2, zzicVar2);
                    }
                    zzicVar2.zzv(Long.MAX_VALUE);
                    zzicVar2.zzx(Long.MIN_VALUE);
                    for (int i29 = 0; i29 < zzicVar2.zzc(); i29++) {
                        com.google.android.gms.internal.measurement.zzhs zzd3 = zzicVar2.zzd(i29);
                        if (zzd3.zzf() < zzicVar2.zzu()) {
                            zzicVar2.zzv(zzd3.zzf());
                        }
                        if (zzd3.zzf() > zzicVar2.zzw()) {
                            zzicVar2.zzx(zzd3.zzf());
                        }
                    }
                    zzicVar2.zzak();
                    zzjl zzjlVar = zzjl.zza;
                    zzjl zzs = zzpgVar2.zzB(zzpcVar4.zza.zzA()).zzs(zzjl.zzf(zzpcVar4.zza.zzaf(), 100));
                    zzjl zzad = zzpgVar2.zzj().zzad(zzpcVar4.zza.zzA());
                    zzpgVar2.zzj().zzac(zzpcVar4.zza.zzA(), zzs);
                    zzjk zzjkVar = zzjk.ANALYTICS_STORAGE;
                    if (zzs.zzo(zzjkVar) || !zzad.zzo(zzjkVar)) {
                        if (zzs.zzo(zzjkVar) && !zzad.zzo(zzjkVar)) {
                            zzpgVar2.zzj().zzj(zzpcVar4.zza.zzA());
                        }
                    } else {
                        zzpgVar2.zzj().zzi(zzpcVar4.zza.zzA());
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
                    zzqp.zza();
                    if (zzpgVar2.zzd().zzp(zzpcVar4.zza.zzA(), zzfy.zzaP) && zzpgVar2.zzt().zzX(zzpcVar4.zza.zzA()) && zzpgVar2.zzB(zzpcVar4.zza.zzA()).zzo(zzjkVar2) && zzpcVar4.zza.zzak()) {
                        zzpgVar2.zzT(zzicVar2, zzpcVar4);
                    }
                    zzicVar2.zzag();
                    zzicVar2.zzaf(zzpgVar2.zzm().zzb(zzicVar2.zzK(), zzicVar2.zzb(), zzicVar2.zzk(), Long.valueOf(zzicVar2.zzu()), Long.valueOf(zzicVar2.zzw()), !zzs.zzo(zzjkVar)));
                    if (zzpgVar2.zzd().zzD(zzpcVar4.zza.zzA())) {
                        try {
                            HashMap hashMap = new HashMap();
                            ArrayList arrayList3 = new ArrayList();
                            SecureRandom zzf = zzpgVar2.zzt().zzf();
                            int i30 = 0;
                            while (i30 < zzicVar2.zzc()) {
                                com.google.android.gms.internal.measurement.zzhr zzhrVar7 = (com.google.android.gms.internal.measurement.zzhr) zzicVar2.zzd(i30).zzcl();
                                if (zzhrVar7.zzk().equals("_ep")) {
                                    zzpgVar2.zzp();
                                    String str12 = (String) zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar7.zzbc(), "_en");
                                    zzbc zzbcVar = (zzbc) hashMap.get(str12);
                                    if (zzbcVar == null && (zzbcVar = zzpgVar2.zzj().zzf(zzpcVar4.zza.zzA(), (String) Preconditions.checkNotNull(str12))) != null) {
                                        hashMap.put(str12, zzbcVar);
                                    }
                                    if (zzbcVar != null && zzbcVar.zzi == null) {
                                        Long l = zzbcVar.zzj;
                                        if (l != null && l.longValue() > 1) {
                                            zzpgVar2.zzp();
                                            zzpk.zzC(zzhrVar7, "_sr", l);
                                        }
                                        Boolean bool2 = zzbcVar.zzk;
                                        if (bool2 != null && bool2.booleanValue()) {
                                            zzpgVar2.zzp();
                                            zzpk.zzC(zzhrVar7, "_efs", 1L);
                                        }
                                        arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar7.zzbc());
                                    }
                                    zzicVar2.zzf(i30, zzhrVar7);
                                    j3 = j5;
                                    secureRandom = zzf;
                                    zzpcVar = zzpcVar4;
                                } else {
                                    zzht zzh = zzpgVar2.zzh();
                                    String zzA5 = zzpcVar4.zza.zzA();
                                    String zza = zzh.zza(zzA5, "measurement.account.time_zone_offset_minutes");
                                    if (!TextUtils.isEmpty(zza)) {
                                        try {
                                            parseLong = Long.parseLong(zza);
                                        } catch (NumberFormatException e) {
                                            zzh.zzu.zzaV().zze().zzc("Unable to parse timezone offset. appId", zzgu.zzl(zzA5), e);
                                        }
                                        j3 = j5;
                                        long zzaj22 = zzpgVar2.zzt().zzaj(zzhrVar7.zzn(), parseLong);
                                        com.google.android.gms.internal.measurement.zzhs zzhsVar2 = (com.google.android.gms.internal.measurement.zzhs) zzhrVar7.zzbc();
                                        Long l22 = 1L;
                                        if (!TextUtils.isEmpty("_dbg")) {
                                            Iterator it2 = zzhsVar2.zza().iterator();
                                            while (true) {
                                                if (!it2.hasNext()) {
                                                    break;
                                                }
                                                com.google.android.gms.internal.measurement.zzhw zzhwVar4 = (com.google.android.gms.internal.measurement.zzhw) it2.next();
                                                if ("_dbg".equals(zzhwVar4.zzb())) {
                                                    if (l22.equals(Long.valueOf(zzhwVar4.zzf()))) {
                                                        zzm = 1;
                                                    }
                                                }
                                            }
                                        }
                                        zzm = zzh().zzm(zzpcVar4.zza.zzA(), zzhrVar7.zzk());
                                        if (zzm > 0) {
                                            zzaV().zze().zzc("Sample rate must be positive. event, rate", zzhrVar7.zzk(), Integer.valueOf(zzm));
                                            arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar7.zzbc());
                                            zzicVar2.zzf(i30, zzhrVar7);
                                        } else {
                                            zzbc zzbcVar2 = (zzbc) hashMap.get(zzhrVar7.zzk());
                                            if (zzbcVar2 == null && (zzbcVar2 = zzj().zzf(zzpcVar4.zza.zzA(), zzhrVar7.zzk())) == null) {
                                                j4 = parseLong;
                                                zzaV().zze().zzc("Event being bundled has no eventAggregate. appId, eventName", zzpcVar4.zza.zzA(), zzhrVar7.zzk());
                                                zzbcVar2 = new zzbc(zzpcVar4.zza.zzA(), zzhrVar7.zzk(), 1L, 1L, 1L, zzhrVar7.zzn(), 0L, null, null, null, null);
                                            } else {
                                                j4 = parseLong;
                                            }
                                            zzp();
                                            Long l3 = (Long) zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar7.zzbc(), "_eid");
                                            Boolean valueOf2 = Boolean.valueOf(l3 != null);
                                            if (zzm == 1) {
                                                arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar7.zzbc());
                                                if (valueOf2.booleanValue() && (zzbcVar2.zzi != null || zzbcVar2.zzj != null || zzbcVar2.zzk != null)) {
                                                    hashMap.put(zzhrVar7.zzk(), zzbcVar2.zzc(null, null, null));
                                                }
                                                zzicVar2.zzf(i30, zzhrVar7);
                                            } else {
                                                if (zzf.nextInt(zzm) == 0) {
                                                    zzp();
                                                    Long valueOf3 = Long.valueOf(zzm);
                                                    zzpk.zzC(zzhrVar7, "_sr", valueOf3);
                                                    arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar7.zzbc());
                                                    if (valueOf2.booleanValue()) {
                                                        zzbcVar2 = zzbcVar2.zzc(null, valueOf3, null);
                                                    }
                                                    hashMap.put(zzhrVar7.zzk(), zzbcVar2.zzb(zzhrVar7.zzn(), zzaj22));
                                                    secureRandom = zzf;
                                                    zzpcVar = zzpcVar4;
                                                } else {
                                                    Long l4 = zzbcVar2.zzh;
                                                    if (l4 != null) {
                                                        zzicVar = zzicVar2;
                                                        secureRandom = zzf;
                                                        zzpcVar = zzpcVar4;
                                                        zzaj = l4.longValue();
                                                        bool = valueOf2;
                                                    } else {
                                                        zzpcVar = zzpcVar4;
                                                        bool = valueOf2;
                                                        zzicVar = zzicVar2;
                                                        secureRandom = zzf;
                                                        zzaj = zzt().zzaj(zzhrVar7.zzp(), j4);
                                                    }
                                                    if (zzaj != zzaj22) {
                                                        zzp();
                                                        zzpk.zzC(zzhrVar7, "_efs", 1L);
                                                        zzp();
                                                        Long valueOf4 = Long.valueOf(zzm);
                                                        zzpk.zzC(zzhrVar7, "_sr", valueOf4);
                                                        arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar7.zzbc());
                                                        if (bool.booleanValue()) {
                                                            zzbcVar2 = zzbcVar2.zzc(null, valueOf4, true);
                                                        }
                                                        hashMap.put(zzhrVar7.zzk(), zzbcVar2.zzb(zzhrVar7.zzn(), zzaj22));
                                                    } else if (bool.booleanValue()) {
                                                        hashMap.put(zzhrVar7.zzk(), zzbcVar2.zzc(l3, null, null));
                                                    }
                                                    zzicVar2 = zzicVar;
                                                }
                                                zzicVar2.zzf(i30, zzhrVar7);
                                            }
                                        }
                                        secureRandom = zzf;
                                        zzpcVar = zzpcVar4;
                                    }
                                    parseLong = j5;
                                    j3 = j5;
                                    long zzaj222 = zzpgVar2.zzt().zzaj(zzhrVar7.zzn(), parseLong);
                                    com.google.android.gms.internal.measurement.zzhs zzhsVar22 = (com.google.android.gms.internal.measurement.zzhs) zzhrVar7.zzbc();
                                    Long l222 = 1L;
                                    if (!TextUtils.isEmpty("_dbg")) {
                                    }
                                    zzm = zzh().zzm(zzpcVar4.zza.zzA(), zzhrVar7.zzk());
                                    if (zzm > 0) {
                                    }
                                    secureRandom = zzf;
                                    zzpcVar = zzpcVar4;
                                }
                                i30++;
                                zzpgVar2 = this;
                                j5 = j3;
                                zzf = secureRandom;
                                zzpcVar4 = zzpcVar;
                            }
                            j2 = j5;
                            zzpc zzpcVar5 = zzpcVar4;
                            if (arrayList3.size() < zzicVar2.zzc()) {
                                zzicVar2.zzi();
                                zzicVar2.zzh(arrayList3);
                            }
                            for (Map.Entry entry : hashMap.entrySet()) {
                                zzj().zzh((zzbc) entry.getValue());
                            }
                            zzpcVar4 = zzpcVar5;
                        } catch (Throwable th) {
                            th = th;
                            zzpgVar3 = this;
                            zzpgVar3.zzj().zzd();
                            throw th;
                        }
                    } else {
                        j2 = 0;
                    }
                    String zzA6 = zzpcVar4.zza.zzA();
                    zzh zzu3 = zzj().zzu(zzA6);
                    if (zzu3 == null) {
                        zzaV().zzb().zzb("Bundling raw events w/o app info. appId", zzgu.zzl(zzpcVar4.zza.zzA()));
                    } else if (zzicVar2.zzc() > 0) {
                        long zzp2 = zzu3.zzp();
                        if (zzp2 != j2) {
                            zzicVar2.zzA(zzp2);
                        } else {
                            zzicVar2.zzB();
                        }
                        long zzn5 = zzu3.zzn();
                        if (zzn5 != j2) {
                            zzp2 = zzn5;
                        }
                        if (zzp2 != j2) {
                            zzicVar2.zzy(zzp2);
                        } else {
                            zzicVar2.zzz();
                        }
                        zzu3.zzM(zzicVar2.zzc());
                        zzicVar2.zzaJ((int) zzu3.zzaF());
                        zzicVar2.zzZ((int) zzu3.zzG());
                        zzu3.zzo(zzicVar2.zzu());
                        zzu3.zzq(zzicVar2.zzw());
                        String zzaa = zzu3.zzaa();
                        if (zzaa != null) {
                            zzicVar2.zzaa(zzaa);
                        } else {
                            zzicVar2.zzab();
                        }
                        zzj().zzv(zzu3, false, false);
                    }
                    if (zzicVar2.zzc() > 0) {
                        zzpgVar = this;
                        zzpgVar.zzn.zzaU();
                        com.google.android.gms.internal.measurement.zzgl zzb2 = zzpgVar.zzh().zzb(zzpcVar4.zza.zzA());
                        if (zzb2 != null && zzb2.zza()) {
                            zzicVar2.zzal(zzb2.zzb());
                            zzpgVar.zzj().zzz((com.google.android.gms.internal.measurement.zzid) zzicVar2.zzbc(), z2);
                        }
                        if (zzpcVar4.zza.zzP().isEmpty()) {
                            zzicVar2.zzal(-1L);
                        } else {
                            zzpgVar.zzaV().zze().zzb("Did not find measurement config or missing version info. appId", zzgu.zzl(zzpcVar4.zza.zzA()));
                        }
                        zzpgVar.zzj().zzz((com.google.android.gms.internal.measurement.zzid) zzicVar2.zzbc(), z2);
                    } else {
                        zzpgVar = this;
                    }
                    zzav zzj = zzpgVar.zzj();
                    List list2 = zzpcVar4.zzb;
                    Preconditions.checkNotNull(list2);
                    zzj.zzg();
                    zzj.zzaw();
                    StringBuilder sb = new StringBuilder("rowid in (");
                    for (int i31 = 0; i31 < list2.size(); i31++) {
                        if (i31 != 0) {
                            sb.append(StringUtils.COMMA);
                        }
                        sb.append(((Long) list2.get(i31)).longValue());
                    }
                    sb.append(")");
                    int delete = zzj.zze().delete("raw_events", sb.toString(), null);
                    if (delete != list2.size()) {
                        zzj.zzu.zzaV().zzb().zzc("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list2.size()));
                    }
                    zzav zzj2 = zzpgVar.zzj();
                    SQLiteDatabase zze = zzj2.zze();
                    try {
                        String[] strArr = new String[2];
                        strArr[0] = zzA6;
                        z3 = true;
                        try {
                            strArr[1] = zzA6;
                            zze.execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", strArr);
                        } catch (SQLiteException e2) {
                            e = e2;
                            zzj2.zzu.zzaV().zzb().zzc("Failed to remove unused event metadata. appId", zzgu.zzl(zzA6), e);
                            zzpgVar.zzj().zzc();
                            z = z3;
                            zzpgVar.zzj().zzd();
                            return z;
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                        z3 = true;
                    }
                    zzpgVar.zzj().zzc();
                    z = z3;
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
        }
    }

    private final void zzaH(com.google.android.gms.internal.measurement.zzic zzicVar, long j, boolean z) {
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
            zzpnVar = new zzpn(zzicVar.zzK(), "auto", str2, zzaZ().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzpnVar = new zzpn(zzicVar.zzK(), "auto", str2, zzaZ().currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + j));
        }
        com.google.android.gms.internal.measurement.zzit zzm2 = com.google.android.gms.internal.measurement.zziu.zzm();
        zzm2.zzb(str2);
        zzm2.zza(zzaZ().currentTimeMillis());
        Object obj2 = zzpnVar.zze;
        zzm2.zze(((Long) obj2).longValue());
        com.google.android.gms.internal.measurement.zziu zziuVar = (com.google.android.gms.internal.measurement.zziu) zzm2.zzbc();
        int zzx = zzpk.zzx(zzicVar, str2);
        if (zzx < 0) {
            zzicVar.zzo(zziuVar);
        } else {
            zzicVar.zzn(zzx, zziuVar);
        }
        if (j > 0) {
            zzj().zzl(zzpnVar);
            zzaV().zzk().zzc("Updated engagement user property. scope, value", true != z ? "lifetime" : "session-scoped", obj2);
        }
    }

    private final boolean zzaI(com.google.android.gms.internal.measurement.zzhr zzhrVar, com.google.android.gms.internal.measurement.zzhr zzhrVar2) {
        Preconditions.checkArgument("_e".equals(zzhrVar.zzk()));
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzF = zzpk.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc(), "_sc");
        String zzd = zzF == null ? null : zzF.zzd();
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzF2 = zzpk.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar2.zzbc(), "_pc");
        String zzd2 = zzF2 != null ? zzF2.zzd() : null;
        if (zzd2 == null || !zzd2.equals(zzd)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzhrVar.zzk()));
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzF3 = zzpk.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc(), "_et");
        if (zzF3 == null || !zzF3.zze() || zzF3.zzf() <= 0) {
            return true;
        }
        long zzf = zzF3.zzf();
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzF4 = zzpk.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar2.zzbc(), "_et");
        if (zzF4 != null && zzF4.zzf() > 0) {
            zzf += zzF4.zzf();
        }
        zzp();
        zzpk.zzC(zzhrVar2, "_et", Long.valueOf(zzf));
        zzp();
        zzpk.zzC(zzhrVar, "_fr", 1L);
        return true;
    }

    private final boolean zzaJ() {
        zzaW().zzg();
        zzu();
        return zzj().zzP() || !TextUtils.isEmpty(zzj().zzF());
    }

    private static String zzaK(Map map, String str) {
        if (map == null) {
            return null;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey())) {
                if (((List) entry.getValue()).isEmpty()) {
                    return null;
                }
                return (String) ((List) entry.getValue()).get(0);
            }
        }
        return null;
    }

    private final void zzaL() {
        long max;
        long j;
        zzaW().zzg();
        zzu();
        if (this.zza > 0) {
            long abs = 3600000 - Math.abs(zzaZ().elapsedRealtime() - this.zza);
            if (abs > 0) {
                zzaV().zzk().zzb("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                zzk().zzb();
                zzl().zzd();
                return;
            }
            this.zza = 0L;
        }
        if (!this.zzn.zzH() || !zzaJ()) {
            zzaV().zzk().zza("Nothing to upload or uploading impossible");
            zzk().zzb();
            zzl().zzd();
            return;
        }
        long currentTimeMillis = zzaZ().currentTimeMillis();
        zzd();
        long max2 = Math.max(0L, ((Long) zzfy.zzO.zzb(null)).longValue());
        boolean z = true;
        if (!zzj().zzR() && !zzj().zzG()) {
            z = false;
        }
        if (z) {
            String zzA = zzd().zzA();
            if (TextUtils.isEmpty(zzA) || ".none.".equals(zzA)) {
                zzd();
                max = Math.max(0L, ((Long) zzfy.zzI.zzb(null)).longValue());
            } else {
                zzd();
                max = Math.max(0L, ((Long) zzfy.zzJ.zzb(null)).longValue());
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
            zzaV().zzk().zza("Next upload time is 0");
            zzk().zzb();
            zzl().zzd();
        } else if (zzi().zzb()) {
            long zza3 = this.zzk.zzc.zza();
            zzd();
            long max5 = Math.max(0L, ((Long) zzfy.zzF.zzb(null)).longValue());
            if (!zzp().zzs(zza3, max5)) {
                j = Math.max(j, zza3 + max5);
            }
            zzk().zzb();
            long currentTimeMillis2 = j - zzaZ().currentTimeMillis();
            if (currentTimeMillis2 <= 0) {
                zzd();
                currentTimeMillis2 = Math.max(0L, ((Long) zzfy.zzK.zzb(null)).longValue());
                this.zzk.zzd.zzb(zzaZ().currentTimeMillis());
            }
            zzaV().zzk().zzb("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
            zzl().zzc(currentTimeMillis2);
        } else {
            zzaV().zzk().zza("No network");
            zzk().zza();
            zzl().zzd();
        }
    }

    private final void zzaM() {
        zzaW().zzg();
        if (this.zzu || this.zzv || this.zzw) {
            zzaV().zzk().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv), Boolean.valueOf(this.zzw));
            return;
        }
        zzaV().zzk().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzq;
        if (list == null) {
            return;
        }
        for (Runnable runnable : list) {
            runnable.run();
        }
        ((List) Preconditions.checkNotNull(this.zzq)).clear();
    }

    private final Boolean zzaN(zzh zzhVar) {
        try {
            if (zzhVar.zzt() == SieveCacheKt.NodeMetaAndPreviousMask) {
                String str = Wrappers.packageManager(this.zzn.zzaY()).getPackageInfo(zzhVar.zzc(), 0).versionName;
                String zzr = zzhVar.zzr();
                if (zzr != null && zzr.equals(str)) {
                    return true;
                }
            } else {
                if (zzhVar.zzt() == Wrappers.packageManager(this.zzn.zzaY()).getPackageInfo(zzhVar.zzc(), 0).versionCode) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final zzr zzaO(String str) {
        zzh zzu = zzj().zzu(str);
        if (zzu == null || TextUtils.isEmpty(zzu.zzr())) {
            zzaV().zzj().zzb("No app data available; dropping", str);
            return null;
        }
        Boolean zzaN = zzaN(zzu);
        if (zzaN == null || zzaN.booleanValue()) {
            return new zzr(str, zzu.zzf(), zzu.zzr(), zzu.zzt(), zzu.zzv(), zzu.zzx(), zzu.zzz(), (String) null, zzu.zzD(), false, zzu.zzl(), 0L, 0, zzu.zzac(), false, zzu.zzae(), zzu.zzB(), zzu.zzag(), zzB(str).zzl(), "", (String) null, zzu.zzai(), zzu.zzak(), zzB(str).zzb(), zzx(str).zze(), zzu.zzao(), zzu.zzaw(), zzu.zzay(), zzu.zzaH(), 0L, zzu.zzaL());
        }
        zzaV().zzb().zzb("App version does not match; dropping. appId", zzgu.zzl(str));
        return null;
    }

    private final boolean zzaP(String str, String str2) {
        zzbc zzf = zzj().zzf(str, str2);
        return zzf == null || zzf.zzc < 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzaQ(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT < 34) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
        }
    }

    private static final boolean zzaR(zzr zzrVar) {
        return !TextUtils.isEmpty(zzrVar.zzb);
    }

    private static final zzos zzaS(zzos zzosVar) {
        if (zzosVar != null) {
            if (zzosVar.zzav()) {
                return zzosVar;
            }
            String valueOf = String.valueOf(zzosVar.getClass());
            String.valueOf(valueOf);
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(valueOf)));
        }
        throw new IllegalStateException("Upload Component not created");
    }

    private static final Boolean zzaT(zzr zzrVar) {
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
        zzaW().zzg();
        zzu();
        this.zzC.put(str, zzjlVar);
        zzj().zzZ(str, zzjlVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzjl zzB(String str) {
        zzjl zzjlVar = zzjl.zza;
        zzaW().zzg();
        zzu();
        zzjl zzjlVar2 = (zzjl) this.zzC.get(str);
        if (zzjlVar2 == null) {
            zzjlVar2 = zzj().zzX(str);
            if (zzjlVar2 == null) {
                zzjlVar2 = zzjl.zza;
            }
            zzA(str, zzjlVar2);
        }
        return zzjlVar2;
    }

    final long zzC() {
        long currentTimeMillis = zzaZ().currentTimeMillis();
        zznn zznnVar = this.zzk;
        zznnVar.zzaw();
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
    public final void zzD(zzbg zzbgVar, String str) {
        zzh zzu = zzj().zzu(str);
        if (zzu == null || TextUtils.isEmpty(zzu.zzr())) {
            zzaV().zzj().zzb("No app data available; dropping event", str);
            return;
        }
        Boolean zzaN = zzaN(zzu);
        if (zzaN == null) {
            if (!"_ui".equals(zzbgVar.zza)) {
                zzaV().zze().zzb("Could not find package. appId", zzgu.zzl(str));
            }
        } else if (!zzaN.booleanValue()) {
            zzaV().zzb().zzb("App version does not match; dropping event. appId", zzgu.zzl(str));
            return;
        }
        zzE(zzbgVar, new zzr(str, zzu.zzf(), zzu.zzr(), zzu.zzt(), zzu.zzv(), zzu.zzx(), zzu.zzz(), (String) null, zzu.zzD(), false, zzu.zzl(), 0L, 0, zzu.zzac(), false, zzu.zzae(), zzu.zzB(), zzu.zzag(), zzB(str).zzl(), "", (String) null, zzu.zzai(), zzu.zzak(), zzB(str).zzb(), zzx(str).zze(), zzu.zzao(), zzu.zzaw(), zzu.zzay(), zzu.zzaH(), 0L, zzu.zzaL()));
    }

    final void zzE(zzbg zzbgVar, zzr zzrVar) {
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzgv zza = zzgv.zza(zzbgVar);
        zzt().zzI(zza.zzd, zzj().zzU(str));
        zzt().zzG(zza, zzd().zzd(str));
        zzbg zzb2 = zza.zzb();
        if (!zzd().zzp(null, zzfy.zzbf) && Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzb2.zza)) {
            zzbe zzbeVar = zzb2.zzb;
            if ("referrer API v2".equals(zzbeVar.zzd("_cis"))) {
                String zzd = zzbeVar.zzd("gclid");
                if (!TextUtils.isEmpty(zzd)) {
                    zzac(new zzpl("_lgclid", zzb2.zzd, zzd, "auto"), zzrVar);
                }
            }
        }
        zzF(zzb2, zzrVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzF(zzbg zzbgVar, zzr zzrVar) {
        zzbg zzbgVar2;
        List<zzah> zzt;
        List<zzah> zzt2;
        List<zzah> zzt3;
        String str;
        Preconditions.checkNotNull(zzrVar);
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        zzaW().zzg();
        zzu();
        long j = zzbgVar.zzd;
        zzgv zza = zzgv.zza(zzbgVar);
        zzaW().zzg();
        char c = 0;
        zzpp.zzav((this.zzG == null || (str = this.zzH) == null || !str.equals(str2)) ? null : this.zzG, zza.zzd, false);
        zzbg zzb2 = zza.zzb();
        zzp();
        if (zzpk.zzD(zzb2, zzrVar)) {
            if (!zzrVar.zzh) {
                zzao(zzrVar);
                return;
            }
            List list = zzrVar.zzr;
            if (list != null) {
                String str3 = zzb2.zza;
                if (list.contains(str3)) {
                    Bundle zzf = zzb2.zzb.zzf();
                    zzf.putLong("ga_safelisted", 1L);
                    zzbgVar2 = new zzbg(str3, new zzbe(zzf), zzb2.zzc, zzb2.zzd);
                } else {
                    zzaV().zzj().zzd("Dropping non-safelisted event. appId, event name, origin", str2, zzb2.zza, zzb2.zzc);
                    return;
                }
            } else {
                zzbgVar2 = zzb2;
            }
            zzj().zzb();
            try {
                String str4 = zzbgVar2.zza;
                if ("_s".equals(str4) && !zzj().zzQ(str2, "_s") && zzbgVar2.zzb.zzb("_sid").longValue() != 0) {
                    if (!zzj().zzQ(str2, "_f") && !zzj().zzQ(str2, "_v")) {
                        zzj().zzW(str2, Long.valueOf(zzaZ().currentTimeMillis() - 15000), "_sid", zzG(str2, zzbgVar2));
                    }
                    zzj().zzW(str2, null, "_sid", zzG(str2, zzbgVar2));
                }
                zzav zzj = zzj();
                Preconditions.checkNotEmpty(str2);
                zzj.zzg();
                zzj.zzaw();
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                char c2 = 2;
                boolean z = true;
                if (i < 0) {
                    zzj.zzu.zzaV().zze().zzc("Invalid time querying timed out conditional properties", zzgu.zzl(str2), Long.valueOf(j));
                    zzt = Collections.emptyList();
                } else {
                    zzt = zzj.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j)});
                }
                for (zzah zzahVar : zzt) {
                    if (zzahVar != null) {
                        char c3 = c;
                        boolean z2 = z;
                        zzaV().zzk().zzd("User property timed out", zzahVar.zza, this.zzn.zzl().zzc(zzahVar.zzc.zzb), zzahVar.zzc.zza());
                        zzbg zzbgVar3 = zzahVar.zzg;
                        if (zzbgVar3 != null) {
                            zzH(new zzbg(zzbgVar3, j), zzrVar);
                        }
                        zzj().zzr(str2, zzahVar.zzc.zzb);
                        c = c3;
                        z = z2;
                    }
                }
                char c4 = c;
                boolean z3 = z;
                zzav zzj2 = zzj();
                Preconditions.checkNotEmpty(str2);
                zzj2.zzg();
                zzj2.zzaw();
                if (i < 0) {
                    zzj2.zzu.zzaV().zze().zzc("Invalid time querying expired conditional properties", zzgu.zzl(str2), Long.valueOf(j));
                    zzt2 = Collections.emptyList();
                } else {
                    String[] strArr = new String[2];
                    strArr[c4] = str2;
                    strArr[z3 ? 1 : 0] = String.valueOf(j);
                    zzt2 = zzj2.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", strArr);
                }
                ArrayList<zzbg> arrayList = new ArrayList(zzt2.size());
                for (zzah zzahVar2 : zzt2) {
                    if (zzahVar2 != null) {
                        char c5 = c2;
                        zzaV().zzk().zzd("User property expired", zzahVar2.zza, this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                        zzj().zzk(str2, zzahVar2.zzc.zzb);
                        zzbg zzbgVar4 = zzahVar2.zzk;
                        if (zzbgVar4 != null) {
                            arrayList.add(zzbgVar4);
                        }
                        zzj().zzr(str2, zzahVar2.zzc.zzb);
                        c2 = c5;
                    }
                }
                char c6 = c2;
                for (zzbg zzbgVar5 : arrayList) {
                    zzH(new zzbg(zzbgVar5, j), zzrVar);
                }
                zzav zzj3 = zzj();
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str4);
                zzj3.zzg();
                zzj3.zzaw();
                if (i < 0) {
                    zzic zzicVar = zzj3.zzu;
                    zzicVar.zzaV().zze().zzd("Invalid time querying triggered conditional properties", zzgu.zzl(str2), zzicVar.zzl().zza(str4), Long.valueOf(j));
                    zzt3 = Collections.emptyList();
                } else {
                    String[] strArr2 = new String[3];
                    strArr2[c4] = str2;
                    strArr2[z3 ? 1 : 0] = str4;
                    strArr2[c6] = String.valueOf(j);
                    zzt3 = zzj3.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", strArr2);
                }
                ArrayList<zzbg> arrayList2 = new ArrayList(zzt3.size());
                for (zzah zzahVar3 : zzt3) {
                    if (zzahVar3 != null) {
                        zzpl zzplVar = zzahVar3.zzc;
                        zzpn zzpnVar = new zzpn((String) Preconditions.checkNotNull(zzahVar3.zza), zzahVar3.zzb, zzplVar.zzb, j, Preconditions.checkNotNull(zzplVar.zza()));
                        if (zzj().zzl(zzpnVar)) {
                            zzaV().zzk().zzd("User property triggered", zzahVar3.zza, this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                        } else {
                            zzaV().zzb().zzd("Too many active user properties, ignoring", zzgu.zzl(zzahVar3.zza), this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                        }
                        zzbg zzbgVar6 = zzahVar3.zzi;
                        if (zzbgVar6 != null) {
                            arrayList2.add(zzbgVar6);
                        }
                        zzahVar3.zzc = new zzpl(zzpnVar);
                        boolean z4 = z3 ? 1 : 0;
                        zzahVar3.zze = z4;
                        zzj().zzp(zzahVar3);
                        z3 = z4;
                    }
                }
                zzH(zzbgVar2, zzrVar);
                for (zzbg zzbgVar7 : arrayList2) {
                    zzH(new zzbg(zzbgVar7, j), zzrVar);
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    final Bundle zzG(String str, zzbg zzbgVar) {
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", zzbgVar.zzb.zzb("_sid").longValue());
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
    /* JADX WARN: Can't wrap try/catch for region: R(15:366|(10:371|372|373|(1:375)|59|(0)(0)|62|(0)(0)|68|69)|376|377|378|379|372|373|(0)|59|(0)(0)|62|(0)(0)|68|69) */
    /* JADX WARN: Can't wrap try/catch for region: R(69:(2:71|(3:73|(1:75)|76))|77|(2:79|(3:81|(1:83)|84))|85|86|(1:88)|89|(2:93|(1:95))|96|(2:102|(2:104|105))|108|109|110|111|(3:112|113|114)|(3:115|116|117)|118|(1:120)|121|(2:123|(1:127)(1:126))(1:329)|128|(1:130)|131|(1:133)|134|(1:136)|137|(1:139)|140|(1:142)|143|(1:145)|146|(6:150|(1:154)|155|(1:157)(1:190)|158|(1:160)(15:161|(1:163)(1:189)|164|(1:166)(1:188)|167|(1:169)(1:187)|170|(1:172)(1:186)|173|(1:175)(1:185)|176|(1:178)(1:184)|179|(1:181)(1:183)|182))|191|(1:193)|194|(1:196)(1:328)|(4:201|(4:204|(3:206|207|(2:209|(2:211|213)(1:319))(1:321))(1:325)|320|202)|326|214)|327|(1:217)|218|(1:220)|221|(2:225|(4:227|(1:229)|230|(28:238|(1:240)(1:317)|241|(1:243)|244|245|(2:247|(1:249))|250|(3:252|(1:254)|255)(1:316)|256|(1:260)|261|(1:263)|264|(4:267|(2:273|274)|275|265)|279|280|281|282|283|(2:284|(2:286|(1:288))(3:303|304|(1:308)))|290|291|292|(1:294)(2:299|300)|295|296|297)))|318|245|(0)|250|(0)(0)|256|(2:258|260)|261|(0)|264|(1:265)|279|280|281|282|283|(3:284|(0)(0)|287)|290|291|292|(0)(0)|295|296|297) */
    /* JADX WARN: Can't wrap try/catch for region: R(71:(2:71|(3:73|(1:75)|76))|77|(2:79|(3:81|(1:83)|84))|85|86|(1:88)|89|(2:93|(1:95))|96|(2:102|(2:104|105))|108|109|110|111|112|113|114|(3:115|116|117)|118|(1:120)|121|(2:123|(1:127)(1:126))(1:329)|128|(1:130)|131|(1:133)|134|(1:136)|137|(1:139)|140|(1:142)|143|(1:145)|146|(6:150|(1:154)|155|(1:157)(1:190)|158|(1:160)(15:161|(1:163)(1:189)|164|(1:166)(1:188)|167|(1:169)(1:187)|170|(1:172)(1:186)|173|(1:175)(1:185)|176|(1:178)(1:184)|179|(1:181)(1:183)|182))|191|(1:193)|194|(1:196)(1:328)|(4:201|(4:204|(3:206|207|(2:209|(2:211|213)(1:319))(1:321))(1:325)|320|202)|326|214)|327|(1:217)|218|(1:220)|221|(2:225|(4:227|(1:229)|230|(28:238|(1:240)(1:317)|241|(1:243)|244|245|(2:247|(1:249))|250|(3:252|(1:254)|255)(1:316)|256|(1:260)|261|(1:263)|264|(4:267|(2:273|274)|275|265)|279|280|281|282|283|(2:284|(2:286|(1:288))(3:303|304|(1:308)))|290|291|292|(1:294)(2:299|300)|295|296|297)))|318|245|(0)|250|(0)(0)|256|(2:258|260)|261|(0)|264|(1:265)|279|280|281|282|283|(3:284|(0)(0)|287)|290|291|292|(0)(0)|295|296|297) */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x07bf, code lost:
        if (r11.isEmpty() == false) goto L216;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x0a4d, code lost:
        r14 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x0b02, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x0b03, code lost:
        r2.zzu.zzaV().zzb().zzc("Error storing raw event. appId", com.google.android.gms.measurement.internal.zzgu.zzl(r9.zza), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x0b32, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x0b33, code lost:
        zzaV().zzb().zzc("Data loss. Failed to insert raw event metadata. appId", com.google.android.gms.measurement.internal.zzgu.zzl(r10.zzK()), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0299, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x029a, code lost:
        r9.zzu.zzaV().zzb().zzc("Error pruning currencies. appId", com.google.android.gms.measurement.internal.zzgu.zzl(r10), r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0511 A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0549 A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x05b7 A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x05fb A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0606 A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0611 A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x061c A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0628 A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0639 A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0692  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x069a  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x069c A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x070b A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0731 A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0736 A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0764 A[Catch: all -> 0x0b79, TRY_LEAVE, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:257:0x07c4 A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x07d4 A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x080b A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x08c6 A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:294:0x08dd A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:298:0x093b  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0944 A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0965 A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0981 A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0a40 A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0ae9 A[Catch: SQLiteException -> 0x0b02, all -> 0x0b79, TRY_LEAVE, TryCatch #6 {SQLiteException -> 0x0b02, blocks: (B:332:0x0ad8, B:334:0x0ae9), top: B:364:0x0ad8, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0afd  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0a4f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x019c A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01fb A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x020d A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02d1 A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0312 A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0371 A[Catch: all -> 0x0b79, TryCatch #5 {all -> 0x0b79, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:88:0x02fe, B:97:0x0334, B:99:0x0371, B:101:0x0376, B:102:0x038d, B:104:0x0398, B:106:0x03b1, B:108:0x03b6, B:109:0x03cd, B:112:0x03eb, B:116:0x040d, B:117:0x0424, B:118:0x042d, B:121:0x044a, B:122:0x045e, B:124:0x0466, B:126:0x0472, B:128:0x0478, B:129:0x047f, B:131:0x048c, B:133:0x0494, B:135:0x049c, B:137:0x04a4, B:138:0x04b0, B:139:0x04bd, B:141:0x04e3, B:143:0x04e7, B:154:0x0511, B:155:0x0526, B:157:0x0549, B:160:0x0560, B:163:0x059b, B:165:0x05c3, B:167:0x05fb, B:168:0x05fe, B:170:0x0606, B:171:0x0609, B:173:0x0611, B:174:0x0614, B:176:0x061c, B:177:0x061f, B:179:0x0628, B:180:0x062c, B:182:0x0639, B:183:0x063c, B:185:0x0668, B:187:0x0672, B:191:0x0687, B:196:0x0693, B:199:0x069c, B:203:0x06a9, B:207:0x06b7, B:211:0x06c5, B:215:0x06d3, B:219:0x06e1, B:223:0x06ec, B:227:0x06f9, B:228:0x0705, B:230:0x070b, B:231:0x070e, B:233:0x0731, B:236:0x073c, B:239:0x0744, B:240:0x075e, B:242:0x0764, B:244:0x0778, B:246:0x0784, B:248:0x0791, B:251:0x07aa, B:253:0x07bb, B:257:0x07c4, B:258:0x07c7, B:260:0x07d4, B:261:0x07d9, B:263:0x07f7, B:265:0x07fb, B:267:0x080b, B:269:0x0816, B:270:0x0821, B:272:0x082b, B:274:0x0837, B:276:0x0841, B:278:0x0847, B:280:0x0857, B:282:0x086d, B:284:0x0873, B:285:0x087c, B:287:0x088a, B:289:0x08c6, B:291:0x08d0, B:292:0x08d3, B:294:0x08dd, B:296:0x08f9, B:297:0x0904, B:299:0x093c, B:301:0x0944, B:303:0x094e, B:304:0x095b, B:306:0x0965, B:307:0x0972, B:308:0x097b, B:310:0x0981, B:312:0x09bd, B:314:0x09c7, B:316:0x09d9, B:318:0x09df, B:319:0x0a24, B:320:0x0a2f, B:321:0x0a3a, B:323:0x0a40, B:331:0x0a8d, B:332:0x0ad8, B:334:0x0ae9, B:346:0x0b48, B:337:0x0aff, B:339:0x0b03, B:326:0x0a4f, B:328:0x0a7b, B:342:0x0b1a, B:343:0x0b31, B:345:0x0b33, B:234:0x0736, B:164:0x05b7, B:151:0x04f8, B:91:0x0312, B:92:0x0319, B:94:0x031f, B:96:0x032e, B:53:0x0190, B:55:0x019c, B:57:0x01b1, B:63:0x01d1, B:68:0x0207, B:70:0x020d, B:72:0x021b, B:74:0x0230, B:77:0x0237, B:85:0x02c7, B:87:0x02d1, B:79:0x0263, B:80:0x0282, B:84:0x02ad, B:83:0x029a, B:66:0x01dd, B:67:0x01fb), top: B:363:0x0155, inners: #0, #3, #6, #8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzH(com.google.android.gms.measurement.internal.zzbg r46, com.google.android.gms.measurement.internal.zzr r47) {
        /*
            Method dump skipped, instructions count: 2946
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzH(com.google.android.gms.measurement.internal.zzbg, com.google.android.gms.measurement.internal.zzr):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzI(zzh zzhVar, com.google.android.gms.internal.measurement.zzic zzicVar) {
        com.google.android.gms.internal.measurement.zziu zziuVar;
        zzaW().zzg();
        zzu();
        zzan zzd = zzan.zzd(zzicVar.zzaA());
        String zzc = zzhVar.zzc();
        zzaW().zzg();
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
        zzaW().zzg();
        zzu();
        zzaz zzz = zzz(zzc2, zzx(zzc2), zzB(zzc2), zzd);
        zzicVar.zzaD(((Boolean) Preconditions.checkNotNull(zzz.zzj())).booleanValue());
        if (!TextUtils.isEmpty(zzz.zzk())) {
            zzicVar.zzaF(zzz.zzk());
        }
        zzaW().zzg();
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
                    if (zzae != null && ((!zzae.booleanValue() || zziuVar.zzg() == 1) && (zzae.booleanValue() || zziuVar.zzg() == 0))) {
                        zzd.zzc(zzjkVar, zzam.MANIFEST);
                    } else {
                        zzd.zzc(zzjkVar, zzam.API);
                    }
                }
            }
        } else {
            int zzaC = zzaC(zzhVar.zzc(), zzd);
            com.google.android.gms.internal.measurement.zzit zzm2 = com.google.android.gms.internal.measurement.zziu.zzm();
            zzm2.zzb("_npa");
            zzm2.zza(zzaZ().currentTimeMillis());
            zzm2.zze(zzaC);
            zzicVar.zzo((com.google.android.gms.internal.measurement.zziu) zzm2.zzbc());
            zzaV().zzk().zzc("Setting user property", "non_personalized_ads(_npa)", Integer.valueOf(zzaC));
        }
        zzicVar.zzaB(zzd.toString());
        boolean zzy = this.zzc.zzy(zzhVar.zzc());
        List zzb2 = zzicVar.zzb();
        int i = 0;
        for (int i2 = 0; i2 < zzb2.size(); i2++) {
            if ("_tcf".equals(((com.google.android.gms.internal.measurement.zzhs) zzb2.get(i2)).zzd())) {
                com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) ((com.google.android.gms.internal.measurement.zzhs) zzb2.get(i2)).zzcl();
                List zza = zzhrVar.zza();
                int i3 = 0;
                while (true) {
                    if (i3 >= zza.size()) {
                        break;
                    } else if ("_tcfd".equals(((com.google.android.gms.internal.measurement.zzhw) zza.get(i3)).zzb())) {
                        String zzd2 = ((com.google.android.gms.internal.measurement.zzhw) zza.get(i3)).zzd();
                        if (zzy && zzd2.length() > 4) {
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
        zzaW().zzg();
        zzu();
        com.google.android.gms.internal.measurement.zzgx zzr = com.google.android.gms.internal.measurement.zzha.zzr();
        byte[] zzaJ = zzhVar.zzaJ();
        if (zzaJ != null) {
            try {
                zzr = (com.google.android.gms.internal.measurement.zzgx) zzpk.zzw(zzr, zzaJ);
            } catch (com.google.android.gms.internal.measurement.zzmr unused) {
                zzaV().zze().zzb("Failed to parse locally stored ad campaign info. appId", zzgu.zzl(zzhVar.zzc()));
            }
        }
        for (com.google.android.gms.internal.measurement.zzhs zzhsVar : zzicVar.zzb()) {
            if (zzhsVar.zzd().equals(Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN)) {
                String str = (String) zzpk.zzJ(zzhsVar, "gclid", "");
                String str2 = (String) zzpk.zzJ(zzhsVar, "gbraid", "");
                String str3 = (String) zzpk.zzJ(zzhsVar, "gad_source", "");
                String[] split = ((String) zzfy.zzbg.zzb(null)).split(StringUtils.COMMA);
                zzp();
                if (!zzpk.zzG(zzhsVar, split).isEmpty()) {
                    long longValue = ((Long) zzpk.zzJ(zzhsVar, "click_timestamp", 0L)).longValue();
                    if (longValue <= 0) {
                        longValue = zzhsVar.zzf();
                    }
                    if ("referrer API v2".equals(zzpk.zzI(zzhsVar, "_cis"))) {
                        if (longValue > zzr.zzo()) {
                            if (str.isEmpty()) {
                                zzr.zzj();
                            } else {
                                zzr.zzi(str);
                            }
                            if (str2.isEmpty()) {
                                zzr.zzl();
                            } else {
                                zzr.zzk(str2);
                            }
                            if (str3.isEmpty()) {
                                zzr.zzn();
                            } else {
                                zzr.zzm(str3);
                            }
                            zzr.zzp(longValue);
                            zzr.zzs();
                            zzr.zzt(zzaD(zzhsVar));
                        }
                    } else if (longValue > zzr.zzg()) {
                        if (str.isEmpty()) {
                            zzr.zzb();
                        } else {
                            zzr.zza(str);
                        }
                        if (str2.isEmpty()) {
                            zzr.zzd();
                        } else {
                            zzr.zzc(str2);
                        }
                        if (str3.isEmpty()) {
                            zzr.zzf();
                        } else {
                            zzr.zze(str3);
                        }
                        zzr.zzh(longValue);
                        zzr.zzq();
                        zzr.zzr(zzaD(zzhsVar));
                    }
                }
            }
        }
        if (!((com.google.android.gms.internal.measurement.zzha) zzr.zzbc()).equals(com.google.android.gms.internal.measurement.zzha.zzs())) {
            zzicVar.zzaM((com.google.android.gms.internal.measurement.zzha) zzr.zzbc());
        }
        zzhVar.zzaI(((com.google.android.gms.internal.measurement.zzha) zzr.zzbc()).zzcc());
        if (zzhVar.zza()) {
            zzj().zzv(zzhVar, false, false);
        }
        if (zzd().zzp(null, zzfy.zzbf)) {
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
            zzaV().zzb().zza("Set uploading progress before finishing the previous upload");
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
        zzW(r0);
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
        zzav zzj;
        long zzF;
        SQLiteException e;
        zzav zzavVar;
        zzaW().zzg();
        zzu();
        Cursor cursor = 1;
        this.zzw = true;
        try {
            zzic zzicVar = this.zzn;
            zzicVar.zzaU();
            Boolean zzJ = zzicVar.zzt().zzJ();
            if (zzJ == null) {
                zzaV().zze().zza("Upload data called on the client side before use of service was decided");
            } else if (zzJ.booleanValue()) {
                zzaV().zzb().zza("Upload called in the client side when service should be used");
            } else if (this.zza <= 0) {
                zzaW().zzg();
                if (this.zzz != null) {
                    zzaV().zzk().zza("Uploading requested multiple times");
                } else if (!zzi().zzb()) {
                    zzaV().zzk().zza("Network not connected, ignoring upload request");
                    zzaL();
                } else {
                    long currentTimeMillis = zzaZ().currentTimeMillis();
                    Cursor cursor2 = null;
                    Cursor cursor3 = null;
                    r8 = null;
                    r8 = null;
                    r8 = null;
                    String str = null;
                    int zzm = zzd().zzm(null, zzfy.zzai);
                    zzd();
                    long zzF2 = currentTimeMillis - zzal.zzF();
                    for (int i = 0; i < zzm && zzaG(null, zzF2); i++) {
                    }
                    zzqp.zza();
                    zzaW().zzg();
                    zzav();
                    long zza = this.zzk.zzd.zza();
                    if (zza != 0) {
                        zzaV().zzj().zzb("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - zza)));
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
                            zzj.zzaw();
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                        }
                        try {
                            cursor = zzj.zze().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(zzF)});
                            try {
                                if (!cursor.moveToFirst()) {
                                    zzj.zzu.zzaV().zzk().zza("No expired configs for apps with pending events");
                                    zzavVar = zzj;
                                    zzj = zzj;
                                } else {
                                    str = cursor.getString(0);
                                    zzavVar = zzj;
                                    zzj = zzj;
                                }
                            } catch (SQLiteException e2) {
                                e = e2;
                                ?? r4 = "Error selecting expired configs";
                                zzj.zzu.zzaV().zzb().zzb("Error selecting expired configs", e);
                                zzavVar = r4;
                                zzj = r4;
                            }
                        } catch (SQLiteException e3) {
                            e = e3;
                            cursor = null;
                            ?? r42 = "Error selecting expired configs";
                            zzj.zzu.zzaV().zzb().zzb("Error selecting expired configs", e);
                            zzavVar = r42;
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
                            zzav zzj2 = zzj();
                            try {
                                cursor3 = zzj2.zze().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                                if (cursor3.moveToFirst()) {
                                    j = cursor3.getLong(0);
                                }
                            } catch (SQLiteException e4) {
                                zzj2.zzu.zzaV().zzb().zzb("Error querying raw events", e4);
                            }
                        }
                        zzN(zzF3, currentTimeMillis);
                    }
                }
            } else {
                zzaL();
            }
        } finally {
            this.zzw = false;
            zzaM();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:155:0x0445, code lost:
        if (r17 != null) goto L309;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0447, code lost:
        r17.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0474, code lost:
        if (r17 == null) goto L268;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01df, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0206, code lost:
        if (r10 != null) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x09b3  */
    /* JADX WARN: Removed duplicated region for block: B:453:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:454:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0214  */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v58 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzN(String str, long j) {
        Cursor cursor;
        long j2;
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
        zzav zzj = zzj();
        zzj.zzg();
        zzj.zzaw();
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
                            zzj.zzu.zzaV().zzb().zzc("Error querying bundles. appId", zzgu.zzl(str), e);
                            emptyList = Collections.emptyList();
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        cursor2 = null;
                        zzj.zzu.zzaV().zzb().zzc("Error querying bundles. appId", zzgu.zzl(str), e);
                        emptyList = Collections.emptyList();
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = null;
                    if (cursor != null) {
                        cursor.close();
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
                com.google.android.gms.internal.measurement.zzpo.zza();
                zzal zzd = zzd();
                zzfx zzfxVar = zzfy.zzbh;
                if (zzd.zzp(null, zzfxVar)) {
                    com.google.android.gms.internal.measurement.zzpo.zza();
                    if (zzd().zzp(null, zzfxVar)) {
                        if (!zzB(str).zzo(zzjk.ANALYTICS_STORAGE) && zzh().zzB(str)) {
                            List asList = Arrays.asList(((String) zzfy.zzbi.zzb(null)).split(StringUtils.COMMA));
                            for (Pair pair : list) {
                                try {
                                    zzj().zzH(((Long) pair.second).longValue());
                                    for (com.google.android.gms.internal.measurement.zzhs zzhsVar : ((com.google.android.gms.internal.measurement.zzid) pair.first).zzc()) {
                                        if (asList.contains(zzhsVar.zzd())) {
                                            if (zzhsVar.zzd().equals("_f") || zzhsVar.zzd().equals("_v")) {
                                                com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzhsVar.zzcl();
                                                zzp();
                                                zzpk.zzC(zzhrVar, "_dac", 1L);
                                                zzhsVar = (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc();
                                            }
                                            zzav zzj2 = zzj();
                                            zzj2.zzg();
                                            zzj2.zzaw();
                                            Preconditions.checkNotNull(zzhsVar);
                                            Preconditions.checkNotEmpty(str);
                                            zzic zzicVar = zzj2.zzu;
                                            zzicVar.zzaV().zzk().zzb("Caching events in NO_DATA mode", zzhsVar);
                                            ContentValues contentValues = new ContentValues();
                                            contentValues.put("app_id", str);
                                            contentValues.put("name", zzhsVar.zzd());
                                            contentValues.put("data", zzhsVar.zzcc());
                                            contentValues.put("timestamp_millis", Long.valueOf(zzhsVar.zzf()));
                                            try {
                                                if (zzj2.zze().insert("no_data_mode_events", null, contentValues) == j2) {
                                                    zzicVar.zzaV().zzb().zzb("Failed to insert NO_DATA mode event (got -1). appId", zzgu.zzl(str));
                                                }
                                            } catch (SQLiteException e4) {
                                                zzj2.zzu.zzaV().zzb().zzc("Error storing NO_DATA mode event. appId", zzgu.zzl(str), e4);
                                            }
                                        }
                                    }
                                } catch (SQLiteException unused) {
                                    zzaV().zzh().zzb("Failed handling NO_DATA mode bundles. appId", str);
                                }
                            }
                            list = Collections.emptyList();
                        } else {
                            ArrayList arrayList = new ArrayList(list.size());
                            zzav zzj3 = zzj();
                            Preconditions.checkNotEmpty(str);
                            zzj3.zzg();
                            zzj3.zzaw();
                            List arrayList2 = new ArrayList();
                            try {
                                try {
                                    zze = zzj3.zze();
                                    currentTimeMillis = zzj3.zzu.zzaZ().currentTimeMillis();
                                    query = zze.query("no_data_mode_events", new String[]{"data"}, "app_id=? AND timestamp_millis <= CAST(? AS INTEGER)", new String[]{str, String.valueOf(currentTimeMillis)}, null, null, "rowid", null);
                                    list3 = list;
                                } catch (SQLiteException e5) {
                                    e = e5;
                                    list3 = list;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                cursor3 = null;
                                if (cursor3 != null) {
                                }
                                throw th;
                            }
                            try {
                                if (query.moveToFirst()) {
                                    while (true) {
                                        try {
                                            arrayList2.add((com.google.android.gms.internal.measurement.zzhs) ((com.google.android.gms.internal.measurement.zzhr) zzpk.zzw(com.google.android.gms.internal.measurement.zzhs.zzk(), query.getBlob(0))).zzbc());
                                            cursor4 = query;
                                        } catch (com.google.android.gms.internal.measurement.zzmr e6) {
                                            cursor4 = query;
                                            try {
                                                try {
                                                    zzj3.zzu.zzaV().zzh().zzc("Failed to parse stored NO_DATA mode event, appId", zzgu.zzl(str), e6);
                                                } catch (SQLiteException e7) {
                                                    e = e7;
                                                    zzj3.zzu.zzaV().zzb().zzc("Error flushing NO_DATA mode events. appId", zzgu.zzl(str), e);
                                                    arrayList2 = Collections.emptyList();
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
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
                                        zzgs zzk = zzj3.zzu.zzaV().zzk();
                                        StringBuilder sb = new StringBuilder(String.valueOf(delete).length() + 34);
                                        sb.append("Pruned ");
                                        sb.append(delete);
                                        sb.append(" NO_DATA mode events. appId");
                                        zzk.zzb(sb.toString(), str);
                                    } catch (SQLiteException e8) {
                                        e = e8;
                                        cursor4 = null;
                                        zzj3.zzu.zzaV().zzb().zzc("Error flushing NO_DATA mode events. appId", zzgu.zzl(str), e);
                                        arrayList2 = Collections.emptyList();
                                    }
                                } else {
                                    cursor4 = query;
                                }
                            } catch (SQLiteException e9) {
                                e = e9;
                                cursor4 = query;
                                zzj3.zzu.zzaV().zzb().zzc("Error flushing NO_DATA mode events. appId", zzgu.zzl(str), e);
                                arrayList2 = Collections.emptyList();
                            } catch (Throwable th4) {
                                th = th4;
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
                                com.google.android.gms.internal.measurement.zzic zzicVar2 = (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzid) pair2.first).zzcl();
                                if (z4 && !arrayList2.isEmpty()) {
                                    List zzb2 = zzicVar2.zzb();
                                    zzicVar2.zzi();
                                    zzicVar2.zzh(arrayList2);
                                    zzicVar2.zzh(zzb2);
                                    z4 = false;
                                }
                                com.google.android.gms.internal.measurement.zzhh zzb3 = com.google.android.gms.internal.measurement.zzho.zzb();
                                com.google.android.gms.internal.measurement.zzgf zzx = zzh().zzx(str);
                                ArrayList arrayList3 = new ArrayList();
                                if (zzx != null) {
                                    for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzx.zza()) {
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
                                        arrayList3.add((com.google.android.gms.internal.measurement.zzhl) zza.zzbc());
                                        z4 = z5;
                                        it = it2;
                                        arrayList2 = list4;
                                    }
                                }
                                Iterator it3 = it;
                                boolean z6 = z4;
                                List list5 = arrayList2;
                                zzb3.zza(arrayList3);
                                zzicVar2.zzaQ(zzb3);
                                arrayList.add(Pair.create((com.google.android.gms.internal.measurement.zzid) zzicVar2.zzbc(), (Long) pair2.second));
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
                com.google.android.gms.internal.measurement.zzhz zzh = com.google.android.gms.internal.measurement.zzib.zzh();
                int size = list.size();
                List arrayList4 = new ArrayList(list.size());
                boolean z7 = zzd().zzC(str) && zzB(str).zzo(zzjkVar);
                boolean zzo = zzB(str).zzo(zzjkVar);
                boolean zzo2 = zzB(str).zzo(zzjk.ANALYTICS_STORAGE);
                zzrb.zza();
                boolean zzp2 = zzd().zzp(str, zzfy.zzaM);
                zzou zzouVar = this.zzl;
                zzot zza2 = zzouVar.zza(str);
                int i8 = 0;
                while (i8 < size) {
                    boolean z8 = zzo;
                    com.google.android.gms.internal.measurement.zzic zzicVar3 = (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzid) ((Pair) list.get(i8)).first).zzcl();
                    int i9 = size;
                    arrayList4.add((Long) ((Pair) list.get(i8)).second);
                    zzd().zzi();
                    boolean z9 = z7;
                    boolean z10 = zzo2;
                    zzicVar3.zzO(133005L);
                    zzicVar3.zzs(j);
                    this.zzn.zzaU();
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
                                com.google.android.gms.internal.measurement.zzhw zzF = zzpk.zzF(zzhsVar2, "_pfo");
                                if (zzF != null) {
                                    l = Long.valueOf(zzF.zzf());
                                }
                                zzp();
                                com.google.android.gms.internal.measurement.zzhw zzF2 = zzpk.zzF(zzhsVar2, "_uwa");
                                if (zzF2 != null) {
                                    l2 = Long.valueOf(zzF2.zzf());
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
                            zzicVar3.zzas(zzp().zzt(((com.google.android.gms.internal.measurement.zzid) zzicVar3.zzbc()).zzcc()));
                        }
                        com.google.android.gms.internal.measurement.zzis zzd3 = zza2.zzd();
                        if (zzd3 != null) {
                            zzicVar3.zzaN(zzd3);
                        }
                        zzh.zze(zzicVar3);
                    }
                    i8 = i + 1;
                    zzo2 = z10;
                    zzo = z8;
                    size = i9;
                    z7 = z2;
                    zzp2 = z3;
                    list = list2;
                }
                if (zzh.zzb() == 0) {
                    zzL(arrayList4);
                    zzV(false, ComposerKt.providerMapsKey, null, null, str, Collections.emptyList());
                    return;
                }
                com.google.android.gms.internal.measurement.zzib zzibVar = (com.google.android.gms.internal.measurement.zzib) zzh.zzbc();
                List arrayList6 = new ArrayList();
                boolean z14 = zza2.zzc() == zzls.SGTM_CLIENT;
                if (zza2.zzc() == zzls.SGTM) {
                    z = z14;
                } else if (!z14) {
                    obj = null;
                    if (zzi().zzb()) {
                        return;
                    }
                    if (Log.isLoggable(zzaV().zzn(), 2)) {
                        obj = zzp().zzi(zzibVar);
                    }
                    zzp();
                    byte[] zzcc = zzibVar.zzcc();
                    zzL(arrayList4);
                    this.zzk.zze.zzb(j);
                    zzaV().zzk().zzd("Uploading data. app, uncompressed size, data", str, Integer.valueOf(zzcc.length), obj);
                    this.zzv = true;
                    zzi().zzc(str, zza2, zzibVar, new zzow(this, str, arrayList6));
                    return;
                } else {
                    z = true;
                }
                Iterator it6 = ((com.google.android.gms.internal.measurement.zzib) zzh.zzbc()).zza().iterator();
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
                com.google.android.gms.internal.measurement.zzib zzibVar2 = (com.google.android.gms.internal.measurement.zzib) zzh.zzbc();
                zzaW().zzg();
                zzu();
                com.google.android.gms.internal.measurement.zzhz zzi = com.google.android.gms.internal.measurement.zzib.zzi(zzibVar2);
                if (!TextUtils.isEmpty(str2)) {
                    zzi.zzi(str2);
                }
                String zzc = zzh().zzc(str);
                if (!TextUtils.isEmpty(zzc)) {
                    zzi.zzj(zzc);
                }
                ArrayList arrayList7 = new ArrayList();
                for (com.google.android.gms.internal.measurement.zzid zzidVar3 : zzibVar2.zza()) {
                    com.google.android.gms.internal.measurement.zzic zzaF = com.google.android.gms.internal.measurement.zzid.zzaF(zzidVar3);
                    zzaF.zzan();
                    arrayList7.add((com.google.android.gms.internal.measurement.zzid) zzaF.zzbc());
                }
                zzi.zzg();
                zzi.zzf(arrayList7);
                zzaV().zzk().zzb("[sgtm] Processed MeasurementBatch for sGTM with sgtmJoinId: ", TextUtils.isEmpty(str2) ? AbstractJsonLexerKt.NULL : zzi.zzh());
                com.google.android.gms.internal.measurement.zzib zzibVar3 = (com.google.android.gms.internal.measurement.zzib) zzi.zzbc();
                if (TextUtils.isEmpty(str2)) {
                    obj = null;
                } else {
                    zzaW().zzg();
                    zzu();
                    com.google.android.gms.internal.measurement.zzhz zzh2 = com.google.android.gms.internal.measurement.zzib.zzh();
                    zzaV().zzk().zzb("[sgtm] Processing Google Signal, sgtmJoinId:", str2);
                    zzh2.zzi(str2);
                    for (com.google.android.gms.internal.measurement.zzid zzidVar4 : ((com.google.android.gms.internal.measurement.zzib) zzh.zzbc()).zza()) {
                        com.google.android.gms.internal.measurement.zzic zzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                        zzaE.zzam(zzidVar4.zzZ());
                        zzaE.zzaJ(zzidVar4.zzav());
                        zzh2.zze(zzaE);
                    }
                    com.google.android.gms.internal.measurement.zzib zzibVar4 = (com.google.android.gms.internal.measurement.zzib) zzh2.zzbc();
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
                if (z) {
                    com.google.android.gms.internal.measurement.zzhz zzhzVar = (com.google.android.gms.internal.measurement.zzhz) zzibVar3.zzcl();
                    for (int i11 = 0; i11 < zzibVar3.zzb(); i11++) {
                        com.google.android.gms.internal.measurement.zzic zzicVar4 = (com.google.android.gms.internal.measurement.zzic) zzibVar3.zzc(i11).zzcl();
                        zzicVar4.zzt();
                        zzicVar4.zzaO(j);
                        zzhzVar.zzd(i11, zzicVar4);
                    }
                    arrayList6.add(Pair.create((com.google.android.gms.internal.measurement.zzib) zzhzVar.zzbc(), zza2));
                    zzL(arrayList4);
                    zzV(false, ComposerKt.providerMapsKey, null, null, str, arrayList6);
                    if (zzO(str, zza2.zza())) {
                        zzaV().zzk().zzb("[sgtm] Sending sgtm batches available notification to app", str);
                        Intent intent = new Intent();
                        intent.setAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                        intent.setPackage(str);
                        zzaQ(this.zzn.zzaY(), intent);
                        return;
                    }
                    return;
                }
                zzibVar = zzibVar3;
                if (zzi().zzb()) {
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
                        zzj.zzu.zzaV().zzb().zzc("Failed to unzip queued bundle. appId", zzgu.zzl(str), e10);
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
                                com.google.android.gms.internal.measurement.zzid zzidVar6 = (com.google.android.gms.internal.measurement.zzid) zzicVar5.zzbc();
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
                                        j3 = zziuVar.zzg();
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
                                        j4 = zziuVar2.zzg();
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
                            list.add(Pair.create((com.google.android.gms.internal.measurement.zzid) zzicVar5.zzbc(), Long.valueOf(j5)));
                        } catch (IOException e11) {
                            zzj.zzu.zzaV().zzb().zzc("Failed to merge queued bundle. appId", zzgu.zzl(str), e11);
                        }
                        if (!cursor2.moveToNext() || i12 > max) {
                            break;
                        }
                        i4 = 0;
                        i5 = 1;
                    } catch (IOException e12) {
                        zzp.zzu.zzaV().zzb().zzb("Failed to ungzip content", e12);
                        throw e12;
                        break;
                    }
                }
                if (!list.isEmpty()) {
                }
            }
        } catch (Throwable th5) {
            th = th5;
            cursor = r10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzO(String str, String str2) {
        zzh zzu = zzj().zzu(str);
        if (zzu == null || !zzt().zzaa(str, zzu.zzay())) {
            zzpe zzpeVar = (zzpe) this.zzF.get(str2);
            if (zzpeVar == null) {
                return true;
            }
            return zzpeVar.zzb();
        }
        this.zzF.remove(str2);
        return true;
    }

    final void zzP(String str) {
        com.google.android.gms.internal.measurement.zzib zzd;
        zzaW().zzg();
        zzu();
        this.zzw = true;
        try {
            zzic zzicVar = this.zzn;
            zzicVar.zzaU();
            Boolean zzJ = zzicVar.zzt().zzJ();
            if (zzJ == null) {
                zzaV().zze().zza("Upload data called on the client side before use of service was decided");
            } else if (zzJ.booleanValue()) {
                zzaV().zzb().zza("Upload called in the client side when service should be used");
            } else if (this.zza > 0) {
                zzaL();
            } else if (!zzi().zzb()) {
                zzaV().zzk().zza("Network not connected, ignoring upload request");
                zzaL();
            } else if (!zzj().zzD(str)) {
                zzaV().zzk().zzb("[sgtm] Upload queue has no batches for appId", str);
            } else {
                zzav zzj = zzj();
                Preconditions.checkNotEmpty(str);
                zzj.zzg();
                zzj.zzaw();
                List zzC = zzj.zzC(str, zzoo.zza(zzls.GOOGLE_SIGNAL), 1);
                zzpj zzpjVar = zzC.isEmpty() ? null : (zzpj) zzC.get(0);
                if (zzpjVar != null && (zzd = zzpjVar.zzd()) != null) {
                    zzaV().zzk().zzd("[sgtm] Uploading data from upload queue. appId, type, url", str, zzpjVar.zzf(), zzpjVar.zze());
                    byte[] zzcc = zzd.zzcc();
                    if (Log.isLoggable(zzaV().zzn(), 2)) {
                        zzaV().zzk().zzd("[sgtm] Uploading data from upload queue. appId, uncompressed size, data", str, Integer.valueOf(zzcc.length), zzp().zzi(zzd));
                    }
                    zzot zza = zzpjVar.zza();
                    this.zzv = true;
                    zzi().zzc(str, zza, zzd, new zzox(this, str, zzpjVar));
                }
            }
        } finally {
            this.zzw = false;
            zzaM();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzQ(String str, int i, Throwable th, byte[] bArr, zzpj zzpjVar) {
        zzaW().zzg();
        zzu();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzv = false;
                zzaM();
                throw th2;
            }
        }
        if (i != 200) {
            if (i == 204) {
                i = 204;
            }
            String str2 = new String(bArr, StandardCharsets.UTF_8);
            String substring = str2.substring(0, Math.min(32, str2.length()));
            zzgs zzh = zzaV().zzh();
            Integer valueOf = Integer.valueOf(i);
            if (th == null) {
                th = substring;
            }
            zzh.zzd("Network upload failed. Will retry later. appId, status, error", str, valueOf, th);
            zzj().zzK(Long.valueOf(zzpjVar.zzc()));
            zzaL();
            this.zzv = false;
            zzaM();
        }
        if (th == null) {
            zzj().zzE(Long.valueOf(zzpjVar.zzc()));
            zzaV().zzk().zzc("Successfully uploaded batch from upload queue. appId, status", str, Integer.valueOf(i));
            if (!zzi().zzb() || !zzj().zzD(str)) {
                zzaL();
            } else {
                zzP(str);
            }
            this.zzv = false;
            zzaM();
        }
        String str22 = new String(bArr, StandardCharsets.UTF_8);
        String substring2 = str22.substring(0, Math.min(32, str22.length()));
        zzgs zzh2 = zzaV().zzh();
        Integer valueOf2 = Integer.valueOf(i);
        if (th == null) {
        }
        zzh2.zzd("Network upload failed. Will retry later. appId, status, error", str, valueOf2, th);
        zzj().zzK(Long.valueOf(zzpjVar.zzc()));
        zzaL();
        this.zzv = false;
        zzaM();
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
        if (zzh().zzp(str)) {
            zzicVar.zzG();
        }
        if (zzh().zzq(str)) {
            String zzD = zzicVar.zzD();
            if (!TextUtils.isEmpty(zzD) && (indexOf = zzD.indexOf(".")) != -1) {
                zzicVar.zzE(zzD.substring(0, indexOf));
            }
        }
        if (zzh().zzr(str) && (zzx = zzpk.zzx(zzicVar, APEZProvider.FILEID)) != -1) {
            zzicVar.zzr(zzx);
        }
        if (zzh().zzs(str)) {
            zzicVar.zzan();
        }
        if (zzh().zzt(str)) {
            zzicVar.zzX();
            if (zzB(str).zzo(zzjk.ANALYTICS_STORAGE)) {
                Map map = this.zzE;
                zzpd zzpdVar = (zzpd) map.get(str);
                if (zzpdVar == null || zzpdVar.zzb + zzd().zzl(str, zzfy.zzak) < zzaZ().elapsedRealtime()) {
                    zzpdVar = new zzpd(this, (byte[]) null);
                    map.put(str, zzpdVar);
                }
                zzicVar.zzax(zzpdVar.zza);
            }
        }
        if (zzh().zzu(str)) {
            zzicVar.zzav();
        }
    }

    final void zzT(com.google.android.gms.internal.measurement.zzic zzicVar, zzpc zzpcVar) {
        for (int i = 0; i < zzicVar.zzc(); i++) {
            com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzicVar.zzd(i).zzcl();
            Iterator it = zzhrVar.zza().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if ("_c".equals(((com.google.android.gms.internal.measurement.zzhw) it.next()).zzb())) {
                    if (zzpcVar.zza.zzar() >= zzd().zzm(zzpcVar.zza.zzA(), zzfy.zzal)) {
                        int zzm = zzd().zzm(zzpcVar.zza.zzA(), zzfy.zzay);
                        String str = null;
                        if (zzm > 0) {
                            if (zzj().zzw(zzC(), zzpcVar.zza.zzA(), false, false, false, false, false, false, true).zzg > zzm) {
                                com.google.android.gms.internal.measurement.zzhv zzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzn.zzb("_tnr");
                                zzn.zzf(1L);
                                zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzn.zzbc());
                            } else {
                                if (zzd().zzp(zzpcVar.zza.zzA(), zzfy.zzaR)) {
                                    str = zzt().zzaw();
                                    com.google.android.gms.internal.measurement.zzhv zzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                    zzn2.zzb("_tu");
                                    zzn2.zzd(str);
                                    zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzn2.zzbc());
                                }
                                com.google.android.gms.internal.measurement.zzhv zzn3 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzn3.zzb("_tr");
                                zzn3.zzf(1L);
                                zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzn3.zzbc());
                                zzoh zzf = zzp().zzf(zzpcVar.zza.zzA(), zzicVar, zzhrVar, str);
                                if (zzf != null) {
                                    zzaV().zzk().zzc("Generated trigger URI. appId, uri", zzpcVar.zza.zzA(), zzf.zza);
                                    zzj().zzY(zzpcVar.zza.zzA(), zzf);
                                    Deque deque = this.zzr;
                                    if (!deque.contains(zzpcVar.zza.zzA())) {
                                        deque.add(zzpcVar.zza.zzA());
                                    }
                                }
                            }
                        } else {
                            if (zzd().zzp(zzpcVar.zza.zzA(), zzfy.zzaR)) {
                                str = zzt().zzaw();
                                com.google.android.gms.internal.measurement.zzhv zzn4 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzn4.zzb("_tu");
                                zzn4.zzd(str);
                                zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzn4.zzbc());
                            }
                            com.google.android.gms.internal.measurement.zzhv zzn5 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzn5.zzb("_tr");
                            zzn5.zzf(1L);
                            zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzn5.zzbc());
                            zzoh zzf2 = zzp().zzf(zzpcVar.zza.zzA(), zzicVar, zzhrVar, str);
                            if (zzf2 != null) {
                                zzaV().zzk().zzc("Generated trigger URI. appId, uri", zzpcVar.zza.zzA(), zzf2.zza);
                                zzj().zzY(zzpcVar.zza.zzA(), zzf2);
                                Deque deque2 = this.zzr;
                                if (!deque2.contains(zzpcVar.zza.zzA())) {
                                    deque2.add(zzpcVar.zza.zzA());
                                }
                            }
                        }
                    }
                    zzicVar.zze(i, (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc());
                }
            }
        }
    }

    final void zzU(String str, com.google.android.gms.internal.measurement.zzhv zzhvVar, Bundle bundle, String str2) {
        int zzf;
        List listOf = CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"});
        if (zzpp.zzZ(zzhvVar.zza()) || zzpp.zzZ(str)) {
            zzf = zzd().zzf(str2, true);
        } else {
            zzf = zzd().zze(str2, true);
        }
        long j = zzf;
        long codePointCount = zzhvVar.zzc().codePointCount(0, zzhvVar.zzc().length());
        zzpp zzt = zzt();
        String zza = zzhvVar.zza();
        zzd();
        String zzC = zzt.zzC(zza, 40, true);
        if (codePointCount <= j || listOf.contains(zzhvVar.zza())) {
            return;
        }
        if ("_ev".equals(zzhvVar.zza())) {
            bundle.putString("_ev", zzt().zzC(zzhvVar.zzc(), zzd().zzf(str2, true), true));
            return;
        }
        zzaV().zzh().zzc("Param value is too long; discarded. Name, value length", zzC, Long.valueOf(codePointCount));
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", 4L);
            if (bundle.getString("_ev") == null) {
                bundle.putString("_ev", zzC);
                bundle.putLong("_el", codePointCount);
            }
        }
        bundle.remove(zzhvVar.zza());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002f, code lost:
        if (r21 != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzV(boolean z, int i, Throwable th, byte[] bArr, String str, List list) {
        byte[] bArr2;
        int i2 = i;
        zzaW().zzg();
        zzu();
        if (bArr == null) {
            try {
                bArr2 = new byte[0];
            } finally {
                this.zzv = false;
                zzaM();
            }
        } else {
            bArr2 = bArr;
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
                    zzaV().zzh().zzd("Network upload failed. Will retry later. code, error", Integer.valueOf(i2), th, str2.substring(0, Math.min(32, str2.length())));
                    this.zzk.zze.zzb(zzaZ().currentTimeMillis());
                    if (i2 == 503 || i2 == 429) {
                        this.zzk.zzc.zzb(zzaZ().currentTimeMillis());
                    }
                    zzj().zzJ(list2);
                    zzaL();
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
                if (zzaZ().currentTimeMillis() > ((Long) zzfy.zzE.zzb(null)).longValue() + zzg) {
                    zzaV().zze().zzc("[sgtm] client batches are queued too long. appId, creationTime", str, Long.valueOf(zzg));
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
            if (!zzi().zzb() || !zzj().zzD(str)) {
                if (!zzi().zzb() || !zzaJ()) {
                    this.zzB = -1L;
                    zzaL();
                } else {
                    zzM();
                }
            } else {
                zzP(str);
            }
            this.zza = 0L;
            return;
        } catch (Throwable th2) {
            zzj().zzd();
            throw th2;
        }
        zzgs zzk = zzaV().zzk();
        Integer valueOf = Integer.valueOf(i2);
        zzk.zzc("Network upload successful with code, uploadAttempted", valueOf, Boolean.valueOf(z));
        if (z) {
            try {
                this.zzk.zzd.zzb(zzaZ().currentTimeMillis());
            } catch (SQLiteException e2) {
                zzaV().zzb().zzb("Database error while trying to delete uploaded bundles", e2);
                this.zza = zzaZ().elapsedRealtime();
                zzaV().zzk().zzb("Disable upload, time", Long.valueOf(this.zza));
            }
        }
        this.zzk.zze.zzb(0L);
        zzaL();
        if (z) {
            zzaV().zzk().zzc("Successful upload. Got network response. code, size", valueOf, Integer.valueOf(bArr2.length));
        } else {
            zzaV().zzk().zza("Purged empty bundles");
        }
        zzj().zzb();
    }

    final void zzW(zzh zzhVar) {
        zzaW().zzg();
        if (TextUtils.isEmpty(zzhVar.zzf())) {
            zzX((String) Preconditions.checkNotNull(zzhVar.zzc()), ComposerKt.providerMapsKey, null, null, null);
            return;
        }
        String str = (String) Preconditions.checkNotNull(zzhVar.zzc());
        zzaV().zzk().zzb("Fetching remote configuration", str);
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
                zzpg.this.zzX(str2, i, th, bArr, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0047 A[Catch: all -> 0x015f, TryCatch #2 {all -> 0x0168, blocks: (B:4:0x0010, B:5:0x0012, B:51:0x0152, B:6:0x002b, B:16:0x0047, B:50:0x014b, B:21:0x0061, B:26:0x00b1, B:25:0x00a2, B:27:0x00b6, B:31:0x00c7, B:35:0x00e1, B:37:0x00f5, B:39:0x0114, B:41:0x011e, B:43:0x0124, B:44:0x0128, B:46:0x0132, B:48:0x0140, B:49:0x0148, B:38:0x0103, B:32:0x00cf, B:34:0x00d9), top: B:60:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f5 A[Catch: all -> 0x015f, TryCatch #2 {all -> 0x0168, blocks: (B:4:0x0010, B:5:0x0012, B:51:0x0152, B:6:0x002b, B:16:0x0047, B:50:0x014b, B:21:0x0061, B:26:0x00b1, B:25:0x00a2, B:27:0x00b6, B:31:0x00c7, B:35:0x00e1, B:37:0x00f5, B:39:0x0114, B:41:0x011e, B:43:0x0124, B:44:0x0128, B:46:0x0132, B:48:0x0140, B:49:0x0148, B:38:0x0103, B:32:0x00cf, B:34:0x00d9), top: B:60:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0103 A[Catch: all -> 0x015f, TryCatch #2 {all -> 0x0168, blocks: (B:4:0x0010, B:5:0x0012, B:51:0x0152, B:6:0x002b, B:16:0x0047, B:50:0x014b, B:21:0x0061, B:26:0x00b1, B:25:0x00a2, B:27:0x00b6, B:31:0x00c7, B:35:0x00e1, B:37:0x00f5, B:39:0x0114, B:41:0x011e, B:43:0x0124, B:44:0x0128, B:46:0x0132, B:48:0x0140, B:49:0x0148, B:38:0x0103, B:32:0x00cf, B:34:0x00d9), top: B:60:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzX(String str, int i, Throwable th, byte[] bArr, Map map) {
        boolean z;
        zzaW().zzg();
        zzu();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.zzu = false;
                zzaM();
            }
        }
        zzgs zzk = zzaV().zzk();
        Integer valueOf = Integer.valueOf(bArr.length);
        zzk.zzb("onConfigFetched. Response size", valueOf);
        zzj().zzb();
        zzh zzu = zzj().zzu(str);
        if (i != 200 && i != 204) {
            if (i == 304) {
                i = 304;
            }
            z = false;
            if (zzu == null) {
                zzaV().zze().zzb("App does not exist in onConfigFetched. appId", zzgu.zzl(str));
            } else {
                if (!z && i != 404) {
                    zzu.zzK(zzaZ().currentTimeMillis());
                    zzj().zzv(zzu, false, false);
                    zzaV().zzk().zzc("Fetching config failed. code, error", Integer.valueOf(i), th);
                    zzh().zzf(str);
                    this.zzk.zze.zzb(zzaZ().currentTimeMillis());
                    if (i == 503 || i == 429) {
                        this.zzk.zzc.zzb(zzaZ().currentTimeMillis());
                    }
                    zzaL();
                }
                String zzaK = zzaK(map, HttpHeaders.LAST_MODIFIED);
                String zzaK2 = zzaK(map, HttpHeaders.ETAG);
                if (i != 404 && i != 304) {
                    zzh().zzi(str, bArr, zzaK, zzaK2);
                    zzu.zzI(zzaZ().currentTimeMillis());
                    zzj().zzv(zzu, false, false);
                    if (i != 404) {
                        zzaV().zzh().zzb("Config not found. Using empty config. appId", str);
                    } else {
                        zzaV().zzk().zzc("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), valueOf);
                    }
                    if (zzi().zzb() || !zzaJ()) {
                        if (zzi().zzb() || !zzj().zzD(zzu.zzc())) {
                            zzaL();
                        } else {
                            zzP(zzu.zzc());
                        }
                    } else {
                        zzM();
                    }
                }
                if (zzh().zzb(str) == null) {
                    zzh().zzi(str, null, null, null);
                }
                zzu.zzI(zzaZ().currentTimeMillis());
                zzj().zzv(zzu, false, false);
                if (i != 404) {
                }
                if (zzi().zzb()) {
                }
                if (zzi().zzb()) {
                }
                zzaL();
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
    public final void zzY(Runnable runnable) {
        zzaW().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzZ() {
        zzaW().zzg();
        zzu();
        if (this.zzp) {
            return;
        }
        this.zzp = true;
        if (zzaa()) {
            FileChannel fileChannel = this.zzy;
            zzaW().zzg();
            int i = 0;
            if (fileChannel == null || !fileChannel.isOpen()) {
                zzaV().zzb().zza("Bad channel to read from");
            } else {
                ByteBuffer allocate = ByteBuffer.allocate(4);
                try {
                    fileChannel.position(0L);
                    int read = fileChannel.read(allocate);
                    if (read == 4) {
                        allocate.flip();
                        i = allocate.getInt();
                    } else if (read != -1) {
                        zzaV().zze().zzb("Unexpected data length. Bytes read", Integer.valueOf(read));
                    }
                } catch (IOException e) {
                    zzaV().zzb().zzb("Failed to read from channel", e);
                }
            }
            int zzm = this.zzn.zzv().zzm();
            zzaW().zzg();
            if (i > zzm) {
                zzaV().zzb().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzm));
            } else if (i < zzm) {
                FileChannel fileChannel2 = this.zzy;
                zzaW().zzg();
                if (fileChannel2 == null || !fileChannel2.isOpen()) {
                    zzaV().zzb().zza("Bad channel to read from");
                } else {
                    ByteBuffer allocate2 = ByteBuffer.allocate(4);
                    allocate2.putInt(zzm);
                    allocate2.flip();
                    try {
                        fileChannel2.truncate(0L);
                        fileChannel2.write(allocate2);
                        fileChannel2.force(true);
                        if (fileChannel2.size() != 4) {
                            zzaV().zzb().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                        }
                        zzaV().zzk().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzm));
                        return;
                    } catch (IOException e2) {
                        zzaV().zzb().zzb("Failed to write to channel", e2);
                    }
                }
                zzaV().zzb().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzm));
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzae zzaU() {
        return this.zzn.zzaU();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzgu zzaV() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzaV();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzhz zzaW() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzaW();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final Context zzaY() {
        return this.zzn.zzaY();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final Clock zzaZ() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzaZ();
    }

    final boolean zzaa() {
        zzaW().zzg();
        FileLock fileLock = this.zzx;
        if (fileLock == null || !fileLock.isValid()) {
            this.zze.zzu.zzc();
            File filesDir = this.zzn.zzaY().getFilesDir();
            com.google.android.gms.internal.measurement.zzbv.zza();
            int i = com.google.android.gms.internal.measurement.zzca.zzb;
            try {
                FileChannel channel = new RandomAccessFile(new File(new File(filesDir, "google_app_measurement.db").getPath()), "rw").getChannel();
                this.zzy = channel;
                FileLock tryLock = channel.tryLock();
                this.zzx = tryLock;
                if (tryLock != null) {
                    zzaV().zzk().zza("Storage concurrent access okay");
                    return true;
                }
                zzaV().zzb().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                zzaV().zzb().zzb("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                zzaV().zzb().zzb("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                zzaV().zze().zzb("Storage lock already acquired", e3);
                return false;
            }
        }
        zzaV().zzk().zza("Storage concurrent access okay");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzab(zzr zzrVar) {
        if (this.zzz != null) {
            ArrayList arrayList = new ArrayList();
            this.zzA = arrayList;
            arrayList.addAll(this.zzz);
        }
        zzav zzj = zzj();
        String str = (String) Preconditions.checkNotNull(zzrVar.zza);
        Preconditions.checkNotEmpty(str);
        zzj.zzg();
        zzj.zzaw();
        try {
            SQLiteDatabase zze = zzj.zze();
            String[] strArr = {str};
            int delete = zze.delete("apps", "app_id=?", strArr) + zze.delete("events", "app_id=?", strArr) + zze.delete("events_snapshot", "app_id=?", strArr) + zze.delete("user_attributes", "app_id=?", strArr) + zze.delete("conditional_properties", "app_id=?", strArr) + zze.delete("raw_events", "app_id=?", strArr) + zze.delete("raw_events_metadata", "app_id=?", strArr) + zze.delete("queue", "app_id=?", strArr) + zze.delete("audience_filter_values", "app_id=?", strArr) + zze.delete("main_event_params", "app_id=?", strArr) + zze.delete("default_event_params", "app_id=?", strArr) + zze.delete("trigger_uris", "app_id=?", strArr) + zze.delete("upload_queue", "app_id=?", strArr);
            com.google.android.gms.internal.measurement.zzpo.zza();
            zzic zzicVar = zzj.zzu;
            if (zzicVar.zzc().zzp(null, zzfy.zzbh)) {
                delete += zze.delete("no_data_mode_events", "app_id=?", strArr);
            }
            if (delete > 0) {
                zzicVar.zzaV().zzk().zzc("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzj.zzu.zzaV().zzb().zzc("Error resetting analytics data. appId, error", zzgu.zzl(str), e);
        }
        if (zzrVar.zzh) {
            zzah(zzrVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzac(zzpl zzplVar, zzr zzrVar) {
        zzpn zzm;
        long j;
        zzaW().zzg();
        zzu();
        if (zzaR(zzrVar)) {
            if (!zzrVar.zzh) {
                zzao(zzrVar);
                return;
            }
            zzpp zzt = zzt();
            String str = zzplVar.zzb;
            int zzp = zzt.zzp(str);
            if (zzp != 0) {
                zzpp zzt2 = zzt();
                zzd();
                zzt().zzN(this.zzK, zzrVar.zza, zzp, "_ev", zzt2.zzC(str, 24, true), str != null ? str.length() : 0);
                return;
            }
            int zzK = zzt().zzK(str, zzplVar.zza());
            if (zzK != 0) {
                zzpp zzt3 = zzt();
                zzd();
                String zzC = zzt3.zzC(str, 24, true);
                Object zza = zzplVar.zza();
                if (zza != null && ((zza instanceof String) || (zza instanceof CharSequence))) {
                    r13 = zza.toString().length();
                }
                zzt().zzN(this.zzK, zzrVar.zza, zzK, "_ev", zzC, r13);
                return;
            }
            Object zzL = zzt().zzL(str, zzplVar.zza());
            if (zzL != null) {
                if ("_sid".equals(str)) {
                    long j2 = zzplVar.zzc;
                    String str2 = zzplVar.zzf;
                    String str3 = (String) Preconditions.checkNotNull(zzrVar.zza);
                    zzpn zzm2 = zzj().zzm(str3, "_sno");
                    if (zzm2 != null) {
                        Object obj = zzm2.zze;
                        if (obj instanceof Long) {
                            j = ((Long) obj).longValue();
                            zzac(new zzpl("_sno", j2, Long.valueOf(j + 1), str2), zzrVar);
                        }
                    }
                    if (zzm2 != null) {
                        zzaV().zze().zzb("Retrieved last session number from database does not contain a valid (long) value", zzm2.zze);
                    }
                    zzbc zzf = zzj().zzf(str3, "_s");
                    if (zzf != null) {
                        zzgs zzk = zzaV().zzk();
                        long j3 = zzf.zzc;
                        zzk.zzb("Backfill the session number. Last used session number", Long.valueOf(j3));
                        j = j3;
                    } else {
                        j = 0;
                    }
                    zzac(new zzpl("_sno", j2, Long.valueOf(j + 1), str2), zzrVar);
                }
                String str4 = zzrVar.zza;
                zzpn zzpnVar = new zzpn((String) Preconditions.checkNotNull(str4), (String) Preconditions.checkNotNull(zzplVar.zzf), str, zzplVar.zzc, zzL);
                zzgs zzk2 = zzaV().zzk();
                zzic zzicVar = this.zzn;
                String str5 = zzpnVar.zzc;
                zzk2.zzc("Setting user property", zzicVar.zzl().zzc(str5), zzL);
                zzj().zzb();
                try {
                    if (APEZProvider.FILEID.equals(str5) && (zzm = zzj().zzm(str4, APEZProvider.FILEID)) != null && !zzpnVar.zze.equals(zzm.zze)) {
                        zzj().zzk(str4, "_lair");
                    }
                    zzao(zzrVar);
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
                        zzaV().zzb().zzc("Too many unique user properties are set. Ignoring user property", zzicVar.zzl().zzc(str5), zzpnVar.zze);
                        zzt().zzN(this.zzK, str4, 9, null, null, 0);
                    }
                } finally {
                    zzj().zzd();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzad(String str, zzr zzrVar) {
        zzaW().zzg();
        zzu();
        if (zzaR(zzrVar)) {
            if (!zzrVar.zzh) {
                zzao(zzrVar);
                return;
            }
            Boolean zzaT = zzaT(zzrVar);
            if (!"_npa".equals(str) || zzaT == null) {
                zzgs zzj = zzaV().zzj();
                zzic zzicVar = this.zzn;
                zzj.zzb("Removing user property", zzicVar.zzl().zzc(str));
                zzj().zzb();
                try {
                    zzao(zzrVar);
                    if (APEZProvider.FILEID.equals(str)) {
                        zzj().zzk((String) Preconditions.checkNotNull(zzrVar.zza), "_lair");
                    }
                    zzj().zzk((String) Preconditions.checkNotNull(zzrVar.zza), str);
                    zzj().zzc();
                    zzaV().zzj().zzb("User property removed", zzicVar.zzl().zzc(str));
                    return;
                } finally {
                    zzj().zzd();
                }
            }
            zzaV().zzj().zza("Falling back to manifest metadata value for ad personalization");
            zzac(new zzpl("_npa", zzaZ().currentTimeMillis(), Long.valueOf(true != zzaT.booleanValue() ? 0L : 1L), "auto"), zzrVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzae() {
        this.zzs++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaf() {
        this.zzt++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzic zzag() {
        return this.zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00bd, code lost:
        if (true == r12.booleanValue()) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bf, code lost:
        r23 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c2, code lost:
        r23 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c4, code lost:
        r15 = new com.google.android.gms.measurement.internal.zzpl("_npa", r17, java.lang.Long.valueOf(r23), "auto");
        r24 = 1;
        r12 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d7, code lost:
        if (r11 == null) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e1, code lost:
        if (r11.zze.equals(r15.zzd) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e3, code lost:
        zzac(r15, r28);
     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0372 A[Catch: all -> 0x043c, TryCatch #3 {all -> 0x043c, blocks: (B:24:0x0095, B:26:0x00a3, B:43:0x00f0, B:45:0x00fd, B:47:0x0106, B:49:0x010b, B:52:0x0124, B:56:0x013a, B:58:0x015e, B:61:0x0166, B:63:0x0175, B:91:0x0256, B:93:0x0282, B:94:0x0285, B:96:0x02ad, B:134:0x0372, B:135:0x0375, B:137:0x0382, B:138:0x038f, B:149:0x042d, B:98:0x02c2, B:103:0x02e5, B:105:0x02ed, B:107:0x02f5, B:111:0x0308, B:115:0x0318, B:119:0x0324, B:113:0x0311, B:120:0x0330, B:123:0x0341, B:125:0x0355, B:127:0x035b, B:129:0x0363, B:131:0x0369, B:101:0x02d1, B:64:0x0186, B:66:0x01b1, B:67:0x01c0, B:69:0x01c7, B:71:0x01cd, B:73:0x01d7, B:75:0x01e1, B:77:0x01e7, B:79:0x01ed, B:80:0x01f2, B:84:0x0210, B:87:0x0215, B:88:0x0229, B:89:0x0237, B:90:0x0245, B:139:0x03a6, B:141:0x03dc, B:142:0x03df, B:144:0x03ec, B:145:0x03f7, B:146:0x040d, B:148:0x0413, B:50:0x0117, B:46:0x0103, B:31:0x00b5, B:35:0x00c4, B:37:0x00d9, B:39:0x00e3, B:42:0x00ed), top: B:161:0x0095, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0382 A[Catch: all -> 0x043c, TryCatch #3 {all -> 0x043c, blocks: (B:24:0x0095, B:26:0x00a3, B:43:0x00f0, B:45:0x00fd, B:47:0x0106, B:49:0x010b, B:52:0x0124, B:56:0x013a, B:58:0x015e, B:61:0x0166, B:63:0x0175, B:91:0x0256, B:93:0x0282, B:94:0x0285, B:96:0x02ad, B:134:0x0372, B:135:0x0375, B:137:0x0382, B:138:0x038f, B:149:0x042d, B:98:0x02c2, B:103:0x02e5, B:105:0x02ed, B:107:0x02f5, B:111:0x0308, B:115:0x0318, B:119:0x0324, B:113:0x0311, B:120:0x0330, B:123:0x0341, B:125:0x0355, B:127:0x035b, B:129:0x0363, B:131:0x0369, B:101:0x02d1, B:64:0x0186, B:66:0x01b1, B:67:0x01c0, B:69:0x01c7, B:71:0x01cd, B:73:0x01d7, B:75:0x01e1, B:77:0x01e7, B:79:0x01ed, B:80:0x01f2, B:84:0x0210, B:87:0x0215, B:88:0x0229, B:89:0x0237, B:90:0x0245, B:139:0x03a6, B:141:0x03dc, B:142:0x03df, B:144:0x03ec, B:145:0x03f7, B:146:0x040d, B:148:0x0413, B:50:0x0117, B:46:0x0103, B:31:0x00b5, B:35:0x00c4, B:37:0x00d9, B:39:0x00e3, B:42:0x00ed), top: B:161:0x0095, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x040d A[Catch: all -> 0x043c, TryCatch #3 {all -> 0x043c, blocks: (B:24:0x0095, B:26:0x00a3, B:43:0x00f0, B:45:0x00fd, B:47:0x0106, B:49:0x010b, B:52:0x0124, B:56:0x013a, B:58:0x015e, B:61:0x0166, B:63:0x0175, B:91:0x0256, B:93:0x0282, B:94:0x0285, B:96:0x02ad, B:134:0x0372, B:135:0x0375, B:137:0x0382, B:138:0x038f, B:149:0x042d, B:98:0x02c2, B:103:0x02e5, B:105:0x02ed, B:107:0x02f5, B:111:0x0308, B:115:0x0318, B:119:0x0324, B:113:0x0311, B:120:0x0330, B:123:0x0341, B:125:0x0355, B:127:0x035b, B:129:0x0363, B:131:0x0369, B:101:0x02d1, B:64:0x0186, B:66:0x01b1, B:67:0x01c0, B:69:0x01c7, B:71:0x01cd, B:73:0x01d7, B:75:0x01e1, B:77:0x01e7, B:79:0x01ed, B:80:0x01f2, B:84:0x0210, B:87:0x0215, B:88:0x0229, B:89:0x0237, B:90:0x0245, B:139:0x03a6, B:141:0x03dc, B:142:0x03df, B:144:0x03ec, B:145:0x03f7, B:146:0x040d, B:148:0x0413, B:50:0x0117, B:46:0x0103, B:31:0x00b5, B:35:0x00c4, B:37:0x00d9, B:39:0x00e3, B:42:0x00ed), top: B:161:0x0095, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fd A[Catch: all -> 0x043c, TryCatch #3 {all -> 0x043c, blocks: (B:24:0x0095, B:26:0x00a3, B:43:0x00f0, B:45:0x00fd, B:47:0x0106, B:49:0x010b, B:52:0x0124, B:56:0x013a, B:58:0x015e, B:61:0x0166, B:63:0x0175, B:91:0x0256, B:93:0x0282, B:94:0x0285, B:96:0x02ad, B:134:0x0372, B:135:0x0375, B:137:0x0382, B:138:0x038f, B:149:0x042d, B:98:0x02c2, B:103:0x02e5, B:105:0x02ed, B:107:0x02f5, B:111:0x0308, B:115:0x0318, B:119:0x0324, B:113:0x0311, B:120:0x0330, B:123:0x0341, B:125:0x0355, B:127:0x035b, B:129:0x0363, B:131:0x0369, B:101:0x02d1, B:64:0x0186, B:66:0x01b1, B:67:0x01c0, B:69:0x01c7, B:71:0x01cd, B:73:0x01d7, B:75:0x01e1, B:77:0x01e7, B:79:0x01ed, B:80:0x01f2, B:84:0x0210, B:87:0x0215, B:88:0x0229, B:89:0x0237, B:90:0x0245, B:139:0x03a6, B:141:0x03dc, B:142:0x03df, B:144:0x03ec, B:145:0x03f7, B:146:0x040d, B:148:0x0413, B:50:0x0117, B:46:0x0103, B:31:0x00b5, B:35:0x00c4, B:37:0x00d9, B:39:0x00e3, B:42:0x00ed), top: B:161:0x0095, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0103 A[Catch: all -> 0x043c, TryCatch #3 {all -> 0x043c, blocks: (B:24:0x0095, B:26:0x00a3, B:43:0x00f0, B:45:0x00fd, B:47:0x0106, B:49:0x010b, B:52:0x0124, B:56:0x013a, B:58:0x015e, B:61:0x0166, B:63:0x0175, B:91:0x0256, B:93:0x0282, B:94:0x0285, B:96:0x02ad, B:134:0x0372, B:135:0x0375, B:137:0x0382, B:138:0x038f, B:149:0x042d, B:98:0x02c2, B:103:0x02e5, B:105:0x02ed, B:107:0x02f5, B:111:0x0308, B:115:0x0318, B:119:0x0324, B:113:0x0311, B:120:0x0330, B:123:0x0341, B:125:0x0355, B:127:0x035b, B:129:0x0363, B:131:0x0369, B:101:0x02d1, B:64:0x0186, B:66:0x01b1, B:67:0x01c0, B:69:0x01c7, B:71:0x01cd, B:73:0x01d7, B:75:0x01e1, B:77:0x01e7, B:79:0x01ed, B:80:0x01f2, B:84:0x0210, B:87:0x0215, B:88:0x0229, B:89:0x0237, B:90:0x0245, B:139:0x03a6, B:141:0x03dc, B:142:0x03df, B:144:0x03ec, B:145:0x03f7, B:146:0x040d, B:148:0x0413, B:50:0x0117, B:46:0x0103, B:31:0x00b5, B:35:0x00c4, B:37:0x00d9, B:39:0x00e3, B:42:0x00ed), top: B:161:0x0095, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010b A[Catch: all -> 0x043c, TryCatch #3 {all -> 0x043c, blocks: (B:24:0x0095, B:26:0x00a3, B:43:0x00f0, B:45:0x00fd, B:47:0x0106, B:49:0x010b, B:52:0x0124, B:56:0x013a, B:58:0x015e, B:61:0x0166, B:63:0x0175, B:91:0x0256, B:93:0x0282, B:94:0x0285, B:96:0x02ad, B:134:0x0372, B:135:0x0375, B:137:0x0382, B:138:0x038f, B:149:0x042d, B:98:0x02c2, B:103:0x02e5, B:105:0x02ed, B:107:0x02f5, B:111:0x0308, B:115:0x0318, B:119:0x0324, B:113:0x0311, B:120:0x0330, B:123:0x0341, B:125:0x0355, B:127:0x035b, B:129:0x0363, B:131:0x0369, B:101:0x02d1, B:64:0x0186, B:66:0x01b1, B:67:0x01c0, B:69:0x01c7, B:71:0x01cd, B:73:0x01d7, B:75:0x01e1, B:77:0x01e7, B:79:0x01ed, B:80:0x01f2, B:84:0x0210, B:87:0x0215, B:88:0x0229, B:89:0x0237, B:90:0x0245, B:139:0x03a6, B:141:0x03dc, B:142:0x03df, B:144:0x03ec, B:145:0x03f7, B:146:0x040d, B:148:0x0413, B:50:0x0117, B:46:0x0103, B:31:0x00b5, B:35:0x00c4, B:37:0x00d9, B:39:0x00e3, B:42:0x00ed), top: B:161:0x0095, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0117 A[Catch: all -> 0x043c, TryCatch #3 {all -> 0x043c, blocks: (B:24:0x0095, B:26:0x00a3, B:43:0x00f0, B:45:0x00fd, B:47:0x0106, B:49:0x010b, B:52:0x0124, B:56:0x013a, B:58:0x015e, B:61:0x0166, B:63:0x0175, B:91:0x0256, B:93:0x0282, B:94:0x0285, B:96:0x02ad, B:134:0x0372, B:135:0x0375, B:137:0x0382, B:138:0x038f, B:149:0x042d, B:98:0x02c2, B:103:0x02e5, B:105:0x02ed, B:107:0x02f5, B:111:0x0308, B:115:0x0318, B:119:0x0324, B:113:0x0311, B:120:0x0330, B:123:0x0341, B:125:0x0355, B:127:0x035b, B:129:0x0363, B:131:0x0369, B:101:0x02d1, B:64:0x0186, B:66:0x01b1, B:67:0x01c0, B:69:0x01c7, B:71:0x01cd, B:73:0x01d7, B:75:0x01e1, B:77:0x01e7, B:79:0x01ed, B:80:0x01f2, B:84:0x0210, B:87:0x0215, B:88:0x0229, B:89:0x0237, B:90:0x0245, B:139:0x03a6, B:141:0x03dc, B:142:0x03df, B:144:0x03ec, B:145:0x03f7, B:146:0x040d, B:148:0x0413, B:50:0x0117, B:46:0x0103, B:31:0x00b5, B:35:0x00c4, B:37:0x00d9, B:39:0x00e3, B:42:0x00ed), top: B:161:0x0095, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0124 A[Catch: all -> 0x043c, TRY_LEAVE, TryCatch #3 {all -> 0x043c, blocks: (B:24:0x0095, B:26:0x00a3, B:43:0x00f0, B:45:0x00fd, B:47:0x0106, B:49:0x010b, B:52:0x0124, B:56:0x013a, B:58:0x015e, B:61:0x0166, B:63:0x0175, B:91:0x0256, B:93:0x0282, B:94:0x0285, B:96:0x02ad, B:134:0x0372, B:135:0x0375, B:137:0x0382, B:138:0x038f, B:149:0x042d, B:98:0x02c2, B:103:0x02e5, B:105:0x02ed, B:107:0x02f5, B:111:0x0308, B:115:0x0318, B:119:0x0324, B:113:0x0311, B:120:0x0330, B:123:0x0341, B:125:0x0355, B:127:0x035b, B:129:0x0363, B:131:0x0369, B:101:0x02d1, B:64:0x0186, B:66:0x01b1, B:67:0x01c0, B:69:0x01c7, B:71:0x01cd, B:73:0x01d7, B:75:0x01e1, B:77:0x01e7, B:79:0x01ed, B:80:0x01f2, B:84:0x0210, B:87:0x0215, B:88:0x0229, B:89:0x0237, B:90:0x0245, B:139:0x03a6, B:141:0x03dc, B:142:0x03df, B:144:0x03ec, B:145:0x03f7, B:146:0x040d, B:148:0x0413, B:50:0x0117, B:46:0x0103, B:31:0x00b5, B:35:0x00c4, B:37:0x00d9, B:39:0x00e3, B:42:0x00ed), top: B:161:0x0095, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0282 A[Catch: all -> 0x043c, TryCatch #3 {all -> 0x043c, blocks: (B:24:0x0095, B:26:0x00a3, B:43:0x00f0, B:45:0x00fd, B:47:0x0106, B:49:0x010b, B:52:0x0124, B:56:0x013a, B:58:0x015e, B:61:0x0166, B:63:0x0175, B:91:0x0256, B:93:0x0282, B:94:0x0285, B:96:0x02ad, B:134:0x0372, B:135:0x0375, B:137:0x0382, B:138:0x038f, B:149:0x042d, B:98:0x02c2, B:103:0x02e5, B:105:0x02ed, B:107:0x02f5, B:111:0x0308, B:115:0x0318, B:119:0x0324, B:113:0x0311, B:120:0x0330, B:123:0x0341, B:125:0x0355, B:127:0x035b, B:129:0x0363, B:131:0x0369, B:101:0x02d1, B:64:0x0186, B:66:0x01b1, B:67:0x01c0, B:69:0x01c7, B:71:0x01cd, B:73:0x01d7, B:75:0x01e1, B:77:0x01e7, B:79:0x01ed, B:80:0x01f2, B:84:0x0210, B:87:0x0215, B:88:0x0229, B:89:0x0237, B:90:0x0245, B:139:0x03a6, B:141:0x03dc, B:142:0x03df, B:144:0x03ec, B:145:0x03f7, B:146:0x040d, B:148:0x0413, B:50:0x0117, B:46:0x0103, B:31:0x00b5, B:35:0x00c4, B:37:0x00d9, B:39:0x00e3, B:42:0x00ed), top: B:161:0x0095, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02ad A[Catch: all -> 0x043c, TRY_LEAVE, TryCatch #3 {all -> 0x043c, blocks: (B:24:0x0095, B:26:0x00a3, B:43:0x00f0, B:45:0x00fd, B:47:0x0106, B:49:0x010b, B:52:0x0124, B:56:0x013a, B:58:0x015e, B:61:0x0166, B:63:0x0175, B:91:0x0256, B:93:0x0282, B:94:0x0285, B:96:0x02ad, B:134:0x0372, B:135:0x0375, B:137:0x0382, B:138:0x038f, B:149:0x042d, B:98:0x02c2, B:103:0x02e5, B:105:0x02ed, B:107:0x02f5, B:111:0x0308, B:115:0x0318, B:119:0x0324, B:113:0x0311, B:120:0x0330, B:123:0x0341, B:125:0x0355, B:127:0x035b, B:129:0x0363, B:131:0x0369, B:101:0x02d1, B:64:0x0186, B:66:0x01b1, B:67:0x01c0, B:69:0x01c7, B:71:0x01cd, B:73:0x01d7, B:75:0x01e1, B:77:0x01e7, B:79:0x01ed, B:80:0x01f2, B:84:0x0210, B:87:0x0215, B:88:0x0229, B:89:0x0237, B:90:0x0245, B:139:0x03a6, B:141:0x03dc, B:142:0x03df, B:144:0x03ec, B:145:0x03f7, B:146:0x040d, B:148:0x0413, B:50:0x0117, B:46:0x0103, B:31:0x00b5, B:35:0x00c4, B:37:0x00d9, B:39:0x00e3, B:42:0x00ed), top: B:161:0x0095, inners: #0, #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzah(zzr zzrVar) {
        long j;
        long j2;
        zzbc zzf;
        boolean z;
        String str;
        long zzN;
        zzic zzicVar;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        long j3;
        boolean z2;
        zzaW().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        if (zzaR(zzrVar)) {
            zzh zzu = zzj().zzu(str2);
            if (zzu != null && TextUtils.isEmpty(zzu.zzf()) && !TextUtils.isEmpty(zzrVar.zzb)) {
                zzu.zzI(0L);
                zzj().zzv(zzu, false, false);
                zzh().zzh(str2);
            }
            if (!zzrVar.zzh) {
                zzao(zzrVar);
                return;
            }
            long j4 = zzrVar.zzl;
            if (j4 == 0) {
                j4 = zzaZ().currentTimeMillis();
            }
            long j5 = j4;
            int i = zzrVar.zzm;
            if (i != 0 && i != 1) {
                zzaV().zze().zzc("Incorrect app type, assuming installed app. appId, appType", zzgu.zzl(str2), Integer.valueOf(i));
                i = 0;
            }
            zzj().zzb();
            try {
                zzpn zzm = zzj().zzm(str2, "_npa");
                Boolean zzaT = zzaT(zzrVar);
                if (zzm != null && !"auto".equals(zzm.zzb)) {
                    j = j5;
                    j2 = 1;
                    if (!zzd().zzp(null, zzfy.zzbb)) {
                        zzan(zzrVar, zzrVar.zzD);
                    } else {
                        zzan(zzrVar, j);
                    }
                    zzao(zzrVar);
                    if (i == 0) {
                        zzf = zzj().zzf(str2, "_v");
                        z = true;
                    } else {
                        zzf = zzj().zzf(str2, "_f");
                        z = false;
                    }
                    if (zzf != null) {
                        long j6 = ((j / 3600000) + j2) * 3600000;
                        if (z) {
                            long j7 = j;
                            zzac(new zzpl("_fvt", j7, Long.valueOf(j6), "auto"), zzrVar);
                            zzaW().zzg();
                            zzu();
                            Bundle bundle = new Bundle();
                            bundle.putLong("_c", 1L);
                            bundle.putLong("_r", 1L);
                            bundle.putLong("_et", 1L);
                            if (zzrVar.zzo) {
                                bundle.putLong("_dac", 1L);
                            }
                            if (zzd().zzp(null, zzfy.zzbj)) {
                                bundle.putLong("_elt", zzaZ().currentTimeMillis());
                            }
                            zzE(new zzbg("_v", new zzbe(bundle), "auto", j7), zzrVar);
                        } else {
                            Long valueOf = Long.valueOf(j6);
                            long j8 = j;
                            zzac(new zzpl("_fot", j8, valueOf, "auto"), zzrVar);
                            zzaW().zzg();
                            zzhk zzhkVar = (zzhk) Preconditions.checkNotNull(this.zzm);
                            if (str2 != null && !str2.isEmpty()) {
                                zzic zzicVar2 = zzhkVar.zza;
                                zzicVar2.zzaW().zzg();
                                if (!zzhkVar.zza()) {
                                    zzicVar2.zzaV().zzi().zza("Install Referrer Reporter is not available");
                                    str = "_elt";
                                } else {
                                    zzhj zzhjVar = new zzhj(zzhkVar, str2);
                                    zzicVar2.zzaW().zzg();
                                    Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                                    str = "_elt";
                                    intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                                    PackageManager packageManager = zzicVar2.zzaY().getPackageManager();
                                    if (packageManager == null) {
                                        zzicVar2.zzaV().zzf().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                                    } else {
                                        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
                                        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                                            zzicVar2.zzaV().zzi().zza("Play Service for fetching Install Referrer is unavailable on device");
                                        } else {
                                            ResolveInfo resolveInfo = queryIntentServices.get(0);
                                            if (resolveInfo.serviceInfo != null) {
                                                String str3 = resolveInfo.serviceInfo.packageName;
                                                if (resolveInfo.serviceInfo.name == null || !"com.android.vending".equals(str3) || !zzhkVar.zza()) {
                                                    zzicVar2.zzaV().zze().zza("Play Store version 8.3.73 or higher required for Install Referrer");
                                                } else {
                                                    try {
                                                        zzicVar2.zzaV().zzk().zzb("Install Referrer Service is", ConnectionTracker.getInstance().bindService(zzicVar2.zzaY(), new Intent(intent), zzhjVar, 1) ? "available" : "not available");
                                                    } catch (RuntimeException e) {
                                                        zzhkVar.zza.zzaV().zzb().zzb("Exception occurred while binding to Install Referrer Service", e.getMessage());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                zzaW().zzg();
                                zzu();
                                Bundle bundle2 = new Bundle();
                                long j9 = j2;
                                bundle2.putLong("_c", j9);
                                bundle2.putLong("_r", j9);
                                bundle2.putLong("_uwa", 0L);
                                bundle2.putLong("_pfo", 0L);
                                bundle2.putLong("_sys", 0L);
                                bundle2.putLong("_sysu", 0L);
                                bundle2.putLong("_et", j9);
                                if (zzrVar.zzo) {
                                    bundle2.putLong("_dac", j9);
                                }
                                String str4 = (String) Preconditions.checkNotNull(zzrVar.zza);
                                zzav zzj = zzj();
                                Preconditions.checkNotEmpty(str4);
                                zzj.zzg();
                                zzj.zzaw();
                                zzN = zzj.zzN(str4, "first_open_count");
                                zzicVar = this.zzn;
                                if (zzicVar.zzaY().getPackageManager() == null) {
                                    try {
                                        packageInfo = Wrappers.packageManager(zzicVar.zzaY()).getPackageInfo(str4, 0);
                                    } catch (PackageManager.NameNotFoundException e2) {
                                        zzaV().zzb().zzc("Package info is null, first open report might be inaccurate. appId", zzgu.zzl(str4), e2);
                                        packageInfo = null;
                                    }
                                    if (packageInfo != null && packageInfo.firstInstallTime != 0) {
                                        if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                            if (!zzd().zzp(null, zzfy.zzaI)) {
                                                bundle2.putLong("_uwa", 1L);
                                            } else if (zzN == 0) {
                                                bundle2.putLong("_uwa", 1L);
                                                zzN = 0;
                                            }
                                            z2 = false;
                                        } else {
                                            z2 = true;
                                        }
                                        zzac(new zzpl("_fi", j8, Long.valueOf(true != z2 ? 0L : 1L), "auto"), zzrVar);
                                    }
                                    try {
                                        applicationInfo = Wrappers.packageManager(this.zzn.zzaY()).getApplicationInfo(str4, 0);
                                    } catch (PackageManager.NameNotFoundException e3) {
                                        zzaV().zzb().zzc("Application info is null, first open report might be inaccurate. appId", zzgu.zzl(str4), e3);
                                        applicationInfo = null;
                                    }
                                    if (applicationInfo != null) {
                                        if ((applicationInfo.flags & 1) != 0) {
                                            j3 = 1;
                                            bundle2.putLong("_sys", 1L);
                                        } else {
                                            j3 = 1;
                                        }
                                        if ((applicationInfo.flags & 128) != 0) {
                                            bundle2.putLong("_sysu", j3);
                                        }
                                    }
                                } else {
                                    zzaV().zzb().zzb("PackageManager is null, first open report might be inaccurate. appId", zzgu.zzl(str4));
                                }
                                if (zzN >= 0) {
                                    bundle2.putLong("_pfo", zzN);
                                }
                                if (zzd().zzp(null, zzfy.zzbj)) {
                                    bundle2.putLong(str, zzaZ().currentTimeMillis());
                                }
                                zzE(new zzbg("_f", new zzbe(bundle2), "auto", j8), zzrVar);
                            }
                            str = "_elt";
                            zzhkVar.zza.zzaV().zzf().zza("Install Referrer Reporter was called with invalid app package name");
                            zzaW().zzg();
                            zzu();
                            Bundle bundle22 = new Bundle();
                            long j92 = j2;
                            bundle22.putLong("_c", j92);
                            bundle22.putLong("_r", j92);
                            bundle22.putLong("_uwa", 0L);
                            bundle22.putLong("_pfo", 0L);
                            bundle22.putLong("_sys", 0L);
                            bundle22.putLong("_sysu", 0L);
                            bundle22.putLong("_et", j92);
                            if (zzrVar.zzo) {
                            }
                            String str42 = (String) Preconditions.checkNotNull(zzrVar.zza);
                            zzav zzj2 = zzj();
                            Preconditions.checkNotEmpty(str42);
                            zzj2.zzg();
                            zzj2.zzaw();
                            zzN = zzj2.zzN(str42, "first_open_count");
                            zzicVar = this.zzn;
                            if (zzicVar.zzaY().getPackageManager() == null) {
                            }
                            if (zzN >= 0) {
                            }
                            if (zzd().zzp(null, zzfy.zzbj)) {
                            }
                            zzE(new zzbg("_f", new zzbe(bundle22), "auto", j8), zzrVar);
                        }
                    } else {
                        long j10 = j;
                        if (zzrVar.zzi) {
                            zzE(new zzbg("_cd", new zzbe(new Bundle()), "auto", j10), zzrVar);
                        }
                    }
                    zzj().zzc();
                }
                j = j5;
                j2 = 1;
                if (zzm != null) {
                    zzad("_npa", zzrVar);
                }
                if (!zzd().zzp(null, zzfy.zzbb)) {
                }
                zzao(zzrVar);
                if (i == 0) {
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
    public final void zzai(zzr zzrVar) {
        zzaW().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        int i = 0;
        if (zzd().zzp(null, zzfy.zzaz)) {
            long currentTimeMillis = zzaZ().currentTimeMillis();
            int zzm = zzd().zzm(null, zzfy.zzai);
            zzd();
            long zzF = currentTimeMillis - zzal.zzF();
            while (i < zzm && zzaG(null, zzF)) {
                i++;
            }
        } else {
            zzd();
            long zzH = zzal.zzH();
            while (i < zzH && zzaG(str, 0L)) {
                i++;
            }
        }
        if (zzd().zzp(null, zzfy.zzaA)) {
            zzaW().zzg();
            zzav();
        }
        if (this.zzl.zzc(str, com.google.android.gms.internal.measurement.zzin.zzb(zzrVar.zzE))) {
            zzaV().zzk().zzb("[sgtm] Going background, trigger client side upload. appId", str);
            zzN(str, zzaZ().currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaj(zzah zzahVar) {
        zzr zzaO = zzaO((String) Preconditions.checkNotNull(zzahVar.zza));
        if (zzaO != null) {
            zzak(zzahVar, zzaO);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzak(zzah zzahVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzahVar);
        Preconditions.checkNotEmpty(zzahVar.zza);
        Preconditions.checkNotNull(zzahVar.zzb);
        Preconditions.checkNotNull(zzahVar.zzc);
        Preconditions.checkNotEmpty(zzahVar.zzc.zzb);
        zzaW().zzg();
        zzu();
        if (zzaR(zzrVar)) {
            if (!zzrVar.zzh) {
                zzao(zzrVar);
                return;
            }
            zzah zzahVar2 = new zzah(zzahVar);
            boolean z = false;
            zzahVar2.zze = false;
            zzj().zzb();
            try {
                zzah zzq = zzj().zzq((String) Preconditions.checkNotNull(zzahVar2.zza), zzahVar2.zzc.zzb);
                if (zzq != null && !zzq.zzb.equals(zzahVar2.zzb)) {
                    zzaV().zze().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzb, zzq.zzb);
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
                        zzaV().zzj().zzd("User property updated immediately", zzahVar2.zza, this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                    } else {
                        zzaV().zzb().zzd("(2)Too many active user properties, ignoring", zzgu.zzl(zzahVar2.zza), this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                    }
                    if (z && zzahVar2.zzi != null) {
                        zzH(new zzbg(zzahVar2.zzi, zzahVar2.zzd), zzrVar);
                    }
                }
                if (zzj().zzp(zzahVar2)) {
                    zzaV().zzj().zzd("Conditional property added", zzahVar2.zza, this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                } else {
                    zzaV().zzb().zzd("Too many conditional properties, ignoring", zzgu.zzl(zzahVar2.zza), this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzal(zzah zzahVar) {
        zzr zzaO = zzaO((String) Preconditions.checkNotNull(zzahVar.zza));
        if (zzaO != null) {
            zzam(zzahVar, zzaO);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzam(zzah zzahVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzahVar);
        Preconditions.checkNotEmpty(zzahVar.zza);
        Preconditions.checkNotNull(zzahVar.zzc);
        Preconditions.checkNotEmpty(zzahVar.zzc.zzb);
        zzaW().zzg();
        zzu();
        if (zzaR(zzrVar)) {
            if (!zzrVar.zzh) {
                zzao(zzrVar);
                return;
            }
            zzj().zzb();
            try {
                zzao(zzrVar);
                String str = (String) Preconditions.checkNotNull(zzahVar.zza);
                zzah zzq = zzj().zzq(str, zzahVar.zzc.zzb);
                if (zzq != null) {
                    zzaV().zzj().zzc("Removing conditional user property", zzahVar.zza, this.zzn.zzl().zzc(zzahVar.zzc.zzb));
                    zzj().zzr(str, zzahVar.zzc.zzb);
                    if (zzq.zze) {
                        zzj().zzk(str, zzahVar.zzc.zzb);
                    }
                    zzbg zzbgVar = zzahVar.zzk;
                    if (zzbgVar != null) {
                        zzbe zzbeVar = zzbgVar.zzb;
                        zzH((zzbg) Preconditions.checkNotNull(zzt().zzac(str, ((zzbg) Preconditions.checkNotNull(zzbgVar)).zza, zzbeVar != null ? zzbeVar.zzf() : null, zzq.zzb, zzbgVar.zzd, true, true)), zzrVar);
                    }
                } else {
                    zzaV().zze().zzc("Conditional user property doesn't exist", zzgu.zzl(zzahVar.zza), this.zzn.zzl().zzc(zzahVar.zzc.zzb));
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    final void zzan(zzr zzrVar, long j) {
        zzh zzu = zzj().zzu((String) Preconditions.checkNotNull(zzrVar.zza));
        boolean z = true;
        if (zzu != null && zzt().zzB(zzrVar.zzb, zzu.zzf())) {
            zzaV().zze().zzb("New GMP App Id passed in. Removing cached database data. appId", zzgu.zzl(zzu.zzc()));
            zzav zzj = zzj();
            String zzc = zzu.zzc();
            zzj.zzaw();
            zzj.zzg();
            Preconditions.checkNotEmpty(zzc);
            try {
                SQLiteDatabase zze = zzj.zze();
                String[] strArr = {zzc};
                int delete = zze.delete("events", "app_id=?", strArr) + zze.delete("user_attributes", "app_id=?", strArr) + zze.delete("conditional_properties", "app_id=?", strArr) + zze.delete("apps", "app_id=?", strArr) + zze.delete("raw_events", "app_id=?", strArr) + zze.delete("raw_events_metadata", "app_id=?", strArr) + zze.delete("event_filters", "app_id=?", strArr) + zze.delete("property_filters", "app_id=?", strArr) + zze.delete("audience_filter_values", "app_id=?", strArr) + zze.delete("consent_settings", "app_id=?", strArr) + zze.delete("default_event_params", "app_id=?", strArr) + zze.delete("trigger_uris", "app_id=?", strArr);
                com.google.android.gms.internal.measurement.zzpo.zza();
                zzic zzicVar = zzj.zzu;
                if (zzicVar.zzc().zzp(null, zzfy.zzbh)) {
                    delete += zze.delete("no_data_mode_events", "app_id=?", strArr);
                }
                if (delete > 0) {
                    zzicVar.zzaV().zzk().zzc("Deleted application data. app, records", zzc, Integer.valueOf(delete));
                }
            } catch (SQLiteException e) {
                zzj.zzu.zzaV().zzb().zzc("Error deleting application data. appId, error", zzgu.zzl(zzc), e);
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
                zzbg zzbgVar = new zzbg("_au", new zzbe(bundle), "auto", j);
                if (zzd().zzp(null, zzfy.zzbc)) {
                    zzE(zzbgVar, zzrVar);
                } else {
                    zzF(zzbgVar, zzrVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzh zzao(zzr zzrVar) {
        String str;
        boolean z;
        String str2;
        long j;
        String str3;
        String str4;
        String str5;
        zzaW().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str6 = zzrVar.zza;
        Preconditions.checkNotEmpty(str6);
        String str7 = zzrVar.zzt;
        if (!str7.isEmpty()) {
            this.zzE.put(str6, new zzpd(this, str7, null));
        }
        zzh zzu = zzj().zzu(str6);
        zzjl zzs = zzB(str6).zzs(zzjl.zzf(zzrVar.zzs, 100));
        zzjk zzjkVar = zzjk.AD_STORAGE;
        if (zzs.zzo(zzjkVar)) {
            str = this.zzk.zzf(str6, zzrVar.zzn);
        } else {
            str = "";
        }
        boolean z2 = true;
        if (zzu == null) {
            zzh zzhVar = new zzh(this.zzn, str6);
            if (zzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                zzhVar.zze(zzK(zzs));
            }
            if (zzs.zzo(zzjkVar)) {
                zzhVar.zzk(str);
            }
            zzu = zzhVar;
        } else if (!zzs.zzo(zzjkVar) || str == null || str.equals(zzu.zzj())) {
            if (TextUtils.isEmpty(zzu.zzd()) && zzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                zzu.zze(zzK(zzs));
            }
        } else {
            boolean isEmpty = TextUtils.isEmpty(zzu.zzj());
            zzu.zzk(str);
            if (!zzrVar.zzn || "00000000-0000-0000-0000-000000000000".equals(this.zzk.zzc(str6, zzs).first) || isEmpty) {
                if (TextUtils.isEmpty(zzu.zzd()) && zzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                    zzu.zze(zzK(zzs));
                }
            } else {
                if (zzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                    zzu.zze(zzK(zzs));
                    z = false;
                } else {
                    z = true;
                }
                if (zzj().zzm(str6, APEZProvider.FILEID) != null && zzj().zzm(str6, "_lair") == null) {
                    zzj().zzl(new zzpn(str6, "auto", "_lair", zzaZ().currentTimeMillis(), 1L));
                }
                zzu.zzg(zzrVar.zzb);
                str2 = zzrVar.zzk;
                if (!TextUtils.isEmpty(str2)) {
                    zzu.zzm(str2);
                }
                j = zzrVar.zze;
                if (j != 0) {
                    zzu.zzy(j);
                }
                str3 = zzrVar.zzc;
                if (!TextUtils.isEmpty(str3)) {
                    zzu.zzs(str3);
                }
                zzu.zzu(zzrVar.zzj);
                str4 = zzrVar.zzd;
                if (str4 != null) {
                    zzu.zzw(str4);
                }
                zzu.zzA(zzrVar.zzf);
                zzu.zzE(zzrVar.zzh);
                str5 = zzrVar.zzg;
                if (!TextUtils.isEmpty(str5)) {
                    zzu.zzab(str5);
                }
                zzu.zzad(zzrVar.zzn);
                zzu.zzaf(zzrVar.zzp);
                zzu.zzC(zzrVar.zzq);
                zzu.zzi(zzrVar.zzu);
                zzpr.zza();
                if (zzd().zzp(null, zzfy.zzaL)) {
                    zzpr.zza();
                    if (zzd().zzp(null, zzfy.zzaK)) {
                        zzu.zzah(null);
                    }
                } else {
                    zzu.zzah(zzrVar.zzr);
                }
                zzu.zzaj(zzrVar.zzv);
                zzu.zzaz(zzrVar.zzB);
                zzqp.zza();
                if (zzd().zzp(null, zzfy.zzaP)) {
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
            }
        }
        z = false;
        zzu.zzg(zzrVar.zzb);
        str2 = zzrVar.zzk;
        if (!TextUtils.isEmpty(str2)) {
        }
        j = zzrVar.zze;
        if (j != 0) {
        }
        str3 = zzrVar.zzc;
        if (!TextUtils.isEmpty(str3)) {
        }
        zzu.zzu(zzrVar.zzj);
        str4 = zzrVar.zzd;
        if (str4 != null) {
        }
        zzu.zzA(zzrVar.zzf);
        zzu.zzE(zzrVar.zzh);
        str5 = zzrVar.zzg;
        if (!TextUtils.isEmpty(str5)) {
        }
        zzu.zzad(zzrVar.zzn);
        zzu.zzaf(zzrVar.zzp);
        zzu.zzC(zzrVar.zzq);
        zzu.zzi(zzrVar.zzu);
        zzpr.zza();
        if (zzd().zzp(null, zzfy.zzaL)) {
        }
        zzu.zzaj(zzrVar.zzv);
        zzu.zzaz(zzrVar.zzB);
        zzqp.zza();
        if (zzd().zzp(null, zzfy.zzaP)) {
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
    public final String zzap(zzr zzrVar) {
        try {
            return (String) zzaW().zzh(new zzoz(this, zzrVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzaV().zzb().zzc("Failed to get app instance id. appId", zzgu.zzl(zzrVar.zza), e);
            return null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:28:0x00a8
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    final java.util.List zzaq(com.google.android.gms.measurement.internal.zzr r21, android.os.Bundle r22) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpg.zzaq(com.google.android.gms.measurement.internal.zzr, android.os.Bundle):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzar(String str, zzaf zzafVar) {
        zzaW().zzg();
        zzu();
        zzav zzj = zzj();
        long j = zzafVar.zza;
        zzpj zzB = zzj.zzB(j);
        if (zzB == null) {
            zzaV().zze().zzc("[sgtm] Queued batch doesn't exist. appId, rowId", str, Long.valueOf(j));
            return;
        }
        String zze = zzB.zze();
        if (zzafVar.zzb == zzlr.SUCCESS.zza()) {
            Map map = this.zzF;
            if (map.containsKey(zze)) {
                map.remove(zze);
            }
            zzav zzj2 = zzj();
            Long valueOf = Long.valueOf(j);
            zzj2.zzE(valueOf);
            zzaV().zzk().zzc("[sgtm] queued batch deleted after successful client upload. appId, rowId", str, valueOf);
            long j2 = zzafVar.zzc;
            if (j2 > 0) {
                zzav zzj3 = zzj();
                zzj3.zzg();
                zzj3.zzaw();
                Long valueOf2 = Long.valueOf(j2);
                Preconditions.checkNotNull(valueOf2);
                ContentValues contentValues = new ContentValues();
                contentValues.put("upload_type", Integer.valueOf(zzls.GOOGLE_SIGNAL.zza()));
                zzic zzicVar = zzj3.zzu;
                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzicVar.zzaZ().currentTimeMillis()));
                try {
                    if (zzj3.zze().update("upload_queue", contentValues, "rowid=? AND app_id=? AND upload_type=?", new String[]{String.valueOf(j2), str, String.valueOf(zzls.GOOGLE_SIGNAL_PENDING.zza())}) != 1) {
                        zzicVar.zzaV().zze().zzc("Google Signal pending batch not updated. appId, rowId", str, valueOf2);
                    }
                    zzaV().zzk().zzc("[sgtm] queued Google Signal batch updated. appId, signalRowId", str, Long.valueOf(zzafVar.zzc));
                    zzP(str);
                    return;
                } catch (SQLiteException e) {
                    zzj3.zzu.zzaV().zzb().zzd("Failed to update google Signal pending batch. appid, rowId", str, Long.valueOf(j2), e);
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
            zzaV().zzk().zzd("[sgtm] Putting sGTM server in backoff mode. appId, destination, nextRetryInSeconds", str, zze, Long.valueOf((zzpeVar.zzc() - zzaZ().currentTimeMillis()) / 1000));
        }
        zzav zzj4 = zzj();
        Long valueOf3 = Long.valueOf(zzafVar.zza);
        zzj4.zzK(valueOf3);
        zzaV().zzk().zzc("[sgtm] increased batch retry count after failed client upload. appId, rowId", str, valueOf3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzas(boolean z) {
        zzaL();
    }

    public final void zzat(String str, zzlu zzluVar) {
        zzaW().zzg();
        String str2 = this.zzH;
        if (str2 == null || str2.equals(str) || zzluVar != null) {
            this.zzH = str;
            this.zzG = zzluVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzau(zzph zzphVar) {
        zzaW().zzg();
        this.zzm = new zzhk(this);
        zzav zzavVar = new zzav(this);
        zzavVar.zzax();
        this.zze = zzavVar;
        zzd().zza((zzak) Preconditions.checkNotNull(this.zzc));
        zznn zznnVar = new zznn(this);
        zznnVar.zzax();
        this.zzk = zznnVar;
        zzad zzadVar = new zzad(this);
        zzadVar.zzax();
        this.zzh = zzadVar;
        zzlp zzlpVar = new zzlp(this);
        zzlpVar.zzax();
        this.zzj = zzlpVar;
        zzok zzokVar = new zzok(this);
        zzokVar.zzax();
        this.zzg = zzokVar;
        this.zzf = new zzhb(this);
        if (this.zzs != this.zzt) {
            zzaV().zzb().zzc("Not all upload components initialized", Integer.valueOf(this.zzs), Integer.valueOf(this.zzt));
        }
        this.zzo.set(true);
        zzaV().zzk().zza("UploadController is now fully initialized");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzic zzax() {
        return this.zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Deque zzay() {
        return this.zzr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaz(long j) {
        this.zzJ = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzc() {
        zzaW().zzg();
        zzj().zzI();
        zzav zzj = zzj();
        zzj.zzg();
        zzj.zzaw();
        if (zzj.zzag()) {
            zzfx zzfxVar = zzfy.zzav;
            if (((Long) zzfxVar.zzb(null)).longValue() != 0) {
                SQLiteDatabase zze = zzj.zze();
                zzic zzicVar = zzj.zzu;
                int delete = zze.delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(zzicVar.zzaZ().currentTimeMillis()), String.valueOf(zzfxVar.zzb(null))});
                if (delete > 0) {
                    zzicVar.zzaV().zzk().zzb("Deleted stale trigger uris. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
        if (this.zzk.zzd.zza() == 0) {
            this.zzk.zzd.zzb(zzaZ().currentTimeMillis());
        }
        zzaL();
    }

    public final zzal zzd() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzc();
    }

    public final zzou zzf() {
        return this.zzl;
    }

    public final zzht zzh() {
        zzht zzhtVar = this.zzc;
        zzaS(zzhtVar);
        return zzhtVar;
    }

    public final zzgz zzi() {
        zzgz zzgzVar = this.zzd;
        zzaS(zzgzVar);
        return zzgzVar;
    }

    public final zzav zzj() {
        zzav zzavVar = this.zze;
        zzaS(zzavVar);
        return zzavVar;
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
        zzaS(zzokVar);
        return zzokVar;
    }

    public final zzad zzm() {
        zzad zzadVar = this.zzh;
        zzaS(zzadVar);
        return zzadVar;
    }

    public final zzlp zzn() {
        zzlp zzlpVar = this.zzj;
        zzaS(zzlpVar);
        return zzlpVar;
    }

    public final zzpk zzp() {
        zzpk zzpkVar = this.zzi;
        zzaS(zzpkVar);
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
        zzaW().zzg();
        zzu();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzjl zzf = zzjl.zzf(zzrVar.zzs, zzrVar.zzx);
        zzB(str);
        zzaV().zzk().zzc("Setting storage consent for package", str, zzf);
        zzA(str, zzf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzw(zzr zzrVar) {
        zzaW().zzg();
        zzu();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzaz zzg = zzaz.zzg(zzrVar.zzy);
        zzaV().zzk().zzc("Setting DMA consent for package", str, zzg);
        zzaW().zzg();
        zzu();
        zzji zzc = zzaz.zzh(zzy(str), 100).zzc();
        this.zzD.put(str, zzg);
        zzj().zzab(str, zzg);
        zzji zzc2 = zzaz.zzh(zzy(str), 100).zzc();
        zzaW().zzg();
        zzu();
        zzji zzjiVar = zzji.DENIED;
        boolean z = true;
        boolean z2 = zzc == zzjiVar && zzc2 == zzji.GRANTED;
        if (zzc != zzji.GRANTED || zzc2 != zzjiVar) {
            z = false;
        }
        if (z2 || z) {
            zzaV().zzk().zzb("Generated _dcu event for", str);
            Bundle bundle = new Bundle();
            if (zzj().zzw(zzC(), str, false, false, false, false, false, false, false).zzf < zzd().zzm(str, zzfy.zzam)) {
                bundle.putLong("_r", 1L);
                zzaV().zzk().zzc("_dcu realtime event count", str, Long.valueOf(zzj().zzw(zzC(), str, false, false, false, false, false, true, false).zzf));
            }
            this.zzK.zza(str, "_dcu", bundle);
        }
    }

    final zzaz zzx(String str) {
        zzaW().zzg();
        zzu();
        Map map = this.zzD;
        zzaz zzazVar = (zzaz) map.get(str);
        if (zzazVar == null) {
            zzaz zzaa = zzj().zzaa(str);
            map.put(str, zzaa);
            return zzaa;
        }
        return zzazVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zzy(String str) {
        boolean z;
        String str2;
        zzaW().zzg();
        zzu();
        if (zzh().zzx(str) == null) {
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
            z = zzaC(str, new zzan());
        }
        if (1 != z) {
            str2 = "granted";
        } else {
            str2 = "denied";
        }
        bundle.putString("ad_personalization", str2);
        return bundle;
    }

    final zzaz zzz(String str, zzaz zzazVar, zzjl zzjlVar, zzan zzanVar) {
        zzji zzjiVar;
        int i = 90;
        boolean z = false;
        if (zzh().zzx(str) == null) {
            if (zzazVar.zzc() == zzji.DENIED) {
                i = zzazVar.zzb();
                zzanVar.zzb(zzjk.AD_USER_DATA, i);
            } else {
                zzanVar.zzc(zzjk.AD_USER_DATA, zzam.FAILSAFE);
            }
            return new zzaz((Boolean) false, i, (Boolean) true, com.google.android.vending.expansion.downloader.Constants.FILENAME_SEQUENCE_SEPARATOR);
        }
        zzji zzc = zzazVar.zzc();
        zzji zzjiVar2 = zzji.GRANTED;
        if (zzc == zzjiVar2 || zzc == (zzjiVar = zzji.DENIED)) {
            i = zzazVar.zzb();
            zzanVar.zzb(zzjk.AD_USER_DATA, i);
        } else {
            if (zzc == zzji.POLICY) {
                zzht zzhtVar = this.zzc;
                zzjk zzjkVar = zzjk.AD_USER_DATA;
                zzji zzA = zzhtVar.zzA(str, zzjkVar);
                if (zzA != zzji.UNINITIALIZED) {
                    zzanVar.zzc(zzjkVar, zzam.REMOTE_ENFORCED_DEFAULT);
                    zzc = zzA;
                }
            }
            zzht zzhtVar2 = this.zzc;
            zzjk zzjkVar2 = zzjk.AD_USER_DATA;
            zzjk zzw = zzhtVar2.zzw(str, zzjkVar2);
            zzji zzp = zzjlVar.zzp();
            if (zzp == zzjiVar2 || zzp == zzjiVar) {
                z = true;
            }
            if (zzw != zzjk.AD_STORAGE || !z) {
                zzanVar.zzc(zzjkVar2, zzam.REMOTE_DEFAULT);
                zzc = true != zzhtVar2.zzv(str, zzjkVar2) ? zzjiVar : zzjiVar2;
            } else {
                zzanVar.zzc(zzjkVar2, zzam.REMOTE_DELEGATION);
                zzc = zzp;
            }
        }
        boolean zzy = this.zzc.zzy(str);
        SortedSet zzz = zzh().zzz(str);
        if (zzc == zzji.DENIED || zzz.isEmpty()) {
            return new zzaz((Boolean) false, i, Boolean.valueOf(zzy), com.google.android.vending.expansion.downloader.Constants.FILENAME_SEQUENCE_SEPARATOR);
        }
        return new zzaz((Boolean) true, i, Boolean.valueOf(zzy), zzy ? TextUtils.join("", zzz) : "");
    }
}
