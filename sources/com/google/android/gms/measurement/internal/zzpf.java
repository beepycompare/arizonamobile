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
import com.google.android.gms.internal.measurement.zzql;
import com.google.android.gms.internal.measurement.zzqu;
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
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzpf implements zzjf {
    private static volatile zzpf zzb;
    private List zzA;
    private long zzB;
    private final Map zzC;
    private final Map zzD;
    private final Map zzE;
    private zzlt zzG;
    private String zzH;
    private zzay zzI;
    private long zzJ;
    long zza;
    private final zzhs zzc;
    private final zzgy zzd;
    private zzav zze;
    private zzha zzf;
    private zzoj zzg;
    private zzad zzh;
    private final zzpj zzi;
    private zzlo zzj;
    private zznm zzk;
    private final zzot zzl;
    private zzhj zzm;
    private final zzib zzn;
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
    private final zzpn zzK = new zzpa(this);

    zzpf(zzpg zzpgVar, zzib zzibVar) {
        Preconditions.checkNotNull(zzpgVar);
        this.zzn = zzib.zzy(zzpgVar.zza, null, null);
        this.zzB = -1L;
        this.zzl = new zzot(this);
        zzpj zzpjVar = new zzpj(this);
        zzpjVar.zzaz();
        this.zzi = zzpjVar;
        zzgy zzgyVar = new zzgy(this);
        zzgyVar.zzaz();
        this.zzd = zzgyVar;
        zzhs zzhsVar = new zzhs(this);
        zzhsVar.zzaz();
        this.zzc = zzhsVar;
        this.zzC = new HashMap();
        this.zzD = new HashMap();
        this.zzE = new HashMap();
        zzaW().zzj(new zzou(this, zzpgVar));
    }

    public static zzpf zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzpf.class) {
                if (zzb == null) {
                    zzb = new zzpf((zzpg) Preconditions.checkNotNull(new zzpg(context)), null);
                }
            }
        }
        return zzb;
    }

    static final void zzaA(com.google.android.gms.internal.measurement.zzhr zzhrVar, String str) {
        List zza = zzhrVar.zza();
        for (int i = 0; i < zza.size(); i++) {
            if (str.equals(((com.google.android.gms.internal.measurement.zzhw) zza.get(i)).zzb())) {
                zzhrVar.zzj(i);
                return;
            }
        }
    }

    private final int zzaB(String str, zzan zzanVar) {
        zzjj zzjjVar;
        zzjh zzA;
        zzhs zzhsVar = this.zzc;
        if (zzhsVar.zzx(str) == null) {
            zzanVar.zzc(zzjj.AD_PERSONALIZATION, zzam.FAILSAFE);
            return 1;
        }
        zzh zzu = zzj().zzu(str);
        if (zzu == null || zze.zzc(zzu.zzaH()).zza() != zzjh.POLICY || (zzA = zzhsVar.zzA(str, (zzjjVar = zzjj.AD_PERSONALIZATION))) == zzjh.UNINITIALIZED) {
            zzjj zzjjVar2 = zzjj.AD_PERSONALIZATION;
            zzanVar.zzc(zzjjVar2, zzam.REMOTE_DEFAULT);
            return zzhsVar.zzv(str, zzjjVar2) ? 0 : 1;
        }
        zzanVar.zzc(zzjjVar, zzam.REMOTE_ENFORCED_DEFAULT);
        return zzA == zzjh.GRANTED ? 0 : 1;
    }

    private final Map zzaC(com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        HashMap hashMap = new HashMap();
        zzp();
        for (Map.Entry entry : zzpj.zzH(zzhsVar, "gad_").entrySet()) {
            hashMap.put((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
        return hashMap;
    }

    private final zzay zzaD() {
        if (this.zzI == null) {
            this.zzI = new zzox(this, this.zzn);
        }
        return this.zzI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzaE */
    public final void zzau() {
        zzaW().zzg();
        if (this.zzr.isEmpty() || zzaD().zzc()) {
            return;
        }
        long max = Math.max(0L, ((Integer) zzfx.zzaB.zzb(null)).intValue() - (zzaZ().elapsedRealtime() - this.zzJ));
        zzaV().zzk().zzb("Scheduling notify next app runnable, delay in ms", Long.valueOf(max));
        zzaD().zzb(max);
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03ab A[Catch: all -> 0x0eac, TryCatch #2 {all -> 0x0eac, blocks: (B:3:0x000f, B:5:0x0026, B:8:0x002e, B:9:0x0041, B:12:0x005b, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:207:0x066e, B:24:0x0100, B:27:0x0112, B:29:0x0118, B:44:0x015a, B:46:0x0168, B:49:0x0188, B:51:0x018e, B:53:0x019e, B:55:0x01ac, B:57:0x01bc, B:58:0x01c9, B:59:0x01cc, B:61:0x01e0, B:114:0x03dc, B:115:0x03e8, B:118:0x03f4, B:124:0x0417, B:121:0x0406, B:147:0x049a, B:149:0x04a6, B:152:0x04b7, B:154:0x04c9, B:156:0x04d5, B:173:0x0543, B:175:0x0549, B:176:0x0555, B:178:0x055b, B:180:0x056b, B:182:0x0575, B:183:0x058a, B:185:0x0590, B:186:0x05ab, B:188:0x05b1, B:189:0x05cf, B:190:0x05d8, B:194:0x05fd, B:191:0x05dc, B:193:0x05ea, B:195:0x0606, B:196:0x061e, B:198:0x0624, B:200:0x0637, B:201:0x0644, B:202:0x0648, B:204:0x064e, B:206:0x065c, B:160:0x04eb, B:162:0x04f9, B:165:0x050c, B:167:0x051e, B:169:0x052a, B:128:0x0421, B:130:0x042d, B:132:0x0439, B:144:0x047e, B:136:0x0456, B:139:0x0468, B:141:0x046e, B:143:0x0478, B:70:0x020d, B:73:0x0217, B:75:0x0225, B:79:0x026c, B:76:0x0242, B:78:0x0252, B:83:0x0279, B:86:0x02a8, B:87:0x02d2, B:89:0x030b, B:91:0x0313, B:94:0x031f, B:96:0x0356, B:97:0x0371, B:99:0x0377, B:101:0x0387, B:105:0x039d, B:102:0x0391, B:108:0x03a4, B:111:0x03ab, B:112:0x03c3, B:33:0x0122, B:35:0x012f, B:37:0x013b, B:39:0x0141, B:43:0x014c, B:210:0x0686, B:212:0x0694, B:214:0x069d, B:225:0x06ce, B:215:0x06a5, B:217:0x06ae, B:219:0x06b4, B:222:0x06c0, B:224:0x06c8, B:226:0x06d1, B:227:0x06dd, B:230:0x06e5, B:232:0x06f7, B:233:0x0702, B:235:0x070a, B:239:0x0730, B:241:0x074a, B:243:0x075f, B:245:0x0779, B:247:0x078e, B:249:0x07d3, B:251:0x07d9, B:257:0x0800, B:259:0x0808, B:260:0x0811, B:262:0x0817, B:263:0x081d, B:265:0x0832, B:267:0x0842, B:269:0x0852, B:272:0x085b, B:274:0x0861, B:275:0x0873, B:277:0x0879, B:279:0x0889, B:281:0x08a1, B:283:0x08b3, B:285:0x08da, B:286:0x08f3, B:288:0x0905, B:290:0x0924, B:292:0x094b, B:294:0x097b, B:295:0x0986, B:297:0x0998, B:299:0x09b7, B:301:0x09de, B:303:0x0a0e, B:304:0x0a17, B:305:0x0a20, B:306:0x0a24, B:314:0x0a98, B:316:0x0ab1, B:318:0x0ac7, B:320:0x0acc, B:322:0x0ad0, B:324:0x0ad4, B:326:0x0ade, B:327:0x0ae4, B:329:0x0ae8, B:331:0x0aee, B:332:0x0afc, B:333:0x0b05, B:338:0x0b29, B:341:0x0b2f, B:439:0x0e1e, B:441:0x0e33, B:444:0x0e3a, B:449:0x0e6b, B:451:0x0e7d, B:445:0x0e42, B:447:0x0e4e, B:448:0x0e54, B:252:0x07e7, B:254:0x07ed, B:256:0x07f3, B:246:0x078b, B:242:0x075c, B:236:0x0710, B:238:0x0716, B:454:0x0e9b), top: B:465:0x000f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03c3 A[Catch: all -> 0x0eac, TryCatch #2 {all -> 0x0eac, blocks: (B:3:0x000f, B:5:0x0026, B:8:0x002e, B:9:0x0041, B:12:0x005b, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:207:0x066e, B:24:0x0100, B:27:0x0112, B:29:0x0118, B:44:0x015a, B:46:0x0168, B:49:0x0188, B:51:0x018e, B:53:0x019e, B:55:0x01ac, B:57:0x01bc, B:58:0x01c9, B:59:0x01cc, B:61:0x01e0, B:114:0x03dc, B:115:0x03e8, B:118:0x03f4, B:124:0x0417, B:121:0x0406, B:147:0x049a, B:149:0x04a6, B:152:0x04b7, B:154:0x04c9, B:156:0x04d5, B:173:0x0543, B:175:0x0549, B:176:0x0555, B:178:0x055b, B:180:0x056b, B:182:0x0575, B:183:0x058a, B:185:0x0590, B:186:0x05ab, B:188:0x05b1, B:189:0x05cf, B:190:0x05d8, B:194:0x05fd, B:191:0x05dc, B:193:0x05ea, B:195:0x0606, B:196:0x061e, B:198:0x0624, B:200:0x0637, B:201:0x0644, B:202:0x0648, B:204:0x064e, B:206:0x065c, B:160:0x04eb, B:162:0x04f9, B:165:0x050c, B:167:0x051e, B:169:0x052a, B:128:0x0421, B:130:0x042d, B:132:0x0439, B:144:0x047e, B:136:0x0456, B:139:0x0468, B:141:0x046e, B:143:0x0478, B:70:0x020d, B:73:0x0217, B:75:0x0225, B:79:0x026c, B:76:0x0242, B:78:0x0252, B:83:0x0279, B:86:0x02a8, B:87:0x02d2, B:89:0x030b, B:91:0x0313, B:94:0x031f, B:96:0x0356, B:97:0x0371, B:99:0x0377, B:101:0x0387, B:105:0x039d, B:102:0x0391, B:108:0x03a4, B:111:0x03ab, B:112:0x03c3, B:33:0x0122, B:35:0x012f, B:37:0x013b, B:39:0x0141, B:43:0x014c, B:210:0x0686, B:212:0x0694, B:214:0x069d, B:225:0x06ce, B:215:0x06a5, B:217:0x06ae, B:219:0x06b4, B:222:0x06c0, B:224:0x06c8, B:226:0x06d1, B:227:0x06dd, B:230:0x06e5, B:232:0x06f7, B:233:0x0702, B:235:0x070a, B:239:0x0730, B:241:0x074a, B:243:0x075f, B:245:0x0779, B:247:0x078e, B:249:0x07d3, B:251:0x07d9, B:257:0x0800, B:259:0x0808, B:260:0x0811, B:262:0x0817, B:263:0x081d, B:265:0x0832, B:267:0x0842, B:269:0x0852, B:272:0x085b, B:274:0x0861, B:275:0x0873, B:277:0x0879, B:279:0x0889, B:281:0x08a1, B:283:0x08b3, B:285:0x08da, B:286:0x08f3, B:288:0x0905, B:290:0x0924, B:292:0x094b, B:294:0x097b, B:295:0x0986, B:297:0x0998, B:299:0x09b7, B:301:0x09de, B:303:0x0a0e, B:304:0x0a17, B:305:0x0a20, B:306:0x0a24, B:314:0x0a98, B:316:0x0ab1, B:318:0x0ac7, B:320:0x0acc, B:322:0x0ad0, B:324:0x0ad4, B:326:0x0ade, B:327:0x0ae4, B:329:0x0ae8, B:331:0x0aee, B:332:0x0afc, B:333:0x0b05, B:338:0x0b29, B:341:0x0b2f, B:439:0x0e1e, B:441:0x0e33, B:444:0x0e3a, B:449:0x0e6b, B:451:0x0e7d, B:445:0x0e42, B:447:0x0e4e, B:448:0x0e54, B:252:0x07e7, B:254:0x07ed, B:256:0x07f3, B:246:0x078b, B:242:0x075c, B:236:0x0710, B:238:0x0716, B:454:0x0e9b), top: B:465:0x000f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03dc A[Catch: all -> 0x0eac, TryCatch #2 {all -> 0x0eac, blocks: (B:3:0x000f, B:5:0x0026, B:8:0x002e, B:9:0x0041, B:12:0x005b, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:207:0x066e, B:24:0x0100, B:27:0x0112, B:29:0x0118, B:44:0x015a, B:46:0x0168, B:49:0x0188, B:51:0x018e, B:53:0x019e, B:55:0x01ac, B:57:0x01bc, B:58:0x01c9, B:59:0x01cc, B:61:0x01e0, B:114:0x03dc, B:115:0x03e8, B:118:0x03f4, B:124:0x0417, B:121:0x0406, B:147:0x049a, B:149:0x04a6, B:152:0x04b7, B:154:0x04c9, B:156:0x04d5, B:173:0x0543, B:175:0x0549, B:176:0x0555, B:178:0x055b, B:180:0x056b, B:182:0x0575, B:183:0x058a, B:185:0x0590, B:186:0x05ab, B:188:0x05b1, B:189:0x05cf, B:190:0x05d8, B:194:0x05fd, B:191:0x05dc, B:193:0x05ea, B:195:0x0606, B:196:0x061e, B:198:0x0624, B:200:0x0637, B:201:0x0644, B:202:0x0648, B:204:0x064e, B:206:0x065c, B:160:0x04eb, B:162:0x04f9, B:165:0x050c, B:167:0x051e, B:169:0x052a, B:128:0x0421, B:130:0x042d, B:132:0x0439, B:144:0x047e, B:136:0x0456, B:139:0x0468, B:141:0x046e, B:143:0x0478, B:70:0x020d, B:73:0x0217, B:75:0x0225, B:79:0x026c, B:76:0x0242, B:78:0x0252, B:83:0x0279, B:86:0x02a8, B:87:0x02d2, B:89:0x030b, B:91:0x0313, B:94:0x031f, B:96:0x0356, B:97:0x0371, B:99:0x0377, B:101:0x0387, B:105:0x039d, B:102:0x0391, B:108:0x03a4, B:111:0x03ab, B:112:0x03c3, B:33:0x0122, B:35:0x012f, B:37:0x013b, B:39:0x0141, B:43:0x014c, B:210:0x0686, B:212:0x0694, B:214:0x069d, B:225:0x06ce, B:215:0x06a5, B:217:0x06ae, B:219:0x06b4, B:222:0x06c0, B:224:0x06c8, B:226:0x06d1, B:227:0x06dd, B:230:0x06e5, B:232:0x06f7, B:233:0x0702, B:235:0x070a, B:239:0x0730, B:241:0x074a, B:243:0x075f, B:245:0x0779, B:247:0x078e, B:249:0x07d3, B:251:0x07d9, B:257:0x0800, B:259:0x0808, B:260:0x0811, B:262:0x0817, B:263:0x081d, B:265:0x0832, B:267:0x0842, B:269:0x0852, B:272:0x085b, B:274:0x0861, B:275:0x0873, B:277:0x0879, B:279:0x0889, B:281:0x08a1, B:283:0x08b3, B:285:0x08da, B:286:0x08f3, B:288:0x0905, B:290:0x0924, B:292:0x094b, B:294:0x097b, B:295:0x0986, B:297:0x0998, B:299:0x09b7, B:301:0x09de, B:303:0x0a0e, B:304:0x0a17, B:305:0x0a20, B:306:0x0a24, B:314:0x0a98, B:316:0x0ab1, B:318:0x0ac7, B:320:0x0acc, B:322:0x0ad0, B:324:0x0ad4, B:326:0x0ade, B:327:0x0ae4, B:329:0x0ae8, B:331:0x0aee, B:332:0x0afc, B:333:0x0b05, B:338:0x0b29, B:341:0x0b2f, B:439:0x0e1e, B:441:0x0e33, B:444:0x0e3a, B:449:0x0e6b, B:451:0x0e7d, B:445:0x0e42, B:447:0x0e4e, B:448:0x0e54, B:252:0x07e7, B:254:0x07ed, B:256:0x07f3, B:246:0x078b, B:242:0x075c, B:236:0x0710, B:238:0x0716, B:454:0x0e9b), top: B:465:0x000f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04a6 A[Catch: all -> 0x0eac, TryCatch #2 {all -> 0x0eac, blocks: (B:3:0x000f, B:5:0x0026, B:8:0x002e, B:9:0x0041, B:12:0x005b, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:207:0x066e, B:24:0x0100, B:27:0x0112, B:29:0x0118, B:44:0x015a, B:46:0x0168, B:49:0x0188, B:51:0x018e, B:53:0x019e, B:55:0x01ac, B:57:0x01bc, B:58:0x01c9, B:59:0x01cc, B:61:0x01e0, B:114:0x03dc, B:115:0x03e8, B:118:0x03f4, B:124:0x0417, B:121:0x0406, B:147:0x049a, B:149:0x04a6, B:152:0x04b7, B:154:0x04c9, B:156:0x04d5, B:173:0x0543, B:175:0x0549, B:176:0x0555, B:178:0x055b, B:180:0x056b, B:182:0x0575, B:183:0x058a, B:185:0x0590, B:186:0x05ab, B:188:0x05b1, B:189:0x05cf, B:190:0x05d8, B:194:0x05fd, B:191:0x05dc, B:193:0x05ea, B:195:0x0606, B:196:0x061e, B:198:0x0624, B:200:0x0637, B:201:0x0644, B:202:0x0648, B:204:0x064e, B:206:0x065c, B:160:0x04eb, B:162:0x04f9, B:165:0x050c, B:167:0x051e, B:169:0x052a, B:128:0x0421, B:130:0x042d, B:132:0x0439, B:144:0x047e, B:136:0x0456, B:139:0x0468, B:141:0x046e, B:143:0x0478, B:70:0x020d, B:73:0x0217, B:75:0x0225, B:79:0x026c, B:76:0x0242, B:78:0x0252, B:83:0x0279, B:86:0x02a8, B:87:0x02d2, B:89:0x030b, B:91:0x0313, B:94:0x031f, B:96:0x0356, B:97:0x0371, B:99:0x0377, B:101:0x0387, B:105:0x039d, B:102:0x0391, B:108:0x03a4, B:111:0x03ab, B:112:0x03c3, B:33:0x0122, B:35:0x012f, B:37:0x013b, B:39:0x0141, B:43:0x014c, B:210:0x0686, B:212:0x0694, B:214:0x069d, B:225:0x06ce, B:215:0x06a5, B:217:0x06ae, B:219:0x06b4, B:222:0x06c0, B:224:0x06c8, B:226:0x06d1, B:227:0x06dd, B:230:0x06e5, B:232:0x06f7, B:233:0x0702, B:235:0x070a, B:239:0x0730, B:241:0x074a, B:243:0x075f, B:245:0x0779, B:247:0x078e, B:249:0x07d3, B:251:0x07d9, B:257:0x0800, B:259:0x0808, B:260:0x0811, B:262:0x0817, B:263:0x081d, B:265:0x0832, B:267:0x0842, B:269:0x0852, B:272:0x085b, B:274:0x0861, B:275:0x0873, B:277:0x0879, B:279:0x0889, B:281:0x08a1, B:283:0x08b3, B:285:0x08da, B:286:0x08f3, B:288:0x0905, B:290:0x0924, B:292:0x094b, B:294:0x097b, B:295:0x0986, B:297:0x0998, B:299:0x09b7, B:301:0x09de, B:303:0x0a0e, B:304:0x0a17, B:305:0x0a20, B:306:0x0a24, B:314:0x0a98, B:316:0x0ab1, B:318:0x0ac7, B:320:0x0acc, B:322:0x0ad0, B:324:0x0ad4, B:326:0x0ade, B:327:0x0ae4, B:329:0x0ae8, B:331:0x0aee, B:332:0x0afc, B:333:0x0b05, B:338:0x0b29, B:341:0x0b2f, B:439:0x0e1e, B:441:0x0e33, B:444:0x0e3a, B:449:0x0e6b, B:451:0x0e7d, B:445:0x0e42, B:447:0x0e4e, B:448:0x0e54, B:252:0x07e7, B:254:0x07ed, B:256:0x07f3, B:246:0x078b, B:242:0x075c, B:236:0x0710, B:238:0x0716, B:454:0x0e9b), top: B:465:0x000f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x04eb A[Catch: all -> 0x0eac, TryCatch #2 {all -> 0x0eac, blocks: (B:3:0x000f, B:5:0x0026, B:8:0x002e, B:9:0x0041, B:12:0x005b, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:207:0x066e, B:24:0x0100, B:27:0x0112, B:29:0x0118, B:44:0x015a, B:46:0x0168, B:49:0x0188, B:51:0x018e, B:53:0x019e, B:55:0x01ac, B:57:0x01bc, B:58:0x01c9, B:59:0x01cc, B:61:0x01e0, B:114:0x03dc, B:115:0x03e8, B:118:0x03f4, B:124:0x0417, B:121:0x0406, B:147:0x049a, B:149:0x04a6, B:152:0x04b7, B:154:0x04c9, B:156:0x04d5, B:173:0x0543, B:175:0x0549, B:176:0x0555, B:178:0x055b, B:180:0x056b, B:182:0x0575, B:183:0x058a, B:185:0x0590, B:186:0x05ab, B:188:0x05b1, B:189:0x05cf, B:190:0x05d8, B:194:0x05fd, B:191:0x05dc, B:193:0x05ea, B:195:0x0606, B:196:0x061e, B:198:0x0624, B:200:0x0637, B:201:0x0644, B:202:0x0648, B:204:0x064e, B:206:0x065c, B:160:0x04eb, B:162:0x04f9, B:165:0x050c, B:167:0x051e, B:169:0x052a, B:128:0x0421, B:130:0x042d, B:132:0x0439, B:144:0x047e, B:136:0x0456, B:139:0x0468, B:141:0x046e, B:143:0x0478, B:70:0x020d, B:73:0x0217, B:75:0x0225, B:79:0x026c, B:76:0x0242, B:78:0x0252, B:83:0x0279, B:86:0x02a8, B:87:0x02d2, B:89:0x030b, B:91:0x0313, B:94:0x031f, B:96:0x0356, B:97:0x0371, B:99:0x0377, B:101:0x0387, B:105:0x039d, B:102:0x0391, B:108:0x03a4, B:111:0x03ab, B:112:0x03c3, B:33:0x0122, B:35:0x012f, B:37:0x013b, B:39:0x0141, B:43:0x014c, B:210:0x0686, B:212:0x0694, B:214:0x069d, B:225:0x06ce, B:215:0x06a5, B:217:0x06ae, B:219:0x06b4, B:222:0x06c0, B:224:0x06c8, B:226:0x06d1, B:227:0x06dd, B:230:0x06e5, B:232:0x06f7, B:233:0x0702, B:235:0x070a, B:239:0x0730, B:241:0x074a, B:243:0x075f, B:245:0x0779, B:247:0x078e, B:249:0x07d3, B:251:0x07d9, B:257:0x0800, B:259:0x0808, B:260:0x0811, B:262:0x0817, B:263:0x081d, B:265:0x0832, B:267:0x0842, B:269:0x0852, B:272:0x085b, B:274:0x0861, B:275:0x0873, B:277:0x0879, B:279:0x0889, B:281:0x08a1, B:283:0x08b3, B:285:0x08da, B:286:0x08f3, B:288:0x0905, B:290:0x0924, B:292:0x094b, B:294:0x097b, B:295:0x0986, B:297:0x0998, B:299:0x09b7, B:301:0x09de, B:303:0x0a0e, B:304:0x0a17, B:305:0x0a20, B:306:0x0a24, B:314:0x0a98, B:316:0x0ab1, B:318:0x0ac7, B:320:0x0acc, B:322:0x0ad0, B:324:0x0ad4, B:326:0x0ade, B:327:0x0ae4, B:329:0x0ae8, B:331:0x0aee, B:332:0x0afc, B:333:0x0b05, B:338:0x0b29, B:341:0x0b2f, B:439:0x0e1e, B:441:0x0e33, B:444:0x0e3a, B:449:0x0e6b, B:451:0x0e7d, B:445:0x0e42, B:447:0x0e4e, B:448:0x0e54, B:252:0x07e7, B:254:0x07ed, B:256:0x07f3, B:246:0x078b, B:242:0x075c, B:236:0x0710, B:238:0x0716, B:454:0x0e9b), top: B:465:0x000f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0549 A[Catch: all -> 0x0eac, TryCatch #2 {all -> 0x0eac, blocks: (B:3:0x000f, B:5:0x0026, B:8:0x002e, B:9:0x0041, B:12:0x005b, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:207:0x066e, B:24:0x0100, B:27:0x0112, B:29:0x0118, B:44:0x015a, B:46:0x0168, B:49:0x0188, B:51:0x018e, B:53:0x019e, B:55:0x01ac, B:57:0x01bc, B:58:0x01c9, B:59:0x01cc, B:61:0x01e0, B:114:0x03dc, B:115:0x03e8, B:118:0x03f4, B:124:0x0417, B:121:0x0406, B:147:0x049a, B:149:0x04a6, B:152:0x04b7, B:154:0x04c9, B:156:0x04d5, B:173:0x0543, B:175:0x0549, B:176:0x0555, B:178:0x055b, B:180:0x056b, B:182:0x0575, B:183:0x058a, B:185:0x0590, B:186:0x05ab, B:188:0x05b1, B:189:0x05cf, B:190:0x05d8, B:194:0x05fd, B:191:0x05dc, B:193:0x05ea, B:195:0x0606, B:196:0x061e, B:198:0x0624, B:200:0x0637, B:201:0x0644, B:202:0x0648, B:204:0x064e, B:206:0x065c, B:160:0x04eb, B:162:0x04f9, B:165:0x050c, B:167:0x051e, B:169:0x052a, B:128:0x0421, B:130:0x042d, B:132:0x0439, B:144:0x047e, B:136:0x0456, B:139:0x0468, B:141:0x046e, B:143:0x0478, B:70:0x020d, B:73:0x0217, B:75:0x0225, B:79:0x026c, B:76:0x0242, B:78:0x0252, B:83:0x0279, B:86:0x02a8, B:87:0x02d2, B:89:0x030b, B:91:0x0313, B:94:0x031f, B:96:0x0356, B:97:0x0371, B:99:0x0377, B:101:0x0387, B:105:0x039d, B:102:0x0391, B:108:0x03a4, B:111:0x03ab, B:112:0x03c3, B:33:0x0122, B:35:0x012f, B:37:0x013b, B:39:0x0141, B:43:0x014c, B:210:0x0686, B:212:0x0694, B:214:0x069d, B:225:0x06ce, B:215:0x06a5, B:217:0x06ae, B:219:0x06b4, B:222:0x06c0, B:224:0x06c8, B:226:0x06d1, B:227:0x06dd, B:230:0x06e5, B:232:0x06f7, B:233:0x0702, B:235:0x070a, B:239:0x0730, B:241:0x074a, B:243:0x075f, B:245:0x0779, B:247:0x078e, B:249:0x07d3, B:251:0x07d9, B:257:0x0800, B:259:0x0808, B:260:0x0811, B:262:0x0817, B:263:0x081d, B:265:0x0832, B:267:0x0842, B:269:0x0852, B:272:0x085b, B:274:0x0861, B:275:0x0873, B:277:0x0879, B:279:0x0889, B:281:0x08a1, B:283:0x08b3, B:285:0x08da, B:286:0x08f3, B:288:0x0905, B:290:0x0924, B:292:0x094b, B:294:0x097b, B:295:0x0986, B:297:0x0998, B:299:0x09b7, B:301:0x09de, B:303:0x0a0e, B:304:0x0a17, B:305:0x0a20, B:306:0x0a24, B:314:0x0a98, B:316:0x0ab1, B:318:0x0ac7, B:320:0x0acc, B:322:0x0ad0, B:324:0x0ad4, B:326:0x0ade, B:327:0x0ae4, B:329:0x0ae8, B:331:0x0aee, B:332:0x0afc, B:333:0x0b05, B:338:0x0b29, B:341:0x0b2f, B:439:0x0e1e, B:441:0x0e33, B:444:0x0e3a, B:449:0x0e6b, B:451:0x0e7d, B:445:0x0e42, B:447:0x0e4e, B:448:0x0e54, B:252:0x07e7, B:254:0x07ed, B:256:0x07f3, B:246:0x078b, B:242:0x075c, B:236:0x0710, B:238:0x0716, B:454:0x0e9b), top: B:465:0x000f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0658  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0b65 A[Catch: all -> 0x0e97, TryCatch #0 {all -> 0x0e97, blocks: (B:308:0x0a66, B:309:0x0a79, B:311:0x0a7f, B:405:0x0d46, B:336:0x0b13, B:343:0x0b43, B:345:0x0b65, B:346:0x0b6d, B:348:0x0b73, B:350:0x0b83, B:357:0x0bab, B:359:0x0bd1, B:361:0x0bdd, B:363:0x0bf3, B:366:0x0c36, B:370:0x0c4c, B:372:0x0c53, B:374:0x0c62, B:376:0x0c66, B:378:0x0c6a, B:380:0x0c6e, B:381:0x0c7a, B:382:0x0c7f, B:384:0x0c85, B:386:0x0c9f, B:387:0x0ca4, B:404:0x0d43, B:388:0x0cba, B:390:0x0cbe, B:394:0x0ce4, B:396:0x0d08, B:398:0x0d16, B:399:0x0d29, B:401:0x0d31, B:391:0x0ccb, B:355:0x0b97, B:406:0x0d4f, B:408:0x0d5d, B:409:0x0d63, B:410:0x0d6b, B:412:0x0d71, B:414:0x0d89, B:416:0x0d99, B:436:0x0e16, B:417:0x0db1, B:419:0x0db7, B:421:0x0dbf, B:423:0x0dc6, B:429:0x0dd4, B:431:0x0ddb, B:433:0x0e07, B:435:0x0e0e, B:434:0x0e0b, B:430:0x0dd8, B:422:0x0dc3), top: B:461:0x0a66 }] */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0bab A[Catch: all -> 0x0e97, TryCatch #0 {all -> 0x0e97, blocks: (B:308:0x0a66, B:309:0x0a79, B:311:0x0a7f, B:405:0x0d46, B:336:0x0b13, B:343:0x0b43, B:345:0x0b65, B:346:0x0b6d, B:348:0x0b73, B:350:0x0b83, B:357:0x0bab, B:359:0x0bd1, B:361:0x0bdd, B:363:0x0bf3, B:366:0x0c36, B:370:0x0c4c, B:372:0x0c53, B:374:0x0c62, B:376:0x0c66, B:378:0x0c6a, B:380:0x0c6e, B:381:0x0c7a, B:382:0x0c7f, B:384:0x0c85, B:386:0x0c9f, B:387:0x0ca4, B:404:0x0d43, B:388:0x0cba, B:390:0x0cbe, B:394:0x0ce4, B:396:0x0d08, B:398:0x0d16, B:399:0x0d29, B:401:0x0d31, B:391:0x0ccb, B:355:0x0b97, B:406:0x0d4f, B:408:0x0d5d, B:409:0x0d63, B:410:0x0d6b, B:412:0x0d71, B:414:0x0d89, B:416:0x0d99, B:436:0x0e16, B:417:0x0db1, B:419:0x0db7, B:421:0x0dbf, B:423:0x0dc6, B:429:0x0dd4, B:431:0x0ddb, B:433:0x0e07, B:435:0x0e0e, B:434:0x0e0b, B:430:0x0dd8, B:422:0x0dc3), top: B:461:0x0a66 }] */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0bd1 A[Catch: all -> 0x0e97, TryCatch #0 {all -> 0x0e97, blocks: (B:308:0x0a66, B:309:0x0a79, B:311:0x0a7f, B:405:0x0d46, B:336:0x0b13, B:343:0x0b43, B:345:0x0b65, B:346:0x0b6d, B:348:0x0b73, B:350:0x0b83, B:357:0x0bab, B:359:0x0bd1, B:361:0x0bdd, B:363:0x0bf3, B:366:0x0c36, B:370:0x0c4c, B:372:0x0c53, B:374:0x0c62, B:376:0x0c66, B:378:0x0c6a, B:380:0x0c6e, B:381:0x0c7a, B:382:0x0c7f, B:384:0x0c85, B:386:0x0c9f, B:387:0x0ca4, B:404:0x0d43, B:388:0x0cba, B:390:0x0cbe, B:394:0x0ce4, B:396:0x0d08, B:398:0x0d16, B:399:0x0d29, B:401:0x0d31, B:391:0x0ccb, B:355:0x0b97, B:406:0x0d4f, B:408:0x0d5d, B:409:0x0d63, B:410:0x0d6b, B:412:0x0d71, B:414:0x0d89, B:416:0x0d99, B:436:0x0e16, B:417:0x0db1, B:419:0x0db7, B:421:0x0dbf, B:423:0x0dc6, B:429:0x0dd4, B:431:0x0ddb, B:433:0x0e07, B:435:0x0e0e, B:434:0x0e0b, B:430:0x0dd8, B:422:0x0dc3), top: B:461:0x0a66 }] */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0c49  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0c4b  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0c53 A[Catch: all -> 0x0e97, TryCatch #0 {all -> 0x0e97, blocks: (B:308:0x0a66, B:309:0x0a79, B:311:0x0a7f, B:405:0x0d46, B:336:0x0b13, B:343:0x0b43, B:345:0x0b65, B:346:0x0b6d, B:348:0x0b73, B:350:0x0b83, B:357:0x0bab, B:359:0x0bd1, B:361:0x0bdd, B:363:0x0bf3, B:366:0x0c36, B:370:0x0c4c, B:372:0x0c53, B:374:0x0c62, B:376:0x0c66, B:378:0x0c6a, B:380:0x0c6e, B:381:0x0c7a, B:382:0x0c7f, B:384:0x0c85, B:386:0x0c9f, B:387:0x0ca4, B:404:0x0d43, B:388:0x0cba, B:390:0x0cbe, B:394:0x0ce4, B:396:0x0d08, B:398:0x0d16, B:399:0x0d29, B:401:0x0d31, B:391:0x0ccb, B:355:0x0b97, B:406:0x0d4f, B:408:0x0d5d, B:409:0x0d63, B:410:0x0d6b, B:412:0x0d71, B:414:0x0d89, B:416:0x0d99, B:436:0x0e16, B:417:0x0db1, B:419:0x0db7, B:421:0x0dbf, B:423:0x0dc6, B:429:0x0dd4, B:431:0x0ddb, B:433:0x0e07, B:435:0x0e0e, B:434:0x0e0b, B:430:0x0dd8, B:422:0x0dc3), top: B:461:0x0a66 }] */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0c7f A[Catch: all -> 0x0e97, TryCatch #0 {all -> 0x0e97, blocks: (B:308:0x0a66, B:309:0x0a79, B:311:0x0a7f, B:405:0x0d46, B:336:0x0b13, B:343:0x0b43, B:345:0x0b65, B:346:0x0b6d, B:348:0x0b73, B:350:0x0b83, B:357:0x0bab, B:359:0x0bd1, B:361:0x0bdd, B:363:0x0bf3, B:366:0x0c36, B:370:0x0c4c, B:372:0x0c53, B:374:0x0c62, B:376:0x0c66, B:378:0x0c6a, B:380:0x0c6e, B:381:0x0c7a, B:382:0x0c7f, B:384:0x0c85, B:386:0x0c9f, B:387:0x0ca4, B:404:0x0d43, B:388:0x0cba, B:390:0x0cbe, B:394:0x0ce4, B:396:0x0d08, B:398:0x0d16, B:399:0x0d29, B:401:0x0d31, B:391:0x0ccb, B:355:0x0b97, B:406:0x0d4f, B:408:0x0d5d, B:409:0x0d63, B:410:0x0d6b, B:412:0x0d71, B:414:0x0d89, B:416:0x0d99, B:436:0x0e16, B:417:0x0db1, B:419:0x0db7, B:421:0x0dbf, B:423:0x0dc6, B:429:0x0dd4, B:431:0x0ddb, B:433:0x0e07, B:435:0x0e0e, B:434:0x0e0b, B:430:0x0dd8, B:422:0x0dc3), top: B:461:0x0a66 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0168 A[Catch: all -> 0x0eac, TryCatch #2 {all -> 0x0eac, blocks: (B:3:0x000f, B:5:0x0026, B:8:0x002e, B:9:0x0041, B:12:0x005b, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:207:0x066e, B:24:0x0100, B:27:0x0112, B:29:0x0118, B:44:0x015a, B:46:0x0168, B:49:0x0188, B:51:0x018e, B:53:0x019e, B:55:0x01ac, B:57:0x01bc, B:58:0x01c9, B:59:0x01cc, B:61:0x01e0, B:114:0x03dc, B:115:0x03e8, B:118:0x03f4, B:124:0x0417, B:121:0x0406, B:147:0x049a, B:149:0x04a6, B:152:0x04b7, B:154:0x04c9, B:156:0x04d5, B:173:0x0543, B:175:0x0549, B:176:0x0555, B:178:0x055b, B:180:0x056b, B:182:0x0575, B:183:0x058a, B:185:0x0590, B:186:0x05ab, B:188:0x05b1, B:189:0x05cf, B:190:0x05d8, B:194:0x05fd, B:191:0x05dc, B:193:0x05ea, B:195:0x0606, B:196:0x061e, B:198:0x0624, B:200:0x0637, B:201:0x0644, B:202:0x0648, B:204:0x064e, B:206:0x065c, B:160:0x04eb, B:162:0x04f9, B:165:0x050c, B:167:0x051e, B:169:0x052a, B:128:0x0421, B:130:0x042d, B:132:0x0439, B:144:0x047e, B:136:0x0456, B:139:0x0468, B:141:0x046e, B:143:0x0478, B:70:0x020d, B:73:0x0217, B:75:0x0225, B:79:0x026c, B:76:0x0242, B:78:0x0252, B:83:0x0279, B:86:0x02a8, B:87:0x02d2, B:89:0x030b, B:91:0x0313, B:94:0x031f, B:96:0x0356, B:97:0x0371, B:99:0x0377, B:101:0x0387, B:105:0x039d, B:102:0x0391, B:108:0x03a4, B:111:0x03ab, B:112:0x03c3, B:33:0x0122, B:35:0x012f, B:37:0x013b, B:39:0x0141, B:43:0x014c, B:210:0x0686, B:212:0x0694, B:214:0x069d, B:225:0x06ce, B:215:0x06a5, B:217:0x06ae, B:219:0x06b4, B:222:0x06c0, B:224:0x06c8, B:226:0x06d1, B:227:0x06dd, B:230:0x06e5, B:232:0x06f7, B:233:0x0702, B:235:0x070a, B:239:0x0730, B:241:0x074a, B:243:0x075f, B:245:0x0779, B:247:0x078e, B:249:0x07d3, B:251:0x07d9, B:257:0x0800, B:259:0x0808, B:260:0x0811, B:262:0x0817, B:263:0x081d, B:265:0x0832, B:267:0x0842, B:269:0x0852, B:272:0x085b, B:274:0x0861, B:275:0x0873, B:277:0x0879, B:279:0x0889, B:281:0x08a1, B:283:0x08b3, B:285:0x08da, B:286:0x08f3, B:288:0x0905, B:290:0x0924, B:292:0x094b, B:294:0x097b, B:295:0x0986, B:297:0x0998, B:299:0x09b7, B:301:0x09de, B:303:0x0a0e, B:304:0x0a17, B:305:0x0a20, B:306:0x0a24, B:314:0x0a98, B:316:0x0ab1, B:318:0x0ac7, B:320:0x0acc, B:322:0x0ad0, B:324:0x0ad4, B:326:0x0ade, B:327:0x0ae4, B:329:0x0ae8, B:331:0x0aee, B:332:0x0afc, B:333:0x0b05, B:338:0x0b29, B:341:0x0b2f, B:439:0x0e1e, B:441:0x0e33, B:444:0x0e3a, B:449:0x0e6b, B:451:0x0e7d, B:445:0x0e42, B:447:0x0e4e, B:448:0x0e54, B:252:0x07e7, B:254:0x07ed, B:256:0x07f3, B:246:0x078b, B:242:0x075c, B:236:0x0710, B:238:0x0716, B:454:0x0e9b), top: B:465:0x000f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:492:0x0273 A[EDGE_INSN: B:492:0x0273->B:80:0x0273 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e0 A[Catch: all -> 0x0eac, TRY_LEAVE, TryCatch #2 {all -> 0x0eac, blocks: (B:3:0x000f, B:5:0x0026, B:8:0x002e, B:9:0x0041, B:12:0x005b, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:207:0x066e, B:24:0x0100, B:27:0x0112, B:29:0x0118, B:44:0x015a, B:46:0x0168, B:49:0x0188, B:51:0x018e, B:53:0x019e, B:55:0x01ac, B:57:0x01bc, B:58:0x01c9, B:59:0x01cc, B:61:0x01e0, B:114:0x03dc, B:115:0x03e8, B:118:0x03f4, B:124:0x0417, B:121:0x0406, B:147:0x049a, B:149:0x04a6, B:152:0x04b7, B:154:0x04c9, B:156:0x04d5, B:173:0x0543, B:175:0x0549, B:176:0x0555, B:178:0x055b, B:180:0x056b, B:182:0x0575, B:183:0x058a, B:185:0x0590, B:186:0x05ab, B:188:0x05b1, B:189:0x05cf, B:190:0x05d8, B:194:0x05fd, B:191:0x05dc, B:193:0x05ea, B:195:0x0606, B:196:0x061e, B:198:0x0624, B:200:0x0637, B:201:0x0644, B:202:0x0648, B:204:0x064e, B:206:0x065c, B:160:0x04eb, B:162:0x04f9, B:165:0x050c, B:167:0x051e, B:169:0x052a, B:128:0x0421, B:130:0x042d, B:132:0x0439, B:144:0x047e, B:136:0x0456, B:139:0x0468, B:141:0x046e, B:143:0x0478, B:70:0x020d, B:73:0x0217, B:75:0x0225, B:79:0x026c, B:76:0x0242, B:78:0x0252, B:83:0x0279, B:86:0x02a8, B:87:0x02d2, B:89:0x030b, B:91:0x0313, B:94:0x031f, B:96:0x0356, B:97:0x0371, B:99:0x0377, B:101:0x0387, B:105:0x039d, B:102:0x0391, B:108:0x03a4, B:111:0x03ab, B:112:0x03c3, B:33:0x0122, B:35:0x012f, B:37:0x013b, B:39:0x0141, B:43:0x014c, B:210:0x0686, B:212:0x0694, B:214:0x069d, B:225:0x06ce, B:215:0x06a5, B:217:0x06ae, B:219:0x06b4, B:222:0x06c0, B:224:0x06c8, B:226:0x06d1, B:227:0x06dd, B:230:0x06e5, B:232:0x06f7, B:233:0x0702, B:235:0x070a, B:239:0x0730, B:241:0x074a, B:243:0x075f, B:245:0x0779, B:247:0x078e, B:249:0x07d3, B:251:0x07d9, B:257:0x0800, B:259:0x0808, B:260:0x0811, B:262:0x0817, B:263:0x081d, B:265:0x0832, B:267:0x0842, B:269:0x0852, B:272:0x085b, B:274:0x0861, B:275:0x0873, B:277:0x0879, B:279:0x0889, B:281:0x08a1, B:283:0x08b3, B:285:0x08da, B:286:0x08f3, B:288:0x0905, B:290:0x0924, B:292:0x094b, B:294:0x097b, B:295:0x0986, B:297:0x0998, B:299:0x09b7, B:301:0x09de, B:303:0x0a0e, B:304:0x0a17, B:305:0x0a20, B:306:0x0a24, B:314:0x0a98, B:316:0x0ab1, B:318:0x0ac7, B:320:0x0acc, B:322:0x0ad0, B:324:0x0ad4, B:326:0x0ade, B:327:0x0ae4, B:329:0x0ae8, B:331:0x0aee, B:332:0x0afc, B:333:0x0b05, B:338:0x0b29, B:341:0x0b2f, B:439:0x0e1e, B:441:0x0e33, B:444:0x0e3a, B:449:0x0e6b, B:451:0x0e7d, B:445:0x0e42, B:447:0x0e4e, B:448:0x0e54, B:252:0x07e7, B:254:0x07ed, B:256:0x07f3, B:246:0x078b, B:242:0x075c, B:236:0x0710, B:238:0x0716, B:454:0x0e9b), top: B:465:0x000f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0217 A[Catch: all -> 0x0eac, TRY_ENTER, TryCatch #2 {all -> 0x0eac, blocks: (B:3:0x000f, B:5:0x0026, B:8:0x002e, B:9:0x0041, B:12:0x005b, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:207:0x066e, B:24:0x0100, B:27:0x0112, B:29:0x0118, B:44:0x015a, B:46:0x0168, B:49:0x0188, B:51:0x018e, B:53:0x019e, B:55:0x01ac, B:57:0x01bc, B:58:0x01c9, B:59:0x01cc, B:61:0x01e0, B:114:0x03dc, B:115:0x03e8, B:118:0x03f4, B:124:0x0417, B:121:0x0406, B:147:0x049a, B:149:0x04a6, B:152:0x04b7, B:154:0x04c9, B:156:0x04d5, B:173:0x0543, B:175:0x0549, B:176:0x0555, B:178:0x055b, B:180:0x056b, B:182:0x0575, B:183:0x058a, B:185:0x0590, B:186:0x05ab, B:188:0x05b1, B:189:0x05cf, B:190:0x05d8, B:194:0x05fd, B:191:0x05dc, B:193:0x05ea, B:195:0x0606, B:196:0x061e, B:198:0x0624, B:200:0x0637, B:201:0x0644, B:202:0x0648, B:204:0x064e, B:206:0x065c, B:160:0x04eb, B:162:0x04f9, B:165:0x050c, B:167:0x051e, B:169:0x052a, B:128:0x0421, B:130:0x042d, B:132:0x0439, B:144:0x047e, B:136:0x0456, B:139:0x0468, B:141:0x046e, B:143:0x0478, B:70:0x020d, B:73:0x0217, B:75:0x0225, B:79:0x026c, B:76:0x0242, B:78:0x0252, B:83:0x0279, B:86:0x02a8, B:87:0x02d2, B:89:0x030b, B:91:0x0313, B:94:0x031f, B:96:0x0356, B:97:0x0371, B:99:0x0377, B:101:0x0387, B:105:0x039d, B:102:0x0391, B:108:0x03a4, B:111:0x03ab, B:112:0x03c3, B:33:0x0122, B:35:0x012f, B:37:0x013b, B:39:0x0141, B:43:0x014c, B:210:0x0686, B:212:0x0694, B:214:0x069d, B:225:0x06ce, B:215:0x06a5, B:217:0x06ae, B:219:0x06b4, B:222:0x06c0, B:224:0x06c8, B:226:0x06d1, B:227:0x06dd, B:230:0x06e5, B:232:0x06f7, B:233:0x0702, B:235:0x070a, B:239:0x0730, B:241:0x074a, B:243:0x075f, B:245:0x0779, B:247:0x078e, B:249:0x07d3, B:251:0x07d9, B:257:0x0800, B:259:0x0808, B:260:0x0811, B:262:0x0817, B:263:0x081d, B:265:0x0832, B:267:0x0842, B:269:0x0852, B:272:0x085b, B:274:0x0861, B:275:0x0873, B:277:0x0879, B:279:0x0889, B:281:0x08a1, B:283:0x08b3, B:285:0x08da, B:286:0x08f3, B:288:0x0905, B:290:0x0924, B:292:0x094b, B:294:0x097b, B:295:0x0986, B:297:0x0998, B:299:0x09b7, B:301:0x09de, B:303:0x0a0e, B:304:0x0a17, B:305:0x0a20, B:306:0x0a24, B:314:0x0a98, B:316:0x0ab1, B:318:0x0ac7, B:320:0x0acc, B:322:0x0ad0, B:324:0x0ad4, B:326:0x0ade, B:327:0x0ae4, B:329:0x0ae8, B:331:0x0aee, B:332:0x0afc, B:333:0x0b05, B:338:0x0b29, B:341:0x0b2f, B:439:0x0e1e, B:441:0x0e33, B:444:0x0e3a, B:449:0x0e6b, B:451:0x0e7d, B:445:0x0e42, B:447:0x0e4e, B:448:0x0e54, B:252:0x07e7, B:254:0x07ed, B:256:0x07f3, B:246:0x078b, B:242:0x075c, B:236:0x0710, B:238:0x0716, B:454:0x0e9b), top: B:465:0x000f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0277 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02a8 A[Catch: all -> 0x0eac, TryCatch #2 {all -> 0x0eac, blocks: (B:3:0x000f, B:5:0x0026, B:8:0x002e, B:9:0x0041, B:12:0x005b, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:207:0x066e, B:24:0x0100, B:27:0x0112, B:29:0x0118, B:44:0x015a, B:46:0x0168, B:49:0x0188, B:51:0x018e, B:53:0x019e, B:55:0x01ac, B:57:0x01bc, B:58:0x01c9, B:59:0x01cc, B:61:0x01e0, B:114:0x03dc, B:115:0x03e8, B:118:0x03f4, B:124:0x0417, B:121:0x0406, B:147:0x049a, B:149:0x04a6, B:152:0x04b7, B:154:0x04c9, B:156:0x04d5, B:173:0x0543, B:175:0x0549, B:176:0x0555, B:178:0x055b, B:180:0x056b, B:182:0x0575, B:183:0x058a, B:185:0x0590, B:186:0x05ab, B:188:0x05b1, B:189:0x05cf, B:190:0x05d8, B:194:0x05fd, B:191:0x05dc, B:193:0x05ea, B:195:0x0606, B:196:0x061e, B:198:0x0624, B:200:0x0637, B:201:0x0644, B:202:0x0648, B:204:0x064e, B:206:0x065c, B:160:0x04eb, B:162:0x04f9, B:165:0x050c, B:167:0x051e, B:169:0x052a, B:128:0x0421, B:130:0x042d, B:132:0x0439, B:144:0x047e, B:136:0x0456, B:139:0x0468, B:141:0x046e, B:143:0x0478, B:70:0x020d, B:73:0x0217, B:75:0x0225, B:79:0x026c, B:76:0x0242, B:78:0x0252, B:83:0x0279, B:86:0x02a8, B:87:0x02d2, B:89:0x030b, B:91:0x0313, B:94:0x031f, B:96:0x0356, B:97:0x0371, B:99:0x0377, B:101:0x0387, B:105:0x039d, B:102:0x0391, B:108:0x03a4, B:111:0x03ab, B:112:0x03c3, B:33:0x0122, B:35:0x012f, B:37:0x013b, B:39:0x0141, B:43:0x014c, B:210:0x0686, B:212:0x0694, B:214:0x069d, B:225:0x06ce, B:215:0x06a5, B:217:0x06ae, B:219:0x06b4, B:222:0x06c0, B:224:0x06c8, B:226:0x06d1, B:227:0x06dd, B:230:0x06e5, B:232:0x06f7, B:233:0x0702, B:235:0x070a, B:239:0x0730, B:241:0x074a, B:243:0x075f, B:245:0x0779, B:247:0x078e, B:249:0x07d3, B:251:0x07d9, B:257:0x0800, B:259:0x0808, B:260:0x0811, B:262:0x0817, B:263:0x081d, B:265:0x0832, B:267:0x0842, B:269:0x0852, B:272:0x085b, B:274:0x0861, B:275:0x0873, B:277:0x0879, B:279:0x0889, B:281:0x08a1, B:283:0x08b3, B:285:0x08da, B:286:0x08f3, B:288:0x0905, B:290:0x0924, B:292:0x094b, B:294:0x097b, B:295:0x0986, B:297:0x0998, B:299:0x09b7, B:301:0x09de, B:303:0x0a0e, B:304:0x0a17, B:305:0x0a20, B:306:0x0a24, B:314:0x0a98, B:316:0x0ab1, B:318:0x0ac7, B:320:0x0acc, B:322:0x0ad0, B:324:0x0ad4, B:326:0x0ade, B:327:0x0ae4, B:329:0x0ae8, B:331:0x0aee, B:332:0x0afc, B:333:0x0b05, B:338:0x0b29, B:341:0x0b2f, B:439:0x0e1e, B:441:0x0e33, B:444:0x0e3a, B:449:0x0e6b, B:451:0x0e7d, B:445:0x0e42, B:447:0x0e4e, B:448:0x0e54, B:252:0x07e7, B:254:0x07ed, B:256:0x07f3, B:246:0x078b, B:242:0x075c, B:236:0x0710, B:238:0x0716, B:454:0x0e9b), top: B:465:0x000f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x030b A[Catch: all -> 0x0eac, TryCatch #2 {all -> 0x0eac, blocks: (B:3:0x000f, B:5:0x0026, B:8:0x002e, B:9:0x0041, B:12:0x005b, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:207:0x066e, B:24:0x0100, B:27:0x0112, B:29:0x0118, B:44:0x015a, B:46:0x0168, B:49:0x0188, B:51:0x018e, B:53:0x019e, B:55:0x01ac, B:57:0x01bc, B:58:0x01c9, B:59:0x01cc, B:61:0x01e0, B:114:0x03dc, B:115:0x03e8, B:118:0x03f4, B:124:0x0417, B:121:0x0406, B:147:0x049a, B:149:0x04a6, B:152:0x04b7, B:154:0x04c9, B:156:0x04d5, B:173:0x0543, B:175:0x0549, B:176:0x0555, B:178:0x055b, B:180:0x056b, B:182:0x0575, B:183:0x058a, B:185:0x0590, B:186:0x05ab, B:188:0x05b1, B:189:0x05cf, B:190:0x05d8, B:194:0x05fd, B:191:0x05dc, B:193:0x05ea, B:195:0x0606, B:196:0x061e, B:198:0x0624, B:200:0x0637, B:201:0x0644, B:202:0x0648, B:204:0x064e, B:206:0x065c, B:160:0x04eb, B:162:0x04f9, B:165:0x050c, B:167:0x051e, B:169:0x052a, B:128:0x0421, B:130:0x042d, B:132:0x0439, B:144:0x047e, B:136:0x0456, B:139:0x0468, B:141:0x046e, B:143:0x0478, B:70:0x020d, B:73:0x0217, B:75:0x0225, B:79:0x026c, B:76:0x0242, B:78:0x0252, B:83:0x0279, B:86:0x02a8, B:87:0x02d2, B:89:0x030b, B:91:0x0313, B:94:0x031f, B:96:0x0356, B:97:0x0371, B:99:0x0377, B:101:0x0387, B:105:0x039d, B:102:0x0391, B:108:0x03a4, B:111:0x03ab, B:112:0x03c3, B:33:0x0122, B:35:0x012f, B:37:0x013b, B:39:0x0141, B:43:0x014c, B:210:0x0686, B:212:0x0694, B:214:0x069d, B:225:0x06ce, B:215:0x06a5, B:217:0x06ae, B:219:0x06b4, B:222:0x06c0, B:224:0x06c8, B:226:0x06d1, B:227:0x06dd, B:230:0x06e5, B:232:0x06f7, B:233:0x0702, B:235:0x070a, B:239:0x0730, B:241:0x074a, B:243:0x075f, B:245:0x0779, B:247:0x078e, B:249:0x07d3, B:251:0x07d9, B:257:0x0800, B:259:0x0808, B:260:0x0811, B:262:0x0817, B:263:0x081d, B:265:0x0832, B:267:0x0842, B:269:0x0852, B:272:0x085b, B:274:0x0861, B:275:0x0873, B:277:0x0879, B:279:0x0889, B:281:0x08a1, B:283:0x08b3, B:285:0x08da, B:286:0x08f3, B:288:0x0905, B:290:0x0924, B:292:0x094b, B:294:0x097b, B:295:0x0986, B:297:0x0998, B:299:0x09b7, B:301:0x09de, B:303:0x0a0e, B:304:0x0a17, B:305:0x0a20, B:306:0x0a24, B:314:0x0a98, B:316:0x0ab1, B:318:0x0ac7, B:320:0x0acc, B:322:0x0ad0, B:324:0x0ad4, B:326:0x0ade, B:327:0x0ae4, B:329:0x0ae8, B:331:0x0aee, B:332:0x0afc, B:333:0x0b05, B:338:0x0b29, B:341:0x0b2f, B:439:0x0e1e, B:441:0x0e33, B:444:0x0e3a, B:449:0x0e6b, B:451:0x0e7d, B:445:0x0e42, B:447:0x0e4e, B:448:0x0e54, B:252:0x07e7, B:254:0x07ed, B:256:0x07f3, B:246:0x078b, B:242:0x075c, B:236:0x0710, B:238:0x0716, B:454:0x0e9b), top: B:465:0x000f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x031d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0377 A[Catch: all -> 0x0eac, TryCatch #2 {all -> 0x0eac, blocks: (B:3:0x000f, B:5:0x0026, B:8:0x002e, B:9:0x0041, B:12:0x005b, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:207:0x066e, B:24:0x0100, B:27:0x0112, B:29:0x0118, B:44:0x015a, B:46:0x0168, B:49:0x0188, B:51:0x018e, B:53:0x019e, B:55:0x01ac, B:57:0x01bc, B:58:0x01c9, B:59:0x01cc, B:61:0x01e0, B:114:0x03dc, B:115:0x03e8, B:118:0x03f4, B:124:0x0417, B:121:0x0406, B:147:0x049a, B:149:0x04a6, B:152:0x04b7, B:154:0x04c9, B:156:0x04d5, B:173:0x0543, B:175:0x0549, B:176:0x0555, B:178:0x055b, B:180:0x056b, B:182:0x0575, B:183:0x058a, B:185:0x0590, B:186:0x05ab, B:188:0x05b1, B:189:0x05cf, B:190:0x05d8, B:194:0x05fd, B:191:0x05dc, B:193:0x05ea, B:195:0x0606, B:196:0x061e, B:198:0x0624, B:200:0x0637, B:201:0x0644, B:202:0x0648, B:204:0x064e, B:206:0x065c, B:160:0x04eb, B:162:0x04f9, B:165:0x050c, B:167:0x051e, B:169:0x052a, B:128:0x0421, B:130:0x042d, B:132:0x0439, B:144:0x047e, B:136:0x0456, B:139:0x0468, B:141:0x046e, B:143:0x0478, B:70:0x020d, B:73:0x0217, B:75:0x0225, B:79:0x026c, B:76:0x0242, B:78:0x0252, B:83:0x0279, B:86:0x02a8, B:87:0x02d2, B:89:0x030b, B:91:0x0313, B:94:0x031f, B:96:0x0356, B:97:0x0371, B:99:0x0377, B:101:0x0387, B:105:0x039d, B:102:0x0391, B:108:0x03a4, B:111:0x03ab, B:112:0x03c3, B:33:0x0122, B:35:0x012f, B:37:0x013b, B:39:0x0141, B:43:0x014c, B:210:0x0686, B:212:0x0694, B:214:0x069d, B:225:0x06ce, B:215:0x06a5, B:217:0x06ae, B:219:0x06b4, B:222:0x06c0, B:224:0x06c8, B:226:0x06d1, B:227:0x06dd, B:230:0x06e5, B:232:0x06f7, B:233:0x0702, B:235:0x070a, B:239:0x0730, B:241:0x074a, B:243:0x075f, B:245:0x0779, B:247:0x078e, B:249:0x07d3, B:251:0x07d9, B:257:0x0800, B:259:0x0808, B:260:0x0811, B:262:0x0817, B:263:0x081d, B:265:0x0832, B:267:0x0842, B:269:0x0852, B:272:0x085b, B:274:0x0861, B:275:0x0873, B:277:0x0879, B:279:0x0889, B:281:0x08a1, B:283:0x08b3, B:285:0x08da, B:286:0x08f3, B:288:0x0905, B:290:0x0924, B:292:0x094b, B:294:0x097b, B:295:0x0986, B:297:0x0998, B:299:0x09b7, B:301:0x09de, B:303:0x0a0e, B:304:0x0a17, B:305:0x0a20, B:306:0x0a24, B:314:0x0a98, B:316:0x0ab1, B:318:0x0ac7, B:320:0x0acc, B:322:0x0ad0, B:324:0x0ad4, B:326:0x0ade, B:327:0x0ae4, B:329:0x0ae8, B:331:0x0aee, B:332:0x0afc, B:333:0x0b05, B:338:0x0b29, B:341:0x0b2f, B:439:0x0e1e, B:441:0x0e33, B:444:0x0e3a, B:449:0x0e6b, B:451:0x0e7d, B:445:0x0e42, B:447:0x0e4e, B:448:0x0e54, B:252:0x07e7, B:254:0x07ed, B:256:0x07f3, B:246:0x078b, B:242:0x075c, B:236:0x0710, B:238:0x0716, B:454:0x0e9b), top: B:465:0x000f, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean zzaF(String str, long j) {
        boolean z;
        int i;
        long j2;
        boolean z2;
        long parseLong;
        long j3;
        int zzm;
        Long l;
        long j4;
        SecureRandom secureRandom;
        int i2;
        Long l2;
        Boolean bool;
        long zzaj;
        int i3;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean zzk;
        String str6;
        int i4;
        boolean z3;
        boolean z4;
        boolean z5;
        int i5;
        String str7;
        int i6;
        boolean z6;
        com.google.android.gms.internal.measurement.zzhv zzhvVar;
        int i7;
        String str8;
        int i8;
        int i9;
        int i10;
        String str9;
        int i11;
        int i12;
        int i13;
        zzpf zzpfVar = this;
        String str10 = FirebaseAnalytics.Event.PURCHASE;
        String str11 = FirebaseAnalytics.Param.ITEMS;
        zzpfVar.zzj().zzb();
        try {
            zzpb zzpbVar = new zzpb(zzpfVar, null);
            zzpfVar.zzj().zzav(str, j, zzpfVar.zzB, zzpbVar);
            List list = zzpbVar.zzc;
            if (list != null && !list.isEmpty()) {
                com.google.android.gms.internal.measurement.zzic zzicVar = (com.google.android.gms.internal.measurement.zzic) zzpbVar.zza.zzcl();
                zzicVar.zzi();
                com.google.android.gms.internal.measurement.zzhr zzhrVar = null;
                com.google.android.gms.internal.measurement.zzhr zzhrVar2 = null;
                int i14 = -1;
                int i15 = 0;
                int i16 = 0;
                boolean z7 = false;
                boolean z8 = false;
                int i17 = -1;
                while (true) {
                    i = i16;
                    boolean z9 = z7;
                    com.google.android.gms.internal.measurement.zzhr zzhrVar3 = zzhrVar;
                    int i18 = i17;
                    com.google.android.gms.internal.measurement.zzhr zzhrVar4 = zzhrVar2;
                    if (i15 >= zzpbVar.zzc.size()) {
                        break;
                    }
                    com.google.android.gms.internal.measurement.zzhr zzhrVar5 = (com.google.android.gms.internal.measurement.zzhr) ((com.google.android.gms.internal.measurement.zzhs) zzpbVar.zzc.get(i15)).zzcl();
                    boolean z10 = z8;
                    if (zzpfVar.zzh().zzj(zzpbVar.zza.zzA(), zzhrVar5.zzk())) {
                        zzpfVar.zzaV().zze().zzc("Dropping blocked raw event. appId", zzgt.zzl(zzpbVar.zza.zzA()), zzpfVar.zzn.zzl().zza(zzhrVar5.zzk()));
                        if (!zzpfVar.zzh().zzn(zzpbVar.zza.zzA()) && !zzpfVar.zzh().zzo(zzpbVar.zza.zzA()) && !"_err".equals(zzhrVar5.zzk())) {
                            zzpfVar.zzt().zzN(zzpfVar.zzK, zzpbVar.zza.zzA(), 11, "_ev", zzhrVar5.zzk(), 0);
                        }
                        i16 = i;
                        str6 = str10;
                        str9 = str11;
                        zzhrVar = zzhrVar3;
                        i17 = i18;
                        zzhrVar2 = zzhrVar4;
                        z8 = z10;
                        i10 = i14;
                        i11 = i15;
                    } else {
                        String zzk2 = zzhrVar5.zzk();
                        int i19 = i15;
                        if (!zzk2.equals(str10) && !zzk2.equals("_iap") && !zzk2.equals("ecommerce_purchase")) {
                            str4 = str11;
                            if (zzhrVar5.zzk().equals(zzjl.zza("_ai"))) {
                                zzhrVar5.zzl("_ai");
                                zzpfVar.zzaV().zzk().zza("Renaming ad_impression to _ai");
                                if (Log.isLoggable(zzpfVar.zzaV().zzn(), 5)) {
                                    for (int i20 = 0; i20 < zzhrVar5.zzb(); i20++) {
                                        if (FirebaseAnalytics.Param.AD_PLATFORM.equals(zzhrVar5.zzc(i20).zzb()) && !zzhrVar5.zzc(i20).zzd().isEmpty() && "admob".equalsIgnoreCase(zzhrVar5.zzc(i20).zzd())) {
                                            zzpfVar.zzaV().zzh().zza("AdMob ad impression logged from app. Potentially duplicative.");
                                        }
                                    }
                                }
                            }
                            zzk = zzpfVar.zzh().zzk(zzpbVar.zza.zzA(), zzhrVar5.zzk());
                            if (!zzk) {
                                zzpfVar.zzp();
                                String zzk3 = zzhrVar5.zzk();
                                Preconditions.checkNotEmpty(zzk3);
                                if (zzk3.hashCode() != 95027 || !zzk3.equals("_ui")) {
                                    str6 = str10;
                                    i5 = i14;
                                    str7 = "_et";
                                    z8 = z10;
                                    z5 = false;
                                    if (z5) {
                                        str8 = str7;
                                    } else {
                                        ArrayList arrayList = new ArrayList(zzhrVar5.zza());
                                        int i21 = 0;
                                        int i22 = -1;
                                        int i23 = -1;
                                        while (true) {
                                            str8 = str7;
                                            if (i21 >= arrayList.size()) {
                                                break;
                                            }
                                            if ("value".equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i21)).zzb())) {
                                                i22 = i21;
                                            } else if (FirebaseAnalytics.Param.CURRENCY.equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i21)).zzb())) {
                                                i23 = i21;
                                            }
                                            i21++;
                                            str7 = str8;
                                        }
                                        if (i22 != -1) {
                                            if (((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i22)).zze() || ((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i22)).zzi()) {
                                                if (i23 != -1) {
                                                    String zzd = ((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i23)).zzd();
                                                    if (zzd.length() == 3) {
                                                        int i24 = 0;
                                                        while (i24 < zzd.length()) {
                                                            int codePointAt = zzd.codePointAt(i24);
                                                            if (Character.isLetter(codePointAt)) {
                                                                i24 += Character.charCount(codePointAt);
                                                            }
                                                        }
                                                    }
                                                }
                                                zzpfVar.zzaV().zzh().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                                zzhrVar5.zzj(i22);
                                                zzaA(zzhrVar5, "_c");
                                                zzaz(zzhrVar5, 19, FirebaseAnalytics.Param.CURRENCY);
                                                break;
                                            }
                                            zzpfVar.zzaV().zzh().zza("Value must be specified with a numeric type.");
                                            zzhrVar5.zzj(i22);
                                            zzaA(zzhrVar5, "_c");
                                            zzaz(zzhrVar5, 18, "value");
                                        }
                                        if ("_e".equals(zzhrVar5.zzk())) {
                                            zzpfVar.zzp();
                                            if (zzpj.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar5.zzbc(), "_fr") == null) {
                                                if (zzhrVar4 != null && Math.abs(zzhrVar4.zzn() - zzhrVar5.zzn()) <= 1000) {
                                                    com.google.android.gms.internal.measurement.zzhr zzhrVar6 = (com.google.android.gms.internal.measurement.zzhr) zzhrVar4.zzaR();
                                                    if (zzpfVar.zzaH(zzhrVar5, zzhrVar6)) {
                                                        int i25 = i5;
                                                        zzicVar.zzf(i25, zzhrVar6);
                                                        i9 = i25;
                                                        i17 = i18;
                                                        zzhrVar = null;
                                                        zzhrVar2 = null;
                                                        if (zzhrVar5.zzb() == 0) {
                                                            zzpfVar.zzp();
                                                            Bundle zzE = zzpj.zzE(zzhrVar5.zza());
                                                            int i26 = 0;
                                                            while (i26 < zzhrVar5.zzb()) {
                                                                com.google.android.gms.internal.measurement.zzhw zzc = zzhrVar5.zzc(i26);
                                                                String str12 = str4;
                                                                if (!zzc.zzb().equals(str12) || zzc.zzk().isEmpty()) {
                                                                    i12 = i9;
                                                                    i13 = i26;
                                                                    if (!zzc.zzb().equals(str12)) {
                                                                        zzpfVar.zzT(zzhrVar5.zzk(), (com.google.android.gms.internal.measurement.zzhv) zzc.zzcl(), zzE, zzpbVar.zza.zzA());
                                                                    }
                                                                } else {
                                                                    String zzA = zzpbVar.zza.zzA();
                                                                    List zzk4 = zzc.zzk();
                                                                    Bundle[] bundleArr = new Bundle[zzk4.size()];
                                                                    i12 = i9;
                                                                    i13 = i26;
                                                                    int i27 = 0;
                                                                    while (i27 < zzk4.size()) {
                                                                        com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) zzk4.get(i27);
                                                                        zzpfVar.zzp();
                                                                        int i28 = i27;
                                                                        Bundle zzE2 = zzpj.zzE(zzhwVar.zzk());
                                                                        Iterator it = zzhwVar.zzk().iterator();
                                                                        while (it.hasNext()) {
                                                                            zzpfVar.zzT(zzhrVar5.zzk(), (com.google.android.gms.internal.measurement.zzhv) ((com.google.android.gms.internal.measurement.zzhw) it.next()).zzcl(), zzE2, zzA);
                                                                            it = it;
                                                                            zzk4 = zzk4;
                                                                        }
                                                                        bundleArr[i28] = zzE2;
                                                                        i27 = i28 + 1;
                                                                        zzk4 = zzk4;
                                                                    }
                                                                    zzE.putParcelableArray(str12, bundleArr);
                                                                }
                                                                i26 = i13 + 1;
                                                                str4 = str12;
                                                                i9 = i12;
                                                            }
                                                            i10 = i9;
                                                            str9 = str4;
                                                            zzhrVar5.zzi();
                                                            zzpj zzp = zzpfVar.zzp();
                                                            ArrayList<com.google.android.gms.internal.measurement.zzhw> arrayList2 = new ArrayList();
                                                            for (String str13 : zzE.keySet()) {
                                                                com.google.android.gms.internal.measurement.zzhv zzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                                                                zzn.zzb(str13);
                                                                Object obj = zzE.get(str13);
                                                                if (obj != null) {
                                                                    zzp.zzd(zzn, obj);
                                                                    arrayList2.add((com.google.android.gms.internal.measurement.zzhw) zzn.zzbc());
                                                                }
                                                            }
                                                            for (com.google.android.gms.internal.measurement.zzhw zzhwVar2 : arrayList2) {
                                                                zzhrVar5.zzf(zzhwVar2);
                                                            }
                                                        } else {
                                                            i10 = i9;
                                                            str9 = str4;
                                                        }
                                                        i11 = i19;
                                                        zzpbVar.zzc.set(i11, (com.google.android.gms.internal.measurement.zzhs) zzhrVar5.zzbc());
                                                        zzicVar.zzg(zzhrVar5);
                                                        i16 = i + 1;
                                                    }
                                                }
                                                i17 = i;
                                                zzhrVar = zzhrVar5;
                                                i9 = i5;
                                                zzhrVar2 = zzhrVar4;
                                                if (zzhrVar5.zzb() == 0) {
                                                }
                                                i11 = i19;
                                                zzpbVar.zzc.set(i11, (com.google.android.gms.internal.measurement.zzhs) zzhrVar5.zzbc());
                                                zzicVar.zzg(zzhrVar5);
                                                i16 = i + 1;
                                            } else {
                                                i8 = i5;
                                                i17 = i18;
                                                i9 = i8;
                                                zzhrVar = zzhrVar3;
                                                zzhrVar2 = zzhrVar4;
                                                if (zzhrVar5.zzb() == 0) {
                                                }
                                                i11 = i19;
                                                zzpbVar.zzc.set(i11, (com.google.android.gms.internal.measurement.zzhs) zzhrVar5.zzbc());
                                                zzicVar.zzg(zzhrVar5);
                                                i16 = i + 1;
                                            }
                                        } else {
                                            i8 = i5;
                                            if ("_vs".equals(zzhrVar5.zzk())) {
                                                zzpfVar.zzp();
                                                if (zzpj.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar5.zzbc(), str8) == null) {
                                                    if (zzhrVar3 != null && Math.abs(zzhrVar3.zzn() - zzhrVar5.zzn()) <= 1000) {
                                                        com.google.android.gms.internal.measurement.zzhr zzhrVar7 = (com.google.android.gms.internal.measurement.zzhr) zzhrVar3.zzaR();
                                                        if (zzpfVar.zzaH(zzhrVar7, zzhrVar5)) {
                                                            zzicVar.zzf(i18, zzhrVar7);
                                                            i17 = i18;
                                                            i9 = i8;
                                                            zzhrVar = null;
                                                            zzhrVar2 = null;
                                                            if (zzhrVar5.zzb() == 0) {
                                                            }
                                                            i11 = i19;
                                                            zzpbVar.zzc.set(i11, (com.google.android.gms.internal.measurement.zzhs) zzhrVar5.zzbc());
                                                            zzicVar.zzg(zzhrVar5);
                                                            i16 = i + 1;
                                                        }
                                                    }
                                                    i17 = i18;
                                                    zzhrVar2 = zzhrVar5;
                                                    zzhrVar = zzhrVar3;
                                                    i9 = i;
                                                    if (zzhrVar5.zzb() == 0) {
                                                    }
                                                    i11 = i19;
                                                    zzpbVar.zzc.set(i11, (com.google.android.gms.internal.measurement.zzhs) zzhrVar5.zzbc());
                                                    zzicVar.zzg(zzhrVar5);
                                                    i16 = i + 1;
                                                }
                                            }
                                            i17 = i18;
                                            i9 = i8;
                                            zzhrVar = zzhrVar3;
                                            zzhrVar2 = zzhrVar4;
                                            if (zzhrVar5.zzb() == 0) {
                                            }
                                            i11 = i19;
                                            zzpbVar.zzc.set(i11, (com.google.android.gms.internal.measurement.zzhs) zzhrVar5.zzbc());
                                            zzicVar.zzg(zzhrVar5);
                                            i16 = i + 1;
                                        }
                                    }
                                    if ("_e".equals(zzhrVar5.zzk())) {
                                    }
                                }
                            }
                            str6 = str10;
                            i4 = 0;
                            z3 = false;
                            z4 = false;
                            while (true) {
                                z5 = zzk;
                                if (i4 >= zzhrVar5.zzb()) {
                                    break;
                                }
                                if ("_c".equals(zzhrVar5.zzc(i4).zzb())) {
                                    com.google.android.gms.internal.measurement.zzhv zzhvVar2 = (com.google.android.gms.internal.measurement.zzhv) zzhrVar5.zzc(i4).zzcl();
                                    i7 = i14;
                                    zzhvVar2.zzf(1L);
                                    zzhrVar5.zzd(i4, (com.google.android.gms.internal.measurement.zzhw) zzhvVar2.zzbc());
                                    z3 = true;
                                } else {
                                    i7 = i14;
                                    if ("_r".equals(zzhrVar5.zzc(i4).zzb())) {
                                        com.google.android.gms.internal.measurement.zzhv zzhvVar3 = (com.google.android.gms.internal.measurement.zzhv) zzhrVar5.zzc(i4).zzcl();
                                        zzhvVar3.zzf(1L);
                                        zzhrVar5.zzd(i4, (com.google.android.gms.internal.measurement.zzhw) zzhvVar3.zzbc());
                                        z4 = true;
                                    }
                                }
                                i4++;
                                zzk = z5;
                                i14 = i7;
                            }
                            i5 = i14;
                            if (z3 && z5) {
                                zzpfVar.zzaV().zzk().zzb("Marking event as conversion", zzpfVar.zzn.zzl().zza(zzhrVar5.zzk()));
                                com.google.android.gms.internal.measurement.zzhv zzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzn2.zzb("_c");
                                str7 = "_et";
                                zzn2.zzf(1L);
                                zzhrVar5.zzg(zzn2);
                            } else {
                                str7 = "_et";
                            }
                            if (!z4) {
                                zzpfVar.zzaV().zzk().zzb("Marking event as real-time", zzpfVar.zzn.zzl().zza(zzhrVar5.zzk()));
                                com.google.android.gms.internal.measurement.zzhv zzn3 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzn3.zzb("_r");
                                zzn3.zzf(1L);
                                zzhrVar5.zzg(zzn3);
                            }
                            if (zzpfVar.zzj().zzw(zzpfVar.zzC(), zzpbVar.zza.zzA(), false, false, false, false, true, false, false).zze > zzpfVar.zzd().zzm(zzpbVar.zza.zzA(), zzfx.zzo)) {
                                zzaA(zzhrVar5, "_r");
                                z8 = z10;
                            } else {
                                z8 = true;
                            }
                            if (zzpo.zzh(zzhrVar5.zzk()) && z5 && zzpfVar.zzj().zzw(zzpfVar.zzC(), zzpbVar.zza.zzA(), false, false, true, false, false, false, false).zzc > zzpfVar.zzd().zzm(zzpbVar.zza.zzA(), zzfx.zzn)) {
                                zzpfVar.zzaV().zze().zzb("Too many conversions. Not logging as conversion. appId", zzgt.zzl(zzpbVar.zza.zzA()));
                                i6 = 0;
                                z6 = false;
                                int i292 = -1;
                                zzhvVar = null;
                                while (i6 < zzhrVar5.zzb()) {
                                    com.google.android.gms.internal.measurement.zzhw zzc2 = zzhrVar5.zzc(i6);
                                    int i30 = i6;
                                    if ("_c".equals(zzc2.zzb())) {
                                        zzhvVar = (com.google.android.gms.internal.measurement.zzhv) zzc2.zzcl();
                                        i292 = i30;
                                    } else if ("_err".equals(zzc2.zzb())) {
                                        z6 = true;
                                    }
                                    i6 = i30 + 1;
                                }
                                if (z6) {
                                    if (zzhvVar != null) {
                                        zzhrVar5.zzj(i292);
                                    } else {
                                        zzhvVar = null;
                                    }
                                }
                                if (zzhvVar == null) {
                                    com.google.android.gms.internal.measurement.zzhv zzhvVar4 = (com.google.android.gms.internal.measurement.zzhv) zzhvVar.zzaR();
                                    zzhvVar4.zzb("_err");
                                    zzhvVar4.zzf(10L);
                                    zzhrVar5.zzd(i292, (com.google.android.gms.internal.measurement.zzhw) zzhvVar4.zzbc());
                                } else {
                                    zzpfVar.zzaV().zzb().zzb("Did not find conversion parameter. appId", zzgt.zzl(zzpbVar.zza.zzA()));
                                }
                            }
                            if (z5) {
                            }
                            if ("_e".equals(zzhrVar5.zzk())) {
                            }
                        }
                        com.google.android.gms.internal.measurement.zzhv zzn4 = com.google.android.gms.internal.measurement.zzhw.zzn();
                        str4 = str11;
                        zzn4.zzb("_ct");
                        if (!z9) {
                            String zzA2 = zzpbVar.zza.zzA();
                            if (zzpfVar.zzaO(zzA2, str10) && zzpfVar.zzaO(zzA2, "_iap") && zzpfVar.zzaO(zzA2, "ecommerce_purchase")) {
                                str5 = "new";
                                zzn4.zzd(str5);
                                zzhrVar5.zzf((com.google.android.gms.internal.measurement.zzhw) zzn4.zzbc());
                                z9 = true;
                                if (zzhrVar5.zzk().equals(zzjl.zza("_ai"))) {
                                }
                                zzk = zzpfVar.zzh().zzk(zzpbVar.zza.zzA(), zzhrVar5.zzk());
                                if (!zzk) {
                                }
                                str6 = str10;
                                i4 = 0;
                                z3 = false;
                                z4 = false;
                                while (true) {
                                    z5 = zzk;
                                    if (i4 >= zzhrVar5.zzb()) {
                                    }
                                    i4++;
                                    zzk = z5;
                                    i14 = i7;
                                }
                                i5 = i14;
                                if (z3) {
                                }
                                str7 = "_et";
                                if (!z4) {
                                }
                                if (zzpfVar.zzj().zzw(zzpfVar.zzC(), zzpbVar.zza.zzA(), false, false, false, false, true, false, false).zze > zzpfVar.zzd().zzm(zzpbVar.zza.zzA(), zzfx.zzo)) {
                                }
                                if (zzpo.zzh(zzhrVar5.zzk())) {
                                    zzpfVar.zzaV().zze().zzb("Too many conversions. Not logging as conversion. appId", zzgt.zzl(zzpbVar.zza.zzA()));
                                    i6 = 0;
                                    z6 = false;
                                    int i2922 = -1;
                                    zzhvVar = null;
                                    while (i6 < zzhrVar5.zzb()) {
                                    }
                                    if (z6) {
                                    }
                                    if (zzhvVar == null) {
                                    }
                                }
                                if (z5) {
                                }
                                if ("_e".equals(zzhrVar5.zzk())) {
                                }
                            }
                        }
                        str5 = "returning";
                        zzn4.zzd(str5);
                        zzhrVar5.zzf((com.google.android.gms.internal.measurement.zzhw) zzn4.zzbc());
                        z9 = true;
                        if (zzhrVar5.zzk().equals(zzjl.zza("_ai"))) {
                        }
                        zzk = zzpfVar.zzh().zzk(zzpbVar.zza.zzA(), zzhrVar5.zzk());
                        if (!zzk) {
                        }
                        str6 = str10;
                        i4 = 0;
                        z3 = false;
                        z4 = false;
                        while (true) {
                            z5 = zzk;
                            if (i4 >= zzhrVar5.zzb()) {
                            }
                            i4++;
                            zzk = z5;
                            i14 = i7;
                        }
                        i5 = i14;
                        if (z3) {
                        }
                        str7 = "_et";
                        if (!z4) {
                        }
                        if (zzpfVar.zzj().zzw(zzpfVar.zzC(), zzpbVar.zza.zzA(), false, false, false, false, true, false, false).zze > zzpfVar.zzd().zzm(zzpbVar.zza.zzA(), zzfx.zzo)) {
                        }
                        if (zzpo.zzh(zzhrVar5.zzk())) {
                        }
                        if (z5) {
                        }
                        if ("_e".equals(zzhrVar5.zzk())) {
                        }
                    }
                    i15 = i11 + 1;
                    str11 = str9;
                    z7 = z9;
                    i14 = i10;
                    str10 = str6;
                }
                boolean z11 = z8;
                long j5 = 0;
                int i31 = i;
                long j6 = 0;
                int i32 = 0;
                while (i32 < i31) {
                    com.google.android.gms.internal.measurement.zzhs zzd2 = zzicVar.zzd(i32);
                    if ("_e".equals(zzd2.zzd())) {
                        zzpfVar.zzp();
                        if (zzpj.zzF(zzd2, "_fr") != null) {
                            zzicVar.zzj(i32);
                            i31--;
                            i32--;
                            i32++;
                        }
                    }
                    zzpfVar.zzp();
                    com.google.android.gms.internal.measurement.zzhw zzF = zzpj.zzF(zzd2, "_et");
                    if (zzF != null) {
                        Long valueOf = zzF.zze() ? Long.valueOf(zzF.zzf()) : null;
                        if (valueOf != null && valueOf.longValue() > 0) {
                            j6 += valueOf.longValue();
                        }
                    }
                    i32++;
                }
                zzpfVar.zzaG(zzicVar, j6, false);
                Iterator it2 = zzicVar.zzb().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if ("_s".equals(((com.google.android.gms.internal.measurement.zzhs) it2.next()).zzd())) {
                            zzpfVar.zzj().zzk(zzicVar.zzK(), "_se");
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (zzpj.zzx(zzicVar, "_sid") >= 0) {
                    zzpfVar.zzaG(zzicVar, j6, true);
                } else {
                    int zzx = zzpj.zzx(zzicVar, "_se");
                    if (zzx >= 0) {
                        zzicVar.zzr(zzx);
                        zzpfVar.zzaV().zzb().zzb("Session engagement user property is in the bundle without session ID. appId", zzgt.zzl(zzpbVar.zza.zzA()));
                    }
                }
                String zzA3 = zzpbVar.zza.zzA();
                zzpfVar.zzaW().zzg();
                zzpfVar.zzu();
                zzh zzu = zzpfVar.zzj().zzu(zzA3);
                if (zzu == null) {
                    zzpfVar.zzaV().zzb().zzb("Cannot fix consent fields without appInfo. appId", zzgt.zzl(zzA3));
                } else {
                    zzpfVar.zzI(zzu, zzicVar);
                }
                String zzA4 = zzpbVar.zza.zzA();
                zzpfVar.zzaW().zzg();
                zzpfVar.zzu();
                zzh zzu2 = zzpfVar.zzj().zzu(zzA4);
                if (zzu2 == null) {
                    zzpfVar.zzaV().zze().zzb("Cannot populate ad_campaign_info without appInfo. appId", zzgt.zzl(zzA4));
                } else {
                    zzpfVar.zzJ(zzu2, zzicVar);
                }
                zzaR(zzicVar);
                zzicVar.zzak();
                zzjk zzjkVar = zzjk.zza;
                zzjk zzs = zzpfVar.zzB(zzpbVar.zza.zzA()).zzs(zzjk.zzf(zzpbVar.zza.zzaf(), 100));
                zzjk zzaf = zzpfVar.zzj().zzaf(zzpbVar.zza.zzA());
                zzpfVar.zzj().zzae(zzpbVar.zza.zzA(), zzs);
                zzjj zzjjVar = zzjj.ANALYTICS_STORAGE;
                if (zzs.zzo(zzjjVar) || !zzaf.zzo(zzjjVar)) {
                    if (zzs.zzo(zzjjVar) && !zzaf.zzo(zzjjVar)) {
                        zzpfVar.zzj().zzj(zzpbVar.zza.zzA());
                    }
                } else {
                    zzpfVar.zzj().zzi(zzpbVar.zza.zzA());
                }
                zzjj zzjjVar2 = zzjj.AD_STORAGE;
                if (!zzs.zzo(zzjjVar2)) {
                    zzicVar.zzR();
                    zzicVar.zzU();
                    zzicVar.zzan();
                }
                if (!zzs.zzo(zzjjVar)) {
                    zzicVar.zzX();
                    zzicVar.zzav();
                }
                zzql.zza();
                if (zzpfVar.zzd().zzp(zzpbVar.zza.zzA(), zzfx.zzaP) && zzpfVar.zzt().zzX(zzpbVar.zza.zzA()) && zzpfVar.zzB(zzpbVar.zza.zzA()).zzo(zzjjVar2) && zzpbVar.zza.zzak()) {
                    for (int i33 = 0; i33 < zzicVar.zzc(); i33++) {
                        com.google.android.gms.internal.measurement.zzhr zzhrVar8 = (com.google.android.gms.internal.measurement.zzhr) zzicVar.zzd(i33).zzcl();
                        Iterator it3 = zzhrVar8.zza().iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                break;
                            } else if ("_c".equals(((com.google.android.gms.internal.measurement.zzhw) it3.next()).zzb())) {
                                if (zzpbVar.zza.zzar() >= zzpfVar.zzd().zzm(zzpbVar.zza.zzA(), zzfx.zzal)) {
                                    int zzm2 = zzpfVar.zzd().zzm(zzpbVar.zza.zzA(), zzfx.zzay);
                                    if (zzm2 > 0) {
                                        if (zzpfVar.zzj().zzw(zzpfVar.zzC(), zzpbVar.zza.zzA(), false, false, false, false, false, false, true).zzg > zzm2) {
                                            com.google.android.gms.internal.measurement.zzhv zzn5 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                            zzn5.zzb("_tnr");
                                            zzn5.zzf(1L);
                                            zzhrVar8.zzf((com.google.android.gms.internal.measurement.zzhw) zzn5.zzbc());
                                        } else {
                                            if (zzpfVar.zzd().zzp(zzpbVar.zza.zzA(), zzfx.zzaR)) {
                                                str3 = zzpfVar.zzt().zzaw();
                                                com.google.android.gms.internal.measurement.zzhv zzn6 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                                zzn6.zzb("_tu");
                                                zzn6.zzd(str3);
                                                zzhrVar8.zzf((com.google.android.gms.internal.measurement.zzhw) zzn6.zzbc());
                                            } else {
                                                str3 = null;
                                            }
                                            com.google.android.gms.internal.measurement.zzhv zzn7 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                            zzn7.zzb("_tr");
                                            zzn7.zzf(1L);
                                            zzhrVar8.zzf((com.google.android.gms.internal.measurement.zzhw) zzn7.zzbc());
                                            zzog zzf = zzpfVar.zzp().zzf(zzpbVar.zza.zzA(), zzicVar, zzhrVar8, str3);
                                            if (zzf != null) {
                                                zzpfVar.zzaV().zzk().zzc("Generated trigger URI. appId, uri", zzpbVar.zza.zzA(), zzf.zza);
                                                zzpfVar.zzj().zzaa(zzpbVar.zza.zzA(), zzf);
                                                Deque deque = zzpfVar.zzr;
                                                if (!deque.contains(zzpbVar.zza.zzA())) {
                                                    deque.add(zzpbVar.zza.zzA());
                                                }
                                            }
                                        }
                                    } else {
                                        if (zzpfVar.zzd().zzp(zzpbVar.zza.zzA(), zzfx.zzaR)) {
                                            str2 = zzpfVar.zzt().zzaw();
                                            com.google.android.gms.internal.measurement.zzhv zzn8 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                            zzn8.zzb("_tu");
                                            zzn8.zzd(str2);
                                            zzhrVar8.zzf((com.google.android.gms.internal.measurement.zzhw) zzn8.zzbc());
                                        } else {
                                            str2 = null;
                                        }
                                        com.google.android.gms.internal.measurement.zzhv zzn9 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                        zzn9.zzb("_tr");
                                        zzn9.zzf(1L);
                                        zzhrVar8.zzf((com.google.android.gms.internal.measurement.zzhw) zzn9.zzbc());
                                        zzog zzf2 = zzpfVar.zzp().zzf(zzpbVar.zza.zzA(), zzicVar, zzhrVar8, str2);
                                        if (zzf2 != null) {
                                            zzpfVar.zzaV().zzk().zzc("Generated trigger URI. appId, uri", zzpbVar.zza.zzA(), zzf2.zza);
                                            zzpfVar.zzj().zzaa(zzpbVar.zza.zzA(), zzf2);
                                            Deque deque2 = zzpfVar.zzr;
                                            if (!deque2.contains(zzpbVar.zza.zzA())) {
                                                deque2.add(zzpbVar.zza.zzA());
                                            }
                                        }
                                    }
                                }
                                zzicVar.zze(i33, (com.google.android.gms.internal.measurement.zzhs) zzhrVar8.zzbc());
                            }
                        }
                    }
                }
                zzicVar.zzag();
                zzicVar.zzaf(zzpfVar.zzm().zzb(zzicVar.zzK(), zzicVar.zzb(), zzicVar.zzk(), Long.valueOf(zzicVar.zzu()), Long.valueOf(zzicVar.zzw()), !zzs.zzo(zzjjVar)));
                if (zzpfVar.zzd().zzD(zzpbVar.zza.zzA())) {
                    try {
                        HashMap hashMap = new HashMap();
                        ArrayList arrayList3 = new ArrayList();
                        SecureRandom zzf3 = zzpfVar.zzt().zzf();
                        int i34 = 0;
                        while (i34 < zzicVar.zzc()) {
                            com.google.android.gms.internal.measurement.zzhr zzhrVar9 = (com.google.android.gms.internal.measurement.zzhr) zzicVar.zzd(i34).zzcl();
                            if (zzhrVar9.zzk().equals("_ep")) {
                                zzpfVar.zzp();
                                String str14 = (String) zzpj.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar9.zzbc(), "_en");
                                zzbc zzbcVar = (zzbc) hashMap.get(str14);
                                if (zzbcVar == null && (zzbcVar = zzpfVar.zzj().zzf(zzpbVar.zza.zzA(), (String) Preconditions.checkNotNull(str14))) != null) {
                                    hashMap.put(str14, zzbcVar);
                                }
                                if (zzbcVar != null && zzbcVar.zzi == null) {
                                    Long l3 = zzbcVar.zzj;
                                    if (l3 != null && l3.longValue() > 1) {
                                        zzpfVar.zzp();
                                        zzpj.zzC(zzhrVar9, "_sr", l3);
                                    }
                                    Boolean bool2 = zzbcVar.zzk;
                                    if (bool2 != null && bool2.booleanValue()) {
                                        zzpfVar.zzp();
                                        zzpj.zzC(zzhrVar9, "_efs", 1L);
                                    }
                                    arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar9.zzbc());
                                }
                                zzicVar.zzf(i34, zzhrVar9);
                                j3 = j5;
                                secureRandom = zzf3;
                                i3 = i34;
                            } else {
                                zzhs zzh = zzpfVar.zzh();
                                String zzA5 = zzpbVar.zza.zzA();
                                String zza = zzh.zza(zzA5, "measurement.account.time_zone_offset_minutes");
                                if (!TextUtils.isEmpty(zza)) {
                                    try {
                                        parseLong = Long.parseLong(zza);
                                    } catch (NumberFormatException e) {
                                        zzh.zzu.zzaV().zze().zzc("Unable to parse timezone offset. appId", zzgt.zzl(zzA5), e);
                                    }
                                    long zzaj22 = zzpfVar.zzt().zzaj(zzhrVar9.zzn(), parseLong);
                                    com.google.android.gms.internal.measurement.zzhs zzhsVar2 = (com.google.android.gms.internal.measurement.zzhs) zzhrVar9.zzbc();
                                    j3 = j5;
                                    Long l42 = 1L;
                                    if (!TextUtils.isEmpty("_dbg")) {
                                        Iterator it4 = zzhsVar2.zza().iterator();
                                        while (true) {
                                            if (!it4.hasNext()) {
                                                break;
                                            }
                                            com.google.android.gms.internal.measurement.zzhw zzhwVar3 = (com.google.android.gms.internal.measurement.zzhw) it4.next();
                                            if ("_dbg".equals(zzhwVar3.zzb())) {
                                                if (l42.equals(Long.valueOf(zzhwVar3.zzf()))) {
                                                    zzm = 1;
                                                }
                                            }
                                        }
                                    }
                                    zzm = zzh().zzm(zzpbVar.zza.zzA(), zzhrVar9.zzk());
                                    if (zzm > 0) {
                                        zzaV().zze().zzc("Sample rate must be positive. event, rate", zzhrVar9.zzk(), Integer.valueOf(zzm));
                                        arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar9.zzbc());
                                        zzicVar.zzf(i34, zzhrVar9);
                                    } else {
                                        zzbc zzbcVar2 = (zzbc) hashMap.get(zzhrVar9.zzk());
                                        if (zzbcVar2 == null) {
                                            l = l42;
                                            zzbcVar2 = zzj().zzf(zzpbVar.zza.zzA(), zzhrVar9.zzk());
                                            if (zzbcVar2 == null) {
                                                j4 = parseLong;
                                                zzaV().zze().zzc("Event being bundled has no eventAggregate. appId, eventName", zzpbVar.zza.zzA(), zzhrVar9.zzk());
                                                zzbcVar2 = new zzbc(zzpbVar.zza.zzA(), zzhrVar9.zzk(), 1L, 1L, 1L, zzhrVar9.zzn(), 0L, null, null, null, null);
                                                zzp();
                                                Long l52 = (Long) zzpj.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar9.zzbc(), "_eid");
                                                Boolean valueOf22 = Boolean.valueOf(l52 == null);
                                                if (zzm != 1) {
                                                    arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar9.zzbc());
                                                    if (valueOf22.booleanValue() && (zzbcVar2.zzi != null || zzbcVar2.zzj != null || zzbcVar2.zzk != null)) {
                                                        hashMap.put(zzhrVar9.zzk(), zzbcVar2.zzc(null, null, null));
                                                    }
                                                    zzicVar.zzf(i34, zzhrVar9);
                                                } else {
                                                    if (zzf3.nextInt(zzm) == 0) {
                                                        zzp();
                                                        Long valueOf3 = Long.valueOf(zzm);
                                                        zzpj.zzC(zzhrVar9, "_sr", valueOf3);
                                                        arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar9.zzbc());
                                                        if (valueOf22.booleanValue()) {
                                                            zzbcVar2 = zzbcVar2.zzc(null, valueOf3, null);
                                                        }
                                                        hashMap.put(zzhrVar9.zzk(), zzbcVar2.zzb(zzhrVar9.zzn(), zzaj22));
                                                        secureRandom = zzf3;
                                                        i3 = i34;
                                                    } else {
                                                        Long l6 = zzbcVar2.zzh;
                                                        if (l6 != null) {
                                                            l2 = l52;
                                                            bool = valueOf22;
                                                            i2 = i34;
                                                            zzaj = l6.longValue();
                                                            secureRandom = zzf3;
                                                        } else {
                                                            secureRandom = zzf3;
                                                            i2 = i34;
                                                            l2 = l52;
                                                            bool = valueOf22;
                                                            zzaj = zzt().zzaj(zzhrVar9.zzp(), j4);
                                                        }
                                                        if (zzaj != zzaj22) {
                                                            zzp();
                                                            zzpj.zzC(zzhrVar9, "_efs", l);
                                                            zzp();
                                                            Long valueOf4 = Long.valueOf(zzm);
                                                            zzpj.zzC(zzhrVar9, "_sr", valueOf4);
                                                            arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar9.zzbc());
                                                            if (bool.booleanValue()) {
                                                                zzbcVar2 = zzbcVar2.zzc(null, valueOf4, true);
                                                            }
                                                            hashMap.put(zzhrVar9.zzk(), zzbcVar2.zzb(zzhrVar9.zzn(), zzaj22));
                                                            i3 = i2;
                                                        } else {
                                                            if (bool.booleanValue()) {
                                                                hashMap.put(zzhrVar9.zzk(), zzbcVar2.zzc(l2, null, null));
                                                            }
                                                            i3 = i2;
                                                        }
                                                    }
                                                    zzicVar.zzf(i3, zzhrVar9);
                                                    i34 = i3 + 1;
                                                    zzpfVar = this;
                                                    j5 = j3;
                                                    zzf3 = secureRandom;
                                                }
                                            }
                                        } else {
                                            l = l42;
                                        }
                                        j4 = parseLong;
                                        zzp();
                                        Long l522 = (Long) zzpj.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar9.zzbc(), "_eid");
                                        Boolean valueOf222 = Boolean.valueOf(l522 == null);
                                        if (zzm != 1) {
                                        }
                                    }
                                    secureRandom = zzf3;
                                    i3 = i34;
                                }
                                parseLong = j5;
                                long zzaj222 = zzpfVar.zzt().zzaj(zzhrVar9.zzn(), parseLong);
                                com.google.android.gms.internal.measurement.zzhs zzhsVar22 = (com.google.android.gms.internal.measurement.zzhs) zzhrVar9.zzbc();
                                j3 = j5;
                                Long l422 = 1L;
                                if (!TextUtils.isEmpty("_dbg")) {
                                }
                                zzm = zzh().zzm(zzpbVar.zza.zzA(), zzhrVar9.zzk());
                                if (zzm > 0) {
                                }
                                secureRandom = zzf3;
                                i3 = i34;
                            }
                            i34 = i3 + 1;
                            zzpfVar = this;
                            j5 = j3;
                            zzf3 = secureRandom;
                        }
                        j2 = j5;
                        z2 = true;
                        if (arrayList3.size() < zzicVar.zzc()) {
                            zzicVar.zzi();
                            zzicVar.zzh(arrayList3);
                        }
                        for (Map.Entry entry : hashMap.entrySet()) {
                            zzj().zzh((zzbc) entry.getValue());
                        }
                    } catch (Throwable th) {
                        th = th;
                        zzpfVar = this;
                        zzpfVar.zzj().zzd();
                        throw th;
                    }
                } else {
                    j2 = 0;
                    z2 = true;
                }
                String zzA6 = zzpbVar.zza.zzA();
                zzh zzu3 = zzj().zzu(zzA6);
                if (zzu3 == null) {
                    zzaV().zzb().zzb("Bundling raw events w/o app info. appId", zzgt.zzl(zzpbVar.zza.zzA()));
                } else if (zzicVar.zzc() > 0) {
                    long zzp2 = zzu3.zzp();
                    if (zzp2 != j2) {
                        zzicVar.zzA(zzp2);
                    } else {
                        zzicVar.zzB();
                    }
                    long zzn10 = zzu3.zzn();
                    if (zzn10 != j2) {
                        zzp2 = zzn10;
                    }
                    if (zzp2 != j2) {
                        zzicVar.zzy(zzp2);
                    } else {
                        zzicVar.zzz();
                    }
                    zzu3.zzM(zzicVar.zzc());
                    zzicVar.zzaJ((int) zzu3.zzaF());
                    zzicVar.zzZ((int) zzu3.zzG());
                    zzu3.zzo(zzicVar.zzu());
                    zzu3.zzq(zzicVar.zzw());
                    String zzaa = zzu3.zzaa();
                    if (zzaa != null) {
                        zzicVar.zzaa(zzaa);
                    } else {
                        zzicVar.zzab();
                    }
                    zzj().zzv(zzu3, false, false);
                }
                if (zzicVar.zzc() > 0) {
                    zzpfVar = this;
                    zzpfVar.zzn.zzaU();
                    com.google.android.gms.internal.measurement.zzgl zzb2 = zzpfVar.zzh().zzb(zzpbVar.zza.zzA());
                    if (zzb2 != null && zzb2.zza()) {
                        zzicVar.zzal(zzb2.zzb());
                        zzpfVar.zzj().zzz((com.google.android.gms.internal.measurement.zzid) zzicVar.zzbc(), z11);
                    }
                    if (zzpbVar.zza.zzP().isEmpty()) {
                        zzicVar.zzal(-1L);
                    } else {
                        zzpfVar.zzaV().zze().zzb("Did not find measurement config or missing version info. appId", zzgt.zzl(zzpbVar.zza.zzA()));
                    }
                    zzpfVar.zzj().zzz((com.google.android.gms.internal.measurement.zzid) zzicVar.zzbc(), z11);
                } else {
                    zzpfVar = this;
                }
                zzpfVar.zzj().zzS(zzpbVar.zzb);
                zzpfVar.zzj().zzT(zzA6);
                zzpfVar.zzj().zzc();
                z = z2;
                zzpfVar.zzj().zzd();
                return z;
            }
            zzpfVar.zzj().zzc();
            z = false;
            zzpfVar.zzj().zzd();
            return z;
        } catch (Throwable th2) {
            th = th2;
            zzpfVar.zzj().zzd();
            throw th;
        }
    }

    private final void zzaG(com.google.android.gms.internal.measurement.zzic zzicVar, long j, boolean z) {
        String str;
        zzpm zzpmVar;
        Object obj;
        if (true != z) {
            str = "_lte";
        } else {
            str = "_se";
        }
        String str2 = str;
        zzpm zzm = zzj().zzm(zzicVar.zzK(), str2);
        if (zzm == null || (obj = zzm.zze) == null) {
            zzpmVar = new zzpm(zzicVar.zzK(), "auto", str2, zzaZ().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzpmVar = new zzpm(zzicVar.zzK(), "auto", str2, zzaZ().currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + j));
        }
        com.google.android.gms.internal.measurement.zzit zzm2 = com.google.android.gms.internal.measurement.zziu.zzm();
        zzm2.zzb(str2);
        zzm2.zza(zzaZ().currentTimeMillis());
        Object obj2 = zzpmVar.zze;
        zzm2.zze(((Long) obj2).longValue());
        com.google.android.gms.internal.measurement.zziu zziuVar = (com.google.android.gms.internal.measurement.zziu) zzm2.zzbc();
        int zzx = zzpj.zzx(zzicVar, str2);
        if (zzx < 0) {
            zzicVar.zzo(zziuVar);
        } else {
            zzicVar.zzn(zzx, zziuVar);
        }
        if (j > 0) {
            zzj().zzl(zzpmVar);
            zzaV().zzk().zzc("Updated engagement user property. scope, value", true != z ? "lifetime" : "session-scoped", obj2);
        }
    }

    private final boolean zzaH(com.google.android.gms.internal.measurement.zzhr zzhrVar, com.google.android.gms.internal.measurement.zzhr zzhrVar2) {
        Preconditions.checkArgument("_e".equals(zzhrVar.zzk()));
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzF = zzpj.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc(), "_sc");
        String zzd = zzF == null ? null : zzF.zzd();
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzF2 = zzpj.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar2.zzbc(), "_pc");
        String zzd2 = zzF2 != null ? zzF2.zzd() : null;
        if (zzd2 == null || !zzd2.equals(zzd)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzhrVar.zzk()));
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzF3 = zzpj.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc(), "_et");
        if (zzF3 == null || !zzF3.zze() || zzF3.zzf() <= 0) {
            return true;
        }
        long zzf = zzF3.zzf();
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzF4 = zzpj.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar2.zzbc(), "_et");
        if (zzF4 != null && zzF4.zzf() > 0) {
            zzf += zzF4.zzf();
        }
        zzp();
        zzpj.zzC(zzhrVar2, "_et", Long.valueOf(zzf));
        zzp();
        zzpj.zzC(zzhrVar, "_fr", 1L);
        return true;
    }

    private final boolean zzaI() {
        zzaW().zzg();
        zzu();
        return zzj().zzP() || !TextUtils.isEmpty(zzj().zzF());
    }

    private static String zzaJ(Map map, String str) {
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

    private final void zzaK() {
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
        if (!this.zzn.zzH() || !zzaI()) {
            zzaV().zzk().zza("Nothing to upload or uploading impossible");
            zzk().zzb();
            zzl().zzd();
            return;
        }
        long currentTimeMillis = zzaZ().currentTimeMillis();
        zzd();
        long max2 = Math.max(0L, ((Long) zzfx.zzO.zzb(null)).longValue());
        boolean z = true;
        if (!zzj().zzR() && !zzj().zzG()) {
            z = false;
        }
        if (z) {
            String zzA = zzd().zzA();
            if (TextUtils.isEmpty(zzA) || ".none.".equals(zzA)) {
                zzd();
                max = Math.max(0L, ((Long) zzfx.zzI.zzb(null)).longValue());
            } else {
                zzd();
                max = Math.max(0L, ((Long) zzfx.zzJ.zzb(null)).longValue());
            }
        } else {
            zzd();
            max = Math.max(0L, ((Long) zzfx.zzH.zzb(null)).longValue());
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
                    if (i >= Math.min(20, Math.max(0, ((Integer) zzfx.zzQ.zzb(null)).intValue()))) {
                        j = 0;
                        break;
                    }
                    zzd();
                    j += Math.max(j2, ((Long) zzfx.zzP.zzb(null)).longValue()) * (1 << i);
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
            long max5 = Math.max(0L, ((Long) zzfx.zzF.zzb(null)).longValue());
            if (!zzp().zzs(zza3, max5)) {
                j = Math.max(j, zza3 + max5);
            }
            zzk().zzb();
            long currentTimeMillis2 = j - zzaZ().currentTimeMillis();
            if (currentTimeMillis2 <= 0) {
                zzd();
                currentTimeMillis2 = Math.max(0L, ((Long) zzfx.zzK.zzb(null)).longValue());
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

    private final void zzaL() {
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

    private final Boolean zzaM(zzh zzhVar) {
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

    private final zzr zzaN(String str) {
        zzh zzu = zzj().zzu(str);
        if (zzu == null || TextUtils.isEmpty(zzu.zzr())) {
            zzaV().zzj().zzb("No app data available; dropping", str);
            return null;
        }
        Boolean zzaM = zzaM(zzu);
        if (zzaM == null || zzaM.booleanValue()) {
            return new zzr(str, zzu.zzf(), zzu.zzr(), zzu.zzt(), zzu.zzv(), zzu.zzx(), zzu.zzz(), (String) null, zzu.zzD(), false, zzu.zzl(), 0L, 0, zzu.zzac(), false, zzu.zzae(), zzu.zzB(), zzu.zzag(), zzB(str).zzl(), "", (String) null, zzu.zzai(), zzu.zzak(), zzB(str).zzb(), zzx(str).zze(), zzu.zzao(), zzu.zzaw(), zzu.zzay(), zzu.zzaH(), 0L, zzu.zzaL());
        }
        zzaV().zzb().zzb("App version does not match; dropping. appId", zzgt.zzl(str));
        return null;
    }

    private final boolean zzaO(String str, String str2) {
        zzbc zzf = zzj().zzf(str, str2);
        return zzf == null || zzf.zzc < 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzaP(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT < 34) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
        }
    }

    private static final boolean zzaQ(zzr zzrVar) {
        return !TextUtils.isEmpty(zzrVar.zzb);
    }

    private static final void zzaR(com.google.android.gms.internal.measurement.zzic zzicVar) {
        zzicVar.zzv(Long.MAX_VALUE);
        zzicVar.zzx(Long.MIN_VALUE);
        for (int i = 0; i < zzicVar.zzc(); i++) {
            com.google.android.gms.internal.measurement.zzhs zzd = zzicVar.zzd(i);
            if (zzd.zzf() < zzicVar.zzu()) {
                zzicVar.zzv(zzd.zzf());
            }
            if (zzd.zzf() > zzicVar.zzw()) {
                zzicVar.zzx(zzd.zzf());
            }
        }
    }

    private static final zzor zzaS(zzor zzorVar) {
        if (zzorVar != null) {
            if (zzorVar.zzax()) {
                return zzorVar;
            }
            String valueOf = String.valueOf(zzorVar.getClass());
            String.valueOf(valueOf);
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(valueOf)));
        }
        throw new IllegalStateException("Upload Component not created");
    }

    private static final Boolean zzaT(zzr zzrVar) {
        Boolean bool = zzrVar.zzp;
        String str = zzrVar.zzC;
        if (!TextUtils.isEmpty(str)) {
            zzjh zza = zze.zzc(str).zza();
            zzjh zzjhVar = zzjh.UNINITIALIZED;
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

    static final void zzaz(com.google.android.gms.internal.measurement.zzhr zzhrVar, int i, String str) {
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

    final void zzA(String str, zzjk zzjkVar) {
        zzaW().zzg();
        zzu();
        this.zzC.put(str, zzjkVar);
        zzj().zzab(str, zzjkVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzjk zzB(String str) {
        zzjk zzjkVar = zzjk.zza;
        zzaW().zzg();
        zzu();
        zzjk zzjkVar2 = (zzjk) this.zzC.get(str);
        if (zzjkVar2 == null) {
            zzjkVar2 = zzj().zzZ(str);
            if (zzjkVar2 == null) {
                zzjkVar2 = zzjk.zza;
            }
            zzA(str, zzjkVar2);
        }
        return zzjkVar2;
    }

    final long zzC() {
        long currentTimeMillis = zzaZ().currentTimeMillis();
        zznm zznmVar = this.zzk;
        zznmVar.zzay();
        zznmVar.zzg();
        zzhd zzhdVar = zznmVar.zzf;
        long zza = zzhdVar.zza();
        if (zza == 0) {
            zza = zznmVar.zzu.zzk().zzf().nextInt(DateCalculationsKt.MILLIS_PER_DAY) + 1;
            zzhdVar.zzb(zza);
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
        Boolean zzaM = zzaM(zzu);
        if (zzaM == null) {
            if (!"_ui".equals(zzbgVar.zza)) {
                zzaV().zze().zzb("Could not find package. appId", zzgt.zzl(str));
            }
        } else if (!zzaM.booleanValue()) {
            zzaV().zzb().zzb("App version does not match; dropping event. appId", zzgt.zzl(str));
            return;
        }
        zzE(zzbgVar, new zzr(str, zzu.zzf(), zzu.zzr(), zzu.zzt(), zzu.zzv(), zzu.zzx(), zzu.zzz(), (String) null, zzu.zzD(), false, zzu.zzl(), 0L, 0, zzu.zzac(), false, zzu.zzae(), zzu.zzB(), zzu.zzag(), zzB(str).zzl(), "", (String) null, zzu.zzai(), zzu.zzak(), zzB(str).zzb(), zzx(str).zze(), zzu.zzao(), zzu.zzaw(), zzu.zzay(), zzu.zzaH(), 0L, zzu.zzaL()));
    }

    final void zzE(zzbg zzbgVar, zzr zzrVar) {
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzgu zza = zzgu.zza(zzbgVar);
        zzt().zzI(zza.zzd, zzj().zzW(str));
        zzt().zzG(zza, zzd().zzd(str));
        zzbg zzb2 = zza.zzb();
        if (!zzd().zzp(null, zzfx.zzbg) && Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzb2.zza)) {
            zzbe zzbeVar = zzb2.zzb;
            if ("referrer API v2".equals(zzbeVar.zzd("_cis"))) {
                String zzd = zzbeVar.zzd("gclid");
                if (!TextUtils.isEmpty(zzd)) {
                    zzab(new zzpk("_lgclid", zzb2.zzd, zzd, "auto"), zzrVar);
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
        zzgu zza = zzgu.zza(zzbgVar);
        zzaW().zzg();
        char c = 0;
        zzpo.zzav((this.zzG == null || (str = this.zzH) == null || !str.equals(str2)) ? null : this.zzG, zza.zzd, false);
        zzbg zzb2 = zza.zzb();
        zzp();
        if (zzpj.zzD(zzb2, zzrVar)) {
            if (!zzrVar.zzh) {
                zzan(zzrVar);
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
                        zzj().zzY(str2, Long.valueOf(zzaZ().currentTimeMillis() - 15000), "_sid", zzG(str2, zzbgVar2));
                    }
                    zzj().zzY(str2, null, "_sid", zzG(str2, zzbgVar2));
                }
                zzav zzj = zzj();
                Preconditions.checkNotEmpty(str2);
                zzj.zzg();
                zzj.zzay();
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                char c2 = 2;
                boolean z = true;
                if (i < 0) {
                    zzj.zzu.zzaV().zze().zzc("Invalid time querying timed out conditional properties", zzgt.zzl(str2), Long.valueOf(j));
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
                zzj2.zzay();
                if (i < 0) {
                    zzj2.zzu.zzaV().zze().zzc("Invalid time querying expired conditional properties", zzgt.zzl(str2), Long.valueOf(j));
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
                zzj3.zzay();
                if (i < 0) {
                    zzib zzibVar = zzj3.zzu;
                    zzibVar.zzaV().zze().zzd("Invalid time querying triggered conditional properties", zzgt.zzl(str2), zzibVar.zzl().zza(str4), Long.valueOf(j));
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
                        zzpk zzpkVar = zzahVar3.zzc;
                        zzpm zzpmVar = new zzpm((String) Preconditions.checkNotNull(zzahVar3.zza), zzahVar3.zzb, zzpkVar.zzb, j, Preconditions.checkNotNull(zzpkVar.zza()));
                        if (zzj().zzl(zzpmVar)) {
                            zzaV().zzk().zzd("User property triggered", zzahVar3.zza, this.zzn.zzl().zzc(zzpmVar.zzc), zzpmVar.zze);
                        } else {
                            zzaV().zzb().zzd("Too many active user properties, ignoring", zzgt.zzl(zzahVar3.zza), this.zzn.zzl().zzc(zzpmVar.zzc), zzpmVar.zze);
                        }
                        zzbg zzbgVar6 = zzahVar3.zzi;
                        if (zzbgVar6 != null) {
                            arrayList2.add(zzbgVar6);
                        }
                        zzahVar3.zzc = new zzpk(zzpmVar);
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
        zzpm zzm = zzj().zzm(str, "_sno");
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
        r2.zzu.zzaV().zzb().zzc("Error storing raw event. appId", com.google.android.gms.measurement.internal.zzgt.zzl(r9.zza), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x0b32, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x0b33, code lost:
        zzaV().zzb().zzc("Data loss. Failed to insert raw event metadata. appId", com.google.android.gms.measurement.internal.zzgt.zzl(r10.zzK()), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0299, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x029a, code lost:
        r9.zzu.zzaV().zzb().zzc("Error pruning currencies. appId", com.google.android.gms.measurement.internal.zzgt.zzl(r10), r0);
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpf.zzH(com.google.android.gms.measurement.internal.zzbg, com.google.android.gms.measurement.internal.zzr):void");
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
        zzjk zzB = zzB(zzc);
        zzjh zzjhVar = zzjh.UNINITIALIZED;
        int ordinal = zzB.zzp().ordinal();
        if (ordinal == 1) {
            zzd.zzc(zzjj.AD_STORAGE, zzam.REMOTE_ENFORCED_DEFAULT);
        } else if (ordinal == 2 || ordinal == 3) {
            zzd.zzb(zzjj.AD_STORAGE, zzB.zzb());
        } else {
            zzd.zzc(zzjj.AD_STORAGE, zzam.FAILSAFE);
        }
        int ordinal2 = zzB.zzq().ordinal();
        if (ordinal2 == 1) {
            zzd.zzc(zzjj.ANALYTICS_STORAGE, zzam.REMOTE_ENFORCED_DEFAULT);
        } else if (ordinal2 == 2 || ordinal2 == 3) {
            zzd.zzb(zzjj.ANALYTICS_STORAGE, zzB.zzb());
        } else {
            zzd.zzc(zzjj.ANALYTICS_STORAGE, zzam.FAILSAFE);
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
            zzjj zzjjVar = zzjj.AD_PERSONALIZATION;
            if (zzd.zza(zzjjVar) == zzam.UNSET) {
                zzpm zzm = zzj().zzm(zzhVar.zzc(), "_npa");
                if (zzm != null) {
                    String str = zzm.zzb;
                    if ("tcf".equals(str)) {
                        zzd.zzc(zzjjVar, zzam.TCF);
                    } else if ("app".equals(str)) {
                        zzd.zzc(zzjjVar, zzam.API);
                    } else {
                        zzd.zzc(zzjjVar, zzam.MANIFEST);
                    }
                } else {
                    Boolean zzae = zzhVar.zzae();
                    if (zzae != null && ((!zzae.booleanValue() || zziuVar.zzg() == 1) && (zzae.booleanValue() || zziuVar.zzg() == 0))) {
                        zzd.zzc(zzjjVar, zzam.MANIFEST);
                    } else {
                        zzd.zzc(zzjjVar, zzam.API);
                    }
                }
            }
        } else {
            int zzaB = zzaB(zzhVar.zzc(), zzd);
            com.google.android.gms.internal.measurement.zzit zzm2 = com.google.android.gms.internal.measurement.zziu.zzm();
            zzm2.zzb("_npa");
            zzm2.zza(zzaZ().currentTimeMillis());
            zzm2.zze(zzaB);
            zzicVar.zzo((com.google.android.gms.internal.measurement.zziu) zzm2.zzbc());
            zzaV().zzk().zzc("Setting user property", "non_personalized_ads(_npa)", Integer.valueOf(zzaB));
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
                zzr = (com.google.android.gms.internal.measurement.zzgx) zzpj.zzw(zzr, zzaJ);
            } catch (com.google.android.gms.internal.measurement.zzmq unused) {
                zzaV().zze().zzb("Failed to parse locally stored ad campaign info. appId", zzgt.zzl(zzhVar.zzc()));
            }
        }
        for (com.google.android.gms.internal.measurement.zzhs zzhsVar : zzicVar.zzb()) {
            if (zzhsVar.zzd().equals(Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN)) {
                String str = (String) zzpj.zzJ(zzhsVar, "gclid", "");
                String str2 = (String) zzpj.zzJ(zzhsVar, "gbraid", "");
                String str3 = (String) zzpj.zzJ(zzhsVar, "gad_source", "");
                String[] split = ((String) zzfx.zzbh.zzb(null)).split(StringUtils.COMMA);
                zzp();
                if (!zzpj.zzG(zzhsVar, split).isEmpty()) {
                    long longValue = ((Long) zzpj.zzJ(zzhsVar, "click_timestamp", 0L)).longValue();
                    if (longValue <= 0) {
                        longValue = zzhsVar.zzf();
                    }
                    if ("referrer API v2".equals(zzpj.zzI(zzhsVar, "_cis"))) {
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
                            zzr.zzt(zzaC(zzhsVar));
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
                        zzr.zzr(zzaC(zzhsVar));
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
        if (zzd().zzp(null, zzfx.zzbg)) {
            zzj().zzk(zzhVar.zzc(), "_lgclid");
        }
    }

    final String zzK(zzjk zzjkVar) {
        if (zzjkVar.zzo(zzjj.ANALYTICS_STORAGE)) {
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
        zzV(r0);
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
            zzib zzibVar = this.zzn;
            zzibVar.zzaU();
            Boolean zzJ = zzibVar.zzt().zzJ();
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
                    zzaK();
                } else {
                    long currentTimeMillis = zzaZ().currentTimeMillis();
                    Cursor cursor2 = null;
                    Cursor cursor3 = null;
                    r8 = null;
                    r8 = null;
                    r8 = null;
                    String str = null;
                    int zzm = zzd().zzm(null, zzfx.zzai);
                    zzd();
                    long zzF2 = currentTimeMillis - zzal.zzF();
                    for (int i = 0; i < zzm && zzaF(null, zzF2); i++) {
                    }
                    zzql.zza();
                    zzaW().zzg();
                    zzau();
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
                            zzj.zzay();
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
                zzaK();
            }
        } finally {
            this.zzw = false;
            zzaL();
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
        zzos zzosVar;
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
        zzpj zzp;
        long j3;
        long j4;
        int zzm = zzd().zzm(str, zzfx.zzg);
        int i4 = 0;
        int max = Math.max(0, zzd().zzm(str, zzfx.zzh));
        zzav zzj = zzj();
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
                            zzj.zzu.zzaV().zzb().zzc("Error querying bundles. appId", zzgt.zzl(str), e);
                            emptyList = Collections.emptyList();
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        cursor2 = null;
                        zzj.zzu.zzaV().zzb().zzc("Error querying bundles. appId", zzgt.zzl(str), e);
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
                com.google.android.gms.internal.measurement.zzpk.zza();
                zzal zzd = zzd();
                zzfw zzfwVar = zzfx.zzbi;
                if (zzd.zzp(null, zzfwVar)) {
                    com.google.android.gms.internal.measurement.zzpk.zza();
                    if (zzd().zzp(null, zzfwVar)) {
                        if (!zzB(str).zzo(zzjj.ANALYTICS_STORAGE) && zzh().zzB(str)) {
                            List asList = Arrays.asList(((String) zzfx.zzbj.zzb(null)).split(StringUtils.COMMA));
                            for (Pair pair : list) {
                                try {
                                    zzj().zzH(((Long) pair.second).longValue());
                                    for (com.google.android.gms.internal.measurement.zzhs zzhsVar : ((com.google.android.gms.internal.measurement.zzid) pair.first).zzc()) {
                                        if (asList.contains(zzhsVar.zzd())) {
                                            if (zzhsVar.zzd().equals("_f") || zzhsVar.zzd().equals("_v")) {
                                                com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzhsVar.zzcl();
                                                zzp();
                                                zzpj.zzC(zzhrVar, "_dac", 1L);
                                                zzhsVar = (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc();
                                            }
                                            zzav zzj2 = zzj();
                                            zzj2.zzg();
                                            zzj2.zzay();
                                            Preconditions.checkNotNull(zzhsVar);
                                            Preconditions.checkNotEmpty(str);
                                            zzib zzibVar = zzj2.zzu;
                                            zzibVar.zzaV().zzk().zzb("Caching events in NO_DATA mode", zzhsVar);
                                            ContentValues contentValues = new ContentValues();
                                            contentValues.put("app_id", str);
                                            contentValues.put("name", zzhsVar.zzd());
                                            contentValues.put("data", zzhsVar.zzcc());
                                            contentValues.put("timestamp_millis", Long.valueOf(zzhsVar.zzf()));
                                            try {
                                                if (zzj2.zze().insert("no_data_mode_events", null, contentValues) == j2) {
                                                    zzibVar.zzaV().zzb().zzb("Failed to insert NO_DATA mode event (got -1). appId", zzgt.zzl(str));
                                                }
                                            } catch (SQLiteException e4) {
                                                zzj2.zzu.zzaV().zzb().zzc("Error storing NO_DATA mode event. appId", zzgt.zzl(str), e4);
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
                            zzj3.zzay();
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
                                            arrayList2.add((com.google.android.gms.internal.measurement.zzhs) ((com.google.android.gms.internal.measurement.zzhr) zzpj.zzw(com.google.android.gms.internal.measurement.zzhs.zzk(), query.getBlob(0))).zzbc());
                                            cursor4 = query;
                                        } catch (com.google.android.gms.internal.measurement.zzmq e6) {
                                            cursor4 = query;
                                            try {
                                                try {
                                                    zzj3.zzu.zzaV().zzh().zzc("Failed to parse stored NO_DATA mode event, appId", zzgt.zzl(str), e6);
                                                } catch (SQLiteException e7) {
                                                    e = e7;
                                                    zzj3.zzu.zzaV().zzb().zzc("Error flushing NO_DATA mode events. appId", zzgt.zzl(str), e);
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
                                        zzgr zzk = zzj3.zzu.zzaV().zzk();
                                        StringBuilder sb = new StringBuilder(String.valueOf(delete).length() + 34);
                                        sb.append("Pruned ");
                                        sb.append(delete);
                                        sb.append(" NO_DATA mode events. appId");
                                        zzk.zzb(sb.toString(), str);
                                    } catch (SQLiteException e8) {
                                        e = e8;
                                        cursor4 = null;
                                        zzj3.zzu.zzaV().zzb().zzc("Error flushing NO_DATA mode events. appId", zzgt.zzl(str), e);
                                        arrayList2 = Collections.emptyList();
                                    }
                                } else {
                                    cursor4 = query;
                                }
                            } catch (SQLiteException e9) {
                                e = e9;
                                cursor4 = query;
                                zzj3.zzu.zzaV().zzb().zzc("Error flushing NO_DATA mode events. appId", zzgt.zzl(str), e);
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
                                com.google.android.gms.internal.measurement.zzic zzicVar = (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzid) pair2.first).zzcl();
                                if (z4 && !arrayList2.isEmpty()) {
                                    List zzb2 = zzicVar.zzb();
                                    zzicVar.zzi();
                                    zzicVar.zzh(arrayList2);
                                    zzicVar.zzh(zzb2);
                                    z4 = false;
                                }
                                com.google.android.gms.internal.measurement.zzhh zzb3 = com.google.android.gms.internal.measurement.zzho.zzb();
                                com.google.android.gms.internal.measurement.zzgf zzx = zzh().zzx(str);
                                ArrayList arrayList3 = new ArrayList();
                                if (zzx != null) {
                                    for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzx.zza()) {
                                        com.google.android.gms.internal.measurement.zzhk zza = com.google.android.gms.internal.measurement.zzhl.zza();
                                        int zzb4 = zzfuVar.zzb();
                                        zzjh zzjhVar = zzjh.UNINITIALIZED;
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
                                zzicVar.zzaQ(zzb3);
                                arrayList.add(Pair.create((com.google.android.gms.internal.measurement.zzid) zzicVar.zzbc(), (Long) pair2.second));
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
                zzjk zzB = zzB(str);
                zzjj zzjjVar = zzjj.AD_STORAGE;
                if (zzB.zzo(zzjjVar)) {
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
                boolean z7 = zzd().zzC(str) && zzB(str).zzo(zzjjVar);
                boolean zzo = zzB(str).zzo(zzjjVar);
                boolean zzo2 = zzB(str).zzo(zzjj.ANALYTICS_STORAGE);
                zzqu.zza();
                boolean zzp2 = zzd().zzp(str, zzfx.zzaM);
                zzot zzotVar = this.zzl;
                zzos zza2 = zzotVar.zza(str);
                int i8 = 0;
                while (i8 < size) {
                    boolean z8 = zzo;
                    com.google.android.gms.internal.measurement.zzic zzicVar2 = (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzid) ((Pair) list.get(i8)).first).zzcl();
                    int i9 = size;
                    arrayList4.add((Long) ((Pair) list.get(i8)).second);
                    zzd().zzi();
                    boolean z9 = z7;
                    boolean z10 = zzo2;
                    zzicVar2.zzO(130000L);
                    zzicVar2.zzs(j);
                    this.zzn.zzaU();
                    zzicVar2.zzae(false);
                    if (!z9) {
                        zzicVar2.zzan();
                    }
                    if (!z8) {
                        zzicVar2.zzR();
                        zzicVar2.zzU();
                    }
                    if (!z10) {
                        zzicVar2.zzX();
                    }
                    zzS(str, zzicVar2);
                    if (!zzp2) {
                        zzicVar2.zzav();
                    }
                    if (!z10) {
                        zzicVar2.zzag();
                    }
                    String zzP = zzicVar2.zzP();
                    if (TextUtils.isEmpty(zzP) || zzP.equals("00000000-0000-0000-0000-000000000000")) {
                        ArrayList arrayList5 = new ArrayList(zzicVar2.zzb());
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
                                com.google.android.gms.internal.measurement.zzhw zzF = zzpj.zzF(zzhsVar2, "_pfo");
                                if (zzF != null) {
                                    l = Long.valueOf(zzF.zzf());
                                }
                                zzp();
                                com.google.android.gms.internal.measurement.zzhw zzF2 = zzpj.zzF(zzhsVar2, "_uwa");
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
                            zzicVar2.zzi();
                            zzicVar2.zzh(arrayList5);
                        }
                        if (z12) {
                            zzR(zzicVar2.zzK(), true, l, l2);
                        }
                    } else {
                        z2 = z9;
                        list2 = list;
                        z3 = zzp2;
                        i = i8;
                    }
                    if (zzicVar2.zzc() != 0) {
                        if (zzd().zzp(str, zzfx.zzaC)) {
                            zzicVar2.zzas(zzp().zzt(((com.google.android.gms.internal.measurement.zzid) zzicVar2.zzbc()).zzcc()));
                        }
                        com.google.android.gms.internal.measurement.zzis zzd3 = zza2.zzd();
                        if (zzd3 != null) {
                            zzicVar2.zzaN(zzd3);
                        }
                        zzh.zze(zzicVar2);
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
                    zzU(false, ComposerKt.providerMapsKey, null, null, str, Collections.emptyList());
                    return;
                }
                com.google.android.gms.internal.measurement.zzib zzibVar2 = (com.google.android.gms.internal.measurement.zzib) zzh.zzbc();
                List arrayList6 = new ArrayList();
                boolean z14 = zza2.zzc() == zzlr.SGTM_CLIENT;
                if (zza2.zzc() == zzlr.SGTM) {
                    z = z14;
                } else if (!z14) {
                    obj = null;
                    if (zzi().zzb()) {
                        return;
                    }
                    if (Log.isLoggable(zzaV().zzn(), 2)) {
                        obj = zzp().zzi(zzibVar2);
                    }
                    zzp();
                    byte[] zzcc = zzibVar2.zzcc();
                    zzL(arrayList4);
                    this.zzk.zze.zzb(j);
                    zzaV().zzk().zzd("Uploading data. app, uncompressed size, data", str, Integer.valueOf(zzcc.length), obj);
                    this.zzv = true;
                    zzi().zzc(str, zza2, zzibVar2, new zzov(this, str, arrayList6));
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
                com.google.android.gms.internal.measurement.zzib zzibVar3 = (com.google.android.gms.internal.measurement.zzib) zzh.zzbc();
                zzaW().zzg();
                zzu();
                com.google.android.gms.internal.measurement.zzhz zzi = com.google.android.gms.internal.measurement.zzib.zzi(zzibVar3);
                if (!TextUtils.isEmpty(str2)) {
                    zzi.zzi(str2);
                }
                String zzc = zzh().zzc(str);
                if (!TextUtils.isEmpty(zzc)) {
                    zzi.zzj(zzc);
                }
                ArrayList arrayList7 = new ArrayList();
                for (com.google.android.gms.internal.measurement.zzid zzidVar3 : zzibVar3.zza()) {
                    com.google.android.gms.internal.measurement.zzic zzaF = com.google.android.gms.internal.measurement.zzid.zzaF(zzidVar3);
                    zzaF.zzan();
                    arrayList7.add((com.google.android.gms.internal.measurement.zzid) zzaF.zzbc());
                }
                zzi.zzg();
                zzi.zzf(arrayList7);
                zzaV().zzk().zzb("[sgtm] Processed MeasurementBatch for sGTM with sgtmJoinId: ", TextUtils.isEmpty(str2) ? AbstractJsonLexerKt.NULL : zzi.zzh());
                com.google.android.gms.internal.measurement.zzib zzibVar4 = (com.google.android.gms.internal.measurement.zzib) zzi.zzbc();
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
                    com.google.android.gms.internal.measurement.zzib zzibVar5 = (com.google.android.gms.internal.measurement.zzib) zzh2.zzbc();
                    String zzc2 = zzotVar.zzg.zzh().zzc(str);
                    if (!TextUtils.isEmpty(zzc2)) {
                        Uri parse = Uri.parse((String) zzfx.zzr.zzb(null));
                        Uri.Builder buildUpon = parse.buildUpon();
                        String authority = parse.getAuthority();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(zzc2).length() + 1 + String.valueOf(authority).length());
                        sb2.append(zzc2);
                        sb2.append(".");
                        sb2.append(authority);
                        buildUpon.authority(sb2.toString());
                        obj = null;
                        zzosVar = new zzos(buildUpon.build().toString(), Collections.emptyMap(), z ? zzlr.GOOGLE_SIGNAL_PENDING : zzlr.GOOGLE_SIGNAL, null);
                    } else {
                        obj = null;
                        zzosVar = new zzos((String) zzfx.zzr.zzb(null), Collections.emptyMap(), z ? zzlr.GOOGLE_SIGNAL_PENDING : zzlr.GOOGLE_SIGNAL, null);
                    }
                    arrayList6.add(Pair.create(zzibVar5, zzosVar));
                }
                if (z) {
                    com.google.android.gms.internal.measurement.zzhz zzhzVar = (com.google.android.gms.internal.measurement.zzhz) zzibVar4.zzcl();
                    for (int i11 = 0; i11 < zzibVar4.zzb(); i11++) {
                        com.google.android.gms.internal.measurement.zzic zzicVar3 = (com.google.android.gms.internal.measurement.zzic) zzibVar4.zzc(i11).zzcl();
                        zzicVar3.zzt();
                        zzicVar3.zzaO(j);
                        zzhzVar.zzd(i11, zzicVar3);
                    }
                    arrayList6.add(Pair.create((com.google.android.gms.internal.measurement.zzib) zzhzVar.zzbc(), zza2));
                    zzL(arrayList4);
                    zzU(false, ComposerKt.providerMapsKey, null, null, str, arrayList6);
                    if (zzO(str, zza2.zza())) {
                        zzaV().zzk().zzb("[sgtm] Sending sgtm batches available notification to app", str);
                        Intent intent = new Intent();
                        intent.setAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                        intent.setPackage(str);
                        zzaP(this.zzn.zzaY(), intent);
                        return;
                    }
                    return;
                }
                zzibVar2 = zzibVar4;
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
                        zzj.zzu.zzaV().zzb().zzc("Failed to unzip queued bundle. appId", zzgt.zzl(str), e10);
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
                            com.google.android.gms.internal.measurement.zzic zzicVar4 = (com.google.android.gms.internal.measurement.zzic) zzpj.zzw(com.google.android.gms.internal.measurement.zzid.zzaE(), byteArray);
                            if (!list.isEmpty()) {
                                com.google.android.gms.internal.measurement.zzid zzidVar5 = (com.google.android.gms.internal.measurement.zzid) ((Pair) list.get(0)).first;
                                com.google.android.gms.internal.measurement.zzid zzidVar6 = (com.google.android.gms.internal.measurement.zzid) zzicVar4.zzbc();
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
                                zzicVar4.zzao(cursor2.getInt(2));
                            }
                            i12 += byteArray.length;
                            list.add(Pair.create((com.google.android.gms.internal.measurement.zzid) zzicVar4.zzbc(), Long.valueOf(j5)));
                        } catch (IOException e11) {
                            zzj.zzu.zzaV().zzb().zzc("Failed to merge queued bundle. appId", zzgt.zzl(str), e11);
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
            zzpd zzpdVar = (zzpd) this.zzF.get(str2);
            if (zzpdVar == null) {
                return true;
            }
            return zzpdVar.zzb();
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
            zzib zzibVar = this.zzn;
            zzibVar.zzaU();
            Boolean zzJ = zzibVar.zzt().zzJ();
            if (zzJ == null) {
                zzaV().zze().zza("Upload data called on the client side before use of service was decided");
            } else if (zzJ.booleanValue()) {
                zzaV().zzb().zza("Upload called in the client side when service should be used");
            } else if (this.zza > 0) {
                zzaK();
            } else if (!zzi().zzb()) {
                zzaV().zzk().zza("Network not connected, ignoring upload request");
                zzaK();
            } else if (!zzj().zzD(str)) {
                zzaV().zzk().zzb("[sgtm] Upload queue has no batches for appId", str);
            } else {
                zzav zzj = zzj();
                Preconditions.checkNotEmpty(str);
                zzj.zzg();
                zzj.zzay();
                List zzC = zzj.zzC(str, zzon.zza(zzlr.GOOGLE_SIGNAL), 1);
                zzpi zzpiVar = zzC.isEmpty() ? null : (zzpi) zzC.get(0);
                if (zzpiVar != null && (zzd = zzpiVar.zzd()) != null) {
                    zzaV().zzk().zzd("[sgtm] Uploading data from upload queue. appId, type, url", str, zzpiVar.zzf(), zzpiVar.zze());
                    byte[] zzcc = zzd.zzcc();
                    if (Log.isLoggable(zzaV().zzn(), 2)) {
                        zzaV().zzk().zzd("[sgtm] Uploading data from upload queue. appId, uncompressed size, data", str, Integer.valueOf(zzcc.length), zzp().zzi(zzd));
                    }
                    zzos zza = zzpiVar.zza();
                    this.zzv = true;
                    zzi().zzc(str, zza, zzd, new zzow(this, str, zzpiVar));
                }
            }
        } finally {
            this.zzw = false;
            zzaL();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzQ(String str, int i, Throwable th, byte[] bArr, zzpi zzpiVar) {
        zzaW().zzg();
        zzu();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzv = false;
                zzaL();
                throw th2;
            }
        }
        if (i != 200) {
            if (i == 204) {
                i = 204;
            }
            String str2 = new String(bArr, StandardCharsets.UTF_8);
            String substring = str2.substring(0, Math.min(32, str2.length()));
            zzgr zzh = zzaV().zzh();
            Integer valueOf = Integer.valueOf(i);
            if (th == null) {
                th = substring;
            }
            zzh.zzd("Network upload failed. Will retry later. appId, status, error", str, valueOf, th);
            zzj().zzK(Long.valueOf(zzpiVar.zzc()));
            zzaK();
            this.zzv = false;
            zzaL();
        }
        if (th == null) {
            zzj().zzE(Long.valueOf(zzpiVar.zzc()));
            zzaV().zzk().zzc("Successfully uploaded batch from upload queue. appId, status", str, Integer.valueOf(i));
            if (!zzi().zzb() || !zzj().zzD(str)) {
                zzaK();
            } else {
                zzP(str);
            }
            this.zzv = false;
            zzaL();
        }
        String str22 = new String(bArr, StandardCharsets.UTF_8);
        String substring2 = str22.substring(0, Math.min(32, str22.length()));
        zzgr zzh2 = zzaV().zzh();
        Integer valueOf2 = Integer.valueOf(i);
        if (th == null) {
        }
        zzh2.zzd("Network upload failed. Will retry later. appId, status, error", str, valueOf2, th);
        zzj().zzK(Long.valueOf(zzpiVar.zzc()));
        zzaK();
        this.zzv = false;
        zzaL();
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
        if (zzh().zzr(str) && (zzx = zzpj.zzx(zzicVar, APEZProvider.FILEID)) != -1) {
            zzicVar.zzr(zzx);
        }
        if (zzh().zzs(str)) {
            zzicVar.zzan();
        }
        if (zzh().zzt(str)) {
            zzicVar.zzX();
            if (zzB(str).zzo(zzjj.ANALYTICS_STORAGE)) {
                Map map = this.zzE;
                zzpc zzpcVar = (zzpc) map.get(str);
                if (zzpcVar == null || zzpcVar.zzb + zzd().zzl(str, zzfx.zzak) < zzaZ().elapsedRealtime()) {
                    zzpcVar = new zzpc(this, (byte[]) null);
                    map.put(str, zzpcVar);
                }
                zzicVar.zzax(zzpcVar.zza);
            }
        }
        if (zzh().zzu(str)) {
            zzicVar.zzav();
        }
    }

    final void zzT(String str, com.google.android.gms.internal.measurement.zzhv zzhvVar, Bundle bundle, String str2) {
        int zzf;
        List listOf = CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"});
        if (zzpo.zzZ(zzhvVar.zza()) || zzpo.zzZ(str)) {
            zzf = zzd().zzf(str2, true);
        } else {
            zzf = zzd().zze(str2, true);
        }
        long j = zzf;
        long codePointCount = zzhvVar.zzc().codePointCount(0, zzhvVar.zzc().length());
        zzpo zzt = zzt();
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
    public final void zzU(boolean z, int i, Throwable th, byte[] bArr, String str, List list) {
        byte[] bArr2;
        int i2 = i;
        zzaW().zzg();
        zzu();
        if (bArr == null) {
            try {
                bArr2 = new byte[0];
            } finally {
                this.zzv = false;
                zzaL();
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
                    zzaK();
                    return;
                }
            }
            HashMap hashMap = new HashMap();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                com.google.android.gms.internal.measurement.zzib zzibVar = (com.google.android.gms.internal.measurement.zzib) pair.first;
                zzos zzosVar = (zzos) pair.second;
                if (zzosVar.zzc() != zzlr.SGTM_CLIENT) {
                    long zzA = zzj().zzA(str, zzibVar, zzosVar.zza(), zzosVar.zzb(), zzosVar.zzc(), null);
                    if (zzosVar.zzc() == zzlr.GOOGLE_SIGNAL_PENDING && zzA != -1 && !zzibVar.zze().isEmpty()) {
                        hashMap.put(zzibVar.zze(), Long.valueOf(zzA));
                    }
                }
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Pair pair2 = (Pair) it2.next();
                com.google.android.gms.internal.measurement.zzib zzibVar2 = (com.google.android.gms.internal.measurement.zzib) pair2.first;
                zzos zzosVar2 = (zzos) pair2.second;
                if (zzosVar2.zzc() == zzlr.SGTM_CLIENT) {
                    zzj().zzA(str, zzibVar2, zzosVar2.zza(), zzosVar2.zzb(), zzosVar2.zzc(), (Long) hashMap.get(zzibVar2.zze()));
                }
            }
            List zzC = zzj().zzC(str, zzon.zza(zzlr.SGTM_CLIENT), 1);
            if (!zzC.isEmpty()) {
                long zzg = ((zzpi) zzC.get(0)).zzg();
                if (zzaZ().currentTimeMillis() > ((Long) zzfx.zzE.zzb(null)).longValue() + zzg) {
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
                if (!zzi().zzb() || !zzaI()) {
                    this.zzB = -1L;
                    zzaK();
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
        zzgr zzk = zzaV().zzk();
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
        zzaK();
        if (z) {
            zzaV().zzk().zzc("Successful upload. Got network response. code, size", valueOf, Integer.valueOf(bArr2.length));
        } else {
            zzaV().zzk().zza("Purged empty bundles");
        }
        zzj().zzb();
    }

    final void zzV(zzh zzhVar) {
        zzaW().zzg();
        if (TextUtils.isEmpty(zzhVar.zzf())) {
            zzW((String) Preconditions.checkNotNull(zzhVar.zzc()), ComposerKt.providerMapsKey, null, null, null);
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
        zzi().zzd(zzhVar, arrayMap, new zzgv() { // from class: com.google.android.gms.measurement.internal.zzpe
            @Override // com.google.android.gms.measurement.internal.zzgv
            public final /* synthetic */ void zza(String str2, int i, Throwable th, byte[] bArr, Map map) {
                zzpf.this.zzW(str2, i, th, bArr, map);
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
    public final void zzW(String str, int i, Throwable th, byte[] bArr, Map map) {
        boolean z;
        zzaW().zzg();
        zzu();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.zzu = false;
                zzaL();
            }
        }
        zzgr zzk = zzaV().zzk();
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
                zzaV().zze().zzb("App does not exist in onConfigFetched. appId", zzgt.zzl(str));
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
                    zzaK();
                }
                String zzaJ = zzaJ(map, HttpHeaders.LAST_MODIFIED);
                String zzaJ2 = zzaJ(map, HttpHeaders.ETAG);
                if (i != 404 && i != 304) {
                    zzh().zzi(str, bArr, zzaJ, zzaJ2);
                    zzu.zzI(zzaZ().currentTimeMillis());
                    zzj().zzv(zzu, false, false);
                    if (i != 404) {
                        zzaV().zzh().zzb("Config not found. Using empty config. appId", str);
                    } else {
                        zzaV().zzk().zzc("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), valueOf);
                    }
                    if (zzi().zzb() || !zzaI()) {
                        if (zzi().zzb() || !zzj().zzD(zzu.zzc())) {
                            zzaK();
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
                zzaK();
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
    public final void zzX(Runnable runnable) {
        zzaW().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzY() {
        zzaW().zzg();
        zzu();
        if (this.zzp) {
            return;
        }
        this.zzp = true;
        if (zzZ()) {
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

    final boolean zzZ() {
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

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final zzae zzaU() {
        return this.zzn.zzaU();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final zzgt zzaV() {
        return ((zzib) Preconditions.checkNotNull(this.zzn)).zzaV();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final zzhy zzaW() {
        return ((zzib) Preconditions.checkNotNull(this.zzn)).zzaW();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final Context zzaY() {
        return this.zzn.zzaY();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final Clock zzaZ() {
        return ((zzib) Preconditions.checkNotNull(this.zzn)).zzaZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaa(zzr zzrVar) {
        if (this.zzz != null) {
            ArrayList arrayList = new ArrayList();
            this.zzA = arrayList;
            arrayList.addAll(this.zzz);
        }
        zzav zzj = zzj();
        String str = (String) Preconditions.checkNotNull(zzrVar.zza);
        Preconditions.checkNotEmpty(str);
        zzj.zzg();
        zzj.zzay();
        try {
            SQLiteDatabase zze = zzj.zze();
            String[] strArr = {str};
            int delete = zze.delete("apps", "app_id=?", strArr) + zze.delete("events", "app_id=?", strArr) + zze.delete("events_snapshot", "app_id=?", strArr) + zze.delete("user_attributes", "app_id=?", strArr) + zze.delete("conditional_properties", "app_id=?", strArr) + zze.delete("raw_events", "app_id=?", strArr) + zze.delete("raw_events_metadata", "app_id=?", strArr) + zze.delete("queue", "app_id=?", strArr) + zze.delete("audience_filter_values", "app_id=?", strArr) + zze.delete("main_event_params", "app_id=?", strArr) + zze.delete("default_event_params", "app_id=?", strArr) + zze.delete("trigger_uris", "app_id=?", strArr) + zze.delete("upload_queue", "app_id=?", strArr);
            com.google.android.gms.internal.measurement.zzpk.zza();
            zzib zzibVar = zzj.zzu;
            if (zzibVar.zzc().zzp(null, zzfx.zzbi)) {
                delete += zze.delete("no_data_mode_events", "app_id=?", strArr);
            }
            if (delete > 0) {
                zzibVar.zzaV().zzk().zzc("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzj.zzu.zzaV().zzb().zzc("Error resetting analytics data. appId, error", zzgt.zzl(str), e);
        }
        if (zzrVar.zzh) {
            zzag(zzrVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzab(zzpk zzpkVar, zzr zzrVar) {
        zzpm zzm;
        long j;
        zzaW().zzg();
        zzu();
        if (zzaQ(zzrVar)) {
            if (!zzrVar.zzh) {
                zzan(zzrVar);
                return;
            }
            zzpo zzt = zzt();
            String str = zzpkVar.zzb;
            int zzp = zzt.zzp(str);
            if (zzp != 0) {
                zzpo zzt2 = zzt();
                zzd();
                zzt().zzN(this.zzK, zzrVar.zza, zzp, "_ev", zzt2.zzC(str, 24, true), str != null ? str.length() : 0);
                return;
            }
            int zzK = zzt().zzK(str, zzpkVar.zza());
            if (zzK != 0) {
                zzpo zzt3 = zzt();
                zzd();
                String zzC = zzt3.zzC(str, 24, true);
                Object zza = zzpkVar.zza();
                if (zza != null && ((zza instanceof String) || (zza instanceof CharSequence))) {
                    r13 = zza.toString().length();
                }
                zzt().zzN(this.zzK, zzrVar.zza, zzK, "_ev", zzC, r13);
                return;
            }
            Object zzL = zzt().zzL(str, zzpkVar.zza());
            if (zzL != null) {
                if ("_sid".equals(str)) {
                    long j2 = zzpkVar.zzc;
                    String str2 = zzpkVar.zzf;
                    String str3 = (String) Preconditions.checkNotNull(zzrVar.zza);
                    zzpm zzm2 = zzj().zzm(str3, "_sno");
                    if (zzm2 != null) {
                        Object obj = zzm2.zze;
                        if (obj instanceof Long) {
                            j = ((Long) obj).longValue();
                            zzab(new zzpk("_sno", j2, Long.valueOf(j + 1), str2), zzrVar);
                        }
                    }
                    if (zzm2 != null) {
                        zzaV().zze().zzb("Retrieved last session number from database does not contain a valid (long) value", zzm2.zze);
                    }
                    zzbc zzf = zzj().zzf(str3, "_s");
                    if (zzf != null) {
                        zzgr zzk = zzaV().zzk();
                        long j3 = zzf.zzc;
                        zzk.zzb("Backfill the session number. Last used session number", Long.valueOf(j3));
                        j = j3;
                    } else {
                        j = 0;
                    }
                    zzab(new zzpk("_sno", j2, Long.valueOf(j + 1), str2), zzrVar);
                }
                String str4 = zzrVar.zza;
                zzpm zzpmVar = new zzpm((String) Preconditions.checkNotNull(str4), (String) Preconditions.checkNotNull(zzpkVar.zzf), str, zzpkVar.zzc, zzL);
                zzgr zzk2 = zzaV().zzk();
                zzib zzibVar = this.zzn;
                String str5 = zzpmVar.zzc;
                zzk2.zzc("Setting user property", zzibVar.zzl().zzc(str5), zzL);
                zzj().zzb();
                try {
                    if (APEZProvider.FILEID.equals(str5) && (zzm = zzj().zzm(str4, APEZProvider.FILEID)) != null && !zzpmVar.zze.equals(zzm.zze)) {
                        zzj().zzk(str4, "_lair");
                    }
                    zzan(zzrVar);
                    boolean zzl = zzj().zzl(zzpmVar);
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
                        zzaV().zzb().zzc("Too many unique user properties are set. Ignoring user property", zzibVar.zzl().zzc(str5), zzpmVar.zze);
                        zzt().zzN(this.zzK, str4, 9, null, null, 0);
                    }
                } finally {
                    zzj().zzd();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzac(String str, zzr zzrVar) {
        zzaW().zzg();
        zzu();
        if (zzaQ(zzrVar)) {
            if (!zzrVar.zzh) {
                zzan(zzrVar);
                return;
            }
            Boolean zzaT = zzaT(zzrVar);
            if (!"_npa".equals(str) || zzaT == null) {
                zzgr zzj = zzaV().zzj();
                zzib zzibVar = this.zzn;
                zzj.zzb("Removing user property", zzibVar.zzl().zzc(str));
                zzj().zzb();
                try {
                    zzan(zzrVar);
                    if (APEZProvider.FILEID.equals(str)) {
                        zzj().zzk((String) Preconditions.checkNotNull(zzrVar.zza), "_lair");
                    }
                    zzj().zzk((String) Preconditions.checkNotNull(zzrVar.zza), str);
                    zzj().zzc();
                    zzaV().zzj().zzb("User property removed", zzibVar.zzl().zzc(str));
                    return;
                } finally {
                    zzj().zzd();
                }
            }
            zzaV().zzj().zza("Falling back to manifest metadata value for ad personalization");
            zzab(new zzpk("_npa", zzaZ().currentTimeMillis(), Long.valueOf(true != zzaT.booleanValue() ? 0L : 1L), "auto"), zzrVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzad() {
        this.zzs++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzae() {
        this.zzt++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzib zzaf() {
        return this.zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00bd, code lost:
        if (true == r12.booleanValue()) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bf, code lost:
        r23 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c2, code lost:
        r23 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c4, code lost:
        r15 = new com.google.android.gms.measurement.internal.zzpk("_npa", r17, java.lang.Long.valueOf(r23), "auto");
        r24 = 1;
        r12 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d7, code lost:
        if (r11 == null) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e1, code lost:
        if (r11.zze.equals(r15.zzd) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e3, code lost:
        zzab(r15, r27);
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x036d A[Catch: all -> 0x0403, TryCatch #1 {all -> 0x0403, blocks: (B:24:0x0095, B:26:0x00a3, B:43:0x00f0, B:45:0x00fd, B:47:0x0106, B:49:0x010b, B:52:0x0124, B:56:0x0138, B:58:0x015c, B:61:0x0164, B:63:0x0173, B:91:0x024e, B:93:0x027a, B:94:0x027d, B:96:0x02a5, B:136:0x036d, B:137:0x0370, B:145:0x03f4, B:98:0x02ba, B:103:0x02dd, B:105:0x02e5, B:107:0x02ed, B:111:0x0300, B:115:0x0311, B:119:0x031d, B:122:0x032b, B:125:0x033c, B:127:0x0350, B:129:0x0356, B:131:0x035e, B:133:0x0364, B:113:0x0309, B:101:0x02c9, B:64:0x0182, B:66:0x01ab, B:67:0x01ba, B:69:0x01c1, B:71:0x01c7, B:73:0x01d1, B:75:0x01db, B:77:0x01e1, B:79:0x01e7, B:80:0x01ec, B:84:0x020a, B:87:0x020f, B:88:0x0223, B:89:0x0231, B:90:0x023f, B:138:0x0386, B:140:0x03bb, B:141:0x03be, B:142:0x03d4, B:144:0x03da, B:50:0x0117, B:46:0x0103, B:31:0x00b5, B:35:0x00c4, B:37:0x00d9, B:39:0x00e3, B:42:0x00ed), top: B:153:0x0095, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03d4 A[Catch: all -> 0x0403, TryCatch #1 {all -> 0x0403, blocks: (B:24:0x0095, B:26:0x00a3, B:43:0x00f0, B:45:0x00fd, B:47:0x0106, B:49:0x010b, B:52:0x0124, B:56:0x0138, B:58:0x015c, B:61:0x0164, B:63:0x0173, B:91:0x024e, B:93:0x027a, B:94:0x027d, B:96:0x02a5, B:136:0x036d, B:137:0x0370, B:145:0x03f4, B:98:0x02ba, B:103:0x02dd, B:105:0x02e5, B:107:0x02ed, B:111:0x0300, B:115:0x0311, B:119:0x031d, B:122:0x032b, B:125:0x033c, B:127:0x0350, B:129:0x0356, B:131:0x035e, B:133:0x0364, B:113:0x0309, B:101:0x02c9, B:64:0x0182, B:66:0x01ab, B:67:0x01ba, B:69:0x01c1, B:71:0x01c7, B:73:0x01d1, B:75:0x01db, B:77:0x01e1, B:79:0x01e7, B:80:0x01ec, B:84:0x020a, B:87:0x020f, B:88:0x0223, B:89:0x0231, B:90:0x023f, B:138:0x0386, B:140:0x03bb, B:141:0x03be, B:142:0x03d4, B:144:0x03da, B:50:0x0117, B:46:0x0103, B:31:0x00b5, B:35:0x00c4, B:37:0x00d9, B:39:0x00e3, B:42:0x00ed), top: B:153:0x0095, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fd A[Catch: all -> 0x0403, TryCatch #1 {all -> 0x0403, blocks: (B:24:0x0095, B:26:0x00a3, B:43:0x00f0, B:45:0x00fd, B:47:0x0106, B:49:0x010b, B:52:0x0124, B:56:0x0138, B:58:0x015c, B:61:0x0164, B:63:0x0173, B:91:0x024e, B:93:0x027a, B:94:0x027d, B:96:0x02a5, B:136:0x036d, B:137:0x0370, B:145:0x03f4, B:98:0x02ba, B:103:0x02dd, B:105:0x02e5, B:107:0x02ed, B:111:0x0300, B:115:0x0311, B:119:0x031d, B:122:0x032b, B:125:0x033c, B:127:0x0350, B:129:0x0356, B:131:0x035e, B:133:0x0364, B:113:0x0309, B:101:0x02c9, B:64:0x0182, B:66:0x01ab, B:67:0x01ba, B:69:0x01c1, B:71:0x01c7, B:73:0x01d1, B:75:0x01db, B:77:0x01e1, B:79:0x01e7, B:80:0x01ec, B:84:0x020a, B:87:0x020f, B:88:0x0223, B:89:0x0231, B:90:0x023f, B:138:0x0386, B:140:0x03bb, B:141:0x03be, B:142:0x03d4, B:144:0x03da, B:50:0x0117, B:46:0x0103, B:31:0x00b5, B:35:0x00c4, B:37:0x00d9, B:39:0x00e3, B:42:0x00ed), top: B:153:0x0095, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0103 A[Catch: all -> 0x0403, TryCatch #1 {all -> 0x0403, blocks: (B:24:0x0095, B:26:0x00a3, B:43:0x00f0, B:45:0x00fd, B:47:0x0106, B:49:0x010b, B:52:0x0124, B:56:0x0138, B:58:0x015c, B:61:0x0164, B:63:0x0173, B:91:0x024e, B:93:0x027a, B:94:0x027d, B:96:0x02a5, B:136:0x036d, B:137:0x0370, B:145:0x03f4, B:98:0x02ba, B:103:0x02dd, B:105:0x02e5, B:107:0x02ed, B:111:0x0300, B:115:0x0311, B:119:0x031d, B:122:0x032b, B:125:0x033c, B:127:0x0350, B:129:0x0356, B:131:0x035e, B:133:0x0364, B:113:0x0309, B:101:0x02c9, B:64:0x0182, B:66:0x01ab, B:67:0x01ba, B:69:0x01c1, B:71:0x01c7, B:73:0x01d1, B:75:0x01db, B:77:0x01e1, B:79:0x01e7, B:80:0x01ec, B:84:0x020a, B:87:0x020f, B:88:0x0223, B:89:0x0231, B:90:0x023f, B:138:0x0386, B:140:0x03bb, B:141:0x03be, B:142:0x03d4, B:144:0x03da, B:50:0x0117, B:46:0x0103, B:31:0x00b5, B:35:0x00c4, B:37:0x00d9, B:39:0x00e3, B:42:0x00ed), top: B:153:0x0095, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010b A[Catch: all -> 0x0403, TryCatch #1 {all -> 0x0403, blocks: (B:24:0x0095, B:26:0x00a3, B:43:0x00f0, B:45:0x00fd, B:47:0x0106, B:49:0x010b, B:52:0x0124, B:56:0x0138, B:58:0x015c, B:61:0x0164, B:63:0x0173, B:91:0x024e, B:93:0x027a, B:94:0x027d, B:96:0x02a5, B:136:0x036d, B:137:0x0370, B:145:0x03f4, B:98:0x02ba, B:103:0x02dd, B:105:0x02e5, B:107:0x02ed, B:111:0x0300, B:115:0x0311, B:119:0x031d, B:122:0x032b, B:125:0x033c, B:127:0x0350, B:129:0x0356, B:131:0x035e, B:133:0x0364, B:113:0x0309, B:101:0x02c9, B:64:0x0182, B:66:0x01ab, B:67:0x01ba, B:69:0x01c1, B:71:0x01c7, B:73:0x01d1, B:75:0x01db, B:77:0x01e1, B:79:0x01e7, B:80:0x01ec, B:84:0x020a, B:87:0x020f, B:88:0x0223, B:89:0x0231, B:90:0x023f, B:138:0x0386, B:140:0x03bb, B:141:0x03be, B:142:0x03d4, B:144:0x03da, B:50:0x0117, B:46:0x0103, B:31:0x00b5, B:35:0x00c4, B:37:0x00d9, B:39:0x00e3, B:42:0x00ed), top: B:153:0x0095, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0117 A[Catch: all -> 0x0403, TryCatch #1 {all -> 0x0403, blocks: (B:24:0x0095, B:26:0x00a3, B:43:0x00f0, B:45:0x00fd, B:47:0x0106, B:49:0x010b, B:52:0x0124, B:56:0x0138, B:58:0x015c, B:61:0x0164, B:63:0x0173, B:91:0x024e, B:93:0x027a, B:94:0x027d, B:96:0x02a5, B:136:0x036d, B:137:0x0370, B:145:0x03f4, B:98:0x02ba, B:103:0x02dd, B:105:0x02e5, B:107:0x02ed, B:111:0x0300, B:115:0x0311, B:119:0x031d, B:122:0x032b, B:125:0x033c, B:127:0x0350, B:129:0x0356, B:131:0x035e, B:133:0x0364, B:113:0x0309, B:101:0x02c9, B:64:0x0182, B:66:0x01ab, B:67:0x01ba, B:69:0x01c1, B:71:0x01c7, B:73:0x01d1, B:75:0x01db, B:77:0x01e1, B:79:0x01e7, B:80:0x01ec, B:84:0x020a, B:87:0x020f, B:88:0x0223, B:89:0x0231, B:90:0x023f, B:138:0x0386, B:140:0x03bb, B:141:0x03be, B:142:0x03d4, B:144:0x03da, B:50:0x0117, B:46:0x0103, B:31:0x00b5, B:35:0x00c4, B:37:0x00d9, B:39:0x00e3, B:42:0x00ed), top: B:153:0x0095, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0124 A[Catch: all -> 0x0403, TRY_LEAVE, TryCatch #1 {all -> 0x0403, blocks: (B:24:0x0095, B:26:0x00a3, B:43:0x00f0, B:45:0x00fd, B:47:0x0106, B:49:0x010b, B:52:0x0124, B:56:0x0138, B:58:0x015c, B:61:0x0164, B:63:0x0173, B:91:0x024e, B:93:0x027a, B:94:0x027d, B:96:0x02a5, B:136:0x036d, B:137:0x0370, B:145:0x03f4, B:98:0x02ba, B:103:0x02dd, B:105:0x02e5, B:107:0x02ed, B:111:0x0300, B:115:0x0311, B:119:0x031d, B:122:0x032b, B:125:0x033c, B:127:0x0350, B:129:0x0356, B:131:0x035e, B:133:0x0364, B:113:0x0309, B:101:0x02c9, B:64:0x0182, B:66:0x01ab, B:67:0x01ba, B:69:0x01c1, B:71:0x01c7, B:73:0x01d1, B:75:0x01db, B:77:0x01e1, B:79:0x01e7, B:80:0x01ec, B:84:0x020a, B:87:0x020f, B:88:0x0223, B:89:0x0231, B:90:0x023f, B:138:0x0386, B:140:0x03bb, B:141:0x03be, B:142:0x03d4, B:144:0x03da, B:50:0x0117, B:46:0x0103, B:31:0x00b5, B:35:0x00c4, B:37:0x00d9, B:39:0x00e3, B:42:0x00ed), top: B:153:0x0095, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x027a A[Catch: all -> 0x0403, TryCatch #1 {all -> 0x0403, blocks: (B:24:0x0095, B:26:0x00a3, B:43:0x00f0, B:45:0x00fd, B:47:0x0106, B:49:0x010b, B:52:0x0124, B:56:0x0138, B:58:0x015c, B:61:0x0164, B:63:0x0173, B:91:0x024e, B:93:0x027a, B:94:0x027d, B:96:0x02a5, B:136:0x036d, B:137:0x0370, B:145:0x03f4, B:98:0x02ba, B:103:0x02dd, B:105:0x02e5, B:107:0x02ed, B:111:0x0300, B:115:0x0311, B:119:0x031d, B:122:0x032b, B:125:0x033c, B:127:0x0350, B:129:0x0356, B:131:0x035e, B:133:0x0364, B:113:0x0309, B:101:0x02c9, B:64:0x0182, B:66:0x01ab, B:67:0x01ba, B:69:0x01c1, B:71:0x01c7, B:73:0x01d1, B:75:0x01db, B:77:0x01e1, B:79:0x01e7, B:80:0x01ec, B:84:0x020a, B:87:0x020f, B:88:0x0223, B:89:0x0231, B:90:0x023f, B:138:0x0386, B:140:0x03bb, B:141:0x03be, B:142:0x03d4, B:144:0x03da, B:50:0x0117, B:46:0x0103, B:31:0x00b5, B:35:0x00c4, B:37:0x00d9, B:39:0x00e3, B:42:0x00ed), top: B:153:0x0095, inners: #0, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02a5 A[Catch: all -> 0x0403, TRY_LEAVE, TryCatch #1 {all -> 0x0403, blocks: (B:24:0x0095, B:26:0x00a3, B:43:0x00f0, B:45:0x00fd, B:47:0x0106, B:49:0x010b, B:52:0x0124, B:56:0x0138, B:58:0x015c, B:61:0x0164, B:63:0x0173, B:91:0x024e, B:93:0x027a, B:94:0x027d, B:96:0x02a5, B:136:0x036d, B:137:0x0370, B:145:0x03f4, B:98:0x02ba, B:103:0x02dd, B:105:0x02e5, B:107:0x02ed, B:111:0x0300, B:115:0x0311, B:119:0x031d, B:122:0x032b, B:125:0x033c, B:127:0x0350, B:129:0x0356, B:131:0x035e, B:133:0x0364, B:113:0x0309, B:101:0x02c9, B:64:0x0182, B:66:0x01ab, B:67:0x01ba, B:69:0x01c1, B:71:0x01c7, B:73:0x01d1, B:75:0x01db, B:77:0x01e1, B:79:0x01e7, B:80:0x01ec, B:84:0x020a, B:87:0x020f, B:88:0x0223, B:89:0x0231, B:90:0x023f, B:138:0x0386, B:140:0x03bb, B:141:0x03be, B:142:0x03d4, B:144:0x03da, B:50:0x0117, B:46:0x0103, B:31:0x00b5, B:35:0x00c4, B:37:0x00d9, B:39:0x00e3, B:42:0x00ed), top: B:153:0x0095, inners: #0, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzag(zzr zzrVar) {
        long j;
        long j2;
        zzbc zzf;
        boolean z;
        long zzN;
        zzib zzibVar;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        ApplicationInfo applicationInfo2;
        long j3;
        boolean z2;
        zzaW().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        if (zzaQ(zzrVar)) {
            zzh zzu = zzj().zzu(str);
            if (zzu != null && TextUtils.isEmpty(zzu.zzf()) && !TextUtils.isEmpty(zzrVar.zzb)) {
                zzu.zzI(0L);
                zzj().zzv(zzu, false, false);
                zzh().zzh(str);
            }
            if (!zzrVar.zzh) {
                zzan(zzrVar);
                return;
            }
            long j4 = zzrVar.zzl;
            if (j4 == 0) {
                j4 = zzaZ().currentTimeMillis();
            }
            long j5 = j4;
            int i = zzrVar.zzm;
            if (i != 0 && i != 1) {
                zzaV().zze().zzc("Incorrect app type, assuming installed app. appId, appType", zzgt.zzl(str), Integer.valueOf(i));
                i = 0;
            }
            zzj().zzb();
            try {
                zzpm zzm = zzj().zzm(str, "_npa");
                Boolean zzaT = zzaT(zzrVar);
                if (zzm != null && !"auto".equals(zzm.zzb)) {
                    j = j5;
                    j2 = 1;
                    if (!zzd().zzp(null, zzfx.zzbc)) {
                        zzam(zzrVar, zzrVar.zzD);
                    } else {
                        zzam(zzrVar, j);
                    }
                    zzan(zzrVar);
                    if (i == 0) {
                        zzf = zzj().zzf(str, "_v");
                        z = true;
                    } else {
                        zzf = zzj().zzf(str, "_f");
                        z = false;
                    }
                    if (zzf != null) {
                        long j6 = ((j / 3600000) + j2) * 3600000;
                        if (z) {
                            long j7 = j;
                            zzab(new zzpk("_fvt", j7, Long.valueOf(j6), "auto"), zzrVar);
                            zzaW().zzg();
                            zzu();
                            Bundle bundle = new Bundle();
                            bundle.putLong("_c", 1L);
                            bundle.putLong("_r", 1L);
                            bundle.putLong("_et", 1L);
                            if (zzrVar.zzo) {
                                bundle.putLong("_dac", 1L);
                            }
                            zzE(new zzbg("_v", new zzbe(bundle), "auto", j7), zzrVar);
                        } else {
                            Long valueOf = Long.valueOf(j6);
                            long j8 = j;
                            zzab(new zzpk("_fot", j8, valueOf, "auto"), zzrVar);
                            zzaW().zzg();
                            zzhj zzhjVar = (zzhj) Preconditions.checkNotNull(this.zzm);
                            if (str != null && !str.isEmpty()) {
                                zzib zzibVar2 = zzhjVar.zza;
                                zzibVar2.zzaW().zzg();
                                if (!zzhjVar.zza()) {
                                    zzibVar2.zzaV().zzi().zza("Install Referrer Reporter is not available");
                                } else {
                                    zzhi zzhiVar = new zzhi(zzhjVar, str);
                                    zzibVar2.zzaW().zzg();
                                    Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                                    intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                                    PackageManager packageManager = zzibVar2.zzaY().getPackageManager();
                                    if (packageManager == null) {
                                        zzibVar2.zzaV().zzf().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                                    } else {
                                        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
                                        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                                            zzibVar2.zzaV().zzi().zza("Play Service for fetching Install Referrer is unavailable on device");
                                        } else {
                                            ResolveInfo resolveInfo = queryIntentServices.get(0);
                                            if (resolveInfo.serviceInfo != null) {
                                                String str2 = resolveInfo.serviceInfo.packageName;
                                                if (resolveInfo.serviceInfo.name == null || !"com.android.vending".equals(str2) || !zzhjVar.zza()) {
                                                    zzibVar2.zzaV().zze().zza("Play Store version 8.3.73 or higher required for Install Referrer");
                                                } else {
                                                    try {
                                                        zzibVar2.zzaV().zzk().zzb("Install Referrer Service is", ConnectionTracker.getInstance().bindService(zzibVar2.zzaY(), new Intent(intent), zzhiVar, 1) ? "available" : "not available");
                                                    } catch (RuntimeException e) {
                                                        zzhjVar.zza.zzaV().zzb().zzb("Exception occurred while binding to Install Referrer Service", e.getMessage());
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
                                String str3 = (String) Preconditions.checkNotNull(zzrVar.zza);
                                zzav zzj = zzj();
                                Preconditions.checkNotEmpty(str3);
                                zzj.zzg();
                                zzj.zzay();
                                zzN = zzj.zzN(str3, "first_open_count");
                                zzibVar = this.zzn;
                                if (zzibVar.zzaY().getPackageManager() == null) {
                                    try {
                                        packageInfo = Wrappers.packageManager(zzibVar.zzaY()).getPackageInfo(str3, 0);
                                    } catch (PackageManager.NameNotFoundException e2) {
                                        zzaV().zzb().zzc("Package info is null, first open report might be inaccurate. appId", zzgt.zzl(str3), e2);
                                        packageInfo = null;
                                    }
                                    if (packageInfo == null || packageInfo.firstInstallTime == 0) {
                                        applicationInfo = null;
                                    } else {
                                        if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                            applicationInfo = null;
                                            if (!zzd().zzp(null, zzfx.zzaI)) {
                                                bundle2.putLong("_uwa", 1L);
                                            } else if (zzN == 0) {
                                                bundle2.putLong("_uwa", 1L);
                                                zzN = 0;
                                            }
                                            z2 = false;
                                        } else {
                                            applicationInfo = null;
                                            z2 = true;
                                        }
                                        zzab(new zzpk("_fi", j8, Long.valueOf(true != z2 ? 0L : 1L), "auto"), zzrVar);
                                    }
                                    try {
                                        applicationInfo2 = Wrappers.packageManager(this.zzn.zzaY()).getApplicationInfo(str3, 0);
                                    } catch (PackageManager.NameNotFoundException e3) {
                                        zzaV().zzb().zzc("Application info is null, first open report might be inaccurate. appId", zzgt.zzl(str3), e3);
                                        applicationInfo2 = applicationInfo;
                                    }
                                    if (applicationInfo2 != null) {
                                        if ((applicationInfo2.flags & 1) != 0) {
                                            j3 = 1;
                                            bundle2.putLong("_sys", 1L);
                                        } else {
                                            j3 = 1;
                                        }
                                        if ((applicationInfo2.flags & 128) != 0) {
                                            bundle2.putLong("_sysu", j3);
                                        }
                                    }
                                } else {
                                    zzaV().zzb().zzb("PackageManager is null, first open report might be inaccurate. appId", zzgt.zzl(str3));
                                }
                                if (zzN >= 0) {
                                    bundle2.putLong("_pfo", zzN);
                                }
                                zzE(new zzbg("_f", new zzbe(bundle2), "auto", j8), zzrVar);
                            }
                            zzhjVar.zza.zzaV().zzf().zza("Install Referrer Reporter was called with invalid app package name");
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
                            String str32 = (String) Preconditions.checkNotNull(zzrVar.zza);
                            zzav zzj2 = zzj();
                            Preconditions.checkNotEmpty(str32);
                            zzj2.zzg();
                            zzj2.zzay();
                            zzN = zzj2.zzN(str32, "first_open_count");
                            zzibVar = this.zzn;
                            if (zzibVar.zzaY().getPackageManager() == null) {
                            }
                            if (zzN >= 0) {
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
                    zzac("_npa", zzrVar);
                }
                if (!zzd().zzp(null, zzfx.zzbc)) {
                }
                zzan(zzrVar);
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
    public final void zzah(zzr zzrVar) {
        zzaW().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        int i = 0;
        if (zzd().zzp(null, zzfx.zzaz)) {
            long currentTimeMillis = zzaZ().currentTimeMillis();
            int zzm = zzd().zzm(null, zzfx.zzai);
            zzd();
            long zzF = currentTimeMillis - zzal.zzF();
            while (i < zzm && zzaF(null, zzF)) {
                i++;
            }
        } else {
            zzd();
            long zzH = zzal.zzH();
            while (i < zzH && zzaF(str, 0L)) {
                i++;
            }
        }
        if (zzd().zzp(null, zzfx.zzaA)) {
            zzaW().zzg();
            zzau();
        }
        if (this.zzl.zzc(str, com.google.android.gms.internal.measurement.zzin.zzb(zzrVar.zzE))) {
            zzaV().zzk().zzb("[sgtm] Going background, trigger client side upload. appId", str);
            zzN(str, zzaZ().currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzai(zzah zzahVar) {
        zzr zzaN = zzaN((String) Preconditions.checkNotNull(zzahVar.zza));
        if (zzaN != null) {
            zzaj(zzahVar, zzaN);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaj(zzah zzahVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzahVar);
        Preconditions.checkNotEmpty(zzahVar.zza);
        Preconditions.checkNotNull(zzahVar.zzb);
        Preconditions.checkNotNull(zzahVar.zzc);
        Preconditions.checkNotEmpty(zzahVar.zzc.zzb);
        zzaW().zzg();
        zzu();
        if (zzaQ(zzrVar)) {
            if (!zzrVar.zzh) {
                zzan(zzrVar);
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
                        zzpk zzpkVar = zzahVar2.zzc;
                        zzahVar2.zzc = new zzpk(zzpkVar.zzb, zzahVar2.zzd, zzpkVar.zza(), zzahVar2.zzc.zzf);
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
                    zzpk zzpkVar2 = zzahVar2.zzc;
                    zzahVar2.zzc = new zzpk(zzpkVar2.zzb, zzq.zzc.zzc, zzpkVar2.zza(), zzq.zzc.zzf);
                }
                if (zzahVar2.zze) {
                    zzpk zzpkVar3 = zzahVar2.zzc;
                    zzpm zzpmVar = new zzpm((String) Preconditions.checkNotNull(zzahVar2.zza), zzahVar2.zzb, zzpkVar3.zzb, zzpkVar3.zzc, Preconditions.checkNotNull(zzpkVar3.zza()));
                    if (zzj().zzl(zzpmVar)) {
                        zzaV().zzj().zzd("User property updated immediately", zzahVar2.zza, this.zzn.zzl().zzc(zzpmVar.zzc), zzpmVar.zze);
                    } else {
                        zzaV().zzb().zzd("(2)Too many active user properties, ignoring", zzgt.zzl(zzahVar2.zza), this.zzn.zzl().zzc(zzpmVar.zzc), zzpmVar.zze);
                    }
                    if (z && zzahVar2.zzi != null) {
                        zzH(new zzbg(zzahVar2.zzi, zzahVar2.zzd), zzrVar);
                    }
                }
                if (zzj().zzp(zzahVar2)) {
                    zzaV().zzj().zzd("Conditional property added", zzahVar2.zza, this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                } else {
                    zzaV().zzb().zzd("Too many conditional properties, ignoring", zzgt.zzl(zzahVar2.zza), this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzak(zzah zzahVar) {
        zzr zzaN = zzaN((String) Preconditions.checkNotNull(zzahVar.zza));
        if (zzaN != null) {
            zzal(zzahVar, zzaN);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzal(zzah zzahVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzahVar);
        Preconditions.checkNotEmpty(zzahVar.zza);
        Preconditions.checkNotNull(zzahVar.zzc);
        Preconditions.checkNotEmpty(zzahVar.zzc.zzb);
        zzaW().zzg();
        zzu();
        if (zzaQ(zzrVar)) {
            if (!zzrVar.zzh) {
                zzan(zzrVar);
                return;
            }
            zzj().zzb();
            try {
                zzan(zzrVar);
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
                    zzaV().zze().zzc("Conditional user property doesn't exist", zzgt.zzl(zzahVar.zza), this.zzn.zzl().zzc(zzahVar.zzc.zzb));
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    final void zzam(zzr zzrVar, long j) {
        zzh zzu = zzj().zzu((String) Preconditions.checkNotNull(zzrVar.zza));
        boolean z = true;
        if (zzu != null && zzt().zzB(zzrVar.zzb, zzu.zzf())) {
            zzaV().zze().zzb("New GMP App Id passed in. Removing cached database data. appId", zzgt.zzl(zzu.zzc()));
            zzav zzj = zzj();
            String zzc = zzu.zzc();
            zzj.zzay();
            zzj.zzg();
            Preconditions.checkNotEmpty(zzc);
            try {
                SQLiteDatabase zze = zzj.zze();
                String[] strArr = {zzc};
                int delete = zze.delete("events", "app_id=?", strArr) + zze.delete("user_attributes", "app_id=?", strArr) + zze.delete("conditional_properties", "app_id=?", strArr) + zze.delete("apps", "app_id=?", strArr) + zze.delete("raw_events", "app_id=?", strArr) + zze.delete("raw_events_metadata", "app_id=?", strArr) + zze.delete("event_filters", "app_id=?", strArr) + zze.delete("property_filters", "app_id=?", strArr) + zze.delete("audience_filter_values", "app_id=?", strArr) + zze.delete("consent_settings", "app_id=?", strArr) + zze.delete("default_event_params", "app_id=?", strArr) + zze.delete("trigger_uris", "app_id=?", strArr);
                com.google.android.gms.internal.measurement.zzpk.zza();
                zzib zzibVar = zzj.zzu;
                if (zzibVar.zzc().zzp(null, zzfx.zzbi)) {
                    delete += zze.delete("no_data_mode_events", "app_id=?", strArr);
                }
                if (delete > 0) {
                    zzibVar.zzaV().zzk().zzc("Deleted application data. app, records", zzc, Integer.valueOf(delete));
                }
            } catch (SQLiteException e) {
                zzj.zzu.zzaV().zzb().zzc("Error deleting application data. appId, error", zzgt.zzl(zzc), e);
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
                if (zzd().zzp(null, zzfx.zzbd)) {
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
    public final zzh zzan(zzr zzrVar) {
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
            this.zzE.put(str6, new zzpc(this, str7, null));
        }
        zzh zzu = zzj().zzu(str6);
        zzjk zzs = zzB(str6).zzs(zzjk.zzf(zzrVar.zzs, 100));
        zzjj zzjjVar = zzjj.AD_STORAGE;
        if (zzs.zzo(zzjjVar)) {
            str = this.zzk.zzf(str6, zzrVar.zzn);
        } else {
            str = "";
        }
        boolean z2 = true;
        if (zzu == null) {
            zzh zzhVar = new zzh(this.zzn, str6);
            if (zzs.zzo(zzjj.ANALYTICS_STORAGE)) {
                zzhVar.zze(zzK(zzs));
            }
            if (zzs.zzo(zzjjVar)) {
                zzhVar.zzk(str);
            }
            zzu = zzhVar;
        } else if (!zzs.zzo(zzjjVar) || str == null || str.equals(zzu.zzj())) {
            if (TextUtils.isEmpty(zzu.zzd()) && zzs.zzo(zzjj.ANALYTICS_STORAGE)) {
                zzu.zze(zzK(zzs));
            }
        } else {
            boolean isEmpty = TextUtils.isEmpty(zzu.zzj());
            zzu.zzk(str);
            if (!zzrVar.zzn || "00000000-0000-0000-0000-000000000000".equals(this.zzk.zzc(str6, zzs).first) || isEmpty) {
                if (TextUtils.isEmpty(zzu.zzd()) && zzs.zzo(zzjj.ANALYTICS_STORAGE)) {
                    zzu.zze(zzK(zzs));
                }
            } else {
                if (zzs.zzo(zzjj.ANALYTICS_STORAGE)) {
                    zzu.zze(zzK(zzs));
                    z = false;
                } else {
                    z = true;
                }
                if (zzj().zzm(str6, APEZProvider.FILEID) != null && zzj().zzm(str6, "_lair") == null) {
                    zzj().zzl(new zzpm(str6, "auto", "_lair", zzaZ().currentTimeMillis(), 1L));
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
                com.google.android.gms.internal.measurement.zzpn.zza();
                if (zzd().zzp(null, zzfx.zzaL)) {
                    com.google.android.gms.internal.measurement.zzpn.zza();
                    if (zzd().zzp(null, zzfx.zzaK)) {
                        zzu.zzah(null);
                    }
                } else {
                    zzu.zzah(zzrVar.zzr);
                }
                zzu.zzaj(zzrVar.zzv);
                zzu.zzaz(zzrVar.zzB);
                zzql.zza();
                if (zzd().zzp(null, zzfx.zzaP)) {
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
        com.google.android.gms.internal.measurement.zzpn.zza();
        if (zzd().zzp(null, zzfx.zzaL)) {
        }
        zzu.zzaj(zzrVar.zzv);
        zzu.zzaz(zzrVar.zzB);
        zzql.zza();
        if (zzd().zzp(null, zzfx.zzaP)) {
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
    public final String zzao(zzr zzrVar) {
        try {
            return (String) zzaW().zzh(new zzoy(this, zzrVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzaV().zzb().zzc("Failed to get app instance id. appId", zzgt.zzl(zzrVar.zza), e);
            return null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:28:0x00a8
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    final java.util.List zzap(com.google.android.gms.measurement.internal.zzr r21, android.os.Bundle r22) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpf.zzap(com.google.android.gms.measurement.internal.zzr, android.os.Bundle):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaq(String str, zzaf zzafVar) {
        zzaW().zzg();
        zzu();
        zzav zzj = zzj();
        long j = zzafVar.zza;
        zzpi zzB = zzj.zzB(j);
        if (zzB == null) {
            zzaV().zze().zzc("[sgtm] Queued batch doesn't exist. appId, rowId", str, Long.valueOf(j));
            return;
        }
        String zze = zzB.zze();
        if (zzafVar.zzb == zzlq.SUCCESS.zza()) {
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
                zzj3.zzay();
                Long valueOf2 = Long.valueOf(j2);
                Preconditions.checkNotNull(valueOf2);
                ContentValues contentValues = new ContentValues();
                contentValues.put("upload_type", Integer.valueOf(zzlr.GOOGLE_SIGNAL.zza()));
                zzib zzibVar = zzj3.zzu;
                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzibVar.zzaZ().currentTimeMillis()));
                try {
                    if (zzj3.zze().update("upload_queue", contentValues, "rowid=? AND app_id=? AND upload_type=?", new String[]{String.valueOf(j2), str, String.valueOf(zzlr.GOOGLE_SIGNAL_PENDING.zza())}) != 1) {
                        zzibVar.zzaV().zze().zzc("Google Signal pending batch not updated. appId, rowId", str, valueOf2);
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
        if (zzafVar.zzb == zzlq.BACKOFF.zza()) {
            Map map2 = this.zzF;
            zzpd zzpdVar = (zzpd) map2.get(zze);
            if (zzpdVar == null) {
                zzpdVar = new zzpd(this);
                map2.put(zze, zzpdVar);
            } else {
                zzpdVar.zza();
            }
            zzaV().zzk().zzd("[sgtm] Putting sGTM server in backoff mode. appId, destination, nextRetryInSeconds", str, zze, Long.valueOf((zzpdVar.zzc() - zzaZ().currentTimeMillis()) / 1000));
        }
        zzav zzj4 = zzj();
        Long valueOf3 = Long.valueOf(zzafVar.zza);
        zzj4.zzK(valueOf3);
        zzaV().zzk().zzc("[sgtm] increased batch retry count after failed client upload. appId, rowId", str, valueOf3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzar(boolean z) {
        zzaK();
    }

    public final void zzas(String str, zzlt zzltVar) {
        zzaW().zzg();
        String str2 = this.zzH;
        if (str2 == null || str2.equals(str) || zzltVar != null) {
            this.zzH = str;
            this.zzG = zzltVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzat(zzpg zzpgVar) {
        zzaW().zzg();
        this.zzm = new zzhj(this);
        zzav zzavVar = new zzav(this);
        zzavVar.zzaz();
        this.zze = zzavVar;
        zzd().zza((zzak) Preconditions.checkNotNull(this.zzc));
        zznm zznmVar = new zznm(this);
        zznmVar.zzaz();
        this.zzk = zznmVar;
        zzad zzadVar = new zzad(this);
        zzadVar.zzaz();
        this.zzh = zzadVar;
        zzlo zzloVar = new zzlo(this);
        zzloVar.zzaz();
        this.zzj = zzloVar;
        zzoj zzojVar = new zzoj(this);
        zzojVar.zzaz();
        this.zzg = zzojVar;
        this.zzf = new zzha(this);
        if (this.zzs != this.zzt) {
            zzaV().zzb().zzc("Not all upload components initialized", Integer.valueOf(this.zzs), Integer.valueOf(this.zzt));
        }
        this.zzo.set(true);
        zzaV().zzk().zza("UploadController is now fully initialized");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzib zzaw() {
        return this.zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Deque zzax() {
        return this.zzr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzay(long j) {
        this.zzJ = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzc() {
        zzaW().zzg();
        zzj().zzI();
        zzav zzj = zzj();
        zzj.zzg();
        zzj.zzay();
        if (zzj.zzai()) {
            zzfw zzfwVar = zzfx.zzav;
            if (((Long) zzfwVar.zzb(null)).longValue() != 0) {
                SQLiteDatabase zze = zzj.zze();
                zzib zzibVar = zzj.zzu;
                int delete = zze.delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(zzibVar.zzaZ().currentTimeMillis()), String.valueOf(zzfwVar.zzb(null))});
                if (delete > 0) {
                    zzibVar.zzaV().zzk().zzb("Deleted stale trigger uris. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
        if (this.zzk.zzd.zza() == 0) {
            this.zzk.zzd.zzb(zzaZ().currentTimeMillis());
        }
        zzaK();
    }

    public final zzal zzd() {
        return ((zzib) Preconditions.checkNotNull(this.zzn)).zzc();
    }

    public final zzot zzf() {
        return this.zzl;
    }

    public final zzhs zzh() {
        zzhs zzhsVar = this.zzc;
        zzaS(zzhsVar);
        return zzhsVar;
    }

    public final zzgy zzi() {
        zzgy zzgyVar = this.zzd;
        zzaS(zzgyVar);
        return zzgyVar;
    }

    public final zzav zzj() {
        zzav zzavVar = this.zze;
        zzaS(zzavVar);
        return zzavVar;
    }

    public final zzha zzk() {
        zzha zzhaVar = this.zzf;
        if (zzhaVar != null) {
            return zzhaVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzoj zzl() {
        zzoj zzojVar = this.zzg;
        zzaS(zzojVar);
        return zzojVar;
    }

    public final zzad zzm() {
        zzad zzadVar = this.zzh;
        zzaS(zzadVar);
        return zzadVar;
    }

    public final zzlo zzn() {
        zzlo zzloVar = this.zzj;
        zzaS(zzloVar);
        return zzloVar;
    }

    public final zzpj zzp() {
        zzpj zzpjVar = this.zzi;
        zzaS(zzpjVar);
        return zzpjVar;
    }

    public final zznm zzq() {
        return this.zzk;
    }

    public final zzgm zzs() {
        return this.zzn.zzl();
    }

    public final zzpo zzt() {
        return ((zzib) Preconditions.checkNotNull(this.zzn)).zzk();
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
        zzjk zzf = zzjk.zzf(zzrVar.zzs, zzrVar.zzx);
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
        zzjh zzc = zzaz.zzh(zzy(str), 100).zzc();
        this.zzD.put(str, zzg);
        zzj().zzad(str, zzg);
        zzjh zzc2 = zzaz.zzh(zzy(str), 100).zzc();
        zzaW().zzg();
        zzu();
        zzjh zzjhVar = zzjh.DENIED;
        boolean z = true;
        boolean z2 = zzc == zzjhVar && zzc2 == zzjh.GRANTED;
        if (zzc != zzjh.GRANTED || zzc2 != zzjhVar) {
            z = false;
        }
        if (z2 || z) {
            zzaV().zzk().zzb("Generated _dcu event for", str);
            Bundle bundle = new Bundle();
            if (zzj().zzw(zzC(), str, false, false, false, false, false, false, false).zzf < zzd().zzm(str, zzfx.zzam)) {
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
            zzaz zzac = zzj().zzac(str);
            map.put(str, zzac);
            return zzac;
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
        zzjk zzB = zzB(str);
        bundle.putAll(zzB.zzn());
        bundle.putAll(zzz(str, zzx(str), zzB, new zzan()).zzf());
        zzpm zzm = zzj().zzm(str, "_npa");
        if (zzm != null) {
            z = zzm.zze.equals(1L);
        } else {
            z = zzaB(str, new zzan());
        }
        if (1 != z) {
            str2 = "granted";
        } else {
            str2 = "denied";
        }
        bundle.putString("ad_personalization", str2);
        return bundle;
    }

    final zzaz zzz(String str, zzaz zzazVar, zzjk zzjkVar, zzan zzanVar) {
        zzjh zzjhVar;
        int i = 90;
        boolean z = false;
        if (zzh().zzx(str) == null) {
            if (zzazVar.zzc() == zzjh.DENIED) {
                i = zzazVar.zzb();
                zzanVar.zzb(zzjj.AD_USER_DATA, i);
            } else {
                zzanVar.zzc(zzjj.AD_USER_DATA, zzam.FAILSAFE);
            }
            return new zzaz((Boolean) false, i, (Boolean) true, com.google.android.vending.expansion.downloader.Constants.FILENAME_SEQUENCE_SEPARATOR);
        }
        zzjh zzc = zzazVar.zzc();
        zzjh zzjhVar2 = zzjh.GRANTED;
        if (zzc == zzjhVar2 || zzc == (zzjhVar = zzjh.DENIED)) {
            i = zzazVar.zzb();
            zzanVar.zzb(zzjj.AD_USER_DATA, i);
        } else {
            if (zzc == zzjh.POLICY) {
                zzhs zzhsVar = this.zzc;
                zzjj zzjjVar = zzjj.AD_USER_DATA;
                zzjh zzA = zzhsVar.zzA(str, zzjjVar);
                if (zzA != zzjh.UNINITIALIZED) {
                    zzanVar.zzc(zzjjVar, zzam.REMOTE_ENFORCED_DEFAULT);
                    zzc = zzA;
                }
            }
            zzhs zzhsVar2 = this.zzc;
            zzjj zzjjVar2 = zzjj.AD_USER_DATA;
            zzjj zzw = zzhsVar2.zzw(str, zzjjVar2);
            zzjh zzp = zzjkVar.zzp();
            if (zzp == zzjhVar2 || zzp == zzjhVar) {
                z = true;
            }
            if (zzw != zzjj.AD_STORAGE || !z) {
                zzanVar.zzc(zzjjVar2, zzam.REMOTE_DEFAULT);
                zzc = true != zzhsVar2.zzv(str, zzjjVar2) ? zzjhVar : zzjhVar2;
            } else {
                zzanVar.zzc(zzjjVar2, zzam.REMOTE_DELEGATION);
                zzc = zzp;
            }
        }
        boolean zzy = this.zzc.zzy(str);
        SortedSet zzz = zzh().zzz(str);
        if (zzc == zzjh.DENIED || zzz.isEmpty()) {
            return new zzaz((Boolean) false, i, Boolean.valueOf(zzy), com.google.android.vending.expansion.downloader.Constants.FILENAME_SEQUENCE_SEPARATOR);
        }
        return new zzaz((Boolean) true, i, Boolean.valueOf(zzy), zzy ? TextUtils.join("", zzz) : "");
    }
}
