package com.arizona.launcher.downloader;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: FilesChek.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ0\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017JB\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a0\u00192\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u001fJ2\u0010 \u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010!\u001a\u00020\u00172\b\b\u0002\u0010\u0015\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\"JL\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030$2\u0006\u0010%\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0011J0\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0011J\u0016\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.2\u0006\u0010(\u001a\u00020)J\f\u0010/\u001a\u00020\u0003*\u000200H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/arizona/launcher/downloader/FilesChek;", "", "TAG", "", "updatePreferences", "Landroid/content/SharedPreferences;", "contentResolver", "Landroid/content/ContentResolver;", "context", "Landroid/content/Context;", "<init>", "(Ljava/lang/String;Landroid/content/SharedPreferences;Landroid/content/ContentResolver;Landroid/content/Context;)V", "excludeFromCheck", "", "localManifestStore", "Lcom/arizona/launcher/downloader/LocalManifestStore;", "isAllFilesOk", "", "checkHash", "purgeExtraFiles", "forceFileEditDate", "useManifest", "mDataInfo", "Lorg/json/JSONArray;", "getFilesToDownload", "", "Lkotlin/Pair;", "", "sources", "dir", "destDir", "(Lorg/json/JSONArray;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkGameDataUpdate", "dataInfo", "(Lorg/json/JSONArray;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllDamagedFiles", "", "fileSourceJson", "addExtraFilesToPurgeList", "checkSingleFile", "file", "Ljava/io/File;", "fileJson", "Lorg/json/JSONObject;", "getFileChecksum", "digest", "Ljava/security/MessageDigest;", "toHex", "", "app_arizonaRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FilesChek {
    public static final int $stable = 8;
    private final String TAG;
    private final ContentResolver contentResolver;
    private final Context context;
    private final List<String> excludeFromCheck;
    private final LocalManifestStore localManifestStore;
    private final SharedPreferences updatePreferences;

    public FilesChek(String TAG, SharedPreferences updatePreferences, ContentResolver contentResolver, Context context) {
        Intrinsics.checkNotNullParameter(TAG, "TAG");
        Intrinsics.checkNotNullParameter(updatePreferences, "updatePreferences");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = TAG;
        this.updatePreferences = updatePreferences;
        this.contentResolver = contentResolver;
        this.context = context;
        this.excludeFromCheck = CollectionsKt.listOf("settings.json");
        File externalFilesDir = context.getExternalFilesDir(null);
        this.localManifestStore = new LocalManifestStore(new File((externalFilesDir != null ? externalFilesDir.getPath() : null) + "/local_manifest.json"), null, 2, null);
    }

    public static /* synthetic */ boolean isAllFilesOk$default(FilesChek filesChek, boolean z, boolean z2, boolean z3, boolean z4, JSONArray jSONArray, int i, Object obj) {
        if ((i & 8) != 0) {
            z4 = false;
        }
        return filesChek.isAllFilesOk(z, z2, z3, z4, jSONArray);
    }

    public final boolean isAllFilesOk(boolean z, boolean z2, boolean z3, boolean z4, JSONArray mDataInfo) {
        Object runBlocking$default;
        Intrinsics.checkNotNullParameter(mDataInfo, "mDataInfo");
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new FilesChek$isAllFilesOk$1(this, mDataInfo, z, z2, z3, z4, null), 1, null);
        return ((Boolean) runBlocking$default).booleanValue();
    }

    public static /* synthetic */ Object getFilesToDownload$default(FilesChek filesChek, JSONArray jSONArray, String str, String str2, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return filesChek.getFilesToDownload(jSONArray, str, str2, z, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getFilesToDownload(JSONArray jSONArray, String str, String str2, boolean z, Continuation<? super List<Pair<String, Long>>> continuation) {
        FilesChek$getFilesToDownload$1 filesChek$getFilesToDownload$1;
        int i;
        if (continuation instanceof FilesChek$getFilesToDownload$1) {
            filesChek$getFilesToDownload$1 = (FilesChek$getFilesToDownload$1) continuation;
            if ((filesChek$getFilesToDownload$1.label & Integer.MIN_VALUE) != 0) {
                filesChek$getFilesToDownload$1.label -= Integer.MIN_VALUE;
                Object obj = filesChek$getFilesToDownload$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = filesChek$getFilesToDownload$1.label;
                if (i == 0) {
                    if (i == 1) {
                        boolean z2 = filesChek$getFilesToDownload$1.Z$0;
                        List list = (List) filesChek$getFilesToDownload$1.L$3;
                        String str3 = (String) filesChek$getFilesToDownload$1.L$2;
                        String str4 = (String) filesChek$getFilesToDownload$1.L$1;
                        JSONArray jSONArray2 = (JSONArray) filesChek$getFilesToDownload$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        return list;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ArrayList arrayList = new ArrayList();
                filesChek$getFilesToDownload$1.L$0 = SpillingKt.nullOutSpilledVariable(jSONArray);
                filesChek$getFilesToDownload$1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                filesChek$getFilesToDownload$1.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                filesChek$getFilesToDownload$1.L$3 = arrayList;
                filesChek$getFilesToDownload$1.Z$0 = z;
                filesChek$getFilesToDownload$1.label = 1;
                return BuildersKt.withContext(Dispatchers.getIO(), new FilesChek$getFilesToDownload$2(jSONArray, this, str, str2, z, arrayList, null), filesChek$getFilesToDownload$1) == coroutine_suspended ? coroutine_suspended : arrayList;
            }
        }
        filesChek$getFilesToDownload$1 = new FilesChek$getFilesToDownload$1(this, continuation);
        Object obj2 = filesChek$getFilesToDownload$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = filesChek$getFilesToDownload$1.label;
        if (i == 0) {
        }
    }

    public static /* synthetic */ Object checkGameDataUpdate$default(FilesChek filesChek, JSONArray jSONArray, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return filesChek.checkGameDataUpdate(jSONArray, z, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkGameDataUpdate(JSONArray jSONArray, boolean z, Continuation<? super Pair<? extends List<String>, Long>> continuation) {
        FilesChek$checkGameDataUpdate$1 filesChek$checkGameDataUpdate$1;
        int i;
        List list;
        if (continuation instanceof FilesChek$checkGameDataUpdate$1) {
            filesChek$checkGameDataUpdate$1 = (FilesChek$checkGameDataUpdate$1) continuation;
            if ((filesChek$checkGameDataUpdate$1.label & Integer.MIN_VALUE) != 0) {
                filesChek$checkGameDataUpdate$1.label -= Integer.MIN_VALUE;
                FilesChek$checkGameDataUpdate$1 filesChek$checkGameDataUpdate$12 = filesChek$checkGameDataUpdate$1;
                Object obj = filesChek$checkGameDataUpdate$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = filesChek$checkGameDataUpdate$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Log.i(this.TAG, "UpdateService checkGameDataUpdate");
                    filesChek$checkGameDataUpdate$12.L$0 = SpillingKt.nullOutSpilledVariable(jSONArray);
                    filesChek$checkGameDataUpdate$12.Z$0 = z;
                    filesChek$checkGameDataUpdate$12.label = 1;
                    obj = getFilesToDownload$default(this, jSONArray, "", "", false, filesChek$checkGameDataUpdate$12, 8, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    boolean z2 = filesChek$checkGameDataUpdate$12.Z$0;
                    JSONArray jSONArray2 = (JSONArray) filesChek$checkGameDataUpdate$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                long j = 0;
                Pair pair = new Pair(new ArrayList(), Boxing.boxLong(0L));
                for (Pair pair2 : (List) obj) {
                    if (!this.excludeFromCheck.contains(CollectionsKt.last((List<? extends Object>) StringsKt.split$default((CharSequence) pair2.getFirst(), new String[]{"/"}, false, 0, 6, (Object) null)))) {
                        ((List) pair.getFirst()).add(pair2.getFirst());
                        j += ((Number) pair2.getSecond()).longValue();
                    }
                }
                Pair copy$default = Pair.copy$default(pair, null, Boxing.boxLong(j), 1, null);
                Log.d(this.TAG, "need download data (" + list.size() + ")) sum " + j);
                return copy$default;
            }
        }
        filesChek$checkGameDataUpdate$1 = new FilesChek$checkGameDataUpdate$1(this, continuation);
        FilesChek$checkGameDataUpdate$1 filesChek$checkGameDataUpdate$122 = filesChek$checkGameDataUpdate$1;
        Object obj2 = filesChek$checkGameDataUpdate$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = filesChek$checkGameDataUpdate$122.label;
        if (i != 0) {
        }
        long j2 = 0;
        Pair pair3 = new Pair(new ArrayList(), Boxing.boxLong(0L));
        while (r3.hasNext()) {
        }
        Pair copy$default2 = Pair.copy$default(pair3, null, Boxing.boxLong(j2), 1, null);
        Log.d(this.TAG, "need download data (" + list.size() + ")) sum " + j2);
        return copy$default2;
    }

    public static /* synthetic */ Map getAllDamagedFiles$default(FilesChek filesChek, JSONArray jSONArray, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        return filesChek.getAllDamagedFiles(jSONArray, str, str2, z, z2, z3, (i & 64) != 0 ? false : z4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x006d, code lost:
        if (r1 != null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<String, String> getAllDamagedFiles(JSONArray jSONArray, String dir, String str, boolean z, boolean z2, boolean z3, boolean z4) {
        File externalFilesDir;
        ArrayList arrayList;
        LinkedHashMap linkedHashMap;
        String str2;
        int i;
        int i2;
        Object obj;
        File externalFilesDir2;
        FilesChek filesChek = this;
        JSONArray fileSourceJson = jSONArray;
        String destDir = str;
        Intrinsics.checkNotNullParameter(fileSourceJson, "fileSourceJson");
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(destDir, "destDir");
        File[] listFiles = new File((filesChek.context.getExternalFilesDir(null) != null ? externalFilesDir.getPath() : null) + destDir + "/" + dir).listFiles();
        int i3 = 0;
        if (listFiles != null) {
            ArrayList arrayList2 = new ArrayList(listFiles.length);
            for (File file : listFiles) {
                arrayList2.add(file.getName());
            }
            arrayList = CollectionsKt.toMutableList((Collection) arrayList2);
        }
        arrayList = new ArrayList();
        List list = arrayList;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        int length = fileSourceJson.length();
        while (i3 < length) {
            int i4 = i3;
            JSONObject jSONObject = fileSourceJson.getJSONObject(i4);
            if (Intrinsics.areEqual(jSONObject.getString("type"), "dir")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("data");
                String string = jSONObject.getString("name");
                Intrinsics.checkNotNull(jSONArray2);
                linkedHashMap = linkedHashMap2;
                i2 = i4;
                i = length;
                str2 = destDir;
                linkedHashMap.putAll(getAllDamagedFiles$default(filesChek, jSONArray2, dir + "/" + string, destDir, z, z2, z3, false, 64, null));
                list.remove(string);
                obj = null;
            } else {
                linkedHashMap = linkedHashMap2;
                str2 = destDir;
                i = length;
                i2 = i4;
                if (Intrinsics.areEqual(jSONObject.getString("type"), "file")) {
                    String string2 = jSONObject.getString("name");
                    obj = null;
                    File file2 = new File((filesChek.context.getExternalFilesDir(null) != null ? externalFilesDir2.getPath() : null) + str2 + dir + "/" + string2);
                    String string3 = jSONObject.getString("hash");
                    list.remove(string2);
                    if (!filesChek.excludeFromCheck.contains(file2.getName())) {
                        Intrinsics.checkNotNull(jSONObject);
                        if (!filesChek.checkSingleFile(file2, jSONObject, z, z3, z4)) {
                            linkedHashMap.put(str2 + dir + "/" + string2, string3);
                        }
                    }
                } else {
                    obj = null;
                    if (Intrinsics.areEqual(jSONObject.getString("type"), "res") && z2) {
                        linkedHashMap.put(str2 + dir + "/" + jSONObject.getString("name"), jSONObject.getString("hash"));
                    }
                }
            }
            i3 = i2 + 1;
            filesChek = this;
            fileSourceJson = jSONArray;
            destDir = str2;
            linkedHashMap2 = linkedHashMap;
            length = i;
        }
        LinkedHashMap linkedHashMap3 = linkedHashMap2;
        String str3 = destDir;
        if (z2) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                linkedHashMap3.put(str3 + dir + "/" + ((String) it.next()), "");
            }
        }
        return linkedHashMap3;
    }

    public static /* synthetic */ boolean checkSingleFile$default(FilesChek filesChek, File file, JSONObject jSONObject, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 16) != 0) {
            z3 = false;
        }
        return filesChek.checkSingleFile(file, jSONObject, z, z2, z3);
    }

    public final boolean checkSingleFile(File file, JSONObject fileJson, boolean z, boolean z2, boolean z3) {
        FileHashEntry fileHashEntry;
        boolean z4;
        boolean z5;
        long j;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(fileJson, "fileJson");
        long length = file.getAbsoluteFile().length();
        String name = file.getName();
        long j2 = fileJson.getLong("size");
        String string = fileJson.getString("hash");
        long j3 = fileJson.getLong("date_change") * 1000;
        LocalManifestStore localManifestStore = this.localManifestStore;
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        FileHashEntry fileHashEntry2 = localManifestStore.get(path);
        if (z2) {
            this.updatePreferences.edit().putLong(file.getAbsolutePath(), j3).apply();
        }
        if (j2 == 0) {
            try {
                Log.d(this.TAG, "checkSingleFile: created new empty file " + name);
                file.createNewFile();
                this.updatePreferences.edit().putLong(file.getAbsolutePath(), j3).apply();
            } catch (IOException unused) {
                Log.d(this.TAG, "checkSingleFile: cannot create " + file);
            }
            return true;
        }
        long j4 = this.updatePreferences.getLong(file.getAbsolutePath(), 0L);
        boolean z6 = j4 != j3;
        if (!file.exists() || length != j2) {
            Log.v(this.TAG, name + " exists: " + file.exists() + ", device size: " + length + ", expected size " + j2);
            return false;
        }
        if (z6) {
            z4 = false;
            fileHashEntry = fileHashEntry2;
            Log.v(this.TAG, name + " date mismatch, current: " + j4 + ", expected: " + j3 + " ");
        } else {
            fileHashEntry = fileHashEntry2;
            z4 = false;
        }
        if (z || fileHashEntry == null || !z3) {
            z5 = z6;
            j = length;
        } else {
            z5 = z6;
            j = length;
            Log.v(this.TAG, "LocalManifest Hash of: " + file + " is: " + fileHashEntry.getMd5() + ", expected: " + string);
            if (!Intrinsics.areEqual(fileHashEntry.getMd5(), string)) {
                return z4;
            }
        }
        if (z || z5) {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            Intrinsics.checkNotNull(messageDigest);
            String fileChecksum = getFileChecksum(messageDigest, file);
            Log.v(this.TAG, "Hash of: " + file + " is: " + fileChecksum + ", expected: " + string);
            boolean areEqual = Intrinsics.areEqual(fileChecksum, string);
            if (areEqual && z5) {
                this.updatePreferences.edit().putLong(file.getAbsolutePath(), j3).apply();
                Log.d(this.TAG, "Force date update after hash check, new file date: " + j4 + "}");
            }
            if (areEqual) {
                Log.v(this.TAG, name + " - good, after hash check");
                LocalManifestStore localManifestStore2 = this.localManifestStore;
                String path2 = file.getPath();
                Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
                LocalManifestStore.put$default(localManifestStore2, path2, new FileHashEntry(fileChecksum, Long.valueOf(j), Long.valueOf(j4)), false, 4, null);
                return areEqual;
            }
            Log.v(this.TAG, name + " - bad, after hash check");
            return areEqual;
        }
        Log.v(this.TAG, name + " - good");
        LocalManifestStore localManifestStore3 = this.localManifestStore;
        String path3 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path3, "getPath(...)");
        Intrinsics.checkNotNull(string);
        LocalManifestStore.put$default(localManifestStore3, path3, new FileHashEntry(string, Long.valueOf(j), Long.valueOf(j4)), false, 4, null);
        return true;
    }

    public final String getFileChecksum(MessageDigest digest, File file) throws IOException {
        Intrinsics.checkNotNullParameter(digest, "digest");
        Intrinsics.checkNotNullParameter(file, "file");
        try {
            InputStream openInputStream = this.contentResolver.openInputStream(Uri.fromFile(file));
            if (openInputStream != null) {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = openInputStream.read(bArr);
                    if (read != -1) {
                        digest.update(bArr, 0, read);
                    } else {
                        openInputStream.close();
                        byte[] digest2 = digest.digest();
                        Intrinsics.checkNotNullExpressionValue(digest2, "digest(...)");
                        return toHex(digest2);
                    }
                }
            } else {
                return "";
            }
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
            return "";
        }
    }

    private final String toHex(byte[] bArr) {
        return ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.arizona.launcher.downloader.FilesChek$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence hex$lambda$0;
                hex$lambda$0 = FilesChek.toHex$lambda$0(((Byte) obj).byteValue());
                return hex$lambda$0;
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toHex$lambda$0(byte b) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
