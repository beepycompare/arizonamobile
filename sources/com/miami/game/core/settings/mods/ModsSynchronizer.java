package com.miami.game.core.settings.mods;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import coil3.util.UtilsKt;
import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
import com.google.common.base.Ascii;
import com.miami.game.core.settings.mods.ModsDocuments;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.zip.CRC32;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: ModsSynchronizer.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0003!\"#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u000eJ0\u0010\u0012\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0010H\u0002J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010 \u001a\n \b*\u0004\u0018\u00010\u00100\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006$"}, d2 = {"Lcom/miami/game/core/settings/mods/ModsSynchronizer;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "resolver", "Landroid/content/ContentResolver;", "kotlin.jvm.PlatformType", "getResolver", "()Landroid/content/ContentResolver;", "root", "Ljava/io/File;", "source", "", "readManifest", "Lorg/json/JSONObject;", "lastGood", "synchronize", "retainObjects", "", "progress", "Lkotlin/Function1;", "Lcom/miami/game/core/settings/mods/ModsSynchronizer$Progress;", "", "sameMetadata", UtilsKt.SCHEME_FILE, "Lcom/miami/game/core/settings/mods/ModsDocuments$Entry;", "entry", "validObject", "objects", "verifySourceUnchanged", "configuration", "Progress", "Pending", "Companion", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModsSynchronizer {
    public static final Companion Companion = new Companion(null);
    private final Context context;

    /* compiled from: ModsSynchronizer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003JB\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006\""}, d2 = {"Lcom/miami/game/core/settings/mods/ModsSynchronizer$Progress;", "", "checking", "", OriginalTzArchiveManifestParser.FILES_ROOT, "", "totalFiles", "bytes", "", "totalBytes", "<init>", "(ZLjava/lang/Integer;IJJ)V", "getChecking", "()Z", "getFiles", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTotalFiles", "()I", "getBytes", "()J", "getTotalBytes", "component1", "component2", "component3", "component4", "component5", "copy", "(ZLjava/lang/Integer;IJJ)Lcom/miami/game/core/settings/mods/ModsSynchronizer$Progress;", "equals", "other", "hashCode", "toString", "", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Progress {
        private final long bytes;
        private final boolean checking;
        private final Integer files;
        private final long totalBytes;
        private final int totalFiles;

        public static /* synthetic */ Progress copy$default(Progress progress, boolean z, Integer num, int i, long j, long j2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = progress.checking;
            }
            if ((i2 & 2) != 0) {
                num = progress.files;
            }
            if ((i2 & 4) != 0) {
                i = progress.totalFiles;
            }
            if ((i2 & 8) != 0) {
                j = progress.bytes;
            }
            if ((i2 & 16) != 0) {
                j2 = progress.totalBytes;
            }
            long j3 = j2;
            int i3 = i;
            return progress.copy(z, num, i3, j, j3);
        }

        public final boolean component1() {
            return this.checking;
        }

        public final Integer component2() {
            return this.files;
        }

        public final int component3() {
            return this.totalFiles;
        }

        public final long component4() {
            return this.bytes;
        }

        public final long component5() {
            return this.totalBytes;
        }

        public final Progress copy(boolean z, Integer num, int i, long j, long j2) {
            return new Progress(z, num, i, j, j2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Progress) {
                Progress progress = (Progress) obj;
                return this.checking == progress.checking && Intrinsics.areEqual(this.files, progress.files) && this.totalFiles == progress.totalFiles && this.bytes == progress.bytes && this.totalBytes == progress.totalBytes;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.checking) * 31;
            Integer num = this.files;
            return ((((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.totalFiles)) * 31) + Long.hashCode(this.bytes)) * 31) + Long.hashCode(this.totalBytes);
        }

        public String toString() {
            boolean z = this.checking;
            Integer num = this.files;
            int i = this.totalFiles;
            long j = this.bytes;
            return "Progress(checking=" + z + ", files=" + num + ", totalFiles=" + i + ", bytes=" + j + ", totalBytes=" + this.totalBytes + ")";
        }

        public Progress(boolean z, Integer num, int i, long j, long j2) {
            this.checking = z;
            this.files = num;
            this.totalFiles = i;
            this.bytes = j;
            this.totalBytes = j2;
        }

        public /* synthetic */ Progress(boolean z, Integer num, int i, long j, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? 0L : j, (i2 & 16) != 0 ? -1L : j2);
        }

        public final boolean getChecking() {
            return this.checking;
        }

        public final Integer getFiles() {
            return this.files;
        }

        public final int getTotalFiles() {
            return this.totalFiles;
        }

        public final long getBytes() {
            return this.bytes;
        }

        public final long getTotalBytes() {
            return this.totalBytes;
        }
    }

    public ModsSynchronizer(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    private final ContentResolver getResolver() {
        return this.context.getContentResolver();
    }

    private final File root(String str) {
        Companion companion = Companion;
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] digest = messageDigest.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
        return new File(this.context.getFilesDir(), "resource-mods/" + companion.hex(digest));
    }

    private final JSONObject readManifest(File file) {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File(file, "manifest.json")), Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            JSONObject jSONObject = new JSONObject(TextStreamsKt.readText(bufferedReader));
            CloseableKt.closeFinally(bufferedReader, null);
            return jSONObject;
        } finally {
        }
    }

    public final JSONObject lastGood(String source) {
        Object m9974constructorimpl;
        File root;
        JSONObject readManifest;
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            Result.Companion companion = Result.Companion;
            ModsSynchronizer modsSynchronizer = this;
            root = root(source);
            readManifest = readManifest(root);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9974constructorimpl = Result.m9974constructorimpl(ResultKt.createFailure(th));
        }
        if (!Intrinsics.areEqual(readManifest.getString("sourceUri"), source)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        File file = new File(root, "objects");
        JSONArray jSONArray = readManifest.getJSONArray(OriginalTzArchiveManifestParser.FILES_ROOT);
        HashSet hashSet = new HashSet();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            Companion companion3 = Companion;
            String string = jSONObject.getString("path");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            if (!hashSet.add(companion3.normalize(string))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            Intrinsics.checkNotNull(jSONObject);
            if (!validObject(file, jSONObject)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
        m9974constructorimpl = Result.m9974constructorimpl(configuration(root));
        if (Result.m9980isFailureimpl(m9974constructorimpl)) {
            m9974constructorimpl = null;
        }
        return (JSONObject) m9974constructorimpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ModsSynchronizer.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/miami/game/core/settings/mods/ModsSynchronizer$Pending;", "", UtilsKt.SCHEME_FILE, "Lcom/miami/game/core/settings/mods/ModsDocuments$Entry;", "previous", "Lorg/json/JSONObject;", "<init>", "(Lcom/miami/game/core/settings/mods/ModsDocuments$Entry;Lorg/json/JSONObject;)V", "getFile", "()Lcom/miami/game/core/settings/mods/ModsDocuments$Entry;", "getPrevious", "()Lorg/json/JSONObject;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Pending {
        private final ModsDocuments.Entry file;
        private final JSONObject previous;

        public static /* synthetic */ Pending copy$default(Pending pending, ModsDocuments.Entry entry, JSONObject jSONObject, int i, Object obj) {
            if ((i & 1) != 0) {
                entry = pending.file;
            }
            if ((i & 2) != 0) {
                jSONObject = pending.previous;
            }
            return pending.copy(entry, jSONObject);
        }

        public final ModsDocuments.Entry component1() {
            return this.file;
        }

        public final JSONObject component2() {
            return this.previous;
        }

        public final Pending copy(ModsDocuments.Entry file, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(file, "file");
            return new Pending(file, jSONObject);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Pending) {
                Pending pending = (Pending) obj;
                return Intrinsics.areEqual(this.file, pending.file) && Intrinsics.areEqual(this.previous, pending.previous);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.file.hashCode() * 31;
            JSONObject jSONObject = this.previous;
            return hashCode + (jSONObject == null ? 0 : jSONObject.hashCode());
        }

        public String toString() {
            ModsDocuments.Entry entry = this.file;
            return "Pending(file=" + entry + ", previous=" + this.previous + ")";
        }

        public Pending(ModsDocuments.Entry file, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(file, "file");
            this.file = file;
            this.previous = jSONObject;
        }

        public final ModsDocuments.Entry getFile() {
            return this.file;
        }

        public final JSONObject getPrevious() {
            return this.previous;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JSONObject synchronize$default(ModsSynchronizer modsSynchronizer, String str, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        return modsSynchronizer.synchronize(str, z, function1);
    }

    public final JSONObject synchronize(String source, boolean z, final Function1<? super Progress, Unit> function1) {
        File file;
        int i;
        JSONObject configuration;
        int i2;
        long j;
        int i3;
        int i4;
        File createTempFile;
        File file2;
        CRC32 crc32;
        InputStream openInputStream;
        JSONArray jSONArray;
        HashSet hashSet;
        byte[] bArr;
        Iterator it;
        int i5;
        File file3;
        long j2;
        Ref.LongRef longRef;
        File file4;
        JSONObject put;
        Long size;
        Iterator it2;
        InputStream inputStream;
        long j3;
        InputStream inputStream2;
        CRC32 crc322;
        long j4;
        long j5;
        long j6;
        int i6;
        File file5;
        File file6;
        ModsDocuments.Entry entry;
        byte[] bArr2;
        FileOutputStream fileOutputStream;
        Ref.LongRef longRef2;
        int i7;
        FileOutputStream fileOutputStream2;
        JSONArray optJSONArray;
        Ref.LongRef longRef3;
        boolean z2;
        JSONArray optJSONArray2;
        Intrinsics.checkNotNullParameter(source, "source");
        synchronized (ModsStorage.INSTANCE.getLock$settings()) {
            if (!ModsPreferences.INSTANCE.prefs(this.context).getBoolean(ModsPreferences.ENABLED, false)) {
                throw new IllegalStateException("Mods are disabled".toString());
            }
            final Ref.LongRef longRef4 = new Ref.LongRef();
            File root = root(source);
            File file7 = new File(root, "objects");
            if (!file7.isDirectory() && !file7.mkdirs()) {
                throw new IllegalStateException("Check failed.");
            }
            Result.Companion companion = Result.Companion;
            ModsSynchronizer modsSynchronizer = this;
            Object m9974constructorimpl = Result.m9974constructorimpl(readManifest(root));
            if (Result.m9980isFailureimpl(m9974constructorimpl)) {
                m9974constructorimpl = null;
            }
            JSONObject jSONObject = (JSONObject) m9974constructorimpl;
            if (jSONObject == null || !Intrinsics.areEqual(jSONObject.optString("sourceUri"), source)) {
                jSONObject = null;
            }
            HashMap hashMap = new HashMap();
            if (jSONObject != null && (optJSONArray2 = jSONObject.optJSONArray(OriginalTzArchiveManifestParser.FILES_ROOT)) != null) {
                int length = optJSONArray2.length();
                for (int i8 = 0; i8 < length; i8++) {
                    JSONObject optJSONObject = optJSONArray2.optJSONObject(i8);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("path");
                        Intrinsics.checkNotNull(optString);
                        if (optString.length() > 0) {
                            hashMap.put(optString, optJSONObject);
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
            boolean hotReloadCapable = ModsPreferences.INSTANCE.hotReloadCapable(this.context);
            Context context = this.context;
            Uri parse = Uri.parse(source);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            List<ModsDocuments.Entry> createStarterIfEmpty = new ModsDocuments(context, parse).createStarterIfEmpty(function1 == null ? null : new Function1() { // from class: com.miami.game.core.settings.mods.ModsSynchronizer$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit synchronize$lambda$0$4;
                    synchronize$lambda$0$4 = ModsSynchronizer.synchronize$lambda$0$4(Function1.this, longRef4, ((Integer) obj).intValue());
                    return synchronize$lambda$0$4;
                }
            });
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            HashSet hashSet2 = z ? null : new HashSet();
            boolean z3 = jSONObject == null;
            int i9 = 0;
            long j7 = 0;
            for (ModsDocuments.Entry entry2 : createStarterIfEmpty) {
                if (entry2.getDirectory()) {
                    longRef3 = longRef4;
                } else {
                    if (hotReloadCapable) {
                        longRef3 = longRef4;
                        z2 = ModsPolicy.INSTANCE.ignored(entry2.getPath());
                    } else {
                        longRef3 = longRef4;
                        z2 = !ModsPolicy.INSTANCE.allowedInRelease(entry2.getPath());
                    }
                    if (!z2) {
                        i9++;
                        JSONObject jSONObject2 = (JSONObject) hashMap.get(entry2.getPath());
                        if (jSONObject2 == null || !validObject(file7, jSONObject2)) {
                            jSONObject2 = null;
                        }
                        boolean z4 = jSONObject2 != null && sameMetadata(entry2, jSONObject2);
                        if (!z4) {
                            z3 = true;
                        }
                        if (z4 && entry2.getSize() != null && entry2.getModified() != null) {
                            Intrinsics.checkNotNull(jSONObject2);
                            synchronize$lambda$0$accept(jSONArray2, hashSet2, jSONObject2);
                        } else {
                            arrayList.add(new Pending(entry2, jSONObject2));
                            if (j7 >= 0 && entry2.getSize() != null) {
                                j7 += entry2.getSize().longValue();
                            }
                            j7 = -1;
                        }
                    }
                }
                longRef4 = longRef3;
            }
            Ref.LongRef longRef5 = longRef4;
            if (hashMap.size() != i9 || jSONObject == null || (optJSONArray = jSONObject.optJSONArray(OriginalTzArchiveManifestParser.FILES_ROOT)) == null || optJSONArray.length() != i9) {
                z3 = true;
            }
            if (function1 != null) {
                function1.invoke(new Progress(true, Integer.valueOf(i9), 0, 0L, 0L, 28, null));
                Unit unit3 = Unit.INSTANCE;
            }
            if (!arrayList.isEmpty()) {
                byte[] bArr3 = new byte[131072];
                int length2 = jSONArray2.length();
                Iterator it3 = arrayList.iterator();
                Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
                int i10 = length2;
                long j8 = 0;
                while (it3.hasNext()) {
                    Object next = it3.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    Pending pending = (Pending) next;
                    ModsDocuments.Entry component1 = pending.component1();
                    JSONObject component2 = pending.component2();
                    try {
                        try {
                            if (component2 == null || !(component1.getSize() == null || component1.getModified() == null)) {
                                j = j8;
                                i3 = i10;
                                i4 = i9;
                            } else {
                                j = j8;
                                InputStream openInputStream2 = getResolver().openInputStream(component1.getUri());
                                Companion.Checksum crc323 = openInputStream2 != null ? Companion.crc32(openInputStream2, bArr3) : null;
                                String string = component2.getString("crc32");
                                i3 = i10;
                                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                i4 = i9;
                                if (Intrinsics.areEqual(crc323, new Companion.Checksum(string, component2.getLong("size")))) {
                                    verifySourceUnchanged(component1);
                                    Intrinsics.checkNotNull(component2);
                                    JSONObject put2 = component2.put("documentId", component1.getId());
                                    Object size2 = component1.getSize();
                                    if (size2 == null) {
                                        size2 = JSONObject.NULL;
                                    }
                                    JSONObject put3 = put2.put("sourceSize", size2);
                                    Object modified = component1.getModified();
                                    if (modified == null) {
                                        modified = JSONObject.NULL;
                                    }
                                    bArr = bArr3;
                                    put = put3.put("lastModified", modified);
                                    jSONArray = jSONArray2;
                                    hashSet = hashSet2;
                                    it = it3;
                                    i5 = i3;
                                    j2 = j7;
                                    longRef = longRef5;
                                    i9 = i4;
                                    file3 = root;
                                    long j9 = j;
                                    Intrinsics.checkNotNull(put);
                                    JSONArray jSONArray3 = jSONArray;
                                    HashSet hashSet3 = hashSet;
                                    synchronize$lambda$0$accept(jSONArray3, hashSet3, put);
                                    long j10 = j2;
                                    i10 = i5 + 1;
                                    synchronize$lambda$0$report(function1, longRef, false, i10, i9, j9, j10);
                                    hashSet2 = hashSet3;
                                    longRef5 = longRef;
                                    j8 = j9;
                                    jSONArray2 = jSONArray3;
                                    it3 = it;
                                    root = file3;
                                    j7 = j10;
                                    bArr3 = bArr;
                                }
                            }
                            InputStream inputStream3 = openInputStream;
                            if (inputStream3 == null) {
                                throw new IllegalStateException("Required value was null.".toString());
                            }
                            FileOutputStream fileOutputStream3 = new FileOutputStream(createTempFile);
                            try {
                                FileOutputStream fileOutputStream4 = fileOutputStream3;
                                File file8 = createTempFile;
                                jSONArray = jSONArray2;
                                hashSet = hashSet2;
                                long j11 = 0;
                                while (true) {
                                    try {
                                        int read = inputStream3.read(bArr3);
                                        if (read < 0) {
                                            break;
                                        }
                                        if (read != 0) {
                                            InputStream inputStream4 = openInputStream;
                                            try {
                                                fileOutputStream4.write(bArr3, 0, read);
                                                crc32.update(bArr3, 0, read);
                                                crc322 = crc32;
                                                long j12 = read;
                                                j4 = j11 + j12;
                                                j5 = j + j12;
                                                j6 = j7;
                                                inputStream2 = inputStream3;
                                                i6 = i3;
                                                file5 = root;
                                                file6 = file8;
                                                entry = component1;
                                                bArr2 = bArr3;
                                                fileOutputStream = fileOutputStream3;
                                                it2 = it3;
                                                longRef2 = longRef5;
                                                i7 = i4;
                                                inputStream = inputStream4;
                                                fileOutputStream2 = fileOutputStream4;
                                            } catch (Throwable th) {
                                                th = th;
                                            }
                                            try {
                                                synchronize$lambda$0$report(function1, longRef2, false, i6, i7, j5, j6);
                                                i4 = i7;
                                                j = j5;
                                                component1 = entry;
                                                fileOutputStream4 = fileOutputStream2;
                                                j11 = j4;
                                                bArr3 = bArr2;
                                                fileOutputStream3 = fileOutputStream;
                                                longRef5 = longRef2;
                                                file8 = file6;
                                                root = file5;
                                                crc32 = crc322;
                                                i3 = i6;
                                                j3 = j6;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                throw th;
                                            }
                                        } else {
                                            it2 = it3;
                                            inputStream = openInputStream;
                                            j3 = j7;
                                            inputStream2 = inputStream3;
                                            root = root;
                                            crc32 = crc32;
                                            bArr3 = bArr3;
                                            i3 = i3;
                                        }
                                        openInputStream = inputStream;
                                        it3 = it2;
                                        inputStream3 = inputStream2;
                                        j7 = j3;
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                }
                                bArr = bArr3;
                                FileOutputStream fileOutputStream5 = fileOutputStream3;
                                it = it3;
                                i5 = i3;
                                i9 = i4;
                                InputStream inputStream5 = openInputStream;
                                file3 = root;
                                file2 = file8;
                                j2 = j7;
                                CRC32 crc324 = crc32;
                                ModsDocuments.Entry entry3 = component1;
                                longRef = longRef5;
                                fileOutputStream4.getFD().sync();
                                Unit unit4 = Unit.INSTANCE;
                                try {
                                    CloseableKt.closeFinally(fileOutputStream5, null);
                                    Unit unit5 = Unit.INSTANCE;
                                    try {
                                        CloseableKt.closeFinally(inputStream5, null);
                                        if (entry3.getSize() != null && ((size = entry3.getSize()) == null || size.longValue() != j11)) {
                                            throw new IllegalArgumentException(("Source changed during copy: " + entry3.getPath()).toString());
                                        }
                                        verifySourceUnchanged(entry3);
                                        do {
                                            String uuid = UUID.randomUUID().toString();
                                            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
                                            file4 = new File(file7, StringsKt.replace$default(uuid, "-", "", false, 4, (Object) null));
                                        } while (!file4.createNewFile());
                                        if (!file2.renameTo(file4)) {
                                            file4.delete();
                                            throw new IllegalStateException("Cannot publish mod file".toString());
                                        }
                                        JSONObject put4 = new JSONObject().put("path", entry3.getPath()).put("documentId", entry3.getId());
                                        Object size3 = entry3.getSize();
                                        if (size3 == null) {
                                            size3 = JSONObject.NULL;
                                        }
                                        JSONObject put5 = put4.put("sourceSize", size3);
                                        Object modified2 = entry3.getModified();
                                        if (modified2 == null) {
                                            modified2 = JSONObject.NULL;
                                        }
                                        put = put5.put("lastModified", modified2).put("size", j11).put("crc32", Companion.hex(crc324)).put("object", file4.getName());
                                        file2.delete();
                                        z3 = true;
                                        long j92 = j;
                                        Intrinsics.checkNotNull(put);
                                        JSONArray jSONArray32 = jSONArray;
                                        HashSet hashSet32 = hashSet;
                                        synchronize$lambda$0$accept(jSONArray32, hashSet32, put);
                                        long j102 = j2;
                                        i10 = i5 + 1;
                                        synchronize$lambda$0$report(function1, longRef, false, i10, i9, j92, j102);
                                        hashSet2 = hashSet32;
                                        longRef5 = longRef;
                                        j8 = j92;
                                        jSONArray2 = jSONArray32;
                                        it3 = it;
                                        root = file3;
                                        j7 = j102;
                                        bArr3 = bArr;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        file2.delete();
                                        throw th;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    throw th;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                        }
                        crc32 = new CRC32();
                        openInputStream = getResolver().openInputStream(component1.getUri());
                    } catch (Throwable th8) {
                        th = th8;
                        file2 = createTempFile;
                    }
                    createTempFile = File.createTempFile("copy-", ".tmp", root);
                }
            }
            JSONArray jSONArray4 = jSONArray2;
            final HashSet hashSet4 = hashSet2;
            File file9 = root;
            if (z3) {
                JSONObject put6 = new JSONObject().put("sourceUri", source).put(OriginalTzArchiveManifestParser.FILES_ROOT, jSONArray4);
                i = 1;
                ModsManifestStore modsManifestStore = new ModsManifestStore(null, 1, null);
                String jSONObject3 = put6.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "toString(...)");
                byte[] bytes = jSONObject3.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                file = file9;
                modsManifestStore.publish(file, bytes);
            } else {
                file = file9;
                i = 1;
            }
            if (hashSet4 != null) {
                String[] list = file7.list(new FilenameFilter() { // from class: com.miami.game.core.settings.mods.ModsSynchronizer$$ExternalSyntheticLambda1
                    @Override // java.io.FilenameFilter
                    public final boolean accept(File file10, String str) {
                        boolean synchronize$lambda$0$9;
                        synchronize$lambda$0$9 = ModsSynchronizer.synchronize$lambda$0$9(hashSet4, file10, str);
                        return synchronize$lambda$0$9;
                    }
                });
                if (list == null) {
                    i2 = 0;
                    list = new String[0];
                } else {
                    i2 = 0;
                }
                if ((list.length == 0 ? i : i2) == 0) {
                    if (!z3) {
                        ModsManifestStore.Companion.syncDirectory(file);
                    }
                    int length3 = list.length;
                    for (int i11 = i2; i11 < length3; i11++) {
                        new File(file7, list[i11]).delete();
                    }
                }
                String[] list2 = file.list(new FilenameFilter() { // from class: com.miami.game.core.settings.mods.ModsSynchronizer$$ExternalSyntheticLambda2
                    @Override // java.io.FilenameFilter
                    public final boolean accept(File file10, String str) {
                        boolean synchronize$lambda$0$11;
                        synchronize$lambda$0$11 = ModsSynchronizer.synchronize$lambda$0$11(file10, str);
                        return synchronize$lambda$0$11;
                    }
                });
                if (list2 != null) {
                    int length4 = list2.length;
                    for (int i12 = i2; i12 < length4; i12++) {
                        new File(file, list2[i12]).delete();
                    }
                    Unit unit6 = Unit.INSTANCE;
                }
            }
            configuration = configuration(file);
        }
        Intrinsics.checkNotNullExpressionValue(configuration, "synchronized(...)");
        return configuration;
    }

    static /* synthetic */ void synchronize$lambda$0$report$default(Function1 function1, Ref.LongRef longRef, boolean z, int i, int i2, long j, long j2, int i3, Object obj) {
        long j3;
        Function1 function12;
        Ref.LongRef longRef2;
        boolean z2;
        int i4;
        if ((i3 & 16) != 0) {
            i2 = 0;
        }
        int i5 = i2;
        long j4 = (i3 & 32) != 0 ? 0L : j;
        if ((i3 & 64) != 0) {
            j3 = -1;
            z2 = z;
            i4 = i;
            function12 = function1;
            longRef2 = longRef;
        } else {
            j3 = j2;
            function12 = function1;
            longRef2 = longRef;
            z2 = z;
            i4 = i;
        }
        synchronize$lambda$0$report(function12, longRef2, z2, i4, i5, j4, j3);
    }

    private static final void synchronize$lambda$0$report(Function1<? super Progress, Unit> function1, Ref.LongRef longRef, boolean z, int i, int i2, long j, long j2) {
        if (function1 == null) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - longRef.element < 100) {
            return;
        }
        longRef.element = elapsedRealtime;
        function1.invoke(new Progress(z, Integer.valueOf(i), i2, j, j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit synchronize$lambda$0$4(Function1 function1, Ref.LongRef longRef, int i) {
        if (i > 0) {
            synchronize$lambda$0$report$default(function1, longRef, true, i, 0, 0L, 0L, 112, null);
        }
        return Unit.INSTANCE;
    }

    private static final void synchronize$lambda$0$accept(JSONArray jSONArray, HashSet<String> hashSet, JSONObject jSONObject) {
        jSONArray.put(jSONObject);
        if (hashSet != null) {
            hashSet.add(jSONObject.getString("object"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean synchronize$lambda$0$9(HashSet hashSet, File file, String str) {
        return !hashSet.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean synchronize$lambda$0$11(File file, String str) {
        Intrinsics.checkNotNull(str);
        return (StringsKt.startsWith$default(str, "copy-", false, 2, (Object) null) || StringsKt.startsWith$default(str, "manifest-", false, 2, (Object) null)) && StringsKt.endsWith$default(str, ".tmp", false, 2, (Object) null);
    }

    private final boolean sameMetadata(ModsDocuments.Entry entry, JSONObject jSONObject) {
        if (Intrinsics.areEqual(jSONObject.optString("documentId"), entry.getId())) {
            long optLong = jSONObject.optLong("sourceSize", -1L);
            Long size = entry.getSize();
            if (optLong == (size != null ? size.longValue() : -1L)) {
                long optLong2 = jSONObject.optLong("lastModified", -1L);
                Long modified = entry.getModified();
                return optLong2 == (modified != null ? modified.longValue() : -1L);
            }
            return false;
        }
        return false;
    }

    private final boolean validObject(File file, JSONObject jSONObject) {
        String optString = jSONObject.optString("object");
        Companion companion = Companion;
        Intrinsics.checkNotNull(optString);
        if (companion.isHex(optString, 32)) {
            String optString2 = jSONObject.optString("crc32");
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
            if (companion.isHex(optString2, 8)) {
                try {
                    StructStat lstat = Os.lstat(new File(file, optString).getAbsolutePath());
                    if (OsConstants.S_ISREG(lstat.st_mode) && lstat.st_size == jSONObject.optLong("size", -1L)) {
                        return true;
                    }
                } catch (ErrnoException unused) {
                }
            }
        }
        return false;
    }

    private final void verifySourceUnchanged(ModsDocuments.Entry entry) {
        Cursor query = getResolver().query(entry.getUri(), new String[]{"_size", "last_modified"}, null, null, null);
        try {
            Cursor cursor = query;
            if (cursor == null || !cursor.moveToFirst()) {
                throw new IllegalStateException(("Source disappeared: " + entry.getPath()).toString());
            }
            if (entry.getSize() != null && !cursor.isNull(0)) {
                long j = cursor.getLong(0);
                Long size = entry.getSize();
                if (size == null || j != size.longValue()) {
                    throw new IllegalStateException("Check failed.");
                }
            }
            if (entry.getModified() != null && !cursor.isNull(1)) {
                long j2 = cursor.getLong(1);
                Long modified = entry.getModified();
                if (modified == null || j2 != modified.longValue()) {
                    throw new IllegalStateException("Check failed.");
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(query, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(query, th);
                throw th2;
            }
        }
    }

    private final JSONObject configuration(File file) {
        return new JSONObject().put("enabled", true).put("source", "manifest").put("root", file.getAbsolutePath()).put("manifest", new File(file, "manifest.json").getAbsolutePath());
    }

    /* compiled from: ModsSynchronizer.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0014\u0010\u0007\u001a\u00020\b*\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\f\u0010\u000b\u001a\u00020\u0005*\u00020\fH\u0002J\f\u0010\u000b\u001a\u00020\u0005*\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fH\u0002¨\u0006\u0014"}, d2 = {"Lcom/miami/game/core/settings/mods/ModsSynchronizer$Companion;", "", "<init>", "()V", "normalize", "", "path", "isHex", "", "length", "", "hex", "", "Ljava/util/zip/CRC32;", "crc32", "Lcom/miami/game/core/settings/mods/ModsSynchronizer$Companion$Checksum;", "input", "Ljava/io/InputStream;", "bytes", "Checksum", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:50:0x00b8, code lost:
            throw new java.lang.IllegalArgumentException("Failed requirement.".toString());
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String normalize(String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            String str = path;
            if (str.length() <= 0 || StringsKt.startsWith$default((CharSequence) str, '/', false, 2, (Object) null) || StringsKt.startsWith$default((CharSequence) str, (char) AbstractJsonLexerKt.STRING_ESC, false, 2, (Object) null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            StringBuilder sb = new StringBuilder(path.length());
            int length = path.length();
            if (length >= 0) {
                int i = 0;
                int i2 = 0;
                loop0: while (true) {
                    if (i >= path.length() || path.charAt(i) == '/' || path.charAt(i) == '\\') {
                        int i3 = i - i2;
                        if (i3 > 0 && (i3 != 1 || path.charAt(i2) != '.')) {
                            if (i3 == 2 && path.charAt(i2) == '.' && path.charAt(i2 + 1) == '.') {
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            int i4 = i - 1;
                            if (path.charAt(i4) == '.' || path.charAt(i4) == ' ') {
                                break;
                            }
                            if (sb.length() > 0) {
                                sb.append('/');
                            }
                            while (i2 < i) {
                                char charAt = path.charAt(i2);
                                if (charAt < ' ' || StringsKt.contains$default((CharSequence) ":*?\"<>|", charAt, false, 2, (Object) null)) {
                                    break loop0;
                                }
                                if ('A' <= charAt && charAt < '[') {
                                    charAt = (char) (charAt + ' ');
                                }
                                sb.append(charAt);
                                i2++;
                            }
                        }
                        i2 = i + 1;
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isHex(String str, int i) {
            int i2;
            if (str.length() == i) {
                String str2 = str;
                for (i2 = 0; i2 < str2.length(); i2 = i2 + 1) {
                    char charAt = str2.charAt(i2);
                    i2 = (('0' <= charAt && charAt < ':') || ('a' <= charAt && charAt < 'g')) ? i2 + 1 : 0;
                }
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String hex(byte[] bArr) {
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            for (byte b : bArr) {
                sb.append("0123456789abcdef".charAt((b & 255) >>> 4)).append("0123456789abcdef".charAt(b & Ascii.SI));
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ModsSynchronizer.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/miami/game/core/settings/mods/ModsSynchronizer$Companion$Checksum;", "", "crc32", "", "size", "", "<init>", "(Ljava/lang/String;J)V", "getCrc32", "()Ljava/lang/String;", "getSize", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Checksum {
            private final String crc32;
            private final long size;

            public static /* synthetic */ Checksum copy$default(Checksum checksum, String str, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = checksum.crc32;
                }
                if ((i & 2) != 0) {
                    j = checksum.size;
                }
                return checksum.copy(str, j);
            }

            public final String component1() {
                return this.crc32;
            }

            public final long component2() {
                return this.size;
            }

            public final Checksum copy(String crc32, long j) {
                Intrinsics.checkNotNullParameter(crc32, "crc32");
                return new Checksum(crc32, j);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Checksum) {
                    Checksum checksum = (Checksum) obj;
                    return Intrinsics.areEqual(this.crc32, checksum.crc32) && this.size == checksum.size;
                }
                return false;
            }

            public int hashCode() {
                return (this.crc32.hashCode() * 31) + Long.hashCode(this.size);
            }

            public String toString() {
                String str = this.crc32;
                return "Checksum(crc32=" + str + ", size=" + this.size + ")";
            }

            public Checksum(String crc32, long j) {
                Intrinsics.checkNotNullParameter(crc32, "crc32");
                this.crc32 = crc32;
                this.size = j;
            }

            public final String getCrc32() {
                return this.crc32;
            }

            public final long getSize() {
                return this.size;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String hex(CRC32 crc32) {
            String l = Long.toString(crc32.getValue(), CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(l, "toString(...)");
            return StringsKt.padStart(l, 8, '0');
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Checksum crc32(InputStream inputStream, byte[] bArr) {
            InputStream inputStream2 = inputStream;
            try {
                InputStream inputStream3 = inputStream2;
                CRC32 crc32 = new CRC32();
                long j = 0;
                while (true) {
                    int read = inputStream3.read(bArr);
                    if (read >= 0) {
                        crc32.update(bArr, 0, read);
                        j += read;
                    } else {
                        Checksum checksum = new Checksum(ModsSynchronizer.Companion.hex(crc32), j);
                        CloseableKt.closeFinally(inputStream2, null);
                        return checksum;
                    }
                }
            } finally {
            }
        }
    }
}
