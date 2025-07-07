package com.miami.game.core.local.repository.common;

import android.content.Context;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesFactory;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
/* compiled from: LocalRepository.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ&\u0010\u0013\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u00152\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u0001H\u0015H\u0096@¢\u0006\u0002\u0010\u0018J*\u0010\u0019\u001a\u0004\u0018\u0001H\u0015\"\b\b\u0000\u0010\u0015*\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0002H\u0096@¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u0002H\u0096@¢\u0006\u0002\u0010\u001fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f*\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/miami/game/core/local/repository/common/LocalRepository;", "Lcom/miami/game/core/local/repository/common/IKeyValueRepository;", "", "context", "Landroid/content/Context;", "gson", "Lcom/google/gson/Gson;", "<init>", "(Landroid/content/Context;Lcom/google/gson/Gson;)V", "getContext", "()Landroid/content/Context;", "appDataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "getAppDataStore", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "appDataStore$delegate", "Lkotlin/properties/ReadOnlyProperty;", "dataStorePreferences", "save", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "key", "value", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "", "t", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remove", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "has", "", "local-repository_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public class LocalRepository implements IKeyValueRepository<String> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property2(new PropertyReference2Impl(LocalRepository.class, "appDataStore", "getAppDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};
    private final ReadOnlyProperty appDataStore$delegate;
    private final Context context;
    private final DataStore<Preferences> dataStorePreferences;
    private final Gson gson;

    @Override // com.miami.game.core.local.repository.common.IKeyValueRepository
    public <V> Object get(String str, Type type, Continuation<? super V> continuation) {
        return get$suspendImpl(this, str, type, continuation);
    }

    /* renamed from: has  reason: avoid collision after fix types in other method */
    public Object has2(String str, Continuation<? super Boolean> continuation) {
        return has$suspendImpl(this, str, continuation);
    }

    /* renamed from: remove  reason: avoid collision after fix types in other method */
    public Object remove2(String str, Continuation<? super Unit> continuation) {
        return remove$suspendImpl(this, str, continuation);
    }

    /* renamed from: save  reason: avoid collision after fix types in other method */
    public <V> Object save2(String str, V v, Continuation<? super Unit> continuation) {
        return save$suspendImpl(this, str, v, continuation);
    }

    public LocalRepository(Context context, Gson gson) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.context = context;
        this.gson = gson;
        this.appDataStore$delegate = PreferenceDataStoreDelegateKt.preferencesDataStore$default("prefs", new ReplaceFileCorruptionHandler(new Function1() { // from class: com.miami.game.core.local.repository.common.LocalRepository$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Preferences appDataStore_delegate$lambda$0;
                appDataStore_delegate$lambda$0 = LocalRepository.appDataStore_delegate$lambda$0((CorruptionException) obj);
                return appDataStore_delegate$lambda$0;
            }
        }), null, null, 12, null);
        this.dataStorePreferences = getAppDataStore(context);
    }

    @Override // com.miami.game.core.local.repository.common.IKeyValueRepository
    public /* bridge */ /* synthetic */ Object has(String str, Continuation continuation) {
        return has2(str, (Continuation<? super Boolean>) continuation);
    }

    @Override // com.miami.game.core.local.repository.common.IKeyValueRepository
    public /* bridge */ /* synthetic */ Object remove(String str, Continuation continuation) {
        return remove2(str, (Continuation<? super Unit>) continuation);
    }

    @Override // com.miami.game.core.local.repository.common.IKeyValueRepository
    public /* bridge */ /* synthetic */ Object save(String str, Object obj, Continuation continuation) {
        return save2(str, (String) obj, (Continuation<? super Unit>) continuation);
    }

    public final Context getContext() {
        return this.context;
    }

    public final DataStore<Preferences> getAppDataStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (DataStore) this.appDataStore$delegate.getValue(context, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Preferences appDataStore_delegate$lambda$0(CorruptionException it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return PreferencesFactory.createEmpty();
    }

    static /* synthetic */ <V> Object save$suspendImpl(LocalRepository localRepository, String str, V v, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new LocalRepository$save$2(localRepository, v, str, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    static /* synthetic */ <V> Object get$suspendImpl(LocalRepository localRepository, String str, Type type, Continuation<? super V> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new LocalRepository$get$2(localRepository, str, type, null), continuation);
    }

    static /* synthetic */ Object remove$suspendImpl(LocalRepository localRepository, String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new LocalRepository$remove$2(localRepository, str, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    static /* synthetic */ Object has$suspendImpl(LocalRepository localRepository, String str, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new LocalRepository$has$2(localRepository, str, null), continuation);
    }
}
