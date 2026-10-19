package com.miami.game.core.settings.mods;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: ModsDocuments.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000f\u001a\n \n*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015J$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n \n*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/miami/game/core/settings/mods/ModsDocuments;", "", "context", "Landroid/content/Context;", "tree", "Landroid/net/Uri;", "<init>", "(Landroid/content/Context;Landroid/net/Uri;)V", "resolver", "Landroid/content/ContentResolver;", "kotlin.jvm.PlatformType", "getResolver", "()Landroid/content/ContentResolver;", "rootId", "", "uri", TtmlNode.ATTR_ID, "inventory", "", "Lcom/miami/game/core/settings/mods/ModsDocuments$Entry;", "progress", "Lkotlin/Function1;", "", "", "createStarterIfEmpty", "requireComplete", "cursor", "Landroid/database/Cursor;", "Entry", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModsDocuments {
    private final Context context;
    private final String rootId;
    private final Uri tree;

    /* compiled from: ModsDocuments.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016JN\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020$HÖ\u0081\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016¨\u0006&"}, d2 = {"Lcom/miami/game/core/settings/mods/ModsDocuments$Entry;", "", "path", "", TtmlNode.ATTR_ID, "uri", "Landroid/net/Uri;", "directory", "", "size", "", "modified", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;ZLjava/lang/Long;Ljava/lang/Long;)V", "getPath", "()Ljava/lang/String;", "getId", "getUri", "()Landroid/net/Uri;", "getDirectory", "()Z", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getModified", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;ZLjava/lang/Long;Ljava/lang/Long;)Lcom/miami/game/core/settings/mods/ModsDocuments$Entry;", "equals", "other", "hashCode", "", "toString", "settings"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Entry {
        private final boolean directory;
        private final String id;
        private final Long modified;
        private final String path;
        private final Long size;
        private final Uri uri;

        public static /* synthetic */ Entry copy$default(Entry entry, String str, String str2, Uri uri, boolean z, Long l, Long l2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = entry.path;
            }
            if ((i & 2) != 0) {
                str2 = entry.id;
            }
            if ((i & 4) != 0) {
                uri = entry.uri;
            }
            if ((i & 8) != 0) {
                z = entry.directory;
            }
            if ((i & 16) != 0) {
                l = entry.size;
            }
            if ((i & 32) != 0) {
                l2 = entry.modified;
            }
            Long l3 = l;
            Long l4 = l2;
            return entry.copy(str, str2, uri, z, l3, l4);
        }

        public final String component1() {
            return this.path;
        }

        public final String component2() {
            return this.id;
        }

        public final Uri component3() {
            return this.uri;
        }

        public final boolean component4() {
            return this.directory;
        }

        public final Long component5() {
            return this.size;
        }

        public final Long component6() {
            return this.modified;
        }

        public final Entry copy(String path, String id, Uri uri, boolean z, Long l, Long l2) {
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(uri, "uri");
            return new Entry(path, id, uri, z, l, l2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Entry) {
                Entry entry = (Entry) obj;
                return Intrinsics.areEqual(this.path, entry.path) && Intrinsics.areEqual(this.id, entry.id) && Intrinsics.areEqual(this.uri, entry.uri) && this.directory == entry.directory && Intrinsics.areEqual(this.size, entry.size) && Intrinsics.areEqual(this.modified, entry.modified);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((((this.path.hashCode() * 31) + this.id.hashCode()) * 31) + this.uri.hashCode()) * 31) + Boolean.hashCode(this.directory)) * 31;
            Long l = this.size;
            int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.modified;
            return hashCode2 + (l2 != null ? l2.hashCode() : 0);
        }

        public String toString() {
            String str = this.path;
            String str2 = this.id;
            Uri uri = this.uri;
            boolean z = this.directory;
            Long l = this.size;
            return "Entry(path=" + str + ", id=" + str2 + ", uri=" + uri + ", directory=" + z + ", size=" + l + ", modified=" + this.modified + ")";
        }

        public Entry(String path, String id, Uri uri, boolean z, Long l, Long l2) {
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.path = path;
            this.id = id;
            this.uri = uri;
            this.directory = z;
            this.size = l;
            this.modified = l2;
        }

        public final boolean getDirectory() {
            return this.directory;
        }

        public final String getId() {
            return this.id;
        }

        public final String getPath() {
            return this.path;
        }

        public final Uri getUri() {
            return this.uri;
        }

        public final Long getModified() {
            return this.modified;
        }

        public final Long getSize() {
            return this.size;
        }
    }

    public ModsDocuments(Context context, Uri tree) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tree, "tree");
        this.context = context;
        this.tree = tree;
        this.rootId = DocumentsContract.getTreeDocumentId(tree);
    }

    private final ContentResolver getResolver() {
        return this.context.getContentResolver();
    }

    private final Uri uri(String str) {
        return DocumentsContract.buildDocumentUriUsingTree(this.tree, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List inventory$default(ModsDocuments modsDocuments, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return modsDocuments.inventory(function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0120 A[Catch: all -> 0x01bd, TryCatch #1 {all -> 0x01bd, blocks: (B:8:0x007a, B:10:0x007f, B:11:0x0082, B:13:0x0089, B:15:0x00a2, B:17:0x00ad, B:19:0x00ca, B:30:0x0117, B:36:0x0136, B:38:0x014c, B:39:0x0167, B:33:0x0120, B:23:0x00f1, B:27:0x010a, B:41:0x016f, B:42:0x018c, B:43:0x018d, B:44:0x0198, B:45:0x0199, B:50:0x01b1, B:51:0x01bc), top: B:64:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x014c A[Catch: all -> 0x01bd, TryCatch #1 {all -> 0x01bd, blocks: (B:8:0x007a, B:10:0x007f, B:11:0x0082, B:13:0x0089, B:15:0x00a2, B:17:0x00ad, B:19:0x00ca, B:30:0x0117, B:36:0x0136, B:38:0x014c, B:39:0x0167, B:33:0x0120, B:23:0x00f1, B:27:0x010a, B:41:0x016f, B:42:0x018c, B:43:0x018d, B:44:0x0198, B:45:0x0199, B:50:0x01b1, B:51:0x01bc), top: B:64:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0167 A[Catch: all -> 0x01bd, TryCatch #1 {all -> 0x01bd, blocks: (B:8:0x007a, B:10:0x007f, B:11:0x0082, B:13:0x0089, B:15:0x00a2, B:17:0x00ad, B:19:0x00ca, B:30:0x0117, B:36:0x0136, B:38:0x014c, B:39:0x0167, B:33:0x0120, B:23:0x00f1, B:27:0x010a, B:41:0x016f, B:42:0x018c, B:43:0x018d, B:44:0x0198, B:45:0x0199, B:50:0x01b1, B:51:0x01bc), top: B:64:0x007a }] */
    /* JADX WARN: Type inference failed for: r6v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<Entry> inventory(Function1<? super Integer, Unit> function1) {
        Long l;
        Long l2;
        ArrayList arrayList = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(TuplesKt.to(this.rootId, ""));
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        boolean z = false;
        int i = 0;
        while (!arrayDeque.isEmpty()) {
            Pair pair = (Pair) arrayDeque.removeFirst();
            String str = (String) pair.component1();
            String str2 = (String) pair.component2();
            if (!hashSet.add(str)) {
                throw new IllegalStateException("Cyclic document tree".toString());
            }
            ContentResolver resolver = getResolver();
            Uri buildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(this.tree, str);
            String[] strArr = new String[5];
            strArr[z ? 1 : 0] = "document_id";
            strArr[1] = "_display_name";
            strArr[2] = "mime_type";
            strArr[3] = "_size";
            strArr[4] = "last_modified";
            Cursor query = resolver.query(buildChildDocumentsUriUsingTree, strArr, null, null, null);
            try {
                Cursor cursor = query;
                if (cursor == null) {
                    throw new IllegalStateException("Cannot list mod directory".toString());
                }
                requireComplete(cursor);
                ?? r6 = z;
                while (cursor.moveToNext()) {
                    String string = cursor.getString(r6);
                    String string2 = cursor.getString(1);
                    Intrinsics.checkNotNull(string2);
                    ArrayList arrayList2 = arrayList;
                    if (StringsKt.contains$default((CharSequence) string2, '/', (boolean) r6, 2, (Object) null) || StringsKt.contains$default(string2, (char) AbstractJsonLexerKt.STRING_ESC, (boolean) r6, 2, (Object) null)) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    String normalize = ModsSynchronizer.Companion.normalize(str2 + string2);
                    if (!hashSet2.add(normalize)) {
                        throw new IllegalStateException(("Duplicate mod path: " + normalize).toString());
                    }
                    boolean areEqual = Intrinsics.areEqual(cursor.getString(2), "vnd.android.document/directory");
                    ArrayList arrayList3 = arrayList2;
                    Intrinsics.checkNotNull(string);
                    Uri uri = uri(string);
                    Intrinsics.checkNotNullExpressionValue(uri, "uri(...)");
                    if (!cursor.isNull(3)) {
                        Long valueOf = Long.valueOf(cursor.getLong(3));
                        if (Boolean.valueOf(valueOf.longValue() >= 0).booleanValue()) {
                            l = valueOf;
                            if (!cursor.isNull(4)) {
                                Long valueOf2 = Long.valueOf(cursor.getLong(4));
                                if (valueOf2.longValue() > 0) {
                                    l2 = valueOf2;
                                    arrayList3.add(new Entry(normalize, string, uri, areEqual, l, l2));
                                    if (areEqual) {
                                        arrayDeque.add(TuplesKt.to(string, normalize + "/"));
                                    } else {
                                        i++;
                                    }
                                    arrayList = arrayList2;
                                    r6 = 0;
                                }
                            }
                            l2 = null;
                            arrayList3.add(new Entry(normalize, string, uri, areEqual, l, l2));
                            if (areEqual) {
                            }
                            arrayList = arrayList2;
                            r6 = 0;
                        }
                    }
                    l = null;
                    if (!cursor.isNull(4)) {
                    }
                    l2 = null;
                    arrayList3.add(new Entry(normalize, string, uri, areEqual, l, l2));
                    if (areEqual) {
                    }
                    arrayList = arrayList2;
                    r6 = 0;
                }
                ArrayList arrayList4 = arrayList;
                requireComplete(cursor);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(query, null);
                if (function1 != null) {
                    function1.invoke(Integer.valueOf(i));
                }
                arrayList = arrayList4;
                z = false;
            } finally {
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List createStarterIfEmpty$default(ModsDocuments modsDocuments, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return modsDocuments.createStarterIfEmpty(function1);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<Entry> createStarterIfEmpty(Function1<? super Integer, Unit> function1) {
        List<Entry> inventory = inventory(function1);
        List<Entry> list = inventory;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (Entry entry : list) {
                if (!entry.getDirectory() || !ModsPolicy.INSTANCE.getStarterDirectories().contains(entry.getPath())) {
                    return inventory;
                }
                while (r1.hasNext()) {
                }
            }
        }
        String rootId = this.rootId;
        Intrinsics.checkNotNullExpressionValue(rootId, "rootId");
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.to("", uri(rootId)));
        for (Entry entry2 : list) {
            hashMapOf.put(entry2.getPath(), entry2.getUri());
        }
        for (String str : ModsPolicy.INSTANCE.getStarterDirectories()) {
            HashMap hashMap = hashMapOf;
            if (!hashMap.containsKey(str)) {
                Uri createDocument = DocumentsContract.createDocument(getResolver(), (Uri) MapsKt.getValue(hashMap, StringsKt.substringBeforeLast(str, '/', "")), "vnd.android.document/directory", StringsKt.substringAfterLast$default(str, '/', (String) null, 2, (Object) null));
                if (createDocument == null) {
                    throw new IllegalStateException("Cannot create mod directory".toString());
                }
                hashMap.put(str, createDocument);
            }
        }
        return CollectionsKt.emptyList();
    }

    private final void requireComplete(Cursor cursor) {
        Bundle extras = cursor.getExtras();
        if (extras.getBoolean("loading", false)) {
            throw new IllegalStateException("Mod directory is still loading".toString());
        }
        if (extras.getString("error") != null) {
            throw new IllegalStateException("Cannot list mod directory: provider error".toString());
        }
    }
}
