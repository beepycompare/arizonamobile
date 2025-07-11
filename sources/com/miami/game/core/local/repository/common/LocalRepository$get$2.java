package com.miami.game.core.local.repository.common;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: LocalRepository.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.local.repository.common.LocalRepository$get$2", f = "LocalRepository.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class LocalRepository$get$2<V> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super V>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ Type $t;
    int label;
    final /* synthetic */ LocalRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalRepository$get$2(LocalRepository localRepository, String str, Type type, Continuation<? super LocalRepository$get$2> continuation) {
        super(2, continuation);
        this.this$0 = localRepository;
        this.$key = str;
        this.$t = type;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalRepository$get$2(this.this$0, this.$key, this.$t, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object obj) {
        return invoke(coroutineScope, (Continuation) ((Continuation) obj));
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super V> continuation) {
        return ((LocalRepository$get$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DataStore dataStore;
        Gson gson;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                dataStore = this.this$0.dataStorePreferences;
                this.label = 1;
                obj = FlowKt.firstOrNull(dataStore.getData(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            Preferences preferences = (Preferences) obj;
            String str = preferences != null ? (String) preferences.get(PreferencesKeys.stringKey(this.$key)) : null;
            gson = this.this$0.gson;
            return gson.fromJson(str, this.$t);
        } catch (Exception unused) {
            return null;
        }
    }
}
